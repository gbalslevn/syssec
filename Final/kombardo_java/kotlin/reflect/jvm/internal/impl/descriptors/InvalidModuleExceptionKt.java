package kotlin.reflect.jvm.internal.impl.descriptors;

import android.support.v4.media.session.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class InvalidModuleExceptionKt {
    private static final ModuleCapability<Object> INVALID_MODULE_NOTIFIER_CAPABILITY = new ModuleCapability<>("InvalidModuleNotifier");

    public static final void moduleInvalidated(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        a.a(moduleDescriptor.getCapability(INVALID_MODULE_NOTIFIER_CAPABILITY));
        throw new InvalidModuleException("Accessing invalid module descriptor " + moduleDescriptor);
    }
}
