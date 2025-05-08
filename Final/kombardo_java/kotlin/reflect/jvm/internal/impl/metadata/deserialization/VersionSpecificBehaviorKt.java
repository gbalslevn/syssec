package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class VersionSpecificBehaviorKt {
    public static final boolean isKotlin1Dot4OrLater(BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return (version.getMajor() == 1 && version.getMinor() >= 4) || version.getMajor() > 1;
    }

    public static final boolean isVersionRequirementTableWrittenCorrectly(BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return isKotlin1Dot4OrLater(version);
    }
}
