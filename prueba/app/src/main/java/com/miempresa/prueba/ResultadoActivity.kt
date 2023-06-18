package com.miempresa.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val num1 = intent.getIntExtra("numero1", 0)
        val num2 = intent.getIntExtra("numero2", 0)

        val suma = num1 + num2
        val resta = num1 - num2
        val multiplicacion = num1 * num2
        val division = if (num2 != 0) num1 / num2 else 0

        findViewById<TextView>(R.id.textViewSuma).text = "Suma: $suma"
        findViewById<TextView>(R.id.textViewResta).text = "Resta: $resta"
        findViewById<TextView>(R.id.textViewMultiplicacion).text = "Multiplicación: $multiplicacion"
        findViewById<TextView>(R.id.textViewDivision).text = "División: $division"
    }
}