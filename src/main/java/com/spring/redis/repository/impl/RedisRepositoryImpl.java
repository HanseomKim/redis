package com.spring.redis.repository.impl;

import com.spring.redis.repository.RedisRepository;
import com.spring.redis.request.RedisRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisRepositoryImpl implements RedisRepository {

  @Value("${spring.redis.key.stringsKey}")
  private String stringsKey;
  @Value("${spring.redis.key.listsKey}")
  private String listsKey;
  @Value("${spring.redis.key.setsKey}")
  private String setsKey;
  @Value("${spring.redis.key.sortedSetsKey}")
  private String sortedSetsKey;
  @Value("${spring.redis.key.hashesKey}")
  private String hashesKey;

  final RedisTemplate<String, Object> redisTemplate;

  @Override
  public String getRedisStrings() {
    return (String) redisTemplate.opsForValue().get(stringsKey);
  }

  @Override
  public String getRedisListByIndex(Integer index) {
    return (String) redisTemplate.opsForList().index(listsKey, index);
  }

  @Override
  public List<Object> getRedisLists() {
    return redisTemplate.opsForList().range(listsKey, 0, -1);
  }

  @Override
  public Set<Object> getRedisSets() {
    return redisTemplate.opsForSet().members(setsKey);
  }

  @Override
  public Set<Object> getRedisSortedSets() {
    return redisTemplate.opsForZSet().range(sortedSetsKey, 0, -1);
  }

  @Override
  public Object getRedisHashesByKey(String key) {
    return redisTemplate.opsForHash().get(hashesKey, key);
  }

  @Override
  public Map<Object, Object> getRedisHashesAll() {
    return redisTemplate.opsForHash().entries(hashesKey);
  }

  @Override
  public void addRedisStrings(String str) {
    redisTemplate.opsForValue().set(stringsKey, str);
  }

  @Override
  public void addRedisLists(List<String> list) {
    redisTemplate.opsForList().rightPush(listsKey, list);
  }

  @Override
  public void addRedisSets(Set<String> set) {
    redisTemplate.opsForSet().add(setsKey, set);
  }

  @Override
  public void addRedisSortedSets(List<String> sortedSet) {
    AtomicInteger atomicInt = new AtomicInteger(0);
    sortedSet.stream().forEach(
        x -> redisTemplate.opsForZSet().add(sortedSetsKey, x, atomicInt.getAndIncrement()));
  }

  @Override
  public void addRedisHashes(RedisRequest request) {
    redisTemplate.opsForHash().put(hashesKey, request.getSinger(), request.getSongs());
  }
}
