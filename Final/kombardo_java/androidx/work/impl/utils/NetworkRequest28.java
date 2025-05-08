package androidx.work.impl.utils;

import android.net.NetworkRequest;
import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\nJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\u001d\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Landroidx/work/impl/utils/NetworkRequest28;", BuildConfig.FLAVOR, "()V", "createNetworkRequest", "Landroid/net/NetworkRequest;", "capabilities", BuildConfig.FLAVOR, "transports", "createNetworkRequestCompat", "Landroidx/work/impl/utils/NetworkRequestCompat;", "createNetworkRequestCompat$work_runtime_release", "hasCapability", BuildConfig.FLAVOR, "request", "capability", BuildConfig.FLAVOR, "hasCapability$work_runtime_release", "hasTransport", "transport", "hasTransport$work_runtime_release", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NetworkRequest28 {
    public static final NetworkRequest28 INSTANCE = new NetworkRequest28();

    private NetworkRequest28() {
    }

    public static final NetworkRequest createNetworkRequest(int[] capabilities, int[] transports) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(transports, "transports");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i5 : capabilities) {
            try {
                builder.addCapability(i5);
            } catch (IllegalArgumentException e5) {
                Logger.get().warning(NetworkRequestCompat.INSTANCE.getTAG(), "Ignoring adding capability '" + i5 + '\'', e5);
            }
        }
        for (int i6 : transports) {
            builder.addTransportType(i6);
        }
        NetworkRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "networkRequest.build()");
        return build;
    }

    public final NetworkRequestCompat createNetworkRequestCompat$work_runtime_release(int[] capabilities, int[] transports) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(transports, "transports");
        return new NetworkRequestCompat(createNetworkRequest(capabilities, transports));
    }

    public final boolean hasCapability$work_runtime_release(NetworkRequest request, int capability) {
        boolean hasCapability;
        Intrinsics.checkNotNullParameter(request, "request");
        hasCapability = request.hasCapability(capability);
        return hasCapability;
    }

    public final boolean hasTransport$work_runtime_release(NetworkRequest request, int transport) {
        boolean hasTransport;
        Intrinsics.checkNotNullParameter(request, "request");
        hasTransport = request.hasTransport(transport);
        return hasTransport;
    }
}
