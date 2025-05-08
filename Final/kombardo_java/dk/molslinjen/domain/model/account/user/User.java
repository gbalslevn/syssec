package dk.molslinjen.domain.model.account.user;

import dk.molslinjen.domain.model.account.user.User;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0003\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/model/account/user/User;", BuildConfig.FLAVOR, "<init>", "()V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "details", "Ldk/molslinjen/domain/model/account/user/UserInfo;", "getDetails", "()Ldk/molslinjen/domain/model/account/user/UserInfo;", "userId", BuildConfig.FLAVOR, "getUserId", "()Ljava/lang/String;", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Ldk/molslinjen/domain/model/account/user/AccountUser;", "Ldk/molslinjen/domain/model/account/user/LocalUser;", "Ldk/molslinjen/domain/model/account/user/Uninitialized;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public abstract class User {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: J1.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = User._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/account/user/User$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/domain/model/account/user/User;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) User.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<User> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ User(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("dk.molslinjen.domain.model.account.user.User", Reflection.getOrCreateKotlinClass(User.class), new KClass[]{Reflection.getOrCreateKotlinClass(AccountUser.class), Reflection.getOrCreateKotlinClass(LocalUser.class)}, new KSerializer[]{AccountUser$$serializer.INSTANCE, LocalUser$$serializer.INSTANCE}, new Annotation[0]);
    }

    public static final /* synthetic */ void write$Self(User self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    public final UserInfo getDetails() {
        if (this instanceof LocalUser) {
            return ((LocalUser) this).getUserInfo();
        }
        if (this instanceof AccountUser) {
            return ((AccountUser) this).getUserInfo();
        }
        if (Intrinsics.areEqual(this, Uninitialized.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getUserId() {
        if (this instanceof AccountUser) {
            return ((AccountUser) this).getId();
        }
        if ((this instanceof LocalUser) || Intrinsics.areEqual(this, Uninitialized.INSTANCE)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private User() {
    }

    public /* synthetic */ User(int i5, SerializationConstructorMarker serializationConstructorMarker) {
    }
}
