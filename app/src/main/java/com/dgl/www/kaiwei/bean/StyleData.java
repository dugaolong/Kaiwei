package com.dgl.www.kaiwei.bean;

/**
 * Created by dugaolong on 17/8/17.
 */

public class StyleData {

    private String[] backreason;
    private String view;

    public StyleData(String[] backreason, String view) {
        this.backreason = backreason;
        this.view = view;
    }

    public String[] getBackreason() {
        return backreason;
    }

    public void setBackreason(String[] backreason) {
        this.backreason = backreason;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
