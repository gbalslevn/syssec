package androidx.privacysandbox.ads.adservices.measurement;

import K.a;
import K.b;
import K.c;
import K.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.InputEvent;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0019H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager;", BuildConfig.FLAVOR, "()V", "deleteRegistrations", BuildConfig.FLAVOR, "deletionRequest", "Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "(Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMeasurementApiStatus", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSource", "attributionSource", "Landroid/net/Uri;", "inputEvent", "Landroid/view/InputEvent;", "(Landroid/net/Uri;Landroid/view/InputEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerTrigger", "trigger", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerWebSource", "request", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "(Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerWebTrigger", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "(Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Api33Ext5Impl", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MeasurementManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\tH\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0097@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001aH\u0097@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000eH\u0097@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0012H\u0097@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0013\u0010(\u001a\u00020'H\u0097@ø\u0001\u0000¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager$Api33Ext5Impl;", "Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager;", "Landroid/adservices/measurement/MeasurementManager;", "mMeasurementManager", "<init>", "(Landroid/adservices/measurement/MeasurementManager;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;", "request", "Landroid/adservices/measurement/DeletionRequest;", "convertDeletionRequest", "(Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;)Landroid/adservices/measurement/DeletionRequest;", "Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;", "Landroid/adservices/measurement/WebSourceRegistrationRequest;", "convertWebSourceRequest", "(Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;)Landroid/adservices/measurement/WebSourceRegistrationRequest;", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "Landroid/adservices/measurement/WebTriggerRegistrationRequest;", "convertWebTriggerRequest", "(Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;)Landroid/adservices/measurement/WebTriggerRegistrationRequest;", "deletionRequest", BuildConfig.FLAVOR, "deleteRegistrations", "(Landroidx/privacysandbox/ads/adservices/measurement/DeletionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/net/Uri;", "attributionSource", "Landroid/view/InputEvent;", "inputEvent", "registerSource", "(Landroid/net/Uri;Landroid/view/InputEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trigger", "registerTrigger", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerWebSource", "(Landroidx/privacysandbox/ads/adservices/measurement/WebSourceRegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerWebTrigger", "(Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "getMeasurementApiStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/adservices/measurement/MeasurementManager;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    /* loaded from: classes.dex */
    public static final class Api33Ext5Impl extends MeasurementManager {
        private final android.adservices.measurement.MeasurementManager mMeasurementManager;

        public Api33Ext5Impl(android.adservices.measurement.MeasurementManager mMeasurementManager) {
            Intrinsics.checkNotNullParameter(mMeasurementManager, "mMeasurementManager");
        }

        public static final /* synthetic */ android.adservices.measurement.MeasurementManager access$getMMeasurementManager$p(Api33Ext5Impl api33Ext5Impl) {
            api33Ext5Impl.getClass();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.adservices.measurement.DeletionRequest convertDeletionRequest(DeletionRequest request) {
            a.a();
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.adservices.measurement.WebSourceRegistrationRequest convertWebSourceRequest(WebSourceRegistrationRequest request) {
            b.a();
            throw null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.adservices.measurement.WebTriggerRegistrationRequest convertWebTriggerRequest(WebTriggerRegistrationRequest request) {
            c.a();
            throw null;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        public Object deleteRegistrations(DeletionRequest deletionRequest, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            access$getMMeasurementManager$p(this);
            android.adservices.measurement.MeasurementManager measurementManager = null;
            measurementManager.deleteRegistrations(convertDeletionRequest(deletionRequest), new d(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            throw null;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        public Object getMeasurementApiStatus(Continuation<? super Integer> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            access$getMMeasurementManager$p(this);
            android.adservices.measurement.MeasurementManager measurementManager = null;
            measurementManager.getMeasurementApiStatus(new d(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            throw null;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        public Object registerSource(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            access$getMMeasurementManager$p(this);
            android.adservices.measurement.MeasurementManager measurementManager = null;
            measurementManager.registerSource(uri, inputEvent, new d(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            throw null;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        public Object registerTrigger(Uri uri, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            access$getMMeasurementManager$p(this);
            new d();
            OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl);
            throw null;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        public Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            access$getMMeasurementManager$p(this);
            android.adservices.measurement.MeasurementManager measurementManager = null;
            measurementManager.registerWebSource(convertWebSourceRequest(webSourceRegistrationRequest), new d(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            throw null;
        }

        @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
        public Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            access$getMMeasurementManager$p(this);
            android.adservices.measurement.MeasurementManager measurementManager = null;
            measurementManager.registerWebTrigger(convertWebTriggerRequest(webTriggerRegistrationRequest), new d(), OutcomeReceiverKt.asOutcomeReceiver(cancellableContinuationImpl));
            throw null;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Api33Ext5Impl(Context context) {
            this((android.adservices.measurement.MeasurementManager) null);
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getSystemService((Class<Object>) android.adservices.measurement.MeasurementManager.class);
            Intrinsics.checkNotNullExpressionValue(systemService, "context.getSystemService…:class.java\n            )");
            android.support.v4.media.session.a.a(systemService);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager$Companion;", BuildConfig.FLAVOR, "()V", "MEASUREMENT_API_STATE_DISABLED", BuildConfig.FLAVOR, "MEASUREMENT_API_STATE_ENABLED", "obtain", "Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManager;", "context", "Landroid/content/Context;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final MeasurementManager obtain(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            StringBuilder sb = new StringBuilder();
            sb.append("AdServicesInfo.version=");
            AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
            sb.append(adServicesInfo.version());
            Log.d("MeasurementManager", sb.toString());
            if (adServicesInfo.version() >= 5) {
                return new Api33Ext5Impl(context);
            }
            return null;
        }

        private Companion() {
        }
    }

    public abstract Object deleteRegistrations(DeletionRequest deletionRequest, Continuation<? super Unit> continuation);

    public abstract Object getMeasurementApiStatus(Continuation<? super Integer> continuation);

    public abstract Object registerSource(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation);

    public abstract Object registerTrigger(Uri uri, Continuation<? super Unit> continuation);

    public abstract Object registerWebSource(WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation<? super Unit> continuation);

    public abstract Object registerWebTrigger(WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation<? super Unit> continuation);
}
