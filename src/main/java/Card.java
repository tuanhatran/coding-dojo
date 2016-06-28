enum Card {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Card(String value) {
        this.value = value;
    }

    public static Card getEnumFromValue(String substring) {
        for (Card card : Card.values()) {
            if (card.getValue().equals(substring))
                return card;
        }
        throw new RuntimeException("Value not found");
    }
}
