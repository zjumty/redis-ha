package demo;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * TODO: 这里需要写注释
 */
public class RedisTemplateTests {

    public void testSetAndGet() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);
        factory.afterPropertiesSet();

        RedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(factory);
        template.afterPropertiesSet();

        template.delete("list1");
        template.boundListOps("list1").leftPush("1");
        template.boundListOps("list1").leftPush("2");

        template.delete("foo:1:1");
    }
}
