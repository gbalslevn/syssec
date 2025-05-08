package androidx.compose.animation.core;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.KeyframeBaseEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0004B\t\b\u0004¢\u0006\u0004\b\u0005\u0010\u0006R,\u0010\t\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0001\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "T", "Landroidx/compose/animation/core/KeyframeBaseEntity;", "E", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "<set-?>", "durationMillis", "I", "getDurationMillis", "()I", "setDurationMillis", "(I)V", "delayMillis", "getDelayMillis", "setDelayMillis", "Landroidx/collection/MutableIntObjectMap;", "keyframes", "Landroidx/collection/MutableIntObjectMap;", "getKeyframes$animation_core_release", "()Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class KeyframesSpecBaseConfig<T, E extends KeyframeBaseEntity<T>> {
    private int delayMillis;
    private int durationMillis;
    private final MutableIntObjectMap<E> keyframes;

    public /* synthetic */ KeyframesSpecBaseConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int getDelayMillis() {
        return this.delayMillis;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final MutableIntObjectMap<E> getKeyframes$animation_core_release() {
        return this.keyframes;
    }

    public final void setDurationMillis(int i5) {
        this.durationMillis = i5;
    }

    private KeyframesSpecBaseConfig() {
        this.durationMillis = 300;
        this.keyframes = IntObjectMapKt.mutableIntObjectMapOf();
    }
}
