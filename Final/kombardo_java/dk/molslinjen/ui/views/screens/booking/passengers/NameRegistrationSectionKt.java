package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.model.booking.AgeGroup;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.extensions.domain.AgeGroupExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.reusable.input.SwitchRowKt;
import dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÙ\u0001\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u001c\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u008d\u0001\u0010$\u001a\u00020\u0006*\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110 2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b$\u0010%\u001aI\u0010*\u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110 2\u0006\u0010&\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0003H\u0003¢\u0006\u0004\b*\u0010+\u001aM\u0010/\u001a\u00020\u0006*\u00020\u001f2\u0006\u0010(\u001a\u00020'2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010-\u001a\u00020,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110 2\u0006\u0010)\u001a\u00020\u0003H\u0002¢\u0006\u0004\b/\u00100¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScope;", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "passengerState", BuildConfig.FLAVOR, "isInEditMode", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onCurrentUserCreatedAsPassenger", "showHelp", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "nationalityResultRecipient", "navigateToNationalitySelection", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "toggleSelected", "createPassenger", "Landroid/content/Context;", "context", "Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel$ViewState;", "state", BuildConfig.FLAVOR, "editPassenger", "showAgeGroupError", "changeSameReturnPassengersAsOutbound", "movePassengerInfo", "NameRegistrationSection", "(Landroidx/compose/foundation/layout/ColumnScope;Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroid/content/Context;Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "selectedPassengers", "titleOverSelection", "samePassengersAsOutbound", "passengerSelectionSection", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroid/content/Context;Ljava/lang/String;Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel$ViewState;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "showAgeGroup", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "enabled", "PassengersHorizontalList", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;Ldk/molslinjen/domain/model/booking/PassengerInfo;ZLandroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/AgeGroup;", "ageGroup", "passengers", "addAgeGroupedItems", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/PassengerInfo;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/domain/model/booking/AgeGroup;Ljava/util/List;Z)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NameRegistrationSectionKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgeGroup.values().length];
            try {
                iArr[AgeGroup.Adult.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgeGroup.Child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgeGroup.Infant.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void NameRegistrationSection(final ColumnScope columnScope, final PassengerSelectionHelper.PassengerState passengerState, final boolean z5, final Function0<Unit> onCurrentUserCreatedAsPassenger, final Function0<Unit> showHelp, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, final Function0<Unit> navigateToNationalitySelection, final CheckoutManager.CheckoutState checkoutState, final Function1<? super BookingPassenger, Unit> toggleSelected, final Function0<Unit> createPassenger, final Context context, final PassengersViewModel.ViewState state, final Function1<? super String, Unit> editPassenger, final Function0<Unit> showAgeGroupError, final Function1<? super Boolean, Unit> changeSameReturnPassengersAsOutbound, final boolean z6, Composer composer, final int i5, final int i6) {
        int i7;
        boolean z7;
        int i8;
        Composer composer2;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(passengerState, "passengerState");
        Intrinsics.checkNotNullParameter(onCurrentUserCreatedAsPassenger, "onCurrentUserCreatedAsPassenger");
        Intrinsics.checkNotNullParameter(showHelp, "showHelp");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Intrinsics.checkNotNullParameter(navigateToNationalitySelection, "navigateToNationalitySelection");
        Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
        Intrinsics.checkNotNullParameter(toggleSelected, "toggleSelected");
        Intrinsics.checkNotNullParameter(createPassenger, "createPassenger");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(editPassenger, "editPassenger");
        Intrinsics.checkNotNullParameter(showAgeGroupError, "showAgeGroupError");
        Intrinsics.checkNotNullParameter(changeSameReturnPassengersAsOutbound, "changeSameReturnPassengersAsOutbound");
        Composer startRestartGroup = composer.startRestartGroup(-684818273);
        if ((i5 & 6) == 0) {
            i7 = i5 | (startRestartGroup.changed(columnScope) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(passengerState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            z7 = z5;
            i7 |= startRestartGroup.changed(z7) ? 256 : 128;
        } else {
            z7 = z5;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(onCurrentUserCreatedAsPassenger) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(showHelp) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changed(nationalityResultRecipient) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(navigateToNationalitySelection) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(checkoutState) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(toggleSelected) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(createPassenger) ? 536870912 : 268435456;
        }
        int i9 = i7;
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(context) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(editPassenger) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(showAgeGroupError) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(changeSameReturnPassengersAsOutbound) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i8 |= startRestartGroup.changed(z6) ? 131072 : 65536;
        }
        int i10 = i8;
        if ((i9 & 306783379) == 306783378 && (74899 & i10) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-684818273, i9, i10, "dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSection (NameRegistrationSection.kt:56)");
            }
            boolean z8 = state.getBookingType() == BookingType.TwoWay && state.getDepartureDirection() == DepartureDirection.Return && state.getSameReturnPassengersAsOutbound();
            if (passengerState.getCurrentUser() != null || z7) {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1525854584);
                final List filterNotNull = CollectionsKt.filterNotNull((!passengerState.getCurrentUserSelected() || passengerState.getCurrentUser() == null) ? passengerState.getSelectedPassengers() : CollectionsKt.plus((Collection<? extends BookingPassenger>) passengerState.getSelectedPassengers(), passengerState.getCurrentUser()));
                final String stringResource = StringResources_androidKt.stringResource(R.string.passengers_previousCoPassengers, composer2, 6);
                Modifier.Companion companion = Modifier.INSTANCE;
                AppColor appColor = AppColor.INSTANCE;
                final boolean z9 = z8;
                Modifier weight$default = ColumnScope.weight$default(columnScope, SizeKt.fillMaxWidth$default(BackgroundKt.m104backgroundbw27NRU$default(companion, z8 ? appColor.m3269getGrey60d7_KjU() : appColor.m3281getWhite0d7_KjU(), null, 2, null), 0.0f, 1, null), 1.0f, false, 2, null);
                composer2.startReplaceGroup(1751913261);
                boolean changedInstance = composer2.changedInstance(state) | composer2.changedInstance(checkoutState) | ((i9 & 57344) == 16384) | composer2.changedInstance(filterNotNull) | ((458752 & i10) == 131072) | ((i10 & 57344) == 16384) | composer2.changedInstance(passengerState) | ((234881024 & i9) == 67108864) | ((1879048192 & i9) == 536870912) | composer2.changedInstance(context) | composer2.changed(stringResource) | composer2.changed(z9) | ((i10 & 896) == 256) | ((i10 & 7168) == 2048);
                Object rememberedValue = composer2.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: U2.v
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit NameRegistrationSection$lambda$1$lambda$0;
                            NameRegistrationSection$lambda$1$lambda$0 = NameRegistrationSectionKt.NameRegistrationSection$lambda$1$lambda$0(PassengersViewModel.ViewState.this, passengerState, filterNotNull, toggleSelected, createPassenger, context, stringResource, z9, editPassenger, showAgeGroupError, checkoutState, showHelp, z6, changeSameReturnPassengersAsOutbound, (LazyListScope) obj);
                            return NameRegistrationSection$lambda$1$lambda$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceGroup();
                LazyDslKt.LazyColumn(weight$default, null, null, false, null, null, null, false, (Function1) rememberedValue, composer2, 0, 254);
                composer2.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1526274479);
                startRestartGroup.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1729797275);
                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CreateYourSelfAsPassengerViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
                CreateYourSelfAsPassengerViewKt.CreateYourSelfAsPassengerView((CreateYourSelfAsPassengerViewModel) viewModel, nationalityResultRecipient, navigateToNationalitySelection, onCurrentUserCreatedAsPassenger, showHelp, composer2, ((i9 >> 12) & 1008) | (i9 & 7168) | (i9 & 57344));
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NameRegistrationSection$lambda$2;
                    NameRegistrationSection$lambda$2 = NameRegistrationSectionKt.NameRegistrationSection$lambda$2(ColumnScope.this, passengerState, z5, onCurrentUserCreatedAsPassenger, showHelp, nationalityResultRecipient, navigateToNationalitySelection, checkoutState, toggleSelected, createPassenger, context, state, editPassenger, showAgeGroupError, changeSameReturnPassengersAsOutbound, z6, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return NameRegistrationSection$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NameRegistrationSection$lambda$1$lambda$0(final PassengersViewModel.ViewState viewState, PassengerSelectionHelper.PassengerState passengerState, final List list, Function1 function1, Function0 function0, Context context, String str, boolean z5, Function1 function12, Function0 function02, final CheckoutManager.CheckoutState checkoutState, final Function0 function03, final boolean z6, final Function1 function13, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1509216215, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt$NameRegistrationSection$1$1$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1509216215, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSection.<anonymous>.<anonymous>.<anonymous> (NameRegistrationSection.kt:87)");
                }
                PassengerHeaderSectionKt.PassengerHeaderSection(function03, PassengersViewModel.ViewState.this.getPassengerInfo(), list, checkoutState.getTransportation(), PassengersViewModel.ViewState.this.getShowAgeGroup(), checkoutState.getBookingType(), true, PassengersViewModel.ViewState.this.getDepartureDirection(), PassengersViewModel.ViewState.this.getRemainingAdultCount(), PassengersViewModel.ViewState.this.getRemainingChildCount(), PassengersViewModel.ViewState.this.getRemainingInfantCount(), true, z6, composer, 1572864, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        if (viewState.getBookingType() == BookingType.TwoWay && viewState.getDepartureDirection() == DepartureDirection.Return && viewState.getSameReturnPassengersAsOutboundChangePossible()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1749382222, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt$NameRegistrationSection$1$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1749382222, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSection.<anonymous>.<anonymous>.<anonymous> (NameRegistrationSection.kt:108)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    AppColor appColor = AppColor.INSTANCE;
                    float f5 = 16;
                    Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(PaddingKt.m315paddingqDBjuR0$default(BackgroundKt.m104backgroundbw27NRU$default(fillMaxWidth$default, appColor.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(f5), 0.0f, 8, null), appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(12));
                    PassengersViewModel.ViewState viewState2 = PassengersViewModel.ViewState.this;
                    Function1<Boolean, Unit> function14 = function13;
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m312paddingVpY3zN4);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    SwitchRowKt.SwitchRow(null, StringResources_androidKt.stringResource(R.string.passengers_sameAsOutboundOnReturn, composer, 6), viewState2.getSameReturnPassengersAsOutbound(), function14, composer, 0, 1);
                    composer.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        passengerSelectionSection(LazyColumn, passengerState, list, function1, function0, context, str, viewState, z5, function12, function02);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NameRegistrationSection$lambda$2(ColumnScope columnScope, PassengerSelectionHelper.PassengerState passengerState, boolean z5, Function0 function0, Function0 function02, ResultRecipient resultRecipient, Function0 function03, CheckoutManager.CheckoutState checkoutState, Function1 function1, Function0 function04, Context context, PassengersViewModel.ViewState viewState, Function1 function12, Function0 function05, Function1 function13, boolean z6, int i5, int i6, Composer composer, int i7) {
        NameRegistrationSection(columnScope, passengerState, z5, function0, function02, resultRecipient, function03, checkoutState, function1, function04, context, viewState, function12, function05, function13, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PassengersHorizontalList(final List<BookingPassenger> list, final boolean z5, final Function1<? super BookingPassenger, Unit> function1, final PassengerInfo passengerInfo, final boolean z6, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1554509302);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(passengerInfo) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1554509302, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.PassengersHorizontalList (NameRegistrationSection.kt:196)");
            }
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            PaddingValues m308PaddingValuesYgX7TsA$default = PaddingKt.m308PaddingValuesYgX7TsA$default(Dp.m2599constructorimpl(11), 0.0f, 2, null);
            startRestartGroup.startReplaceGroup(-1718161087);
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(passengerInfo) | ((i6 & 896) == 256) | startRestartGroup.changedInstance(list) | ((i6 & 57344) == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function12 = new Function1() { // from class: U2.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengersHorizontalList$lambda$5$lambda$4;
                        PassengersHorizontalList$lambda$5$lambda$4 = NameRegistrationSectionKt.PassengersHorizontalList$lambda$5$lambda$4(z5, passengerInfo, function1, list, z6, (LazyListScope) obj);
                        return PassengersHorizontalList$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(function12);
                rememberedValue = function12;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyRow(m104backgroundbw27NRU$default, null, m308PaddingValuesYgX7TsA$default, false, null, null, null, false, (Function1) rememberedValue, composer2, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengersHorizontalList$lambda$6;
                    PassengersHorizontalList$lambda$6 = NameRegistrationSectionKt.PassengersHorizontalList$lambda$6(list, z5, function1, passengerInfo, z6, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengersHorizontalList$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersHorizontalList$lambda$5$lambda$4(boolean z5, PassengerInfo passengerInfo, final Function1 function1, final List list, final boolean z6, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        if (z5) {
            addAgeGroupedItems(LazyRow, passengerInfo, function1, AgeGroup.Adult, list, z6);
            addAgeGroupedItems(LazyRow, passengerInfo, function1, AgeGroup.Child, list, z6);
            addAgeGroupedItems(LazyRow, passengerInfo, function1, AgeGroup.Infant, list, z6);
        } else {
            final NameRegistrationSectionKt$PassengersHorizontalList$lambda$5$lambda$4$$inlined$items$default$1 nameRegistrationSectionKt$PassengersHorizontalList$lambda$5$lambda$4$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt$PassengersHorizontalList$lambda$5$lambda$4$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(BookingPassenger bookingPassenger) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((BookingPassenger) obj);
                }
            };
            LazyRow.items(list.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt$PassengersHorizontalList$lambda$5$lambda$4$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i5) {
                    return Function1.this.invoke(list.get(i5));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt$PassengersHorizontalList$lambda$5$lambda$4$$inlined$items$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                    int i7;
                    if ((i6 & 6) == 0) {
                        i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                    } else {
                        i7 = i6;
                    }
                    if ((i6 & 48) == 0) {
                        i7 |= composer.changed(i5) ? 32 : 16;
                    }
                    if ((i7 & 147) == 146 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                    }
                    BookingPassenger bookingPassenger = (BookingPassenger) list.get(i5);
                    composer.startReplaceGroup(612572594);
                    CheckoutPassengerPortraitKt.CheckoutPassengerPortrait(bookingPassenger, function1, false, z6, false, composer, 384, 16);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            if (list.isEmpty()) {
                LazyListScope.item$default(LazyRow, null, null, ComposableSingletons$NameRegistrationSectionKt.INSTANCE.m3463getLambda1$app_kombardoProd(), 3, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersHorizontalList$lambda$6(List list, boolean z5, Function1 function1, PassengerInfo passengerInfo, boolean z6, int i5, Composer composer, int i6) {
        PassengersHorizontalList(list, z5, function1, passengerInfo, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void addAgeGroupedItems(LazyListScope lazyListScope, PassengerInfo passengerInfo, final Function1<? super BookingPassenger, Unit> function1, final AgeGroup ageGroup, List<BookingPassenger> list, final boolean z5) {
        int adultCount;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((BookingPassenger) obj).getAgeGroup() == ageGroup) {
                arrayList.add(obj);
            }
        }
        int i5 = WhenMappings.$EnumSwitchMapping$0[ageGroup.ordinal()];
        if (i5 == 1) {
            adultCount = passengerInfo.getAdultCount();
        } else if (i5 == 2) {
            adultCount = passengerInfo.getChildCount();
        } else {
            if (i5 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            adultCount = passengerInfo.getInfantCount();
        }
        int max = Integer.max(adultCount, arrayList.size());
        for (int i6 = 0; i6 < max; i6++) {
            final BookingPassenger bookingPassenger = (BookingPassenger) CollectionsKt.getOrNull(arrayList, i6);
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(464508682, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt$addAgeGroupedItems$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i7) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i7 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(464508682, i7, -1, "dk.molslinjen.ui.views.screens.booking.passengers.addAgeGroupedItems.<anonymous> (NameRegistrationSection.kt:260)");
                    }
                    if (BookingPassenger.this != null) {
                        composer.startReplaceGroup(-2101393333);
                        CheckoutPassengerPortraitKt.CheckoutPassengerPortrait(BookingPassenger.this, function1, true, z5, false, composer, 384, 16);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-2101140745);
                        CheckoutPassengerPortraitTemplateKt.CheckoutPassengerPortraitTemplate(AgeGroupExtensionsKt.name(ageGroup, (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())), composer, 0);
                        composer.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        if (adultCount <= 0 || ageGroup == AgeGroup.Infant) {
            return;
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$NameRegistrationSectionKt.INSTANCE.m3464getLambda2$app_kombardoProd(), 3, null);
    }

    private static final void passengerSelectionSection(LazyListScope lazyListScope, PassengerSelectionHelper.PassengerState passengerState, final List<BookingPassenger> list, final Function1<? super BookingPassenger, Unit> function1, final Function0<Unit> function0, Context context, String str, final PassengersViewModel.ViewState viewState, final boolean z5, Function1<? super String, Unit> function12, Function0<Unit> function02) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-681798697, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt$passengerSelectionSection$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-681798697, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.passengerSelectionSection.<anonymous> (NameRegistrationSection.kt:154)");
                }
                PassengerInfo passengerInfo = PassengersViewModel.ViewState.this.getPassengerInfo();
                if (passengerInfo == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    NameRegistrationSectionKt.PassengersHorizontalList(list, PassengersViewModel.ViewState.this.getShowAgeGroup(), function1, passengerInfo, !z5, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
        }), 3, null);
        if (z5) {
            return;
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1318160498, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.NameRegistrationSectionKt$passengerSelectionSection$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1318160498, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.passengerSelectionSection.<anonymous> (NameRegistrationSection.kt:168)");
                }
                OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16)), StringResources_androidKt.stringResource(R.string.passengers_create, composer, 6), R.drawable.icon_plus_circled, 0L, 0L, 0L, function0, composer, 390, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        PassengerSelectionVerticalListKt.passengerSelectionVerticalList(lazyListScope, passengerState, function1, viewState, str, context, function12, function02);
    }
}
