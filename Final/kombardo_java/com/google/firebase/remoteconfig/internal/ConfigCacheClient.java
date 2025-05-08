package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class ConfigCacheClient {
    private Task<ConfigContainer> cachedContainerTask = null;
    private final Executor executor;
    private final ConfigStorageClient storageClient;
    private static final Map<String, ConfigCacheClient> clientInstances = new HashMap();
    private static final Executor DIRECT_EXECUTOR = new K.d();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class AwaitListener<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {
        private final CountDownLatch latch;

        private AwaitListener() {
            this.latch = new CountDownLatch(1);
        }

        public boolean await(long j5, TimeUnit timeUnit) {
            return this.latch.await(j5, timeUnit);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.latch.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(TResult tresult) {
            this.latch.countDown();
        }
    }

    private ConfigCacheClient(Executor executor, ConfigStorageClient configStorageClient) {
        this.executor = executor;
        this.storageClient = configStorageClient;
    }

    private static <TResult> TResult await(Task<TResult> task, long j5, TimeUnit timeUnit) {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = DIRECT_EXECUTOR;
        task.addOnSuccessListener(executor, awaitListener);
        task.addOnFailureListener(executor, awaitListener);
        task.addOnCanceledListener(executor, awaitListener);
        if (!awaitListener.await(j5, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static synchronized ConfigCacheClient getInstance(Executor executor, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            try {
                String fileName = configStorageClient.getFileName();
                Map<String, ConfigCacheClient> map = clientInstances;
                if (!map.containsKey(fileName)) {
                    map.put(fileName, new ConfigCacheClient(executor, configStorageClient));
                }
                configCacheClient = map.get(fileName);
            } catch (Throwable th) {
                throw th;
            }
        }
        return configCacheClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$put$0(ConfigContainer configContainer) {
        return this.storageClient.write(configContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$put$1(boolean z5, ConfigContainer configContainer, Void r32) {
        if (z5) {
            updateInMemoryConfigContainer(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    private synchronized void updateInMemoryConfigContainer(ConfigContainer configContainer) {
        this.cachedContainerTask = Tasks.forResult(configContainer);
    }

    public void clear() {
        synchronized (this) {
            this.cachedContainerTask = Tasks.forResult(null);
        }
        this.storageClient.clear();
    }

    public synchronized Task<ConfigContainer> get() {
        try {
            Task<ConfigContainer> task = this.cachedContainerTask;
            if (task != null) {
                if (task.isComplete() && !this.cachedContainerTask.isSuccessful()) {
                }
            }
            Executor executor = this.executor;
            final ConfigStorageClient configStorageClient = this.storageClient;
            Objects.requireNonNull(configStorageClient);
            this.cachedContainerTask = Tasks.call(executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConfigStorageClient.this.read();
                }
            });
        } catch (Throwable th) {
            throw th;
        }
        return this.cachedContainerTask;
    }

    public ConfigContainer getBlocking() {
        return getBlocking(5L);
    }

    public Task<ConfigContainer> put(ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    ConfigContainer getBlocking(long j5) {
        synchronized (this) {
            try {
                Task<ConfigContainer> task = this.cachedContainerTask;
                if (task != null && task.isSuccessful()) {
                    return this.cachedContainerTask.getResult();
                }
                try {
                    return (ConfigContainer) await(get(), j5, TimeUnit.SECONDS);
                } catch (InterruptedException | ExecutionException | TimeoutException e5) {
                    Log.d("FirebaseRemoteConfig", "Reading from storage file failed.", e5);
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Task<ConfigContainer> put(final ConfigContainer configContainer, final boolean z5) {
        return Tasks.call(this.executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void lambda$put$0;
                lambda$put$0 = ConfigCacheClient.this.lambda$put$0(configContainer);
                return lambda$put$0;
            }
        }).onSuccessTask(this.executor, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task lambda$put$1;
                lambda$put$1 = ConfigCacheClient.this.lambda$put$1(z5, configContainer, (Void) obj);
                return lambda$put$1;
            }
        });
    }
}
