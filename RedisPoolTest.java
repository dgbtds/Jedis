import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created with Eclipse IDEA.
 * User: dgbtds
 * Date: 2017/3/4.
 * Time: 下午 12:28.
 * Explain:测试RedisPool,发布订阅
 */
public class RedisPoolTest {

    public static void main(String[] args) {  
    	
    	  String redisIp = "127.0.0.1";
          int reidsPort = 6379;
          JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort);
          System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));

          SubThread subThread = new SubThread(jedisPool);
          subThread.start();

          Publisher publisher = new Publisher(jedisPool);
          publisher.start();


    }

}
