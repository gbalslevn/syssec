package kotlin.reflect.jvm.internal.impl.resolve;

import android.support.v4.media.session.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;

/* loaded from: classes3.dex */
public abstract class ResolutionAnchorProviderKt {
    private static final ModuleCapability<Object> RESOLUTION_ANCHOR_PROVIDER_CAPABILITY = new ModuleCapability<>("ResolutionAnchorProvider");

    public static final ModuleDescriptor getResolutionAnchorIfAny(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        a.a(moduleDescriptor.getCapability(RESOLUTION_ANCHOR_PROVIDER_CAPABILITY));
        return null;
    }
}
