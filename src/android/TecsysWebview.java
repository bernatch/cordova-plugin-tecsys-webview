/*
 * This software is unpublished confidential proprietary property and
 * is distributed under agreement with Tecsys Incorporated.
 * Tecsys Incorporated owns all rights to this work and intends to
 * keep this software confidential so as to maintain its value as a
 * trade secret. This software is furnished under a license and may be
 * used, copied or disclosed only in accordance with the terms of such
 * license and with inclusion of this notice.
 *
 * Copyright (C) Tecsys Incorporated, 2020
 */

package org.apache.cordova.tecsys.webview;

import android.util.Log;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.provider.Browser;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

import android.webkit.SslErrorHandler;
import android.net.http.SslError;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TecsysWebview extends CordovaPlugin {

    private static final String TAG = TecsysWebview.class.getSimpleName();

    // Binding a Cordova string to a java method
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            //this.init(callbackContext);
            return true;
        }
	    
	if (action.equals("test")) {
	    //WebView cordovaWebview = new WebView(cordova.getActivity());
            //Toast.makeText(cordovaWebview.getContext(), "This is a test", Toast.LENGTH_SHORT).show();
            return true;
        }
     
        return false;
    }

	/*
    private void init(final CallbackContext callbackContext) {
        Log.d(TAG, "# init");
        
        Log.d(TAG, "# init - Getting webview ");
	WebView cordovaWebview = new WebView(cordova.getActivity());
        //WebView tecsysWebView = (WebView)findViewById(R.id.webview); 
        
        Log.d(TAG, "# init - Setting up javascript interface");
        final JavaScriptInterface jsInterface = new JavaScriptInterface(cordovaWebview.getContext());    	 
    	 
        cordovaWebview.getSettings().setJavaScriptEnabled(true);
        cordovaWebview.addJavascriptInterface(jsInterface, "TECSYS");
        
         Log.d(TAG, "# init - Done");
    }
	*/
    
	/*
    public class JavaScriptInterface {
	Context mContext;

	JavaScriptInterface(Context c) {
	    mContext = c;
	}
	    
	public void showToast(String webMessage){
	   Toast.makeText(mContext, webMessage, Toast.LENGTH_SHORT).show();
	}
    }
	*/
}
