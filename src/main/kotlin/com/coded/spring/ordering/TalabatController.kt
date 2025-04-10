package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Value


@RestController
class TalabatController(
    val talabatRepository: TalabatRepository,
                               @Value("\${server-welcome-message}")
                               val welcomeMessage: String
) {

    @GetMapping("/welcome")
    fun welcomeToTalabat() = "Hello! $welcomeMessage"

    @PostMapping("/clients")
    //in memory method to save the information in a list
//fun order( @RequestBody request: OrderRequest) = "Hi ${request.name}, thank you for placing an order from ${request.restaurant} containing the following items: ${request.items} !"
    fun clients(@RequestBody request: ClientsRequest) = talabatRepository.save(UserEntity(name = request.name))

}

data class ClientsRequest(
    val name: String)
//    val restaurant: String,
//    val items:List<String>)




