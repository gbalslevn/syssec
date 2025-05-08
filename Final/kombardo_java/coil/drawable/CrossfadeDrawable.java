package coil.drawable;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.media.session.a;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\u000e\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iBE\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\bH\u0017¢\u0006\u0004\b\u001f\u0010\u001bJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&H\u0014¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\bH\u0014¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0014¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u0010\u001bJ\u000f\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u0010\u001bJ\u001f\u00106\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00012\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0001H\u0016¢\u0006\u0004\b8\u00109J'\u0010<\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00012\u0006\u00105\u001a\u0002042\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\bH\u0016¢\u0006\u0004\b?\u0010\u001eJ\u0019\u0010B\u001a\u00020\u00132\b\u0010A\u001a\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bB\u0010CJ\u0019\u0010F\u001a\u00020\u00132\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bF\u0010GJ\u0019\u0010J\u001a\u00020\u00132\b\u0010I\u001a\u0004\u0018\u00010HH\u0017¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\nH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010\u0004\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0004\u0010\u0015J\u000f\u0010N\u001a\u00020\u0013H\u0016¢\u0006\u0004\bN\u0010\u0015J\u001f\u0010S\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00012\u0006\u0010P\u001a\u00020&H\u0001¢\u0006\u0004\bQ\u0010RR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010T\u001a\u0004\bU\u0010VR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010W\u001a\u0004\bX\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010Y\u001a\u0004\bZ\u0010MR\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010Y\u001a\u0004\b[\u0010MR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00030\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010WR\u0014\u0010`\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010WR\u0016\u0010a\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010WR\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010WR(\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010d\u001a\u0004\u0018\u00010\u00018\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010e\u001a\u0004\bf\u0010gR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0005\u0010e\u001a\u0004\bh\u0010g¨\u0006j"}, d2 = {"Lcoil/drawable/CrossfadeDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", BuildConfig.FLAVOR, "start", "end", "Lcoil/size/Scale;", "scale", BuildConfig.FLAVOR, "durationMillis", BuildConfig.FLAVOR, "fadeStart", "preferExactIntrinsicSize", "<init>", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/size/Scale;IZZ)V", "startSize", "endSize", "computeIntrinsicDimension", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", BuildConfig.FLAVOR, "markDone", "()V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "getAlpha", "()I", "alpha", "setAlpha", "(I)V", "getOpacity", "Landroid/graphics/ColorFilter;", "getColorFilter", "()Landroid/graphics/ColorFilter;", "colorFilter", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "(Landroid/graphics/Rect;)V", "level", "onLevelChange", "(I)Z", BuildConfig.FLAVOR, "state", "onStateChange", "([I)Z", "getIntrinsicWidth", "getIntrinsicHeight", "who", "Ljava/lang/Runnable;", "what", "unscheduleDrawable", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;)V", "invalidateDrawable", "(Landroid/graphics/drawable/Drawable;)V", BuildConfig.FLAVOR, "when", "scheduleDrawable", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V", "tintColor", "setTint", "Landroid/content/res/ColorStateList;", "tint", "setTintList", "(Landroid/content/res/ColorStateList;)V", "Landroid/graphics/PorterDuff$Mode;", "tintMode", "setTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "Landroid/graphics/BlendMode;", "blendMode", "setTintBlendMode", "(Landroid/graphics/BlendMode;)V", "isRunning", "()Z", "stop", "drawable", "targetBounds", "updateBounds$coil_base_release", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Rect;)V", "updateBounds", "Lcoil/size/Scale;", "getScale", "()Lcoil/size/Scale;", "I", "getDurationMillis", "Z", "getFadeStart", "getPreferExactIntrinsicSize", BuildConfig.FLAVOR, "callbacks", "Ljava/util/List;", "intrinsicWidth", "intrinsicHeight", "startTimeMillis", "J", "maxAlpha", "<set-?>", "Landroid/graphics/drawable/Drawable;", "getStart", "()Landroid/graphics/drawable/Drawable;", "getEnd", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CrossfadeDrawable extends Drawable implements Drawable.Callback, Animatable {
    private static final int STATE_DONE = 2;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_START = 0;
    private final List<Object> callbacks = new ArrayList();
    private final int durationMillis;
    private final Drawable end;
    private final boolean fadeStart;
    private final int intrinsicHeight;
    private final int intrinsicWidth;
    private int maxAlpha;
    private final boolean preferExactIntrinsicSize;
    private final Scale scale;
    private Drawable start;
    private long startTimeMillis;
    private int state;

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale, int i5, boolean z5, boolean z6) {
        this.scale = scale;
        this.durationMillis = i5;
        this.fadeStart = z5;
        this.preferExactIntrinsicSize = z6;
        this.intrinsicWidth = computeIntrinsicDimension(drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicWidth()) : null);
        this.intrinsicHeight = computeIntrinsicDimension(drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicHeight()) : null);
        this.maxAlpha = Function.USE_VARARGS;
        this.start = drawable != null ? drawable.mutate() : null;
        Drawable mutate = drawable2 != null ? drawable2.mutate() : null;
        this.end = mutate;
        if (i5 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
        Drawable drawable3 = this.start;
        if (drawable3 != null) {
            drawable3.setCallback(this);
        }
        if (mutate == null) {
            return;
        }
        mutate.setCallback(this);
    }

    private final int computeIntrinsicDimension(Integer startSize, Integer endSize) {
        if (this.preferExactIntrinsicSize || ((startSize == null || startSize.intValue() != -1) && (endSize == null || endSize.intValue() != -1))) {
            return Math.max(startSize != null ? startSize.intValue() : -1, endSize != null ? endSize.intValue() : -1);
        }
        return -1;
    }

    private final void markDone() {
        this.state = 2;
        this.start = null;
        List<Object> list = this.callbacks;
        if (list.size() <= 0) {
            return;
        }
        a.a(list.get(0));
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save;
        Drawable drawable;
        int i5 = this.state;
        if (i5 == 0) {
            Drawable drawable2 = this.start;
            if (drawable2 != null) {
                drawable2.setAlpha(this.maxAlpha);
                save = canvas.save();
                try {
                    drawable2.draw(canvas);
                    return;
                } finally {
                }
            }
            return;
        }
        if (i5 == 2) {
            Drawable drawable3 = this.end;
            if (drawable3 != null) {
                drawable3.setAlpha(this.maxAlpha);
                save = canvas.save();
                try {
                    drawable3.draw(canvas);
                    return;
                } finally {
                }
            }
            return;
        }
        double uptimeMillis = (SystemClock.uptimeMillis() - this.startTimeMillis) / this.durationMillis;
        double coerceIn = RangesKt.coerceIn(uptimeMillis, 0.0d, 1.0d);
        int i6 = this.maxAlpha;
        int i7 = (int) (coerceIn * i6);
        if (this.fadeStart) {
            i6 -= i7;
        }
        boolean z5 = uptimeMillis >= 1.0d;
        if (!z5 && (drawable = this.start) != null) {
            drawable.setAlpha(i6);
            save = canvas.save();
            try {
                drawable.draw(canvas);
            } finally {
            }
        }
        Drawable drawable4 = this.end;
        if (drawable4 != null) {
            drawable4.setAlpha(i7);
            save = canvas.save();
            try {
                drawable4.draw(canvas);
            } finally {
            }
        }
        if (z5) {
            markDone();
        } else {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.maxAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        Drawable drawable;
        int i5 = this.state;
        if (i5 == 0) {
            Drawable drawable2 = this.start;
            if (drawable2 != null) {
                return drawable2.getColorFilter();
            }
            return null;
        }
        if (i5 != 1) {
            if (i5 == 2 && (drawable = this.end) != null) {
                return drawable.getColorFilter();
            }
            return null;
        }
        Drawable drawable3 = this.end;
        if (drawable3 != null && (colorFilter = drawable3.getColorFilter()) != null) {
            return colorFilter;
        }
        Drawable drawable4 = this.start;
        if (drawable4 != null) {
            return drawable4.getColorFilter();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.intrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.intrinsicWidth;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public int getOpacity() {
        Drawable drawable = this.start;
        Drawable drawable2 = this.end;
        int i5 = this.state;
        if (i5 == 0) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        }
        if (i5 == 2) {
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        }
        if (drawable != null && drawable2 != null) {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        }
        if (drawable != null) {
            return drawable.getOpacity();
        }
        if (drawable2 != null) {
            return drawable2.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.state == 1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Drawable drawable = this.start;
        if (drawable != null) {
            updateBounds$coil_base_release(drawable, bounds);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            updateBounds$coil_base_release(drawable2, bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int level) {
        Drawable drawable = this.start;
        boolean level2 = drawable != null ? drawable.setLevel(level) : false;
        Drawable drawable2 = this.end;
        return level2 || (drawable2 != null ? drawable2.setLevel(level) : false);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] state) {
        Drawable drawable = this.start;
        boolean state2 = drawable != null ? drawable.setState(state) : false;
        Drawable drawable2 = this.end;
        return state2 || (drawable2 != null ? drawable2.setState(state) : false);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (alpha >= 0 && alpha < 256) {
            this.maxAlpha = alpha;
            return;
        }
        throw new IllegalArgumentException(("Invalid alpha: " + alpha).toString());
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.end;
        if (drawable2 == null) {
            return;
        }
        drawable2.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int tintColor) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTint(tintColor);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTint(tintColor);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintList(tint);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintList(tint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode tintMode) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintMode(tintMode);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintMode(tintMode);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Object obj = this.start;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.start();
        }
        Object obj2 = this.end;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.start();
        }
        if (this.state != 0) {
            return;
        }
        this.state = 1;
        this.startTimeMillis = SystemClock.uptimeMillis();
        List<Object> list = this.callbacks;
        if (list.size() <= 0) {
            invalidateSelf();
        } else {
            a.a(list.get(0));
            throw null;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Object obj = this.start;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.stop();
        }
        Object obj2 = this.end;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.stop();
        }
        if (this.state != 2) {
            markDone();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable who, Runnable what) {
        unscheduleSelf(what);
    }

    public final void updateBounds$coil_base_release(Drawable drawable, Rect targetBounds) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(targetBounds);
            return;
        }
        int width = targetBounds.width();
        int height = targetBounds.height();
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(intrinsicWidth, intrinsicHeight, width, height, this.scale);
        double d5 = 2;
        int roundToInt = MathKt.roundToInt((width - (intrinsicWidth * computeSizeMultiplier)) / d5);
        int roundToInt2 = MathKt.roundToInt((height - (computeSizeMultiplier * intrinsicHeight)) / d5);
        drawable.setBounds(targetBounds.left + roundToInt, targetBounds.top + roundToInt2, targetBounds.right - roundToInt, targetBounds.bottom - roundToInt2);
    }
}
