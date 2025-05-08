package dk.molslinjen.core.migration.oldApp;

import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.UserPassenger;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.BM\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b&\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b-\u0010\u001d¨\u00060"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppPassenger;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, "firstName", "lastName", "Ldk/molslinjen/core/migration/oldApp/OldAppGender;", "gender", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "birthDate", "nationality", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/core/migration/oldApp/OldAppGender;Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppPassenger;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/model/account/UserPassenger;", "toPassenger", "()Ldk/molslinjen/domain/model/account/UserPassenger;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFirstName", "getLastName", "Ldk/molslinjen/core/migration/oldApp/OldAppGender;", "getGender", "()Ldk/molslinjen/core/migration/oldApp/OldAppGender;", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "getBirthDate", "()Ldk/molslinjen/core/migration/oldApp/OldAppLocalDate;", "getNationality", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OldAppPassenger {
    private final OldAppLocalDate birthDate;
    private final String firstName;
    private final OldAppGender gender;
    private final String lastName;
    private final String nationality;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.core.migration.oldApp.OldAppGender", OldAppGender.values()), null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppPassenger$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppPassenger;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OldAppPassenger> serializer() {
            return OldAppPassenger$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ OldAppPassenger(int i5, String str, String str2, OldAppGender oldAppGender, OldAppLocalDate oldAppLocalDate, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, OldAppPassenger$$serializer.INSTANCE.getDescriptor());
        }
        this.firstName = str;
        this.lastName = str2;
        this.gender = oldAppGender;
        this.birthDate = oldAppLocalDate;
        this.nationality = str3;
    }

    public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppPassenger self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.firstName);
        output.encodeStringElement(serialDesc, 1, self.lastName);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.gender);
        output.encodeNullableSerializableElement(serialDesc, 3, OldAppLocalDate$$serializer.INSTANCE, self.birthDate);
        output.encodeStringElement(serialDesc, 4, self.nationality);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OldAppPassenger)) {
            return false;
        }
        OldAppPassenger oldAppPassenger = (OldAppPassenger) other;
        return Intrinsics.areEqual(this.firstName, oldAppPassenger.firstName) && Intrinsics.areEqual(this.lastName, oldAppPassenger.lastName) && this.gender == oldAppPassenger.gender && Intrinsics.areEqual(this.birthDate, oldAppPassenger.birthDate) && Intrinsics.areEqual(this.nationality, oldAppPassenger.nationality);
    }

    public int hashCode() {
        int hashCode = ((((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.gender.hashCode()) * 31;
        OldAppLocalDate oldAppLocalDate = this.birthDate;
        return ((hashCode + (oldAppLocalDate == null ? 0 : oldAppLocalDate.hashCode())) * 31) + this.nationality.hashCode();
    }

    public final UserPassenger toPassenger() {
        LocalDate minusYears;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String str = this.firstName;
        String str2 = this.lastName;
        Gender gender = this.gender.toGender();
        OldAppLocalDate oldAppLocalDate = this.birthDate;
        if (oldAppLocalDate == null || (minusYears = oldAppLocalDate.toLocalDate()) == null) {
            minusYears = LocalDate.now().minusYears(30L);
        }
        LocalDate localDate = minusYears;
        Intrinsics.checkNotNull(localDate);
        return new UserPassenger(uuid, null, str, str2, gender, localDate, this.nationality, false);
    }

    public String toString() {
        return "OldAppPassenger(firstName=" + this.firstName + ", lastName=" + this.lastName + ", gender=" + this.gender + ", birthDate=" + this.birthDate + ", nationality=" + this.nationality + ")";
    }
}
