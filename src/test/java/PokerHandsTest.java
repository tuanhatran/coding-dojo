import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by thtran on 28/06/16.
 */
public class PokerHandsTest {
    private PokerHands hands;
    private CardUtilities cardUtilities;

    @org.junit.Before
    public void setUp() throws Exception {
        cardUtilities = mock(CardUtilities.class);
        hands = new PokerHands(cardUtilities);
    }

    @Test
    public void testWinByHighCard() throws Exception {
        final Player player1 = new Player("white", "2H 3D 5S 9C KD");
        final Player player2 = new Player("black", "2C 3H 4S 8C AH");
        final Result result = hands.whoWin(player1, player2);

        assertThat(result.getPlayer(), is(player2));
        assertThat(result.getType(), is(HandType.HIGH_CARD));
        assertThat(result.getHighestCard().get(), is(new Card("H", CardRank.ACE)));
    }

    @Test
    public void testWinByPair() throws Exception {
        final Player player1 = new Player("white", "2H 2D 5S 9C KD");
        final Player player2 = new Player("black", "2C 3H 4S 8C AH");

        final Result result = hands.whoWin(player1, player2);

        assertThat(result.getPlayer(), is(player2));
        assertThat(result.getType(), is(HandType.PAIR));
        assertThat(result.getHighestCard(), is(Optional.empty()));
    }
}