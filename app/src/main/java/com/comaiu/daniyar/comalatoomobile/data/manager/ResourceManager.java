package com.comaiu.daniyar.comalatoomobile.data.manager;

import android.content.Context;
import android.content.res.Resources;

public final class ResourceManager {

    private Context mContext;

    public ResourceManager(Context context){
        mContext = context;
    }

    public Resources getResources(){
        return mContext.getResources();
    }
}
