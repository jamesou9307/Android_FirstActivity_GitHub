package com.james.firstactivity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fsuser on 2017-08-01.
 */

public class ActivityCollector {

    //用于对应用中的activity进行管理
    public static List<Activity> activities=new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){//销毁所有目前的activity

        for(Activity activity :activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}

