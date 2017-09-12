package com.dgl.www.kaiwei.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.dgl.www.kaiwei.R;

public class FragmentIHome extends Fragment {

    private Context mContext;
    //    private ListView listView;
    private WebView webView;
    private String url;

    public FragmentIHome() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        webView = (WebView) view.findViewById(R.id.webView);
        initWebView();
        return view;
    }

    public FragmentIHome(Context context, String url) {
        mContext = context;
        this.url = url;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //清除记录
        webView.clearCache(true);
        webView.clearHistory();
        webView.clearFormData();

        webView.destroy();
    }

    private void initWebView() {
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //系统默认会打开系统浏览器去打开网页，为了要显示在自己的webview中必须设置这个属性
                Log.e("url==", url);
                view.loadUrl(url);

                return super.shouldOverrideUrlLoading(view, url);
            }

            //加载开始时调用

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            // 加载结束时调用

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }


        });

        webView.setWebChromeClient(new WebChromeClient() {
            //加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.e("WebView>>>>>>>", newProgress + "");
                super.onProgressChanged(view, newProgress);
            }


            @Override
            public void onRequestFocus(WebView view) {
                super.onRequestFocus(view);
            }

            @Override
            public void onCloseWindow(WebView window) {
                super.onCloseWindow(window);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Log.e("url==", url);
                view.loadUrl(url);
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                Log.e("url==", url);
                view.loadUrl(url);
                return super.onJsConfirm(view, url, message, result);
            }

        });

        webView.loadUrl(url);
        // 得到setting
        WebSettings webSettings = webView.getSettings();
        //设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //支持的语言类型
        webSettings.setDefaultTextEncodingName("UTF-8");
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);

        webSettings.setDomStorageEnabled(true);


        //关键代码
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        //这里处理返回键事件
                        if (webView.canGoBack()) {
                            webView.goBack();
                            Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }
}