package com.spring.redis.service;

import com.spring.redis.dto.RedisListsDTO;
import com.spring.redis.request.RedisRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {
  String getRedisStrings();
  RedisListsDTO getRedisLists(Integer index);
  Set<Object> getRedisSets();
  Set<Object> getRedisSortedSets();
  List<String> getRedisHashes(String singer);
  Map<Object, Object> getRedisHashesAll();

  void addRedisStrings(String str);
  void addRedisLists(List<String> list);
  void addRedisSets(Set<String> set);
  void addRedisSortedSets(List<String> sortedSet);
  void addRedisHashes(RedisRequest request);
}
