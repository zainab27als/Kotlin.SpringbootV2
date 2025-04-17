package com.coded.spring.ordering.profiles

import com.coded.spring.ordering.TalabatRepository
import org.springframework.web.bind.annotation.*
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails

@RestController
class ProfileController(
    private val talabatRepository: TalabatRepository,
    private val profileRepository: ProfileRepository
) {

    @PostMapping("/profile")
    fun createProfile(
        @RequestBody profileRequest: ProfileRequest,
        @AuthenticationPrincipal userDetails: UserDetails
    ): ProfileEntity {
        val user = talabatRepository.findByUsername(userDetails.username)
            ?: throw RuntimeException("User not found")

        val profile = ProfileEntity(
            user = user,
            firstName = profileRequest.firstName,
            lastName = profileRequest.lastName,
            phoneNumber = profileRequest.phoneNumber
        )

        return profileRepository.save(profile)
    }
}
data class ProfileRequest(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
)