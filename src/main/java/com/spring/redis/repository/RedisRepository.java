package com.spring.redis.repository;

import com.spring.redis.request.RedisRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisRepository {
  String getRedisStrings();
  String getRedisListByIndex(Integer index);
  List<Object> getRedisLists();
  Set<Object> getRedisSets();
  Set<Object> getRedisSortedSets();
  Object getRedisHashesByKey(String key);
  Map<Object, Object> getRedisHashesAll();

  void addRedisStrings(String str);
  void addRedisLists(List<String> list);
  void addRedisSets(Set<String> set);
  void addRedisSortedSets(List<String> sortedSet);
  void addRedisHashes(RedisRequest request);
}
