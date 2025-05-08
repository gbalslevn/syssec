package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* loaded from: classes3.dex */
public abstract class UtilsKt {
    public static final void record(LookupTracker lookupTracker, LookupLocation from, ClassDescriptor scopeOwner, Name name) {
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        if (lookupTracker == LookupTracker.DO_NOTHING.INSTANCE) {
            return;
        }
        from.getLocation();
    }

    public static final void recordPackageLookup(LookupTracker lookupTracker, LookupLocation from, String packageFqName, String name) {
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(name, "name");
        if (lookupTracker == LookupTracker.DO_NOTHING.INSTANCE) {
            return;
        }
        from.getLocation();
    }

    public static final void record(LookupTracker lookupTracker, LookupLocation from, PackageFragmentDescriptor scopeOwner, Name name) {
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(scopeOwner, "scopeOwner");
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = scopeOwner.getFqName().asString();
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
        recordPackageLookup(lookupTracker, from, asString, asString2);
    }
}
