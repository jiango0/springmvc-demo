package com.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.io.*;
import java.util.List;
import java.util.Set;

public class JedisUtils {
	
	private static Logger logger = LoggerFactory.getLogger(JedisUtils.class);
	
	private static JedisPool pool = null;
	
	public synchronized static void init(){
		if(pool == null){
			JedisPoolConfig config = new JedisPoolConfig();
			
			config.setMaxIdle(300);
			config.setMaxTotal(60000);
			config.setTestOnBorrow(true);
			config.setMaxWaitMillis(5000);
			
			String host = "192.168.30.32";
			Integer port = 6379;
			
			pool = new JedisPool(config, host, port, 2000, null, 1);
		}
	}
	
	public static JedisPool getPool(){
		if(pool == null){
			JedisUtils.init();
		}
		
		return pool;
	}
	
	
	public static Jedis getJedis(){
		if(pool == null){
			JedisUtils.getPool();
		}
		
		return pool.getResource();
	}
	
	/**
	 * 获取值(string)
	 *  @param	key
	 *  @return	value
	 * */
	public static String get(String key){
		String value = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			if(jedis.exists(key)){
				value = jedis.get(key);
				value = StringUtils.isNotBlank(value) && !"nil".equalsIgnoreCase(value) ? value : null;
			}
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.get() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return value;
	}
	
	/**
	 * 设置值(string)
	 * @param	key
	 * @param	value
	 * @param	cacheSeconds	缓存时间(秒) 0为永久保存
	 * */
	public static String set(String key, String value, int cacheSeconds){
		String result = "";
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			result = jedis.set(key, value);
			if (cacheSeconds != 0) {
				jedis.expire(key, cacheSeconds);
			}
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.set() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return result;
	}
	
	/**
	 * 获取值(object)
	 * @param	key
	 * @return
	 * */
	public static Object getObject(String key){
		Object value = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			if (jedis.exists(getBytes(key))){
				value = unserialize(jedis.get(getBytes(key)));
			}
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.getObject() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return value;
	}
	
	/**
	 * 设置值(object)
	 * @param	key
	 * @param	value
	 * @param	cacheSeconds	缓存时间(秒) 0为永久保存
	 * @return
	 * */
	public static String setObject(String key, Object value, int cacheSeconds){
		String result = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			result = jedis.set(getBytes(key), serialize(value));
			if (cacheSeconds != 0) {
				jedis.expire(getBytes(key), cacheSeconds);
			}
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.setObject() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return result;
	}
	
	/**
	 * 设置计数器
	 * @param	key
	 * @return
	 * */
	public static Long incr(String key){
		Long result = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			result = jedis.incr(key);
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.incr() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return result;
	}
	
	/**
	 * 批量获取key
	 * */
	public static Set<String> keys(String pattern){
		Set<String> result = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			result = jedis.keys(pattern);
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.keys() ==>> redis获取失败", e);
		}finally {
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return result;
	}
	
	/**
	 * 通过key批量获取值
	 * */
	public static List<String> mget(String[] keys){
		List<String> valueList = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			valueList = jedis.mget(keys);
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.mget() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return valueList;
	}
	
	public static Long del(String key){
		Long result = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			result = jedis.del(key);
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.incr() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return result;
	}
	
	public static Long setnx(String key, String value){
		Long result = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			result = jedis.setnx(key, value);
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.setnx() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return result;
	}
	
	public static String getset(String key, String value){
		String result = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			result = jedis.getSet(key, value);
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.getset() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return result;
	}
	
	/**
	 * 判断是否存在
	 * @param	key
	 * @return
	 * */
	public static boolean exists(String key){
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			return jedis.exists(key);
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.exists() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}
		
		return false;
	}
	
	/**
	 * 序列化对象
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			if (object != null){
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.writeObject(object);
				return baos.toByteArray();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 反序列化对象
	 * @param bytes
	 * @return
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			if (bytes != null && bytes.length > 0){
				bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				return ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] getBytes(String str){
    	if (str != null){
    		try {
				return str.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				return null;
			}
    	}else{
    		return null;
    	}
    }

	/**
	 * hash计数器
	 * @param	key
	 * @param 	field
	 * @param 	value
	 * @return
	 * */
	public static Long hincrby(String key, String field, long value){
		Long result = null;
		Jedis jedis = null;
		try{
			jedis = JedisUtils.getJedis();
			result = jedis.hincrBy(key, field, value);
		}catch(Exception e){
			JedisUtils.getPool().returnBrokenResource(jedis);
			logger.error("JedisUtils.hincrby() ==>> redis获取失败", e);
		}finally{
			JedisUtils.getPool().returnResource(jedis);
		}

		return result;
	}

	public static Long expire(String key, int cacheSeconds) {
		Long result = null;
		Jedis jedis = null;
		try {
			jedis = JedisUtils.getJedis();
			result = jedis.expire(key, cacheSeconds);
		} catch (Exception e) {
		} finally {
			JedisUtils.getPool().returnResource(jedis);
		}
		return result;
	}

	/**
	 * 判断Map缓存中的Key是否存在
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public static boolean mapExists(String key, String mapKey) {
		boolean result = false;
		Jedis jedis = null;
		try {
			jedis = JedisUtils.getJedis();
			result = jedis.hexists(key, mapKey);
			logger.debug("mapExists {}  {}", key, mapKey);
		} catch (Exception e) {
			logger.warn("mapExists {}  {}", key, mapKey, e);
		} finally {
			JedisUtils.getPool().returnResource(jedis);
		}
		return result;
	}

	public static Transaction multi(){
		Transaction result = null;
		Jedis jedis = null;
		try {
			jedis = JedisUtils.getJedis();
			result = jedis.multi();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JedisUtils.getPool().returnResource(jedis);
		}
		return result;
	}

}
