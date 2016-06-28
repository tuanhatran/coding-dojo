import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PokerHands {
    private static final String REGEX_SPACE = " ";

    public Result whoWin(final Player player1, final Player player2) {
        final Card firstPlayerHighestCard = getHighestCard(player1.getHand());
        final Card secondPlayerHighestCard = getHighestCard(player2.getHand());

        if (firstPlayerHighestCard.getRank().ordinal() > secondPlayerHighestCard.getRank().ordinal()) {
            return new Result(player1, HandType.HIGH_CARD, Optional.of(firstPlayerHighestCard));
        } else {
            return new Result(player2, HandType.HIGH_CARD, Optional.of(secondPlayerHighestCard));
        }
    }

    private Card getHighestCard(final String hand) {
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
