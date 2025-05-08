package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bB1\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000eBE\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0011BO\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b \u0010\u001c¨\u0006!"}, d2 = {"Landroidx/compose/ui/window/PopupProperties;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "flags", BuildConfig.FLAVOR, "inheritSecurePolicy", "dismissOnBackPress", "dismissOnClickOutside", "excludeFromSystemGesture", "usePlatformDefaultWidth", "<init>", "(IZZZZZ)V", "focusable", "clippingEnabled", "(ZZZZ)V", "Landroidx/compose/ui/window/SecureFlagPolicy;", "securePolicy", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZZ)V", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "getFlags$ui_release", "Z", "getInheritSecurePolicy$ui_release", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getExcludeFromSystemGesture", "getUsePlatformDefaultWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PopupProperties {
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final int flags;
    private final boolean inheritSecurePolicy;
    private final boolean usePlatformDefaultWidth;

    public PopupProperties(int i5, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.flags = i5;
        this.inheritSecurePolicy = z5;
        this.dismissOnBackPress = z6;
        this.dismissOnClickOutside = z7;
        this.excludeFromSystemGesture = z8;
        this.usePlatformDefaultWidth = z9;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) other;
        return this.flags == popupProperties.flags && this.inheritSecurePolicy == popupProperties.inheritSecurePolicy && this.dismissOnBackPress == popupProperties.dismissOnBackPress && this.dismissOnClickOutside == popupProperties.dismissOnClickOutside && this.excludeFromSystemGesture == popupProperties.excludeFromSystemGesture && this.usePlatformDefaultWidth == popupProperties.usePlatformDefaultWidth;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    /* renamed from: getFlags$ui_release, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* renamed from: getInheritSecurePolicy$ui_release, reason: from getter */
    public final boolean getInheritSecurePolicy() {
        return this.inheritSecurePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return (((((((((this.flags * 31) + Boolean.hashCode(this.inheritSecurePolicy)) * 31) + Boolean.hashCode(this.dismissOnBackPress)) * 31) + Boolean.hashCode(this.dismissOnClickOutside)) * 31) + Boolean.hashCode(this.excludeFromSystemGesture)) * 31) + Boolean.hashCode(this.usePlatformDefaultWidth);
    }

    public /* synthetic */ PopupProperties(boolean z5, boolean z6, boolean z7, boolean z8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? true : z6, (i5 & 4) != 0 ? true : z7, (i5 & 8) != 0 ? true : z8);
    }

    public PopupProperties(boolean z5, boolean z6, boolean z7, boolean z8) {
        this(z5, z6, z7, SecureFlagPolicy.Inherit, true, z8);
    }

    public /* synthetic */ PopupProperties(boolean z5, boolean z6, boolean z7, SecureFlagPolicy secureFlagPolicy, boolean z8, boolean z9, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? true : z6, (i5 & 4) != 0 ? true : z7, (i5 & 8) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i5 & 16) != 0 ? true : z8, (i5 & 32) == 0 ? z9 : true);
    }

    public PopupProperties(boolean z5, boolean z6, boolean z7, SecureFlagPolicy secureFlagPolicy, boolean z8, boolean z9) {
        this(z5, z6, z7, secureFlagPolicy, z8, z9, false);
    }

    public PopupProperties(boolean z5, boolean z6, boolean z7, SecureFlagPolicy secureFlagPolicy, boolean z8, boolean z9, boolean z10) {
        this(AndroidPopup_androidKt.access$createFlags(z5, secureFlagPolicy, z9), secureFlagPolicy == SecureFlagPolicy.Inherit, z6, z7, z8, z10);
    }
}
