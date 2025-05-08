package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a¢\u0001\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0019\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001b\u0010\u001c\u001a\u00020\u000b*\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\"&\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "sourceCenter", "magnifierCenter", "Landroidx/compose/ui/unit/DpSize;", BuildConfig.FLAVOR, "onSizeChanged", BuildConfig.FLAVOR, "zoom", BuildConfig.FLAVOR, "useTextDefault", "size", "Landroidx/compose/ui/unit/Dp;", "cornerRadius", "elevation", "clippingEnabled", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "platformMagnifierFactory", "magnifier-jPUL71Q", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;)Landroidx/compose/ui/Modifier;", "magnifier", BuildConfig.FLAVOR, "sdkVersion", "isPlatformMagnifierSupported", "(I)Z", "other", "equalsIncludingNaN", "(FF)Z", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "MagnifierPositionInRoot", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getMagnifierPositionInRoot", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Magnifier_androidKt {
    private static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", null, 2, null);

    public static final boolean equalsIncludingNaN(float f5, float f6) {
        return (Float.isNaN(f5) && Float.isNaN(f6)) || f5 == f6;
    }

    public static final SemanticsPropertyKey<Function0<Offset>> getMagnifierPositionInRoot() {
        return MagnifierPositionInRoot;
    }

    public static final boolean isPlatformMagnifierSupported(int i5) {
        return i5 >= 28;
    }

    public static /* synthetic */ boolean isPlatformMagnifierSupported$default(int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = Build.VERSION.SDK_INT;
        }
        return isPlatformMagnifierSupported(i5);
    }

    /* renamed from: magnifier-jPUL71Q, reason: not valid java name */
    public static final Modifier m143magnifierjPUL71Q(Modifier modifier, Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f5, boolean z5, long j5, float f6, float f7, boolean z6, PlatformMagnifierFactory platformMagnifierFactory) {
        if (isPlatformMagnifierSupported$default(0, 1, null)) {
            return modifier.then(new MagnifierElement(function1, function12, function13, f5, z5, j5, f6, f7, z6, platformMagnifierFactory == null ? PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform() : platformMagnifierFactory, null));
        }
        return modifier;
    }
}
