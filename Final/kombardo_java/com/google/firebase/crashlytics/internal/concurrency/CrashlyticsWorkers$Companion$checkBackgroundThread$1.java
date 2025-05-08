package com.google.firebase.crashlytics.internal.concurrency;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class CrashlyticsWorkers$Companion$checkBackgroundThread$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashlyticsWorkers$Companion$checkBackgroundThread$1(Object obj) {
        super(0, obj, CrashlyticsWorkers.Companion.class, "isBackgroundThread", "isBackgroundThread()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        boolean isBackgroundThread;
        isBackgroundThread = ((CrashlyticsWorkers.Companion) this.receiver).isBackgroundThread();
        return Boolean.valueOf(isBackgroundThread);
    }
}
