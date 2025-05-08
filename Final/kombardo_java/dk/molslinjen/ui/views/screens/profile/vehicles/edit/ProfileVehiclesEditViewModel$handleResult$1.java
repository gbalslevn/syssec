package dk.molslinjen.ui.views.screens.profile.vehicles.edit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.vehicles.edit.ProfileVehiclesEditViewModel", f = "ProfileVehiclesEditViewModel.kt", l = {75}, m = "handleResult")
/* loaded from: classes2.dex */
public final class ProfileVehiclesEditViewModel$handleResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileVehiclesEditViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileVehiclesEditViewModel$handleResult$1(ProfileVehiclesEditViewModel profileVehiclesEditViewModel, Continuation<? super ProfileVehiclesEditViewModel$handleResult$1> continuation) {
        super(continuation);
        this.this$0 = profileVehiclesEditViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleResult;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleResult = this.this$0.handleResult(null, null, this);
        return handleResult;
    }
}
