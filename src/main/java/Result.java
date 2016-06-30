import java.util.Objects;
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

    @Override
    public int hashCode() {
        return Objects.hash(player, type, highestCard);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Result other = (Result) obj;
        return Objects.equals(this.player, other.player)
                && Objects.equals(this.type, other.type)
                && Objects.equals(this.highestCard, other.highestCard);
    }
}
