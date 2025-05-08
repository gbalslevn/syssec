package dk.molslinjen.core.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import dk.molslinjen.extensions.IntExtensionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0097@¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Ldk/molslinjen/core/location/LocationManager;", "Ldk/molslinjen/core/location/ILocationManager;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BuildConfig.FLAVOR, "initLocationRequests", "()V", "Landroid/location/Location;", "location", BuildConfig.FLAVOR, "isValidLocation", "(Landroid/location/Location;)Z", "isAuthorized", "()Z", "getLocation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "Lcom/google/android/gms/location/LocationRequest;", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocationManager implements ILocationManager, CoroutineScope {
    private final Context context;
    private FusedLocationProviderClient fusedLocationClient;
    private final CompletableJob job;
    private LocationRequest locationRequest;

    public LocationManager(Context context) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.job = Job$default;
        initLocationRequests();
    }

    private final void initLocationRequests() {
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.context);
        this.locationRequest = new LocationRequest.Builder(5L).setPriority(100).setMinUpdateIntervalMillis(100L).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidLocation(Location location) {
        return location != null && SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos() < IntExtensionsKt.millisecondsAsNano(IntExtensionsKt.secondsAsMilliseconds(30));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.job);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [dk.molslinjen.core.location.LocationManager$getLocation$2$locationCallback$1] */
    @Override // dk.molslinjen.core.location.ILocationManager
    @SuppressLint({"MissingPermission"})
    public Object getLocation(Continuation<? super Location> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final ?? r12 = new LocationCallback() { // from class: dk.molslinjen.core.location.LocationManager$getLocation$2$locationCallback$1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult locationResult) {
                FusedLocationProviderClient fusedLocationProviderClient;
                boolean isValidLocation;
                Intrinsics.checkNotNullParameter(locationResult, "locationResult");
                fusedLocationProviderClient = LocationManager.this.fusedLocationClient;
                if (fusedLocationProviderClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
                    fusedLocationProviderClient = null;
                }
                fusedLocationProviderClient.removeLocationUpdates(this);
                isValidLocation = LocationManager.this.isValidLocation(locationResult.getLastLocation());
                if (isValidLocation) {
                    Continuation<Location> continuation2 = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m3567constructorimpl(locationResult.getLastLocation()));
                }
            }
        };
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        if (fusedLocationProviderClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
            fusedLocationProviderClient = null;
        }
        Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
        final Function1<Location, Unit> function1 = new Function1<Location, Unit>() { // from class: dk.molslinjen.core.location.LocationManager$getLocation$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Location location) {
                invoke2(location);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Location location) {
                boolean isValidLocation;
                FusedLocationProviderClient fusedLocationProviderClient2;
                LocationRequest locationRequest;
                isValidLocation = LocationManager.this.isValidLocation(location);
                if (isValidLocation) {
                    safeContinuation.resumeWith(Result.m3567constructorimpl(location));
                    return;
                }
                fusedLocationProviderClient2 = LocationManager.this.fusedLocationClient;
                LocationRequest locationRequest2 = null;
                if (fusedLocationProviderClient2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
                    fusedLocationProviderClient2 = null;
                }
                locationRequest = LocationManager.this.locationRequest;
                if (locationRequest == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationRequest");
                } else {
                    locationRequest2 = locationRequest;
                }
                fusedLocationProviderClient2.requestLocationUpdates(locationRequest2, r12, Looper.myLooper());
            }
        };
        lastLocation.addOnSuccessListener(new OnSuccessListener(function1) { // from class: dk.molslinjen.core.location.LocationManager$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.function.invoke(obj);
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // dk.molslinjen.core.location.ILocationManager
    public boolean isAuthorized() {
        return (ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0) && (ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0);
    }
}
