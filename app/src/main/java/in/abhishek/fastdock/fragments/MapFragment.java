package in.abhishek.fastdock.fragments;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;
import com.google.maps.android.ui.IconGenerator;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import in.abhishek.fastdock.R;
import in.abhishek.fastdock.models.Leg;
import in.abhishek.fastdock.models.Route;
import in.abhishek.fastdock.models.WayPoint;
import in.abhishek.fastdock.network.FindRoute;


/**
 * Created by abhishek on 13/09/15 at 4:52 PM.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = "Map Fragment";
    public static int[] colors = {
            Color.parseColor("#EF5350"),
            Color.parseColor("#66BB6A"),
            Color.parseColor("#AB47BC"),
            Color.parseColor("#7E57C2"),
            Color.parseColor("#5C6BC0"),
            Color.parseColor("#26A69A"),
            Color.parseColor("#66BB6A"),
            Color.parseColor("#78909C"),
    };
    private GoogleMap mGoogleMap;
    private MapView mMapView;

    public static Fragment newInstance() {
        return new MapFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.tripMapView);
        mMapView.onCreate(savedInstanceState);


        mMapView.getMapAsync(this);
        mMapView.onResume();

        return rootView;
    }


    public void addMarker(LatLng point, String placeName, int index, String completeName) {

        TextView textView = new TextView(getContext());
        textView.setText(placeName);
        textView.setPadding(30, 10, 30, 10);
        textView.setTextColor(Color.WHITE);
        IconGenerator factory = new IconGenerator(getContext());
        factory.setContentView(textView);
        factory.setColor(colors[index % colors.length]);
        Bitmap icon = factory.makeIcon();
        mGoogleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(icon))
                .position(point)
                .title(completeName));

    }


    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        if (getActivity().getIntent().getBooleanExtra("JSON", false)) {

            String data = getActivity().getIntent().getStringExtra("JSON_DATA");
            try {
                JSONArray jsonArray = new JSONArray(data);
                ArrayList<String> strings = new ArrayList<>();
                String src = null;
                for (int i = 0; i < jsonArray.length(); i++) {
                    if (i == 0) {
                        src = jsonArray.getString(i);
                    } else {
                        strings.add(jsonArray.getString(i));
                    }
                }

                FindRoute.getResponse(src, src, strings, this);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            ArrayList<String> wayPoints = getActivity().getIntent().getStringArrayListExtra("data");
            String source = wayPoints.get(0);
            wayPoints.remove(0);
            source = source.replace("Source: ", "");
            FindRoute.getResponse(source, source, wayPoints, this);
        }
    }

    public void plotPoints(WayPoint wayPoint) {

        ArrayList<LatLng> points = new ArrayList<>();

        int count = 0;

        if (wayPoint.getRoutes() != null && wayPoint.getRoutes().size() > 0) {
            Route route = wayPoint.getRoutes().get(0);
            LatLng northEast = new LatLng(route.getBounds().getNortheast().getLat(), route.getBounds().getNortheast().getLng());
            LatLng southWest = new LatLng(route.getBounds().getSouthwest().getLat(), route.getBounds().getSouthwest().getLng());

            LatLngBounds latLngBounds = new LatLngBounds(southWest, northEast);
            mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 150));
            Log.d(TAG, route.getOverviewPolyline().getPoints());

            List<LatLng> latLngs = PolyUtil.decode(route.getOverviewPolyline().getPoints());

            for (LatLng latLng : latLngs) {
                points.add(latLng);
            }


            for (Leg leg : route.getLegs()) {
                count++;
                LatLng dest = new LatLng(leg.getStartLocation().getLat(), leg.getStartLocation().getLng());
                addMarker(dest, "Stop: " + count + ". " + leg.getStartAddress().substring(0, leg.getStartAddress().indexOf(',')), count, leg.getStartAddress());

            }

            PolylineOptions polyLineOptions = new PolylineOptions();
            polyLineOptions.addAll(points);
            polyLineOptions.width(8);
            polyLineOptions.color(ContextCompat.getColor(getContext(), R.color.color_1));

            mGoogleMap.addPolyline(polyLineOptions);
        }


    }
}
