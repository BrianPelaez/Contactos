package com.example.contactos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTel;
    private TextView tvEmail;
    private Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        // BOTON BACK ARRIBA TOOLBAR
        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        

        //SE INICIALICIA EL BUNDLE PARA CONSEGUIR LOS DATOS DE LA OTRA ACTIVIDAD
        Bundle parametros_contacto = getIntent().getExtras();

        String nombre  = parametros_contacto.getString(getResources().getString(R.string.pnombre));
        String tel  = parametros_contacto.getString(getResources().getString(R.string.ptel));
        String email  = parametros_contacto.getString(getResources().getString(R.string.pemail));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTel.setText(tel);
        tvEmail.setText(email);
    }

    // ABRIR APLICACION DE LLAMADA
    public void llamar(View v){
        String telefono = tvTel.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefono)));
    }

    // ABRIR APLICACION DE MENSAJE
    public void enviarMail(View v){
        // SE CONSIGUE EL STRING DEL TEXTVIEW
        String email = tvEmail.getText().toString();
        // SE DECLARA EL INTENT CON LA ACCION DE CORREO
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        // SE SETEA LA ACCION QUE VA A SUCEDER EJ: 'mailto:' -> Enviar a...
        emailIntent.setData(Uri.parse("mailto:"));
        // SE DEFINEN LOS PARAMETROS.
        // SE PUEDEN AGREGAR VARIOS PARAMETROS.
        // EJ: emailIntent.putExtra(Intent.EXTRA_SUBJECT, new String[] {"Asunto"});
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {email});
        //emailIntent.setType("message/rfc822");
        // SE ELIJE LA APLICACION A ABRIR, EN ESTE CASO CON EL ACTION_SEND LO SELECCIONAMOS,
        // EN EL 'emailIntent'
        startActivity(Intent.createChooser(emailIntent, "Email"));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        // SE CHEQUEA SI LA TECLA BACK FUE CHEQUEADA
        if (keyCode == KeyEvent.KEYCODE_BACK){
            //SE VUELVE A INICIAR LA ACTIVIDAD PRINCIPAL YA QUE FUE FINALIZADA PARA AHORRAR RECURSOS
            // ESTO SE UTILIZA PARA OPTIMIZAR LAS APLICACIONES EN CASO DE TENER MUCHAS ACTIVIDADES
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }
}