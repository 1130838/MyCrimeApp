package com.brunodevesa.mycrimeapp;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.brunodevesa.mycrimeapp.model.Crime;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }


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


}
