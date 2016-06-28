import java.util.ArrayList;
import java.util.List;

class CardUtilities {
    private static final String REGEX_SPACE = " ";

    public Card getHighestCard(final String hand) {
        final String[] cardStrings = hand.split(REGEX_SPACE);
        final List<Card> cards = convertToCard(cardStrings);
        Card highest = cards.get(0);
        for (Card card : cards) {
            if (card.getRank().ordinal() > highest.getRank().ordinal()) {
                highest = card;
            }
        }
        return highest;
    }

    private List<Card> convertToCard(String[] cards) {
        List<Card> cardList = new ArrayList<>();
        for (String card : cards) {
            final Card c = new Card(card.substring(1, 2), CardRank.getEnumFromValue(card.substring(0, 1)));
            cardList.add(c);
        }
        return cardList;
    }
}
