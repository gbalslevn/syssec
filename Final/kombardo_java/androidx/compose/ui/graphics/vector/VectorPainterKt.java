package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a&\u0010\f\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a*\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a$\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aD\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010!\u001a\u00020 H\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a'\u0010)\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'H\u0000¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010-\u001a\u00020'*\u00020'2\u0006\u0010,\u001a\u00020+H\u0000¢\u0006\u0004\b-\u0010.\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "image", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "rememberVectorPainter", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Dp;", "defaultWidth", "defaultHeight", "Landroidx/compose/ui/geometry/Size;", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "obtainSizePx", "defaultSize", BuildConfig.FLAVOR, "viewportWidth", "viewportHeight", "obtainViewportSize-Pq9zytI", "(JFF)J", "obtainViewportSize", "Landroidx/compose/ui/graphics/Color;", "tintColor", "Landroidx/compose/ui/graphics/BlendMode;", "tintBlendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "createColorFilter", "viewportSize", BuildConfig.FLAVOR, "name", "intrinsicColorFilter", BuildConfig.FLAVOR, "autoMirror", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "configureVectorPainter", "density", "imageVector", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "root", "createVectorPainterFromImageVector", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/vector/GroupComponent;)Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "currentGroup", "createGroupComponent", "(Landroidx/compose/ui/graphics/vector/GroupComponent;Landroidx/compose/ui/graphics/vector/VectorGroup;)Landroidx/compose/ui/graphics/vector/GroupComponent;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class VectorPainterKt {
    /* renamed from: configureVectorPainter-T4PVSW8, reason: not valid java name */
    public static final VectorPainter m1769configureVectorPainterT4PVSW8(VectorPainter vectorPainter, long j5, long j6, String str, ColorFilter colorFilter, boolean z5) {
        vectorPainter.m1767setSizeuvyYCjk$ui_release(j5);
        vectorPainter.setAutoMirror$ui_release(z5);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.m1768setViewportSizeuvyYCjk$ui_release(j6);
        vectorPainter.setName$ui_release(str);
        return vectorPainter;
    }

    /* renamed from: createColorFilter-xETnrds, reason: not valid java name */
    private static final ColorFilter m1770createColorFilterxETnrds(long j5, int i5) {
        if (j5 != 16) {
            return ColorFilter.INSTANCE.m1504tintxETnrds(j5, i5);
        }
        return null;
    }

    public static final GroupComponent createGroupComponent(GroupComponent groupComponent, VectorGroup vectorGroup) {
        int size = vectorGroup.getSize();
        for (int i5 = 0; i5 < size; i5++) {
            VectorNode vectorNode = vectorGroup.get(i5);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.setPathData(vectorPath.getPathData());
                pathComponent.m1759setPathFillTypeoQ8Xj4U(vectorPath.getPathFillType());
                pathComponent.setName(vectorPath.getName());
                pathComponent.setFill(vectorPath.getFill());
                pathComponent.setFillAlpha(vectorPath.getFillAlpha());
                pathComponent.setStroke(vectorPath.getStroke());
                pathComponent.setStrokeAlpha(vectorPath.getStrokeAlpha());
                pathComponent.setStrokeLineWidth(vectorPath.getStrokeLineWidth());
                pathComponent.m1760setStrokeLineCapBeK7IIE(vectorPath.getStrokeLineCap());
                pathComponent.m1761setStrokeLineJoinWw9F2mQ(vectorPath.getStrokeLineJoin());
                pathComponent.setStrokeLineMiter(vectorPath.getStrokeLineMiter());
                pathComponent.setTrimPathStart(vectorPath.getTrimPathStart());
                pathComponent.setTrimPathEnd(vectorPath.getTrimPathEnd());
                pathComponent.setTrimPathOffset(vectorPath.getTrimPathOffset());
                groupComponent.insertAt(i5, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.setName(vectorGroup2.getName());
                groupComponent2.setRotation(vectorGroup2.getRotation());
                groupComponent2.setScaleX(vectorGroup2.getScaleX());
                groupComponent2.setScaleY(vectorGroup2.getScaleY());
                groupComponent2.setTranslationX(vectorGroup2.getTranslationX());
                groupComponent2.setTranslationY(vectorGroup2.getTranslationY());
                groupComponent2.setPivotX(vectorGroup2.getPivotX());
                groupComponent2.setPivotY(vectorGroup2.getPivotY());
                groupComponent2.setClipPathData(vectorGroup2.getClipPathData());
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i5, groupComponent2);
            }
        }
        return groupComponent;
    }

    public static final VectorPainter createVectorPainterFromImageVector(Density density, ImageVector imageVector, GroupComponent groupComponent) {
        long m1771obtainSizePxVpY3zN4 = m1771obtainSizePxVpY3zN4(density, imageVector.getDefaultWidth(), imageVector.getDefaultHeight());
        return m1769configureVectorPainterT4PVSW8(new VectorPainter(groupComponent), m1771obtainSizePxVpY3zN4, m1772obtainViewportSizePq9zytI(m1771obtainSizePxVpY3zN4, imageVector.getViewportWidth(), imageVector.getViewportHeight()), imageVector.getName(), m1770createColorFilterxETnrds(imageVector.getTintColor(), imageVector.getTintBlendMode()), imageVector.getAutoMirror());
    }

    /* renamed from: obtainSizePx-VpY3zN4, reason: not valid java name */
    private static final long m1771obtainSizePxVpY3zN4(Density density, float f5, float f6) {
        return SizeKt.Size(density.mo212toPx0680j_4(f5), density.mo212toPx0680j_4(f6));
    }

    /* renamed from: obtainViewportSize-Pq9zytI, reason: not valid java name */
    private static final long m1772obtainViewportSizePq9zytI(long j5, float f5, float f6) {
        if (Float.isNaN(f5)) {
            f5 = Size.m1377getWidthimpl(j5);
        }
        if (Float.isNaN(f6)) {
            f6 = Size.m1375getHeightimpl(j5);
        }
        return SizeKt.Size(f5, f6);
    }

    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i5, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:171)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        float genId = imageVector.getGenId();
        float density2 = density.getDensity();
        boolean changed = composer.changed((Float.floatToRawIntBits(density2) & 4294967295L) | (Float.floatToRawIntBits(genId) << 32));
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.getRoot());
            Unit unit = Unit.INSTANCE;
            rememberedValue = createVectorPainterFromImageVector(density, imageVector, groupComponent);
            composer.updateRememberedValue(rememberedValue);
        }
        VectorPainter vectorPainter = (VectorPainter) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return vectorPainter;
    }
}
