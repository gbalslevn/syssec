package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public class TextLayer extends BaseLayer {
    private final LongSparseArray<String> codePointCache;
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final StringBuilder stringBuilder;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
    private final Paint strokePaint;
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
    private final List<TextSubLine> textSubLines;
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;
    private BaseKeyframeAnimation<Typeface, Typeface> typefaceCallbackAnimation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.TextLayer$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class TextSubLine {
        private String text;
        private float width;

        private TextSubLine() {
            this.text = BuildConfig.FLAVOR;
            this.width = 0.0f;
        }

        void set(String str, float f5) {
            this.text = str;
            this.width = f5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        this.stringBuilder = new StringBuilder(2);
        this.rectF = new RectF();
        this.matrix = new Matrix();
        int i5 = 1;
        this.fillPaint = new Paint(i5) { // from class: com.airbnb.lottie.model.layer.TextLayer.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(i5) { // from class: com.airbnb.lottie.model.layer.TextLayer.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.contentsForCharacter = new HashMap();
        this.codePointCache = new LongSparseArray<>();
        this.textSubLines = new ArrayList();
        this.lottieDrawable = lottieDrawable;
        this.composition = layer.getComposition();
        TextKeyframeAnimation createAnimation = layer.getText().createAnimation();
        this.textAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        addAnimation(createAnimation);
        AnimatableTextProperties textProperties = layer.getTextProperties();
        if (textProperties != null && (animatableColorValue2 = textProperties.color) != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = animatableColorValue2.createAnimation();
            this.colorAnimation = createAnimation2;
            createAnimation2.addUpdateListener(this);
            addAnimation(this.colorAnimation);
        }
        if (textProperties != null && (animatableColorValue = textProperties.stroke) != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation3 = animatableColorValue.createAnimation();
            this.strokeColorAnimation = createAnimation3;
            createAnimation3.addUpdateListener(this);
            addAnimation(this.strokeColorAnimation);
        }
        if (textProperties != null && (animatableFloatValue2 = textProperties.strokeWidth) != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation4 = animatableFloatValue2.createAnimation();
            this.strokeWidthAnimation = createAnimation4;
            createAnimation4.addUpdateListener(this);
            addAnimation(this.strokeWidthAnimation);
        }
        if (textProperties == null || (animatableFloatValue = textProperties.tracking) == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> createAnimation5 = animatableFloatValue.createAnimation();
        this.trackingAnimation = createAnimation5;
        createAnimation5.addUpdateListener(this);
        addAnimation(this.trackingAnimation);
    }

    private String codePointToString(String str, int i5) {
        int codePointAt = str.codePointAt(i5);
        int charCount = Character.charCount(codePointAt) + i5;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!isModifier(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j5 = codePointAt;
        if (this.codePointCache.containsKey(j5)) {
            return this.codePointCache.get(j5);
        }
        this.stringBuilder.setLength(0);
        while (i5 < charCount) {
            int codePointAt3 = str.codePointAt(i5);
            this.stringBuilder.appendCodePoint(codePointAt3);
            i5 += Character.charCount(codePointAt3);
        }
        String sb = this.stringBuilder.toString();
        this.codePointCache.put(j5, sb);
        return sb;
    }

    private void configurePaint(DocumentData documentData, Matrix matrix) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
        if (baseKeyframeAnimation != null) {
            this.fillPaint.setColor(baseKeyframeAnimation.getValue().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.colorAnimation;
            if (baseKeyframeAnimation2 != null) {
                this.fillPaint.setColor(baseKeyframeAnimation2.getValue().intValue());
            } else {
                this.fillPaint.setColor(documentData.color);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.strokeColorCallbackAnimation;
        if (baseKeyframeAnimation3 != null) {
            this.strokePaint.setColor(baseKeyframeAnimation3.getValue().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.strokeColorAnimation;
            if (baseKeyframeAnimation4 != null) {
                this.strokePaint.setColor(baseKeyframeAnimation4.getValue().intValue());
            } else {
                this.strokePaint.setColor(documentData.strokeColor);
            }
        }
        int intValue = ((this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue()) * Function.USE_VARARGS) / 100;
        this.fillPaint.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.strokeWidthCallbackAnimation;
        if (baseKeyframeAnimation5 != null) {
            this.strokePaint.setStrokeWidth(baseKeyframeAnimation5.getValue().floatValue());
            return;
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.strokeWidthAnimation;
        if (baseKeyframeAnimation6 != null) {
            this.strokePaint.setStrokeWidth(baseKeyframeAnimation6.getValue().floatValue());
        } else {
            this.strokePaint.setStrokeWidth(documentData.strokeWidth * Utils.dpScale());
        }
    }

    private void drawCharacter(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, float f5, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> contentsForCharacter = getContentsForCharacter(fontCharacter);
        for (int i5 = 0; i5 < contentsForCharacter.size(); i5++) {
            Path path = contentsForCharacter.get(i5).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.reset();
            this.matrix.preTranslate(0.0f, (-documentData.baselineShift) * Utils.dpScale());
            this.matrix.preScale(f5, f5);
            path.transform(this.matrix);
            if (documentData.strokeOverFill) {
                drawGlyph(path, this.fillPaint, canvas);
                drawGlyph(path, this.strokePaint, canvas);
            } else {
                drawGlyph(path, this.strokePaint, canvas);
                drawGlyph(path, this.fillPaint, canvas);
            }
        }
    }

    private void drawCharacterFromFont(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.strokeOverFill) {
            drawCharacter(str, this.fillPaint, canvas);
            drawCharacter(str, this.strokePaint, canvas);
        } else {
            drawCharacter(str, this.strokePaint, canvas);
            drawCharacter(str, this.fillPaint, canvas);
        }
    }

    private void drawFontTextLine(String str, DocumentData documentData, Canvas canvas, float f5) {
        int i5 = 0;
        while (i5 < str.length()) {
            String codePointToString = codePointToString(str, i5);
            i5 += codePointToString.length();
            drawCharacterFromFont(codePointToString, documentData, canvas);
            canvas.translate(this.fillPaint.measureText(codePointToString) + f5, 0.0f);
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void drawGlyphTextLine(String str, DocumentData documentData, Font font, Canvas canvas, float f5, float f6, float f7) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(str.charAt(i5), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                drawCharacterAsGlyph(fontCharacter, f6, documentData, canvas);
                canvas.translate((((float) fontCharacter.getWidth()) * f6 * Utils.dpScale()) + f7, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawTextWithFont(DocumentData documentData, Font font, Canvas canvas) {
        float floatValue;
        int size;
        int i5;
        Typeface typeface = getTypeface(font);
        if (typeface == null) {
            return;
        }
        String str = documentData.text;
        this.lottieDrawable.getTextDelegate();
        this.fillPaint.setTypeface(typeface);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.textSizeCallbackAnimation;
        float floatValue2 = baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() : documentData.size;
        this.fillPaint.setTextSize(Utils.dpScale() * floatValue2);
        this.strokePaint.setTypeface(this.fillPaint.getTypeface());
        this.strokePaint.setTextSize(this.fillPaint.getTextSize());
        float f5 = documentData.tracking / 10.0f;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.trackingCallbackAnimation;
        if (baseKeyframeAnimation2 == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.trackingAnimation;
            if (baseKeyframeAnimation3 != null) {
                floatValue = baseKeyframeAnimation3.getValue().floatValue();
            }
            float dpScale = ((f5 * Utils.dpScale()) * floatValue2) / 100.0f;
            List<String> textLines = getTextLines(str);
            size = textLines.size();
            int i6 = -1;
            i5 = 0;
            while (i5 < size) {
                String str2 = textLines.get(i5);
                PointF pointF = documentData.boxSize;
                int i7 = i5;
                List<TextSubLine> splitGlyphTextIntoLines = splitGlyphTextIntoLines(str2, pointF == null ? 0.0f : pointF.x, font, 0.0f, dpScale, false);
                for (int i8 = 0; i8 < splitGlyphTextIntoLines.size(); i8++) {
                    TextSubLine textSubLine = splitGlyphTextIntoLines.get(i8);
                    i6++;
                    canvas.save();
                    offsetCanvas(canvas, documentData, i6, textSubLine.width);
                    drawFontTextLine(textSubLine.text, documentData, canvas, dpScale);
                    canvas.restore();
                }
                i5 = i7 + 1;
            }
        }
        floatValue = baseKeyframeAnimation2.getValue().floatValue();
        f5 += floatValue;
        float dpScale2 = ((f5 * Utils.dpScale()) * floatValue2) / 100.0f;
        List<String> textLines2 = getTextLines(str);
        size = textLines2.size();
        int i62 = -1;
        i5 = 0;
        while (i5 < size) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawTextWithGlyphs(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float floatValue;
        int i5;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.textSizeCallbackAnimation;
        float floatValue2 = (baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() : documentData.size) / 100.0f;
        float scale = Utils.getScale(matrix);
        List<String> textLines = getTextLines(documentData.text);
        int size = textLines.size();
        float f5 = documentData.tracking / 10.0f;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.trackingCallbackAnimation;
        if (baseKeyframeAnimation2 == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.trackingAnimation;
            if (baseKeyframeAnimation3 != null) {
                floatValue = baseKeyframeAnimation3.getValue().floatValue();
            }
            float f6 = f5;
            int i6 = -1;
            i5 = 0;
            while (i5 < size) {
                String str = textLines.get(i5);
                PointF pointF = documentData.boxSize;
                int i7 = i5;
                List<TextSubLine> splitGlyphTextIntoLines = splitGlyphTextIntoLines(str, pointF == null ? 0.0f : pointF.x, font, floatValue2, f6, true);
                int i8 = 0;
                while (i8 < splitGlyphTextIntoLines.size()) {
                    TextSubLine textSubLine = splitGlyphTextIntoLines.get(i8);
                    int i9 = i6 + 1;
                    canvas.save();
                    offsetCanvas(canvas, documentData, i9, textSubLine.width);
                    drawGlyphTextLine(textSubLine.text, documentData, font, canvas, scale, floatValue2, f6);
                    canvas.restore();
                    i8++;
                    splitGlyphTextIntoLines = splitGlyphTextIntoLines;
                    i6 = i9;
                }
                i5 = i7 + 1;
            }
        }
        floatValue = baseKeyframeAnimation2.getValue().floatValue();
        f5 += floatValue;
        float f62 = f5;
        int i62 = -1;
        i5 = 0;
        while (i5 < size) {
        }
    }

    private TextSubLine ensureEnoughSubLines(int i5) {
        for (int size = this.textSubLines.size(); size < i5; size++) {
            this.textSubLines.add(new TextSubLine());
        }
        return this.textSubLines.get(i5 - 1);
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        if (this.contentsForCharacter.containsKey(fontCharacter)) {
            return this.contentsForCharacter.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(new ContentGroup(this.lottieDrawable, this, shapes.get(i5), this.composition));
        }
        this.contentsForCharacter.put(fontCharacter, arrayList);
        return arrayList;
    }

    private List<String> getTextLines(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private Typeface getTypeface(Font font) {
        Typeface value;
        BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation = this.typefaceCallbackAnimation;
        if (baseKeyframeAnimation != null && (value = baseKeyframeAnimation.getValue()) != null) {
            return value;
        }
        Typeface typeface = this.lottieDrawable.getTypeface(font);
        return typeface != null ? typeface : font.getTypeface();
    }

    private boolean isModifier(int i5) {
        return Character.getType(i5) == 16 || Character.getType(i5) == 27 || Character.getType(i5) == 6 || Character.getType(i5) == 28 || Character.getType(i5) == 8 || Character.getType(i5) == 19;
    }

    private void offsetCanvas(Canvas canvas, DocumentData documentData, int i5, float f5) {
        PointF pointF = documentData.boxPosition;
        PointF pointF2 = documentData.boxSize;
        float dpScale = Utils.dpScale();
        float f6 = (i5 * documentData.lineHeight * dpScale) + (pointF == null ? 0.0f : (documentData.lineHeight * dpScale) + pointF.y);
        float f7 = pointF == null ? 0.0f : pointF.x;
        float f8 = pointF2 != null ? pointF2.x : 0.0f;
        int i6 = AnonymousClass3.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[documentData.justification.ordinal()];
        if (i6 == 1) {
            canvas.translate(f7, f6);
        } else if (i6 == 2) {
            canvas.translate((f7 + f8) - f5, f6);
        } else {
            if (i6 != 3) {
                return;
            }
            canvas.translate((f7 + (f8 / 2.0f)) - (f5 / 2.0f), f6);
        }
    }

    private List<TextSubLine> splitGlyphTextIntoLines(String str, float f5, Font font, float f6, float f7, boolean z5) {
        float measureText;
        int i5 = 0;
        int i6 = 0;
        boolean z6 = false;
        int i7 = 0;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i8 = 0; i8 < str.length(); i8++) {
            char charAt = str.charAt(i8);
            if (z5) {
                FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(charAt, font.getFamily(), font.getStyle()));
                if (fontCharacter != null) {
                    measureText = ((float) fontCharacter.getWidth()) * f6 * Utils.dpScale();
                }
            } else {
                measureText = this.fillPaint.measureText(str.substring(i8, i8 + 1));
            }
            float f11 = measureText + f7;
            if (charAt == ' ') {
                z6 = true;
                f10 = f11;
            } else if (z6) {
                z6 = false;
                i7 = i8;
                f9 = f11;
            } else {
                f9 += f11;
            }
            f8 += f11;
            if (f5 > 0.0f && f8 >= f5 && charAt != ' ') {
                i5++;
                TextSubLine ensureEnoughSubLines = ensureEnoughSubLines(i5);
                if (i7 == i6) {
                    ensureEnoughSubLines.set(str.substring(i6, i8).trim(), (f8 - f11) - ((r9.length() - r7.length()) * f10));
                    i6 = i8;
                    i7 = i6;
                    f8 = f11;
                    f9 = f8;
                } else {
                    ensureEnoughSubLines.set(str.substring(i6, i7 - 1).trim(), ((f8 - f9) - ((r7.length() - r13.length()) * f10)) - f10);
                    f8 = f9;
                    i6 = i7;
                }
            }
        }
        if (f8 > 0.0f) {
            i5++;
            ensureEnoughSubLines(i5).set(str.substring(i6), f8);
        }
        return this.textSubLines.subList(0, i5);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t5, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t5, lottieValueCallback);
        if (t5 == LottieProperty.COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.colorCallbackAnimation);
            return;
        }
        if (t5 == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorCallbackAnimation;
            if (baseKeyframeAnimation2 != null) {
                removeAnimation(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.strokeColorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.strokeColorCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            addAnimation(this.strokeColorCallbackAnimation);
            return;
        }
        if (t5 == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthCallbackAnimation;
            if (baseKeyframeAnimation3 != null) {
                removeAnimation(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.strokeWidthCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.strokeWidthCallbackAnimation = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            addAnimation(this.strokeWidthCallbackAnimation);
            return;
        }
        if (t5 == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.trackingCallbackAnimation;
            if (baseKeyframeAnimation4 != null) {
                removeAnimation(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.trackingCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.trackingCallbackAnimation = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            addAnimation(this.trackingCallbackAnimation);
            return;
        }
        if (t5 == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.textSizeCallbackAnimation;
            if (baseKeyframeAnimation5 != null) {
                removeAnimation(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.textSizeCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.textSizeCallbackAnimation = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.addUpdateListener(this);
            addAnimation(this.textSizeCallbackAnimation);
            return;
        }
        if (t5 != LottieProperty.TYPEFACE) {
            if (t5 == LottieProperty.TEXT) {
                this.textAnimation.setStringValueCallback(lottieValueCallback);
                return;
            }
            return;
        }
        BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation6 = this.typefaceCallbackAnimation;
        if (baseKeyframeAnimation6 != null) {
            removeAnimation(baseKeyframeAnimation6);
        }
        if (lottieValueCallback == null) {
            this.typefaceCallbackAnimation = null;
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation6 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        this.typefaceCallbackAnimation = valueCallbackKeyframeAnimation6;
        valueCallbackKeyframeAnimation6.addUpdateListener(this);
        addAnimation(this.typefaceCallbackAnimation);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i5) {
        DocumentData value = this.textAnimation.getValue();
        Font font = this.composition.getFonts().get(value.fontName);
        if (font == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        configurePaint(value, matrix);
        if (this.lottieDrawable.useTextGlyphs()) {
            drawTextWithGlyphs(value, matrix, font, canvas);
        } else {
            drawTextWithFont(value, font, canvas);
        }
        canvas.restore();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z5) {
        super.getBounds(rectF, matrix, z5);
        rectF.set(0.0f, 0.0f, this.composition.getBounds().width(), this.composition.getBounds().height());
    }
}
