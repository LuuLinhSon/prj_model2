package login;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rain Cool on 08-May-17.
 */

public class ServiceManage {


    public static InstagramService createService() {
        return getRetrofit().create(InstagramService.class);
    }



    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.instagram.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
