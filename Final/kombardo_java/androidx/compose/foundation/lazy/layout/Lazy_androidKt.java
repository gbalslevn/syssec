package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"getDefaultLazyLayoutKey", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Lazy_androidKt {
    public static final Object getDefaultLazyLayoutKey(int i5) {
        return new DefaultLazyKey(i5);
    }
}
