package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.a;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDeepLink;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 i2\u00020\u0001:\u0002ijB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0004\b\u0004\u0010\bJ5\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u0015H\u0017¢\u0006\u0004\b!\u0010\"J\u001b\u0010%\u001a\u00020$2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0010H\u0017¢\u0006\u0004\b*\u0010+J\u001f\u00100\u001a\u00020\u00192\b\b\u0001\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u001d\u00104\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u00105J\u001b\u00107\u001a\u0004\u0018\u00010'2\b\u00106\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0002H\u0016¢\u0006\u0004\b9\u0010:J\u001a\u0010<\u001a\u00020\u00102\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020,H\u0016¢\u0006\u0004\b>\u0010?R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010@\u001a\u0004\bA\u0010:R.\u0010D\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010B8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010@R$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020.0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR,\u0010[\u001a\u00020,2\b\b\u0001\u0010[\u001a\u00020,8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010?\"\u0004\b^\u0010_R.\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010@\u001a\u0004\b`\u0010:\"\u0004\ba\u0010\u0005R\u001e\u0010c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0014\u0010h\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010:¨\u0006k"}, d2 = {"Landroidx/navigation/NavDestination;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "navigatorName", "<init>", "(Ljava/lang/String;)V", "Landroidx/navigation/Navigator;", "navigator", "(Landroidx/navigation/Navigator;)V", "Landroidx/navigation/NavDeepLink;", "deepLink", "Landroid/net/Uri;", "uri", BuildConfig.FLAVOR, "Landroidx/navigation/NavArgument;", "arguments", BuildConfig.FLAVOR, "hasRequiredArguments", "(Landroidx/navigation/NavDeepLink;Landroid/net/Uri;Ljava/util/Map;)Z", "hasDeepLink", "(Landroid/net/Uri;)Z", "Landroidx/navigation/NavDeepLinkRequest;", "deepLinkRequest", "(Landroidx/navigation/NavDeepLinkRequest;)Z", "navDeepLink", BuildConfig.FLAVOR, "addDeepLink", "(Landroidx/navigation/NavDeepLink;)V", "route", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchRoute", "(Ljava/lang/String;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "matchDeepLink", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "previousDestination", BuildConfig.FLAVOR, "buildDeepLinkIds", "(Landroidx/navigation/NavDestination;)[I", "Landroid/os/Bundle;", "hasRoute", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "supportsActions", "()Z", BuildConfig.FLAVOR, "actionId", "Landroidx/navigation/NavAction;", "action", "putAction", "(ILandroidx/navigation/NavAction;)V", "argumentName", "argument", "addArgument", "(Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "args", "addInDefaultArgs", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getNavigatorName", "Landroidx/navigation/NavGraph;", "<set-?>", "parent", "Landroidx/navigation/NavGraph;", "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "idName", BuildConfig.FLAVOR, "label", "Ljava/lang/CharSequence;", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", BuildConfig.FLAVOR, "deepLinks", "Ljava/util/List;", "Landroidx/collection/SparseArrayCompat;", "actions", "Landroidx/collection/SparseArrayCompat;", BuildConfig.FLAVOR, "_arguments", "Ljava/util/Map;", Constants.ID_ATTRIBUTE_KEY, "I", "getId", "setId", "(I)V", "getRoute", "setRoute", "Lkotlin/Lazy;", "routeDeepLink", "Lkotlin/Lazy;", "getArguments", "()Ljava/util/Map;", "getDisplayName", "displayName", "Companion", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NavDestination {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Class<?>> classes = new LinkedHashMap();
    private Map<String, NavArgument> _arguments;
    private final SparseArrayCompat<NavAction> actions;
    private final List<NavDeepLink> deepLinks;
    private int id;
    private String idName;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;
    private String route;
    private Lazy<NavDeepLink> routeDeepLink;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000f*\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "getDisplayName", "(Landroid/content/Context;I)Ljava/lang/String;", "route", "createRoute", "(Ljava/lang/String;)Ljava/lang/String;", "Landroidx/navigation/NavDestination;", "Lkotlin/sequences/Sequence;", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "hierarchy", BuildConfig.FLAVOR, "Ljava/lang/Class;", "classes", "Ljava/util/Map;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String createRoute(String route) {
            if (route == null) {
                return BuildConfig.FLAVOR;
            }
            return "android-app://androidx.navigation/" + route;
        }

        public final String getDisplayName(Context context, int r32) {
            String valueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            if (r32 <= 16777215) {
                return String.valueOf(r32);
            }
            try {
                valueOf = context.getResources().getResourceName(r32);
            } catch (Resources.NotFoundException unused) {
                valueOf = String.valueOf(r32);
            }
            Intrinsics.checkNotNullExpressionValue(valueOf, "try {\n                  …tring()\n                }");
            return valueOf;
        }

        public final Sequence<NavDestination> getHierarchy(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "<this>");
            return SequencesKt.generateSequence(navDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavDestination$Companion$hierarchy$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getParent();
                }
            });
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", BuildConfig.FLAVOR, "destination", "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "isExactDeepLink", BuildConfig.FLAVOR, "matchingPathSegments", BuildConfig.FLAVOR, "hasMatchingAction", "mimeTypeMatchLevel", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZIZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", "other", "hasMatchingArgs", "arguments", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination destination, Bundle bundle, boolean z5, int i5, boolean z6, int i6) {
            Intrinsics.checkNotNullParameter(destination, "destination");
            this.destination = destination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z5;
            this.matchingPathSegments = i5;
            this.hasMatchingAction = z6;
            this.mimeTypeMatchLevel = i6;
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }

        public final boolean hasMatchingArgs(Bundle arguments) {
            Bundle bundle;
            Object obj;
            if (arguments == null || (bundle = this.matchingArgs) == null) {
                return false;
            }
            Set<String> keySet = bundle.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "matchingArgs.keySet()");
            for (String key : keySet) {
                if (!arguments.containsKey(key)) {
                    return false;
                }
                NavArgument navArgument = (NavArgument) this.destination._arguments.get(key);
                Object obj2 = null;
                NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                if (type != null) {
                    Bundle bundle2 = this.matchingArgs;
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    obj = type.get(bundle2, key);
                } else {
                    obj = null;
                }
                if (type != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    obj2 = type.get(arguments, key);
                }
                if (type != null && !type.valueEquals(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(DeepLinkMatch other) {
            Intrinsics.checkNotNullParameter(other, "other");
            boolean z5 = this.isExactDeepLink;
            if (z5 && !other.isExactDeepLink) {
                return 1;
            }
            if (!z5 && other.isExactDeepLink) {
                return -1;
            }
            int i5 = this.matchingPathSegments - other.matchingPathSegments;
            if (i5 > 0) {
                return 1;
            }
            if (i5 < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && other.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && other.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = other.matchingArgs;
                Intrinsics.checkNotNull(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z6 = this.hasMatchingAction;
            if (z6 && !other.hasMatchingAction) {
                return 1;
            }
            if (z6 || !other.hasMatchingAction) {
                return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
            }
            return -1;
        }
    }

    public NavDestination(String navigatorName) {
        Intrinsics.checkNotNullParameter(navigatorName, "navigatorName");
        this.navigatorName = navigatorName;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat<>(0, 1, null);
        this._arguments = new LinkedHashMap();
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i5 & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.buildDeepLinkIds(navDestination2);
    }

    private final boolean hasRequiredArguments(NavDeepLink deepLink, Uri uri, Map<String, NavArgument> arguments) {
        final Bundle matchingPathAndQueryArgs$navigation_common_release = deepLink.getMatchingPathAndQueryArgs$navigation_common_release(uri, arguments);
        return NavArgumentKt.missingRequiredArguments(arguments, new Function1<String, Boolean>() { // from class: androidx.navigation.NavDestination$hasRequiredArguments$missingRequiredArguments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Boolean.valueOf(!matchingPathAndQueryArgs$navigation_common_release.containsKey(key));
            }
        }).isEmpty();
    }

    public final void addArgument(String argumentName, NavArgument argument) {
        Intrinsics.checkNotNullParameter(argumentName, "argumentName");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this._arguments.put(argumentName, argument);
    }

    public final void addDeepLink(final NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new Function1<String, Boolean>() { // from class: androidx.navigation.NavDestination$addDeepLink$missingRequiredArguments$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return Boolean.valueOf(!NavDeepLink.this.getArgumentsNames$navigation_common_release().contains(key));
            }
        });
        if (missingRequiredArguments.isEmpty()) {
            this.deepLinks.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + missingRequiredArguments).toString());
    }

    public final Bundle addInDefaultArgs(Bundle args) {
        if (args == null && this._arguments.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, NavArgument> entry : this._arguments.entrySet()) {
            entry.getValue().putDefaultValue(entry.getKey(), bundle);
        }
        if (args != null) {
            bundle.putAll(args);
            for (Map.Entry<String, NavArgument> entry2 : this._arguments.entrySet()) {
                String key = entry2.getKey();
                NavArgument value = entry2.getValue();
                if (!value.getIsDefaultValueUnknown() && !value.verify(key, bundle)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + key + "' in argument bundle. " + value.getType().getName() + " expected.").toString());
                }
            }
        }
        return bundle;
    }

    public final int[] buildDeepLinkIds(NavDestination previousDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination = this;
        while (true) {
            Intrinsics.checkNotNull(navDestination);
            NavGraph navGraph = navDestination.parent;
            if ((previousDestination != null ? previousDestination.parent : null) != null) {
                NavGraph navGraph2 = previousDestination.parent;
                Intrinsics.checkNotNull(navGraph2);
                if (navGraph2.findNode(navDestination.id) == navDestination) {
                    arrayDeque.addFirst(navDestination);
                    break;
                }
            }
            if (navGraph == null || navGraph.getStartDestId() != navDestination.id) {
                arrayDeque.addFirst(navDestination);
            }
            if (Intrinsics.areEqual(navGraph, previousDestination) || navGraph == null) {
                break;
            }
            navDestination = navGraph;
        }
        List list = CollectionsKt.toList(arrayDeque);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((NavDestination) it.next()).id));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object other) {
        boolean z5;
        boolean z6;
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavDestination)) {
            return false;
        }
        NavDestination navDestination = (NavDestination) other;
        boolean areEqual = Intrinsics.areEqual(this.deepLinks, navDestination.deepLinks);
        if (this.actions.size() == navDestination.actions.size()) {
            Iterator it = SequencesKt.asSequence(SparseArrayKt.keyIterator(this.actions)).iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                if (!Intrinsics.areEqual(this.actions.get(intValue), navDestination.actions.get(intValue))) {
                }
            }
            z5 = true;
            if (this._arguments.size() == navDestination._arguments.size()) {
                for (Map.Entry entry : MapsKt.asSequence(this._arguments)) {
                    if (navDestination._arguments.containsKey(entry.getKey()) && Intrinsics.areEqual(navDestination._arguments.get(entry.getKey()), entry.getValue())) {
                    }
                }
                z6 = true;
                return this.id != navDestination.id && Intrinsics.areEqual(this.route, navDestination.route) && areEqual && z5 && z6;
            }
            z6 = false;
            if (this.id != navDestination.id) {
            }
        }
        z5 = false;
        if (this._arguments.size() == navDestination._arguments.size()) {
        }
        z6 = false;
        if (this.id != navDestination.id) {
        }
    }

    public final Map<String, NavArgument> getArguments() {
        return MapsKt.toMap(this._arguments);
    }

    public String getDisplayName() {
        String str = this.idName;
        return str == null ? String.valueOf(this.id) : str;
    }

    public final int getId() {
        return this.id;
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final String getRoute() {
        return this.route;
    }

    public boolean hasDeepLink(Uri deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(deepLink, null, null));
    }

    public final boolean hasRoute(String route, Bundle arguments) {
        Intrinsics.checkNotNullParameter(route, "route");
        if (Intrinsics.areEqual(this.route, route)) {
            return true;
        }
        DeepLinkMatch matchRoute = matchRoute(route);
        if (Intrinsics.areEqual(this, matchRoute != null ? matchRoute.getDestination() : null)) {
            return matchRoute.hasMatchingArgs(arguments);
        }
        return false;
    }

    public int hashCode() {
        int i5 = this.id * 31;
        String str = this.route;
        int hashCode = i5 + (str != null ? str.hashCode() : 0);
        for (NavDeepLink navDeepLink : this.deepLinks) {
            int i6 = hashCode * 31;
            String uriPattern = navDeepLink.getUriPattern();
            int hashCode2 = (i6 + (uriPattern != null ? uriPattern.hashCode() : 0)) * 31;
            String action = navDeepLink.getAction();
            int hashCode3 = (hashCode2 + (action != null ? action.hashCode() : 0)) * 31;
            String mimeType = navDeepLink.getMimeType();
            hashCode = hashCode3 + (mimeType != null ? mimeType.hashCode() : 0);
        }
        Iterator valueIterator = SparseArrayKt.valueIterator(this.actions);
        if (valueIterator.hasNext()) {
            a.a(valueIterator.next());
            throw null;
        }
        for (String str2 : this._arguments.keySet()) {
            int hashCode4 = ((hashCode * 31) + str2.hashCode()) * 31;
            NavArgument navArgument = this._arguments.get(str2);
            hashCode = hashCode4 + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return hashCode;
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.deepLinks.isEmpty()) {
            return null;
        }
        DeepLinkMatch deepLinkMatch = null;
        for (NavDeepLink navDeepLink : this.deepLinks) {
            Uri uri = navDeepLinkRequest.getUri();
            if (navDeepLink.matches$navigation_common_release(navDeepLinkRequest)) {
                Bundle matchingArguments = uri != null ? navDeepLink.getMatchingArguments(uri, this._arguments) : null;
                int calculateMatchingPathSegments$navigation_common_release = navDeepLink.calculateMatchingPathSegments$navigation_common_release(uri);
                String action = navDeepLinkRequest.getAction();
                boolean z5 = action != null && Intrinsics.areEqual(action, navDeepLink.getAction());
                String mimeType = navDeepLinkRequest.getMimeType();
                int mimeTypeMatchRating = mimeType != null ? navDeepLink.getMimeTypeMatchRating(mimeType) : -1;
                if (matchingArguments == null) {
                    if (z5 || mimeTypeMatchRating > -1) {
                        if (hasRequiredArguments(navDeepLink, uri, this._arguments)) {
                        }
                    }
                }
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, matchingArguments, navDeepLink.getIsExactDeepLink(), calculateMatchingPathSegments$navigation_common_release, z5, mimeTypeMatchRating);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
        }
        return deepLinkMatch;
    }

    public final DeepLinkMatch matchRoute(String route) {
        NavDeepLink value;
        Intrinsics.checkNotNullParameter(route, "route");
        Lazy<NavDeepLink> lazy = this.routeDeepLink;
        if (lazy == null || (value = lazy.getValue()) == null) {
            return null;
        }
        Uri parse = Uri.parse(INSTANCE.createRoute(route));
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        Bundle matchingArguments = value.getMatchingArguments(parse, this._arguments);
        if (matchingArguments == null) {
            return null;
        }
        return new DeepLinkMatch(this, matchingArguments, value.getIsExactDeepLink(), value.calculateMatchingPathSegments$navigation_common_release(parse), false, -1);
    }

    public final void putAction(int actionId, NavAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (supportsActions()) {
            if (actionId == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            this.actions.put(actionId, action);
        } else {
            throw new UnsupportedOperationException("Cannot add action " + actionId + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
    }

    public final void setId(int i5) {
        this.id = i5;
        this.idName = null;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    public final void setParent(NavGraph navGraph) {
        this.parent = navGraph;
    }

    public final void setRoute(String str) {
        if (str == null) {
            setId(0);
        } else {
            if (StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot have an empty route");
            }
            final String createRoute = INSTANCE.createRoute(str);
            final NavDeepLink build = new NavDeepLink.Builder().setUriPattern(createRoute).build();
            List<String> missingRequiredArguments = NavArgumentKt.missingRequiredArguments(this._arguments, new Function1<String, Boolean>() { // from class: androidx.navigation.NavDestination$route$missingRequiredArguments$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String key) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    return Boolean.valueOf(!NavDeepLink.this.getArgumentsNames$navigation_common_release().contains(key));
                }
            });
            if (!missingRequiredArguments.isEmpty()) {
                throw new IllegalArgumentException(("Cannot set route \"" + str + "\" for destination " + this + ". Following required arguments are missing: " + missingRequiredArguments).toString());
            }
            this.routeDeepLink = LazyKt.lazy(new Function0<NavDeepLink>() { // from class: androidx.navigation.NavDestination$route$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final NavDeepLink invoke() {
                    return new NavDeepLink.Builder().setUriPattern(createRoute).build();
                }
            });
            setId(createRoute.hashCode());
        }
        this.route = str;
    }

    public boolean supportsActions() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.idName;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.id));
        } else {
            sb.append(str);
        }
        sb.append(")");
        String str2 = this.route;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            sb.append(" route=");
            sb.append(this.route);
        }
        if (this.label != null) {
            sb.append(" label=");
            sb.append(this.label);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public boolean hasDeepLink(NavDeepLinkRequest deepLinkRequest) {
        Intrinsics.checkNotNullParameter(deepLinkRequest, "deepLinkRequest");
        return matchDeepLink(deepLinkRequest) != null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.INSTANCE.getNameForNavigator$navigation_common_release(navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }
}
