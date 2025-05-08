package dk.molslinjen.api.services.multiRide.response;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;", BuildConfig.FLAVOR, "url", BuildConfig.FLAVOR, "appUrl", "orderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getAppUrl", "getOrderId", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRidePurchaseResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appUrl;
    private final String orderId;
    private final String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRidePurchaseResponseDTO> serializer() {
            return MultiRidePurchaseResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MultiRidePurchaseResponseDTO(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, MultiRidePurchaseResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.url = str;
        this.appUrl = str2;
        this.orderId = str3;
    }

    public static /* synthetic */ MultiRidePurchaseResponseDTO copy$default(MultiRidePurchaseResponseDTO multiRidePurchaseResponseDTO, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = multiRidePurchaseResponseDTO.url;
        }
        if ((i5 & 2) != 0) {
            str2 = multiRidePurchaseResponseDTO.appUrl;
        }
        if ((i5 & 4) != 0) {
            str3 = multiRidePurchaseResponseDTO.orderId;
        }
        return multiRidePurchaseResponseDTO.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRidePurchaseResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.url);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.appUrl);
        output.encodeStringElement(serialDesc, 2, self.orderId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppUrl() {
        return this.appUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    public final MultiRidePurchaseResponseDTO copy(String url, String appUrl, String orderId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        return new MultiRidePurchaseResponseDTO(url, appUrl, orderId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRidePurchaseResponseDTO)) {
            return false;
        }
        MultiRidePurchaseResponseDTO multiRidePurchaseResponseDTO = (MultiRidePurchaseResponseDTO) other;
        return Intrinsics.areEqual(this.url, multiRidePurchaseResponseDTO.url) && Intrinsics.areEqual(this.appUrl, multiRidePurchaseResponseDTO.appUrl) && Intrinsics.areEqual(this.orderId, multiRidePurchaseResponseDTO.orderId);
    }

    public final String getAppUrl() {
        return this.appUrl;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        String str = this.appUrl;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.orderId.hashCode();
    }

    public String toString() {
        return "MultiRidePurchaseResponseDTO(url=" + this.url + ", appUrl=" + this.appUrl + ", orderId=" + this.orderId + ")";
    }

    public MultiRidePurchaseResponseDTO(String url, String str, String orderId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        this.url = url;
        this.appUrl = str;
        this.orderId = orderId;
    }
}
