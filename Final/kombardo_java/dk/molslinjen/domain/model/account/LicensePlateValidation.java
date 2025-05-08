package dk.molslinjen.domain.model.account;

import dk.molslinjen.api.services.account.vehicle.response.VehicleLicensePlateValidationDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/account/LicensePlateValidation;", BuildConfig.FLAVOR, "<init>", "()V", "Valid", "NotFound", "Companion", "Ldk/molslinjen/domain/model/account/LicensePlateValidation$NotFound;", "Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LicensePlateValidation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Valid mockValid = new Valid("ABC12323", "Ford", "Fiesta", Double.valueOf(1.8d), Double.valueOf(13.901d));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/account/LicensePlateValidation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockValid", "Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "getMockValid", "()Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Valid getMockValid() {
            return LicensePlateValidation.mockValid;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/domain/model/account/LicensePlateValidation$NotFound;", "Ldk/molslinjen/domain/model/account/LicensePlateValidation;", "<init>", "()V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class NotFound extends LicensePlateValidation {
        public static final NotFound INSTANCE = new NotFound();

        private NotFound() {
            super(null);
        }
    }

    public /* synthetic */ LicensePlateValidation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LicensePlateValidation() {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006%"}, d2 = {"Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "Ldk/molslinjen/domain/model/account/LicensePlateValidation;", "licensePlate", BuildConfig.FLAVOR, "manufacturer", "model", "heightInMeters", BuildConfig.FLAVOR, "lengthInMeters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "dto", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleLicensePlateValidationDTO;", "(Ldk/molslinjen/api/services/account/vehicle/response/VehicleLicensePlateValidationDTO;)V", "getLicensePlate", "()Ljava/lang/String;", "getManufacturer", "getModel", "getHeightInMeters", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLengthInMeters", "displayName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Valid extends LicensePlateValidation {
        private final Double heightInMeters;
        private final Double lengthInMeters;
        private final String licensePlate;
        private final String manufacturer;
        private final String model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Valid(String licensePlate, String manufacturer, String model, Double d5, Double d6) {
            super(null);
            Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
            Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
            Intrinsics.checkNotNullParameter(model, "model");
            this.licensePlate = licensePlate;
            this.manufacturer = manufacturer;
            this.model = model;
            this.heightInMeters = d5;
            this.lengthInMeters = d6;
        }

        public static /* synthetic */ Valid copy$default(Valid valid, String str, String str2, String str3, Double d5, Double d6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = valid.licensePlate;
            }
            if ((i5 & 2) != 0) {
                str2 = valid.manufacturer;
            }
            String str4 = str2;
            if ((i5 & 4) != 0) {
                str3 = valid.model;
            }
            String str5 = str3;
            if ((i5 & 8) != 0) {
                d5 = valid.heightInMeters;
            }
            Double d7 = d5;
            if ((i5 & 16) != 0) {
                d6 = valid.lengthInMeters;
            }
            return valid.copy(str, str4, str5, d7, d6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLicensePlate() {
            return this.licensePlate;
        }

        /* renamed from: component2, reason: from getter */
        public final String getManufacturer() {
            return this.manufacturer;
        }

        /* renamed from: component3, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        /* renamed from: component4, reason: from getter */
        public final Double getHeightInMeters() {
            return this.heightInMeters;
        }

        /* renamed from: component5, reason: from getter */
        public final Double getLengthInMeters() {
            return this.lengthInMeters;
        }

        public final Valid copy(String licensePlate, String manufacturer, String model, Double heightInMeters, Double lengthInMeters) {
            Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
            Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
            Intrinsics.checkNotNullParameter(model, "model");
            return new Valid(licensePlate, manufacturer, model, heightInMeters, lengthInMeters);
        }

        public final String displayName() {
            if (StringsKt.isBlank(this.manufacturer) && StringsKt.isBlank(this.model)) {
                return this.licensePlate;
            }
            return this.manufacturer + " " + this.model;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Valid)) {
                return false;
            }
            Valid valid = (Valid) other;
            return Intrinsics.areEqual(this.licensePlate, valid.licensePlate) && Intrinsics.areEqual(this.manufacturer, valid.manufacturer) && Intrinsics.areEqual(this.model, valid.model) && Intrinsics.areEqual(this.heightInMeters, valid.heightInMeters) && Intrinsics.areEqual(this.lengthInMeters, valid.lengthInMeters);
        }

        public final Double getHeightInMeters() {
            return this.heightInMeters;
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

        public int hashCode() {
            int hashCode = ((((this.licensePlate.hashCode() * 31) + this.manufacturer.hashCode()) * 31) + this.model.hashCode()) * 31;
            Double d5 = this.heightInMeters;
            int hashCode2 = (hashCode + (d5 == null ? 0 : d5.hashCode())) * 31;
            Double d6 = this.lengthInMeters;
            return hashCode2 + (d6 != null ? d6.hashCode() : 0);
        }

        public String toString() {
            return "Valid(licensePlate=" + this.licensePlate + ", manufacturer=" + this.manufacturer + ", model=" + this.model + ", heightInMeters=" + this.heightInMeters + ", lengthInMeters=" + this.lengthInMeters + ")";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Valid(VehicleLicensePlateValidationDTO dto) {
            this(dto.getLicensePlate(), dto.getManufacturer(), dto.getModel(), dto.getHeightInMeters() == 0.0d ? null : Double.valueOf(dto.getHeightInMeters()), dto.getLengthInMeters() == 0.0d ? null : Double.valueOf(dto.getLengthInMeters()));
            Intrinsics.checkNotNullParameter(dto, "dto");
        }
    }
}
