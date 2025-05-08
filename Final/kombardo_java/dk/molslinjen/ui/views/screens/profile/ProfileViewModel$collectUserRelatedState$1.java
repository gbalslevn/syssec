package dk.molslinjen.ui.views.screens.profile;

import android.content.Context;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.user.AccountUser;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.account.user.UserCompany;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.screens.profile.ProfileViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$collectUserRelatedState$1", f = "ProfileViewModel.kt", l = {97}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileViewModel$collectUserRelatedState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "userState", "Ldk/molslinjen/domain/managers/user/IUserManager$UserState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$collectUserRelatedState$1$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.profile.ProfileViewModel$collectUserRelatedState$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<IUserManager.UserState, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ProfileViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ProfileViewModel profileViewModel, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = profileViewModel;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$context, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(IUserManager.UserState userState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(userState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e0 A[LOOP:1: B:20:0x008e->B:31:0x00e0, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00dd A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List list;
            MutableStateFlow mutableStateFlow;
            Object value;
            ProfileViewModel.ViewState viewState;
            User user;
            DropdownItem dropdownItem;
            Object obj2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            IUserManager.UserState userState = (IUserManager.UserState) this.L$0;
            User user2 = userState.getUser();
            DropdownItem dropdownItem2 = null;
            AccountUser accountUser = user2 instanceof AccountUser ? (AccountUser) user2 : null;
            if (accountUser != null) {
                Context context = this.$context;
                if (accountUser.getId() != null && accountUser.getUserInfo() != null && !accountUser.getCompanies().isEmpty()) {
                    List<UserCompany> companies = accountUser.getCompanies();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(companies, 10));
                    for (UserCompany userCompany : companies) {
                        arrayList.add(new DropdownItem(userCompany.companyAndDepartmentName(), userCompany.getCompanyId()));
                    }
                    String string = context.getString(R.string.profile_company_defaultProfile);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    list = CollectionsKt.plus((Collection) CollectionsKt.listOf(new DropdownItem(string, null)), (Iterable) arrayList);
                    mutableStateFlow = this.this$0._viewState;
                    while (true) {
                        value = mutableStateFlow.getValue();
                        viewState = (ProfileViewModel.ViewState) value;
                        user = userState.getUser();
                        if (list == null) {
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj2 = dropdownItem2;
                                    break;
                                }
                                obj2 = it.next();
                                if (Intrinsics.areEqual(((DropdownItem) obj2).getValue(), userState.getActiveCompanyId())) {
                                    break;
                                }
                            }
                            dropdownItem = (DropdownItem) obj2;
                        } else {
                            dropdownItem = dropdownItem2;
                        }
                        if (!mutableStateFlow.compareAndSet(value, ProfileViewModel.ViewState.copy$default(viewState, user, list, dropdownItem, false, false, null, false, null, null, 504, null))) {
                            return Unit.INSTANCE;
                        }
                        dropdownItem2 = null;
                    }
                }
            }
            list = null;
            mutableStateFlow = this.this$0._viewState;
            while (true) {
                value = mutableStateFlow.getValue();
                viewState = (ProfileViewModel.ViewState) value;
                user = userState.getUser();
                if (list == null) {
                }
                if (!mutableStateFlow.compareAndSet(value, ProfileViewModel.ViewState.copy$default(viewState, user, list, dropdownItem, false, false, null, false, null, null, 504, null))) {
                }
                dropdownItem2 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileViewModel$collectUserRelatedState$1(ProfileViewModel profileViewModel, Context context, Continuation<? super ProfileViewModel$collectUserRelatedState$1> continuation) {
        super(2, continuation);
        this.this$0 = profileViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileViewModel$collectUserRelatedState$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<IUserManager.UserState> currentUserState = this.this$0.userManager.getCurrentUserState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$context, null);
            this.label = 1;
            if (FlowKt.collectLatest(currentUserState, anonymousClass1, this) == coroutine_suspended) {
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
        return ((ProfileViewModel$collectUserRelatedState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
