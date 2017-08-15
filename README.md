Spring Boot - TornadoFX

This is an example application. The goal is to demonstrate the basics of combining
the benefit of new technologies, such as TornadoFX and FXLauncher, with older technologies 
as Spring Boot. 

````bash
 -root
    -src
        -main
            -kotlin
                -com/github/bkenn
                    -configuration
                        CommandLineConfig.kt
                    -model
                        Greeter.kt
                        GreeterFX.kt
                    -repository
                        GreeterRepository.kt
                    -style
                        Styles.kt
                    -view
                        MainView.kt
                        MainController.kt
                    MyApp.kt
    .gitignore
    build.gradle
    README.md
````

With Spring Boot it is necessary to start the framework as the FX Application thread is revving up.
In the MyApp.kt file, we must place these hooks in during the starting phase of the application. TornadoFX
has its own dependency injection framework, but a benefit of the framework is that any DI framework 
can be used in conjunction. The wiring of Spring Boot should occur in the init() phase of FX Application start up phase.
This code shows that spring framework will use the MyApp class as the entry point for component scanning. and the spring
context will be set to an outside variable for later use.


````bash
    override fun init() {
        this.springContext = SpringApplication.run(this.javaClass)
        springContext.autowireCapableBeanFactory.autowireBean(this)

        FX.dicontainer = object: DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T {
                return springContext.getBean(type.java)
            }
        }
    }
````

It is important for the spring framework to know when to properly shutdown.
In the stop() hook for the JavaFX Application, this is the appropriate place to 
notify spring when to shutdown.
````bash
        override fun stop() {
            super.stop()
            springContext.close()
        }
````

Not really sure as to why these lines are important. I saw this from another application.
So we launch the JavaFX Application thread from a static main method. Why? I am not sure. 
My guess it allows for java to identify the main point of startup for this application.

````bash
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(MyApp::class.java, *args)
        }
    }
````

This link is of a repository that I heavily used to understand
 third-party DI usage in the TornadoFX framework.  https://github.com/sedovalx/spring-boot-tornadofx.