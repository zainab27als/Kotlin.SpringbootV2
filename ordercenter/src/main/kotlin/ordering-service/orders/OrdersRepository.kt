package `ordering-service`.orders

import org.springframework.data.jpa.repository.JpaRepository
import `ordering-service`.orders.OrderEntity

interface OrderRepository : JpaRepository<OrderEntity, Long>
