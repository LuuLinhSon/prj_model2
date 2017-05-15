package vn.hackademicshanoi.prj_model.Model.Login;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import vn.hackademicshanoi.prj_model.API.APIPath;
import vn.hackademicshanoi.prj_model.Connection.DownloadJSONData;

/**
 * Created by Admin on 5/11/2017.
 */

public class ModelLogIn {
    public boolean KiemTraDangNhap(Context context,String id, String password){

        boolean kiemtra = false;

        String linkURL = APIPath.LOGIN_MANAGER_API;

        JSONObject jInfoUser = new JSONObject();
        try {
            jInfoUser.put("username",id);
            jInfoUser.put("password",password);
            String sJsonInfoUser = jInfoUser.toString();

            DownloadJSONData downloadJSONData = new DownloadJSONData(context,linkURL);
            downloadJSONData.execute(sJsonInfoUser);

            String dataJson = downloadJSONData.get();
            JSONObject jResult = new JSONObject(dataJson);
            String result = jResult.getString("error_code");

            if(result.equals("0")){
                kiemtra = true;
//                String tennv = jsonObject.getString("tennv");

            }else {
                kiemtra = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return kiemtra;
    }
}
