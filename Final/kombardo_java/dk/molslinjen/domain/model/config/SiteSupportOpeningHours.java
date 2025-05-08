package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB/\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0005\u0010\u000eJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/model/config/SiteSupportOpeningHours;", BuildConfig.FLAVOR, "days", BuildConfig.FLAVOR, "hours", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportOpeningHourDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$SiteSupportOpeningHourDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDays", "()Ljava/lang/String;", "getHours", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SiteSupportOpeningHours {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SiteSupportOpeningHours mock = new SiteSupportOpeningHours("Monday - Friday", "8:00 - 16:00");
    private final String days;
    private final String hours;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/SiteSupportOpeningHours$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/SiteSupportOpeningHours;", "getMock", "()Ldk/molslinjen/domain/model/config/SiteSupportOpeningHours;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SiteSupportOpeningHours getMock() {
            return SiteSupportOpeningHours.mock;
        }

        public final KSerializer<SiteSupportOpeningHours> serializer() {
            return SiteSupportOpeningHours$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SiteSupportOpeningHours(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, SiteSupportOpeningHours$$serializer.INSTANCE.getDescriptor());
        }
        this.days = str;
        this.hours = str2;
    }

    public static /* synthetic */ SiteSupportOpeningHours copy$default(SiteSupportOpeningHours siteSupportOpeningHours, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = siteSupportOpeningHours.days;
        }
        if ((i5 & 2) != 0) {
            str2 = siteSupportOpeningHours.hours;
        }
        return siteSupportOpeningHours.copy(str, str2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SiteSupportOpeningHours self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.days);
        output.encodeStringElement(serialDesc, 1, self.hours);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDays() {
        return this.days;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHours() {
        return this.hours;
    }

    public final SiteSupportOpeningHours copy(String days, String hours) {
        Intrinsics.checkNotNullParameter(days, "days");
        Intrinsics.checkNotNullParameter(hours, "hours");
        return new SiteSupportOpeningHours(days, hours);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteSupportOpeningHours)) {
            return false;
        }
        SiteSupportOpeningHours siteSupportOpeningHours = (SiteSupportOpeningHours) other;
        return Intrinsics.areEqual(this.days, siteSupportOpeningHours.days) && Intrinsics.areEqual(this.hours, siteSupportOpeningHours.hours);
    }

    public final String getDays() {
        return this.days;
    }

    public final String getHours() {
        return this.hours;
    }

    public int hashCode() {
        return (this.days.hashCode() * 31) + this.hours.hashCode();
    }

    public String toString() {
        return "SiteSupportOpeningHours(days=" + this.days + ", hours=" + this.hours + ")";
    }

    public SiteSupportOpeningHours(String days, String hours) {
        Intrinsics.checkNotNullParameter(days, "days");
        Intrinsics.checkNotNullParameter(hours, "hours");
        this.days = days;
        this.hours = hours;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SiteSupportOpeningHours(ConfigurationResponseDTO.SiteSupportOpeningHourDTO dto) {
        this(dto.getDays(), dto.getHours());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
