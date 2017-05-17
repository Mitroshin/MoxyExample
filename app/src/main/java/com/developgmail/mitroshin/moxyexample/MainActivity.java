package com.developgmail.mitroshin.moxyexample;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
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

    private AlertDialog mMessageDialog;
    private TextView mTimerTextView;
    private View mMessageView;

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
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_main);
        mMessageView = LayoutInflater.from(this).inflate(R.layout.item_message, rootView, false);
        rootView.addView(mMessageView);
        ((TextView) mMessageView.findViewById(R.id.item_message_text_view)).setText(message);
        mMessageView.findViewById(R.id.item_message_close_button)
                .setOnClickListener(v -> mHelloMoxyPresenter.onDismissMessage());

//        mMessageDialog = new AlertDialog.Builder(this)
//                .setTitle(R.string.app_name)
//                .setMessage(message)
//                .setPositiveButton(android.R.string.ok, null)
////                Все мобытия пользовательского интерфейса нужно передавать в Presenter
//                .setOnDismissListener(dialogInterface -> mHelloMoxyPresenter.onDismissMessage())
//                .show();
    }

    @Override
    public void hideMessage() {
        ViewGroup rootView = (ViewGroup) findViewById(R.id.activity_main);
        rootView.removeView(mMessageView);
//        if (mMessageDialog != null) {
//            mMessageDialog.dismiss();
//        }
    }
}
