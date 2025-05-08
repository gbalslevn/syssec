package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NestedScrollSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Drag;
    private static final int Fling;
    private static final int Relocate;
    private static final int SideEffect;
    private static final int UserInput;
    private static final int Wheel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "UserInput", "I", "getUserInput-WNlRxjI", "()I", "SideEffect", "getSideEffect-WNlRxjI", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getSideEffect-WNlRxjI, reason: not valid java name */
        public final int m1841getSideEffectWNlRxjI() {
            return NestedScrollSource.SideEffect;
        }

        /* renamed from: getUserInput-WNlRxjI, reason: not valid java name */
        public final int m1842getUserInputWNlRxjI() {
            return NestedScrollSource.UserInput;
        }

        private Companion() {
        }
    }

    static {
        int m1839constructorimpl = m1839constructorimpl(1);
        UserInput = m1839constructorimpl;
        int m1839constructorimpl2 = m1839constructorimpl(2);
        SideEffect = m1839constructorimpl2;
        Drag = m1839constructorimpl;
        Fling = m1839constructorimpl2;
        Relocate = m1839constructorimpl(3);
        Wheel = m1839constructorimpl;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1839constructorimpl(int i5) {
        return i5;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1840equalsimpl0(int i5, int i6) {
        return i5 == i6;
    }
}
