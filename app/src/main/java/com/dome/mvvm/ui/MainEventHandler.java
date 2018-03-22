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

    /**
     *  会根据用户输入回调
     *  由 ActivityMainDataBinding 调用
     *  @param text 点击软键盘的提交按钮后获取到的文本
     */
    public void onTextSubmit(String text) {
        mainActivity.onSearchUser(text);
    }
}
