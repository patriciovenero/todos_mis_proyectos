package com.miempresa.pasovariablesactividadesv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtseleccionados.isFocusable = false

        val values = arrayOf(
            "juegos",
            "aplicaciones",
            "cursos",
            "profesores",
            "cerrar"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,android.R.id.text1,
            values
        )

        lista.adapter = adapter

        lista.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val itemPosition = position
                val itemvalue = lista.getItemAtPosition(position) as String
                val seleccionados = txtseleccionados.text.toString()
                when(itemvalue) {
                    "juegos" -> {
                        val intent = Intent(this, juegos::class.java)
                        intent.putExtra("seleccionados",seleccionados)
                        startActivity(intent)
                    }
                    "aplicaciones" -> {
                        val intent = Intent(this, aplicaciones::class.java)
                        intent.putExtra("seleccionados",seleccionados)
                        startActivity(intent)
                    }
                    "cursos" -> {
                        val intent = Intent(this, cursos::class.java)
                        intent.putExtra("seleccionados",seleccionados)
                        startActivity(intent)
                    }
                    "profesores" -> {
                        val intent = Intent(this, profesores::class.java)
                        intent.putExtra("seleccionados",seleccionados)
                        startActivity(intent)
                    }
                    "cerrar" -> {
                        AlertDialog.Builder(this)
                            .setTitle("Cerrar aplicación")
                            .setMessage("¿Estás seguro que deseas cerrar la aplicación?")
                            .setPositiveButton("Sí") { _, _ ->
                                finishAffinity()

                            }
                            .setNegativeButton("No", null)
                            .show()

                    }
                    else -> {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("seleccionados",seleccionados)
                        startActivity(intent)
                    }
                }
            }


        val bundle :Bundle ?=intent.extras
        if (bundle !=null){
            val recibidos = bundle.getString("parametro").toString()
            val datosactividad01 = bundle.getString("datosactividad01").toString()
            txtseleccionados.setText(datosactividad01+recibidos+"\n")
        }
    }
}