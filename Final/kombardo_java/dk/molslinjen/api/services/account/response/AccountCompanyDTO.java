package dk.molslinjen.api.services.account.response;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/account/response/AccountCompanyDTO;", BuildConfig.FLAVOR, "companyId", BuildConfig.FLAVOR, "companyName", "departmentName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCompanyId", "()Ljava/lang/String;", "getCompanyName", "getDepartmentName", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AccountCompanyDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String companyId;
    private final String companyName;
    private final String departmentName;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/response/AccountCompanyDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/response/AccountCompanyDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<AccountCompanyDTO> serializer() {
            return AccountCompanyDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ AccountCompanyDTO(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, AccountCompanyDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.companyId = str;
        this.companyName = str2;
        this.departmentName = str3;
    }

    public static /* synthetic */ AccountCompanyDTO copy$default(AccountCompanyDTO accountCompanyDTO, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = accountCompanyDTO.companyId;
        }
        if ((i5 & 2) != 0) {
            str2 = accountCompanyDTO.companyName;
        }
        if ((i5 & 4) != 0) {
            str3 = accountCompanyDTO.departmentName;
        }
        return accountCompanyDTO.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(AccountCompanyDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.companyId);
        output.encodeStringElement(serialDesc, 1, self.companyName);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.departmentName);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCompanyId() {
        return this.companyId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCompanyName() {
        return this.companyName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDepartmentName() {
        return this.departmentName;
    }

    public final AccountCompanyDTO copy(String companyId, String companyName, String departmentName) {
        Intrinsics.checkNotNullParameter(companyId, "companyId");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        return new AccountCompanyDTO(companyId, companyName, departmentName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountCompanyDTO)) {
            return false;
        }
        AccountCompanyDTO accountCompanyDTO = (AccountCompanyDTO) other;
        return Intrinsics.areEqual(this.companyId, accountCompanyDTO.companyId) && Intrinsics.areEqual(this.companyName, accountCompanyDTO.companyName) && Intrinsics.areEqual(this.departmentName, accountCompanyDTO.departmentName);
    }

    public final String getCompanyId() {
        return this.companyId;
    }

    public final String getCompanyName() {
        return this.companyName;
    }

    public final String getDepartmentName() {
        return this.departmentName;
    }

    public int hashCode() {
        int hashCode = ((this.companyId.hashCode() * 31) + this.companyName.hashCode()) * 31;
        String str = this.departmentName;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AccountCompanyDTO(companyId=" + this.companyId + ", companyName=" + this.companyName + ", departmentName=" + this.departmentName + ")";
    }

    public AccountCompanyDTO(String companyId, String companyName, String str) {
        Intrinsics.checkNotNullParameter(companyId, "companyId");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        this.companyId = companyId;
        this.companyName = companyName;
        this.departmentName = str;
    }
}
