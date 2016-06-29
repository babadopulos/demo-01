package demo.babadopulos;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author babadopulos
 */
public class MathDemoTest {

    public MathDemoTest() {
    }

    @Test
    public void sumTest() {
        Integer sum = MathDemo.sum(1, 2);

        assertEquals((Integer) 3, sum);

        Integer sum1 = MathDemo.sum(null, 2);

        assertNull(sum1);

        Integer sum2 = MathDemo.sum(1, null);

        assertNull(sum2);

        Integer sum3 = MathDemo.sum(null, null);

        assertNull(sum3);

    }
}
