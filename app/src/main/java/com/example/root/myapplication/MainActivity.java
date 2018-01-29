package com.example.root.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check();

    }
    public void check() {
        TextView display = (TextView) findViewById(R.id.display);
        h.postDelayed(r,1000);
        try {


            FileReader reader = new FileReader("/sys/class/power_supply/usb/type");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                display.setText(line);
            }
            reader.close();
        } catch (IOException e) {
            display.setText("Permission Denied");
        }



    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            check();
        }
    };

}