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
    private CardRules cardRules;

    @org.junit.Before
    public void setUp() throws Exception {
        cardRules = mock(CardRules.class);
        hands = new PokerHands(cardRules);
    }


    @Test
    public void testDetermineWinnerByHighestCard() throws Exception {
        final Player player1 = new Player("white", "2H 3D 5S 9C AD");
        final Player player2 = new Player("black", "2C 3H 4S 8C KH");
        final Card expectedFirstPlayerHighestCard = new Card("D", CardRank.ACE);
        final Card expectedSecondPlayerHighestCard = new Card("H", CardRank.KING);
        when(cardRules.highestHandTypeFrom("2H 3D 5S 9C AD")).thenReturn(HandType.HIGH_CARD);
        when(cardRules.highestHandTypeFrom("2C 3H 4S 8C KH")).thenReturn(HandType.HIGH_CARD);
        when(cardRules.highestCardFrom("2H 3D 5S 9C AD")).thenReturn(expectedFirstPlayerHighestCard);
        when(cardRules.highestCardFrom("2C 3H 4S 8C KH")).thenReturn(expectedSecondPlayerHighestCard);
        final Result result = hands.play(player1, player2);

        assertThat(result.getPlayer(), is(player1));
        assertThat(result.getType(), is(HandType.HIGH_CARD));
        assertThat(result.getHighestCard().get(), is(expectedFirstPlayerHighestCard));
    }

    @Test
    public void testDetermineWinnerByPair() throws Exception {
        final Player player1 = new Player("white", "2H 2D 5S 9C KD");
        final Player player2 = new Player("black", "2C 3H 4S 8C AH");
        when(cardRules.highestHandTypeFrom("2H 2D 5S 9C KD")).thenReturn(HandType.PAIR);
        when(cardRules.highestHandTypeFrom("2C 3H 4S 8C AH")).thenReturn(HandType.HIGH_CARD);

        final Result result = hands.play(player1, player2);

        assertThat(result.getPlayer(), is(player1));
        assertThat(result.getType(), is(HandType.PAIR));
        assertThat(result.getHighestCard(), is(Optional.empty()));
    }
}