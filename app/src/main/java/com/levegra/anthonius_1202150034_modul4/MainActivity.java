package com.levegra.anthonius_1202150034_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button list = (Button)findViewById(R.id.button_list);
        Button gambar = (Button)findViewById(R.id.button_cari);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MahasiswaActivity.class);
                startActivity(i);
            }
        });

        gambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FetchGambarActivity.class);
                startActivity(i);
            }
        });
    }
}
