package com.dgl.www.kaiwei.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.dgl.www.kaiwei.Constant;
import com.dgl.www.kaiwei.R;
import com.dgl.www.kaiwei.adapter.MyItemDecoration;
import com.dgl.www.kaiwei.adapter.RecycleAdapter;
import com.dgl.www.kaiwei.bean.DataItem;
import com.dgl.www.kaiwei.bean.IfengResponse;
import com.dgl.www.kaiwei.retrofit.RequestServices;
import com.dgl.www.kaiwei.utils.DialogUtil;
import com.dgl.www.kaiwei.widget.FullyLinearLayoutManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<DataItem> mDatas = new ArrayList<>();
    private RecycleAdapter mRecycleAdapter;

    private Context mContext;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
        initData();
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        // 设置是否允许嵌套滑动
        mRecyclerView.setNestedScrollingEnabled(false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        //设置布局管理器
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecycleAdapter = new RecycleAdapter(this, mDatas);
        mRecyclerView.setAdapter(mRecycleAdapter);
        mRecycleAdapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
//                clickItem(position);
            }

        });
        //这句就是添加我们自定义的分隔线
        mRecyclerView.addItemDecoration(new MyItemDecoration());
        initToolBar();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
        navigationView =
                (NavigationView) findViewById(R.id.nv_main_navigation);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    });
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"fab clicked",Toast.LENGTH_LONG).show();
                Snackbar.make(v, "data delete ", Snackbar.LENGTH_SHORT).setAction("yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "data has delete", Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });
    }

    private void initData() {
        DialogUtil.showProgressDialog(mContext, "拼命加载中");
        //创建Retrofit实例，设置url地址
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URL_IFENG)
                .client(genericClient())
                .build();

        //通过Retrofit实例，创建接口服务对象
        RequestServices requestServices = retrofit.create(RequestServices.class);
        //接口服务对象调用接口中的方法，获得Call对象
        Call<ResponseBody> call = requestServices.getString("861735038272489", "861735038272489");
        //call对象执行请求
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                DialogUtil.closeProgressDialog();
                if (response.isSuccess()) {
                    try {
                        String result = response.body().string();
                        Log.i("MainActivity", result);
                        //返回的结果保存在response.body()中
                        IfengResponse ifengResponse = JSON.parseObject(result, new TypeReference<IfengResponse>() {});
//                        IfengResponse ifengResponse = (IfengResponse) JSON.parse(result);
                        mDatas.addAll(ifengResponse.getData().getList().getItem());
                        //onResponse方法是运行在主线程也就是UI线程的，所以我们可以在这里
                        mRecycleAdapter.notifyDataSetChanged();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(mContext,"网络异常",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("MainActivity", "onFailure");
            }
        });
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("凤凰新闻");
        toolbar.collapseActionView();
        toolbar.setBackgroundColor(Color.parseColor("#dddddd"));
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrCloseDrawer();
            }
        });
    }

    private void openOrCloseDrawer() {
        if (mDrawerLayout.isDrawerOpen(navigationView)) {
            mDrawerLayout.closeDrawer(navigationView);
        } else {
            mDrawerLayout.openDrawer(navigationView);
        }
    }

    public static OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                                .addHeader("Accept-Encoding", "gzip, deflate")
                                .addHeader("Connection", "keep-alive")
                                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                                .addHeader("Cookie", "_ga=GA1.2.2072854642.1487668872; _octo=GH1.1.501568181.1487668872; dotcom_user=dugaolong; logged_in=yes")
                                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/601.7.7 (KHTML, like Gecko) Version/9.1.2 Safari/601.7.7")
                                .build();
                        return chain.proceed(request);
                    }

                })
                .build();

        return httpClient;
    }
}
