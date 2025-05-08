package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"androidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "<init>", "()V", BuildConfig.FLAVOR, "lineNumber", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "direction", "getLineEdgeIndex", "(ILandroidx/compose/ui/text/style/ResolvedTextDirection;)I", BuildConfig.FLAVOR, "text", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", "Landroidx/compose/ui/semantics/SemanticsNode;", "node", BuildConfig.FLAVOR, "initialize", "(Ljava/lang/String;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/semantics/SemanticsNode;)V", "current", BuildConfig.FLAVOR, "following", "(I)[I", "preceding", "Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Landroid/graphics/Rect;", "tempRect", "Landroid/graphics/Rect;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AccessibilityIterators$PageTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    private static AccessibilityIterators$PageTextSegmentIterator pageInstance;
    private TextLayoutResult layoutResult;
    private SemanticsNode node;
    private Rect tempRect;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
    private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator$Companion;", BuildConfig.FLAVOR, "()V", "DirectionEnd", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionStart", "pageInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityIterators$PageTextSegmentIterator getInstance() {
            if (AccessibilityIterators$PageTextSegmentIterator.pageInstance == null) {
                AccessibilityIterators$PageTextSegmentIterator.pageInstance = new AccessibilityIterators$PageTextSegmentIterator(null);
            }
            AccessibilityIterators$PageTextSegmentIterator accessibilityIterators$PageTextSegmentIterator = AccessibilityIterators$PageTextSegmentIterator.pageInstance;
            Intrinsics.checkNotNull(accessibilityIterators$PageTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
            return accessibilityIterators$PageTextSegmentIterator;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AccessibilityIterators$PageTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int getLineEdgeIndex(int lineNumber, ResolvedTextDirection direction) {
        TextLayoutResult textLayoutResult = this.layoutResult;
        TextLayoutResult textLayoutResult2 = null;
        if (textLayoutResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult = null;
        }
        int lineStart = textLayoutResult.getLineStart(lineNumber);
        TextLayoutResult textLayoutResult3 = this.layoutResult;
        if (textLayoutResult3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult3 = null;
        }
        if (direction != textLayoutResult3.getParagraphDirection(lineStart)) {
            TextLayoutResult textLayoutResult4 = this.layoutResult;
            if (textLayoutResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            } else {
                textLayoutResult2 = textLayoutResult4;
            }
            return textLayoutResult2.getLineStart(lineNumber);
        }
        TextLayoutResult textLayoutResult5 = this.layoutResult;
        if (textLayoutResult5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            textLayoutResult5 = null;
        }
        return TextLayoutResult.getLineEnd$default(textLayoutResult5, lineNumber, false, 2, null) - 1;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] following(int current) {
        int lineCount;
        TextLayoutResult textLayoutResult = null;
        if (getText().length() <= 0 || current >= getText().length()) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.node;
            if (semanticsNode == null) {
                Intrinsics.throwUninitializedPropertyAccessException("node");
                semanticsNode = null;
            }
            int round = Math.round(semanticsNode.getBoundsInRoot().getHeight());
            int coerceAtLeast = RangesKt.coerceAtLeast(0, current);
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult2 = null;
            }
            int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtLeast);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            float lineTop = textLayoutResult3.getLineTop(lineForOffset) + round;
            TextLayoutResult textLayoutResult4 = this.layoutResult;
            if (textLayoutResult4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult4 = null;
            }
            TextLayoutResult textLayoutResult5 = this.layoutResult;
            if (textLayoutResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult5 = null;
            }
            if (lineTop < textLayoutResult4.getLineTop(textLayoutResult5.getLineCount() - 1)) {
                TextLayoutResult textLayoutResult6 = this.layoutResult;
                if (textLayoutResult6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult = textLayoutResult6;
                }
                lineCount = textLayoutResult.getLineForVerticalPosition(lineTop);
            } else {
                TextLayoutResult textLayoutResult7 = this.layoutResult;
                if (textLayoutResult7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult = textLayoutResult7;
                }
                lineCount = textLayoutResult.getLineCount();
            }
            return getRange(coerceAtLeast, getLineEdgeIndex(lineCount - 1, DirectionEnd) + 1);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public final void initialize(String text, TextLayoutResult layoutResult, SemanticsNode node) {
        setText(text);
        this.layoutResult = layoutResult;
        this.node = node;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] preceding(int current) {
        int i5;
        TextLayoutResult textLayoutResult = null;
        if (getText().length() <= 0 || current <= 0) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.node;
            if (semanticsNode == null) {
                Intrinsics.throwUninitializedPropertyAccessException("node");
                semanticsNode = null;
            }
            int round = Math.round(semanticsNode.getBoundsInRoot().getHeight());
            int coerceAtMost = RangesKt.coerceAtMost(getText().length(), current);
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult2 = null;
            }
            int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtMost);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            float lineTop = textLayoutResult3.getLineTop(lineForOffset) - round;
            if (lineTop > 0.0f) {
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult = textLayoutResult4;
                }
                i5 = textLayoutResult.getLineForVerticalPosition(lineTop);
            } else {
                i5 = 0;
            }
            if (coerceAtMost == getText().length() && i5 < lineForOffset) {
                i5++;
            }
            return getRange(getLineEdgeIndex(i5, DirectionStart), coerceAtMost);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    private AccessibilityIterators$PageTextSegmentIterator() {
        this.tempRect = new Rect();
    }
}
