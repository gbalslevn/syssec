package dk.molslinjen.core.extensions;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"splitNumberForAccessibility", BuildConfig.FLAVOR, "toAccessibilityReadableDate", "Ljava/time/LocalDate;", "locale", "Ljava/util/Locale;", "core_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AccessibilityKt {
    public static final String splitNumberForAccessibility(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return CollectionsKt.joinToString$default(StringsKt.chunked(str, 2), " ", null, null, 0, null, null, 62, null);
    }

    public static final String toAccessibilityReadableDate(LocalDate localDate, Locale locale) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return localDate.getDayOfMonth() + ". " + localDate.getMonth().getDisplayName(TextStyle.FULL, locale);
    }
}
