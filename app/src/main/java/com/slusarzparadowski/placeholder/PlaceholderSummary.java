package com.slusarzparadowski.placeholder;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slusarzparadowski.homebudget.R;

/**
 * Created by Dominik on 2015-03-22.
 */
public class PlaceholderSummary extends Fragment {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderSummary newInstance(int sectionNumber) {
        PlaceholderSummary fragment = new PlaceholderSummary();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    public PlaceholderSummary() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_summary, container, false);
        Bundle bundle = this.getArguments();
        double income = bundle.getDouble("income");
        double outcome = bundle.getDouble("outcome");
        tv1 = (TextView) rootView.findViewById(R.id.textViewSummaryIncome);
        tv2 = (TextView) rootView.findViewById(R.id.textViewSummaryOutcome);
        tv3 = (TextView) rootView.findViewById(R.id.textViewSummarySummary);
        tv1.setText("Income: "+ String.valueOf(income));
        tv2.setText("Outcome: "+ String.valueOf(outcome));
        double r = (income - outcome);
        if(r < 0)
            tv3.setTextColor(Color.RED);
        else
            tv3.setTextColor(Color.GREEN);
        tv3.setText("Summary: "+ String.valueOf(r));
        return rootView;
    }
}