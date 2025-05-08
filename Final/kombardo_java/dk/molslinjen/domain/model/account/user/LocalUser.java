package dk.molslinjen.domain.model.account.user;

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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/model/account/user/LocalUser;", "Ldk/molslinjen/domain/model/account/user/User;", "userInfo", "Ldk/molslinjen/domain/model/account/user/UserInfo;", "<init>", "(Ldk/molslinjen/domain/model/account/user/UserInfo;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdk/molslinjen/domain/model/account/user/UserInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUserInfo", "()Ldk/molslinjen/domain/model/account/user/UserInfo;", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "$serializer", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class LocalUser extends User {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final UserInfo userInfo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/account/user/LocalUser$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/domain/model/account/user/LocalUser;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<LocalUser> serializer() {
            return LocalUser$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalUser(int i5, UserInfo userInfo, SerializationConstructorMarker serializationConstructorMarker) {
        super(i5, serializationConstructorMarker);
        if (1 != (i5 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1, LocalUser$$serializer.INSTANCE.getDescriptor());
        }
        this.userInfo = userInfo;
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(LocalUser self, CompositeEncoder output, SerialDescriptor serialDesc) {
        User.write$Self(self, output, serialDesc);
        output.encodeSerializableElement(serialDesc, 0, UserInfo$$serializer.INSTANCE, self.userInfo);
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalUser(UserInfo userInfo) {
        super(null);
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        this.userInfo = userInfo;
    }
}
