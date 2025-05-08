package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.HandwritingGestureApi34;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import h.AbstractC0414A;
import h.AbstractC0432s;
import h.AbstractC0433t;
import h.AbstractC0434u;
import h.AbstractC0435v;
import h.AbstractC0436w;
import h.C;
import h.D;
import h.E;
import h.F;
import h.T;
import h.U;
import h.V;
import h.r;
import h.z;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J>\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00162\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J8\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J&\u0010\u001e\u001a\u00020\n*\u00020\u001d2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J0\u0010#\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010#\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J0\u0010(\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010(\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J&\u0010*\u001a\u00020\n*\u00020\u001d2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-JA\u0010.\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0001¢\u0006\u0002\b2J+\u0010.\u001a\u00020\u0004*\u00020\u001d2\u0006\u00103\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0001¢\u0006\u0002\b2J2\u00104\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002052\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00104\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002052\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00106\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00106\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00108\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J&\u00108\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010&\u001a\u00020'2\b\u00100\u001a\u0004\u0018\u000101H\u0003J2\u0010:\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010:\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J2\u0010<\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003J\u001c\u0010<\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010>\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010>\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010?\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010?\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J-\u0010@\u001a\u00020\u0011*\u00020$2\u0006\u0010\u0005\u001a\u00020A2\b\u0010/\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\bDJ+\u0010@\u001a\u00020\u0011*\u00020\u001d2\u0006\u00103\u001a\u00020A2\u0006\u0010&\u001a\u00020'2\b\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\bDJ\u001e\u0010E\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010E\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010F\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\b\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010F\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u0019\u0010G\u001a\u00020H*\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006K"}, d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", BuildConfig.FLAVOR, "()V", "fallbackOnLegacyTextField", BuildConfig.FLAVOR, "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", BuildConfig.FLAVOR, "performDeletionOnLegacyTextField", "range", "Landroidx/compose/ui/text/TextRange;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "adjustRange", BuildConfig.FLAVOR, "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "performInsertionOnLegacyTextField", "offset", BuildConfig.FLAVOR, "performSelectionOnLegacyTextField", "textSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "fallback", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "highlightRange", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "performDeleteGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroid/view/inputmethod/DeleteGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "performDeletion", "rangeInTransformedText", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "performHandwritingGesture", "textFieldSelectionManager", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation_release", "handwritingGesture", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performSelectGesture", "Landroid/view/inputmethod/SelectGesture;", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewDeleteGesture", "previewDeleteRangeGesture", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation_release", "previewSelectGesture", "previewSelectRangeGesture", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HandwritingGestureApi34 {
    public static final HandwritingGestureApi34 INSTANCE = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    private final int fallback(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        TransformedTextFieldState.access$getTextFieldState$p(transformedTextFieldState);
        TransformedTextFieldState.access$getInputTransformation$p(transformedTextFieldState);
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        throw null;
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture gesture, Function1<? super EditCommand, Unit> editCommandConsumer) {
        String fallbackText;
        fallbackText = gesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        editCommandConsumer.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* renamed from: highlightRange-XJREzCE, reason: not valid java name */
    private final void m567highlightRangeXJREzCE(TransformedTextFieldState transformedTextFieldState, long j5, int i5) {
        if (!TextRange.m2279getCollapsedimpl(j5)) {
            throw null;
        }
        TransformedTextFieldState.access$getTextFieldState$p(transformedTextFieldState);
        TransformedTextFieldState.access$getInputTransformation$p(transformedTextFieldState);
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        throw null;
    }

    private final int performDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        int granularity;
        RectF deletionArea;
        long m589getRangeForScreenRectOH9lIzo;
        granularity = deleteGesture.getGranularity();
        int m571toTextGranularityNUwxegE = m571toTextGranularityNUwxegE(granularity);
        deletionArea = deleteGesture.getDeletionArea();
        m589getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m589getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deletionArea), m571toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m2279getCollapsedimpl(m589getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, T.a(deleteGesture));
        }
        m568performDeletionSbBc2M(transformedTextFieldState, m589getRangeForScreenRectOH9lIzo, TextGranularity.m2263equalsimpl0(m571toTextGranularityNUwxegE, TextGranularity.INSTANCE.m2265getWordDRrd7Zo()));
        return 1;
    }

    private final int performDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        int granularity;
        RectF deletionStartArea;
        RectF deletionEndArea;
        long m591getRangeForScreenRectsO048IG0;
        granularity = deleteRangeGesture.getGranularity();
        int m571toTextGranularityNUwxegE = m571toTextGranularityNUwxegE(granularity);
        deletionStartArea = deleteRangeGesture.getDeletionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(deletionStartArea);
        deletionEndArea = deleteRangeGesture.getDeletionEndArea();
        m591getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m591getRangeForScreenRectsO048IG0(textLayoutState, composeRect, RectHelper_androidKt.toComposeRect(deletionEndArea), m571toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m2279getCollapsedimpl(m591getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, T.a(deleteRangeGesture));
        }
        m568performDeletionSbBc2M(transformedTextFieldState, m591getRangeForScreenRectsO048IG0, TextGranularity.m2263equalsimpl0(m571toTextGranularityNUwxegE, TextGranularity.INSTANCE.m2265getWordDRrd7Zo()));
        return 1;
    }

    /* renamed from: performDeletion-Sb-Bc2M, reason: not valid java name */
    private final void m568performDeletionSbBc2M(TransformedTextFieldState transformedTextFieldState, long j5, boolean z5) {
        if (z5) {
            throw null;
        }
        TransformedTextFieldState.m594replaceTextM8tDOmk$default(transformedTextFieldState, BuildConfig.FLAVOR, j5, null, false, 12, null);
    }

    /* renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    private final void m569performDeletionOnLegacyTextFieldvJH6DeI(long range, AnnotatedString text, boolean adjustRange, Function1<? super EditCommand, Unit> editCommandConsumer) {
        EditCommand compoundEditCommand;
        if (adjustRange) {
            range = HandwritingGesture_androidKt.m580adjustHandwritingDeleteGestureRange72CqOWE(range, text);
        }
        compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(TextRange.m2280getEndimpl(range), TextRange.m2280getEndimpl(range)), new DeleteSurroundingTextCommand(TextRange.m2281getLengthimpl(range), 0));
        editCommandConsumer.invoke(compoundEditCommand);
    }

    private final int performInsertGesture(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        PointF insertionPoint;
        long offset;
        int m584getOffsetForHandwritingGestured4ec7I;
        String textToInsert;
        insertionPoint = insertGesture.getInsertionPoint();
        offset = HandwritingGesture_androidKt.toOffset(insertionPoint);
        m584getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m584getOffsetForHandwritingGestured4ec7I(textLayoutState, offset, viewConfiguration);
        if (m584getOffsetForHandwritingGestured4ec7I == -1) {
            return fallback(transformedTextFieldState, T.a(insertGesture));
        }
        textToInsert = insertGesture.getTextToInsert();
        TransformedTextFieldState.m594replaceTextM8tDOmk$default(transformedTextFieldState, textToInsert, TextRangeKt.TextRange(m584getOffsetForHandwritingGestured4ec7I), null, false, 12, null);
        return 1;
    }

    private final void performInsertionOnLegacyTextField(int offset, String text, Function1<? super EditCommand, Unit> editCommandConsumer) {
        EditCommand compoundEditCommand;
        compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(offset, offset), new CommitTextCommand(text, 1));
        editCommandConsumer.invoke(compoundEditCommand);
    }

    private final int performJoinOrSplitGesture(TransformedTextFieldState transformedTextFieldState, JoinOrSplitGesture joinOrSplitGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        throw null;
    }

    private final int performRemoveSpaceGesture(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        throw null;
    }

    private final int performSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        RectF selectionArea;
        int granularity;
        long m589getRangeForScreenRectOH9lIzo;
        selectionArea = selectGesture.getSelectionArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionArea);
        granularity = selectGesture.getGranularity();
        m589getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m589getRangeForScreenRectOH9lIzo(textLayoutState, composeRect, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m2279getCollapsedimpl(m589getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, T.a(selectGesture));
        }
        throw null;
    }

    private final int performSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        RectF selectionStartArea;
        RectF selectionEndArea;
        int granularity;
        long m591getRangeForScreenRectsO048IG0;
        selectionStartArea = selectRangeGesture.getSelectionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionStartArea);
        selectionEndArea = selectRangeGesture.getSelectionEndArea();
        Rect composeRect2 = RectHelper_androidKt.toComposeRect(selectionEndArea);
        granularity = selectRangeGesture.getGranularity();
        m591getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m591getRangeForScreenRectsO048IG0(textLayoutState, composeRect, composeRect2, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m2279getCollapsedimpl(m591getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, T.a(selectRangeGesture));
        }
        throw null;
    }

    /* renamed from: performSelectionOnLegacyTextField-8ffj60Q, reason: not valid java name */
    private final void m570performSelectionOnLegacyTextField8ffj60Q(long range, TextFieldSelectionManager textSelectionManager, Function1<? super EditCommand, Unit> editCommandConsumer) {
        editCommandConsumer.invoke(new SetSelectionCommand(TextRange.m2285getStartimpl(range), TextRange.m2280getEndimpl(range)));
        if (textSelectionManager != null) {
            textSelectionManager.enterSelectionMode$foundation_release(true);
        }
    }

    private final void previewDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        RectF deletionArea;
        int granularity;
        long m589getRangeForScreenRectOH9lIzo;
        deletionArea = deleteGesture.getDeletionArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(deletionArea);
        granularity = deleteGesture.getGranularity();
        m589getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m589getRangeForScreenRectOH9lIzo(textLayoutState, composeRect, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        m567highlightRangeXJREzCE(transformedTextFieldState, m589getRangeForScreenRectOH9lIzo, TextHighlightType.INSTANCE.m562getHandwritingDeletePreviewsxJuwY());
    }

    private final void previewDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        RectF deletionStartArea;
        RectF deletionEndArea;
        int granularity;
        long m591getRangeForScreenRectsO048IG0;
        deletionStartArea = deleteRangeGesture.getDeletionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(deletionStartArea);
        deletionEndArea = deleteRangeGesture.getDeletionEndArea();
        Rect composeRect2 = RectHelper_androidKt.toComposeRect(deletionEndArea);
        granularity = deleteRangeGesture.getGranularity();
        m591getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m591getRangeForScreenRectsO048IG0(textLayoutState, composeRect, composeRect2, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        m567highlightRangeXJREzCE(transformedTextFieldState, m591getRangeForScreenRectsO048IG0, TextHighlightType.INSTANCE.m562getHandwritingDeletePreviewsxJuwY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$1(TransformedTextFieldState transformedTextFieldState) {
        TransformedTextFieldState.access$getTextFieldState$p(transformedTextFieldState);
        TransformedTextFieldState.access$getInputTransformation$p(transformedTextFieldState);
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$9(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.clearPreviewHighlight$foundation_release();
        }
    }

    private final void previewSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        RectF selectionArea;
        int granularity;
        long m589getRangeForScreenRectOH9lIzo;
        selectionArea = selectGesture.getSelectionArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionArea);
        granularity = selectGesture.getGranularity();
        m589getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m589getRangeForScreenRectOH9lIzo(textLayoutState, composeRect, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        m567highlightRangeXJREzCE(transformedTextFieldState, m589getRangeForScreenRectOH9lIzo, TextHighlightType.INSTANCE.m563getHandwritingSelectPreviewsxJuwY());
    }

    private final void previewSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        RectF selectionStartArea;
        RectF selectionEndArea;
        int granularity;
        long m591getRangeForScreenRectsO048IG0;
        selectionStartArea = selectRangeGesture.getSelectionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionStartArea);
        selectionEndArea = selectRangeGesture.getSelectionEndArea();
        Rect composeRect2 = RectHelper_androidKt.toComposeRect(selectionEndArea);
        granularity = selectRangeGesture.getGranularity();
        m591getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m591getRangeForScreenRectsO048IG0(textLayoutState, composeRect, composeRect2, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        m567highlightRangeXJREzCE(transformedTextFieldState, m591getRangeForScreenRectsO048IG0, TextHighlightType.INSTANCE.m563getHandwritingSelectPreviewsxJuwY());
    }

    /* renamed from: toTextGranularity-NUwxegE, reason: not valid java name */
    private final int m571toTextGranularityNUwxegE(int i5) {
        return i5 != 1 ? i5 != 2 ? TextGranularity.INSTANCE.m2264getCharacterDRrd7Zo() : TextGranularity.INSTANCE.m2264getCharacterDRrd7Zo() : TextGranularity.INSTANCE.m2265getWordDRrd7Zo();
    }

    public final int performHandwritingGesture$foundation_release(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        if (U.a(handwritingGesture)) {
            return performSelectGesture(transformedTextFieldState, V.a(handwritingGesture), textLayoutState);
        }
        if (r.a(handwritingGesture)) {
            return performDeleteGesture(transformedTextFieldState, AbstractC0432s.a(handwritingGesture), textLayoutState);
        }
        if (AbstractC0433t.a(handwritingGesture)) {
            return performSelectRangeGesture(transformedTextFieldState, AbstractC0434u.a(handwritingGesture), textLayoutState);
        }
        if (AbstractC0435v.a(handwritingGesture)) {
            return performDeleteRangeGesture(transformedTextFieldState, AbstractC0436w.a(handwritingGesture), textLayoutState);
        }
        if (E.a(handwritingGesture)) {
            return performJoinOrSplitGesture(transformedTextFieldState, F.a(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (z.a(handwritingGesture)) {
            return performInsertGesture(transformedTextFieldState, AbstractC0414A.a(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (C.a(handwritingGesture)) {
            return performRemoveSpaceGesture(transformedTextFieldState, D.a(handwritingGesture), textLayoutState, viewConfiguration);
        }
        return 2;
    }

    public final boolean previewHandwritingGesture$foundation_release(final TransformedTextFieldState transformedTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextLayoutState textLayoutState, CancellationSignal cancellationSignal) {
        if (U.a(previewableHandwritingGesture)) {
            previewSelectGesture(transformedTextFieldState, V.a(previewableHandwritingGesture), textLayoutState);
        } else if (r.a(previewableHandwritingGesture)) {
            previewDeleteGesture(transformedTextFieldState, AbstractC0432s.a(previewableHandwritingGesture), textLayoutState);
        } else if (AbstractC0433t.a(previewableHandwritingGesture)) {
            previewSelectRangeGesture(transformedTextFieldState, AbstractC0434u.a(previewableHandwritingGesture), textLayoutState);
        } else {
            if (!AbstractC0435v.a(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(transformedTextFieldState, AbstractC0436w.a(previewableHandwritingGesture), textLayoutState);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener(transformedTextFieldState) { // from class: h.X
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.previewHandwritingGesture$lambda$1(null);
            }
        });
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r8 == true) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int performJoinOrSplitGesture(LegacyTextFieldState legacyTextFieldState, JoinOrSplitGesture joinOrSplitGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        PointF joinOrSplitPoint;
        long offset;
        int m583getOffsetForHandwritingGestured4ec7I;
        long rangeOfWhitespaces;
        TextLayoutResult value;
        boolean isBiDiBoundary;
        if (viewConfiguration == null) {
            return fallbackOnLegacyTextField(T.a(joinOrSplitGesture), function1);
        }
        joinOrSplitPoint = joinOrSplitGesture.getJoinOrSplitPoint();
        offset = HandwritingGesture_androidKt.toOffset(joinOrSplitPoint);
        m583getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m583getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, offset, viewConfiguration);
        if (m583getOffsetForHandwritingGestured4ec7I != -1) {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult != null && (value = layoutResult.getValue()) != null) {
                isBiDiBoundary = HandwritingGesture_androidKt.isBiDiBoundary(value, m583getOffsetForHandwritingGestured4ec7I);
            }
            rangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(annotatedString, m583getOffsetForHandwritingGestured4ec7I);
            if (TextRange.m2279getCollapsedimpl(rangeOfWhitespaces)) {
                performInsertionOnLegacyTextField(TextRange.m2285getStartimpl(rangeOfWhitespaces), " ", function1);
            } else {
                m569performDeletionOnLegacyTextFieldvJH6DeI(rangeOfWhitespaces, annotatedString, false, function1);
            }
            return 1;
        }
        return fallbackOnLegacyTextField(T.a(joinOrSplitGesture), function1);
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        PointF startPoint;
        long offset;
        PointF endPoint;
        long offset2;
        long m586getRangeForRemoveSpaceGesture5iVPX68;
        EditCommand compoundEditCommand;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
        startPoint = removeSpaceGesture.getStartPoint();
        offset = HandwritingGesture_androidKt.toOffset(startPoint);
        endPoint = removeSpaceGesture.getEndPoint();
        offset2 = HandwritingGesture_androidKt.toOffset(endPoint);
        m586getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m586getRangeForRemoveSpaceGesture5iVPX68(value, offset, offset2, legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
        if (TextRange.m2279getCollapsedimpl(m586getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallbackOnLegacyTextField(T.a(removeSpaceGesture), function1);
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = -1;
        String replace = new Regex("\\s+").replace(TextRangeKt.m2292substringFDrldGo(annotatedString, m586getRangeForRemoveSpaceGesture5iVPX68), new Function1<MatchResult, CharSequence>() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Ref$IntRef ref$IntRef3 = Ref$IntRef.this;
                if (ref$IntRef3.element == -1) {
                    ref$IntRef3.element = matchResult.getRange().getFirst();
                }
                ref$IntRef2.element = matchResult.getRange().getLast() + 1;
                return BuildConfig.FLAVOR;
            }
        });
        if (ref$IntRef.element != -1 && ref$IntRef2.element != -1) {
            int m2285getStartimpl = TextRange.m2285getStartimpl(m586getRangeForRemoveSpaceGesture5iVPX68) + ref$IntRef.element;
            int m2285getStartimpl2 = TextRange.m2285getStartimpl(m586getRangeForRemoveSpaceGesture5iVPX68) + ref$IntRef2.element;
            String substring = replace.substring(ref$IntRef.element, replace.length() - (TextRange.m2281getLengthimpl(m586getRangeForRemoveSpaceGesture5iVPX68) - ref$IntRef2.element));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            compoundEditCommand = HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(m2285getStartimpl, m2285getStartimpl2), new CommitTextCommand(substring, 1));
            function1.invoke(compoundEditCommand);
            return 1;
        }
        return fallbackOnLegacyTextField(T.a(removeSpaceGesture), function1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r3 == true) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int performInsertGesture(LegacyTextFieldState legacyTextFieldState, InsertGesture insertGesture, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        PointF insertionPoint;
        long offset;
        int m583getOffsetForHandwritingGestured4ec7I;
        String textToInsert;
        TextLayoutResult value;
        boolean isBiDiBoundary;
        if (viewConfiguration == null) {
            return fallbackOnLegacyTextField(T.a(insertGesture), function1);
        }
        insertionPoint = insertGesture.getInsertionPoint();
        offset = HandwritingGesture_androidKt.toOffset(insertionPoint);
        m583getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m583getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, offset, viewConfiguration);
        if (m583getOffsetForHandwritingGestured4ec7I != -1) {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult != null && (value = layoutResult.getValue()) != null) {
                isBiDiBoundary = HandwritingGesture_androidKt.isBiDiBoundary(value, m583getOffsetForHandwritingGestured4ec7I);
            }
            textToInsert = insertGesture.getTextToInsert();
            performInsertionOnLegacyTextField(m583getOffsetForHandwritingGestured4ec7I, textToInsert, function1);
            return 1;
        }
        return fallbackOnLegacyTextField(T.a(insertGesture), function1);
    }

    public final boolean previewHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, final TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return false;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return false;
        }
        if (U.a(previewableHandwritingGesture)) {
            previewSelectGesture(legacyTextFieldState, V.a(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (r.a(previewableHandwritingGesture)) {
            previewDeleteGesture(legacyTextFieldState, AbstractC0432s.a(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (AbstractC0433t.a(previewableHandwritingGesture)) {
            previewSelectRangeGesture(legacyTextFieldState, AbstractC0434u.a(previewableHandwritingGesture), textFieldSelectionManager);
        } else {
            if (!AbstractC0435v.a(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(legacyTextFieldState, AbstractC0436w.a(previewableHandwritingGesture), textFieldSelectionManager);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: h.W
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                HandwritingGestureApi34.previewHandwritingGesture$lambda$9(TextFieldSelectionManager.this);
            }
        });
        return true;
    }

    private final int performSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        RectF selectionArea;
        int granularity;
        long m588getRangeForScreenRectOH9lIzo;
        selectionArea = selectGesture.getSelectionArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionArea);
        granularity = selectGesture.getGranularity();
        m588getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m588getRangeForScreenRectOH9lIzo(legacyTextFieldState, composeRect, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m2279getCollapsedimpl(m588getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(T.a(selectGesture), function1);
        }
        m570performSelectionOnLegacyTextField8ffj60Q(m588getRangeForScreenRectOH9lIzo, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        RectF deletionArea;
        int granularity;
        long m588getRangeForScreenRectOH9lIzo;
        if (textFieldSelectionManager != null) {
            deletionArea = deleteGesture.getDeletionArea();
            Rect composeRect = RectHelper_androidKt.toComposeRect(deletionArea);
            granularity = deleteGesture.getGranularity();
            m588getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m588getRangeForScreenRectOH9lIzo(legacyTextFieldState, composeRect, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
            textFieldSelectionManager.m647setDeletionPreviewHighlight5zctL8$foundation_release(m588getRangeForScreenRectOH9lIzo);
        }
    }

    private final void previewSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        RectF selectionArea;
        int granularity;
        long m588getRangeForScreenRectOH9lIzo;
        if (textFieldSelectionManager != null) {
            selectionArea = selectGesture.getSelectionArea();
            Rect composeRect = RectHelper_androidKt.toComposeRect(selectionArea);
            granularity = selectGesture.getGranularity();
            m588getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m588getRangeForScreenRectOH9lIzo(legacyTextFieldState, composeRect, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
            textFieldSelectionManager.m648setSelectionPreviewHighlight5zctL8$foundation_release(m588getRangeForScreenRectOH9lIzo);
        }
    }

    private final int performDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int granularity;
        RectF deletionArea;
        long m588getRangeForScreenRectOH9lIzo;
        granularity = deleteGesture.getGranularity();
        int m571toTextGranularityNUwxegE = m571toTextGranularityNUwxegE(granularity);
        deletionArea = deleteGesture.getDeletionArea();
        m588getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m588getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deletionArea), m571toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m2279getCollapsedimpl(m588getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(T.a(deleteGesture), function1);
        }
        m569performDeletionOnLegacyTextFieldvJH6DeI(m588getRangeForScreenRectOH9lIzo, annotatedString, TextGranularity.m2263equalsimpl0(m571toTextGranularityNUwxegE, TextGranularity.INSTANCE.m2265getWordDRrd7Zo()), function1);
        return 1;
    }

    private final int performSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, Function1<? super EditCommand, Unit> function1) {
        RectF selectionStartArea;
        RectF selectionEndArea;
        int granularity;
        long m590getRangeForScreenRectsO048IG0;
        selectionStartArea = selectRangeGesture.getSelectionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(selectionStartArea);
        selectionEndArea = selectRangeGesture.getSelectionEndArea();
        Rect composeRect2 = RectHelper_androidKt.toComposeRect(selectionEndArea);
        granularity = selectRangeGesture.getGranularity();
        m590getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m590getRangeForScreenRectsO048IG0(legacyTextFieldState, composeRect, composeRect2, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m2279getCollapsedimpl(m590getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(T.a(selectRangeGesture), function1);
        }
        m570performSelectionOnLegacyTextField8ffj60Q(m590getRangeForScreenRectsO048IG0, textFieldSelectionManager, function1);
        return 1;
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        RectF deletionStartArea;
        RectF deletionEndArea;
        int granularity;
        long m590getRangeForScreenRectsO048IG0;
        if (textFieldSelectionManager != null) {
            deletionStartArea = deleteRangeGesture.getDeletionStartArea();
            Rect composeRect = RectHelper_androidKt.toComposeRect(deletionStartArea);
            deletionEndArea = deleteRangeGesture.getDeletionEndArea();
            Rect composeRect2 = RectHelper_androidKt.toComposeRect(deletionEndArea);
            granularity = deleteRangeGesture.getGranularity();
            m590getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m590getRangeForScreenRectsO048IG0(legacyTextFieldState, composeRect, composeRect2, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
            textFieldSelectionManager.m647setDeletionPreviewHighlight5zctL8$foundation_release(m590getRangeForScreenRectsO048IG0);
        }
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        RectF selectionStartArea;
        RectF selectionEndArea;
        int granularity;
        long m590getRangeForScreenRectsO048IG0;
        if (textFieldSelectionManager != null) {
            selectionStartArea = selectRangeGesture.getSelectionStartArea();
            Rect composeRect = RectHelper_androidKt.toComposeRect(selectionStartArea);
            selectionEndArea = selectRangeGesture.getSelectionEndArea();
            Rect composeRect2 = RectHelper_androidKt.toComposeRect(selectionEndArea);
            granularity = selectRangeGesture.getGranularity();
            m590getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m590getRangeForScreenRectsO048IG0(legacyTextFieldState, composeRect, composeRect2, m571toTextGranularityNUwxegE(granularity), TextInclusionStrategy.INSTANCE.getContainsCenter());
            textFieldSelectionManager.m648setSelectionPreviewHighlight5zctL8$foundation_release(m590getRangeForScreenRectsO048IG0);
        }
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, Function1<? super EditCommand, Unit> function1) {
        int granularity;
        RectF deletionStartArea;
        RectF deletionEndArea;
        long m590getRangeForScreenRectsO048IG0;
        granularity = deleteRangeGesture.getGranularity();
        int m571toTextGranularityNUwxegE = m571toTextGranularityNUwxegE(granularity);
        deletionStartArea = deleteRangeGesture.getDeletionStartArea();
        Rect composeRect = RectHelper_androidKt.toComposeRect(deletionStartArea);
        deletionEndArea = deleteRangeGesture.getDeletionEndArea();
        m590getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m590getRangeForScreenRectsO048IG0(legacyTextFieldState, composeRect, RectHelper_androidKt.toComposeRect(deletionEndArea), m571toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m2279getCollapsedimpl(m590getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(T.a(deleteRangeGesture), function1);
        }
        m569performDeletionOnLegacyTextFieldvJH6DeI(m590getRangeForScreenRectsO048IG0, annotatedString, TextGranularity.m2263equalsimpl0(m571toTextGranularityNUwxegE, TextGranularity.INSTANCE.m2265getWordDRrd7Zo()), function1);
        return 1;
    }

    public final int performHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, HandwritingGesture handwritingGesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> function1) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return 3;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!Intrinsics.areEqual(untransformedText, (layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return 3;
        }
        if (U.a(handwritingGesture)) {
            return performSelectGesture(legacyTextFieldState, V.a(handwritingGesture), textFieldSelectionManager, function1);
        }
        if (r.a(handwritingGesture)) {
            return performDeleteGesture(legacyTextFieldState, AbstractC0432s.a(handwritingGesture), untransformedText, function1);
        }
        if (AbstractC0433t.a(handwritingGesture)) {
            return performSelectRangeGesture(legacyTextFieldState, AbstractC0434u.a(handwritingGesture), textFieldSelectionManager, function1);
        }
        if (AbstractC0435v.a(handwritingGesture)) {
            return performDeleteRangeGesture(legacyTextFieldState, AbstractC0436w.a(handwritingGesture), untransformedText, function1);
        }
        if (E.a(handwritingGesture)) {
            return performJoinOrSplitGesture(legacyTextFieldState, F.a(handwritingGesture), untransformedText, viewConfiguration, function1);
        }
        if (z.a(handwritingGesture)) {
            return performInsertGesture(legacyTextFieldState, AbstractC0414A.a(handwritingGesture), viewConfiguration, function1);
        }
        if (C.a(handwritingGesture)) {
            return performRemoveSpaceGesture(legacyTextFieldState, D.a(handwritingGesture), untransformedText, viewConfiguration, function1);
        }
        return 2;
    }
}
