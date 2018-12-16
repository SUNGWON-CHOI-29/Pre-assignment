package com.example.watsonz.pre_assignment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.watsonz.pre_assignment.databinding.ActivityMainBinding;

import model.MovieItem;
import viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel model = new MainViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        model = ViewModelProviders.of(this).get(MainViewModel.class);
        if (savedInstanceState == null) {
            model.init();
        }
        binding.setModel(model);
    }
}
