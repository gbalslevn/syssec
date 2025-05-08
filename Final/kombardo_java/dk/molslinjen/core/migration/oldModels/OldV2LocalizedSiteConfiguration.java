package dk.molslinjen.core.migration.oldModels;

import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.AgeClassifications$$serializer;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.Harbor$$serializer;
import dk.molslinjen.domain.model.config.MultiRideType;
import dk.molslinjen.domain.model.config.MultiRideType$$serializer;
import dk.molslinjen.domain.model.config.Region;
import dk.molslinjen.domain.model.config.Region$$serializer;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Route$$serializer;
import dk.molslinjen.domain.model.config.SimpleFerry;
import dk.molslinjen.domain.model.config.SimpleFerry$$serializer;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import dk.molslinjen.domain.model.config.SiteSupportInfo$$serializer;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
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

@Deprecated
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087\b\u0018\u0000 F2\u00020\u0001:\u0002GFB½\u0001\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0004\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0004\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010(\u001a\u00020%2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b2\u00103R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b4\u00103R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006¢\u0006\f\n\u0004\b\n\u00101\u001a\u0004\b5\u00103R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b6\u00103R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b7\u00103R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u00101\u001a\u0004\b8\u00103R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010<\u001a\u0004\b=\u0010*R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010<\u001a\u0004\b>\u0010*R\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010B\u001a\u0004\bC\u0010DR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\bE\u00103¨\u0006H"}, d2 = {"Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Route;", "routes", "Ldk/molslinjen/core/migration/oldModels/OldV2Transportation;", "transportations", "Ldk/molslinjen/domain/model/config/Harbor;", "harbors", "Ldk/molslinjen/domain/model/config/Region;", "regions", "Ldk/molslinjen/domain/model/config/MultiRideType;", "multiRideTypes", "Ldk/molslinjen/domain/model/config/SimpleFerry;", "ferries", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "ageClassifications", BuildConfig.FLAVOR, "siteName", "lineLogoUrl", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "supportInfo", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "enabledCurrencies", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/config/AgeClassifications;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/SiteSupportInfo;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getRoutes", "()Ljava/util/List;", "getTransportations", "getHarbors", "getRegions", "getMultiRideTypes", "getFerries", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "getAgeClassifications", "()Ldk/molslinjen/domain/model/config/AgeClassifications;", "Ljava/lang/String;", "getSiteName", "getLineLogoUrl", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "getSupportInfo", "()Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "getEnabledCurrencies", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OldV2LocalizedSiteConfiguration {
    private final AgeClassifications ageClassifications;
    private final List<CurrencyType> enabledCurrencies;
    private final List<SimpleFerry> ferries;
    private final List<Harbor> harbors;
    private final String lineLogoUrl;
    private final List<MultiRideType> multiRideTypes;
    private final List<Region> regions;
    private final List<Route> routes;
    private final Site site;
    private final String siteName;
    private final SiteSupportInfo supportInfo;
    private final List<OldV2Transportation> transportations;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Route$$serializer.INSTANCE), new ArrayListSerializer(OldV2Transportation$$serializer.INSTANCE), new ArrayListSerializer(Harbor$$serializer.INSTANCE), new ArrayListSerializer(Region$$serializer.INSTANCE), new ArrayListSerializer(MultiRideType$$serializer.INSTANCE), new ArrayListSerializer(SimpleFerry$$serializer.INSTANCE), null, null, null, Site.INSTANCE.serializer(), null, new ArrayListSerializer(CurrencyType.INSTANCE.serializer())};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OldV2LocalizedSiteConfiguration> serializer() {
            return OldV2LocalizedSiteConfiguration$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ OldV2LocalizedSiteConfiguration(int i5, List list, List list2, List list3, List list4, List list5, List list6, AgeClassifications ageClassifications, String str, String str2, Site site, SiteSupportInfo siteSupportInfo, List list7, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i5 & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 4095, OldV2LocalizedSiteConfiguration$$serializer.INSTANCE.getDescriptor());
        }
        this.routes = list;
        this.transportations = list2;
        this.harbors = list3;
        this.regions = list4;
        this.multiRideTypes = list5;
        this.ferries = list6;
        this.ageClassifications = ageClassifications;
        this.siteName = str;
        this.lineLogoUrl = str2;
        this.site = site;
        this.supportInfo = siteSupportInfo;
        this.enabledCurrencies = list7;
    }

    public static final /* synthetic */ void write$Self$app_kombardoProd(OldV2LocalizedSiteConfiguration self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.routes);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.transportations);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.harbors);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.regions);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.multiRideTypes);
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.ferries);
        output.encodeSerializableElement(serialDesc, 6, AgeClassifications$$serializer.INSTANCE, self.ageClassifications);
        output.encodeStringElement(serialDesc, 7, self.siteName);
        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.lineLogoUrl);
        output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.site);
        output.encodeSerializableElement(serialDesc, 10, SiteSupportInfo$$serializer.INSTANCE, self.supportInfo);
        output.encodeSerializableElement(serialDesc, 11, kSerializerArr[11], self.enabledCurrencies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OldV2LocalizedSiteConfiguration)) {
            return false;
        }
        OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration = (OldV2LocalizedSiteConfiguration) other;
        return Intrinsics.areEqual(this.routes, oldV2LocalizedSiteConfiguration.routes) && Intrinsics.areEqual(this.transportations, oldV2LocalizedSiteConfiguration.transportations) && Intrinsics.areEqual(this.harbors, oldV2LocalizedSiteConfiguration.harbors) && Intrinsics.areEqual(this.regions, oldV2LocalizedSiteConfiguration.regions) && Intrinsics.areEqual(this.multiRideTypes, oldV2LocalizedSiteConfiguration.multiRideTypes) && Intrinsics.areEqual(this.ferries, oldV2LocalizedSiteConfiguration.ferries) && Intrinsics.areEqual(this.ageClassifications, oldV2LocalizedSiteConfiguration.ageClassifications) && Intrinsics.areEqual(this.siteName, oldV2LocalizedSiteConfiguration.siteName) && Intrinsics.areEqual(this.lineLogoUrl, oldV2LocalizedSiteConfiguration.lineLogoUrl) && this.site == oldV2LocalizedSiteConfiguration.site && Intrinsics.areEqual(this.supportInfo, oldV2LocalizedSiteConfiguration.supportInfo) && Intrinsics.areEqual(this.enabledCurrencies, oldV2LocalizedSiteConfiguration.enabledCurrencies);
    }

    public final AgeClassifications getAgeClassifications() {
        return this.ageClassifications;
    }

    public final List<CurrencyType> getEnabledCurrencies() {
        return this.enabledCurrencies;
    }

    public final List<SimpleFerry> getFerries() {
        return this.ferries;
    }

    public final List<Harbor> getHarbors() {
        return this.harbors;
    }

    public final String getLineLogoUrl() {
        return this.lineLogoUrl;
    }

    public final List<MultiRideType> getMultiRideTypes() {
        return this.multiRideTypes;
    }

    public final List<Region> getRegions() {
        return this.regions;
    }

    public final List<Route> getRoutes() {
        return this.routes;
    }

    public final Site getSite() {
        return this.site;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final SiteSupportInfo getSupportInfo() {
        return this.supportInfo;
    }

    public final List<OldV2Transportation> getTransportations() {
        return this.transportations;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.routes.hashCode() * 31) + this.transportations.hashCode()) * 31) + this.harbors.hashCode()) * 31) + this.regions.hashCode()) * 31) + this.multiRideTypes.hashCode()) * 31) + this.ferries.hashCode()) * 31) + this.ageClassifications.hashCode()) * 31) + this.siteName.hashCode()) * 31;
        String str = this.lineLogoUrl;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.site.hashCode()) * 31) + this.supportInfo.hashCode()) * 31) + this.enabledCurrencies.hashCode();
    }

    public String toString() {
        return "OldV2LocalizedSiteConfiguration(routes=" + this.routes + ", transportations=" + this.transportations + ", harbors=" + this.harbors + ", regions=" + this.regions + ", multiRideTypes=" + this.multiRideTypes + ", ferries=" + this.ferries + ", ageClassifications=" + this.ageClassifications + ", siteName=" + this.siteName + ", lineLogoUrl=" + this.lineLogoUrl + ", site=" + this.site + ", supportInfo=" + this.supportInfo + ", enabledCurrencies=" + this.enabledCurrencies + ")";
    }
}
