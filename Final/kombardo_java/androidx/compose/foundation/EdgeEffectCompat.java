package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0012\u0010\u0012\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0004R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/EdgeEffectCompat;", BuildConfig.FLAVOR, "()V", "distanceCompat", BuildConfig.FLAVOR, "Landroid/widget/EdgeEffect;", "getDistanceCompat", "(Landroid/widget/EdgeEffect;)F", "create", "context", "Landroid/content/Context;", "onAbsorbCompat", BuildConfig.FLAVOR, "velocity", BuildConfig.FLAVOR, "onPullDistanceCompat", "deltaDistance", "displacement", "onReleaseWithOppositeDelta", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    public static final EdgeEffectCompat INSTANCE = new EdgeEffectCompat();

    private EdgeEffectCompat() {
    }

    public final EdgeEffect create(Context context) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.INSTANCE.create(context, null) : new GlowEdgeEffectCompat(context);
    }

    public final float getDistanceCompat(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public final void onAbsorbCompat(EdgeEffect edgeEffect, int i5) {
        if (Build.VERSION.SDK_INT >= 31) {
            edgeEffect.onAbsorb(i5);
        } else if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(i5);
        }
    }

    public final float onPullDistanceCompat(EdgeEffect edgeEffect, float f5, float f6) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.onPullDistance(edgeEffect, f5, f6);
        }
        edgeEffect.onPull(f5, f6);
        return f5;
    }

    public final void onReleaseWithOppositeDelta(EdgeEffect edgeEffect, float f5) {
        if (edgeEffect instanceof GlowEdgeEffectCompat) {
            ((GlowEdgeEffectCompat) edgeEffect).releaseWithOppositeDelta(f5);
        } else {
            edgeEffect.onRelease();
        }
    }
}
