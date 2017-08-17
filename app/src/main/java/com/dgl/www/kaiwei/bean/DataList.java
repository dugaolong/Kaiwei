package com.dgl.www.kaiwei.bean;

import java.util.List;

/**
 * Created by dugaolong on 17/8/17.
 */

public class DataList {
    private int totalPage;
    private List<DataItem> item;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<DataItem> getItem() {
        return item;
    }

    public void setItem(List<DataItem> item) {
        this.item = item;
    }
}
