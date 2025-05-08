package dk.molslinjen.domain.model.account.user;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.account.response.AccountCompanyDTO;
import dk.molslinjen.api.services.account.response.AccountInfoResponseDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002+,B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rB?\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\t\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000fHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Ldk/molslinjen/domain/model/account/user/AccountUser;", "Ldk/molslinjen/domain/model/account/user/User;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "companies", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/user/UserCompany;", "userInfo", "Ldk/molslinjen/domain/model/account/user/UserInfo;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/account/user/UserInfo;)V", "dto", "Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;", "(Ldk/molslinjen/api/services/account/response/AccountInfoResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/account/user/UserInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getCompanies", "()Ljava/util/List;", "getUserInfo", "()Ldk/molslinjen/domain/model/account/user/UserInfo;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AccountUser extends User {
    private final List<UserCompany> companies;
    private final String id;
    private final UserInfo userInfo;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(UserCompany$$serializer.INSTANCE), null};
    private static final AccountUser mock = new AccountUser("1234", CollectionsKt.listOf(UserCompany.INSTANCE.getMock()), UserInfo.INSTANCE.getMock());

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/account/user/AccountUser$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/account/user/AccountUser;", "getMock", "()Ldk/molslinjen/domain/model/account/user/AccountUser;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccountUser getMock() {
            return AccountUser.mock;
        }

        public final KSerializer<AccountUser> serializer() {
            return AccountUser$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountUser(int i5, String str, List list, UserInfo userInfo, SerializationConstructorMarker serializationConstructorMarker) {
        super(i5, serializationConstructorMarker);
        if (5 != (i5 & 5)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 5, AccountUser$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        if ((i5 & 2) == 0) {
            this.companies = CollectionsKt.emptyList();
        } else {
            this.companies = list;
        }
        this.userInfo = userInfo;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccountUser copy$default(AccountUser accountUser, String str, List list, UserInfo userInfo, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = accountUser.id;
        }
        if ((i5 & 2) != 0) {
            list = accountUser.companies;
        }
        if ((i5 & 4) != 0) {
            userInfo = accountUser.userInfo;
        }
        return accountUser.copy(str, list, userInfo);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(AccountUser self, CompositeEncoder output, SerialDescriptor serialDesc) {
        User.write$Self(self, output, serialDesc);
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.companies, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.companies);
        }
        output.encodeNullableSerializableElement(serialDesc, 2, UserInfo$$serializer.INSTANCE, self.userInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<UserCompany> component2() {
        return this.companies;
    }

    /* renamed from: component3, reason: from getter */
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public final AccountUser copy(String r22, List<UserCompany> companies, UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(companies, "companies");
        return new AccountUser(r22, companies, userInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccountUser)) {
            return false;
        }
        AccountUser accountUser = (AccountUser) other;
        return Intrinsics.areEqual(this.id, accountUser.id) && Intrinsics.areEqual(this.companies, accountUser.companies) && Intrinsics.areEqual(this.userInfo, accountUser.userInfo);
    }

    public final List<UserCompany> getCompanies() {
        return this.companies;
    }

    public final String getId() {
        return this.id;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.companies.hashCode()) * 31;
        UserInfo userInfo = this.userInfo;
        return hashCode + (userInfo != null ? userInfo.hashCode() : 0);
    }

    public String toString() {
        return "AccountUser(id=" + this.id + ", companies=" + this.companies + ", userInfo=" + this.userInfo + ")";
    }

    public /* synthetic */ AccountUser(String str, List list, UserInfo userInfo, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list, userInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountUser(String str, List<UserCompany> companies, UserInfo userInfo) {
        super(null);
        Intrinsics.checkNotNullParameter(companies, "companies");
        this.id = str;
        this.companies = companies;
        this.userInfo = userInfo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AccountUser(AccountInfoResponseDTO dto) {
        this(r0, r2, new UserInfo(dto));
        Intrinsics.checkNotNullParameter(dto, "dto");
        String userId = dto.getUserId();
        List<AccountCompanyDTO> companies = dto.getCompanies();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(companies, 10));
        Iterator<T> it = companies.iterator();
        while (it.hasNext()) {
            arrayList.add(new UserCompany((AccountCompanyDTO) it.next()));
        }
    }
}
