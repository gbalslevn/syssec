package dk.molslinjen.core.location;

import android.location.Location;
import dk.molslinjen.domain.analytics.ILocationManagerProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096A¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\nH\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/core/location/LocationManagerProvider;", "Ldk/molslinjen/domain/analytics/ILocationManagerProvider;", "Ldk/molslinjen/core/location/ILocationManager;", "locationManager", "<init>", "(Ldk/molslinjen/core/location/ILocationManager;)V", "getLocation", "Landroid/location/Location;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAuthorized", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocationManagerProvider implements ILocationManagerProvider, ILocationManager {
    private final ILocationManager locationManager;

    public LocationManagerProvider(ILocationManager locationManager) {
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        this.locationManager = locationManager;
    }

    @Override // dk.molslinjen.core.location.ILocationManager
    public Object getLocation(Continuation<? super Location> continuation) {
        return this.locationManager.getLocation(continuation);
    }

    @Override // dk.molslinjen.domain.analytics.ILocationManagerProvider, dk.molslinjen.core.location.ILocationManager
    public boolean isAuthorized() {
        return this.locationManager.isAuthorized();
    }
}
