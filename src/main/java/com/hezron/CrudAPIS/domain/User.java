package com.hezron.CrudAPIS.domain;

import lombok.Data;

import javax.persistence.*;
import java.security.Timestamp;


@Entity
@Data
@Table(name = "tbl_Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "username",nullable = false, unique = true)
    private String username;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "active",nullable = false)
    private int active;

    @Column(name = "created_at",nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at",nullable = false)
    private Timestamp updatedAt;

}
