package coil.transition;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.drawable.CrossfadeDrawable;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Scale;
import coil.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcoil/transition/CrossfadeTransition;", "Lcoil/transition/Transition;", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "durationMillis", BuildConfig.FLAVOR, "preferExactIntrinsicSize", BuildConfig.FLAVOR, "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;IZ)V", "getDurationMillis", "()I", "getPreferExactIntrinsicSize", "()Z", "transition", BuildConfig.FLAVOR, "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CrossfadeTransition implements Transition {
    private final int durationMillis;
    private final boolean preferExactIntrinsicSize;
    private final ImageResult result;
    private final TransitionTarget target;

    public CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i5, boolean z5) {
        this.target = transitionTarget;
        this.result = imageResult;
        this.durationMillis = i5;
        this.preferExactIntrinsicSize = z5;
        if (i5 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    @Override // coil.transition.Transition
    public void transition() {
        Drawable drawable = this.target.getDrawable();
        Drawable drawable2 = this.result.getDrawable();
        Scale scale = this.result.getRequest().getScale();
        int i5 = this.durationMillis;
        ImageResult imageResult = this.result;
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable(drawable, drawable2, scale, i5, ((imageResult instanceof SuccessResult) && ((SuccessResult) imageResult).getIsPlaceholderCached()) ? false : true, this.preferExactIntrinsicSize);
        ImageResult imageResult2 = this.result;
        if (imageResult2 instanceof SuccessResult) {
            this.target.onSuccess(crossfadeDrawable);
        } else if (imageResult2 instanceof ErrorResult) {
            this.target.onError(crossfadeDrawable);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcoil/transition/CrossfadeTransition$Factory;", "Lcoil/transition/Transition$Factory;", BuildConfig.FLAVOR, "durationMillis", BuildConfig.FLAVOR, "preferExactIntrinsicSize", "<init>", "(IZ)V", "Lcoil/transition/TransitionTarget;", "target", "Lcoil/request/ImageResult;", "result", "Lcoil/transition/Transition;", "create", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;)Lcoil/transition/Transition;", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "getDurationMillis", "Z", "getPreferExactIntrinsicSize", "()Z", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Factory implements Transition.Factory {
        private final int durationMillis;
        private final boolean preferExactIntrinsicSize;

        public Factory(int i5, boolean z5) {
            this.durationMillis = i5;
            this.preferExactIntrinsicSize = z5;
            if (i5 <= 0) {
                throw new IllegalArgumentException("durationMillis must be > 0.");
            }
        }

        @Override // coil.transition.Transition.Factory
        public Transition create(TransitionTarget target, ImageResult result) {
            if ((result instanceof SuccessResult) && ((SuccessResult) result).getDataSource() != DataSource.MEMORY_CACHE) {
                return new CrossfadeTransition(target, result, this.durationMillis, this.preferExactIntrinsicSize);
            }
            return Transition.Factory.NONE.create(target, result);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Factory) {
                Factory factory = (Factory) other;
                if (this.durationMillis == factory.durationMillis && this.preferExactIntrinsicSize == factory.preferExactIntrinsicSize) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.durationMillis * 31) + Boolean.hashCode(this.preferExactIntrinsicSize);
        }

        public /* synthetic */ Factory(int i5, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? 100 : i5, (i6 & 2) != 0 ? false : z5);
        }
    }
}
