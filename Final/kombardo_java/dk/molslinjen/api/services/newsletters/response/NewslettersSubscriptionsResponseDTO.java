package dk.molslinjen.api.services.newsletters.response;

import dk.molslinjen.api.services.config.response.SiteDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0003 !\"B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO;", BuildConfig.FLAVOR, "statuses", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO;", "<init>", "(Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStatuses$annotations", "()V", "getStatuses", "()Ljava/util/List;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "NewsletterSubscriptionDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class NewslettersSubscriptionsResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<NewsletterSubscriptionDTO> statuses;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<NewslettersSubscriptionsResponseDTO> serializer() {
            return NewslettersSubscriptionsResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO;", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "allowsNewsletters", BuildConfig.FLAVOR, "allowsPromotions", "<init>", "(Ldk/molslinjen/api/services/config/response/SiteDTO;ZZ)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/api/services/config/response/SiteDTO;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSite", "()Ldk/molslinjen/api/services/config/response/SiteDTO;", "getAllowsNewsletters", "()Z", "getAllowsPromotions", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class NewsletterSubscriptionDTO {
        private final boolean allowsNewsletters;
        private final boolean allowsPromotions;
        private final SiteDTO site;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {EnumsKt.createSimpleEnumSerializer("dk.molslinjen.api.services.config.response.SiteDTO", SiteDTO.values()), null, null};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<NewsletterSubscriptionDTO> serializer() {
                return NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ NewsletterSubscriptionDTO(int i5, SiteDTO siteDTO, boolean z5, boolean z6, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, NewslettersSubscriptionsResponseDTO$NewsletterSubscriptionDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.site = siteDTO;
            this.allowsNewsletters = z5;
            this.allowsPromotions = z6;
        }

        public static /* synthetic */ NewsletterSubscriptionDTO copy$default(NewsletterSubscriptionDTO newsletterSubscriptionDTO, SiteDTO siteDTO, boolean z5, boolean z6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                siteDTO = newsletterSubscriptionDTO.site;
            }
            if ((i5 & 2) != 0) {
                z5 = newsletterSubscriptionDTO.allowsNewsletters;
            }
            if ((i5 & 4) != 0) {
                z6 = newsletterSubscriptionDTO.allowsPromotions;
            }
            return newsletterSubscriptionDTO.copy(siteDTO, z5, z6);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(NewsletterSubscriptionDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.site);
            output.encodeBooleanElement(serialDesc, 1, self.allowsNewsletters);
            output.encodeBooleanElement(serialDesc, 2, self.allowsPromotions);
        }

        /* renamed from: component1, reason: from getter */
        public final SiteDTO getSite() {
            return this.site;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAllowsNewsletters() {
            return this.allowsNewsletters;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getAllowsPromotions() {
            return this.allowsPromotions;
        }

        public final NewsletterSubscriptionDTO copy(SiteDTO site, boolean allowsNewsletters, boolean allowsPromotions) {
            Intrinsics.checkNotNullParameter(site, "site");
            return new NewsletterSubscriptionDTO(site, allowsNewsletters, allowsPromotions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NewsletterSubscriptionDTO)) {
                return false;
            }
            NewsletterSubscriptionDTO newsletterSubscriptionDTO = (NewsletterSubscriptionDTO) other;
            return this.site == newsletterSubscriptionDTO.site && this.allowsNewsletters == newsletterSubscriptionDTO.allowsNewsletters && this.allowsPromotions == newsletterSubscriptionDTO.allowsPromotions;
        }

        public final boolean getAllowsNewsletters() {
            return this.allowsNewsletters;
        }

        public final boolean getAllowsPromotions() {
            return this.allowsPromotions;
        }

        public final SiteDTO getSite() {
            return this.site;
        }

        public int hashCode() {
            return (((this.site.hashCode() * 31) + Boolean.hashCode(this.allowsNewsletters)) * 31) + Boolean.hashCode(this.allowsPromotions);
        }

        public String toString() {
            return "NewsletterSubscriptionDTO(site=" + this.site + ", allowsNewsletters=" + this.allowsNewsletters + ", allowsPromotions=" + this.allowsPromotions + ")";
        }

        public NewsletterSubscriptionDTO(SiteDTO site, boolean z5, boolean z6) {
            Intrinsics.checkNotNullParameter(site, "site");
            this.site = site;
            this.allowsNewsletters = z5;
            this.allowsPromotions = z6;
        }
    }

    public /* synthetic */ NewslettersSubscriptionsResponseDTO(int i5, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, NewslettersSubscriptionsResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.statuses = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewslettersSubscriptionsResponseDTO copy$default(NewslettersSubscriptionsResponseDTO newslettersSubscriptionsResponseDTO, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = newslettersSubscriptionsResponseDTO.statuses;
        }
        return newslettersSubscriptionsResponseDTO.copy(list);
    }

    @Serializable(with = NewsletterSubscriptionDTOSafeListSerializer.class)
    public static /* synthetic */ void getStatuses$annotations() {
    }

    public final List<NewsletterSubscriptionDTO> component1() {
        return this.statuses;
    }

    public final NewslettersSubscriptionsResponseDTO copy(List<NewsletterSubscriptionDTO> statuses) {
        Intrinsics.checkNotNullParameter(statuses, "statuses");
        return new NewslettersSubscriptionsResponseDTO(statuses);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NewslettersSubscriptionsResponseDTO) && Intrinsics.areEqual(this.statuses, ((NewslettersSubscriptionsResponseDTO) other).statuses);
    }

    public final List<NewsletterSubscriptionDTO> getStatuses() {
        return this.statuses;
    }

    public int hashCode() {
        return this.statuses.hashCode();
    }

    public String toString() {
        return "NewslettersSubscriptionsResponseDTO(statuses=" + this.statuses + ")";
    }

    public NewslettersSubscriptionsResponseDTO(List<NewsletterSubscriptionDTO> statuses) {
        Intrinsics.checkNotNullParameter(statuses, "statuses");
        this.statuses = statuses;
    }
}
