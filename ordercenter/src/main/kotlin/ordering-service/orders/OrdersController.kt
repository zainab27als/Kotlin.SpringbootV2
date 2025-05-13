package `ordering-service`.orders

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

