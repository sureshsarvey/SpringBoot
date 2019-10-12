package com.boot.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport
{

@Bean
public net.sf.ehcache.CacheManager ehCahcheManager()
{
	CacheConfiguration tenSecondCache = new CacheConfiguration();
	tenSecondCache.setName("ten-second-cache");
	tenSecondCache.setMaxEntriesLocalHeap(20);
	tenSecondCache.setTimeToLiveSeconds(100000);
	
	CacheConfiguration twentySecondCache = new CacheConfiguration();
	twentySecondCache.setName("twenty-second-cache");
	twentySecondCache.setMaxEntriesLocalHeap(20);
	twentySecondCache.setTimeToLiveSeconds(20);
	
	net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
	config.addCache(tenSecondCache);
	config.addCache(twentySecondCache);
	
	return  net.sf.ehcache.CacheManager.newInstance(config);
	
	
}
	
@Bean	
@Override
public CacheManager cacheManager() {
	// TODO Auto-generated method stub
	return new EhCacheCacheManager(ehCahcheManager());
}
}
