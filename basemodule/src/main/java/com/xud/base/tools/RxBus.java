package com.xud.base.tools;

import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by xud on 2/18/16.
 */
public class RxBus {
    private static final String TAG = "RxBus";

    private static RxBus mRxBus;

    private RxBus() {
    }

    public static RxBus getInstance() {
        if (mRxBus == null) mRxBus = new RxBus();
        return mRxBus;
    }

    private ConcurrentHashMap<Object, List<Subject>> subjectMapper = new ConcurrentHashMap<>();

    public <T> Observable<T> register(@NonNull Object tag) {
        List<Subject> subjectList = subjectMapper.get(tag);
        if (null == subjectList) {
            subjectList = new ArrayList<>();
            subjectMapper.put(tag, subjectList);
        }

        Subject<T, T> subject = PublishSubject.create();
        subjectList.add(subject);
        Logger.t(TAG).i("[register]subjectMapper: %s", subjectMapper);
        return subject;
    }

    @SuppressWarnings("unchecked")
    public void unregister(@NonNull Object tag, @NonNull Observable observable) {
        List<Subject> subjects = subjectMapper.get(tag);
        if (null != subjects) {
            subjects.remove(observable);
            if (subjects.size() == 0) {
                subjectMapper.remove(tag);
            }
        }
        Logger.t(TAG).i("[unregister]subjectMapper: %s", subjectMapper);
    }

    @SuppressWarnings("unchecked")
    public void post(@NonNull Object tag, @NonNull Object content) {
        List<Subject> subjectList = subjectMapper.get(tag);

        if (subjectList != null) {
            for (Subject subject : subjectList) {
                try {
                    subject.onNext(content);
                } catch (Exception e) {
                    subject.onError(e.getCause());
                }
            }
        }
        Logger.t(TAG).i("[send]subjectMapper: %s", subjectMapper);
    }
}
