package com.developgmail.mitroshin.moxyexample;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface HelloMoxyView extends MvpView {
    void showTimer();

    void hideTimer();

    void setTimer(int seconds);

    void showMessage(int message);

    void hideMessage();
}
