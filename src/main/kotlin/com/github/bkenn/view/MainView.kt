package com.github.bkenn.view

import com.github.bkenn.model.Greeter
import com.github.bkenn.model.GreeterFX
import com.github.bkenn.repository.GreeterRepository
import com.github.bkenn.style.Styles
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("Hello TornadoFX. Again! And Again") {
    val controller: MainController by inject()

    init {
        controller.loadAll()
    }

    override val root = vbox {
        alignment = Pos.CENTER
        label(title) {
            addClass(Styles.heading)
        }
        tableview(controller.greetings) {
            smartResize()
            column("ID", GreeterFX::idProperty)
            column("Message", GreeterFX::messageProperty)
        }
    }
}

class MainController: Controller() {
    val greeterRepository: GreeterRepository by di()
    val greetings = mutableListOf<GreeterFX>().observable()

    fun loadAll() {
        val greets = greeterRepository.findAll().map(Greeter::toFX)
        greetings.setAll(greets)
    }
}