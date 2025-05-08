package androidx.navigation;

import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.navigation.NavDestination;
import androidx.navigation.serialization.RouteSerializerKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 P2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001PB\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010 \u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J9\u0010#\u001a\u0004\u0018\u00010\u00012\b\b\u0001\u0010\u001f\u001a\u00020\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b#\u0010$J\u0019\u0010 \u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b \u0010%J!\u0010 \u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\tH\u0007¢\u0006\u0004\b \u0010'J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010(H\u0086\u0002¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010-J\u0015\u0010,\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0007¢\u0006\u0004\b,\u0010/J\u001f\u0010,\u001a\u00020\u0017\"\b\b\u0000\u00101*\u0002002\u0006\u0010.\u001a\u00028\u0000¢\u0006\u0004\b,\u00102J7\u0010,\u001a\u00020\u0017\"\u0004\b\u0000\u001012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000705H\u0007¢\u0006\u0004\b,\u00107J\u000f\u00108\u001a\u00020\u0007H\u0016¢\u0006\u0004\b8\u00109J\u001a\u0010;\u001a\u00020\t2\b\u0010:\u001a\u0004\u0018\u000100H\u0096\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u001eH\u0016¢\u0006\u0004\b=\u0010>R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010?8G¢\u0006\f\n\u0004\b\u001b\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER.\u0010F\u001a\u0004\u0018\u00010\u00072\b\u0010.\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010E\u001a\u0004\bG\u00109\"\u0004\bH\u0010/R$\u0010K\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001e8G@BX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010>\"\u0004\bJ\u0010-R\u0014\u0010M\u001a\u00020\u00078WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u00109R\u0011\u0010O\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\bN\u00109¨\u0006Q"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", BuildConfig.FLAVOR, "Landroidx/navigation/Navigator;", "navGraphNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", BuildConfig.FLAVOR, "route", BuildConfig.FLAVOR, "searchChildren", "searchParent", "lastVisited", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchRouteComprehensive", "(Ljava/lang/String;ZZLandroidx/navigation/NavDestination;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "Landroidx/navigation/NavDeepLinkRequest;", "navDeepLinkRequest", "matchDeepLinkComprehensive", "(Landroidx/navigation/NavDeepLinkRequest;ZZLandroidx/navigation/NavDestination;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchDeepLink", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "node", BuildConfig.FLAVOR, "addDestination", "(Landroidx/navigation/NavDestination;)V", BuildConfig.FLAVOR, "nodes", "addDestinations", "(Ljava/util/Collection;)V", BuildConfig.FLAVOR, "resId", "findNode", "(I)Landroidx/navigation/NavDestination;", "matchingDest", "findNodeComprehensive", "(ILandroidx/navigation/NavDestination;ZLandroidx/navigation/NavDestination;)Landroidx/navigation/NavDestination;", "(Ljava/lang/String;)Landroidx/navigation/NavDestination;", "searchParents", "(Ljava/lang/String;Z)Landroidx/navigation/NavDestination;", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "startDestId", "setStartDestination", "(I)V", "startDestRoute", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "T", "(Ljava/lang/Object;)V", "Lkotlinx/serialization/KSerializer;", "serializer", "Lkotlin/Function1;", "parseRoute", "(Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;)V", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/SparseArrayCompat;", "getNodes", "()Landroidx/collection/SparseArrayCompat;", "I", "startDestIdName", "Ljava/lang/String;", "startDestinationRoute", "getStartDestinationRoute", "setStartDestinationRoute", "getStartDestinationId", "setStartDestinationId", "startDestinationId", "getDisplayName", "displayName", "getStartDestDisplayName", "startDestDisplayName", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SparseArrayCompat<NavDestination> nodes;
    private int startDestId;
    private String startDestIdName;
    private String startDestinationRoute;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0007J\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", BuildConfig.FLAVOR, "()V", "childHierarchy", "Lkotlin/sequences/Sequence;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "findStartDestination", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Sequence<NavDestination> childHierarchy(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return SequencesKt.generateSequence(navGraph, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavGraph$Companion$childHierarchy$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!(it instanceof NavGraph)) {
                        return null;
                    }
                    NavGraph navGraph2 = (NavGraph) it;
                    return navGraph2.findNode(navGraph2.getStartDestId());
                }
            });
        }

        public final NavDestination findStartDestination(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "<this>");
            return (NavDestination) SequencesKt.last(childHierarchy(navGraph));
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator<? extends NavGraph> navGraphNavigator) {
        super(navGraphNavigator);
        Intrinsics.checkNotNullParameter(navGraphNavigator, "navGraphNavigator");
        this.nodes = new SparseArrayCompat<>(0, 1, null);
    }

    public static /* synthetic */ NavDestination findNodeComprehensive$default(NavGraph navGraph, int i5, NavDestination navDestination, boolean z5, NavDestination navDestination2, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findNodeComprehensive");
        }
        if ((i6 & 8) != 0) {
            navDestination2 = null;
        }
        return navGraph.findNodeComprehensive(i5, navDestination, z5, navDestination2);
    }

    private final void setStartDestinationId(int i5) {
        if (i5 != getId()) {
            if (this.startDestinationRoute != null) {
                setStartDestinationRoute(null);
            }
            this.startDestId = i5;
            this.startDestIdName = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i5 + " cannot use the same id as the graph " + this).toString());
    }

    private final void setStartDestinationRoute(String str) {
        int hashCode;
        if (str == null) {
            hashCode = 0;
        } else {
            if (Intrinsics.areEqual(str, getRoute())) {
                throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
            }
            if (StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot have an empty start destination route");
            }
            hashCode = NavDestination.INSTANCE.createRoute(str).hashCode();
        }
        this.startDestId = hashCode;
        this.startDestinationRoute = str;
    }

    public final void addDestination(NavDestination node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int id = node.getId();
        String route = node.getRoute();
        if (id == 0 && route == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        if (getRoute() != null && Intrinsics.areEqual(route, getRoute())) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same route as graph " + this).toString());
        }
        if (id == getId()) {
            throw new IllegalArgumentException(("Destination " + node + " cannot have the same id as graph " + this).toString());
        }
        NavDestination navDestination = this.nodes.get(id);
        if (navDestination == node) {
            return;
        }
        if (node.getParent() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (navDestination != null) {
            navDestination.setParent(null);
        }
        node.setParent(this);
        this.nodes.put(node.getId(), node);
    }

    public final void addDestinations(Collection<? extends NavDestination> nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        for (NavDestination navDestination : nodes) {
            if (navDestination != null) {
                addDestination(navDestination);
            }
        }
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavGraph)) {
            return false;
        }
        if (super.equals(other)) {
            NavGraph navGraph = (NavGraph) other;
            if (this.nodes.size() == navGraph.nodes.size() && getStartDestId() == navGraph.getStartDestId()) {
                for (NavDestination navDestination : SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes))) {
                    if (!Intrinsics.areEqual(navDestination, navGraph.nodes.get(navDestination.getId()))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final NavDestination findNode(int resId) {
        return findNodeComprehensive$default(this, resId, this, false, null, 8, null);
    }

    public final NavDestination findNodeComprehensive(int resId, NavDestination lastVisited, boolean searchChildren, NavDestination matchingDest) {
        NavDestination navDestination = this.nodes.get(resId);
        if (matchingDest != null) {
            if (Intrinsics.areEqual(navDestination, matchingDest) && Intrinsics.areEqual(navDestination.getParent(), matchingDest.getParent())) {
                return navDestination;
            }
            navDestination = null;
        } else if (navDestination != null) {
            return navDestination;
        }
        if (searchChildren) {
            Iterator it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    navDestination = null;
                    break;
                }
                NavDestination navDestination2 = (NavDestination) it.next();
                NavDestination findNodeComprehensive = (!(navDestination2 instanceof NavGraph) || Intrinsics.areEqual(navDestination2, lastVisited)) ? null : ((NavGraph) navDestination2).findNodeComprehensive(resId, this, true, matchingDest);
                if (findNodeComprehensive != null) {
                    navDestination = findNodeComprehensive;
                    break;
                }
            }
        }
        if (navDestination != null) {
            return navDestination;
        }
        if (getParent() == null || Intrinsics.areEqual(getParent(), lastVisited)) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNodeComprehensive(resId, this, searchChildren, matchingDest);
    }

    @Override // androidx.navigation.NavDestination
    public String getDisplayName() {
        return getId() != 0 ? super.getDisplayName() : "the root navigation";
    }

    public final SparseArrayCompat<NavDestination> getNodes() {
        return this.nodes;
    }

    public final String getStartDestDisplayName() {
        if (this.startDestIdName == null) {
            String str = this.startDestinationRoute;
            if (str == null) {
                str = String.valueOf(this.startDestId);
            }
            this.startDestIdName = str;
        }
        String str2 = this.startDestIdName;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    /* renamed from: getStartDestinationId, reason: from getter */
    public final int getStartDestId() {
        return this.startDestId;
    }

    public final String getStartDestinationRoute() {
        return this.startDestinationRoute;
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int startDestId = getStartDestId();
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        for (int i5 = 0; i5 < size; i5++) {
            startDestId = (((startDestId * 31) + sparseArrayCompat.keyAt(i5)) * 31) + sparseArrayCompat.valueAt(i5).hashCode();
        }
        return startDestId;
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new NavGraph$iterator$1(this);
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        return matchDeepLinkComprehensive(navDeepLinkRequest, true, false, this);
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive(NavDeepLinkRequest navDeepLinkRequest, boolean searchChildren, boolean searchParent, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "navDeepLinkRequest");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        NavDestination.DeepLinkMatch deepLinkMatch2 = null;
        if (searchChildren) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this) {
                NavDestination.DeepLinkMatch matchDeepLink2 = !Intrinsics.areEqual(navDestination, lastVisited) ? navDestination.matchDeepLink(navDeepLinkRequest) : null;
                if (matchDeepLink2 != null) {
                    arrayList.add(matchDeepLink2);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && searchParent && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatch2 = parent.matchDeepLinkComprehensive(navDeepLinkRequest, searchChildren, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{matchDeepLink, deepLinkMatch, deepLinkMatch2}));
    }

    public final NavDestination.DeepLinkMatch matchRouteComprehensive(String route, boolean searchChildren, boolean searchParent, NavDestination lastVisited) {
        NavDestination.DeepLinkMatch deepLinkMatch;
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(lastVisited, "lastVisited");
        NavDestination.DeepLinkMatch matchRoute = matchRoute(route);
        NavDestination.DeepLinkMatch deepLinkMatch2 = null;
        if (searchChildren) {
            ArrayList arrayList = new ArrayList();
            for (NavDestination navDestination : this) {
                NavDestination.DeepLinkMatch matchRouteComprehensive = Intrinsics.areEqual(navDestination, lastVisited) ? null : navDestination instanceof NavGraph ? ((NavGraph) navDestination).matchRouteComprehensive(route, true, false, this) : navDestination.matchRoute(route);
                if (matchRouteComprehensive != null) {
                    arrayList.add(matchRouteComprehensive);
                }
            }
            deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList);
        } else {
            deepLinkMatch = null;
        }
        NavGraph parent = getParent();
        if (parent != null && searchParent && !Intrinsics.areEqual(parent, lastVisited)) {
            deepLinkMatch2 = parent.matchRouteComprehensive(route, searchChildren, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{matchRoute, deepLinkMatch, deepLinkMatch2}));
    }

    public final void setStartDestination(int startDestId) {
        setStartDestinationId(startDestId);
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination findNode = findNode(this.startDestinationRoute);
        if (findNode == null) {
            findNode = findNode(getStartDestId());
        }
        sb.append(" startDestination=");
        if (findNode == null) {
            String str = this.startDestinationRoute;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.startDestIdName;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append("0x" + Integer.toHexString(this.startDestId));
                }
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public final NavDestination findNode(String route) {
        if (route == null || StringsKt.isBlank(route)) {
            return null;
        }
        return findNode(route, true);
    }

    public final void setStartDestination(String startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestinationRoute(startDestRoute);
    }

    public final NavDestination findNode(String route, boolean searchParents) {
        Object obj;
        Intrinsics.checkNotNullParameter(route, "route");
        Iterator it = SequencesKt.asSequence(SparseArrayKt.valueIterator(this.nodes)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            NavDestination navDestination = (NavDestination) obj;
            if (StringsKt.equals$default(navDestination.getRoute(), route, false, 2, null) || navDestination.matchRoute(route) != null) {
                break;
            }
        }
        NavDestination navDestination2 = (NavDestination) obj;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!searchParents || getParent() == null) {
            return null;
        }
        NavGraph parent = getParent();
        Intrinsics.checkNotNull(parent);
        return parent.findNode(route);
    }

    public final <T> void setStartDestination(final T startDestRoute) {
        Intrinsics.checkNotNullParameter(startDestRoute, "startDestRoute");
        setStartDestination(SerializersKt.serializer(Reflection.getOrCreateKotlinClass(startDestRoute.getClass())), new Function1<NavDestination, String>() { // from class: androidx.navigation.NavGraph$setStartDestination$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(NavDestination startDestination) {
                Intrinsics.checkNotNullParameter(startDestination, "startDestination");
                Map<String, NavArgument> arguments = startDestination.getArguments();
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(arguments.size()));
                Iterator<T> it = arguments.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), ((NavArgument) entry.getValue()).getType());
                }
                return RouteSerializerKt.generateRouteWithArgs(startDestRoute, linkedHashMap);
            }
        });
    }

    public final <T> void setStartDestination(KSerializer<T> serializer, Function1<? super NavDestination, String> parseRoute) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(parseRoute, "parseRoute");
        int generateHashCode = RouteSerializerKt.generateHashCode(serializer);
        NavDestination findNode = findNode(generateHashCode);
        if (findNode != null) {
            setStartDestinationRoute(parseRoute.invoke(findNode));
            this.startDestId = generateHashCode;
        } else {
            throw new IllegalStateException(("Cannot find startDestination " + serializer.getDescriptor().getSerialName() + " from NavGraph. Ensure the starting NavDestination was added with route from KClass.").toString());
        }
    }
}
