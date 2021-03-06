package com.dome.mvvm.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dome.mvvm.R;
import com.dome.mvvm.databinding.ActivityMainBinding;
import com.dome.mvvm.vo.Resource;
import com.dome.mvvm.vo.User;

/**
 * @author yawei
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainBinding.setEventHandler(new MainEventHandler(this));

        LiveData<Resource<User>> user = mainViewModel.getUser();
        user.observe(this, userResource -> {
            mainBinding.setLoadStatus(userResource == null ? null : userResource.status);
            mainBinding.setUser(userResource == null ? null : userResource.data);
            mainBinding.setResource(userResource);
        });
    }

    void onSearchUser(String text) {
        mainViewModel.setUserName(text);
    }
}
