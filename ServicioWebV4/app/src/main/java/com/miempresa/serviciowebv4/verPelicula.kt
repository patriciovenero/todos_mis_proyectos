package com.miempresa.serviciowebv4

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_ver_pelicula.*

class verPelicula : AppCompatActivity() {

    private var isEditing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_pelicula)

        val categorias = arrayOf("Drama", "Comedia","Anime")
        cmbcategoria.setAdapter(
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,categorias
            )
        )
        val bundle:Bundle ?= intent.extras
        if (bundle!=null){
            txtid.setText(bundle.getString("id").toString())
            txtnombre.setText(bundle.getString("nombre").toString())
            when(bundle.getString("categoria").toString()){
                "Drama" -> cmbcategoria.setSelection(0)
                "Comedia"-> cmbcategoria.setSelection(1)
                "Anime" -> cmbcategoria.setSelection(2)
            }
            txtduracion.setText(bundle.getString("duracion".toString()))
            txtimagen.setText(bundle.getString("imagen").toString())

            btnguardar.isEnabled = false
            btneliminar.isEnabled = true
            isEditing = true
        } else {
            btnguardar.isEnabled = true
            btneliminar.isEnabled = false
            isEditing = false
        }

        // Habilitar el botón de guardar al realizar cambios en los campos de entrada
        txtnombre.addTextChangedListener { enableGuardarButton() }
        txtduracion.addTextChangedListener { enableGuardarButton() }
        txtimagen.addTextChangedListener { enableGuardarButton() }

        btnguardar.setOnClickListener(){
            if (isEditing) {
                editarPelicula()
            } else {
                agregarPelicula()
            }
        }
        btneliminar.setOnClickListener(){
            eliminarPelicula()
        }

    }

    private fun enableGuardarButton() {
        btnguardar.isEnabled = true
    }

    fun agregarPelicula() {
        AsyncTask.execute {

            val id = txtid.text.toString()
            val nombre = txtnombre.text.toString()
            val categoria = cmbcategoria.selectedItem.toString()
            val duracion = txtduracion.text.toString()
            val imagen = txtimagen.text.toString()

            val queue = Volley.newRequestQueue(this)
            var url = getString(R.string.urlAPI) + "/peliculas"
            val postRequest: StringRequest = object : StringRequest(
                Request.Method.POST, url,
                Response.Listener { response -> // response
                    Toast.makeText(
                        applicationContext,
                        "Registro agregado correctamente",
                        Toast.LENGTH_LONG
                    ).show()
                    // Deshabilitar el botón de guardar después de guardar los datos
                    btnguardar.isEnabled = false
                },
                Response.ErrorListener { response ->// error
                    Toast.makeText(
                        applicationContext,
                        "Se produjo un error al guardar los datos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            ) {
                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> =
                        HashMap()
                    params["id"] = id
                    params["nombre"] = nombre
                    params["categoria"] = categoria
                    params["duracion"] = duracion
                    params["imagen"] = imagen
                    return params
                }
            }
            queue.add(postRequest)

        }
    }

    fun editarPelicula() {
        AsyncTask.execute {

            val id = txtid.text.toString()
            val nombre = txtnombre.text.toString()
            val categoria = cmbcategoria.selectedItem.toString()
            val duracion = txtduracion.text.toString()
            val imagen = txtimagen.text.toString()

            val queue = Volley.newRequestQueue(this)
            var url = getString(R.string.urlAPI) + "/peliculas/" + id
            val putRequest: StringRequest = object : StringRequest(
                Request.Method.PUT, url,
                Response.Listener { response -> // response
                    Toast.makeText(
                        applicationContext,
                        "Registro actualizado correctamente",
                        Toast.LENGTH_LONG
                    ).show()
                    // Deshabilitar el botón de guardar después de guardar los datos
                    btnguardar.isEnabled = false
                },
                Response.ErrorListener { response ->// error
                    Toast.makeText(
                        applicationContext,
                        "Se produjo un error al actualizar los datos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            ) {
                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> =
                        HashMap()
                    params["id"] = id
                    params["nombre"] = nombre
                    params["categoria"] = categoria
                    params["duracion"] = duracion
                    params["imagen"] = imagen
                    return params
                }
            }
            queue.add(putRequest)

        }
    }

    fun eliminarPelicula() {
        AsyncTask.execute {
            val id = txtid.text.toString()

            val queue = Volley.newRequestQueue(this)
            var url = getString(R.string.urlAPI) + "/peliculas/" + id
            val deleteRequest: StringRequest = object : StringRequest(
                Request.Method.DELETE, url,
                Response.Listener { response -> // response
                    Toast.makeText(
                        applicationContext,
                        "Registro eliminado correctamente",
                        Toast.LENGTH_LONG
                    ).show()
                    // Deshabilitar el botón de eliminar después de eliminar el registro
                    btneliminar.isEnabled = false
                },
                Response.ErrorListener { response ->// error
                    Toast.makeText(
                        applicationContext,
                        "Se produjo un error al eliminar el registro",
                        Toast.LENGTH_LONG
                    ).show()
                }
            ){}
            queue.add(deleteRequest)
        }
    }
}
