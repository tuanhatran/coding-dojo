import java.util.Optional;

class Result {
    private final Player player;
    private final HandType type;
    private final Optional<Card> highestCard;

    public Result(Player player, HandType type, Optional<Card> highestCard) {
        this.player = player;
        this.type = type;
        this.highestCard = highestCard;
    }

    public Player getPlayer() {
        return player;
    }

    public HandType getType() {
        return type;
    }

    public Optional<Card> getHighestCard() {
        return highestCard;
    }
}
