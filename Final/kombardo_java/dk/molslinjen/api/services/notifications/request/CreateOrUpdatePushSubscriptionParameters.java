package dk.molslinjen.api.services.notifications.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006*"}, d2 = {"Ldk/molslinjen/api/services/notifications/request/CreateOrUpdatePushSubscriptionParameters;", BuildConfig.FLAVOR, "firebaseUserToken", BuildConfig.FLAVOR, "app", "tags", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/notifications/request/PushTagParameters;", "languageIsoCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFirebaseUserToken", "()Ljava/lang/String;", "getApp", "getTags", "()Ljava/util/List;", "getLanguageIsoCode", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class CreateOrUpdatePushSubscriptionParameters {
    private final String app;
    private final String firebaseUserToken;
    private final String languageIsoCode;
    private final List<PushTagParameters> tags;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(PushTagParameters$$serializer.INSTANCE), null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/notifications/request/CreateOrUpdatePushSubscriptionParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/notifications/request/CreateOrUpdatePushSubscriptionParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreateOrUpdatePushSubscriptionParameters> serializer() {
            return CreateOrUpdatePushSubscriptionParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ CreateOrUpdatePushSubscriptionParameters(int i5, String str, String str2, List list, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, CreateOrUpdatePushSubscriptionParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.firebaseUserToken = str;
        this.app = str2;
        this.tags = list;
        this.languageIsoCode = str3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreateOrUpdatePushSubscriptionParameters copy$default(CreateOrUpdatePushSubscriptionParameters createOrUpdatePushSubscriptionParameters, String str, String str2, List list, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = createOrUpdatePushSubscriptionParameters.firebaseUserToken;
        }
        if ((i5 & 2) != 0) {
            str2 = createOrUpdatePushSubscriptionParameters.app;
        }
        if ((i5 & 4) != 0) {
            list = createOrUpdatePushSubscriptionParameters.tags;
        }
        if ((i5 & 8) != 0) {
            str3 = createOrUpdatePushSubscriptionParameters.languageIsoCode;
        }
        return createOrUpdatePushSubscriptionParameters.copy(str, str2, list, str3);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(CreateOrUpdatePushSubscriptionParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.firebaseUserToken);
        output.encodeStringElement(serialDesc, 1, self.app);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.tags);
        output.encodeStringElement(serialDesc, 3, self.languageIsoCode);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFirebaseUserToken() {
        return this.firebaseUserToken;
    }

    /* renamed from: component2, reason: from getter */
    public final String getApp() {
        return this.app;
    }

    public final List<PushTagParameters> component3() {
        return this.tags;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLanguageIsoCode() {
        return this.languageIsoCode;
    }

    public final CreateOrUpdatePushSubscriptionParameters copy(String firebaseUserToken, String app, List<PushTagParameters> tags, String languageIsoCode) {
        Intrinsics.checkNotNullParameter(firebaseUserToken, "firebaseUserToken");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(languageIsoCode, "languageIsoCode");
        return new CreateOrUpdatePushSubscriptionParameters(firebaseUserToken, app, tags, languageIsoCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateOrUpdatePushSubscriptionParameters)) {
            return false;
        }
        CreateOrUpdatePushSubscriptionParameters createOrUpdatePushSubscriptionParameters = (CreateOrUpdatePushSubscriptionParameters) other;
        return Intrinsics.areEqual(this.firebaseUserToken, createOrUpdatePushSubscriptionParameters.firebaseUserToken) && Intrinsics.areEqual(this.app, createOrUpdatePushSubscriptionParameters.app) && Intrinsics.areEqual(this.tags, createOrUpdatePushSubscriptionParameters.tags) && Intrinsics.areEqual(this.languageIsoCode, createOrUpdatePushSubscriptionParameters.languageIsoCode);
    }

    public final String getApp() {
        return this.app;
    }

    public final String getFirebaseUserToken() {
        return this.firebaseUserToken;
    }

    public final String getLanguageIsoCode() {
        return this.languageIsoCode;
    }

    public final List<PushTagParameters> getTags() {
        return this.tags;
    }

    public int hashCode() {
        return (((((this.firebaseUserToken.hashCode() * 31) + this.app.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.languageIsoCode.hashCode();
    }

    public String toString() {
        return "CreateOrUpdatePushSubscriptionParameters(firebaseUserToken=" + this.firebaseUserToken + ", app=" + this.app + ", tags=" + this.tags + ", languageIsoCode=" + this.languageIsoCode + ")";
    }

    public CreateOrUpdatePushSubscriptionParameters(String firebaseUserToken, String app, List<PushTagParameters> tags, String languageIsoCode) {
        Intrinsics.checkNotNullParameter(firebaseUserToken, "firebaseUserToken");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(languageIsoCode, "languageIsoCode");
        this.firebaseUserToken = firebaseUserToken;
        this.app = app;
        this.tags = tags;
        this.languageIsoCode = languageIsoCode;
    }
}
