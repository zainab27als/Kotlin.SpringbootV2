package com.coded.spring.ordering.menu

import com.coded.spring.ordering.cache.menuHazelcastInstance
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service


@Service
class MenuService(private val menuRepository: MenuRepository) {

    fun getMenu(): List<MenuEntity> {
        val cached = menuCache["all"]
        if (cached != null) {
            println("Returning menu from cache")
            return cached
        }
        println("Fetching menu from DB...")
        val menu = menuRepository.findAll()
        menuCache["all"] = menu
        return menu
    }

    fun addMenuItem(request: MenuRequest): MenuEntity {
        val newItem = MenuEntity(name = request.name, price = request.price)
        val savedItem = menuRepository.save(newItem)

        menuCache.remove("all")
        println("Cleared menu cache after adding new item")

        return savedItem
    }

}