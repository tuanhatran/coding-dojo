import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        final Card expectedFirstPlayerHighestCard = new Card("D", CardRank.KING);
        final Card expectedSecondPlayerHighestCard = new Card("H", CardRank.ACE);
        when(cardUtilities.highestHandTypeFrom("2H 3D 5S 9C KD")).thenReturn(HandType.HIGH_CARD);
        when(cardUtilities.highestHandTypeFrom("2C 3H 4S 8C AH")).thenReturn(HandType.HIGH_CARD);
        when(cardUtilities.highestCardFrom("2H 3D 5S 9C KD")).thenReturn(expectedFirstPlayerHighestCard);
        when(cardUtilities.highestCardFrom("2C 3H 4S 8C AH")).thenReturn(expectedSecondPlayerHighestCard);
        final Result result = hands.whoWin(player1, player2);

        assertThat(result.getPlayer(), is(player2));
        assertThat(result.getType(), is(HandType.HIGH_CARD));
        assertThat(result.getHighestCard().get(), is(expectedSecondPlayerHighestCard));
    }

    @Test
    public void testWinByPair() throws Exception {
        final Player player1 = new Player("white", "2H 2D 5S 9C KD");
        final Player player2 = new Player("black", "2C 3H 4S 8C AH");
        when(cardUtilities.highestHandTypeFrom("2H 2D 5S 9C KD")).thenReturn(HandType.PAIR);
        when(cardUtilities.highestHandTypeFrom("2C 3H 4S 8C AH")).thenReturn(HandType.HIGH_CARD);

        final Result result = hands.whoWin(player1, player2);

        assertThat(result.getPlayer(), is(player1));
        assertThat(result.getType(), is(HandType.PAIR));
        assertThat(result.getHighestCard(), is(Optional.empty()));
    }
}