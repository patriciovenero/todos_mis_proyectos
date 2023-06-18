package com.miempresa.ejerciciocontroles2v4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    fun sumar(num1:Double,num2:Double):Double{
        return num1 + num2
    }
    fun restar(num1:Double,num2:Double):Double{
        return num1 - num2
    }
    fun producto(num1:Double,num2:Double):Double{
        return num1 * num2
    }
    fun divicion(num1:Double,num2:Double): Any {
        if (num2 == 0.0) {
            return "No es posible dividir por cero" // División por cero, devolver nulo
        }
        return num1 / num2
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var radioSuma = findViewById<RadioButton>(R.id.radioSuma)
        var radioResta = findViewById<RadioButton>(R.id.radioResta)
        var radioProducto = findViewById<RadioButton>(R.id.radioProducto)
        var radioDivicion = findViewById<RadioButton>(R.id.radioDivision)
        var txtValor1 = findViewById<EditText>(R.id.txtValor1)
        var txtValor2 = findViewById<EditText>(R.id.txtValor2)
        var txtResultado = findViewById<EditText>(R.id.txtResultado)

        radioSuma.setOnClickListener(){
            var numero1 = txtValor1.text.toString().toDouble()
            var numero2 = txtValor2.text.toString().toDouble()
            var respuesta = (sumar(numero1,numero2)).toString()
            txtResultado.setText(respuesta)
        }

        radioResta.setOnClickListener(){
            var numero1 = txtValor1.text.toString().toDouble()
            var numero2 = txtValor2.text.toString().toDouble()
            var respuesta = (restar(numero1,numero2)).toString()
            txtResultado.setText(respuesta)
        }
        radioProducto.setOnClickListener(){
            var numero1 = txtValor1.text.toString().toDouble()
            var numero2 = txtValor2.text.toString().toDouble()
            var respuesta = (producto(numero1,numero2)).toString()
            txtResultado.setText(respuesta)
        }
        radioDivicion.setOnClickListener(){
            var numero1 = txtValor1.text.toString().toDouble()
            var numero2 = txtValor2.text.toString().toDouble()
            var respuesta = (divicion(numero1,numero2)).toString()
            txtResultado.setText(respuesta)
        }
    }
}