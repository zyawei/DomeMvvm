package com.dome.mvvm.vo;

import com.google.gson.annotations.SerializedName;

/**
 * @author yawei
 * @data on 18-3-21  上午10:48
 * @project mvvm
 * @org www.komlin.com
 * @email zyawei@live.com
 */

public class User {
    public String name;
    @SerializedName("avatar_url")
    public String avatarUrl;
    @SerializedName("updated_at")
    public String lastUpdate;
    @SerializedName("public_repos")
    public int repoNumber;
}
