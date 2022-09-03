package com.qajungle.backendddtesting.infrastructure.console.config

import org.jline.utils.AttributedString
import org.jline.utils.AttributedStyle
import org.springframework.shell.jline.PromptProvider
import org.springframework.stereotype.Component

@Component
class CustomPromptProvider : PromptProvider {
  override fun getPrompt(): AttributedString {
    return AttributedString(
      "backend-ddd-testing:>",
      AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW)
    )
  }
}