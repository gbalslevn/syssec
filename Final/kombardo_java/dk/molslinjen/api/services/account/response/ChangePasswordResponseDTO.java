package dk.molslinjen.api.services.account.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/api/services/account/response/ChangePasswordResponseDTO;", BuildConfig.FLAVOR, "userId", BuildConfig.FLAVOR, "authToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUserId$annotations", "()V", "getUserId", "()Ljava/lang/String;", "getAuthToken$annotations", "getAuthToken", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ChangePasswordResponseDTO {
    private final String authToken;
    private final String userId;

    public ChangePasswordResponseDTO(String userId, String authToken) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(authToken, "authToken");
        this.userId = userId;
        this.authToken = authToken;
    }

    public static /* synthetic */ ChangePasswordResponseDTO copy$default(ChangePasswordResponseDTO changePasswordResponseDTO, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = changePasswordResponseDTO.userId;
        }
        if ((i5 & 2) != 0) {
            str2 = changePasswordResponseDTO.authToken;
        }
        return changePasswordResponseDTO.copy(str, str2);
    }

    public static /* synthetic */ void getAuthToken$annotations() {
    }

    public static /* synthetic */ void getUserId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthToken() {
        return this.authToken;
    }

    public final ChangePasswordResponseDTO copy(String userId, String authToken) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(authToken, "authToken");
        return new ChangePasswordResponseDTO(userId, authToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangePasswordResponseDTO)) {
            return false;
        }
        ChangePasswordResponseDTO changePasswordResponseDTO = (ChangePasswordResponseDTO) other;
        return Intrinsics.areEqual(this.userId, changePasswordResponseDTO.userId) && Intrinsics.areEqual(this.authToken, changePasswordResponseDTO.authToken);
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.authToken.hashCode();
    }

    public String toString() {
        return "ChangePasswordResponseDTO(userId=" + this.userId + ", authToken=" + this.authToken + ")";
    }
}
