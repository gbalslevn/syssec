package dk.molslinjen.extensions;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/Color;", BuildConfig.FLAVOR, "alpha", "withAlpha-DxMtmZc", "(JF)J", "withAlpha", BuildConfig.FLAVOR, "safeToColor", "(Ljava/lang/String;)J", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ColorExtensionsKt {
    public static final long safeToColor(String str) {
        if (str == null) {
            return Color.INSTANCE.m1502getWhite0d7_KjU();
        }
        if (str.length() == 0) {
            str = "#000000";
        } else if (str.length() == 4 && StringsKt.first(str) == '#') {
            String substring = str.substring(1, 2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = str.substring(1, 2);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            String substring3 = str.substring(2, 3);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            String substring4 = str.substring(2, 3);
            Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
            String substring5 = str.substring(3, 4);
            Intrinsics.checkNotNullExpressionValue(substring5, "substring(...)");
            String substring6 = str.substring(3, 4);
            Intrinsics.checkNotNullExpressionValue(substring6, "substring(...)");
            str = "#" + substring + substring2 + substring3 + substring4 + substring5 + substring6;
        } else if (StringsKt.first(str) != '#') {
            str = "#" + str;
        }
        return ColorKt.Color(android.graphics.Color.parseColor(str));
    }

    /* renamed from: withAlpha-DxMtmZc, reason: not valid java name */
    public static final long m3249withAlphaDxMtmZc(long j5, float f5) {
        return Color.m1485copywmQWz5c$default(j5, f5, 0.0f, 0.0f, 0.0f, 14, null);
    }
}
