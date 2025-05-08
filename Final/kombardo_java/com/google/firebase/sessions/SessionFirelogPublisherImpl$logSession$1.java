package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.InstallationId;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.sun.jna.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", l = {Function.ALT_CONVENTION, Function.THROW_LAST_ERROR, 70}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class SessionFirelogPublisherImpl$logSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionDetails $sessionDetails;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ SessionFirelogPublisherImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionFirelogPublisherImpl$logSession$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, SessionDetails sessionDetails, Continuation<? super SessionFirelogPublisherImpl$logSession$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionFirelogPublisherImpl;
        this.$sessionDetails = sessionDetails;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionFirelogPublisherImpl$logSession$1(this.this$0, this.$sessionDetails, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FirebaseInstallationsApi firebaseInstallationsApi;
        InstallationId installationId;
        FirebaseApp firebaseApp;
        SessionsSettings sessionsSettings;
        Object registeredSubscribers$com_google_firebase_firebase_sessions;
        SessionEvents sessionEvents;
        SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
        SessionsSettings sessionsSettings2;
        FirebaseApp firebaseApp2;
        SessionDetails sessionDetails;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            SessionFirelogPublisherImpl sessionFirelogPublisherImpl2 = this.this$0;
            this.label = 1;
            obj = sessionFirelogPublisherImpl2.shouldLogSession(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    SessionsSettings sessionsSettings3 = (SessionsSettings) this.L$5;
                    SessionDetails sessionDetails2 = (SessionDetails) this.L$4;
                    FirebaseApp firebaseApp3 = (FirebaseApp) this.L$3;
                    SessionEvents sessionEvents2 = (SessionEvents) this.L$2;
                    SessionFirelogPublisherImpl sessionFirelogPublisherImpl3 = (SessionFirelogPublisherImpl) this.L$1;
                    installationId = (InstallationId) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sessionFirelogPublisherImpl = sessionFirelogPublisherImpl3;
                    sessionsSettings2 = sessionsSettings3;
                    sessionEvents = sessionEvents2;
                    sessionDetails = sessionDetails2;
                    firebaseApp2 = firebaseApp3;
                    sessionFirelogPublisherImpl.attemptLoggingSessionEvent(sessionEvents.buildSession(firebaseApp2, sessionDetails, sessionsSettings2, (Map) obj, installationId.getFid(), installationId.getAuthToken()));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                installationId = (InstallationId) obj;
                SessionFirelogPublisherImpl sessionFirelogPublisherImpl4 = this.this$0;
                SessionEvents sessionEvents3 = SessionEvents.INSTANCE;
                firebaseApp = sessionFirelogPublisherImpl4.firebaseApp;
                SessionDetails sessionDetails3 = this.$sessionDetails;
                sessionsSettings = this.this$0.sessionSettings;
                FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
                this.L$0 = installationId;
                this.L$1 = sessionFirelogPublisherImpl4;
                this.L$2 = sessionEvents3;
                this.L$3 = firebaseApp;
                this.L$4 = sessionDetails3;
                this.L$5 = sessionsSettings;
                this.label = 3;
                registeredSubscribers$com_google_firebase_firebase_sessions = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
                if (registeredSubscribers$com_google_firebase_firebase_sessions != coroutine_suspended) {
                    return coroutine_suspended;
                }
                sessionEvents = sessionEvents3;
                sessionFirelogPublisherImpl = sessionFirelogPublisherImpl4;
                sessionsSettings2 = sessionsSettings;
                firebaseApp2 = firebaseApp;
                obj = registeredSubscribers$com_google_firebase_firebase_sessions;
                sessionDetails = sessionDetails3;
                sessionFirelogPublisherImpl.attemptLoggingSessionEvent(sessionEvents.buildSession(firebaseApp2, sessionDetails, sessionsSettings2, (Map) obj, installationId.getFid(), installationId.getAuthToken()));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            InstallationId.Companion companion = InstallationId.INSTANCE;
            firebaseInstallationsApi = this.this$0.firebaseInstallations;
            this.label = 2;
            obj = companion.create(firebaseInstallationsApi, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            installationId = (InstallationId) obj;
            SessionFirelogPublisherImpl sessionFirelogPublisherImpl42 = this.this$0;
            SessionEvents sessionEvents32 = SessionEvents.INSTANCE;
            firebaseApp = sessionFirelogPublisherImpl42.firebaseApp;
            SessionDetails sessionDetails32 = this.$sessionDetails;
            sessionsSettings = this.this$0.sessionSettings;
            FirebaseSessionsDependencies firebaseSessionsDependencies2 = FirebaseSessionsDependencies.INSTANCE;
            this.L$0 = installationId;
            this.L$1 = sessionFirelogPublisherImpl42;
            this.L$2 = sessionEvents32;
            this.L$3 = firebaseApp;
            this.L$4 = sessionDetails32;
            this.L$5 = sessionsSettings;
            this.label = 3;
            registeredSubscribers$com_google_firebase_firebase_sessions = firebaseSessionsDependencies2.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
            if (registeredSubscribers$com_google_firebase_firebase_sessions != coroutine_suspended) {
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SessionFirelogPublisherImpl$logSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
