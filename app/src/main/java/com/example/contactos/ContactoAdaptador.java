package com.example.contactos;

// ESTE ADAPTADOR ES NECESARIO PARA EL RECYCLER VIEW

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    //ATRIBUTOS
    ArrayList<Contacto> contactos;
    Activity activity;

    // CONTRUCTOR
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    // METODOS

    @NonNull
    @Override
    // INFLA EL LAYOUT Y LO PASA AL VIEWHOLDER PARA QUE OBTENGA CADA ELEMENTO
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // SE ASOCIA NUESTRO LAYAOUT AL RECYCLERVIEW
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    // SETEA CADA ELEMENTO DE LA LISTA A CADA VIEW
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {

        final Contacto contacto = contactos.get(position);
        contactoViewHolder.tvTelCv.setText(contacto.getTel());
        contactoViewHolder.ivContactoCv.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCv.setText(contacto.getNombre());

        // AL PRESIONAR SOBRE LA IMAGEN DEL CONTACTO
        // SE ASIGNAN LOS VALORES DEL CONTACTO PRESIONADO
        contactoViewHolder.ivContactoCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("tel", contacto.getTel());
                intent.putExtra("foto", contacto.getFoto());
                activity.startActivity(intent);
                //activity.finish();
            }
        });

        // AL PRESIONAR SOBRE EL BOTON DE LIKE

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    // CANTIDAD DE ELEMENTOS DE LA LISTA
    public int getItemCount() {
        return contactos.size();
    }

    // SE CREA UN VIEWHOLDER PARA MANEJAR LA LOGICA DEL VIEW
    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        //ATRIBUTOS DEL VIEWHOLDER

        private ImageView ivContactoCv;
        private TextView tvNombreCv;
        private TextView tvTelCv;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivContactoCv    = (ImageView) itemView.findViewById(R.id.ivContactoCv);
            tvNombreCv      = (TextView) itemView.findViewById(R.id.tvNombreCv);
            tvTelCv         = (TextView) itemView.findViewById(R.id.tvTelCv);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
