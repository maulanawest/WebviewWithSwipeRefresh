package com.redudantdev8.webviewwithswiperefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

	SwipeRefreshLayout swipeRefreshLayout_id;
	WebView webView_id;
	WebViewClient webViewClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView_id = (WebView) findViewById(R.id.webView_id);
		swipeRefreshLayout_id = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh_id);

		webView_id.loadUrl("https://github.com/maulana2ahmad?tab=repositories");

		swipeRefreshLayout_id.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				webView_id.reload();
			}
		});

		webViewClient = new WebViewClient() {

			//TODO onpageFinished
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);

				//TODO false refresh
				swipeRefreshLayout_id.setRefreshing(false);
			}

			//TODO finish refresh
			@Override
			public void onPageCommitVisible(WebView view, String url) {
				super.onPageCommitVisible(view, url);

				swipeRefreshLayout_id.setColorSchemeResources(R.color.colorFinishRefresh);
			}

			//TODO load refresh
			@Override
			public void onLoadResource(WebView view, String url) {
				super.onLoadResource(view, url);

				swipeRefreshLayout_id.setColorSchemeResources(R.color.colorLoadRefresh);
			}
		};

		webView_id.setWebViewClient(webViewClient);
	}


}
