package com.miempresa.googlemapv4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_destinos.*

class destinos : AppCompatActivity() {
    var destino = ""
    var latitud = ""
    var longitud = ""
    var info =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinos)
        val recibidos = this.intent.extras
        if (recibidos != null) {
            destino = intent.extras!!.getString("destino")!!
            latitud = intent.extras!!.getString("latitud")!!
            longitud = intent.extras!!.getString("longitud")!!
            info = intent.extras!!.getString("info")!!
        }
        lblDestino.setText(destino)
        lblCoordenadas.setText("$latitud , $longitud")
        lblInfo.setText(info)
    }
    fun volverLista(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}