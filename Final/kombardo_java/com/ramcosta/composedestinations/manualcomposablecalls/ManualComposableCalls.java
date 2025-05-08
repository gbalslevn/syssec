package com.ramcosta.composedestinations.manualcomposablecalls;

import android.support.v4.media.session.a;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BO\b\u0000\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0004H\u0086\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0004R\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", BuildConfig.FLAVOR, "map", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/manualcomposablecalls/DestinationLambda;", "animations", "Lcom/ramcosta/composedestinations/spec/DestinationStyle$Animated;", "deepLinks", BuildConfig.FLAVOR, "Landroidx/navigation/NavDeepLink;", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "get", "route", "manualAnimation", "manualDeepLinks", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ManualComposableCalls {
    private final Map<String, DestinationStyle.Animated> animations;
    private final Map<String, List<NavDeepLink>> deepLinks;
    private final Map<String, DestinationLambda<?>> map;

    /* JADX WARN: Multi-variable type inference failed */
    public ManualComposableCalls(Map<String, ? extends DestinationLambda<?>> map, Map<String, ? extends DestinationStyle.Animated> animations, Map<String, ? extends List<NavDeepLink>> deepLinks) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(animations, "animations");
        Intrinsics.checkNotNullParameter(deepLinks, "deepLinks");
        this.map = map;
        this.animations = animations;
        this.deepLinks = deepLinks;
    }

    public final DestinationLambda<?> get(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        a.a(this.map.get(route));
        return null;
    }

    public final DestinationStyle.Animated manualAnimation(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.animations.get(route);
    }

    public final List<NavDeepLink> manualDeepLinks(String route) {
        Intrinsics.checkNotNullParameter(route, "route");
        return this.deepLinks.get(route);
    }
}
