package dk.molslinjen.ui.views.screens.profile.vehicles.edit;

import androidx.compose.runtime.MutableState;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$1$1", f = "ProfileVehicleEditScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isKeyboardVisible;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ MutableState<Boolean> $shouldDismiss$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$1$1(boolean z5, DestinationsNavigator destinationsNavigator, MutableState<Boolean> mutableState, Continuation<? super ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$1$1> continuation) {
        super(2, continuation);
        this.$isKeyboardVisible = z5;
        this.$navigator = destinationsNavigator;
        this.$shouldDismiss$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$1$1(this.$isKeyboardVisible, this.$navigator, this.$shouldDismiss$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean ProfileVehicleEditScreen$lambda$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ProfileVehicleEditScreen$lambda$1 = ProfileVehicleEditScreenKt.ProfileVehicleEditScreen$lambda$1(this.$shouldDismiss$delegate);
        if (ProfileVehicleEditScreen$lambda$1 && !this.$isKeyboardVisible) {
            this.$navigator.popBackStack();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileVehicleEditScreenKt$ProfileVehicleEditScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
