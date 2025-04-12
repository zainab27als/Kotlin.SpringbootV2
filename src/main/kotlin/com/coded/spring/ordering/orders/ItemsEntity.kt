package com.coded.spring.ordering.orders

import com.coded.spring.ordering.orders.entities.OrderEntity
import jakarta.persistence.*

@Entity
@Table(name = "items")
data class ItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,
    val quantity: Int,

    @ManyToOne
    @JoinColumn(name = "order_id")
    val order: OrderEntity
)

