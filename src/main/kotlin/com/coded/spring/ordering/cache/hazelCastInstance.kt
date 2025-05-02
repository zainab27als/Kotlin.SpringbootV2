package com.coded.spring.ordering.cache

import com.hazelcast.config.Config
import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance

val menuCacheConfig = Config("menu-cache").apply {
    getMapConfig("menu").timeToLiveSeconds = 60
}

val menuHazelcastInstance: HazelcastInstance = Hazelcast.newHazelcastInstance(menuCacheConfig)
