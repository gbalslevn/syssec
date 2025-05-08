package dk.molslinjen.extensions;

import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"format", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "digits", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DoubleExtensionsKt {
    public static final String format(double d5, int i5) {
        String format = new DecimalFormat("0." + StringsKt.repeat("0", i5)).format(d5);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
