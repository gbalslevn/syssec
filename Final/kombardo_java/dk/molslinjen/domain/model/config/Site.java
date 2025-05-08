package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.SiteId;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/model/config/Site;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Mols", "Bornholm", "Als", "Langeland", "Samsoe", "Fanoe", "Kombardo", "Oeresund", "toDTO", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "toSiteId", "Luniffi/molslinjen_shared/SiteId;", "trackingKey", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class Site {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Site[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final Site Mols = new Site("Mols", 0);
    public static final Site Bornholm = new Site("Bornholm", 1);
    public static final Site Als = new Site("Als", 2);
    public static final Site Langeland = new Site("Langeland", 3);
    public static final Site Samsoe = new Site("Samsoe", 4);
    public static final Site Fanoe = new Site("Fanoe", 5);
    public static final Site Kombardo = new Site("Kombardo", 6);
    public static final Site Oeresund = new Site("Oeresund", 7);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/config/Site$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/config/Site;", "dto", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "name", BuildConfig.FLAVOR, "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SiteDTO.values().length];
                try {
                    iArr[SiteDTO.Mols.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SiteDTO.Bornholm.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SiteDTO.Als.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[SiteDTO.Langeland.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[SiteDTO.Samsoe.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[SiteDTO.Fanoe.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[SiteDTO.Kombardo.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[SiteDTO.Oeresund.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) Site.$cachedSerializer$delegate.getValue();
        }

        public final Site invoke(SiteDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            switch (WhenMappings.$EnumSwitchMapping$0[dto.ordinal()]) {
                case 1:
                    return Site.Mols;
                case 2:
                    return Site.Bornholm;
                case 3:
                    return Site.Als;
                case 4:
                    return Site.Langeland;
                case 5:
                    return Site.Samsoe;
                case 6:
                    return Site.Fanoe;
                case 7:
                    return Site.Kombardo;
                case 8:
                    return Site.Oeresund;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final KSerializer<Site> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }

        public final Site invoke(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            for (Site site : Site.values()) {
                if (Intrinsics.areEqual(site.name(), name)) {
                    return site;
                }
            }
            return null;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Site.values().length];
            try {
                iArr[Site.Mols.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Site.Bornholm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Site.Als.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Site.Langeland.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Site.Samsoe.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Site.Fanoe.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Site.Kombardo.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Site.Oeresund.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ Site[] $values() {
        return new Site[]{Mols, Bornholm, Als, Langeland, Samsoe, Fanoe, Kombardo, Oeresund};
    }

    static {
        Site[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: L1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = Site._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });
    }

    private Site(String str, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.config.Site", values());
    }

    public static EnumEntries<Site> getEntries() {
        return $ENTRIES;
    }

    public static Site valueOf(String str) {
        return (Site) Enum.valueOf(Site.class, str);
    }

    public static Site[] values() {
        return (Site[]) $VALUES.clone();
    }

    public final SiteDTO toDTO() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return SiteDTO.Mols;
            case 2:
                return SiteDTO.Bornholm;
            case 3:
                return SiteDTO.Als;
            case 4:
                return SiteDTO.Langeland;
            case 5:
                return SiteDTO.Samsoe;
            case 6:
                return SiteDTO.Fanoe;
            case 7:
                return SiteDTO.Kombardo;
            case 8:
                return SiteDTO.Oeresund;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final SiteId toSiteId() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return SiteId.MOLS;
            case 2:
                return SiteId.BORNHOLM;
            case 3:
                return SiteId.ALS;
            case 4:
                return SiteId.LANGELAND;
            case 5:
                return SiteId.SAMSOE;
            case 6:
                return SiteId.FANOE;
            case 7:
                return SiteId.KOMBARDO;
            case 8:
                return SiteId.OERESUND;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String trackingKey() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "molslinjen";
            case 2:
                return "bornholmslinjen";
            case 3:
                return "alslinjen";
            case 4:
                return "langelandslinjen";
            case 5:
                return "samsølinjen";
            case 6:
                return "fanølinjen";
            case 7:
                return "kombardo expressen";
            case 8:
                return "øresundslinjen";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
