package com.devleoh.glomo.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String userId;
    private String password;
    private String email;

    public User() {}

    public User(String username, String userId, String password, String email) {
        this.username = username;
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    public boolean isSameUserName(String username) {
        return this.username.equals(username);
    }

    public boolean isSameUserId(String userId) {
        return this.userId.equals(userId);
    }
}
