package org.shenchanghui.schcodelib.okhttp.cookie;


import android.content.Context;

import org.shenchanghui.schcodelib.utils.LogUtil;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by 沈昌辉 on 2017/2/17.
 */

public class CookiesManager implements CookieJar {


    private final String TAG = getClass().getSimpleName();
    private final PersistentCookieStore cookieStore;

    public CookiesManager(Context context) {
        cookieStore = new PersistentCookieStore(context);
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        LogUtil.d(TAG, "saveFromResponse" + cookies);
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        LogUtil.d(TAG, "loadForRequest cookies" + cookies);
        return cookies;
    }
}
