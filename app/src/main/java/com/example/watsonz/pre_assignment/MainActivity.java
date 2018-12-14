package com.example.watsonz.pre_assignment;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.watsonz.pre_assignment.databinding.ActivityMainBinding;

import viewmodel.MainViewmodel;

public class MainActivity extends AppCompatActivity {

    private MainViewmodel model = new MainViewmodel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(model);

        model.OnCreate();
    }
}
