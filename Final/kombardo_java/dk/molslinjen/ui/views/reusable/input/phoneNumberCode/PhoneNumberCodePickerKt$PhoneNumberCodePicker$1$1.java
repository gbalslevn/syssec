package dk.molslinjen.ui.views.reusable.input.phoneNumberCode;

import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodePickerKt$PhoneNumberCodePicker$1$1", f = "PhoneNumberCodePicker.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class PhoneNumberCodePickerKt$PhoneNumberCodePicker$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PhoneNumber $phoneNumber;
    final /* synthetic */ IFormValidator.ValidationKey $validationKey;
    final /* synthetic */ IFormValidator $validator;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNumberCodePickerKt$PhoneNumberCodePicker$1$1(IFormValidator iFormValidator, IFormValidator.ValidationKey validationKey, PhoneNumber phoneNumber, Continuation<? super PhoneNumberCodePickerKt$PhoneNumberCodePicker$1$1> continuation) {
        super(2, continuation);
        this.$validator = iFormValidator;
        this.$validationKey = validationKey;
        this.$phoneNumber = phoneNumber;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhoneNumberCodePickerKt$PhoneNumberCodePicker$1$1(this.$validator, this.$validationKey, this.$phoneNumber, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$validator.validate(this.$validationKey, this.$phoneNumber.getCountryCode());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PhoneNumberCodePickerKt$PhoneNumberCodePicker$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
