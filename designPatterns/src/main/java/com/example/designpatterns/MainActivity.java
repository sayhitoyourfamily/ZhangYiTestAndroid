package com.example.designpatterns;

import java.util.ArrayList;
import java.util.List;

import utils.LogKT;

import designpatterns.PeopleFactory;
import model.Person;
import model.User;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


/**
 * @author zhangyi
 *
 * TODO  设计模式，再次探索
 */
public class MainActivity extends Activity {
	private List<User> users=new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Person student=PeopleFactory.getStudent();
        Person user=PeopleFactory.getUser();
        student.say();
        user.say();
        users.add((User) user);
        LogKT.zy("------"+users.size());
        users.addAll(null);
        LogKT.zy("------"+users.size());
    }

}
