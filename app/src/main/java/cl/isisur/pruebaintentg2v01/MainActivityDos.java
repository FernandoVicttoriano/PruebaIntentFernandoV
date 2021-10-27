package cl.isisur.pruebaintentg2v01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityDos extends AppCompatActivity {
    Button btAceptarDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dos);
        btAceptarDos=(Button) findViewById(R.id.btAceptar1);
        Intent intent1= new Intent(this,MainActivity.class);

        btAceptarDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });



    }


}