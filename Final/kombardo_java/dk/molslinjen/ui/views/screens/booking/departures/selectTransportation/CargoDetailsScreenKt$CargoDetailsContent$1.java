package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.SegmentedControlKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CargoDetailsScreenKt$CargoDetailsContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function1<DepartureDirection, Unit> $changeSection;
    final /* synthetic */ Function1<String, Unit> $onNote1Change;
    final /* synthetic */ Function1<String, Unit> $onNote2Change;
    final /* synthetic */ Function1<String, Unit> $onNote3Change;
    final /* synthetic */ Function1<String, Unit> $onTotalWeightChange;
    final /* synthetic */ IFormValidator $outboundValidator;
    final /* synthetic */ IFormValidator $returnValidator;
    final /* synthetic */ CargoDetailsViewModel.ViewState $viewState;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public CargoDetailsScreenKt$CargoDetailsContent$1(CargoDetailsViewModel.ViewState viewState, Function1<? super DepartureDirection, Unit> function1, Function1<? super String, Unit> function12, Function1<? super String, Unit> function13, Function1<? super String, Unit> function14, Function1<? super String, Unit> function15, IFormValidator iFormValidator, IFormValidator iFormValidator2) {
        this.$viewState = viewState;
        this.$changeSection = function1;
        this.$onTotalWeightChange = function12;
        this.$onNote1Change = function13;
        this.$onNote2Change = function14;
        this.$onNote3Change = function15;
        this.$outboundValidator = iFormValidator;
        this.$returnValidator = iFormValidator2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(Function1 function1, List list, int i5) {
        function1.invoke(list.get(i5));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        Function1<String, Unit> function1;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1793655653, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsContent.<anonymous> (CargoDetailsScreen.kt:167)");
        }
        FocusManager focusManager = (FocusManager) composer.consume(CompositionLocalsKt.getLocalFocusManager());
        composer.startReplaceGroup(2067988830);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new FocusRequester();
            composer.updateRememberedValue(rememberedValue);
        }
        FocusRequester focusRequester = (FocusRequester) rememberedValue;
        composer.endReplaceGroup();
        Modifier.Companion companion2 = Modifier.INSTANCE;
        float f5 = 24;
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(ModifierExtensionsKt.closeKeyboardOnClickOutside(companion2, focusManager), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(f5), 5, null);
        CargoDetailsViewModel.ViewState viewState = this.$viewState;
        final Function1<DepartureDirection, Unit> function12 = this.$changeSection;
        Function1<String, Unit> function13 = this.$onTotalWeightChange;
        Function1<String, Unit> function14 = this.$onNote1Change;
        Function1<String, Unit> function15 = this.$onNote2Change;
        Function1<String, Unit> function16 = this.$onNote3Change;
        IFormValidator iFormValidator = this.$outboundValidator;
        IFormValidator iFormValidator2 = this.$returnValidator;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m315paddingqDBjuR0$default);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composer.startReplaceGroup(-1385378475);
        if (viewState.getHasReturn()) {
            final List listOf = CollectionsKt.listOf((Object[]) new DepartureDirection[]{DepartureDirection.Outbound, DepartureDirection.Return});
            List listOf2 = CollectionsKt.listOf((Object[]) new String[]{StringResources_androidKt.stringResource(R.string.departures_tab_outbound, composer, 6), StringResources_androidKt.stringResource(R.string.departures_tab_return, composer, 6)});
            int indexOf = listOf.indexOf(viewState.getActiveDirectionTab());
            composer.startReplaceGroup(-1385362854);
            boolean changed = composer.changed(function12);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$3$lambda$2$lambda$1;
                        invoke$lambda$3$lambda$2$lambda$1 = CargoDetailsScreenKt$CargoDetailsContent$1.invoke$lambda$3$lambda$2$lambda$1(Function1.this, listOf, ((Integer) obj).intValue());
                        return invoke$lambda$3$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            function1 = function16;
            SegmentedControlKt.SegmentedControlStrings(null, listOf2, indexOf, (Function1) rememberedValue2, composer, 0, 1);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(32)), composer, 6);
        } else {
            function1 = function16;
        }
        composer.endReplaceGroup();
        int i6 = WhenMappings.$EnumSwitchMapping$0[viewState.getActiveDirectionTab().ordinal()];
        if (i6 == 1) {
            composer.startReplaceGroup(-1385350221);
            CargoDetailsInputKt.CargoDetailsInput(columnScopeInstance, viewState.getOutboundCargoInfo(), viewState.getIsWeightRequired(), viewState.getNotesRequired(), viewState.getMaxWeightAllowed(), function13, function14, function15, function1, iFormValidator, focusRequester, composer, 6, 6);
            composer.endReplaceGroup();
        } else if (i6 == 2) {
            composer.startReplaceGroup(-1385327973);
            CargoDetailsInputKt.CargoDetailsInput(columnScopeInstance, viewState.getReturnCargoInfo(), viewState.getIsWeightRequired(), viewState.getNotesRequired(), viewState.getMaxWeightAllowed(), function13, function14, function15, function1, iFormValidator2, focusRequester, composer, 6, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1385352108);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        }
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
