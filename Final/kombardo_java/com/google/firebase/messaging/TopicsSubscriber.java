package com.google.firebase.messaging;

import android.content.Context;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class TopicsSubscriber {
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final long RPC_TIMEOUT_SEC = 30;
    private final Context context;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();
    private boolean syncScheduledOrRunning = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging;
        this.metadata = metadata;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context;
        this.syncExecutor = scheduledExecutorService;
    }

    private static <T> void awaitTask(Task<T> task) {
        try {
            Tasks.await(task, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException e5) {
            e = e5;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        } catch (ExecutionException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e6);
            }
            throw ((RuntimeException) cause);
        } catch (TimeoutException e7) {
            e = e7;
            throw new IOException("SERVICE_NOT_AVAILABLE", e);
        }
    }

    private void blockingSubscribeToTopic(String str) {
        awaitTask(this.rpc.subscribeToTopic(this.firebaseMessaging.blockingGetToken(), str));
    }

    private void blockingUnsubscribeFromTopic(String str) {
        awaitTask(this.rpc.unsubscribeFromTopic(this.firebaseMessaging.blockingGetToken(), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Task<TopicsSubscriber> createInstance(final FirebaseMessaging firebaseMessaging, final Metadata metadata, final GmsRpc gmsRpc, final Context context, final ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.messaging.A
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TopicsSubscriber lambda$createInstance$0;
                lambda$createInstance$0 = TopicsSubscriber.lambda$createInstance$0(context, scheduledExecutorService, firebaseMessaging, metadata, gmsRpc);
                return lambda$createInstance$0;
            }
        });
    }

    static boolean isDebugLogEnabled() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TopicsSubscriber lambda$createInstance$0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        return new TopicsSubscriber(firebaseMessaging, metadata, TopicsStore.getInstance(context, scheduledExecutorService), gmsRpc, context, scheduledExecutorService);
    }

    private void markCompletePendingOperation(TopicOperation topicOperation) {
        synchronized (this.pendingOperations) {
            try {
                String serialize = topicOperation.serialize();
                if (this.pendingOperations.containsKey(serialize)) {
                    ArrayDeque<TaskCompletionSource<Void>> arrayDeque = this.pendingOperations.get(serialize);
                    TaskCompletionSource<Void> poll = arrayDeque.poll();
                    if (poll != null) {
                        poll.setResult(null);
                    }
                    if (arrayDeque.isEmpty()) {
                        this.pendingOperations.remove(serialize);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void startSync() {
        if (isSyncScheduledOrRunning()) {
            return;
        }
        syncWithDelaySecondsInternal(0L);
    }

    boolean hasPendingOperation() {
        return this.store.getNextTopicOperation() != null;
    }

    synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[Catch: IOException -> 0x001f, TryCatch #0 {IOException -> 0x001f, blocks: (B:3:0x0003, B:12:0x0033, B:14:0x0039, B:17:0x0053, B:19:0x0060, B:20:0x007c, B:22:0x0089, B:23:0x0015, B:26:0x0022), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean performTopicOperation(TopicOperation topicOperation) {
        char c5;
        try {
            String operation = topicOperation.getOperation();
            int hashCode = operation.hashCode();
            if (hashCode == 83) {
                if (operation.equals("S")) {
                    c5 = 0;
                    if (c5 != 0) {
                    }
                    return true;
                }
                c5 = 65535;
                if (c5 != 0) {
                }
                return true;
            }
            if (hashCode == 85 && operation.equals("U")) {
                c5 = 1;
                if (c5 != 0) {
                    blockingSubscribeToTopic(topicOperation.getTopic());
                    if (isDebugLogEnabled()) {
                        Log.d("FirebaseMessaging", "Subscribe to topic: " + topicOperation.getTopic() + " succeeded.");
                    }
                } else if (c5 == 1) {
                    blockingUnsubscribeFromTopic(topicOperation.getTopic());
                    if (isDebugLogEnabled()) {
                        Log.d("FirebaseMessaging", "Unsubscribe from topic: " + topicOperation.getTopic() + " succeeded.");
                    }
                } else if (isDebugLogEnabled()) {
                    Log.d("FirebaseMessaging", "Unknown topic operation" + topicOperation + ".");
                }
                return true;
            }
            c5 = 65535;
            if (c5 != 0) {
            }
            return true;
        } catch (IOException e5) {
            if (!"SERVICE_NOT_AVAILABLE".equals(e5.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e5.getMessage()) && !"TOO_MANY_SUBSCRIBERS".equals(e5.getMessage())) {
                if (e5.getMessage() != null) {
                    throw e5;
                }
                Log.e("FirebaseMessaging", "Topic operation failed without exception message. Will retry Topic operation.");
                return false;
            }
            Log.e("FirebaseMessaging", "Topic operation failed: " + e5.getMessage() + ". Will retry Topic operation.");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j5) {
        this.syncExecutor.schedule(runnable, j5, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean z5) {
        this.syncScheduledOrRunning = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x000d, code lost:
    
        if (isDebugLogEnabled() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x000f, code lost:
    
        android.util.Log.d("FirebaseMessaging", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001a, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean syncTopics() {
        while (true) {
            synchronized (this) {
                try {
                    TopicOperation nextTopicOperation = this.store.getNextTopicOperation();
                    if (nextTopicOperation == null) {
                        break;
                    }
                    if (!performTopicOperation(nextTopicOperation)) {
                        return false;
                    }
                    this.store.removeTopicOperation(nextTopicOperation);
                    markCompletePendingOperation(nextTopicOperation);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syncWithDelaySecondsInternal(long j5) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30L, 2 * j5), MAX_DELAY_SEC)), j5);
        setSyncScheduledOrRunning(true);
    }
}
