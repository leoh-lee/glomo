package com.devleoh.glomo.member.domain;

import com.devleoh.glomo.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    public Member(String name, String memberId, String password, String email) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public boolean isSameMemberId(String memberId) {
        return this.memberId.equals(memberId);
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeMemberId(String memberId) {
        this.memberId = memberId;
    }
}
