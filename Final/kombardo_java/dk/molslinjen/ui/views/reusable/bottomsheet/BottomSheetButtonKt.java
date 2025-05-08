package dk.molslinjen.ui.views.reusable.bottomsheet;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.ButtonWithPriceKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001ak\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {BuildConfig.FLAVOR, "text", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "price", BuildConfig.FLAVOR, "enabled", "isLoading", "topShadow", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClickDisabled", "onClick", "BottomSheetButton-1YH7lEI", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ZZZJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "BottomSheetButton", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BottomSheetButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00ce  */
    /* renamed from: BottomSheetButton-1YH7lEI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3397BottomSheetButton1YH7lEI(final String text, PriceWithCurrency priceWithCurrency, boolean z5, boolean z6, boolean z7, long j5, Function0<Unit> function0, final Function0<Unit> onClick, Composer composer, final int i5, final int i6) {
        int i7;
        PriceWithCurrency priceWithCurrency2;
        int i8;
        boolean z8;
        int i9;
        int i10;
        boolean z9;
        int i11;
        final long j6;
        int i12;
        PriceWithCurrency priceWithCurrency3;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        boolean z10;
        Composer composer2;
        final boolean z11;
        final Function0<Unit> function02;
        final boolean z12;
        final PriceWithCurrency priceWithCurrency4;
        final boolean z13;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1996520633);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(text) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i13 = 2 & i6;
        if (i13 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            priceWithCurrency2 = priceWithCurrency;
            i7 |= startRestartGroup.changedInstance(priceWithCurrency2) ? 32 : 16;
            i8 = 4 & i6;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                z8 = z5;
                i7 |= startRestartGroup.changed(z8) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        z9 = z7;
                        i7 |= startRestartGroup.changed(z9) ? 16384 : 8192;
                        i11 = 32 & i6;
                        if (i11 != 0) {
                            i7 |= 196608;
                            j6 = j5;
                        } else {
                            j6 = j5;
                            if ((i5 & 196608) == 0) {
                                i7 |= startRestartGroup.changed(j6) ? 131072 : 65536;
                            }
                        }
                        i12 = i6 & 64;
                        if (i12 != 0) {
                            i7 |= 1572864;
                        } else if ((i5 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
                        }
                        if ((128 & i6) != 0) {
                            i7 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i7 |= startRestartGroup.changedInstance(onClick) ? 8388608 : 4194304;
                        }
                        if ((4793491 & i7) == 4793490 || !startRestartGroup.getSkipping()) {
                            priceWithCurrency3 = i13 != 0 ? null : priceWithCurrency2;
                            boolean z14 = i8 != 0 ? true : z8;
                            boolean z15 = i9 != 0 ? false : z6;
                            boolean z16 = i10 != 0 ? false : z9;
                            long m3281getWhite0d7_KjU = i11 != 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j6;
                            Function0<Unit> function03 = i12 != 0 ? null : function0;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1996520633, i7, -1, "dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButton (BottomSheetButton.kt:29)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            startRestartGroup.startReplaceGroup(-1633756106);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1() { // from class: Y1.a
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Modifier BottomSheetButton_1YH7lEI$lambda$1$lambda$0;
                                        BottomSheetButton_1YH7lEI$lambda$1$lambda$0 = BottomSheetButtonKt.BottomSheetButton_1YH7lEI$lambda$1$lambda$0((Modifier) obj);
                                        return BottomSheetButton_1YH7lEI$lambda$1$lambda$0;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(SizeKt.fillMaxWidth$default(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.applyIf(companion, z16, (Function1) rememberedValue), m3281getWhite0d7_KjU, null, 2, null), 0.0f, 1, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(16));
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            if (priceWithCurrency3 == null) {
                                startRestartGroup.startReplaceGroup(-1146615708);
                                int i14 = i7 << 9;
                                z10 = z16;
                                PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), text, onClick, function03, ButtonConfig.Large, z14, z15, false, startRestartGroup, ((i7 << 3) & 112) | 24582 | ((i7 >> 15) & 896) | ((i7 >> 9) & 7168) | (458752 & i14) | (i14 & 3670016), 128);
                                startRestartGroup.endReplaceGroup();
                                composer2 = startRestartGroup;
                            } else {
                                z10 = z16;
                                startRestartGroup.startReplaceGroup(-1146269872);
                                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                                int i15 = i7 << 6;
                                composer2 = startRestartGroup;
                                ButtonWithPriceKt.ButtonWithPrice(fillMaxWidth$default, onClick, text, priceWithCurrency3, (String) null, z14 && !z15, function03, (ButtonConfig) null, false, startRestartGroup, ((i7 >> 18) & 112) | 6 | (i15 & 896) | (i15 & 7168) | (3670016 & i7), Constants.MINIMAL_ERROR_STATUS_CODE);
                                composer2.endReplaceGroup();
                            }
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z11 = z15;
                            function02 = function03;
                            z12 = z10;
                            priceWithCurrency4 = priceWithCurrency3;
                            z13 = z14;
                            j6 = m3281getWhite0d7_KjU;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z11 = z6;
                            function02 = function0;
                            z12 = z9;
                            priceWithCurrency4 = priceWithCurrency2;
                            z13 = z8;
                            composer2 = startRestartGroup;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: Y1.b
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit BottomSheetButton_1YH7lEI$lambda$3;
                                    BottomSheetButton_1YH7lEI$lambda$3 = BottomSheetButtonKt.BottomSheetButton_1YH7lEI$lambda$3(text, priceWithCurrency4, z13, z11, z12, j6, function02, onClick, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return BottomSheetButton_1YH7lEI$lambda$3;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z9 = z7;
                    i11 = 32 & i6;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 64;
                    if (i12 != 0) {
                    }
                    if ((128 & i6) != 0) {
                    }
                    if ((4793491 & i7) == 4793490) {
                    }
                    if (i13 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    startRestartGroup.startReplaceGroup(-1633756106);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier m312paddingVpY3zN42 = PaddingKt.m312paddingVpY3zN4(SizeKt.fillMaxWidth$default(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.applyIf(companion3, z16, (Function1) rememberedValue), m3281getWhite0d7_KjU, null, 2, null), 0.0f, 1, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(16));
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN42);
                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion22.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    if (priceWithCurrency3 == null) {
                    }
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z11 = z15;
                    function02 = function03;
                    z12 = z10;
                    priceWithCurrency4 = priceWithCurrency3;
                    z13 = z14;
                    j6 = m3281getWhite0d7_KjU;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                z9 = z7;
                i11 = 32 & i6;
                if (i11 != 0) {
                }
                i12 = i6 & 64;
                if (i12 != 0) {
                }
                if ((128 & i6) != 0) {
                }
                if ((4793491 & i7) == 4793490) {
                }
                if (i13 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier.Companion companion32 = Modifier.INSTANCE;
                startRestartGroup.startReplaceGroup(-1633756106);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier m312paddingVpY3zN422 = PaddingKt.m312paddingVpY3zN4(SizeKt.fillMaxWidth$default(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.applyIf(companion32, z16, (Function1) rememberedValue), m3281getWhite0d7_KjU, null, 2, null), 0.0f, 1, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(16));
                MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN422);
                ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                if (priceWithCurrency3 == null) {
                }
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                z11 = z15;
                function02 = function03;
                z12 = z10;
                priceWithCurrency4 = priceWithCurrency3;
                z13 = z14;
                j6 = m3281getWhite0d7_KjU;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z8 = z5;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            z9 = z7;
            i11 = 32 & i6;
            if (i11 != 0) {
            }
            i12 = i6 & 64;
            if (i12 != 0) {
            }
            if ((128 & i6) != 0) {
            }
            if ((4793491 & i7) == 4793490) {
            }
            if (i13 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier.Companion companion322 = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(-1633756106);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier m312paddingVpY3zN4222 = PaddingKt.m312paddingVpY3zN4(SizeKt.fillMaxWidth$default(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.applyIf(companion322, z16, (Function1) rememberedValue), m3281getWhite0d7_KjU, null, 2, null), 0.0f, 1, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(16));
            MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4222);
            ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor222 = companion2222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222, companion2222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion2222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion2222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion2222.getSetModifier());
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            if (priceWithCurrency3 == null) {
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            z11 = z15;
            function02 = function03;
            z12 = z10;
            priceWithCurrency4 = priceWithCurrency3;
            z13 = z14;
            j6 = m3281getWhite0d7_KjU;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        priceWithCurrency2 = priceWithCurrency;
        i8 = 4 & i6;
        if (i8 == 0) {
        }
        z8 = z5;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        z9 = z7;
        i11 = 32 & i6;
        if (i11 != 0) {
        }
        i12 = i6 & 64;
        if (i12 != 0) {
        }
        if ((128 & i6) != 0) {
        }
        if ((4793491 & i7) == 4793490) {
        }
        if (i13 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion3222 = Modifier.INSTANCE;
        startRestartGroup.startReplaceGroup(-1633756106);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier m312paddingVpY3zN42222 = PaddingKt.m312paddingVpY3zN4(SizeKt.fillMaxWidth$default(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.applyIf(companion3222, z16, (Function1) rememberedValue), m3281getWhite0d7_KjU, null, 2, null), 0.0f, 1, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(16));
        MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN42222);
        ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2222 = companion22222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2222, companion22222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion22222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion22222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion22222.getSetModifier());
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        if (priceWithCurrency3 == null) {
        }
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z11 = z15;
        function02 = function03;
        z12 = z10;
        priceWithCurrency4 = priceWithCurrency3;
        z13 = z14;
        j6 = m3281getWhite0d7_KjU;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier BottomSheetButton_1YH7lEI$lambda$1$lambda$0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ModifierExtensionsKt.topShadow(applyIf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetButton_1YH7lEI$lambda$3(String str, PriceWithCurrency priceWithCurrency, boolean z5, boolean z6, boolean z7, long j5, Function0 function0, Function0 function02, int i5, int i6, Composer composer, int i7) {
        m3397BottomSheetButton1YH7lEI(str, priceWithCurrency, z5, z6, z7, j5, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
