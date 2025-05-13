package com.coded.spring.`welcome-service`

import com.coded.spring.`welcome-service`.AppProperties
import org.springframework.web.bind.annotation.*
import org.springframework.security.crypto.password.PasswordEncoder

@RestController
class TalabatController(
    private val talabatRepository: TalabatRepository,
    private val passwordEncoder: PasswordEncoder,
    private val appProperties: AppProperties
) {

    @GetMapping("/welcome")
    fun welcomeToTalabat(): String {
        return if (appProperties.festive.enabled) {
            appProperties.festive.message
        } else {
            "Welcome to Online Ordering by ${appProperties.companyName}"
        }
    }