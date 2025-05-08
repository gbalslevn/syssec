package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.compose.LifecycleEffectKt;
import com.ramcosta.composedestinations.generated.destinations.CheckoutDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FerryFloorSectionsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FerrySectionSeatsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsScreenKt;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutButtonSheetBottomBarKt;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001aI\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0003¢\u0006\u0004\b\u001f\u0010 \u001a\u001f\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0003¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "checkoutExpirationDialogHandler", BuildConfig.FLAVOR, "AddonsScreen", "(Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "addonState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "editState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutState", "Lkotlin/Function0;", "proceed", "showTicketDetails", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, "onQuantityChanged", "onStartSeatSelection", "onStartSeatsEdit", "retrySeatSync", "AddonsContent", "(Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "selectSeatingGroup", "SelectSeatingSectionView", "(Ldk/molslinjen/domain/model/booking/product/ProductGroup;Ldk/molslinjen/ui/views/screens/booking/addons/AddonsViewModel$ViewState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "Landroidx/compose/ui/text/AnnotatedString;", "buildTitle", "(Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/booking/DepartureDirection;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AddonsScreenKt {

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

    private static final void AddonsContent(final AddonsViewModel.ViewState viewState, final AddonHelper.AddonState addonState, final EditManager.EditState editState, final CheckoutManager.CheckoutState checkoutState, final Function0<Unit> function0, final Function0<Unit> function02, final Function2<? super Product, ? super Integer, Unit> function2, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Composer composer, final int i5) {
        int i6;
        int i7;
        int i8;
        ComposableLambda rememberComposableLambda;
        Composer startRestartGroup = composer.startRestartGroup(804998865);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(addonState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(editState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(checkoutState) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function04) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function05) ? 536870912 : 268435456;
        }
        int i9 = i6;
        if ((306783379 & i9) == 306783378 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(804998865, i9, -1, "dk.molslinjen.ui.views.screens.booking.addons.AddonsContent (AddonsScreen.kt:120)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion, AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            DepartureDirection departureDirection = viewState.getDepartureDirection();
            startRestartGroup.startReplaceGroup(-969904764);
            AnnotatedString buildTitle = departureDirection == null ? null : buildTitle(viewState.getBookingType(), departureDirection, startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            boolean isLoading = viewState.getIsLoading();
            List<ProductGroup> productGroups = addonState.getProductGroups();
            String stringResource = StringResources_androidKt.stringResource(R.string.addons_empty, startRestartGroup, 6);
            List<UnavailableProduct> unavailableProducts = addonState.getUnavailableProducts();
            PriceWithCurrency unavailableSeatReservationPrice = viewState.getUnavailableSeatReservationPrice();
            final ProductGroup selectSeatingGroup = addonState.getSelectSeatingGroup();
            startRestartGroup.startReplaceGroup(-969884235);
            if (selectSeatingGroup == null) {
                i7 = i9;
                rememberComposableLambda = null;
                i8 = 6;
            } else {
                i7 = i9;
                i8 = 6;
                rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-829123845, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.AddonsScreenKt$AddonsContent$1$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i10) {
                        if ((i10 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-829123845, i10, -1, "dk.molslinjen.ui.views.screens.booking.addons.AddonsContent.<anonymous>.<anonymous>.<anonymous> (AddonsScreen.kt:137)");
                        }
                        AddonsScreenKt.SelectSeatingSectionView(ProductGroup.this, viewState, function03, function04, function05, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54);
            }
            startRestartGroup.endReplaceGroup();
            ProductsViewKt.ProductsView(columnScopeInstance, isLoading, productGroups, buildTitle, false, stringResource, unavailableProducts, unavailableSeatReservationPrice, R.drawable.icon_no_addons, function2, null, rememberComposableLambda, startRestartGroup, 100663302 | ((i7 << 9) & 1879048192), 0, 520);
            CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar(ModifierExtensionsKt.topShadow(companion), StringResources_androidKt.stringResource(R.string.checkout_buttonBar_proceed, startRestartGroup, i8), checkoutState.getPriceDetails().getTotalPrice(), editState.getIsEditing(), null, false, function02, null, function0, startRestartGroup, ((i7 << 3) & 3670016) | ((i7 << 12) & 234881024), 176);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddonsContent$lambda$18;
                    AddonsContent$lambda$18 = AddonsScreenKt.AddonsContent$lambda$18(AddonsViewModel.ViewState.this, addonState, editState, checkoutState, function0, function02, function2, function03, function04, function05, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddonsContent$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonsContent$lambda$18(AddonsViewModel.ViewState viewState, AddonHelper.AddonState addonState, EditManager.EditState editState, CheckoutManager.CheckoutState checkoutState, Function0 function0, Function0 function02, Function2 function2, Function0 function03, Function0 function04, Function0 function05, int i5, Composer composer, int i6) {
        AddonsContent(viewState, addonState, editState, checkoutState, function0, function02, function2, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void AddonsScreen(final AddonsViewModel viewModel, final DestinationsNavigator navigator, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(1373048160);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= (i5 & 512) == 0 ? startRestartGroup.changed(checkoutExpirationDialogHandler) : startRestartGroup.changedInstance(checkoutExpirationDialogHandler) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1373048160, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.AddonsScreen (AddonsScreen.kt:64)");
            }
            int i7 = i6 & 112;
            checkoutExpirationDialogHandler.HandleDepartureExpiration(viewModel, navigator, startRestartGroup, i6 & 1022);
            final AddonsViewModel.ViewState viewState = (AddonsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            AddonHelper.AddonState addonState = (AddonHelper.AddonState) SnapshotStateKt.collectAsState(viewModel.getAddonState(), null, startRestartGroup, 0, 1).getValue();
            EditManager.EditState editState = (EditManager.EditState) SnapshotStateKt.collectAsState(viewModel.getEditState(), null, startRestartGroup, 0, 1).getValue();
            CheckoutManager.CheckoutState checkoutState = (CheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: D2.d
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AddonsScreen$lambda$0;
                            AddonsScreen$lambda$0 = AddonsScreenKt.AddonsScreen$lambda$0(AddonsViewModel.this, navigator, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return AddonsScreen$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            startRestartGroup.startReplaceGroup(-1942222860);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AddonsScreenKt$AddonsScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LifecycleEffectKt.LifecycleEventEffect(event, null, (Function0) ((KFunction) rememberedValue), startRestartGroup, 6, 2);
            startRestartGroup.startReplaceGroup(-1942216706);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: D2.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddonsScreen$lambda$3$lambda$2;
                        AddonsScreen$lambda$3$lambda$2 = AddonsScreenKt.AddonsScreen$lambda$3$lambda$2(AddonsViewModel.this, navigator);
                        return AddonsScreen$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1942213726);
            boolean z5 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: D2.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddonsScreen$lambda$5$lambda$4;
                        AddonsScreen$lambda$5$lambda$4 = AddonsScreenKt.AddonsScreen$lambda$5$lambda$4(DestinationsNavigator.this);
                        return AddonsScreen$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1942209700);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new AddonsScreenKt$AddonsScreen$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Function2 function2 = (Function2) ((KFunction) rememberedValue4);
            startRestartGroup.startReplaceGroup(-1942207631);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewState) | (i7 == 32);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: D2.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddonsScreen$lambda$9$lambda$8;
                        AddonsScreen$lambda$9$lambda$8 = AddonsScreenKt.AddonsScreen$lambda$9$lambda$8(AddonsViewModel.ViewState.this, navigator);
                        return AddonsScreen$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function03 = (Function0) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1942201906);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewState) | (i7 == 32);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: D2.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddonsScreen$lambda$12$lambda$11;
                        AddonsScreen$lambda$12$lambda$11 = AddonsScreenKt.AddonsScreen$lambda$12$lambda$11(AddonsViewModel.ViewState.this, navigator);
                        return AddonsScreen$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            Function0 function04 = (Function0) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1942191688);
            boolean changedInstance6 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new AddonsScreenKt$AddonsScreen$7$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            AddonsContent(viewState, addonState, editState, checkoutState, function0, function02, function2, function03, function04, (Function0) ((KFunction) rememberedValue7), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: D2.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddonsScreen$lambda$14;
                    AddonsScreen$lambda$14 = AddonsScreenKt.AddonsScreen$lambda$14(AddonsViewModel.this, navigator, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddonsScreen$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonsScreen$lambda$0(AddonsViewModel addonsViewModel, DestinationsNavigator destinationsNavigator, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        AddonsScreen(addonsViewModel, destinationsNavigator, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonsScreen$lambda$12$lambda$11(AddonsViewModel.ViewState viewState, DestinationsNavigator destinationsNavigator) {
        DepartureDirection departureDirection = viewState.getDepartureDirection();
        if (departureDirection != null) {
            DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, FerrySectionSeatsScreenDestination.m3070invokeb0fnrdo$default(FerrySectionSeatsScreenDestination.INSTANCE, null, departureDirection, null, 4, null), null, null, 6, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonsScreen$lambda$14(AddonsViewModel addonsViewModel, DestinationsNavigator destinationsNavigator, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        AddonsScreen(addonsViewModel, destinationsNavigator, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonsScreen$lambda$3$lambda$2(AddonsViewModel addonsViewModel, DestinationsNavigator destinationsNavigator) {
        addonsViewModel.proceed(new AddonsScreenKt$AddonsScreen$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonsScreen$lambda$5$lambda$4(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CheckoutDetailsScreenDestination.INSTANCE.invoke(TicketSection.Addons), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonsScreen$lambda$9$lambda$8(AddonsViewModel.ViewState viewState, DestinationsNavigator destinationsNavigator) {
        DepartureDirection departureDirection = viewState.getDepartureDirection();
        if (departureDirection != null) {
            DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, FerryFloorSectionsScreenDestination.INSTANCE.invoke(departureDirection), null, null, 6, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectSeatingSectionView(final ProductGroup productGroup, final AddonsViewModel.ViewState viewState, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i5) {
        int i6;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(1127155089);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(productGroup) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(viewState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1127155089, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.SelectSeatingSectionView (AddonsScreen.kt:166)");
            }
            Iterator<T> it = productGroup.getProducts().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((Product) obj).getProductType() == ProductType.SelectSeating) {
                        break;
                    }
                }
            }
            Product product = (Product) obj;
            if (product != null) {
                Modifier.Companion companion = Modifier.INSTANCE;
                TextKt.m940Text4IGK_g(productGroup.getName(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(16), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 48, 1572864, 65532);
                Modifier defaultShadow$default = ModifierExtensionsKt.defaultShadow$default(companion, null, 1, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, defaultShadow$default);
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
                Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                SeatReservationAddonViewKt.SeatReservationAddonView(false, product, viewState.getNumberOfPassengers(), viewState.getSeatReservation(), function0, function02, function03, startRestartGroup, (i6 << 6) & 4186112, 1);
                startRestartGroup.endNode();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SelectSeatingSectionView$lambda$22;
                    SelectSeatingSectionView$lambda$22 = AddonsScreenKt.SelectSeatingSectionView$lambda$22(ProductGroup.this, viewState, function0, function02, function03, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return SelectSeatingSectionView$lambda$22;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectSeatingSectionView$lambda$22(ProductGroup productGroup, AddonsViewModel.ViewState viewState, Function0 function0, Function0 function02, Function0 function03, int i5, Composer composer, int i6) {
        SelectSeatingSectionView(productGroup, viewState, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final AnnotatedString buildTitle(BookingType bookingType, DepartureDirection departureDirection, Composer composer, int i5) {
        String stringResource;
        composer.startReplaceGroup(-1178812667);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1178812667, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.buildTitle (AddonsScreen.kt:189)");
        }
        composer.startReplaceGroup(629570200);
        if (bookingType == BookingType.Single) {
            AnnotatedString annotatedString = new AnnotatedString(StringResources_androidKt.stringResource(R.string.addons_pageTitle, composer, 6), null, null, 6, null);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return annotatedString;
        }
        composer.endReplaceGroup();
        int i6 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i6 == 1) {
            composer.startReplaceGroup(629576608);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_outboundTravel, composer, 6);
            composer.endReplaceGroup();
        } else {
            if (i6 != 2) {
                composer.startReplaceGroup(629574626);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(629579518);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_returnTravel, composer, 6);
            composer.endReplaceGroup();
        }
        String lowerCase = stringResource.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String stringResource2 = StringResources_androidKt.stringResource(R.string.addons_pageTitle_withDirection, new Object[]{lowerCase}, composer, 6);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) stringResource2, lowerCase, 0, false, 6, (Object) null);
        AnnotatedString annotatedString2 = new AnnotatedString(stringResource2, CollectionsKt.mutableListOf(new AnnotatedString.Range(new SpanStyle(AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65534, null), indexOf$default, lowerCase.length() + indexOf$default)), null, 4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return annotatedString2;
    }
}
