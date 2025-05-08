package dk.molslinjen.api.services.saleOnBoard.request;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\r¨\u0006#"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/CreateOrderRequestParameters;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "phoneIncludingRegionCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getPhoneIncludingRegionCode$annotations", "()V", "getPhoneIncludingRegionCode", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class CreateOrderRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final String phoneIncludingRegionCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/request/CreateOrderRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/request/CreateOrderRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreateOrderRequestParameters> serializer() {
            return CreateOrderRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ CreateOrderRequestParameters(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, CreateOrderRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.phoneIncludingRegionCode = str2;
    }

    public static /* synthetic */ CreateOrderRequestParameters copy$default(CreateOrderRequestParameters createOrderRequestParameters, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = createOrderRequestParameters.name;
        }
        if ((i5 & 2) != 0) {
            str2 = createOrderRequestParameters.phoneIncludingRegionCode;
        }
        return createOrderRequestParameters.copy(str, str2);
    }

    public static /* synthetic */ void getPhoneIncludingRegionCode$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(CreateOrderRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.phoneIncludingRegionCode);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhoneIncludingRegionCode() {
        return this.phoneIncludingRegionCode;
    }

    public final CreateOrderRequestParameters copy(String name, String phoneIncludingRegionCode) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneIncludingRegionCode, "phoneIncludingRegionCode");
        return new CreateOrderRequestParameters(name, phoneIncludingRegionCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateOrderRequestParameters)) {
            return false;
        }
        CreateOrderRequestParameters createOrderRequestParameters = (CreateOrderRequestParameters) other;
        return Intrinsics.areEqual(this.name, createOrderRequestParameters.name) && Intrinsics.areEqual(this.phoneIncludingRegionCode, createOrderRequestParameters.phoneIncludingRegionCode);
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhoneIncludingRegionCode() {
        return this.phoneIncludingRegionCode;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.phoneIncludingRegionCode.hashCode();
    }

    public String toString() {
        return "CreateOrderRequestParameters(name=" + this.name + ", phoneIncludingRegionCode=" + this.phoneIncludingRegionCode + ")";
    }

    public CreateOrderRequestParameters(String name, String phoneIncludingRegionCode) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneIncludingRegionCode, "phoneIncludingRegionCode");
        this.name = name;
        this.phoneIncludingRegionCode = phoneIncludingRegionCode;
    }
}
