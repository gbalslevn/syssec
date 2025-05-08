package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.shared.response.SublineDTO;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002%&B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB9\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\fHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006'"}, d2 = {"Ldk/molslinjen/domain/model/config/Subline;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "iconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/shared/response/SublineDTO;", "(Ldk/molslinjen/api/shared/response/SublineDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getId", "getIconUrl", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class Subline {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Subline mock = new Subline("Øresund Expressen", "oresund-expressen", "https://cdn.qa.molslinjen.dk/h4ndnzxa/icon-logo-micro-kombardoexpressen.svg");
    private final String iconUrl;
    private final String id;
    private final String name;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/Subline$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/Subline;", "getMock", "()Ldk/molslinjen/domain/model/config/Subline;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Subline getMock() {
            return Subline.mock;
        }

        public final KSerializer<Subline> serializer() {
            return Subline$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Subline(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, Subline$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.id = str2;
        this.iconUrl = str3;
    }

    public static /* synthetic */ Subline copy$default(Subline subline, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = subline.name;
        }
        if ((i5 & 2) != 0) {
            str2 = subline.id;
        }
        if ((i5 & 4) != 0) {
            str3 = subline.iconUrl;
        }
        return subline.copy(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(Subline self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.id);
        output.encodeStringElement(serialDesc, 2, self.iconUrl);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Subline copy(String name, String id, String iconUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        return new Subline(name, id, iconUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subline)) {
            return false;
        }
        Subline subline = (Subline) other;
        return Intrinsics.areEqual(this.name, subline.name) && Intrinsics.areEqual(this.id, subline.id) && Intrinsics.areEqual(this.iconUrl, subline.iconUrl);
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + this.iconUrl.hashCode();
    }

    public String toString() {
        return "Subline(name=" + this.name + ", id=" + this.id + ", iconUrl=" + this.iconUrl + ")";
    }

    public Subline(String name, String id, String iconUrl) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        this.name = name;
        this.id = id;
        this.iconUrl = iconUrl;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Subline(SublineDTO dto) {
        this(dto.getName(), dto.getId(), dto.getIconUrl());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
