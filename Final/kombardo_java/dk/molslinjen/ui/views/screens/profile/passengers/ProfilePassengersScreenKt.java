package dk.molslinjen.ui.views.screens.profile.passengers;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.ProfilePassengerEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ProfilePassengersRegisterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SignupScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersScreenKt;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerDeleteDialogKt;
import dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsContainerKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aI\u0010\u000f\u001a\u00020\u0004*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/ProfilePassengersViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ProfilePassengersScreen", "(Ldk/molslinjen/ui/views/screens/profile/passengers/ProfilePassengersViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/UserPassenger;", "passengers", "Lkotlin/Function1;", BuildConfig.FLAVOR, "navigateToEdit", "triggerDeleteFlow", "profilePassengersContent", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfilePassengersScreenKt {
    public static final void ProfilePassengersScreen(final ProfilePassengersViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1384971973);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1384971973, i7, -1, "dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersScreen (ProfilePassengersScreen.kt:24)");
            }
            ProfilePassengersViewModel.ViewState viewState = (ProfilePassengersViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final UserPassenger passengerToDelete = viewState.getPassengerToDelete();
            startRestartGroup.startReplaceGroup(452108564);
            if (passengerToDelete != null) {
                boolean isDeleteLoading = viewState.getIsDeleteLoading();
                startRestartGroup.startReplaceGroup(452114323);
                boolean changedInstance = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(passengerToDelete);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: Q3.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ProfilePassengersScreen$lambda$1$lambda$0;
                            ProfilePassengersScreen$lambda$1$lambda$0 = ProfilePassengersScreenKt.ProfilePassengersScreen$lambda$1$lambda$0(ProfilePassengersViewModel.this, passengerToDelete);
                            return ProfilePassengersScreen$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(452116670);
                boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new ProfilePassengersScreenKt$ProfilePassengersScreen$2$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                ProfilePassengerDeleteDialogKt.ProfilePassengerDeleteDialog(passengerToDelete, isDeleteLoading, function0, (Function0) ((KFunction) rememberedValue2), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            boolean isLoading = viewState.getIsLoading();
            final List<UserPassenger> passengers = viewState.getPassengers();
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_passengersTitle, startRestartGroup, 6);
            AccountCardData accountCardData = viewState.getAccountCardData();
            boolean isEmpty = passengers.isEmpty();
            startRestartGroup.startReplaceGroup(452131802);
            int i8 = i7 & 112;
            boolean z5 = i8 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new ProfilePassengersScreenKt$ProfilePassengersScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function02 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(452133274);
            boolean z6 = i8 == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new ProfilePassengersScreenKt$ProfilePassengersScreen$4$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function03 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            String stringResource2 = StringResources_androidKt.stringResource(R.string.profile_passengers_emptyDescription, startRestartGroup, 6);
            String stringResource3 = StringResources_androidKt.stringResource(R.string.profile_passengers_register, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(452142757);
            boolean z7 = i8 == 32;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: Q3.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfilePassengersScreen$lambda$7$lambda$6;
                        ProfilePassengersScreen$lambda$7$lambda$6 = ProfilePassengersScreenKt.ProfilePassengersScreen$lambda$7$lambda$6(DestinationsNavigator.this);
                        return ProfilePassengersScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function04 = (Function0) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(452127590);
            boolean z8 = i8 == 32;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: Q3.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfilePassengersScreen$lambda$9$lambda$8;
                        ProfilePassengersScreen$lambda$9$lambda$8 = ProfilePassengersScreenKt.ProfilePassengersScreen$lambda$9$lambda$8(DestinationsNavigator.this);
                        return ProfilePassengersScreen$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            Function0 function05 = (Function0) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(452145375);
            boolean changedInstance3 = startRestartGroup.changedInstance(passengers) | (i8 == 32) | startRestartGroup.changedInstance(viewModel);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: Q3.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfilePassengersScreen$lambda$12$lambda$11;
                        ProfilePassengersScreen$lambda$12$lambda$11 = ProfilePassengersScreenKt.ProfilePassengersScreen$lambda$12$lambda$11(passengers, viewModel, navigator, (LazyListScope) obj);
                        return ProfilePassengersScreen$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            ProfileAssetsContainerKt.ProfileAssetsListContainer(stringResource, accountCardData, isLoading, isEmpty, function02, function03, R.drawable.icon_profile_passengers, stringResource2, null, stringResource3, function04, function05, (Function1) rememberedValue7, composer2, 1572864, 0, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Q3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfilePassengersScreen$lambda$13;
                    ProfilePassengersScreen$lambda$13 = ProfilePassengersScreenKt.ProfilePassengersScreen$lambda$13(ProfilePassengersViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfilePassengersScreen$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengersScreen$lambda$1$lambda$0(ProfilePassengersViewModel profilePassengersViewModel, UserPassenger userPassenger) {
        profilePassengersViewModel.deletePassenger(userPassenger);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengersScreen$lambda$12$lambda$11(List list, ProfilePassengersViewModel profilePassengersViewModel, final DestinationsNavigator destinationsNavigator, LazyListScope ProfileAssetsListContainer) {
        Intrinsics.checkNotNullParameter(ProfileAssetsListContainer, "$this$ProfileAssetsListContainer");
        profilePassengersContent(ProfileAssetsListContainer, list, new Function1() { // from class: Q3.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ProfilePassengersScreen$lambda$12$lambda$11$lambda$10;
                ProfilePassengersScreen$lambda$12$lambda$11$lambda$10 = ProfilePassengersScreenKt.ProfilePassengersScreen$lambda$12$lambda$11$lambda$10(DestinationsNavigator.this, (String) obj);
                return ProfilePassengersScreen$lambda$12$lambda$11$lambda$10;
            }
        }, new ProfilePassengersScreenKt$ProfilePassengersScreen$7$1$2(profilePassengersViewModel));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengersScreen$lambda$12$lambda$11$lambda$10(DestinationsNavigator destinationsNavigator, String passengerId) {
        Intrinsics.checkNotNullParameter(passengerId, "passengerId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfilePassengerEditScreenDestination.INSTANCE.invoke(passengerId), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengersScreen$lambda$13(ProfilePassengersViewModel profilePassengersViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfilePassengersScreen(profilePassengersViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengersScreen$lambda$7$lambda$6(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ProfilePassengersRegisterScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengersScreen$lambda$9$lambda$8(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SignupScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    private static final void profilePassengersContent(LazyListScope lazyListScope, final List<UserPassenger> list, final Function1<? super String, Unit> function1, final Function1<? super UserPassenger, Unit> function12) {
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$ProfilePassengersScreenKt.INSTANCE.m3514getLambda1$app_kombardoProd(), 3, null);
        final Function1 function13 = new Function1() { // from class: Q3.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object profilePassengersContent$lambda$14;
                profilePassengersContent$lambda$14 = ProfilePassengersScreenKt.profilePassengersContent$lambda$14((UserPassenger) obj);
                return profilePassengersContent$lambda$14;
            }
        };
        final ProfilePassengersScreenKt$profilePassengersContent$$inlined$items$default$1 profilePassengersScreenKt$profilePassengersContent$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersScreenKt$profilePassengersContent$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(UserPassenger userPassenger) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((UserPassenger) obj);
            }
        };
        lazyListScope.items(list.size(), new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersScreenKt$profilePassengersContent$$inlined$items$default$2
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
        }, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersScreenKt$profilePassengersContent$$inlined$items$default$3
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
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengersScreenKt$profilePassengersContent$$inlined$items$default$4
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
                UserPassenger userPassenger = (UserPassenger) list.get(i5);
                composer.startReplaceGroup(-1767499930);
                ProfilePassengerRowKt.ProfilePassengerRow(userPassenger, function1, function12, composer, 0);
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object profilePassengersContent$lambda$14(UserPassenger it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLocalId();
    }
}
