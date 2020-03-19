package com.rogercw.eshop.inventory.vo;

/**
 * @author rogercw
 * @date 2019-12-18
 */
public class BaseResponse {

    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    private Integer status;
    private String message;

    public BaseResponse(String message) {
        this.message = message;
    }

    public BaseResponse(Integer status) {
        this.status = status;
    }

    public BaseResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
