package dk.molslinjen.extensions;

import dk.molslinjen.kombardo.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"getFlag", BuildConfig.FLAVOR, "Ljava/util/Locale;", "(Ljava/util/Locale;)Ljava/lang/Integer;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LocaleExtensionsKt {
    public static final Integer getFlag(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<this>");
        String country = locale.getCountry();
        if (country != null) {
            int hashCode = country.hashCode();
            if (hashCode != 2177) {
                if (hashCode != 2183) {
                    if (hashCode != 2497) {
                        if (hashCode == 2642 && country.equals("SE")) {
                            return Integer.valueOf(R.drawable.flag_se);
                        }
                    } else if (country.equals("NO")) {
                        return Integer.valueOf(R.drawable.flag_no);
                    }
                } else if (country.equals("DK")) {
                    return Integer.valueOf(R.drawable.flag_dk);
                }
            } else if (country.equals("DE")) {
                return Integer.valueOf(R.drawable.flag_de);
            }
        }
        return null;
    }
}
