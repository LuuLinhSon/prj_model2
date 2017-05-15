package vn.hackademicshanoi.prj_model.Connection;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Admin on 5/15/2017.
 */

public class GetJSONData extends AsyncTask<Void,Void,String> {

    String linkURL;
    public GetJSONData(String linkURL){
        this.linkURL = linkURL;
    }

    @Override
    protected String doInBackground(Void... params) {
        String result = "";
        try {
            URL url = new URL(linkURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();

            InputStream is = httpURLConnection.getInputStream();

            int byteCharacter;
            while ((byteCharacter = is.read()) != -1) {
                result += (char) byteCharacter;
            }

            is.close();
            httpURLConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
