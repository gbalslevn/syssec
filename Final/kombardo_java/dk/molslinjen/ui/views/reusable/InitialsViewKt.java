package dk.molslinjen.ui.views.reusable;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.InitialsViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u001ac\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/ui/views/reusable/InitialsViewSize;", "size", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "textColor", BuildConfig.FLAVOR, "initials", BuildConfig.FLAVOR, "selected", "editable", "showEditablePadding", BuildConfig.FLAVOR, "InitialsView-gPmlwdY", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/ui/views/reusable/InitialsViewSize;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Ljava/lang/String;ZZZLandroidx/compose/runtime/Composer;II)V", "InitialsView", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class InitialsViewKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02d1  */
    /* renamed from: InitialsView-gPmlwdY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3389InitialsViewgPmlwdY(Modifier modifier, final InitialsViewSize size, Color color, Color color2, String str, boolean z5, boolean z6, boolean z7, Composer composer, final int i5, final int i6) {
        int i7;
        Color color3;
        int i8;
        Color color4;
        int i9;
        String str2;
        int i10;
        boolean z8;
        int i11;
        int i12;
        Modifier modifier2;
        final Color color5;
        boolean z9;
        boolean z10;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Object rememberedValue;
        long m3255getBrandBlue10d7_KjU;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        final String str3;
        final Color color6;
        final boolean z11;
        final boolean z12;
        final boolean z13;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(size, "size");
        Composer startRestartGroup = composer.startRestartGroup(-414622982);
        int i13 = i6 & 1;
        if (i13 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(size) ? 32 : 16;
        }
        int i14 = i6 & 4;
        if (i14 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            color3 = color;
            i7 |= startRestartGroup.changed(color3) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                color4 = color2;
                i7 |= startRestartGroup.changed(color4) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    str2 = str;
                    i7 |= startRestartGroup.changed(str2) ? 16384 : 8192;
                    i10 = i6 & 32;
                    if (i10 == 0) {
                        i7 |= 196608;
                    } else if ((196608 & i5) == 0) {
                        z8 = z5;
                        i7 |= startRestartGroup.changed(z8) ? 131072 : 65536;
                        i11 = i6 & 64;
                        if (i11 != 0) {
                            i7 |= 1572864;
                        } else if ((i5 & 1572864) == 0) {
                            i7 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
                        }
                        i12 = i6 & 128;
                        if (i12 != 0) {
                            i7 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i7 |= startRestartGroup.changed(z7) ? 8388608 : 4194304;
                        }
                        if ((i7 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                            modifier2 = i13 != 0 ? Modifier.INSTANCE : modifier;
                            if (i14 != 0) {
                                color3 = null;
                            }
                            color5 = i8 != 0 ? null : color4;
                            String str4 = i9 == 0 ? str2 : null;
                            z9 = i10 != 0 ? false : z8;
                            z10 = i11 != 0 ? false : z6;
                            boolean z14 = i12 != 0 ? false : z7;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-414622982, i7, -1, "dk.molslinjen.ui.views.reusable.InitialsView (InitialsView.kt:38)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            Alignment.Companion companion2 = Alignment.INSTANCE;
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            boolean z15 = !z9 || z10 || z14;
                            startRestartGroup.startReplaceGroup(-1433329934);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1() { // from class: W1.p
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Modifier InitialsView_gPmlwdY$lambda$3$lambda$1$lambda$0;
                                        InitialsView_gPmlwdY$lambda$3$lambda$1$lambda$0 = InitialsViewKt.InitialsView_gPmlwdY$lambda$3$lambda$1$lambda$0((Modifier) obj);
                                        return InitialsView_gPmlwdY$lambda$3$lambda$1$lambda$0;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(ModifierExtensionsKt.applyIf(modifier2, z15, (Function1) rememberedValue), size.m3390getSizeD9Ej5fM());
                            if (color3 != null) {
                                m3255getBrandBlue10d7_KjU = color3.getValue();
                            } else {
                                AppColor appColor = AppColor.INSTANCE;
                                m3255getBrandBlue10d7_KjU = z9 ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3267getGrey40d7_KjU();
                            }
                            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(m331size3ABfNKs, m3255getBrandBlue10d7_KjU, RoundedCornerShapeKt.getCircleShape());
                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU);
                            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor2);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                            boolean z16 = z14;
                            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                            if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                            TextKt.m940Text4IGK_g(str4 == null ? BuildConfig.FLAVOR : str4, null, color5 != null ? color5.getValue() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, size.getTextStyle(), startRestartGroup, 0, 3072, 57338);
                            startRestartGroup.endNode();
                            startRestartGroup.startReplaceGroup(-1433314842);
                            if (z9) {
                                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_tick_small, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), boxScopeInstance.align(companion, companion2.getTopEnd()), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3072, 0);
                            }
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-1433304631);
                            if (z10) {
                                Modifier clip = ClipKt.clip(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(18)), RoundedCornerShapeKt.getCircleShape());
                                AppColor appColor2 = AppColor.INSTANCE;
                                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_edit, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_edit, startRestartGroup, 6), boxScopeInstance.align(PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(BackgroundKt.m104backgroundbw27NRU$default(clip, appColor2.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(1), appColor2.m3267getGrey40d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(5)), companion2.getBottomEnd()), appColor2.m3253getBrandBlack10d7_KjU(), startRestartGroup, 3072, 0);
                            }
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str3 = str4;
                            color6 = color3;
                            z11 = z9;
                            z12 = z10;
                            z13 = z16;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z13 = z7;
                            color6 = color3;
                            color5 = color4;
                            str3 = str2;
                            z11 = z8;
                            z12 = z6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            endRestartGroup.updateScope(new Function2() { // from class: W1.q
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit InitialsView_gPmlwdY$lambda$4;
                                    InitialsView_gPmlwdY$lambda$4 = InitialsViewKt.InitialsView_gPmlwdY$lambda$4(Modifier.this, size, color6, color5, str3, z11, z12, z13, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return InitialsView_gPmlwdY$lambda$4;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z8 = z5;
                    i11 = i6 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 128;
                    if (i12 != 0) {
                    }
                    if ((i7 & 4793491) == 4793490) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    Alignment.Companion companion22 = Alignment.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion22.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion4);
                    ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor3 = companion32.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy3, companion32.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion32.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion32.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion32.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    if (z9) {
                    }
                    startRestartGroup.startReplaceGroup(-1433329934);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier m331size3ABfNKs2 = SizeKt.m331size3ABfNKs(ModifierExtensionsKt.applyIf(modifier2, z15, (Function1) rememberedValue), size.m3390getSizeD9Ej5fM());
                    if (color3 != null) {
                    }
                    Modifier m103backgroundbw27NRU2 = BackgroundKt.m103backgroundbw27NRU(m331size3ABfNKs2, m3255getBrandBlue10d7_KjU, RoundedCornerShapeKt.getCircleShape());
                    MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion22.getCenter(), false);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU2);
                    Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    boolean z162 = z14;
                    Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy22, companion32.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion32.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion32.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting()) {
                    }
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion32.getSetModifier());
                    if (str4 == null) {
                    }
                    TextKt.m940Text4IGK_g(str4 == null ? BuildConfig.FLAVOR : str4, null, color5 != null ? color5.getValue() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, size.getTextStyle(), startRestartGroup, 0, 3072, 57338);
                    startRestartGroup.endNode();
                    startRestartGroup.startReplaceGroup(-1433314842);
                    if (z9) {
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-1433304631);
                    if (z10) {
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str3 = str4;
                    color6 = color3;
                    z11 = z9;
                    z12 = z10;
                    z13 = z162;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                str2 = str;
                i10 = i6 & 32;
                if (i10 == 0) {
                }
                z8 = z5;
                i11 = i6 & 64;
                if (i11 != 0) {
                }
                i12 = i6 & 128;
                if (i12 != 0) {
                }
                if ((i7 & 4793491) == 4793490) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 == 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier.Companion companion42 = Modifier.INSTANCE;
                Alignment.Companion companion222 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy32 = BoxKt.maybeCachedBoxMeasurePolicy(companion222.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, companion42);
                ComposeUiNode.Companion companion322 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor32 = companion322.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy32, companion322.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion322.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion322.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion322.getSetModifier());
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                if (z9) {
                }
                startRestartGroup.startReplaceGroup(-1433329934);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier m331size3ABfNKs22 = SizeKt.m331size3ABfNKs(ModifierExtensionsKt.applyIf(modifier2, z15, (Function1) rememberedValue), size.m3390getSizeD9Ej5fM());
                if (color3 != null) {
                }
                Modifier m103backgroundbw27NRU22 = BackgroundKt.m103backgroundbw27NRU(m331size3ABfNKs22, m3255getBrandBlue10d7_KjU, RoundedCornerShapeKt.getCircleShape());
                MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(companion222.getCenter(), false);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU22);
                Function0<ComposeUiNode> constructor222 = companion322.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                boolean z1622 = z14;
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy222, companion322.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion322.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion322.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting()) {
                }
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion322.getSetModifier());
                if (str4 == null) {
                }
                TextKt.m940Text4IGK_g(str4 == null ? BuildConfig.FLAVOR : str4, null, color5 != null ? color5.getValue() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, size.getTextStyle(), startRestartGroup, 0, 3072, 57338);
                startRestartGroup.endNode();
                startRestartGroup.startReplaceGroup(-1433314842);
                if (z9) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1433304631);
                if (z10) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                str3 = str4;
                color6 = color3;
                z11 = z9;
                z12 = z10;
                z13 = z1622;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            color4 = color2;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            str2 = str;
            i10 = i6 & 32;
            if (i10 == 0) {
            }
            z8 = z5;
            i11 = i6 & 64;
            if (i11 != 0) {
            }
            i12 = i6 & 128;
            if (i12 != 0) {
            }
            if ((i7 & 4793491) == 4793490) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 == 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier.Companion companion422 = Modifier.INSTANCE;
            Alignment.Companion companion2222 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy322 = BoxKt.maybeCachedBoxMeasurePolicy(companion2222.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, companion422);
            ComposeUiNode.Companion companion3222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor322 = companion3222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy322, companion3222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap322, companion3222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = companion3222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash322);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier322, companion3222.getSetModifier());
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            if (z9) {
            }
            startRestartGroup.startReplaceGroup(-1433329934);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier m331size3ABfNKs222 = SizeKt.m331size3ABfNKs(ModifierExtensionsKt.applyIf(modifier2, z15, (Function1) rememberedValue), size.m3390getSizeD9Ej5fM());
            if (color3 != null) {
            }
            Modifier m103backgroundbw27NRU222 = BackgroundKt.m103backgroundbw27NRU(m331size3ABfNKs222, m3255getBrandBlue10d7_KjU, RoundedCornerShapeKt.getCircleShape());
            MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(companion2222.getCenter(), false);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU222);
            Function0<ComposeUiNode> constructor2222 = companion3222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            boolean z16222 = z14;
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2222, companion3222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2222, companion3222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion3222.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2222, companion3222.getSetModifier());
            if (str4 == null) {
            }
            TextKt.m940Text4IGK_g(str4 == null ? BuildConfig.FLAVOR : str4, null, color5 != null ? color5.getValue() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, size.getTextStyle(), startRestartGroup, 0, 3072, 57338);
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(-1433314842);
            if (z9) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1433304631);
            if (z10) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            str3 = str4;
            color6 = color3;
            z11 = z9;
            z12 = z10;
            z13 = z16222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        color3 = color;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        color4 = color2;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        str2 = str;
        i10 = i6 & 32;
        if (i10 == 0) {
        }
        z8 = z5;
        i11 = i6 & 64;
        if (i11 != 0) {
        }
        i12 = i6 & 128;
        if (i12 != 0) {
        }
        if ((i7 & 4793491) == 4793490) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion4222 = Modifier.INSTANCE;
        Alignment.Companion companion22222 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy3222 = BoxKt.maybeCachedBoxMeasurePolicy(companion22222.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion4222);
        ComposeUiNode.Companion companion32222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor3222 = companion32222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy3222, companion32222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3222, companion32222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = companion32222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier3222, companion32222.getSetModifier());
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        if (z9) {
        }
        startRestartGroup.startReplaceGroup(-1433329934);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier m331size3ABfNKs2222 = SizeKt.m331size3ABfNKs(ModifierExtensionsKt.applyIf(modifier2, z15, (Function1) rememberedValue), size.m3390getSizeD9Ej5fM());
        if (color3 != null) {
        }
        Modifier m103backgroundbw27NRU2222 = BackgroundKt.m103backgroundbw27NRU(m331size3ABfNKs2222, m3255getBrandBlue10d7_KjU, RoundedCornerShapeKt.getCircleShape());
        MeasurePolicy maybeCachedBoxMeasurePolicy22222 = BoxKt.maybeCachedBoxMeasurePolicy(companion22222.getCenter(), false);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU2222);
        Function0<ComposeUiNode> constructor22222 = companion32222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        boolean z162222 = z14;
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy22222, companion32222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22222, companion32222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = companion32222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22222, companion32222.getSetModifier());
        if (str4 == null) {
        }
        TextKt.m940Text4IGK_g(str4 == null ? BuildConfig.FLAVOR : str4, null, color5 != null ? color5.getValue() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, size.getTextStyle(), startRestartGroup, 0, 3072, 57338);
        startRestartGroup.endNode();
        startRestartGroup.startReplaceGroup(-1433314842);
        if (z9) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1433304631);
        if (z10) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        color6 = color3;
        z11 = z9;
        z12 = z10;
        z13 = z162222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier InitialsView_gPmlwdY$lambda$3$lambda$1$lambda$0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InitialsView_gPmlwdY$lambda$4(Modifier modifier, InitialsViewSize initialsViewSize, Color color, Color color2, String str, boolean z5, boolean z6, boolean z7, int i5, int i6, Composer composer, int i7) {
        m3389InitialsViewgPmlwdY(modifier, initialsViewSize, color, color2, str, z5, z6, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
