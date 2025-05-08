package dk.molslinjen.domain.extensions;

import com.adjust.sdk.Constants;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.FormatStyle;
import org.threeten.bp.temporal.ChronoUnit;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\t¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\r\u001a\u00020\u0001*\u00020\f¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0019\u0010\u0011\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0019\u0010\u0011\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0013\u001a!\u0010\u0011\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0011\u0010\u0018\u001a\u0019\u0010\u0011\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0019\u001a\u0011\u0010\u001b\u001a\u00020\u001a*\u00020\f¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\u001d*\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0019\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010 \u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010!\u001a\u0011\u0010\"\u001a\u00020\u001d*\u00020\u0000¢\u0006\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Lorg/threeten/bp/LocalDate;", BuildConfig.FLAVOR, "toFormatBirthdateInput", "(Lorg/threeten/bp/LocalDate;)Ljava/lang/String;", "toShortFormat", "toFormatWeekdayWithDate", "toFormatWeekdayWithDateLowercase", "toFormatWithFullMonth", "toFormatWithFullMonthWithoutYear", "Lorg/threeten/bp/LocalTime;", "toFormatTime", "(Lorg/threeten/bp/LocalTime;)Ljava/lang/String;", "Lorg/threeten/bp/LocalDateTime;", "toFormatWithWeekday", "(Lorg/threeten/bp/LocalDateTime;)Ljava/lang/String;", "toAccessibilityReadableDate", "pattern", "toFormat", "(Lorg/threeten/bp/LocalDateTime;Ljava/lang/String;)Ljava/lang/String;", "(Lorg/threeten/bp/LocalDate;Ljava/lang/String;)Ljava/lang/String;", "Lorg/threeten/bp/format/FormatStyle;", "formatStyle", "Ljava/util/Locale;", "locale", "(Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/format/FormatStyle;Ljava/util/Locale;)Ljava/lang/String;", "(Lorg/threeten/bp/LocalTime;Ljava/lang/String;)Ljava/lang/String;", BuildConfig.FLAVOR, "toMilliseconds", "(Lorg/threeten/bp/LocalDateTime;)J", BuildConfig.FLAVOR, "toAge", "(Lorg/threeten/bp/LocalDate;)I", "atDate", "(Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;)I", "daysFromNow", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LocalDateTimeExtensionsKt {
    public static final int daysFromNow(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return (int) ChronoUnit.DAYS.between(LocalDate.now(), localDate);
    }

    public static final String toAccessibilityReadableDate(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        FormatStyle formatStyle = FormatStyle.FULL;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return toFormat(localDate, formatStyle, locale);
    }

    public static final int toAge(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        LocalDate now = LocalDate.now();
        Intrinsics.checkNotNullExpressionValue(now, "now(...)");
        return toAge(localDate, now);
    }

    public static final String toFormat(LocalDateTime localDateTime, String pattern) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String format = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String toFormatBirthdateInput(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return toFormat(localDate, "dd / MM / yyyy");
    }

    public static final String toFormatTime(LocalTime localTime) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        return toFormat(localTime, "HH:mm");
    }

    public static final String toFormatWeekdayWithDate(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return StringExtensionsKt.uppercaseFirstLetter(toFormat(localDate, "EEEE - d. MMMM yyyy"));
    }

    public static final String toFormatWeekdayWithDateLowercase(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return toFormat(localDate, "EEEE d. MMMM");
    }

    public static final String toFormatWithFullMonth(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return toFormat(localDate, "d. MMMM yyyy");
    }

    public static final String toFormatWithFullMonthWithoutYear(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return toFormat(localDate, "d. MMMM");
    }

    public static final String toFormatWithWeekday(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return toFormat(localDateTime, "EEEE d. MMMM yyyy 'kl.' HH:mm");
    }

    public static final long toMilliseconds(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return localDateTime.toEpochSecond(OffsetDateTime.now().getOffset()) * Constants.ONE_SECOND;
    }

    public static final String toShortFormat(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        FormatStyle formatStyle = FormatStyle.SHORT;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return toFormat(localDate, formatStyle, locale);
    }

    public static final int toAge(LocalDate localDate, LocalDate atDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(atDate, "atDate");
        int year = atDate.getYear() - localDate.getYear();
        return localDate.plusYears((long) year).isAfter(atDate) ? year - 1 : year;
    }

    public static final String toFormat(LocalDate localDate, String pattern) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String format = localDate.format(DateTimeFormatter.ofPattern(pattern));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String toFormat(LocalDate localDate, FormatStyle formatStyle, Locale locale) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(formatStyle, "formatStyle");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String format = localDate.format(DateTimeFormatter.ofLocalizedDate(formatStyle).withLocale(locale));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final String toFormat(LocalTime localTime, String pattern) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String format = localTime.format(DateTimeFormatter.ofPattern(pattern));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
