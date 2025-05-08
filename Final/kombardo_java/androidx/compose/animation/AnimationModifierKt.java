package androidx.compose.animation;

import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/IntSize;", "InvalidSize", "J", "getInvalidSize", "()J", BuildConfig.FLAVOR, "isValid-ozmzZPI", "(J)Z", "isValid", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimationModifierKt {
    private static final long InvalidSize = IntSizeKt.IntSize(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public static final long getInvalidSize() {
        return InvalidSize;
    }

    /* renamed from: isValid-ozmzZPI, reason: not valid java name */
    public static final boolean m25isValidozmzZPI(long j5) {
        return !IntSize.m2659equalsimpl0(j5, InvalidSize);
    }
}
