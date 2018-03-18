package com.levegra.anthonius_1202150034_modul4;

import android.content.pm.ActivityInfo;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;

public class FetchGambarActivity extends AppCompatActivity {

    EditText input;
    ImageView res_img;
    Button fetch;
    private static final String STATE_ITEMS = "asd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_gambar);

        input = (EditText)findViewById(R.id.input_link); //Declare Input
        res_img = (ImageView)findViewById(R.id.res_gambar); //Declare result
        fetch = (Button)findViewById(R.id.button_fetch_gambar); //Declare button

        Picasso.with(this).setLoggingEnabled(true);

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(FetchGambarActivity.this)
                        .load(input.getText().toString())
                        .placeholder(R.mipmap.ic_launcher_round)
                        .error(R.drawable.ic_error_black_24dp)
                        .into(res_img);
            }
        });

    }

}
