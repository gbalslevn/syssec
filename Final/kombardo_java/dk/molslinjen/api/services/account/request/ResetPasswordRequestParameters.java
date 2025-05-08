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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Ldk/molslinjen/api/services/account/request/ResetPasswordRequestParameters;", BuildConfig.FLAVOR, "password", BuildConfig.FLAVOR, "resetToken", "rememberMe", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPassword", "()Ljava/lang/String;", "getResetToken$annotations", "()V", "getResetToken", "getRememberMe", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class ResetPasswordRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String password;
    private final boolean rememberMe;
    private final String resetToken;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/request/ResetPasswordRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/request/ResetPasswordRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ResetPasswordRequestParameters> serializer() {
            return ResetPasswordRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ ResetPasswordRequestParameters(int i5, String str, String str2, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, ResetPasswordRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.password = str;
        this.resetToken = str2;
        if ((i5 & 4) == 0) {
            this.rememberMe = true;
        } else {
            this.rememberMe = z5;
        }
    }

    public static /* synthetic */ ResetPasswordRequestParameters copy$default(ResetPasswordRequestParameters resetPasswordRequestParameters, String str, String str2, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = resetPasswordRequestParameters.password;
        }
        if ((i5 & 2) != 0) {
            str2 = resetPasswordRequestParameters.resetToken;
        }
        if ((i5 & 4) != 0) {
            z5 = resetPasswordRequestParameters.rememberMe;
        }
        return resetPasswordRequestParameters.copy(str, str2, z5);
    }

    public static /* synthetic */ void getResetToken$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(ResetPasswordRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.password);
        output.encodeStringElement(serialDesc, 1, self.resetToken);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.rememberMe) {
            return;
        }
        output.encodeBooleanElement(serialDesc, 2, self.rememberMe);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* renamed from: component2, reason: from getter */
    public final String getResetToken() {
        return this.resetToken;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getRememberMe() {
        return this.rememberMe;
    }

    public final ResetPasswordRequestParameters copy(String password, String resetToken, boolean rememberMe) {
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(resetToken, "resetToken");
        return new ResetPasswordRequestParameters(password, resetToken, rememberMe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResetPasswordRequestParameters)) {
            return false;
        }
        ResetPasswordRequestParameters resetPasswordRequestParameters = (ResetPasswordRequestParameters) other;
        return Intrinsics.areEqual(this.password, resetPasswordRequestParameters.password) && Intrinsics.areEqual(this.resetToken, resetPasswordRequestParameters.resetToken) && this.rememberMe == resetPasswordRequestParameters.rememberMe;
    }

    public final String getPassword() {
        return this.password;
    }

    public final boolean getRememberMe() {
        return this.rememberMe;
    }

    public final String getResetToken() {
        return this.resetToken;
    }

    public int hashCode() {
        return (((this.password.hashCode() * 31) + this.resetToken.hashCode()) * 31) + Boolean.hashCode(this.rememberMe);
    }

    public String toString() {
        return "ResetPasswordRequestParameters(password=" + this.password + ", resetToken=" + this.resetToken + ", rememberMe=" + this.rememberMe + ")";
    }

    public ResetPasswordRequestParameters(String password, String resetToken, boolean z5) {
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(resetToken, "resetToken");
        this.password = password;
        this.resetToken = resetToken;
        this.rememberMe = z5;
    }

    public /* synthetic */ ResetPasswordRequestParameters(String str, String str2, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i5 & 4) != 0 ? true : z5);
    }
}
