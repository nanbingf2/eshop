package com.rogercw.eshop.inventory.service.impl;

import com.rogercw.eshop.inventory.dao.RedisDao;
import com.rogercw.eshop.inventory.entity.InventoryEntity;
import com.rogercw.eshop.inventory.mapper.InventoryMapper;
import com.rogercw.eshop.inventory.service.IInventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rogercw
 * @date 2019-12-16
 */
@Service
@Slf4j
public class InventoryServiceImpl implements IInventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;
    @Autowired
    private RedisDao redisDao;

    private static String prefix_redis = "product:inventory:";

    @Override
    public void updateInventory(InventoryEntity inventoryEntity) {
        inventoryMapper.updateProductQuantity(inventoryEntity.getProductId(), inventoryEntity.getQuantity());
        log.info("更新数据库中的库存信息成功");
    }

    @Override
    public InventoryEntity getInventoryByProductId(Long productId) {
        InventoryEntity inventoryEntity = inventoryMapper.findByProductId(productId);
        log.info("从数据库中获取库存信息");
        return inventoryEntity;
    }

    @Override
    public void setCachedInventory(InventoryEntity inventoryEntity) {
        String key = prefix_redis + inventoryEntity.getProductId();
        redisDao.set(key, inventoryEntity.getQuantity().toString());
        log.info("向缓存中写入数据");
    }

    @Override
    public void removeCachedinventory(InventoryEntity inventoryEntity) {
        redisDao.delete(prefix_redis + inventoryEntity.getProductId());
        log.info("删除缓存中的数据");
    }

    @Override
    public InventoryEntity getFromCached(Long productId) {
        String data = redisDao.get(prefix_redis + productId);
        return null;
    }
}
