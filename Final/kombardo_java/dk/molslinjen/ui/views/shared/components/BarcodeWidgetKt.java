package dk.molslinjen.ui.views.shared.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewKt;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidityViewKt;
import dk.molslinjen.ui.views.shared.components.BarcodeWidgetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aa\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032*\u0010\t\u001a&\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b2\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f*J\u0010\r\"\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\"\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¨\u0006\u000e"}, d2 = {BuildConfig.FLAVOR, "barcode", "barcodeDescription", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "type", "Lkotlin/Function4;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/shared/components/ExpandBarcodeCallback;", "expandBarcode", "barcodeValidity", "BarcodeWidget", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;Lkotlin/jvm/functions/Function4;Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;Landroidx/compose/runtime/Composer;II)V", "ExpandBarcodeCallback", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BarcodeWidgetKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BarcodeViewType.values().length];
            try {
                iArr[BarcodeViewType.QR_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0369  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BarcodeWidget(final String barcode, final String str, BarcodeViewType barcodeViewType, final Function4<? super String, ? super String, ? super BarcodeViewType, ? super BarcodeValidity, Unit> expandBarcode, BarcodeValidity barcodeValidity, Composer composer, final int i5, final int i6) {
        int i7;
        BarcodeViewType barcodeViewType2;
        int i8;
        BarcodeValidity barcodeValidity2;
        BarcodeValidity barcodeValidity3;
        boolean z5;
        Object rememberedValue;
        int i9;
        ?? r14;
        Object obj;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        int i10;
        Object rememberedValue2;
        Composer.Companion companion;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        BarcodeViewType barcodeViewType3;
        Composer composer3;
        final BarcodeValidity barcodeValidity4;
        final BarcodeViewType barcodeViewType4;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(expandBarcode, "expandBarcode");
        Composer startRestartGroup = composer.startRestartGroup(-1648932516);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(barcode) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i11 = i6 & 4;
        if (i11 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            barcodeViewType2 = barcodeViewType;
            i7 |= startRestartGroup.changed(barcodeViewType2) ? 256 : 128;
            if ((i6 & 8) == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i7 |= startRestartGroup.changedInstance(expandBarcode) ? 2048 : 1024;
            }
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                barcodeValidity2 = barcodeValidity;
                i7 |= startRestartGroup.changed(barcodeValidity2) ? 16384 : 8192;
                if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    if (i11 != 0) {
                        barcodeViewType2 = BarcodeViewType.CODE_128;
                    }
                    barcodeValidity3 = i8 != 0 ? BarcodeValidity.Valid : barcodeValidity2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1648932516, i7, -1, "dk.molslinjen.ui.views.shared.components.BarcodeWidget (BarcodeWidget.kt:46)");
                    }
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getMedium());
                    startRestartGroup.startReplaceGroup(2055389660);
                    int i12 = i7 & 14;
                    z5 = ((i7 & 7168) == 2048) | (i12 == 4) | ((i7 & 112) == 32) | ((i7 & 896) == 256) | ((57344 & i7) == 16384);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        i9 = i7;
                        r14 = 0;
                        obj = null;
                        final BarcodeViewType barcodeViewType5 = barcodeViewType2;
                        final BarcodeValidity barcodeValidity5 = barcodeValidity3;
                        Function0 function0 = new Function0() { // from class: w4.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit BarcodeWidget$lambda$1$lambda$0;
                                BarcodeWidget$lambda$1$lambda$0 = BarcodeWidgetKt.BarcodeWidget$lambda$1$lambda$0(Function4.this, barcode, str, barcodeViewType5, barcodeValidity5);
                                return BarcodeWidget$lambda$1$lambda$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(function0);
                        rememberedValue = function0;
                    } else {
                        i9 = i7;
                        obj = null;
                        r14 = 0;
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue, 7, null);
                    AppColor appColor = AppColor.INSTANCE;
                    float f5 = 16;
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(BackgroundKt.m104backgroundbw27NRU$default(m122clickableXHw0xAI$default, appColor.m3269getGrey60d7_KjU(), null, 2, null), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), r14);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r14);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, obj);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getCenterHorizontally(), startRestartGroup, 48);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(762500509);
                    if (str == null) {
                        i10 = 2;
                    } else {
                        i10 = 2;
                        TextKt.m940Text4IGK_g(str, PaddingKt.m313paddingVpY3zN4$default(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
                        Unit unit = Unit.INSTANCE;
                    }
                    startRestartGroup.endReplaceGroup();
                    int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                    float m2599constructorimpl = iArr[barcodeViewType2.ordinal()] == 1 ? Dp.m2599constructorimpl(200) : Dp.m2599constructorimpl(200);
                    float m2599constructorimpl2 = iArr[barcodeViewType2.ordinal()] == 1 ? m2599constructorimpl : Dp.m2599constructorimpl(80);
                    startRestartGroup.startReplaceGroup(762520568);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: w4.g
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                Unit BarcodeWidget$lambda$8$lambda$7$lambda$4$lambda$3;
                                BarcodeWidget$lambda$8$lambda$7$lambda$4$lambda$3 = BarcodeWidgetKt.BarcodeWidget$lambda$8$lambda$7$lambda$4$lambda$3((SemanticsPropertyReceiver) obj2);
                                return BarcodeWidget$lambda$8$lambda$7$lambda$4$lambda$3;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    BarcodeValidity barcodeValidity6 = barcodeValidity3;
                    BarcodeViewKt.m3395BarcodeViewYlGCr2M(PaddingKt.m313paddingVpY3zN4$default(SizeKt.m325height3ABfNKs(columnScopeInstance.align(SemanticsModifierKt.clearAndSetSemantics(companion2, (Function1) rememberedValue2), companion3.getCenterHorizontally()), m2599constructorimpl2), Dp.m2599constructorimpl(f5), 0.0f, i10, null), false, 0, m2599constructorimpl, m2599constructorimpl2, barcodeViewType2, barcode, startRestartGroup, ((i9 << 9) & 458752) | ((i9 << 18) & 3670016), 6);
                    startRestartGroup.startReplaceGroup(762530615);
                    if (barcodeViewType2 != BarcodeViewType.QR_CODE) {
                        Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), Dp.m2599constructorimpl(f5), 0.0f, i10, null);
                        startRestartGroup.startReplaceGroup(762537768);
                        boolean z6 = i12 == 4;
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (z6 || rememberedValue3 == companion.getEmpty()) {
                            rememberedValue3 = new Function1() { // from class: w4.h
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    Unit BarcodeWidget$lambda$8$lambda$7$lambda$6$lambda$5;
                                    BarcodeWidget$lambda$8$lambda$7$lambda$6$lambda$5 = BarcodeWidgetKt.BarcodeWidget$lambda$8$lambda$7$lambda$6$lambda$5(barcode, (SemanticsPropertyReceiver) obj2);
                                    return BarcodeWidget$lambda$8$lambda$7$lambda$6$lambda$5;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceGroup();
                        barcodeViewType3 = barcodeViewType2;
                        boxScopeInstance = boxScopeInstance2;
                        composer2 = startRestartGroup;
                        TextKt.m940Text4IGK_g(barcode, SemanticsModifierKt.semantics$default(m313paddingVpY3zN4$default, false, (Function1) rememberedValue3, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, i12, 1572864, 65532);
                    } else {
                        boxScopeInstance = boxScopeInstance2;
                        composer2 = startRestartGroup;
                        barcodeViewType3 = barcodeViewType2;
                    }
                    composer2.endReplaceGroup();
                    composer3 = composer2;
                    BarcodeValidityViewKt.BarcodeValidityView(false, barcodeValidity6, composer3, (i9 >> 9) & 112, 1);
                    composer3.endNode();
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_expand_barcode, composer3, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_zoomBarcode, composer3, 6), boxScopeInstance.align(SizeKt.m331size3ABfNKs(PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(f5), 0.0f, 2, null), Dp.m2599constructorimpl(f5)), companion3.getTopEnd()), appColor.m3253getBrandBlack10d7_KjU(), composer3, 3072, 0);
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    barcodeValidity4 = barcodeValidity6;
                    barcodeViewType4 = barcodeViewType3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    barcodeValidity4 = barcodeValidity2;
                    composer3 = startRestartGroup;
                    barcodeViewType4 = barcodeViewType2;
                }
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: w4.i
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit BarcodeWidget$lambda$9;
                            BarcodeWidget$lambda$9 = BarcodeWidgetKt.BarcodeWidget$lambda$9(barcode, str, barcodeViewType4, expandBarcode, barcodeValidity4, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                            return BarcodeWidget$lambda$9;
                        }
                    });
                    return;
                }
                return;
            }
            barcodeValidity2 = barcodeValidity;
            if ((i7 & 9363) == 9362) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier.Companion companion22 = Modifier.INSTANCE;
            Modifier clip2 = ClipKt.clip(SizeKt.fillMaxWidth$default(companion22, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getMedium());
            startRestartGroup.startReplaceGroup(2055389660);
            int i122 = i7 & 14;
            z5 = ((i7 & 7168) == 2048) | (i122 == 4) | ((i7 & 112) == 32) | ((i7 & 896) == 256) | ((57344 & i7) == 16384);
            rememberedValue = startRestartGroup.rememberedValue();
            if (z5) {
            }
            i9 = i7;
            r14 = 0;
            obj = null;
            final BarcodeViewType barcodeViewType52 = barcodeViewType2;
            final BarcodeValidity barcodeValidity52 = barcodeValidity3;
            Function0 function02 = new Function0() { // from class: w4.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit BarcodeWidget$lambda$1$lambda$0;
                    BarcodeWidget$lambda$1$lambda$0 = BarcodeWidgetKt.BarcodeWidget$lambda$1$lambda$0(Function4.this, barcode, str, barcodeViewType52, barcodeValidity52);
                    return BarcodeWidget$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(function02);
            rememberedValue = function02;
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(clip2, false, null, null, (Function0) rememberedValue, 7, null);
            AppColor appColor2 = AppColor.INSTANCE;
            float f52 = 16;
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(BackgroundKt.m104backgroundbw27NRU$default(m122clickableXHw0xAI$default2, appColor2.m3269getGrey60d7_KjU(), null, 2, null), 0.0f, Dp.m2599constructorimpl(f52), 0.0f, 0.0f, 13, null);
            Alignment.Companion companion32 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion32.getTopStart(), r14);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r14);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
            ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor3 = companion42.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion42.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion42.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion42.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion42.getSetModifier());
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion22, 0.0f, 1, obj);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion32.getCenterHorizontally(), startRestartGroup, 48);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default2);
            Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion42.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion42.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(762500509);
            if (str == null) {
            }
            startRestartGroup.endReplaceGroup();
            int[] iArr2 = WhenMappings.$EnumSwitchMapping$0;
            float m2599constructorimpl3 = iArr2[barcodeViewType2.ordinal()] == 1 ? Dp.m2599constructorimpl(200) : Dp.m2599constructorimpl(200);
            if (iArr2[barcodeViewType2.ordinal()] == 1) {
            }
            startRestartGroup.startReplaceGroup(762520568);
            rememberedValue2 = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            BarcodeValidity barcodeValidity62 = barcodeValidity3;
            BarcodeViewKt.m3395BarcodeViewYlGCr2M(PaddingKt.m313paddingVpY3zN4$default(SizeKt.m325height3ABfNKs(columnScopeInstance2.align(SemanticsModifierKt.clearAndSetSemantics(companion22, (Function1) rememberedValue2), companion32.getCenterHorizontally()), m2599constructorimpl2), Dp.m2599constructorimpl(f52), 0.0f, i10, null), false, 0, m2599constructorimpl3, m2599constructorimpl2, barcodeViewType2, barcode, startRestartGroup, ((i9 << 9) & 458752) | ((i9 << 18) & 3670016), 6);
            startRestartGroup.startReplaceGroup(762530615);
            if (barcodeViewType2 != BarcodeViewType.QR_CODE) {
            }
            composer2.endReplaceGroup();
            composer3 = composer2;
            BarcodeValidityViewKt.BarcodeValidityView(false, barcodeValidity62, composer3, (i9 >> 9) & 112, 1);
            composer3.endNode();
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_expand_barcode, composer3, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_zoomBarcode, composer3, 6), boxScopeInstance.align(SizeKt.m331size3ABfNKs(PaddingKt.m313paddingVpY3zN4$default(companion22, Dp.m2599constructorimpl(f52), 0.0f, 2, null), Dp.m2599constructorimpl(f52)), companion32.getTopEnd()), appColor2.m3253getBrandBlack10d7_KjU(), composer3, 3072, 0);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            barcodeValidity4 = barcodeValidity62;
            barcodeViewType4 = barcodeViewType3;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        barcodeViewType2 = barcodeViewType;
        if ((i6 & 8) == 0) {
        }
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        barcodeValidity2 = barcodeValidity;
        if ((i7 & 9363) == 9362) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion222 = Modifier.INSTANCE;
        Modifier clip22 = ClipKt.clip(SizeKt.fillMaxWidth$default(companion222, 0.0f, 1, null), ThemeShapesKt.getThemeShapes().getMedium());
        startRestartGroup.startReplaceGroup(2055389660);
        int i1222 = i7 & 14;
        z5 = ((i7 & 7168) == 2048) | (i1222 == 4) | ((i7 & 112) == 32) | ((i7 & 896) == 256) | ((57344 & i7) == 16384);
        rememberedValue = startRestartGroup.rememberedValue();
        if (z5) {
        }
        i9 = i7;
        r14 = 0;
        obj = null;
        final BarcodeViewType barcodeViewType522 = barcodeViewType2;
        final BarcodeValidity barcodeValidity522 = barcodeValidity3;
        Function0 function022 = new Function0() { // from class: w4.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit BarcodeWidget$lambda$1$lambda$0;
                BarcodeWidget$lambda$1$lambda$0 = BarcodeWidgetKt.BarcodeWidget$lambda$1$lambda$0(Function4.this, barcode, str, barcodeViewType522, barcodeValidity522);
                return BarcodeWidget$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(function022);
        rememberedValue = function022;
        startRestartGroup.endReplaceGroup();
        Modifier m122clickableXHw0xAI$default22 = ClickableKt.m122clickableXHw0xAI$default(clip22, false, null, null, (Function0) rememberedValue, 7, null);
        AppColor appColor22 = AppColor.INSTANCE;
        float f522 = 16;
        Modifier m315paddingqDBjuR0$default22 = PaddingKt.m315paddingqDBjuR0$default(BackgroundKt.m104backgroundbw27NRU$default(m122clickableXHw0xAI$default22, appColor22.m3269getGrey60d7_KjU(), null, 2, null), 0.0f, Dp.m2599constructorimpl(f522), 0.0f, 0.0f, 13, null);
        Alignment.Companion companion322 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion322.getTopStart(), r14);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, r14);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default22);
        ComposeUiNode.Companion companion422 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor32 = companion422.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion422.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion422.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion422.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion422.getSetModifier());
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        Modifier fillMaxWidth$default22 = SizeKt.fillMaxWidth$default(companion222, 0.0f, 1, obj);
        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion322.getCenterHorizontally(), startRestartGroup, 48);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default22);
        Function0<ComposeUiNode> constructor222 = companion422.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy22, companion422.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion422.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion422.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion422.getSetModifier());
        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(762500509);
        if (str == null) {
        }
        startRestartGroup.endReplaceGroup();
        int[] iArr22 = WhenMappings.$EnumSwitchMapping$0;
        float m2599constructorimpl32 = iArr22[barcodeViewType2.ordinal()] == 1 ? Dp.m2599constructorimpl(200) : Dp.m2599constructorimpl(200);
        if (iArr22[barcodeViewType2.ordinal()] == 1) {
        }
        startRestartGroup.startReplaceGroup(762520568);
        rememberedValue2 = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        BarcodeValidity barcodeValidity622 = barcodeValidity3;
        BarcodeViewKt.m3395BarcodeViewYlGCr2M(PaddingKt.m313paddingVpY3zN4$default(SizeKt.m325height3ABfNKs(columnScopeInstance22.align(SemanticsModifierKt.clearAndSetSemantics(companion222, (Function1) rememberedValue2), companion322.getCenterHorizontally()), m2599constructorimpl2), Dp.m2599constructorimpl(f522), 0.0f, i10, null), false, 0, m2599constructorimpl32, m2599constructorimpl2, barcodeViewType2, barcode, startRestartGroup, ((i9 << 9) & 458752) | ((i9 << 18) & 3670016), 6);
        startRestartGroup.startReplaceGroup(762530615);
        if (barcodeViewType2 != BarcodeViewType.QR_CODE) {
        }
        composer2.endReplaceGroup();
        composer3 = composer2;
        BarcodeValidityViewKt.BarcodeValidityView(false, barcodeValidity622, composer3, (i9 >> 9) & 112, 1);
        composer3.endNode();
        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_expand_barcode, composer3, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_zoomBarcode, composer3, 6), boxScopeInstance.align(SizeKt.m331size3ABfNKs(PaddingKt.m313paddingVpY3zN4$default(companion222, Dp.m2599constructorimpl(f522), 0.0f, 2, null), Dp.m2599constructorimpl(f522)), companion322.getTopEnd()), appColor22.m3253getBrandBlack10d7_KjU(), composer3, 3072, 0);
        composer3.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        barcodeValidity4 = barcodeValidity622;
        barcodeViewType4 = barcodeViewType3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeWidget$lambda$1$lambda$0(Function4 function4, String str, String str2, BarcodeViewType barcodeViewType, BarcodeValidity barcodeValidity) {
        function4.invoke(str, str2, barcodeViewType, barcodeValidity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeWidget$lambda$8$lambda$7$lambda$4$lambda$3(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeWidget$lambda$8$lambda$7$lambda$6$lambda$5(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, CollectionsKt.joinToString$default(StringsKt.chunked(str, 2), " ", null, null, 0, null, null, 62, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarcodeWidget$lambda$9(String str, String str2, BarcodeViewType barcodeViewType, Function4 function4, BarcodeValidity barcodeValidity, int i5, int i6, Composer composer, int i7) {
        BarcodeWidget(str, str2, barcodeViewType, function4, barcodeValidity, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
