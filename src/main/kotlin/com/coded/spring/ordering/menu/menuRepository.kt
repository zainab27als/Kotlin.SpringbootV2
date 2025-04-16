package com.coded.spring.ordering.menu

import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : JpaRepository<MenuEntity, Long>