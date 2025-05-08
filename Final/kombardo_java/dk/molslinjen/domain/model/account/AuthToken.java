package dk.molslinjen.domain.model.account;

import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/model/account/AuthToken;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "toDTO", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "toDTO-impl", "(Ljava/lang/String;)Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "equals", BuildConfig.FLAVOR, "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", BuildConfig.FLAVOR, "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "$serializer", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class AuthToken {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/account/AuthToken$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/domain/model/account/AuthToken;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<AuthToken> serializer() {
            return AuthToken$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ AuthToken(String str) {
        this.value = str;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AuthToken m3209boximpl(String str) {
        return new AuthToken(str);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static String m3210constructorimpl(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3211equalsimpl(String str, Object obj) {
        return (obj instanceof AuthToken) && Intrinsics.areEqual(str, ((AuthToken) obj).m3216unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3212equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3213hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toDTO-impl, reason: not valid java name */
    public static final AuthTokenDTO m3214toDTOimpl(String str) {
        return new AuthTokenDTO(str);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3215toStringimpl(String str) {
        return "AuthToken(value=" + str + ")";
    }

    public boolean equals(Object obj) {
        return m3211equalsimpl(this.value, obj);
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return m3213hashCodeimpl(this.value);
    }

    public String toString() {
        return m3215toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m3216unboximpl() {
        return this.value;
    }
}
