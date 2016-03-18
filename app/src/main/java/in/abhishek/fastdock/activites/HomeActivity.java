package in.abhishek.fastdock.activites;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yayandroid.locationmanager.LocationBaseActivity;
import com.yayandroid.locationmanager.LocationConfiguration;
import com.yayandroid.locationmanager.LocationManager;
import com.yayandroid.locationmanager.constants.LogType;
import com.yayandroid.locationmanager.constants.ProviderType;

import in.abhishek.fastdock.R;
import in.abhishek.fastdock.activites.MapsActivity;
import in.abhishek.fastdock.models.Weather;
import in.abhishek.fastdock.network.WeatherApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends LocationBaseActivity {

    private static final String TAG = "HomeActivity";

    private TextView mTextCity;
    private TextView mTextCondition;
    private TextView mTextTemp;

    @Override
    public LocationConfiguration getLocationConfiguration() {
        return new LocationConfiguration()
                .keepTracking(true)
                .askForGooglePlayServices(true)
                .setMinAccuracy(200.0f)
                .setWaitPeriod(ProviderType.GOOGLE_PLAY_SERVICES, 5 * 1000)
                .setWaitPeriod(ProviderType.GPS, 10 * 1000)
                .setWaitPeriod(ProviderType.NETWORK, 5 * 1000)
                .setGPSMessage("Would you mind to turn GPS on?")
                .setRationalMessage("Gimme the permission!");
    }

    @Override
    public void onLocationFailed(int failType) {
    }

    @Override
    public void onLocationChanged(Location location) {

        WeatherApi.getWeather(location, new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Weather weather = response.body();

                mTextCondition.setText((weather.getCurrent().getCondition().getText()));
                mTextCity.setText(weather.getLocation().getName());
                int temp = weather.getCurrent().getFeelslikeC().intValue();
                mTextTemp.setText(String.valueOf(temp) + "\u2103");
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar action = getSupportActionBar();
        action.setDisplayShowHomeEnabled(false);
        action.setDisplayShowTitleEnabled(false);
        action.setDisplayShowCustomEnabled(true);
        action.setCustomView(R.layout.action_bar);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        action.setCustomView(action.getCustomView(), layoutParams);

        Toolbar parent = (Toolbar) action.getCustomView().getParent();
        parent.setContentInsetsAbsolute(0, 0);


        mTextCity = (TextView) findViewById(R.id.home_city);
        mTextCondition = (TextView) findViewById(R.id.home_condition);
        mTextTemp = (TextView) findViewById(R.id.home_temperature);

        LocationManager.setLogType(LogType.IMPORTANT);
        getLocation();
    }

    public void planNewTrip(View view) {

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void startCurrencyChecker(View view) {

        Intent intent = new Intent(this, CurrencyActivity.class);
        startActivity(intent);

    }
}
