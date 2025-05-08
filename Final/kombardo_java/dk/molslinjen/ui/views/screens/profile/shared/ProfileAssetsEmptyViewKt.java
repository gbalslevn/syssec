package dk.molslinjen.ui.views.screens.profile.shared;

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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsEmptyViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aK\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, "icon", BuildConfig.FLAVOR, "description", "subDescription", "buttonText", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onButtonClick", "ProfileItemsEmptyView", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileAssetsEmptyViewKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProfileItemsEmptyView(final int i5, final String description, String str, String str2, Function0<Unit> function0, Composer composer, final int i6, final int i7) {
        int i8;
        final String str3;
        int i9;
        String str4;
        int i10;
        Function0<Unit> function02;
        int i11;
        String str5;
        Modifier.Companion companion;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final Function0<Unit> function03;
        final String str6;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(description, "description");
        Composer startRestartGroup = composer.startRestartGroup(-1117370504);
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
            i8 |= startRestartGroup.changed(description) ? 32 : 16;
        }
        int i12 = i7 & 4;
        if (i12 != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            str3 = str;
            i8 |= startRestartGroup.changed(str3) ? 256 : 128;
            i9 = i7 & 8;
            if (i9 == 0) {
                i8 |= 3072;
            } else if ((i6 & 3072) == 0) {
                str4 = str2;
                i8 |= startRestartGroup.changed(str4) ? 2048 : 1024;
                i10 = i7 & 16;
                if (i10 != 0) {
                    i8 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    function02 = function0;
                    i8 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
                    i11 = i8;
                    if ((i11 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                        String str7 = i12 == 0 ? null : str3;
                        str5 = i9 == 0 ? null : str4;
                        if (i10 != 0) {
                            function02 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1117370504, i11, -1, "dk.molslinjen.ui.views.screens.profile.shared.ProfileItemsEmptyView (ProfileAssetsEmptyView.kt:21)");
                        }
                        companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ProfileAssetsEmptyCardKt.ProfileItemsEmptyCard(null, i5, description, str7, startRestartGroup, (i11 << 3) & 8176, 1);
                        startRestartGroup.startReplaceGroup(1956635181);
                        if (str5 != null && function02 != null) {
                            float f5 = 24;
                            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
                            int i13 = i11 >> 6;
                            ProfileCreateAssetButtonKt.ProfileCreateItemButton(m313paddingVpY3zN4$default, str5, function02, startRestartGroup, 6 | (i13 & 112) | (i13 & 896), 0);
                        }
                        startRestartGroup.endReplaceGroup();
                        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function03 = function02;
                        str3 = str7;
                        str6 = str5;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        str6 = str4;
                        function03 = function02;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: W3.c
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ProfileItemsEmptyView$lambda$1;
                                ProfileItemsEmptyView$lambda$1 = ProfileAssetsEmptyViewKt.ProfileItemsEmptyView$lambda$1(i5, description, str3, str6, function03, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                return ProfileItemsEmptyView$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
                function02 = function0;
                i11 = i8;
                if ((i11 & 9363) == 9362) {
                }
                if (i12 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                companion = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion22.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ProfileAssetsEmptyCardKt.ProfileItemsEmptyCard(null, i5, description, str7, startRestartGroup, (i11 << 3) & 8176, 1);
                startRestartGroup.startReplaceGroup(1956635181);
                if (str5 != null) {
                    float f52 = 24;
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f52)), startRestartGroup, 6);
                    Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f52), 0.0f, 2, null);
                    int i132 = i11 >> 6;
                    ProfileCreateAssetButtonKt.ProfileCreateItemButton(m313paddingVpY3zN4$default2, str5, function02, startRestartGroup, 6 | (i132 & 112) | (i132 & 896), 0);
                }
                startRestartGroup.endReplaceGroup();
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance2, companion, 1.0f, false, 2, null), startRestartGroup, 0);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                function03 = function02;
                str3 = str7;
                str6 = str5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            str4 = str2;
            i10 = i7 & 16;
            if (i10 != 0) {
            }
            function02 = function0;
            i11 = i8;
            if ((i11 & 9363) == 9362) {
            }
            if (i12 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
            ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
            ProfileAssetsEmptyCardKt.ProfileItemsEmptyCard(null, i5, description, str7, startRestartGroup, (i11 << 3) & 8176, 1);
            startRestartGroup.startReplaceGroup(1956635181);
            if (str5 != null) {
            }
            startRestartGroup.endReplaceGroup();
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance22, companion, 1.0f, false, 2, null), startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function03 = function02;
            str3 = str7;
            str6 = str5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        str3 = str;
        i9 = i7 & 8;
        if (i9 == 0) {
        }
        str4 = str2;
        i10 = i7 & 16;
        if (i10 != 0) {
        }
        function02 = function0;
        i11 = i8;
        if ((i11 & 9363) == 9362) {
        }
        if (i12 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        companion = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
        ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor222 = companion2222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222, companion2222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion2222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion2222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion2222.getSetModifier());
        ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
        ProfileAssetsEmptyCardKt.ProfileItemsEmptyCard(null, i5, description, str7, startRestartGroup, (i11 << 3) & 8176, 1);
        startRestartGroup.startReplaceGroup(1956635181);
        if (str5 != null) {
        }
        startRestartGroup.endReplaceGroup();
        SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance222, companion, 1.0f, false, 2, null), startRestartGroup, 0);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function03 = function02;
        str3 = str7;
        str6 = str5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileItemsEmptyView$lambda$1(int i5, String str, String str2, String str3, Function0 function0, int i6, int i7, Composer composer, int i8) {
        ProfileItemsEmptyView(i5, str, str2, str3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
