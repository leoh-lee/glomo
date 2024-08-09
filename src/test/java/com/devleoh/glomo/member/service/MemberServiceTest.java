package com.devleoh.glomo.member.service;

import com.devleoh.glomo.member.entity.Member;
import com.devleoh.glomo.member.exception.MemberException;
import com.devleoh.glomo.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static com.devleoh.glomo.member.exception.MemberExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * packageName    : com.devleoh.glomo.member.service
 * fileName       : MemberServiceTest
 * author         : nimoh
 * date           : 2024/06/24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/06/24        nimoh       최초 생성
 */
@SpringBootTest(classes = MemberService.class)
public class MemberServiceTest {

    public static final String MEMBER_PASSWORD = "1234";

    @Autowired
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    private Member member;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException {
        member = new Member("test","test", MEMBER_PASSWORD, "test@test.com");
    }
    @Nested
    class 멤버조회 {
        @Test
        void 실패_ID에_해당하는_멤버없음_() {
            //given
            when(memberRepository.findById(1L)).thenReturn(Optional.empty());
            //when
            //then
            assertThatThrownBy(() -> memberService.findById(1L)).isInstanceOf(MemberException.class).hasMessageContaining(MEMBER_NOT_FOUND.getMessage());
        }

        @Test
        void 성공() {
            //given
            //when
            when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

            Member findMember = memberService.findById(1L);
            //then
            assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId());
            assertThat(findMember.getLoginId()).isEqualTo(member.getLoginId());
            assertThat(findMember.getPassword()).isEqualTo(member.getPassword());
            assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
        }
    }

    @Nested
    class 회원가입 {
        @Test
        void 실패_이미_존재하는_아이디() {
            //given
            when(memberRepository.existsByLoginId(member.getLoginId())).thenReturn(true);

            Member newMember = new Member("ace","test","1234", "ace@ace.com");
            //when
            //then
            assertThatThrownBy(() -> memberService.createMember(newMember)).isInstanceOf(MemberException.class).hasMessageContaining(DUPLICATE_MEMBER_ID.getMessage());
        }

        @Test
        void 실패_이미_존재하는_이메일() {
            //given
            when(memberRepository.existsByEmail(member.getEmail())).thenReturn(true);

            Member newMember = new Member("ace","ace","1234", "test@test.com");
            //when
            //then
            assertThatThrownBy(() -> memberService.createMember(newMember)).isInstanceOf(MemberException.class).hasMessageContaining(DUPLICATE_EMAIL.getMessage());
        }

        @Test
        void 성공() {
            //given
            when(memberRepository.existsByLoginId(anyString())).thenReturn(false);
            when(memberRepository.existsByEmail(any())).thenReturn(false);
            when(memberRepository.save(any())).thenReturn(member);
            //when
            //then
            assertThatNoException().isThrownBy(()->memberService.createMember(member));

        }
    }

}
