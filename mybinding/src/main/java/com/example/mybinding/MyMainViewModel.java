package com.example.mybinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyMainViewModel extends ViewModel {
    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<User> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
            loadUser();
        }
        return userMutableLiveData;
    }

    private void setNewUser(User user) {
        userMutableLiveData.setValue(user);
    }

    private void loadUser() {
        User myUser = new User(1, "create from mutableData");
        userMutableLiveData.setValue(myUser);
    }

    public void changeUser() {
        int age = getUser().getValue().getAge() + 1;
        String name = getUser().getValue().getName() + "_";
        User newUser = new User(age, name);
        setNewUser(newUser);
    }
}

