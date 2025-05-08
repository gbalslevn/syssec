package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u0081\u0001\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u000f\u0010\u0013\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "focused", "showDetails", "isEmpty", "Lkotlin/Function0;", BuildConfig.FLAVOR, "addProducts", "Landroidx/compose/ui/unit/Dp;", "simpleTopPadding", "detailedTopPadding", "showEditButton", "boldTitle", "simpleContent", "detailedContent", "SectionContainer-vCe147k", "(Ljava/lang/String;ZZZLkotlin/jvm/functions/Function0;FFZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SectionContainer", "DashedBorder", "(Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SectionContainerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void DashedBorder(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(780154070);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(780154070, i5, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.DashedBorder (SectionContainer.kt:127)");
            }
            float dpToPx = ComposeExtensionsKt.dpToPx(4, startRestartGroup, 6);
            final float dpToPx2 = ComposeExtensionsKt.dpToPx(8, startRestartGroup, 6);
            final Stroke stroke = new Stroke(ComposeExtensionsKt.dpToPx(2, startRestartGroup, 6), 0.0f, StrokeCap.INSTANCE.m1608getRoundKaPHkGw(), 0, PathEffect.Companion.dashPathEffect$default(PathEffect.INSTANCE, new float[]{dpToPx, dpToPx}, 0.0f, 2, null), 10, null);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-525204679);
            boolean changed = startRestartGroup.changed(dpToPx2) | startRestartGroup.changedInstance(stroke);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: C4.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DashedBorder$lambda$2$lambda$1;
                        DashedBorder$lambda$2$lambda$1 = SectionContainerKt.DashedBorder$lambda$2$lambda$1(dpToPx2, stroke, (DrawScope) obj);
                        return DashedBorder$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C4.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DashedBorder$lambda$3;
                    DashedBorder$lambda$3 = SectionContainerKt.DashedBorder$lambda$3(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DashedBorder$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DashedBorder$lambda$2$lambda$1(float f5, Stroke stroke, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        DrawScope.m1700drawRoundRectuAw5IA$default(Canvas, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, 0L, CornerRadiusKt.CornerRadius(f5, f5), stroke, 0.0f, null, 0, 230, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DashedBorder$lambda$3(int i5, Composer composer, int i6) {
        DashedBorder(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e7  */
    /* renamed from: SectionContainer-vCe147k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3561SectionContainervCe147k(final String title, final boolean z5, final boolean z6, final boolean z7, Function0<Unit> function0, final float f5, final float f6, boolean z8, boolean z9, final Function2<? super Composer, ? super Integer, Unit> simpleContent, final Function2<? super Composer, ? super Integer, Unit> detailedContent, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final Function0<Unit> function02;
        final boolean z10;
        final boolean z11;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(simpleContent, "simpleContent");
        Intrinsics.checkNotNullParameter(detailedContent, "detailedContent");
        Composer startRestartGroup = composer.startRestartGroup(-224342962);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = (startRestartGroup.changed(title) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i5 & 384) == 0) {
            i8 |= startRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i8 |= startRestartGroup.changed(z7) ? 2048 : 1024;
        }
        int i13 = i7 & 16;
        if (i13 != 0) {
            i8 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
            if ((i7 & 32) == 0) {
                i8 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i8 |= startRestartGroup.changed(f5) ? 131072 : 65536;
            }
            if ((i7 & 64) == 0) {
                i8 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i8 |= startRestartGroup.changed(f6) ? 1048576 : 524288;
            }
            i9 = i7 & 128;
            if (i9 == 0) {
                i8 |= 12582912;
            } else if ((i5 & 12582912) == 0) {
                i8 |= startRestartGroup.changed(z8) ? 8388608 : 4194304;
            }
            i10 = i7 & 256;
            if (i10 == 0) {
                i8 |= 100663296;
            } else if ((i5 & 100663296) == 0) {
                i8 |= startRestartGroup.changed(z9) ? 67108864 : 33554432;
            }
            if ((i7 & 512) == 0) {
                i8 |= 805306368;
            } else if ((i5 & 805306368) == 0) {
                i8 |= startRestartGroup.changedInstance(simpleContent) ? 536870912 : 268435456;
            }
            i11 = i8;
            if ((i7 & 1024) == 0) {
                i12 = i6 | 6;
            } else if ((i6 & 6) == 0) {
                i12 = i6 | (startRestartGroup.changedInstance(detailedContent) ? 4 : 2);
            } else {
                i12 = i6;
            }
            if ((i11 & 306783379) != 306783378 && (i12 & 3) == 2 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                function02 = function0;
                z10 = z8;
                z11 = z9;
                composer2 = startRestartGroup;
            } else {
                Function0<Unit> function03 = i13 == 0 ? null : function0;
                boolean z12 = i9 == 0 ? false : z8;
                boolean z13 = i10 == 0 ? false : z9;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-224342962, i11, i12, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainer (SectionContainer.kt:43)");
                }
                final boolean z14 = z12;
                final boolean z15 = z13;
                final Function0<Unit> function04 = function03;
                composer2 = startRestartGroup;
                AnimatedVisibilityKt.AnimatedVisibility(z6, null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), null, ComposableLambdaKt.rememberComposableLambda(-466281354, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainerKt$SectionContainer$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                        invoke(animatedVisibilityScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i14) {
                        Composer composer4;
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-466281354, i14, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainer.<anonymous> (SectionContainer.kt:49)");
                        }
                        float f7 = f6;
                        boolean z16 = z14;
                        boolean z17 = z15;
                        String str = title;
                        boolean z18 = z5;
                        Function0<Unit> function05 = function04;
                        boolean z19 = z7;
                        Function2<Composer, Integer, Unit> function2 = detailedContent;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Arrangement arrangement = Arrangement.INSTANCE;
                        Arrangement.Vertical top = arrangement.getTop();
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer3, 0);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, f7), composer3, 0);
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer3, 48);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, companion);
                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer3);
                        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                        Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
                        TextStyle paragraphBold = z17 ? TypographyKt.getParagraphBold() : TypographyKt.getParagraphSmall();
                        TextAlign.Companion companion4 = TextAlign.INSTANCE;
                        TextKt.m940Text4IGK_g(str, weight$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, composer3, 0, 0, 65020);
                        composer3.startReplaceGroup(-787452542);
                        if (z18) {
                            composer4 = composer3;
                            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketSummary_focusedSection, composer3, 6), null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 384, 1572864, 65018);
                        } else {
                            composer4 = composer3;
                        }
                        composer3.endReplaceGroup();
                        composer4.startReplaceGroup(-787441636);
                        if (z16 && function05 != null) {
                            IconButtonKt.IconButton(function05, null, false, null, null, ComposableSingletons$SectionContainerKt.INSTANCE.m3558getLambda1$app_kombardoProd(), composer3, 196608, 30);
                        }
                        composer3.endReplaceGroup();
                        composer3.endNode();
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(z16 ? 8 : 16)), composer4, 0);
                        Modifier height = IntrinsicKt.height(companion, IntrinsicSize.Min);
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, height);
                        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer4.createNode(constructor3);
                        } else {
                            composer3.useNode();
                        }
                        Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer3);
                        Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        if (z19 && function05 != null) {
                            composer4.startReplaceGroup(1359823303);
                            OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(BackgroundKt.m104backgroundbw27NRU$default(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), StringResources_androidKt.stringResource(R.string.ticketSummary_section_add, new Object[]{StringExtensionsKt.lowercaseFirstLetter(str)}, composer4, 6), R.drawable.icon_plus_circled, 0L, 0L, 0L, function05, composer3, 390, 56);
                            composer3.endReplaceGroup();
                        } else {
                            composer4.startReplaceGroup(1360218956);
                            composer4.startReplaceGroup(-787406129);
                            if (z18) {
                                SectionContainerKt.DashedBorder(composer4, 0);
                            }
                            composer3.endReplaceGroup();
                            AppColor appColor = AppColor.INSTANCE;
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(companion, appColor.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(16)), 0.0f, 1, null);
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(8)), companion2.getStart(), composer4, 6);
                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer4, fillMaxWidth$default);
                            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
                            if (composer3.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer4.createNode(constructor4);
                            } else {
                                composer3.useNode();
                            }
                            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer3);
                            Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
                            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                            }
                            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
                            if (z19) {
                                composer4.startReplaceGroup(1138073441);
                                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.common_noneSelected, composer4, 6), SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, 432, 1572864, 65528);
                                composer3.endReplaceGroup();
                            } else {
                                composer4.startReplaceGroup(1138418006);
                                function2.invoke(composer4, 0);
                                composer3.endReplaceGroup();
                            }
                            composer3.endNode();
                            composer3.endReplaceGroup();
                        }
                        composer3.endNode();
                        composer3.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, ((i11 >> 6) & 14) | 200064, 18);
                AnimatedVisibilityKt.AnimatedVisibility(z6 && !z7, null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), null, ComposableLambdaKt.rememberComposableLambda(-168781857, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainerKt$SectionContainer$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                        invoke(animatedVisibilityScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i14) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-168781857, i14, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainer.<anonymous> (SectionContainer.kt:117)");
                        }
                        float f7 = f5;
                        Function2<Composer, Integer, Unit> function2 = simpleContent;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer3, 0);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, f7), composer3, 0);
                        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 11, null);
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m315paddingqDBjuR0$default);
                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer3);
                        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        function2.invoke(composer3, 0);
                        composer3.endNode();
                        composer3.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 200064, 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function02 = function03;
                z10 = z12;
                z11 = z13;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: C4.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SectionContainer_vCe147k$lambda$0;
                        SectionContainer_vCe147k$lambda$0 = SectionContainerKt.SectionContainer_vCe147k$lambda$0(title, z5, z6, z7, function02, f5, f6, z10, z11, simpleContent, detailedContent, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return SectionContainer_vCe147k$lambda$0;
                    }
                });
                return;
            }
            return;
        }
        if ((i7 & 32) == 0) {
        }
        if ((i7 & 64) == 0) {
        }
        i9 = i7 & 128;
        if (i9 == 0) {
        }
        i10 = i7 & 256;
        if (i10 == 0) {
        }
        if ((i7 & 512) == 0) {
        }
        i11 = i8;
        if ((i7 & 1024) == 0) {
        }
        if ((i11 & 306783379) != 306783378) {
        }
        if (i13 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final boolean z142 = z12;
        final boolean z152 = z13;
        final Function0<Unit> function042 = function03;
        composer2 = startRestartGroup;
        AnimatedVisibilityKt.AnimatedVisibility(z6, null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), null, ComposableLambdaKt.rememberComposableLambda(-466281354, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainerKt$SectionContainer$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                invoke(animatedVisibilityScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i14) {
                Composer composer4;
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-466281354, i14, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainer.<anonymous> (SectionContainer.kt:49)");
                }
                float f7 = f6;
                boolean z16 = z142;
                boolean z17 = z152;
                String str = title;
                boolean z18 = z5;
                Function0<Unit> function05 = function042;
                boolean z19 = z7;
                Function2<Composer, Integer, Unit> function2 = detailedContent;
                Modifier.Companion companion = Modifier.INSTANCE;
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer3, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (composer3.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, f7), composer3, 0);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer3, 48);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, companion);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (composer3.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor2);
                } else {
                    composer3.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer3);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
                TextStyle paragraphBold = z17 ? TypographyKt.getParagraphBold() : TypographyKt.getParagraphSmall();
                TextAlign.Companion companion4 = TextAlign.INSTANCE;
                TextKt.m940Text4IGK_g(str, weight$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, composer3, 0, 0, 65020);
                composer3.startReplaceGroup(-787452542);
                if (z18) {
                    composer4 = composer3;
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketSummary_focusedSection, composer3, 6), null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 384, 1572864, 65018);
                } else {
                    composer4 = composer3;
                }
                composer3.endReplaceGroup();
                composer4.startReplaceGroup(-787441636);
                if (z16 && function05 != null) {
                    IconButtonKt.IconButton(function05, null, false, null, null, ComposableSingletons$SectionContainerKt.INSTANCE.m3558getLambda1$app_kombardoProd(), composer3, 196608, 30);
                }
                composer3.endReplaceGroup();
                composer3.endNode();
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(z16 ? 8 : 16)), composer4, 0);
                Modifier height = IntrinsicKt.height(companion, IntrinsicSize.Min);
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, height);
                Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                if (composer3.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer4.createNode(constructor3);
                } else {
                    composer3.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer3);
                Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (z19 && function05 != null) {
                    composer4.startReplaceGroup(1359823303);
                    OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(BackgroundKt.m104backgroundbw27NRU$default(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), StringResources_androidKt.stringResource(R.string.ticketSummary_section_add, new Object[]{StringExtensionsKt.lowercaseFirstLetter(str)}, composer4, 6), R.drawable.icon_plus_circled, 0L, 0L, 0L, function05, composer3, 390, 56);
                    composer3.endReplaceGroup();
                } else {
                    composer4.startReplaceGroup(1360218956);
                    composer4.startReplaceGroup(-787406129);
                    if (z18) {
                        SectionContainerKt.DashedBorder(composer4, 0);
                    }
                    composer3.endReplaceGroup();
                    AppColor appColor = AppColor.INSTANCE;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(companion, appColor.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(16)), 0.0f, 1, null);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(8)), companion2.getStart(), composer4, 6);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer4, fillMaxWidth$default);
                    Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer4.createNode(constructor4);
                    } else {
                        composer3.useNode();
                    }
                    Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer3);
                    Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
                    if (z19) {
                        composer4.startReplaceGroup(1138073441);
                        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.common_noneSelected, composer4, 6), SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, 432, 1572864, 65528);
                        composer3.endReplaceGroup();
                    } else {
                        composer4.startReplaceGroup(1138418006);
                        function2.invoke(composer4, 0);
                        composer3.endReplaceGroup();
                    }
                    composer3.endNode();
                    composer3.endReplaceGroup();
                }
                composer3.endNode();
                composer3.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer2, 54), composer2, ((i11 >> 6) & 14) | 200064, 18);
        AnimatedVisibilityKt.AnimatedVisibility(z6 && !z7, null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), null, ComposableLambdaKt.rememberComposableLambda(-168781857, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainerKt$SectionContainer$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                invoke(animatedVisibilityScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i14) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-168781857, i14, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.SectionContainer.<anonymous> (SectionContainer.kt:117)");
                }
                float f7 = f5;
                Function2<Composer, Integer, Unit> function2 = simpleContent;
                Modifier.Companion companion = Modifier.INSTANCE;
                Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer3, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (composer3.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, f7), composer3, 0);
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 11, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (composer3.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor2);
                } else {
                    composer3.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer3);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function2.invoke(composer3, 0);
                composer3.endNode();
                composer3.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer2, 54), composer2, 200064, 18);
        if (ComposerKt.isTraceInProgress()) {
        }
        function02 = function03;
        z10 = z12;
        z11 = z13;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionContainer_vCe147k$lambda$0(String str, boolean z5, boolean z6, boolean z7, Function0 function0, float f5, float f6, boolean z8, boolean z9, Function2 function2, Function2 function22, int i5, int i6, int i7, Composer composer, int i8) {
        m3561SectionContainervCe147k(str, z5, z6, z7, function0, f5, f6, z8, z9, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }
}
