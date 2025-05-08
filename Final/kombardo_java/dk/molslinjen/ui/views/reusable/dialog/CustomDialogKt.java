package dk.molslinjen.ui.views.reusable.dialog;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.buttons.DestructiveButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ac\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;", "primaryButton", "destructiveButton", "secondaryButton", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onDismissRequest", BuildConfig.FLAVOR, "dismissible", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "customContent", "CustomDialog", "(Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CustomDialogKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0120 A[EDGE_INSN: B:70:0x0120->B:53:0x0120 BREAK  A[LOOP:0: B:58:0x010b->B:68:0x010b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CustomDialog(SimpleButtonData simpleButtonData, SimpleButtonData simpleButtonData2, SimpleButtonData simpleButtonData3, final Function0<Unit> onDismissRequest, boolean z5, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        SimpleButtonData simpleButtonData4;
        int i7;
        SimpleButtonData simpleButtonData5;
        int i8;
        SimpleButtonData simpleButtonData6;
        int i9;
        boolean z6;
        int i10;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        List listOf;
        Iterator it;
        final SimpleButtonData simpleButtonData7;
        final SimpleButtonData simpleButtonData8;
        final boolean z7;
        final SimpleButtonData simpleButtonData9;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer startRestartGroup = composer.startRestartGroup(-143803563);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i7 = i5 | 6;
            simpleButtonData4 = simpleButtonData;
        } else if ((i5 & 6) == 0) {
            simpleButtonData4 = simpleButtonData;
            i7 = (startRestartGroup.changed(simpleButtonData4) ? 4 : 2) | i5;
        } else {
            simpleButtonData4 = simpleButtonData;
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            simpleButtonData5 = simpleButtonData2;
            i7 |= startRestartGroup.changed(simpleButtonData5) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                simpleButtonData6 = simpleButtonData3;
                i7 |= startRestartGroup.changed(simpleButtonData6) ? 256 : 128;
                if ((i6 & 8) != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changedInstance(onDismissRequest) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    z6 = z5;
                    i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                    i10 = i6 & 32;
                    if (i10 == 0) {
                        i7 |= 196608;
                    } else if ((196608 & i5) == 0) {
                        function32 = function3;
                        i7 |= startRestartGroup.changedInstance(function32) ? 131072 : 65536;
                        if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                            SimpleButtonData simpleButtonData10 = i11 != 0 ? null : simpleButtonData4;
                            if (i12 != 0) {
                                simpleButtonData5 = null;
                            }
                            if (i8 != 0) {
                                simpleButtonData6 = null;
                            }
                            if (i9 != 0) {
                                z6 = true;
                            }
                            if (i10 != 0) {
                                function32 = null;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-143803563, i7, -1, "dk.molslinjen.ui.views.reusable.dialog.CustomDialog (CustomDialog.kt:37)");
                            }
                            listOf = CollectionsKt.listOf((Object[]) new SimpleButtonData[]{simpleButtonData10, simpleButtonData5, simpleButtonData6});
                            boolean z8 = false;
                            if ((listOf instanceof Collection) || !listOf.isEmpty()) {
                                it = listOf.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    SimpleButtonData simpleButtonData11 = (SimpleButtonData) it.next();
                                    if (simpleButtonData11 != null && simpleButtonData11.getIsLoading()) {
                                        z8 = true;
                                        break;
                                    }
                                }
                            }
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                            final SimpleButtonData simpleButtonData12 = simpleButtonData10;
                            final SimpleButtonData simpleButtonData13 = simpleButtonData5;
                            final SimpleButtonData simpleButtonData14 = simpleButtonData6;
                            final boolean z9 = z8;
                            SimpleButtonData simpleButtonData15 = simpleButtonData5;
                            AndroidDialog_androidKt.Dialog(onDismissRequest, new DialogProperties(z6, z6, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1732124258, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt$CustomDialog$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    boolean z10;
                                    boolean z11;
                                    float f5;
                                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1732124258, i13, -1, "dk.molslinjen.ui.views.reusable.dialog.CustomDialog.<anonymous> (CustomDialog.kt:44)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    float f6 = 24;
                                    Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(32));
                                    Alignment.Companion companion2 = Alignment.INSTANCE;
                                    Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
                                    Function3<ColumnScope, Composer, Integer, Unit> function34 = function33;
                                    SimpleButtonData simpleButtonData16 = simpleButtonData12;
                                    SimpleButtonData simpleButtonData17 = simpleButtonData13;
                                    SimpleButtonData simpleButtonData18 = simpleButtonData14;
                                    boolean z12 = z9;
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer2, 48);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m312paddingVpY3zN4);
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    composer2.startReplaceGroup(792110146);
                                    if (function34 != null) {
                                        function34.invoke(columnScopeInstance, composer2, 6);
                                    }
                                    composer2.endReplaceGroup();
                                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), composer2, 6);
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), companion2.getStart(), composer2, 6);
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                    if (composer2.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor2);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                                    composer2.startReplaceGroup(1607827215);
                                    if (simpleButtonData16 == null) {
                                        z10 = false;
                                        z11 = z12;
                                    } else {
                                        z10 = false;
                                        z11 = z12;
                                        PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData16.getText(), simpleButtonData16.getOnClick(), null, null, simpleButtonData16.getEnabled() && !z12, simpleButtonData16.getIsLoading(), false, composer2, 6, 152);
                                    }
                                    composer2.endReplaceGroup();
                                    composer2.startReplaceGroup(1607839379);
                                    if (simpleButtonData17 == null) {
                                        f5 = 0.0f;
                                    } else {
                                        f5 = 0.0f;
                                        DestructiveButtonKt.DestructiveButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData17.getText(), simpleButtonData17.getOnClick(), null, null, (!simpleButtonData17.getEnabled() || z11) ? z10 : true, simpleButtonData17.getIsLoading(), composer2, 6, 24);
                                    }
                                    composer2.endReplaceGroup();
                                    composer2.startReplaceGroup(1607851601);
                                    if (simpleButtonData18 != null) {
                                        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, f5, 1, null), simpleButtonData18.getText(), simpleButtonData18.getOnClick(), null, (!simpleButtonData18.getEnabled() || z11) ? z10 : true, null, simpleButtonData18.getIsLoading(), null, null, 0L, false, composer2, 6, 0, 1960);
                                    }
                                    composer2.endReplaceGroup();
                                    composer2.endNode();
                                    composer2.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, ((i7 >> 9) & 14) | 384, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            simpleButtonData7 = simpleButtonData15;
                            simpleButtonData8 = simpleButtonData6;
                            z7 = z6;
                            simpleButtonData9 = simpleButtonData10;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            simpleButtonData9 = simpleButtonData4;
                            simpleButtonData7 = simpleButtonData5;
                            simpleButtonData8 = simpleButtonData6;
                            z7 = z6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function34 = function32;
                            endRestartGroup.updateScope(new Function2() { // from class: b2.a
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit CustomDialog$lambda$1;
                                    CustomDialog$lambda$1 = CustomDialogKt.CustomDialog$lambda$1(SimpleButtonData.this, simpleButtonData7, simpleButtonData8, onDismissRequest, z7, function34, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return CustomDialog$lambda$1;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function32 = function3;
                    if ((74899 & i7) == 74898) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    listOf = CollectionsKt.listOf((Object[]) new SimpleButtonData[]{simpleButtonData10, simpleButtonData5, simpleButtonData6});
                    boolean z82 = false;
                    if (listOf instanceof Collection) {
                    }
                    it = listOf.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                        }
                    }
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332 = function32;
                    final SimpleButtonData simpleButtonData122 = simpleButtonData10;
                    final SimpleButtonData simpleButtonData132 = simpleButtonData5;
                    final SimpleButtonData simpleButtonData142 = simpleButtonData6;
                    final boolean z92 = z82;
                    SimpleButtonData simpleButtonData152 = simpleButtonData5;
                    AndroidDialog_androidKt.Dialog(onDismissRequest, new DialogProperties(z6, z6, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1732124258, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt$CustomDialog$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            boolean z10;
                            boolean z11;
                            float f5;
                            if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1732124258, i13, -1, "dk.molslinjen.ui.views.reusable.dialog.CustomDialog.<anonymous> (CustomDialog.kt:44)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            float f6 = 24;
                            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(32));
                            Alignment.Companion companion2 = Alignment.INSTANCE;
                            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
                            Function3<ColumnScope, Composer, Integer, Unit> function342 = function332;
                            SimpleButtonData simpleButtonData16 = simpleButtonData122;
                            SimpleButtonData simpleButtonData17 = simpleButtonData132;
                            SimpleButtonData simpleButtonData18 = simpleButtonData142;
                            boolean z12 = z92;
                            Arrangement arrangement = Arrangement.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer2, 48);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m312paddingVpY3zN4);
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                            if (composer2.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            composer2.startReplaceGroup(792110146);
                            if (function342 != null) {
                                function342.invoke(columnScopeInstance, composer2, 6);
                            }
                            composer2.endReplaceGroup();
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), composer2, 6);
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), companion2.getStart(), composer2, 6);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                            if (composer2.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                            composer2.startReplaceGroup(1607827215);
                            if (simpleButtonData16 == null) {
                                z10 = false;
                                z11 = z12;
                            } else {
                                z10 = false;
                                z11 = z12;
                                PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData16.getText(), simpleButtonData16.getOnClick(), null, null, simpleButtonData16.getEnabled() && !z12, simpleButtonData16.getIsLoading(), false, composer2, 6, 152);
                            }
                            composer2.endReplaceGroup();
                            composer2.startReplaceGroup(1607839379);
                            if (simpleButtonData17 == null) {
                                f5 = 0.0f;
                            } else {
                                f5 = 0.0f;
                                DestructiveButtonKt.DestructiveButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData17.getText(), simpleButtonData17.getOnClick(), null, null, (!simpleButtonData17.getEnabled() || z11) ? z10 : true, simpleButtonData17.getIsLoading(), composer2, 6, 24);
                            }
                            composer2.endReplaceGroup();
                            composer2.startReplaceGroup(1607851601);
                            if (simpleButtonData18 != null) {
                                SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, f5, 1, null), simpleButtonData18.getText(), simpleButtonData18.getOnClick(), null, (!simpleButtonData18.getEnabled() || z11) ? z10 : true, null, simpleButtonData18.getIsLoading(), null, null, 0L, false, composer2, 6, 0, 1960);
                            }
                            composer2.endReplaceGroup();
                            composer2.endNode();
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, ((i7 >> 9) & 14) | 384, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    simpleButtonData7 = simpleButtonData152;
                    simpleButtonData8 = simpleButtonData6;
                    z7 = z6;
                    simpleButtonData9 = simpleButtonData10;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z6 = z5;
                i10 = i6 & 32;
                if (i10 == 0) {
                }
                function32 = function3;
                if ((74899 & i7) == 74898) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                listOf = CollectionsKt.listOf((Object[]) new SimpleButtonData[]{simpleButtonData10, simpleButtonData5, simpleButtonData6});
                boolean z822 = false;
                if (listOf instanceof Collection) {
                }
                it = listOf.iterator();
                while (true) {
                    if (!it.hasNext()) {
                    }
                }
                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3322 = function32;
                final SimpleButtonData simpleButtonData1222 = simpleButtonData10;
                final SimpleButtonData simpleButtonData1322 = simpleButtonData5;
                final SimpleButtonData simpleButtonData1422 = simpleButtonData6;
                final boolean z922 = z822;
                SimpleButtonData simpleButtonData1522 = simpleButtonData5;
                AndroidDialog_androidKt.Dialog(onDismissRequest, new DialogProperties(z6, z6, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1732124258, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt$CustomDialog$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        boolean z10;
                        boolean z11;
                        float f5;
                        if ((i13 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1732124258, i13, -1, "dk.molslinjen.ui.views.reusable.dialog.CustomDialog.<anonymous> (CustomDialog.kt:44)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        float f6 = 24;
                        Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(32));
                        Alignment.Companion companion2 = Alignment.INSTANCE;
                        Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
                        Function3<ColumnScope, Composer, Integer, Unit> function342 = function3322;
                        SimpleButtonData simpleButtonData16 = simpleButtonData1222;
                        SimpleButtonData simpleButtonData17 = simpleButtonData1322;
                        SimpleButtonData simpleButtonData18 = simpleButtonData1422;
                        boolean z12 = z922;
                        Arrangement arrangement = Arrangement.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer2, 48);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m312paddingVpY3zN4);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        composer2.startReplaceGroup(792110146);
                        if (function342 != null) {
                            function342.invoke(columnScopeInstance, composer2, 6);
                        }
                        composer2.endReplaceGroup();
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), composer2, 6);
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), companion2.getStart(), composer2, 6);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                        composer2.startReplaceGroup(1607827215);
                        if (simpleButtonData16 == null) {
                            z10 = false;
                            z11 = z12;
                        } else {
                            z10 = false;
                            z11 = z12;
                            PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData16.getText(), simpleButtonData16.getOnClick(), null, null, simpleButtonData16.getEnabled() && !z12, simpleButtonData16.getIsLoading(), false, composer2, 6, 152);
                        }
                        composer2.endReplaceGroup();
                        composer2.startReplaceGroup(1607839379);
                        if (simpleButtonData17 == null) {
                            f5 = 0.0f;
                        } else {
                            f5 = 0.0f;
                            DestructiveButtonKt.DestructiveButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData17.getText(), simpleButtonData17.getOnClick(), null, null, (!simpleButtonData17.getEnabled() || z11) ? z10 : true, simpleButtonData17.getIsLoading(), composer2, 6, 24);
                        }
                        composer2.endReplaceGroup();
                        composer2.startReplaceGroup(1607851601);
                        if (simpleButtonData18 != null) {
                            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, f5, 1, null), simpleButtonData18.getText(), simpleButtonData18.getOnClick(), null, (!simpleButtonData18.getEnabled() || z11) ? z10 : true, null, simpleButtonData18.getIsLoading(), null, null, 0L, false, composer2, 6, 0, 1960);
                        }
                        composer2.endReplaceGroup();
                        composer2.endNode();
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, ((i7 >> 9) & 14) | 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                simpleButtonData7 = simpleButtonData1522;
                simpleButtonData8 = simpleButtonData6;
                z7 = z6;
                simpleButtonData9 = simpleButtonData10;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            simpleButtonData6 = simpleButtonData3;
            if ((i6 & 8) != 0) {
            }
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z5;
            i10 = i6 & 32;
            if (i10 == 0) {
            }
            function32 = function3;
            if ((74899 & i7) == 74898) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            listOf = CollectionsKt.listOf((Object[]) new SimpleButtonData[]{simpleButtonData10, simpleButtonData5, simpleButtonData6});
            boolean z8222 = false;
            if (listOf instanceof Collection) {
            }
            it = listOf.iterator();
            while (true) {
                if (!it.hasNext()) {
                }
            }
            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33222 = function32;
            final SimpleButtonData simpleButtonData12222 = simpleButtonData10;
            final SimpleButtonData simpleButtonData13222 = simpleButtonData5;
            final SimpleButtonData simpleButtonData14222 = simpleButtonData6;
            final boolean z9222 = z8222;
            SimpleButtonData simpleButtonData15222 = simpleButtonData5;
            AndroidDialog_androidKt.Dialog(onDismissRequest, new DialogProperties(z6, z6, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1732124258, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt$CustomDialog$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    boolean z10;
                    boolean z11;
                    float f5;
                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1732124258, i13, -1, "dk.molslinjen.ui.views.reusable.dialog.CustomDialog.<anonymous> (CustomDialog.kt:44)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    float f6 = 24;
                    Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(32));
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
                    Function3<ColumnScope, Composer, Integer, Unit> function342 = function33222;
                    SimpleButtonData simpleButtonData16 = simpleButtonData12222;
                    SimpleButtonData simpleButtonData17 = simpleButtonData13222;
                    SimpleButtonData simpleButtonData18 = simpleButtonData14222;
                    boolean z12 = z9222;
                    Arrangement arrangement = Arrangement.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer2, 48);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m312paddingVpY3zN4);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    composer2.startReplaceGroup(792110146);
                    if (function342 != null) {
                        function342.invoke(columnScopeInstance, composer2, 6);
                    }
                    composer2.endReplaceGroup();
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), composer2, 6);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), companion2.getStart(), composer2, 6);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                    composer2.startReplaceGroup(1607827215);
                    if (simpleButtonData16 == null) {
                        z10 = false;
                        z11 = z12;
                    } else {
                        z10 = false;
                        z11 = z12;
                        PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData16.getText(), simpleButtonData16.getOnClick(), null, null, simpleButtonData16.getEnabled() && !z12, simpleButtonData16.getIsLoading(), false, composer2, 6, 152);
                    }
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(1607839379);
                    if (simpleButtonData17 == null) {
                        f5 = 0.0f;
                    } else {
                        f5 = 0.0f;
                        DestructiveButtonKt.DestructiveButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData17.getText(), simpleButtonData17.getOnClick(), null, null, (!simpleButtonData17.getEnabled() || z11) ? z10 : true, simpleButtonData17.getIsLoading(), composer2, 6, 24);
                    }
                    composer2.endReplaceGroup();
                    composer2.startReplaceGroup(1607851601);
                    if (simpleButtonData18 != null) {
                        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, f5, 1, null), simpleButtonData18.getText(), simpleButtonData18.getOnClick(), null, (!simpleButtonData18.getEnabled() || z11) ? z10 : true, null, simpleButtonData18.getIsLoading(), null, null, 0L, false, composer2, 6, 0, 1960);
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i7 >> 9) & 14) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            simpleButtonData7 = simpleButtonData15222;
            simpleButtonData8 = simpleButtonData6;
            z7 = z6;
            simpleButtonData9 = simpleButtonData10;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        simpleButtonData5 = simpleButtonData2;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        simpleButtonData6 = simpleButtonData3;
        if ((i6 & 8) != 0) {
        }
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z5;
        i10 = i6 & 32;
        if (i10 == 0) {
        }
        function32 = function3;
        if ((74899 & i7) == 74898) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        listOf = CollectionsKt.listOf((Object[]) new SimpleButtonData[]{simpleButtonData10, simpleButtonData5, simpleButtonData6});
        boolean z82222 = false;
        if (listOf instanceof Collection) {
        }
        it = listOf.iterator();
        while (true) {
            if (!it.hasNext()) {
            }
        }
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function332222 = function32;
        final SimpleButtonData simpleButtonData122222 = simpleButtonData10;
        final SimpleButtonData simpleButtonData132222 = simpleButtonData5;
        final SimpleButtonData simpleButtonData142222 = simpleButtonData6;
        final boolean z92222 = z82222;
        SimpleButtonData simpleButtonData152222 = simpleButtonData5;
        AndroidDialog_androidKt.Dialog(onDismissRequest, new DialogProperties(z6, z6, false, 4, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1732124258, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt$CustomDialog$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i13) {
                boolean z10;
                boolean z11;
                float f5;
                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1732124258, i13, -1, "dk.molslinjen.ui.views.reusable.dialog.CustomDialog.<anonymous> (CustomDialog.kt:44)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                float f6 = 24;
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(32));
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
                Function3<ColumnScope, Composer, Integer, Unit> function342 = function332222;
                SimpleButtonData simpleButtonData16 = simpleButtonData122222;
                SimpleButtonData simpleButtonData17 = simpleButtonData132222;
                SimpleButtonData simpleButtonData18 = simpleButtonData142222;
                boolean z12 = z92222;
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer2, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m312paddingVpY3zN4);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer2.startReplaceGroup(792110146);
                if (function342 != null) {
                    function342.invoke(columnScopeInstance, composer2, 6);
                }
                composer2.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), composer2, 6);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), companion2.getStart(), composer2, 6);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                composer2.startReplaceGroup(1607827215);
                if (simpleButtonData16 == null) {
                    z10 = false;
                    z11 = z12;
                } else {
                    z10 = false;
                    z11 = z12;
                    PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData16.getText(), simpleButtonData16.getOnClick(), null, null, simpleButtonData16.getEnabled() && !z12, simpleButtonData16.getIsLoading(), false, composer2, 6, 152);
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(1607839379);
                if (simpleButtonData17 == null) {
                    f5 = 0.0f;
                } else {
                    f5 = 0.0f;
                    DestructiveButtonKt.DestructiveButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData17.getText(), simpleButtonData17.getOnClick(), null, null, (!simpleButtonData17.getEnabled() || z11) ? z10 : true, simpleButtonData17.getIsLoading(), composer2, 6, 24);
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(1607851601);
                if (simpleButtonData18 != null) {
                    SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, f5, 1, null), simpleButtonData18.getText(), simpleButtonData18.getOnClick(), null, (!simpleButtonData18.getEnabled() || z11) ? z10 : true, null, simpleButtonData18.getIsLoading(), null, null, 0L, false, composer2, 6, 0, 1960);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, ((i7 >> 9) & 14) | 384, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        simpleButtonData7 = simpleButtonData152222;
        simpleButtonData8 = simpleButtonData6;
        z7 = z6;
        simpleButtonData9 = simpleButtonData10;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomDialog$lambda$1(SimpleButtonData simpleButtonData, SimpleButtonData simpleButtonData2, SimpleButtonData simpleButtonData3, Function0 function0, boolean z5, Function3 function3, int i5, int i6, Composer composer, int i7) {
        CustomDialog(simpleButtonData, simpleButtonData2, simpleButtonData3, function0, z5, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
