package com.example.nbateamsproject;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.nbateamsproject.RecyclerView.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager2 viewPager;
    private String array[] = {"List", "Team Details"};

    // When you pass the context or activity, do not initialize your class here. Activity is not fully loaded yet
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.main_activity_viewpager);
        tabs = findViewById(R.id.main_activity_tabs);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(array[position]);
            }
        }).attach();
    }

    public void onClick(View view) {
        viewPager.setCurrentItem(1);
    }

}