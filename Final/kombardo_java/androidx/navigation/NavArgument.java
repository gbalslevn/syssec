package androidx.navigation;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001'B;\b\u0000\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001f\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\u0005\u0010 R\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b!\u0010 R\u001a\u0010\"\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010 R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/navigation/NavArgument;", BuildConfig.FLAVOR, "Landroidx/navigation/NavType;", "type", BuildConfig.FLAVOR, "isNullable", "defaultValue", "defaultValuePresent", "unknownDefaultValuePresent", "<init>", "(Landroidx/navigation/NavType;ZLjava/lang/Object;ZZ)V", BuildConfig.FLAVOR, "name", "Landroid/os/Bundle;", "bundle", BuildConfig.FLAVOR, "putDefaultValue", "(Ljava/lang/String;Landroid/os/Bundle;)V", "verify", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "Landroidx/navigation/NavType;", "getType", "()Landroidx/navigation/NavType;", "Z", "()Z", "isDefaultValuePresent", "isDefaultValueUnknown", "isDefaultValueUnknown$navigation_common_release", "Ljava/lang/Object;", "getDefaultValue", "()Ljava/lang/Object;", "Builder", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavArgument {
    private final Object defaultValue;
    private final boolean isDefaultValuePresent;
    private final boolean isDefaultValueUnknown;
    private final boolean isNullable;
    private final NavType<Object> type;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavArgument$Builder;", BuildConfig.FLAVOR, "<init>", "()V", "T", "Landroidx/navigation/NavType;", "type", "setType", "(Landroidx/navigation/NavType;)Landroidx/navigation/NavArgument$Builder;", BuildConfig.FLAVOR, "isNullable", "setIsNullable", "(Z)Landroidx/navigation/NavArgument$Builder;", "defaultValue", "setDefaultValue", "(Ljava/lang/Object;)Landroidx/navigation/NavArgument$Builder;", "Landroidx/navigation/NavArgument;", "build", "()Landroidx/navigation/NavArgument;", "Landroidx/navigation/NavType;", "Z", "Ljava/lang/Object;", "defaultValuePresent", "unknownDefaultValuePresent", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private Object defaultValue;
        private boolean defaultValuePresent;
        private boolean isNullable;
        private NavType<Object> type;
        private boolean unknownDefaultValuePresent;

        public final NavArgument build() {
            NavType<Object> navType = this.type;
            if (navType == null) {
                navType = NavType.INSTANCE.inferFromValueType(this.defaultValue);
                Intrinsics.checkNotNull(navType, "null cannot be cast to non-null type androidx.navigation.NavType<kotlin.Any?>");
            }
            return new NavArgument(navType, this.isNullable, this.defaultValue, this.defaultValuePresent, this.unknownDefaultValuePresent);
        }

        public final Builder setDefaultValue(Object defaultValue) {
            this.defaultValue = defaultValue;
            this.defaultValuePresent = true;
            return this;
        }

        public final Builder setIsNullable(boolean isNullable) {
            this.isNullable = isNullable;
            return this;
        }

        public final <T> Builder setType(NavType<T> type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            return this;
        }
    }

    public NavArgument(NavType<Object> type, boolean z5, Object obj, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!type.getIsNullableAllowed() && z5) {
            throw new IllegalArgumentException((type.getName() + " does not allow nullable values").toString());
        }
        if (!z5 && z6 && obj == null) {
            throw new IllegalArgumentException(("Argument with type " + type.getName() + " has null value but is not nullable.").toString());
        }
        this.type = type;
        this.isNullable = z5;
        this.defaultValue = obj;
        this.isDefaultValuePresent = z6 || z7;
        this.isDefaultValueUnknown = z7;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(NavArgument.class, other.getClass())) {
            return false;
        }
        NavArgument navArgument = (NavArgument) other;
        if (this.isNullable != navArgument.isNullable || this.isDefaultValuePresent != navArgument.isDefaultValuePresent || !Intrinsics.areEqual(this.type, navArgument.type)) {
            return false;
        }
        Object obj = this.defaultValue;
        return obj != null ? Intrinsics.areEqual(obj, navArgument.defaultValue) : navArgument.defaultValue == null;
    }

    public final NavType<Object> getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((this.type.hashCode() * 31) + (this.isNullable ? 1 : 0)) * 31) + (this.isDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.defaultValue;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    /* renamed from: isDefaultValuePresent, reason: from getter */
    public final boolean getIsDefaultValuePresent() {
        return this.isDefaultValuePresent;
    }

    /* renamed from: isDefaultValueUnknown$navigation_common_release, reason: from getter */
    public final boolean getIsDefaultValueUnknown() {
        return this.isDefaultValueUnknown;
    }

    /* renamed from: isNullable, reason: from getter */
    public final boolean getIsNullable() {
        return this.isNullable;
    }

    public final void putDefaultValue(String name, Bundle bundle) {
        Object obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!this.isDefaultValuePresent || (obj = this.defaultValue) == null) {
            return;
        }
        this.type.put(bundle, name, obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NavArgument.class.getSimpleName());
        sb.append(" Type: " + this.type);
        sb.append(" Nullable: " + this.isNullable);
        if (this.isDefaultValuePresent) {
            sb.append(" DefaultValue: " + this.defaultValue);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public final boolean verify(String name, Bundle bundle) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!this.isNullable && bundle.containsKey(name) && bundle.get(name) == null) {
            return false;
        }
        try {
            this.type.get(bundle, name);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
