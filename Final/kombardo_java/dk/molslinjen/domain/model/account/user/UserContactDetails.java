package dk.molslinjen.domain.model.account.user;

import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PhoneNumber$$serializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002$%B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006&"}, d2 = {"Ldk/molslinjen/domain/model/account/user/UserContactDetails;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "postalCode", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEmail", "()Ljava/lang/String;", "getPhoneNumber", "()Ldk/molslinjen/domain/model/shared/PhoneNumber;", "getPostalCode", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class UserContactDetails {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UserContactDetails mock = new UserContactDetails("abcdef@vertica.dk", new PhoneNumber("+45", "12345678"), "8000");
    private final String email;
    private final PhoneNumber phoneNumber;
    private final String postalCode;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/account/user/UserContactDetails$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/account/user/UserContactDetails;", "getMock", "()Ldk/molslinjen/domain/model/account/user/UserContactDetails;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserContactDetails getMock() {
            return UserContactDetails.mock;
        }

        public final KSerializer<UserContactDetails> serializer() {
            return UserContactDetails$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ UserContactDetails(int i5, String str, PhoneNumber phoneNumber, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, UserContactDetails$$serializer.INSTANCE.getDescriptor());
        }
        this.email = str;
        this.phoneNumber = phoneNumber;
        this.postalCode = str2;
    }

    public static /* synthetic */ UserContactDetails copy$default(UserContactDetails userContactDetails, String str, PhoneNumber phoneNumber, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = userContactDetails.email;
        }
        if ((i5 & 2) != 0) {
            phoneNumber = userContactDetails.phoneNumber;
        }
        if ((i5 & 4) != 0) {
            str2 = userContactDetails.postalCode;
        }
        return userContactDetails.copy(str, phoneNumber, str2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(UserContactDetails self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.email);
        output.encodeSerializableElement(serialDesc, 1, PhoneNumber$$serializer.INSTANCE, self.phoneNumber);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.postalCode);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    public final UserContactDetails copy(String email, PhoneNumber phoneNumber, String postalCode) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return new UserContactDetails(email, phoneNumber, postalCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserContactDetails)) {
            return false;
        }
        UserContactDetails userContactDetails = (UserContactDetails) other;
        return Intrinsics.areEqual(this.email, userContactDetails.email) && Intrinsics.areEqual(this.phoneNumber, userContactDetails.phoneNumber) && Intrinsics.areEqual(this.postalCode, userContactDetails.postalCode);
    }

    public final String getEmail() {
        return this.email;
    }

    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public int hashCode() {
        int hashCode = ((this.email.hashCode() * 31) + this.phoneNumber.hashCode()) * 31;
        String str = this.postalCode;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UserContactDetails(email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", postalCode=" + this.postalCode + ")";
    }

    public UserContactDetails(String email, PhoneNumber phoneNumber, String str) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.postalCode = str;
    }
}
