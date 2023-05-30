package com.example.petcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;
    private BottomNavigationView mBottomNavigationView;
    private FragmentManager fragmentManager;

    private FloatingActionButton Fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomAppBar = findViewById(R.id.bottom_appbar);
        mBottomNavigationView = findViewById(R.id.bottom_nav);

        Fab = findViewById(R.id.fab);

        fragmentManager = getSupportFragmentManager();

        // Thiết lập fragment mặc định
        Fragment defaultFragment = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, defaultFragment).commit();
        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                // Xác định fragment tương ứng với mục menu được chọn
                switch (item.getItemId()) {
                    case R.id.Activity_Home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.Activity_Community:
                        selectedFragment = new CommunityFragment();
                        break;
                    case R.id.Place_holder:
                        break;
                    case R.id.Activity_Shop:
                        selectedFragment = new ShopFragment();
                        break;
                    case R.id.Activity_Chat:
                        selectedFragment = new ChatFragment();
                        break;

                }

                // Thay thế fragment hiện tại bằng fragment mới
                fragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }

}