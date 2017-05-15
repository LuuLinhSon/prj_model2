package vn.hackademicshanoi.prj_model.Model.Profile;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import vn.hackademicshanoi.prj_model.API.APIPath;
import vn.hackademicshanoi.prj_model.Connection.DownloadJSONData;
import vn.hackademicshanoi.prj_model.Connection.GetJSONData;
import vn.hackademicshanoi.prj_model.Model.Object.Profile;

/**
 * Created by Admin on 5/15/2017.
 */

public class ModelProfile {

    ArrayList<String> listHeight;
    ArrayList<String> listWeight;
    ArrayList<String> listSizeShoe;
    ArrayList<String> listSizeClothes;
    ArrayList<String> listMagazines;
    ArrayList<ArrayList> listProfile;

    public ArrayList<ArrayList> LayDuLieuProfileOne(Context context){

        boolean kiemtra = false;
        String linkURL = APIPath.GET_PROFILE_API;

        GetJSONData getJSONData = new GetJSONData(linkURL);
        getJSONData.execute();
        try {
            String result = getJSONData.get();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject jDataInit = jsonObject.getJSONObject("data_init");
            JSONArray jHeights = jDataInit.getJSONArray("height");
            int coutHeights = jHeights.length();
            for (int i = 0; i < coutHeights; i++) {
                JSONObject jHeight = jHeights.getJSONObject(i);
                String height1 = jHeight.getString("1");
                String height2 = jHeight.getString("2");

                listHeight = new ArrayList<>();
                listHeight.add(height1);
                listHeight.add(height2);
            }
            JSONArray jWeights = jDataInit.getJSONArray("weight");
            int coutWeight = jWeights.length();
            for (int i = 0; i < coutWeight; i++) {
                JSONObject jWeight = jHeights.getJSONObject(i);
                String weight1 = jWeight.getString("1");
                String weight2 = jWeight.getString("2");

                listWeight = new ArrayList<>();
                listWeight.add(weight1);
                listWeight.add(weight2);
            }
            JSONArray jSizeShoes = jDataInit.getJSONArray("size_shoe");
            int coutSizeShoes = jSizeShoes.length();
            for (int i = 0; i < coutSizeShoes; i++) {
                JSONObject jSizeShoe = jSizeShoes.getJSONObject(i);
                String sizeShoe1 = jSizeShoe.getString("1");
                String sizeShoe2 = jSizeShoe.getString("2");

                listSizeShoe = new ArrayList<>();
                listSizeShoe.add(sizeShoe1);
                listSizeShoe.add(sizeShoe1);
            }
            JSONArray jSizeClothes = jDataInit.getJSONArray("size_clothes");
            int coutSizeClothes = jSizeClothes.length();
            for (int i = 0; i < coutSizeClothes; i++) {
                JSONObject jSizeClothe = jSizeClothes.getJSONObject(i);
                String sizeClothe1 = jSizeClothe.getString("1");
                String sizeClothe2 = jSizeClothe.getString("2");

                listSizeClothes = new ArrayList<>();
                listSizeClothes.add(sizeClothe1);
                listSizeClothes.add(sizeClothe2);
            }

            JSONArray jMagazines = jDataInit.getJSONArray("magazine");
            int coutMagazines = jMagazines.length();
            for (int i = 0; i < coutMagazines; i++) {
                JSONObject jMagazine = jMagazines.getJSONObject(i);
                String magazine1 = jMagazine.getString("1");
                String magazine2 = jMagazine.getString("2");

                listMagazines = new ArrayList<>();
                listMagazines.add(magazine1);
                listMagazines.add(magazine2);
            }

            listProfile = new ArrayList<>();
            listProfile.add(listHeight);
            listProfile.add(listWeight);
            listProfile.add(listSizeShoe);
            listProfile.add(listSizeClothes);
            listProfile.add(listMagazines);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return listProfile ;
    }

}
