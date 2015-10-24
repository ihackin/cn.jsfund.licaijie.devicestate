package cn.jsfund.licaijie.devicestate;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by maning on 15/10/24.
 */
public class CDVDeviceState extends CordovaPlugin {
    
    private CallbackContext mCallbackContext;
    
    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("start")) {
            mCallbackContext = callbackContext;
            PluginResult dataResult = new PluginResult(PluginResult.Status.OK,"start success");
            dataResult.setKeepCallback(true);//非常重要
            mCallbackContext.sendPluginResult(dataResult);
        }
        return true;
    }
    
    
    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        try {
            JSONObject result = new JSONObject();
            result.put("state", "resume");
            if (mCallbackContext != null) {
                PluginResult dataResult = new PluginResult(PluginResult.Status.OK, result.toString());
                dataResult.setKeepCallback(true);//非常重要
                mCallbackContext.sendPluginResult(dataResult);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void onPause(boolean multitasking) {
        super.onPause(multitasking);
        try {
            JSONObject result = new JSONObject();
            result.put("state", "pause");
            if (mCallbackContext != null) {
                PluginResult dataResult = new PluginResult(PluginResult.Status.OK, result.toString());
                dataResult.setKeepCallback(true);//非常重要
                mCallbackContext.sendPluginResult(dataResult);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    
    
}
