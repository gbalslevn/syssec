package dk.molslinjen.ui.views.reusable.input.validation;

import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\u0015\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00120\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "submitAllFields", "()V", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "fieldId", "submit", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;)V", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "error", "set", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;)V", BuildConfig.FLAVOR, "value", "validate", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "getSubmittedErrors", "()Lkotlinx/coroutines/flow/StateFlow;", "submittedErrors", BuildConfig.FLAVOR, "isFormValid", "ValidationKey", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IFormValidator {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "getLabel", "()Ljava/lang/Integer;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface ValidationKey {
        Integer getLabel();
    }

    StateFlow<Map<ValidationKey, InputValidationError>> getSubmittedErrors();

    StateFlow<Boolean> isFormValid();

    void set(ValidationKey fieldId, InputValidationError error);

    void submit(ValidationKey fieldId);

    void submitAllFields();

    void validate(ValidationKey fieldId, String value);
}
