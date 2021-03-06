package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private static final String TAG=MainActivity.class.getName();
    private Button task1;
    private Button task2;
    private WorkerThread workerThread;

    private Runnable taskOne=new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task one "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable taskTwo=new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task two "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerThread=new WorkerThread();
        workerThread.start();
        task1=findViewById(R.id.tvData);
        task2=findViewById(R.id.tvTask2);

        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskOne);
            }
        });


        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskTwo);
            }
        });
    }
}