package dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.AddressViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a]\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "address", BuildConfig.FLAVOR, "showDetailsForDepartingTime", "highlightedAddress", "longArriveBeforeText", "showAddress", "Lkotlin/Function1;", BuildConfig.FLAVOR, "showOnMap", "AddressView", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZZZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AddressViewKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AddressView(Modifier modifier, final String address, final boolean z5, boolean z6, boolean z7, boolean z8, final Function1<? super String, Unit> function1, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        boolean z9;
        int i8;
        boolean z10;
        int i9;
        boolean z11;
        boolean z12;
        boolean z13;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int i10;
        Composer composer2;
        Modifier modifier3;
        Composer composer3;
        int i11;
        final boolean z14;
        final boolean z15;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(address, "address");
        Composer startRestartGroup = composer.startRestartGroup(-250362341);
        int i12 = i6 & 1;
        if (i12 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(address) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        int i13 = i6 & 8;
        if (i13 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            z9 = z6;
            i7 |= startRestartGroup.changed(z9) ? 2048 : 1024;
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                z10 = z7;
                i7 |= startRestartGroup.changed(z10) ? 16384 : 8192;
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                    z11 = z8;
                } else {
                    z11 = z8;
                    if ((i5 & 196608) == 0) {
                        i7 |= startRestartGroup.changed(z11) ? 131072 : 65536;
                    }
                }
                if ((i6 & 64) != 0) {
                    i7 |= 1572864;
                } else if ((i5 & 1572864) == 0) {
                    i7 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                }
                if ((i7 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                    Modifier modifier4 = i12 != 0 ? Modifier.INSTANCE : modifier2;
                    z12 = i13 != 0 ? false : z9;
                    boolean z16 = i8 != 0 ? false : z10;
                    z13 = i9 != 0 ? true : z11;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-250362341, i7, -1, "dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.AddressView (AddressView.kt:29)");
                    }
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.Vertical top = arrangement.getTop();
                    Alignment.Companion companion = Alignment.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
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
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(1317171456);
                    if (z13) {
                        TextStyle sub = TypographyKt.getSub();
                        AppColor appColor = AppColor.INSTANCE;
                        i10 = i7;
                        composer2 = startRestartGroup;
                        modifier3 = modifier4;
                        TextKt.m940Text4IGK_g(address, null, z12 ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, composer2, (i7 >> 3) & 14, 1572864, 65530);
                    } else {
                        i10 = i7;
                        composer2 = startRestartGroup;
                        modifier3 = modifier4;
                    }
                    composer2.endReplaceGroup();
                    composer3 = composer2;
                    composer3.startReplaceGroup(1317178787);
                    if (z5) {
                        i11 = 0;
                        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(z16 ? R.string.ticketDetails_kombardoArrivalTimeBeforeDeparture_long : R.string.ticketDetails_kombardoArrivalTimeBeforeDeparture, composer3, 0), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(12), 0.0f, 0.0f, 13, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, 432, 1572864, 65528);
                    } else {
                        i11 = 0;
                    }
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(1317196368);
                    if (function1 != null) {
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        float f5 = 16;
                        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                        composer3.startReplaceGroup(1317200452);
                        int i14 = ((i10 & 3670016) == 1048576 ? 1 : i11) | ((i10 & 112) != 32 ? i11 : 1);
                        Object rememberedValue = composer3.rememberedValue();
                        if (i14 != 0 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function0() { // from class: c3.a
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit AddressView$lambda$3$lambda$1$lambda$0;
                                    AddressView$lambda$3$lambda$1$lambda$0 = AddressViewKt.AddressView$lambda$3$lambda$1$lambda$0(Function1.this, address);
                                    return AddressView$lambda$3$lambda$1$lambda$0;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceGroup();
                        Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(m315paddingqDBjuR0$default, false, null, null, (Function0) rememberedValue, 7, null);
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), composer3, i11);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, i11);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m122clickableXHw0xAI$default);
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_pin_ticket_details, composer3, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer3, 3456, 0);
                        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketDetails_showOnMap, composer3, 6), PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 432, 1572864, 65528);
                        composer3.endNode();
                    }
                    composer3.endReplaceGroup();
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z14 = z16;
                    z15 = z13;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    z12 = z9;
                    modifier3 = modifier2;
                    composer3 = startRestartGroup;
                    z14 = z10;
                    z15 = z11;
                }
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier3;
                    final boolean z17 = z12;
                    endRestartGroup.updateScope(new Function2() { // from class: c3.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AddressView$lambda$4;
                            AddressView$lambda$4 = AddressViewKt.AddressView$lambda$4(Modifier.this, address, z5, z17, z14, z15, function1, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return AddressView$lambda$4;
                        }
                    });
                    return;
                }
                return;
            }
            z10 = z7;
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if ((i7 & 599187) == 599186) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Arrangement arrangement2 = Arrangement.INSTANCE;
            Arrangement.Vertical top2 = arrangement2.getTop();
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion4.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor3 = companion22.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion22.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion22.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion22.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion22.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1317171456);
            if (z13) {
            }
            composer2.endReplaceGroup();
            composer3 = composer2;
            composer3.startReplaceGroup(1317178787);
            if (z5) {
            }
            composer3.endReplaceGroup();
            composer3.startReplaceGroup(1317196368);
            if (function1 != null) {
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            z14 = z16;
            z15 = z13;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z9 = z6;
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        z10 = z7;
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if ((i7 & 599187) == 599186) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Arrangement arrangement22 = Arrangement.INSTANCE;
        Arrangement.Vertical top22 = arrangement22.getTop();
        Alignment.Companion companion42 = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(top22, companion42.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor32 = companion222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion222.getSetModifier());
        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(1317171456);
        if (z13) {
        }
        composer2.endReplaceGroup();
        composer3 = composer2;
        composer3.startReplaceGroup(1317178787);
        if (z5) {
        }
        composer3.endReplaceGroup();
        composer3.startReplaceGroup(1317196368);
        if (function1 != null) {
        }
        composer3.endReplaceGroup();
        composer3.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z14 = z16;
        z15 = z13;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddressView$lambda$3$lambda$1$lambda$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddressView$lambda$4(Modifier modifier, String str, boolean z5, boolean z6, boolean z7, boolean z8, Function1 function1, int i5, int i6, Composer composer, int i7) {
        AddressView(modifier, str, z5, z6, z7, z8, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
