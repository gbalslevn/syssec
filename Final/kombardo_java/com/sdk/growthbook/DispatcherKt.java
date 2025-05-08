package com.sdk.growthbook;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"PlatformDependentIODispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getPlatformDependentIODispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DispatcherKt {
    private static final CoroutineDispatcher PlatformDependentIODispatcher = Dispatchers.getIO();

    public static final CoroutineDispatcher getPlatformDependentIODispatcher() {
        return PlatformDependentIODispatcher;
    }
}
