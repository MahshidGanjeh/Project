package com.example.yara;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.yara.Retrofit.RetrofitActivity;


public class CategoryFragment extends Fragment {

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BottomNavigationView mBottomNavigationView = view.findViewById(R.id.bottom_navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_navigation_home:
                                RegisterFragment registerFragment = new RegisterFragment();
                                android.support.v4.app.FragmentManager fm = getFragmentManager();
                                fm.beginTransaction().replace(R.id.fragment_container, registerFragment).commit();
                                return true;
                            case R.id.bottom_navigation_category:
                                CategoryFragment categoryFragment = new CategoryFragment();
                                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                fragmentManager.beginTransaction().replace(R.id.fragment_container, categoryFragment).commit();
                                return true;
                            case R.id.bottom_navigation_users:
                                startActivity(new Intent(getContext(), RetrofitActivity.class));
                                return true;
                            default:
                                return false;
                        }
                    }
                });

    }
}
