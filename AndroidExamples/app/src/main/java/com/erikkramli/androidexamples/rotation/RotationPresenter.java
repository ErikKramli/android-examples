package com.erikkramli.androidexamples.rotation;

import com.erikkramli.androidexamples.infrastructure.ActivityScope;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

@ActivityScope
public class RotationPresenter {

    private Callbacks callbacks;
    private Subscription subscription;

    private long state = -1;

    public interface Callbacks {
        void onLoad(String text);
    }

    @Inject
    RotationPresenter() {
    }

    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
        if (state != -1) {
            callbacks.onLoad(String.valueOf(state));
        }
    }

    public void load() {
        if (subscription == null) {
            if (callbacks != null) {
                callbacks.onLoad("started");
            }

            subscription = Observable
                    .interval(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<Long>() {
                        @Override
                        public void call(Long aLong) {
                            state = aLong;
                            if (callbacks != null) {
                                callbacks.onLoad(String.valueOf(aLong));
                            }
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            if (callbacks != null) {
                                callbacks.onLoad("error " + throwable.getMessage());
                            }
                        }
                    });
        }
    }

    public void stop() {
        if (subscription != null) {
            subscription.unsubscribe();
            subscription = null;
        }
    }
}
