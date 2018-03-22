package com.dome.mvvm.binding;

import android.databinding.BindingAdapter;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * @author yawei
 * @data on 18-3-21  下午1:34
 * @project mvvm
 * @org www.komlin.com
 * @email zyawei@live.com
 */

public class BindingAdapters {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
    @BindingAdapter("imgUrl")
    public static void imgUrl(ImageView view, final String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }
    @BindingAdapter("onInputFinish")
    public static void onInputFinish(TextView view, final OnInputFinish listener) {
        if (listener == null) {
            view.setOnEditorActionListener(null);
        } else {
            view.setOnEditorActionListener((v, actionId, event) -> {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    listener.onInputFinish(v.getText().toString());
                }
                return false;
            });
        }
    }
}
