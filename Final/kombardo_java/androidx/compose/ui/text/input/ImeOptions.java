package androidx.compose.ui.text.input;

import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(BO\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b \u0010\u0016R\u001d\u0010\n\u001a\u00020\t8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b!\u0010\u0016R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "singleLine", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "capitalization", "autoCorrect", "Landroidx/compose/ui/text/input/KeyboardType;", "keyboardType", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "platformImeOptions", "Landroidx/compose/ui/text/intl/LocaleList;", "hintLocales", "<init>", "(ZIZIILandroidx/compose/ui/text/input/PlatformImeOptions;Landroidx/compose/ui/text/intl/LocaleList;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Z", "getSingleLine", "()Z", "I", "getCapitalization-IUNYP9k", "getAutoCorrect", "getKeyboardType-PjHm6EE", "getImeAction-eUduSuo", "Landroidx/compose/ui/text/input/PlatformImeOptions;", "getPlatformImeOptions", "()Landroidx/compose/ui/text/input/PlatformImeOptions;", "Landroidx/compose/ui/text/intl/LocaleList;", "getHintLocales", "()Landroidx/compose/ui/text/intl/LocaleList;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ImeOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, null, null, 127, null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final PlatformImeOptions platformImeOptions;
    private final boolean singleLine;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", BuildConfig.FLAVOR, "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImeOptions(boolean z5, int i5, boolean z6, int i6, int i7, PlatformImeOptions platformImeOptions, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(z5, i5, z6, i6, i7, platformImeOptions, localeList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) other;
        if (this.singleLine != imeOptions.singleLine || !KeyboardCapitalization.m2398equalsimpl0(this.capitalization, imeOptions.capitalization) || this.autoCorrect != imeOptions.autoCorrect || !KeyboardType.m2410equalsimpl0(this.keyboardType, imeOptions.keyboardType) || !ImeAction.m2378equalsimpl0(this.imeAction, imeOptions.imeAction)) {
            return false;
        }
        imeOptions.getClass();
        return Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.hintLocales, imeOptions.hintLocales);
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getCapitalization-IUNYP9k, reason: not valid java name and from getter */
    public final int getCapitalization() {
        return this.capitalization;
    }

    public final LocaleList getHintLocales() {
        return this.hintLocales;
    }

    /* renamed from: getImeAction-eUduSuo, reason: not valid java name and from getter */
    public final int getImeAction() {
        return this.imeAction;
    }

    /* renamed from: getKeyboardType-PjHm6EE, reason: not valid java name and from getter */
    public final int getKeyboardType() {
        return this.keyboardType;
    }

    public final PlatformImeOptions getPlatformImeOptions() {
        return null;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.singleLine) * 31) + KeyboardCapitalization.m2399hashCodeimpl(this.capitalization)) * 31) + Boolean.hashCode(this.autoCorrect)) * 31) + KeyboardType.m2411hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m2379hashCodeimpl(this.imeAction)) * 961) + this.hintLocales.hashCode();
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + ((Object) KeyboardCapitalization.m2400toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m2412toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m2380toStringimpl(this.imeAction)) + ", platformImeOptions=" + ((Object) null) + ", hintLocales=" + this.hintLocales + ')';
    }

    private ImeOptions(boolean z5, int i5, boolean z6, int i6, int i7, PlatformImeOptions platformImeOptions, LocaleList localeList) {
        this.singleLine = z5;
        this.capitalization = i5;
        this.autoCorrect = z6;
        this.keyboardType = i6;
        this.imeAction = i7;
        this.hintLocales = localeList;
    }

    public /* synthetic */ ImeOptions(boolean z5, int i5, boolean z6, int i6, int i7, PlatformImeOptions platformImeOptions, LocaleList localeList, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z5, (i8 & 2) != 0 ? KeyboardCapitalization.INSTANCE.m2403getNoneIUNYP9k() : i5, (i8 & 4) != 0 ? true : z6, (i8 & 8) != 0 ? KeyboardType.INSTANCE.m2421getTextPjHm6EE() : i6, (i8 & 16) != 0 ? ImeAction.INSTANCE.m2382getDefaulteUduSuo() : i7, (i8 & 32) != 0 ? null : platformImeOptions, (i8 & 64) != 0 ? LocaleList.INSTANCE.getEmpty() : localeList, null);
    }
}
