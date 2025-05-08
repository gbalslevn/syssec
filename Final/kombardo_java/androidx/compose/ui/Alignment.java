package androidx.compose.ui;

import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bç\u0080\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\f\rJ*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment;", BuildConfig.FLAVOR, "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "Companion", "Horizontal", "Vertical", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Alignment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\u000b\u0010\bR \u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u000e\u0010\bR \u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\bR \u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\bR \u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\bR \u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001a\u0010\bR \u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001c\u0010\u0006\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001d\u0010\bR \u0010\u001f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u0012\u0004\b!\u0010\u0003\u001a\u0004\b \u0010\bR \u0010#\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b#\u0010$\u0012\u0004\b'\u0010\u0003\u001a\u0004\b%\u0010&R \u0010(\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b(\u0010$\u0012\u0004\b*\u0010\u0003\u001a\u0004\b)\u0010&R \u0010+\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b+\u0010$\u0012\u0004\b-\u0010\u0003\u001a\u0004\b,\u0010&R \u0010/\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b/\u00100\u0012\u0004\b3\u0010\u0003\u001a\u0004\b1\u00102R \u00104\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b4\u00100\u0012\u0004\b6\u0010\u0003\u001a\u0004\b5\u00102R \u00107\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b7\u00100\u0012\u0004\b9\u0010\u0003\u001a\u0004\b8\u00102¨\u0006:"}, d2 = {"Landroidx/compose/ui/Alignment$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/Alignment;", "TopStart", "Landroidx/compose/ui/Alignment;", "getTopStart", "()Landroidx/compose/ui/Alignment;", "getTopStart$annotations", "TopCenter", "getTopCenter", "getTopCenter$annotations", "TopEnd", "getTopEnd", "getTopEnd$annotations", "CenterStart", "getCenterStart", "getCenterStart$annotations", "Center", "getCenter", "getCenter$annotations", "CenterEnd", "getCenterEnd", "getCenterEnd$annotations", "BottomStart", "getBottomStart", "getBottomStart$annotations", "BottomCenter", "getBottomCenter", "getBottomCenter$annotations", "BottomEnd", "getBottomEnd", "getBottomEnd$annotations", "Landroidx/compose/ui/Alignment$Vertical;", "Top", "Landroidx/compose/ui/Alignment$Vertical;", "getTop", "()Landroidx/compose/ui/Alignment$Vertical;", "getTop$annotations", "CenterVertically", "getCenterVertically", "getCenterVertically$annotations", "Bottom", "getBottom", "getBottom$annotations", "Landroidx/compose/ui/Alignment$Horizontal;", "Start", "Landroidx/compose/ui/Alignment$Horizontal;", "getStart", "()Landroidx/compose/ui/Alignment$Horizontal;", "getStart$annotations", "CenterHorizontally", "getCenterHorizontally", "getCenterHorizontally$annotations", "End", "getEnd", "getEnd$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Alignment TopStart = new BiasAlignment(-1.0f, -1.0f);
        private static final Alignment TopCenter = new BiasAlignment(0.0f, -1.0f);
        private static final Alignment TopEnd = new BiasAlignment(1.0f, -1.0f);
        private static final Alignment CenterStart = new BiasAlignment(-1.0f, 0.0f);
        private static final Alignment Center = new BiasAlignment(0.0f, 0.0f);
        private static final Alignment CenterEnd = new BiasAlignment(1.0f, 0.0f);
        private static final Alignment BottomStart = new BiasAlignment(-1.0f, 1.0f);
        private static final Alignment BottomCenter = new BiasAlignment(0.0f, 1.0f);
        private static final Alignment BottomEnd = new BiasAlignment(1.0f, 1.0f);
        private static final Vertical Top = new BiasAlignment.Vertical(-1.0f);
        private static final Vertical CenterVertically = new BiasAlignment.Vertical(0.0f);
        private static final Vertical Bottom = new BiasAlignment.Vertical(1.0f);
        private static final Horizontal Start = new BiasAlignment.Horizontal(-1.0f);
        private static final Horizontal CenterHorizontally = new BiasAlignment.Horizontal(0.0f);
        private static final Horizontal End = new BiasAlignment.Horizontal(1.0f);

        private Companion() {
        }

        public final Vertical getBottom() {
            return Bottom;
        }

        public final Alignment getBottomCenter() {
            return BottomCenter;
        }

        public final Alignment getBottomEnd() {
            return BottomEnd;
        }

        public final Alignment getBottomStart() {
            return BottomStart;
        }

        public final Alignment getCenter() {
            return Center;
        }

        public final Alignment getCenterEnd() {
            return CenterEnd;
        }

        public final Horizontal getCenterHorizontally() {
            return CenterHorizontally;
        }

        public final Alignment getCenterStart() {
            return CenterStart;
        }

        public final Vertical getCenterVertically() {
            return CenterVertically;
        }

        public final Horizontal getEnd() {
            return End;
        }

        public final Horizontal getStart() {
            return Start;
        }

        public final Vertical getTop() {
            return Top;
        }

        public final Alignment getTopCenter() {
            return TopCenter;
        }

        public final Alignment getTopEnd() {
            return TopEnd;
        }

        public final Alignment getTopStart() {
            return TopStart;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment$Horizontal;", BuildConfig.FLAVOR, "align", BuildConfig.FLAVOR, "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Horizontal {
        int align(int size, int space, LayoutDirection layoutDirection);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/Alignment$Vertical;", BuildConfig.FLAVOR, "align", BuildConfig.FLAVOR, "size", "space", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Vertical {
        int align(int size, int space);
    }

    /* renamed from: align-KFBX0sM, reason: not valid java name */
    long mo1251alignKFBX0sM(long size, long space, LayoutDirection layoutDirection);
}
