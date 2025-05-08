package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class TopicsStore {
    private static final String DIVIDER_QUEUE_OPERATIONS = ",";
    private static WeakReference<TopicsStore> topicsStoreWeakReference;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    private SharedPreferencesQueue topicOperationsQueue;

    private TopicsStore(SharedPreferences sharedPreferences, Executor executor) {
        this.syncExecutor = executor;
        this.sharedPreferences = sharedPreferences;
    }

    public static synchronized TopicsStore getInstance(Context context, Executor executor) {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            try {
                WeakReference<TopicsStore> weakReference = topicsStoreWeakReference;
                topicsStore = weakReference != null ? weakReference.get() : null;
                if (topicsStore == null) {
                    topicsStore = new TopicsStore(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                    topicsStore.initStore();
                    topicsStoreWeakReference = new WeakReference<>(topicsStore);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return topicsStore;
    }

    private synchronized void initStore() {
        this.topicOperationsQueue = SharedPreferencesQueue.createInstance(this.sharedPreferences, "topic_operation_queue", DIVIDER_QUEUE_OPERATIONS, this.syncExecutor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized TopicOperation getNextTopicOperation() {
        return TopicOperation.from(this.topicOperationsQueue.peek());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean removeTopicOperation(TopicOperation topicOperation) {
        return this.topicOperationsQueue.remove(topicOperation.serialize());
    }
}
