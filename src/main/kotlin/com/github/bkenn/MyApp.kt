package com.github.bkenn

import com.github.bkenn.style.Styles
import com.github.bkenn.view.MainView
import javafx.application.Application
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import tornadofx.*
import kotlin.reflect.KClass

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("com.github.bkenn"))
class MyApp: App(MainView::class, Styles::class) {

    private lateinit var springContext: ConfigurableApplicationContext

    override fun init() {
        this.springContext = SpringApplication.run(this.javaClass)
        springContext.autowireCapableBeanFactory.autowireBean(this)

        FX.dicontainer = object: DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T {
                return springContext.getBean(type.java)
            }
        }
    }

    override fun stop() {
        super.stop()
        springContext.close()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(MyApp::class.java, *args)
        }
    }
}