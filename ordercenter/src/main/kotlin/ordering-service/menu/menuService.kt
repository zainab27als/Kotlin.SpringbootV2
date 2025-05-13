package `ordering-service`.menu

import com.coded.spring.ordering.AppProperties
import org.springframework.stereotype.Service


@Service
class MenuService(
    private val menuRepository: MenuRepository,
    private val appProperties: AppProperties
) {

    fun getMenu(): List<MenuEntity> {
        val cached = menuCache["all"]
        val menu = if (cached != null) {
            println("Returning menu from cache")
            cached
        } else {
            println("Fetching menu from DB...")
            val dbMenu = menuRepository.findAll()
            menuCache["all"] = dbMenu
            dbMenu
        }

        return if (appProperties.festive.enabled) {
            menu.map { it.copy(price = (it.price * 0.8)) }
        } else {
            menu
        }
    }

    fun addMenuItem(request: MenuRequest): MenuEntity {
        val newItem = MenuEntity(name = request.name, price = request.price)
        val saved = menuRepository.save(newItem)

        menuCache.remove("all")
        println("Cleared menu cache after adding new item")

        return saved
    }
}