package com.devleoh.glomo.portfolio.model;

import com.devleoh.glomo.asset.model.Asset;
import com.devleoh.glomo.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * packageName    : com.devleoh.glomo.portfolio.model
 * fileName       : PortfolioAsset
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
public class PortfolioAsset extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PORTFOLIO_ASSET_ID")
    private Long portfolioAssetId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PORTFOLIO_ID")
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSET_ID")
    private Asset asset;

    @Column(name = "ALLOCATION", nullable = false)
    private BigDecimal allocation;       // 자산의 포트폴리오 내 비율
}
