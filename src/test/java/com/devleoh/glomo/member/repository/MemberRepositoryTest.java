package com.devleoh.glomo.member.repository;

import com.devleoh.glomo.member.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName    : com.devleoh.glomo.user.repository
 * fileName       : UserRepositoryTest
 * author         : nimoh
 * date           : 2024/06/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/06/17        nimoh       최초 생성
 */

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        // given
        String memberName = "memberName";
        String memberId = "memberId";
        Member member = new Member(memberName, memberId,"password",  "email");
        // when
        final Member result = memberRepository.save(member);
        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.isSameName(memberName)).isTrue();
        assertThat(result.isSameMemberId(memberId)).isTrue();
    }

    @Test
    public void 회원수정() throws Exception {
        // given
        String memberName = "memberName";
        String memberId = "memberId";
        Member member = new Member(memberName, memberId,"password",  "email");
        final Member savedMember = memberRepository.save(member);
        em.flush();
        // when
        Member findMember = memberRepository.findById(savedMember.getId()).get();
        String changedName = "userName2";
        String changedMemberId = "userId2";

        findMember.changeName(changedName);
        findMember.changeMemberId(changedMemberId);

        em.flush();

        Member updatedMember = memberRepository.findById(savedMember.getId()).get();
        // then
        assertThat(updatedMember.getId()).isEqualTo(findMember.getId());
        assertThat(updatedMember.isSameMemberId(changedName));
        assertThat(updatedMember.isSameName(changedMemberId));
    }

    @Test
    public void 회원삭제() throws Exception {
        // given
        String memberName = "memberName";
        String memberId = "memberId";
        Member member = new Member(memberName, memberId,"password",  "email");
        final Member savedMember = memberRepository.save(member);
        em.flush();
        // when
        memberRepository.delete(savedMember);
        em.flush();

        Optional<Member> findMember = memberRepository.findById(savedMember.getId());
        // then
        assertThat(findMember).isEmpty();
    }

}
