package com.devleoh.glomo.news.model;

import com.devleoh.glomo.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class News extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "NEWS_ID")
    private long newsId;

    @Column(name = "NEWS_TITLE", nullable = false)
    private String newTitle;

    @Column(name = "NEWS_CONTENT", nullable = false)
    private String newContent;

    @Column(name = "NEWS_AUTHOR")
    private String newsAuthor;

    @ManyToOne
    @JoinColumn(name="NEWS_CATEGORY", nullable = false)
    private NewsCategory newsCategory;

    public void changeNewsCategory(NewsCategory newsCategory) {
        newsCategory.addNews(this);
        this.newsCategory = newsCategory;
    }

}
