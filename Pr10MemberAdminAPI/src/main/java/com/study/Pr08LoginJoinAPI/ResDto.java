package com.study.Pr08LoginJoinAPI;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResDto {
  String status;
  String message;
}
