package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:BU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010BS\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0012J\u0019\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\u0007\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b&\u0010\u001dR\u001d\u0010\t\u001a\u00020\b8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b'\u0010\u001dR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b+\u0010%R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00103\u001a\u00020\u00028BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b2\u0010\u001dR\u001a\u00105\u001a\u00020\u00068BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b4\u0010\u001dR\u0014\u00107\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010.R\u001a\u00109\u001a\u00020\b8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b8\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "capitalization", BuildConfig.FLAVOR, "autoCorrectEnabled", "Landroidx/compose/ui/text/input/KeyboardType;", "keyboardType", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "platformImeOptions", "showKeyboardOnFocus", "Landroidx/compose/ui/text/intl/LocaleList;", "hintLocales", "<init>", "(ILjava/lang/Boolean;IILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoCorrect", "(IZIILandroidx/compose/ui/text/input/PlatformImeOptions;Ljava/lang/Boolean;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "singleLine", "Landroidx/compose/ui/text/input/ImeOptions;", "toImeOptions$foundation_release", "(Z)Landroidx/compose/ui/text/input/ImeOptions;", "toImeOptions", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "I", "getCapitalization-IUNYP9k", "Ljava/lang/Boolean;", "getAutoCorrectEnabled", "()Ljava/lang/Boolean;", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "getShowKeyboardOnFocus", "Landroidx/compose/ui/text/intl/LocaleList;", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "getAutoCorrectOrDefault", "()Z", "autoCorrectOrDefault", "getCapitalizationOrDefault-IUNYP9k", "capitalizationOrDefault", "getKeyboardTypeOrDefault-PjHm6EE", "keyboardTypeOrDefault", "getHintLocalesOrDefault", "hintLocalesOrDefault", "getImeActionOrDefault-eUduSuo$foundation_release", "imeActionOrDefault", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyboardOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KeyboardOptions Default = new KeyboardOptions(0, (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 127, (DefaultConstructorMarker) null);
    private static final KeyboardOptions SecureTextField = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.INSTANCE.m2419getPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 121, (DefaultConstructorMarker) null);
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final Boolean showKeyboardOnFocus;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/foundation/text/KeyboardOptions;", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault$annotations", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }

        private Companion() {
        }
    }

    public /* synthetic */ KeyboardOptions(int i5, Boolean bool, int i6, int i7, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, bool, i6, i7, platformImeOptions, bool2, localeList);
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean bool = this.autoCorrectEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m482getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization m2395boximpl = KeyboardCapitalization.m2395boximpl(this.capitalization);
        int value = m2395boximpl.getValue();
        KeyboardCapitalization.Companion companion = KeyboardCapitalization.INSTANCE;
        if (KeyboardCapitalization.m2398equalsimpl0(value, companion.m2405getUnspecifiedIUNYP9k())) {
            m2395boximpl = null;
        }
        return m2395boximpl != null ? m2395boximpl.getValue() : companion.m2403getNoneIUNYP9k();
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList localeList = this.hintLocales;
        return localeList == null ? LocaleList.INSTANCE.getEmpty() : localeList;
    }

    /* renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m483getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType m2407boximpl = KeyboardType.m2407boximpl(this.keyboardType);
        int value = m2407boximpl.getValue();
        KeyboardType.Companion companion = KeyboardType.INSTANCE;
        if (KeyboardType.m2410equalsimpl0(value, companion.m2422getUnspecifiedPjHm6EE())) {
            m2407boximpl = null;
        }
        return m2407boximpl != null ? m2407boximpl.getValue() : companion.m2421getTextPjHm6EE();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) other;
        if (!KeyboardCapitalization.m2398equalsimpl0(this.capitalization, keyboardOptions.capitalization) || !Intrinsics.areEqual(this.autoCorrectEnabled, keyboardOptions.autoCorrectEnabled) || !KeyboardType.m2410equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) || !ImeAction.m2378equalsimpl0(this.imeAction, keyboardOptions.imeAction)) {
            return false;
        }
        keyboardOptions.getClass();
        return Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.showKeyboardOnFocus, keyboardOptions.showKeyboardOnFocus) && Intrinsics.areEqual(this.hintLocales, keyboardOptions.hintLocales);
    }

    /* renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m484getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction m2375boximpl = ImeAction.m2375boximpl(this.imeAction);
        int value = m2375boximpl.getValue();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        if (ImeAction.m2378equalsimpl0(value, companion.m2390getUnspecifiedeUduSuo())) {
            m2375boximpl = null;
        }
        return m2375boximpl != null ? m2375boximpl.getValue() : companion.m2382getDefaulteUduSuo();
    }

    public int hashCode() {
        int m2399hashCodeimpl = KeyboardCapitalization.m2399hashCodeimpl(this.capitalization) * 31;
        Boolean bool = this.autoCorrectEnabled;
        int hashCode = (((((m2399hashCodeimpl + (bool != null ? bool.hashCode() : 0)) * 31) + KeyboardType.m2411hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m2379hashCodeimpl(this.imeAction)) * 961;
        Boolean bool2 = this.showKeyboardOnFocus;
        int hashCode2 = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.hintLocales;
        return hashCode2 + (localeList != null ? localeList.hashCode() : 0);
    }

    public final ImeOptions toImeOptions$foundation_release(boolean singleLine) {
        return new ImeOptions(singleLine, m482getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m483getKeyboardTypeOrDefaultPjHm6EE(), m484getImeActionOrDefaulteUduSuo$foundation_release(), null, getHintLocalesOrDefault(), null);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m2400toStringimpl(this.capitalization)) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + ((Object) KeyboardType.m2412toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m2380toStringimpl(this.imeAction)) + ", platformImeOptions=" + ((Object) null) + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }

    @Deprecated
    public /* synthetic */ KeyboardOptions(int i5, boolean z5, int i6, int i7, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, z5, i6, i7, platformImeOptions, bool, localeList);
    }

    private KeyboardOptions(int i5, Boolean bool, int i6, int i7, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList) {
        this.capitalization = i5;
        this.autoCorrectEnabled = bool;
        this.keyboardType = i6;
        this.imeAction = i7;
        this.showKeyboardOnFocus = bool2;
        this.hintLocales = localeList;
    }

    public /* synthetic */ KeyboardOptions(int i5, Boolean bool, int i6, int i7, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m2405getUnspecifiedIUNYP9k() : i5, (i8 & 2) != 0 ? null : bool, (i8 & 4) != 0 ? KeyboardType.INSTANCE.m2422getUnspecifiedPjHm6EE() : i6, (i8 & 8) != 0 ? ImeAction.INSTANCE.m2390getUnspecifiedeUduSuo() : i7, (i8 & 16) != 0 ? null : platformImeOptions, (i8 & 32) != 0 ? null : bool2, (i8 & 64) == 0 ? localeList : null, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ KeyboardOptions(int i5, boolean z5, int i6, int i7, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? KeyboardCapitalization.INSTANCE.m2405getUnspecifiedIUNYP9k() : i5, z5, (i8 & 4) != 0 ? KeyboardType.INSTANCE.m2422getUnspecifiedPjHm6EE() : i6, (i8 & 8) != 0 ? ImeAction.INSTANCE.m2390getUnspecifiedeUduSuo() : i7, (i8 & 16) != 0 ? null : platformImeOptions, (i8 & 32) != 0 ? null : bool, (i8 & 64) != 0 ? null : localeList, (DefaultConstructorMarker) null);
    }

    private KeyboardOptions(int i5, boolean z5, int i6, int i7, PlatformImeOptions platformImeOptions, Boolean bool, LocaleList localeList) {
        this(i5, Boolean.valueOf(z5), i6, i7, platformImeOptions, bool, localeList, (DefaultConstructorMarker) null);
    }
}
