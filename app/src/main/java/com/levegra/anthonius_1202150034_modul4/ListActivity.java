package com.levegra.anthonius_1202150034_modul4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    Button async;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        async = (Button)findViewById(R.id.button_async);
//        mTextView = (TextView)findViewById(R.id.textView2);

        async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Put a message in the text view
                mTextView.setText("Napping... ");

                // Start the AsyncTask.
                // The AsyncTask has a callback that will update the text view.
//                new MyAsyncTask(mTextView).execute();
            }
        });
    }

}
