package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.chrono.Chronology;

/* loaded from: classes3.dex */
abstract class DateTimeFormatStyleProvider {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateTimeFormatStyleProvider getInstance() {
        return new SimpleDateTimeFormatStyleProvider();
    }

    public abstract DateTimeFormatter getFormatter(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale);
}
