import java.util.Optional;

class Result {
    private final Player player;
    private final HandType type;
    private final Optional<Card> highestCard;

    Result(Player player, HandType type, Optional<Card> highestCard) {
        this.player = player;
        this.type = type;
        this.highestCard = highestCard;
    }

    Player getPlayer() {
        return player;
    }

    HandType getType() {
        return type;
    }

    Optional<Card> getHighestCard() {
        return highestCard;
    }
}
