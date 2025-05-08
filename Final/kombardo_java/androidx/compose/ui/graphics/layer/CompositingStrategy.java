package androidx.compose.ui.graphics.layer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/layer/CompositingStrategy;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CompositingStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Auto = m1710constructorimpl(0);
    private static final int Offscreen = m1710constructorimpl(1);
    private static final int ModulateAlpha = m1710constructorimpl(2);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/graphics/layer/CompositingStrategy$Companion;", BuildConfig.FLAVOR, "()V", "Auto", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getAuto-ke2Ky5w", "()I", "I", "ModulateAlpha", "getModulateAlpha-ke2Ky5w", "Offscreen", "getOffscreen-ke2Ky5w", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAuto-ke2Ky5w, reason: not valid java name */
        public final int m1712getAutoke2Ky5w() {
            return CompositingStrategy.Auto;
        }

        /* renamed from: getModulateAlpha-ke2Ky5w, reason: not valid java name */
        public final int m1713getModulateAlphake2Ky5w() {
            return CompositingStrategy.ModulateAlpha;
        }

        /* renamed from: getOffscreen-ke2Ky5w, reason: not valid java name */
        public final int m1714getOffscreenke2Ky5w() {
            return CompositingStrategy.Offscreen;
        }

        private Companion() {
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1710constructorimpl(int i5) {
        return i5;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1711equalsimpl0(int i5, int i6) {
        return i5 == i6;
    }
}
