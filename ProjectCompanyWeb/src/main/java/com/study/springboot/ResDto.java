package com.study.springboot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResDto {
  String status;
  String message;
}
