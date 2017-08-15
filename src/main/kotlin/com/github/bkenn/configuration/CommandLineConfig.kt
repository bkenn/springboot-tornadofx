package com.github.bkenn.configuration

import com.github.bkenn.model.Greeter
import com.github.bkenn.repository.GreeterRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * Created: Brian
 * Date:    8/14/2017
 */
@Component
class CommandLineConfig: CommandLineRunner {
    val logger = LoggerFactory.getLogger(CommandLineConfig::class.java)

    @Autowired lateinit var greeterRepository: GreeterRepository

    override fun run(vararg p0: String?) {
        listOf(Greeter(message = "Hello, Message 1"), Greeter(message = "Hello, Message 2"),
                Greeter(message = "Hello, Message 3"), Greeter(message = "Hello, Message 4"))
                .map(greeterRepository::save)

        greeterRepository.findAll().forEach { logger.info("$it") }
    }
}