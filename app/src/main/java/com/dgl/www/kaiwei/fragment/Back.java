package com.dgl.www.kaiwei.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dgl.www.kaiwei.R;
import com.dgl.www.kaiwei.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 备份：
 * fragment中使用listview
 *
 * Created by dugaolong on 17/9/12.
 */

public class Back extends Fragment {
    private Context mContext;
    private ListView listView;

    public Back() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        listView = (ListView) view.findViewById(R.id.listView_back);
        List<Map<String, Object>> list = getData();
        listView.setAdapter(new ListViewAdapter(mContext, list));
        return view;
    }

    public Back(Context context) {
        mContext = context;
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.mipmap.ic_launcher);
            map.put("title", "这是一个标题2" + i);
            map.put("info", "这是一个详细信息2" + i);
            list.add(map);
        }
        return list;
    }
}