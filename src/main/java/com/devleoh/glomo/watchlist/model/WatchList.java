package com.devleoh.glomo.watchlist.model;

import com.devleoh.glomo.base.BaseEntity;
import com.devleoh.glomo.member.model.Member;
import com.devleoh.glomo.asset.model.Asset;
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
    @Column(name = "WATCH_LIST_ID")
    private Long watchListId;

    @Column(name = "WATCH_LIST_NAME")
    private String watchListName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSET_ID", nullable = false)
    private Asset asset;
}
