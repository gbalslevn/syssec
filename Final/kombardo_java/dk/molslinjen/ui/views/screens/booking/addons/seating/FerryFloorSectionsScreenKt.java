package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionsScreenKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.sections.FerrySectionViewKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatingSectionId;
import uniffi.molslinjen_shared.FerrySeatingSectionOverview;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001ao\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n0\u0017H\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001aG\u0010!\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00192\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0011H\u0003¢\u0006\u0004\b!\u0010\"¨\u0006$²\u0006\u0010\u0010#\u001a\u0004\u0018\u00010\u001b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "bottomSheetDismissHandler", BuildConfig.FLAVOR, "FerryFloorSectionsScreen", "(Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionViewModel$ViewState;", "state", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Lkotlin/Function2;", "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "Landroidx/compose/ui/geometry/Offset;", "onSectionSelected", "Lkotlin/Function0;", "onDisabledSectionSelected", "Lkotlin/Function1;", "Luniffi/molslinjen_shared/FerrySeatingSectionOverview;", BuildConfig.FLAVOR, "isSectionEnabled", "Landroidx/compose/ui/unit/IntSize;", "updateDataForImageSize", "Content", "(Ldk/molslinjen/ui/views/screens/booking/addons/seating/FerryFloorSectionViewModel$ViewState;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "section", "enabled", "DrawSection", "(Luniffi/molslinjen_shared/FerrySeatingSectionOverview;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "imageSize", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerryFloorSectionsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final FerryFloorSectionViewModel.ViewState viewState, final ScrollState scrollState, final Function2<? super FerrySeatingSectionId, ? super Offset, Unit> function2, final Function0<Unit> function0, final Function1<? super FerrySeatingSectionOverview, Boolean> function1, final Function1<? super IntSize, Unit> function12, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(2025618987);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(scrollState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025618987, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.Content (FerryFloorSectionsScreen.kt:126)");
            }
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, viewState.getIsLoading(), 0, false, null, ComposableLambdaKt.rememberComposableLambda(-880643233, true, new FerryFloorSectionsScreenKt$Content$1(function12, viewState, scrollState, function1, function0, function2), startRestartGroup, 54), startRestartGroup, 1572870, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: E2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$4;
                    Content$lambda$4 = FerryFloorSectionsScreenKt.Content$lambda$4(FerryFloorSectionViewModel.ViewState.this, scrollState, function2, function0, function1, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$4(FerryFloorSectionViewModel.ViewState viewState, ScrollState scrollState, Function2 function2, Function0 function0, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        Content(viewState, scrollState, function2, function0, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DrawSection(final FerrySeatingSectionOverview ferrySeatingSectionOverview, final boolean z5, final Function0<Unit> function0, final Function2<? super FerrySeatingSectionId, ? super Offset, Unit> function2, Composer composer, final int i5) {
        int i6;
        long m3258getBrandBlue50d7_KjU;
        long m3257getBrandBlue40d7_KjU;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1273304908);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(ferrySeatingSectionOverview) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1273304908, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.DrawSection (FerryFloorSectionsScreen.kt:189)");
            }
            if (z5) {
                AppColor appColor = AppColor.INSTANCE;
                m3258getBrandBlue50d7_KjU = appColor.m3257getBrandBlue40d7_KjU();
                m3257getBrandBlue40d7_KjU = appColor.m3259getBrandDarkBlue10d7_KjU();
            } else {
                AppColor appColor2 = AppColor.INSTANCE;
                m3258getBrandBlue50d7_KjU = appColor2.m3258getBrandBlue50d7_KjU();
                m3257getBrandBlue40d7_KjU = appColor2.m3257getBrandBlue40d7_KjU();
            }
            long j5 = m3258getBrandBlue50d7_KjU;
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m294offsetVpY3zN4 = OffsetKt.m294offsetVpY3zN4(companion, ComposeExtensionsKt.pxToDp((int) ferrySeatingSectionOverview.getOrigin().getX(), startRestartGroup, 0), ComposeExtensionsKt.pxToDp((int) ferrySeatingSectionOverview.getOrigin().getY(), startRestartGroup, 0));
            startRestartGroup.startReplaceGroup(-1824383186);
            boolean changedInstance = startRestartGroup.changedInstance(ferrySeatingSectionOverview);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: E2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DrawSection$lambda$6$lambda$5;
                        DrawSection$lambda$6$lambda$5 = FerryFloorSectionsScreenKt.DrawSection$lambda$6$lambda$5(FerrySeatingSectionOverview.this, (SemanticsPropertyReceiver) obj);
                        return DrawSection$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(m294offsetVpY3zN4, (Function1) rememberedValue);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(442125767);
            boolean changedInstance2 = ((i6 & 112) == 32) | ((i6 & 7168) == 2048) | startRestartGroup.changedInstance(ferrySeatingSectionOverview) | ((i6 & 896) == 256);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                FerryFloorSectionsScreenKt$DrawSection$2$1$1 ferryFloorSectionsScreenKt$DrawSection$2$1$1 = new FerryFloorSectionsScreenKt$DrawSection$2$1$1(z5, function2, ferrySeatingSectionOverview, function0, null);
                startRestartGroup.updateRememberedValue(ferryFloorSectionsScreenKt$DrawSection$2$1$1);
                rememberedValue2 = ferryFloorSectionsScreenKt$DrawSection$2$1$1;
            }
            startRestartGroup.endReplaceGroup();
            FerrySectionViewKt.m3443FerrySectionViewjA1GFJw(SuspendingPointerInputFilterKt.pointerInput(companion, unit, (Function2) rememberedValue2), ferrySeatingSectionOverview.getCoordinates(), ferrySeatingSectionOverview.getSize(), j5, m3257getBrandBlue40d7_KjU, startRestartGroup, 0, 0);
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(-1824319091);
            boolean changedInstance3 = composer2.changedInstance(ferrySeatingSectionOverview);
            Object rememberedValue3 = composer2.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new FerryFloorSectionsScreenKt$DrawSection$4$1(ferrySeatingSectionOverview);
                composer2.updateRememberedValue(rememberedValue3);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
            composer2.endReplaceGroup();
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
            Updater.m1227setimpl(m1226constructorimpl2, measurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), composer2, 48);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(companion, j5, null, 2, null), Dp.m2599constructorimpl(2), 0.0f, 2, null);
            composer2.startReplaceGroup(-907107134);
            Object rememberedValue4 = composer2.rememberedValue();
            if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: E2.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DrawSection$lambda$13$lambda$12$lambda$10$lambda$9;
                        DrawSection$lambda$13$lambda$12$lambda$10$lambda$9 = FerryFloorSectionsScreenKt.DrawSection$lambda$13$lambda$12$lambda$10$lambda$9((SemanticsPropertyReceiver) obj);
                        return DrawSection$lambda$13$lambda$12$lambda$10$lambda$9;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(m313paddingVpY3zN4$default, false, (Function1) rememberedValue4, 1, null);
            composer2.startReplaceGroup(-907104497);
            Iterator it = StringsKt.split$default((CharSequence) ferrySeatingSectionOverview.getName(), new String[]{" "}, false, 0, 6, (Object) null).iterator();
            while (it.hasNext()) {
                TextKt.m940Text4IGK_g((String) it.next(), semantics$default, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), composer2, 0, 1572864, 65020);
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-907095776);
            if (ferrySeatingSectionOverview.getShowAvailableSeats() && ferrySeatingSectionOverview.getAvailableSeats() > 0) {
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.selectSeat_seatsAvailable, new Object[]{Integer.valueOf(ferrySeatingSectionOverview.getAvailableSeats())}, composer2, 6), semantics$default, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer2, 0, 1572864, 65532);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: E2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DrawSection$lambda$15;
                    DrawSection$lambda$15 = FerryFloorSectionsScreenKt.DrawSection$lambda$15(FerrySeatingSectionOverview.this, z5, function0, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DrawSection$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawSection$lambda$13$lambda$12$lambda$10$lambda$9(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.invisibleToUser(semantics);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawSection$lambda$15(FerrySeatingSectionOverview ferrySeatingSectionOverview, boolean z5, Function0 function0, Function2 function2, int i5, Composer composer, int i6) {
        DrawSection(ferrySeatingSectionOverview, z5, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawSection$lambda$6$lambda$5(FerrySeatingSectionOverview ferrySeatingSectionOverview, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, ferrySeatingSectionOverview.getName());
        SemanticsPropertiesKt.m2184setRolekuIjeqM(clearAndSetSemantics, Role.INSTANCE.m2170getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    public static final void FerryFloorSectionsScreen(final FerryFloorSectionViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetDismissHandler bottomSheetDismissHandler, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Composer startRestartGroup = composer.startRestartGroup(1232953912);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetDismissHandler) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1232953912, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionsScreen (FerryFloorSectionsScreen.kt:82)");
            }
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismiss, startRestartGroup, ((i7 >> 9) & 14) | 3072 | ((i7 >> 3) & 112) | ((i7 << 3) & 896) | (57344 & i7));
            FerryFloorSectionViewModel.ViewState viewState = (FerryFloorSectionViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.selectSeat_chooseSection, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-660094251);
            int i8 = i7 & 112;
            boolean z5 = i8 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-660092683);
            boolean z6 = i8 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, function0, (Function0) rememberedValue2, rememberScrollState, null, ComposableLambdaKt.rememberComposableLambda(-1748826101, true, new FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3(viewState, rememberScrollState, navigator, viewModel), startRestartGroup, 54), composer2, 805306374, 282);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: E2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FerryFloorSectionsScreen$lambda$3;
                    FerryFloorSectionsScreen$lambda$3 = FerryFloorSectionsScreenKt.FerryFloorSectionsScreen$lambda$3(FerryFloorSectionViewModel.this, navigator, navController, navBackStackEntry, bottomSheetDismissHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FerryFloorSectionsScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerryFloorSectionsScreen$lambda$3(FerryFloorSectionViewModel ferryFloorSectionViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetDismissHandler bottomSheetDismissHandler, int i5, Composer composer, int i6) {
        FerryFloorSectionsScreen(ferryFloorSectionViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetDismissHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
