package com.devleoh.glomo.asset.model;

import com.devleoh.glomo.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.devleoh.glomo.product.entity
 * fileName       : Product
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
public class Asset extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSET_ID")
    private Long assetId;

    @Column(name = "ASSET_CODE", nullable = false)
    private String assetCode;                        // 상품 코드

    @Column(name = "ASSET_NAME", nullable = false)
    private String assetName;                   // 상품 명

    @Column(name = "FACE_VALUE")
    private int faceValue;                      // 액면가

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSET_CATEGORY_ID")
    private AssetCategory assetCategory;        // 상품 분류

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRADING_MARKET_ID")
    private TradingMarket tradingMarket;        // 거래 시장
}
