package demo.babadopulos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import redis.clients.jedis.Jedis;

/**
 *
 * @author babadopulos
 */
public class DemoTest {

    public DemoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void redisSetTest() {
        Demo demo = new Demo();

        Jedis jedis = mock(Jedis.class);

        String key = "demo";
        String value = "Integration Test Demo";

        demo.redisSet(jedis, key, value);

        Mockito.verify(jedis).set(key, value);
        Mockito.verify(jedis, never()).expire(key, 0);

    }

    @Test
    public void redisSetWithtTTLTest() {
        Demo demo = new Demo();

        Jedis jedis = mock(Jedis.class);

        String key = "demo";
        String value = "Integration Test Demo";

        int ttl = 600;

        demo.redisSet(jedis, key, value, ttl);

        Mockito.verify(jedis).set(key, value);
        Mockito.verify(jedis).expire(key, ttl);

    }

    @Test
    public void redisGetTest() {
        Demo demo = new Demo();

        Jedis jedis = mock(Jedis.class);

        String key = "demo";

        demo.redisGet(jedis, key);

        Mockito.verify(jedis).get(key);

    }

}
