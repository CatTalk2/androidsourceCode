package com.debugcat.resourcedemo.Skin;

import android.content.res.Resources;

import java.lang.ref.WeakReference;

/**
 * 1. 初始化从assets中加载皮肤资源
 *
 * 2. 判断当前是否需要使用皮肤resource
 *
 * 3.
 */
public class SkinManager {

    private static SkinManager sSkinManager;

    private Resources mSkinResources;

    private WeakReference<ISkinUpdate> wfUpdateObserver;

    private SkinManager() {

    }

    public SkinManager getInstance() {
        if (sSkinManager == null) {
            sSkinManager = new SkinManager();
        }
        return sSkinManager;
    }

    /**
     * 拷贝皮肤文件，构造SkinResources
     */
    public void init() {

    }


    /**
     * 加载本地或者网络皮肤文件
     */
    public void load() {

    }


    public void addObserver(ISkinUpdate observer) {

    }


    public void attach() {

    }

    public void detach() {

    }


}
