package in.abhishek.fastdock.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.gms.location.places.Place;

import java.util.ArrayList;

import in.abhishek.fastdock.R;

/**
 * Created by abhishek on 17/03/16 at 11:49 PM.
 */
public class PlaceAdapter extends BaseAdapter {

    ArrayList<Place> mPlaces;
    Context mContext;

    public PlaceAdapter(ArrayList<Place> places, Context context) {
        mPlaces = places;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mPlaces.size();
    }

    @Override
    public Place getItem(int i) {
        return mPlaces.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView destinationName;

        if(view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(R.layout.item_main, viewGroup, false);
            destinationName = (TextView) view.findViewById(R.id.list_text_main);
        } else {
            destinationName = (TextView) view.getTag();
        }

        Place place = getItem(i);
        destinationName.setText(place.getName());

        view.setTag(destinationName);

        return view;
    }
}
