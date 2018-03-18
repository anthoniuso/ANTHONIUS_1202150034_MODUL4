package com.levegra.anthonius_1202150034_modul4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MahasiswaActivity extends AppCompatActivity {

    ListView fetch_mahasiswa;
    Button fetch_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa);
        fetch_mahasiswa = (ListView) findViewById(R.id.fetch_mahasiswa);
        fetch_data = (Button)findViewById(R.id.button_fetch);

        fetch_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {new getData(fetch_mahasiswa).execute();}
        });
    }

    class getData extends AsyncTask<String, Integer, String> {

        ArrayAdapter adapter;
        ProgressDialog fetch_dialog;
        ArrayList<String> fetch_nama;
        ListView fetch_mahasiswa;

        public getData(ListView fetch_mahasiswa){
            this.fetch_mahasiswa = fetch_mahasiswa;
            fetch_dialog = new ProgressDialog(MahasiswaActivity.this);
            fetch_nama = new ArrayList<>();
        }
        @Override
        protected String doInBackground(String... strings) {
            adapter = new ArrayAdapter<>(MahasiswaActivity.this, android.R.layout.simple_list_item_1, fetch_nama); //membuat adapter

            //Declare an array
            String[] mhs = getResources().getStringArray(R.array.mahasiswa);

            //Save array Loop
            for (int a = 0; a < mhs.length; a++) {
                final long percentage = 100L * a / mhs.length;
                final String name = mhs[a];
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() {
                            fetch_dialog.setMessage((int) percentage+"% - Adding "+name);
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    fetch_nama.add(mhs[a]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            fetch_dialog.setTitle("Fetching Data...");
            fetch_dialog.setIndeterminate(true);
            fetch_dialog.setProgress(0);
            fetch_dialog.setMax(100);
            fetch_dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            fetch_dialog.setCancelable(true);
            fetch_dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Batalkan", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    fetch_dialog.dismiss();
                    getData.this.cancel(true);
                }
            });

            fetch_dialog.show();
        }

        @Override
        protected void onPostExecute(String mahasiswa) {
            super.onPostExecute(mahasiswa);
            fetch_mahasiswa.setAdapter(adapter);
            fetch_dialog.dismiss();
        }
    }

}
