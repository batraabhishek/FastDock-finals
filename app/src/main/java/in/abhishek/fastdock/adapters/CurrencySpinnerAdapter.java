package in.abhishek.fastdock.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import in.abhishek.fastdock.models.Currency;

/**
 * Created by abhishek on 18/03/16 at 8:41 PM.
 */
public class CurrencySpinnerAdapter extends BaseAdapter {

    private Context mContext;

    public CurrencySpinnerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Currency.values().length;
    }

    @Override
    public Currency getItem(int i) {
        return Currency.values()[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        }

        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        textView.setText("Rs" + Currency.values()[i].getDenom());

        return view;
    }
}
