package dk.molslinjen.api.services.account.booking.request;

import dk.molslinjen.api.helpers.serializers.LocalDateNoDashesSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eB_\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010'\u001a\u00020\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J^\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001fR\u001e\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c¨\u0006;"}, d2 = {"Ldk/molslinjen/api/services/account/booking/request/GetAccountBookingsRequestParameter;", BuildConfig.FLAVOR, "active", BuildConfig.FLAVOR, "take", BuildConfig.FLAVOR, "skip", "userId", BuildConfig.FLAVOR, "startDate", "Lorg/threeten/bp/LocalDate;", "endDate", "companyId", "<init>", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getActive", "()Z", "getTake", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSkip", "getUserId$annotations", "()V", "getUserId", "()Ljava/lang/String;", "getStartDate$annotations", "getStartDate", "()Lorg/threeten/bp/LocalDate;", "getEndDate$annotations", "getEndDate", "getCompanyId$annotations", "getCompanyId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Ljava/lang/String;)Ldk/molslinjen/api/services/account/booking/request/GetAccountBookingsRequestParameter;", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class GetAccountBookingsRequestParameter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean active;
    private final String companyId;
    private final LocalDate endDate;
    private final Integer skip;
    private final LocalDate startDate;
    private final Integer take;
    private final String userId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/booking/request/GetAccountBookingsRequestParameter$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/booking/request/GetAccountBookingsRequestParameter;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<GetAccountBookingsRequestParameter> serializer() {
            return GetAccountBookingsRequestParameter$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ GetAccountBookingsRequestParameter(int i5, boolean z5, Integer num, Integer num2, String str, LocalDate localDate, LocalDate localDate2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, GetAccountBookingsRequestParameter$$serializer.INSTANCE.getDescriptor());
        }
        this.active = z5;
        this.take = num;
        this.skip = num2;
        this.userId = str;
        this.startDate = localDate;
        this.endDate = localDate2;
        this.companyId = str2;
    }

    public static /* synthetic */ GetAccountBookingsRequestParameter copy$default(GetAccountBookingsRequestParameter getAccountBookingsRequestParameter, boolean z5, Integer num, Integer num2, String str, LocalDate localDate, LocalDate localDate2, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = getAccountBookingsRequestParameter.active;
        }
        if ((i5 & 2) != 0) {
            num = getAccountBookingsRequestParameter.take;
        }
        Integer num3 = num;
        if ((i5 & 4) != 0) {
            num2 = getAccountBookingsRequestParameter.skip;
        }
        Integer num4 = num2;
        if ((i5 & 8) != 0) {
            str = getAccountBookingsRequestParameter.userId;
        }
        String str3 = str;
        if ((i5 & 16) != 0) {
            localDate = getAccountBookingsRequestParameter.startDate;
        }
        LocalDate localDate3 = localDate;
        if ((i5 & 32) != 0) {
            localDate2 = getAccountBookingsRequestParameter.endDate;
        }
        LocalDate localDate4 = localDate2;
        if ((i5 & 64) != 0) {
            str2 = getAccountBookingsRequestParameter.companyId;
        }
        return getAccountBookingsRequestParameter.copy(z5, num3, num4, str3, localDate3, localDate4, str2);
    }

    public static /* synthetic */ void getCompanyId$annotations() {
    }

    @Serializable(with = LocalDateNoDashesSerializer.class)
    public static /* synthetic */ void getEndDate$annotations() {
    }

    @Serializable(with = LocalDateNoDashesSerializer.class)
    public static /* synthetic */ void getStartDate$annotations() {
    }

    public static /* synthetic */ void getUserId$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(GetAccountBookingsRequestParameter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeBooleanElement(serialDesc, 0, self.active);
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 1, intSerializer, self.take);
        output.encodeNullableSerializableElement(serialDesc, 2, intSerializer, self.skip);
        output.encodeStringElement(serialDesc, 3, self.userId);
        LocalDateNoDashesSerializer localDateNoDashesSerializer = LocalDateNoDashesSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 4, localDateNoDashesSerializer, self.startDate);
        output.encodeNullableSerializableElement(serialDesc, 5, localDateNoDashesSerializer, self.endDate);
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.companyId);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getActive() {
        return this.active;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getTake() {
        return this.take;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getSkip() {
        return this.skip;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final LocalDate getStartDate() {
        return this.startDate;
    }

    /* renamed from: component6, reason: from getter */
    public final LocalDate getEndDate() {
        return this.endDate;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCompanyId() {
        return this.companyId;
    }

    public final GetAccountBookingsRequestParameter copy(boolean active, Integer take, Integer skip, String userId, LocalDate startDate, LocalDate endDate, String companyId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new GetAccountBookingsRequestParameter(active, take, skip, userId, startDate, endDate, companyId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetAccountBookingsRequestParameter)) {
            return false;
        }
        GetAccountBookingsRequestParameter getAccountBookingsRequestParameter = (GetAccountBookingsRequestParameter) other;
        return this.active == getAccountBookingsRequestParameter.active && Intrinsics.areEqual(this.take, getAccountBookingsRequestParameter.take) && Intrinsics.areEqual(this.skip, getAccountBookingsRequestParameter.skip) && Intrinsics.areEqual(this.userId, getAccountBookingsRequestParameter.userId) && Intrinsics.areEqual(this.startDate, getAccountBookingsRequestParameter.startDate) && Intrinsics.areEqual(this.endDate, getAccountBookingsRequestParameter.endDate) && Intrinsics.areEqual(this.companyId, getAccountBookingsRequestParameter.companyId);
    }

    public final boolean getActive() {
        return this.active;
    }

    public final String getCompanyId() {
        return this.companyId;
    }

    public final LocalDate getEndDate() {
        return this.endDate;
    }

    public final Integer getSkip() {
        return this.skip;
    }

    public final LocalDate getStartDate() {
        return this.startDate;
    }

    public final Integer getTake() {
        return this.take;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.active) * 31;
        Integer num = this.take;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.skip;
        int hashCode3 = (((hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.userId.hashCode()) * 31;
        LocalDate localDate = this.startDate;
        int hashCode4 = (hashCode3 + (localDate == null ? 0 : localDate.hashCode())) * 31;
        LocalDate localDate2 = this.endDate;
        int hashCode5 = (hashCode4 + (localDate2 == null ? 0 : localDate2.hashCode())) * 31;
        String str = this.companyId;
        return hashCode5 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "GetAccountBookingsRequestParameter(active=" + this.active + ", take=" + this.take + ", skip=" + this.skip + ", userId=" + this.userId + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", companyId=" + this.companyId + ")";
    }

    public GetAccountBookingsRequestParameter(boolean z5, Integer num, Integer num2, String userId, LocalDate localDate, LocalDate localDate2, String str) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.active = z5;
        this.take = num;
        this.skip = num2;
        this.userId = userId;
        this.startDate = localDate;
        this.endDate = localDate2;
        this.companyId = str;
    }
}
