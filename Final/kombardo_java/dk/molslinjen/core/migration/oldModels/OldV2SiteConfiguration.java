package dk.molslinjen.core.migration.oldModels;

import dk.molslinjen.domain.model.config.Site;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fBC\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c¨\u0006!"}, d2 = {"Ldk/molslinjen/core/migration/oldModels/OldV2SiteConfiguration;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;", "danishConfiguration", "englishConfiguration", "swedishConfiguration", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILdk/molslinjen/domain/model/config/Site;Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldModels/OldV2SiteConfiguration;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;", "getDanishConfiguration", "()Ldk/molslinjen/core/migration/oldModels/OldV2LocalizedSiteConfiguration;", "getEnglishConfiguration", "getSwedishConfiguration", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class OldV2SiteConfiguration {
    private final OldV2LocalizedSiteConfiguration danishConfiguration;
    private final OldV2LocalizedSiteConfiguration englishConfiguration;
    private final Site site;
    private final OldV2LocalizedSiteConfiguration swedishConfiguration;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {Site.INSTANCE.serializer(), null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldModels/OldV2SiteConfiguration$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldModels/OldV2SiteConfiguration;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OldV2SiteConfiguration> serializer() {
            return OldV2SiteConfiguration$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ OldV2SiteConfiguration(int i5, Site site, OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration, OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration2, OldV2LocalizedSiteConfiguration oldV2LocalizedSiteConfiguration3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, OldV2SiteConfiguration$$serializer.INSTANCE.getDescriptor());
        }
        this.site = site;
        this.danishConfiguration = oldV2LocalizedSiteConfiguration;
        this.englishConfiguration = oldV2LocalizedSiteConfiguration2;
        this.swedishConfiguration = oldV2LocalizedSiteConfiguration3;
    }

    public static final /* synthetic */ void write$Self$app_kombardoProd(OldV2SiteConfiguration self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.site);
        OldV2LocalizedSiteConfiguration$$serializer oldV2LocalizedSiteConfiguration$$serializer = OldV2LocalizedSiteConfiguration$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 1, oldV2LocalizedSiteConfiguration$$serializer, self.danishConfiguration);
        output.encodeSerializableElement(serialDesc, 2, oldV2LocalizedSiteConfiguration$$serializer, self.englishConfiguration);
        output.encodeSerializableElement(serialDesc, 3, oldV2LocalizedSiteConfiguration$$serializer, self.swedishConfiguration);
    }

    public final OldV2LocalizedSiteConfiguration getDanishConfiguration() {
        return this.danishConfiguration;
    }

    public final OldV2LocalizedSiteConfiguration getEnglishConfiguration() {
        return this.englishConfiguration;
    }

    public final Site getSite() {
        return this.site;
    }

    public final OldV2LocalizedSiteConfiguration getSwedishConfiguration() {
        return this.swedishConfiguration;
    }
}
