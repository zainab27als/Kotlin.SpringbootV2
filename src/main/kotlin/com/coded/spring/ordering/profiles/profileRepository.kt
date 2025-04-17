package com.coded.spring.ordering.profiles

import jakarta.inject.Named
import org.springframework.data.jpa.repository.JpaRepository

@Named
interface ProfileRepository : JpaRepository<ProfileEntity, Long>
