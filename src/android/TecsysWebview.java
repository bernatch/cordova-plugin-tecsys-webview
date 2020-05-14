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

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.Toast;

import java.util.ArrayList;

public class TecsysWebview extends CordovaPlugin {

    private static final String TAG = TecsysWebview.class.getSimpleName();

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    // Binding a Cordova string to a java method
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("init")) {
            this.init(callbackContext);
            return true;
        }
	    
	if (action.equals("test")) {
            Toast.makeText(mContext, "This is a test", Toast.LENGTH_SHORT).show();
            return true;
        }
     
        return false;
    }

    private void init(final CallbackContext callbackContext) {
        Log.d(TAG, "# init");
        
        Log.d(TAG, "# init - Getting webview ");
	WebView cordovaWebview = new WebView(cordova.getActivity());
        //WebView tecsysWebView = (WebView)findViewById(R.id.webview); 
        
        Log.d(TAG, "# init - Setting up javascript interface");
        final JavaScriptInterface jsInterface = new JavaScriptInterface(this);    	 
    	 
        cordovaWebview.getSettings().setJavaScriptEnabled(true);
        cordovaWebview.addJavascriptInterface(jsInterface, "TECSYS");
        
         Log.d(TAG, "# init - Done");
    }
    
    public class JavaScriptInterface {
		Context mContext;

	    JavaScriptInterface(Context c) {
	        mContext = c;
	    }
	    
	    public void showToast(String webMessage){	    	
	    	final String msgToast = webMessage;	    	
	    	 myHandler.post(new Runnable() {
	             @Override
	             public void run() {
	                 myTextView.setText(msgToast);
	             }
	         });

	       Toast.makeText(mContext, webMessage, Toast.LENGTH_SHORT).show();
	    }
    }
}