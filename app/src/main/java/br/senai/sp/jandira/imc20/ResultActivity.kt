package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.imc20.databinding.ActivityResultBinding
import br.senai.sp.jandira.imc20.utils.getBmi
import br.senai.sp.jandira.imc20.utils.getStatusBmi

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        // recuperar os valores que estão na 'Intent'
        val weight = intent.getIntExtra("peso", 0)
        val height = intent.getDoubleExtra("altura", 0.0)

        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        val imc = getBmi(weight, height)
        val bmi = String.format("%.2f", imc)
        binding.textResult.text = bmi.toString()
        binding.textViewStatus.text = getStatusBmi(imc, this)
    }
}