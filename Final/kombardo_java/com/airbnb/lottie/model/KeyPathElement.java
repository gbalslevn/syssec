package com.airbnb.lottie.model;

import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public interface KeyPathElement {
    <T> void addValueCallback(T t5, LottieValueCallback<T> lottieValueCallback);

    void resolveKeyPath(KeyPath keyPath, int i5, List<KeyPath> list, KeyPath keyPath2);
}
