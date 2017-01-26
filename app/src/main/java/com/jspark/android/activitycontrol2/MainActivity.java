package com.jspark.android.activitycontrol2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button callBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callBrowser = (Button)findViewById(R.id.btnBrowse);

        callBrowser.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnBrowse :
                    Intent i = new Intent(MainActivity.this, BrowserActivity.class);
                    startActivity(i);
                    break;
            }
        }
    };
}
