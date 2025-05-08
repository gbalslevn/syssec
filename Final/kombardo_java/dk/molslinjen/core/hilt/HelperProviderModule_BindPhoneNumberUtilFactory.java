package dk.molslinjen.core.hilt;

import android.content.Context;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;

/* loaded from: classes2.dex */
public abstract class HelperProviderModule_BindPhoneNumberUtilFactory implements Provider {
    public static PhoneNumberUtil bindPhoneNumberUtil(Context context) {
        return (PhoneNumberUtil) Preconditions.checkNotNullFromProvides(HelperProviderModule.INSTANCE.bindPhoneNumberUtil(context));
    }
}
