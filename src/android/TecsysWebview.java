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

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.provider.Browser;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import android.util.Log;
import java.util.ArrayList;
import java.lang.annotation.Annotation;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;

import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

android.widget.LinearLayout

public class TecsysWebview extends CordovaPlugin {

    private static final String TAG = TecsysWebview.class.getSimpleName();
	
    private WebView cordovaWebview;
    private static CordovaWebView cWebView = null;
	
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
	//cWebView = webView;
	//cordovaWebview = (WebView) webView.getEngine().getView();
	//cordovaWebview = (WebView) webView.getView();
    }

    // Binding a Cordova string to a java method
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            //this.init(callbackContext);
            return true;
        }
	    
	if (action.equals("test")) {
	    Log.d(TAG, "test......");
	    //Toast.makeText(cordova.getActivity(), "This is a test", Toast.LENGTH_SHORT).show();
		
	    //WebView cordovaWebview = new WebView(cordova.getActivity());
	    //WebView cordovaWebview = null;
		
	    // Create dialog in new thread
            Runnable runnable = new Runnable() {
	        @SuppressLint("NewApi")
                public void run() {
	            //cordovaWebview = new WebView(cordova.getActivity());
		    //cordovaWebview = (WebView) findViewById(android.R.id.webview);
		    //cordovaWebview = (WebView) findViewById(android.R.id.6);
		    //cordovaWebview = (WebView) cordova.getActivity().findViewById(Integer.valueOf(6));
		    //cordovaWebview = (WebView) cordova.getActivity().getCurrentFocus();
		    final JavaScriptInterface jsInterface = new JavaScriptInterface(cordova.getActivity());
		    //cordovaWebview.getSettings().setJavaScriptEnabled(true);
		    LinearLayout main = new LinearLayout(cordova.getActivity());
		    cordovaWebview = (WebView) main.findViewById(Integer.valueOf(6));
		    cordovaWebview.addJavascriptInterface(jsInterface, "TECSYS");
		    Log.d(TAG, "jsInterface setup");
		}
	    };
	    this.cordova.getActivity().runOnUiThread(runnable);
            
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
    
    public class JavaScriptInterface {
	Context mContext;

	JavaScriptInterface(Context c) {
	    mContext = c;
	}
	   
	@JavascriptInterface
	public void showToast(String webMessage){
	   Log.d(TAG, "showToast");
	   Toast.makeText(mContext, webMessage, Toast.LENGTH_SHORT).show();
	}
    }
}
