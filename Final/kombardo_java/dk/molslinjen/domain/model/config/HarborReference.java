package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.api.shared.response.AreaDTO;
import dk.molslinjen.domain.model.config.Region;
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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002/0B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fBK\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000b\u0010\u0014J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0011HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Ldk/molslinjen/domain/model/config/HarborReference;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "region", "Ldk/molslinjen/domain/model/config/Region;", "isFrequentlyUsed", BuildConfig.FLAVOR, "area", "Ldk/molslinjen/domain/model/config/Area;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Region;ZLdk/molslinjen/domain/model/config/Area;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$HarborReferenceDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Region;ZLdk/molslinjen/domain/model/config/Area;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getRegion", "()Ldk/molslinjen/domain/model/config/Region;", "()Z", "getArea", "()Ldk/molslinjen/domain/model/config/Area;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class HarborReference {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HarborReference mockAarhus;
    private static final HarborReference mockZealand;
    private final Area area;
    private final String id;
    private final boolean isFrequentlyUsed;
    private final String name;
    private final Region region;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/config/HarborReference$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockAarhus", "Ldk/molslinjen/domain/model/config/HarborReference;", "getMockAarhus", "()Ldk/molslinjen/domain/model/config/HarborReference;", "mockZealand", "getMockZealand", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HarborReference getMockAarhus() {
            return HarborReference.mockAarhus;
        }

        public final HarborReference getMockZealand() {
            return HarborReference.mockZealand;
        }

        public final KSerializer<HarborReference> serializer() {
            return HarborReference$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        Region.Companion companion = Region.INSTANCE;
        mockAarhus = new HarborReference("ÅRH3", "Aarhus", companion.getMockJutland(), true, (Area) null, 16, (DefaultConstructorMarker) null);
        mockZealand = new HarborReference("ODD", "Odden", companion.getMockZealand(), false, (Area) null, 16, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ HarborReference(int i5, String str, String str2, Region region, boolean z5, Area area, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, HarborReference$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.region = region;
        this.isFrequentlyUsed = z5;
        if ((i5 & 16) == 0) {
            this.area = null;
        } else {
            this.area = area;
        }
    }

    public static /* synthetic */ HarborReference copy$default(HarborReference harborReference, String str, String str2, Region region, boolean z5, Area area, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = harborReference.id;
        }
        if ((i5 & 2) != 0) {
            str2 = harborReference.name;
        }
        String str3 = str2;
        if ((i5 & 4) != 0) {
            region = harborReference.region;
        }
        Region region2 = region;
        if ((i5 & 8) != 0) {
            z5 = harborReference.isFrequentlyUsed;
        }
        boolean z6 = z5;
        if ((i5 & 16) != 0) {
            area = harborReference.area;
        }
        return harborReference.copy(str, str3, region2, z6, area);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(HarborReference self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeSerializableElement(serialDesc, 2, Region$$serializer.INSTANCE, self.region);
        output.encodeBooleanElement(serialDesc, 3, self.isFrequentlyUsed);
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.area == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, Area$$serializer.INSTANCE, self.area);
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
    public final Region getRegion() {
        return this.region;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsFrequentlyUsed() {
        return this.isFrequentlyUsed;
    }

    /* renamed from: component5, reason: from getter */
    public final Area getArea() {
        return this.area;
    }

    public final HarborReference copy(String id, String name, Region region, boolean isFrequentlyUsed, Area area) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(region, "region");
        return new HarborReference(id, name, region, isFrequentlyUsed, area);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HarborReference)) {
            return false;
        }
        HarborReference harborReference = (HarborReference) other;
        return Intrinsics.areEqual(this.id, harborReference.id) && Intrinsics.areEqual(this.name, harborReference.name) && Intrinsics.areEqual(this.region, harborReference.region) && this.isFrequentlyUsed == harborReference.isFrequentlyUsed && Intrinsics.areEqual(this.area, harborReference.area);
    }

    public final Area getArea() {
        return this.area;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Region getRegion() {
        return this.region;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.region.hashCode()) * 31) + Boolean.hashCode(this.isFrequentlyUsed)) * 31;
        Area area = this.area;
        return hashCode + (area == null ? 0 : area.hashCode());
    }

    public final boolean isFrequentlyUsed() {
        return this.isFrequentlyUsed;
    }

    public String toString() {
        return "HarborReference(id=" + this.id + ", name=" + this.name + ", region=" + this.region + ", isFrequentlyUsed=" + this.isFrequentlyUsed + ", area=" + this.area + ")";
    }

    public HarborReference(String id, String name, Region region, boolean z5, Area area) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(region, "region");
        this.id = id;
        this.name = name;
        this.region = region;
        this.isFrequentlyUsed = z5;
        this.area = area;
    }

    public /* synthetic */ HarborReference(String str, String str2, Region region, boolean z5, Area area, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, region, z5, (i5 & 16) != 0 ? null : area);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HarborReference(ConfigurationResponseDTO.HarborReferenceDTO dto) {
        this(r2, r3, r4, r5, r8 != null ? new Area(r8) : null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        String name = dto.getName();
        Region region = new Region(dto.getRegion());
        boolean isFrequentlyUsed = dto.isFrequentlyUsed();
        AreaDTO area = dto.getArea();
    }
}
