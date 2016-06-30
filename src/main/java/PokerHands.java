import java.util.Optional;

class PokerHands {
    private final CardRules cardRules;

    PokerHands(CardRules cardRules) {
        this.cardRules = cardRules;
    }

    Result play(final Player player1, final Player player2) {
        final Result result;
        final HandType firstPlayerHandType = cardRules.highestHandTypeFrom(player1.getHand());
        final HandType secondPlayerHandType = cardRules.highestHandTypeFrom(player2.getHand());
        if (winableByHandType(firstPlayerHandType, secondPlayerHandType)) {
            result = determineWinnerByHandType(player1, firstPlayerHandType, player2, secondPlayerHandType);
        } else {
            result = determineWinnerByHighestCard(player1, player2);

        }
        return result;
    }

    private Result determineWinnerByHandType(final Player player1,
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

    private Result determineWinnerByHighestCard(final Player player1, final Player player2) {
        final Result result;
        final Card firstPlayerHighestCard = cardRules.highestCardFrom(player1.getHand());
        final Card secondPlayerHighestCard = cardRules.highestCardFrom(player2.getHand());
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
