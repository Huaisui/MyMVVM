package com.example.mymvvm.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mymvvm.Model.User;
import com.example.mymvvm.R;
import com.example.mymvvm.ViewModel.MainViewModel;

/**
 * LiveData 使得数据可被观察者观察，观察者会自动更新 View 上的数据，而不需要每次数据被更新时都手动去刷新界面
 */
public class MainActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView ageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTextView = findViewById(R.id.user_name);
        ageTextView = findViewById(R.id.user_age);

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                nameTextView.setText(user.getName());
                ageTextView.setText(String.valueOf(user.getAge()));
            }
        });
        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.getUser().setValue(new User((int)System.currentTimeMillis()%100, "new user"));
            }
        });
    }
}