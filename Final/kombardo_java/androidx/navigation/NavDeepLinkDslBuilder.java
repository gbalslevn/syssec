package androidx.navigation;

import androidx.navigation.NavDeepLink;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u0006!"}, d2 = {"Landroidx/navigation/NavDeepLinkDslBuilder;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/navigation/NavDeepLink;", "build$navigation_common_release", "()Landroidx/navigation/NavDeepLink;", "build", "Landroidx/navigation/NavDeepLink$Builder;", "builder", "Landroidx/navigation/NavDeepLink$Builder;", "Lkotlin/reflect/KClass;", "route", "Lkotlin/reflect/KClass;", BuildConfig.FLAVOR, "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "typeMap", "Ljava/util/Map;", BuildConfig.FLAVOR, "uriPattern", "Ljava/lang/String;", "getUriPattern", "()Ljava/lang/String;", "setUriPattern", "(Ljava/lang/String;)V", "p", "action", "getAction", "setAction", "mimeType", "getMimeType", "setMimeType", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavDeepLinkDslBuilder {
    private String action;
    private String mimeType;
    private KClass<?> route;
    private String uriPattern;
    private final NavDeepLink.Builder builder = new NavDeepLink.Builder();
    private Map<KType, ? extends NavType<?>> typeMap = MapsKt.emptyMap();

    public final NavDeepLink build$navigation_common_release() {
        NavDeepLink.Builder builder = this.builder;
        String str = this.uriPattern;
        if (str == null && this.action == null && this.mimeType == null) {
            throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.");
        }
        if (str != null) {
            builder.setUriPattern(str);
        }
        String str2 = this.action;
        if (str2 != null) {
            builder.setAction(str2);
        }
        String str3 = this.mimeType;
        if (str3 != null) {
            builder.setMimeType(str3);
        }
        return builder.build();
    }

    public final void setUriPattern(String str) {
        this.uriPattern = str;
    }
}
