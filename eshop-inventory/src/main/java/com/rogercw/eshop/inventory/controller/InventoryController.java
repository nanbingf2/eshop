package com.rogercw.eshop.inventory.controller;

import com.rogercw.eshop.inventory.entity.InventoryEntity;
import com.rogercw.eshop.inventory.request.InventoryDBUpdateRequest;
import com.rogercw.eshop.inventory.request.Request;
import com.rogercw.eshop.inventory.service.IInventoryService;
import com.rogercw.eshop.inventory.service.RequestAsyncProcessService;
import com.rogercw.eshop.inventory.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private RequestAsyncProcessService requestAsyncProcessService;
    @Autowired
    private IInventoryService inventoryService;

    @PostMapping("updateInventory")
    public BaseResponse updateInventory(@RequestBody InventoryEntity inventoryEntity){
        BaseResponse baseResponse;
        try {
            //创建请求处理对象
            Request request = new InventoryDBUpdateRequest(inventoryEntity);
            requestAsyncProcessService.process(request);
            baseResponse = new BaseResponse(BaseResponse.SUCCESS);
        } catch (Exception e) {
            baseResponse = new BaseResponse(BaseResponse.FAILURE);
            e.printStackTrace();
        }
        return baseResponse;
    }
}
