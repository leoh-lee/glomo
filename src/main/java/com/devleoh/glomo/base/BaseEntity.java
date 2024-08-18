package com.devleoh.glomo.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * packageName    : com.devleoh.glomo.base
 * fileName       : BaseEntity
 * author         : nimoh
 * date           : 2024/06/19
 * description    : 모든 Entity의 Base 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/06/19        nimoh       최초 생성
 */
@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class BaseEntity {

    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAT;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAT;
}
