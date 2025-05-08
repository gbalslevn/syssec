package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    private static final float ROUNDED_CORNER_MAGIC_NUMBER = 0.5519f;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> roundedCorners;
    private ShapeData shapeData;

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.lottieDrawable = lottieDrawable;
        this.name = roundedCorners.getName();
        BaseKeyframeAnimation<Float, Float> createAnimation = roundedCorners.getCornerRadius().createAnimation();
        this.roundedCorners = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    private static int floorDiv(int i5, int i6) {
        int i7 = i5 / i6;
        return ((i5 ^ i6) >= 0 || i6 * i7 == i5) ? i7 : i7 - 1;
    }

    private static int floorMod(int i5, int i6) {
        return i5 - (floorDiv(i5, i6) * i6);
    }

    private ShapeData getShapeData(ShapeData shapeData) {
        List<CubicCurveData> curves = shapeData.getCurves();
        boolean isClosed = shapeData.isClosed();
        int size = curves.size() - 1;
        int i5 = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = curves.get(size);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(size - 1, curves.size()));
            PointF vertex = (size != 0 || isClosed) ? cubicCurveData2.getVertex() : shapeData.getInitialPoint();
            i5 = (((size != 0 || isClosed) ? cubicCurveData2.getControlPoint2() : vertex).equals(vertex) && cubicCurveData.getControlPoint1().equals(vertex) && !(!shapeData.isClosed() && size == 0 && size == curves.size() - 1)) ? i5 + 2 : i5 + 1;
            size--;
        }
        ShapeData shapeData2 = this.shapeData;
        if (shapeData2 == null || shapeData2.getCurves().size() != i5) {
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = 0; i6 < i5; i6++) {
                arrayList.add(new CubicCurveData());
            }
            this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.shapeData.setClosed(isClosed);
        return this.shapeData;
    }

    public BaseKeyframeAnimation<Float, Float> getRoundedCorners() {
        return this.roundedCorners;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
    
        if (r7 == (r0.size() - 1)) goto L27;
     */
    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShapeData modifyShape(ShapeData shapeData) {
        List<CubicCurveData> list;
        List<CubicCurveData> curves = shapeData.getCurves();
        if (curves.size() <= 2) {
            return shapeData;
        }
        float floatValue = this.roundedCorners.getValue().floatValue();
        if (floatValue == 0.0f) {
            return shapeData;
        }
        ShapeData shapeData2 = getShapeData(shapeData);
        shapeData2.setInitialPoint(shapeData.getInitialPoint().x, shapeData.getInitialPoint().y);
        List<CubicCurveData> curves2 = shapeData2.getCurves();
        boolean isClosed = shapeData.isClosed();
        int i5 = 0;
        int i6 = 0;
        while (i5 < curves.size()) {
            CubicCurveData cubicCurveData = curves.get(i5);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(i5 - 1, curves.size()));
            CubicCurveData cubicCurveData3 = curves.get(floorMod(i5 - 2, curves.size()));
            PointF vertex = (i5 != 0 || isClosed) ? cubicCurveData2.getVertex() : shapeData.getInitialPoint();
            PointF controlPoint2 = (i5 != 0 || isClosed) ? cubicCurveData2.getControlPoint2() : vertex;
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF vertex2 = cubicCurveData3.getVertex();
            PointF vertex3 = cubicCurveData.getVertex();
            boolean z5 = !shapeData.isClosed() && i5 == 0;
            if (controlPoint2.equals(vertex) && controlPoint1.equals(vertex) && !z5) {
                float f5 = vertex.x;
                float f6 = f5 - vertex2.x;
                float f7 = vertex.y;
                float f8 = f7 - vertex2.y;
                float f9 = vertex3.x - f5;
                float f10 = vertex3.y - f7;
                list = curves;
                float hypot = (float) Math.hypot(f6, f8);
                float hypot2 = (float) Math.hypot(f9, f10);
                float min = Math.min(floatValue / hypot, 0.5f);
                float min2 = Math.min(floatValue / hypot2, 0.5f);
                float f11 = vertex.x;
                float f12 = ((vertex2.x - f11) * min) + f11;
                float f13 = vertex.y;
                float f14 = ((vertex2.y - f13) * min) + f13;
                float f15 = ((vertex3.x - f11) * min2) + f11;
                float f16 = ((vertex3.y - f13) * min2) + f13;
                float f17 = f12 - ((f12 - f11) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f18 = f14 - ((f14 - f13) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f19 = f15 - ((f15 - f11) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f20 = f16 - ((f16 - f13) * ROUNDED_CORNER_MAGIC_NUMBER);
                CubicCurveData cubicCurveData4 = curves2.get(floorMod(i6 - 1, curves2.size()));
                CubicCurveData cubicCurveData5 = curves2.get(i6);
                cubicCurveData4.setControlPoint2(f12, f14);
                cubicCurveData4.setVertex(f12, f14);
                if (i5 == 0) {
                    shapeData2.setInitialPoint(f12, f14);
                }
                cubicCurveData5.setControlPoint1(f17, f18);
                CubicCurveData cubicCurveData6 = curves2.get(i6 + 1);
                cubicCurveData5.setControlPoint2(f19, f20);
                cubicCurveData5.setVertex(f15, f16);
                cubicCurveData6.setControlPoint1(f15, f16);
                i6 += 2;
            } else {
                list = curves;
                CubicCurveData cubicCurveData7 = curves2.get(floorMod(i6 - 1, curves2.size()));
                CubicCurveData cubicCurveData8 = curves2.get(i6);
                cubicCurveData7.setControlPoint2(cubicCurveData2.getControlPoint2().x, cubicCurveData2.getControlPoint2().y);
                cubicCurveData7.setVertex(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                cubicCurveData8.setControlPoint1(cubicCurveData.getControlPoint1().x, cubicCurveData.getControlPoint1().y);
                i6++;
            }
            i5++;
            curves = list;
        }
        return shapeData2;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }
}
