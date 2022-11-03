package com.example.ejemploanytask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressBar);

        }
public void run(){
        pb.setProgress(0);
        while(pb.getProgress()<100){

        try{
        Thread.sleep(1000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
        pb.incrementProgressBy(1);
        }
        }

public void tarea(View v)throws InterruptedException{
        hilo= new Thread(this);
        hilo.start();
        }
public void saluda ( View v){
        Toast.makeText(this, "Hola Mundo!", Toast.LENGTH_LONG).show();
        }
}