import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by thtran on 29/06/16.
 */
public class CardUtilitiesTest {
    private CardUtilities cardUtilities;

    @Before
    public void setUp() throws Exception {
        cardUtilities = new CardUtilities();
    }

    @Test
    public void getHighestCard() throws Exception {
        final Card highestCard = cardUtilities.getHighestCard("2H 3D 5S 9C KD");

        assertThat(highestCard, is(new Card("D", CardRank.KING)));
    }

}