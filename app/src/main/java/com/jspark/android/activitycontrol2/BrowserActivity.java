package com.jspark.android.activitycontrol2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BrowserActivity extends AppCompatActivity {

    Button backButton, goButton;
    EditText etPath;
    WebView wV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        backButton = (Button)findViewById(R.id.btnBack);
        goButton = (Button)findViewById(R.id.btnGo);
        etPath = (EditText)findViewById(R.id.editPath);
        wV = (WebView)findViewById(R.id.webView);

        // 둘 다 설정해서 둘 중에 하나를 선택하여 동작함
        wV.setWebViewClient(new WebViewClient());
        wV.setWebChromeClient(new WebChromeClient());

        // 세팅 정하기
        wV.getSettings().setJavaScriptEnabled(true);
        wV.getSettings().setSupportZoom(true);

        backButton.setOnClickListener(listener);
        goButton.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnBack :
                    if(wV.canGoBack()) {
                        wV.goBack();
                    } else {
                        Toast.makeText(BrowserActivity.this, "더 이상 뒤로 갈 수 없습니다", Toast.LENGTH_SHORT).show();
                    }

                    break;
                case R.id.btnGo :
                    String url = etPath.getText().toString();
                    if(!url.equals("")) {
                        wV.loadUrl("http://"+url);
                    }
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
