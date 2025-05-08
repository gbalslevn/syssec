package com.google.firebase.remoteconfig.internal.rollouts;

import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class RolloutsStateSubscriptionsHandler {
    private ConfigCacheClient activatedConfigsCache;
    private Executor executor;
    private RolloutsStateFactory rolloutsStateFactory;
    private Set<RolloutsStateSubscriber> subscribers = Collections.newSetFromMap(new ConcurrentHashMap());

    public RolloutsStateSubscriptionsHandler(ConfigCacheClient configCacheClient, RolloutsStateFactory rolloutsStateFactory, Executor executor) {
        this.activatedConfigsCache = configCacheClient;
        this.rolloutsStateFactory = rolloutsStateFactory;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerRolloutsStateSubscriber$1(Task task, final RolloutsStateSubscriber rolloutsStateSubscriber, ConfigContainer configContainer) {
        try {
            ConfigContainer configContainer2 = (ConfigContainer) task.getResult();
            if (configContainer2 != null) {
                final RolloutsState activeRolloutsState = this.rolloutsStateFactory.getActiveRolloutsState(configContainer2);
                this.executor.execute(new Runnable() { // from class: Z0.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        RolloutsStateSubscriber.this.onRolloutsStateChanged(activeRolloutsState);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e5) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e5);
        }
    }

    public void publishActiveRolloutsState(ConfigContainer configContainer) {
        try {
            final RolloutsState activeRolloutsState = this.rolloutsStateFactory.getActiveRolloutsState(configContainer);
            for (final RolloutsStateSubscriber rolloutsStateSubscriber : this.subscribers) {
                this.executor.execute(new Runnable() { // from class: Z0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        RolloutsStateSubscriber.this.onRolloutsStateChanged(activeRolloutsState);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e5) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e5);
        }
    }

    public void registerRolloutsStateSubscriber(final RolloutsStateSubscriber rolloutsStateSubscriber) {
        this.subscribers.add(rolloutsStateSubscriber);
        final Task<ConfigContainer> task = this.activatedConfigsCache.get();
        task.addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: Z0.b
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                RolloutsStateSubscriptionsHandler.this.lambda$registerRolloutsStateSubscriber$1(task, rolloutsStateSubscriber, (ConfigContainer) obj);
            }
        });
    }
}
