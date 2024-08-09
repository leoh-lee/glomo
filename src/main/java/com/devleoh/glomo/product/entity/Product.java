package com.devleoh.glomo.product.entity;

import com.devleoh.glomo.base.BaseEntity;
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
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(nullable = false)
    private String code;                        // 상품 코드

    private int faceValue;                      // 액면가

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCategory productCategory;    // 상품 분류

    @ManyToOne(fetch = FetchType.LAZY)
    private TradingMarket tradingMarket;        // 시장
}
