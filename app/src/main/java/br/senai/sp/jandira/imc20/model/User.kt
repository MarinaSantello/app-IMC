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

    fun getBmi(): Double {
        return weight / height.pow(2)
    }

    fun getStatusBmi(): String {

        val bmi = getBmi();

        if (bmi <= 18.5) {
            return "Abaixo do peso."
        } else if (bmi > 18.5 && bmi < 25) {
            return "Peso ideal."
        } else if (bmi >= 25 && bmi < 30) {
            return "Levemente acima do peso."
        } else if (bmi >= 30 && bmi < 35) {
            return "Obesidade grau I."
        } else if (bmi >= 35 && bmi < 40) {
            return "Obesidade grau II."
        } else {
            return "Obesidade grau III."
        }
    }
}