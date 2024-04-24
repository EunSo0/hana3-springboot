package com.study.springboot.dto;

import lombok.Data;

@Data
public class MemberLoginDto {
  private String memberId;
  private String memberPw;
}
