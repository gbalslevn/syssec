package dk.molslinjen.ui.views.screens.booking.shared;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutButtonSheetBottomBarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a{\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "buttonTitle", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "totalPrice", BuildConfig.FLAVOR, "isEditing", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "enabled", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showDetails", "onClickDisabled", "onClick", "CheckoutButtonSheetBottomBar", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ldk/molslinjen/domain/managers/checkout/PriceTotal;ZLdk/molslinjen/domain/model/booking/PassengerInfo;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutButtonSheetBottomBarKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CheckoutButtonSheetBottomBar(Modifier modifier, final String buttonTitle, final PriceTotal priceTotal, final boolean z5, PassengerInfo passengerInfo, boolean z6, Function0<Unit> function0, Function0<Unit> function02, final Function0<Unit> onClick, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        int i8;
        final boolean z7;
        int i9;
        int i10;
        final Function0<Unit> function03;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        boolean z8;
        Object rememberedValue;
        Composer composer2;
        final Function0<Unit> function04;
        final PassengerInfo passengerInfo2;
        final Modifier modifier3;
        final Function0<Unit> function05;
        ScopeUpdateScope endRestartGroup;
        int i11;
        Intrinsics.checkNotNullParameter(buttonTitle, "buttonTitle");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-614777174);
        int i12 = i6 & 1;
        if (i12 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i5 & 6) == 0) {
                i7 = i5 | (startRestartGroup.changed(modifier2) ? 4 : 2);
            } else {
                i7 = i5;
            }
        }
        if ((2 & i6) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(buttonTitle) ? 32 : 16;
        }
        int i13 = i7;
        if ((4 & i6) != 0) {
            i13 |= 384;
        } else if ((i5 & 384) == 0) {
            i13 |= startRestartGroup.changedInstance(priceTotal) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i13 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i13 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        int i14 = 16 & i6;
        if (i14 != 0) {
            i13 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i13 |= startRestartGroup.changedInstance(passengerInfo) ? 16384 : 8192;
            i8 = 32 & i6;
            if (i8 == 0) {
                i13 |= 196608;
                z7 = z6;
            } else {
                z7 = z6;
                if ((i5 & 196608) == 0) {
                    i13 |= startRestartGroup.changed(z7) ? 131072 : 65536;
                }
            }
            i9 = i6 & 64;
            if (i9 == 0) {
                i13 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i13 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
            }
            i10 = 128 & i6;
            if (i10 == 0) {
                i11 = (i5 & 12582912) == 0 ? startRestartGroup.changedInstance(function02) ? 8388608 : 4194304 : 12582912;
                if ((256 & i6) != 0) {
                    i13 |= 100663296;
                } else if ((i5 & 100663296) == 0) {
                    i13 |= startRestartGroup.changedInstance(onClick) ? 67108864 : 33554432;
                }
                if ((38347923 & i13) == 38347922 || !startRestartGroup.getSkipping()) {
                    Modifier modifier4 = i12 != 0 ? Modifier.INSTANCE : modifier2;
                    PassengerInfo passengerInfo3 = i14 != 0 ? null : passengerInfo;
                    boolean z9 = i8 != 0 ? true : z7;
                    function03 = i9 != 0 ? null : function0;
                    Function0<Unit> function06 = i10 != 0 ? null : function02;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-614777174, i13, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutButtonSheetBottomBar (CheckoutButtonSheetBottomBar.kt:52)");
                    }
                    Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(modifier4, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
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
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    startRestartGroup.startReplaceGroup(2018354216);
                    z8 = (i13 & 3670016) == 1048576;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: a3.a
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0;
                                CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0 = CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0(Function0.this);
                                return CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    FlowLayoutKt.FlowRow(ClickableKt.m122clickableXHw0xAI$default(companion2, false, null, null, (Function0) rememberedValue, 7, null), null, null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(263692741, true, new CheckoutButtonSheetBottomBarKt$CheckoutButtonSheetBottomBar$1$2(function03, passengerInfo3, z5, priceTotal), startRestartGroup, 54), startRestartGroup, 1572864, 62);
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, Dp.m2599constructorimpl((float) 0.5d), null, startRestartGroup, 384, 11);
                    int i15 = i13 >> 3;
                    Function0<Unit> function07 = function03;
                    PassengerInfo passengerInfo4 = passengerInfo3;
                    composer2 = startRestartGroup;
                    BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(buttonTitle, null, z9, false, false, 0L, function06, onClick, startRestartGroup, (3670016 & i15) | (i15 & 14) | ((i13 >> 9) & 896) | (i15 & 29360128), 58);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function04 = function07;
                    passengerInfo2 = passengerInfo4;
                    modifier3 = modifier4;
                    z7 = z9;
                    function05 = function06;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    passengerInfo2 = passengerInfo;
                    function05 = function02;
                    modifier3 = modifier2;
                    composer2 = startRestartGroup;
                    function04 = function0;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: a3.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit CheckoutButtonSheetBottomBar$lambda$3;
                            CheckoutButtonSheetBottomBar$lambda$3 = CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar$lambda$3(Modifier.this, buttonTitle, priceTotal, z5, passengerInfo2, z7, function04, function05, onClick, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return CheckoutButtonSheetBottomBar$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            i13 |= i11;
            if ((256 & i6) != 0) {
            }
            if ((38347923 & i13) == 38347922) {
            }
            if (i12 != 0) {
            }
            if (i14 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(modifier4, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion22 = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(2018354216);
            if ((i13 & 3670016) == 1048576) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z8) {
            }
            rememberedValue = new Function0() { // from class: a3.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0;
                    CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0 = CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0(Function0.this);
                    return CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            FlowLayoutKt.FlowRow(ClickableKt.m122clickableXHw0xAI$default(companion22, false, null, null, (Function0) rememberedValue, 7, null), null, null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(263692741, true, new CheckoutButtonSheetBottomBarKt$CheckoutButtonSheetBottomBar$1$2(function03, passengerInfo3, z5, priceTotal), startRestartGroup, 54), startRestartGroup, 1572864, 62);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, Dp.m2599constructorimpl((float) 0.5d), null, startRestartGroup, 384, 11);
            int i152 = i13 >> 3;
            Function0<Unit> function072 = function03;
            PassengerInfo passengerInfo42 = passengerInfo3;
            composer2 = startRestartGroup;
            BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(buttonTitle, null, z9, false, false, 0L, function06, onClick, startRestartGroup, (3670016 & i152) | (i152 & 14) | ((i13 >> 9) & 896) | (i152 & 29360128), 58);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function04 = function072;
            passengerInfo2 = passengerInfo42;
            modifier3 = modifier4;
            z7 = z9;
            function05 = function06;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = 32 & i6;
        if (i8 == 0) {
        }
        i9 = i6 & 64;
        if (i9 == 0) {
        }
        i10 = 128 & i6;
        if (i10 == 0) {
        }
        i13 |= i11;
        if ((256 & i6) != 0) {
        }
        if ((38347923 & i13) == 38347922) {
        }
        if (i12 != 0) {
        }
        if (i14 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m104backgroundbw27NRU$default22 = BackgroundKt.m104backgroundbw27NRU$default(modifier4, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default22);
        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion32.getSetModifier());
        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
        Modifier.Companion companion222 = Modifier.INSTANCE;
        startRestartGroup.startReplaceGroup(2018354216);
        if ((i13 & 3670016) == 1048576) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z8) {
        }
        rememberedValue = new Function0() { // from class: a3.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0;
                CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0 = CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0(Function0.this);
                return CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        FlowLayoutKt.FlowRow(ClickableKt.m122clickableXHw0xAI$default(companion222, false, null, null, (Function0) rememberedValue, 7, null), null, null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(263692741, true, new CheckoutButtonSheetBottomBarKt$CheckoutButtonSheetBottomBar$1$2(function03, passengerInfo3, z5, priceTotal), startRestartGroup, 54), startRestartGroup, 1572864, 62);
        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, Dp.m2599constructorimpl((float) 0.5d), null, startRestartGroup, 384, 11);
        int i1522 = i13 >> 3;
        Function0<Unit> function0722 = function03;
        PassengerInfo passengerInfo422 = passengerInfo3;
        composer2 = startRestartGroup;
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(buttonTitle, null, z9, false, false, 0L, function06, onClick, startRestartGroup, (3670016 & i1522) | (i1522 & 14) | ((i13 >> 9) & 896) | (i1522 & 29360128), 58);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function04 = function0722;
        passengerInfo2 = passengerInfo422;
        modifier3 = modifier4;
        z7 = z9;
        function05 = function06;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutButtonSheetBottomBar$lambda$2$lambda$1$lambda$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutButtonSheetBottomBar$lambda$3(Modifier modifier, String str, PriceTotal priceTotal, boolean z5, PassengerInfo passengerInfo, boolean z6, Function0 function0, Function0 function02, Function0 function03, int i5, int i6, Composer composer, int i7) {
        CheckoutButtonSheetBottomBar(modifier, str, priceTotal, z5, passengerInfo, z6, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
