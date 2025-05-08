package dk.molslinjen.ui.views.screens.profile;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.sun.jna.Function;
import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.Environment;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.api.IApiProviderManager;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001.B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010J\u0016\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tJ\u0006\u0010&\u001a\u00020 J\u0016\u0010'\u001a\u00020\u001e2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)J\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010,\u001a\u00020\u001eJ\u0006\u0010-\u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006/"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "apiProviderManager", "Ldk/molslinjen/domain/managers/api/IApiProviderManager;", "context", "Landroid/content/Context;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/api/IApiProviderManager;Landroid/content/Context;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "showDeveloperMenu", "Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "getShowDeveloperMenu", "()Lkotlinx/coroutines/flow/StateFlow;", "showDeveloperSection", "getShowDeveloperSection", "()Z", "showApiSwitcher", "getShowApiSwitcher", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/ProfileViewModel$ViewState;", "viewState", "getViewState", "collectUserRelatedState", BuildConfig.FLAVOR, "toggleDeveloperMenu", "Lkotlinx/coroutines/Job;", "show", "switchApiEnvironment", "apiEnvironment", "Ldk/molslinjen/core/ApiEnvironment;", "appContext", "ignorePendingActivation", "onAccountSelected", "changeAccountDropdownItem", "Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", BuildConfig.FLAVOR, "startLogoutFlow", "cancelLogoutFlow", "logout", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final IApiProviderManager apiProviderManager;
    private final ISettings settings;
    private final boolean showApiSwitcher;
    private final StateFlow<Boolean> showDeveloperMenu;
    private final boolean showDeveloperSection;
    private final IUserManager userManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$1", f = "ProfileViewModel.kt", l = {Function.ALT_CONVENTION}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.ProfileViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "authenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$1$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.ProfileViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00601 extends SuspendLambda implements Function2<AuthenticationType, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProfileViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00601(ProfileViewModel profileViewModel, Continuation<? super C00601> continuation) {
                super(2, continuation);
                this.this$0 = profileViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00601 c00601 = new C00601(this.this$0, continuation);
                c00601.L$0 = obj;
                return c00601;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AuthenticationType authenticationType, Continuation<? super Unit> continuation) {
                return ((C00601) create(authenticationType, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                AuthenticationType authenticationType = (AuthenticationType) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, null, null, false, authenticationType.isAuthenticated(), null, false, null, null, 495, null)));
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<AuthenticationType> authenticationType = ProfileViewModel.this.userManager.getAuthenticationType();
                C00601 c00601 = new C00601(ProfileViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(authenticationType, c00601, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$2", f = "ProfileViewModel.kt", l = {71}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.ProfileViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "activationInfo", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$2$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.ProfileViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<IUserManager.ActivationInfo, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ProfileViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ProfileViewModel profileViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = profileViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(IUserManager.ActivationInfo activationInfo, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(activationInfo, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                IUserManager.ActivationInfo activationInfo = (IUserManager.ActivationInfo) this.L$0;
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, null, null, false, false, activationInfo != null ? new AccountCardData.ActivationPending(activationInfo) : null, false, null, null, 479, null)));
                return Unit.INSTANCE;
            }
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<IUserManager.ActivationInfo> pendingAccountActivation = ProfileViewModel.this.userManager.getPendingAccountActivation();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfileViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(pendingAccountActivation, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$3", f = "ProfileViewModel.kt", l = {83}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.ProfileViewModel$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                IUserManager iUserManager = ProfileViewModel.this.userManager;
                this.label = 1;
                if (iUserManager.loadUserInfo(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$4", f = "ProfileViewModel.kt", l = {87}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.ProfileViewModel$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/core/ApiEnvironment;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$4$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.profile.ProfileViewModel$4$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<ApiEnvironment, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ProfileViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ProfileViewModel profileViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = profileViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ApiEnvironment apiEnvironment, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(apiEnvironment, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                ProfileViewModel profileViewModel = this.this$0;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default((ViewState) value, null, null, null, false, false, null, false, profileViewModel.apiProviderManager.getActiveApi(), null, 383, null)));
                return Unit.INSTANCE;
            }
        }

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<ApiEnvironment> overrideApiState = ProfileViewModel.this.apiProviderManager.getOverrideApiState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfileViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(overrideApiState, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Environment.values().length];
            try {
                iArr[Environment.Dev.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Environment.Test.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Environment.ProdTest.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Environment.Prod.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ProfileViewModel(ISettings settings, IUserManager userManager, IApiProviderManager apiProviderManager, Context context, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(apiProviderManager, "apiProviderManager");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.settings = settings;
        this.userManager = userManager;
        this.apiProviderManager = apiProviderManager;
        this.analyticsTracker = analyticsTracker;
        this.showDeveloperMenu = settings.get(ViewModelKt.getViewModelScope(this), SettingsProperty.Dev.ShowDeveloperMenu.INSTANCE);
        this.showDeveloperSection = Environment.Dev.isCurrent();
        int i5 = WhenMappings.$EnumSwitchMapping$0[Environment.INSTANCE.current().ordinal()];
        boolean z5 = true;
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3 && i5 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            z5 = false;
        }
        this.showApiSwitcher = z5;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(userManager.getCurrentUserState().getValue().getUser(), null, null, false, false, null, false, apiProviderManager.getActiveApi(), apiProviderManager.getAvailableApis(), 126, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        collectUserRelatedState(context);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass4(null), 3, null);
    }

    private final void collectUserRelatedState(Context context) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$collectUserRelatedState$1(this, context, null), 3, null);
    }

    public final void cancelLogoutFlow() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, false, false, null, false, null, null, 503, null)));
    }

    public final boolean getShowApiSwitcher() {
        return this.showApiSwitcher;
    }

    public final StateFlow<Boolean> getShowDeveloperMenu() {
        return this.showDeveloperMenu;
    }

    public final boolean getShowDeveloperSection() {
        return this.showDeveloperSection;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final Job ignorePendingActivation() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$ignorePendingActivation$1(this, null), 3, null);
        return launch$default;
    }

    public final void logout() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$logout$1(this, null), 3, null);
    }

    public final void onAccountSelected(DropdownItem<String> changeAccountDropdownItem) {
        Intrinsics.checkNotNullParameter(changeAccountDropdownItem, "changeAccountDropdownItem");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$onAccountSelected$1(this, changeAccountDropdownItem, null), 3, null);
    }

    public final void startLogoutFlow() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, null, true, false, null, false, null, null, 503, null)));
    }

    public final void switchApiEnvironment(ApiEnvironment apiEnvironment, Context appContext) {
        Intrinsics.checkNotNullParameter(apiEnvironment, "apiEnvironment");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (apiEnvironment != this.viewState.getValue().getSelectedApi()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$switchApiEnvironment$1(this, appContext, apiEnvironment, null), 3, null);
        }
    }

    public final Job toggleDeveloperMenu(boolean show) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$toggleDeveloperMenu$1(this, show, null), 3, null);
        return launch$default;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u008c\u0001\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u00042\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R'\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R!\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b\u000b\u0010)R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b\u000e\u0010)R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b.\u0010/R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b0\u0010#¨\u00061"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/ProfileViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/user/User;", "user", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", BuildConfig.FLAVOR, "accounts", "selectedAccount", BuildConfig.FLAVOR, "showLogoutDialog", "isAuthenticated", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;", "accountCardData", "isChangingAccount", "Ldk/molslinjen/core/ApiEnvironment;", "selectedApi", "availableApis", "<init>", "(Ldk/molslinjen/domain/model/account/user/User;Ljava/util/List;Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;ZZLdk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;ZLdk/molslinjen/core/ApiEnvironment;Ljava/util/List;)V", "copy", "(Ldk/molslinjen/domain/model/account/user/User;Ljava/util/List;Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;ZZLdk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;ZLdk/molslinjen/core/ApiEnvironment;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/profile/ProfileViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/account/user/User;", "getUser", "()Ldk/molslinjen/domain/model/account/user/User;", "Ljava/util/List;", "getAccounts", "()Ljava/util/List;", "Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", "getSelectedAccount", "()Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", "Z", "getShowLogoutDialog", "()Z", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;", "getAccountCardData", "()Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;", "Ldk/molslinjen/core/ApiEnvironment;", "getSelectedApi", "()Ldk/molslinjen/core/ApiEnvironment;", "getAvailableApis", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final AccountCardData.ActivationPending accountCardData;
        private final List<DropdownItem<String>> accounts;
        private final List<ApiEnvironment> availableApis;
        private final boolean isAuthenticated;
        private final boolean isChangingAccount;
        private final DropdownItem<String> selectedAccount;
        private final ApiEnvironment selectedApi;
        private final boolean showLogoutDialog;
        private final User user;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(User user, List<DropdownItem<String>> list, DropdownItem<String> dropdownItem, boolean z5, boolean z6, AccountCardData.ActivationPending activationPending, boolean z7, ApiEnvironment selectedApi, List<? extends ApiEnvironment> availableApis) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(selectedApi, "selectedApi");
            Intrinsics.checkNotNullParameter(availableApis, "availableApis");
            this.user = user;
            this.accounts = list;
            this.selectedAccount = dropdownItem;
            this.showLogoutDialog = z5;
            this.isAuthenticated = z6;
            this.accountCardData = activationPending;
            this.isChangingAccount = z7;
            this.selectedApi = selectedApi;
            this.availableApis = availableApis;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, User user, List list, DropdownItem dropdownItem, boolean z5, boolean z6, AccountCardData.ActivationPending activationPending, boolean z7, ApiEnvironment apiEnvironment, List list2, int i5, Object obj) {
            return viewState.copy((i5 & 1) != 0 ? viewState.user : user, (i5 & 2) != 0 ? viewState.accounts : list, (i5 & 4) != 0 ? viewState.selectedAccount : dropdownItem, (i5 & 8) != 0 ? viewState.showLogoutDialog : z5, (i5 & 16) != 0 ? viewState.isAuthenticated : z6, (i5 & 32) != 0 ? viewState.accountCardData : activationPending, (i5 & 64) != 0 ? viewState.isChangingAccount : z7, (i5 & 128) != 0 ? viewState.selectedApi : apiEnvironment, (i5 & 256) != 0 ? viewState.availableApis : list2);
        }

        public final ViewState copy(User user, List<DropdownItem<String>> accounts, DropdownItem<String> selectedAccount, boolean showLogoutDialog, boolean isAuthenticated, AccountCardData.ActivationPending accountCardData, boolean isChangingAccount, ApiEnvironment selectedApi, List<? extends ApiEnvironment> availableApis) {
            Intrinsics.checkNotNullParameter(user, "user");
            Intrinsics.checkNotNullParameter(selectedApi, "selectedApi");
            Intrinsics.checkNotNullParameter(availableApis, "availableApis");
            return new ViewState(user, accounts, selectedAccount, showLogoutDialog, isAuthenticated, accountCardData, isChangingAccount, selectedApi, availableApis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.user, viewState.user) && Intrinsics.areEqual(this.accounts, viewState.accounts) && Intrinsics.areEqual(this.selectedAccount, viewState.selectedAccount) && this.showLogoutDialog == viewState.showLogoutDialog && this.isAuthenticated == viewState.isAuthenticated && Intrinsics.areEqual(this.accountCardData, viewState.accountCardData) && this.isChangingAccount == viewState.isChangingAccount && this.selectedApi == viewState.selectedApi && Intrinsics.areEqual(this.availableApis, viewState.availableApis);
        }

        public final AccountCardData.ActivationPending getAccountCardData() {
            return this.accountCardData;
        }

        public final List<DropdownItem<String>> getAccounts() {
            return this.accounts;
        }

        public final List<ApiEnvironment> getAvailableApis() {
            return this.availableApis;
        }

        public final DropdownItem<String> getSelectedAccount() {
            return this.selectedAccount;
        }

        public final ApiEnvironment getSelectedApi() {
            return this.selectedApi;
        }

        public final boolean getShowLogoutDialog() {
            return this.showLogoutDialog;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            int hashCode = this.user.hashCode() * 31;
            List<DropdownItem<String>> list = this.accounts;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            DropdownItem<String> dropdownItem = this.selectedAccount;
            int hashCode3 = (((((hashCode2 + (dropdownItem == null ? 0 : dropdownItem.hashCode())) * 31) + Boolean.hashCode(this.showLogoutDialog)) * 31) + Boolean.hashCode(this.isAuthenticated)) * 31;
            AccountCardData.ActivationPending activationPending = this.accountCardData;
            return ((((((hashCode3 + (activationPending != null ? activationPending.hashCode() : 0)) * 31) + Boolean.hashCode(this.isChangingAccount)) * 31) + this.selectedApi.hashCode()) * 31) + this.availableApis.hashCode();
        }

        /* renamed from: isAuthenticated, reason: from getter */
        public final boolean getIsAuthenticated() {
            return this.isAuthenticated;
        }

        /* renamed from: isChangingAccount, reason: from getter */
        public final boolean getIsChangingAccount() {
            return this.isChangingAccount;
        }

        public String toString() {
            return "ViewState(user=" + this.user + ", accounts=" + this.accounts + ", selectedAccount=" + this.selectedAccount + ", showLogoutDialog=" + this.showLogoutDialog + ", isAuthenticated=" + this.isAuthenticated + ", accountCardData=" + this.accountCardData + ", isChangingAccount=" + this.isChangingAccount + ", selectedApi=" + this.selectedApi + ", availableApis=" + this.availableApis + ")";
        }

        public /* synthetic */ ViewState(User user, List list, DropdownItem dropdownItem, boolean z5, boolean z6, AccountCardData.ActivationPending activationPending, boolean z7, ApiEnvironment apiEnvironment, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(user, (i5 & 2) != 0 ? null : list, (i5 & 4) != 0 ? null : dropdownItem, (i5 & 8) != 0 ? false : z5, (i5 & 16) != 0 ? false : z6, (i5 & 32) != 0 ? null : activationPending, (i5 & 64) != 0 ? false : z7, apiEnvironment, list2);
        }
    }
}
