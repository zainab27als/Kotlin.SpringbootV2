package `ordering-service`

import org.springframework.web.bind.annotation.*
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails

@RestController
class TalabatController(
    private val talabatRepository: TalabatRepository,
    private val passwordEncoder: PasswordEncoder,
    private val appProperties: AppProperties
) {

    @PostMapping("/clients")
    fun clients(@RequestBody request: ClientsRequest): UserEntity {
        val encodedPassword = passwordEncoder.encode(request.password)
        return talabatRepository.save(
            UserEntity(
                name = request.name,
                username = request.username,
                password = encodedPassword
            )
        )
    }

    @PostMapping("/order")
    fun submitOrder(
        @RequestBody request: OrderRequest,
        @AuthenticationPrincipal user: UserDetails
    ): String {
        return "Order received from ${user.username} for items: ${request.items.joinToString(", ")}"
    }
}

data class ClientsRequest(
    val name: String,
    val username: String,
    val password: String
)

data class OrderRequest(
    val items: List<String>
)

data class MenuItem(
    val name: String,
    val price: Double
)
