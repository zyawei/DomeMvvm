package com.dome.mvvm.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.dome.mvvm.repo.UserRepo;
import com.dome.mvvm.vo.Resource;
import com.dome.mvvm.vo.User;

/**
 * @author yawei
 * @data on 18-3-21  上午11:05
 * @project mvvm
 * @org www.komlin.com
 * @email zyawei@live.com
 */

public class MainViewModel extends ViewModel {
    private final UserRepo userRepo = UserRepo.getInstance();
    private final MutableLiveData<String> userNameLiveData = new MutableLiveData<>();
    private final LiveData<Resource<User>> userEntityLiveData;

    public MainViewModel() {
        userEntityLiveData = Transformations.switchMap(userNameLiveData, input -> {
            if (input == null) {
                return new MutableLiveData<>();
            } else {
                return userRepo.getUser(input);
            }
        });
    }

    public LiveData<Resource<User>> getUser() {
        return userEntityLiveData;
    }

    public void setUserName(String userName) {
        userNameLiveData.postValue(userName);
    }
}
