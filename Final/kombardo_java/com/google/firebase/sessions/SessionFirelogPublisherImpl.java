package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0011\u0010\u0016\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisherImpl;", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "sessionSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/EventGDTLoggerInterface;Lkotlin/coroutines/CoroutineContext;)V", "attemptLoggingSessionEvent", BuildConfig.FLAVOR, "sessionEvent", "Lcom/google/firebase/sessions/SessionEvent;", "logSession", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "shouldCollectEvents", BuildConfig.FLAVOR, "shouldLogSession", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {
    private static final String TAG = "SessionFirelogPublisher";
    private final CoroutineContext backgroundDispatcher;
    private final EventGDTLoggerInterface eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final SessionsSettings sessionSettings;
    private static final double randomValueForSampling = Math.random();

    public SessionFirelogPublisherImpl(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, SessionsSettings sessionSettings, EventGDTLoggerInterface eventGDTLogger, CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(sessionSettings, "sessionSettings");
        Intrinsics.checkNotNullParameter(eventGDTLogger, "eventGDTLogger");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallations;
        this.sessionSettings = sessionSettings;
        this.eventGDTLogger = eventGDTLogger;
        this.backgroundDispatcher = backgroundDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attemptLoggingSessionEvent(SessionEvent sessionEvent) {
        try {
            this.eventGDTLogger.log(sessionEvent);
            Log.d(TAG, "Successfully logged Session Start event.");
        } catch (RuntimeException e5) {
            Log.e(TAG, "Error logging Session Start event to DataTransport: ", e5);
        }
    }

    private final boolean shouldCollectEvents() {
        return randomValueForSampling <= this.sessionSettings.getSamplingRate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object shouldLogSession(Continuation<? super Boolean> continuation) {
        SessionFirelogPublisherImpl$shouldLogSession$1 sessionFirelogPublisherImpl$shouldLogSession$1;
        int i5;
        SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
        if (continuation instanceof SessionFirelogPublisherImpl$shouldLogSession$1) {
            sessionFirelogPublisherImpl$shouldLogSession$1 = (SessionFirelogPublisherImpl$shouldLogSession$1) continuation;
            int i6 = sessionFirelogPublisherImpl$shouldLogSession$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                sessionFirelogPublisherImpl$shouldLogSession$1.label = i6 - Integer.MIN_VALUE;
                Object obj = sessionFirelogPublisherImpl$shouldLogSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = sessionFirelogPublisherImpl$shouldLogSession$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Log.d(TAG, "Data Collection is enabled for at least one Subscriber");
                    SessionsSettings sessionsSettings = this.sessionSettings;
                    sessionFirelogPublisherImpl$shouldLogSession$1.L$0 = this;
                    sessionFirelogPublisherImpl$shouldLogSession$1.label = 1;
                    if (sessionsSettings.updateSettings(sessionFirelogPublisherImpl$shouldLogSession$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sessionFirelogPublisherImpl = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) sessionFirelogPublisherImpl$shouldLogSession$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (sessionFirelogPublisherImpl.sessionSettings.getSessionsEnabled()) {
                    Log.d(TAG, "Sessions SDK disabled. Events will not be sent.");
                    return Boxing.boxBoolean(false);
                }
                if (sessionFirelogPublisherImpl.shouldCollectEvents()) {
                    return Boxing.boxBoolean(true);
                }
                Log.d(TAG, "Sessions SDK has dropped this session due to sampling.");
                return Boxing.boxBoolean(false);
            }
        }
        sessionFirelogPublisherImpl$shouldLogSession$1 = new SessionFirelogPublisherImpl$shouldLogSession$1(this, continuation);
        Object obj2 = sessionFirelogPublisherImpl$shouldLogSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = sessionFirelogPublisherImpl$shouldLogSession$1.label;
        if (i5 != 0) {
        }
        if (sessionFirelogPublisherImpl.sessionSettings.getSessionsEnabled()) {
        }
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void logSession(SessionDetails sessionDetails) {
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new SessionFirelogPublisherImpl$logSession$1(this, sessionDetails, null), 3, null);
    }
}
