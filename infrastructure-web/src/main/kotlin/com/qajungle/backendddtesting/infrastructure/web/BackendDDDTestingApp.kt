package com.qajungle.backendddtesting.infrastructure.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendDDDTestingApp

fun main(args: Array<String>) {
  runApplication<BackendDDDTestingApp>(*args)
}