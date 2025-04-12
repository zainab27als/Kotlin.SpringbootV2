package com.coded.spring.ordering.orders

import com.coded.spring.ordering.orders.entities.OrderEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrdersController(
    private val ordersService: OrdersService
) {
    @PostMapping
    fun createOrder(@RequestBody request: CreateOrderRequest): OrderEntity {
        return ordersService.createOrder(request)
    }
    @GetMapping("/v1/list")
    fun listOrders(): List<OrderEntity> {
        return ordersService.listOrders()
    }
}

