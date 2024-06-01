package com.example.fragmentbackstackmanging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.LoaderManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String ROOT_FRAGMENT_TAG = AFragment;
    Button fragA,fragB,fragC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragA=findViewById(R.id.fragmentA);
        fragB=findViewById(R.id.fragmentB);
        fragC=findViewById(R.id.fragmentC);


        fragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadfrag(new AFragment(),0);
            }
        });
        fragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new BFragment(),1);
            }
        });
        fragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new CFragment(),1);
            }
        });
    }


    public void loadfrag(Fragment fragment,int flag)
    {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag==0)
        {
            ft.add(R.id.container,fragment);
            fm.popBackStack(ROOT_FRAGMENT_TAG,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        }
        else
        {
            ft.replace(R.id.container,fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }
}