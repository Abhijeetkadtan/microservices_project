    package com.example.order_service.service;

    import com.example.order_service.client.UserClient;
    import com.example.order_service.dto.OrderResponse;
    import com.example.order_service.dto.UserDTO;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Service;

    @Slf4j
    @Service
    public class OrderService {

        private final UserClient userClient;

        public OrderService(UserClient userClient) {
            this.userClient = userClient;
        }

        public OrderResponse getOrderWithUser(Long orderId) {

            Long userId = 1L;
            String product = "Laptop";

            log.info("Fetching order details for orderId={}, userId={}", orderId, userId);

            try {
                UserDTO user = userClient.getUserById(userId);

                log.info("Successfully fetched user data for userId={}", userId);

                return new OrderResponse(orderId, product, userId, user);

            } catch (Exception ex) {
                log.error(
                        "Failed to fetch user data for orderId={}, userId={}",
                        orderId,
                        userId,
                        ex
                );
                throw ex;
            }
        }
    }
