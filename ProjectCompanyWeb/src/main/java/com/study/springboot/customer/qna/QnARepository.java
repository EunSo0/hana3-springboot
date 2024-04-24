package com.study.springboot.qna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QnARepository  extends JpaRepository<QnA,Long> {
  QnA findByQnaPw(String qnaPw);
}
