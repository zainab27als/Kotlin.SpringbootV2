package com.coded.spring.ordering.menu

import com.coded.spring.ordering.cache.menuHazelcastInstance

val menuCache = menuHazelcastInstance.getMap<String, List<MenuEntity>>("menu")
