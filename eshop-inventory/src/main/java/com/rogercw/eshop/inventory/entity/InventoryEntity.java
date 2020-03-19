package com.rogercw.eshop.inventory.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "eshop_inventory")
@Data
public class InventoryEntity implements Serializable {

    private Long id;

    private Long productId;

    private Integer quantity;
}
