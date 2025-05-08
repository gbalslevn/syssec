package com.google.firebase.sessions;

import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.tasks.TasksKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/InstallationId;", BuildConfig.FLAVOR, "fid", BuildConfig.FLAVOR, "authToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthToken", "()Ljava/lang/String;", "getFid", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InstallationId {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "InstallationId";
    private final String authToken;
    private final String fid;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/InstallationId$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "create", "Lcom/google/firebase/sessions/InstallationId;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "(Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(12:5|6|7|(1:(1:(6:11|12|13|14|15|16)(2:19|20))(2:21|22))(3:29|30|(1:32))|23|24|25|(1:27)|13|14|15|16))|37|6|7|(0)(0)|23|24|25|(0)|13|14|15|16) */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
        
            r10 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
        
            android.util.Log.w(com.google.firebase.sessions.InstallationId.TAG, "Error getting authentication token.", r10);
            r10 = r9;
            r9 = org.conscrypt.BuildConfig.FLAVOR;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0034, code lost:
        
            r10 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0093, code lost:
        
            android.util.Log.w(com.google.firebase.sessions.InstallationId.TAG, "Error getting Firebase installation id .", r10);
            r9 = r9;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
        /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v8 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object create(FirebaseInstallationsApi firebaseInstallationsApi, Continuation<? super InstallationId> continuation) {
            InstallationId$Companion$create$1 installationId$Companion$create$1;
            Object obj;
            Object coroutine_suspended;
            int i5;
            if (continuation instanceof InstallationId$Companion$create$1) {
                installationId$Companion$create$1 = (InstallationId$Companion$create$1) continuation;
                int i6 = installationId$Companion$create$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    installationId$Companion$create$1.label = i6 - Integer.MIN_VALUE;
                    obj = installationId$Companion$create$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = installationId$Companion$create$1.label;
                    String str = BuildConfig.FLAVOR;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        Task<InstallationTokenResult> token = firebaseInstallationsApi.getToken(false);
                        Intrinsics.checkNotNullExpressionValue(token, "firebaseInstallations.getToken(false)");
                        installationId$Companion$create$1.L$0 = firebaseInstallationsApi;
                        installationId$Companion$create$1.label = 1;
                        obj = TasksKt.await(token, installationId$Companion$create$1);
                        firebaseInstallationsApi = firebaseInstallationsApi;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ?? r9 = (String) installationId$Companion$create$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            firebaseInstallationsApi = r9;
                            Intrinsics.checkNotNullExpressionValue(obj, "{\n          firebaseInst…ions.id.await()\n        }");
                            str = (String) obj;
                            ?? r92 = firebaseInstallationsApi;
                            return new InstallationId(str, r92, null);
                        }
                        FirebaseInstallationsApi firebaseInstallationsApi2 = (FirebaseInstallationsApi) installationId$Companion$create$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        firebaseInstallationsApi = firebaseInstallationsApi2;
                    }
                    String token2 = ((InstallationTokenResult) obj).getToken();
                    Intrinsics.checkNotNullExpressionValue(token2, "{\n          firebaseInst…).await().token\n        }");
                    FirebaseInstallationsApi firebaseInstallationsApi3 = firebaseInstallationsApi;
                    ?? r93 = token2;
                    Task<String> id = firebaseInstallationsApi3.getId();
                    Intrinsics.checkNotNullExpressionValue(id, "firebaseInstallations.id");
                    installationId$Companion$create$1.L$0 = r93;
                    installationId$Companion$create$1.label = 2;
                    obj = TasksKt.await(id, installationId$Companion$create$1);
                    firebaseInstallationsApi = r93;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Intrinsics.checkNotNullExpressionValue(obj, "{\n          firebaseInst…ions.id.await()\n        }");
                    str = (String) obj;
                    ?? r922 = firebaseInstallationsApi;
                    return new InstallationId(str, r922, null);
                }
            }
            installationId$Companion$create$1 = new InstallationId$Companion$create$1(this, continuation);
            obj = installationId$Companion$create$1.result;
            coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i5 = installationId$Companion$create$1.label;
            String str2 = BuildConfig.FLAVOR;
            if (i5 != 0) {
            }
            String token22 = ((InstallationTokenResult) obj).getToken();
            Intrinsics.checkNotNullExpressionValue(token22, "{\n          firebaseInst…).await().token\n        }");
            FirebaseInstallationsApi firebaseInstallationsApi32 = firebaseInstallationsApi;
            ?? r932 = token22;
            Task<String> id2 = firebaseInstallationsApi32.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "firebaseInstallations.id");
            installationId$Companion$create$1.L$0 = r932;
            installationId$Companion$create$1.label = 2;
            obj = TasksKt.await(id2, installationId$Companion$create$1);
            firebaseInstallationsApi = r932;
            if (obj == coroutine_suspended) {
            }
            Intrinsics.checkNotNullExpressionValue(obj, "{\n          firebaseInst…ions.id.await()\n        }");
            str2 = (String) obj;
            ?? r9222 = firebaseInstallationsApi;
            return new InstallationId(str2, r9222, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ InstallationId(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getFid() {
        return this.fid;
    }

    private InstallationId(String str, String str2) {
        this.fid = str;
        this.authToken = str2;
    }
}
