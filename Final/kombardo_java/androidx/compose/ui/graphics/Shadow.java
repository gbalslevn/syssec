package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R&\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u0012\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u0019\u0010\u0016R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\u001b\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/ui/graphics/Shadow;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/geometry/Offset;", "offset", BuildConfig.FLAVOR, "blurRadius", "<init>", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "J", "getColor-0d7_KjU", "()J", "getColor-0d7_KjU$annotations", "()V", "getOffset-F1C5BW0", "getOffset-F1C5BW0$annotations", "F", "getBlurRadius", "()F", "getBlurRadius$annotations", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Shadow {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Shadow None = new Shadow(0, 0, 0.0f, 7, null);
    private final float blurRadius;
    private final long color;
    private final long offset;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/Shadow$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/graphics/Shadow;", "None", "Landroidx/compose/ui/graphics/Shadow;", "getNone", "()Landroidx/compose/ui/graphics/Shadow;", "getNone$annotations", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Shadow getNone() {
            return Shadow.None;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Shadow(long j5, long j6, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, f5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shadow)) {
            return false;
        }
        Shadow shadow = (Shadow) other;
        return Color.m1487equalsimpl0(this.color, shadow.color) && Offset.m1334equalsimpl0(this.offset, shadow.offset) && this.blurRadius == shadow.blurRadius;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getColor() {
        return this.color;
    }

    /* renamed from: getOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getOffset() {
        return this.offset;
    }

    public int hashCode() {
        return (((Color.m1493hashCodeimpl(this.color) * 31) + Offset.m1339hashCodeimpl(this.offset)) * 31) + Float.hashCode(this.blurRadius);
    }

    public String toString() {
        return "Shadow(color=" + ((Object) Color.m1494toStringimpl(this.color)) + ", offset=" + ((Object) Offset.m1344toStringimpl(this.offset)) + ", blurRadius=" + this.blurRadius + ')';
    }

    private Shadow(long j5, long j6, float f5) {
        this.color = j5;
        this.offset = j6;
        this.blurRadius = f5;
    }

    public /* synthetic */ Shadow(long j5, long j6, float f5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? ColorKt.Color(4278190080L) : j5, (i5 & 2) != 0 ? Offset.INSTANCE.m1349getZeroF1C5BW0() : j6, (i5 & 4) != 0 ? 0.0f : f5, null);
    }
}
