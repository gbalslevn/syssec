package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0012R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010*\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/facebook/appevents/internal/SessionInfo;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "sessionStartTime", "sessionLastEventTime", "Ljava/util/UUID;", "sessionId", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/util/UUID;)V", BuildConfig.FLAVOR, "incrementInterruptionCount", "()V", "writeSessionToDisk", "Ljava/lang/Long;", "getSessionStartTime", "()Ljava/lang/Long;", "getSessionLastEventTime", "setSessionLastEventTime", "(Ljava/lang/Long;)V", "Ljava/util/UUID;", "getSessionId", "()Ljava/util/UUID;", "setSessionId", "(Ljava/util/UUID;)V", BuildConfig.FLAVOR, "<set-?>", "interruptionCount", "I", "getInterruptionCount", "()I", "diskRestoreTime", "getDiskRestoreTime", "setDiskRestoreTime", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "sourceApplicationInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "getSourceApplicationInfo", "()Lcom/facebook/appevents/internal/SourceApplicationInfo;", "setSourceApplicationInfo", "(Lcom/facebook/appevents/internal/SourceApplicationInfo;)V", "getSessionLength", "()J", "sessionLength", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SessionInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
    private Long diskRestoreTime;
    private int interruptionCount;
    private UUID sessionId;
    private Long sessionLastEventTime;
    private final Long sessionStartTime;
    private SourceApplicationInfo sourceApplicationInfo;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/internal/SessionInfo$Companion;", BuildConfig.FLAVOR, "()V", "INTERRUPTION_COUNT_KEY", BuildConfig.FLAVOR, "LAST_SESSION_INFO_END_KEY", "LAST_SESSION_INFO_START_KEY", "SESSION_ID_KEY", "clearSavedSessionFromDisk", BuildConfig.FLAVOR, "getStoredSessionInfo", "Lcom/facebook/appevents/internal/SessionInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearSavedSessionFromDisk() {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.remove(SessionInfo.LAST_SESSION_INFO_START_KEY);
            edit.remove(SessionInfo.LAST_SESSION_INFO_END_KEY);
            edit.remove(SessionInfo.INTERRUPTION_COUNT_KEY);
            edit.remove(SessionInfo.SESSION_ID_KEY);
            edit.apply();
            SourceApplicationInfo.INSTANCE.clearSavedSourceApplicationInfoFromDisk();
        }

        public final SessionInfo getStoredSessionInfo() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            long j5 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_START_KEY, 0L);
            long j6 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_END_KEY, 0L);
            String string = defaultSharedPreferences.getString(SessionInfo.SESSION_ID_KEY, null);
            if (j5 == 0 || j6 == 0 || string == null) {
                return null;
            }
            SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j5), Long.valueOf(j6), null, 4, null);
            sessionInfo.interruptionCount = defaultSharedPreferences.getInt(SessionInfo.INTERRUPTION_COUNT_KEY, 0);
            sessionInfo.setSourceApplicationInfo(SourceApplicationInfo.INSTANCE.getStoredSourceApplicatioInfo());
            sessionInfo.setDiskRestoreTime(Long.valueOf(System.currentTimeMillis()));
            UUID fromString = UUID.fromString(string);
            Intrinsics.checkNotNullExpressionValue(fromString, "fromString(sessionIDStr)");
            sessionInfo.setSessionId(fromString);
            return sessionInfo;
        }

        private Companion() {
        }
    }

    public SessionInfo(Long l5, Long l6, UUID sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionStartTime = l5;
        this.sessionLastEventTime = l6;
        this.sessionId = sessionId;
    }

    public final Long getDiskRestoreTime() {
        Long l5 = this.diskRestoreTime;
        if (l5 == null) {
            return 0L;
        }
        return l5;
    }

    public final int getInterruptionCount() {
        return this.interruptionCount;
    }

    public final UUID getSessionId() {
        return this.sessionId;
    }

    public final Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public final long getSessionLength() {
        Long l5;
        if (this.sessionStartTime == null || (l5 = this.sessionLastEventTime) == null) {
            return 0L;
        }
        if (l5 != null) {
            return l5.longValue() - this.sessionStartTime.longValue();
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public final void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public final void setDiskRestoreTime(Long l5) {
        this.diskRestoreTime = l5;
    }

    public final void setSessionId(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<set-?>");
        this.sessionId = uuid;
    }

    public final void setSessionLastEventTime(Long l5) {
        this.sessionLastEventTime = l5;
    }

    public final void setSourceApplicationInfo(SourceApplicationInfo sourceApplicationInfo) {
        this.sourceApplicationInfo = sourceApplicationInfo;
    }

    public final void writeSessionToDisk() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        Long l5 = this.sessionStartTime;
        edit.putLong(LAST_SESSION_INFO_START_KEY, l5 == null ? 0L : l5.longValue());
        Long l6 = this.sessionLastEventTime;
        edit.putLong(LAST_SESSION_INFO_END_KEY, l6 != null ? l6.longValue() : 0L);
        edit.putInt(INTERRUPTION_COUNT_KEY, this.interruptionCount);
        edit.putString(SESSION_ID_KEY, this.sessionId.toString());
        edit.apply();
        SourceApplicationInfo sourceApplicationInfo = this.sourceApplicationInfo;
        if (sourceApplicationInfo == null || sourceApplicationInfo == null) {
            return;
        }
        sourceApplicationInfo.writeSourceApplicationInfoToDisk();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SessionInfo(Long l5, Long l6, UUID uuid, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(l5, l6, uuid);
        if ((i5 & 4) != 0) {
            uuid = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID()");
        }
    }
}
