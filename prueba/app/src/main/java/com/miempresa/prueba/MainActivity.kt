package com.miempresa.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun enviarNumeros(view: View) {
        val num1 = findViewById<EditText>(R.id.editTextNum1).text.toString().toInt()
        val num2 = findViewById<EditText>(R.id.editTextNum2).text.toString().toInt()

        val intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("numero1", num1)
        intent.putExtra("numero2", num2)


        startActivity(intent)
    }
}