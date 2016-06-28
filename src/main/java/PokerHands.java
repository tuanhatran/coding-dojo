import java.util.Optional;

class PokerHands {
    private final CardUtilities cardUtilities;

    PokerHands(CardUtilities cardUtilities) {
        this.cardUtilities = cardUtilities;
    }

    public Result whoWin(final Player player1, final Player player2) {
        final Result result;
        final HandType firstPlayerHandType = cardUtilities.highestHandTypeFrom(player1.getHand());
        final HandType secondPlayerHandType = cardUtilities.highestHandTypeFrom(player2.getHand());
        if (winableByHandType(firstPlayerHandType, secondPlayerHandType)) {
            result = whoWinByHandType(player1, firstPlayerHandType, player2, secondPlayerHandType);
        } else {
            result = whoWinByHigherCard(player1, player2);

        }
        return result;
    }

    private Result whoWinByHandType(final Player player1,
                                    final HandType firstPlayerHandType,
                                    final Player player2,
                                    final HandType secondPlayerHandType) {
        final Result result;
        if (firstPlayerHandType.ordinal() > secondPlayerHandType.ordinal()) {
            result = new Result(player1, firstPlayerHandType, Optional.empty());
        } else {
            result = new Result(player2, secondPlayerHandType, Optional.empty());
        }
        return result;
    }

    private Result whoWinByHigherCard(final Player player1, final Player player2) {
        final Result result;
        final Card firstPlayerHighestCard = cardUtilities.highestCardFrom(player1.getHand());
        final Card secondPlayerHighestCard = cardUtilities.highestCardFrom(player2.getHand());
        if (firstPlayerHighestCard.getRank().ordinal() > secondPlayerHighestCard.getRank().ordinal()) {
            result = new Result(player1, HandType.HIGH_CARD, Optional.of(firstPlayerHighestCard));
        } else {
            result = new Result(player2, HandType.HIGH_CARD, Optional.of(secondPlayerHighestCard));
        }
        return result;
    }

    private boolean winableByHandType(final HandType firstHandType, final HandType secondHandType) {
        return firstHandType != secondHandType;
    }
}
