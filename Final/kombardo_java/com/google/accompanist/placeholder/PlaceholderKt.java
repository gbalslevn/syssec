package com.google.accompanist.placeholder;

import android.support.v4.media.session.a;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0080\u0001\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072 \b\u0002\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t2 \b\u0002\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aX\u0010\u001c\u001a\u0004\u0018\u00010\u0014*\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 ²\u0006\u000e\u0010\u001d\u001a\u00020\f8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001e\u001a\u00020\f8\nX\u008a\u0084\u0002²\u0006\f\u0010\u001f\u001a\u00020\f8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "visible", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/graphics/Shape;", "shape", "Lcom/google/accompanist/placeholder/PlaceholderHighlight;", "highlight", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", BuildConfig.FLAVOR, "placeholderFadeTransitionSpec", "contentFadeTransitionSpec", "placeholder-cf5BqRc", "(Landroidx/compose/ui/Modifier;ZJLandroidx/compose/ui/graphics/Shape;Lcom/google/accompanist/placeholder/PlaceholderHighlight;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "placeholder", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "progress", "Landroidx/compose/ui/graphics/Outline;", "lastOutline", "Landroidx/compose/ui/unit/LayoutDirection;", "lastLayoutDirection", "Landroidx/compose/ui/geometry/Size;", "lastSize", "drawPlaceholder-hpmOzss", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Shape;JLcom/google/accompanist/placeholder/PlaceholderHighlight;FLandroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Size;)Landroidx/compose/ui/graphics/Outline;", "drawPlaceholder", "highlightProgress", "placeholderAlpha", "contentAlpha", "placeholder_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PlaceholderKt {
    /* renamed from: access$drawPlaceholder-hpmOzss */
    public static final /* synthetic */ Outline m2909access$drawPlaceholderhpmOzss(DrawScope drawScope, Shape shape, long j5, PlaceholderHighlight placeholderHighlight, float f5, Outline outline, LayoutDirection layoutDirection, Size size) {
        return m2910drawPlaceholderhpmOzss(drawScope, shape, j5, placeholderHighlight, f5, outline, layoutDirection, size);
    }

    /* renamed from: drawPlaceholder-hpmOzss */
    public static final Outline m2910drawPlaceholderhpmOzss(DrawScope drawScope, Shape shape, long j5, PlaceholderHighlight placeholderHighlight, float f5, Outline outline, LayoutDirection layoutDirection, Size size) {
        Outline outline2 = null;
        if (shape == RectangleShapeKt.getRectangleShape()) {
            DrawScope.m1698drawRectnJ9OG0$default(drawScope, j5, 0L, 0L, 0.0f, null, null, 0, 126, null);
            if (placeholderHighlight != null) {
                DrawScope.m1697drawRectAsUm42w$default(drawScope, placeholderHighlight.mo2906brushd16Qtg0(f5, drawScope.mo1703getSizeNHjbRc()), 0L, 0L, placeholderHighlight.alpha(f5), null, null, 0, 118, null);
            }
            return null;
        }
        if (Size.m1373equalsimpl(drawScope.mo1703getSizeNHjbRc(), size) && drawScope.getLayoutDirection() == layoutDirection) {
            outline2 = outline;
        }
        if (outline2 == null) {
            outline2 = shape.mo131createOutlinePq9zytI(drawScope.mo1703getSizeNHjbRc(), drawScope.getLayoutDirection(), drawScope);
        }
        OutlineKt.m1568drawOutlinewDX37Ww(drawScope, outline2, j5, (r17 & 4) != 0 ? 1.0f : 0.0f, (r17 & 8) != 0 ? Fill.INSTANCE : null, (r17 & 16) != 0 ? null : null, (r17 & 32) != 0 ? DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU() : 0);
        if (placeholderHighlight != null) {
            OutlineKt.m1567drawOutlinehn5TExg$default(drawScope, outline2, placeholderHighlight.mo2906brushd16Qtg0(f5, drawScope.mo1703getSizeNHjbRc()), placeholderHighlight.alpha(f5), null, null, 0, 56, null);
        }
        return outline2;
    }

    @Deprecated
    /* renamed from: placeholder-cf5BqRc */
    public static final Modifier m2911placeholdercf5BqRc(Modifier placeholder, final boolean z5, final long j5, final Shape shape, final PlaceholderHighlight placeholderHighlight, Function3<? super Transition.Segment<Boolean>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> placeholderFadeTransitionSpec, Function3<? super Transition.Segment<Boolean>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> contentFadeTransitionSpec) {
        Intrinsics.checkNotNullParameter(placeholder, "$this$placeholder");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(placeholderFadeTransitionSpec, "placeholderFadeTransitionSpec");
        Intrinsics.checkNotNullParameter(contentFadeTransitionSpec, "contentFadeTransitionSpec");
        return ComposedModifierKt.composed(placeholder, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: com.google.accompanist.placeholder.PlaceholderKt$placeholder-cf5BqRc$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), new PlaceholderKt$placeholder$4(placeholderFadeTransitionSpec, contentFadeTransitionSpec, placeholderHighlight, z5, j5, shape));
    }

    /* renamed from: placeholder-cf5BqRc$default */
    public static /* synthetic */ Modifier m2912placeholdercf5BqRc$default(Modifier modifier, boolean z5, long j5, Shape shape, PlaceholderHighlight placeholderHighlight, Function3 function3, Function3 function32, int i5, Object obj) {
        return m2911placeholdercf5BqRc(modifier, z5, j5, (i5 & 4) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i5 & 8) != 0 ? null : placeholderHighlight, (i5 & 16) != 0 ? new Function3<Transition.Segment<Boolean>, Composer, Integer, SpringSpec<Float>>() { // from class: com.google.accompanist.placeholder.PlaceholderKt$placeholder$1
            public final SpringSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, int i6) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                composer.startReplaceableGroup(87515116);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(87515116, i6, -1, "com.google.accompanist.placeholder.placeholder.<anonymous> (Placeholder.kt:124)");
                }
                SpringSpec<Float> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return spring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                return invoke(segment, composer, num.intValue());
            }
        } : function3, (i5 & 32) != 0 ? new Function3<Transition.Segment<Boolean>, Composer, Integer, SpringSpec<Float>>() { // from class: com.google.accompanist.placeholder.PlaceholderKt$placeholder$2
            public final SpringSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, int i6) {
                Intrinsics.checkNotNullParameter(segment, "$this$null");
                composer.startReplaceableGroup(-439090190);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-439090190, i6, -1, "com.google.accompanist.placeholder.placeholder.<anonymous> (Placeholder.kt:125)");
                }
                SpringSpec<Float> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return spring$default;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, Integer num) {
                return invoke(segment, composer, num.intValue());
            }
        } : function32);
    }
}
