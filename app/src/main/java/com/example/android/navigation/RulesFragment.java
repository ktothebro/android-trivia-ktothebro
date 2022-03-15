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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.android.navigation.databinding.FragmentRulesBinding;


public class RulesFragment extends Fragment {
    private NavController mNavController;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentRulesBinding binding = FragmentRulesBinding.inflate(inflater);
        mNavController = NavHostFragment.findNavController(this);
        binding.playButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNavController.navigate(R.id.action_rulesFragment_to_gameFragment);
            }
        });

        return binding.getRoot();
    }
}
