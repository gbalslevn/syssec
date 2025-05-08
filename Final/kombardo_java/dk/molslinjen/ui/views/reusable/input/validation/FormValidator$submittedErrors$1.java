package dk.molslinjen.ui.views.reusable.input.validation;

import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "fields", BuildConfig.FLAVOR, "errors"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.reusable.input.validation.FormValidator$submittedErrors$1", f = "FormValidator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class FormValidator$submittedErrors$1 extends SuspendLambda implements Function3<Set<? extends IFormValidator.ValidationKey>, Map<IFormValidator.ValidationKey, ? extends InputValidationError>, Continuation<? super Map<IFormValidator.ValidationKey, ? extends InputValidationError>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormValidator$submittedErrors$1(Continuation<? super FormValidator$submittedErrors$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Set set = (Set) this.L$0;
        Map map = (Map) this.L$1;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (set.contains((IFormValidator.ValidationKey) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Set<? extends IFormValidator.ValidationKey> set, Map<IFormValidator.ValidationKey, ? extends InputValidationError> map, Continuation<? super Map<IFormValidator.ValidationKey, ? extends InputValidationError>> continuation) {
        FormValidator$submittedErrors$1 formValidator$submittedErrors$1 = new FormValidator$submittedErrors$1(continuation);
        formValidator$submittedErrors$1.L$0 = set;
        formValidator$submittedErrors$1.L$1 = map;
        return formValidator$submittedErrors$1.invokeSuspend(Unit.INSTANCE);
    }
}
