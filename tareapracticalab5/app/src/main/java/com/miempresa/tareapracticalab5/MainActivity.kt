package com.miempresa.tareapracticalab5
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prolab1: EditText = findViewById(R.id.prolab1)
        val pracca1: EditText = findViewById(R.id.pracca1)
        val pracca2: EditText = findViewById(R.id.pracca2)
        val pracca3: EditText = findViewById(R.id.pracca3)
        val pracca4: EditText = findViewById(R.id.pracca4)
        val profi: Button = findViewById(R.id.profi)
        val promediofi: EditText = findViewById(R.id.promediofi)
        val imagenResultado: ImageView = findViewById(R.id.imagen_resultado)

        profi.setOnClickListener {
            // Obtener las notas de los campos de texto
            val prolab1Nota = prolab1.text.toString().toFloatOrNull()
            val pracca1Nota = pracca1.text.toString().toFloatOrNull()
            val pracca2Nota = pracca2.text.toString().toFloatOrNull()
            val pracca3Nota = pracca3.text.toString().toFloatOrNull()
            val pracca4Nota = pracca4.text.toString().toFloatOrNull()

            // Validar que todas las notas sean válidas
            if (prolab1Nota == null || pracca1Nota == null || pracca2Nota == null || pracca3Nota == null || pracca4Nota == null) {
                Toast.makeText(this, "Por favor ingrese todas las notas", Toast.LENGTH_SHORT).show()
            } else {
                // Calcular el promedio
                val promedio = (prolab1Nota * 0.7f) + ((pracca1Nota + pracca2Nota + pracca3Nota + pracca4Nota) / 4f) * 0.3f
                promediofi.setText(promedio.toString())

                // Determinar si el curso está aprobado o no
                val imagen: Drawable = if (promedio >= 12.5f) {
                    getDrawable(R.drawable.contento)!!
                } else {
                    getDrawable(R.drawable.triste)!!
                }
                imagenResultado.setImageDrawable(imagen)
            }
        }
    }
}
