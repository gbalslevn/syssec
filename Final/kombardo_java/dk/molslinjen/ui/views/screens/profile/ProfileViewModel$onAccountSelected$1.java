package dk.molslinjen.ui.views.screens.profile;

import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.screens.profile.ProfileViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.ProfileViewModel$onAccountSelected$1", f = "ProfileViewModel.kt", l = {154}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileViewModel$onAccountSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DropdownItem<String> $changeAccountDropdownItem;
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileViewModel$onAccountSelected$1(ProfileViewModel profileViewModel, DropdownItem<String> dropdownItem, Continuation<? super ProfileViewModel$onAccountSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = profileViewModel;
        this.$changeAccountDropdownItem = dropdownItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileViewModel$onAccountSelected$1(this.this$0, this.$changeAccountDropdownItem, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ProfileViewModel.ViewState.copy$default((ProfileViewModel.ViewState) value, null, null, null, false, false, null, true, null, null, 447, null)));
            IUserManager iUserManager = this.this$0.userManager;
            String value3 = this.$changeAccountDropdownItem.getValue();
            this.label = 1;
            if (iUserManager.changeAccount(value3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MutableStateFlow mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ProfileViewModel.ViewState.copy$default((ProfileViewModel.ViewState) value2, null, null, null, false, false, null, false, null, null, 447, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$onAccountSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
