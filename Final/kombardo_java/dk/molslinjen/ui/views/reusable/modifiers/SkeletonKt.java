package dk.molslinjen.ui.views.reusable.modifiers;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.google.accompanist.placeholder.PlaceholderHighlight;
import com.google.accompanist.placeholder.PlaceholderHighlightKt;
import com.google.accompanist.placeholder.PlaceholderKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\b\u0006\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"skeleton", "Landroidx/compose/ui/Modifier;", "visible", BuildConfig.FLAVOR, "color", "Landroidx/compose/ui/graphics/Color;", "skeleton-t9lfQc4", "LocalSkeletonColor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalSkeletonColor", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalSkeletonHighlightColor", "getLocalSkeletonHighlightColor", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SkeletonKt {
    private static final ProvidableCompositionLocal<Color> LocalSkeletonColor = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Color>() { // from class: dk.molslinjen.ui.views.reusable.modifiers.SkeletonKt$LocalSkeletonColor$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Color invoke() {
            return Color.m1481boximpl(m3426invoke0d7_KjU());
        }

        /* renamed from: invoke-0d7_KjU, reason: not valid java name */
        public final long m3426invoke0d7_KjU() {
            return AppColor.INSTANCE.m3268getGrey50d7_KjU();
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<Color> LocalSkeletonHighlightColor = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Color>() { // from class: dk.molslinjen.ui.views.reusable.modifiers.SkeletonKt$LocalSkeletonHighlightColor$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Color invoke() {
            return Color.m1481boximpl(m3427invoke0d7_KjU());
        }

        /* renamed from: invoke-0d7_KjU, reason: not valid java name */
        public final long m3427invoke0d7_KjU() {
            return AppColor.INSTANCE.m3269getGrey60d7_KjU();
        }
    }, 1, null);

    public static final ProvidableCompositionLocal<Color> getLocalSkeletonColor() {
        return LocalSkeletonColor;
    }

    public static final ProvidableCompositionLocal<Color> getLocalSkeletonHighlightColor() {
        return LocalSkeletonHighlightColor;
    }

    /* renamed from: skeleton-t9lfQc4, reason: not valid java name */
    public static final Modifier m3424skeletont9lfQc4(Modifier skeleton, final boolean z5, final Color color) {
        Intrinsics.checkNotNullParameter(skeleton, "$this$skeleton");
        return ComposedModifierKt.composed$default(skeleton, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: dk.molslinjen.ui.views.reusable.modifiers.SkeletonKt$skeleton$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i5) {
                long value;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceGroup(-344570362);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-344570362, i5, -1, "dk.molslinjen.ui.views.reusable.modifiers.skeleton.<anonymous> (Skeleton.kt:13)");
                }
                Color color2 = Color.this;
                composer.startReplaceGroup(-1354840090);
                if (color2 == null) {
                    value = ((Color) composer.consume(SkeletonKt.getLocalSkeletonColor())).getValue();
                } else {
                    value = color2.getValue();
                }
                long j5 = value;
                composer.endReplaceGroup();
                PlaceholderHighlight m2908fadebw27NRU$default = PlaceholderHighlightKt.m2908fadebw27NRU$default(PlaceholderHighlight.INSTANCE, ((Color) composer.consume(SkeletonKt.getLocalSkeletonHighlightColor())).getValue(), null, 2, null);
                Modifier m2912placeholdercf5BqRc$default = PlaceholderKt.m2912placeholdercf5BqRc$default(composed, z5, j5, ThemeShapesKt.getThemeShapes().getMedium(), m2908fadebw27NRU$default, null, null, 48, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m2912placeholdercf5BqRc$default;
            }
        }, 1, null);
    }

    /* renamed from: skeleton-t9lfQc4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3425skeletont9lfQc4$default(Modifier modifier, boolean z5, Color color, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            color = null;
        }
        return m3424skeletont9lfQc4(modifier, z5, color);
    }
}
