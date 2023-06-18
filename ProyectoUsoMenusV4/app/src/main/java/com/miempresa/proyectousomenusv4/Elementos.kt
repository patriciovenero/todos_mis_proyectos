package com.miempresa.proyectousomenusv4

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

data class Elementos(val texto:String, val imagen:Bitmap);

class AdaptadorElementos(val ListaElemtos:ArrayList<Elementos>): RecyclerView.Adapter<AdaptadorElementos.Viewholder>(){
    class Viewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val fTexto = itemView.findViewById<TextView>(R.id.elemento_texto)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorElementos.Viewholder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.elementoslista,parent,false);
        return Viewholder(v);

    }



    override fun onBindViewHolder(holder: AdaptadorElementos.Viewholder, position: Int) {
        holder?.fTexto?.text=ListaElemtos[position].texto
        holder?.fImagen?.setImageBitmap(ListaElemtos[position].imagen)

        holder.itemView.setOnCreateContextMenuListener{contexMenu,_,_->
            contexMenu.setHeaderTitle("Se eligio Opcion"+(position+1))
        }
    }

    override fun getItemCount(): Int {
        return ListaElemtos.size;
    }

}