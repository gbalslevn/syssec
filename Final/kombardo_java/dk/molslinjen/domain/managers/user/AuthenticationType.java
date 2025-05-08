package dk.molslinjen.domain.managers.user;

import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005Jp\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00002\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086@¢\u0006\u0002\u0010\u000e\u0082\u0001\u0003\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/domain/managers/user/AuthenticationType;", BuildConfig.FLAVOR, "<init>", "()V", "isAuthenticated", BuildConfig.FLAVOR, "onNewAuthenticationType", BuildConfig.FLAVOR, "newType", "onLoggedOut", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "onLoggedIn", "onChangedAccount", "(Ldk/molslinjen/domain/managers/user/AuthenticationType;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "None", "User", "Company", "Ldk/molslinjen/domain/managers/user/AuthenticationType$Company;", "Ldk/molslinjen/domain/managers/user/AuthenticationType$None;", "Ldk/molslinjen/domain/managers/user/AuthenticationType$User;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AuthenticationType {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/domain/managers/user/AuthenticationType$Company;", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Company extends AuthenticationType {
        private final String id;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Company(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Company) && Intrinsics.areEqual(this.id, ((Company) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "Company(id=" + this.id + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/managers/user/AuthenticationType$None;", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class None extends AuthenticationType {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof None);
        }

        public int hashCode() {
            return 542948331;
        }

        public String toString() {
            return "None";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/managers/user/AuthenticationType$User;", "Ldk/molslinjen/domain/managers/user/AuthenticationType;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class User extends AuthenticationType {
        public static final User INSTANCE = new User();

        private User() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof User);
        }

        public int hashCode() {
            return 543160446;
        }

        public String toString() {
            return "User";
        }
    }

    public /* synthetic */ AuthenticationType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean isAuthenticated() {
        return !Intrinsics.areEqual(this, None.INSTANCE);
    }

    public final Object onNewAuthenticationType(AuthenticationType authenticationType, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Function1<? super Continuation<? super Unit>, ? extends Object> function13, Continuation<? super Unit> continuation) {
        Object invoke;
        boolean z5 = this instanceof None;
        boolean z6 = false;
        boolean z7 = !z5 && (authenticationType instanceof None);
        boolean z8 = z5 && !(authenticationType instanceof None);
        if (!z5 && !(authenticationType instanceof None) && !Intrinsics.areEqual(this, authenticationType)) {
            z6 = true;
        }
        if (z7) {
            Object invoke2 = function1.invoke(continuation);
            return invoke2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke2 : Unit.INSTANCE;
        }
        if (!z8) {
            return (z6 && (invoke = function13.invoke(continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? invoke : Unit.INSTANCE;
        }
        Object invoke3 = function12.invoke(continuation);
        return invoke3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke3 : Unit.INSTANCE;
    }

    private AuthenticationType() {
    }
}
