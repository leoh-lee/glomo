package com.devleoh.glomo.member.model;

import com.devleoh.glomo.base.BaseEntity;
import com.devleoh.glomo.util.SHA256;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;

/**
 * packageName    : com.devleoh.glomo.user.domain
 * fileName       : User
 * author         : nimoh
 * date           : 2024/06/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/06/17        nimoh       최초 생성
 */
@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "MEMBER_NAME", nullable = false)
    private String memberName;

    @Column(name = "LOGIN_ID", nullable = false)
    private String loginId;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PASSWORD_SALT", nullable = false)
    private String passwordSalt = "";

    @Column(name = "EMAIL", nullable = false)
    private String email;

    public Member(String memberName, String loginId, String password, String email) {
        this.memberName = memberName;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
    }

    public boolean isSameName(final String name) {
        return this.memberName.equals(name);
    }

    public boolean isSameMemberId(final String memberId) {
        return this.loginId.equals(memberId);
    }

    public void changeName(final String name) {
        this.memberName = name;
    }

    public void changeMemberId(final String memberId) {
        this.loginId = memberId;
    }

    public void encryptPassword() throws NoSuchAlgorithmException {
        String salt = SHA256.createSalt();
        password = SHA256.encrypt(password, salt);
        passwordSalt = salt;
    }
}
