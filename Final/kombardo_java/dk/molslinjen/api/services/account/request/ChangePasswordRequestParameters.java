package dk.molslinjen.api.services.account.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Ldk/molslinjen/api/services/account/request/ChangePasswordRequestParameters;", BuildConfig.FLAVOR, "oldPassword", BuildConfig.FLAVOR, "newPassword", "rememberMe", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOldPassword", "()Ljava/lang/String;", "getNewPassword", "getRememberMe", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ChangePasswordRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String newPassword;
    private final String oldPassword;
    private final boolean rememberMe;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/request/ChangePasswordRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/request/ChangePasswordRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ChangePasswordRequestParameters> serializer() {
            return ChangePasswordRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ChangePasswordRequestParameters(int i5, String str, String str2, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, ChangePasswordRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.oldPassword = str;
        this.newPassword = str2;
        if ((i5 & 4) == 0) {
            this.rememberMe = true;
        } else {
            this.rememberMe = z5;
        }
    }

    public static /* synthetic */ ChangePasswordRequestParameters copy$default(ChangePasswordRequestParameters changePasswordRequestParameters, String str, String str2, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = changePasswordRequestParameters.oldPassword;
        }
        if ((i5 & 2) != 0) {
            str2 = changePasswordRequestParameters.newPassword;
        }
        if ((i5 & 4) != 0) {
            z5 = changePasswordRequestParameters.rememberMe;
        }
        return changePasswordRequestParameters.copy(str, str2, z5);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ChangePasswordRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.oldPassword);
        output.encodeStringElement(serialDesc, 1, self.newPassword);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.rememberMe) {
            return;
        }
        output.encodeBooleanElement(serialDesc, 2, self.rememberMe);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOldPassword() {
        return this.oldPassword;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNewPassword() {
        return this.newPassword;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getRememberMe() {
        return this.rememberMe;
    }

    public final ChangePasswordRequestParameters copy(String oldPassword, String newPassword, boolean rememberMe) {
        Intrinsics.checkNotNullParameter(oldPassword, "oldPassword");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        return new ChangePasswordRequestParameters(oldPassword, newPassword, rememberMe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangePasswordRequestParameters)) {
            return false;
        }
        ChangePasswordRequestParameters changePasswordRequestParameters = (ChangePasswordRequestParameters) other;
        return Intrinsics.areEqual(this.oldPassword, changePasswordRequestParameters.oldPassword) && Intrinsics.areEqual(this.newPassword, changePasswordRequestParameters.newPassword) && this.rememberMe == changePasswordRequestParameters.rememberMe;
    }

    public final String getNewPassword() {
        return this.newPassword;
    }

    public final String getOldPassword() {
        return this.oldPassword;
    }

    public final boolean getRememberMe() {
        return this.rememberMe;
    }

    public int hashCode() {
        return (((this.oldPassword.hashCode() * 31) + this.newPassword.hashCode()) * 31) + Boolean.hashCode(this.rememberMe);
    }

    public String toString() {
        return "ChangePasswordRequestParameters(oldPassword=" + this.oldPassword + ", newPassword=" + this.newPassword + ", rememberMe=" + this.rememberMe + ")";
    }

    public ChangePasswordRequestParameters(String oldPassword, String newPassword, boolean z5) {
        Intrinsics.checkNotNullParameter(oldPassword, "oldPassword");
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.rememberMe = z5;
    }

    public /* synthetic */ ChangePasswordRequestParameters(String str, String str2, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i5 & 4) != 0 ? true : z5);
    }
}
