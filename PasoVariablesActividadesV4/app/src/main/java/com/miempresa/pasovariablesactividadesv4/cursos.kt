package com.miempresa.pasovariablesactividadesv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_cursos.*

class cursos : AppCompatActivity() {
    var datosactividad01: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        val values = arrayOf(
            "Programacion en moviles",
            "Tecnologias emergentes",
            "Desarrollo de aplicaciones web",
            "Construccion y pruebas de software",
            "Desarrollo de aplicaciones empresariales"
        )

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, android.R.id.text1,
            values
        )

        listadecursos.adapter = adapter
        listadecursos.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val itemValue = listadecursos.getItemAtPosition(position) as String
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("parametro", itemValue)
                intent.putExtra("datosactividad01", datosactividad01)
                this.finish()
                startActivity(intent)
            }

        val bundle :Bundle ?=intent.extras
        if (bundle !=null){
            datosactividad01 = bundle.getString("seleccionados").toString()
        }
    }
}
