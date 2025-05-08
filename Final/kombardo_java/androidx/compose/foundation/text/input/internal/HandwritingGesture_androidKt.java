package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditingBuffer;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0007\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a&\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010\u001b\u001a\u00020\u0001*\u00020 2\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010!\u001a2\u0010\u001b\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a<\u0010&\u001a\u00020\t*\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a.\u0010,\u001a\u00020\t*\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a.\u0010,\u001a\u00020\t*\u00020 2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00105\u001a:\u0010,\u001a\u00020\t*\u0004\u0018\u00010\u00142\u0006\u0010-\u001a\u00020.2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a6\u00108\u001a\u00020\t*\u00020\u001c2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a6\u00108\u001a\u00020\t*\u00020 2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020'2\u0006\u0010@\u001a\u00020\u0001H\u0002\u001a\f\u0010A\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010B\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010C\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010D\u001a\u00020?*\u00020\u0001H\u0002\u001a\u0019\u0010E\u001a\u00020\t*\u00020\u00102\u0006\u0010@\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010F\u001a\u0011\u0010G\u001a\u00020\u0016*\u00020HH\u0002¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"LINE_FEED_CODE_POINT", BuildConfig.FLAVOR, "NBSP_CODE_POINT", "compoundEditCommand", "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", BuildConfig.FLAVOR, "([Landroidx/compose/ui/text/input/EditCommand;)Landroidx/compose/ui/text/input/EditCommand;", "enclosure", "Landroidx/compose/ui/text/TextRange;", "a", "b", "enclosure-pWDy79M", "(JJ)J", "adjustHandwritingDeleteGestureRange", "text", BuildConfig.FLAVOR, "adjustHandwritingDeleteGestureRange-72CqOWE", "(JLjava/lang/CharSequence;)J", "getLineForHandwritingGesture", "Landroidx/compose/ui/text/MultiParagraph;", "localPoint", "Landroidx/compose/ui/geometry/Offset;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getLineForHandwritingGesture-d-4ec7I", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "getOffsetForHandwritingGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "pointInScreen", "getOffsetForHandwritingGesture-d-4ec7I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getOffsetForHandwritingGesture-ubNVwUQ", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)I", "getRangeForRemoveSpaceGesture", "Landroidx/compose/ui/text/TextLayoutResult;", "startPointInScreen", "endPointerInScreen", "getRangeForRemoveSpaceGesture-5iVPX68", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)J", "getRangeForScreenRect", "rectInScreen", "Landroidx/compose/ui/geometry/Rect;", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForScreenRect-OH9lIzo", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRect-O048IG0", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/layout/LayoutCoordinates;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRects", "startRectInScreen", "endRectInScreen", "getRangeForScreenRects-O048IG0", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "isBiDiBoundary", BuildConfig.FLAVOR, "offset", "isNewline", "isPunctuation", "isWhitespace", "isWhitespaceExceptNewline", "rangeOfWhitespaces", "(Ljava/lang/CharSequence;I)J", "toOffset", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class HandwritingGesture_androidKt {
    private static final int LINE_FEED_CODE_POINT = 10;
    private static final int NBSP_CODE_POINT = 160;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: adjustHandwritingDeleteGestureRange-72CqOWE, reason: not valid java name */
    public static final long m580adjustHandwritingDeleteGestureRange72CqOWE(long j5, CharSequence charSequence) {
        int m2285getStartimpl = TextRange.m2285getStartimpl(j5);
        int m2280getEndimpl = TextRange.m2280getEndimpl(j5);
        int codePointBefore = m2285getStartimpl > 0 ? Character.codePointBefore(charSequence, m2285getStartimpl) : 10;
        int codePointAt = m2280getEndimpl < charSequence.length() ? Character.codePointAt(charSequence, m2280getEndimpl) : 10;
        if (isWhitespaceExceptNewline(codePointBefore) && (isWhitespace(codePointAt) || isPunctuation(codePointAt))) {
            do {
                m2285getStartimpl -= Character.charCount(codePointBefore);
                if (m2285getStartimpl == 0) {
                    break;
                }
                codePointBefore = Character.codePointBefore(charSequence, m2285getStartimpl);
            } while (isWhitespaceExceptNewline(codePointBefore));
            return TextRangeKt.TextRange(m2285getStartimpl, m2280getEndimpl);
        }
        if (!isWhitespaceExceptNewline(codePointAt)) {
            return j5;
        }
        if (!isWhitespace(codePointBefore) && !isPunctuation(codePointBefore)) {
            return j5;
        }
        do {
            m2280getEndimpl += Character.charCount(codePointAt);
            if (m2280getEndimpl == charSequence.length()) {
                break;
            }
            codePointAt = Character.codePointAt(charSequence, m2280getEndimpl);
        } while (isWhitespaceExceptNewline(codePointAt));
        return TextRangeKt.TextRange(m2285getStartimpl, m2280getEndimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EditCommand compoundEditCommand(final EditCommand... editCommandArr) {
        return new EditCommand() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt$compoundEditCommand$1
            @Override // androidx.compose.ui.text.input.EditCommand
            public void applyTo(EditingBuffer buffer) {
                for (EditCommand editCommand : editCommandArr) {
                    editCommand.applyTo(buffer);
                }
            }
        };
    }

    /* renamed from: enclosure-pWDy79M, reason: not valid java name */
    private static final long m581enclosurepWDy79M(long j5, long j6) {
        return TextRangeKt.TextRange(Math.min(TextRange.m2285getStartimpl(j5), TextRange.m2285getStartimpl(j5)), Math.max(TextRange.m2280getEndimpl(j6), TextRange.m2280getEndimpl(j6)));
    }

    /* renamed from: getLineForHandwritingGesture-d-4ec7I, reason: not valid java name */
    private static final int m582getLineForHandwritingGestured4ec7I(MultiParagraph multiParagraph, long j5, ViewConfiguration viewConfiguration) {
        float handwritingGestureLineMargin = viewConfiguration != null ? viewConfiguration.getHandwritingGestureLineMargin() : 0.0f;
        int lineForVerticalPosition = multiParagraph.getLineForVerticalPosition(Offset.m1338getYimpl(j5));
        if (Offset.m1338getYimpl(j5) < multiParagraph.getLineTop(lineForVerticalPosition) - handwritingGestureLineMargin || Offset.m1338getYimpl(j5) > multiParagraph.getLineBottom(lineForVerticalPosition) + handwritingGestureLineMargin || Offset.m1337getXimpl(j5) < (-handwritingGestureLineMargin) || Offset.m1337getXimpl(j5) > multiParagraph.getWidth() + handwritingGestureLineMargin) {
            return -1;
        }
        return lineForVerticalPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m584getOffsetForHandwritingGestured4ec7I(TextLayoutState textLayoutState, long j5, ViewConfiguration viewConfiguration) {
        throw null;
    }

    /* renamed from: getOffsetForHandwritingGesture-ubNVwUQ, reason: not valid java name */
    private static final int m585getOffsetForHandwritingGestureubNVwUQ(MultiParagraph multiParagraph, long j5, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        long mo1953screenToLocalMKHz9U;
        int m582getLineForHandwritingGestured4ec7I;
        if (layoutCoordinates == null || (m582getLineForHandwritingGestured4ec7I = m582getLineForHandwritingGestured4ec7I(multiParagraph, (mo1953screenToLocalMKHz9U = layoutCoordinates.mo1953screenToLocalMKHz9U(j5)), viewConfiguration)) == -1) {
            return -1;
        }
        return multiParagraph.m2218getOffsetForPositionk4lQ0M(Offset.m1331copydBAh8RU$default(mo1953screenToLocalMKHz9U, 0.0f, (multiParagraph.getLineTop(m582getLineForHandwritingGestured4ec7I) + multiParagraph.getLineBottom(m582getLineForHandwritingGestured4ec7I)) / 2.0f, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForRemoveSpaceGesture-5iVPX68, reason: not valid java name */
    public static final long m586getRangeForRemoveSpaceGesture5iVPX68(TextLayoutResult textLayoutResult, long j5, long j6, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        if (textLayoutResult == null || layoutCoordinates == null) {
            return TextRange.INSTANCE.m2290getZerod9O1mEE();
        }
        long mo1953screenToLocalMKHz9U = layoutCoordinates.mo1953screenToLocalMKHz9U(j5);
        long mo1953screenToLocalMKHz9U2 = layoutCoordinates.mo1953screenToLocalMKHz9U(j6);
        int m582getLineForHandwritingGestured4ec7I = m582getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), mo1953screenToLocalMKHz9U, viewConfiguration);
        int m582getLineForHandwritingGestured4ec7I2 = m582getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), mo1953screenToLocalMKHz9U2, viewConfiguration);
        if (m582getLineForHandwritingGestured4ec7I != -1) {
            if (m582getLineForHandwritingGestured4ec7I2 != -1) {
                m582getLineForHandwritingGestured4ec7I = Math.min(m582getLineForHandwritingGestured4ec7I, m582getLineForHandwritingGestured4ec7I2);
            }
            m582getLineForHandwritingGestured4ec7I2 = m582getLineForHandwritingGestured4ec7I;
        } else if (m582getLineForHandwritingGestured4ec7I2 == -1) {
            return TextRange.INSTANCE.m2290getZerod9O1mEE();
        }
        float lineTop = (textLayoutResult.getLineTop(m582getLineForHandwritingGestured4ec7I2) + textLayoutResult.getLineBottom(m582getLineForHandwritingGestured4ec7I2)) / 2;
        return textLayoutResult.getMultiParagraph().m2219getRangeForRect86BmAI(new Rect(Math.min(Offset.m1337getXimpl(mo1953screenToLocalMKHz9U), Offset.m1337getXimpl(mo1953screenToLocalMKHz9U2)), lineTop - 0.1f, Math.max(Offset.m1337getXimpl(mo1953screenToLocalMKHz9U), Offset.m1337getXimpl(mo1953screenToLocalMKHz9U2)), lineTop + 0.1f), TextGranularity.INSTANCE.m2264getCharacterDRrd7Zo(), TextInclusionStrategy.INSTANCE.getAnyOverlap());
    }

    /* renamed from: getRangeForScreenRect-O048IG0, reason: not valid java name */
    private static final long m587getRangeForScreenRectO048IG0(MultiParagraph multiParagraph, Rect rect, LayoutCoordinates layoutCoordinates, int i5, TextInclusionStrategy textInclusionStrategy) {
        return (multiParagraph == null || layoutCoordinates == null) ? TextRange.INSTANCE.m2290getZerod9O1mEE() : multiParagraph.m2219getRangeForRect86BmAI(rect.m1359translatek4lQ0M(layoutCoordinates.mo1953screenToLocalMKHz9U(Offset.INSTANCE.m1349getZeroF1C5BW0())), i5, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m589getRangeForScreenRectOH9lIzo(TextLayoutState textLayoutState, Rect rect, int i5, TextInclusionStrategy textInclusionStrategy) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m591getRangeForScreenRectsO048IG0(TextLayoutState textLayoutState, Rect rect, Rect rect2, int i5, TextInclusionStrategy textInclusionStrategy) {
        long m589getRangeForScreenRectOH9lIzo = m589getRangeForScreenRectOH9lIzo(textLayoutState, rect, i5, textInclusionStrategy);
        if (TextRange.m2279getCollapsedimpl(m589getRangeForScreenRectOH9lIzo)) {
            return TextRange.INSTANCE.m2290getZerod9O1mEE();
        }
        long m589getRangeForScreenRectOH9lIzo2 = m589getRangeForScreenRectOH9lIzo(textLayoutState, rect2, i5, textInclusionStrategy);
        return TextRange.m2279getCollapsedimpl(m589getRangeForScreenRectOH9lIzo2) ? TextRange.INSTANCE.m2290getZerod9O1mEE() : m581enclosurepWDy79M(m589getRangeForScreenRectOH9lIzo, m589getRangeForScreenRectOH9lIzo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBiDiBoundary(TextLayoutResult textLayoutResult, int i5) {
        int lineForOffset = textLayoutResult.getLineForOffset(i5);
        return (i5 == textLayoutResult.getLineStart(lineForOffset) || i5 == TextLayoutResult.getLineEnd$default(textLayoutResult, lineForOffset, false, 2, null)) ? textLayoutResult.getParagraphDirection(i5) != textLayoutResult.getBidiRunDirection(i5) : textLayoutResult.getBidiRunDirection(i5) != textLayoutResult.getBidiRunDirection(i5 - 1);
    }

    private static final boolean isNewline(int i5) {
        int type = Character.getType(i5);
        return type == 14 || type == 13 || i5 == 10;
    }

    private static final boolean isPunctuation(int i5) {
        int type = Character.getType(i5);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    private static final boolean isWhitespace(int i5) {
        return Character.isWhitespace(i5) || i5 == NBSP_CODE_POINT;
    }

    private static final boolean isWhitespaceExceptNewline(int i5) {
        return isWhitespace(i5) && !isNewline(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long rangeOfWhitespaces(CharSequence charSequence, int i5) {
        int i6 = i5;
        while (i6 > 0) {
            int codePointBefore = CodepointHelpers_jvmKt.codePointBefore(charSequence, i6);
            if (!isWhitespace(codePointBefore)) {
                break;
            }
            i6 -= Character.charCount(codePointBefore);
        }
        while (i5 < charSequence.length()) {
            int codePointAt = CodepointHelpers_jvmKt.codePointAt(charSequence, i5);
            if (!isWhitespace(codePointAt)) {
                break;
            }
            i5 += CodepointHelpers_jvmKt.charCount(codePointAt);
        }
        return TextRangeKt.TextRange(i6, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toOffset(PointF pointF) {
        return OffsetKt.Offset(pointF.x, pointF.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m583getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState legacyTextFieldState, long j5, ViewConfiguration viewConfiguration) {
        TextLayoutResult value;
        MultiParagraph multiParagraph;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult == null || (value = layoutResult.getValue()) == null || (multiParagraph = value.getMultiParagraph()) == null) {
            return -1;
        }
        return m585getOffsetForHandwritingGestureubNVwUQ(multiParagraph, j5, legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m588getRangeForScreenRectOH9lIzo(LegacyTextFieldState legacyTextFieldState, Rect rect, int i5, TextInclusionStrategy textInclusionStrategy) {
        TextLayoutResult value;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        return m587getRangeForScreenRectO048IG0((layoutResult == null || (value = layoutResult.getValue()) == null) ? null : value.getMultiParagraph(), rect, legacyTextFieldState.getLayoutCoordinates(), i5, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m590getRangeForScreenRectsO048IG0(LegacyTextFieldState legacyTextFieldState, Rect rect, Rect rect2, int i5, TextInclusionStrategy textInclusionStrategy) {
        long m588getRangeForScreenRectOH9lIzo = m588getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect, i5, textInclusionStrategy);
        if (TextRange.m2279getCollapsedimpl(m588getRangeForScreenRectOH9lIzo)) {
            return TextRange.INSTANCE.m2290getZerod9O1mEE();
        }
        long m588getRangeForScreenRectOH9lIzo2 = m588getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect2, i5, textInclusionStrategy);
        return TextRange.m2279getCollapsedimpl(m588getRangeForScreenRectOH9lIzo2) ? TextRange.INSTANCE.m2290getZerod9O1mEE() : m581enclosurepWDy79M(m588getRangeForScreenRectOH9lIzo, m588getRangeForScreenRectOH9lIzo2);
    }
}
