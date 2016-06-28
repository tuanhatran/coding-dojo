import java.util.Optional;

class PokerHands {
    private final CardUtilities cardUtilities;

    PokerHands(CardUtilities cardUtilities) {
        this.cardUtilities = cardUtilities;
    }

    public Result whoWin(final Player player1, final Player player2) {
        final HandType firstPlayerHandType = cardUtilities.highestHandTypeFrom(player1.getHand());
        final HandType secondPlayerHandType = cardUtilities.highestHandTypeFrom(player2.getHand());
        if (firstPlayerHandType.ordinal() > secondPlayerHandType.ordinal()) {
            return new Result(player1, firstPlayerHandType, Optional.empty());
        } else if (secondPlayerHandType.ordinal() > firstPlayerHandType.ordinal()) {
            return new Result(player2, secondPlayerHandType, Optional.empty());
        } else {
            final Card firstPlayerHighestCard = cardUtilities.highestCardFrom(player1.getHand());
            final Card secondPlayerHighestCard = cardUtilities.highestCardFrom(player2.getHand());

            if (firstPlayerHighestCard.getRank().ordinal() > secondPlayerHighestCard.getRank().ordinal()) {
                return new Result(player1, HandType.HIGH_CARD, Optional.of(firstPlayerHighestCard));
            } else {
                return new Result(player2, HandType.HIGH_CARD, Optional.of(secondPlayerHighestCard));
            }
        }
    }
}
