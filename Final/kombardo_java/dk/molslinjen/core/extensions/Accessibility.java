package dk.molslinjen.core.extensions;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/core/extensions/Accessibility;", BuildConfig.FLAVOR, "<init>", "()V", "skip", BuildConfig.FLAVOR, "getSkip", "()Ljava/lang/String;", "core_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Accessibility {
    public static final Accessibility INSTANCE = new Accessibility();
    private static final String skip = null;

    private Accessibility() {
    }

    public final String getSkip() {
        return skip;
    }
}
