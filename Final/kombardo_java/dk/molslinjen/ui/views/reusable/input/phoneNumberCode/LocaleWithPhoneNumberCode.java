package dk.molslinjen.ui.views.reusable.input.phoneNumberCode;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/phoneNumberCode/LocaleWithPhoneNumberCode;", BuildConfig.FLAVOR, "Ljava/util/Locale;", "locale", BuildConfig.FLAVOR, "phoneNumberCode", "<init>", "(Ljava/util/Locale;I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "I", "getPhoneNumberCode", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LocaleWithPhoneNumberCode {
    private final Locale locale;
    private final int phoneNumberCode;

    public LocaleWithPhoneNumberCode(Locale locale, int i5) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.locale = locale;
        this.phoneNumberCode = i5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocaleWithPhoneNumberCode)) {
            return false;
        }
        LocaleWithPhoneNumberCode localeWithPhoneNumberCode = (LocaleWithPhoneNumberCode) other;
        return Intrinsics.areEqual(this.locale, localeWithPhoneNumberCode.locale) && this.phoneNumberCode == localeWithPhoneNumberCode.phoneNumberCode;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final int getPhoneNumberCode() {
        return this.phoneNumberCode;
    }

    public int hashCode() {
        return (this.locale.hashCode() * 31) + Integer.hashCode(this.phoneNumberCode);
    }

    public String toString() {
        return "LocaleWithPhoneNumberCode(locale=" + this.locale + ", phoneNumberCode=" + this.phoneNumberCode + ")";
    }
}
