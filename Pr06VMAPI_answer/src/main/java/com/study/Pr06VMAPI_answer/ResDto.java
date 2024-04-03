package com.study.Pr06VMAPI_answer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResDtoDelete {
  String status; // "ok"
  String message; //"삭제되었습니다"
  int count; // 1
}
