package dk.molslinjen.api.services.account.passenger.request;

import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 #2\u00020\u0001:\u0002\"#B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bBM\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006$\u0080å\b\u0002\u0080å\b\u0004\u0080å\b\u0005\u0080å\b\u0007\u0080å\b\t"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;", BuildConfig.FLAVOR, "firstName", BuildConfig.FLAVOR, "lastName", "gender", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "birthdate", "Lorg/threeten/bp/LocalDate;", "nationality", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Lorg/threeten/bp/LocalDate;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFirstName", "()Ljava/lang/String;", "getLastName", "getGender", "()Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "getBirthdate$annotations", "()V", "getBirthdate", "()Lorg/threeten/bp/LocalDate;", "getNationality", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public class RegisterPassengerRequestParameter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LocalDate birthdate;
    private final String firstName;
    private final GenderDTO gender;
    private final String lastName;
    private final String nationality;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<RegisterPassengerRequestParameter> serializer() {
            return RegisterPassengerRequestParameter$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ RegisterPassengerRequestParameter(int i5, String str, String str2, GenderDTO genderDTO, LocalDate localDate, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, RegisterPassengerRequestParameter$$serializer.INSTANCE.getDescriptor());
        }
        this.firstName = str;
        this.lastName = str2;
        this.gender = genderDTO;
        this.birthdate = localDate;
        this.nationality = str3;
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getBirthdate$annotations() {
    }

    public static final /* synthetic */ void write$Self(RegisterPassengerRequestParameter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.firstName);
        output.encodeStringElement(serialDesc, 1, self.lastName);
        output.encodeSerializableElement(serialDesc, 2, GenderDTO.Serializer.INSTANCE, self.gender);
        output.encodeSerializableElement(serialDesc, 3, LocalDateWithTimeSerializer.INSTANCE, self.birthdate);
        output.encodeStringElement(serialDesc, 4, self.nationality);
    }

    public final LocalDate getBirthdate() {
        return this.birthdate;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final GenderDTO getGender() {
        return this.gender;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getNationality() {
        return this.nationality;
    }

    public RegisterPassengerRequestParameter(String firstName, String lastName, GenderDTO gender, LocalDate birthdate, String nationality) {
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(birthdate, "birthdate");
        Intrinsics.checkNotNullParameter(nationality, "nationality");
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }
}
