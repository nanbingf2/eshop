package com.rogercw.eshop.inventory.request;

import com.rogercw.eshop.inventory.entity.InventoryEntity;
import com.rogercw.eshop.inventory.mapper.InventoryMapper;
import com.rogercw.eshop.inventory.service.IInventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rogercw
 * @date 2019-12-16
 * 库存数据库更新请求处理对象
 */
@Slf4j
public class InventoryDBUpdateRequest implements Request {

    @Autowired
    private IInventoryService inventoryService;
    private InventoryEntity inventoryEntity;

    public InventoryDBUpdateRequest(InventoryEntity inventoryEntity) {
        this.inventoryEntity = inventoryEntity;
    }

    /**
     * 更新数据库时的处理方法：
     * 这里采取先删除缓存，再更新数据库的步骤
     */
    @Override
    public void process() {
        log.info("-------数据库更新开始，商品Id="+inventoryEntity.getProductId());
        //删除缓存中的数据
        inventoryService.removeCachedinventory(inventoryEntity);
        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //更新数据库中的数据
        inventoryService.updateInventory(inventoryEntity);
    }

    @Override
    public Long getProductId() {
        return inventoryEntity.getProductId();
    }

    @Override
    public Boolean isForceReferensh() {
        return false;
    }
}
