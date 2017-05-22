package com.developgmail.mitroshin.moxyexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

public class CounterFragment extends MvpAppCompatFragment implements CounterView {
    @InjectPresenter(type = PresenterType.GLOBAL, tag = "counterPresenter")
    CounterPresenter mCounterPresenter;
    private TextView mCounterTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.setBackgroundColor(getArguments().getInt("argColor"));
        mCounterTextView = (TextView) getView().findViewById(R.id.counter_text);
        view.findViewById(R.id.plus_button).setOnClickListener(v -> mCounterPresenter.onPlusClick());
    }

    @Override
    public void showCount(int count) {
        mCounterTextView.setText(String.valueOf(count));
    }
}
