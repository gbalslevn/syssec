package dk.molslinjen.ui.views.screens.tickets.details;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsActionButtonsSectionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u001a\u0085\u0001\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aS\u0010\u0018\u001a\u00020\u00072\b\b\u0001\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {BuildConfig.FLAVOR, "refundable", "editable", "shareable", "hideShare", "hideRefund", "Lkotlin/Function0;", BuildConfig.FLAVOR, "refund", "shareReceipt", "editTicket", "showReceiptDisabledMessage", "showRefundDisabledMessage", "shareIsLoading", "TicketDetailsActionButtonsSection", "(ZZZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "icon", BuildConfig.FLAVOR, "text", "onClick", "disabledClick", "enabled", "isLoading", "IconButton", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketDetailsActionButtonsSectionKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void IconButton(final int i5, final String str, final Function0<Unit> function0, Function0<Unit> function02, final boolean z5, boolean z6, Composer composer, final int i6, final int i7) {
        int i8;
        int i9;
        Function0<Unit> function03;
        int i10;
        boolean z7;
        final Function0<Unit> function04;
        boolean z8;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        boolean z9;
        final Function0<Unit> function05;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-219482705);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(str) ? 32 : 16;
            if ((i7 & 4) == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                i8 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
            }
            i9 = i7 & 8;
            if (i9 == 0) {
                i8 |= 3072;
            } else if ((i6 & 3072) == 0) {
                function03 = function02;
                i8 |= startRestartGroup.changedInstance(function03) ? 2048 : 1024;
                if ((i7 & 16) != 0) {
                    i8 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    i8 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                }
                i10 = i7 & 32;
                if (i10 != 0) {
                    i8 |= 196608;
                } else if ((196608 & i6) == 0) {
                    z7 = z6;
                    i8 |= startRestartGroup.changed(z7) ? 131072 : 65536;
                    if ((i8 & 74899) == 74898 || !startRestartGroup.getSkipping()) {
                        function04 = i9 == 0 ? null : function03;
                        if (i10 != 0) {
                            z7 = false;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-219482705, i8, -1, "dk.molslinjen.ui.views.screens.tickets.details.IconButton (TicketDetailsActionButtonsSection.kt:92)");
                        }
                        Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8));
                        boolean z10 = !z7;
                        startRestartGroup.startReplaceGroup(563910842);
                        z8 = ((57344 & i8) != 16384) | ((i8 & 896) != 256) | ((i8 & 7168) != 2048);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function0() { // from class: p4.f
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit IconButton$lambda$6$lambda$5;
                                    IconButton$lambda$6$lambda$5 = TicketDetailsActionButtonsSectionKt.IconButton$lambda$6$lambda$5(z5, function0, function04);
                                    return IconButton$lambda$6$lambda$5;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier alpha = AlphaKt.alpha(ClickableKt.m122clickableXHw0xAI$default(m311padding3ABfNKs, z10, null, null, (Function0) rememberedValue, 6, null), !z5 ? 1.0f : 0.4f);
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, alpha);
                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.useNode();
                        } else {
                            startRestartGroup.createNode(constructor);
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        composer2 = startRestartGroup;
                        LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, Dp.m2599constructorimpl(20), z7, R.raw.animation_lottie_blue_loadspinner, false, null, ComposableLambdaKt.rememberComposableLambda(33067737, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsActionButtonsSectionKt$IconButton$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i11) {
                                if ((i11 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(33067737, i11, -1, "dk.molslinjen.ui.views.screens.tickets.details.IconButton.<anonymous>.<anonymous> (TicketDetailsActionButtonsSection.kt:105)");
                                }
                                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, composer3, 0), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(4), 7, null), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer3, 3456, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), composer2, ((i8 >> 9) & 896) | 1575984, 49);
                        TextKt.m940Text4IGK_g(str, null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), composer2, ((i8 >> 3) & 14) | 384, 1572864, 65018);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        Function0<Unit> function06 = function04;
                        z9 = z7;
                        function05 = function06;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        z9 = z7;
                        function05 = function03;
                        composer2 = startRestartGroup;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        final boolean z11 = z9;
                        endRestartGroup.updateScope(new Function2() { // from class: p4.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit IconButton$lambda$8;
                                IconButton$lambda$8 = TicketDetailsActionButtonsSectionKt.IconButton$lambda$8(i5, str, function0, function05, z5, z11, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                return IconButton$lambda$8;
                            }
                        });
                        return;
                    }
                    return;
                }
                z7 = z6;
                if ((i8 & 74899) == 74898) {
                }
                if (i9 == 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier m311padding3ABfNKs2 = PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8));
                boolean z102 = !z7;
                startRestartGroup.startReplaceGroup(563910842);
                z8 = ((57344 & i8) != 16384) | ((i8 & 896) != 256) | ((i8 & 7168) != 2048);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z8) {
                }
                rememberedValue = new Function0() { // from class: p4.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit IconButton$lambda$6$lambda$5;
                        IconButton$lambda$6$lambda$5 = TicketDetailsActionButtonsSectionKt.IconButton$lambda$6$lambda$5(z5, function0, function04);
                        return IconButton$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                Modifier alpha2 = AlphaKt.alpha(ClickableKt.m122clickableXHw0xAI$default(m311padding3ABfNKs2, z102, null, null, (Function0) rememberedValue, 6, null), !z5 ? 1.0f : 0.4f);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, alpha2);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                composer2 = startRestartGroup;
                LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, Dp.m2599constructorimpl(20), z7, R.raw.animation_lottie_blue_loadspinner, false, null, ComposableLambdaKt.rememberComposableLambda(33067737, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsActionButtonsSectionKt$IconButton$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i11) {
                        if ((i11 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(33067737, i11, -1, "dk.molslinjen.ui.views.screens.tickets.details.IconButton.<anonymous>.<anonymous> (TicketDetailsActionButtonsSection.kt:105)");
                        }
                        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, composer3, 0), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(4), 7, null), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer3, 3456, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), composer2, ((i8 >> 9) & 896) | 1575984, 49);
                TextKt.m940Text4IGK_g(str, null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), composer2, ((i8 >> 3) & 14) | 384, 1572864, 65018);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                Function0<Unit> function062 = function04;
                z9 = z7;
                function05 = function062;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function03 = function02;
            if ((i7 & 16) != 0) {
            }
            i10 = i7 & 32;
            if (i10 != 0) {
            }
            z7 = z6;
            if ((i8 & 74899) == 74898) {
            }
            if (i9 == 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m311padding3ABfNKs22 = PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8));
            boolean z1022 = !z7;
            startRestartGroup.startReplaceGroup(563910842);
            z8 = ((57344 & i8) != 16384) | ((i8 & 896) != 256) | ((i8 & 7168) != 2048);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z8) {
            }
            rememberedValue = new Function0() { // from class: p4.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit IconButton$lambda$6$lambda$5;
                    IconButton$lambda$6$lambda$5 = TicketDetailsActionButtonsSectionKt.IconButton$lambda$6$lambda$5(z5, function0, function04);
                    return IconButton$lambda$6$lambda$5;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier alpha22 = AlphaKt.alpha(ClickableKt.m122clickableXHw0xAI$default(m311padding3ABfNKs22, z1022, null, null, (Function0) rememberedValue, 6, null), !z5 ? 1.0f : 0.4f);
            MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, alpha22);
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion22.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
            ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, Dp.m2599constructorimpl(20), z7, R.raw.animation_lottie_blue_loadspinner, false, null, ComposableLambdaKt.rememberComposableLambda(33067737, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsActionButtonsSectionKt$IconButton$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i11) {
                    if ((i11 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(33067737, i11, -1, "dk.molslinjen.ui.views.screens.tickets.details.IconButton.<anonymous>.<anonymous> (TicketDetailsActionButtonsSection.kt:105)");
                    }
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, composer3, 0), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(4), 7, null), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer3, 3456, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, ((i8 >> 9) & 896) | 1575984, 49);
            TextKt.m940Text4IGK_g(str, null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), composer2, ((i8 >> 3) & 14) | 384, 1572864, 65018);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            Function0<Unit> function0622 = function04;
            z9 = z7;
            function05 = function0622;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i7 & 4) == 0) {
        }
        i9 = i7 & 8;
        if (i9 == 0) {
        }
        function03 = function02;
        if ((i7 & 16) != 0) {
        }
        i10 = i7 & 32;
        if (i10 != 0) {
        }
        z7 = z6;
        if ((i8 & 74899) == 74898) {
        }
        if (i9 == 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m311padding3ABfNKs222 = PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8));
        boolean z10222 = !z7;
        startRestartGroup.startReplaceGroup(563910842);
        z8 = ((57344 & i8) != 16384) | ((i8 & 896) != 256) | ((i8 & 7168) != 2048);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z8) {
        }
        rememberedValue = new Function0() { // from class: p4.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit IconButton$lambda$6$lambda$5;
                IconButton$lambda$6$lambda$5 = TicketDetailsActionButtonsSectionKt.IconButton$lambda$6$lambda$5(z5, function0, function04);
                return IconButton$lambda$6$lambda$5;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier alpha222 = AlphaKt.alpha(ClickableKt.m122clickableXHw0xAI$default(m311padding3ABfNKs222, z10222, null, null, (Function0) rememberedValue, 6, null), !z5 ? 1.0f : 0.4f);
        MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, alpha222);
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222, companion222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion222.getSetModifier());
        ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
        composer2 = startRestartGroup;
        LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, Dp.m2599constructorimpl(20), z7, R.raw.animation_lottie_blue_loadspinner, false, null, ComposableLambdaKt.rememberComposableLambda(33067737, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsActionButtonsSectionKt$IconButton$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i11) {
                if ((i11 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(33067737, i11, -1, "dk.molslinjen.ui.views.screens.tickets.details.IconButton.<anonymous>.<anonymous> (TicketDetailsActionButtonsSection.kt:105)");
                }
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, composer3, 0), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(20)), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(4), 7, null), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer3, 3456, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), composer2, ((i8 >> 9) & 896) | 1575984, 49);
        TextKt.m940Text4IGK_g(str, null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), composer2, ((i8 >> 3) & 14) | 384, 1572864, 65018);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        Function0<Unit> function06222 = function04;
        z9 = z7;
        function05 = function06222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButton$lambda$6$lambda$5(boolean z5, Function0 function0, Function0 function02) {
        if (z5) {
            function0.invoke();
        } else if (function02 != null) {
            function02.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconButton$lambda$8(int i5, String str, Function0 function0, Function0 function02, boolean z5, boolean z6, int i6, int i7, Composer composer, int i8) {
        IconButton(i5, str, function0, function02, z5, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    public static final void TicketDetailsActionButtonsSection(final boolean z5, final boolean z6, final boolean z7, final boolean z8, final boolean z9, final Function0<Unit> refund, final Function0<Unit> shareReceipt, final Function0<Unit> editTicket, final Function0<Unit> showReceiptDisabledMessage, final Function0<Unit> showRefundDisabledMessage, final boolean z10, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        Modifier.Companion companion;
        Composer composer2;
        int i10;
        int i11;
        Composer composer3;
        Intrinsics.checkNotNullParameter(refund, "refund");
        Intrinsics.checkNotNullParameter(shareReceipt, "shareReceipt");
        Intrinsics.checkNotNullParameter(editTicket, "editTicket");
        Intrinsics.checkNotNullParameter(showReceiptDisabledMessage, "showReceiptDisabledMessage");
        Intrinsics.checkNotNullParameter(showRefundDisabledMessage, "showRefundDisabledMessage");
        Composer startRestartGroup = composer.startRestartGroup(1782260684);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z7) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z8) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changed(z9) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(refund) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(shareReceipt) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(editTicket) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(showReceiptDisabledMessage) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(showRefundDisabledMessage) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changed(z10) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i7 & 306783379) == 306783378 && (i8 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1782260684, i7, i8, "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsActionButtonsSection (TicketDetailsActionButtonsSection.kt:36)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, companion3.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1712991786);
            if (z9) {
                i9 = i7;
                companion = companion2;
                composer2 = startRestartGroup;
                i10 = i8;
                i11 = 6;
            } else {
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                i9 = i7;
                i11 = 6;
                companion = companion2;
                composer2 = startRestartGroup;
                i10 = i8;
                IconButton(R.drawable.icon_refund, StringResources_androidKt.stringResource(R.string.ticketDetails_refundTicket, startRestartGroup, 6), refund, showRefundDisabledMessage, z5, false, startRestartGroup, ((i7 >> 9) & 896) | 6 | ((i7 >> 18) & 7168) | ((i7 << 12) & 57344), 32);
                composer2.endNode();
            }
            composer2.endReplaceGroup();
            Composer composer4 = composer2;
            composer4.startReplaceGroup(1713008103);
            if (z8) {
                composer3 = composer4;
            } else {
                Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer4.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, weight$default2);
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                if (composer4.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor3);
                } else {
                    composer4.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer4);
                Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composer3 = composer4;
                IconButton(R.drawable.icon_share_receipt, StringResources_androidKt.stringResource(R.string.ticketDetails_shareReceipt, composer4, i11), shareReceipt, showReceiptDisabledMessage, z7, z10, composer4, ((i9 >> 12) & 896) | i11 | ((i9 >> 15) & 7168) | ((i9 << 6) & 57344) | ((i10 << 15) & 458752), 0);
                composer3.endNode();
            }
            composer3.endReplaceGroup();
            Modifier weight$default3 = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getCenter(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, weight$default3);
            Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
            if (composer3.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor4);
            } else {
                composer3.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer3);
            Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            IconButton(R.drawable.icon_edit_ticket, StringResources_androidKt.stringResource(R.string.ticketDetails_editTicket, composer3, i11), editTicket, null, z6, false, composer3, ((i9 >> 15) & 896) | i11 | ((i9 << 9) & 57344), 40);
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketDetailsActionButtonsSection$lambda$4;
                    TicketDetailsActionButtonsSection$lambda$4 = TicketDetailsActionButtonsSectionKt.TicketDetailsActionButtonsSection$lambda$4(z5, z6, z7, z8, z9, refund, shareReceipt, editTicket, showReceiptDisabledMessage, showRefundDisabledMessage, z10, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketDetailsActionButtonsSection$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketDetailsActionButtonsSection$lambda$4(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, boolean z10, int i5, int i6, Composer composer, int i7) {
        TicketDetailsActionButtonsSection(z5, z6, z7, z8, z9, function0, function02, function03, function04, function05, z10, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }
}
