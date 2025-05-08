package dk.molslinjen.ui.views.reusable;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a9\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/unit/Dp;", "thickness", "strokeInterval", BuildConfig.FLAVOR, "VerticalDivider-tZIQpXc", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/ui/unit/Dp;Landroidx/compose/runtime/Composer;II)V", "VerticalDivider", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class VerticalDividerKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0051  */
    /* renamed from: VerticalDivider-tZIQpXc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3394VerticalDividertZIQpXc(Modifier modifier, long j5, float f5, Dp dp, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        long j6;
        int i8;
        float f6;
        int i9;
        Dp dp2;
        final Float valueOf;
        final Modifier modifier3;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-836163525);
        int i10 = i6 & 1;
        if (i10 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            j6 = j5;
            i7 |= startRestartGroup.changed(j6) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                f6 = f5;
                i7 |= startRestartGroup.changed(f6) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    dp2 = dp;
                    i7 |= startRestartGroup.changed(dp2) ? 2048 : 1024;
                    if ((i7 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        final long m3268getGrey50d7_KjU = i11 == 0 ? AppColor.INSTANCE.m3268getGrey50d7_KjU() : j6;
                        if (i8 != 0) {
                            f6 = Dp.m2599constructorimpl(1);
                        }
                        if (i9 != 0) {
                            dp2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-836163525, i7, -1, "dk.molslinjen.ui.views.reusable.VerticalDivider (VerticalDivider.kt:27)");
                        }
                        startRestartGroup.startReplaceGroup(-967442842);
                        valueOf = dp2 != null ? null : Float.valueOf(ComposeExtensionsKt.m3250dpToPx8Feqmps(dp2.getValue(), startRestartGroup, (i7 >> 9) & 14));
                        startRestartGroup.endReplaceGroup();
                        if (valueOf == null) {
                            startRestartGroup.startReplaceGroup(74113931);
                            final float m3250dpToPx8Feqmps = ComposeExtensionsKt.m3250dpToPx8Feqmps(f6, startRestartGroup, (i7 >> 6) & 14);
                            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m336width3ABfNKs(modifier2, f6), 0.0f, 1, null);
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            startRestartGroup.startReplaceGroup(-485994125);
                            boolean changed = startRestartGroup.changed(valueOf) | ((i7 & 112) == 32) | startRestartGroup.changed(m3250dpToPx8Feqmps);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1() { // from class: W1.G
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit VerticalDivider_tZIQpXc$lambda$2$lambda$1$lambda$0;
                                        VerticalDivider_tZIQpXc$lambda$2$lambda$1$lambda$0 = VerticalDividerKt.VerticalDivider_tZIQpXc$lambda$2$lambda$1$lambda$0(valueOf, m3268getGrey50d7_KjU, m3250dpToPx8Feqmps, (DrawScope) obj);
                                        return VerticalDivider_tZIQpXc$lambda$2$lambda$1$lambda$0;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue, startRestartGroup, 6);
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(74979575);
                            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.m336width3ABfNKs(modifier2, f6), 0.0f, 1, null), m3268getGrey50d7_KjU, null, 2, null), startRestartGroup, 0);
                            startRestartGroup.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        j7 = m3268getGrey50d7_KjU;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        j7 = j6;
                    }
                    final Dp dp3 = dp2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final float f7 = f6;
                        endRestartGroup.updateScope(new Function2() { // from class: W1.H
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit VerticalDivider_tZIQpXc$lambda$3;
                                VerticalDivider_tZIQpXc$lambda$3 = VerticalDividerKt.VerticalDivider_tZIQpXc$lambda$3(Modifier.this, j7, f7, dp3, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return VerticalDivider_tZIQpXc$lambda$3;
                            }
                        });
                        return;
                    }
                    return;
                }
                dp2 = dp;
                if ((i7 & 1171) == 1170) {
                }
                if (i10 != 0) {
                }
                if (i11 == 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-967442842);
                if (dp2 != null) {
                }
                startRestartGroup.endReplaceGroup();
                if (valueOf == null) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                j7 = m3268getGrey50d7_KjU;
                final Dp dp32 = dp2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f6 = f5;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            dp2 = dp;
            if ((i7 & 1171) == 1170) {
            }
            if (i10 != 0) {
            }
            if (i11 == 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-967442842);
            if (dp2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            if (valueOf == null) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            j7 = m3268getGrey50d7_KjU;
            final Dp dp322 = dp2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        j6 = j5;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        f6 = f5;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        dp2 = dp;
        if ((i7 & 1171) == 1170) {
        }
        if (i10 != 0) {
        }
        if (i11 == 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-967442842);
        if (dp2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        if (valueOf == null) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        j7 = m3268getGrey50d7_KjU;
        final Dp dp3222 = dp2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDivider_tZIQpXc$lambda$2$lambda$1$lambda$0(Float f5, long j5, float f6, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        DrawScope.m1694drawLineNGM6Ib0$default(Canvas, j5, OffsetKt.Offset(Size.m1377getWidthimpl(Canvas.mo1703getSizeNHjbRc()), 0.0f), OffsetKt.Offset(0.0f, Size.m1375getHeightimpl(Canvas.mo1703getSizeNHjbRc())), f6, StrokeCap.INSTANCE.m1607getButtKaPHkGw(), PathEffect.Companion.dashPathEffect$default(PathEffect.INSTANCE, new float[]{f5.floatValue(), f5.floatValue()}, 0.0f, 2, null), 0.0f, null, 0, 448, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDivider_tZIQpXc$lambda$3(Modifier modifier, long j5, float f5, Dp dp, int i5, int i6, Composer composer, int i7) {
        m3394VerticalDividertZIQpXc(modifier, j5, f5, dp, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
