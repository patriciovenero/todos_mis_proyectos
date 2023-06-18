package com.miempresa.proyectousomenusv4

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        setSupportActionBar(findViewById(R.id.mitoolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        lista.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        lista.layoutManager = LinearLayoutManager(this);

        var llenarlista = ArrayList<Elementos>()
        for (i in 1 until 20) {
            llenarlista.add(
                Elementos("Elemento "+i,
            BitmapFactory.decodeResource(resources,R.drawable.imgconfiguracion))
            )
        }

        val adapter = AdaptadorElementos(llenarlista)
        lista.adapter = adapter

        registerForContextMenu(lista)
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ){
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menucontextual,menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.configuracion) {
            //Toast.makeText(this,"Elegiste menu configuracion",Toast.LENGTH_LONG).show();
            val llamaractividad = Intent(applicationContext,Configuracion::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == R.id.informacion) {
            //Toast.makeText(this, "elejiste menu informacion",Toast.LENGTH_LONG).show();
            val llamaractividad = Intent(applicationContext,Informacion::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == android.R.id.home){
            layout_lateral.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nombre -> {
                Toast.makeText(this, "Elejiste nombre", Toast.LENGTH_SHORT).show()

            }
            R.id.semestre -> {
                Toast.makeText(this, "Elejiste semestre", Toast.LENGTH_SHORT).show()
            }
            R.id.email -> {
                Toast.makeText(this, "Elejiste email", Toast.LENGTH_SHORT).show()
            }
            R.id.carrera ->{
                Toast.makeText(this, "Elejiste carrera", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home ->Toast.makeText(this,"elejiste menu inicio",Toast.LENGTH_LONG).show()
            R.id.nav_setting -> {
                val llamaractividad = Intent(applicationContext,ListaCardView::class.java)
                startActivity(llamaractividad)
            }
        }
        return true
    }
}