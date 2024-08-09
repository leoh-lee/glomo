package com.devleoh.glomo.member.repository;

import com.devleoh.glomo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName    : com.devleoh.glomo.user.repository
 * fileName       : UserRepository
 * author         : nimoh
 * date           : 2024/06/17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/06/17        nimoh       최초 생성
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByLoginId(String loginId);

    boolean existsByLoginId(String loginId);

    boolean existsByEmail(String email);
}
