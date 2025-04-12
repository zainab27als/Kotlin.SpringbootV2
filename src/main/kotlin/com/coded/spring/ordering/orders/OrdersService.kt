package com.coded.spring.ordering.orders

import com.coded.spring.ordering.TalabatRepository
import com.coded.spring.ordering.orders.entities.OrderEntity
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class OrdersService(
    private val orderRepository: OrderRepository,
    private val userRepository: TalabatRepository,
    private val objectMapper: ObjectMapper
) {
    fun createOrder(request: CreateOrderRequest): OrderEntity {
        val user = userRepository.findById(request.userId).orElseThrow()
        val itemsJson = objectMapper.writeValueAsString(request.items)

        val order = OrderEntity(
            user = user,
            restaurant = request.restaurant,
            items = itemsJson
        )

        return orderRepository.save(order)
    }
    fun listOrders(): List<OrderEntity> {
        return orderRepository.findAll()
    }
}
