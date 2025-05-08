package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/BlendModeColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "nativeColorFilter", "<init>", "(JILandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JILkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "J", "getColor-0d7_KjU", "()J", "I", "getBlendMode-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BlendModeColorFilter extends ColorFilter {
    private final int blendMode;
    private final long color;

    public /* synthetic */ BlendModeColorFilter(long j5, int i5, android.graphics.ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, i5, colorFilter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlendModeColorFilter)) {
            return false;
        }
        BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) other;
        return Color.m1487equalsimpl0(this.color, blendModeColorFilter.color) && BlendMode.m1429equalsimpl0(this.blendMode, blendModeColorFilter.blendMode);
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name and from getter */
    public final int getBlendMode() {
        return this.blendMode;
    }

    public int hashCode() {
        return (Color.m1493hashCodeimpl(this.color) * 31) + BlendMode.m1430hashCodeimpl(this.blendMode);
    }

    public String toString() {
        return "BlendModeColorFilter(color=" + ((Object) Color.m1494toStringimpl(this.color)) + ", blendMode=" + ((Object) BlendMode.m1431toStringimpl(this.blendMode)) + ')';
    }

    public /* synthetic */ BlendModeColorFilter(long j5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, i5);
    }

    private BlendModeColorFilter(long j5, int i5, android.graphics.ColorFilter colorFilter) {
        super(colorFilter);
        this.color = j5;
        this.blendMode = i5;
    }

    private BlendModeColorFilter(long j5, int i5) {
        this(j5, i5, AndroidColorFilter_androidKt.m1397actualTintColorFilterxETnrds(j5, i5), null);
    }
}
