import java.util.Objects;

class Player {
    private final String name;
    private final String hand;

    public Player(String name, String hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public String getHand() {
        return hand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hand);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        return Objects.equals(this.name, other.name)
                && Objects.equals(this.hand, other.hand);
    }
}
