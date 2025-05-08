package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f8\u0006@BX\u0086.¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator;", BuildConfig.FLAVOR, "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lkotlin/Function0;", "Ljava/util/UUID;", "uuidGenerator", "<init>", "(Lcom/google/firebase/sessions/TimeProvider;Lkotlin/jvm/functions/Function0;)V", BuildConfig.FLAVOR, "generateSessionId", "()Ljava/lang/String;", "Lcom/google/firebase/sessions/SessionDetails;", "generateNewSession", "()Lcom/google/firebase/sessions/SessionDetails;", "Lcom/google/firebase/sessions/TimeProvider;", "Lkotlin/jvm/functions/Function0;", "firstSessionId", "Ljava/lang/String;", BuildConfig.FLAVOR, "sessionIndex", "I", "<set-?>", "currentSession", "Lcom/google/firebase/sessions/SessionDetails;", "getCurrentSession", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionGenerator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private SessionDetails currentSession;
    private final String firstSessionId;
    private int sessionIndex;
    private final TimeProvider timeProvider;
    private final Function0<UUID> uuidGenerator;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: com.google.firebase.sessions.SessionGenerator$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<UUID> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0, UUID.class, "randomUUID", "randomUUID()Ljava/util/UUID;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator$Companion;", BuildConfig.FLAVOR, "()V", "instance", "Lcom/google/firebase/sessions/SessionGenerator;", "getInstance", "()Lcom/google/firebase/sessions/SessionGenerator;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SessionGenerator getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionGenerator.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Firebase.app[SessionGenerator::class.java]");
            return (SessionGenerator) obj;
        }

        private Companion() {
        }
    }

    public SessionGenerator(TimeProvider timeProvider, Function0<UUID> uuidGenerator) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(uuidGenerator, "uuidGenerator");
        this.timeProvider = timeProvider;
        this.uuidGenerator = uuidGenerator;
        this.firstSessionId = generateSessionId();
        this.sessionIndex = -1;
    }

    private final String generateSessionId() {
        String uuid = this.uuidGenerator.invoke().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "uuidGenerator().toString()");
        String lowerCase = StringsKt.replace$default(uuid, "-", BuildConfig.FLAVOR, false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final SessionDetails generateNewSession() {
        int i5 = this.sessionIndex + 1;
        this.sessionIndex = i5;
        this.currentSession = new SessionDetails(i5 == 0 ? this.firstSessionId : generateSessionId(), this.firstSessionId, this.sessionIndex, this.timeProvider.currentTimeUs());
        return getCurrentSession();
    }

    public final SessionDetails getCurrentSession() {
        SessionDetails sessionDetails = this.currentSession;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentSession");
        return null;
    }

    public /* synthetic */ SessionGenerator(TimeProvider timeProvider, Function0 function0, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeProvider, (i5 & 2) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
