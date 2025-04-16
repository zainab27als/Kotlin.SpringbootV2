package com.coded.spring.ordering

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.password.PasswordEncoder

@RestController
class TalabatController(
    private val talabatRepository: TalabatRepository,
    private val passwordEncoder: PasswordEncoder,
    @Value("\${server-welcome-message}")
    val welcomeMessage: String
) {

    @GetMapping("/welcome")
    fun welcomeToTalabat() = "Hello! $welcomeMessage"

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
}

data class ClientsRequest(
    val name: String,
    val username: String,
    val password: String)
//    val restaurant: String,
//    val items:List<String>)




