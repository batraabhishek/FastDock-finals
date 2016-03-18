package in.abhishek.fastdock.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import in.abhishek.fastdock.R;
import in.abhishek.fastdock.models.Currency;
import in.abhishek.fastdock.models.CurrencyWrapper;

/**
 * Created by abhishek on 18/03/16 at 9:37 PM.
 */
public class CurrencyAdapter extends BaseAdapter {

    private static final String TAG = "CurrencyAdapter";
    private ArrayList<CurrencyWrapper> mWrappers;
    private Context mContext;

    public CurrencyAdapter(Currency currency, Context context) {
        mContext = context;

        mWrappers = new ArrayList<>();
        for (String cond : currency.getConditions()) {
            mWrappers.add(new CurrencyWrapper(cond, false));
        }
    }

    @Override
    public int getCount() {
        return mWrappers.size();
    }

    @Override
    public CurrencyWrapper getItem(int i) {
        return mWrappers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder holder;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.item_currency, viewGroup, false);
            holder = new Holder();
        } else {
            holder = (Holder) view.getTag();
        }

        final CurrencyWrapper wrapper = getItem(i);

        holder.mCurrencyText = (TextView) view.findViewById(R.id.currency_text);
        holder.mBox = (CheckBox) view.findViewById(R.id.currency_check);
        holder.mCurrencyText.setText(wrapper.getText());

        holder.mBox.setChecked(wrapper.isChecked());

        holder.mBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrapper.setIsChecked(!wrapper.isChecked());
            }
        });
        view.setTag(holder);

        return view;
    }

    public int getCheckedCount() {

        int count = 0;
        for(CurrencyWrapper wrapper : mWrappers) {

            if(wrapper.isChecked()) {
                count++;
            }
        }
        return count;
    }

    public class Holder {
        TextView mCurrencyText;
        CheckBox mBox;
    }
}
