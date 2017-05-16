package com.developgmail.mitroshin.moxyexample;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

// Благодаря аннотации @InjectViewState и типизации по интерфейсу View при вызове дефолтного
// конструктора, будет создан экземпляр ViewState. К нему можно будет обращаться с помощью getViewState().
@InjectViewState
public class HelloMoxyPresenter extends MvpPresenter<HelloMoxyView> {
    public HelloMoxyPresenter() {

        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                sleepSecond();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().showMessage(R.string.hello_moxy);
            }

            private void sleepSecond() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        asyncTask.execute();
    }
}
