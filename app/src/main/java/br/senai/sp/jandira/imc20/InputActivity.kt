package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.imc20.databinding.ActivityInputBinding
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding

class InputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        loadProfile()

        binding.buttonCalculate.setOnClickListener {
            exportData()
        }
    }

    private fun exportData() {
        val openResult = Intent(this, ResultActivity::class.java)
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        // enviar dados de uma activity para outra
        openResult.putExtra("peso", binding.editInputWeight.text.toString().toInt())

        val editor = dados.edit()
        editor.putInt("Weight", binding.editInputWeight.text.toString().toInt())

        if (binding.editInputHeight.text.isEmpty()) {
            openResult.putExtra("altura", dados.getFloat("Height", 0.0f).toDouble())
        } else {
            openResult.putExtra("altura", binding.editInputHeight.text.toString().toDouble())

            editor.putFloat("Height", binding.editInputHeight.text.toString().toFloat())
        }

        if (editor.commit()) {
            finish()
        } else {
            Toast.makeText(this, "Ocorreu um erro na gravação.", Toast.LENGTH_SHORT).show()
        }

        startActivity(openResult)
    }

    private fun loadProfile() {

        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textNameUser.text = dados.getString("name", "Nome não encontrado")
        binding.textEmailUser.text = dados.getString("email", "E-mail não encontrado")

        binding.textHeightValue.text = "${resources.getText(R.string.new_height)} ${dados.getFloat("Height", 0f)} m"
        binding.textWeightValue.text = "${resources.getText(R.string.new_weight)} ${dados.getInt("Weight", 0)} kg"
    }
}