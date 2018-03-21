package com.dome.mvvm.ui;

/**
 * @author yawei
 * @data on 18-3-21  上午11:32
 * @project mvvm
 * @org www.komlin.com
 * @email zyawei@live.com
 */

public class MainEventHandler {

    private MainActivity mainActivity;

    MainEventHandler(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void onInputFinish(String text) {
        mainActivity.onInputFinish(text);
    }
}
