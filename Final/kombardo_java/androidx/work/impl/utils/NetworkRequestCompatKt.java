package androidx.work.impl.utils;

import android.net.NetworkRequest;
import android.os.Build;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"capabilitiesCompat", BuildConfig.FLAVOR, "Landroid/net/NetworkRequest;", "getCapabilitiesCompat", "(Landroid/net/NetworkRequest;)[I", "transportTypesCompat", "getTransportTypesCompat", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NetworkRequestCompatKt {
    public static final int[] getCapabilitiesCompat(NetworkRequest networkRequest) {
        Intrinsics.checkNotNullParameter(networkRequest, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return NetworkRequest31.INSTANCE.capabilities(networkRequest);
        }
        int[] iArr = {17, 5, 2, 10, 29, 19, 3, 32, 7, 4, 12, 23, 0, 33, 20, 11, 13, 18, 21, 15, 35, 34, 8, 1, 25, 14, 16, 6, 9};
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < 29; i5++) {
            int i6 = iArr[i5];
            if (NetworkRequest28.INSTANCE.hasCapability$work_runtime_release(networkRequest, i6)) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    public static final int[] getTransportTypesCompat(NetworkRequest networkRequest) {
        Intrinsics.checkNotNullParameter(networkRequest, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return NetworkRequest31.INSTANCE.transportTypes(networkRequest);
        }
        int[] iArr = {2, 0, 3, 6, 9, 8, 4, 1, 5};
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < 9; i5++) {
            int i6 = iArr[i5];
            if (NetworkRequest28.INSTANCE.hasTransport$work_runtime_release(networkRequest, i6)) {
                arrayList.add(Integer.valueOf(i6));
            }
        }
        return CollectionsKt.toIntArray(arrayList);
    }
}
