package com.developgmail.mitroshin.moxyexample;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

// Так как Activity наследует MvpAppCompatActivity, в момент вызова onCreate() будут
// проинициализированы все поля, отмеченные аннотацией @InjectPresenter
public class MainActivity extends MvpAppCompatActivity implements HelloMoxyView {
    @InjectPresenter
    HelloMoxyPresenter mHelloMoxyPresenter;

    private TextView mTimerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTimerTextView = (TextView) findViewById(R.id.timer_text_view);
    }

    @Override
    public void showTimer() {
        mTimerTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTimer() {
        mTimerTextView.setVisibility(View.GONE);
    }

    @Override
    public void setTimer(int seconds) {
        mTimerTextView.setText(getString(R.string.timer, seconds));
    }

    @Override
    public void showMessage(int message) {
        TextView messageTextView = new TextView(this);
        messageTextView.setText(message);
        messageTextView.setTextSize(40);
        messageTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        ((ViewGroup) findViewById(R.id.activity_main)).addView(messageTextView);
    }
}
