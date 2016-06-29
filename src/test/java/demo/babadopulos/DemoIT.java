package demo.babadopulos;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 *
 * @author babadopulos
 */
public class DemoIT {

    private static Jedis jedis;

    public DemoIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        jedis = new Jedis(System.getenv("DOCKER_IP"));

        assertEquals((Long) 0l, jedis.dbSize());
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
    public void redisTest() {

        Demo demo = new Demo();

        String key = "demo";
        String value = "Integration Test Demo";

        demo.redisSet(jedis, key, value);

        assertEquals(value, demo.redisGet(jedis, key));
    }

    @Test
    public void redisTTLTest() throws InterruptedException {

        Demo demo = new Demo();

        String key = "demo";
        String value = "Integration Test Demo";

        int ttl = 1;

        demo.redisSet(jedis, key, value, ttl);

        Thread.sleep(1000 * ttl + 100);

        assertNull(demo.redisGet(jedis, key));
    }

}
