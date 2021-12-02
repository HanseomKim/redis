package com.spring.redis.request;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisRequest {
  @ApiModelProperty(notes = "가수", required = true)
  private String singer;

  @ApiModelProperty(notes = "곡")
  private List<String> songs;
}
