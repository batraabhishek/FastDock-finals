package in.abhishek.fastdock.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import in.abhishek.fastdock.R;
import in.abhishek.fastdock.fragments.MapFragment;
import in.abhishek.fastdock.models.Stop;


/**
 * Created by abhishek on 28/01/16 at 1:51 AM.
 */
public class StopAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Stop> mStops;

    public StopAdapter(Context context, ArrayList<Stop> stops) {
        mContext = context;
        mStops = stops;
    }

    @Override
    public int getCount() {
        return mStops.size();
    }

    @Override
    public Stop getItem(int i) {
        return mStops.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder holder;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            view = layoutInflater.inflate(R.layout.item_step, viewGroup, false);
            holder = new Holder();
        } else {
            holder = (Holder) view.getTag();
        }

        holder.bottom = view.findViewById(R.id.list_bottom);
        holder.top = view.findViewById(R.id.list_top);
        holder.distanceLayout = (LinearLayout) view.findViewById(R.id.list_distance_bg);
        holder.stopName = (TextView) view.findViewById(R.id.list_place);
        holder.stopDistance = (TextView) view.findViewById(R.id.list_distance);
        holder.stopNo = (TextView) view.findViewById(R.id.list_stop);
        holder.toStop = (TextView) view.findViewById(R.id.list_to_place);

        if (i == 0) {
            holder.top.setVisibility(View.INVISIBLE);
        } else {
            holder.top.setVisibility(View.VISIBLE);
        }

        if (i == getCount() - 1) {
            holder.bottom.setVisibility(View.INVISIBLE);
        } else {
            holder.bottom.setVisibility(View.VISIBLE);
        }

        Stop stop = getItem(i);
        holder.stopDistance.setText(stop.getDistance());
        holder.stopName.setText(stop.getPlace());
        holder.stopNo.setText("STOP " + stop.getStopNo());
        holder.stopNo.setTextColor(MapFragment.colors[i % MapFragment.colors.length]);
        holder.toStop.setText("To " + stop.getToStop());

        holder.distanceLayout.setBackgroundColor(MapFragment.colors[i % MapFragment.colors.length]);

        view.setTag(holder);

        return view;
    }

    public class Holder {
        TextView stopNo;
        TextView stopName;
        View top;
        View bottom;
        TextView stopDistance;
        LinearLayout distanceLayout;
        TextView toStop;

    }
}
