package com.devleoh.glomo.portfolio.model;

import com.devleoh.glomo.base.model.BaseEntity;
import com.devleoh.glomo.member.model.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * packageName    : com.devleoh.glomo.portfolio.model
 * fileName       : Portfolio
 * author         : nimoh
 * date           : 2024/08/18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/08/18        nimoh       최초 생성
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member owner;

    @OneToMany(mappedBy = "portfolio")
    private Set<PortfolioAsset> portfolioAssets = new HashSet<>();
}
