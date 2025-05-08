package androidx.compose.material3.internal;

import androidx.compose.ui.text.PlatformTextStyle;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/PlatformTextStyle;", "defaultPlatformTextStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", BuildConfig.FLAVOR, "DefaultIncludeFontPadding", "Z", "DefaultPlatformTextStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "getDefaultPlatformTextStyle$annotations", "()V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DefaultPlatformTextStyle_androidKt {
    private static final boolean DefaultIncludeFontPadding = false;
    private static final PlatformTextStyle DefaultPlatformTextStyle = new PlatformTextStyle(false);

    public static final PlatformTextStyle defaultPlatformTextStyle() {
        return DefaultPlatformTextStyle;
    }
}
