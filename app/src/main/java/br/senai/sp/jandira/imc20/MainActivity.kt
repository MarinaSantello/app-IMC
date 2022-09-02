package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import br.senai.sp.jandira.imc20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.textSignup.setOnClickListener {
            val openSignupActivity = Intent(this, SignupActivity::class.java)

            startActivity(openSignupActivity)
        }

        binding.buttonLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        if(validar()) {
            val email = binding.editTextEmailAddress.text.toString()
            val pass = binding.editTextPassword.text.toString()

            // abrindo o SharedPreferences
            val dados = getSharedPreferences("dados", MODE_PRIVATE)

            val emailSP = dados.getString("email", "E-mail não encontrado")
            val passSP = dados.getString("password", "Senha não encontrada")

            // verificação dos dados de altenticação
            if (email == emailSP && pass == passSP) {
                val openCalculate = Intent(this, InputActivity::class.java)

                startActivity(openCalculate)
            }
            else {
                Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validar(): Boolean {
        if (binding.editTextEmailAddress.text.isEmpty()) {
            binding.editTextEmailAddress.error = "E-mail is require."
            return false
        }

        if (binding.editTextPassword.text.isEmpty()) {
            binding.editTextPassword.error = "Password is require."
            return false
        }

        return true
    }
}