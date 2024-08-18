package com.devleoh.glomo.board.model;

import com.devleoh.glomo.member.model.Member;
import com.devleoh.glomo.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * packageName    : com.devleoh.glomo.board.model
 * fileName       : Comment
 * author         : nimoh
 * date           : 2024/08/18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/08/18        nimoh       최초 생성
 */
@Getter
@RequiredArgsConstructor
@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "comment")
    private Set<Like> likes = new HashSet<>();
}
