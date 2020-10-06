package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Atributos

    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SE DEBE CARGAR LA ACTION BAR PARA QUE SE VEA EN TODAS LAS ACTIVITIES
        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        // >>>>>>>>>>       EJEMPLO RECYCLER VIEW             <<<<<<<<<
        // SE DEBE CREAR UNA CLASE ADAPTADOR DONDE SE INICIALIZAN LOS DATOS DEL RECYCLER
        rvContactos = (RecyclerView) findViewById(R.id.rvContactos);
        //SE ASIGNA EL CONTEXTO AL LinearLayoutManager
        LinearLayoutManager llm = new LinearLayoutManager(this); // <----- LINEAL
        //GridLayoutManager glm = new GridLayoutManager(this, 2); // <---- Modo Grilla
        // Se setea la orientacion del recycler view
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        // Se setea el LinearLayoutManager
        rvContactos.setLayoutManager(llm);

        crearContactos();
        inicializarAdaptador();

        /* >>>>>>>>>>       EJEMPLO TEXT VIEW             <<<<<<<<<

            // SE RECORRE LA LISTA DE CONTACTOS Y SE ASIGNA LOS VALORES
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto:contactos){
            nombresContacto.add(contacto.getNombre());
        }

        ListView lvContactos = (ListView) findViewById(R.id.lvContacto);

        //SE SETEA EL ADAPTER CON EL ARRAY DE LOS NOMBRES PARA MOSTRARLOS EN UN LAYOUT PREDEFINIDO 'simple_list_item_1'
        //lvContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        // AL PRESIONAR SOBRE EL CONTACTO SE EJECUTA ESTE METODO
        lvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // LOS INTENT SIRVEN PARA PASAR DE UNA ACTIVIDAD A OTRA Y PODER ENVIAR DATOS
                //SE INSTANCIA EL CONTEXTO DONDE NOS ENCONTRAMOS + A DONDE QUEREMOS IR
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                // '.putExtra' ES EL METODO PARA ENVIAR DATOS A LA OTRA ACTIVIDAD
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptel), contactos.get(position).getTel());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                //SE FINALIZA LA ACTIVIDAD PARA AHORRAR RECURSOS
                finish();
            }
        });
        */

    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        rvContactos.setAdapter(adaptador);
    }

    public void crearContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Brian Pelaez","45555555", "asd@hotmail.com",R.drawable.round_mail_black_18dp));
        contactos.add(new Contacto("Ruben Sanchez","548131324", "aswhawed@hotmail.com", R.drawable.round_phone_black_18dp));
        contactos.add(new Contacto("Jorge Rodriguez","123425212", "asawddwd@hotmail.com", R.drawable.round_phone_black_18dp));
        contactos.add(new Contacto("Camila Cairo","325161231", "asd56212@hotmail.com",R.drawable.round_phone_black_18dp));
        contactos.add(new Contacto("Bruno Prado","213566334", "aswawaad@hotmail.com", R.drawable.round_phone_black_18dp));
        contactos.add(new Contacto("Sol Prieto","412334656", "123@hotmail.com", R.drawable.round_mail_black_18dp));
        contactos.add(new Contacto("Ayelen Greatti","32436362", "987321@hotmail.com", R.drawable.round_mail_black_18dp));
        contactos.add(new Contacto("Ana Zerda","4324324663", "85258@hotmail.com", R.drawable.round_mail_black_18dp));
        contactos.add(new Contacto("Marcelo Pelaez","43263632", "asdzzzzzz@hotmail.com", R.drawable.round_mail_black_18dp));

    }
}