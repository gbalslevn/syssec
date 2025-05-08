package dk.molslinjen.ui.views.screens.deeplink;

import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkState;
import dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "_deepLinkState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState;", "deepLinkState", "Lkotlinx/coroutines/flow/StateFlow;", "getDeepLinkState", "()Lkotlinx/coroutines/flow/StateFlow;", "deepLinkUri", "Landroid/net/Uri;", "getDeepLinkUri", "()Landroid/net/Uri;", "deepLinkUri$delegate", "Lkotlin/Lazy;", "getToken", BuildConfig.FLAVOR, "resetDeepLinkState", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeepLinkViewModel extends ViewModel {
    private final MutableStateFlow<DeepLinkState> _deepLinkState;
    private final StateFlow<DeepLinkState> deepLinkState;

    /* renamed from: deepLinkUri$delegate, reason: from kotlin metadata */
    private final Lazy deepLinkUri;
    private final SavedStateHandle savedStateHandle;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel$1", f = "DeepLinkViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.deeplink.DeepLinkViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object value2;
            String token;
            String token2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Uri deepLinkUri = DeepLinkViewModel.this.getDeepLinkUri();
            Object obj2 = null;
            String path = deepLinkUri != null ? deepLinkUri.getPath() : null;
            if (path != null) {
                int hashCode = path.hashCode();
                if (hashCode != -1809140423) {
                    if (hashCode != -1210010261) {
                        if (hashCode == 1296140194 && path.equals("/profil/aktivering") && (token2 = DeepLinkViewModel.this.getToken()) != null) {
                            String uri = deepLinkUri.toString();
                            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                            obj2 = new DeepLinkState.ShowAccountActivation(token2, uri);
                        }
                    } else if (path.equals("/profil/reset") && (token = DeepLinkViewModel.this.getToken()) != null) {
                        String uri2 = deepLinkUri.toString();
                        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
                        obj2 = new DeepLinkState.ShowPasswordReset(token, uri2);
                    }
                } else if (path.equals("/check-in")) {
                    String str = (String) DeepLinkViewModel.this.savedStateHandle.get("phone");
                    String str2 = (String) DeepLinkViewModel.this.savedStateHandle.get("orderid");
                    if (str != null && str2 != null) {
                        obj2 = new DeepLinkState.ShowEarlyCheckIn(str, str2, null, 4, null);
                    }
                }
            }
            Logger logger = Logger.INSTANCE;
            Logger.log$default(logger, "Mapped DeepLink state: " + obj2 + " (from " + deepLinkUri + ")", null, 0, 6, null);
            if (obj2 != null) {
                MutableStateFlow mutableStateFlow = DeepLinkViewModel.this._deepLinkState;
                do {
                    value2 = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value2, obj2));
            } else {
                logger.logCritical(new CriticalLog("Could not map uri to DeepLink state: " + deepLinkUri));
                MutableStateFlow mutableStateFlow2 = DeepLinkViewModel.this._deepLinkState;
                do {
                    value = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value, DeepLinkState.ShowHomeScreen.INSTANCE));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public DeepLinkViewModel(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.savedStateHandle = savedStateHandle;
        MutableStateFlow<DeepLinkState> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._deepLinkState = MutableStateFlow;
        this.deepLinkState = MutableStateFlow;
        this.deepLinkUri = LazyKt.lazy(new Function0() { // from class: k3.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Uri deepLinkUri_delegate$lambda$0;
                deepLinkUri_delegate$lambda$0 = DeepLinkViewModel.deepLinkUri_delegate$lambda$0(DeepLinkViewModel.this);
                return deepLinkUri_delegate$lambda$0;
            }
        });
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri deepLinkUri_delegate$lambda$0(DeepLinkViewModel deepLinkViewModel) {
        Intent intent = (Intent) deepLinkViewModel.savedStateHandle.get("android-support-nav:controller:deepLinkIntent");
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Uri getDeepLinkUri() {
        return (Uri) this.deepLinkUri.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getToken() {
        String str = (String) this.savedStateHandle.get("token");
        if (str == null) {
            Logger.log$default(Logger.INSTANCE, "Token not found in deep link data: " + getDeepLinkUri(), null, 0, 6, null);
        }
        return str;
    }

    public final StateFlow<DeepLinkState> getDeepLinkState() {
        return this.deepLinkState;
    }

    public final void resetDeepLinkState() {
        this._deepLinkState.setValue(null);
    }
}
