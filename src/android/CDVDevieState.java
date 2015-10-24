package cn.jsfund.licaijie.devicestate;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
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
                mCallbackContext.success(result);
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
                mCallbackContext.success(result);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
