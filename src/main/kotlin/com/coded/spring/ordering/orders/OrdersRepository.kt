package com.coded.spring.ordering.orders

import org.springframework.data.jpa.repository.JpaRepository
import com.coded.spring.ordering.orders.entities.OrderEntity

interface OrderRepository : JpaRepository<OrderEntity, Long>
