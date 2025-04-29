package com.coded.spring.ordering

import jakarta.inject.Named
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository

interface TalabatRepository : JpaRepository<UserEntity, Long>{
    fun findByUsername(username: String): UserEntity?
}

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    @Column(unique = true)
    var username: String,

    var password: String
) {
    constructor() : this(null, "", "","")
}