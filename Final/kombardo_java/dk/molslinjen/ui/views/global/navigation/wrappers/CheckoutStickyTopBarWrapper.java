package dk.molslinjen.ui.views.global.navigation.wrappers;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.generated.destinations.AddonsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FoodScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengersScreenDestination;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.wrapper.DestinationWrapper;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.ui.views.global.navigation.wrappers.CheckoutStickyTopBarWrapper;
import dk.molslinjen.ui.views.screens.booking.checkout.CheckoutViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutTopBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/wrappers/CheckoutStickyTopBarWrapper;", "Lcom/ramcosta/composedestinations/wrapper/DestinationWrapper;", "<init>", "()V", "T", "Lcom/ramcosta/composedestinations/scope/DestinationScope;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "screenContent", "Wrap", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutStickyTopBarWrapper implements DestinationWrapper {
    public static final CheckoutStickyTopBarWrapper INSTANCE = new CheckoutStickyTopBarWrapper();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketSection.values().length];
            try {
                iArr[TicketSection.Passenger.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketSection.Addons.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketSection.Food.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketSection.Summary.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CheckoutStickyTopBarWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Wrap$lambda$3$lambda$2$lambda$1(CheckoutViewModel checkoutViewModel, DestinationScope destinationScope, TicketSection section) {
        Intrinsics.checkNotNullParameter(section, "section");
        DepartureDirection departureDirection = checkoutViewModel.getReturnState().getValue().getIsAddingReturnFromBookingSummary() ? DepartureDirection.Return : DepartureDirection.Outbound;
        checkoutViewModel.trackNavigatingBackToSection(section);
        int i5 = WhenMappings.$EnumSwitchMapping$0[section.ordinal()];
        if (i5 == 1) {
            NavController.popBackStack$default(destinationScope.getNavController(), PassengersScreenDestination.INSTANCE.invoke(departureDirection), false, false, 4, null);
        } else if (i5 == 2) {
            NavController.popBackStack$default(destinationScope.getNavController(), AddonsScreenDestination.INSTANCE.invoke(departureDirection), false, false, 4, null);
        } else if (i5 == 3) {
            NavController.popBackStack$default(destinationScope.getNavController(), FoodScreenDestination.INSTANCE.invoke(departureDirection), false, false, 4, null);
        } else if (i5 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    @Override // com.ramcosta.composedestinations.wrapper.DestinationWrapper
    public <T> void Wrap(final DestinationScope<T> destinationScope, Function2<? super Composer, ? super Integer, Unit> screenContent, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        Intrinsics.checkNotNullParameter(screenContent, "screenContent");
        composer.startReplaceGroup(-1560512008);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1560512008, i5, -1, "dk.molslinjen.ui.views.global.navigation.wrappers.CheckoutStickyTopBarWrapper.Wrap (CheckoutStickyTopBarWrapper.kt:19)");
        }
        composer.startReplaceableGroup(1890788296);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
        }
        ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CheckoutViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        final CheckoutViewModel checkoutViewModel = (CheckoutViewModel) viewModel;
        TypedDestinationSpec<T> destination = destinationScope.getDestination();
        composer.startReplaceGroup(-442915564);
        int i6 = (i5 & 14) ^ 6;
        boolean changedInstance = composer.changedInstance(checkoutViewModel) | ((i6 > 4 && composer.changed(destinationScope)) || (i5 & 6) == 4);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new CheckoutStickyTopBarWrapper$Wrap$1$1(checkoutViewModel, destinationScope, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(destination, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer, 0);
        CheckoutViewModel.ViewState viewState = (CheckoutViewModel.ViewState) SnapshotStateKt.collectAsState(checkoutViewModel.getViewState(), null, composer, 0, 1).getValue();
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        List<TicketSection> checkoutSections = viewState.getCheckoutSections();
        TicketSection activeSection = viewState.getActiveSection();
        boolean showClickableTopBar = checkoutViewModel.getShowClickableTopBar();
        composer.startReplaceGroup(-50914436);
        boolean changedInstance2 = composer.changedInstance(checkoutViewModel) | ((i6 > 4 && composer.changed(destinationScope)) || (i5 & 6) == 4);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: U1.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit Wrap$lambda$3$lambda$2$lambda$1;
                    Wrap$lambda$3$lambda$2$lambda$1 = CheckoutStickyTopBarWrapper.Wrap$lambda$3$lambda$2$lambda$1(CheckoutViewModel.this, destinationScope, (TicketSection) obj);
                    return Wrap$lambda$3$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        CheckoutTopBarKt.CheckoutTopBar(checkoutSections, activeSection, showClickableTopBar, (Function1) rememberedValue2, composer, 0);
        screenContent.invoke(composer, Integer.valueOf((i5 >> 3) & 14));
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}
