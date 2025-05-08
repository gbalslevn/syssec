package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b/\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R1\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR1\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR1\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR1\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR1\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR1\u0010\b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR1\u0010\t\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR1\u0010\n\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR1\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR1\u0010\f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b5\u0010\u0018\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR1\u0010\r\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b8\u0010\u0018\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR1\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@@X\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b;\u0010\u0018\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0018\u001a\u0004\b\u0010\u0010?\"\u0004\b@\u0010A\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/material/Colors;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", BuildConfig.FLAVOR, "isLight", "<init>", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "<set-?>", "primary$delegate", "Landroidx/compose/runtime/MutableState;", "getPrimary-0d7_KjU", "()J", "setPrimary-8_81llA$material_release", "(J)V", "primaryVariant$delegate", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material_release", "secondary$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material_release", "secondaryVariant$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material_release", "background$delegate", "getBackground-0d7_KjU", "setBackground-8_81llA$material_release", "surface$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material_release", "error$delegate", "getError-0d7_KjU", "setError-8_81llA$material_release", "onPrimary$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material_release", "onSecondary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material_release", "onBackground$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material_release", "onSurface$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material_release", "onError$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material_release", "isLight$delegate", "()Z", "setLight$material_release", "(Z)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Colors {

    /* renamed from: background$delegate, reason: from kotlin metadata */
    private final MutableState background;

    /* renamed from: error$delegate, reason: from kotlin metadata */
    private final MutableState error;

    /* renamed from: isLight$delegate, reason: from kotlin metadata */
    private final MutableState isLight;

    /* renamed from: onBackground$delegate, reason: from kotlin metadata */
    private final MutableState onBackground;

    /* renamed from: onError$delegate, reason: from kotlin metadata */
    private final MutableState onError;

    /* renamed from: onPrimary$delegate, reason: from kotlin metadata */
    private final MutableState onPrimary;

    /* renamed from: onSecondary$delegate, reason: from kotlin metadata */
    private final MutableState onSecondary;

    /* renamed from: onSurface$delegate, reason: from kotlin metadata */
    private final MutableState onSurface;

    /* renamed from: primary$delegate, reason: from kotlin metadata */
    private final MutableState primary;

    /* renamed from: primaryVariant$delegate, reason: from kotlin metadata */
    private final MutableState primaryVariant;

    /* renamed from: secondary$delegate, reason: from kotlin metadata */
    private final MutableState secondary;

    /* renamed from: secondaryVariant$delegate, reason: from kotlin metadata */
    private final MutableState secondaryVariant;

    /* renamed from: surface$delegate, reason: from kotlin metadata */
    private final MutableState surface;

    public /* synthetic */ Colors(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m660getBackground0d7_KjU() {
        return ((Color) this.background.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m661getError0d7_KjU() {
        return ((Color) this.error.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m662getOnBackground0d7_KjU() {
        return ((Color) this.onBackground.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m663getOnError0d7_KjU() {
        return ((Color) this.onError.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m664getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m665getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m666getOnSurface0d7_KjU() {
        return ((Color) this.onSurface.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m667getPrimary0d7_KjU() {
        return ((Color) this.primary.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m668getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m669getSecondary0d7_KjU() {
        return ((Color) this.secondary.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m670getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m671getSurface0d7_KjU() {
        return ((Color) this.surface.getValue()).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLight() {
        return ((Boolean) this.isLight.getValue()).booleanValue();
    }

    public String toString() {
        return "Colors(primary=" + ((Object) Color.m1494toStringimpl(m667getPrimary0d7_KjU())) + ", primaryVariant=" + ((Object) Color.m1494toStringimpl(m668getPrimaryVariant0d7_KjU())) + ", secondary=" + ((Object) Color.m1494toStringimpl(m669getSecondary0d7_KjU())) + ", secondaryVariant=" + ((Object) Color.m1494toStringimpl(m670getSecondaryVariant0d7_KjU())) + ", background=" + ((Object) Color.m1494toStringimpl(m660getBackground0d7_KjU())) + ", surface=" + ((Object) Color.m1494toStringimpl(m671getSurface0d7_KjU())) + ", error=" + ((Object) Color.m1494toStringimpl(m661getError0d7_KjU())) + ", onPrimary=" + ((Object) Color.m1494toStringimpl(m664getOnPrimary0d7_KjU())) + ", onSecondary=" + ((Object) Color.m1494toStringimpl(m665getOnSecondary0d7_KjU())) + ", onBackground=" + ((Object) Color.m1494toStringimpl(m662getOnBackground0d7_KjU())) + ", onSurface=" + ((Object) Color.m1494toStringimpl(m666getOnSurface0d7_KjU())) + ", onError=" + ((Object) Color.m1494toStringimpl(m663getOnError0d7_KjU())) + ", isLight=" + isLight() + ')';
    }

    private Colors(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z5) {
        this.primary = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.background = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.surface = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.error = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j13), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j14), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j15), SnapshotStateKt.structuralEqualityPolicy());
        this.onError = SnapshotStateKt.mutableStateOf(Color.m1481boximpl(j16), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z5), SnapshotStateKt.structuralEqualityPolicy());
    }
}
