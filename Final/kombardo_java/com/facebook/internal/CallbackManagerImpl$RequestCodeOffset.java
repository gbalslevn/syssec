package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.Arrays;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"com/facebook/internal/CallbackManagerImpl$RequestCodeOffset", BuildConfig.FLAVOR, "Lcom/facebook/internal/CallbackManagerImpl$RequestCodeOffset;", BuildConfig.FLAVOR, "offset", "<init>", "(Ljava/lang/String;II)V", "toRequestCode", "()I", "I", "Login", "Share", "Message", "Like", "GameRequest", "AppGroupCreate", "AppGroupJoin", "AppInvite", "DeviceShare", "GamingFriendFinder", "GamingGroupIntegration", "Referral", "GamingContextCreate", "GamingContextSwitch", "GamingContextChoose", "TournamentShareDialog", "TournamentJoinDialog", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public enum CallbackManagerImpl$RequestCodeOffset {
    Login(0),
    Share(1),
    Message(2),
    Like(3),
    GameRequest(4),
    AppGroupCreate(5),
    AppGroupJoin(6),
    AppInvite(7),
    DeviceShare(8),
    GamingFriendFinder(9),
    GamingGroupIntegration(10),
    Referral(11),
    GamingContextCreate(12),
    GamingContextSwitch(13),
    GamingContextChoose(14),
    TournamentShareDialog(15),
    TournamentJoinDialog(16);

    private final int offset;

    CallbackManagerImpl$RequestCodeOffset(int i5) {
        this.offset = i5;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static CallbackManagerImpl$RequestCodeOffset[] valuesCustom() {
        CallbackManagerImpl$RequestCodeOffset[] valuesCustom = values();
        return (CallbackManagerImpl$RequestCodeOffset[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    public final int toRequestCode() {
        return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
    }
}
