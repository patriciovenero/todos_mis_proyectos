package com.miempresa.usowidgetv4

import android.appwidget.AppWidgetManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_datos_widget.*

private var widgetId = 0
class DatosWidget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_widget)

        val recibidowidget = intent
        val parametros = recibidowidget.extras
        if (parametros != null){
            //se obtiene ID de widget que se esta configurando
            widgetId = parametros.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }

        //se establece un resultado por defecto(cuando se pulse el boton de atras del telefono este sera el mensaje mostrado
        setResult(RESULT_CANCELED)
        val bntAceptar = findViewById<Button>(R.id.btnAceptar)
        bntAceptar.setOnClickListener(View.OnClickListener {//se apertura harchivo de preferencias
            //para escribir datos que almacene la actividad
            val datos = getSharedPreferences("DatosWidget", MODE_PRIVATE)
            //se apertura editor para guardar datos
            val editor = datos.edit()
            editor.putString("mensaje",txtEnviar.getText().toString())
            editor.commit()

            val notificarWidget = AppWidgetManager.getInstance(this)
            val usoClaseWidget = mi_widget()
            usoClaseWidget.actualizarWidget(this,notificarWidget, widgetId)

            val resultado = Intent()
            resultado.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId)
            setResult(RESULT_OK,resultado)
            finish()
        })

        bntCancelar.setOnClickListener(View.OnClickListener { finish() })
    }
}