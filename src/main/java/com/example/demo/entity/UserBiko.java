package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "t_user_biko")
public class UserBiko {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "biko")
    private String biko;

    //@ToString.Exclude
    // t_user_biko n:1 t_user 
    @ManyToOne
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private User user;
}
