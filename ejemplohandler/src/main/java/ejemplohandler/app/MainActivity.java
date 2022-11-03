package ejemplohandler.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb ;
    HiloConsumidor hilo;
    Handler h;
    TextView texto;
    public void tarea(View v)throws InterruptedException{
        hilo= new HiloConsumidor();
        hilo.start();
        hilo.getHandler();
    }
    public void saluda ( View v){
        Toast.makeText(this, "Hola Mundo!", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressBar);
        h = new Handler();
        texto= findViewById(R.id.textView);
    }
    static class HiloConsumidor extends Thread{
        Handler handler;

        public synchronized Handler getHandler() {
            while (handler ==null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return handler;
        }

        public void run(){
            Looper.prepare();
            synchronized (this){

                handler= new Handler(
                        Looper.myLooper()//se usa el mylooper para poder escoger el hilo
                );}
            Looper.loop();
        }
    }

}