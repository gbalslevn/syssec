package dk.molslinjen.ui.views.screens.booking.food;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import com.ramcosta.composedestinations.generated.destinations.CheckoutDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.addons.ProductsViewKt;
import dk.molslinjen.ui.views.screens.booking.food.FoodScreenKt;
import dk.molslinjen.ui.views.screens.booking.food.FoodViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutButtonSheetBottomBarKt;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001ae\u0010\u0018\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0014H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0003¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/food/FoodViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "checkoutExpirationDialogHandler", BuildConfig.FLAVOR, "FoodScreen", "(Ldk/molslinjen/ui/views/screens/booking/food/FoodViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/food/FoodViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "addonState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "editState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutState", "Lkotlin/Function0;", "proceed", "showTicketDetails", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, "onQuantityChanged", "FoodContent", "(Ldk/molslinjen/ui/views/screens/booking/food/FoodViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "Landroidx/compose/ui/text/AnnotatedString;", "buildTitle", "(Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/booking/DepartureDirection;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FoodScreenKt {

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

    private static final void FoodContent(final FoodViewModel.ViewState viewState, final AddonHelper.AddonState addonState, final EditManager.EditState editState, final CheckoutManager.CheckoutState checkoutState, final Function0<Unit> function0, final Function0<Unit> function02, final Function2<? super Product, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1151030334);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
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
        if ((599187 & i6) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1151030334, i6, -1, "dk.molslinjen.ui.views.screens.booking.food.FoodContent (FoodScreen.kt:83)");
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
            ProductsViewKt.ProductsView(ColumnScopeInstance.INSTANCE, viewState.getIsLoading(), addonState.getFood(), buildTitle(viewState.getBookingType(), viewState.getDepartureDirection(), startRestartGroup, 0), false, StringResources_androidKt.stringResource(R.string.food_empty, startRestartGroup, 6), addonState.getUnavailableFood(), null, R.drawable.icon_no_food, function2, null, null, startRestartGroup, 100663302 | ((i6 << 9) & 1879048192), 0, 1608);
            CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar(ModifierExtensionsKt.topShadow(companion), StringResources_androidKt.stringResource(R.string.checkout_buttonBar_proceed, startRestartGroup, 6), checkoutState.getPriceDetails().getTotalPrice(), editState.getIsEditing(), null, false, function02, null, function0, startRestartGroup, ((i6 << 3) & 3670016) | ((i6 << 12) & 234881024), 176);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: T2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FoodContent$lambda$8;
                    FoodContent$lambda$8 = FoodScreenKt.FoodContent$lambda$8(FoodViewModel.ViewState.this, addonState, editState, checkoutState, function0, function02, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FoodContent$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodContent$lambda$8(FoodViewModel.ViewState viewState, AddonHelper.AddonState addonState, EditManager.EditState editState, CheckoutManager.CheckoutState checkoutState, Function0 function0, Function0 function02, Function2 function2, int i5, Composer composer, int i6) {
        FoodContent(viewState, addonState, editState, checkoutState, function0, function02, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void FoodScreen(final FoodViewModel viewModel, final DestinationsNavigator navigator, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(1385320234);
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
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1385320234, i6, -1, "dk.molslinjen.ui.views.screens.booking.food.FoodScreen (FoodScreen.kt:53)");
            }
            int i7 = i6 & 112;
            checkoutExpirationDialogHandler.HandleDepartureExpiration(viewModel, navigator, startRestartGroup, i6 & 1022);
            FoodViewModel.ViewState viewState = (FoodViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            AddonHelper.AddonState addonState = (AddonHelper.AddonState) SnapshotStateKt.collectAsState(viewModel.getAddonState(), null, startRestartGroup, 0, 1).getValue();
            CheckoutManager.CheckoutState checkoutState = (CheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: T2.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit FoodScreen$lambda$0;
                            FoodScreen$lambda$0 = FoodScreenKt.FoodScreen$lambda$0(FoodViewModel.this, navigator, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return FoodScreen$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            EditManager.EditState editState = (EditManager.EditState) SnapshotStateKt.collectAsState(viewModel.getEditState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-1826763478);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: T2.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit FoodScreen$lambda$2$lambda$1;
                        FoodScreen$lambda$2$lambda$1 = FoodScreenKt.FoodScreen$lambda$2$lambda$1(FoodViewModel.this, navigator);
                        return FoodScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1826761120);
            boolean z5 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: T2.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit FoodScreen$lambda$4$lambda$3;
                        FoodScreen$lambda$4$lambda$3 = FoodScreenKt.FoodScreen$lambda$4$lambda$3(DestinationsNavigator.this);
                        return FoodScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function02 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1826757156);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new FoodScreenKt$FoodScreen$3$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            FoodContent(viewState, addonState, editState, checkoutState, function0, function02, (Function2) ((KFunction) rememberedValue3), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: T2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FoodScreen$lambda$6;
                    FoodScreen$lambda$6 = FoodScreenKt.FoodScreen$lambda$6(FoodViewModel.this, navigator, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FoodScreen$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodScreen$lambda$0(FoodViewModel foodViewModel, DestinationsNavigator destinationsNavigator, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        FoodScreen(foodViewModel, destinationsNavigator, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodScreen$lambda$2$lambda$1(FoodViewModel foodViewModel, DestinationsNavigator destinationsNavigator) {
        foodViewModel.proceed(new FoodScreenKt$FoodScreen$1$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodScreen$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CheckoutDetailsScreenDestination.INSTANCE.invoke(TicketSection.Food), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodScreen$lambda$6(FoodViewModel foodViewModel, DestinationsNavigator destinationsNavigator, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        FoodScreen(foodViewModel, destinationsNavigator, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final AnnotatedString buildTitle(BookingType bookingType, DepartureDirection departureDirection, Composer composer, int i5) {
        String stringResource;
        composer.startReplaceGroup(571520239);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(571520239, i5, -1, "dk.molslinjen.ui.views.screens.booking.food.buildTitle (FoodScreen.kt:107)");
        }
        composer.startReplaceGroup(-1908081333);
        if (bookingType == BookingType.Single) {
            AnnotatedString annotatedString = new AnnotatedString(StringResources_androidKt.stringResource(R.string.food_pageTitle, composer, 6), null, null, 6, null);
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
            composer.startReplaceGroup(-1908074987);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_outboundTravel, composer, 6);
            composer.endReplaceGroup();
        } else {
            if (i6 != 2) {
                composer.startReplaceGroup(-1908076969);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(-1908072077);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_returnTravel, composer, 6);
            composer.endReplaceGroup();
        }
        String lowerCase = stringResource.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String stringResource2 = StringResources_androidKt.stringResource(R.string.food_pageTitle_withDirection, new Object[]{lowerCase}, composer, 6);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) stringResource2, lowerCase, 0, false, 6, (Object) null);
        AnnotatedString annotatedString2 = new AnnotatedString(stringResource2, CollectionsKt.mutableListOf(new AnnotatedString.Range(new SpanStyle(AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65534, null), indexOf$default, lowerCase.length() + indexOf$default)), null, 4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return annotatedString2;
    }
}
