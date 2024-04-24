package com.study.springboot.dto;

import com.study.springboot.domain.reply.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReplyReponseDto {
  private String replyContent;
  private String replyName;
  private Long replyBoardIdx;
  private LocalDateTime replyDate;

  public ReplyReponseDto(Reply entity) {
    this.replyContent = entity.getReplyContent();
    this.replyName = entity.getReplyName();
    this.replyBoardIdx = entity.getReplyBoardIdx();
    this.replyDate = entity.getReplyDate();
  }
}
