package com.coded.spring.ordering.menu

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/menu")
class MenuController(private val menuService: MenuService) {

    @GetMapping
    fun getMenu(): List<MenuEntity> = menuService.getMenu()

    @PostMapping
    fun addMenuItem(@RequestBody request: MenuRequest): MenuEntity {
        return menuService.addMenuItem(request)
    }
}

data class MenuRequest(
    val name: String,
    val price: Double
)

