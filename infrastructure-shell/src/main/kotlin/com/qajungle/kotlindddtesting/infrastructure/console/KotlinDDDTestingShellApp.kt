package com.qajungle.kotlindddtesting.infrastructure.console

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDDDTestingShellApp

fun main(args: Array<String>) {
  runApplication<KotlinDDDTestingShellApp>(*args)
}