package dk.molslinjen.extensions;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/extensions/LocaleUtils;", BuildConfig.FLAVOR, "<init>", "()V", "frequentlyUsedCountryCodes", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getFrequentlyUsedCountryCodes", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocaleUtils {
    public static final LocaleUtils INSTANCE = new LocaleUtils();
    private static final List<String> frequentlyUsedCountryCodes = CollectionsKt.listOf((Object[]) new String[]{"DK", "DE", "NO", "SE"});
    public static final int $stable = 8;

    private LocaleUtils() {
    }

    public final List<String> getFrequentlyUsedCountryCodes() {
        return frequentlyUsedCountryCodes;
    }
}
