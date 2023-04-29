package com.jutjoy.domain.entity.profile;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name="profiles")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Profile {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "hobby")
    private String hobby;
    
    @Column(name = "introduction")
    private String introduction;

    @CreatedDate
    @Column(name = "registered_date")
    private Timestamp registeredDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Timestamp updatedDate;
    
    // 2-6課題
    @OneToMany(mappedBy = "profile")
    private List<ProfileHistories> histories;
}
