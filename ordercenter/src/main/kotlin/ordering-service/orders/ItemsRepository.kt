package `ordering-service`.orders

import org.springframework.data.jpa.repository.JpaRepository
import `ordering-service`.orders.ItemEntity

interface ItemsRepository : JpaRepository<ItemEntity, Long>

