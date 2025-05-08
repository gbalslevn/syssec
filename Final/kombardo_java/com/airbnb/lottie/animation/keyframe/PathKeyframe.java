package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* loaded from: classes.dex */
public class PathKeyframe extends Keyframe<PointF> {
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.xInterpolator, keyframe.yInterpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void createPath() {
        T t5;
        T t6;
        T t7 = this.endValue;
        boolean z5 = (t7 == 0 || (t6 = this.startValue) == 0 || !((PointF) t6).equals(((PointF) t7).x, ((PointF) t7).y)) ? false : true;
        T t8 = this.startValue;
        if (t8 == 0 || (t5 = this.endValue) == 0 || z5) {
            return;
        }
        Keyframe<PointF> keyframe = this.pointKeyFrame;
        this.path = Utils.createPath((PointF) t8, (PointF) t5, keyframe.pathCp1, keyframe.pathCp2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path getPath() {
        return this.path;
    }
}
