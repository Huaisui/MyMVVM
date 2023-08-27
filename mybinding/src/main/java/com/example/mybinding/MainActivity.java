package com.example.mybinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import com.example.mybinding.databinding.ActivityMainBinding;

/**
 * DataBinding 使得 ViewModel 和 View 双向绑定
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyMainViewModel myMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main); 用 DataBindingUtil.setContentView 代替
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        myMainViewModel = new ViewModelProvider(this).get(MyMainViewModel.class);
/**
    mainViewModel.getUser().observe(this, new Observer<User>() {
        @Override
        public void onChanged(User user) {
            binding.userName.setText(user.getName());
            binding.userAge.setText(String.valueOf(user.getAge()));
        }
    });
    binding.userName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "This is name textView", Toast.LENGTH_SHORT).show();
        }
    });
 使用 DataBinding 不需要以上代码，生成类会有观察者观察数据的变化，绑定视图
**/
        binding.setMyMainViewModel(myMainViewModel);
        binding.setUser(new User(100, "create from User"));
        binding.setLifecycleOwner(this);

    }
}