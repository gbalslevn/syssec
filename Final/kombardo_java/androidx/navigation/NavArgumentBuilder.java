package androidx.navigation;

import androidx.navigation.NavArgument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R,\u0010\"\u001a\u0006\u0012\u0002\b\u00030\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/navigation/NavArgumentBuilder;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/navigation/NavArgument;", "build", "()Landroidx/navigation/NavArgument;", "Landroidx/navigation/NavArgument$Builder;", "builder", "Landroidx/navigation/NavArgument$Builder;", "Landroidx/navigation/NavType;", "_type", "Landroidx/navigation/NavType;", BuildConfig.FLAVOR, "value", "nullable", "Z", "getNullable", "()Z", "setNullable", "(Z)V", "defaultValue", "Ljava/lang/Object;", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "unknownDefaultValuePresent", "getUnknownDefaultValuePresent$navigation_common_release", "setUnknownDefaultValuePresent$navigation_common_release", "getType", "()Landroidx/navigation/NavType;", "setType", "(Landroidx/navigation/NavType;)V", "type", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavArgumentBuilder {
    private NavType<?> _type;
    private final NavArgument.Builder builder = new NavArgument.Builder();
    private Object defaultValue;
    private boolean nullable;
    private boolean unknownDefaultValuePresent;

    public final NavArgument build() {
        return this.builder.build();
    }

    public final void setDefaultValue(Object obj) {
        this.defaultValue = obj;
        this.builder.setDefaultValue(obj);
    }

    public final void setNullable(boolean z5) {
        this.nullable = z5;
        this.builder.setIsNullable(z5);
    }

    public final void setType(NavType<?> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._type = value;
        this.builder.setType(value);
    }
}
