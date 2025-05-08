package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.core.view.ViewKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0005\"\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\t\"(\u0010\r\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0011\u001a\u00020\u000b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000e\"\u0018\u0010\u0015\u001a\u00020\u0012*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroid/view/View;", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "listener", BuildConfig.FLAVOR, "addPoolingContainerListener", "(Landroid/view/View;Landroidx/customview/poolingcontainer/PoolingContainerListener;)V", "removePoolingContainerListener", BuildConfig.FLAVOR, "PoolingContainerListenerHolderTag", "I", "IsPoolingContainerTag", BuildConfig.FLAVOR, "value", "isPoolingContainer", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "getPoolingContainerListenerHolder", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "poolingContainerListenerHolder", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PoolingContainer {
    private static final int PoolingContainerListenerHolderTag = R$id.pooling_container_listener_holder_tag;
    private static final int IsPoolingContainerTag = R$id.is_pooling_container_tag;

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(View view, PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        getPoolingContainerListenerHolder(view).addListener(listener);
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        int i5 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i5);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i5, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final boolean isPoolingContainer(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(IsPoolingContainerTag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWithinPoolingContainer(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        for (Object obj : ViewKt.getAncestors(view)) {
            if ((obj instanceof View) && isPoolingContainer((View) obj)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(View view, PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        getPoolingContainerListenerHolder(view).removeListener(listener);
    }
}
