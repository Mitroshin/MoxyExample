package com.developgmail.mitroshin.moxyexample;

import com.arellomobile.mvp.MvpView;

public interface HelloMoxyView extends MvpView {
    void showTimer();

    void hideTimer();

    void setTimer(int seconds);

    void showMessage(int message);
}
