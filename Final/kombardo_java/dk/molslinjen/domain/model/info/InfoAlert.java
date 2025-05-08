package dk.molslinjen.domain.model.info;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.info.response.InfoAlertResponseDTO;
import dk.molslinjen.api.services.info.response.InfoDialogIconTypeDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.info.InfoAlert;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0003=>?BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011Bi\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\r\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003Ja\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u00101\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0013HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006@"}, d2 = {"Ldk/molslinjen/domain/model/info/InfoAlert;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "description", "routeId", "version", "iconType", "Ldk/molslinjen/domain/model/info/InfoAlert$IconType;", "buttonText", "shown", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/info/InfoAlert$IconType;Ljava/lang/String;Z)V", "dto", "Ldk/molslinjen/api/services/info/response/InfoAlertResponseDTO;", "(Ldk/molslinjen/api/services/info/response/InfoAlertResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/info/InfoAlert$IconType;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getDescription", "getRouteId", "getVersion", "getIconType", "()Ldk/molslinjen/domain/model/info/InfoAlert$IconType;", "setIconType", "(Ldk/molslinjen/domain/model/info/InfoAlert$IconType;)V", "getButtonText", "setButtonText", "(Ljava/lang/String;)V", "getShown", "()Z", "setShown", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "IconType", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class InfoAlert {
    private static final InfoAlert mock1;
    private static final InfoAlert mock2;
    private static final InfoAlert mock3;
    private static final InfoAlert mock4;
    private String buttonText;
    private final String description;
    private IconType iconType;
    private final String id;
    private final String routeId;
    private boolean shown;
    private final String title;
    private final String version;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, IconType.INSTANCE.serializer(), null, null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/model/info/InfoAlert$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock1", "Ldk/molslinjen/domain/model/info/InfoAlert;", "getMock1", "()Ldk/molslinjen/domain/model/info/InfoAlert;", "mock2", "getMock2", "mock3", "getMock3", "mock4", "getMock4", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InfoAlert getMock1() {
            return InfoAlert.mock1;
        }

        public final InfoAlert getMock2() {
            return InfoAlert.mock2;
        }

        public final InfoAlert getMock3() {
            return InfoAlert.mock3;
        }

        public final InfoAlert getMock4() {
            return InfoAlert.mock4;
        }

        public final KSerializer<InfoAlert> serializer() {
            return InfoAlert$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/info/InfoAlert$IconType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Celebration", "Warning", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final class IconType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ IconType[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final IconType Celebration = new IconType("Celebration", 0);
        public static final IconType Warning = new IconType("Warning", 1);

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/info/InfoAlert$IconType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/info/InfoAlert$IconType;", "dto", "Ldk/molslinjen/api/services/info/response/InfoDialogIconTypeDTO;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {

            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[InfoDialogIconTypeDTO.values().length];
                    try {
                        iArr[InfoDialogIconTypeDTO.Celebration.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[InfoDialogIconTypeDTO.Warning.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) IconType.$cachedSerializer$delegate.getValue();
            }

            public final IconType invoke(InfoDialogIconTypeDTO dto) {
                Intrinsics.checkNotNullParameter(dto, "dto");
                int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
                if (i5 == 1) {
                    return IconType.Celebration;
                }
                if (i5 == 2) {
                    return IconType.Warning;
                }
                throw new NoWhenBranchMatchedException();
            }

            public final KSerializer<IconType> serializer() {
                return get$cachedSerializer();
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ IconType[] $values() {
            return new IconType[]{Celebration, Warning};
        }

        static {
            IconType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: M1.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = InfoAlert.IconType._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
        }

        private IconType(String str, int i5) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.info.InfoAlert.IconType", values());
        }

        public static EnumEntries<IconType> getEntries() {
            return $ENTRIES;
        }

        public static IconType valueOf(String str) {
            return (IconType) Enum.valueOf(IconType.class, str);
        }

        public static IconType[] values() {
            return (IconType[]) $VALUES.clone();
        }
    }

    static {
        IconType iconType = IconType.Celebration;
        int i5 = 128;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = null;
        boolean z5 = false;
        mock1 = new InfoAlert("10", "Generel info", "Molslinjen prøver noget nyt", (String) null, str, iconType, "Forstået", z5, i5, defaultConstructorMarker);
        mock2 = new InfoAlert("20", "Rute info 3", "Detaljer om rute 3 er ændret til at køre fra med nye færger", "3", str, iconType, "Forstået", z5, i5, defaultConstructorMarker);
        mock3 = new InfoAlert("30", "Rute 10 - vigtig", "Det er nu ikke muligt at kører ombord med små biler", "10", (String) null, IconType.Warning, "Arh øv", false, 128, (DefaultConstructorMarker) null);
        mock4 = new InfoAlert("40", "Ny version af appen", "En helt ny app er klar til dig", (String) null, "458", iconType, (String) null, z5, i5, defaultConstructorMarker);
    }

    public /* synthetic */ InfoAlert(int i5, String str, String str2, String str3, String str4, String str5, IconType iconType, String str6, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, InfoAlert$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.routeId = str4;
        this.version = str5;
        this.iconType = iconType;
        this.buttonText = str6;
        if ((i5 & 128) == 0) {
            this.shown = false;
        } else {
            this.shown = z5;
        }
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(InfoAlert self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.title);
        output.encodeStringElement(serialDesc, 2, self.description);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.routeId);
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.version);
        output.encodeNullableSerializableElement(serialDesc, 5, kSerializerArr[5], self.iconType);
        output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.buttonText);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.shown) {
            output.encodeBooleanElement(serialDesc, 7, self.shown);
        }
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRouteId() {
        return this.routeId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component6, reason: from getter */
    public final IconType getIconType() {
        return this.iconType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getShown() {
        return this.shown;
    }

    public final InfoAlert copy(String id, String title, String description, String routeId, String version, IconType iconType, String buttonText, boolean shown) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        return new InfoAlert(id, title, description, routeId, version, iconType, buttonText, shown);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InfoAlert)) {
            return false;
        }
        InfoAlert infoAlert = (InfoAlert) other;
        return Intrinsics.areEqual(this.id, infoAlert.id) && Intrinsics.areEqual(this.title, infoAlert.title) && Intrinsics.areEqual(this.description, infoAlert.description) && Intrinsics.areEqual(this.routeId, infoAlert.routeId) && Intrinsics.areEqual(this.version, infoAlert.version) && this.iconType == infoAlert.iconType && Intrinsics.areEqual(this.buttonText, infoAlert.buttonText) && this.shown == infoAlert.shown;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getDescription() {
        return this.description;
    }

    public final IconType getIconType() {
        return this.iconType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRouteId() {
        return this.routeId;
    }

    public final boolean getShown() {
        return this.shown;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.routeId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        IconType iconType = this.iconType;
        int hashCode4 = (hashCode3 + (iconType == null ? 0 : iconType.hashCode())) * 31;
        String str3 = this.buttonText;
        return ((hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.shown);
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final void setIconType(IconType iconType) {
        this.iconType = iconType;
    }

    public final void setShown(boolean z5) {
        this.shown = z5;
    }

    public String toString() {
        return "InfoAlert(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", routeId=" + this.routeId + ", version=" + this.version + ", iconType=" + this.iconType + ", buttonText=" + this.buttonText + ", shown=" + this.shown + ")";
    }

    public InfoAlert(String id, String title, String description, String str, String str2, IconType iconType, String str3, boolean z5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = id;
        this.title = title;
        this.description = description;
        this.routeId = str;
        this.version = str2;
        this.iconType = iconType;
        this.buttonText = str3;
        this.shown = z5;
    }

    public /* synthetic */ InfoAlert(String str, String str2, String str3, String str4, String str5, IconType iconType, String str6, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, iconType, str6, (i5 & 128) != 0 ? false : z5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InfoAlert(InfoAlertResponseDTO dto) {
        this(r2, r3, r4, r5, r6, r13 != null ? IconType.INSTANCE.invoke(r13) : null, r8, false, 128, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        String title = dto.getTitle();
        String description = dto.getDescription();
        String nullIfEmpty = StringExtensionsKt.nullIfEmpty(dto.getRouteId());
        String nullIfEmpty2 = StringExtensionsKt.nullIfEmpty(dto.getVersion());
        String buttonText = dto.getButtonText();
        InfoDialogIconTypeDTO iconType = dto.getIconType();
    }
}
