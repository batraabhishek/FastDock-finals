package in.abhishek.fastdock.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import in.abhishek.fastdock.R;
import in.abhishek.fastdock.adapters.PlaceAdapter;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int PLACE_AUTOCOMPLETE_REQUEST_CODE = 3342;
    private static final String TAG = "MapActivity";
    private GoogleMap mMap;
    private ListView mListView;
    private PlaceAdapter mPlaceAdapter;
    private TextView mHelpText;

    private ArrayList<Place> mPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlaces = new ArrayList<>();
        mPlaceAdapter = new PlaceAdapter(mPlaces, this);
        setContentView(R.layout.activity_maps);
        mHelpText = (TextView) findViewById(R.id.map_help_text);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        mListView = (ListView) findViewById(R.id.list_place);
        mListView.setAdapter(mPlaceAdapter);

        ActionBar action = getSupportActionBar();
        action.setDisplayShowHomeEnabled(false);
        action.setDisplayShowTitleEnabled(false);
        action.setDisplayShowCustomEnabled(true);
        action.setCustomView(R.layout.action_bar);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        action.setCustomView(action.getCustomView(), layoutParams);

        Toolbar parent = (Toolbar) action.getCustomView().getParent();
        parent.setContentInsetsAbsolute(0, 0);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                findPlace();
                return true;
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        findViewById(R.id.add_place).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPlace();
            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    public void addMarker(Place place) {
        mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title(place.getName().toString()));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(), 10));
    }


    public void findPlace() {
        try {
            AutocompleteFilter filter = new AutocompleteFilter.Builder()
                    .setTypeFilter(Place.TYPE_GEOCODE)
                    .build();

            Intent intent =
                    new PlaceAutocomplete
                            .IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .setFilter(filter)
                            .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            // TODO: Handle the error.
        } catch (GooglePlayServicesNotAvailableException e) {
            // TODO: Handle the error.
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i(TAG, "Place: " + place.getName());


                mHelpText.setText("Location List");

                addMarker(place);
                mPlaces.add(place);
                mPlaceAdapter.notifyDataSetChanged();
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                Log.i(TAG, status.getStatusMessage());


            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }

    public void launchTrip(View view) {

        if (mPlaces.size() == 0) {
            Snackbar.make(findViewById(R.id.root), "Add locations first", Snackbar.LENGTH_SHORT).show();
        } else {
            ArrayList<String> strings = new ArrayList<>();
            for (Place place : mPlaces) {
                Log.d(TAG, place.getAddress().toString());
                strings.add(place.getAddress().toString());
            }
            Intent intent = new Intent(this, RouteActivity.class);
            intent.putStringArrayListExtra("data", strings);
            startActivity(intent);
        }

    }
}
