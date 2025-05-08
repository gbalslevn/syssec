package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000212B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000fBI\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\n\u0010\u0014J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J;\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0011HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001b¨\u00063"}, d2 = {"Ldk/molslinjen/domain/model/config/Route;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "outRoute", "Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "returnRoute", "usesRegions", BuildConfig.FLAVOR, "isEarlyCheckInPossible", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/RouteDirectionGroup;Ldk/molslinjen/domain/model/config/RouteDirectionGroup;ZZ)V", "routeDTO", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDTO;", "useRegions", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDTO;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/domain/model/config/RouteDirectionGroup;Ldk/molslinjen/domain/model/config/RouteDirectionGroup;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getOutRoute", "()Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "getReturnRoute", "getUsesRegions", "()Z", "getRouteDirection", "direction", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class Route {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Route mock;
    private final String id;
    private final boolean isEarlyCheckInPossible;
    private final RouteDirectionGroup outRoute;
    private final RouteDirectionGroup returnRoute;
    private final boolean usesRegions;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/Route$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/Route;", "getMock", "()Ldk/molslinjen/domain/model/config/Route;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Route getMock() {
            return Route.mock;
        }

        public final KSerializer<Route> serializer() {
            return Route$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RouteDirection.values().length];
            try {
                iArr[RouteDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RouteDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        RouteDirectionGroup.Companion companion = RouteDirectionGroup.INSTANCE;
        mock = new Route("3", companion.getMockAarhusOdden(), companion.getMockOddenAarhus(), true, true);
    }

    public /* synthetic */ Route(int i5, String str, RouteDirectionGroup routeDirectionGroup, RouteDirectionGroup routeDirectionGroup2, boolean z5, boolean z6, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, Route$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.outRoute = routeDirectionGroup;
        this.returnRoute = routeDirectionGroup2;
        this.usesRegions = z5;
        this.isEarlyCheckInPossible = z6;
    }

    public static /* synthetic */ Route copy$default(Route route, String str, RouteDirectionGroup routeDirectionGroup, RouteDirectionGroup routeDirectionGroup2, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = route.id;
        }
        if ((i5 & 2) != 0) {
            routeDirectionGroup = route.outRoute;
        }
        RouteDirectionGroup routeDirectionGroup3 = routeDirectionGroup;
        if ((i5 & 4) != 0) {
            routeDirectionGroup2 = route.returnRoute;
        }
        RouteDirectionGroup routeDirectionGroup4 = routeDirectionGroup2;
        if ((i5 & 8) != 0) {
            z5 = route.usesRegions;
        }
        boolean z7 = z5;
        if ((i5 & 16) != 0) {
            z6 = route.isEarlyCheckInPossible;
        }
        return route.copy(str, routeDirectionGroup3, routeDirectionGroup4, z7, z6);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(Route self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        RouteDirectionGroup$$serializer routeDirectionGroup$$serializer = RouteDirectionGroup$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 1, routeDirectionGroup$$serializer, self.outRoute);
        output.encodeSerializableElement(serialDesc, 2, routeDirectionGroup$$serializer, self.returnRoute);
        output.encodeBooleanElement(serialDesc, 3, self.usesRegions);
        output.encodeBooleanElement(serialDesc, 4, self.isEarlyCheckInPossible);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final RouteDirectionGroup getOutRoute() {
        return this.outRoute;
    }

    /* renamed from: component3, reason: from getter */
    public final RouteDirectionGroup getReturnRoute() {
        return this.returnRoute;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getUsesRegions() {
        return this.usesRegions;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsEarlyCheckInPossible() {
        return this.isEarlyCheckInPossible;
    }

    public final Route copy(String id, RouteDirectionGroup outRoute, RouteDirectionGroup returnRoute, boolean usesRegions, boolean isEarlyCheckInPossible) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(outRoute, "outRoute");
        Intrinsics.checkNotNullParameter(returnRoute, "returnRoute");
        return new Route(id, outRoute, returnRoute, usesRegions, isEarlyCheckInPossible);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Route)) {
            return false;
        }
        Route route = (Route) other;
        return Intrinsics.areEqual(this.id, route.id) && Intrinsics.areEqual(this.outRoute, route.outRoute) && Intrinsics.areEqual(this.returnRoute, route.returnRoute) && this.usesRegions == route.usesRegions && this.isEarlyCheckInPossible == route.isEarlyCheckInPossible;
    }

    public final String getId() {
        return this.id;
    }

    public final RouteDirectionGroup getOutRoute() {
        return this.outRoute;
    }

    public final RouteDirectionGroup getReturnRoute() {
        return this.returnRoute;
    }

    public final RouteDirectionGroup getRouteDirection(RouteDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        int i5 = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
        if (i5 == 1) {
            return this.outRoute;
        }
        if (i5 == 2) {
            return this.returnRoute;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getUsesRegions() {
        return this.usesRegions;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.outRoute.hashCode()) * 31) + this.returnRoute.hashCode()) * 31) + Boolean.hashCode(this.usesRegions)) * 31) + Boolean.hashCode(this.isEarlyCheckInPossible);
    }

    public final boolean isEarlyCheckInPossible() {
        return this.isEarlyCheckInPossible;
    }

    public String toString() {
        return "Route(id=" + this.id + ", outRoute=" + this.outRoute + ", returnRoute=" + this.returnRoute + ", usesRegions=" + this.usesRegions + ", isEarlyCheckInPossible=" + this.isEarlyCheckInPossible + ")";
    }

    public Route(String id, RouteDirectionGroup outRoute, RouteDirectionGroup returnRoute, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(outRoute, "outRoute");
        Intrinsics.checkNotNullParameter(returnRoute, "returnRoute");
        this.id = id;
        this.outRoute = outRoute;
        this.returnRoute = returnRoute;
        this.usesRegions = z5;
        this.isEarlyCheckInPossible = z6;
    }

    public final RouteDirectionGroup getRouteDirection(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (Intrinsics.areEqual(this.outRoute.getMainRouteId(), id)) {
            return this.outRoute;
        }
        if (Intrinsics.areEqual(this.returnRoute.getMainRouteId(), id)) {
            return this.returnRoute;
        }
        return null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Route(ConfigurationResponseDTO.RouteDTO routeDTO, boolean z5) {
        this(r2, r3, r4, z5, r8);
        boolean z6;
        Intrinsics.checkNotNullParameter(routeDTO, "routeDTO");
        String id = routeDTO.getId();
        RouteDirectionGroup routeDirectionGroup = new RouteDirectionGroup(routeDTO.getOutRoute(), z5);
        RouteDirectionGroup routeDirectionGroup2 = new RouteDirectionGroup(routeDTO.getReturnRoute(), z5);
        List<ConfigurationResponseDTO.RouteDirectionDetailsDTO> routes = routeDTO.getOutRoute().getRoutes();
        if (!(routes instanceof Collection) || !routes.isEmpty()) {
            Iterator<T> it = routes.iterator();
            while (it.hasNext()) {
                if (((ConfigurationResponseDTO.RouteDirectionDetailsDTO) it.next()).isEarlyCheckInPossible()) {
                    break;
                }
            }
        }
        List<ConfigurationResponseDTO.RouteDirectionDetailsDTO> routes2 = routeDTO.getReturnRoute().getRoutes();
        if (!(routes2 instanceof Collection) || !routes2.isEmpty()) {
            Iterator<T> it2 = routes2.iterator();
            while (it2.hasNext()) {
                if (((ConfigurationResponseDTO.RouteDirectionDetailsDTO) it2.next()).isEarlyCheckInPossible()) {
                    z6 = true;
                }
            }
        }
        z6 = false;
    }
}
