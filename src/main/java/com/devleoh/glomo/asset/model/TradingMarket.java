package com.devleoh.glomo.asset.model;

import com.devleoh.glomo.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.devleoh.glomo.product.entity
 * fileName       : TradingMarket
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
public class TradingMarket extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRADING_MARKET_ID")
    private Long tradingMarketId;

    @Column(name = "TRADING_MARKET_NAME", nullable = false)
    private String tradingMarketName;
}
