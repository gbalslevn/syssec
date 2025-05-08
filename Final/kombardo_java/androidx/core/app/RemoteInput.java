package androidx.core.app;

/* loaded from: classes.dex */
public abstract class RemoteInput {
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api20Impl {
        public static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i5 = 0; i5 < remoteInputArr.length; i5++) {
            RemoteInput remoteInput = remoteInputArr[i5];
            remoteInputArr2[i5] = fromCompat((RemoteInput) null);
        }
        return remoteInputArr2;
    }

    static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
        return Api20Impl.fromCompat(remoteInput);
    }
}
