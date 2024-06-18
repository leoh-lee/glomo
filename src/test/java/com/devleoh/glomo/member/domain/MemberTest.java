package com.devleoh.glomo.member.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * packageName    : com.devleoh.glomo.user.domain
 * fileName       : UserTest
 * author         : nimoh
 * date           : 2024/06/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/06/17        nimoh       최초 생성
 */
public class MemberTest {
    @Test
    void testNoArgsConstructor() {
        Member member = new Member();
        assertNull(member.getId());
        assertNull(member.getName());
        assertNull(member.getMemberId());
        assertNull(member.getPassword());
        assertNull(member.getEmail());
    }

    @Test
    void testAllArgsConstructor() {
        Member member = new Member("John Doe", "johndoe", "password123", "john@example.com");
        assertNull(member.getId());
        assertEquals("John Doe", member.getName());
        assertEquals("johndoe", member.getMemberId());
        assertEquals("password123", member.getPassword());
        assertEquals("john@example.com", member.getEmail());
    }

    @Test
    void testIsSameName() {
        Member member = new Member("John Doe", "johndoe", "password123", "john@example.com");
        assertTrue(member.isSameName("John Doe"));
        assertFalse(member.isSameName("Jane Doe"));
    }

    @Test
    void testIsSameMemberId() {
        Member member = new Member("John Doe", "johndoe", "password123", "john@example.com");
        assertTrue(member.isSameMemberId("johndoe"));
        assertFalse(member.isSameMemberId("janedoe"));
    }

    @Test
    void testChangeName() {
        Member member = new Member("John Doe", "johndoe", "password123", "john@example.com");
        member.changeName("Jane Doe");
        assertEquals("Jane Doe", member.getName());
    }

    @Test
    void testChangeMemberId() {
        Member member = new Member("John Doe", "johndoe", "password123", "john@example.com");
        member.changeMemberId("janedoe");
        assertEquals("janedoe", member.getMemberId());
    }
//
//    public static final String USERNAME = "username";
//    public static final String USER_ID = "userId";
//    public static final String PASSWORD = "password";
//    public static final String EMAIL = "email";
//    private Member user;
//
//    @BeforeEach
//    void setUp() {
//        user = new Member(USERNAME, USER_ID, PASSWORD, EMAIL);
//    }
//
//    @Test
//    void isSameUserName() {
//        final String failName = "failName";
//
//        assertAll(
//                () -> assertThat(user.isSameName(USERNAME)).isTrue(),
//                () -> assertThat(user.isSameName(failName)).isFalse()
//        );
//    }
//
//    @Test
//    void isSameUserId() {
//        final String failId = "failId";
//
//        assertAll(
//                () -> assertThat(user.isSameMemberId(USER_ID)).isTrue(),
//                () -> assertThat(user.isSameMemberId(failId)).isFalse()
//        );
//    }
}
