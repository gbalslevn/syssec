package androidx.compose.animation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\b\u0081\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'R'\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroidx/compose/animation/TransitionData;", BuildConfig.FLAVOR, "Landroidx/compose/animation/Fade;", "fade", "Landroidx/compose/animation/Slide;", "slide", "Landroidx/compose/animation/ChangeSize;", "changeSize", "Landroidx/compose/animation/Scale;", "scale", BuildConfig.FLAVOR, "hold", BuildConfig.FLAVOR, "effectsMap", "<init>", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;Landroidx/compose/animation/Scale;ZLjava/util/Map;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/animation/Fade;", "getFade", "()Landroidx/compose/animation/Fade;", "Landroidx/compose/animation/Slide;", "getSlide", "()Landroidx/compose/animation/Slide;", "Landroidx/compose/animation/ChangeSize;", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "Landroidx/compose/animation/Scale;", "getScale", "()Landroidx/compose/animation/Scale;", "Z", "getHold", "()Z", "Ljava/util/Map;", "getEffectsMap", "()Ljava/util/Map;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TransitionData {
    private final ChangeSize changeSize;
    private final Map<Object, Object> effectsMap;
    private final Fade fade;
    private final boolean hold;
    private final Scale scale;
    private final Slide slide;

    public TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale, boolean z5, Map<Object, Object> map) {
        this.fade = fade;
        this.slide = slide;
        this.changeSize = changeSize;
        this.scale = scale;
        this.hold = z5;
        this.effectsMap = map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransitionData)) {
            return false;
        }
        TransitionData transitionData = (TransitionData) other;
        return Intrinsics.areEqual(this.fade, transitionData.fade) && Intrinsics.areEqual(this.slide, transitionData.slide) && Intrinsics.areEqual(this.changeSize, transitionData.changeSize) && Intrinsics.areEqual(this.scale, transitionData.scale) && this.hold == transitionData.hold && Intrinsics.areEqual(this.effectsMap, transitionData.effectsMap);
    }

    public final ChangeSize getChangeSize() {
        return this.changeSize;
    }

    public final Map<Object, Object> getEffectsMap() {
        return this.effectsMap;
    }

    public final Fade getFade() {
        return this.fade;
    }

    public final boolean getHold() {
        return this.hold;
    }

    public final Scale getScale() {
        return this.scale;
    }

    public final Slide getSlide() {
        return this.slide;
    }

    public int hashCode() {
        Fade fade = this.fade;
        int hashCode = (fade == null ? 0 : fade.hashCode()) * 31;
        Slide slide = this.slide;
        int hashCode2 = (hashCode + (slide == null ? 0 : slide.hashCode())) * 31;
        ChangeSize changeSize = this.changeSize;
        int hashCode3 = (hashCode2 + (changeSize == null ? 0 : changeSize.hashCode())) * 31;
        Scale scale = this.scale;
        return ((((hashCode3 + (scale != null ? scale.hashCode() : 0)) * 31) + Boolean.hashCode(this.hold)) * 31) + this.effectsMap.hashCode();
    }

    public String toString() {
        return "TransitionData(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ", hold=" + this.hold + ", effectsMap=" + this.effectsMap + ')';
    }

    public /* synthetic */ TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale, boolean z5, Map map, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : fade, (i5 & 2) != 0 ? null : slide, (i5 & 4) != 0 ? null : changeSize, (i5 & 8) == 0 ? scale : null, (i5 & 16) != 0 ? false : z5, (i5 & 32) != 0 ? MapsKt.emptyMap() : map);
    }
}
