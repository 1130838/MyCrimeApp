package com.brunodevesa.mycrimeapp;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.brunodevesa.mycrimeapp.model.Crime;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

   /* @Override
    protected Fragment createFragment() {

        return new CrimeFragment();
    }*/


/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        Fragment fragmentOne = fm.findFragmentById(R.id.main_layout_id);

        if (fragmentOne == null) {
            fragmentOne = new CrimeFragment();
            fm.beginTransaction().add(R.id.main_layout_id, fragmentOne).commit();
        }

    }*/




    // Intent and Key to receive the Intent

    private static final String EXTRA_CRIME_ID = "com.brunodevesa.mycrimeapp.crime_id";


    protected Fragment createFragment(){
    UUID crimeId = (UUID)getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }


    // start a new Activity from a fragment:
    public static Intent newIntent(Context pacakgeContext,UUID crimeId){
        Intent intent = new Intent(pacakgeContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;

    }

}
