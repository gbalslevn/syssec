package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.domain.model.config.SiteConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB1\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0004J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/domain/model/config/Configuration;", BuildConfig.FLAVOR, "siteConfigurations", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/config/SiteConfiguration;", "<init>", "(Ljava/util/Map;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSiteConfigurations", "()Ljava/util/Map;", "getConfiguration", "site", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class Configuration {
    private static final Configuration mock;
    private final Map<Site, SiteConfiguration> siteConfigurations;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(Site.INSTANCE.serializer(), SiteConfiguration$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/Configuration$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/Configuration;", "getMock", "()Ldk/molslinjen/domain/model/config/Configuration;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Configuration getMock() {
            return Configuration.mock;
        }

        public final KSerializer<Configuration> serializer() {
            return Configuration$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        SiteConfiguration.Companion companion = SiteConfiguration.INSTANCE;
        mock = new Configuration((Map<Site, SiteConfiguration>) MapsKt.mapOf(new Pair(companion.getMockMols().getSite(), companion.getMockMols()), new Pair(companion.getMockKombardo().getSite(), companion.getMockKombardo())));
    }

    public /* synthetic */ Configuration(int i5, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, Configuration$$serializer.INSTANCE.getDescriptor());
        }
        this.siteConfigurations = map;
    }

    public final SiteConfiguration getConfiguration(Site site) {
        Intrinsics.checkNotNullParameter(site, "site");
        SiteConfiguration siteConfiguration = this.siteConfigurations.get(site);
        if (siteConfiguration != null) {
            return siteConfiguration;
        }
        throw new IllegalArgumentException("No configuration for site " + site + ". Available sites: " + CollectionsKt.joinToString$default(this.siteConfigurations.keySet(), ", ", null, null, 0, null, null, 62, null));
    }

    public final Map<Site, SiteConfiguration> getSiteConfigurations() {
        return this.siteConfigurations;
    }

    public Configuration(Map<Site, SiteConfiguration> siteConfigurations) {
        Intrinsics.checkNotNullParameter(siteConfigurations, "siteConfigurations");
        this.siteConfigurations = siteConfigurations;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Configuration(ConfigurationResponseDTO dto) {
        this(r1);
        Intrinsics.checkNotNullParameter(dto, "dto");
        List<ConfigurationResponseDTO.ConfigDTO> configs = dto.getConfigs();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(configs, 10));
        Iterator<T> it = configs.iterator();
        while (it.hasNext()) {
            arrayList.add(new SiteConfiguration((ConfigurationResponseDTO.ConfigDTO) it.next()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(((SiteConfiguration) obj).getSite(), obj);
        }
    }
}
