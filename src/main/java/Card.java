class Card implements Comparable<Card> {
    private final String suit;
    private final CardRank rank;

    public Card(final String suit, final CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public int compareTo(Card card) {
        return this.getRank().ordinal() - card.getRank().ordinal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != null ? !suit.equals(card.suit) : card.suit != null) return false;
        return rank == card.rank;

    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }
}
