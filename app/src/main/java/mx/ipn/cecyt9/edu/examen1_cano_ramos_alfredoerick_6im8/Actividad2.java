package mx.ipn.cecyt9.edu.examen1_cano_ramos_alfredoerick_6im8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad2 extends AppCompatActivity {

    double resultado;
    TextView nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        Bundle recibe = new Bundle();
        recibe = getIntent().getExtras();

        resultado = recibe.getDouble("resultado");
        nombre = (TextView) findViewById(R.id.nombre);
        nombre.setText(nombre.getText().toString() + "; Resultado  " + resultado);


    }

    public void onClickEnviar(View v){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Asunto: examen 1er parcial ");
        intent.putExtra(Intent.EXTRA_TEXT, "Resultado de la conversion: " + resultado);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "eoropezag@ipn.mx"} );

        try {
            startActivity(Intent.createChooser(intent, "Mandando correo"));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Actividad2.this,
                    "No hay aplicación de email", Toast.LENGTH_SHORT).show();
        }
    }

}


