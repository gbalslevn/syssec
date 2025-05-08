package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\rJ\r\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\rJ\r\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\rJ\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\rJ\r\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\rJ\r\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\rJ\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\rJ\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\nJ\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\nJ\r\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\nJ\r\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\nJ\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\nJ\r\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\nJ\r\u0010 \u001a\u00020\b¢\u0006\u0004\b \u0010\nJ\u0018\u0010&\u001a\u00020#2\u0006\u0010\"\u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u001c\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\"\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010+R\u0018\u00101\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010+R\u0018\u00102\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010+R\u001a\u00103\u001a\u00020\u000b*\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u000b*\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/foundation/EdgeEffectWrapper;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "glowColor", "<init>", "(Landroid/content/Context;I)V", "Landroid/widget/EdgeEffect;", "createEdgeEffect", "()Landroid/widget/EdgeEffect;", BuildConfig.FLAVOR, "isTopStretched", "()Z", "isBottomStretched", "isLeftStretched", "isRightStretched", "isTopNegationStretched", "isBottomNegationStretched", "isLeftNegationStretched", "isRightNegationStretched", "isTopAnimating", "isBottomAnimating", "isLeftAnimating", "isRightAnimating", "getOrCreateTopEffect", "getOrCreateBottomEffect", "getOrCreateLeftEffect", "getOrCreateRightEffect", "getOrCreateTopEffectNegation", "getOrCreateBottomEffectNegation", "getOrCreateLeftEffectNegation", "getOrCreateRightEffectNegation", "Landroidx/compose/ui/unit/IntSize;", "size", BuildConfig.FLAVOR, "setSize-ozmzZPI", "(J)V", "setSize", "Landroid/content/Context;", "I", "J", "topEffect", "Landroid/widget/EdgeEffect;", "bottomEffect", "leftEffect", "rightEffect", "topEffectNegation", "bottomEffectNegation", "leftEffectNegation", "rightEffectNegation", "isStretched", "(Landroid/widget/EdgeEffect;)Z", "isAnimating", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class EdgeEffectWrapper {
    private EdgeEffect bottomEffect;
    private EdgeEffect bottomEffectNegation;
    private final Context context;
    private final int glowColor;
    private EdgeEffect leftEffect;
    private EdgeEffect leftEffectNegation;
    private EdgeEffect rightEffect;
    private EdgeEffect rightEffectNegation;
    private long size = IntSize.INSTANCE.m2665getZeroYbymL2g();
    private EdgeEffect topEffect;
    private EdgeEffect topEffectNegation;

    public EdgeEffectWrapper(Context context, int i5) {
        this.context = context;
        this.glowColor = i5;
    }

    private final EdgeEffect createEdgeEffect() {
        EdgeEffect create = EdgeEffectCompat.INSTANCE.create(this.context);
        create.setColor(this.glowColor);
        if (!IntSize.m2659equalsimpl0(this.size, IntSize.INSTANCE.m2665getZeroYbymL2g())) {
            create.setSize(IntSize.m2661getWidthimpl(this.size), IntSize.m2660getHeightimpl(this.size));
        }
        return create;
    }

    private final boolean isAnimating(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !edgeEffect.isFinished();
    }

    private final boolean isStretched(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !(EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) == 0.0f);
    }

    public final EdgeEffect getOrCreateBottomEffect() {
        EdgeEffect edgeEffect = this.bottomEffect;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect createEdgeEffect = createEdgeEffect();
        this.bottomEffect = createEdgeEffect;
        return createEdgeEffect;
    }

    public final EdgeEffect getOrCreateBottomEffectNegation() {
        EdgeEffect edgeEffect = this.bottomEffectNegation;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect createEdgeEffect = createEdgeEffect();
        this.bottomEffectNegation = createEdgeEffect;
        return createEdgeEffect;
    }

    public final EdgeEffect getOrCreateLeftEffect() {
        EdgeEffect edgeEffect = this.leftEffect;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect createEdgeEffect = createEdgeEffect();
        this.leftEffect = createEdgeEffect;
        return createEdgeEffect;
    }

    public final EdgeEffect getOrCreateLeftEffectNegation() {
        EdgeEffect edgeEffect = this.leftEffectNegation;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect createEdgeEffect = createEdgeEffect();
        this.leftEffectNegation = createEdgeEffect;
        return createEdgeEffect;
    }

    public final EdgeEffect getOrCreateRightEffect() {
        EdgeEffect edgeEffect = this.rightEffect;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect createEdgeEffect = createEdgeEffect();
        this.rightEffect = createEdgeEffect;
        return createEdgeEffect;
    }

    public final EdgeEffect getOrCreateRightEffectNegation() {
        EdgeEffect edgeEffect = this.rightEffectNegation;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect createEdgeEffect = createEdgeEffect();
        this.rightEffectNegation = createEdgeEffect;
        return createEdgeEffect;
    }

    public final EdgeEffect getOrCreateTopEffect() {
        EdgeEffect edgeEffect = this.topEffect;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect createEdgeEffect = createEdgeEffect();
        this.topEffect = createEdgeEffect;
        return createEdgeEffect;
    }

    public final EdgeEffect getOrCreateTopEffectNegation() {
        EdgeEffect edgeEffect = this.topEffectNegation;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect createEdgeEffect = createEdgeEffect();
        this.topEffectNegation = createEdgeEffect;
        return createEdgeEffect;
    }

    public final boolean isBottomAnimating() {
        return isAnimating(this.bottomEffect);
    }

    public final boolean isBottomNegationStretched() {
        return isStretched(this.bottomEffectNegation);
    }

    public final boolean isBottomStretched() {
        return isStretched(this.bottomEffect);
    }

    public final boolean isLeftAnimating() {
        return isAnimating(this.leftEffect);
    }

    public final boolean isLeftNegationStretched() {
        return isStretched(this.leftEffectNegation);
    }

    public final boolean isLeftStretched() {
        return isStretched(this.leftEffect);
    }

    public final boolean isRightAnimating() {
        return isAnimating(this.rightEffect);
    }

    public final boolean isRightNegationStretched() {
        return isStretched(this.rightEffectNegation);
    }

    public final boolean isRightStretched() {
        return isStretched(this.rightEffect);
    }

    public final boolean isTopAnimating() {
        return isAnimating(this.topEffect);
    }

    public final boolean isTopNegationStretched() {
        return isStretched(this.topEffectNegation);
    }

    public final boolean isTopStretched() {
        return isStretched(this.topEffect);
    }

    /* renamed from: setSize-ozmzZPI, reason: not valid java name */
    public final void m138setSizeozmzZPI(long size) {
        this.size = size;
        EdgeEffect edgeEffect = this.topEffect;
        if (edgeEffect != null) {
            edgeEffect.setSize(IntSize.m2661getWidthimpl(size), IntSize.m2660getHeightimpl(size));
        }
        EdgeEffect edgeEffect2 = this.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.setSize(IntSize.m2661getWidthimpl(size), IntSize.m2660getHeightimpl(size));
        }
        EdgeEffect edgeEffect3 = this.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.setSize(IntSize.m2660getHeightimpl(size), IntSize.m2661getWidthimpl(size));
        }
        EdgeEffect edgeEffect4 = this.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.setSize(IntSize.m2660getHeightimpl(size), IntSize.m2661getWidthimpl(size));
        }
        EdgeEffect edgeEffect5 = this.topEffectNegation;
        if (edgeEffect5 != null) {
            edgeEffect5.setSize(IntSize.m2661getWidthimpl(size), IntSize.m2660getHeightimpl(size));
        }
        EdgeEffect edgeEffect6 = this.bottomEffectNegation;
        if (edgeEffect6 != null) {
            edgeEffect6.setSize(IntSize.m2661getWidthimpl(size), IntSize.m2660getHeightimpl(size));
        }
        EdgeEffect edgeEffect7 = this.leftEffectNegation;
        if (edgeEffect7 != null) {
            edgeEffect7.setSize(IntSize.m2660getHeightimpl(size), IntSize.m2661getWidthimpl(size));
        }
        EdgeEffect edgeEffect8 = this.rightEffectNegation;
        if (edgeEffect8 != null) {
            edgeEffect8.setSize(IntSize.m2660getHeightimpl(size), IntSize.m2661getWidthimpl(size));
        }
    }
}
