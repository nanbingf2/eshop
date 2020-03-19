package com.rogercw.eshop.inventory.mapper;

import com.rogercw.eshop.inventory.entity.InventoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InventoryMapper extends tk.mybatis.mapper.common.Mapper<InventoryEntity> {

    /**
     * 更新产品库存数量
     * @param productId
     * @param quantity
     */
    void updateProductQuantity(@Param("productId") Long productId, @Param("quantity") Integer quantity);

    /**
     * 通过产品Id获取库存对象
     * @param productId
     * @return
     */
    InventoryEntity findByProductId(@Param("productId") Long productId);


}
