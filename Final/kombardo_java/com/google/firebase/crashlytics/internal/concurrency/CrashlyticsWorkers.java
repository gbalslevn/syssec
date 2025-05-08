package com.google.firebase.crashlytics.internal.concurrency;

import android.os.Looper;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/google/firebase/crashlytics/internal/concurrency/CrashlyticsWorkers;", BuildConfig.FLAVOR, "backgroundExecutorService", "Ljava/util/concurrent/ExecutorService;", "blockingExecutorService", "(Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;)V", "common", "Lcom/google/firebase/crashlytics/internal/concurrency/CrashlyticsWorker;", "dataCollect", "diskWrite", "network", "Companion", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CrashlyticsWorkers {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean enforcement;
    public final CrashlyticsWorker common;
    public final CrashlyticsWorker dataCollect;
    public final CrashlyticsWorker diskWrite;
    public final CrashlyticsWorker network;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0003R\u001c\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/google/firebase/crashlytics/internal/concurrency/CrashlyticsWorkers$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "isNotMainThread", "()Z", "isBlockingThread", "isBackgroundThread", "Lkotlin/Function0;", "isCorrectThread", BuildConfig.FLAVOR, "failureMessage", BuildConfig.FLAVOR, "checkThread", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "checkNotMainThread", "checkBlockingThread", "checkBackgroundThread", "kotlin.jvm.PlatformType", "getThreadName", "()Ljava/lang/String;", "threadName", "enforcement", "Z", "getEnforcement", "setEnforcement", "(Z)V", "getEnforcement$annotations", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void checkThread(Function0<Boolean> isCorrectThread, Function0<String> failureMessage) {
            if (isCorrectThread.invoke().booleanValue()) {
                return;
            }
            Logger.getLogger().d(failureMessage.invoke());
            getEnforcement();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getThreadName() {
            return Thread.currentThread().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBackgroundThread() {
            String threadName = getThreadName();
            Intrinsics.checkNotNullExpressionValue(threadName, "threadName");
            return StringsKt.contains$default((CharSequence) threadName, (CharSequence) "Firebase Background Thread #", false, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBlockingThread() {
            String threadName = getThreadName();
            Intrinsics.checkNotNullExpressionValue(threadName, "threadName");
            return StringsKt.contains$default((CharSequence) threadName, (CharSequence) "Firebase Blocking Thread #", false, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isNotMainThread() {
            return !Looper.getMainLooper().isCurrentThread();
        }

        public final void checkBackgroundThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkBackgroundThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkBackgroundThread$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String threadName;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Must be called on a background thread, was called on ");
                    threadName = CrashlyticsWorkers.INSTANCE.getThreadName();
                    sb.append(threadName);
                    sb.append('.');
                    return sb.toString();
                }
            });
        }

        public final void checkBlockingThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkBlockingThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkBlockingThread$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String threadName;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Must be called on a blocking thread, was called on ");
                    threadName = CrashlyticsWorkers.INSTANCE.getThreadName();
                    sb.append(threadName);
                    sb.append('.');
                    return sb.toString();
                }
            });
        }

        public final void checkNotMainThread() {
            checkThread(new CrashlyticsWorkers$Companion$checkNotMainThread$1(this), new Function0<String>() { // from class: com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers$Companion$checkNotMainThread$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    String threadName;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Must not be called on a main thread, was called on ");
                    threadName = CrashlyticsWorkers.INSTANCE.getThreadName();
                    sb.append(threadName);
                    sb.append('.');
                    return sb.toString();
                }
            });
        }

        public final boolean getEnforcement() {
            return CrashlyticsWorkers.enforcement;
        }

        public final void setEnforcement(boolean z5) {
            CrashlyticsWorkers.enforcement = z5;
        }

        private Companion() {
        }
    }

    public CrashlyticsWorkers(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        Intrinsics.checkNotNullParameter(backgroundExecutorService, "backgroundExecutorService");
        Intrinsics.checkNotNullParameter(blockingExecutorService, "blockingExecutorService");
        this.common = new CrashlyticsWorker(backgroundExecutorService);
        this.diskWrite = new CrashlyticsWorker(backgroundExecutorService);
        this.dataCollect = new CrashlyticsWorker(backgroundExecutorService);
        this.network = new CrashlyticsWorker(blockingExecutorService);
    }

    public static final void checkBackgroundThread() {
        INSTANCE.checkBackgroundThread();
    }

    public static final void checkBlockingThread() {
        INSTANCE.checkBlockingThread();
    }

    public static final void checkNotMainThread() {
        INSTANCE.checkNotMainThread();
    }

    public static final void setEnforcement(boolean z5) {
        INSTANCE.setEnforcement(z5);
    }
}
