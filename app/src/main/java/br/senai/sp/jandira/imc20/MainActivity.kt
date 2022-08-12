package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textSignup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        textSignup = findViewById(R.id.text_signup)

        textSignup.setOnClickListener {
            val openSignupActivity = Intent(this, SignupActivity::class.java)

            startActivity(openSignupActivity)
        }
    }
}