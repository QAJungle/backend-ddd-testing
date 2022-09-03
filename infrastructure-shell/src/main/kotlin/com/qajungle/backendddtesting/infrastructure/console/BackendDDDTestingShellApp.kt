package com.qajungle.backendddtesting.infrastructure.console

import org.jline.utils.AttributedString
import org.jline.utils.AttributedStyle
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.shell.jline.PromptProvider

@SpringBootApplication
class BackendDDDTestingShellApp

fun main(args: Array<String>) {
  runApplication<BackendDDDTestingShellApp>(*args)
}