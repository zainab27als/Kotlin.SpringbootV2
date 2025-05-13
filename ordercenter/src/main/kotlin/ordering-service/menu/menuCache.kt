package `ordering-service`.menu

import `ordering-service`.cache.menuHazelcastInstance

val menuCache = menuHazelcastInstance.getMap<String, List<MenuEntity>>("menu")
