import java.util.Optional;

class Result {
    private Player player;
    private HandType type;
    private Optional<Card> highestCard;

    public Player getPlayer() {
        return player;
    }

    public HandType getType() {
        return type;
    }

    public void setType(HandType type) {
        this.type = type;
    }

    public Optional<Card> getHighestCard() {
        return highestCard;
    }

    public void setHighestCard(final Optional<Card> highestCard) {
        this.highestCard = highestCard;
    }
}
