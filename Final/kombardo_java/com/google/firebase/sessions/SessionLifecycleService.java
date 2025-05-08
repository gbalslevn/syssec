package com.google.firebase.sessions;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.firebase.sessions.SessionGenerator;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0003J\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u0003R\u001a\u0010\u0010\u001a\u00020\u000f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService;", "Landroid/app/Service;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/Messenger;", "getClientCallback", "(Landroid/content/Intent;)Landroid/os/Messenger;", BuildConfig.FLAVOR, "onCreate", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onDestroy", "Landroid/os/HandlerThread;", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread$com_google_firebase_firebase_sessions", "()Landroid/os/HandlerThread;", "Lcom/google/firebase/sessions/SessionLifecycleService$MessageHandler;", "messageHandler", "Lcom/google/firebase/sessions/SessionLifecycleService$MessageHandler;", "messenger", "Landroid/os/Messenger;", "Companion", "MessageHandler", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionLifecycleService extends Service {
    private static final int CLIENT_BOUND = 4;
    private final HandlerThread handlerThread = new HandlerThread("FirebaseSessions_HandlerThread");
    private MessageHandler messageHandler;
    private Messenger messenger;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleService$MessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "boundClients", "Ljava/util/ArrayList;", "Landroid/os/Messenger;", "Lkotlin/collections/ArrayList;", "hasForegrounded", BuildConfig.FLAVOR, "lastMsgTimeMs", BuildConfig.FLAVOR, "broadcastSession", BuildConfig.FLAVOR, "handleBackgrounding", "msg", "Landroid/os/Message;", "handleClientBound", "handleForegrounding", "handleMessage", "isSessionRestart", "foregroundTimeMs", "maybeSendSessionToClient", "client", "newSession", "sendSessionToClient", "sessionId", BuildConfig.FLAVOR, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class MessageHandler extends Handler {
        private final ArrayList<Messenger> boundClients;
        private boolean hasForegrounded;
        private long lastMsgTimeMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.boundClients = new ArrayList<>();
        }

        private final void broadcastSession() {
            Log.d("SessionLifecycleService", "Broadcasting new session");
            SessionFirelogPublisher.INSTANCE.getInstance().logSession(SessionGenerator.INSTANCE.getInstance().getCurrentSession());
            for (Messenger it : new ArrayList(this.boundClients)) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                maybeSendSessionToClient(it);
            }
        }

        private final void handleBackgrounding(Message msg) {
            Log.d("SessionLifecycleService", "Activity backgrounding at " + msg.getWhen());
            this.lastMsgTimeMs = msg.getWhen();
        }

        private final void handleClientBound(Message msg) {
            this.boundClients.add(msg.replyTo);
            Messenger messenger = msg.replyTo;
            Intrinsics.checkNotNullExpressionValue(messenger, "msg.replyTo");
            maybeSendSessionToClient(messenger);
            Log.d("SessionLifecycleService", "Client " + msg.replyTo + " bound at " + msg.getWhen() + ". Clients: " + this.boundClients.size());
        }

        private final void handleForegrounding(Message msg) {
            Log.d("SessionLifecycleService", "Activity foregrounding at " + msg.getWhen() + '.');
            if (!this.hasForegrounded) {
                Log.d("SessionLifecycleService", "Cold start detected.");
                this.hasForegrounded = true;
                newSession();
            } else if (isSessionRestart(msg.getWhen())) {
                Log.d("SessionLifecycleService", "Session too long in background. Creating new session.");
                newSession();
            }
            this.lastMsgTimeMs = msg.getWhen();
        }

        private final boolean isSessionRestart(long foregroundTimeMs) {
            return foregroundTimeMs - this.lastMsgTimeMs > Duration.m3735getInWholeMillisecondsimpl(SessionsSettings.INSTANCE.getInstance().m2920getSessionRestartTimeoutUwyO8pc());
        }

        private final void maybeSendSessionToClient(Messenger client) {
            if (this.hasForegrounded) {
                sendSessionToClient(client, SessionGenerator.INSTANCE.getInstance().getCurrentSession().getSessionId());
                return;
            }
            String currentSessionId = SessionDatastore.INSTANCE.getInstance().getCurrentSessionId();
            Log.d("SessionLifecycleService", "App has not yet foregrounded. Using previously stored session.");
            if (currentSessionId != null) {
                sendSessionToClient(client, currentSessionId);
            }
        }

        private final void newSession() {
            SessionGenerator.Companion companion = SessionGenerator.INSTANCE;
            companion.getInstance().generateNewSession();
            Log.d("SessionLifecycleService", "Generated new session.");
            broadcastSession();
            SessionDatastore.INSTANCE.getInstance().updateSessionId(companion.getInstance().getCurrentSession().getSessionId());
        }

        private final void sendSessionToClient(Messenger client, String sessionId) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("SessionUpdateExtra", sessionId);
                Message obtain = Message.obtain(null, 3, 0, 0);
                obtain.setData(bundle);
                client.send(obtain);
            } catch (DeadObjectException unused) {
                Log.d("SessionLifecycleService", "Removing dead client from list: " + client);
                this.boundClients.remove(client);
            } catch (Exception e5) {
                Log.w("SessionLifecycleService", "Unable to push new session to " + client + '.', e5);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (this.lastMsgTimeMs > msg.getWhen()) {
                Log.d("SessionLifecycleService", "Ignoring old message from " + msg.getWhen() + " which is older than " + this.lastMsgTimeMs + '.');
                return;
            }
            int i5 = msg.what;
            if (i5 == 1) {
                handleForegrounding(msg);
                return;
            }
            if (i5 == 2) {
                handleBackgrounding(msg);
                return;
            }
            if (i5 == 4) {
                handleClientBound(msg);
                return;
            }
            Log.w("SessionLifecycleService", "Received unexpected event from the SessionLifecycleClient: " + msg);
            super.handleMessage(msg);
        }
    }

    private final Messenger getClientCallback(Intent intent) {
        Object parcelableExtra;
        if (Build.VERSION.SDK_INT < 33) {
            return (Messenger) intent.getParcelableExtra("ClientCallbackMessenger");
        }
        parcelableExtra = intent.getParcelableExtra("ClientCallbackMessenger", Messenger.class);
        return (Messenger) parcelableExtra;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            Log.d("SessionLifecycleService", "Service bound with null intent. Ignoring.");
            return null;
        }
        Log.d("SessionLifecycleService", "Service bound to new client on process " + intent.getAction());
        Messenger clientCallback = getClientCallback(intent);
        if (clientCallback != null) {
            Message obtain = Message.obtain(null, 4, 0, 0);
            obtain.replyTo = clientCallback;
            MessageHandler messageHandler = this.messageHandler;
            if (messageHandler != null) {
                messageHandler.sendMessage(obtain);
            }
        }
        Messenger messenger = this.messenger;
        if (messenger != null) {
            return messenger.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.handlerThread.start();
        Looper looper = this.handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "handlerThread.looper");
        this.messageHandler = new MessageHandler(looper);
        this.messenger = new Messenger(this.messageHandler);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.handlerThread.quit();
    }
}
