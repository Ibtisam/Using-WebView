package com.example.usingwebview;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context mContext;

    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void openActivity(String fname, String lname){
        Intent intent = new Intent();
        intent.setClass(mContext, ActivityForJavaScript.class);
        intent.putExtra("FNAME", fname);
        intent.putExtra("LNAME", lname);
        mContext.startActivity(intent);
    }
}
