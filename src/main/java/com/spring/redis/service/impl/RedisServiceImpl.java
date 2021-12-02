package com.spring.redis.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.redis.dto.RedisListsDTO;
import com.spring.redis.repository.RedisRepository;
import com.spring.redis.request.RedisRequest;
import com.spring.redis.service.RedisService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {

  private final RedisRepository redisRepository;

  @Override
  public String getRedisStrings() {
    return redisRepository.getRedisStrings();
  }

  @Override
  public RedisListsDTO getRedisLists(Integer index) {
    RedisListsDTO result = new RedisListsDTO();
    List<Object> redisResult = new ArrayList<>();

    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

    if (index != null) {
      redisResult.add(redisRepository.getRedisListByIndex(index));
    } else {
      redisResult = redisRepository.getRedisLists();
    }

    if (redisResult != null) {
      for (Object o : redisResult) {
        result.setResult(mapper.convertValue(o, List.class));
      }
    }

    return result;
  }

  @Override
  public Set<Object> getRedisSets() {
    return redisRepository.getRedisSets();
  }

  @Override
  public Set<Object> getRedisSortedSets() {
    return redisRepository.getRedisSortedSets();
  }

  @Override
  public List<String> getRedisHashes(String singer) {
    return (List<String>) redisRepository.getRedisHashesByKey(singer);
  }

  @Override
  public Map<Object, Object> getRedisHashesAll() {
    return redisRepository.getRedisHashesAll();
  }

  @Override
  public void addRedisStrings(String str) {
    redisRepository.addRedisStrings(str);
  }

  @Override
  public void addRedisLists(List<String> list) {
    redisRepository.addRedisLists(list);
  }

  @Override
  public void addRedisSets(Set<String> set) {
    redisRepository.addRedisSets(set);
  }

  @Override
  public void addRedisSortedSets(List<String> sortedSet) {
    redisRepository.addRedisSortedSets(sortedSet);
  }

  @Override
  public void addRedisHashes(RedisRequest request) {
    redisRepository.addRedisHashes(request);
  }
}
