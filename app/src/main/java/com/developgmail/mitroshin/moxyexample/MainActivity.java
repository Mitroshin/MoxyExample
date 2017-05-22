package com.developgmail.mitroshin.moxyexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.MvpAppCompatActivity;

// Так как Activity наследует MvpAppCompatActivity, в момент вызова onCreate() будут
// проинициализированы все поля, отмеченные аннотацией @InjectPresenter
public class MainActivity extends MvpAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction
                    .add(R.id.frame_1, getFragment(0xFFFF80AB))
                    .add(R.id.frame_2, getFragment(0xFFCCFF90))
                    .commit();
        }
    }

    private Fragment getFragment(int color) {
        CounterFragment fragment =  new CounterFragment();
        Bundle args = new Bundle();
        args.putInt("argColor", color);
        fragment.setArguments(args);
        return fragment;
    }
}
