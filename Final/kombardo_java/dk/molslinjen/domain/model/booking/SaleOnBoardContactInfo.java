package dk.molslinjen.domain.model.booking;

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
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002()B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBA\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "email", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "wasPrefilled", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getEmail", "getPhoneNumber", "()Ldk/molslinjen/domain/model/shared/PhoneNumber;", "getWasPrefilled", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardContactInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SaleOnBoardContactInfo mock = new SaleOnBoardContactInfo("John Doe", "test@asf.dk", new PhoneNumber("12345678", (String) null, 2, (DefaultConstructorMarker) null), false);
    private final String email;
    private final String name;
    private final PhoneNumber phoneNumber;
    private final boolean wasPrefilled;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "getMock", "()Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardContactInfo getMock() {
            return SaleOnBoardContactInfo.mock;
        }

        public final KSerializer<SaleOnBoardContactInfo> serializer() {
            return SaleOnBoardContactInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SaleOnBoardContactInfo(int i5, String str, String str2, PhoneNumber phoneNumber, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, SaleOnBoardContactInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.email = str2;
        this.phoneNumber = phoneNumber;
        this.wasPrefilled = z5;
    }

    public static /* synthetic */ SaleOnBoardContactInfo copy$default(SaleOnBoardContactInfo saleOnBoardContactInfo, String str, String str2, PhoneNumber phoneNumber, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardContactInfo.name;
        }
        if ((i5 & 2) != 0) {
            str2 = saleOnBoardContactInfo.email;
        }
        if ((i5 & 4) != 0) {
            phoneNumber = saleOnBoardContactInfo.phoneNumber;
        }
        if ((i5 & 8) != 0) {
            z5 = saleOnBoardContactInfo.wasPrefilled;
        }
        return saleOnBoardContactInfo.copy(str, str2, phoneNumber, z5);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardContactInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.email);
        output.encodeSerializableElement(serialDesc, 2, PhoneNumber$$serializer.INSTANCE, self.phoneNumber);
        output.encodeBooleanElement(serialDesc, 3, self.wasPrefilled);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component3, reason: from getter */
    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getWasPrefilled() {
        return this.wasPrefilled;
    }

    public final SaleOnBoardContactInfo copy(String name, String email, PhoneNumber phoneNumber, boolean wasPrefilled) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return new SaleOnBoardContactInfo(name, email, phoneNumber, wasPrefilled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardContactInfo)) {
            return false;
        }
        SaleOnBoardContactInfo saleOnBoardContactInfo = (SaleOnBoardContactInfo) other;
        return Intrinsics.areEqual(this.name, saleOnBoardContactInfo.name) && Intrinsics.areEqual(this.email, saleOnBoardContactInfo.email) && Intrinsics.areEqual(this.phoneNumber, saleOnBoardContactInfo.phoneNumber) && this.wasPrefilled == saleOnBoardContactInfo.wasPrefilled;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getName() {
        return this.name;
    }

    public final PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public final boolean getWasPrefilled() {
        return this.wasPrefilled;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.email.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + Boolean.hashCode(this.wasPrefilled);
    }

    public String toString() {
        return "SaleOnBoardContactInfo(name=" + this.name + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", wasPrefilled=" + this.wasPrefilled + ")";
    }

    public SaleOnBoardContactInfo(String name, String email, PhoneNumber phoneNumber, boolean z5) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wasPrefilled = z5;
    }
}
