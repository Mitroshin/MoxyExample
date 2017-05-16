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
        AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {
            @Override
            protected void onPreExecute() {
                getViewState().showTimer();
            }

            @Override
            protected Void doInBackground(Void... params) {
                for (int i = 5; i > 0; i--) {
                    publishProgress(i);
                    sleepSecond();
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                getViewState().setTimer(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().hideTimer();
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
