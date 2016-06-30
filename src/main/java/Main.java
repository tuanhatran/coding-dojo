public class Main {
    public static void main(String[] args) {
        final Player player1 = new Player("white", "2H 3D 5S 9C KD");
        final Player player2 = new Player("black", "2C 3H 4S 8C AH");
        final Result result = new PokerHands(new CardRules()).play(player1, player2);
        final String winner = result.getPlayer().getName();
        final String winByType = (" win by").concat(result.getType().toString());
        final String highestCard = result.getHighestCard().isPresent() ? result.getHighestCard().toString() : "";
        System.out.println(winner + winByType + highestCard);
    }
}
