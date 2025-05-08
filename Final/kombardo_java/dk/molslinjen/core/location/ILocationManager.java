package dk.molslinjen.core.location;

import android.location.Location;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/location/ILocationManager;", BuildConfig.FLAVOR, "getLocation", "Landroid/location/Location;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAuthorized", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ILocationManager {
    Object getLocation(Continuation<? super Location> continuation);

    boolean isAuthorized();
}
