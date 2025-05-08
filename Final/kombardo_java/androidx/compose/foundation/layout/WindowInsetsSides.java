package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(I)I", "sides", "plus-gK_yJZ4", "(II)I", "plus", BuildConfig.FLAVOR, "hasAny-bkgdKaI$foundation_layout_release", "(II)Z", "hasAny", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "toString", "valueToString-impl", "valueToString", "hashCode-impl", "hashCode", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WindowInsetsSides {
    private static final int AllowLeftInLtr;
    private static final int AllowLeftInRtl;
    private static final int AllowRightInLtr;
    private static final int AllowRightInRtl;
    private static final int Bottom;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int End;
    private static final int Horizontal;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Top;
    private static final int Vertical;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u00020\u00048\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR \u0010\u000b\u001a\u00020\u00048\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR \u0010\r\u001a\u00020\u00048\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u000f\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u001d\u0010\u0011\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u001d\u0010\u0013\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "AllowLeftInLtr", "I", "getAllowLeftInLtr-JoeWqyM$foundation_layout_release", "()I", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout_release", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout_release", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout_release", "Top", "getTop-JoeWqyM", "Bottom", "getBottom-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m356getAllowLeftInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        /* renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m357getAllowLeftInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        /* renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m358getAllowRightInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        /* renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m359getAllowRightInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        /* renamed from: getBottom-JoeWqyM, reason: not valid java name */
        public final int m360getBottomJoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        /* renamed from: getHorizontal-JoeWqyM, reason: not valid java name */
        public final int m361getHorizontalJoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }

        /* renamed from: getTop-JoeWqyM, reason: not valid java name */
        public final int m362getTopJoeWqyM() {
            return WindowInsetsSides.Top;
        }

        private Companion() {
        }
    }

    static {
        int m349constructorimpl = m349constructorimpl(8);
        AllowLeftInLtr = m349constructorimpl;
        int m349constructorimpl2 = m349constructorimpl(4);
        AllowRightInLtr = m349constructorimpl2;
        int m349constructorimpl3 = m349constructorimpl(2);
        AllowLeftInRtl = m349constructorimpl3;
        int m349constructorimpl4 = m349constructorimpl(1);
        AllowRightInRtl = m349constructorimpl4;
        Start = m353plusgK_yJZ4(m349constructorimpl, m349constructorimpl4);
        End = m353plusgK_yJZ4(m349constructorimpl2, m349constructorimpl3);
        int m349constructorimpl5 = m349constructorimpl(16);
        Top = m349constructorimpl5;
        int m349constructorimpl6 = m349constructorimpl(32);
        Bottom = m349constructorimpl6;
        int m353plusgK_yJZ4 = m353plusgK_yJZ4(m349constructorimpl, m349constructorimpl3);
        Left = m353plusgK_yJZ4;
        int m353plusgK_yJZ42 = m353plusgK_yJZ4(m349constructorimpl2, m349constructorimpl4);
        Right = m353plusgK_yJZ42;
        Horizontal = m353plusgK_yJZ4(m353plusgK_yJZ4, m353plusgK_yJZ42);
        Vertical = m353plusgK_yJZ4(m349constructorimpl5, m349constructorimpl6);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m349constructorimpl(int i5) {
        return i5;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m350equalsimpl0(int i5, int i6) {
        return i5 == i6;
    }

    /* renamed from: hasAny-bkgdKaI$foundation_layout_release, reason: not valid java name */
    public static final boolean m351hasAnybkgdKaI$foundation_layout_release(int i5, int i6) {
        return (i5 & i6) != 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m352hashCodeimpl(int i5) {
        return Integer.hashCode(i5);
    }

    /* renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m353plusgK_yJZ4(int i5, int i6) {
        return m349constructorimpl(i5 | i6);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m354toStringimpl(int i5) {
        return "WindowInsetsSides(" + m355valueToStringimpl(i5) + ')';
    }

    /* renamed from: valueToString-impl, reason: not valid java name */
    private static final String m355valueToStringimpl(int i5) {
        StringBuilder sb = new StringBuilder();
        int i6 = Start;
        if ((i5 & i6) == i6) {
            valueToString_impl$lambda$0$appendPlus(sb, "Start");
        }
        int i7 = Left;
        if ((i5 & i7) == i7) {
            valueToString_impl$lambda$0$appendPlus(sb, "Left");
        }
        int i8 = Top;
        if ((i5 & i8) == i8) {
            valueToString_impl$lambda$0$appendPlus(sb, "Top");
        }
        int i9 = End;
        if ((i5 & i9) == i9) {
            valueToString_impl$lambda$0$appendPlus(sb, "End");
        }
        int i10 = Right;
        if ((i5 & i10) == i10) {
            valueToString_impl$lambda$0$appendPlus(sb, "Right");
        }
        int i11 = Bottom;
        if ((i5 & i11) == i11) {
            valueToString_impl$lambda$0$appendPlus(sb, "Bottom");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }
}
