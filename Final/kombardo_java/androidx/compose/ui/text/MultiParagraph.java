package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDraw_androidKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJP\u0010!\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 JX\u0010!\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020$2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001d\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020$¢\u0006\u0004\b.\u0010/J\u0018\u00104\u001a\u00020\u00062\u0006\u00101\u001a\u000200ø\u0001\u0000¢\u0006\u0004\b2\u00103J(\u0010>\u001a\u00020;2\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u0002052\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b?\u0010@J*\u0010G\u001a\u00020B2\u0006\u0010A\u001a\u00020;2\u0006\u0010C\u001a\u00020B2\b\b\u0001\u0010D\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u001d\u0010I\u001a\u00020$2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\b¢\u0006\u0004\bI\u0010JJ\u0015\u0010L\u001a\u00020K2\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\bL\u0010MJ\u0015\u0010N\u001a\u00020K2\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\bN\u0010MJ\u001b\u0010Q\u001a\u00020;2\u0006\u0010\f\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u0015\u0010R\u001a\u0002052\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\bR\u0010@J\u0015\u0010S\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\bS\u0010TJ\u0015\u0010U\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\bU\u0010VJ\u0015\u0010W\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\bW\u0010VJ\u0015\u0010X\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\bX\u0010VJ\u0015\u0010Y\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\bY\u0010VJ\u0015\u0010Z\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\bZ\u0010TJ\u001f\u0010\\\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010[\u001a\u00020\b¢\u0006\u0004\b\\\u0010]R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010^\u001a\u0004\b_\u0010`R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010a\u001a\u0004\bb\u0010cR\u0017\u0010d\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0017\u0010h\u001a\u00020$8\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0017\u0010l\u001a\u00020$8\u0006¢\u0006\f\n\u0004\bl\u0010i\u001a\u0004\bm\u0010kR\u0017\u0010n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\bn\u0010a\u001a\u0004\bo\u0010cR\u001f\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050p8\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR \u0010v\u001a\b\u0012\u0004\u0012\u00020u0p8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bv\u0010r\u001a\u0004\bw\u0010tR\u0014\u0010{\u001a\u00020x8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR\u0011\u0010}\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b|\u0010kR\u0011\u0010\u007f\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b~\u0010k\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0080\u0001"}, d2 = {"Landroidx/compose/ui/text/MultiParagraph;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "intrinsics", "Landroidx/compose/ui/unit/Constraints;", "constraints", BuildConfig.FLAVOR, "maxLines", BuildConfig.FLAVOR, "ellipsis", "<init>", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "offset", BuildConfig.FLAVOR, "requireIndexInRange", "(I)V", "requireIndexInRangeInclusiveEnd", "lineIndex", "requireLineIndexInRange", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "Landroidx/compose/ui/text/style/TextDecoration;", "decoration", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "paint-LG529CI", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "paint", "Landroidx/compose/ui/graphics/Brush;", "brush", BuildConfig.FLAVOR, "alpha", "paint-hn5TExg", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "start", "end", "Landroidx/compose/ui/graphics/Path;", "getPathForRange", "(II)Landroidx/compose/ui/graphics/Path;", "vertical", "getLineForVerticalPosition", "(F)I", "Landroidx/compose/ui/geometry/Offset;", "position", "getOffsetForPosition-k-4lQ0M", "(J)I", "getOffsetForPosition", "Landroidx/compose/ui/geometry/Rect;", "rect", "Landroidx/compose/ui/text/TextGranularity;", "granularity", "Landroidx/compose/ui/text/TextInclusionStrategy;", "inclusionStrategy", "Landroidx/compose/ui/text/TextRange;", "getRangeForRect-8-6BmAI", "(Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForRect", "getBoundingBox", "(I)Landroidx/compose/ui/geometry/Rect;", "range", BuildConfig.FLAVOR, "array", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)[F", "fillBoundingBoxes", "usePrimaryDirection", "getHorizontalPosition", "(IZ)F", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getParagraphDirection", "(I)Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getBidiRunDirection", "getWordBoundary--jx7JFs", "(I)J", "getWordBoundary", "getCursorRect", "getLineForOffset", "(I)I", "getLineLeft", "(I)F", "getLineRight", "getLineTop", "getLineBottom", "getLineStart", "visibleEnd", "getLineEnd", "(IZ)I", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "I", "getMaxLines", "()I", "didExceedMaxLines", "Z", "getDidExceedMaxLines", "()Z", "width", "F", "getWidth", "()F", "height", "getHeight", "lineCount", "getLineCount", BuildConfig.FLAVOR, "placeholderRects", "Ljava/util/List;", "getPlaceholderRects", "()Ljava/util/List;", "Landroidx/compose/ui/text/ParagraphInfo;", "paragraphInfoList", "getParagraphInfoList$ui_text_release", "Landroidx/compose/ui/text/AnnotatedString;", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "annotatedString", "getFirstBaseline", "firstBaseline", "getLastBaseline", "lastBaseline", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiParagraph {
    private final boolean didExceedMaxLines;
    private final float height;
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    private final List<ParagraphInfo> paragraphInfoList;
    private final List<Rect> placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j5, int i5, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j5, i5, z5);
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    private final void requireIndexInRange(int offset) {
        if (offset < 0 || offset >= getAnnotatedString().getText().length()) {
            throw new IllegalArgumentException(("offset(" + offset + ") is out of bounds [0, " + getAnnotatedString().length() + ')').toString());
        }
    }

    private final void requireIndexInRangeInclusiveEnd(int offset) {
        if (offset < 0 || offset > getAnnotatedString().getText().length()) {
            throw new IllegalArgumentException(("offset(" + offset + ") is out of bounds [0, " + getAnnotatedString().length() + ']').toString());
        }
    }

    private final void requireLineIndexInRange(int lineIndex) {
        if (lineIndex < 0 || lineIndex >= this.lineCount) {
            throw new IllegalArgumentException(("lineIndex(" + lineIndex + ") is out of bounds [0, " + this.lineCount + ')').toString());
        }
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final float[] m2217fillBoundingBoxes8ffj60Q(final long range, final float[] array, int arrayStart) {
        requireIndexInRange(TextRange.m2283getMinimpl(range));
        requireIndexInRangeInclusiveEnd(TextRange.m2282getMaximpl(range));
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = arrayStart;
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        MultiParagraphKt.m2223findParagraphsByRangeSbBc2M(this.paragraphInfoList, range, new Function1<ParagraphInfo, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$fillBoundingBoxes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ParagraphInfo paragraphInfo) {
                invoke2(paragraphInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ParagraphInfo paragraphInfo) {
                long j5 = range;
                float[] fArr = array;
                Ref$IntRef ref$IntRef2 = ref$IntRef;
                Ref$FloatRef ref$FloatRef2 = ref$FloatRef;
                long TextRange = TextRangeKt.TextRange(paragraphInfo.toLocalIndex(paragraphInfo.getStartIndex() > TextRange.m2283getMinimpl(j5) ? paragraphInfo.getStartIndex() : TextRange.m2283getMinimpl(j5)), paragraphInfo.toLocalIndex(paragraphInfo.getEndIndex() < TextRange.m2282getMaximpl(j5) ? paragraphInfo.getEndIndex() : TextRange.m2282getMaximpl(j5)));
                paragraphInfo.getParagraph().mo2186fillBoundingBoxes8ffj60Q(TextRange, fArr, ref$IntRef2.element);
                int m2281getLengthimpl = ref$IntRef2.element + (TextRange.m2281getLengthimpl(TextRange) * 4);
                for (int i5 = ref$IntRef2.element; i5 < m2281getLengthimpl; i5 += 4) {
                    int i6 = i5 + 1;
                    float f5 = fArr[i6];
                    float f6 = ref$FloatRef2.element;
                    fArr[i6] = f5 + f6;
                    int i7 = i5 + 3;
                    fArr[i7] = fArr[i7] + f6;
                }
                ref$IntRef2.element = m2281getLengthimpl;
                ref$FloatRef2.element += paragraphInfo.getParagraph().getHeight();
            }
        });
        return array;
    }

    public final ResolvedTextDirection getBidiRunDirection(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getBidiRunDirection(paragraphInfo.toLocalIndex(offset));
    }

    public final Rect getBoundingBox(int offset) {
        requireIndexInRange(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getBoundingBox(paragraphInfo.toLocalIndex(offset)));
    }

    public final Rect getCursorRect(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getCursorRect(paragraphInfo.toLocalIndex(offset)));
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getFirstBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getHorizontalPosition(paragraphInfo.toLocalIndex(offset), usePrimaryDirection);
    }

    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final float getLastBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt.last((List) this.paragraphInfoList);
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLastBaseline());
    }

    public final float getLineBottom(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBottom(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getLineEnd(int lineIndex, boolean visibleEnd) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineEnd(paragraphInfo.toLocalLineIndex(lineIndex), visibleEnd));
    }

    public final int getLineForOffset(int offset) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset >= getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : offset < 0 ? 0 : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForOffset(paragraphInfo.toLocalIndex(offset)));
    }

    public final int getLineForVerticalPosition(float vertical) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, vertical));
        return paragraphInfo.getLength() == 0 ? paragraphInfo.getStartLineIndex() : paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForVerticalPosition(paragraphInfo.toLocalYPosition(vertical)));
    }

    public final float getLineLeft(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineLeft(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final float getLineRight(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.getParagraph().getLineRight(paragraphInfo.toLocalLineIndex(lineIndex));
    }

    public final int getLineStart(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineStart(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    public final float getLineTop(int lineIndex) {
        requireLineIndexInRange(lineIndex);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, lineIndex));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineTop(paragraphInfo.toLocalLineIndex(lineIndex)));
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m2218getOffsetForPositionk4lQ0M(long position) {
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Offset.m1338getYimpl(position)));
        return paragraphInfo.getLength() == 0 ? paragraphInfo.getStartIndex() : paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().mo2187getOffsetForPositionk4lQ0M(paragraphInfo.m2228toLocalMKHz9U(position)));
    }

    public final ResolvedTextDirection getParagraphDirection(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.getParagraph().getParagraphDirection(paragraphInfo.toLocalIndex(offset));
    }

    public final List<ParagraphInfo> getParagraphInfoList$ui_text_release() {
        return this.paragraphInfoList;
    }

    public final Path getPathForRange(final int start, final int end) {
        if (start >= 0 && start <= end && end <= getAnnotatedString().getText().length()) {
            if (start == end) {
                return AndroidPath_androidKt.Path();
            }
            final Path Path = AndroidPath_androidKt.Path();
            MultiParagraphKt.m2223findParagraphsByRangeSbBc2M(this.paragraphInfoList, TextRangeKt.TextRange(start, end), new Function1<ParagraphInfo, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$getPathForRange$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ParagraphInfo paragraphInfo) {
                    invoke2(paragraphInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ParagraphInfo paragraphInfo) {
                    Path.m1574addPathUv8p0NA$default(Path.this, paragraphInfo.toGlobal(paragraphInfo.getParagraph().getPathForRange(paragraphInfo.toLocalIndex(start), paragraphInfo.toLocalIndex(end))), 0L, 2, null);
                }
            });
            return Path;
        }
        throw new IllegalArgumentException(("Start(" + start + ") or End(" + end + ") is out of range [0.." + getAnnotatedString().getText().length() + "), or start > end!").toString());
    }

    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    /* renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m2219getRangeForRect86BmAI(Rect rect, int granularity, TextInclusionStrategy inclusionStrategy) {
        TextRange.Companion companion;
        TextRange.Companion companion2;
        int findParagraphByY = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getTop());
        if (this.paragraphInfoList.get(findParagraphByY).getBottom() >= rect.getBottom() || findParagraphByY == CollectionsKt.getLastIndex(this.paragraphInfoList)) {
            ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByY);
            return ParagraphInfo.m2226toGlobalxdX6G0$default(paragraphInfo, paragraphInfo.getParagraph().mo2188getRangeForRect86BmAI(paragraphInfo.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
        }
        int findParagraphByY2 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, rect.getBottom());
        long m2290getZerod9O1mEE = TextRange.INSTANCE.m2290getZerod9O1mEE();
        while (true) {
            companion = TextRange.INSTANCE;
            if (!TextRange.m2278equalsimpl0(m2290getZerod9O1mEE, companion.m2290getZerod9O1mEE()) || findParagraphByY > findParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo2 = this.paragraphInfoList.get(findParagraphByY);
            m2290getZerod9O1mEE = ParagraphInfo.m2226toGlobalxdX6G0$default(paragraphInfo2, paragraphInfo2.getParagraph().mo2188getRangeForRect86BmAI(paragraphInfo2.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
            findParagraphByY++;
        }
        if (TextRange.m2278equalsimpl0(m2290getZerod9O1mEE, companion.m2290getZerod9O1mEE())) {
            return companion.m2290getZerod9O1mEE();
        }
        long m2290getZerod9O1mEE2 = companion.m2290getZerod9O1mEE();
        while (true) {
            companion2 = TextRange.INSTANCE;
            if (!TextRange.m2278equalsimpl0(m2290getZerod9O1mEE2, companion2.m2290getZerod9O1mEE()) || findParagraphByY > findParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo3 = this.paragraphInfoList.get(findParagraphByY2);
            m2290getZerod9O1mEE2 = ParagraphInfo.m2226toGlobalxdX6G0$default(paragraphInfo3, paragraphInfo3.getParagraph().mo2188getRangeForRect86BmAI(paragraphInfo3.toLocal(rect), granularity, inclusionStrategy), false, 1, null);
            findParagraphByY2--;
        }
        return TextRange.m2278equalsimpl0(m2290getZerod9O1mEE2, companion2.m2290getZerod9O1mEE()) ? m2290getZerod9O1mEE : TextRangeKt.TextRange(TextRange.m2285getStartimpl(m2290getZerod9O1mEE), TextRange.m2280getEndimpl(m2290getZerod9O1mEE2));
    }

    public final float getWidth() {
        return this.width;
    }

    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    public final long m2220getWordBoundaryjx7JFs(int offset) {
        requireIndexInRangeInclusiveEnd(offset);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(offset == getAnnotatedString().length() ? CollectionsKt.getLastIndex(this.paragraphInfoList) : MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, offset));
        return paragraphInfo.m2227toGlobalxdX6G0(paragraphInfo.getParagraph().mo2189getWordBoundaryjx7JFs(paragraphInfo.toLocalIndex(offset)), false);
    }

    /* renamed from: paint-LG529CI, reason: not valid java name */
    public final void m2221paintLG529CI(Canvas canvas, long color, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            ParagraphInfo paragraphInfo = list.get(i5);
            paragraphInfo.getParagraph().mo2190paintLG529CI(canvas, color, shadow, decoration, drawStyle, blendMode);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* renamed from: paint-hn5TExg, reason: not valid java name */
    public final void m2222painthn5TExg(Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        AndroidMultiParagraphDraw_androidKt.m2432drawMultiParagraph7AXcY_I(this, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j5, int i5, boolean z5) {
        boolean z6;
        int m2577getMaxHeightimpl;
        this.intrinsics = multiParagraphIntrinsics;
        this.maxLines = i5;
        if (Constraints.m2580getMinWidthimpl(j5) == 0 && Constraints.m2579getMinHeightimpl(j5) == 0) {
            ArrayList arrayList = new ArrayList();
            List<ParagraphIntrinsicInfo> infoList$ui_text_release = multiParagraphIntrinsics.getInfoList$ui_text_release();
            int size = infoList$ui_text_release.size();
            int i6 = 0;
            int i7 = 0;
            float f5 = 0.0f;
            int i8 = 0;
            while (i8 < size) {
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = infoList$ui_text_release.get(i8);
                ParagraphIntrinsics intrinsics = paragraphIntrinsicInfo.getIntrinsics();
                int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5);
                if (Constraints.m2573getHasBoundedHeightimpl(j5)) {
                    m2577getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m2577getMaxHeightimpl(j5) - ParagraphKt.ceilToInt(f5), i6);
                } else {
                    m2577getMaxHeightimpl = Constraints.m2577getMaxHeightimpl(j5);
                }
                Paragraph m2231Paragraph_EkL_Y = ParagraphKt.m2231Paragraph_EkL_Y(intrinsics, ConstraintsKt.Constraints$default(0, m2578getMaxWidthimpl, 0, m2577getMaxHeightimpl, 5, null), this.maxLines - i7, z5);
                float height = f5 + m2231Paragraph_EkL_Y.getHeight();
                int lineCount = i7 + m2231Paragraph_EkL_Y.getLineCount();
                List<ParagraphIntrinsicInfo> list = infoList$ui_text_release;
                arrayList.add(new ParagraphInfo(m2231Paragraph_EkL_Y, paragraphIntrinsicInfo.getStartIndex(), paragraphIntrinsicInfo.getEndIndex(), i7, lineCount, f5, height));
                if (m2231Paragraph_EkL_Y.getDidExceedMaxLines() || (lineCount == this.maxLines && i8 != CollectionsKt.getLastIndex(this.intrinsics.getInfoList$ui_text_release()))) {
                    z6 = true;
                    i7 = lineCount;
                    f5 = height;
                    break;
                } else {
                    i8++;
                    i7 = lineCount;
                    f5 = height;
                    i6 = 0;
                    infoList$ui_text_release = list;
                }
            }
            z6 = false;
            this.height = f5;
            this.lineCount = i7;
            this.didExceedMaxLines = z6;
            this.paragraphInfoList = arrayList;
            this.width = Constraints.m2578getMaxWidthimpl(j5);
            List<Rect> arrayList2 = new ArrayList<>(arrayList.size());
            int size2 = arrayList.size();
            for (int i9 = 0; i9 < size2; i9++) {
                ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i9);
                List<Rect> placeholderRects = paragraphInfo.getParagraph().getPlaceholderRects();
                ArrayList arrayList3 = new ArrayList(placeholderRects.size());
                int size3 = placeholderRects.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    Rect rect = placeholderRects.get(i10);
                    arrayList3.add(rect != null ? paragraphInfo.toGlobal(rect) : null);
                }
                CollectionsKt.addAll(arrayList2, arrayList3);
            }
            if (arrayList2.size() < this.intrinsics.getPlaceholders().size()) {
                int size4 = this.intrinsics.getPlaceholders().size() - arrayList2.size();
                ArrayList arrayList4 = new ArrayList(size4);
                for (int i11 = 0; i11 < size4; i11++) {
                    arrayList4.add(null);
                }
                arrayList2 = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList4);
            }
            this.placeholderRects = arrayList2;
            return;
        }
        throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
    }
}
