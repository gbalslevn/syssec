package androidx.compose.ui.text.intl;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004*\n\u0010\u0005\"\u00020\u00002\u00020\u0000¨\u0006\u0006"}, d2 = {"Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", BuildConfig.FLAVOR, "getLanguageTag", "(Ljava/util/Locale;)Ljava/lang/String;", "PlatformLocale", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PlatformLocale_jvmKt {
    public static final String getLanguageTag(java.util.Locale locale) {
        return locale.toLanguageTag();
    }
}
