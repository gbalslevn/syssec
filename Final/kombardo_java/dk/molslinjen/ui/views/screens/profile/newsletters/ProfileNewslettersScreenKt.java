package dk.molslinjen.ui.views.screens.profile.newsletters;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.account.newsletters.NewsletterSubscription;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersScreenKt;
import dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aw\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\r2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0015*\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/newsletters/ProfileNewslettersViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ProfileNewslettersScreen", "(Ldk/molslinjen/ui/views/screens/profile/newsletters/ProfileNewslettersViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;", "subscriptions", "selectedSiteSubscriptions", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/site/SiteInfo;", "onNewsletterSubscriptionChange", "onPromotionsSubscriptionChange", "Lkotlin/Function1;", "onSiteChange", "ProfileNewslettersContent", "(ZLjava/util/List;Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", "toDropdownItem", "(Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;)Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileNewslettersScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileNewslettersContent(final boolean z5, final List<NewsletterSubscription> list, final NewsletterSubscription newsletterSubscription, final Function2<? super SiteInfo, ? super Boolean, Unit> function2, final Function2<? super SiteInfo, ? super Boolean, Unit> function22, final Function1<? super NewsletterSubscription, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1732908694);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(newsletterSubscription) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1732908694, i7, -1, "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersContent (ProfileNewslettersScreen.kt:63)");
            }
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z5, 0, newsletterSubscription == null || list.isEmpty(), null, ComposableLambdaKt.rememberComposableLambda(-321298506, true, new ProfileNewslettersScreenKt$ProfileNewslettersContent$1(newsletterSubscription, list, function1, function2, function22), startRestartGroup, 54), startRestartGroup, ((i7 << 6) & 896) | 1572864, 43);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: P3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileNewslettersContent$lambda$4;
                    ProfileNewslettersContent$lambda$4 = ProfileNewslettersScreenKt.ProfileNewslettersContent$lambda$4(z5, list, newsletterSubscription, function2, function22, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileNewslettersContent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileNewslettersContent$lambda$4(boolean z5, List list, NewsletterSubscription newsletterSubscription, Function2 function2, Function2 function22, Function1 function1, int i5, Composer composer, int i6) {
        ProfileNewslettersContent(z5, list, newsletterSubscription, function2, function22, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ProfileNewslettersScreen(final ProfileNewslettersViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1623236969);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1623236969, i6, -1, "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersScreen (ProfileNewslettersScreen.kt:31)");
            }
            ProfileNewslettersViewModel.ViewState viewState = (ProfileNewslettersViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final boolean isLoading = viewState.getIsLoading();
            final NewsletterSubscription selectedSiteSubscriptions = viewState.getSelectedSiteSubscriptions();
            final List<NewsletterSubscription> component3 = viewState.component3();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_newslettersTitle, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(50139762);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new ProfileNewslettersScreenKt$ProfileNewslettersScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(50141330);
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new ProfileNewslettersScreenKt$ProfileNewslettersScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-485147204, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersScreenKt$ProfileNewslettersScreen$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i8) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i8 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-485147204, i8, -1, "dk.molslinjen.ui.views.screens.profile.newsletters.ProfileNewslettersScreen.<anonymous> (ProfileNewslettersScreen.kt:44)");
                    }
                    boolean z7 = isLoading;
                    List<NewsletterSubscription> list = component3;
                    NewsletterSubscription newsletterSubscription = selectedSiteSubscriptions;
                    ProfileNewslettersViewModel profileNewslettersViewModel = viewModel;
                    composer3.startReplaceGroup(876997185);
                    boolean changedInstance = composer3.changedInstance(profileNewslettersViewModel);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new ProfileNewslettersScreenKt$ProfileNewslettersScreen$3$1$1(profileNewslettersViewModel);
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceGroup();
                    Function2 function2 = (Function2) ((KFunction) rememberedValue3);
                    ProfileNewslettersViewModel profileNewslettersViewModel2 = viewModel;
                    composer3.startReplaceGroup(876999937);
                    boolean changedInstance2 = composer3.changedInstance(profileNewslettersViewModel2);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new ProfileNewslettersScreenKt$ProfileNewslettersScreen$3$2$1(profileNewslettersViewModel2);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceGroup();
                    Function2 function22 = (Function2) ((KFunction) rememberedValue4);
                    ProfileNewslettersViewModel profileNewslettersViewModel3 = viewModel;
                    composer3.startReplaceGroup(877002097);
                    boolean changedInstance3 = composer3.changedInstance(profileNewslettersViewModel3);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new ProfileNewslettersScreenKt$ProfileNewslettersScreen$3$3$1(profileNewslettersViewModel3);
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceGroup();
                    ProfileNewslettersScreenKt.ProfileNewslettersContent(z7, list, newsletterSubscription, function2, function22, (Function1) ((KFunction) rememberedValue5), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, function0, (Function0) rememberedValue2, null, null, rememberComposableLambda, startRestartGroup, 805306374, 410);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: P3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileNewslettersScreen$lambda$3;
                    ProfileNewslettersScreen$lambda$3 = ProfileNewslettersScreenKt.ProfileNewslettersScreen$lambda$3(ProfileNewslettersViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileNewslettersScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileNewslettersScreen$lambda$3(ProfileNewslettersViewModel profileNewslettersViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfileNewslettersScreen(profileNewslettersViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DropdownItem<NewsletterSubscription> toDropdownItem(NewsletterSubscription newsletterSubscription) {
        return new DropdownItem<>(newsletterSubscription.getSiteInfo().getSiteName(), newsletterSubscription);
    }
}
