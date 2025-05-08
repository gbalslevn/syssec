package androidx.compose.ui.modifier;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H \u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\r\u001a\u00020\n2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H \u0002¢\u0006\u0004\b\u000b\u0010\f\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalMap;", BuildConfig.FLAVOR, "<init>", "()V", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "key", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "get", BuildConfig.FLAVOR, "contains$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Z", "contains", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "Landroidx/compose/ui/modifier/EmptyMap;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ModifierLocalMap {
    public /* synthetic */ ModifierLocalMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean contains$ui_release(ModifierLocal<?> key);

    public abstract <T> T get$ui_release(ModifierLocal<T> key);

    private ModifierLocalMap() {
    }
}
