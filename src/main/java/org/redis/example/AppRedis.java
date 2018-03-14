package org.redis.example;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class AppRedis {


public static void main( String[] args ) throws InterruptedException
{
	
	/**exemple1**/
	
	String cacheKey = "cachekey";

    Jedis jedis = new Jedis("127.0.0.1");
    jedis.set("foo", "bar");
    String value = jedis.get("foo");
    
    System.err.println(value);   
    
    
    /**exemple2**/
    
    
    System.out.println(jedis.get("counter"));
    jedis.incr("counter");
    System.out.println(jedis.get("counter"));
    
    
    
    /**exemple3**/

    
   
 // adding a new key
    jedis.set(cacheKey, "cached value");
    // setting the TTL in seconds
    jedis.expire(cacheKey, 15);
    // Getting the remaining ttl
    System.out.println("TTL:" + jedis.ttl(cacheKey));
    Thread.sleep(1000);
    System.out.println("TTL:" + jedis.ttl(cacheKey));
    // Getting the cache value
    System.out.println("Cached Value:" + jedis.get(cacheKey));

    // Wait for the TTL finishs
    Thread.sleep(15000);

    // trying to get the expired key
    System.out.println("Expired Key:" + jedis.get(cacheKey));
    
    
    /**exemple4**/

    String cacheKeyL = "languages";
    // Adding a set as value

    jedis.sadd(cacheKeyL, "Java");
    jedis.sadd(cacheKeyL, "C#");
    jedis.sadd(cacheKeyL, "Python");// SADD

    // Getting all values in the set: SMEMBERS
    System.out.println("Languages: " + jedis.smembers(cacheKeyL));
    // Adding new values
    jedis.sadd(cacheKeyL, "Java");
    jedis.sadd(cacheKeyL, "Ruby");
    // Getting the values... it doesn't allow duplicates
    System.out.println("Languages: " + jedis.smembers(cacheKeyL));

    
    
    
    
    
    
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



}
