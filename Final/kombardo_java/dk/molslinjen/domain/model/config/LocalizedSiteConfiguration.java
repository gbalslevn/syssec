package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.api.shared.response.HarborDTO;
import dk.molslinjen.api.shared.response.TransportResponseDTO;
import dk.molslinjen.core.Environment;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.MultiRideType;
import dk.molslinjen.domain.model.config.Region;
import dk.molslinjen.domain.model.config.TransportationCategory;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 V2\u00020\u0001:\u0002VWB¡\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003¢\u0006\u0004\b\u001c\u0010\u001dB\u0019\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010 BÍ\u0001\b\u0010\u0012\u0006\u0010!\u001a\u00020\"\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\u001c\u0010%J\u0012\u00109\u001a\u0004\u0018\u00010\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0014J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÂ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003HÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0012HÆ\u0003J\t\u0010C\u001a\u00020\u0014HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010E\u001a\u00020\u0017HÆ\u0003J\t\u0010F\u001a\u00020\u0019HÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003HÆ\u0003J½\u0001\u0010H\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003HÆ\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010L\u001a\u00020\"HÖ\u0001J\t\u0010M\u001a\u00020\u0014HÖ\u0001J%\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0001¢\u0006\u0002\bUR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\b0\u00038F¢\u0006\u0006\u001a\u0004\b8\u0010'¨\u0006X"}, d2 = {"Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", BuildConfig.FLAVOR, "routes", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Route;", "transportationCategories", "Ldk/molslinjen/domain/model/config/TransportationCategory;", "extraTransportations", "Ldk/molslinjen/domain/model/config/Transportation;", "harbors", "Ldk/molslinjen/domain/model/config/Harbor;", "regions", "Ldk/molslinjen/domain/model/config/Region;", "multiRideTypes", "Ldk/molslinjen/domain/model/config/MultiRideType;", "ferries", "Ldk/molslinjen/domain/model/config/SimpleFerry;", "ageClassifications", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "siteName", BuildConfig.FLAVOR, "lineLogoUrl", "site", "Ldk/molslinjen/domain/model/config/Site;", "supportInfo", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "enabledCurrencies", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/config/AgeClassifications;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/SiteSupportInfo;Ljava/util/List;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$LanguageSpecificConfigurationDTO;Ldk/molslinjen/domain/model/config/Site;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/config/AgeClassifications;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/SiteSupportInfo;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRoutes", "()Ljava/util/List;", "getTransportationCategories", "getHarbors", "getRegions", "getMultiRideTypes", "getFerries", "getAgeClassifications", "()Ldk/molslinjen/domain/model/config/AgeClassifications;", "getSiteName", "()Ljava/lang/String;", "getLineLogoUrl", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "getSupportInfo", "()Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "getEnabledCurrencies", "transportations", "getTransportations", "getFerry", Constants.ID_ATTRIBUTE_KEY, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class LocalizedSiteConfiguration {
    private static final LocalizedSiteConfiguration mock;
    private final AgeClassifications ageClassifications;
    private final List<CurrencyType> enabledCurrencies;
    private final List<Transportation> extraTransportations;
    private final List<SimpleFerry> ferries;
    private final List<Harbor> harbors;
    private final String lineLogoUrl;
    private final List<MultiRideType> multiRideTypes;
    private final List<Region> regions;
    private final List<Route> routes;
    private final Site site;
    private final String siteName;
    private final SiteSupportInfo supportInfo;
    private final List<TransportationCategory> transportationCategories;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Route$$serializer.INSTANCE), new ArrayListSerializer(TransportationCategory$$serializer.INSTANCE), new ArrayListSerializer(Transportation$$serializer.INSTANCE), new ArrayListSerializer(Harbor$$serializer.INSTANCE), new ArrayListSerializer(Region$$serializer.INSTANCE), new ArrayListSerializer(MultiRideType$$serializer.INSTANCE), new ArrayListSerializer(SimpleFerry$$serializer.INSTANCE), null, null, null, Site.INSTANCE.serializer(), null, new ArrayListSerializer(CurrencyType.INSTANCE.serializer())};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "getMock", "()Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalizedSiteConfiguration getMock() {
            return LocalizedSiteConfiguration.mock;
        }

        public final KSerializer<LocalizedSiteConfiguration> serializer() {
            return LocalizedSiteConfiguration$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        Site site = Site.Mols;
        List listOf = CollectionsKt.listOf(Route.INSTANCE.getMock());
        TransportationCategory.Companion companion = TransportationCategory.INSTANCE;
        List listOf2 = CollectionsKt.listOf((Object[]) new TransportationCategory[]{companion.getMock(), companion.getMock()});
        List emptyList = CollectionsKt.emptyList();
        Harbor.Companion companion2 = Harbor.INSTANCE;
        List listOf3 = CollectionsKt.listOf((Object[]) new Harbor[]{companion2.getMockAarhus(), companion2.getMockOdden()});
        Region.Companion companion3 = Region.INSTANCE;
        List listOf4 = CollectionsKt.listOf((Object[]) new Region[]{companion3.getMockJutland(), companion3.getMockZealand()});
        List listOf5 = CollectionsKt.listOf(SimpleFerry.INSTANCE.getMock());
        MultiRideType.Companion companion4 = MultiRideType.INSTANCE;
        mock = new LocalizedSiteConfiguration(listOf, listOf2, emptyList, listOf3, listOf4, CollectionsKt.listOf((Object[]) new MultiRideType[]{companion4.getMockStandard(), companion4.getMockBlueClass()}), listOf5, new AgeClassifications(new IntRange(0, 2), new IntRange(3, 11), new IntRange(12, Integer.MAX_VALUE)), "Molslinjen", null, site, SiteSupportInfo.INSTANCE.getMock(), CollectionsKt.listOf((Object[]) new CurrencyType[]{CurrencyType.DKK, CurrencyType.SEK, CurrencyType.EUR}));
    }

    public /* synthetic */ LocalizedSiteConfiguration(int i5, List list, List list2, List list3, List list4, List list5, List list6, List list7, AgeClassifications ageClassifications, String str, String str2, Site site, SiteSupportInfo siteSupportInfo, List list8, SerializationConstructorMarker serializationConstructorMarker) {
        if (8191 != (i5 & 8191)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 8191, LocalizedSiteConfiguration$$serializer.INSTANCE.getDescriptor());
        }
        this.routes = list;
        this.transportationCategories = list2;
        this.extraTransportations = list3;
        this.harbors = list4;
        this.regions = list5;
        this.multiRideTypes = list6;
        this.ferries = list7;
        this.ageClassifications = ageClassifications;
        this.siteName = str;
        this.lineLogoUrl = str2;
        this.site = site;
        this.supportInfo = siteSupportInfo;
        this.enabledCurrencies = list8;
    }

    private final List<Transportation> component3() {
        return this.extraTransportations;
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(LocalizedSiteConfiguration self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.routes);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.transportationCategories);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.extraTransportations);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.harbors);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.regions);
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.multiRideTypes);
        output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.ferries);
        output.encodeSerializableElement(serialDesc, 7, AgeClassifications$$serializer.INSTANCE, self.ageClassifications);
        output.encodeStringElement(serialDesc, 8, self.siteName);
        output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.lineLogoUrl);
        output.encodeSerializableElement(serialDesc, 10, kSerializerArr[10], self.site);
        output.encodeSerializableElement(serialDesc, 11, SiteSupportInfo$$serializer.INSTANCE, self.supportInfo);
        output.encodeSerializableElement(serialDesc, 12, kSerializerArr[12], self.enabledCurrencies);
    }

    public final List<Route> component1() {
        return this.routes;
    }

    /* renamed from: component10, reason: from getter */
    public final String getLineLogoUrl() {
        return this.lineLogoUrl;
    }

    /* renamed from: component11, reason: from getter */
    public final Site getSite() {
        return this.site;
    }

    /* renamed from: component12, reason: from getter */
    public final SiteSupportInfo getSupportInfo() {
        return this.supportInfo;
    }

    public final List<CurrencyType> component13() {
        return this.enabledCurrencies;
    }

    public final List<TransportationCategory> component2() {
        return this.transportationCategories;
    }

    public final List<Harbor> component4() {
        return this.harbors;
    }

    public final List<Region> component5() {
        return this.regions;
    }

    public final List<MultiRideType> component6() {
        return this.multiRideTypes;
    }

    public final List<SimpleFerry> component7() {
        return this.ferries;
    }

    /* renamed from: component8, reason: from getter */
    public final AgeClassifications getAgeClassifications() {
        return this.ageClassifications;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    public final LocalizedSiteConfiguration copy(List<Route> routes, List<TransportationCategory> transportationCategories, List<Transportation> extraTransportations, List<Harbor> harbors, List<Region> regions, List<MultiRideType> multiRideTypes, List<SimpleFerry> ferries, AgeClassifications ageClassifications, String siteName, String lineLogoUrl, Site site, SiteSupportInfo supportInfo, List<? extends CurrencyType> enabledCurrencies) {
        Intrinsics.checkNotNullParameter(routes, "routes");
        Intrinsics.checkNotNullParameter(transportationCategories, "transportationCategories");
        Intrinsics.checkNotNullParameter(extraTransportations, "extraTransportations");
        Intrinsics.checkNotNullParameter(harbors, "harbors");
        Intrinsics.checkNotNullParameter(regions, "regions");
        Intrinsics.checkNotNullParameter(multiRideTypes, "multiRideTypes");
        Intrinsics.checkNotNullParameter(ferries, "ferries");
        Intrinsics.checkNotNullParameter(ageClassifications, "ageClassifications");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(supportInfo, "supportInfo");
        Intrinsics.checkNotNullParameter(enabledCurrencies, "enabledCurrencies");
        return new LocalizedSiteConfiguration(routes, transportationCategories, extraTransportations, harbors, regions, multiRideTypes, ferries, ageClassifications, siteName, lineLogoUrl, site, supportInfo, enabledCurrencies);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalizedSiteConfiguration)) {
            return false;
        }
        LocalizedSiteConfiguration localizedSiteConfiguration = (LocalizedSiteConfiguration) other;
        return Intrinsics.areEqual(this.routes, localizedSiteConfiguration.routes) && Intrinsics.areEqual(this.transportationCategories, localizedSiteConfiguration.transportationCategories) && Intrinsics.areEqual(this.extraTransportations, localizedSiteConfiguration.extraTransportations) && Intrinsics.areEqual(this.harbors, localizedSiteConfiguration.harbors) && Intrinsics.areEqual(this.regions, localizedSiteConfiguration.regions) && Intrinsics.areEqual(this.multiRideTypes, localizedSiteConfiguration.multiRideTypes) && Intrinsics.areEqual(this.ferries, localizedSiteConfiguration.ferries) && Intrinsics.areEqual(this.ageClassifications, localizedSiteConfiguration.ageClassifications) && Intrinsics.areEqual(this.siteName, localizedSiteConfiguration.siteName) && Intrinsics.areEqual(this.lineLogoUrl, localizedSiteConfiguration.lineLogoUrl) && this.site == localizedSiteConfiguration.site && Intrinsics.areEqual(this.supportInfo, localizedSiteConfiguration.supportInfo) && Intrinsics.areEqual(this.enabledCurrencies, localizedSiteConfiguration.enabledCurrencies);
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

    public final SimpleFerry getFerry(String id) {
        Object obj;
        Iterator<T> it = this.ferries.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((SimpleFerry) obj).getId(), id)) {
                break;
            }
        }
        return (SimpleFerry) obj;
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

    public final List<TransportationCategory> getTransportationCategories() {
        return this.transportationCategories;
    }

    public final List<Transportation> getTransportations() {
        List<TransportationCategory> list = this.transportationCategories;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((TransportationCategory) it.next()).getTransportations());
        }
        return CollectionsKt.plus((Collection) arrayList, (Iterable) this.extraTransportations);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.routes.hashCode() * 31) + this.transportationCategories.hashCode()) * 31) + this.extraTransportations.hashCode()) * 31) + this.harbors.hashCode()) * 31) + this.regions.hashCode()) * 31) + this.multiRideTypes.hashCode()) * 31) + this.ferries.hashCode()) * 31) + this.ageClassifications.hashCode()) * 31) + this.siteName.hashCode()) * 31;
        String str = this.lineLogoUrl;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.site.hashCode()) * 31) + this.supportInfo.hashCode()) * 31) + this.enabledCurrencies.hashCode();
    }

    public String toString() {
        return "LocalizedSiteConfiguration(routes=" + this.routes + ", transportationCategories=" + this.transportationCategories + ", extraTransportations=" + this.extraTransportations + ", harbors=" + this.harbors + ", regions=" + this.regions + ", multiRideTypes=" + this.multiRideTypes + ", ferries=" + this.ferries + ", ageClassifications=" + this.ageClassifications + ", siteName=" + this.siteName + ", lineLogoUrl=" + this.lineLogoUrl + ", site=" + this.site + ", supportInfo=" + this.supportInfo + ", enabledCurrencies=" + this.enabledCurrencies + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalizedSiteConfiguration(List<Route> routes, List<TransportationCategory> transportationCategories, List<Transportation> extraTransportations, List<Harbor> harbors, List<Region> regions, List<MultiRideType> multiRideTypes, List<SimpleFerry> ferries, AgeClassifications ageClassifications, String siteName, String str, Site site, SiteSupportInfo supportInfo, List<? extends CurrencyType> enabledCurrencies) {
        Intrinsics.checkNotNullParameter(routes, "routes");
        Intrinsics.checkNotNullParameter(transportationCategories, "transportationCategories");
        Intrinsics.checkNotNullParameter(extraTransportations, "extraTransportations");
        Intrinsics.checkNotNullParameter(harbors, "harbors");
        Intrinsics.checkNotNullParameter(regions, "regions");
        Intrinsics.checkNotNullParameter(multiRideTypes, "multiRideTypes");
        Intrinsics.checkNotNullParameter(ferries, "ferries");
        Intrinsics.checkNotNullParameter(ageClassifications, "ageClassifications");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(supportInfo, "supportInfo");
        Intrinsics.checkNotNullParameter(enabledCurrencies, "enabledCurrencies");
        this.routes = routes;
        this.transportationCategories = transportationCategories;
        this.extraTransportations = extraTransportations;
        this.harbors = harbors;
        this.regions = regions;
        this.multiRideTypes = multiRideTypes;
        this.ferries = ferries;
        this.ageClassifications = ageClassifications;
        this.siteName = siteName;
        this.lineLogoUrl = str;
        this.site = site;
        this.supportInfo = supportInfo;
        this.enabledCurrencies = enabledCurrencies;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalizedSiteConfiguration(ConfigurationResponseDTO.LanguageSpecificConfigurationDTO dto, Site site) {
        this(r2, r4, r5, r6, r0, r8, r14, r9, r10, r11, site, r13, r15);
        List emptyList;
        CurrencyType currencyType;
        Intrinsics.checkNotNullParameter(dto, "dto");
        Intrinsics.checkNotNullParameter(site, "site");
        List<ConfigurationResponseDTO.RouteDTO> routes = dto.getRoutes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(routes, 10));
        Iterator<T> it = routes.iterator();
        while (true) {
            boolean z5 = false;
            if (!it.hasNext()) {
                break;
            }
            ConfigurationResponseDTO.RouteDTO routeDTO = (ConfigurationResponseDTO.RouteDTO) it.next();
            if (dto.getRegions() != null) {
                z5 = true;
            }
            arrayList.add(new Route(routeDTO, z5));
        }
        List<ConfigurationResponseDTO.TransportCategoryDTO> transportCategories = dto.getTransportCategories();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(transportCategories, 10));
        int i5 = 0;
        for (Object obj : transportCategories) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList2.add(new TransportationCategory((ConfigurationResponseDTO.TransportCategoryDTO) obj, dto.getTransportCategories().size() > 1 && i5 > 0));
            i5 = i6;
        }
        List<TransportResponseDTO> extraTransports = dto.getExtraTransports();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(extraTransports, 10));
        for (TransportResponseDTO transportResponseDTO : extraTransports) {
            arrayList3.add(new Transportation(transportResponseDTO, transportResponseDTO.getName()));
        }
        List<HarborDTO> harbors = dto.getHarbors();
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(harbors, 10));
        Iterator<T> it2 = harbors.iterator();
        while (it2.hasNext()) {
            arrayList4.add(new Harbor((HarborDTO) it2.next()));
        }
        List<ConfigurationResponseDTO.RegionDTO> regions = dto.getRegions();
        if (regions != null) {
            List<ConfigurationResponseDTO.RegionDTO> list = regions;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it3 = list.iterator();
            while (it3.hasNext()) {
                arrayList5.add(new Region((ConfigurationResponseDTO.RegionDTO) it3.next()));
            }
            emptyList = arrayList5;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        List<ConfigurationResponseDTO.MultiRideTypeDTO> tripCardTypes = dto.getTripCardTypes();
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(tripCardTypes, 10));
        Iterator<T> it4 = tripCardTypes.iterator();
        while (it4.hasNext()) {
            arrayList6.add(new MultiRideType((ConfigurationResponseDTO.MultiRideTypeDTO) it4.next()));
        }
        AgeClassifications ageClassifications = new AgeClassifications(dto.getAgeClassifications());
        String lineName = dto.getLineName();
        String lineLogoUrl = Environment.INSTANCE.isMolslinjen() ? dto.getLineLogoUrl() : null;
        SiteSupportInfo siteSupportInfo = new SiteSupportInfo(dto.getSupportInfo());
        List<ConfigurationResponseDTO.SimpleFerryDTO> ferries = dto.getFerries();
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(ferries, 10));
        Iterator<T> it5 = ferries.iterator();
        while (it5.hasNext()) {
            arrayList7.add(new SimpleFerry((ConfigurationResponseDTO.SimpleFerryDTO) it5.next()));
        }
        List<ConfigurationResponseDTO.CurrencyDTO> enabledCurrencies = dto.getEnabledCurrencies();
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(enabledCurrencies, 10));
        Iterator it6 = enabledCurrencies.iterator();
        while (it6.hasNext()) {
            String currency = ((ConfigurationResponseDTO.CurrencyDTO) it6.next()).getCurrency();
            int hashCode = currency.hashCode();
            Iterator it7 = it6;
            if (hashCode == 67748) {
                if (currency.equals("DKK")) {
                    currencyType = CurrencyType.DKK;
                }
                currencyType = CurrencyType.DKK;
            } else if (hashCode == 69026) {
                if (currency.equals("EUR")) {
                    currencyType = CurrencyType.EUR;
                }
                currencyType = CurrencyType.DKK;
            } else {
                if (hashCode == 81977 && currency.equals("SEK")) {
                    currencyType = CurrencyType.SEK;
                }
                currencyType = CurrencyType.DKK;
            }
            arrayList8.add(currencyType);
            it6 = it7;
        }
    }
}
