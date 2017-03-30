package mx.ipn.cecyt9.edu.examen1_cano_ramos_alfredoerick_6im8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Actividad1 extends AppCompatActivity {


    EditText dinero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        dinero=(EditText) findViewById(R.id.dinero);
    }

    public void onClickConvertir(View v){

        double dolares = Integer.parseInt(dinero.getText().toString());
        double conversion = dolares/15;

        Intent intento = new Intent(this,Actividad2.class);
        Bundle datos = new Bundle();

        datos.putDouble("resultado",conversion);
        intento.putExtras(datos);
        finish();
        startActivity(intento);


    }
}

