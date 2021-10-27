package cl.isisur.pruebaintentg2v01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityUno extends AppCompatActivity {

    Button btAceptar;
    TextView tvNombre;
    String stNombre="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_uno);
        Context context=getApplicationContext();
        Bundle intent =this.getIntent().getExtras();
        if (intent !=null){

            stNombre=intent.getString("nombre");
            Toast.makeText(context, "Su Nombre es: "+stNombre, Toast.LENGTH_SHORT).show();

        }


        btAceptar =(Button) findViewById(R.id.btAceptar);
        tvNombre=(TextView) findViewById(R.id.tvNombre);

        tvNombre.setText(stNombre);
        Intent intentP= new Intent(this,MainActivity.class);
        intentP.putExtra("nombre",stNombre);

        btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentP);
            }
        });

    }
}