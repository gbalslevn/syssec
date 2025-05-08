package dk.molslinjen.ui.views.reusable.bottomsheet;

import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.ScrollableStateExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0099\u0001\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0099\u0001\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u0011H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001f²\u0006\u000e\u0010\u001c\u001a\u00020\u001b8\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u001e\u001a\u00020\u001d8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/unit/Dp;", "minHeight", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "Ldk/molslinjen/ui/views/reusable/bottomsheet/BottomSheetTitleStyle;", "titleStyle", "Landroidx/compose/ui/graphics/Color;", "headerBackgroundColor", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onBackAction", "onCloseAction", "Landroidx/compose/foundation/gestures/ScrollableState;", "scrollState", "stickyFooter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "content", "BottomSheetContainer-ZO57_FM", "(Landroidx/compose/ui/Modifier;FLjava/lang/String;Ldk/molslinjen/ui/views/reusable/bottomsheet/BottomSheetTitleStyle;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/ScrollableState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetContainer", "Landroidx/compose/ui/text/AnnotatedString;", "annotatedTitle", "BottomSheetContainer-8Un_QVk", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/text/AnnotatedString;Ldk/molslinjen/ui/views/reusable/bottomsheet/BottomSheetTitleStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/gestures/ScrollableState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "stickyFooterHeight", BuildConfig.FLAVOR, "elevation", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BottomSheetContainerKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0366 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x033f  */
    /* renamed from: BottomSheetContainer-8Un_QVk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3398BottomSheetContainer8Un_QVk(Modifier modifier, float f5, long j5, AnnotatedString annotatedString, BottomSheetTitleStyle bottomSheetTitleStyle, Function0<Unit> function0, Function0<Unit> function02, ScrollableState scrollableState, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Object rememberedValue;
        Composer.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Object rememberedValue2;
        Object rememberedValue3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        boolean z5;
        int i13;
        Object rememberedValue4;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        Function0<Unit> function03;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScrollableState scrollableState2;
        final Modifier modifier3;
        final AnnotatedString annotatedString2;
        final float f6;
        final BottomSheetTitleStyle bottomSheetTitleStyle2;
        final ScrollableState scrollableState3;
        final Function0<Unit> function04;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1597297734);
        int i16 = i6 & 1;
        if (i16 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        int i17 = 2 & i6;
        if (i17 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(f5) ? 32 : 16;
        }
        int i18 = 4 & i6;
        if (i18 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(j5) ? 256 : 128;
        }
        int i19 = i6 & 8;
        if (i19 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(annotatedString) ? 2048 : 1024;
            i8 = 16 & i6;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changed(bottomSheetTitleStyle) ? 16384 : 8192;
                i9 = 32 & i6;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i7 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                    i15 = (i5 & 1572864) == 0 ? startRestartGroup.changedInstance(function02) ? 1048576 : 524288 : 1572864;
                    i11 = 128 & i6;
                    if (i11 == 0) {
                        i14 = (i5 & 12582912) == 0 ? startRestartGroup.changedInstance(scrollableState) ? 8388608 : 4194304 : 12582912;
                        i12 = 256 & i6;
                        if (i12 != 0) {
                            i7 |= 100663296;
                        } else if ((i5 & 100663296) == 0) {
                            i7 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                        }
                        if ((i6 & 512) != 0) {
                            i7 |= 805306368;
                        } else if ((i5 & 805306368) == 0) {
                            i7 |= startRestartGroup.changedInstance(content) ? 536870912 : 268435456;
                        }
                        if ((306783379 & i7) == 306783378 || !startRestartGroup.getSkipping()) {
                            Modifier modifier4 = i16 != 0 ? Modifier.INSTANCE : modifier2;
                            float m2608getUnspecifiedD9Ej5fM = i17 != 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : f5;
                            long m3281getWhite0d7_KjU = i18 != 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j5;
                            AnnotatedString annotatedString3 = i19 != 0 ? null : annotatedString;
                            BottomSheetTitleStyle bottomSheetTitleStyle3 = i8 != 0 ? BottomSheetTitleStyle.Standard : bottomSheetTitleStyle;
                            Function0<Unit> function05 = i9 != 0 ? null : function0;
                            Function0<Unit> function06 = i10 != 0 ? null : function02;
                            final ScrollableState scrollableState4 = i11 != 0 ? null : scrollableState;
                            Function2<? super Composer, ? super Integer, Unit> function24 = i12 != 0 ? null : function2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1597297734, i7, -1, "dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainer (BottomSheetContainer.kt:70)");
                            }
                            startRestartGroup.startReplaceGroup(254291053);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            function22 = function24;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            MutableIntState mutableIntState = (MutableIntState) rememberedValue;
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(254295349);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                final float f7 = 20.0f;
                                final float f8 = 4.0f;
                                rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: Y1.c
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        float BottomSheetContainer_8Un_QVk$lambda$6$lambda$5;
                                        BottomSheetContainer_8Un_QVk$lambda$6$lambda$5 = BottomSheetContainerKt.BottomSheetContainer_8Un_QVk$lambda$6$lambda$5(ScrollableState.this, f7, f8);
                                        return Float.valueOf(BottomSheetContainer_8Un_QVk$lambda$6$lambda$5);
                                    }
                                });
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            State state = (State) rememberedValue2;
                            startRestartGroup.endReplaceGroup();
                            boolean isImeVisible = WindowInsets_androidKt.isImeVisible(WindowInsets.INSTANCE, startRestartGroup, 6);
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            ScrollableState scrollableState5 = scrollableState4;
                            Modifier m326heightInVpY3zN4 = SizeKt.m326heightInVpY3zN4(companion2, m2608getUnspecifiedD9Ej5fM, Dp.m2599constructorimpl(((Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp));
                            float f9 = m2608getUnspecifiedD9Ej5fM;
                            startRestartGroup.startReplaceGroup(254309159);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            Modifier modifier5 = modifier4;
                            if (rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new Function1() { // from class: Y1.d
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit BottomSheetContainer_8Un_QVk$lambda$9$lambda$8;
                                        BottomSheetContainer_8Un_QVk$lambda$9$lambda$8 = BottomSheetContainerKt.BottomSheetContainer_8Un_QVk$lambda$9$lambda$8((SemanticsPropertyReceiver) obj);
                                        return BottomSheetContainer_8Un_QVk$lambda$9$lambda$8;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceGroup();
                            long j7 = m3281getWhite0d7_KjU;
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(m326heightInVpY3zN4, false, (Function1) rememberedValue3, 1, null);
                            Alignment.Companion companion3 = Alignment.INSTANCE;
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                            BottomSheetTitleStyle bottomSheetTitleStyle4 = bottomSheetTitleStyle3;
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
                            int i20 = i7;
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            startRestartGroup.startReplaceGroup(1908601344);
                            float m2599constructorimpl = isImeVisible ? Dp.m2599constructorimpl(0) : ComposeExtensionsKt.pxToDp(mutableIntState.getIntValue(), startRestartGroup, 0);
                            startRestartGroup.endReplaceGroup();
                            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, m2599constructorimpl, 7, null);
                            Arrangement arrangement = Arrangement.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
                            z5 = (annotatedString3 != null && function05 == null && function06 == null) ? false : true;
                            startRestartGroup.startReplaceGroup(565343665);
                            if (z5) {
                                i13 = i20;
                                int i21 = i13 >> 3;
                                BottomSheetHeaderKt.m3400BottomSheetHeaderuKGXYA(annotatedString3, bottomSheetTitleStyle4, j7, Dp.m2599constructorimpl(BottomSheetContainer_8Un_QVk$lambda$7(state)), function05, function06, startRestartGroup, ((i20 >> 9) & 126) | (i13 & 896) | (57344 & i21) | (i21 & 458752), 0);
                            } else {
                                i13 = i20;
                            }
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(565358035);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == companion.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: Y1.e
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit BottomSheetContainer_8Un_QVk$lambda$19$lambda$13$lambda$11$lambda$10;
                                        BottomSheetContainer_8Un_QVk$lambda$19$lambda$13$lambda$11$lambda$10 = BottomSheetContainerKt.BottomSheetContainer_8Un_QVk$lambda$19$lambda$13$lambda$11$lambda$10((SemanticsPropertyReceiver) obj);
                                        return BottomSheetContainer_8Un_QVk$lambda$19$lambda$13$lambda$11$lambda$10;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier semantics$default2 = SemanticsModifierKt.semantics$default(modifier5, false, (Function1) rememberedValue4, 1, null);
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default2);
                            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor3);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                            function03 = function06;
                            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                            if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                            content.invoke(columnScopeInstance, startRestartGroup, Integer.valueOf(((i13 >> 24) & 112) | 6));
                            startRestartGroup.endNode();
                            startRestartGroup.endNode();
                            startRestartGroup.startReplaceGroup(1908629374);
                            if (function22 == null) {
                                function23 = function22;
                                scrollableState2 = scrollableState5;
                            } else {
                                Modifier align = boxScopeInstance.align(companion2, companion3.getBottomCenter());
                                boolean z6 = !isImeVisible;
                                startRestartGroup.startReplaceGroup(565370448);
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (rememberedValue5 == companion.getEmpty()) {
                                    rememberedValue5 = new Function1() { // from class: Y1.f
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            int BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$15$lambda$14;
                                            BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$15$lambda$14 = BottomSheetContainerKt.BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$15$lambda$14(((Integer) obj).intValue());
                                            return Integer.valueOf(BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$15$lambda$14);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                startRestartGroup.endReplaceGroup();
                                EnterTransition slideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) rememberedValue5, 1, null);
                                startRestartGroup.startReplaceGroup(565372048);
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (rememberedValue6 == companion.getEmpty()) {
                                    rememberedValue6 = new Function1() { // from class: Y1.g
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            int BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$17$lambda$16;
                                            BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$17$lambda$16 = BottomSheetContainerKt.BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$17$lambda$16(((Integer) obj).intValue());
                                            return Integer.valueOf(BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$17$lambda$16);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                startRestartGroup.endReplaceGroup();
                                function23 = function22;
                                scrollableState2 = scrollableState5;
                                AnimatedVisibilityKt.AnimatedVisibility(z6, align, slideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) rememberedValue6, 1, null), null, ComposableLambdaKt.rememberComposableLambda(654420022, true, new BottomSheetContainerKt$BottomSheetContainer$4$2$3(scrollableState2, mutableIntState, function23), startRestartGroup, 54), startRestartGroup, 200064, 16);
                                Unit unit = Unit.INSTANCE;
                            }
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier5;
                            annotatedString2 = annotatedString3;
                            f6 = f9;
                            bottomSheetTitleStyle2 = bottomSheetTitleStyle4;
                            scrollableState3 = scrollableState2;
                            function04 = function05;
                            j6 = j7;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            f6 = f5;
                            j6 = j5;
                            annotatedString2 = annotatedString;
                            bottomSheetTitleStyle2 = bottomSheetTitleStyle;
                            function04 = function0;
                            function03 = function02;
                            scrollableState3 = scrollableState;
                            function23 = function2;
                            modifier3 = modifier2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Function0<Unit> function07 = function03;
                            endRestartGroup.updateScope(new Function2() { // from class: Y1.h
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit BottomSheetContainer_8Un_QVk$lambda$20;
                                    BottomSheetContainer_8Un_QVk$lambda$20 = BottomSheetContainerKt.BottomSheetContainer_8Un_QVk$lambda$20(Modifier.this, f6, j6, annotatedString2, bottomSheetTitleStyle2, function04, function07, scrollableState3, function23, content, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return BottomSheetContainer_8Un_QVk$lambda$20;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i7 |= i14;
                    i12 = 256 & i6;
                    if (i12 != 0) {
                    }
                    if ((i6 & 512) != 0) {
                    }
                    if ((306783379 & i7) == 306783378) {
                    }
                    if (i16 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
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
                    startRestartGroup.startReplaceGroup(254291053);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    function22 = function24;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    MutableIntState mutableIntState2 = (MutableIntState) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(254295349);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    State state2 = (State) rememberedValue2;
                    startRestartGroup.endReplaceGroup();
                    boolean isImeVisible2 = WindowInsets_androidKt.isImeVisible(WindowInsets.INSTANCE, startRestartGroup, 6);
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    ScrollableState scrollableState52 = scrollableState4;
                    Modifier m326heightInVpY3zN42 = SizeKt.m326heightInVpY3zN4(companion22, m2608getUnspecifiedD9Ej5fM, Dp.m2599constructorimpl(((Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp));
                    float f92 = m2608getUnspecifiedD9Ej5fM;
                    startRestartGroup.startReplaceGroup(254309159);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    Modifier modifier52 = modifier4;
                    if (rememberedValue3 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    long j72 = m3281getWhite0d7_KjU;
                    Modifier semantics$default3 = SemanticsModifierKt.semantics$default(m326heightInVpY3zN42, false, (Function1) rememberedValue3, 1, null);
                    Alignment.Companion companion32 = Alignment.INSTANCE;
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion32.getTopStart(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default3);
                    ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
                    BottomSheetTitleStyle bottomSheetTitleStyle42 = bottomSheetTitleStyle3;
                    Function0<ComposeUiNode> constructor4 = companion42.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    int i202 = i7;
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion42.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4, companion42.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion42.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier4, companion42.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(1908601344);
                    if (isImeVisible2) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, 0.0f, 0.0f, m2599constructorimpl, 7, null);
                    Arrangement arrangement2 = Arrangement.INSTANCE;
                    MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion32.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
                    Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy3, companion42.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting()) {
                    }
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion42.getSetModifier());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    if (annotatedString3 != null) {
                    }
                    startRestartGroup.startReplaceGroup(565343665);
                    if (z5) {
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(565358035);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier semantics$default22 = SemanticsModifierKt.semantics$default(modifier52, false, (Function1) rememberedValue4, 1, null);
                    MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion32.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default22);
                    Function0<ComposeUiNode> constructor32 = companion42.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                    function03 = function06;
                    Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy22, companion42.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion42.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion42.getSetCompositeKeyHash();
                    if (!m1226constructorimpl3.getInserting()) {
                    }
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion42.getSetModifier());
                    content.invoke(columnScopeInstance2, startRestartGroup, Integer.valueOf(((i13 >> 24) & 112) | 6));
                    startRestartGroup.endNode();
                    startRestartGroup.endNode();
                    startRestartGroup.startReplaceGroup(1908629374);
                    if (function22 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier52;
                    annotatedString2 = annotatedString3;
                    f6 = f92;
                    bottomSheetTitleStyle2 = bottomSheetTitleStyle42;
                    scrollableState3 = scrollableState2;
                    function04 = function05;
                    j6 = j72;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 |= i15;
                i11 = 128 & i6;
                if (i11 == 0) {
                }
                i7 |= i14;
                i12 = 256 & i6;
                if (i12 != 0) {
                }
                if ((i6 & 512) != 0) {
                }
                if ((306783379 & i7) == 306783378) {
                }
                if (i16 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
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
                startRestartGroup.startReplaceGroup(254291053);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                function22 = function24;
                if (rememberedValue == companion.getEmpty()) {
                }
                MutableIntState mutableIntState22 = (MutableIntState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(254295349);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                State state22 = (State) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                boolean isImeVisible22 = WindowInsets_androidKt.isImeVisible(WindowInsets.INSTANCE, startRestartGroup, 6);
                Modifier.Companion companion222 = Modifier.INSTANCE;
                ScrollableState scrollableState522 = scrollableState4;
                Modifier m326heightInVpY3zN422 = SizeKt.m326heightInVpY3zN4(companion222, m2608getUnspecifiedD9Ej5fM, Dp.m2599constructorimpl(((Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp));
                float f922 = m2608getUnspecifiedD9Ej5fM;
                startRestartGroup.startReplaceGroup(254309159);
                rememberedValue3 = startRestartGroup.rememberedValue();
                Modifier modifier522 = modifier4;
                if (rememberedValue3 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                long j722 = m3281getWhite0d7_KjU;
                Modifier semantics$default32 = SemanticsModifierKt.semantics$default(m326heightInVpY3zN422, false, (Function1) rememberedValue3, 1, null);
                Alignment.Companion companion322 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(companion322.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default32);
                ComposeUiNode.Companion companion422 = ComposeUiNode.INSTANCE;
                BottomSheetTitleStyle bottomSheetTitleStyle422 = bottomSheetTitleStyle3;
                Function0<ComposeUiNode> constructor42 = companion422.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                int i2022 = i7;
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion422.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap42, companion422.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = companion422.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash42);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier42, companion422.getSetModifier());
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(1908601344);
                if (isImeVisible22) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier m315paddingqDBjuR0$default22 = PaddingKt.m315paddingqDBjuR0$default(companion222, 0.0f, 0.0f, 0.0f, m2599constructorimpl, 7, null);
                Arrangement arrangement22 = Arrangement.INSTANCE;
                MeasurePolicy columnMeasurePolicy32 = ColumnKt.columnMeasurePolicy(arrangement22.getTop(), companion322.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default22);
                Function0<ComposeUiNode> constructor222 = companion422.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy32, companion422.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion422.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion422.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting()) {
                }
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion422.getSetModifier());
                ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
                if (annotatedString3 != null) {
                }
                startRestartGroup.startReplaceGroup(565343665);
                if (z5) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(565358035);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier semantics$default222 = SemanticsModifierKt.semantics$default(modifier522, false, (Function1) rememberedValue4, 1, null);
                MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(arrangement22.getTop(), companion322.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default222);
                Function0<ComposeUiNode> constructor322 = companion422.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                function03 = function06;
                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy222, companion422.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap322, companion422.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = companion422.getSetCompositeKeyHash();
                if (!m1226constructorimpl3.getInserting()) {
                }
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash322);
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier322, companion422.getSetModifier());
                content.invoke(columnScopeInstance22, startRestartGroup, Integer.valueOf(((i13 >> 24) & 112) | 6));
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                startRestartGroup.startReplaceGroup(1908629374);
                if (function22 == null) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier522;
                annotatedString2 = annotatedString3;
                f6 = f922;
                bottomSheetTitleStyle2 = bottomSheetTitleStyle422;
                scrollableState3 = scrollableState2;
                function04 = function05;
                j6 = j722;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i9 = 32 & i6;
            if (i9 != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i7 |= i15;
            i11 = 128 & i6;
            if (i11 == 0) {
            }
            i7 |= i14;
            i12 = 256 & i6;
            if (i12 != 0) {
            }
            if ((i6 & 512) != 0) {
            }
            if ((306783379 & i7) == 306783378) {
            }
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
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
            startRestartGroup.startReplaceGroup(254291053);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            function22 = function24;
            if (rememberedValue == companion.getEmpty()) {
            }
            MutableIntState mutableIntState222 = (MutableIntState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(254295349);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            State state222 = (State) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            boolean isImeVisible222 = WindowInsets_androidKt.isImeVisible(WindowInsets.INSTANCE, startRestartGroup, 6);
            Modifier.Companion companion2222 = Modifier.INSTANCE;
            ScrollableState scrollableState5222 = scrollableState4;
            Modifier m326heightInVpY3zN4222 = SizeKt.m326heightInVpY3zN4(companion2222, m2608getUnspecifiedD9Ej5fM, Dp.m2599constructorimpl(((Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp));
            float f9222 = m2608getUnspecifiedD9Ej5fM;
            startRestartGroup.startReplaceGroup(254309159);
            rememberedValue3 = startRestartGroup.rememberedValue();
            Modifier modifier5222 = modifier4;
            if (rememberedValue3 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            long j7222 = m3281getWhite0d7_KjU;
            Modifier semantics$default322 = SemanticsModifierKt.semantics$default(m326heightInVpY3zN4222, false, (Function1) rememberedValue3, 1, null);
            Alignment.Companion companion3222 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(companion3222.getTopStart(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier422 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default322);
            ComposeUiNode.Companion companion4222 = ComposeUiNode.INSTANCE;
            BottomSheetTitleStyle bottomSheetTitleStyle4222 = bottomSheetTitleStyle3;
            Function0<ComposeUiNode> constructor422 = companion4222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            int i20222 = i7;
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222, companion4222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap422, companion4222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash422 = companion4222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash422);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier422, companion4222.getSetModifier());
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1908601344);
            if (isImeVisible222) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default222 = PaddingKt.m315paddingqDBjuR0$default(companion2222, 0.0f, 0.0f, 0.0f, m2599constructorimpl, 7, null);
            Arrangement arrangement222 = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy322 = ColumnKt.columnMeasurePolicy(arrangement222.getTop(), companion3222.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default222);
            Function0<ComposeUiNode> constructor2222 = companion4222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy322, companion4222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2222, companion4222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion4222.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2222, companion4222.getSetModifier());
            ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
            if (annotatedString3 != null) {
            }
            startRestartGroup.startReplaceGroup(565343665);
            if (z5) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(565358035);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default2222 = SemanticsModifierKt.semantics$default(modifier5222, false, (Function1) rememberedValue4, 1, null);
            MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(arrangement222.getTop(), companion3222.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default2222);
            Function0<ComposeUiNode> constructor3222 = companion4222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            function03 = function06;
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2222, companion4222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3222, companion4222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = companion4222.getSetCompositeKeyHash();
            if (!m1226constructorimpl3.getInserting()) {
            }
            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3222);
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3222, companion4222.getSetModifier());
            content.invoke(columnScopeInstance222, startRestartGroup, Integer.valueOf(((i13 >> 24) & 112) | 6));
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(1908629374);
            if (function22 == null) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier5222;
            annotatedString2 = annotatedString3;
            f6 = f9222;
            bottomSheetTitleStyle2 = bottomSheetTitleStyle4222;
            scrollableState3 = scrollableState2;
            function04 = function05;
            j6 = j7222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = 16 & i6;
        if (i8 == 0) {
        }
        i9 = 32 & i6;
        if (i9 != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i7 |= i15;
        i11 = 128 & i6;
        if (i11 == 0) {
        }
        i7 |= i14;
        i12 = 256 & i6;
        if (i12 != 0) {
        }
        if ((i6 & 512) != 0) {
        }
        if ((306783379 & i7) == 306783378) {
        }
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
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
        startRestartGroup.startReplaceGroup(254291053);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        function22 = function24;
        if (rememberedValue == companion.getEmpty()) {
        }
        MutableIntState mutableIntState2222 = (MutableIntState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(254295349);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        State state2222 = (State) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        boolean isImeVisible2222 = WindowInsets_androidKt.isImeVisible(WindowInsets.INSTANCE, startRestartGroup, 6);
        Modifier.Companion companion22222 = Modifier.INSTANCE;
        ScrollableState scrollableState52222 = scrollableState4;
        Modifier m326heightInVpY3zN42222 = SizeKt.m326heightInVpY3zN4(companion22222, m2608getUnspecifiedD9Ej5fM, Dp.m2599constructorimpl(((Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())).screenHeightDp));
        float f92222 = m2608getUnspecifiedD9Ej5fM;
        startRestartGroup.startReplaceGroup(254309159);
        rememberedValue3 = startRestartGroup.rememberedValue();
        Modifier modifier52222 = modifier4;
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        long j72222 = m3281getWhite0d7_KjU;
        Modifier semantics$default3222 = SemanticsModifierKt.semantics$default(m326heightInVpY3zN42222, false, (Function1) rememberedValue3, 1, null);
        Alignment.Companion companion32222 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(companion32222.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier4222 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default3222);
        ComposeUiNode.Companion companion42222 = ComposeUiNode.INSTANCE;
        BottomSheetTitleStyle bottomSheetTitleStyle42222 = bottomSheetTitleStyle3;
        Function0<ComposeUiNode> constructor4222 = companion42222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        int i202222 = i7;
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2222, companion42222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4222, companion42222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4222 = companion42222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4222, companion42222.getSetModifier());
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(1908601344);
        if (isImeVisible2222) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier m315paddingqDBjuR0$default2222 = PaddingKt.m315paddingqDBjuR0$default(companion22222, 0.0f, 0.0f, 0.0f, m2599constructorimpl, 7, null);
        Arrangement arrangement2222 = Arrangement.INSTANCE;
        MeasurePolicy columnMeasurePolicy3222 = ColumnKt.columnMeasurePolicy(arrangement2222.getTop(), companion32222.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2222);
        Function0<ComposeUiNode> constructor22222 = companion42222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy3222, companion42222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22222, companion42222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = companion42222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22222, companion42222.getSetModifier());
        ColumnScopeInstance columnScopeInstance2222 = ColumnScopeInstance.INSTANCE;
        if (annotatedString3 != null) {
        }
        startRestartGroup.startReplaceGroup(565343665);
        if (z5) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(565358035);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier semantics$default22222 = SemanticsModifierKt.semantics$default(modifier52222, false, (Function1) rememberedValue4, 1, null);
        MeasurePolicy columnMeasurePolicy22222 = ColumnKt.columnMeasurePolicy(arrangement2222.getTop(), companion32222.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32222 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default22222);
        Function0<ComposeUiNode> constructor32222 = companion42222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
        function03 = function06;
        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy22222, companion42222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32222, companion42222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32222 = companion42222.getSetCompositeKeyHash();
        if (!m1226constructorimpl3.getInserting()) {
        }
        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32222);
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32222, companion42222.getSetModifier());
        content.invoke(columnScopeInstance2222, startRestartGroup, Integer.valueOf(((i13 >> 24) & 112) | 6));
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        startRestartGroup.startReplaceGroup(1908629374);
        if (function22 == null) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier52222;
        annotatedString2 = annotatedString3;
        f6 = f92222;
        bottomSheetTitleStyle2 = bottomSheetTitleStyle42222;
        scrollableState3 = scrollableState2;
        function04 = function05;
        j6 = j72222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e9  */
    /* renamed from: BottomSheetContainer-ZO57_FM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3399BottomSheetContainerZO57_FM(Modifier modifier, float f5, String str, BottomSheetTitleStyle bottomSheetTitleStyle, long j5, Function0<Unit> function0, Function0<Unit> function02, ScrollableState scrollableState, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        String str2;
        int i9;
        BottomSheetTitleStyle bottomSheetTitleStyle2;
        int i10;
        int i11;
        int i12;
        Function0<Unit> function03;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final Function0<Unit> function04;
        final Function0<Unit> function05;
        final Modifier modifier2;
        final float f6;
        final String str3;
        final BottomSheetTitleStyle bottomSheetTitleStyle3;
        final long j6;
        final ScrollableState scrollableState2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(173604722);
        int i16 = i6 & 1;
        if (i16 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i17 = i6 & 2;
        if (i17 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(f5) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                str2 = str;
                i7 |= startRestartGroup.changed(str2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    bottomSheetTitleStyle2 = bottomSheetTitleStyle;
                    i7 |= startRestartGroup.changed(bottomSheetTitleStyle2) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                        i11 = i16;
                    } else {
                        i11 = i16;
                        if ((i5 & 24576) == 0) {
                            i7 |= startRestartGroup.changed(j5) ? 16384 : 8192;
                        }
                    }
                    i12 = i6 & 32;
                    if (i12 == 0) {
                        i7 |= 196608;
                        function03 = function0;
                    } else {
                        function03 = function0;
                        if ((i5 & 196608) == 0) {
                            i7 |= startRestartGroup.changedInstance(function03) ? 131072 : 65536;
                        }
                    }
                    i13 = i6 & 64;
                    if (i13 == 0) {
                        i7 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i7 |= startRestartGroup.changedInstance(function02) ? 1048576 : 524288;
                    }
                    i14 = i6 & 128;
                    if (i14 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changedInstance(scrollableState) ? 8388608 : 4194304;
                    }
                    i15 = i6 & 256;
                    if (i15 == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i7 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                    }
                    if ((i6 & 512) == 0) {
                        i7 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i7 |= startRestartGroup.changedInstance(content) ? 536870912 : 268435456;
                    }
                    if ((306783379 & i7) == 306783378 || !startRestartGroup.getSkipping()) {
                        Modifier modifier3 = i11 == 0 ? Modifier.INSTANCE : modifier;
                        float m2608getUnspecifiedD9Ej5fM = i17 == 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : f5;
                        String str4 = i8 == 0 ? null : str2;
                        BottomSheetTitleStyle bottomSheetTitleStyle4 = i9 == 0 ? BottomSheetTitleStyle.Standard : bottomSheetTitleStyle2;
                        long m3281getWhite0d7_KjU = i10 == 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j5;
                        Function0<Unit> function06 = i12 == 0 ? null : function03;
                        Function0<Unit> function07 = i13 == 0 ? null : function02;
                        ScrollableState scrollableState3 = i14 == 0 ? null : scrollableState;
                        Function2<? super Composer, ? super Integer, Unit> function23 = i15 == 0 ? null : function2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(173604722, i7, -1, "dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainer (BottomSheetContainer.kt:42)");
                        }
                        composer2 = startRestartGroup;
                        m3398BottomSheetContainer8Un_QVk(modifier3, m2608getUnspecifiedD9Ej5fM, m3281getWhite0d7_KjU, str4 == null ? new AnnotatedString(str4, null, null, 6, null) : null, bottomSheetTitleStyle4, function06, function07, scrollableState3, function23, content, startRestartGroup, (i7 & 126) | ((i7 >> 6) & 896) | ((i7 << 3) & 57344) | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (1879048192 & i7), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function04 = function06;
                        function05 = function07;
                        modifier2 = modifier3;
                        f6 = m2608getUnspecifiedD9Ej5fM;
                        str3 = str4;
                        bottomSheetTitleStyle3 = bottomSheetTitleStyle4;
                        j6 = m3281getWhite0d7_KjU;
                        scrollableState2 = scrollableState3;
                        function22 = function23;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        f6 = f5;
                        j6 = j5;
                        function05 = function02;
                        function22 = function2;
                        str3 = str2;
                        bottomSheetTitleStyle3 = bottomSheetTitleStyle2;
                        function04 = function03;
                        composer2 = startRestartGroup;
                        scrollableState2 = scrollableState;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: Y1.i
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit BottomSheetContainer_ZO57_FM$lambda$1;
                                BottomSheetContainer_ZO57_FM$lambda$1 = BottomSheetContainerKt.BottomSheetContainer_ZO57_FM$lambda$1(Modifier.this, f6, str3, bottomSheetTitleStyle3, j6, function04, function05, scrollableState2, function22, content, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return BottomSheetContainer_ZO57_FM$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
                bottomSheetTitleStyle2 = bottomSheetTitleStyle;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                i12 = i6 & 32;
                if (i12 == 0) {
                }
                i13 = i6 & 64;
                if (i13 == 0) {
                }
                i14 = i6 & 128;
                if (i14 == 0) {
                }
                i15 = i6 & 256;
                if (i15 == 0) {
                }
                if ((i6 & 512) == 0) {
                }
                if ((306783379 & i7) == 306783378) {
                }
                if (i11 == 0) {
                }
                if (i17 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i15 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                m3398BottomSheetContainer8Un_QVk(modifier3, m2608getUnspecifiedD9Ej5fM, m3281getWhite0d7_KjU, str4 == null ? new AnnotatedString(str4, null, null, 6, null) : null, bottomSheetTitleStyle4, function06, function07, scrollableState3, function23, content, startRestartGroup, (i7 & 126) | ((i7 >> 6) & 896) | ((i7 << 3) & 57344) | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (1879048192 & i7), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function04 = function06;
                function05 = function07;
                modifier2 = modifier3;
                f6 = m2608getUnspecifiedD9Ej5fM;
                str3 = str4;
                bottomSheetTitleStyle3 = bottomSheetTitleStyle4;
                j6 = m3281getWhite0d7_KjU;
                scrollableState2 = scrollableState3;
                function22 = function23;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            str2 = str;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            bottomSheetTitleStyle2 = bottomSheetTitleStyle;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            i12 = i6 & 32;
            if (i12 == 0) {
            }
            i13 = i6 & 64;
            if (i13 == 0) {
            }
            i14 = i6 & 128;
            if (i14 == 0) {
            }
            i15 = i6 & 256;
            if (i15 == 0) {
            }
            if ((i6 & 512) == 0) {
            }
            if ((306783379 & i7) == 306783378) {
            }
            if (i11 == 0) {
            }
            if (i17 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i15 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            m3398BottomSheetContainer8Un_QVk(modifier3, m2608getUnspecifiedD9Ej5fM, m3281getWhite0d7_KjU, str4 == null ? new AnnotatedString(str4, null, null, 6, null) : null, bottomSheetTitleStyle4, function06, function07, scrollableState3, function23, content, startRestartGroup, (i7 & 126) | ((i7 >> 6) & 896) | ((i7 << 3) & 57344) | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (1879048192 & i7), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function04 = function06;
            function05 = function07;
            modifier2 = modifier3;
            f6 = m2608getUnspecifiedD9Ej5fM;
            str3 = str4;
            bottomSheetTitleStyle3 = bottomSheetTitleStyle4;
            j6 = m3281getWhite0d7_KjU;
            scrollableState2 = scrollableState3;
            function22 = function23;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        str2 = str;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        bottomSheetTitleStyle2 = bottomSheetTitleStyle;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        i12 = i6 & 32;
        if (i12 == 0) {
        }
        i13 = i6 & 64;
        if (i13 == 0) {
        }
        i14 = i6 & 128;
        if (i14 == 0) {
        }
        i15 = i6 & 256;
        if (i15 == 0) {
        }
        if ((i6 & 512) == 0) {
        }
        if ((306783379 & i7) == 306783378) {
        }
        if (i11 == 0) {
        }
        if (i17 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i15 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        m3398BottomSheetContainer8Un_QVk(modifier3, m2608getUnspecifiedD9Ej5fM, m3281getWhite0d7_KjU, str4 == null ? new AnnotatedString(str4, null, null, 6, null) : null, bottomSheetTitleStyle4, function06, function07, scrollableState3, function23, content, startRestartGroup, (i7 & 126) | ((i7 >> 6) & 896) | ((i7 << 3) & 57344) | (458752 & i7) | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (1879048192 & i7), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function04 = function06;
        function05 = function07;
        modifier2 = modifier3;
        f6 = m2608getUnspecifiedD9Ej5fM;
        str3 = str4;
        bottomSheetTitleStyle3 = bottomSheetTitleStyle4;
        j6 = m3281getWhite0d7_KjU;
        scrollableState2 = scrollableState3;
        function22 = function23;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContainer_8Un_QVk$lambda$19$lambda$13$lambda$11$lambda$10(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        SemanticsPropertiesKt.setTraversalIndex(semantics, -30.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$15$lambda$14(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BottomSheetContainer_8Un_QVk$lambda$19$lambda$18$lambda$17$lambda$16(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContainer_8Un_QVk$lambda$20(Modifier modifier, float f5, long j5, AnnotatedString annotatedString, BottomSheetTitleStyle bottomSheetTitleStyle, Function0 function0, Function0 function02, ScrollableState scrollableState, Function2 function2, Function3 function3, int i5, int i6, Composer composer, int i7) {
        m3398BottomSheetContainer8Un_QVk(modifier, f5, j5, annotatedString, bottomSheetTitleStyle, function0, function02, scrollableState, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomSheetContainer_8Un_QVk$lambda$6$lambda$5(ScrollableState scrollableState, float f5, float f6) {
        return f6 * (scrollableState != null ? ScrollableStateExtensionsKt.elevationPercentage(scrollableState, f5) : 0.0f);
    }

    private static final float BottomSheetContainer_8Un_QVk$lambda$7(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContainer_8Un_QVk$lambda$9$lambda$8(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContainer_ZO57_FM$lambda$1(Modifier modifier, float f5, String str, BottomSheetTitleStyle bottomSheetTitleStyle, long j5, Function0 function0, Function0 function02, ScrollableState scrollableState, Function2 function2, Function3 function3, int i5, int i6, Composer composer, int i7) {
        m3399BottomSheetContainerZO57_FM(modifier, f5, str, bottomSheetTitleStyle, j5, function0, function02, scrollableState, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
