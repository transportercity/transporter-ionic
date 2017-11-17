package cordova.plugin.transporter;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.transporter.sdk.Transporter;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import android.util.Log;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class transporter extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("testMethod")) {
            String message = args.getString(0);
            this.testMethod(message, callbackContext);
            return true;
        }

        if(action.equals("initialize")) {
          String secretKey = args.getString(0);
          this.initialize(callbackContext,secretKey);
          return true;
        }
        
        if(action.equals("setUserId")) {
          String userId = args.getString(0);
          this.setUserId(callbackContext,userId);
          return true;
        }

        if(action.equals("setDescription")) {
          String description = args.getString(0);
          this.setDescription(callbackContext,description);
          return true;
        }

        if(action.equals("startTracking")) {
          this.startTracking(callbackContext);
          return true;
        }

        if(action.equals("stopTracking")) {
          this.stopTracking(callbackContext);
          return true;
        }

        if (action.equals("checkSelfPermissions")) {
          this.checkSelfPermissions(callbackContext);
          return true;
        }

        if (action.equals("requestPermissions")) {
          this.requestPermissions(callbackContext);
          return true;
        }

        if (action.equals("isLocationEnabled")) {
          this.isLocationEnabled(callbackContext);
          return true;
        }

        if (action.equals("requestLocationSettings")) {
          this.requestLocationSettings(callbackContext);
          return true;
        }
        return false;
    }



    private void testMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void initialize(CallbackContext callbackContext, String secretKey){
        Transporter.initialize(this.cordova.getActivity().getApplicationContext(), secretKey);
    }

    private void setUserId(CallbackContext callbackContext, String userId){
        Transporter.setUserId(this.cordova.getActivity().getApplicationContext(),userId);
    }

    private void setDescription(CallbackContext callbackContext, String descrition){
        Transporter.setDescription(this.cordova.getActivity().getApplicationContext(),descrition);
    }

    private void startTracking(CallbackContext callbackContext){
        Transporter.startTracking(this.cordova.getActivity().getApplicationContext());
    }

    private void stopTracking(CallbackContext callbackContext){
        Transporter.stopTracking(this.cordova.getActivity().getApplicationContext());
    }

    private void isLocationEnabled(CallbackContext callbackContext){
        if (Transporter.isLocationEnabled(this.cordova.getActivity().getApplicationContext())) {
          callbackContext.success("true");
        } else {
          callbackContext.success("false");
        }
    }

    private void requestLocationSettings(CallbackContext callbackContext){
        Transporter.requestLocationSettings(this.cordova.getActivity());
    }

    private void checkSelfPermissions(CallbackContext callbackContext){
        if (Transporter.checkSelfPermissions(this.cordova.getActivity().getApplicationContext())) {
          callbackContext.success("true");
        } else {
          callbackContext.success("false");
        }
    }

    private void requestPermissions(CallbackContext callbackContext){
        Transporter.requestPermissions(this.cordova.getActivity());
    }
}
