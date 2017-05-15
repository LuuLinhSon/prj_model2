package vn.hackademicshanoi.prj_model.Connection;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Admin on 5/11/2017.
 */

public class DownloadJSONData extends AsyncTask<String,Void,String> {

    Context context;
    String linkURL;
    ProgressDialog pbLoading;
    OutputStream os;
    InputStream is;
    String result;

    public DownloadJSONData(Context context,String linkURL){
        this.context = context;
        this.linkURL = linkURL ;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pbLoading = new ProgressDialog(context);
        pbLoading.setMessage("Vui lòng đợi....");
        pbLoading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pbLoading.setCancelable(true);
        pbLoading.setCanceledOnTouchOutside(false);

        pbLoading.show();

    }

    @Override
    protected String doInBackground(String... params) {
        String jsondata = params[0];

        try {
            URL url = new URL(linkURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();

            os = httpURLConnection.getOutputStream();
            os.write(jsondata.getBytes());

            is = httpURLConnection.getInputStream();
            result = "";
            int byteCharacrer;
            while ((byteCharacrer = is.read()) != -1){
                result += (char)byteCharacrer;
            }

            is.close();
            os.close();
            httpURLConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
