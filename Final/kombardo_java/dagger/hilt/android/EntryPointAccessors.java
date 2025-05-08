package dagger.hilt.android;

import android.content.Context;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldagger/hilt/android/EntryPointAccessors;", BuildConfig.FLAVOR, "<init>", "()V", "T", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "entryPoint", "fromApplication", "(Landroid/content/Context;Ljava/lang/Class;)Ljava/lang/Object;", "java_dagger_hilt_android-entry_point_accessors_internal_kt"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EntryPointAccessors {
    public static final EntryPointAccessors INSTANCE = new EntryPointAccessors();

    private EntryPointAccessors() {
    }

    public static final <T> T fromApplication(Context context, Class<T> entryPoint) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entryPoint, "entryPoint");
        return (T) EntryPoints.get(Contexts.getApplication(context.getApplicationContext()), entryPoint);
    }
}
