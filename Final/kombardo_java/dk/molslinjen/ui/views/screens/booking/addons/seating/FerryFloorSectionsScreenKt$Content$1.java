package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import coil.compose.SingletonAsyncImageKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import uniffi.molslinjen_shared.FerrySeatingSectionId;
import uniffi.molslinjen_shared.FerrySeatingSectionOverview;
import uniffi.molslinjen_shared.Point;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FerryFloorSectionsScreenKt$Content$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function1<FerrySeatingSectionOverview, Boolean> $isSectionEnabled;
    final /* synthetic */ Function0<Unit> $onDisabledSectionSelected;
    final /* synthetic */ Function2<FerrySeatingSectionId, Offset, Unit> $onSectionSelected;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ FerryFloorSectionViewModel.ViewState $state;
    final /* synthetic */ Function1<IntSize, Unit> $updateDataForImageSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public FerryFloorSectionsScreenKt$Content$1(Function1<? super IntSize, Unit> function1, FerryFloorSectionViewModel.ViewState viewState, ScrollState scrollState, Function1<? super FerrySeatingSectionOverview, Boolean> function12, Function0<Unit> function0, Function2<? super FerrySeatingSectionId, ? super Offset, Unit> function2) {
        this.$updateDataForImageSize = function1;
        this.$state = viewState;
        this.$scrollState = scrollState;
        this.$isSectionEnabled = function12;
        this.$onDisabledSectionSelected = function0;
        this.$onSectionSelected = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntSize invoke$lambda$1(MutableState<IntSize> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$11$lambda$10$lambda$7$lambda$6(MutableState mutableState, IntSize intSize) {
        if (!(intSize == null ? false : IntSize.m2659equalsimpl0(intSize.getPackedValue(), IntSize.INSTANCE.m2665getZeroYbymL2g()))) {
            mutableState.setValue(intSize);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-880643233, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.Content.<anonymous> (FerryFloorSectionsScreen.kt:131)");
        }
        composer.startReplaceGroup(164566215);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        IntSize invoke$lambda$1 = invoke$lambda$1(mutableState);
        composer.startReplaceGroup(164568711);
        boolean changed = composer.changed(this.$updateDataForImageSize);
        Function1<IntSize, Unit> function1 = this.$updateDataForImageSize;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new FerryFloorSectionsScreenKt$Content$1$1$1(mutableState, function1, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(invoke$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, 0);
        Object selectedFloorImageUrl = this.$state.getSelectedFloorImageUrl();
        Object selectedFloorImageUrl2 = this.$state.getSelectedFloorImageUrl();
        composer.startReplaceGroup(164572810);
        boolean changed2 = composer.changed(selectedFloorImageUrl) | composer.changed(selectedFloorImageUrl2);
        FerryFloorSectionViewModel.ViewState viewState = this.$state;
        Object rememberedValue3 = composer.rememberedValue();
        if (changed2 || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = viewState.getSelectedFloorImageUrl();
            composer.updateRememberedValue(rememberedValue3);
        }
        String str = (String) rememberedValue3;
        composer.endReplaceGroup();
        Point focusPoint = this.$state.getFocusPoint();
        composer.startReplaceGroup(164579792);
        boolean changedInstance = composer.changedInstance(focusPoint) | composer.changed(this.$scrollState);
        ScrollState scrollState = this.$scrollState;
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance || rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new FerryFloorSectionsScreenKt$Content$1$2$1(focusPoint, scrollState, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(focusPoint, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, composer, 0);
        ScrollState scrollState2 = this.$scrollState;
        FerryFloorSectionViewModel.ViewState viewState2 = this.$state;
        Function1<FerrySeatingSectionOverview, Boolean> function12 = this.$isSectionEnabled;
        Function0<Unit> function0 = this.$onDisabledSectionSelected;
        Function2<FerrySeatingSectionId, Offset, Unit> function2 = this.$onSectionSelected;
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
        Alignment.Companion companion3 = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion2);
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion4.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), scrollState2, false, null, false, 14, null), Dp.m2599constructorimpl(16));
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m311padding3ABfNKs);
        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceGroup(-590304526);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$11$lambda$10$lambda$7$lambda$6;
                    invoke$lambda$11$lambda$10$lambda$7$lambda$6 = FerryFloorSectionsScreenKt$Content$1.invoke$lambda$11$lambda$10$lambda$7$lambda$6(MutableState.this, (IntSize) obj);
                    return invoke$lambda$11$lambda$10$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        SingletonAsyncImageKt.m2743AsyncImage3HmZ8SU(str, Accessibility.INSTANCE.getSkip(), OnRemeasuredModifierKt.onSizeChanged(companion2, (Function1) rememberedValue5), null, null, null, ContentScale.INSTANCE.getFillWidth(), 0.0f, null, 0, composer, 1573248, 952);
        List<FerrySeatingSectionOverview> ferrySections = viewState2.getFerrySections();
        composer.startReplaceGroup(-590292712);
        if (ferrySections != null) {
            composer.startReplaceGroup(-590291831);
            for (FerrySeatingSectionOverview ferrySeatingSectionOverview : ferrySections) {
                FerryFloorSectionsScreenKt.DrawSection(ferrySeatingSectionOverview, function12.invoke(ferrySeatingSectionOverview).booleanValue(), function0, function2, composer, 0);
            }
            composer.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
        }
        composer.endReplaceGroup();
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
