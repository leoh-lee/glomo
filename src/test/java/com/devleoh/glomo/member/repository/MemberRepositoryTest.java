package com.devleoh.glomo.member.repository;

import com.devleoh.glomo.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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


    @Test
    public void 회원가입() throws Exception {
        // given
        String userName = "userName";
        String userId = "userId";
        Member user = new Member(userName, userId,"password",  "email");
        // when
        final Member result = memberRepository.save(user);
        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.isSameName("userName")).isTrue();
        assertThat(result.isSameMemberId("userId")).isTrue();
    }

}
