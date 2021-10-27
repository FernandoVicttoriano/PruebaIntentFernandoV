package cl.isisur.pruebaintentg2v01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivitySensor extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sensor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor =sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (proximitySensor ==null){
            Toast.makeText(this, "Sensor con Error", Toast.LENGTH_SHORT).show();
            finish();
        }

        proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                if (sensorEvent.values[0]<proximitySensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.CYAN);
                } else {
                    getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(proximitySensorListener,proximitySensor,2*1000*1000);
    }
    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(proximitySensorListener);
    }
}