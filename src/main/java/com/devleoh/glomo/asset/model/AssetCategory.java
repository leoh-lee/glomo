package com.devleoh.glomo.asset.model;

import com.devleoh.glomo.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.devleoh.glomo.ProductCategory.entity
 * fileName       : ProductCategory
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AssetCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSET_CATEOGRY_ID")
    private Long assetCategoryId;

    @Column(name = "ASSET_CATEGORY_NAME", nullable = false)
    private String assetCategoryName;
}
