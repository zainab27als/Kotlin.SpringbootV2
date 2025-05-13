package `ordering-service`.profiles

import jakarta.inject.Named
import `ordering-service`.profiles.ProfileEntity
import org.springframework.data.jpa.repository.JpaRepository

@Named
interface ProfileRepository : JpaRepository<ProfileEntity, Long>
