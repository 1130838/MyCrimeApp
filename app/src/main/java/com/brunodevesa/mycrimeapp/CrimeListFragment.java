package com.brunodevesa.mycrimeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.brunodevesa.mycrimeapp.model.Crime;
import com.brunodevesa.mycrimeapp.model.CrimeLab;

import java.lang.annotation.Target;
import java.util.List;

/**
 * Created by bruno.devesa on 11/03/2016.
 */
public class CrimeListFragment extends Fragment {
    // nothing yet

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mCrimeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    // so the recyclerView can be updated when changes in detail happens
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimesList();

        if (mCrimeAdapter == null) {

            mCrimeAdapter = new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mCrimeAdapter);
        }
        else{
            mCrimeAdapter.notifyDataSetChanged();
        }
    }


    // VIEW HOLDER ( define what u want to show in the Recycler List )
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Crime mCrime;
        //public TextView mTitleTextView;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        public CrimeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this); // the whole view will be clickable

            // all the widgets in the xml file View will be initialize here
            mTitleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);

        }

        // define what the widgets will have in relation to the model
        public void bindCrime(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());
            mSolvedCheckBox.setChecked(mCrime.isSolved());
        }


        @Override
        public void onClick(View v) {


            Intent intent = CrimeActivity.newIntent(getActivity(), mCrime.getiD());
            startActivity(intent);

            //Intent intent = new Intent(getActivity(), CrimeActivity.class);
            //startActivity(intent);

            //Toast.makeText(getActivity(), "You clicked crime #" + mCrime.getTitle(), Toast.LENGTH_SHORT).show();
        }
    }


    // ADAPTER
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        private List<Crime> mCrimes;

        // this method is called by RecyclerView when it needs a View to display an item
        // in this method you create the View and wrap it in a ViewHolder
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            // list_item_crime is the xml file that gonna inflate. However, the widgets of the layout must be coehrent in the ViewHolder
            View view = layoutInflater.inflate(R.layout.list_item_crime, parent, false); // list_itm_crime is the xml file that gonna inflate
            return new CrimeHolder(view);
        }

        // this method will bind a ViewHolder's to the model objects.
        // it receive the ViewHolder and a position. to bind the View, you use that position to find the right model data.
        // this method to define what widgets will have.
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            //holder.mTitleTextView.setText(crime.getTitle());

            holder.bindCrime(crime);

        }


        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }


}
