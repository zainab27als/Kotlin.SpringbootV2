package com.coded.spring.ordering.profiles

import com.coded.spring.ordering.UserEntity
import jakarta.persistence.*

@Entity
@Table(name = "profiles")
data class ProfileEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: UserEntity? = null,

    var firstName: String = "",
    var lastName: String = "",
    var phoneNumber: String = ""
)