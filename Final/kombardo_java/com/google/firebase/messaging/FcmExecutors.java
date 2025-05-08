package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.firebase.messaging.threads.PoolableExecutors;
import com.google.firebase.messaging.threads.ThreadPriority;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
abstract class FcmExecutors {
    private static final String THREAD_FILE = "Firebase-Messaging-File";
    private static final String THREAD_INIT = "Firebase-Messaging-Init";
    private static final String THREAD_INTENT_HANDLE = "Firebase-Messaging-Intent-Handle";
    private static final String THREAD_NETWORK_IO = "Firebase-Messaging-Network-Io";
    private static final String THREAD_TASK = "Firebase-Messaging-Task";
    private static final String THREAD_TOPICS_IO = "Firebase-Messaging-Topics-Io";

    @SuppressLint({"ThreadPoolCreation"})
    private static Executor newCachedSingleThreadExecutor(String str) {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor newFileIOExecutor() {
        return newCachedSingleThreadExecutor("Firebase-Messaging-File-Io");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public static ScheduledExecutorService newInitExecutor() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(THREAD_INIT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public static ExecutorService newIntentHandleExecutor() {
        return PoolableExecutors.factory().newSingleThreadExecutor(new NamedThreadFactory(THREAD_INTENT_HANDLE), ThreadPriority.HIGH_SPEED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public static ExecutorService newNetworkIOExecutor() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory(THREAD_NETWORK_IO));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public static ExecutorService newTaskExecutor() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory(THREAD_TASK));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public static ScheduledExecutorService newTopicsSyncExecutor() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(THREAD_TOPICS_IO));
    }
}
