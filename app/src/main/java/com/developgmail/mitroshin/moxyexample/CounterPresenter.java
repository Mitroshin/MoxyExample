package com.developgmail.mitroshin.moxyexample;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class CounterPresenter extends MvpPresenter<CounterView> {
    private int mCount;

    public CounterPresenter() {
        getViewState().showCount(mCount);
    }

    public void onPlusClick() {
        mCount++;
        getViewState().showCount(mCount);
    }
}
