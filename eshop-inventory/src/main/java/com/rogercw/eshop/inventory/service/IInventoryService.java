package com.rogercw.eshop.inventory.service;

import com.rogercw.eshop.inventory.entity.InventoryEntity;

public interface IInventoryService {

    /**
     * 更新数据库库存信息
     * @param inventoryEntity
     */
    void updateInventory(InventoryEntity inventoryEntity);

    /**
     * 从数据库中获取库存信息
     * @param productId
     * @return
     */
    InventoryEntity getInventoryByProductId(Long productId);

    /**
     * 将库存信息保存到Redis缓存中
     * @param inventoryEntity
     */
    void setCachedInventory(InventoryEntity inventoryEntity);

    /**
     * 删除缓存中到库存信息
     * @param inventoryEntity
     */
    void removeCachedinventory(InventoryEntity inventoryEntity);

    /**
     * 从缓存中读取库存信息
     * @param productId
     * @return
     */
    InventoryEntity getFromCached(Long productId);
}
