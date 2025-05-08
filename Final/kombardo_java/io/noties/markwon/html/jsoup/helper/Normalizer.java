package io.noties.markwon.html.jsoup.helper;

import java.util.Locale;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public abstract class Normalizer {
    public static String lowerCase(String str) {
        return str != null ? str.toLowerCase(Locale.ENGLISH) : BuildConfig.FLAVOR;
    }
}
