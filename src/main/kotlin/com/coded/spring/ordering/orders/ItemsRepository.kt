package com.coded.spring.ordering.orders

import org.springframework.data.jpa.repository.JpaRepository
import com.coded.spring.ordering.orders.ItemEntity

interface ItemsRepository : JpaRepository<ItemEntity, Long>

