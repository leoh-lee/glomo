package com.devleoh.glomo.member.service;

import com.devleoh.glomo.member.domain.Member;
import com.devleoh.glomo.member.exception.MemberException;
import com.devleoh.glomo.member.exception.MemberExceptionMessage;
import com.devleoh.glomo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.devleoh.glomo.member.service
 * fileName       : MemberService
 * author         : nimoh
 * date           : 2024/06/24
 * description    : Member 관련 서비스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/06/24        nimoh       최초 생성
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public long createMember(final Member member) {
        if (memberRepository.existsByMemberId(member.getMemberId())) {
            throw new MemberException(MemberExceptionMessage.DUPLICATE_MEMBER_ID);
        }

        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new MemberException(MemberExceptionMessage.DUPLICATE_EMAIL);
        }

        Member savedMember = memberRepository.save(member);

        return savedMember.getId();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberException(MemberExceptionMessage.MEMBER_NOT_FOUND));
    }
}
