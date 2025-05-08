package dk.molslinjen.extensions;

import dk.molslinjen.core.extensions.StringExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.YearMonth;
import org.threeten.bp.format.DateTimeFormatter;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toFullMonthWithYear", BuildConfig.FLAVOR, "Lorg/threeten/bp/YearMonth;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class YearMonthExtensionsKt {
    public static final String toFullMonthWithYear(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        String format = yearMonth.format(DateTimeFormatter.ofPattern("MMMM yyyy"));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return StringExtensionsKt.uppercaseFirstLetter(format);
    }
}
