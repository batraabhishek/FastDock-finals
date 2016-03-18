package in.abhishek.fastdock.network;

import android.util.Log;

import java.util.ArrayList;

import in.abhishek.fastdock.fragments.MapFragment;
import in.abhishek.fastdock.fragments.StopFragment;
import in.abhishek.fastdock.models.WayPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abhishek on 27/01/16 at 9:02 PM.
 */
public class FindRoute {

    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/";
    public static final String API_KEY = "AIzaSyAWvRtY3YHKAnrjDDNmaMiIwmm1HM3TQJs";
    private static final String TAG = "FindRoute";


    public static void getResponse(String source, String destination, ArrayList<String> wayPoints, final MapFragment mapFragment) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WayPointService wayPointService = retrofit.create(WayPointService.class);

        String wayPointsString = "optimize:true";
        for (String wayPoint : wayPoints) {
            wayPointsString += "|" + urlEncode(wayPoint);
        }

        Log.d(TAG, wayPointsString);


        Call<WayPoint> call = null;
        call = wayPointService.getWayPoints(urlEncode(source), urlEncode(destination), wayPointsString, API_KEY);
        call.enqueue(new Callback<WayPoint>() {
            /**
             * Invoked for a received HTTP response.
             * <p/>
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call {@link Response#isSuccess()} to determine if the response indicates success.
             *
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<WayPoint> call, Response<WayPoint> response) {
                WayPoint wayPoint = response.body();
                Log.d(TAG, wayPoint.getStatus());
                mapFragment.plotPoints(wayPoint);
                ((StopFragment) StopFragment.newInstance()).updateList(wayPoint);
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             *
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<WayPoint> call, Throwable t) {
                Log.d(TAG, "Failure");
            }

        });


    }

    public static String urlEncode(String data) {
        return data.replaceAll(" ", "+");
    }

    public interface WayPointService {
        @GET("directions/json")
        Call<WayPoint> getWayPoints(@Query("origin") String origin, @Query("destination") String destination, @Query("waypoints") String wayPoints, @Query("key") String key);
    }
}
