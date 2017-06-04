package com.reserva;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad2 extends Activity {

	String nombre = "", fecha = "", hora = "";
	int personas = 0;
	TextView muestraDatos;
	boolean ServicioValetP=false;
	CheckBox servicio;
	String servicioContratado="Ninguno";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad2);

		servicio=(CheckBox) findViewById(R.id.servicioValet);
		muestraDatos = (TextView) findViewById(R.id.muestraDatos);

		Bundle recibe = new Bundle();
		recibe = this.getIntent().getExtras();

		nombre = recibe.getString("nombre");
		personas = recibe.getInt("personas");
		fecha = recibe.getString("fecha");
		hora = recibe.getString("hora");

		muestraDatos.setText("Reservacion a nombre de:\n" + nombre + "\n" + personas
				+ " personas\nFecha: " + fecha + "\nHora: " + hora + "\n");

	}

	public void onClickServicio(View v){
		ServicioValetP=((CheckBox)v).isChecked();
		if(ServicioValetP)
			servicioContratado="Valet Parking";
		else
			servicioContratado="Ninguno";
	}
    public void hacerOtraReserva(View v) {
        Intent envia = new Intent(this, MainActivity.class);
		Bundle regreso=new Bundle();
		regreso.putString("ServicioExtra",servicioContratado);
		envia.putExtras(regreso);
        finish();
        startActivity(envia);
    }

}
