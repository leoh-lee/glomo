package com.devleoh.glomo.news.model;

import com.devleoh.glomo.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.devleoh.glomo.news.entity
 * fileName       : News
 * author         : nimoh
 * date           : 2024/08/09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/08/09        nimoh       최초 생성
 */
@Entity
@Getter
@NoArgsConstructor
public class News extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="NEWS_ID")
    private long newsId;

    private String title;

    private String content;

    private String author;

    @ManyToOne
    @JoinColumn(name="NEWS_CATEGORY")
    private NewsCategory newsCategory;

    public void changeNewsCategory(NewsCategory newsCategory) {
        newsCategory.addNews(this);
        this.newsCategory = newsCategory;
    }

}
