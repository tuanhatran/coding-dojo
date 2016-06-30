import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class CardRules {
    private static final String REGEX_SPACE = " ";
    private static final int ONE_PAIR = 4; //There is 1 pair => 5 cards => 4

    Card highestCardFrom(final String hand) {
        final List<Card> cards = cardsFrom(hand);
        return cards.stream().max(Card::compareTo).get();
    }

    HandType highestHandTypeFrom(final String hand) {
        final HandType result;
        final List<Card> cards = cardsFrom(hand);
        final Integer count = countDistinctCard(cards);
        switch (count) { // to be completed with different handtype : TWO PAIR, etc.
            case 5:
                result = HandType.HIGH_CARD;
                break;
            case 4:
                result = HandType.PAIR;
                break;
            default:
                result = HandType.FLUSH;
        }
        return result;
    }

    private Integer countDistinctCard(final List<Card> cards) {
        return Integer.valueOf(String.valueOf(cards.stream().map(Card::getRank).distinct().count()));
    }

    private List<Card> cardsFrom(String hand) {
        final String[] cardStrings = hand.split(REGEX_SPACE);
        return convertToCard(cardStrings);
    }

    private List<Card> convertToCard(String[] cards) {
        return Arrays.stream(cards)
                .map(card -> new Card(card.substring(1, 2), CardRank.getEnumFromValue(card.substring(0, 1))))
                .collect(Collectors.toList());
    }
}
