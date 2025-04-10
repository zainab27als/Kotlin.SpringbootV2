package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Value
import jakarta.persistence.Column

@RestController
class TalabatController(
//    val talabatRepository: TalabatRepository,
//                               @Value("\${server-welcome-message}")
//                               val welcomeMessage: String
){

    @GetMapping("/welcome")
    fun welcomeToTalabat() =  "Hello! welcome to Talabat"}


