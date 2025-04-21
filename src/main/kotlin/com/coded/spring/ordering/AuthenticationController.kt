package com.coded.spring.ordering

import org.springframework.security.authentication.*
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/authentication")
class AuthenticationController(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val jwtService: JwtService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: AuthenticationRequest): AuthenticationResponse {
        val authenticationToken = UsernamePasswordAuthenticationToken(request.username, request.password)
        val authentication = authenticationManager.authenticate(authenticationToken)

        if (authentication.isAuthenticated) {
            val userDetails = userDetailsService.loadUserByUsername(request.username)
            val token = jwtService.generateToken(userDetails.username)
            return AuthenticationResponse(token)
        } else {
            throw UsernameNotFoundException("Invalid login")
        }
    }
}

data class AuthenticationRequest(
    val username: String,
    val password: String
)

data class AuthenticationResponse(
    val token: String
)
