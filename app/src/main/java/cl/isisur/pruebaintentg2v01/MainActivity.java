package cl.isisur.pruebaintentg2v01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btUno,btDos;
    EditText etNombre;
    String stNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btUno=(Button) findViewById(R.id.btBotonA);
        btDos=(Button) findViewById(R.id.btBotonB);
        etNombre=(EditText) findViewById(R.id.etNombre);


        Context context=getApplicationContext();
        Bundle intentp =this.getIntent().getExtras();
        if (intentp !=null){

            stNombre=intentp.getString("nombre");
            Toast.makeText(context, "Su Nombre es: "+stNombre, Toast.LENGTH_SHORT).show();
            etNombre.setText(stNombre);
        }


        Intent intentUno=new Intent(this,MainActivityUno.class);
        Intent intentDos=new Intent(this,MainActivityDos.class);

        btUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Nombre= etNombre.getText().toString();
                intentUno.putExtra("nombre",etNombre.getText().toString());
                startActivity(intentUno);


            }
        });

        btDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentDos);
            }
        });



    }
}