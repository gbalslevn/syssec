package dk.molslinjen.core.hilt;

import android.content.Context;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.SelectSeatingHelper;
import uniffi.molslinjen_shared.SelectSeatingHelperInterface;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/core/hilt/HelperProviderModule;", BuildConfig.FLAVOR, "<init>", "()V", "bindPhoneNumberUtil", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "context", "Landroid/content/Context;", "bindSelectSeatingHelper", "Luniffi/molslinjen_shared/SelectSeatingHelperInterface;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HelperProviderModule {
    public static final HelperProviderModule INSTANCE = new HelperProviderModule();

    private HelperProviderModule() {
    }

    public final PhoneNumberUtil bindPhoneNumberUtil(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PhoneNumberUtil createInstance = PhoneNumberUtil.createInstance(context);
        Intrinsics.checkNotNullExpressionValue(createInstance, "createInstance(...)");
        return createInstance;
    }

    public final SelectSeatingHelperInterface bindSelectSeatingHelper() {
        return new SelectSeatingHelper();
    }
}
