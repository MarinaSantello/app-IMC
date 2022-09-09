package br.senai.sp.jandira.imc20.model

import kotlin.math.pow

class User {

    // Java: private int id;
    // Kotlin (tipagem explícita: opcional)
    var id: Int = 0
    var name: String = ""
    var email: String = ""
    var password: String = ""
    var weight: Int = 0
    var height: Double = 0.0

}