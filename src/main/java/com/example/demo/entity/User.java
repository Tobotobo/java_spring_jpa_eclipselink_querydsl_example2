package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "t_user") // H2で"user"は予約語でNG
//@Table(name = "`user`") // ``で囲ってもOK
public class User {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    // t_user 1:n t_user_biko
    @OneToMany(mappedBy = "user")
    private List<UserBiko> bikos;

}
