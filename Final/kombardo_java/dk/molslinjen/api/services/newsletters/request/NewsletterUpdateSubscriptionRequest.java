package dk.molslinjen.api.services.newsletters.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J:\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006*"}, d2 = {"Ldk/molslinjen/api/services/newsletters/request/NewsletterUpdateSubscriptionRequest;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "allowsNewsletters", BuildConfig.FLAVOR, "allowsPromotions", "source", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEmail", "()Ljava/lang/String;", "getAllowsNewsletters", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowsPromotions", "getSource", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Ldk/molslinjen/api/services/newsletters/request/NewsletterUpdateSubscriptionRequest;", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class NewsletterUpdateSubscriptionRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean allowsNewsletters;
    private final Boolean allowsPromotions;
    private final String email;
    private final String source;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/newsletters/request/NewsletterUpdateSubscriptionRequest$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/newsletters/request/NewsletterUpdateSubscriptionRequest;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<NewsletterUpdateSubscriptionRequest> serializer() {
            return NewsletterUpdateSubscriptionRequest$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ NewsletterUpdateSubscriptionRequest(int i5, String str, Boolean bool, Boolean bool2, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, NewsletterUpdateSubscriptionRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.email = str;
        this.allowsNewsletters = bool;
        this.allowsPromotions = bool2;
        if ((i5 & 8) == 0) {
            this.source = "app";
        } else {
            this.source = str2;
        }
    }

    public static /* synthetic */ NewsletterUpdateSubscriptionRequest copy$default(NewsletterUpdateSubscriptionRequest newsletterUpdateSubscriptionRequest, String str, Boolean bool, Boolean bool2, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = newsletterUpdateSubscriptionRequest.email;
        }
        if ((i5 & 2) != 0) {
            bool = newsletterUpdateSubscriptionRequest.allowsNewsletters;
        }
        if ((i5 & 4) != 0) {
            bool2 = newsletterUpdateSubscriptionRequest.allowsPromotions;
        }
        if ((i5 & 8) != 0) {
            str2 = newsletterUpdateSubscriptionRequest.source;
        }
        return newsletterUpdateSubscriptionRequest.copy(str, bool, bool2, str2);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(NewsletterUpdateSubscriptionRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.email);
        BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 1, booleanSerializer, self.allowsNewsletters);
        output.encodeNullableSerializableElement(serialDesc, 2, booleanSerializer, self.allowsPromotions);
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.source, "app")) {
            return;
        }
        output.encodeStringElement(serialDesc, 3, self.source);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getAllowsNewsletters() {
        return this.allowsNewsletters;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getAllowsPromotions() {
        return this.allowsPromotions;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    public final NewsletterUpdateSubscriptionRequest copy(String email, Boolean allowsNewsletters, Boolean allowsPromotions, String source) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(source, "source");
        return new NewsletterUpdateSubscriptionRequest(email, allowsNewsletters, allowsPromotions, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewsletterUpdateSubscriptionRequest)) {
            return false;
        }
        NewsletterUpdateSubscriptionRequest newsletterUpdateSubscriptionRequest = (NewsletterUpdateSubscriptionRequest) other;
        return Intrinsics.areEqual(this.email, newsletterUpdateSubscriptionRequest.email) && Intrinsics.areEqual(this.allowsNewsletters, newsletterUpdateSubscriptionRequest.allowsNewsletters) && Intrinsics.areEqual(this.allowsPromotions, newsletterUpdateSubscriptionRequest.allowsPromotions) && Intrinsics.areEqual(this.source, newsletterUpdateSubscriptionRequest.source);
    }

    public final Boolean getAllowsNewsletters() {
        return this.allowsNewsletters;
    }

    public final Boolean getAllowsPromotions() {
        return this.allowsPromotions;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        int hashCode = this.email.hashCode() * 31;
        Boolean bool = this.allowsNewsletters;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.allowsPromotions;
        return ((hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "NewsletterUpdateSubscriptionRequest(email=" + this.email + ", allowsNewsletters=" + this.allowsNewsletters + ", allowsPromotions=" + this.allowsPromotions + ", source=" + this.source + ")";
    }

    public NewsletterUpdateSubscriptionRequest(String email, Boolean bool, Boolean bool2, String source) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(source, "source");
        this.email = email;
        this.allowsNewsletters = bool;
        this.allowsPromotions = bool2;
        this.source = source;
    }

    public /* synthetic */ NewsletterUpdateSubscriptionRequest(String str, Boolean bool, Boolean bool2, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bool, bool2, (i5 & 8) != 0 ? "app" : str2);
    }
}
