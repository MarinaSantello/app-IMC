package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.senai.sp.jandira.imc20.model.User

class SignupActivity : AppCompatActivity() {

    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editWeight: EditText
    lateinit var editHeight: EditText
    lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // "definir conteúdo de vizualização": (comando para renderizar a tela criada no arquivo xml)
        setContentView(R.layout.activity_signup)

        supportActionBar!!.hide()

        // Instância dos componentes (views)
        editName = findViewById(R.id.editTextPersonName)
        editEmail = findViewById(R.id.editTextPersonEmail)
        editPassword = findViewById(R.id.editTextPersonPassword)
        editWeight = findViewById(R.id.editNumberWeight)
        editHeight = findViewById(R.id.editNumberHeight)
        buttonSave = findViewById(R.id.buttonSave)

        // Colocando 'click' no botão
        buttonSave.setOnClickListener {
            saveUser()
        }
    }

    private fun saveUser() {
        // Java User user = new User()
        val user = User()

        user.id = 1
        user.name = editName.text.toString()
        user.email = editEmail.text.toString()
        user.password = editPassword.text.toString()
        user.weight = editWeight.text.toString().toInt()
        user.height = editHeight.text.toString().toDouble()

        // Gravar o login do usuário no 'Shared' Preferences (armazenar no dispositívo)
            // Step 1 - obter uma instância do SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

            // Step 2 - criar um editor para o arquivo (instância)
        val editor = dados.edit()

            // Step 3 - inserir os dados no arquivo (instância)
        editor.putInt("ID", user.id)
        editor.putString("name", user.name)
        editor.putString("email", user.email)
        editor.putString("password", user.password)
        editor.putInt("Weight", user.weight)
        editor.putFloat("Height", user.height.toFloat())
        // Concluir a entrega dos dados : editor.commit()

        if (editor.commit()) {
            Toast.makeText(this, "Usuário gravado com sucesso.", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Ocorreu um erro na gravação.", Toast.LENGTH_SHORT).show()
        }
    }
}