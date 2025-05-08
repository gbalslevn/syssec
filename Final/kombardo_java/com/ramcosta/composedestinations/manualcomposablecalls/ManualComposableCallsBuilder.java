package com.ramcosta.composedestinations.manualcomposablecalls;

import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.spec.DestinationStyle;
import com.ramcosta.composedestinations.spec.NavHostEngine;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R&\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCallsBuilder;", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", "engineType", "<init>", "(Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;)V", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "build$compose_destinations_release", "()Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "build", "Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", "getEngineType", "()Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", "getEngineType$annotations", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/manualcomposablecalls/DestinationLambda;", "map", "Ljava/util/Map;", "Lcom/ramcosta/composedestinations/spec/DestinationStyle$Animated;", "animations", BuildConfig.FLAVOR, "Landroidx/navigation/NavDeepLink;", "deepLinks", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ManualComposableCallsBuilder {
    private final Map<String, DestinationStyle.Animated> animations;
    private final Map<String, List<NavDeepLink>> deepLinks;
    private final NavHostEngine.Type engineType;
    private final Map<String, DestinationLambda<?>> map;

    public ManualComposableCallsBuilder(NavHostEngine.Type engineType) {
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        this.engineType = engineType;
        this.map = new LinkedHashMap();
        this.animations = new LinkedHashMap();
        this.deepLinks = new LinkedHashMap();
    }

    public final ManualComposableCalls build$compose_destinations_release() {
        return new ManualComposableCalls(this.map, this.animations, this.deepLinks);
    }
}
