package com.github.bkenn.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
/**
 * Created: Brian
 * Date:    8/14/2017
 */
@Entity
@Table(name = "greeter")
data class Greeter (@Id
                    @GeneratedValue
                    val id: Int = 0,
                    val message: String = "") {
        fun toFX() = GreeterFX (id = this.id, message = this.message)
}

class GreeterFX(id: Int = 0, message: String = "") {
        val idProperty = SimpleIntegerProperty(id)
        var id by idProperty

        val messageProperty = SimpleStringProperty(message)
        var message by messageProperty

        fun toTable() = Greeter (id = this.id, message = this.message)
}