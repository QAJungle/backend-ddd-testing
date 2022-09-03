package com.qajungle.backendddtesting.infrastructure.console

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendDDDTestingShellApp

fun main(args: Array<String>) {
  runApplication<BackendDDDTestingShellApp>(*args)
}