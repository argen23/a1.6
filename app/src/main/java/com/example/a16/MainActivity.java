package com.example.a16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a16.databinding.ActivityMainBinding;
import com.example.a16.fragments.DashboardFragment;
import com.example.a16.fragments.FormFragment;
import com.example.a16.fragments.HomeFragment;
import com.example.a16.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private DashboardFragment dashboardFragment;
    private ProfileFragment profileFragment;
    private ActivityMainBinding binding;
    private FormFragment formFragment;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment active;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        homeFragment = new HomeFragment();
        dashboardFragment = new DashboardFragment();
        profileFragment = new ProfileFragment();
        formFragment = new FormFragment();
        setSupportActionBar(binding.toolbar);
        binding.botNav.setOnNavigationItemSelectedListener(listener);
        active = homeFragment;
        fragmentManager.
                beginTransaction().add(R.id.fm_container, profileFragment, "profile")
                .hide(profileFragment).commit();
        fragmentManager.
                beginTransaction().add(R.id.fm_container, dashboardFragment, "Dash")
                .hide(dashboardFragment).commit();
        fragmentManager
                .beginTransaction()
                .add(R.id.fm_container, homeFragment, "home")
                .hide(homeFragment).commit();
        fragmentManager.beginTransaction().add(R.id.fm_container,formFragment,"form")
                .hide(formFragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.hom:
                        fragmentManager.beginTransaction().hide(active).show(homeFragment).commit();
                        binding.tvAppBar.setText(R.string.home);
                        active = homeFragment;
                        return true;
                    case R.id.dashboard:
                        fragmentManager.beginTransaction().hide(active).show(dashboardFragment).commit();
                        binding.tvAppBar.setText(R.string.dash);
                        active = dashboardFragment;
                        return true;
                    case R.id.profile:
                        fragmentManager.beginTransaction().hide(active).show(profileFragment).commit();
                        binding.tvAppBar.setText(R.string.profile);
                        active = profileFragment;
                        return true;
                }
                return false;
            };
}