package com.study.springboot.dto;

import lombok.Data;

@Data
public class MemberFindDto {
  private String memberName;
  private String memberId;
  private String memberEmail;
}
