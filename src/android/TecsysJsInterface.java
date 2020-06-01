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

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.UtteranceProgressListener;

import java.util.HashMap;
import java.util.Locale;
import java.util.*;

public class TecsysJsInterface implements OnInitListener {

	private static final String TAG = TecsysJsInterface.class.getSimpleName();
	
	public static final String ERR_INVALID_OPTIONS = "ERR_INVALID_OPTIONS";
	public static final String ERR_NOT_INITIALIZED = "ERR_NOT_INITIALIZED";
	public static final String ERR_ERROR_INITIALIZING = "ERR_ERROR_INITIALIZING";
	public static final String ERR_UNKNOWN = "ERR_UNKNOWN";

	Context mContext;
	TextToSpeech tts = null;
	boolean ttsInitialized = false;

	TecsysJsInterface (Context c) {
	   mContext = c;
	   tts = new TextToSpeech(c, this);
	}

	@JavascriptInterface
	public void speak(String message){
	   speak(message);
	}

	@Override
	public void onInit(int status) {
		if (status != TextToSpeech.SUCCESS) {
			tts = null;
		} else {
			// warm up the tts engine with an empty string
			HashMap<String, String> ttsParams = new HashMap<String, String>();
			ttsParams.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
			tts.setLanguage(new Locale("en", "US"));
			tts.speak("", TextToSpeech.QUEUE_FLUSH, ttsParams);

			ttsInitialized = true;
		}
	}

	private void speakTTS(String message) throws NullPointerException {

		String text = message;
		String locale = "en-US";
		double rate = 1.0;

		if (tts == null) {
			Log.d(TAG, "showToast");
			Toast.makeText(mContext, "TTS NULL", Toast.LENGTH_SHORT).show();
			
			return;
		}

		if (!ttsInitialized) {
			Log.d(TAG, "showToast");
			Toast.makeText(mContext, "TTS NOT INITIALIZED", Toast.LENGTH_SHORT).show();

			return;
		}

		HashMap<String, String> ttsParams = new HashMap<String, String>();
		ttsParams.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, callbackContext.getCallbackId());

		String[] localeArgs = locale.split("-");
		tts.setLanguage(new Locale(localeArgs[0], localeArgs[1]));

		if (Build.VERSION.SDK_INT >= 27) {
			tts.setSpeechRate((float) rate * 0.7f);
		} 
		else {
			tts.setSpeechRate((float) rate);
		}

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, ttsParams);
	}
}
