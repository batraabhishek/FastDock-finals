package in.abhishek.fastdock.network;

import android.location.Location;

import java.io.IOException;

import in.abhishek.fastdock.Constants;
import in.abhishek.fastdock.WebService;
import in.abhishek.fastdock.models.Weather;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abhishek on 18/03/16 at 11:10 PM.
 */
public class Util {


    public static void sendAlert(final Location location) {

        final OkHttpClient client = new OkHttpClient();

        new Thread(new Runnable() {
            @Override
            public void run() {

                RequestBody formBody = new FormBody.Builder()
                        .add("title", "Alert")
                        .add("message", "Panic button pressed\nClick to view location")
                        .add("url", "https://www.google.com/maps?q=" + location.getLatitude() + "," + location.getLongitude())
                        .add("subscriber_id", "80ecda18121e5d73e31ced6789c590eb")
                        .build();

                Request request = new Request.Builder()
                        .url("https://pushcrew.com/api/v1/send/individual")
                        .addHeader("Authorization", "96b88306134b6a36330a1ad7f1599895")
                        .post(formBody)
                        .build();

                Response response = null;
                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
