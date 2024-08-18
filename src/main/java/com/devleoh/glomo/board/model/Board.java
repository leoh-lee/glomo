package com.devleoh.glomo.board.model;

import com.devleoh.glomo.asset.model.Asset;
import com.devleoh.glomo.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.devleoh.glomo.board.model
 * fileName       : Board
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
@NoArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long boardId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSET_ID")
    private Asset asset;

    public static Board create(Asset asset) {
        Board board = new Board();
        board.asset = asset;
        return board;
    }
}
