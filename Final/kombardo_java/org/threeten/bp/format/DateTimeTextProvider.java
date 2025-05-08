package org.threeten.bp.format;

import e.AbstractC0321h;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;

/* loaded from: classes3.dex */
public abstract class DateTimeTextProvider {
    private static final AtomicReference<DateTimeTextProvider> MUTABLE_PROVIDER = new AtomicReference<>();

    /* loaded from: classes3.dex */
    static class ProviderSingleton {
        static final DateTimeTextProvider PROVIDER = initialize();

        static DateTimeTextProvider initialize() {
            AbstractC0321h.a(DateTimeTextProvider.MUTABLE_PROVIDER, null, new SimpleDateTimeTextProvider());
            return (DateTimeTextProvider) DateTimeTextProvider.MUTABLE_PROVIDER.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateTimeTextProvider getInstance() {
        return ProviderSingleton.PROVIDER;
    }

    public abstract String getText(TemporalField temporalField, long j5, TextStyle textStyle, Locale locale);

    public abstract Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale);
}
