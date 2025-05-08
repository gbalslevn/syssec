package dk.molslinjen.domain.model.account;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.account.vehicle.response.VehicleDTO;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002;<BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0010Bu\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u000b\u0010\u0017J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJX\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0012HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019¨\u0006="}, d2 = {"Ldk/molslinjen/domain/model/account/UserVehicle;", "Ljava/io/Serializable;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "licensePlate", "manufacturer", "model", "heightInMeters", BuildConfig.FLAVOR, "lengthInMeters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "dto", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;", "(Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;)V", "(Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "displayName", "formattedModelName", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getLicensePlate", "getManufacturer", "getModel", "getHeightInMeters", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLengthInMeters", "getDisplayName", "getFormattedModelName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Ldk/molslinjen/domain/model/account/UserVehicle;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class UserVehicle implements java.io.Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UserVehicle loadingPlaceholder;
    private static final UserVehicle mock;
    private final String displayName;
    private final String formattedModelName;
    private final Double heightInMeters;
    private final String id;
    private final Double lengthInMeters;
    private final String licensePlate;
    private final String manufacturer;
    private final String model;
    private final String name;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/account/UserVehicle$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/account/UserVehicle;", "getMock", "()Ldk/molslinjen/domain/model/account/UserVehicle;", "loadingPlaceholder", "getLoadingPlaceholder", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserVehicle getLoadingPlaceholder() {
            return UserVehicle.loadingPlaceholder;
        }

        public final UserVehicle getMock() {
            return UserVehicle.mock;
        }

        public final KSerializer<UserVehicle> serializer() {
            return UserVehicle$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        Double valueOf = Double.valueOf(1.8d);
        Double valueOf2 = Double.valueOf(3.5d);
        mock = new UserVehicle("1423", "Vores bil", "AB23123", "Volvo", "V70", valueOf, valueOf2);
        loadingPlaceholder = new UserVehicle("loading", "Loading", "Loading", "Loading", "Loading", valueOf, valueOf2);
    }

    public /* synthetic */ UserVehicle(int i5, String str, String str2, String str3, String str4, String str5, Double d5, Double d6, String str6, String str7, SerializationConstructorMarker serializationConstructorMarker) {
        String str8;
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, UserVehicle$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.licensePlate = str3;
        this.manufacturer = str4;
        this.model = str5;
        this.heightInMeters = d5;
        this.lengthInMeters = d6;
        if ((i5 & 128) == 0) {
            this.displayName = StringsKt.isBlank(str2) ? str3 : str2;
        } else {
            this.displayName = str6;
        }
        if ((i5 & 256) != 0) {
            this.formattedModelName = str7;
            return;
        }
        if (StringsKt.isBlank(str4) && StringsKt.isBlank(str5)) {
            str8 = null;
        } else {
            str8 = str4 + " " + str5;
        }
        this.formattedModelName = str8;
    }

    public static /* synthetic */ UserVehicle copy$default(UserVehicle userVehicle, String str, String str2, String str3, String str4, String str5, Double d5, Double d6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = userVehicle.id;
        }
        if ((i5 & 2) != 0) {
            str2 = userVehicle.name;
        }
        String str6 = str2;
        if ((i5 & 4) != 0) {
            str3 = userVehicle.licensePlate;
        }
        String str7 = str3;
        if ((i5 & 8) != 0) {
            str4 = userVehicle.manufacturer;
        }
        String str8 = str4;
        if ((i5 & 16) != 0) {
            str5 = userVehicle.model;
        }
        String str9 = str5;
        if ((i5 & 32) != 0) {
            d5 = userVehicle.heightInMeters;
        }
        Double d7 = d5;
        if ((i5 & 64) != 0) {
            d6 = userVehicle.lengthInMeters;
        }
        return userVehicle.copy(str, str6, str7, str8, str9, d7, d6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0047, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.displayName, !kotlin.text.StringsKt.isBlank(r5.name) ? r5.name : r5.licensePlate) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void write$Self$domain_kombardoProd(UserVehicle self, CompositeEncoder output, SerialDescriptor serialDesc) {
        String str;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeStringElement(serialDesc, 2, self.licensePlate);
        output.encodeStringElement(serialDesc, 3, self.manufacturer);
        output.encodeStringElement(serialDesc, 4, self.model);
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 5, doubleSerializer, self.heightInMeters);
        output.encodeNullableSerializableElement(serialDesc, 6, doubleSerializer, self.lengthInMeters);
        if (!output.shouldEncodeElementDefault(serialDesc, 7)) {
        }
        output.encodeStringElement(serialDesc, 7, self.displayName);
        if (!output.shouldEncodeElementDefault(serialDesc, 8)) {
            String str2 = self.formattedModelName;
            if (StringsKt.isBlank(self.manufacturer) && StringsKt.isBlank(self.model)) {
                str = null;
            } else {
                str = self.manufacturer + " " + self.model;
            }
            if (Intrinsics.areEqual(str2, str)) {
                return;
            }
        }
        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.formattedModelName);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLicensePlate() {
        return this.licensePlate;
    }

    /* renamed from: component4, reason: from getter */
    public final String getManufacturer() {
        return this.manufacturer;
    }

    /* renamed from: component5, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component6, reason: from getter */
    public final Double getHeightInMeters() {
        return this.heightInMeters;
    }

    /* renamed from: component7, reason: from getter */
    public final Double getLengthInMeters() {
        return this.lengthInMeters;
    }

    public final UserVehicle copy(String id, String name, String licensePlate, String manufacturer, String model, Double heightInMeters, Double lengthInMeters) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        return new UserVehicle(id, name, licensePlate, manufacturer, model, heightInMeters, lengthInMeters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserVehicle)) {
            return false;
        }
        UserVehicle userVehicle = (UserVehicle) other;
        return Intrinsics.areEqual(this.id, userVehicle.id) && Intrinsics.areEqual(this.name, userVehicle.name) && Intrinsics.areEqual(this.licensePlate, userVehicle.licensePlate) && Intrinsics.areEqual(this.manufacturer, userVehicle.manufacturer) && Intrinsics.areEqual(this.model, userVehicle.model) && Intrinsics.areEqual(this.heightInMeters, userVehicle.heightInMeters) && Intrinsics.areEqual(this.lengthInMeters, userVehicle.lengthInMeters);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getFormattedModelName() {
        return this.formattedModelName;
    }

    public final Double getHeightInMeters() {
        return this.heightInMeters;
    }

    public final String getId() {
        return this.id;
    }

    public final Double getLengthInMeters() {
        return this.lengthInMeters;
    }

    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = ((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.licensePlate.hashCode()) * 31) + this.manufacturer.hashCode()) * 31) + this.model.hashCode()) * 31;
        Double d5 = this.heightInMeters;
        int hashCode2 = (hashCode + (d5 == null ? 0 : d5.hashCode())) * 31;
        Double d6 = this.lengthInMeters;
        return hashCode2 + (d6 != null ? d6.hashCode() : 0);
    }

    public String toString() {
        return "UserVehicle(id=" + this.id + ", name=" + this.name + ", licensePlate=" + this.licensePlate + ", manufacturer=" + this.manufacturer + ", model=" + this.model + ", heightInMeters=" + this.heightInMeters + ", lengthInMeters=" + this.lengthInMeters + ")";
    }

    public UserVehicle(String id, String name, String licensePlate, String manufacturer, String model, Double d5, Double d6) {
        String str;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        this.id = id;
        this.name = name;
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
        this.model = model;
        this.heightInMeters = d5;
        this.lengthInMeters = d6;
        this.displayName = StringsKt.isBlank(name) ? licensePlate : name;
        if (StringsKt.isBlank(manufacturer) && StringsKt.isBlank(model)) {
            str = null;
        } else {
            str = manufacturer + " " + model;
        }
        this.formattedModelName = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserVehicle(VehicleDTO dto) {
        this(dto.getVehicleId(), dto.getName(), dto.getLicensePlate(), dto.getManufacturer(), dto.getModel(), dto.getHeightInMeters() > 0.0d ? Double.valueOf(dto.getHeightInMeters()) : null, dto.getLengthInMeters() > 0.0d ? Double.valueOf(dto.getLengthInMeters()) : null);
        Intrinsics.checkNotNullParameter(dto, "dto");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public UserVehicle(String licensePlate) {
        this(r2, licensePlate, licensePlate, BuildConfig.FLAVOR, BuildConfig.FLAVOR, null, null);
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
    }
}
