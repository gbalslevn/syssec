package androidx.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Landroidx/navigation/NamedNavArgument;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "name", "Landroidx/navigation/NavArgument;", "argument", "<init>", "(Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "component1", "()Ljava/lang/String;", "component2", "()Landroidx/navigation/NavArgument;", "Ljava/lang/String;", "getName", "Landroidx/navigation/NavArgument;", "getArgument", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NamedNavArgument {
    private final NavArgument argument;
    private final String name;

    public NamedNavArgument(String name, NavArgument argument) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.name = name;
        this.argument = argument;
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final NavArgument getArgument() {
        return this.argument;
    }
}
