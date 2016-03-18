package in.abhishek.fastdock.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import in.abhishek.fastdock.adapters.StopAdapter;
import in.abhishek.fastdock.models.Leg;
import in.abhishek.fastdock.models.Route;
import in.abhishek.fastdock.models.Stop;
import in.abhishek.fastdock.models.WayPoint;


/**
 * Created by abhishek on 28/01/16 at 2:01 AM.
 */
public class StopFragment extends ListFragment {

    private static Fragment instance;

    public static Fragment newInstance() {

        if(instance == null) {
            instance =  new StopFragment();
        }

        return instance;
    }


    private ArrayList<Stop> mStops;
    private StopAdapter mStopAdapter;

    /**
     * Attach to list view once the view hierarchy has been created.
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mStops = new ArrayList<>();
        mStopAdapter = new StopAdapter(getContext(), mStops);

        setListAdapter(mStopAdapter);
        setEmptyText("No Route Found");
        getListView().setDividerHeight(0);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Stop stop = mStops.get(i);
                String startCord = stop.getStartCord();
                String endCord = stop.getEndCord();
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=" + startCord + "&daddr=" + endCord));
                startActivity(intent);
            }
        });


    }

    public void updateList(WayPoint wayPoint) {


        if (wayPoint.getRoutes() != null && wayPoint.getRoutes().size() > 0) {
            Route route = wayPoint.getRoutes().get(0);
            int count = 1;
            for (Leg leg : route.getLegs()) {
                Stop stop = new Stop(count++, leg.getStartAddress().substring(0, leg.getStartAddress().indexOf(',')), leg.getDistance().getText(), leg.getEndAddress().substring(0, leg.getEndAddress().indexOf(',')), leg.getStartLocation(), leg.getEndLocation());
                mStops.add(stop);

            }

            mStopAdapter.notifyDataSetChanged();
        }
    }
}
