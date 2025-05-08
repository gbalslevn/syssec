package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "width", BuildConfig.FLAVOR, "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "(FFIILandroidx/compose/ui/graphics/PathEffect;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCap-KaPHkGw", "()I", "I", "getJoin-LxFBmk8", "getMiter", "()F", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "getWidth", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Stroke extends DrawStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DefaultCap = StrokeCap.INSTANCE.m1607getButtKaPHkGw();
    private static final int DefaultJoin = StrokeJoin.INSTANCE.m1615getMiterLxFBmk8();
    private final int cap;
    private final int join;
    private final float miter;
    private final PathEffect pathEffect;
    private final float width;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\r"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/Stroke$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/graphics/StrokeCap;", "DefaultCap", "I", "getDefaultCap-KaPHkGw", "()I", BuildConfig.FLAVOR, "DefaultMiter", "F", "HairlineWidth", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDefaultCap-KaPHkGw, reason: not valid java name */
        public final int m1709getDefaultCapKaPHkGw() {
            return Stroke.DefaultCap;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Stroke(float f5, float f6, int i5, int i6, PathEffect pathEffect, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, i5, i6, pathEffect);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) other;
        return this.width == stroke.width && this.miter == stroke.miter && StrokeCap.m1604equalsimpl0(this.cap, stroke.cap) && StrokeJoin.m1611equalsimpl0(this.join, stroke.join) && Intrinsics.areEqual(this.pathEffect, stroke.pathEffect);
    }

    /* renamed from: getCap-KaPHkGw, reason: not valid java name and from getter */
    public final int getCap() {
        return this.cap;
    }

    /* renamed from: getJoin-LxFBmk8, reason: not valid java name and from getter */
    public final int getJoin() {
        return this.join;
    }

    public final float getMiter() {
        return this.miter;
    }

    public final PathEffect getPathEffect() {
        return this.pathEffect;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = ((((((Float.hashCode(this.width) * 31) + Float.hashCode(this.miter)) * 31) + StrokeCap.m1605hashCodeimpl(this.cap)) * 31) + StrokeJoin.m1612hashCodeimpl(this.join)) * 31;
        PathEffect pathEffect = this.pathEffect;
        return hashCode + (pathEffect != null ? pathEffect.hashCode() : 0);
    }

    public String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + ((Object) StrokeCap.m1606toStringimpl(this.cap)) + ", join=" + ((Object) StrokeJoin.m1613toStringimpl(this.join)) + ", pathEffect=" + this.pathEffect + ')';
    }

    public /* synthetic */ Stroke(float f5, float f6, int i5, int i6, PathEffect pathEffect, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0.0f : f5, (i7 & 2) != 0 ? 4.0f : f6, (i7 & 4) != 0 ? DefaultCap : i5, (i7 & 8) != 0 ? DefaultJoin : i6, (i7 & 16) != 0 ? null : pathEffect, null);
    }

    private Stroke(float f5, float f6, int i5, int i6, PathEffect pathEffect) {
        super(null);
        this.width = f5;
        this.miter = f6;
        this.cap = i5;
        this.join = i6;
        this.pathEffect = pathEffect;
    }
}
