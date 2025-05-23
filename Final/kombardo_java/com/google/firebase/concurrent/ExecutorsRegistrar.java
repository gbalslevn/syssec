package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: classes2.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {
    static final Lazy<ScheduledExecutorService> BG_EXECUTOR = new Lazy<>(new Provider() { // from class: F0.a
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            ScheduledExecutorService lambda$static$0;
            lambda$static$0 = ExecutorsRegistrar.lambda$static$0();
            return lambda$static$0;
        }
    });
    static final Lazy<ScheduledExecutorService> LITE_EXECUTOR = new Lazy<>(new Provider() { // from class: F0.b
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            ScheduledExecutorService lambda$static$1;
            lambda$static$1 = ExecutorsRegistrar.lambda$static$1();
            return lambda$static$1;
        }
    });
    static final Lazy<ScheduledExecutorService> BLOCKING_EXECUTOR = new Lazy<>(new Provider() { // from class: F0.c
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            ScheduledExecutorService lambda$static$2;
            lambda$static$2 = ExecutorsRegistrar.lambda$static$2();
            return lambda$static$2;
        }
    });
    static final Lazy<ScheduledExecutorService> SCHEDULER = new Lazy<>(new Provider() { // from class: F0.d
        @Override // com.google.firebase.inject.Provider
        public final Object get() {
            ScheduledExecutorService lambda$static$3;
            lambda$static$3 = ExecutorsRegistrar.lambda$static$3();
            return lambda$static$3;
        }
    });

    private static StrictMode.ThreadPolicy bgPolicy() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        detectNetwork.detectResourceMismatches();
        detectNetwork.detectUnbufferedIo();
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory factory(String str, int i5) {
        return new CustomThreadFactory(str, i5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService lambda$getComponents$4(ComponentContainer componentContainer) {
        return BG_EXECUTOR.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService lambda$getComponents$5(ComponentContainer componentContainer) {
        return BLOCKING_EXECUTOR.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService lambda$getComponents$6(ComponentContainer componentContainer) {
        return LITE_EXECUTOR.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Executor lambda$getComponents$7(ComponentContainer componentContainer) {
        return UiExecutor.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService lambda$static$0() {
        return scheduled(Executors.newFixedThreadPool(4, factory("Firebase Background", 10, bgPolicy())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService lambda$static$1() {
        return scheduled(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), factory("Firebase Lite", 0, litePolicy())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService lambda$static$2() {
        return scheduled(Executors.newCachedThreadPool(factory("Firebase Blocking", 11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScheduledExecutorService lambda$static$3() {
        return Executors.newSingleThreadScheduledExecutor(factory("Firebase Scheduler", 0));
    }

    private static StrictMode.ThreadPolicy litePolicy() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    private static ScheduledExecutorService scheduled(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, SCHEDULER.get());
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(Qualified.qualified(Background.class, ScheduledExecutorService.class), Qualified.qualified(Background.class, ExecutorService.class), Qualified.qualified(Background.class, Executor.class)).factory(new ComponentFactory() { // from class: F0.e
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                ScheduledExecutorService lambda$getComponents$4;
                lambda$getComponents$4 = ExecutorsRegistrar.lambda$getComponents$4(componentContainer);
                return lambda$getComponents$4;
            }
        }).build(), Component.builder(Qualified.qualified(Blocking.class, ScheduledExecutorService.class), Qualified.qualified(Blocking.class, ExecutorService.class), Qualified.qualified(Blocking.class, Executor.class)).factory(new ComponentFactory() { // from class: F0.f
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                ScheduledExecutorService lambda$getComponents$5;
                lambda$getComponents$5 = ExecutorsRegistrar.lambda$getComponents$5(componentContainer);
                return lambda$getComponents$5;
            }
        }).build(), Component.builder(Qualified.qualified(Lightweight.class, ScheduledExecutorService.class), Qualified.qualified(Lightweight.class, ExecutorService.class), Qualified.qualified(Lightweight.class, Executor.class)).factory(new ComponentFactory() { // from class: F0.g
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                ScheduledExecutorService lambda$getComponents$6;
                lambda$getComponents$6 = ExecutorsRegistrar.lambda$getComponents$6(componentContainer);
                return lambda$getComponents$6;
            }
        }).build(), Component.builder(Qualified.qualified(UiThread.class, Executor.class)).factory(new ComponentFactory() { // from class: F0.h
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                Executor lambda$getComponents$7;
                lambda$getComponents$7 = ExecutorsRegistrar.lambda$getComponents$7(componentContainer);
                return lambda$getComponents$7;
            }
        }).build());
    }

    private static ThreadFactory factory(String str, int i5, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i5, threadPolicy);
    }
}
