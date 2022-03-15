/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.android.navigation.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController mNavController;
    private DrawerLayout mDrawerLayout;
    private NavHostFragment mNavHostFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        mDrawerLayout = binding.drawerLayout;
        FragmentManager fragmentManager = getSupportFragmentManager();
        mNavHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView);
        mNavController = mNavHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, mNavController, mDrawerLayout);
        NavigationView navView = findViewById(R.id.navView);
        NavigationUI.setupWithNavController(navView, mNavController);

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(mNavController.getGraph())
                        .setDrawerLayout(mDrawerLayout)
                        .build();
    }

    @Override
    public boolean onSupportNavigateUp() {

        return NavigationUI.navigateUp(mNavController, mDrawerLayout);
    }
}

