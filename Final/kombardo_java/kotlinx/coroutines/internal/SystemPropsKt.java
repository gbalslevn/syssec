package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return SystemPropsKt__SystemPropsKt.getAVAILABLE_PROCESSORS();
    }

    public static final int systemProp(String str, int i5, int i6, int i7) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, i5, i6, i7);
    }

    public static final long systemProp(String str, long j5, long j6, long j7) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, j5, j6, j7);
    }

    public static final String systemProp(String str) {
        return SystemPropsKt__SystemPropsKt.systemProp(str);
    }

    public static final String systemProp(String str, String str2) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, str2);
    }

    public static final boolean systemProp(String str, boolean z5) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, z5);
    }
}
