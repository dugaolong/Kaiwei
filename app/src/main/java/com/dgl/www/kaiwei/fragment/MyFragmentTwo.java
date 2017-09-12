package com.dgl.www.kaiwei.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.dgl.www.kaiwei.R;

/**
 * Created by wangjitao on 2016/3/7.
 */
public class MyFragmentTwo extends Fragment {
    private Context mContext;
    private String url;
    private WebView webView;

    public MyFragmentTwo(Context context, String url) {
        this.mContext = context;
        this.url = url;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        webView = (WebView) view.findViewById(R.id.webView);
        return view;
    }

    public MyFragmentTwo() {

    }


}