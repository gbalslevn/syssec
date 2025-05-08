package dk.molslinjen.ui.views.screens.profile.shared.userInfo;

import dk.molslinjen.core.extensions.LocaleExtensionsKt;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0014H\u0016J\u0012\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u0014H\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020\u0012H\u0016J\f\u0010,\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006-"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/UserInfoInputHandler;", "Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "<init>", "(Ldk/molslinjen/domain/managers/user/IUserManager;)V", "initialData", "Ldk/molslinjen/domain/managers/user/UserInfoInput;", "userInfoInput", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getUserInfoInput", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "hasChanges", "Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "getHasChanges", "()Lkotlinx/coroutines/flow/StateFlow;", "updateFirstName", BuildConfig.FLAVOR, "firstName", BuildConfig.FLAVOR, "updateLastName", "lastName", "updateGender", "gender", "Ldk/molslinjen/domain/model/account/Gender;", "updateNationality", "locale", "Ljava/util/Locale;", "updateBirthdate", "birthdate", "Lorg/threeten/bp/LocalDate;", "updatePostalCode", "zipCode", "updatePhoneNumberCode", "phoneNumberCode", "updatePhoneNumber", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "updateEmail", "email", "updatePassword", "password", "ensureCountryCodePrefilled", "copyWithPrefilledCountryCode", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserInfoInputHandler implements IUserInfoInputHandler {
    private final StateFlow<Boolean> hasChanges;
    private final UserInfoInput initialData;
    private final MutableStateFlow<UserInfoInput> userInfoInput;

    public UserInfoInputHandler(IUserManager userManager) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.userInfoInput = StateFlowKt.MutableStateFlow(new UserInfoInput(null, null, null, null, null, null, null, null, null, false, 1023, null));
        this.initialData = copyWithPrefilledCountryCode(userManager.createUserInfoInput());
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
        } while (!userInfoInput.compareAndSet(userInfoInput.getValue(), this.initialData));
        final MutableStateFlow<UserInfoInput> userInfoInput2 = getUserInfoInput();
        this.hasChanges = FlowKt.stateIn(new Flow<Boolean>() { // from class: dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoInputHandler$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            /* renamed from: dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoInputHandler$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ UserInfoInputHandler this$0;

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                @DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoInputHandler$special$$inlined$map$1$2", f = "UserInfoInputHandler.kt", l = {223}, m = "emit")
                /* renamed from: dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoInputHandler$special$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, UserInfoInputHandler userInfoInputHandler) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = userInfoInputHandler;
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
                    UserInfoInput userInfoInput;
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
                                userInfoInput = this.this$0.initialData;
                                Boolean boxBoolean = Boxing.boxBoolean(!Intrinsics.areEqual((UserInfoInput) obj, userInfoInput));
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
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), SharingStarted.INSTANCE.getLazily(), Boolean.FALSE);
    }

    private final UserInfoInput copyWithPrefilledCountryCode(UserInfoInput userInfoInput) {
        PhoneNumber phoneNumber;
        UserInfoInput copy;
        String countryCode;
        if (userInfoInput.getPhoneNumber().getCountryCode().length() == 0) {
            PhoneNumber phoneNumber2 = userInfoInput.getPhoneNumber();
            Locale nationality = userInfoInput.getNationality();
            if (nationality == null || (countryCode = LocaleExtensionsKt.getPhoneNumberCountryCode(nationality)) == null) {
                countryCode = userInfoInput.getPhoneNumber().getCountryCode();
            }
            phoneNumber = PhoneNumber.copy$default(phoneNumber2, countryCode, null, 2, null);
        } else {
            phoneNumber = userInfoInput.getPhoneNumber();
        }
        copy = userInfoInput.copy((r22 & 1) != 0 ? userInfoInput.firstName : null, (r22 & 2) != 0 ? userInfoInput.lastName : null, (r22 & 4) != 0 ? userInfoInput.gender : null, (r22 & 8) != 0 ? userInfoInput.nationality : null, (r22 & 16) != 0 ? userInfoInput.birthdate : null, (r22 & 32) != 0 ? userInfoInput.postalCode : null, (r22 & 64) != 0 ? userInfoInput.phoneNumber : phoneNumber, (r22 & 128) != 0 ? userInfoInput.email : null, (r22 & 256) != 0 ? userInfoInput.password : null, (r22 & 512) != 0 ? userInfoInput.wasPrefilled : false);
        return copy;
    }

    public void ensureCountryCodePrefilled() {
        UserInfoInput value;
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
        } while (!userInfoInput.compareAndSet(value, copyWithPrefilledCountryCode(value)));
    }

    public StateFlow<Boolean> getHasChanges() {
        return this.hasChanges;
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public MutableStateFlow<UserInfoInput> getUserInfoInput() {
        return this.userInfoInput;
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateBirthdate(LocalDate birthdate) {
        UserInfoInput value;
        UserInfoInput copy;
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r2.copy((r22 & 1) != 0 ? r2.firstName : null, (r22 & 2) != 0 ? r2.lastName : null, (r22 & 4) != 0 ? r2.gender : null, (r22 & 8) != 0 ? r2.nationality : null, (r22 & 16) != 0 ? r2.birthdate : birthdate, (r22 & 32) != 0 ? r2.postalCode : null, (r22 & 64) != 0 ? r2.phoneNumber : null, (r22 & 128) != 0 ? r2.email : null, (r22 & 256) != 0 ? r2.password : null, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateEmail(String email) {
        UserInfoInput value;
        UserInfoInput copy;
        Intrinsics.checkNotNullParameter(email, "email");
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r1.copy((r22 & 1) != 0 ? r1.firstName : null, (r22 & 2) != 0 ? r1.lastName : null, (r22 & 4) != 0 ? r1.gender : null, (r22 & 8) != 0 ? r1.nationality : null, (r22 & 16) != 0 ? r1.birthdate : null, (r22 & 32) != 0 ? r1.postalCode : null, (r22 & 64) != 0 ? r1.phoneNumber : null, (r22 & 128) != 0 ? r1.email : email, (r22 & 256) != 0 ? r1.password : null, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateFirstName(String firstName) {
        UserInfoInput value;
        UserInfoInput copy;
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r1.copy((r22 & 1) != 0 ? r1.firstName : firstName, (r22 & 2) != 0 ? r1.lastName : null, (r22 & 4) != 0 ? r1.gender : null, (r22 & 8) != 0 ? r1.nationality : null, (r22 & 16) != 0 ? r1.birthdate : null, (r22 & 32) != 0 ? r1.postalCode : null, (r22 & 64) != 0 ? r1.phoneNumber : null, (r22 & 128) != 0 ? r1.email : null, (r22 & 256) != 0 ? r1.password : null, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateGender(Gender gender) {
        UserInfoInput value;
        UserInfoInput copy;
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r2.copy((r22 & 1) != 0 ? r2.firstName : null, (r22 & 2) != 0 ? r2.lastName : null, (r22 & 4) != 0 ? r2.gender : gender, (r22 & 8) != 0 ? r2.nationality : null, (r22 & 16) != 0 ? r2.birthdate : null, (r22 & 32) != 0 ? r2.postalCode : null, (r22 & 64) != 0 ? r2.phoneNumber : null, (r22 & 128) != 0 ? r2.email : null, (r22 & 256) != 0 ? r2.password : null, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateLastName(String lastName) {
        UserInfoInput value;
        UserInfoInput copy;
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r1.copy((r22 & 1) != 0 ? r1.firstName : null, (r22 & 2) != 0 ? r1.lastName : lastName, (r22 & 4) != 0 ? r1.gender : null, (r22 & 8) != 0 ? r1.nationality : null, (r22 & 16) != 0 ? r1.birthdate : null, (r22 & 32) != 0 ? r1.postalCode : null, (r22 & 64) != 0 ? r1.phoneNumber : null, (r22 & 128) != 0 ? r1.email : null, (r22 & 256) != 0 ? r1.password : null, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updateNationality(Locale locale) {
        UserInfoInput value;
        UserInfoInput copy;
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r2.copy((r22 & 1) != 0 ? r2.firstName : null, (r22 & 2) != 0 ? r2.lastName : null, (r22 & 4) != 0 ? r2.gender : null, (r22 & 8) != 0 ? r2.nationality : locale, (r22 & 16) != 0 ? r2.birthdate : null, (r22 & 32) != 0 ? r2.postalCode : null, (r22 & 64) != 0 ? r2.phoneNumber : null, (r22 & 128) != 0 ? r2.email : null, (r22 & 256) != 0 ? r2.password : null, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
        ensureCountryCodePrefilled();
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePassword(String password) {
        UserInfoInput value;
        UserInfoInput copy;
        Intrinsics.checkNotNullParameter(password, "password");
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r1.copy((r22 & 1) != 0 ? r1.firstName : null, (r22 & 2) != 0 ? r1.lastName : null, (r22 & 4) != 0 ? r1.gender : null, (r22 & 8) != 0 ? r1.nationality : null, (r22 & 16) != 0 ? r1.birthdate : null, (r22 & 32) != 0 ? r1.postalCode : null, (r22 & 64) != 0 ? r1.phoneNumber : null, (r22 & 128) != 0 ? r1.email : null, (r22 & 256) != 0 ? r1.password : password, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePhoneNumber(PhoneNumber phoneNumber) {
        UserInfoInput value;
        UserInfoInput copy;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r1.copy((r22 & 1) != 0 ? r1.firstName : null, (r22 & 2) != 0 ? r1.lastName : null, (r22 & 4) != 0 ? r1.gender : null, (r22 & 8) != 0 ? r1.nationality : null, (r22 & 16) != 0 ? r1.birthdate : null, (r22 & 32) != 0 ? r1.postalCode : null, (r22 & 64) != 0 ? r1.phoneNumber : phoneNumber, (r22 & 128) != 0 ? r1.email : null, (r22 & 256) != 0 ? r1.password : null, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
    }

    public void updatePhoneNumberCode(String phoneNumberCode) {
        PhoneNumber phoneNumber = getUserInfoInput().getValue().getPhoneNumber();
        if (phoneNumberCode == null) {
            phoneNumberCode = getUserInfoInput().getValue().getPhoneNumber().getCountryCode();
        }
        updatePhoneNumber(PhoneNumber.copy$default(phoneNumber, phoneNumberCode, null, 2, null));
    }

    @Override // dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler
    public void updatePostalCode(String zipCode) {
        UserInfoInput value;
        UserInfoInput copy;
        Intrinsics.checkNotNullParameter(zipCode, "zipCode");
        MutableStateFlow<UserInfoInput> userInfoInput = getUserInfoInput();
        do {
            value = userInfoInput.getValue();
            copy = r3.copy((r22 & 1) != 0 ? r3.firstName : null, (r22 & 2) != 0 ? r3.lastName : null, (r22 & 4) != 0 ? r3.gender : null, (r22 & 8) != 0 ? r3.nationality : null, (r22 & 16) != 0 ? r3.birthdate : null, (r22 & 32) != 0 ? r3.postalCode : zipCode.length() == 0 ? null : zipCode, (r22 & 64) != 0 ? r3.phoneNumber : null, (r22 & 128) != 0 ? r3.email : null, (r22 & 256) != 0 ? r3.password : null, (r22 & 512) != 0 ? value.wasPrefilled : false);
        } while (!userInfoInput.compareAndSet(value, copy));
    }
}
