package com.devleoh.glomo.product.entity;

import com.devleoh.glomo.base.BaseEntity;
import jakarta.persistence.*;
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
@NoArgsConstructor
public class ProductCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRODUCT_CATEOGRY_ID")
    private Long productCategoryId;

    @Column(nullable = false)
    private String name;
}
