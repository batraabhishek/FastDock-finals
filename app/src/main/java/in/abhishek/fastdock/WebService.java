package in.abhishek.fastdock;

import in.abhishek.fastdock.models.Weather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abhishek on 12/03/16 at 11:17 PM.
 */
public interface WebService {


    @GET("v1/forecast.json")
    Call<Weather> getClimate(@Query("key") String appId, @Query("q") String query);


}
