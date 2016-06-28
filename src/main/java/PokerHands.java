import java.util.Optional;

class PokerHands {
    private final CardUtilities cardUtilities;

    PokerHands(CardUtilities cardUtilities) {
        this.cardUtilities = cardUtilities;
    }

    public Result whoWin(final Player player1, final Player player2) {
        final Card firstPlayerHighestCard = cardUtilities.getHighestCard(player1.getHand());
        final Card secondPlayerHighestCard = cardUtilities.getHighestCard(player2.getHand());

        if (firstPlayerHighestCard.getRank().ordinal() > secondPlayerHighestCard.getRank().ordinal()) {
            return new Result(player1, HandType.HIGH_CARD, Optional.of(firstPlayerHighestCard));
        } else {
            return new Result(player2, HandType.HIGH_CARD, Optional.of(secondPlayerHighestCard));
        }
    }
}
