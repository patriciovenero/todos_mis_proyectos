package com.miempresa.serviciowebv4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class FormularioActivity : AppCompatActivity() {
    private lateinit var txtUsuario: EditText
    private lateinit var txtClave: EditText
    private lateinit var txtEstado: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        txtUsuario = findViewById(R.id.txtUsuario)
        txtClave = findViewById(R.id.txtClave)
        txtEstado = findViewById(R.id.txtEstado)

        val btnRegistrar: Button = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            registrarUsuario()
        }
    }

    private fun registrarUsuario() {
        val nuevoUsuario = txtUsuario.text.toString()
        val nuevaClave = txtClave.text.toString()
        val nuevoEstado = txtEstado.text.toString()

        val queue = Volley.newRequestQueue(this)
        val url = "http://192.168.0.117:3000/usuarios" // Reemplaza con la URL de tu servidor

        val stringRequest = object : StringRequest(Method.POST, url,
            Response.Listener { response ->
                Toast.makeText(
                    applicationContext,
                    "Usuario registrado correctamente",
                    Toast.LENGTH_LONG
                ).show()
                finish() // Cerrar la actividad después de registrar el usuario
            },
            Response.ErrorListener { error ->
                Toast.makeText(
                    applicationContext,
                    "Error al registrar el usuario: ${error.message}",
                    Toast.LENGTH_LONG
                ).show()
                Log.e("Registrar", error.toString())
            }) {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["usuario"] = nuevoUsuario
                params["clave"] = nuevaClave
                params["estado"] = nuevoEstado
                return params
            }
        }

        queue.add(stringRequest)
    }
}
