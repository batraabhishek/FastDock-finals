package in.abhishek.fastdock.activites;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import in.abhishek.fastdock.R;
import in.abhishek.fastdock.adapters.CurrencyAdapter;
import in.abhishek.fastdock.adapters.CurrencySpinnerAdapter;
import in.abhishek.fastdock.models.Currency;

public class CurrencyActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private CurrencySpinnerAdapter mSpinnerAdapter;
    private ListView mListView;
    private CurrencyAdapter mCurrencyAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
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

        mSpinner = (Spinner) findViewById(R.id.currency_spinner);
        mSpinnerAdapter = new CurrencySpinnerAdapter(this);
        mSpinner.setAdapter(mSpinnerAdapter);
        mListView = (ListView) findViewById(R.id.list_currency);

        mCurrencyAdapter = new CurrencyAdapter(Currency.values()[0], CurrencyActivity.this);
        mListView.setAdapter(mCurrencyAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Currency currency = Currency.values()[i];
                mCurrencyAdapter = new CurrencyAdapter(currency, CurrencyActivity.this);
                mListView.setAdapter(mCurrencyAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void checkCurrency(View view) {

        Currency currency = (Currency) mSpinner.getSelectedItem();
        if(mCurrencyAdapter.getCheckedCount() >= currency.getPassValue()) {
            Snackbar.make(view, "Valid currency", Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(view, "Conditions not met. Need for info for validating", Snackbar.LENGTH_SHORT).show();
        }

    }
}
