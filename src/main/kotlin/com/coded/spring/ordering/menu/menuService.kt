package com.coded.spring.ordering.menu

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class MenuService(private val menuRepository: MenuRepository) {

    @Cacheable("menu")
    fun getMenu(): List<MenuEntity> {
        println("Fetching menu from DB...")
        return menuRepository.findAll()
    }

    fun addMenuItem(request: MenuRequest): MenuEntity {
        val newItem = MenuEntity(name = request.name, price = request.price)
        return menuRepository.save(newItem)
    }

}