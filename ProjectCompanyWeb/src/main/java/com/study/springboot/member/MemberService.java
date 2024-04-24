package com.study.springboot.service;

import com.study.springboot.domain.member.Member;
import com.study.springboot.domain.member.MemberRepository;
import com.study.springboot.dto.MembeSaveRequestDto;
import com.study.springboot.dto.MemberFindDto;
import com.study.springboot.dto.MemberLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  @Transactional
  public Long save(final MembeSaveRequestDto dto){
    Member entity = memberRepository.save(dto.toEntity());
    return entity.getMemberIdx();
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long boardIdx){
    boolean isFound = memberRepository.existsById(boardIdx);
    return isFound;
  }

  @Transactional(readOnly = true)
  public Member existsMember(final MemberLoginDto dto){
    Member member = memberRepository.findByMemberId(dto.getMemberId());
    return member;
  }

  @Transactional(readOnly = true)
  public boolean dupleId(String userId){
    Member member = memberRepository.findByMemberId(userId);
    return member != null;
  }

  @Transactional(readOnly = true)
  public String findId(final MemberFindDto dto){
    Member member = memberRepository.findByMemberName(dto.getMemberName());
    if(member == null){
      return null;
    }
    if(member.getMemberEmail().equals(dto.getMemberEmail())){
      return member.getMemberId();
    } else{
      return null;
    }
  }

  @Transactional(readOnly = true)
  public String findPw(final MemberFindDto dto){
    Member member = memberRepository.findByMemberName(dto.getMemberName());
    if(member == null){
      return null;
    }
    if(member.getMemberEmail().equals(dto.getMemberEmail()) && member.getMemberId().equals(dto.getMemberId())){
      return member.getMemberPw();
    } else{
      return null;
    }
  }

}
