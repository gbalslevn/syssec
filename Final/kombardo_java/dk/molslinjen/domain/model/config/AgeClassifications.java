package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.helpers.serializers.IntRangeSerializer;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/model/config/AgeClassifications;", BuildConfig.FLAVOR, "infantRange", "Lkotlin/ranges/IntRange;", "childRange", "adultRange", "<init>", "(Lkotlin/ranges/IntRange;Lkotlin/ranges/IntRange;Lkotlin/ranges/IntRange;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$AgeClassificationsDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlin/ranges/IntRange;Lkotlin/ranges/IntRange;Lkotlin/ranges/IntRange;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInfantRange$annotations", "()V", "getInfantRange", "()Lkotlin/ranges/IntRange;", "getChildRange$annotations", "getChildRange", "getAdultRange$annotations", "getAdultRange", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AgeClassifications {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AgeClassifications mock = new AgeClassifications(new IntRange(0, 2), new IntRange(3, 11), new IntRange(12, Integer.MAX_VALUE));
    private final IntRange adultRange;
    private final IntRange childRange;
    private final IntRange infantRange;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/AgeClassifications$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "getMock", "()Ldk/molslinjen/domain/model/config/AgeClassifications;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AgeClassifications getMock() {
            return AgeClassifications.mock;
        }

        public final KSerializer<AgeClassifications> serializer() {
            return AgeClassifications$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AgeClassifications(int i5, IntRange intRange, IntRange intRange2, IntRange intRange3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, AgeClassifications$$serializer.INSTANCE.getDescriptor());
        }
        this.infantRange = intRange;
        this.childRange = intRange2;
        this.adultRange = intRange3;
    }

    public static /* synthetic */ AgeClassifications copy$default(AgeClassifications ageClassifications, IntRange intRange, IntRange intRange2, IntRange intRange3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            intRange = ageClassifications.infantRange;
        }
        if ((i5 & 2) != 0) {
            intRange2 = ageClassifications.childRange;
        }
        if ((i5 & 4) != 0) {
            intRange3 = ageClassifications.adultRange;
        }
        return ageClassifications.copy(intRange, intRange2, intRange3);
    }

    @Serializable(with = IntRangeSerializer.class)
    public static /* synthetic */ void getAdultRange$annotations() {
    }

    @Serializable(with = IntRangeSerializer.class)
    public static /* synthetic */ void getChildRange$annotations() {
    }

    @Serializable(with = IntRangeSerializer.class)
    public static /* synthetic */ void getInfantRange$annotations() {
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(AgeClassifications self, CompositeEncoder output, SerialDescriptor serialDesc) {
        IntRangeSerializer intRangeSerializer = IntRangeSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 0, intRangeSerializer, self.infantRange);
        output.encodeSerializableElement(serialDesc, 1, intRangeSerializer, self.childRange);
        output.encodeSerializableElement(serialDesc, 2, intRangeSerializer, self.adultRange);
    }

    /* renamed from: component1, reason: from getter */
    public final IntRange getInfantRange() {
        return this.infantRange;
    }

    /* renamed from: component2, reason: from getter */
    public final IntRange getChildRange() {
        return this.childRange;
    }

    /* renamed from: component3, reason: from getter */
    public final IntRange getAdultRange() {
        return this.adultRange;
    }

    public final AgeClassifications copy(IntRange infantRange, IntRange childRange, IntRange adultRange) {
        Intrinsics.checkNotNullParameter(infantRange, "infantRange");
        Intrinsics.checkNotNullParameter(childRange, "childRange");
        Intrinsics.checkNotNullParameter(adultRange, "adultRange");
        return new AgeClassifications(infantRange, childRange, adultRange);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgeClassifications)) {
            return false;
        }
        AgeClassifications ageClassifications = (AgeClassifications) other;
        return Intrinsics.areEqual(this.infantRange, ageClassifications.infantRange) && Intrinsics.areEqual(this.childRange, ageClassifications.childRange) && Intrinsics.areEqual(this.adultRange, ageClassifications.adultRange);
    }

    public final IntRange getAdultRange() {
        return this.adultRange;
    }

    public final IntRange getChildRange() {
        return this.childRange;
    }

    public final IntRange getInfantRange() {
        return this.infantRange;
    }

    public int hashCode() {
        return (((this.infantRange.hashCode() * 31) + this.childRange.hashCode()) * 31) + this.adultRange.hashCode();
    }

    public String toString() {
        return "AgeClassifications(infantRange=" + this.infantRange + ", childRange=" + this.childRange + ", adultRange=" + this.adultRange + ")";
    }

    public AgeClassifications(IntRange infantRange, IntRange childRange, IntRange adultRange) {
        Intrinsics.checkNotNullParameter(infantRange, "infantRange");
        Intrinsics.checkNotNullParameter(childRange, "childRange");
        Intrinsics.checkNotNullParameter(adultRange, "adultRange");
        this.infantRange = infantRange;
        this.childRange = childRange;
        this.adultRange = adultRange;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AgeClassifications(ConfigurationResponseDTO.AgeClassificationsDTO dto) {
        this(r0, r1, new IntRange(r3, r5 != null ? r5.intValue() : Integer.MAX_VALUE));
        Intrinsics.checkNotNullParameter(dto, "dto");
        int min = dto.getInfant().getMin();
        Integer max = dto.getInfant().getMax();
        IntRange intRange = new IntRange(min, max != null ? max.intValue() : dto.getInfant().getMin());
        int min2 = dto.getChild().getMin();
        Integer max2 = dto.getChild().getMax();
        IntRange intRange2 = new IntRange(min2, max2 != null ? max2.intValue() : dto.getChild().getMin());
        int min3 = dto.getAdult().getMin();
        Integer max3 = dto.getAdult().getMax();
    }
}
