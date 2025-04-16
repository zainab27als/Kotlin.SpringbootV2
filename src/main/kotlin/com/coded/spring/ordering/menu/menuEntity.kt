package com.coded.spring.ordering.menu


import jakarta.persistence.*

@Entity
@Table(name = "menu")
data class MenuEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String = "",

    val price: Double = 0.0
)