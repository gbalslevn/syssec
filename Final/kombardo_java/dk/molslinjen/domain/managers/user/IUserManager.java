package dk.molslinjen.domain.managers.user;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeMethod;
import dk.molslinjen.domain.model.account.MergeResult;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002=>J\b\u0010\r\u001a\u00020\u000eH&J\u000e\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u0014\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u0014\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u0018\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u0018\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\u001c\u001a\u00020\u001dH¦@¢\u0006\u0002\u0010\u001eJ$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H¦@¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010&H&¢\u0006\u0004\b'\u0010(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010!\u001a\u00020\"H¦@¢\u0006\u0002\u0010*J$\u0010+\u001a\b\u0012\u0004\u0012\u00020 0\u00132\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\"H¦@¢\u0006\u0002\u0010$J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020 0\u00132\u0006\u0010/\u001a\u00020\"H¦@¢\u0006\u0002\u0010*J$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u00101\u001a\u00020\"2\u0006\u0010,\u001a\u00020\"H¦@¢\u0006\u0002\u0010$J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H¦@¢\u0006\u0002\u0010\u0011J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020\u00100\u00132\b\u00104\u001a\u0004\u0018\u00010\"H¦@¢\u0006\u0002\u0010*J\u000e\u00105\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011J\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H¦@¢\u0006\u0002\u0010\u0011J\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00132\u0006\u00109\u001a\u00020:H¦@¢\u0006\u0002\u0010;J\u000e\u0010<\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006?"}, d2 = {"Ldk/molslinjen/domain/managers/user/IUserManager;", BuildConfig.FLAVOR, "currentUserState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/IUserManager$UserState;", "getCurrentUserState", "()Lkotlinx/coroutines/flow/StateFlow;", "pendingAccountActivation", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;", "getPendingAccountActivation", "authenticationType", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "getAuthenticationType", "createUserInfoInput", "Ldk/molslinjen/domain/managers/user/UserInfoInput;", "clearPendingActivation", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAccount", "Ldk/molslinjen/domain/managers/ManagerResult;", "userInfoInput", "(Ldk/molslinjen/domain/managers/user/UserInfoInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "updateAccountUser", "personalDetails", "Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;", "(Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalUser", "contactDetails", "Ldk/molslinjen/domain/model/account/user/UserContactDetails;", "(Ldk/molslinjen/domain/model/account/user/UserContactDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Ldk/molslinjen/domain/managers/user/LoginResult;", "email", BuildConfig.FLAVOR, "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthToken", "Ldk/molslinjen/domain/model/account/AuthToken;", "getAuthToken-OEbVFrA", "()Ljava/lang/String;", "forgotPassword", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPassword", "newPassword", "resetToken", "activateAccount", "activationToken", "changePassword", "currentPassword", "loadUserInfo", "changeAccount", "companyId", "logout", "deleteAccount", "mergeAssets", "Ldk/molslinjen/domain/model/account/MergeResult;", "method", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;", "(Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMerge", "UserState", "ActivationInfo", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IUserManager {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u0017¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "firstName", "lastName", "email", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$domain_kombardoProd", "(Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFirstName", "getLastName", "getEmail", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class ActivationInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String email;
        private final String firstName;
        private final String lastName;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ActivationInfo> serializer() {
                return IUserManager$ActivationInfo$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ActivationInfo(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, IUserManager$ActivationInfo$$serializer.INSTANCE.getDescriptor());
            }
            this.firstName = str;
            this.lastName = str2;
            this.email = str3;
        }

        public static final /* synthetic */ void write$Self$domain_kombardoProd(ActivationInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.firstName);
            output.encodeStringElement(serialDesc, 1, self.lastName);
            output.encodeStringElement(serialDesc, 2, self.email);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActivationInfo)) {
                return false;
            }
            ActivationInfo activationInfo = (ActivationInfo) other;
            return Intrinsics.areEqual(this.firstName, activationInfo.firstName) && Intrinsics.areEqual(this.lastName, activationInfo.lastName) && Intrinsics.areEqual(this.email, activationInfo.email);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public int hashCode() {
            return (((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.email.hashCode();
        }

        public String toString() {
            return "ActivationInfo(firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ")";
        }

        public ActivationInfo(String firstName, String lastName, String email) {
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(email, "email");
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }

    Object activateAccount(String str, Continuation<? super ManagerResult<? extends LoginResult>> continuation);

    Object cancelMerge(Continuation<? super Unit> continuation);

    Object changeAccount(String str, Continuation<? super ManagerResult<Unit>> continuation);

    Object changePassword(String str, String str2, Continuation<? super ManagerResult<Unit>> continuation);

    Object clearPendingActivation(Continuation<? super Unit> continuation);

    Object createAccount(UserInfoInput userInfoInput, Continuation<? super ManagerResult<Unit>> continuation);

    UserInfoInput createUserInfoInput();

    Object deleteAccount(Continuation<? super ManagerResult<Unit>> continuation);

    Object forgotPassword(String str, Continuation<? super ManagerResult<Unit>> continuation);

    /* renamed from: getAuthToken-OEbVFrA, reason: not valid java name */
    String mo3198getAuthTokenOEbVFrA();

    StateFlow<AuthenticationType> getAuthenticationType();

    StateFlow<UserState> getCurrentUserState();

    StateFlow<ActivationInfo> getPendingAccountActivation();

    Object loadUserInfo(Continuation<? super ManagerResult<Unit>> continuation);

    Object login(String str, String str2, Continuation<? super ManagerResult<? extends LoginResult>> continuation);

    Object logout(Continuation<? super Unit> continuation);

    Object mergeAssets(AssetsMergeMethod assetsMergeMethod, Continuation<? super ManagerResult<MergeResult>> continuation);

    Object resetPassword(String str, String str2, Continuation<? super ManagerResult<? extends LoginResult>> continuation);

    Object updateAccountUser(UserPersonalDetails userPersonalDetails, Continuation<? super ManagerResult<Unit>> continuation);

    Object updateLocalUser(UserContactDetails userContactDetails, Continuation<? super ManagerResult<Unit>> continuation);

    Object updateLocalUser(UserPersonalDetails userPersonalDetails, Continuation<? super ManagerResult<Unit>> continuation);

    Object updateUser(UserInfoInput userInfoInput, Continuation<? super ManagerResult<Unit>> continuation);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/managers/user/IUserManager$UserState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/user/User;", "user", BuildConfig.FLAVOR, "activeCompanyId", "<init>", "(Ldk/molslinjen/domain/model/account/user/User;Ljava/lang/String;)V", "copy", "(Ldk/molslinjen/domain/model/account/user/User;Ljava/lang/String;)Ldk/molslinjen/domain/managers/user/IUserManager$UserState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/account/user/User;", "getUser", "()Ldk/molslinjen/domain/model/account/user/User;", "Ljava/lang/String;", "getActiveCompanyId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class UserState {
        private final String activeCompanyId;
        private final User user;

        public UserState(User user, String str) {
            Intrinsics.checkNotNullParameter(user, "user");
            this.user = user;
            this.activeCompanyId = str;
        }

        public static /* synthetic */ UserState copy$default(UserState userState, User user, String str, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                user = userState.user;
            }
            if ((i5 & 2) != 0) {
                str = userState.activeCompanyId;
            }
            return userState.copy(user, str);
        }

        public final UserState copy(User user, String activeCompanyId) {
            Intrinsics.checkNotNullParameter(user, "user");
            return new UserState(user, activeCompanyId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserState)) {
                return false;
            }
            UserState userState = (UserState) other;
            return Intrinsics.areEqual(this.user, userState.user) && Intrinsics.areEqual(this.activeCompanyId, userState.activeCompanyId);
        }

        public final String getActiveCompanyId() {
            return this.activeCompanyId;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            int hashCode = this.user.hashCode() * 31;
            String str = this.activeCompanyId;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UserState(user=" + this.user + ", activeCompanyId=" + this.activeCompanyId + ")";
        }

        public /* synthetic */ UserState(User user, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(user, (i5 & 2) != 0 ? null : str);
        }
    }
}
