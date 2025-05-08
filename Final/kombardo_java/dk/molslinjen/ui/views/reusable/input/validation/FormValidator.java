package dk.molslinjen.ui.views.reusable.input.validation;

import android.content.Context;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR(\u0010\u001e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR&\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010#R.\u0010%\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00020$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R \u0010*\u001a\b\u0012\u0004\u0012\u00020)0$8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b*\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/FormValidator;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator;", "validators", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Ljava/util/Map;Lkotlinx/coroutines/CoroutineScope;)V", BuildConfig.FLAVOR, "submitAllFields", "()V", "fieldId", "submit", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;)V", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "error", "set", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;)V", BuildConfig.FLAVOR, "value", "validate", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "getAnyError", "(Landroid/content/Context;)Ljava/lang/String;", "Ljava/util/Map;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "formErrors", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "submittedFields", "getSubmittedFields", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "submittedErrors", "Lkotlinx/coroutines/flow/StateFlow;", "getSubmittedErrors", "()Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "isFormValid", "getFieldKeys", "()Ljava/util/Set;", "fieldKeys", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FormValidator implements IFormValidator {
    private final MutableStateFlow<Map<IFormValidator.ValidationKey, InputValidationError>> formErrors;
    private final StateFlow<Boolean> isFormValid;
    private final StateFlow<Map<IFormValidator.ValidationKey, InputValidationError>> submittedErrors;
    private final MutableStateFlow<Set<IFormValidator.ValidationKey>> submittedFields;
    private final Map<IFormValidator.ValidationKey, IInputValidator> validators;

    /* JADX WARN: Multi-variable type inference failed */
    public FormValidator(Map<IFormValidator.ValidationKey, ? extends IInputValidator> validators, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(validators, "validators");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.validators = validators;
        final MutableStateFlow<Map<IFormValidator.ValidationKey, InputValidationError>> MutableStateFlow = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this.formErrors = MutableStateFlow;
        this.submittedFields = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        Flow flowCombine = FlowKt.flowCombine(getSubmittedFields(), MutableStateFlow, new FormValidator$submittedErrors$1(null));
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        this.submittedErrors = FlowKt.stateIn(flowCombine, coroutineScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), MapsKt.emptyMap());
        this.isFormValid = FlowKt.stateIn(new Flow<Boolean>() { // from class: dk.molslinjen.ui.views.reusable.input.validation.FormValidator$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: dk.molslinjen.ui.views.reusable.input.validation.FormValidator$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "dk.molslinjen.ui.views.reusable.input.validation.FormValidator$special$$inlined$map$1$2", f = "FormValidator.kt", l = {223}, m = "emit")
                /* renamed from: dk.molslinjen.ui.views.reusable.input.validation.FormValidator$special$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i5;
                    boolean z5;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i6 = anonymousClass1.label;
                        if ((i6 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i6 - Integer.MIN_VALUE;
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i5 = anonymousClass1.label;
                            if (i5 != 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Collection values = ((Map) obj).values();
                                if (!(values instanceof Collection) || !values.isEmpty()) {
                                    Iterator<T> it = values.iterator();
                                    while (it.hasNext()) {
                                        if (((InputValidationError) it.next()) != null) {
                                            z5 = false;
                                            break;
                                        }
                                    }
                                }
                                z5 = true;
                                Boolean boxBoolean = Boxing.boxBoolean(z5);
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(boxBoolean, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i5 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj22 = anonymousClass1.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = anonymousClass1.label;
                    if (i5 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, coroutineScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), Boolean.FALSE);
    }

    private final Set<IFormValidator.ValidationKey> getFieldKeys() {
        return this.validators.keySet();
    }

    public String getAnyError(Context context) {
        Map.Entry<IFormValidator.ValidationKey, InputValidationError> entry;
        InputValidationError value;
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<Map.Entry<IFormValidator.ValidationKey, InputValidationError>> it = this.formErrors.getValue().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                entry = null;
                break;
            }
            entry = it.next();
            if (entry.getValue() == null) {
                entry = null;
            }
            if (entry != null) {
                break;
            }
        }
        if (entry == null || (value = entry.getValue()) == null) {
            return null;
        }
        return value.toErrorMessage(context, entry.getKey());
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator
    public StateFlow<Map<IFormValidator.ValidationKey, InputValidationError>> getSubmittedErrors() {
        return this.submittedErrors;
    }

    public MutableStateFlow<Set<IFormValidator.ValidationKey>> getSubmittedFields() {
        return this.submittedFields;
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator
    public StateFlow<Boolean> isFormValid() {
        return this.isFormValid;
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator
    public void set(IFormValidator.ValidationKey fieldId, InputValidationError error) {
        Map<IFormValidator.ValidationKey, InputValidationError> value;
        Intrinsics.checkNotNullParameter(fieldId, "fieldId");
        MutableStateFlow<Map<IFormValidator.ValidationKey, InputValidationError>> mutableStateFlow = this.formErrors;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MapsKt.plus(value, TuplesKt.to(fieldId, error))));
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator
    public void submit(IFormValidator.ValidationKey fieldId) {
        Set<IFormValidator.ValidationKey> value;
        Intrinsics.checkNotNullParameter(fieldId, "fieldId");
        MutableStateFlow<Set<IFormValidator.ValidationKey>> submittedFields = getSubmittedFields();
        do {
            value = submittedFields.getValue();
        } while (!submittedFields.compareAndSet(value, SetsKt.plus(value, fieldId)));
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator
    public void submitAllFields() {
        MutableStateFlow<Set<IFormValidator.ValidationKey>> submittedFields = getSubmittedFields();
        do {
        } while (!submittedFields.compareAndSet(submittedFields.getValue(), getFieldKeys()));
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator
    public void validate(IFormValidator.ValidationKey fieldId, String value) {
        Intrinsics.checkNotNullParameter(fieldId, "fieldId");
        IInputValidator iInputValidator = this.validators.get(fieldId);
        if (iInputValidator instanceof IInputValidator.StringValidator) {
            set(fieldId, ((IInputValidator.StringValidator) iInputValidator).validate(value));
            return;
        }
        if (iInputValidator instanceof IInputValidator.CustomValidator) {
            Logger.INSTANCE.logCriticalThenFatalError(new CriticalLog(".validate(..) should not be called with CustomValidator when validation String values. FieldId: " + fieldId + " (Input value was " + value + ")"));
            return;
        }
        if (iInputValidator != null) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.INSTANCE.logCriticalThenFatalError(new CriticalLog("No validator found for fieldId: " + fieldId + " (Input value was " + value + ")"));
    }
}
