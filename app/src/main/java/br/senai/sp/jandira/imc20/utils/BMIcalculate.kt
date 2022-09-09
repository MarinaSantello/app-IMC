package br.senai.sp.jandira.imc20.utils

import android.content.Context
import br.senai.sp.jandira.imc20.R
import kotlin.math.pow

fun getBmi(weight: Int, height: Double): Double {
    return weight / height.pow(2)
}

fun getStatusBmi(bmi: Double, context: Context): String {

    if (bmi <= 18.5) {
        return context.getString(R.string.level01)
    } else if (bmi > 18.5 && bmi < 25) {
        return context.getString(R.string.level02)
    } else if (bmi >= 25 && bmi < 30) {
        return context.getString(R.string.level03)
    } else if (bmi >= 30 && bmi < 35) {
        return context.getString(R.string.level04)
    } else if (bmi >= 35 && bmi < 40) {
        return context.getString(R.string.level05)
    } else {
        return context.getString(R.string.level06)
    }
}