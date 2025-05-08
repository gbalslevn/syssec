package com.caverock.androidsvg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.adjust.sdk.Constants;
import com.caverock.androidsvg.CSSParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public class SVG {
    private static final int DEFAULT_PICTURE_HEIGHT = 512;
    private static final int DEFAULT_PICTURE_WIDTH = 512;
    private static final long SPECIFIED_ALL = -1;
    private static final double SQRT2 = 1.414213562373095d;
    private static final String VERSION = "1.4";
    private static boolean enableInternalEntities = true;
    private static SVGExternalFileResolver externalFileResolver;
    private Svg rootElement = null;
    private String title = BuildConfig.FLAVOR;
    private String desc = BuildConfig.FLAVOR;
    private float renderDPI = 96.0f;
    private CSSParser.Ruleset cssRules = new CSSParser.Ruleset();
    private Map<String, SvgElementBase> idToElementMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.SVG$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$com$caverock$androidsvg$SVG$Unit = iArr;
            try {
                iArr[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Unit[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    static class CSSClipRect {
        Length bottom;
        Length left;
        Length right;
        Length top;

        /* JADX INFO: Access modifiers changed from: package-private */
        public CSSClipRect(Length length, Length length2, Length length3, Length length4) {
            this.top = length;
            this.right = length2;
            this.bottom = length3;
            this.left = length4;
        }
    }

    /* loaded from: classes.dex */
    static class Circle extends GraphicsElement {
        Length cx;
        Length cy;

        /* renamed from: r, reason: collision with root package name */
        Length f4241r;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "circle";
        }
    }

    /* loaded from: classes.dex */
    static class ClipPath extends Group implements NotDirectlyRendered {
        Boolean clipPathUnitsAreUser;

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "clipPath";
        }
    }

    /* loaded from: classes.dex */
    static class Colour extends SvgPaint {
        static final Colour BLACK = new Colour(-16777216);
        static final Colour TRANSPARENT = new Colour(0);
        int colour;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Colour(int i5) {
            this.colour = i5;
        }

        public String toString() {
            return String.format("#%08x", Integer.valueOf(this.colour));
        }
    }

    /* loaded from: classes.dex */
    static class CurrentColor extends SvgPaint {
        private static CurrentColor instance = new CurrentColor();

        private CurrentColor() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static CurrentColor getInstance() {
            return instance;
        }
    }

    /* loaded from: classes.dex */
    static class Defs extends Group implements NotDirectlyRendered {
        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "defs";
        }
    }

    /* loaded from: classes.dex */
    static class Ellipse extends GraphicsElement {
        Length cx;
        Length cy;
        Length rx;
        Length ry;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "ellipse";
        }
    }

    /* loaded from: classes.dex */
    static abstract class GradientElement extends SvgElementBase implements SvgContainer {
        List<SvgObject> children = new ArrayList();
        Matrix gradientTransform;
        Boolean gradientUnitsAreUser;
        String href;
        GradientSpread spreadMethod;

        GradientElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) {
            if (svgObject instanceof Stop) {
                this.children.add(svgObject);
                return;
            }
            throw new SVGParseException("Gradient elements cannot contain " + svgObject + " elements.");
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }
    }

    /* loaded from: classes.dex */
    enum GradientSpread {
        pad,
        reflect,
        repeat
    }

    /* loaded from: classes.dex */
    static abstract class GraphicsElement extends SvgConditionalElement implements HasTransform {
        Matrix transform;

        GraphicsElement() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* loaded from: classes.dex */
    static class Group extends SvgConditionalContainer implements HasTransform {
        Matrix transform;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "group";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* loaded from: classes.dex */
    interface HasTransform {
        void setTransform(Matrix matrix);
    }

    /* loaded from: classes.dex */
    static class Image extends SvgPreserveAspectRatioContainer implements HasTransform {
        Length height;
        String href;
        Matrix transform;
        Length width;

        /* renamed from: x, reason: collision with root package name */
        Length f4242x;

        /* renamed from: y, reason: collision with root package name */
        Length f4243y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "image";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Length implements Cloneable {
        Unit unit;
        float value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Length(float f5, Unit unit) {
            this.value = f5;
            this.unit = unit;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue() {
            return this.value;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValueX(SVGAndroidRenderer sVGAndroidRenderer) {
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Unit[this.unit.ordinal()]) {
                case 1:
                    return this.value;
                case 2:
                    return this.value * sVGAndroidRenderer.getCurrentFontSize();
                case 3:
                    return this.value * sVGAndroidRenderer.getCurrentFontXHeight();
                case 4:
                    return this.value * sVGAndroidRenderer.getDPI();
                case 5:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 2.54f;
                case 6:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 25.4f;
                case 7:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 72.0f;
                case 8:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 6.0f;
                case 9:
                    Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                    return currentViewPortInUserUnits == null ? this.value : (this.value * currentViewPortInUserUnits.width) / 100.0f;
                default:
                    return this.value;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValueY(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit != Unit.percent) {
                return floatValueX(sVGAndroidRenderer);
            }
            Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
            return currentViewPortInUserUnits == null ? this.value : (this.value * currentViewPortInUserUnits.height) / 100.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isNegative() {
            return this.value < 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isZero() {
            return this.value == 0.0f;
        }

        public String toString() {
            return String.valueOf(this.value) + this.unit;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                if (currentViewPortInUserUnits == null) {
                    return this.value;
                }
                float f5 = currentViewPortInUserUnits.width;
                if (f5 == currentViewPortInUserUnits.height) {
                    return (this.value * f5) / 100.0f;
                }
                return (this.value * ((float) (Math.sqrt((f5 * f5) + (r6 * r6)) / SVG.SQRT2))) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Length(float f5) {
            this.value = f5;
            this.unit = Unit.px;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer, float f5) {
            if (this.unit == Unit.percent) {
                return (this.value * f5) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float floatValue(float f5) {
            int i5 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Unit[this.unit.ordinal()];
            if (i5 != 1) {
                switch (i5) {
                    case 4:
                        return this.value * f5;
                    case 5:
                        return (this.value * f5) / 2.54f;
                    case 6:
                        return (this.value * f5) / 25.4f;
                    case 7:
                        return (this.value * f5) / 72.0f;
                    case 8:
                        return (this.value * f5) / 6.0f;
                    default:
                        return this.value;
                }
            }
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    static class Line extends GraphicsElement {

        /* renamed from: x1, reason: collision with root package name */
        Length f4244x1;

        /* renamed from: x2, reason: collision with root package name */
        Length f4245x2;

        /* renamed from: y1, reason: collision with root package name */
        Length f4246y1;

        /* renamed from: y2, reason: collision with root package name */
        Length f4247y2;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "line";
        }
    }

    /* loaded from: classes.dex */
    static class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length markerHeight;
        boolean markerUnitsAreUser;
        Length markerWidth;
        Float orient;
        Length refX;
        Length refY;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "marker";
        }
    }

    /* loaded from: classes.dex */
    static class Mask extends SvgConditionalContainer implements NotDirectlyRendered {
        Length height;
        Boolean maskContentUnitsAreUser;
        Boolean maskUnitsAreUser;
        Length width;

        /* renamed from: x, reason: collision with root package name */
        Length f4248x;

        /* renamed from: y, reason: collision with root package name */
        Length f4249y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "mask";
        }
    }

    /* loaded from: classes.dex */
    interface NotDirectlyRendered {
    }

    /* loaded from: classes.dex */
    static class PaintReference extends SvgPaint {
        SvgPaint fallback;
        String href;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public String toString() {
            return this.href + " " + this.fallback;
        }
    }

    /* loaded from: classes.dex */
    static class Path extends GraphicsElement {

        /* renamed from: d, reason: collision with root package name */
        PathDefinition f4250d;
        Float pathLength;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "path";
        }
    }

    /* loaded from: classes.dex */
    static class PathDefinition implements PathInterface {
        private static final byte ARCTO = 4;
        private static final byte CLOSE = 8;
        private static final byte CUBICTO = 2;
        private static final byte LINETO = 1;
        private static final byte MOVETO = 0;
        private static final byte QUADTO = 3;
        private int commandsLength = 0;
        private int coordsLength = 0;
        private byte[] commands = new byte[8];
        private float[] coords = new float[16];

        private void addCommand(byte b5) {
            int i5 = this.commandsLength;
            byte[] bArr = this.commands;
            if (i5 == bArr.length) {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.commands = bArr2;
            }
            byte[] bArr3 = this.commands;
            int i6 = this.commandsLength;
            this.commandsLength = i6 + 1;
            bArr3[i6] = b5;
        }

        private void coordsEnsure(int i5) {
            float[] fArr = this.coords;
            if (fArr.length < this.coordsLength + i5) {
                float[] fArr2 = new float[fArr.length * 2];
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                this.coords = fArr2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f5, float f6, float f7, boolean z5, boolean z6, float f8, float f9) {
            addCommand((byte) ((z5 ? 2 : 0) | 4 | (z6 ? 1 : 0)));
            coordsEnsure(5);
            float[] fArr = this.coords;
            int i5 = this.coordsLength;
            int i6 = i5 + 1;
            this.coordsLength = i6;
            fArr[i5] = f5;
            int i7 = i5 + 2;
            this.coordsLength = i7;
            fArr[i6] = f6;
            int i8 = i5 + 3;
            this.coordsLength = i8;
            fArr[i7] = f7;
            int i9 = i5 + 4;
            this.coordsLength = i9;
            fArr[i8] = f8;
            this.coordsLength = i5 + 5;
            fArr[i9] = f9;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            addCommand(CLOSE);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f5, float f6, float f7, float f8, float f9, float f10) {
            addCommand((byte) 2);
            coordsEnsure(6);
            float[] fArr = this.coords;
            int i5 = this.coordsLength;
            int i6 = i5 + 1;
            this.coordsLength = i6;
            fArr[i5] = f5;
            int i7 = i5 + 2;
            this.coordsLength = i7;
            fArr[i6] = f6;
            int i8 = i5 + 3;
            this.coordsLength = i8;
            fArr[i7] = f7;
            int i9 = i5 + 4;
            this.coordsLength = i9;
            fArr[i8] = f8;
            int i10 = i5 + 5;
            this.coordsLength = i10;
            fArr[i9] = f9;
            this.coordsLength = i5 + 6;
            fArr[i10] = f10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void enumeratePath(PathInterface pathInterface) {
            int i5 = 0;
            for (int i6 = 0; i6 < this.commandsLength; i6++) {
                byte b5 = this.commands[i6];
                if (b5 == 0) {
                    float[] fArr = this.coords;
                    int i7 = i5 + 1;
                    float f5 = fArr[i5];
                    i5 += 2;
                    pathInterface.moveTo(f5, fArr[i7]);
                } else if (b5 == 1) {
                    float[] fArr2 = this.coords;
                    int i8 = i5 + 1;
                    float f6 = fArr2[i5];
                    i5 += 2;
                    pathInterface.lineTo(f6, fArr2[i8]);
                } else if (b5 == 2) {
                    float[] fArr3 = this.coords;
                    float f7 = fArr3[i5];
                    float f8 = fArr3[i5 + 1];
                    float f9 = fArr3[i5 + 2];
                    float f10 = fArr3[i5 + 3];
                    int i9 = i5 + 5;
                    float f11 = fArr3[i5 + 4];
                    i5 += 6;
                    pathInterface.cubicTo(f7, f8, f9, f10, f11, fArr3[i9]);
                } else if (b5 == 3) {
                    float[] fArr4 = this.coords;
                    float f12 = fArr4[i5];
                    float f13 = fArr4[i5 + 1];
                    int i10 = i5 + 3;
                    float f14 = fArr4[i5 + 2];
                    i5 += 4;
                    pathInterface.quadTo(f12, f13, f14, fArr4[i10]);
                } else if (b5 != 8) {
                    boolean z5 = (b5 & 2) != 0;
                    boolean z6 = (b5 & 1) != 0;
                    float[] fArr5 = this.coords;
                    float f15 = fArr5[i5];
                    float f16 = fArr5[i5 + 1];
                    float f17 = fArr5[i5 + 2];
                    int i11 = i5 + 4;
                    float f18 = fArr5[i5 + 3];
                    i5 += 5;
                    pathInterface.arcTo(f15, f16, f17, z5, z6, f18, fArr5[i11]);
                } else {
                    pathInterface.close();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.commandsLength == 0;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f5, float f6) {
            addCommand((byte) 1);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i5 = this.coordsLength;
            int i6 = i5 + 1;
            this.coordsLength = i6;
            fArr[i5] = f5;
            this.coordsLength = i5 + 2;
            fArr[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f5, float f6) {
            addCommand((byte) 0);
            coordsEnsure(2);
            float[] fArr = this.coords;
            int i5 = this.coordsLength;
            int i6 = i5 + 1;
            this.coordsLength = i6;
            fArr[i5] = f5;
            this.coordsLength = i5 + 2;
            fArr[i6] = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f5, float f6, float f7, float f8) {
            addCommand(QUADTO);
            coordsEnsure(4);
            float[] fArr = this.coords;
            int i5 = this.coordsLength;
            int i6 = i5 + 1;
            this.coordsLength = i6;
            fArr[i5] = f5;
            int i7 = i5 + 2;
            this.coordsLength = i7;
            fArr[i6] = f6;
            int i8 = i5 + 3;
            this.coordsLength = i8;
            fArr[i7] = f7;
            this.coordsLength = i5 + 4;
            fArr[i8] = f8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface PathInterface {
        void arcTo(float f5, float f6, float f7, boolean z5, boolean z6, float f8, float f9);

        void close();

        void cubicTo(float f5, float f6, float f7, float f8, float f9, float f10);

        void lineTo(float f5, float f6);

        void moveTo(float f5, float f6);

        void quadTo(float f5, float f6, float f7, float f8);
    }

    /* loaded from: classes.dex */
    static class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {
        Length height;
        String href;
        Boolean patternContentUnitsAreUser;
        Matrix patternTransform;
        Boolean patternUnitsAreUser;
        Length width;

        /* renamed from: x, reason: collision with root package name */
        Length f4251x;

        /* renamed from: y, reason: collision with root package name */
        Length f4252y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "pattern";
        }
    }

    /* loaded from: classes.dex */
    static class PolyLine extends GraphicsElement {
        float[] points;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "polyline";
        }
    }

    /* loaded from: classes.dex */
    static class Polygon extends PolyLine {
        @Override // com.caverock.androidsvg.SVG.PolyLine, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "polygon";
        }
    }

    /* loaded from: classes.dex */
    static class Rect extends GraphicsElement {
        Length height;
        Length rx;
        Length ry;
        Length width;

        /* renamed from: x, reason: collision with root package name */
        Length f4253x;

        /* renamed from: y, reason: collision with root package name */
        Length f4254y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "rect";
        }
    }

    /* loaded from: classes.dex */
    static class SolidColor extends SvgElementBase implements SvgContainer {
        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "solidColor";
        }
    }

    /* loaded from: classes.dex */
    static class Stop extends SvgElementBase implements SvgContainer {
        Float offset;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return Collections.emptyList();
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "stop";
        }
    }

    /* loaded from: classes.dex */
    static class Style implements Cloneable {
        CSSClipRect clip;
        String clipPath;
        FillRule clipRule;
        Colour color;
        TextDirection direction;
        Boolean display;
        SvgPaint fill;
        Float fillOpacity;
        FillRule fillRule;
        List<String> fontFamily;
        Length fontSize;
        FontStyle fontStyle;
        Integer fontWeight;
        RenderQuality imageRendering;
        String markerEnd;
        String markerMid;
        String markerStart;
        String mask;
        Float opacity;
        Boolean overflow;
        SvgPaint solidColor;
        Float solidOpacity;
        long specifiedFlags = 0;
        SvgPaint stopColor;
        Float stopOpacity;
        SvgPaint stroke;
        Length[] strokeDashArray;
        Length strokeDashOffset;
        LineCap strokeLineCap;
        LineJoin strokeLineJoin;
        Float strokeMiterLimit;
        Float strokeOpacity;
        Length strokeWidth;
        TextAnchor textAnchor;
        TextDecoration textDecoration;
        VectorEffect vectorEffect;
        SvgPaint viewportFill;
        Float viewportFillOpacity;
        Boolean visibility;

        /* loaded from: classes.dex */
        public enum FillRule {
            NonZero,
            EvenOdd
        }

        /* loaded from: classes.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique
        }

        /* loaded from: classes.dex */
        public enum LineCap {
            Butt,
            Round,
            Square
        }

        /* loaded from: classes.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel
        }

        /* loaded from: classes.dex */
        public enum RenderQuality {
            auto,
            optimizeQuality,
            optimizeSpeed
        }

        /* loaded from: classes.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End
        }

        /* loaded from: classes.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink
        }

        /* loaded from: classes.dex */
        public enum TextDirection {
            LTR,
            RTL
        }

        /* loaded from: classes.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Style getDefaultStyle() {
            Style style = new Style();
            style.specifiedFlags = SVG.SPECIFIED_ALL;
            Colour colour = Colour.BLACK;
            style.fill = colour;
            FillRule fillRule = FillRule.NonZero;
            style.fillRule = fillRule;
            Float valueOf = Float.valueOf(1.0f);
            style.fillOpacity = valueOf;
            style.stroke = null;
            style.strokeOpacity = valueOf;
            style.strokeWidth = new Length(1.0f);
            style.strokeLineCap = LineCap.Butt;
            style.strokeLineJoin = LineJoin.Miter;
            style.strokeMiterLimit = Float.valueOf(4.0f);
            style.strokeDashArray = null;
            style.strokeDashOffset = new Length(0.0f);
            style.opacity = valueOf;
            style.color = colour;
            style.fontFamily = null;
            style.fontSize = new Length(12.0f, Unit.pt);
            style.fontWeight = Integer.valueOf(Constants.MINIMAL_ERROR_STATUS_CODE);
            style.fontStyle = FontStyle.Normal;
            style.textDecoration = TextDecoration.None;
            style.direction = TextDirection.LTR;
            style.textAnchor = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.overflow = bool;
            style.clip = null;
            style.markerStart = null;
            style.markerMid = null;
            style.markerEnd = null;
            style.display = bool;
            style.visibility = bool;
            style.stopColor = colour;
            style.stopOpacity = valueOf;
            style.clipPath = null;
            style.clipRule = fillRule;
            style.mask = null;
            style.solidColor = null;
            style.solidOpacity = valueOf;
            style.viewportFill = null;
            style.viewportFillOpacity = valueOf;
            style.vectorEffect = VectorEffect.None;
            style.imageRendering = RenderQuality.auto;
            return style;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            Style style = (Style) super.clone();
            Length[] lengthArr = this.strokeDashArray;
            if (lengthArr != null) {
                style.strokeDashArray = (Length[]) lengthArr.clone();
            }
            return style;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void resetNonInheritingProperties(boolean z5) {
            Boolean bool = Boolean.TRUE;
            this.display = bool;
            if (!z5) {
                bool = Boolean.FALSE;
            }
            this.overflow = bool;
            this.clip = null;
            this.clipPath = null;
            this.opacity = Float.valueOf(1.0f);
            this.stopColor = Colour.BLACK;
            this.stopOpacity = Float.valueOf(1.0f);
            this.mask = null;
            this.solidColor = null;
            this.solidOpacity = Float.valueOf(1.0f);
            this.viewportFill = null;
            this.viewportFillOpacity = Float.valueOf(1.0f);
            this.vectorEffect = VectorEffect.None;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Svg extends SvgViewBoxContainer {
        Length height;
        public String version;
        Length width;

        /* renamed from: x, reason: collision with root package name */
        Length f4255x;

        /* renamed from: y, reason: collision with root package name */
        Length f4256y;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "svg";
        }
    }

    /* loaded from: classes.dex */
    interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    /* loaded from: classes.dex */
    static abstract class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {
        List<SvgObject> children = new ArrayList();
        Set<String> requiredFeatures = null;
        String requiredExtensions = null;
        Set<String> systemLanguage = null;
        Set<String> requiredFormats = null;
        Set<String> requiredFonts = null;

        SvgConditionalContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) {
            this.children.add(svgObject);
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }
    }

    /* loaded from: classes.dex */
    static abstract class SvgConditionalElement extends SvgElement implements SvgConditional {
        Set<String> requiredFeatures = null;
        String requiredExtensions = null;
        Set<String> systemLanguage = null;
        Set<String> requiredFormats = null;
        Set<String> requiredFonts = null;

        SvgConditionalElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return this.systemLanguage;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface SvgContainer {
        void addChild(SvgObject svgObject);

        List<SvgObject> getChildren();
    }

    /* loaded from: classes.dex */
    static abstract class SvgElement extends SvgElementBase {
        Box boundingBox = null;

        SvgElement() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class SvgElementBase extends SvgObject {
        String id = null;
        Boolean spacePreserve = null;
        Style baseStyle = null;
        Style style = null;
        List<String> classNames = null;

        SvgElementBase() {
        }

        public String toString() {
            return getNodeName();
        }
    }

    /* loaded from: classes.dex */
    static class SvgLinearGradient extends GradientElement {

        /* renamed from: x1, reason: collision with root package name */
        Length f4257x1;

        /* renamed from: x2, reason: collision with root package name */
        Length f4258x2;

        /* renamed from: y1, reason: collision with root package name */
        Length f4259y1;

        /* renamed from: y2, reason: collision with root package name */
        Length f4260y2;

        @Override // com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "linearGradient";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SvgObject {
        SVG document;
        SvgContainer parent;

        SvgObject() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract String getNodeName();
    }

    /* loaded from: classes.dex */
    static abstract class SvgPaint implements Cloneable {
        SvgPaint() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {
        PreserveAspectRatio preserveAspectRatio = null;

        SvgPreserveAspectRatioContainer() {
        }
    }

    /* loaded from: classes.dex */
    static class SvgRadialGradient extends GradientElement {
        Length cx;
        Length cy;
        Length fx;
        Length fy;

        /* renamed from: r, reason: collision with root package name */
        Length f4261r;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "radialGradient";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {
        Box viewBox;

        SvgViewBoxContainer() {
        }
    }

    /* loaded from: classes.dex */
    static class Switch extends Group {
        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "switch";
        }
    }

    /* loaded from: classes.dex */
    static class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "symbol";
        }
    }

    /* loaded from: classes.dex */
    static class TRef extends TextContainer implements TextChild {
        String href;
        private TextRoot textRoot;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "tref";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }
    }

    /* loaded from: classes.dex */
    static class TSpan extends TextPositionedContainer implements TextChild {
        private TextRoot textRoot;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "tspan";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }
    }

    /* loaded from: classes.dex */
    static class Text extends TextPositionedContainer implements TextRoot, HasTransform {
        Matrix transform;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "text";
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* loaded from: classes.dex */
    interface TextChild {
        TextRoot getTextRoot();
    }

    /* loaded from: classes.dex */
    static abstract class TextContainer extends SvgConditionalContainer {
        TextContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditionalContainer, com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) {
            if (svgObject instanceof TextChild) {
                this.children.add(svgObject);
                return;
            }
            throw new SVGParseException("Text content elements cannot contain " + svgObject + " elements.");
        }
    }

    /* loaded from: classes.dex */
    static class TextPath extends TextContainer implements TextChild {
        String href;
        Length startOffset;
        private TextRoot textRoot;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "textPath";
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }
    }

    /* loaded from: classes.dex */
    static abstract class TextPositionedContainer extends TextContainer {
        List<Length> dx;
        List<Length> dy;

        /* renamed from: x, reason: collision with root package name */
        List<Length> f4262x;

        /* renamed from: y, reason: collision with root package name */
        List<Length> f4263y;

        TextPositionedContainer() {
        }
    }

    /* loaded from: classes.dex */
    interface TextRoot {
    }

    /* loaded from: classes.dex */
    static class TextSequence extends SvgObject implements TextChild {
        String text;
        private TextRoot textRoot;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TextSequence(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        public String toString() {
            return "TextChild: '" + this.text + "'";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent
    }

    /* loaded from: classes.dex */
    static class Use extends Group {
        Length height;
        String href;
        Length width;

        /* renamed from: x, reason: collision with root package name */
        Length f4264x;

        /* renamed from: y, reason: collision with root package name */
        Length f4265y;

        @Override // com.caverock.androidsvg.SVG.Group, com.caverock.androidsvg.SVG.SvgObject
        String getNodeName() {
            return "use";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class View extends SvgViewBoxContainer implements NotDirectlyRendered {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String getNodeName() {
            return "view";
        }
    }

    private String cssQuotedString(String str) {
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1).replace("\\\"", "\"");
        } else if (str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1).replace("\\'", "'");
        }
        return str.replace("\\\n", BuildConfig.FLAVOR).replace("\\A", "\n");
    }

    private Box getDocumentDimensions(float f5) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        Unit unit4;
        float f6;
        Unit unit5;
        Svg svg = this.rootElement;
        Length length = svg.width;
        Length length2 = svg.height;
        if (length == null || length.isZero() || (unit = length.unit) == (unit2 = Unit.percent) || unit == (unit3 = Unit.em) || unit == (unit4 = Unit.ex)) {
            return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
        }
        float floatValue = length.floatValue(f5);
        if (length2 == null) {
            Box box = this.rootElement.viewBox;
            f6 = box != null ? (box.height * floatValue) / box.width : floatValue;
        } else {
            if (length2.isZero() || (unit5 = length2.unit) == unit2 || unit5 == unit3 || unit5 == unit4) {
                return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
            }
            f6 = length2.floatValue(f5);
        }
        return new Box(0.0f, 0.0f, floatValue, f6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SVGExternalFileResolver getFileResolver() {
        return null;
    }

    public static SVG getFromInputStream(InputStream inputStream) {
        return new SVGParser().parse(inputStream, enableInternalEntities);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCSSRules(CSSParser.Ruleset ruleset) {
        this.cssRules.addAll(ruleset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearRenderCSSRules() {
        this.cssRules.removeFromSource(CSSParser.Source.RenderOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<CSSParser.Rule> getCSSRules() {
        return this.cssRules.getRules();
    }

    public float getDocumentHeight() {
        if (this.rootElement != null) {
            return getDocumentDimensions(this.renderDPI).height;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public RectF getDocumentViewBox() {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        Box box = svg.viewBox;
        if (box == null) {
            return null;
        }
        return box.toRectF();
    }

    public float getDocumentWidth() {
        if (this.rootElement != null) {
            return getDocumentDimensions(this.renderDPI).width;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SvgElementBase getElementById(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.equals(this.rootElement.id)) {
            return this.rootElement;
        }
        if (this.idToElementMap.containsKey(str)) {
            return this.idToElementMap.get(str);
        }
        SvgElementBase elementById = getElementById(this.rootElement, str);
        this.idToElementMap.put(str, elementById);
        return elementById;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Svg getRootElement() {
        return this.rootElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCSSRules() {
        return !this.cssRules.isEmpty();
    }

    public void renderToCanvas(Canvas canvas, RenderOptions renderOptions) {
        if (renderOptions == null) {
            renderOptions = new RenderOptions();
        }
        if (!renderOptions.hasViewPort()) {
            renderOptions.viewPort(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, this.renderDPI).renderDocument(this, renderOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SvgObject resolveIRI(String str) {
        if (str == null) {
            return null;
        }
        String cssQuotedString = cssQuotedString(str);
        if (cssQuotedString.length() <= 1 || !cssQuotedString.startsWith("#")) {
            return null;
        }
        return getElementById(cssQuotedString.substring(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDocumentHeight(String str) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.height = SVGParser.parseLength(str);
    }

    public void setDocumentViewBox(float f5, float f6, float f7, float f8) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.viewBox = new Box(f5, f6, f7, f8);
    }

    public void setDocumentWidth(String str) {
        Svg svg = this.rootElement;
        if (svg == null) {
            throw new IllegalArgumentException("SVG document is empty");
        }
        svg.width = SVGParser.parseLength(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRootElement(Svg svg) {
        this.rootElement = svg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTitle(String str) {
        this.title = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Box {
        float height;
        float minX;
        float minY;
        float width;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Box(float f5, float f6, float f7, float f8) {
            this.minX = f5;
            this.minY = f6;
            this.width = f7;
            this.height = f8;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Box fromLimits(float f5, float f6, float f7, float f8) {
            return new Box(f5, f6, f7 - f5, f8 - f6);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float maxX() {
            return this.minX + this.width;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float maxY() {
            return this.minY + this.height;
        }

        RectF toRectF() {
            return new RectF(this.minX, this.minY, maxX(), maxY());
        }

        public String toString() {
            return "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void union(Box box) {
            float f5 = box.minX;
            if (f5 < this.minX) {
                this.minX = f5;
            }
            float f6 = box.minY;
            if (f6 < this.minY) {
                this.minY = f6;
            }
            if (box.maxX() > maxX()) {
                this.width = box.maxX() - this.minX;
            }
            if (box.maxY() > maxY()) {
                this.height = box.maxY() - this.minY;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Box(Box box) {
            this.minX = box.minX;
            this.minY = box.minY;
            this.width = box.width;
            this.height = box.height;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SvgElementBase getElementById(SvgContainer svgContainer, String str) {
        SvgElementBase elementById;
        SvgElementBase svgElementBase = (SvgElementBase) svgContainer;
        if (str.equals(svgElementBase.id)) {
            return svgElementBase;
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj instanceof SvgElementBase) {
                SvgElementBase svgElementBase2 = (SvgElementBase) obj;
                if (str.equals(svgElementBase2.id)) {
                    return svgElementBase2;
                }
                if ((obj instanceof SvgContainer) && (elementById = getElementById((SvgContainer) obj, str)) != null) {
                    return elementById;
                }
            }
        }
        return null;
    }
}
