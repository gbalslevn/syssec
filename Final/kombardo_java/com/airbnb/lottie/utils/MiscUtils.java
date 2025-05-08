package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MiscUtils {
    private static final PointF pathFromDataCurrentPoint = new PointF();

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static int clamp(int i5, int i6, int i7) {
        return Math.max(i6, Math.min(i7, i5));
    }

    public static boolean contains(float f5, float f6, float f7) {
        return f5 >= f6 && f5 <= f7;
    }

    private static int floorDiv(int i5, int i6) {
        int i7 = i5 / i6;
        return (((i5 ^ i6) >= 0) || i5 % i6 == 0) ? i7 : i7 - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int floorMod(float f5, float f6) {
        return floorMod((int) f5, (int) f6);
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        path.reset();
        PointF initialPoint = shapeData.getInitialPoint();
        path.moveTo(initialPoint.x, initialPoint.y);
        pathFromDataCurrentPoint.set(initialPoint.x, initialPoint.y);
        for (int i5 = 0; i5 < shapeData.getCurves().size(); i5++) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(i5);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF pointF = pathFromDataCurrentPoint;
            if (controlPoint1.equals(pointF) && controlPoint2.equals(vertex)) {
                path.lineTo(vertex.x, vertex.y);
            } else {
                path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, vertex.x, vertex.y);
            }
            pointF.set(vertex.x, vertex.y);
        }
        if (shapeData.isClosed()) {
            path.close();
        }
    }

    public static float lerp(float f5, float f6, float f7) {
        return f5 + (f7 * (f6 - f5));
    }

    public static void resolveKeyPath(KeyPath keyPath, int i5, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.fullyResolvesTo(keyPathElementContent.getName(), i5)) {
            list.add(keyPath2.addKey(keyPathElementContent.getName()).resolve(keyPathElementContent));
        }
    }

    public static float clamp(float f5, float f6, float f7) {
        return Math.max(f6, Math.min(f7, f5));
    }

    private static int floorMod(int i5, int i6) {
        return i5 - (i6 * floorDiv(i5, i6));
    }

    public static int lerp(int i5, int i6, float f5) {
        return (int) (i5 + (f5 * (i6 - i5)));
    }
}
