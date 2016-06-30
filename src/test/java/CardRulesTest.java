import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by thtran on 29/06/16.
 */
public class CardRulesTest {
    private CardRules cardRules;

    @Before
    public void setUp() throws Exception {
        cardRules = new CardRules();
    }

    @Test
    public void testHighestCardFromHand() throws Exception {
        final Card highestCard = cardRules.highestCardFrom("2H 3D 5S 9C KD");

        assertThat(highestCard, is(new Card("D", CardRank.KING)));
    }

    @Test
    public void testHighestHandTypePAIRFromHand() throws Exception {
        final HandType result = cardRules.highestHandTypeFrom("2H 2D 5S 9C KD");

        assertThat(result, is(HandType.PAIR));
    }

    @Test
    public void testHighestHandTypeHIGHCARDFromHand() throws Exception {
        final HandType result = cardRules.highestHandTypeFrom("2H 3D 5S 9C KD");

        assertThat(result, is(HandType.HIGH_CARD));
    }
}