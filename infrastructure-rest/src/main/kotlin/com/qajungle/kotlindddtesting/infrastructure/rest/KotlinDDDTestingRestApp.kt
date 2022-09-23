package com.qajungle.kotlindddtesting.infrastructure.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDDDTestingRestApp

fun main(args: Array<String>) {
  runApplication<KotlinDDDTestingRestApp>(*args)
}