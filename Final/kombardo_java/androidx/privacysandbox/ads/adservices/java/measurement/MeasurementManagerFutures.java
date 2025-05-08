package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.measurement.DeletionRequest;
import androidx.privacysandbox.ads.adservices.measurement.MeasurementManager;
import androidx.privacysandbox.ads.adservices.measurement.WebSourceRegistrationRequest;
import androidx.privacysandbox.ads.adservices.measurement.WebTriggerRegistrationRequest;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \r2\u00020\u0001:\u0002\u000e\rB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/net/Uri;", "trigger", "Lcom/google/common/util/concurrent/ListenableFuture;", BuildConfig.FLAVOR, "registerTriggerAsync", "(Landroid/net/Uri;)Lcom/google/common/util/concurrent/ListenableFuture;", BuildConfig.FLAVOR, "getMeasurementApiStatusAsync", "()Lcom/google/common/util/concurrent/ListenableFuture;", "Companion", "Api33Ext5JavaImpl", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MeasurementManagerFutures {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0017J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0017J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0012\u001a\u00020\u000eH\u0017J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0017H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures$Api33Ext5JavaImpl;", "Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", "mMeasurementManager", "Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager;", "(Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager;)V", "deleteRegistrationsAsync", "Lcom/google/common/util/concurrent/ListenableFuture;", BuildConfig.FLAVOR, "deletionRequest", "Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "getMeasurementApiStatusAsync", BuildConfig.FLAVOR, "registerSourceAsync", "attributionSource", "Landroid/net/Uri;", "inputEvent", "Landroid/view/InputEvent;", "registerTriggerAsync", "trigger", "registerWebSourceAsync", "request", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "registerWebTriggerAsync", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Api33Ext5JavaImpl extends MeasurementManagerFutures {
        private final MeasurementManager mMeasurementManager;

        public Api33Ext5JavaImpl(MeasurementManager mMeasurementManager) {
            Intrinsics.checkNotNullParameter(mMeasurementManager, "mMeasurementManager");
            this.mMeasurementManager = mMeasurementManager;
        }

        public ListenableFuture<Unit> deleteRegistrationsAsync(DeletionRequest deletionRequest) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(deletionRequest, "deletionRequest");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$deleteRegistrationsAsync$1(this, deletionRequest, null), 3, null);
            return CoroutineAdapterKt.asListenableFuture$default(async$default, null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        public ListenableFuture<Integer> getMeasurementApiStatusAsync() {
            Deferred async$default;
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1(this, null), 3, null);
            return CoroutineAdapterKt.asListenableFuture$default(async$default, null, 1, null);
        }

        public ListenableFuture<Unit> registerSourceAsync(Uri attributionSource, InputEvent inputEvent) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(attributionSource, "attributionSource");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1(this, attributionSource, inputEvent, null), 3, null);
            return CoroutineAdapterKt.asListenableFuture$default(async$default, null, 1, null);
        }

        @Override // androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures
        public ListenableFuture<Unit> registerTriggerAsync(Uri trigger) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1(this, trigger, null), 3, null);
            return CoroutineAdapterKt.asListenableFuture$default(async$default, null, 1, null);
        }

        public ListenableFuture<Unit> registerWebSourceAsync(WebSourceRegistrationRequest request) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(request, "request");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebSourceAsync$1(this, request, null), 3, null);
            return CoroutineAdapterKt.asListenableFuture$default(async$default, null, 1, null);
        }

        public ListenableFuture<Unit> registerWebTriggerAsync(WebTriggerRegistrationRequest request) {
            Deferred async$default;
            Intrinsics.checkNotNullParameter(request, "request");
            async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new MeasurementManagerFutures$Api33Ext5JavaImpl$registerWebTriggerAsync$1(this, request, null), 3, null);
            return CoroutineAdapterKt.asListenableFuture$default(async$default, null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures$Companion;", BuildConfig.FLAVOR, "()V", "from", "Landroidx/privacysandbox/ads/adservices/java/measurement/MeasurementManagerFutures;", "context", "Landroid/content/Context;", "ads-adservices-java_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MeasurementManagerFutures from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            MeasurementManager obtain = MeasurementManager.INSTANCE.obtain(context);
            if (obtain != null) {
                return new Api33Ext5JavaImpl(obtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final MeasurementManagerFutures from(Context context) {
        return INSTANCE.from(context);
    }

    public abstract ListenableFuture<Integer> getMeasurementApiStatusAsync();

    public abstract ListenableFuture<Unit> registerTriggerAsync(Uri trigger);
}
