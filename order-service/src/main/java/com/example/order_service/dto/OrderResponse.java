package com.example.order_service.dto;

public class OrderResponse {

    private Long orderId;
    private String product;
    private Long userId;
    private UserDTO user;

    public OrderResponse() {
    }

    public OrderResponse(Long orderId, String product, Long userId, UserDTO user) {
        this.orderId = orderId;
        this.product = product;
        this.userId = userId;
        this.user = user;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
