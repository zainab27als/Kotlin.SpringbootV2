package `ordering-service`.menu

import `ordering-service`.menu.MenuEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<MenuEntity, Long>