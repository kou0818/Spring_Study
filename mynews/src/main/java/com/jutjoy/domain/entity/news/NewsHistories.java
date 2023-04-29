package com.jutjoy.domain.entity.news;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@DynamicUpdate
@Table(name="news_histories")
@Data
@EntityListeners(AuditingEntityListener.class)
public class NewsHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "news_id")
    private Integer newsId;

    @LastModifiedDate
    @Column(name = "edited_date")
    private Timestamp editedDate;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    private News news;
}