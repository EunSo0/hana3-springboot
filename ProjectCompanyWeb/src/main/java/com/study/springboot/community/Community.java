package com.study.springboot.domain.community;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="company_notice")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Community {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notice_idx", nullable = false)
  private Long noticeIdx;
  @Column(name="notice_title", nullable = false)
  private String noticeTitle;
  @Column(name="notice_content", nullable = false)
  private String noticeContent;
  @Column(name="notice_member_id", nullable = false)
  private String noticeMemberId;
  @Column(name="notice_date", nullable = false)
  private LocalDateTime noticeDate = LocalDateTime.now();

  @Builder
  public Community(Long noticeIdx, String noticeTitle, String noticeContent, String noticeMemberId, LocalDateTime noticeDate) {
    this.noticeIdx = noticeIdx;
    this.noticeTitle = noticeTitle;
    this.noticeContent = noticeContent;
    this.noticeMemberId = noticeMemberId;
    this.noticeDate = LocalDateTime.now();
  }
}
