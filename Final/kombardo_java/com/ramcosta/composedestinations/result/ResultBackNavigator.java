package com.ramcosta.composedestinations.result;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "R", BuildConfig.FLAVOR, "result", BuildConfig.FLAVOR, "navigateBack", "(Ljava/lang/Object;)V", "()V", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ResultBackNavigator<R> {
    void navigateBack();

    void navigateBack(R result);
}
