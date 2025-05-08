package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import java.util.Locale;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fBC\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\b\u0010\u0011J\u0006\u0010\u0014\u001a\u00020\u0005J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/domain/model/config/SiteConfiguration;", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "danishConfiguration", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "englishConfiguration", "swedishConfiguration", "<init>", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$ConfigDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$ConfigDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "getActiveConfiguration", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class SiteConfiguration {
    private static final SiteConfiguration mockKombardo;
    private static final SiteConfiguration mockMols;
    private final LocalizedSiteConfiguration danishConfiguration;
    private final LocalizedSiteConfiguration englishConfiguration;
    private final Site site;
    private final LocalizedSiteConfiguration swedishConfiguration;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {Site.INSTANCE.serializer(), null, null, null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/config/SiteConfiguration$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockMols", "Ldk/molslinjen/domain/model/config/SiteConfiguration;", "getMockMols", "()Ldk/molslinjen/domain/model/config/SiteConfiguration;", "mockKombardo", "getMockKombardo", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SiteConfiguration getMockKombardo() {
            return SiteConfiguration.mockKombardo;
        }

        public final SiteConfiguration getMockMols() {
            return SiteConfiguration.mockMols;
        }

        public final KSerializer<SiteConfiguration> serializer() {
            return SiteConfiguration$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        Site site = Site.Mols;
        LocalizedSiteConfiguration.Companion companion = LocalizedSiteConfiguration.INSTANCE;
        mockMols = new SiteConfiguration(site, companion.getMock(), companion.getMock(), companion.getMock());
        mockKombardo = new SiteConfiguration(Site.Kombardo, companion.getMock(), companion.getMock(), companion.getMock());
    }

    public /* synthetic */ SiteConfiguration(int i5, Site site, LocalizedSiteConfiguration localizedSiteConfiguration, LocalizedSiteConfiguration localizedSiteConfiguration2, LocalizedSiteConfiguration localizedSiteConfiguration3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, SiteConfiguration$$serializer.INSTANCE.getDescriptor());
        }
        this.site = site;
        this.danishConfiguration = localizedSiteConfiguration;
        this.englishConfiguration = localizedSiteConfiguration2;
        this.swedishConfiguration = localizedSiteConfiguration3;
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SiteConfiguration self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.site);
        LocalizedSiteConfiguration$$serializer localizedSiteConfiguration$$serializer = LocalizedSiteConfiguration$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 1, localizedSiteConfiguration$$serializer, self.danishConfiguration);
        output.encodeSerializableElement(serialDesc, 2, localizedSiteConfiguration$$serializer, self.englishConfiguration);
        output.encodeSerializableElement(serialDesc, 3, localizedSiteConfiguration$$serializer, self.swedishConfiguration);
    }

    public final LocalizedSiteConfiguration getActiveConfiguration() {
        String language = Locale.getDefault().getLanguage();
        return Intrinsics.areEqual(language, "da") ? this.danishConfiguration : Intrinsics.areEqual(language, "sv") ? this.swedishConfiguration : this.englishConfiguration;
    }

    public final Site getSite() {
        return this.site;
    }

    public SiteConfiguration(Site site, LocalizedSiteConfiguration danishConfiguration, LocalizedSiteConfiguration englishConfiguration, LocalizedSiteConfiguration swedishConfiguration) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(danishConfiguration, "danishConfiguration");
        Intrinsics.checkNotNullParameter(englishConfiguration, "englishConfiguration");
        Intrinsics.checkNotNullParameter(swedishConfiguration, "swedishConfiguration");
        this.site = site;
        this.danishConfiguration = danishConfiguration;
        this.englishConfiguration = englishConfiguration;
        this.swedishConfiguration = swedishConfiguration;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SiteConfiguration(ConfigurationResponseDTO.ConfigDTO dto) {
        this(r0.invoke(dto.getSite()), new LocalizedSiteConfiguration(dto.getLanguages().getDanish(), r0.invoke(dto.getSite())), new LocalizedSiteConfiguration(dto.getLanguages().getEnglish(), r0.invoke(dto.getSite())), new LocalizedSiteConfiguration(dto.getLanguages().getSwedish(), r0.invoke(dto.getSite())));
        Intrinsics.checkNotNullParameter(dto, "dto");
        Site.Companion companion = Site.INSTANCE;
    }
}
