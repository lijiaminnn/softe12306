package com.example.ticket.util;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 张燕华 on 2018/12/25.
 */

public class ExitApplication extends Application {
    private List<Activity> activityList = new LinkedList<Activity>();
    private static ExitApplication instance;

    public ExitApplication() {
    }

    /**单例模式中获取唯一的ExitApplication实例*/
    public static ExitApplication getInstance() {
        if (null == instance){
            instance = new ExitApplication();
        }
        return instance;
    }

    /**
     *添加Activity到容器中
     *@param Activity activity
     */
    public void addActivity(Activity activity){
        activityList.add(activity);
    }

    /**
     *遍历所有的Activity并杀死应用
     */
    public void exit(){
        for (Activity activity:activityList){
            activity.finish();
        }
        System.exit(0);
    }
}
