package dk.molslinjen.core.extensions;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u00020\u0001¨\u0006\u0005"}, d2 = {"defaultLanguageString", BuildConfig.FLAVOR, "Ljava/util/Locale;", "getPhoneNumberCountryCode", "toLocale", "core_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LocaleExtensionsKt {
    public static final String defaultLanguageString(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String language = locale.getLanguage();
        return Intrinsics.areEqual(language, "da") ? "da" : Intrinsics.areEqual(language, "sv") ? "sv" : "en";
    }

    public static final String getPhoneNumberCountryCode(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String country = locale.getCountry();
        if (country != null) {
            int hashCode = country.hashCode();
            if (hashCode != 2177) {
                if (hashCode != 2183) {
                    if (hashCode != 2497) {
                        if (hashCode == 2642 && country.equals("SE")) {
                            return "+46";
                        }
                    } else if (country.equals("NO")) {
                        return "+47";
                    }
                } else if (country.equals("DK")) {
                    return "+45";
                }
            } else if (country.equals("DE")) {
                return "+49";
            }
        }
        return null;
    }

    public static final Locale toLocale(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return new Locale(BuildConfig.FLAVOR, str);
        } catch (Exception unused) {
            return null;
        }
    }
}
