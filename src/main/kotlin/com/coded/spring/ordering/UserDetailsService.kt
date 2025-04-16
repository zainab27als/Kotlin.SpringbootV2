package com.coded.spring.ordering


import org.springframework.security.core.userdetails.*
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val talabatRepository: TalabatRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = talabatRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")

        return User.builder()
            .username(user.username)
            .password(user.password)
            .roles("USER")
            .build()
    }
}