package com.example.mymvvm.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymvvm.Model.User;

public class MainViewModel extends ViewModel {
    private MutableLiveData<User> user; // LiveData

    public MutableLiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
            loadUser();
        }
        return user;
    }

    private void loadUser() {
        User myUser = new User(1,"name");
        user.setValue(myUser);
    }
}
