package in.abhishek.fastdock.network;

import android.location.Location;

import in.abhishek.fastdock.Constants;
import in.abhishek.fastdock.WebService;
import in.abhishek.fastdock.models.Weather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abhishek on 12/03/16 at 11:41 PM.
 */
public class WeatherApi {

    public static void getWeather(Location location, Callback<Weather> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();

        WebService webService = retrofit.create(WebService.class);
        String query = String.valueOf(location.getLatitude()) + "," + String.valueOf(location.getLongitude());
        Call<Weather> weather = webService.getClimate(Constants.API_KEY, query);

        weather.enqueue(callback);
    }
}
