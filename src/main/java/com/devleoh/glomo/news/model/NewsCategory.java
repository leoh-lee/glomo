package com.devleoh.glomo.news.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.devleoh.glomo.news.entity
 * fileName       : NewsCategory
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
public class NewsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NEWS_CATERGORY_ID")
    private long newsCategoryId;

    @Column(name = "NEWS_CATEGORY_NAME")
    private String newsCategoryName;

    @OneToMany(mappedBy = "newsCategory")
    private List<News> newsList = new ArrayList<>();

    public void addNews(News news) {
        newsList.add(news);
    }
}
