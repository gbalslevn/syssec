package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextInclusionStrategy;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/TextInclusionStrategy;", BuildConfig.FLAVOR, "isIncluded", BuildConfig.FLAVOR, "textBounds", "Landroidx/compose/ui/geometry/Rect;", "rect", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface TextInclusionStrategy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/TextInclusionStrategy$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/TextInclusionStrategy;", "AnyOverlap", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getAnyOverlap", "()Landroidx/compose/ui/text/TextInclusionStrategy;", "ContainsAll", "getContainsAll", "ContainsCenter", "getContainsCenter", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final TextInclusionStrategy AnyOverlap = new TextInclusionStrategy() { // from class: s.a
            @Override // androidx.compose.ui.text.TextInclusionStrategy
            public final boolean isIncluded(Rect rect, Rect rect2) {
                boolean overlaps;
                overlaps = rect.overlaps(rect2);
                return overlaps;
            }
        };
        private static final TextInclusionStrategy ContainsAll = new TextInclusionStrategy() { // from class: s.b
            @Override // androidx.compose.ui.text.TextInclusionStrategy
            public final boolean isIncluded(Rect rect, Rect rect2) {
                boolean ContainsAll$lambda$1;
                ContainsAll$lambda$1 = TextInclusionStrategy.Companion.ContainsAll$lambda$1(rect, rect2);
                return ContainsAll$lambda$1;
            }
        };
        private static final TextInclusionStrategy ContainsCenter = new TextInclusionStrategy() { // from class: s.c
            @Override // androidx.compose.ui.text.TextInclusionStrategy
            public final boolean isIncluded(Rect rect, Rect rect2) {
                boolean ContainsCenter$lambda$2;
                ContainsCenter$lambda$2 = TextInclusionStrategy.Companion.ContainsCenter$lambda$2(rect, rect2);
                return ContainsCenter$lambda$2;
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean ContainsAll$lambda$1(Rect rect, Rect rect2) {
            return !rect2.isEmpty() && rect.getLeft() >= rect2.getLeft() && rect.getRight() <= rect2.getRight() && rect.getTop() >= rect2.getTop() && rect.getBottom() <= rect2.getBottom();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean ContainsCenter$lambda$2(Rect rect, Rect rect2) {
            return rect2.m1354containsk4lQ0M(rect.m1356getCenterF1C5BW0());
        }

        public final TextInclusionStrategy getAnyOverlap() {
            return AnyOverlap;
        }

        public final TextInclusionStrategy getContainsCenter() {
            return ContainsCenter;
        }
    }

    boolean isIncluded(Rect textBounds, Rect rect);
}
