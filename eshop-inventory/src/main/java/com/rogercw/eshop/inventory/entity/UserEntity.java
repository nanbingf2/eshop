package com.rogercw.eshop.inventory.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "eshop_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String sex;

    private String phone;
}
