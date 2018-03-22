package com.dome.mvvm.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.dome.mvvm.api.ApiResponse;
import com.dome.mvvm.api.ApiService;
import com.dome.mvvm.vo.Resource;
import com.dome.mvvm.vo.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author yawei
 * @data on 18-3-21  上午10:40
 * @project mvvm
 * @org www.komlin.com
 * @email zyawei@live.com
 */

public class UserRepo {
    private static UserRepo userRepo = new UserRepo();

    public static UserRepo getInstance() {
        return userRepo;
    }

    public LiveData<Resource<User>> getUser(String userId) {
        MutableLiveData<Resource<User>> userEntityLiveData = new MutableLiveData<>();
        userEntityLiveData.postValue(Resource.loading(null));
        ApiService.INSTANCE.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                ApiResponse<User> apiResponse = new ApiResponse<>(response);
                if (apiResponse.isSuccessful()) {
                    userEntityLiveData.postValue(Resource.success(response.body()));
                } else {
                    userEntityLiveData.postValue(Resource.error(apiResponse.errorMessage, null));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                userEntityLiveData.postValue(Resource.error(t.getMessage(), null));
            }
        });
        return userEntityLiveData;
    }
}
