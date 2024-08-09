package com.devleoh.glomo.watchlist.entity;

import com.devleoh.glomo.base.BaseEntity;
import com.devleoh.glomo.member.entity.Member;
import com.devleoh.glomo.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.devleoh.glomo.WatchList.entity
 * fileName       : WatchList
 * author         : nimoh
 * date           : 2024/08/01
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/08/01        nimoh       최초 생성
 */
@Entity
@Getter
@NoArgsConstructor
public class WatchList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
