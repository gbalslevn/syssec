package com.sdk.growthbook;

import android.content.Context;
import androidx.startup.Initializer;
import com.sdk.growthbook.sandbox.CachingAndroid;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001a\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\b0\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/sdk/growthbook/AppContextProvider;", "Landroidx/startup/Initializer;", "Landroid/content/Context;", "()V", "create", "context", "dependencies", org.conscrypt.BuildConfig.FLAVOR, "Ljava/lang/Class;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppContextProvider implements Initializer<Context> {
    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Context create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CachingAndroid.INSTANCE.consumeContext(context);
        return context;
    }
}
