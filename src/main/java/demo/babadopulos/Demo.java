package demo.babadopulos;

import redis.clients.jedis.Jedis;

/**
 *
 * @author babadopulos
 */
public class Demo {

    public String redisGet(Jedis jedis, String key) {
        return jedis.get(key);
    }

    public void redisSet(Jedis jedis, String key, String value) {
        jedis.set(key, value);
    }

    public void redisSet(Jedis jedis, String key, String value, Integer ttl) {
        redisSet(jedis, key, value);
        jedis.expire(key, ttl);
    }

}
