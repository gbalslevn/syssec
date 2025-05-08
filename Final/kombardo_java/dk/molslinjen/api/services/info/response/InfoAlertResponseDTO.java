package dk.molslinjen.api.services.info.response;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.info.response.InfoDialogIconTypeDTO;
import dk.molslinjen.domain.model.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBa\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003JW\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Ldk/molslinjen/api/services/info/response/InfoAlertResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "description", "routeId", "version", "buttonText", "iconType", "Ldk/molslinjen/api/services/info/response/InfoDialogIconTypeDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/info/response/InfoDialogIconTypeDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/info/response/InfoDialogIconTypeDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle$annotations", "()V", "getTitle", "getDescription$annotations", "getDescription", "getRouteId", "getVersion", "getButtonText", "getIconType", "()Ldk/molslinjen/api/services/info/response/InfoDialogIconTypeDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class InfoAlertResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String buttonText;
    private final String description;
    private final InfoDialogIconTypeDTO iconType;
    private final String id;
    private final String routeId;
    private final String title;
    private final String version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/info/response/InfoAlertResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/info/response/InfoAlertResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<InfoAlertResponseDTO> serializer() {
            return InfoAlertResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ InfoAlertResponseDTO(int i5, String str, String str2, String str3, String str4, String str5, String str6, InfoDialogIconTypeDTO infoDialogIconTypeDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, InfoAlertResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.routeId = str4;
        this.version = str5;
        this.buttonText = str6;
        this.iconType = infoDialogIconTypeDTO;
    }

    public static /* synthetic */ InfoAlertResponseDTO copy$default(InfoAlertResponseDTO infoAlertResponseDTO, String str, String str2, String str3, String str4, String str5, String str6, InfoDialogIconTypeDTO infoDialogIconTypeDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = infoAlertResponseDTO.id;
        }
        if ((i5 & 2) != 0) {
            str2 = infoAlertResponseDTO.title;
        }
        String str7 = str2;
        if ((i5 & 4) != 0) {
            str3 = infoAlertResponseDTO.description;
        }
        String str8 = str3;
        if ((i5 & 8) != 0) {
            str4 = infoAlertResponseDTO.routeId;
        }
        String str9 = str4;
        if ((i5 & 16) != 0) {
            str5 = infoAlertResponseDTO.version;
        }
        String str10 = str5;
        if ((i5 & 32) != 0) {
            str6 = infoAlertResponseDTO.buttonText;
        }
        String str11 = str6;
        if ((i5 & 64) != 0) {
            infoDialogIconTypeDTO = infoAlertResponseDTO.iconType;
        }
        return infoAlertResponseDTO.copy(str, str7, str8, str9, str10, str11, infoDialogIconTypeDTO);
    }

    public static /* synthetic */ void getDescription$annotations() {
    }

    public static /* synthetic */ void getTitle$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(InfoAlertResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.title);
        output.encodeStringElement(serialDesc, 2, self.description);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.routeId);
        output.encodeNullableSerializableElement(serialDesc, 4, stringSerializer, self.version);
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.buttonText);
        output.encodeNullableSerializableElement(serialDesc, 6, InfoDialogIconTypeDTO.Serializer.INSTANCE, self.iconType);
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
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: component7, reason: from getter */
    public final InfoDialogIconTypeDTO getIconType() {
        return this.iconType;
    }

    public final InfoAlertResponseDTO copy(String id, String title, String description, String routeId, String version, String buttonText, InfoDialogIconTypeDTO iconType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        return new InfoAlertResponseDTO(id, title, description, routeId, version, buttonText, iconType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InfoAlertResponseDTO)) {
            return false;
        }
        InfoAlertResponseDTO infoAlertResponseDTO = (InfoAlertResponseDTO) other;
        return Intrinsics.areEqual(this.id, infoAlertResponseDTO.id) && Intrinsics.areEqual(this.title, infoAlertResponseDTO.title) && Intrinsics.areEqual(this.description, infoAlertResponseDTO.description) && Intrinsics.areEqual(this.routeId, infoAlertResponseDTO.routeId) && Intrinsics.areEqual(this.version, infoAlertResponseDTO.version) && Intrinsics.areEqual(this.buttonText, infoAlertResponseDTO.buttonText) && this.iconType == infoAlertResponseDTO.iconType;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getDescription() {
        return this.description;
    }

    public final InfoDialogIconTypeDTO getIconType() {
        return this.iconType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRouteId() {
        return this.routeId;
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
        String str3 = this.buttonText;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        InfoDialogIconTypeDTO infoDialogIconTypeDTO = this.iconType;
        return hashCode4 + (infoDialogIconTypeDTO != null ? infoDialogIconTypeDTO.hashCode() : 0);
    }

    public String toString() {
        return "InfoAlertResponseDTO(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", routeId=" + this.routeId + ", version=" + this.version + ", buttonText=" + this.buttonText + ", iconType=" + this.iconType + ")";
    }

    public InfoAlertResponseDTO(String id, String title, String description, String str, String str2, String str3, InfoDialogIconTypeDTO infoDialogIconTypeDTO) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = id;
        this.title = title;
        this.description = description;
        this.routeId = str;
        this.version = str2;
        this.buttonText = str3;
        this.iconType = infoDialogIconTypeDTO;
    }
}
