package com.study.springboot.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  Member findByMemberId(String memberId);
  Member findByMemberName(String memberName);
}
