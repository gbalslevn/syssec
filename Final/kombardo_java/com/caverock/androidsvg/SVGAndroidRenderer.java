package com.caverock.androidsvg;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SVGAndroidRenderer {
    private static final float BEZIER_ARC_FACTOR = 0.5522848f;
    private static final String DEFAULT_FONT_FAMILY = "serif";
    private static final String TAG = "SVGAndroidRenderer";
    private static HashSet<String> supportedFeatures;
    private Canvas canvas;
    private SVG document;
    private float dpi;
    private Stack<Matrix> matrixStack;
    private Stack<SVG.SvgContainer> parentStack;
    private CSSParser.RuleMatchContext ruleMatchContext = null;
    private RendererState state;
    private Stack<RendererState> stateStack;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.SVGAndroidRenderer$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin;

        static {
            int[] iArr = new int[SVG.Style.LineJoin.values().length];
            $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin = iArr;
            try {
                iArr[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SVG.Style.LineCap.values().length];
            $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap = iArr2;
            try {
                iArr2[SVG.Style.LineCap.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[SVG.Style.LineCap.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[SVG.Style.LineCap.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[PreserveAspectRatio.Alignment.values().length];
            $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment = iArr3;
            try {
                iArr3[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MarkerPositionCalculator implements SVG.PathInterface {
        private boolean closepathReAdjustPending;
        private float startX;
        private float startY;
        private List<MarkerVector> markers = new ArrayList();
        private MarkerVector lastPos = null;
        private boolean startArc = false;
        private boolean normalCubic = true;
        private int subpathStartIndex = -1;

        MarkerPositionCalculator(SVG.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.enumeratePath(this);
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f5, float f6, float f7, boolean z5, boolean z6, float f8, float f9) {
            this.startArc = true;
            this.normalCubic = false;
            MarkerVector markerVector = this.lastPos;
            SVGAndroidRenderer.arcTo(markerVector.f4266x, markerVector.f4267y, f5, f6, f7, z5, z6, f8, f9, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f5, float f6, float f7, float f8, float f9, float f10) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(f5, f6);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = new MarkerVector(f9, f10, f9 - f7, f10 - f8);
            this.closepathReAdjustPending = false;
        }

        List<MarkerVector> getMarkers() {
            return this.markers;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f5, float f6) {
            this.lastPos.add(f5, f6);
            this.markers.add(this.lastPos);
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            MarkerVector markerVector = this.lastPos;
            this.lastPos = new MarkerVector(f5, f6, f5 - markerVector.f4266x, f6 - markerVector.f4267y);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f5, float f6) {
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
            this.startX = f5;
            this.startY = f6;
            this.lastPos = new MarkerVector(f5, f6, 0.0f, 0.0f);
            this.subpathStartIndex = this.markers.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f5, float f6, float f7, float f8) {
            this.lastPos.add(f5, f6);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f7, f8, f7 - f5, f8 - f6);
            this.closepathReAdjustPending = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PathConverter implements SVG.PathInterface {
        float lastX;
        float lastY;
        Path path = new Path();

        PathConverter(SVG.PathDefinition pathDefinition) {
            if (pathDefinition == null) {
                return;
            }
            pathDefinition.enumeratePath(this);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f5, float f6, float f7, boolean z5, boolean z6, float f8, float f9) {
            SVGAndroidRenderer.arcTo(this.lastX, this.lastY, f5, f6, f7, z5, z6, f8, f9, this);
            this.lastX = f8;
            this.lastY = f9;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.path.close();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f5, float f6, float f7, float f8, float f9, float f10) {
            this.path.cubicTo(f5, f6, f7, f8, f9, f10);
            this.lastX = f9;
            this.lastY = f10;
        }

        Path getPath() {
            return this.path;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f5, float f6) {
            this.path.lineTo(f5, f6);
            this.lastX = f5;
            this.lastY = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f5, float f6) {
            this.path.moveTo(f5, f6);
            this.lastX = f5;
            this.lastY = f6;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f5, float f6, float f7, float f8) {
            this.path.quadTo(f5, f6, f7, f8);
            this.lastX = f7;
            this.lastY = f8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PathTextDrawer extends PlainTextDrawer {
        private Path path;

        PathTextDrawer(Path path, float f5, float f6) {
            super(f5, f6);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.PlainTextDrawer, com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.f4268x, this.f4269y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.f4268x, this.f4269y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f4268x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PlainTextDrawer extends TextProcessor {

        /* renamed from: x, reason: collision with root package name */
        float f4268x;

        /* renamed from: y, reason: collision with root package name */
        float f4269y;

        PlainTextDrawer(float f5, float f6) {
            super(SVGAndroidRenderer.this, null);
            this.f4268x = f5;
            this.f4269y = f6;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            SVGAndroidRenderer.debug("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.f4268x, this.f4269y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.f4268x, this.f4269y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f4268x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PlainTextToPath extends TextProcessor {
        Path textAsPath;

        /* renamed from: x, reason: collision with root package name */
        float f4270x;

        /* renamed from: y, reason: collision with root package name */
        float f4271y;

        PlainTextToPath(float f5, float f6, Path path) {
            super(SVGAndroidRenderer.this, null);
            this.f4270x = f5;
            this.f4271y = f6;
            this.textAsPath = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVGAndroidRenderer.warn("Using <textPath> elements in a clip path is not supported.", new Object[0]);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Path path = new Path();
                SVGAndroidRenderer.this.state.fillPaint.getTextPath(str, 0, str.length(), this.f4270x, this.f4271y, path);
                this.textAsPath.addPath(path);
            }
            this.f4270x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TextBoundsCalculator extends TextProcessor {
        RectF bbox;

        /* renamed from: x, reason: collision with root package name */
        float f4272x;

        /* renamed from: y, reason: collision with root package name */
        float f4273y;

        TextBoundsCalculator(float f5, float f6) {
            super(SVGAndroidRenderer.this, null);
            this.bbox = new RectF();
            this.f4272x = f5;
            this.f4273y = f6;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVG.TextPath textPath = (SVG.TextPath) textContainer;
            SVG.SvgObject resolveIRI = textContainer.document.resolveIRI(textPath.href);
            if (resolveIRI == null) {
                SVGAndroidRenderer.error("TextPath path reference '%s' not found", textPath.href);
                return false;
            }
            SVG.Path path = (SVG.Path) resolveIRI;
            Path path2 = new PathConverter(path.f4250d).getPath();
            Matrix matrix = path.transform;
            if (matrix != null) {
                path2.transform(matrix);
            }
            RectF rectF = new RectF();
            path2.computeBounds(rectF, true);
            this.bbox.union(rectF);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.state.fillPaint.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f4272x, this.f4273y);
                this.bbox.union(rectF);
            }
            this.f4272x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class TextProcessor {
        private TextProcessor() {
        }

        public boolean doTextContainer(SVG.TextContainer textContainer) {
            return true;
        }

        public abstract void processText(String str);

        /* synthetic */ TextProcessor(SVGAndroidRenderer sVGAndroidRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVGAndroidRenderer(Canvas canvas, float f5) {
        this.canvas = canvas;
        this.dpi = f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void arcTo(float f5, float f6, float f7, float f8, float f9, boolean z5, boolean z6, float f10, float f11, SVG.PathInterface pathInterface) {
        float f12;
        SVG.PathInterface pathInterface2;
        if (f5 == f10 && f6 == f11) {
            return;
        }
        if (f7 == 0.0f) {
            f12 = f10;
            pathInterface2 = pathInterface;
        } else {
            if (f8 != 0.0f) {
                float abs = Math.abs(f7);
                float abs2 = Math.abs(f8);
                double radians = Math.toRadians(f9 % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d5 = (f5 - f10) / 2.0d;
                double d6 = (f6 - f11) / 2.0d;
                double d7 = (cos * d5) + (sin * d6);
                double d8 = ((-sin) * d5) + (d6 * cos);
                double d9 = abs * abs;
                double d10 = abs2 * abs2;
                double d11 = d7 * d7;
                double d12 = d8 * d8;
                double d13 = (d11 / d9) + (d12 / d10);
                if (d13 > 0.99999d) {
                    double sqrt = Math.sqrt(d13) * 1.00001d;
                    abs = (float) (abs * sqrt);
                    abs2 = (float) (sqrt * abs2);
                    d9 = abs * abs;
                    d10 = abs2 * abs2;
                }
                double d14 = z5 == z6 ? -1.0d : 1.0d;
                double d15 = d9 * d10;
                double d16 = d9 * d12;
                double d17 = d10 * d11;
                double d18 = ((d15 - d16) - d17) / (d16 + d17);
                if (d18 < 0.0d) {
                    d18 = 0.0d;
                }
                double sqrt2 = d14 * Math.sqrt(d18);
                double d19 = abs;
                double d20 = abs2;
                double d21 = ((d19 * d8) / d20) * sqrt2;
                float f13 = abs;
                float f14 = abs2;
                double d22 = sqrt2 * (-((d20 * d7) / d19));
                double d23 = ((f5 + f10) / 2.0d) + ((cos * d21) - (sin * d22));
                double d24 = ((f6 + f11) / 2.0d) + (sin * d21) + (cos * d22);
                double d25 = (d7 - d21) / d19;
                double d26 = (d8 - d22) / d20;
                double d27 = ((-d7) - d21) / d19;
                double d28 = ((-d8) - d22) / d20;
                double d29 = (d25 * d25) + (d26 * d26);
                double acos = (d26 < 0.0d ? -1.0d : 1.0d) * Math.acos(d25 / Math.sqrt(d29));
                double checkedArcCos = ((d25 * d28) - (d26 * d27) < 0.0d ? -1.0d : 1.0d) * checkedArcCos(((d25 * d27) + (d26 * d28)) / Math.sqrt(d29 * ((d27 * d27) + (d28 * d28))));
                if (!z6 && checkedArcCos > 0.0d) {
                    checkedArcCos -= 6.283185307179586d;
                } else if (z6 && checkedArcCos < 0.0d) {
                    checkedArcCos += 6.283185307179586d;
                }
                float[] arcToBeziers = arcToBeziers(acos % 6.283185307179586d, checkedArcCos % 6.283185307179586d);
                Matrix matrix = new Matrix();
                matrix.postScale(f13, f14);
                matrix.postRotate(f9);
                matrix.postTranslate((float) d23, (float) d24);
                matrix.mapPoints(arcToBeziers);
                arcToBeziers[arcToBeziers.length - 2] = f10;
                arcToBeziers[arcToBeziers.length - 1] = f11;
                for (int i5 = 0; i5 < arcToBeziers.length; i5 += 6) {
                    pathInterface.cubicTo(arcToBeziers[i5], arcToBeziers[i5 + 1], arcToBeziers[i5 + 2], arcToBeziers[i5 + 3], arcToBeziers[i5 + 4], arcToBeziers[i5 + 5]);
                }
                return;
            }
            pathInterface2 = pathInterface;
            f12 = f10;
        }
        pathInterface2.lineTo(f12, f11);
    }

    private static float[] arcToBeziers(double d5, double d6) {
        int ceil = (int) Math.ceil((Math.abs(d6) * 2.0d) / 3.141592653589793d);
        double d7 = d6 / ceil;
        double d8 = d7 / 2.0d;
        double sin = (Math.sin(d8) * 1.3333333333333333d) / (Math.cos(d8) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i5 = 0;
        int i6 = 0;
        while (i5 < ceil) {
            double d9 = d5 + (i5 * d7);
            double cos = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d10 = d7;
            fArr[i6] = (float) (cos - (sin * sin2));
            fArr[i6 + 1] = (float) (sin2 + (cos * sin));
            double d11 = d9 + d10;
            double cos2 = Math.cos(d11);
            double sin3 = Math.sin(d11);
            fArr[i6 + 2] = (float) ((sin * sin3) + cos2);
            fArr[i6 + 3] = (float) (sin3 - (sin * cos2));
            int i7 = i6 + 5;
            fArr[i6 + 4] = (float) cos2;
            i6 += 6;
            fArr[i7] = (float) sin3;
            i5++;
            d7 = d10;
        }
        return fArr;
    }

    @TargetApi(19)
    private Path calculateClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path objectToPath;
        SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(this.state.style.clipPath);
        if (resolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return null;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) resolveIRI;
        this.stateStack.push(this.state);
        this.state = findInheritFromAncestorState(clipPath);
        Boolean bool = clipPath.clipPathUnitsAreUser;
        boolean z5 = bool == null || bool.booleanValue();
        Matrix matrix = new Matrix();
        if (!z5) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = clipPath.transform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (SVG.SvgObject svgObject : clipPath.children) {
            if ((svgObject instanceof SVG.SvgElement) && (objectToPath = objectToPath((SVG.SvgElement) svgObject, true)) != null) {
                path.op(objectToPath, Path.Op.UNION);
            }
        }
        if (this.state.style.clipPath != null) {
            if (clipPath.boundingBox == null) {
                clipPath.boundingBox = calculatePathBounds(path);
            }
            Path calculateClipPath = calculateClipPath(clipPath, clipPath.boundingBox);
            if (calculateClipPath != null) {
                path.op(calculateClipPath, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.state = this.stateStack.pop();
        return path;
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.Line line) {
        SVG.Length length = line.f4244x1;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = line.f4246y1;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Length length3 = line.f4245x2;
        float floatValueX2 = length3 != null ? length3.floatValueX(this) : 0.0f;
        SVG.Length length4 = line.f4247y2;
        float floatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f5 = floatValueX2 - floatValueX;
        float f6 = floatValueY2 - floatValueY;
        arrayList.add(new MarkerVector(floatValueX, floatValueY, f5, f6));
        arrayList.add(new MarkerVector(floatValueX2, floatValueY2, f5, f6));
        return arrayList;
    }

    private SVG.Box calculatePathBounds(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private float calculateTextWidth(SVG.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator(this, null);
        enumerateTextSpans(textContainer, textWidthCalculator);
        return textWidthCalculator.f4274x;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
    
        if (r12 != 8) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Matrix calculateViewBoxTransform(SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        float f5;
        float f6;
        Matrix matrix = new Matrix();
        if (preserveAspectRatio != null && preserveAspectRatio.getAlignment() != null) {
            float f7 = box.width / box2.width;
            float f8 = box.height / box2.height;
            float f9 = -box2.minX;
            float f10 = -box2.minY;
            if (preserveAspectRatio.equals(PreserveAspectRatio.STRETCH)) {
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(f7, f8);
                matrix.preTranslate(f9, f10);
                return matrix;
            }
            float max = preserveAspectRatio.getScale() == PreserveAspectRatio.Scale.slice ? Math.max(f7, f8) : Math.min(f7, f8);
            float f11 = box.width / max;
            float f12 = box.height / max;
            int[] iArr = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment;
            switch (iArr[preserveAspectRatio.getAlignment().ordinal()]) {
                case 1:
                case 2:
                case 3:
                    f6 = (box2.width - f11) / 2.0f;
                    break;
                case 4:
                case 5:
                case 6:
                    f6 = box2.width - f11;
                    break;
            }
            f9 -= f6;
            int i5 = iArr[preserveAspectRatio.getAlignment().ordinal()];
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 5) {
                        if (i5 != 6) {
                            if (i5 != 7) {
                            }
                        }
                    }
                }
                f5 = box2.height - f12;
                f10 -= f5;
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(max, max);
                matrix.preTranslate(f9, f10);
            }
            f5 = (box2.height - f12) / 2.0f;
            f10 -= f5;
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(max, max);
            matrix.preTranslate(f9, f10);
        }
        return matrix;
    }

    private void checkForClipPath(SVG.SvgElement svgElement) {
        checkForClipPath(svgElement, svgElement.boundingBox);
    }

    private void checkForGradientsAndPatterns(SVG.SvgElement svgElement) {
        SVG.SvgPaint svgPaint = this.state.style.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            decodePaintReference(true, svgElement.boundingBox, (SVG.PaintReference) svgPaint);
        }
        SVG.SvgPaint svgPaint2 = this.state.style.stroke;
        if (svgPaint2 instanceof SVG.PaintReference) {
            decodePaintReference(false, svgElement.boundingBox, (SVG.PaintReference) svgPaint2);
        }
    }

    private Bitmap checkForImageDataURL(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e5) {
            Log.e(TAG, "Could not decode bad Data URL", e5);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r6.equals("fantasy") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Typeface checkGenericFont(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        char c5 = 2;
        boolean z5 = fontStyle == SVG.Style.FontStyle.Italic;
        int i5 = num.intValue() > 500 ? z5 ? 3 : 1 : z5 ? 2 : 0;
        str.hashCode();
        switch (str.hashCode()) {
            case -1536685117:
                if (str.equals("sans-serif")) {
                    c5 = 0;
                    break;
                }
                c5 = 65535;
                break;
            case -1431958525:
                if (str.equals("monospace")) {
                    c5 = 1;
                    break;
                }
                c5 = 65535;
                break;
            case -1081737434:
                break;
            case 109326717:
                if (str.equals(DEFAULT_FONT_FAMILY)) {
                    c5 = 3;
                    break;
                }
                c5 = 65535;
                break;
            case 1126973893:
                if (str.equals("cursive")) {
                    c5 = 4;
                    break;
                }
                c5 = 65535;
                break;
            default:
                c5 = 65535;
                break;
        }
        switch (c5) {
            case 0:
                return Typeface.create(Typeface.SANS_SERIF, i5);
            case 1:
                return Typeface.create(Typeface.MONOSPACE, i5);
            case 2:
                return Typeface.create(Typeface.SANS_SERIF, i5);
            case 3:
                return Typeface.create(Typeface.SERIF, i5);
            case 4:
                return Typeface.create(Typeface.SANS_SERIF, i5);
            default:
                return null;
        }
    }

    private void checkXMLSpaceAttribute(SVG.SvgObject svgObject) {
        Boolean bool;
        if ((svgObject instanceof SVG.SvgElementBase) && (bool = ((SVG.SvgElementBase) svgObject).spacePreserve) != null) {
            this.state.spacePreserve = bool.booleanValue();
        }
    }

    private static double checkedArcCos(double d5) {
        if (d5 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d5 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d5);
    }

    private static int clamp255(float f5) {
        int i5 = (int) (f5 * 256.0f);
        if (i5 < 0) {
            return 0;
        }
        return i5 > 255 ? Function.USE_VARARGS : i5;
    }

    private static int colourWithOpacity(int i5, float f5) {
        int i6 = Function.USE_VARARGS;
        int round = Math.round(((i5 >> 24) & Function.USE_VARARGS) * f5);
        if (round < 0) {
            i6 = 0;
        } else if (round <= 255) {
            i6 = round;
        }
        return (i5 & 16777215) | (i6 << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void debug(String str, Object... objArr) {
    }

    private void decodePaintReference(boolean z5, SVG.Box box, SVG.PaintReference paintReference) {
        SVG.SvgObject resolveIRI = this.document.resolveIRI(paintReference.href);
        if (resolveIRI == null) {
            error("%s reference '%s' not found", z5 ? "Fill" : "Stroke", paintReference.href);
            SVG.SvgPaint svgPaint = paintReference.fallback;
            if (svgPaint != null) {
                setPaintColour(this.state, z5, svgPaint);
                return;
            } else if (z5) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        if (resolveIRI instanceof SVG.SvgLinearGradient) {
            makeLinearGradient(z5, box, (SVG.SvgLinearGradient) resolveIRI);
        } else if (resolveIRI instanceof SVG.SvgRadialGradient) {
            makeRadialGradient(z5, box, (SVG.SvgRadialGradient) resolveIRI);
        } else if (resolveIRI instanceof SVG.SolidColor) {
            setSolidColor(z5, (SVG.SolidColor) resolveIRI);
        }
    }

    private boolean display() {
        Boolean bool = this.state.style.display;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void doFilledPath(SVG.SvgElement svgElement, Path path) {
        SVG.SvgPaint svgPaint = this.state.style.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            SVG.SvgObject resolveIRI = this.document.resolveIRI(((SVG.PaintReference) svgPaint).href);
            if (resolveIRI instanceof SVG.Pattern) {
                fillWithPattern(svgElement, path, (SVG.Pattern) resolveIRI);
                return;
            }
        }
        this.canvas.drawPath(path, this.state.fillPaint);
    }

    private void doStroke(Path path) {
        RendererState rendererState = this.state;
        if (rendererState.style.vectorEffect != SVG.Style.VectorEffect.NonScalingStroke) {
            this.canvas.drawPath(path, rendererState.strokePaint);
            return;
        }
        Matrix matrix = this.canvas.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        this.canvas.setMatrix(new Matrix());
        Shader shader = this.state.strokePaint.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        this.canvas.drawPath(path2, this.state.strokePaint);
        this.canvas.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
    }

    private float dotProduct(float f5, float f6, float f7, float f8) {
        return (f5 * f7) + (f6 * f8);
    }

    private void enumerateTextSpans(SVG.TextContainer textContainer, TextProcessor textProcessor) {
        if (display()) {
            Iterator<SVG.SvgObject> it = textContainer.children.iterator();
            boolean z5 = true;
            while (it.hasNext()) {
                SVG.SvgObject next = it.next();
                if (next instanceof SVG.TextSequence) {
                    textProcessor.processText(textXMLSpaceTransform(((SVG.TextSequence) next).text, z5, !it.hasNext()));
                } else {
                    processTextChild(next, textProcessor);
                }
                z5 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void error(String str, Object... objArr) {
        Log.e(TAG, String.format(str, objArr));
    }

    private void extractRawText(SVG.TextContainer textContainer, StringBuilder sb) {
        Iterator<SVG.SvgObject> it = textContainer.children.iterator();
        boolean z5 = true;
        while (it.hasNext()) {
            SVG.SvgObject next = it.next();
            if (next instanceof SVG.TextContainer) {
                extractRawText((SVG.TextContainer) next, sb);
            } else if (next instanceof SVG.TextSequence) {
                sb.append(textXMLSpaceTransform(((SVG.TextSequence) next).text, z5, !it.hasNext()));
            }
            z5 = false;
        }
    }

    private void fillInChainedGradientFields(SVG.GradientElement gradientElement, String str) {
        SVG.SvgObject resolveIRI = gradientElement.document.resolveIRI(str);
        if (resolveIRI == null) {
            warn("Gradient reference '%s' not found", str);
            return;
        }
        if (!(resolveIRI instanceof SVG.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (resolveIRI == gradientElement) {
            error("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        SVG.GradientElement gradientElement2 = (SVG.GradientElement) resolveIRI;
        if (gradientElement.gradientUnitsAreUser == null) {
            gradientElement.gradientUnitsAreUser = gradientElement2.gradientUnitsAreUser;
        }
        if (gradientElement.gradientTransform == null) {
            gradientElement.gradientTransform = gradientElement2.gradientTransform;
        }
        if (gradientElement.spreadMethod == null) {
            gradientElement.spreadMethod = gradientElement2.spreadMethod;
        }
        if (gradientElement.children.isEmpty()) {
            gradientElement.children = gradientElement2.children;
        }
        try {
            if (gradientElement instanceof SVG.SvgLinearGradient) {
                fillInChainedGradientFields((SVG.SvgLinearGradient) gradientElement, (SVG.SvgLinearGradient) resolveIRI);
            } else {
                fillInChainedGradientFields((SVG.SvgRadialGradient) gradientElement, (SVG.SvgRadialGradient) resolveIRI);
            }
        } catch (ClassCastException unused) {
        }
        String str2 = gradientElement2.href;
        if (str2 != null) {
            fillInChainedGradientFields(gradientElement, str2);
        }
    }

    private void fillInChainedPatternFields(SVG.Pattern pattern, String str) {
        SVG.SvgObject resolveIRI = pattern.document.resolveIRI(str);
        if (resolveIRI == null) {
            warn("Pattern reference '%s' not found", str);
            return;
        }
        if (!(resolveIRI instanceof SVG.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (resolveIRI == pattern) {
            error("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        SVG.Pattern pattern2 = (SVG.Pattern) resolveIRI;
        if (pattern.patternUnitsAreUser == null) {
            pattern.patternUnitsAreUser = pattern2.patternUnitsAreUser;
        }
        if (pattern.patternContentUnitsAreUser == null) {
            pattern.patternContentUnitsAreUser = pattern2.patternContentUnitsAreUser;
        }
        if (pattern.patternTransform == null) {
            pattern.patternTransform = pattern2.patternTransform;
        }
        if (pattern.f4251x == null) {
            pattern.f4251x = pattern2.f4251x;
        }
        if (pattern.f4252y == null) {
            pattern.f4252y = pattern2.f4252y;
        }
        if (pattern.width == null) {
            pattern.width = pattern2.width;
        }
        if (pattern.height == null) {
            pattern.height = pattern2.height;
        }
        if (pattern.children.isEmpty()) {
            pattern.children = pattern2.children;
        }
        if (pattern.viewBox == null) {
            pattern.viewBox = pattern2.viewBox;
        }
        if (pattern.preserveAspectRatio == null) {
            pattern.preserveAspectRatio = pattern2.preserveAspectRatio;
        }
        String str2 = pattern2.href;
        if (str2 != null) {
            fillInChainedPatternFields(pattern, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f6 A[LOOP:3: B:67:0x01f0->B:69:0x01f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0212  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void fillWithPattern(SVG.SvgElement svgElement, Path path, SVG.Pattern pattern) {
        float f5;
        float f6;
        float f7;
        float f8;
        PreserveAspectRatio preserveAspectRatio;
        boolean z5;
        boolean z6;
        float floor;
        float maxY;
        boolean pushLayer;
        PreserveAspectRatio preserveAspectRatio2;
        Iterator<SVG.SvgObject> it;
        Boolean bool = pattern.patternUnitsAreUser;
        boolean z7 = bool != null && bool.booleanValue();
        String str = pattern.href;
        if (str != null) {
            fillInChainedPatternFields(pattern, str);
        }
        if (z7) {
            SVG.Length length = pattern.f4251x;
            f5 = length != null ? length.floatValueX(this) : 0.0f;
            SVG.Length length2 = pattern.f4252y;
            f7 = length2 != null ? length2.floatValueY(this) : 0.0f;
            SVG.Length length3 = pattern.width;
            f8 = length3 != null ? length3.floatValueX(this) : 0.0f;
            SVG.Length length4 = pattern.height;
            f6 = length4 != null ? length4.floatValueY(this) : 0.0f;
        } else {
            SVG.Length length5 = pattern.f4251x;
            float floatValue = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length6 = pattern.f4252y;
            float floatValue2 = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length7 = pattern.width;
            float floatValue3 = length7 != null ? length7.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length8 = pattern.height;
            float floatValue4 = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
            SVG.Box box = svgElement.boundingBox;
            float f9 = box.minX;
            float f10 = box.width;
            f5 = (floatValue * f10) + f9;
            float f11 = box.minY;
            float f12 = box.height;
            float f13 = floatValue3 * f10;
            f6 = floatValue4 * f12;
            f7 = (floatValue2 * f12) + f11;
            f8 = f13;
        }
        if (f8 == 0.0f || f6 == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio3 = pattern.preserveAspectRatio;
        if (preserveAspectRatio3 == null) {
            preserveAspectRatio3 = PreserveAspectRatio.LETTERBOX;
        }
        statePush();
        this.canvas.clipPath(path);
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        rendererState.style.overflow = Boolean.FALSE;
        this.state = findInheritFromAncestorState(pattern, rendererState);
        SVG.Box box2 = svgElement.boundingBox;
        Matrix matrix = pattern.patternTransform;
        if (matrix != null) {
            this.canvas.concat(matrix);
            Matrix matrix2 = new Matrix();
            if (pattern.patternTransform.invert(matrix2)) {
                SVG.Box box3 = svgElement.boundingBox;
                float f14 = box3.minX;
                float f15 = box3.minY;
                float maxX = box3.maxX();
                SVG.Box box4 = svgElement.boundingBox;
                float f16 = box4.minY;
                float maxX2 = box4.maxX();
                float maxY2 = svgElement.boundingBox.maxY();
                SVG.Box box5 = svgElement.boundingBox;
                preserveAspectRatio = preserveAspectRatio3;
                float[] fArr = {f14, f15, maxX, f16, maxX2, maxY2, box5.minX, box5.maxY()};
                matrix2.mapPoints(fArr);
                z6 = false;
                float f17 = fArr[0];
                float f18 = fArr[1];
                RectF rectF = new RectF(f17, f18, f17, f18);
                for (int i5 = 2; i5 <= 6; i5 += 2) {
                    float f19 = fArr[i5];
                    if (f19 < rectF.left) {
                        rectF.left = f19;
                    }
                    if (f19 > rectF.right) {
                        rectF.right = f19;
                    }
                    float f20 = fArr[i5 + 1];
                    if (f20 < rectF.top) {
                        rectF.top = f20;
                    }
                    if (f20 > rectF.bottom) {
                        rectF.bottom = f20;
                    }
                }
                z5 = true;
                float f21 = rectF.left;
                float f22 = rectF.top;
                box2 = new SVG.Box(f21, f22, rectF.right - f21, rectF.bottom - f22);
                float floor2 = f5 + (((float) Math.floor((box2.minX - f5) / f8)) * f8);
                floor = f7 + (((float) Math.floor((box2.minY - f7) / f6)) * f6);
                float maxX3 = box2.maxX();
                maxY = box2.maxY();
                SVG.Box box6 = new SVG.Box(0.0f, 0.0f, f8, f6);
                pushLayer = pushLayer();
                while (floor < maxY) {
                    float f23 = floor2;
                    while (f23 < maxX3) {
                        box6.minX = f23;
                        box6.minY = floor;
                        statePush();
                        if (!this.state.style.overflow.booleanValue()) {
                            setClipRect(box6.minX, box6.minY, box6.width, box6.height);
                        }
                        SVG.Box box7 = pattern.viewBox;
                        if (box7 != null) {
                            preserveAspectRatio2 = preserveAspectRatio;
                            this.canvas.concat(calculateViewBoxTransform(box6, box7, preserveAspectRatio2));
                        } else {
                            preserveAspectRatio2 = preserveAspectRatio;
                            Boolean bool2 = pattern.patternContentUnitsAreUser;
                            boolean z8 = (bool2 == null || bool2.booleanValue()) ? z5 : z6;
                            this.canvas.translate(f23, floor);
                            if (!z8) {
                                Canvas canvas = this.canvas;
                                SVG.Box box8 = svgElement.boundingBox;
                                canvas.scale(box8.width, box8.height);
                                it = pattern.children.iterator();
                                while (it.hasNext()) {
                                    render(it.next());
                                }
                                statePop();
                                f23 += f8;
                                preserveAspectRatio = preserveAspectRatio2;
                                z5 = true;
                            }
                        }
                        it = pattern.children.iterator();
                        while (it.hasNext()) {
                        }
                        statePop();
                        f23 += f8;
                        preserveAspectRatio = preserveAspectRatio2;
                        z5 = true;
                    }
                    floor += f6;
                    z5 = true;
                }
                if (pushLayer) {
                    popLayer(pattern);
                }
                statePop();
            }
        }
        preserveAspectRatio = preserveAspectRatio3;
        z5 = true;
        z6 = false;
        float floor22 = f5 + (((float) Math.floor((box2.minX - f5) / f8)) * f8);
        floor = f7 + (((float) Math.floor((box2.minY - f7) / f6)) * f6);
        float maxX32 = box2.maxX();
        maxY = box2.maxY();
        SVG.Box box62 = new SVG.Box(0.0f, 0.0f, f8, f6);
        pushLayer = pushLayer();
        while (floor < maxY) {
        }
        if (pushLayer) {
        }
        statePop();
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject) {
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        return findInheritFromAncestorState(svgObject, rendererState);
    }

    private SVG.Style.TextAnchor getAnchorPosition() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.state.style;
        if (style.direction == SVG.Style.TextDirection.LTR || (textAnchor = style.textAnchor) == SVG.Style.TextAnchor.Middle) {
            return style.textAnchor;
        }
        SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
        return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
    }

    private Path.FillType getClipRuleFromState() {
        SVG.Style.FillRule fillRule = this.state.style.clipRule;
        return (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private Path.FillType getFillTypeFromState() {
        SVG.Style.FillRule fillRule = this.state.style.fillRule;
        return (fillRule == null || fillRule != SVG.Style.FillRule.EvenOdd) ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
    }

    private static synchronized void initialiseSupportedFeaturesMap() {
        synchronized (SVGAndroidRenderer.class) {
            HashSet<String> hashSet = new HashSet<>();
            supportedFeatures = hashSet;
            hashSet.add("Structure");
            supportedFeatures.add("BasicStructure");
            supportedFeatures.add("ConditionalProcessing");
            supportedFeatures.add("Image");
            supportedFeatures.add("Style");
            supportedFeatures.add("ViewportAttribute");
            supportedFeatures.add("Shape");
            supportedFeatures.add("BasicText");
            supportedFeatures.add("PaintAttribute");
            supportedFeatures.add("BasicPaintAttribute");
            supportedFeatures.add("OpacityAttribute");
            supportedFeatures.add("BasicGraphicsAttribute");
            supportedFeatures.add("Marker");
            supportedFeatures.add("Gradient");
            supportedFeatures.add("Pattern");
            supportedFeatures.add("Clip");
            supportedFeatures.add("BasicClip");
            supportedFeatures.add("Mask");
            supportedFeatures.add("View");
        }
    }

    private boolean isSpecified(SVG.Style style, long j5) {
        return (style.specifiedFlags & j5) != 0;
    }

    private void makeLinearGradient(boolean z5, SVG.Box box, SVG.SvgLinearGradient svgLinearGradient) {
        float f5;
        float floatValue;
        float f6;
        float f7;
        String str = svgLinearGradient.href;
        if (str != null) {
            fillInChainedGradientFields(svgLinearGradient, str);
        }
        Boolean bool = svgLinearGradient.gradientUnitsAreUser;
        int i5 = 0;
        boolean z6 = bool != null && bool.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z5 ? rendererState.fillPaint : rendererState.strokePaint;
        if (z6) {
            SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
            SVG.Length length = svgLinearGradient.f4257x1;
            float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
            SVG.Length length2 = svgLinearGradient.f4259y1;
            float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
            SVG.Length length3 = svgLinearGradient.f4258x2;
            float floatValueX2 = length3 != null ? length3.floatValueX(this) : currentViewPortInUserUnits.width;
            SVG.Length length4 = svgLinearGradient.f4260y2;
            f7 = floatValueX2;
            f5 = floatValueX;
            f6 = floatValueY;
            floatValue = length4 != null ? length4.floatValueY(this) : 0.0f;
        } else {
            SVG.Length length5 = svgLinearGradient.f4257x1;
            float floatValue2 = length5 != null ? length5.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length6 = svgLinearGradient.f4259y1;
            float floatValue3 = length6 != null ? length6.floatValue(this, 1.0f) : 0.0f;
            SVG.Length length7 = svgLinearGradient.f4258x2;
            float floatValue4 = length7 != null ? length7.floatValue(this, 1.0f) : 1.0f;
            SVG.Length length8 = svgLinearGradient.f4260y2;
            f5 = floatValue2;
            floatValue = length8 != null ? length8.floatValue(this, 1.0f) : 0.0f;
            f6 = floatValue3;
            f7 = floatValue4;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgLinearGradient);
        Matrix matrix = new Matrix();
        if (!z6) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = svgLinearGradient.gradientTransform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = svgLinearGradient.children.size();
        if (size == 0) {
            statePop();
            if (z5) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgLinearGradient.children.iterator();
        float f8 = -1.0f;
        while (it.hasNext()) {
            SVG.Stop stop = (SVG.Stop) it.next();
            Float f9 = stop.offset;
            float floatValue5 = f9 != null ? f9.floatValue() : 0.0f;
            if (i5 == 0 || floatValue5 >= f8) {
                fArr[i5] = floatValue5;
                f8 = floatValue5;
            } else {
                fArr[i5] = f8;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Style style = this.state.style;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i5] = colourWithOpacity(colour.colour, style.stopOpacity.floatValue());
            i5++;
            statePop();
        }
        if ((f5 == f7 && f6 == floatValue) || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = svgLinearGradient.spreadMethod;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        statePop();
        LinearGradient linearGradient = new LinearGradient(f5, f6, f7, floatValue, iArr, fArr, tileMode2);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private Path makePathAndBoundingBox(SVG.Line line) {
        SVG.Length length = line.f4244x1;
        float floatValueX = length == null ? 0.0f : length.floatValueX(this);
        SVG.Length length2 = line.f4246y1;
        float floatValueY = length2 == null ? 0.0f : length2.floatValueY(this);
        SVG.Length length3 = line.f4245x2;
        float floatValueX2 = length3 == null ? 0.0f : length3.floatValueX(this);
        SVG.Length length4 = line.f4247y2;
        float floatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        if (line.boundingBox == null) {
            line.boundingBox = new SVG.Box(Math.min(floatValueX, floatValueX2), Math.min(floatValueY, floatValueY2), Math.abs(floatValueX2 - floatValueX), Math.abs(floatValueY2 - floatValueY));
        }
        Path path = new Path();
        path.moveTo(floatValueX, floatValueY);
        path.lineTo(floatValueX2, floatValueY2);
        return path;
    }

    private void makeRadialGradient(boolean z5, SVG.Box box, SVG.SvgRadialGradient svgRadialGradient) {
        float f5;
        float floatValue;
        float f6;
        String str = svgRadialGradient.href;
        if (str != null) {
            fillInChainedGradientFields(svgRadialGradient, str);
        }
        Boolean bool = svgRadialGradient.gradientUnitsAreUser;
        int i5 = 0;
        boolean z6 = bool != null && bool.booleanValue();
        RendererState rendererState = this.state;
        Paint paint = z5 ? rendererState.fillPaint : rendererState.strokePaint;
        if (z6) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            SVG.Length length2 = svgRadialGradient.cx;
            float floatValueX = length2 != null ? length2.floatValueX(this) : length.floatValueX(this);
            SVG.Length length3 = svgRadialGradient.cy;
            float floatValueY = length3 != null ? length3.floatValueY(this) : length.floatValueY(this);
            SVG.Length length4 = svgRadialGradient.f4261r;
            floatValue = length4 != null ? length4.floatValue(this) : length.floatValue(this);
            f5 = floatValueX;
            f6 = floatValueY;
        } else {
            SVG.Length length5 = svgRadialGradient.cx;
            float floatValue2 = length5 != null ? length5.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length6 = svgRadialGradient.cy;
            float floatValue3 = length6 != null ? length6.floatValue(this, 1.0f) : 0.5f;
            SVG.Length length7 = svgRadialGradient.f4261r;
            f5 = floatValue2;
            floatValue = length7 != null ? length7.floatValue(this, 1.0f) : 0.5f;
            f6 = floatValue3;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgRadialGradient);
        Matrix matrix = new Matrix();
        if (!z6) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = svgRadialGradient.gradientTransform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = svgRadialGradient.children.size();
        if (size == 0) {
            statePop();
            if (z5) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgRadialGradient.children.iterator();
        float f7 = -1.0f;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SVG.Stop stop = (SVG.Stop) it.next();
            Float f8 = stop.offset;
            float floatValue4 = f8 != null ? f8.floatValue() : 0.0f;
            if (i5 == 0 || floatValue4 >= f7) {
                fArr[i5] = floatValue4;
                f7 = floatValue4;
            } else {
                fArr[i5] = f7;
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Style style = this.state.style;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i5] = colourWithOpacity(colour.colour, style.stopOpacity.floatValue());
            i5++;
            statePop();
        }
        if (floatValue == 0.0f || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = svgRadialGradient.spreadMethod;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        statePop();
        RadialGradient radialGradient = new RadialGradient(f5, f6, floatValue, iArr, fArr, tileMode2);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        paint.setAlpha(clamp255(this.state.style.fillOpacity.floatValue()));
    }

    private SVG.Box makeViewPort(SVG.Length length, SVG.Length length2, SVG.Length length3, SVG.Length length4) {
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
        return new SVG.Box(floatValueX, floatValueY, length3 != null ? length3.floatValueX(this) : currentViewPortInUserUnits.width, length4 != null ? length4.floatValueY(this) : currentViewPortInUserUnits.height);
    }

    @TargetApi(19)
    private Path objectToPath(SVG.SvgElement svgElement, boolean z5) {
        Path makePathAndBoundingBox;
        Path calculateClipPath;
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        updateStyleForElement(rendererState, svgElement);
        if (!display() || !visible()) {
            this.state = this.stateStack.pop();
            return null;
        }
        if (svgElement instanceof SVG.Use) {
            if (!z5) {
                error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
            }
            SVG.Use use = (SVG.Use) svgElement;
            SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(use.href);
            if (resolveIRI == null) {
                error("Use reference '%s' not found", use.href);
                this.state = this.stateStack.pop();
                return null;
            }
            if (!(resolveIRI instanceof SVG.SvgElement)) {
                this.state = this.stateStack.pop();
                return null;
            }
            makePathAndBoundingBox = objectToPath((SVG.SvgElement) resolveIRI, false);
            if (makePathAndBoundingBox == null) {
                return null;
            }
            if (use.boundingBox == null) {
                use.boundingBox = calculatePathBounds(makePathAndBoundingBox);
            }
            Matrix matrix = use.transform;
            if (matrix != null) {
                makePathAndBoundingBox.transform(matrix);
            }
        } else if (svgElement instanceof SVG.GraphicsElement) {
            SVG.GraphicsElement graphicsElement = (SVG.GraphicsElement) svgElement;
            if (svgElement instanceof SVG.Path) {
                makePathAndBoundingBox = new PathConverter(((SVG.Path) svgElement).f4250d).getPath();
                if (svgElement.boundingBox == null) {
                    svgElement.boundingBox = calculatePathBounds(makePathAndBoundingBox);
                }
            } else {
                makePathAndBoundingBox = svgElement instanceof SVG.Rect ? makePathAndBoundingBox((SVG.Rect) svgElement) : svgElement instanceof SVG.Circle ? makePathAndBoundingBox((SVG.Circle) svgElement) : svgElement instanceof SVG.Ellipse ? makePathAndBoundingBox((SVG.Ellipse) svgElement) : svgElement instanceof SVG.PolyLine ? makePathAndBoundingBox((SVG.PolyLine) svgElement) : null;
            }
            if (makePathAndBoundingBox == null) {
                return null;
            }
            if (graphicsElement.boundingBox == null) {
                graphicsElement.boundingBox = calculatePathBounds(makePathAndBoundingBox);
            }
            Matrix matrix2 = graphicsElement.transform;
            if (matrix2 != null) {
                makePathAndBoundingBox.transform(matrix2);
            }
            makePathAndBoundingBox.setFillType(getClipRuleFromState());
        } else {
            if (!(svgElement instanceof SVG.Text)) {
                error("Invalid %s element found in clipPath definition", svgElement.getNodeName());
                return null;
            }
            SVG.Text text = (SVG.Text) svgElement;
            makePathAndBoundingBox = makePathAndBoundingBox(text);
            if (makePathAndBoundingBox == null) {
                return null;
            }
            Matrix matrix3 = text.transform;
            if (matrix3 != null) {
                makePathAndBoundingBox.transform(matrix3);
            }
            makePathAndBoundingBox.setFillType(getClipRuleFromState());
        }
        if (this.state.style.clipPath != null && (calculateClipPath = calculateClipPath(svgElement, svgElement.boundingBox)) != null) {
            makePathAndBoundingBox.op(calculateClipPath, Path.Op.INTERSECT);
        }
        this.state = this.stateStack.pop();
        return makePathAndBoundingBox;
    }

    private void parentPop() {
        this.parentStack.pop();
        this.matrixStack.pop();
    }

    private void parentPush(SVG.SvgContainer svgContainer) {
        this.parentStack.push(svgContainer);
        this.matrixStack.push(this.canvas.getMatrix());
    }

    private void popLayer(SVG.SvgElement svgElement) {
        popLayer(svgElement, svgElement.boundingBox);
    }

    private void processTextChild(SVG.SvgObject svgObject, TextProcessor textProcessor) {
        float f5;
        float f6;
        float f7;
        SVG.Style.TextAnchor anchorPosition;
        if (textProcessor.doTextContainer((SVG.TextContainer) svgObject)) {
            if (svgObject instanceof SVG.TextPath) {
                statePush();
                renderTextPath((SVG.TextPath) svgObject);
                statePop();
                return;
            }
            if (!(svgObject instanceof SVG.TSpan)) {
                if (svgObject instanceof SVG.TRef) {
                    statePush();
                    SVG.TRef tRef = (SVG.TRef) svgObject;
                    updateStyleForElement(this.state, tRef);
                    if (display()) {
                        checkForGradientsAndPatterns((SVG.SvgElement) tRef.getTextRoot());
                        SVG.SvgObject resolveIRI = svgObject.document.resolveIRI(tRef.href);
                        if (resolveIRI == null || !(resolveIRI instanceof SVG.TextContainer)) {
                            error("Tref reference '%s' not found", tRef.href);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            extractRawText((SVG.TextContainer) resolveIRI, sb);
                            if (sb.length() > 0) {
                                textProcessor.processText(sb.toString());
                            }
                        }
                    }
                    statePop();
                    return;
                }
                return;
            }
            debug("TSpan render", new Object[0]);
            statePush();
            SVG.TSpan tSpan = (SVG.TSpan) svgObject;
            updateStyleForElement(this.state, tSpan);
            if (display()) {
                List<SVG.Length> list = tSpan.f4262x;
                boolean z5 = list != null && list.size() > 0;
                boolean z6 = textProcessor instanceof PlainTextDrawer;
                float f8 = 0.0f;
                if (z6) {
                    float floatValueX = !z5 ? ((PlainTextDrawer) textProcessor).f4268x : tSpan.f4262x.get(0).floatValueX(this);
                    List<SVG.Length> list2 = tSpan.f4263y;
                    f6 = (list2 == null || list2.size() == 0) ? ((PlainTextDrawer) textProcessor).f4269y : tSpan.f4263y.get(0).floatValueY(this);
                    List<SVG.Length> list3 = tSpan.dx;
                    f7 = (list3 == null || list3.size() == 0) ? 0.0f : tSpan.dx.get(0).floatValueX(this);
                    List<SVG.Length> list4 = tSpan.dy;
                    if (list4 != null && list4.size() != 0) {
                        f8 = tSpan.dy.get(0).floatValueY(this);
                    }
                    f5 = f8;
                    f8 = floatValueX;
                } else {
                    f5 = 0.0f;
                    f6 = 0.0f;
                    f7 = 0.0f;
                }
                if (z5 && (anchorPosition = getAnchorPosition()) != SVG.Style.TextAnchor.Start) {
                    float calculateTextWidth = calculateTextWidth(tSpan);
                    if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                        calculateTextWidth /= 2.0f;
                    }
                    f8 -= calculateTextWidth;
                }
                checkForGradientsAndPatterns((SVG.SvgElement) tSpan.getTextRoot());
                if (z6) {
                    PlainTextDrawer plainTextDrawer = (PlainTextDrawer) textProcessor;
                    plainTextDrawer.f4268x = f8 + f7;
                    plainTextDrawer.f4269y = f6 + f5;
                }
                boolean pushLayer = pushLayer();
                enumerateTextSpans(tSpan, textProcessor);
                if (pushLayer) {
                    popLayer(tSpan);
                }
            }
            statePop();
        }
    }

    private boolean pushLayer() {
        SVG.SvgObject resolveIRI;
        if (!requiresCompositing()) {
            return false;
        }
        this.canvas.saveLayerAlpha(null, clamp255(this.state.style.opacity.floatValue()), 31);
        this.stateStack.push(this.state);
        RendererState rendererState = new RendererState(this.state);
        this.state = rendererState;
        String str = rendererState.style.mask;
        if (str != null && ((resolveIRI = this.document.resolveIRI(str)) == null || !(resolveIRI instanceof SVG.Mask))) {
            error("Mask reference '%s' not found", this.state.style.mask);
            this.state.style.mask = null;
        }
        return true;
    }

    private MarkerVector realignMarkerMid(MarkerVector markerVector, MarkerVector markerVector2, MarkerVector markerVector3) {
        float dotProduct = dotProduct(markerVector2.dx, markerVector2.dy, markerVector2.f4266x - markerVector.f4266x, markerVector2.f4267y - markerVector.f4267y);
        if (dotProduct == 0.0f) {
            dotProduct = dotProduct(markerVector2.dx, markerVector2.dy, markerVector3.f4266x - markerVector2.f4266x, markerVector3.f4267y - markerVector2.f4267y);
        }
        if (dotProduct > 0.0f) {
            return markerVector2;
        }
        if (dotProduct == 0.0f && (markerVector2.dx > 0.0f || markerVector2.dy >= 0.0f)) {
            return markerVector2;
        }
        markerVector2.dx = -markerVector2.dx;
        markerVector2.dy = -markerVector2.dy;
        return markerVector2;
    }

    private void render(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.NotDirectlyRendered) {
            return;
        }
        statePush();
        checkXMLSpaceAttribute(svgObject);
        if (svgObject instanceof SVG.Svg) {
            render((SVG.Svg) svgObject);
        } else if (svgObject instanceof SVG.Use) {
            render((SVG.Use) svgObject);
        } else if (svgObject instanceof SVG.Switch) {
            render((SVG.Switch) svgObject);
        } else if (svgObject instanceof SVG.Group) {
            render((SVG.Group) svgObject);
        } else if (svgObject instanceof SVG.Image) {
            render((SVG.Image) svgObject);
        } else if (svgObject instanceof SVG.Path) {
            render((SVG.Path) svgObject);
        } else if (svgObject instanceof SVG.Rect) {
            render((SVG.Rect) svgObject);
        } else if (svgObject instanceof SVG.Circle) {
            render((SVG.Circle) svgObject);
        } else if (svgObject instanceof SVG.Ellipse) {
            render((SVG.Ellipse) svgObject);
        } else if (svgObject instanceof SVG.Line) {
            render((SVG.Line) svgObject);
        } else if (svgObject instanceof SVG.Polygon) {
            render((SVG.Polygon) svgObject);
        } else if (svgObject instanceof SVG.PolyLine) {
            render((SVG.PolyLine) svgObject);
        } else if (svgObject instanceof SVG.Text) {
            render((SVG.Text) svgObject);
        }
        statePop();
    }

    private void renderChildren(SVG.SvgContainer svgContainer, boolean z5) {
        if (z5) {
            parentPush(svgContainer);
        }
        Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            render(it.next());
        }
        if (z5) {
            parentPop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0101, code lost:
    
        if (r7 != 8) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void renderMarker(SVG.Marker marker, MarkerVector markerVector) {
        float f5;
        SVG.Box box;
        boolean pushLayer;
        float f6;
        float f7;
        float f8;
        statePush();
        Float f9 = marker.orient;
        float f10 = 0.0f;
        if (f9 != null) {
            if (Float.isNaN(f9.floatValue())) {
                float f11 = markerVector.dx;
                if (f11 != 0.0f || markerVector.dy != 0.0f) {
                    f5 = (float) Math.toDegrees(Math.atan2(markerVector.dy, f11));
                }
            } else {
                f5 = marker.orient.floatValue();
            }
            float floatValue = !marker.markerUnitsAreUser ? 1.0f : this.state.style.strokeWidth.floatValue(this.dpi);
            this.state = findInheritFromAncestorState(marker);
            Matrix matrix = new Matrix();
            matrix.preTranslate(markerVector.f4266x, markerVector.f4267y);
            matrix.preRotate(f5);
            matrix.preScale(floatValue, floatValue);
            SVG.Length length = marker.refX;
            float floatValueX = length == null ? length.floatValueX(this) : 0.0f;
            SVG.Length length2 = marker.refY;
            float floatValueY = length2 == null ? length2.floatValueY(this) : 0.0f;
            SVG.Length length3 = marker.markerWidth;
            float floatValueX2 = length3 == null ? length3.floatValueX(this) : 3.0f;
            SVG.Length length4 = marker.markerHeight;
            float floatValueY2 = length4 != null ? length4.floatValueY(this) : 3.0f;
            box = marker.viewBox;
            if (box == null) {
                float f12 = floatValueX2 / box.width;
                float f13 = floatValueY2 / box.height;
                PreserveAspectRatio preserveAspectRatio = marker.preserveAspectRatio;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
                }
                if (!preserveAspectRatio.equals(PreserveAspectRatio.STRETCH)) {
                    f12 = preserveAspectRatio.getScale() == PreserveAspectRatio.Scale.slice ? Math.max(f12, f13) : Math.min(f12, f13);
                    f13 = f12;
                }
                matrix.preTranslate((-floatValueX) * f12, (-floatValueY) * f13);
                this.canvas.concat(matrix);
                SVG.Box box2 = marker.viewBox;
                float f14 = box2.width * f12;
                float f15 = box2.height * f13;
                int[] iArr = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$PreserveAspectRatio$Alignment;
                switch (iArr[preserveAspectRatio.getAlignment().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        f6 = (floatValueX2 - f14) / 2.0f;
                        f7 = 0.0f - f6;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        f6 = floatValueX2 - f14;
                        f7 = 0.0f - f6;
                        break;
                    default:
                        f7 = 0.0f;
                        break;
                }
                int i5 = iArr[preserveAspectRatio.getAlignment().ordinal()];
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 5) {
                            if (i5 != 6) {
                                if (i5 != 7) {
                                }
                            }
                        }
                    }
                    f8 = floatValueY2 - f15;
                    f10 = 0.0f - f8;
                    if (!this.state.style.overflow.booleanValue()) {
                        setClipRect(f7, f10, floatValueX2, floatValueY2);
                    }
                    matrix.reset();
                    matrix.preScale(f12, f13);
                    this.canvas.concat(matrix);
                }
                f8 = (floatValueY2 - f15) / 2.0f;
                f10 = 0.0f - f8;
                if (!this.state.style.overflow.booleanValue()) {
                }
                matrix.reset();
                matrix.preScale(f12, f13);
                this.canvas.concat(matrix);
            } else {
                matrix.preTranslate(-floatValueX, -floatValueY);
                this.canvas.concat(matrix);
                if (!this.state.style.overflow.booleanValue()) {
                    setClipRect(0.0f, 0.0f, floatValueX2, floatValueY2);
                }
            }
            pushLayer = pushLayer();
            renderChildren(marker, false);
            if (pushLayer) {
                popLayer(marker);
            }
            statePop();
        }
        f5 = 0.0f;
        if (!marker.markerUnitsAreUser) {
        }
        this.state = findInheritFromAncestorState(marker);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(markerVector.f4266x, markerVector.f4267y);
        matrix2.preRotate(f5);
        matrix2.preScale(floatValue, floatValue);
        SVG.Length length5 = marker.refX;
        if (length5 == null) {
        }
        SVG.Length length22 = marker.refY;
        if (length22 == null) {
        }
        SVG.Length length32 = marker.markerWidth;
        if (length32 == null) {
        }
        SVG.Length length42 = marker.markerHeight;
        if (length42 != null) {
        }
        box = marker.viewBox;
        if (box == null) {
        }
        pushLayer = pushLayer();
        renderChildren(marker, false);
        if (pushLayer) {
        }
        statePop();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void renderMarkers(SVG.GraphicsElement graphicsElement) {
        SVG.Marker marker;
        String str;
        SVG.Marker marker2;
        String str2;
        SVG.Marker marker3;
        List<MarkerVector> markers;
        int size;
        int i5;
        SVG.Style style = this.state.style;
        String str3 = style.markerStart;
        if (str3 == null && style.markerMid == null && style.markerEnd == null) {
            return;
        }
        if (str3 != null) {
            SVG.SvgObject resolveIRI = graphicsElement.document.resolveIRI(str3);
            if (resolveIRI != null) {
                marker = (SVG.Marker) resolveIRI;
                str = this.state.style.markerMid;
                if (str != null) {
                    SVG.SvgObject resolveIRI2 = graphicsElement.document.resolveIRI(str);
                    if (resolveIRI2 != null) {
                        marker2 = (SVG.Marker) resolveIRI2;
                        str2 = this.state.style.markerEnd;
                        if (str2 != null) {
                            SVG.SvgObject resolveIRI3 = graphicsElement.document.resolveIRI(str2);
                            if (resolveIRI3 != null) {
                                marker3 = (SVG.Marker) resolveIRI3;
                                markers = !(graphicsElement instanceof SVG.Path) ? new MarkerPositionCalculator(((SVG.Path) graphicsElement).f4250d).getMarkers() : graphicsElement instanceof SVG.Line ? calculateMarkerPositions((SVG.Line) graphicsElement) : calculateMarkerPositions((SVG.PolyLine) graphicsElement);
                                if (markers == null && (size = markers.size()) != 0) {
                                    SVG.Style style2 = this.state.style;
                                    style2.markerEnd = null;
                                    style2.markerMid = null;
                                    style2.markerStart = null;
                                    if (marker != null) {
                                        renderMarker(marker, markers.get(0));
                                    }
                                    if (marker2 != null && markers.size() > 2) {
                                        MarkerVector markerVector = markers.get(0);
                                        MarkerVector markerVector2 = markers.get(1);
                                        i5 = 1;
                                        while (i5 < size - 1) {
                                            i5++;
                                            MarkerVector markerVector3 = markers.get(i5);
                                            markerVector = markerVector2.isAmbiguous ? realignMarkerMid(markerVector, markerVector2, markerVector3) : markerVector2;
                                            renderMarker(marker2, markerVector);
                                            markerVector2 = markerVector3;
                                        }
                                    }
                                    if (marker3 == null) {
                                        renderMarker(marker3, markers.get(size - 1));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            error("Marker reference '%s' not found", this.state.style.markerEnd);
                        }
                        marker3 = null;
                        if (!(graphicsElement instanceof SVG.Path)) {
                        }
                        if (markers == null) {
                            return;
                        }
                        SVG.Style style22 = this.state.style;
                        style22.markerEnd = null;
                        style22.markerMid = null;
                        style22.markerStart = null;
                        if (marker != null) {
                        }
                        if (marker2 != null) {
                            MarkerVector markerVector4 = markers.get(0);
                            MarkerVector markerVector22 = markers.get(1);
                            i5 = 1;
                            while (i5 < size - 1) {
                            }
                        }
                        if (marker3 == null) {
                        }
                    } else {
                        error("Marker reference '%s' not found", this.state.style.markerMid);
                    }
                }
                marker2 = null;
                str2 = this.state.style.markerEnd;
                if (str2 != null) {
                }
                marker3 = null;
                if (!(graphicsElement instanceof SVG.Path)) {
                }
                if (markers == null) {
                }
            } else {
                error("Marker reference '%s' not found", this.state.style.markerStart);
            }
        }
        marker = null;
        str = this.state.style.markerMid;
        if (str != null) {
        }
        marker2 = null;
        str2 = this.state.style.markerEnd;
        if (str2 != null) {
        }
        marker3 = null;
        if (!(graphicsElement instanceof SVG.Path)) {
        }
        if (markers == null) {
        }
    }

    private void renderMask(SVG.Mask mask, SVG.SvgElement svgElement, SVG.Box box) {
        float f5;
        float f6;
        debug("Mask render", new Object[0]);
        Boolean bool = mask.maskUnitsAreUser;
        if (bool == null || !bool.booleanValue()) {
            SVG.Length length = mask.width;
            float floatValue = length != null ? length.floatValue(this, 1.0f) : 1.2f;
            SVG.Length length2 = mask.height;
            float floatValue2 = length2 != null ? length2.floatValue(this, 1.0f) : 1.2f;
            f5 = floatValue * box.width;
            f6 = floatValue2 * box.height;
        } else {
            SVG.Length length3 = mask.width;
            f5 = length3 != null ? length3.floatValueX(this) : box.width;
            SVG.Length length4 = mask.height;
            f6 = length4 != null ? length4.floatValueY(this) : box.height;
        }
        if (f5 == 0.0f || f6 == 0.0f) {
            return;
        }
        statePush();
        RendererState findInheritFromAncestorState = findInheritFromAncestorState(mask);
        this.state = findInheritFromAncestorState;
        findInheritFromAncestorState.style.opacity = Float.valueOf(1.0f);
        boolean pushLayer = pushLayer();
        this.canvas.save();
        Boolean bool2 = mask.maskContentUnitsAreUser;
        if (bool2 != null && !bool2.booleanValue()) {
            this.canvas.translate(box.minX, box.minY);
            this.canvas.scale(box.width, box.height);
        }
        renderChildren(mask, false);
        this.canvas.restore();
        if (pushLayer) {
            popLayer(svgElement, box);
        }
        statePop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void renderSwitchChild(SVG.Switch r6) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        SVG.getFileResolver();
        for (SVG.SvgObject svgObject : r6.getChildren()) {
            if (svgObject instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) svgObject;
                if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                    Set<String> requiredFeatures = svgConditional.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (supportedFeatures == null) {
                            initialiseSupportedFeaturesMap();
                        }
                        if (!requiredFeatures.isEmpty() && supportedFeatures.containsAll(requiredFeatures)) {
                        }
                    }
                    Set<String> requiredFormats = svgConditional.getRequiredFormats();
                    if (requiredFormats != null) {
                        requiredFormats.isEmpty();
                    } else {
                        Set<String> requiredFonts = svgConditional.getRequiredFonts();
                        if (requiredFonts == null) {
                            render(svgObject);
                            return;
                        }
                        requiredFonts.isEmpty();
                    }
                }
            }
        }
    }

    private void renderTextPath(SVG.TextPath textPath) {
        debug("TextPath render", new Object[0]);
        updateStyleForElement(this.state, textPath);
        if (display() && visible()) {
            SVG.SvgObject resolveIRI = textPath.document.resolveIRI(textPath.href);
            if (resolveIRI == null) {
                error("TextPath reference '%s' not found", textPath.href);
                return;
            }
            SVG.Path path = (SVG.Path) resolveIRI;
            Path path2 = new PathConverter(path.f4250d).getPath();
            Matrix matrix = path.transform;
            if (matrix != null) {
                path2.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(path2, false);
            SVG.Length length = textPath.startOffset;
            float floatValue = length != null ? length.floatValue(this, pathMeasure.getLength()) : 0.0f;
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(textPath);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValue -= calculateTextWidth;
            }
            checkForGradientsAndPatterns((SVG.SvgElement) textPath.getTextRoot());
            boolean pushLayer = pushLayer();
            enumerateTextSpans(textPath, new PathTextDrawer(path2, floatValue, 0.0f));
            if (pushLayer) {
                popLayer(textPath);
            }
        }
    }

    private boolean requiresCompositing() {
        return this.state.style.opacity.floatValue() < 1.0f || this.state.style.mask != null;
    }

    private void resetState() {
        this.state = new RendererState();
        this.stateStack = new Stack<>();
        updateStyle(this.state, SVG.Style.getDefaultStyle());
        RendererState rendererState = this.state;
        rendererState.viewPort = null;
        rendererState.spacePreserve = false;
        this.stateStack.push(new RendererState(rendererState));
        this.matrixStack = new Stack<>();
        this.parentStack = new Stack<>();
    }

    private void setClipRect(float f5, float f6, float f7, float f8) {
        float f9 = f7 + f5;
        float f10 = f8 + f6;
        SVG.CSSClipRect cSSClipRect = this.state.style.clip;
        if (cSSClipRect != null) {
            f5 += cSSClipRect.left.floatValueX(this);
            f6 += this.state.style.clip.top.floatValueY(this);
            f9 -= this.state.style.clip.right.floatValueX(this);
            f10 -= this.state.style.clip.bottom.floatValueY(this);
        }
        this.canvas.clipRect(f5, f6, f9, f10);
    }

    private void setPaintColour(RendererState rendererState, boolean z5, SVG.SvgPaint svgPaint) {
        int i5;
        SVG.Style style = rendererState.style;
        float floatValue = (z5 ? style.fillOpacity : style.strokeOpacity).floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i5 = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i5 = rendererState.style.color.colour;
        }
        int colourWithOpacity = colourWithOpacity(i5, floatValue);
        if (z5) {
            rendererState.fillPaint.setColor(colourWithOpacity);
        } else {
            rendererState.strokePaint.setColor(colourWithOpacity);
        }
    }

    private void setSolidColor(boolean z5, SVG.SolidColor solidColor) {
        if (z5) {
            if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                RendererState rendererState = this.state;
                SVG.Style style = rendererState.style;
                SVG.SvgPaint svgPaint = solidColor.baseStyle.solidColor;
                style.fill = svgPaint;
                rendererState.hasFill = svgPaint != null;
            }
            if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                this.state.style.fillOpacity = solidColor.baseStyle.solidOpacity;
            }
            if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                RendererState rendererState2 = this.state;
                setPaintColour(rendererState2, z5, rendererState2.style.fill);
                return;
            }
            return;
        }
        if (isSpecified(solidColor.baseStyle, 2147483648L)) {
            RendererState rendererState3 = this.state;
            SVG.Style style2 = rendererState3.style;
            SVG.SvgPaint svgPaint2 = solidColor.baseStyle.solidColor;
            style2.stroke = svgPaint2;
            rendererState3.hasStroke = svgPaint2 != null;
        }
        if (isSpecified(solidColor.baseStyle, 4294967296L)) {
            this.state.style.strokeOpacity = solidColor.baseStyle.solidOpacity;
        }
        if (isSpecified(solidColor.baseStyle, 6442450944L)) {
            RendererState rendererState4 = this.state;
            setPaintColour(rendererState4, z5, rendererState4.style.stroke);
        }
    }

    private void statePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void statePush() {
        this.canvas.save();
        this.stateStack.push(this.state);
        this.state = new RendererState(this.state);
    }

    private String textXMLSpaceTransform(String str, boolean z5, boolean z6) {
        if (this.state.spacePreserve) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", BuildConfig.FLAVOR).replaceAll("\\t", " ");
        if (z5) {
            replaceAll = replaceAll.replaceAll("^\\s+", BuildConfig.FLAVOR);
        }
        if (z6) {
            replaceAll = replaceAll.replaceAll("\\s+$", BuildConfig.FLAVOR);
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    private void updateParentBoundingBox(SVG.SvgElement svgElement) {
        if (svgElement.parent == null || svgElement.boundingBox == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.matrixStack.peek().invert(matrix)) {
            SVG.Box box = svgElement.boundingBox;
            float f5 = box.minX;
            float f6 = box.minY;
            float maxX = box.maxX();
            SVG.Box box2 = svgElement.boundingBox;
            float f7 = box2.minY;
            float maxX2 = box2.maxX();
            float maxY = svgElement.boundingBox.maxY();
            SVG.Box box3 = svgElement.boundingBox;
            float[] fArr = {f5, f6, maxX, f7, maxX2, maxY, box3.minX, box3.maxY()};
            matrix.preConcat(this.canvas.getMatrix());
            matrix.mapPoints(fArr);
            float f8 = fArr[0];
            float f9 = fArr[1];
            RectF rectF = new RectF(f8, f9, f8, f9);
            for (int i5 = 2; i5 <= 6; i5 += 2) {
                float f10 = fArr[i5];
                if (f10 < rectF.left) {
                    rectF.left = f10;
                }
                if (f10 > rectF.right) {
                    rectF.right = f10;
                }
                float f11 = fArr[i5 + 1];
                if (f11 < rectF.top) {
                    rectF.top = f11;
                }
                if (f11 > rectF.bottom) {
                    rectF.bottom = f11;
                }
            }
            SVG.SvgElement svgElement2 = (SVG.SvgElement) this.parentStack.peek();
            SVG.Box box4 = svgElement2.boundingBox;
            if (box4 == null) {
                svgElement2.boundingBox = SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                box4.union(SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private void updateStyle(RendererState rendererState, SVG.Style style) {
        if (isSpecified(style, 4096L)) {
            rendererState.style.color = style.color;
        }
        if (isSpecified(style, 2048L)) {
            rendererState.style.opacity = style.opacity;
        }
        if (isSpecified(style, 1L)) {
            rendererState.style.fill = style.fill;
            SVG.SvgPaint svgPaint = style.fill;
            rendererState.hasFill = (svgPaint == null || svgPaint == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 4L)) {
            rendererState.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149L)) {
            setPaintColour(rendererState, true, rendererState.style.fill);
        }
        if (isSpecified(style, 2L)) {
            rendererState.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8L)) {
            rendererState.style.stroke = style.stroke;
            SVG.SvgPaint svgPaint2 = style.stroke;
            rendererState.hasStroke = (svgPaint2 == null || svgPaint2 == SVG.Colour.TRANSPARENT) ? false : true;
        }
        if (isSpecified(style, 16L)) {
            rendererState.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168L)) {
            setPaintColour(rendererState, false, rendererState.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            rendererState.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32L)) {
            SVG.Style style2 = rendererState.style;
            SVG.Length length = style.strokeWidth;
            style2.strokeWidth = length;
            rendererState.strokePaint.setStrokeWidth(length.floatValue(this));
        }
        if (isSpecified(style, 64L)) {
            rendererState.style.strokeLineCap = style.strokeLineCap;
            int i5 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Style$LineCap[style.strokeLineCap.ordinal()];
            if (i5 == 1) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.BUTT);
            } else if (i5 == 2) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.ROUND);
            } else if (i5 == 3) {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (isSpecified(style, 128L)) {
            rendererState.style.strokeLineJoin = style.strokeLineJoin;
            int i6 = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$SVG$Style$LineJoin[style.strokeLineJoin.ordinal()];
            if (i6 == 1) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.MITER);
            } else if (i6 == 2) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.ROUND);
            } else if (i6 == 3) {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (isSpecified(style, 256L)) {
            rendererState.style.strokeMiterLimit = style.strokeMiterLimit;
            rendererState.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512L)) {
            rendererState.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024L)) {
            rendererState.style.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typeface = null;
        if (isSpecified(style, 1536L)) {
            SVG.Length[] lengthArr = rendererState.style.strokeDashArray;
            if (lengthArr == null) {
                rendererState.strokePaint.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                int i7 = length2 % 2 == 0 ? length2 : length2 * 2;
                float[] fArr = new float[i7];
                float f5 = 0.0f;
                for (int i8 = 0; i8 < i7; i8++) {
                    float floatValue = rendererState.style.strokeDashArray[i8 % length2].floatValue(this);
                    fArr[i8] = floatValue;
                    f5 += floatValue;
                }
                if (f5 == 0.0f) {
                    rendererState.strokePaint.setPathEffect(null);
                } else {
                    float floatValue2 = rendererState.style.strokeDashOffset.floatValue(this);
                    if (floatValue2 < 0.0f) {
                        floatValue2 = (floatValue2 % f5) + f5;
                    }
                    rendererState.strokePaint.setPathEffect(new DashPathEffect(fArr, floatValue2));
                }
            }
        }
        if (isSpecified(style, 16384L)) {
            float currentFontSize = getCurrentFontSize();
            rendererState.style.fontSize = style.fontSize;
            rendererState.fillPaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
            rendererState.strokePaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
        }
        if (isSpecified(style, 8192L)) {
            rendererState.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, 32768L)) {
            if (style.fontWeight.intValue() == -1 && rendererState.style.fontWeight.intValue() > 100) {
                SVG.Style style3 = rendererState.style;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() != 1 || rendererState.style.fontWeight.intValue() >= 900) {
                rendererState.style.fontWeight = style.fontWeight;
            } else {
                SVG.Style style4 = rendererState.style;
                style4.fontWeight = Integer.valueOf(style4.fontWeight.intValue() + 100);
            }
        }
        if (isSpecified(style, 65536L)) {
            rendererState.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 106496L)) {
            if (rendererState.style.fontFamily != null && this.document != null) {
                SVG.getFileResolver();
                for (String str : rendererState.style.fontFamily) {
                    SVG.Style style5 = rendererState.style;
                    typeface = checkGenericFont(str, style5.fontWeight, style5.fontStyle);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = rendererState.style;
                typeface = checkGenericFont(DEFAULT_FONT_FAMILY, style6.fontWeight, style6.fontStyle);
            }
            rendererState.fillPaint.setTypeface(typeface);
            rendererState.strokePaint.setTypeface(typeface);
        }
        if (isSpecified(style, 131072L)) {
            rendererState.style.textDecoration = style.textDecoration;
            Paint paint = rendererState.fillPaint;
            SVG.Style.TextDecoration textDecoration = style.textDecoration;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = rendererState.fillPaint;
            SVG.Style.TextDecoration textDecoration3 = style.textDecoration;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            rendererState.strokePaint.setStrikeThruText(style.textDecoration == textDecoration2);
            rendererState.strokePaint.setUnderlineText(style.textDecoration == textDecoration4);
        }
        if (isSpecified(style, 68719476736L)) {
            rendererState.style.direction = style.direction;
        }
        if (isSpecified(style, 262144L)) {
            rendererState.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, 524288L)) {
            rendererState.style.overflow = style.overflow;
        }
        if (isSpecified(style, 2097152L)) {
            rendererState.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, 4194304L)) {
            rendererState.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, 8388608L)) {
            rendererState.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216L)) {
            rendererState.style.display = style.display;
        }
        if (isSpecified(style, 33554432L)) {
            rendererState.style.visibility = style.visibility;
        }
        if (isSpecified(style, 1048576L)) {
            rendererState.style.clip = style.clip;
        }
        if (isSpecified(style, 268435456L)) {
            rendererState.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912L)) {
            rendererState.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, 1073741824L)) {
            rendererState.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864L)) {
            rendererState.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728L)) {
            rendererState.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            rendererState.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            rendererState.style.viewportFillOpacity = style.viewportFillOpacity;
        }
        if (isSpecified(style, 137438953472L)) {
            rendererState.style.imageRendering = style.imageRendering;
        }
    }

    private void updateStyleForElement(RendererState rendererState, SVG.SvgElementBase svgElementBase) {
        rendererState.style.resetNonInheritingProperties(svgElementBase.parent == null);
        SVG.Style style = svgElementBase.baseStyle;
        if (style != null) {
            updateStyle(rendererState, style);
        }
        if (this.document.hasCSSRules()) {
            for (CSSParser.Rule rule : this.document.getCSSRules()) {
                if (CSSParser.ruleMatch(this.ruleMatchContext, rule.selector, svgElementBase)) {
                    updateStyle(rendererState, rule.style);
                }
            }
        }
        SVG.Style style2 = svgElementBase.style;
        if (style2 != null) {
            updateStyle(rendererState, style2);
        }
    }

    private void viewportFill() {
        int i5;
        SVG.Style style = this.state.style;
        SVG.SvgPaint svgPaint = style.viewportFill;
        if (svgPaint instanceof SVG.Colour) {
            i5 = ((SVG.Colour) svgPaint).colour;
        } else if (!(svgPaint instanceof SVG.CurrentColor)) {
            return;
        } else {
            i5 = style.color.colour;
        }
        Float f5 = style.viewportFillOpacity;
        if (f5 != null) {
            i5 = colourWithOpacity(i5, f5.floatValue());
        }
        this.canvas.drawColor(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean visible() {
        Boolean bool = this.state.style.visibility;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCurrentFontSize() {
        return this.state.fillPaint.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCurrentFontXHeight() {
        return this.state.fillPaint.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVG.Box getCurrentViewPortInUserUnits() {
        RendererState rendererState = this.state;
        SVG.Box box = rendererState.viewBox;
        return box != null ? box : rendererState.viewPort;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getDPI() {
        return this.dpi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void renderDocument(SVG svg, RenderOptions renderOptions) {
        SVG.Box box;
        PreserveAspectRatio preserveAspectRatio;
        if (renderOptions == null) {
            throw new NullPointerException("renderOptions shouldn't be null");
        }
        this.document = svg;
        SVG.Svg rootElement = svg.getRootElement();
        if (rootElement == null) {
            warn("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        if (renderOptions.hasView()) {
            SVG.SvgElementBase elementById = this.document.getElementById(renderOptions.viewId);
            if (elementById == null || !(elementById instanceof SVG.View)) {
                Log.w(TAG, String.format("View element with id \"%s\" not found.", renderOptions.viewId));
                return;
            }
            SVG.View view = (SVG.View) elementById;
            box = view.viewBox;
            if (box == null) {
                Log.w(TAG, String.format("View element with id \"%s\" is missing a viewBox attribute.", renderOptions.viewId));
                return;
            }
            preserveAspectRatio = view.preserveAspectRatio;
        } else {
            box = renderOptions.hasViewBox() ? renderOptions.viewBox : rootElement.viewBox;
            preserveAspectRatio = renderOptions.hasPreserveAspectRatio() ? renderOptions.preserveAspectRatio : rootElement.preserveAspectRatio;
        }
        if (renderOptions.hasCss()) {
            svg.addCSSRules(renderOptions.css);
        }
        if (renderOptions.hasTarget()) {
            CSSParser.RuleMatchContext ruleMatchContext = new CSSParser.RuleMatchContext();
            this.ruleMatchContext = ruleMatchContext;
            ruleMatchContext.targetElement = svg.getElementById(renderOptions.targetId);
        }
        resetState();
        checkXMLSpaceAttribute(rootElement);
        statePush();
        SVG.Box box2 = new SVG.Box(renderOptions.viewPort);
        SVG.Length length = rootElement.width;
        if (length != null) {
            box2.width = length.floatValue(this, box2.width);
        }
        SVG.Length length2 = rootElement.height;
        if (length2 != null) {
            box2.height = length2.floatValue(this, box2.height);
        }
        render(rootElement, box2, box, preserveAspectRatio);
        statePop();
        if (renderOptions.hasCss()) {
            svg.clearRenderCSSRules();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TextWidthCalculator extends TextProcessor {

        /* renamed from: x, reason: collision with root package name */
        float f4274x;

        private TextWidthCalculator() {
            super(SVGAndroidRenderer.this, null);
            this.f4274x = 0.0f;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            this.f4274x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }

        /* synthetic */ TextWidthCalculator(SVGAndroidRenderer sVGAndroidRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private void checkForClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        Path calculateClipPath;
        if (this.state.style.clipPath == null || (calculateClipPath = calculateClipPath(svgElement, box)) == null) {
            return;
        }
        this.canvas.clipPath(calculateClipPath);
    }

    private void popLayer(SVG.SvgElement svgElement, SVG.Box box) {
        if (this.state.style.mask != null) {
            Paint paint = new Paint();
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            this.canvas.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.canvas.saveLayer(null, paint2, 31);
            SVG.Mask mask = (SVG.Mask) this.document.resolveIRI(this.state.style.mask);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(mode));
            this.canvas.saveLayer(null, paint3, 31);
            renderMask(mask, svgElement, box);
            this.canvas.restore();
            this.canvas.restore();
        }
        statePop();
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject, RendererState rendererState) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (svgObject instanceof SVG.SvgElementBase) {
                arrayList.add(0, (SVG.SvgElementBase) svgObject);
            }
            Object obj = svgObject.parent;
            if (obj == null) {
                break;
            }
            svgObject = (SVG.SvgObject) obj;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            updateStyleForElement(rendererState, (SVG.SvgElementBase) it.next());
        }
        RendererState rendererState2 = this.state;
        rendererState.viewBox = rendererState2.viewBox;
        rendererState.viewPort = rendererState2.viewPort;
        return rendererState;
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.PolyLine polyLine) {
        int length = polyLine.points.length;
        int i5 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = polyLine.points;
        MarkerVector markerVector = new MarkerVector(fArr[0], fArr[1], 0.0f, 0.0f);
        float f5 = 0.0f;
        float f6 = 0.0f;
        while (i5 < length) {
            float[] fArr2 = polyLine.points;
            float f7 = fArr2[i5];
            float f8 = fArr2[i5 + 1];
            markerVector.add(f7, f8);
            arrayList.add(markerVector);
            i5 += 2;
            markerVector = new MarkerVector(f7, f8, f7 - markerVector.f4266x, f8 - markerVector.f4267y);
            f6 = f8;
            f5 = f7;
        }
        if (polyLine instanceof SVG.Polygon) {
            float[] fArr3 = polyLine.points;
            float f9 = fArr3[0];
            if (f5 != f9) {
                float f10 = fArr3[1];
                if (f6 != f10) {
                    markerVector.add(f9, f10);
                    arrayList.add(markerVector);
                    MarkerVector markerVector2 = new MarkerVector(f9, f10, f9 - markerVector.f4266x, f10 - markerVector.f4267y);
                    markerVector2.add((MarkerVector) arrayList.get(0));
                    arrayList.add(markerVector2);
                    arrayList.set(0, markerVector2);
                }
            }
        } else {
            arrayList.add(markerVector);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MarkerVector {
        float dx;
        float dy;
        boolean isAmbiguous = false;

        /* renamed from: x, reason: collision with root package name */
        float f4266x;

        /* renamed from: y, reason: collision with root package name */
        float f4267y;

        MarkerVector(float f5, float f6, float f7, float f8) {
            this.dx = 0.0f;
            this.dy = 0.0f;
            this.f4266x = f5;
            this.f4267y = f6;
            double sqrt = Math.sqrt((f7 * f7) + (f8 * f8));
            if (sqrt != 0.0d) {
                this.dx = (float) (f7 / sqrt);
                this.dy = (float) (f8 / sqrt);
            }
        }

        void add(float f5, float f6) {
            float f7 = f5 - this.f4266x;
            float f8 = f6 - this.f4267y;
            double sqrt = Math.sqrt((f7 * f7) + (f8 * f8));
            if (sqrt != 0.0d) {
                f7 = (float) (f7 / sqrt);
                f8 = (float) (f8 / sqrt);
            }
            float f9 = this.dx;
            if (f7 == (-f9) && f8 == (-this.dy)) {
                this.isAmbiguous = true;
                this.dx = -f8;
                this.dy = f7;
            } else {
                this.dx = f9 + f7;
                this.dy += f8;
            }
        }

        public String toString() {
            return "(" + this.f4266x + "," + this.f4267y + " " + this.dx + "," + this.dy + ")";
        }

        void add(MarkerVector markerVector) {
            float f5 = markerVector.dx;
            float f6 = this.dx;
            if (f5 == (-f6)) {
                float f7 = markerVector.dy;
                if (f7 == (-this.dy)) {
                    this.isAmbiguous = true;
                    this.dx = -f7;
                    this.dy = markerVector.dx;
                    return;
                }
            }
            this.dx = f6 + f5;
            this.dy += markerVector.dy;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Path makePathAndBoundingBox(SVG.Rect rect) {
        float floatValueX;
        float floatValueY;
        float min;
        float floatValueX2;
        float floatValueY2;
        float f5;
        float f6;
        Path path;
        Path path2;
        SVG.Length length = rect.rx;
        if (length == null && rect.ry == null) {
            floatValueX = 0.0f;
        } else if (length == null) {
            floatValueX = rect.ry.floatValueY(this);
        } else if (rect.ry == null) {
            floatValueX = length.floatValueX(this);
        } else {
            floatValueX = length.floatValueX(this);
            floatValueY = rect.ry.floatValueY(this);
            min = Math.min(floatValueX, rect.width.floatValueX(this) / 2.0f);
            float min2 = Math.min(floatValueY, rect.height.floatValueY(this) / 2.0f);
            SVG.Length length2 = rect.f4253x;
            floatValueX2 = length2 == null ? length2.floatValueX(this) : 0.0f;
            SVG.Length length3 = rect.f4254y;
            floatValueY2 = length3 == null ? length3.floatValueY(this) : 0.0f;
            float floatValueX3 = rect.width.floatValueX(this);
            float floatValueY3 = rect.height.floatValueY(this);
            if (rect.boundingBox == null) {
                rect.boundingBox = new SVG.Box(floatValueX2, floatValueY2, floatValueX3, floatValueY3);
            }
            f5 = floatValueX2 + floatValueX3;
            f6 = floatValueY2 + floatValueY3;
            path = new Path();
            if (min == 0.0f && min2 != 0.0f) {
                float f7 = min * BEZIER_ARC_FACTOR;
                float f8 = BEZIER_ARC_FACTOR * min2;
                float f9 = floatValueY2 + min2;
                path.moveTo(floatValueX2, f9);
                float f10 = f9 - f8;
                float f11 = floatValueX2 + min;
                float f12 = f11 - f7;
                path.cubicTo(floatValueX2, f10, f12, floatValueY2, f11, floatValueY2);
                float f13 = f5 - min;
                path.lineTo(f13, floatValueY2);
                float f14 = f13 + f7;
                path.cubicTo(f14, floatValueY2, f5, f10, f5, f9);
                float f15 = f6 - min2;
                path.lineTo(f5, f15);
                float f16 = f15 + f8;
                path2 = path;
                path.cubicTo(f5, f16, f14, f6, f13, f6);
                path2.lineTo(f11, f6);
                path2.cubicTo(f12, f6, floatValueX2, f16, floatValueX2, f15);
                path2.lineTo(floatValueX2, f9);
            } else {
                path2 = path;
                path2.moveTo(floatValueX2, floatValueY2);
                path2.lineTo(f5, floatValueY2);
                path2.lineTo(f5, f6);
                path2.lineTo(floatValueX2, f6);
                path2.lineTo(floatValueX2, floatValueY2);
            }
            path2.close();
            return path2;
        }
        floatValueY = floatValueX;
        min = Math.min(floatValueX, rect.width.floatValueX(this) / 2.0f);
        float min22 = Math.min(floatValueY, rect.height.floatValueY(this) / 2.0f);
        SVG.Length length22 = rect.f4253x;
        if (length22 == null) {
        }
        SVG.Length length32 = rect.f4254y;
        if (length32 == null) {
        }
        float floatValueX32 = rect.width.floatValueX(this);
        float floatValueY32 = rect.height.floatValueY(this);
        if (rect.boundingBox == null) {
        }
        f5 = floatValueX2 + floatValueX32;
        f6 = floatValueY2 + floatValueY32;
        path = new Path();
        if (min == 0.0f) {
        }
        path2 = path;
        path2.moveTo(floatValueX2, floatValueY2);
        path2.lineTo(f5, floatValueY2);
        path2.lineTo(f5, f6);
        path2.lineTo(floatValueX2, f6);
        path2.lineTo(floatValueX2, floatValueY2);
        path2.close();
        return path2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RendererState {
        Paint fillPaint;
        boolean hasFill;
        boolean hasStroke;
        boolean spacePreserve;
        Paint strokePaint;
        SVG.Style style;
        SVG.Box viewBox;
        SVG.Box viewPort;

        RendererState() {
            Paint paint = new Paint();
            this.fillPaint = paint;
            paint.setFlags(193);
            this.fillPaint.setHinting(0);
            this.fillPaint.setStyle(Paint.Style.FILL);
            Paint paint2 = this.fillPaint;
            Typeface typeface = Typeface.DEFAULT;
            paint2.setTypeface(typeface);
            Paint paint3 = new Paint();
            this.strokePaint = paint3;
            paint3.setFlags(193);
            this.strokePaint.setHinting(0);
            this.strokePaint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setTypeface(typeface);
            this.style = SVG.Style.getDefaultStyle();
        }

        RendererState(RendererState rendererState) {
            this.hasFill = rendererState.hasFill;
            this.hasStroke = rendererState.hasStroke;
            this.fillPaint = new Paint(rendererState.fillPaint);
            this.strokePaint = new Paint(rendererState.strokePaint);
            SVG.Box box = rendererState.viewPort;
            if (box != null) {
                this.viewPort = new SVG.Box(box);
            }
            SVG.Box box2 = rendererState.viewBox;
            if (box2 != null) {
                this.viewBox = new SVG.Box(box2);
            }
            this.spacePreserve = rendererState.spacePreserve;
            try {
                this.style = (SVG.Style) rendererState.style.clone();
            } catch (CloneNotSupportedException e5) {
                Log.e(SVGAndroidRenderer.TAG, "Unexpected clone error", e5);
                this.style = SVG.Style.getDefaultStyle();
            }
        }
    }

    private void fillInChainedGradientFields(SVG.SvgLinearGradient svgLinearGradient, SVG.SvgLinearGradient svgLinearGradient2) {
        if (svgLinearGradient.f4257x1 == null) {
            svgLinearGradient.f4257x1 = svgLinearGradient2.f4257x1;
        }
        if (svgLinearGradient.f4259y1 == null) {
            svgLinearGradient.f4259y1 = svgLinearGradient2.f4259y1;
        }
        if (svgLinearGradient.f4258x2 == null) {
            svgLinearGradient.f4258x2 = svgLinearGradient2.f4258x2;
        }
        if (svgLinearGradient.f4260y2 == null) {
            svgLinearGradient.f4260y2 = svgLinearGradient2.f4260y2;
        }
    }

    private void fillInChainedGradientFields(SVG.SvgRadialGradient svgRadialGradient, SVG.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.cx == null) {
            svgRadialGradient.cx = svgRadialGradient2.cx;
        }
        if (svgRadialGradient.cy == null) {
            svgRadialGradient.cy = svgRadialGradient2.cy;
        }
        if (svgRadialGradient.f4261r == null) {
            svgRadialGradient.f4261r = svgRadialGradient2.f4261r;
        }
        if (svgRadialGradient.fx == null) {
            svgRadialGradient.fx = svgRadialGradient2.fx;
        }
        if (svgRadialGradient.fy == null) {
            svgRadialGradient.fy = svgRadialGradient2.fy;
        }
    }

    private void render(SVG.Svg svg) {
        render(svg, makeViewPort(svg.f4255x, svg.f4256y, svg.width, svg.height), svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Box box) {
        render(svg, box, svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        debug("Svg render", new Object[0]);
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        if (preserveAspectRatio == null && (preserveAspectRatio = svg.preserveAspectRatio) == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        updateStyleForElement(this.state, svg);
        if (display()) {
            RendererState rendererState = this.state;
            rendererState.viewPort = box;
            if (!rendererState.style.overflow.booleanValue()) {
                SVG.Box box3 = this.state.viewPort;
                setClipRect(box3.minX, box3.minY, box3.width, box3.height);
            }
            checkForClipPath(svg, this.state.viewPort);
            if (box2 != null) {
                this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box2, preserveAspectRatio));
                this.state.viewBox = svg.viewBox;
            } else {
                Canvas canvas = this.canvas;
                SVG.Box box4 = this.state.viewPort;
                canvas.translate(box4.minX, box4.minY);
            }
            boolean pushLayer = pushLayer();
            viewportFill();
            renderChildren(svg, true);
            if (pushLayer) {
                popLayer(svg);
            }
            updateParentBoundingBox(svg);
        }
    }

    private Path makePathAndBoundingBox(SVG.Circle circle) {
        SVG.Length length = circle.cx;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = circle.cy;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float floatValue = circle.f4241r.floatValue(this);
        float f5 = floatValueX - floatValue;
        float f6 = floatValueY - floatValue;
        float f7 = floatValueX + floatValue;
        float f8 = floatValueY + floatValue;
        if (circle.boundingBox == null) {
            float f9 = 2.0f * floatValue;
            circle.boundingBox = new SVG.Box(f5, f6, f9, f9);
        }
        float f10 = BEZIER_ARC_FACTOR * floatValue;
        Path path = new Path();
        path.moveTo(floatValueX, f6);
        float f11 = floatValueX + f10;
        float f12 = floatValueY - f10;
        path.cubicTo(f11, f6, f7, f12, f7, floatValueY);
        float f13 = floatValueY + f10;
        path.cubicTo(f7, f13, f11, f8, floatValueX, f8);
        float f14 = floatValueX - f10;
        path.cubicTo(f14, f8, f5, f13, f5, floatValueY);
        path.cubicTo(f5, f12, f14, f6, floatValueX, f6);
        path.close();
        return path;
    }

    private void render(SVG.Group group) {
        debug("Group render", new Object[0]);
        updateStyleForElement(this.state, group);
        if (display()) {
            Matrix matrix = group.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            checkForClipPath(group);
            boolean pushLayer = pushLayer();
            renderChildren(group, true);
            if (pushLayer) {
                popLayer(group);
            }
            updateParentBoundingBox(group);
        }
    }

    private Path makePathAndBoundingBox(SVG.Ellipse ellipse) {
        SVG.Length length = ellipse.cx;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = ellipse.cy;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float floatValueX2 = ellipse.rx.floatValueX(this);
        float floatValueY2 = ellipse.ry.floatValueY(this);
        float f5 = floatValueX - floatValueX2;
        float f6 = floatValueY - floatValueY2;
        float f7 = floatValueX + floatValueX2;
        float f8 = floatValueY + floatValueY2;
        if (ellipse.boundingBox == null) {
            ellipse.boundingBox = new SVG.Box(f5, f6, floatValueX2 * 2.0f, 2.0f * floatValueY2);
        }
        float f9 = floatValueX2 * BEZIER_ARC_FACTOR;
        float f10 = BEZIER_ARC_FACTOR * floatValueY2;
        Path path = new Path();
        path.moveTo(floatValueX, f6);
        float f11 = floatValueX + f9;
        float f12 = floatValueY - f10;
        path.cubicTo(f11, f6, f7, f12, f7, floatValueY);
        float f13 = f10 + floatValueY;
        path.cubicTo(f7, f13, f11, f8, floatValueX, f8);
        float f14 = floatValueX - f9;
        path.cubicTo(f14, f8, f5, f13, f5, floatValueY);
        path.cubicTo(f5, f12, f14, f6, floatValueX, f6);
        path.close();
        return path;
    }

    private void render(SVG.Switch r32) {
        debug("Switch render", new Object[0]);
        updateStyleForElement(this.state, r32);
        if (display()) {
            Matrix matrix = r32.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            checkForClipPath(r32);
            boolean pushLayer = pushLayer();
            renderSwitchChild(r32);
            if (pushLayer) {
                popLayer(r32);
            }
            updateParentBoundingBox(r32);
        }
    }

    private Path makePathAndBoundingBox(SVG.PolyLine polyLine) {
        Path path = new Path();
        float[] fArr = polyLine.points;
        path.moveTo(fArr[0], fArr[1]);
        int i5 = 2;
        while (true) {
            float[] fArr2 = polyLine.points;
            if (i5 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i5], fArr2[i5 + 1]);
            i5 += 2;
        }
        if (polyLine instanceof SVG.Polygon) {
            path.close();
        }
        if (polyLine.boundingBox == null) {
            polyLine.boundingBox = calculatePathBounds(path);
        }
        return path;
    }

    private void render(SVG.Use use) {
        debug("Use render", new Object[0]);
        SVG.Length length = use.width;
        if (length == null || !length.isZero()) {
            SVG.Length length2 = use.height;
            if (length2 == null || !length2.isZero()) {
                updateStyleForElement(this.state, use);
                if (display()) {
                    SVG.SvgObject resolveIRI = use.document.resolveIRI(use.href);
                    if (resolveIRI == null) {
                        error("Use reference '%s' not found", use.href);
                        return;
                    }
                    Matrix matrix = use.transform;
                    if (matrix != null) {
                        this.canvas.concat(matrix);
                    }
                    SVG.Length length3 = use.f4264x;
                    float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
                    SVG.Length length4 = use.f4265y;
                    this.canvas.translate(floatValueX, length4 != null ? length4.floatValueY(this) : 0.0f);
                    checkForClipPath(use);
                    boolean pushLayer = pushLayer();
                    parentPush(use);
                    if (resolveIRI instanceof SVG.Svg) {
                        SVG.Box makeViewPort = makeViewPort(null, null, use.width, use.height);
                        statePush();
                        render((SVG.Svg) resolveIRI, makeViewPort);
                        statePop();
                    } else if (resolveIRI instanceof SVG.Symbol) {
                        SVG.Length length5 = use.width;
                        if (length5 == null) {
                            length5 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Length length6 = use.height;
                        if (length6 == null) {
                            length6 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Box makeViewPort2 = makeViewPort(null, null, length5, length6);
                        statePush();
                        render((SVG.Symbol) resolveIRI, makeViewPort2);
                        statePop();
                    } else {
                        render(resolveIRI);
                    }
                    parentPop();
                    if (pushLayer) {
                        popLayer(use);
                    }
                    updateParentBoundingBox(use);
                }
            }
        }
    }

    private Path makePathAndBoundingBox(SVG.Text text) {
        List<SVG.Length> list = text.f4262x;
        float f5 = 0.0f;
        float floatValueX = (list == null || list.size() == 0) ? 0.0f : text.f4262x.get(0).floatValueX(this);
        List<SVG.Length> list2 = text.f4263y;
        float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : text.f4263y.get(0).floatValueY(this);
        List<SVG.Length> list3 = text.dx;
        float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
        List<SVG.Length> list4 = text.dy;
        if (list4 != null && list4.size() != 0) {
            f5 = text.dy.get(0).floatValueY(this);
        }
        if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
            float calculateTextWidth = calculateTextWidth(text);
            if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                calculateTextWidth /= 2.0f;
            }
            floatValueX -= calculateTextWidth;
        }
        if (text.boundingBox == null) {
            TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
            enumerateTextSpans(text, textBoundsCalculator);
            RectF rectF = textBoundsCalculator.bbox;
            text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.bbox.height());
        }
        Path path = new Path();
        enumerateTextSpans(text, new PlainTextToPath(floatValueX + floatValueX2, floatValueY + f5, path));
        return path;
    }

    private void render(SVG.Path path) {
        debug("Path render", new Object[0]);
        if (path.f4250d == null) {
            return;
        }
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = path.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                Path path2 = new PathConverter(path.f4250d).getPath();
                if (path.boundingBox == null) {
                    path.boundingBox = calculatePathBounds(path2);
                }
                updateParentBoundingBox(path);
                checkForGradientsAndPatterns(path);
                checkForClipPath(path);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    path2.setFillType(getFillTypeFromState());
                    doFilledPath(path, path2);
                }
                if (this.state.hasStroke) {
                    doStroke(path2);
                }
                renderMarkers(path);
                if (pushLayer) {
                    popLayer(path);
                }
            }
        }
    }

    private void render(SVG.Rect rect) {
        debug("Rect render", new Object[0]);
        SVG.Length length = rect.width;
        if (length == null || rect.height == null || length.isZero() || rect.height.isZero()) {
            return;
        }
        updateStyleForElement(this.state, rect);
        if (display() && visible()) {
            Matrix matrix = rect.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(rect);
            updateParentBoundingBox(rect);
            checkForGradientsAndPatterns(rect);
            checkForClipPath(rect);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(rect, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(rect);
            }
        }
    }

    private void render(SVG.Circle circle) {
        debug("Circle render", new Object[0]);
        SVG.Length length = circle.f4241r;
        if (length == null || length.isZero()) {
            return;
        }
        updateStyleForElement(this.state, circle);
        if (display() && visible()) {
            Matrix matrix = circle.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(circle);
            updateParentBoundingBox(circle);
            checkForGradientsAndPatterns(circle);
            checkForClipPath(circle);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(circle, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(circle);
            }
        }
    }

    private void render(SVG.Ellipse ellipse) {
        debug("Ellipse render", new Object[0]);
        SVG.Length length = ellipse.rx;
        if (length == null || ellipse.ry == null || length.isZero() || ellipse.ry.isZero()) {
            return;
        }
        updateStyleForElement(this.state, ellipse);
        if (display() && visible()) {
            Matrix matrix = ellipse.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(ellipse);
            updateParentBoundingBox(ellipse);
            checkForGradientsAndPatterns(ellipse);
            checkForClipPath(ellipse);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(ellipse, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(ellipse);
            }
        }
    }

    private void render(SVG.Line line) {
        debug("Line render", new Object[0]);
        updateStyleForElement(this.state, line);
        if (display() && visible() && this.state.hasStroke) {
            Matrix matrix = line.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(line);
            updateParentBoundingBox(line);
            checkForGradientsAndPatterns(line);
            checkForClipPath(line);
            boolean pushLayer = pushLayer();
            doStroke(makePathAndBoundingBox);
            renderMarkers(line);
            if (pushLayer) {
                popLayer(line);
            }
        }
    }

    private void render(SVG.PolyLine polyLine) {
        debug("PolyLine render", new Object[0]);
        updateStyleForElement(this.state, polyLine);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = polyLine.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                if (polyLine.points.length < 2) {
                    return;
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(polyLine);
                updateParentBoundingBox(polyLine);
                makePathAndBoundingBox.setFillType(getFillTypeFromState());
                checkForGradientsAndPatterns(polyLine);
                checkForClipPath(polyLine);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polyLine, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                renderMarkers(polyLine);
                if (pushLayer) {
                    popLayer(polyLine);
                }
            }
        }
    }

    private void render(SVG.Polygon polygon) {
        debug("Polygon render", new Object[0]);
        updateStyleForElement(this.state, polygon);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = polygon.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                if (polygon.points.length < 2) {
                    return;
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(polygon);
                updateParentBoundingBox(polygon);
                checkForGradientsAndPatterns(polygon);
                checkForClipPath(polygon);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polygon, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                renderMarkers(polygon);
                if (pushLayer) {
                    popLayer(polygon);
                }
            }
        }
    }

    private void render(SVG.Text text) {
        debug("Text render", new Object[0]);
        updateStyleForElement(this.state, text);
        if (display()) {
            Matrix matrix = text.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            List<SVG.Length> list = text.f4262x;
            float f5 = 0.0f;
            float floatValueX = (list == null || list.size() == 0) ? 0.0f : text.f4262x.get(0).floatValueX(this);
            List<SVG.Length> list2 = text.f4263y;
            float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : text.f4263y.get(0).floatValueY(this);
            List<SVG.Length> list3 = text.dx;
            float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : text.dx.get(0).floatValueX(this);
            List<SVG.Length> list4 = text.dy;
            if (list4 != null && list4.size() != 0) {
                f5 = text.dy.get(0).floatValueY(this);
            }
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(text);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValueX -= calculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
                enumerateTextSpans(text, textBoundsCalculator);
                RectF rectF = textBoundsCalculator.bbox;
                text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.bbox.height());
            }
            updateParentBoundingBox(text);
            checkForGradientsAndPatterns(text);
            checkForClipPath(text);
            boolean pushLayer = pushLayer();
            enumerateTextSpans(text, new PlainTextDrawer(floatValueX + floatValueX2, floatValueY + f5));
            if (pushLayer) {
                popLayer(text);
            }
        }
    }

    private void render(SVG.Symbol symbol, SVG.Box box) {
        debug("Symbol render", new Object[0]);
        if (box.width == 0.0f || box.height == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = symbol.preserveAspectRatio;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        updateStyleForElement(this.state, symbol);
        RendererState rendererState = this.state;
        rendererState.viewPort = box;
        if (!rendererState.style.overflow.booleanValue()) {
            SVG.Box box2 = this.state.viewPort;
            setClipRect(box2.minX, box2.minY, box2.width, box2.height);
        }
        SVG.Box box3 = symbol.viewBox;
        if (box3 != null) {
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box3, preserveAspectRatio));
            this.state.viewBox = symbol.viewBox;
        } else {
            Canvas canvas = this.canvas;
            SVG.Box box4 = this.state.viewPort;
            canvas.translate(box4.minX, box4.minY);
        }
        boolean pushLayer = pushLayer();
        renderChildren(symbol, true);
        if (pushLayer) {
            popLayer(symbol);
        }
        updateParentBoundingBox(symbol);
    }

    private void render(SVG.Image image) {
        SVG.Length length;
        String str;
        debug("Image render", new Object[0]);
        SVG.Length length2 = image.width;
        if (length2 == null || length2.isZero() || (length = image.height) == null || length.isZero() || (str = image.href) == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = image.preserveAspectRatio;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        Bitmap checkForImageDataURL = checkForImageDataURL(str);
        if (checkForImageDataURL == null) {
            SVG.getFileResolver();
            return;
        }
        SVG.Box box = new SVG.Box(0.0f, 0.0f, checkForImageDataURL.getWidth(), checkForImageDataURL.getHeight());
        updateStyleForElement(this.state, image);
        if (display() && visible()) {
            Matrix matrix = image.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            SVG.Length length3 = image.f4242x;
            float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
            SVG.Length length4 = image.f4243y;
            this.state.viewPort = new SVG.Box(floatValueX, length4 != null ? length4.floatValueY(this) : 0.0f, image.width.floatValueX(this), image.height.floatValueX(this));
            if (!this.state.style.overflow.booleanValue()) {
                SVG.Box box2 = this.state.viewPort;
                setClipRect(box2.minX, box2.minY, box2.width, box2.height);
            }
            image.boundingBox = this.state.viewPort;
            updateParentBoundingBox(image);
            checkForClipPath(image);
            boolean pushLayer = pushLayer();
            viewportFill();
            this.canvas.save();
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box, preserveAspectRatio));
            this.canvas.drawBitmap(checkForImageDataURL, 0.0f, 0.0f, new Paint(this.state.style.imageRendering != SVG.Style.RenderQuality.optimizeSpeed ? 2 : 0));
            this.canvas.restore();
            if (pushLayer) {
                popLayer(image);
            }
        }
    }
}
