package com.coded.spring.ordering

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "app")
class AppProperties {
    lateinit var companyName: String
    var festive: Festive = Festive()

    class Festive {
        var enabled: Boolean = false
        var message: String = ""
    }
}
