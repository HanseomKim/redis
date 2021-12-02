package com.spring.redis.controller;

import com.spring.redis.dto.RedisListsDTO;
import com.spring.redis.request.RedisRequest;
import com.spring.redis.service.RedisService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class RedisController {

  private final RedisService redisService;

  @ApiOperation(value = "Redis 데이터 조회(Strings)")
  @GetMapping("/getRedisStrings")
  public ResponseEntity<String> getRedisStrings() {
    return ResponseEntity.ok(redisService.getRedisStrings());
  }

  @ApiOperation(value = "Redis 데이터 조회(Lists)")
  @GetMapping("/getRedisLists")
  public ResponseEntity<RedisListsDTO> getRedisLists(
      @RequestParam(required = false) Integer index) {
    return ResponseEntity.ok(redisService.getRedisLists(index));
  }

  @ApiOperation(value = "Redis 데이터 조회(Sets)")
  @GetMapping("/getRedisSets")
  public ResponseEntity<Set<Object>> getRedisSets() {
    return ResponseEntity.ok(redisService.getRedisSets());
  }

  @ApiOperation(value = "Redis 데이터 조회(SortedSets)")
  @GetMapping("/getRedisSortedSets")
  public ResponseEntity<Set<Object>> getRedisSortedSets() {
    return ResponseEntity.ok(redisService.getRedisSortedSets());
  }

  @ApiOperation(value = "Redis 데이터 조회(Hashes)")
  @GetMapping("/getRedisHashes")
  public ResponseEntity<List<String>> getRedisHashes(
      @RequestParam(required = true) String singer) {
    return ResponseEntity.ok(redisService.getRedisHashes(singer));
  }

  @ApiOperation(value = "Redis 데이터 전체 조회(Hashes)")
  @GetMapping("/getRedisHashesAll")
  public ResponseEntity<Map<Object, Object>> getRedisHashesAll() {
    return ResponseEntity.ok(redisService.getRedisHashesAll());
  }

  @ApiOperation(value = "Redis 데이터 저장(Strings)")
  @PostMapping("/addRedisStrings")
  public ResponseEntity<String> addRedisStrings(
      @RequestBody String str) {
    try {
      redisService.addRedisStrings(str);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(e.getMessage());
    }
    return ResponseEntity.ok("success");
  }

  @ApiOperation(value = "Redis 데이터 저장(Lists)")
  @PostMapping("/addRedisLists")
  public ResponseEntity<String> addRedisLists(
      @RequestBody List<String> list) {
    try {
      redisService.addRedisLists(list);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(e.getMessage());
    }
    return ResponseEntity.ok("success");
  }

  @ApiOperation(value = "Redis 데이터 저장(Sets)")
  @PostMapping("/addRedisSets")
  public ResponseEntity<String> addRedisSets(
      @RequestBody Set<String> set) {
    try {
      redisService.addRedisSets(set);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(e.getMessage());
    }
    return ResponseEntity.ok("success");
  }

  @ApiOperation(value = "Redis 데이터 저장(SortedSets)")
  @PostMapping("/addRedisSortedSets")
  public ResponseEntity<String> addRedisSortedSets(
      @RequestBody List<String> set) {
    try {
/*
      set.forEach(System.out::print);
*/
      redisService.addRedisSortedSets(set);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(e.getMessage());
    }
    return ResponseEntity.ok("success");
  }

  @ApiOperation(value = "Redis 데이터 저장(Hashes)")
  @PostMapping("/addRedisHashes")
  public ResponseEntity<String> addRedisHashes(
      @RequestBody RedisRequest request) {
    try {
      redisService.addRedisHashes(request);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(e.getMessage());
    }
    return ResponseEntity.ok("success");
  }
}
