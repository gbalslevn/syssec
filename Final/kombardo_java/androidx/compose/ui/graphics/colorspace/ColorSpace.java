package androidx.compose.ui.graphics.colorspace;

import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000 52\u00020\u0001:\u00015B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\rJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010!\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0000H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H\u0016¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010#R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010.R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b0\u0010)R\u0011\u00102\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b1\u0010)R\u0014\u00103\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorSpace;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "name", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "model", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "<init>", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "component", BuildConfig.FLAVOR, "getMinValue", "(I)F", "getMaxValue", "v0", "v1", "v2", BuildConfig.FLAVOR, "toXy$ui_graphics_release", "(FFF)J", "toXy", "toZ$ui_graphics_release", "(FFF)F", "toZ", "x", "y", "z", "a", "colorSpace", "Landroidx/compose/ui/graphics/Color;", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "xyzaToColor", "toString", "()Ljava/lang/String;", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getName", "J", "getModel-xdoWZVw", "()J", "I", "getId$ui_graphics_release", "getComponentCount", "componentCount", "isSrgb", "()Z", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ColorSpace {
    private final int id;
    private final long model;
    private final String name;

    public /* synthetic */ ColorSpace(String str, long j5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j5, i5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) other;
        if (this.id == colorSpace.id && Intrinsics.areEqual(this.name, colorSpace.name)) {
            return ColorModel.m1638equalsimpl0(this.model, colorSpace.model);
        }
        return false;
    }

    public final int getComponentCount() {
        return ColorModel.m1639getComponentCountimpl(this.model);
    }

    /* renamed from: getId$ui_graphics_release, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public abstract float getMaxValue(int component);

    public abstract float getMinValue(int component);

    /* renamed from: getModel-xdoWZVw, reason: not valid java name and from getter */
    public final long getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + ColorModel.m1640hashCodeimpl(this.model)) * 31) + this.id;
    }

    public boolean isSrgb() {
        return false;
    }

    public String toString() {
        return this.name + " (id=" + this.id + ", model=" + ((Object) ColorModel.m1641toStringimpl(this.model)) + ')';
    }

    public abstract long toXy$ui_graphics_release(float v02, float v12, float v22);

    public abstract float toZ$ui_graphics_release(float v02, float v12, float v22);

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release, reason: not valid java name */
    public abstract long mo1646xyzaToColorJlNiLsg$ui_graphics_release(float x5, float y5, float z5, float a5, ColorSpace colorSpace);

    private ColorSpace(String str, long j5, int i5) {
        this.name = str;
        this.model = j5;
        this.id = i5;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i5 < -1 || i5 > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }
}
