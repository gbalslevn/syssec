package dk.molslinjen.domain.model.account.user;

import dk.molslinjen.api.services.account.response.AccountCompanyDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002&'B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u0006\u0010\u0014\u001a\u00020\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\fHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006("}, d2 = {"Ldk/molslinjen/domain/model/account/user/UserCompany;", BuildConfig.FLAVOR, "companyId", BuildConfig.FLAVOR, "companyName", "departmentName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/account/response/AccountCompanyDTO;", "(Ldk/molslinjen/api/services/account/response/AccountCompanyDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCompanyId", "()Ljava/lang/String;", "getCompanyName", "getDepartmentName", "companyAndDepartmentName", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class UserCompany {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UserCompany mock = new UserCompany("123123", "Vertica", "HR");
    private final String companyId;
    private final String companyName;
    private final String departmentName;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/account/user/UserCompany$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/account/user/UserCompany;", "getMock", "()Ldk/molslinjen/domain/model/account/user/UserCompany;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserCompany getMock() {
            return UserCompany.mock;
        }

        public final KSerializer<UserCompany> serializer() {
            return UserCompany$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ UserCompany(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, UserCompany$$serializer.INSTANCE.getDescriptor());
        }
        this.companyId = str;
        this.companyName = str2;
        this.departmentName = str3;
    }

    public static /* synthetic */ UserCompany copy$default(UserCompany userCompany, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = userCompany.companyId;
        }
        if ((i5 & 2) != 0) {
            str2 = userCompany.companyName;
        }
        if ((i5 & 4) != 0) {
            str3 = userCompany.departmentName;
        }
        return userCompany.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(UserCompany self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.companyId);
        output.encodeStringElement(serialDesc, 1, self.companyName);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.departmentName);
    }

    public final String companyAndDepartmentName() {
        String str = this.companyName;
        String str2 = this.departmentName;
        String str3 = BuildConfig.FLAVOR;
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        if (!StringsKt.isBlank(str2)) {
            str3 = ", " + this.departmentName;
        }
        return str + str3;
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

    public final UserCompany copy(String companyId, String companyName, String departmentName) {
        Intrinsics.checkNotNullParameter(companyId, "companyId");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        return new UserCompany(companyId, companyName, departmentName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserCompany)) {
            return false;
        }
        UserCompany userCompany = (UserCompany) other;
        return Intrinsics.areEqual(this.companyId, userCompany.companyId) && Intrinsics.areEqual(this.companyName, userCompany.companyName) && Intrinsics.areEqual(this.departmentName, userCompany.departmentName);
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
        return "UserCompany(companyId=" + this.companyId + ", companyName=" + this.companyName + ", departmentName=" + this.departmentName + ")";
    }

    public UserCompany(String companyId, String companyName, String str) {
        Intrinsics.checkNotNullParameter(companyId, "companyId");
        Intrinsics.checkNotNullParameter(companyName, "companyName");
        this.companyId = companyId;
        this.companyName = companyName;
        this.departmentName = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserCompany(AccountCompanyDTO dto) {
        this(dto.getCompanyId(), dto.getCompanyName(), dto.getDepartmentName());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
