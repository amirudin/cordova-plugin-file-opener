package io.github.pwlin.cordova.plugins.fileopener;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

public class FileOpener extends CordovaPlugin {

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action        The action to execute.
     * @param args          JSONArry of arguments for the plugin.
     * @param callbackId    The callback id used when calling back into JavaScript.
     * @return              A PluginResult object with a status and message.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
    	
    	   	
        PluginResult.Status status = PluginResult.Status.OK;
        String result = "";

        try {
            if (action.equals("open")) {
                result = this.open(args.getString(0), args.getString(1));
                if (result.length() > 0) {
                    status = PluginResult.Status.ERROR;
                }
            }
            return new PluginResult(status, result) != null;
        } catch (JSONException e) {
            return new PluginResult(PluginResult.Status.JSON_EXCEPTION) != null;
        }
    }

    /**
     * Identifies if action to be executed returns a value and should be run synchronously.
     *
     * @param action    The action to execute
     * @return          T=returns value
     */
    public boolean isSynch(String action) {
        return false;
    }

    /**
     * Called by AccelBroker when listener is to be shut down.
     * Stop listener.
     */
    public void onDestroy() {
    }

    //--------------------------------------------------------------------------
    // LOCAL METHODS
    //--------------------------------------------------------------------------

    public String open(String fileName, String contentType) {
    	
    	File file = new File(fileName);

        if (file.exists()) {
        	try {
	        	Uri path = Uri.fromFile(file);
	            Intent intent = new Intent(Intent.ACTION_VIEW);
	            intent.setDataAndType(path, contentType);
	            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            //intent.setData(Uri.parse(fileName));
                /////////this.ctx.startActivity(intent);
	            cordova.getActivity().startActivity(intent);
                return "";
            } catch (android.content.ActivityNotFoundException e) {
                //System.out.println("FileOpener: Error opening "+fileName+":"+ e.toString());
                return e.toString();
            }            
        } else {
        	return "file not found";
        }
    }

}
