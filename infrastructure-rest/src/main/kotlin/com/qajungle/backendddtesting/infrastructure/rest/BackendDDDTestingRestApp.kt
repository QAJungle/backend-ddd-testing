package com.qajungle.backendddtesting.infrastructure.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendDDDTestingRestApp

fun main(args: Array<String>) {
  runApplication<BackendDDDTestingRestApp>(*args)
}