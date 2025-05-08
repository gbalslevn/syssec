package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJB\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010$\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0017\u0010(\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000¢\u0006\u0004\b&\u0010'J\u000f\u0010+\u001a\u00020%H\u0000¢\u0006\u0004\b)\u0010*J\u0019\u0010.\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020\u0006H\u0000¢\u0006\u0004\b-\u0010\nJ\u000f\u00101\u001a\u00020\bH\u0000¢\u0006\u0004\b/\u00100J\u001e\u00105\u001a\u00020\b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001a\u00109\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001a\u0010;\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\b:\u00108J\u000f\u0010=\u001a\u00020\bH\u0000¢\u0006\u0004\b<\u00100J\u0019\u0010@\u001a\u00020\b2\b\b\u0002\u0010>\u001a\u00020\u0006H\u0000¢\u0006\u0004\b?\u0010\nJ\u000f\u0010B\u001a\u00020\bH\u0000¢\u0006\u0004\bA\u00100J\u000f\u0010D\u001a\u00020\bH\u0000¢\u0006\u0004\bC\u00100J\u000f\u0010F\u001a\u00020\bH\u0000¢\u0006\u0004\bE\u00100J\u001d\u0010I\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001d\u0010N\u001a\u00020\u00102\u0006\u0010K\u001a\u00020JH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u000f\u0010P\u001a\u00020\bH\u0000¢\u0006\u0004\bO\u00100J\u000f\u0010R\u001a\u00020\bH\u0000¢\u0006\u0004\bQ\u00100J\u000f\u0010U\u001a\u00020\u0006H\u0000¢\u0006\u0004\bS\u0010TR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010V\u001a\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R.\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0`8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010h\u001a\u0004\u0018\u00010g8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020\u000e8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010v\u001a\u00020u8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R'\u0010}\u001a\u0004\u0018\u00010|8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R,\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R,\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R/\u0010\u009b\u0001\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u0098\u0001\u0010p\u001a\u0005\b\u0099\u0001\u0010T\"\u0005\b\u009a\u0001\u0010\nR/\u0010\u009f\u0001\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010p\u001a\u0005\b\u009d\u0001\u0010T\"\u0005\b\u009e\u0001\u0010\nR\u001f\u0010 \u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001f\u0010¥\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b¥\u0001\u0010¡\u0001R7\u0010¬\u0001\u001a\u0005\u0018\u00010¦\u00012\t\u0010n\u001a\u0005\u0018\u00010¦\u00018F@BX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b§\u0001\u0010p\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R:\u0010±\u0001\u001a\u0004\u0018\u00010\u00102\b\u0010n\u001a\u0004\u0018\u00010\u00108F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0016\n\u0005\b\u00ad\u0001\u0010p\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0005\b°\u0001\u00104R\u001a\u0010²\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0019\u0010´\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001c\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001e\u0010¹\u0001\u001a\u00020%8\u0000X\u0080\u0004¢\u0006\u000f\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0005\b»\u0001\u0010*R \u0010½\u0001\u001a\u00030¼\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001R\u0019\u0010Ã\u0001\u001a\u0004\u0018\u00010\u001f8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÁ\u0001\u0010Â\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Ä\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/text/UndoManager;", "undoManager", "<init>", "(Landroidx/compose/foundation/text/UndoManager;)V", BuildConfig.FLAVOR, "show", BuildConfig.FLAVOR, "updateFloatingToolbar", "(Z)V", "Landroidx/compose/ui/geometry/Rect;", "getContentRect", "()Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/text/input/TextFieldValue;", "value", "Landroidx/compose/ui/geometry/Offset;", "currentPosition", "isStartOfSelection", "isStartHandle", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjustment", "isTouchBasedSelection", "Landroidx/compose/ui/text/TextRange;", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "updateSelection", "Landroidx/compose/foundation/text/HandleState;", "handleState", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "Landroidx/compose/ui/text/AnnotatedString;", "annotatedString", "selection", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "createTextFieldValue", "Landroidx/compose/foundation/text/TextDragObserver;", "handleDragObserver$foundation_release", "(Z)Landroidx/compose/foundation/text/TextDragObserver;", "handleDragObserver", "cursorDragObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "cursorDragObserver", "showFloatingToolbar", "enterSelectionMode$foundation_release", "enterSelectionMode", "exitSelectionMode$foundation_release", "()V", "exitSelectionMode", "position", "deselect-_kEHs6E$foundation_release", "(Landroidx/compose/ui/geometry/Offset;)V", "deselect", "range", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "(J)V", "setSelectionPreviewHighlight", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "setDeletionPreviewHighlight", "clearPreviewHighlight$foundation_release", "clearPreviewHighlight", "cancelSelection", "copy$foundation_release", "copy", "paste$foundation_release", "paste", "cut$foundation_release", "cut", "selectAll$foundation_release", "selectAll", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "getHandlePosition", "Landroidx/compose/ui/unit/Density;", "density", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getCursorPosition", "showSelectionToolbar$foundation_release", "showSelectionToolbar", "hideSelectionToolbar$foundation_release", "hideSelectionToolbar", "isTextChanged$foundation_release", "()Z", "isTextChanged", "Landroidx/compose/foundation/text/UndoManager;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "Lkotlin/Function1;", "onValueChange", "Lkotlin/jvm/functions/Function1;", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "<set-?>", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "Landroidx/compose/ui/platform/ClipboardManager;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "Landroidx/compose/ui/platform/TextToolbar;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "editable$delegate", "getEditable", "setEditable", "editable", "enabled$delegate", "getEnabled", "setEnabled", "enabled", "dragBeginPosition", "J", BuildConfig.FLAVOR, "dragBeginOffsetInText", "Ljava/lang/Integer;", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle$delegate", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle", "currentDragPosition$delegate", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "currentDragPosition", "previousRawDragOffset", "I", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "transformedText", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    private ClipboardManager clipboardManager;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: editable$delegate, reason: from kotlin metadata */
    private final MutableState editable;

    /* renamed from: enabled$delegate, reason: from kotlin metadata */
    private final MutableState enabled;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private TextFieldValue oldValue;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;
    private VisualTransformation visualTransformation;
    private OffsetMapping offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
    private Function1<? super TextFieldValue, Unit> onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextFieldValue textFieldValue) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
            invoke2(textFieldValue);
            return Unit.INSTANCE;
        }
    };

    public TextFieldSelectionManager(UndoManager undoManager) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        this.undoManager = undoManager;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.value = mutableStateOf$default;
        this.visualTransformation = VisualTransformation.INSTANCE.getNone();
        Boolean bool = Boolean.TRUE;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.editable = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.enabled = mutableStateOf$default3;
        Offset.Companion companion = Offset.INSTANCE;
        this.dragBeginPosition = companion.m1349getZeroF1C5BW0();
        this.dragTotalDistance = companion.m1349getZeroF1C5BW0();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = mutableStateOf$default5;
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            private final void onEnd() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m641setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
                TextFieldSelectionManager.this.dragBeginOffsetInText = null;
                boolean m2279getCollapsedimpl = TextRange.m2279getCollapsedimpl(TextFieldSelectionManager.this.getValue$foundation_release().getSelection());
                TextFieldSelectionManager.this.setHandleState(m2279getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null) {
                    state.setShowSelectionHandleStart(!m2279getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true));
                }
                LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 != null) {
                    state2.setShowSelectionHandleEnd(!m2279getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, false));
                }
                LegacyTextFieldState state3 = TextFieldSelectionManager.this.getState();
                if (state3 == null) {
                    return;
                }
                state3.setShowCursorHandle(m2279getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo525onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo526onDragk4lQ0M(long delta) {
                long j5;
                TextLayoutResultProxy layoutResult;
                long j6;
                long j7;
                Integer num;
                Integer num2;
                long j8;
                int m552getOffsetForPosition3MmeM6k;
                Integer num3;
                long m642updateSelection8UEBfa8;
                long j9;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j5 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m1342plusMKHz9U(j5, delta);
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    j6 = textFieldSelectionManager2.dragBeginPosition;
                    j7 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m641setCurrentDragPosition_kEHs6E(Offset.m1328boximpl(Offset.m1342plusMKHz9U(j6, j7)));
                    num = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num == null) {
                        Offset m644getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m644getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m644getCurrentDragPosition_m7T9E);
                        if (!layoutResult.m553isPositionOnTextk4lQ0M(m644getCurrentDragPosition_m7T9E.getPackedValue())) {
                            OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                            j9 = textFieldSelectionManager2.dragBeginPosition;
                            int transformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m551getOffsetForPosition3MmeM6k$default(layoutResult, j9, false, 2, null));
                            OffsetMapping offsetMapping2 = textFieldSelectionManager2.getOffsetMapping();
                            Offset m644getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m644getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m644getCurrentDragPosition_m7T9E2);
                            SelectionAdjustment none = transformedToOriginal == offsetMapping2.transformedToOriginal(TextLayoutResultProxy.m551getOffsetForPosition3MmeM6k$default(layoutResult, m644getCurrentDragPosition_m7T9E2.getPackedValue(), false, 2, null)) ? SelectionAdjustment.INSTANCE.getNone() : SelectionAdjustment.INSTANCE.getWord();
                            TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                            Offset m644getCurrentDragPosition_m7T9E3 = textFieldSelectionManager2.m644getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m644getCurrentDragPosition_m7T9E3);
                            m642updateSelection8UEBfa8 = textFieldSelectionManager2.m642updateSelection8UEBfa8(value$foundation_release, m644getCurrentDragPosition_m7T9E3.getPackedValue(), false, false, none, true);
                            TextRange.m2273boximpl(m642updateSelection8UEBfa8);
                        }
                    }
                    num2 = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num2 != null) {
                        m552getOffsetForPosition3MmeM6k = num2.intValue();
                    } else {
                        j8 = textFieldSelectionManager2.dragBeginPosition;
                        m552getOffsetForPosition3MmeM6k = layoutResult.m552getOffsetForPosition3MmeM6k(j8, false);
                    }
                    Offset m644getCurrentDragPosition_m7T9E4 = textFieldSelectionManager2.m644getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m644getCurrentDragPosition_m7T9E4);
                    int m552getOffsetForPosition3MmeM6k2 = layoutResult.m552getOffsetForPosition3MmeM6k(m644getCurrentDragPosition_m7T9E4.getPackedValue(), false);
                    num3 = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num3 == null && m552getOffsetForPosition3MmeM6k == m552getOffsetForPosition3MmeM6k2) {
                        return;
                    }
                    TextFieldValue value$foundation_release2 = textFieldSelectionManager2.getValue$foundation_release();
                    Offset m644getCurrentDragPosition_m7T9E5 = textFieldSelectionManager2.m644getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m644getCurrentDragPosition_m7T9E5);
                    m642updateSelection8UEBfa8 = textFieldSelectionManager2.m642updateSelection8UEBfa8(value$foundation_release2, m644getCurrentDragPosition_m7T9E5.getPackedValue(), false, false, SelectionAdjustment.INSTANCE.getWord(), true);
                    TextRange.m2273boximpl(m642updateSelection8UEBfa8);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo527onStartk4lQ0M(long startPoint) {
                TextLayoutResultProxy layoutResult;
                TextFieldValue m639createTextFieldValueFDrldGo;
                long j5;
                TextLayoutResultProxy layoutResult2;
                long m642updateSelection8UEBfa8;
                if (TextFieldSelectionManager.this.getEnabled() && TextFieldSelectionManager.this.getDraggingHandle() == null) {
                    TextFieldSelectionManager.this.setDraggingHandle(Handle.SelectionEnd);
                    TextFieldSelectionManager.this.previousRawDragOffset = -1;
                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                    if (state == null || (layoutResult2 = state.getLayoutResult()) == null || !layoutResult2.m553isPositionOnTextk4lQ0M(startPoint)) {
                        LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                        if (state2 != null && (layoutResult = state2.getLayoutResult()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                            int transformedToOriginal = textFieldSelectionManager.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.m551getOffsetForPosition3MmeM6k$default(layoutResult, startPoint, false, 2, null));
                            m639createTextFieldValueFDrldGo = textFieldSelectionManager.m639createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getText(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                            HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                            if (hapticFeedBack != null) {
                                hapticFeedBack.mo1778performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m1782getTextHandleMove5zf0vsI());
                            }
                            textFieldSelectionManager.getOnValueChange$foundation_release().invoke(m639createTextFieldValueFDrldGo);
                        }
                    } else {
                        if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                            return;
                        }
                        TextFieldSelectionManager.this.enterSelectionMode$foundation_release(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                        m642updateSelection8UEBfa8 = textFieldSelectionManager2.m642updateSelection8UEBfa8(TextFieldValue.m2424copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.INSTANCE.m2290getZerod9O1mEE(), (TextRange) null, 5, (Object) null), startPoint, true, false, SelectionAdjustment.INSTANCE.getWord(), true);
                        TextFieldSelectionManager.this.dragBeginOffsetInText = Integer.valueOf(TextRange.m2285getStartimpl(m642updateSelection8UEBfa8));
                    }
                    TextFieldSelectionManager.this.setHandleState(HandleState.None);
                    TextFieldSelectionManager.this.dragBeginPosition = startPoint;
                    TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                    j5 = textFieldSelectionManager3.dragBeginPosition;
                    textFieldSelectionManager3.m641setCurrentDragPosition_kEHs6E(Offset.m1328boximpl(j5));
                    TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m1349getZeroF1C5BW0();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo624onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                LegacyTextFieldState state;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), dragPosition, false, adjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo625onExtendk4lQ0M(long downPosition) {
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || state.getLayoutResult() == null || !TextFieldSelectionManager.this.getEnabled()) {
                    return false;
                }
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), downPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo626onExtendDragk4lQ0M(long dragPosition) {
                LegacyTextFieldState state;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), dragPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k */
            public boolean mo627onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
                LegacyTextFieldState state;
                long j5;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state = TextFieldSelectionManager.this.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                FocusRequester focusRequester = TextFieldSelectionManager.this.getFocusRequester();
                if (focusRequester != null) {
                    focusRequester.requestFocus();
                }
                TextFieldSelectionManager.this.dragBeginPosition = downPosition;
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                TextFieldValue value$foundation_release = TextFieldSelectionManager.this.getValue$foundation_release();
                j5 = TextFieldSelectionManager.this.dragBeginPosition;
                updateMouseSelection(value$foundation_release, j5, true, adjustment);
                return true;
            }

            public final void updateMouseSelection(TextFieldValue value, long currentPosition, boolean isStartOfSelection, SelectionAdjustment adjustment) {
                long m642updateSelection8UEBfa8;
                m642updateSelection8UEBfa8 = TextFieldSelectionManager.this.m642updateSelection8UEBfa8(value, currentPosition, isStartOfSelection, false, adjustment, false);
                TextFieldSelectionManager.this.setHandleState(TextRange.m2279getCollapsedimpl(m642updateSelection8UEBfa8) ? HandleState.Cursor : HandleState.Selection);
            }
        };
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        textFieldSelectionManager.copy$foundation_release(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m639createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m640deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m643deselect_kEHs6E$foundation_release(offset);
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z5);
    }

    private final Rect getContentRect() {
        float f5;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getIsLayoutResultStale()) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m2285getStartimpl(getValue$foundation_release().getSelection()));
                int originalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m2280getEndimpl(getValue$foundation_release().getSelection()));
                LegacyTextFieldState legacyTextFieldState2 = this.state;
                long m1349getZeroF1C5BW0 = (legacyTextFieldState2 == null || (layoutCoordinates4 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m1349getZeroF1C5BW0() : layoutCoordinates4.mo1951localToRootMKHz9U(m646getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState legacyTextFieldState3 = this.state;
                long m1349getZeroF1C5BW02 = (legacyTextFieldState3 == null || (layoutCoordinates3 = legacyTextFieldState3.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m1349getZeroF1C5BW0() : layoutCoordinates3.mo1951localToRootMKHz9U(m646getHandlePositiontuRUvjQ$foundation_release(false));
                LegacyTextFieldState legacyTextFieldState4 = this.state;
                float f6 = 0.0f;
                if (legacyTextFieldState4 == null || (layoutCoordinates2 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                    f5 = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    f5 = Offset.m1338getYimpl(layoutCoordinates2.mo1951localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(originalToTransformed)) == null) ? 0.0f : cursorRect2.getTop())));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.state;
                if (legacyTextFieldState5 != null && (layoutCoordinates = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    f6 = Offset.m1338getYimpl(layoutCoordinates.mo1951localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(originalToTransformed2)) == null) ? 0.0f : cursorRect.getTop())));
                }
                return new Rect(Math.min(Offset.m1337getXimpl(m1349getZeroF1C5BW0), Offset.m1337getXimpl(m1349getZeroF1C5BW02)), Math.min(f5, f6), Math.max(Offset.m1337getXimpl(m1349getZeroF1C5BW0), Offset.m1337getXimpl(m1349getZeroF1C5BW02)), Math.max(Offset.m1338getYimpl(m1349getZeroF1C5BW0), Offset.m1338getYimpl(m1349getZeroF1C5BW02)) + (Dp.m2599constructorimpl(25) * legacyTextFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m641setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean show) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.setShowFloatingToolbar(show);
        }
        if (show) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    public final long m642updateSelection8UEBfa8(TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        TextLayoutResultProxy layoutResult;
        HapticFeedback hapticFeedback;
        int i5;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.INSTANCE.m2290getZerod9O1mEE();
        }
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m2285getStartimpl(value.getSelection())), this.offsetMapping.originalToTransformed(TextRange.m2280getEndimpl(value.getSelection())));
        boolean z5 = false;
        int m552getOffsetForPosition3MmeM6k = layoutResult.m552getOffsetForPosition3MmeM6k(currentPosition, false);
        int m2285getStartimpl = (isStartHandle || isStartOfSelection) ? m552getOffsetForPosition3MmeM6k : TextRange.m2285getStartimpl(TextRange);
        int m2280getEndimpl = (!isStartHandle || isStartOfSelection) ? m552getOffsetForPosition3MmeM6k : TextRange.m2280getEndimpl(TextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        int i6 = -1;
        if (!isStartOfSelection && selectionLayout != null && (i5 = this.previousRawDragOffset) != -1) {
            i6 = i5;
        }
        SelectionLayout m629getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m629getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), m2285getStartimpl, m2280getEndimpl, i6, TextRange, isStartOfSelection, isStartHandle);
        if (!m629getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return value.getSelection();
        }
        this.previousSelectionLayout = m629getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = m552getOffsetForPosition3MmeM6k;
        Selection adjust = adjustment.adjust(m629getTextFieldSelectionLayoutRcvTLA);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(adjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(adjust.getEnd().getOffset()));
        if (TextRange.m2278equalsimpl0(TextRange2, value.getSelection())) {
            return value.getSelection();
        }
        boolean z6 = TextRange.m2284getReversedimpl(TextRange2) != TextRange.m2284getReversedimpl(value.getSelection()) && TextRange.m2278equalsimpl0(TextRangeKt.TextRange(TextRange.m2280getEndimpl(TextRange2), TextRange.m2285getStartimpl(TextRange2)), value.getSelection());
        boolean z7 = TextRange.m2279getCollapsedimpl(TextRange2) && TextRange.m2279getCollapsedimpl(value.getSelection());
        if (isTouchBasedSelection && value.getText().length() > 0 && !z6 && !z7 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo1778performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m1782getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m639createTextFieldValueFDrldGo(value.getText(), TextRange2));
        if (!isTouchBasedSelection) {
            updateFloatingToolbar(!TextRange.m2279getCollapsedimpl(TextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(isTouchBasedSelection);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.m2279getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.m2279getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 != null) {
            if (TextRange.m2279getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true)) {
                z5 = true;
            }
            legacyTextFieldState5.setShowCursorHandle(z5);
        }
        return TextRange2;
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m489setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m2290getZerod9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 == null) {
            return;
        }
        legacyTextFieldState2.m491setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m2290getZerod9O1mEE());
    }

    public final void copy$foundation_release(boolean cancelSelection) {
        if (TextRange.m2279getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (cancelSelection) {
            int m2282getMaximpl = TextRange.m2282getMaximpl(getValue$foundation_release().getSelection());
            this.onValueChange.invoke(m639createTextFieldValueFDrldGo(getValue$foundation_release().getText(), TextRangeKt.TextRange(m2282getMaximpl, m2282getMaximpl)));
            setHandleState(HandleState.None);
        }
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo525onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo526onDragk4lQ0M(long delta) {
                long j5;
                TextLayoutResultProxy layoutResult;
                long j6;
                long j7;
                HapticFeedback hapticFeedBack;
                TextFieldValue m639createTextFieldValueFDrldGo;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j5 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m1342plusMKHz9U(j5, delta);
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j6 = textFieldSelectionManager2.dragBeginPosition;
                j7 = textFieldSelectionManager2.dragTotalDistance;
                textFieldSelectionManager2.m641setCurrentDragPosition_kEHs6E(Offset.m1328boximpl(Offset.m1342plusMKHz9U(j6, j7)));
                OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                Offset m644getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m644getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m644getCurrentDragPosition_m7T9E);
                int transformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m551getOffsetForPosition3MmeM6k$default(layoutResult, m644getCurrentDragPosition_m7T9E.getPackedValue(), false, 2, null));
                long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
                if (TextRange.m2278equalsimpl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().getSelection())) {
                    return;
                }
                LegacyTextFieldState state2 = textFieldSelectionManager2.getState();
                if ((state2 == null || state2.isInTouchMode()) && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo1778performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m1782getTextHandleMove5zf0vsI());
                }
                Function1<TextFieldValue, Unit> onValueChange$foundation_release = textFieldSelectionManager2.getOnValueChange$foundation_release();
                m639createTextFieldValueFDrldGo = textFieldSelectionManager2.m639createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getText(), TextRange);
                onValueChange$foundation_release.invoke(m639createTextFieldValueFDrldGo);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo527onStartk4lQ0M(long startPoint) {
                TextLayoutResultProxy layoutResult;
                long m628getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m628getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m646getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m628getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m641setCurrentDragPosition_kEHs6E(Offset.m1328boximpl(m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m1349getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m641setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m641setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public final void cut$foundation_release() {
        if (TextRange.m2279getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int m2283getMinimpl = TextRange.m2283getMinimpl(getValue$foundation_release().getSelection());
        this.onValueChange.invoke(m639createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(m2283getMinimpl, m2283getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    /* renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m643deselect_kEHs6E$foundation_release(Offset position) {
        if (!TextRange.m2279getCollapsedimpl(getValue$foundation_release().getSelection())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            this.onValueChange.invoke(TextFieldValue.m2424copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange((position == null || layoutResult == null) ? TextRange.m2282getMaximpl(getValue$foundation_release().getSelection()) : this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m551getOffsetForPosition3MmeM6k$default(layoutResult, position.getPackedValue(), false, 2, null))), (TextRange) null, 5, (Object) null));
        }
        setHandleState((position == null || getValue$foundation_release().getText().length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    public final void enterSelectionMode$foundation_release(boolean showFloatingToolbar) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && !legacyTextFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            focusRequester.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(showFloatingToolbar);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* renamed from: getClipboardManager$foundation_release, reason: from getter */
    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m644getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m645getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m2285getStartimpl(getValue$foundation_release().getSelection()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length()));
        return OffsetKt.Offset(cursorRect.getLeft() + (density.mo212toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / 2), cursorRect.getBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEditable() {
        return ((Boolean) this.editable.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnabled() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m646getHandlePositiontuRUvjQ$foundation_release(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        if (!Intrinsics.areEqual(transformedText$foundation_release.getText(), value.getLayoutInput().getText().getText())) {
            return Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        }
        long selection = getValue$foundation_release().getSelection();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(isStartHandle ? TextRange.m2285getStartimpl(selection) : TextRange.m2280getEndimpl(selection)), isStartHandle, TextRange.m2284getReversedimpl(getValue$foundation_release().getSelection()));
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    /* renamed from: getMouseSelectionObserver$foundation_release, reason: from getter */
    public final MouseSelectionObserver getMouseSelectionObserver() {
        return this.mouseSelectionObserver;
    }

    /* renamed from: getOffsetMapping$foundation_release, reason: from getter */
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    /* renamed from: getState$foundation_release, reason: from getter */
    public final LegacyTextFieldState getState() {
        return this.state;
    }

    /* renamed from: getTouchSelectionObserver$foundation_release, reason: from getter */
    public final TextDragObserver getTouchSelectionObserver() {
        return this.touchSelectionObserver;
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value.getValue();
    }

    /* renamed from: getVisualTransformation$foundation_release, reason: from getter */
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo525onDownk4lQ0M(long point) {
                TextLayoutResultProxy layoutResult;
                TextFieldSelectionManager.this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                long m628getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m628getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m646getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m628getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m641setCurrentDragPosition_kEHs6E(Offset.m1328boximpl(m555translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m1349getZeroF1C5BW0();
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 != null) {
                    state2.setInTouchMode(true);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo526onDragk4lQ0M(long delta) {
                long j5;
                long j6;
                long j7;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j5 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m1342plusMKHz9U(j5, delta);
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j6 = textFieldSelectionManager2.dragBeginPosition;
                j7 = TextFieldSelectionManager.this.dragTotalDistance;
                textFieldSelectionManager2.m641setCurrentDragPosition_kEHs6E(Offset.m1328boximpl(Offset.m1342plusMKHz9U(j6, j7)));
                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                Offset m644getCurrentDragPosition_m7T9E = TextFieldSelectionManager.this.m644getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m644getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m642updateSelection8UEBfa8(value$foundation_release, m644getCurrentDragPosition_m7T9E.getPackedValue(), false, isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo527onStartk4lQ0M(long startPoint) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m641setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m641setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }
        };
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null) {
            return;
        }
        AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int m2283getMinimpl = TextRange.m2283getMinimpl(getValue$foundation_release().getSelection()) + text.length();
        this.onValueChange.invoke(m639createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(m2283getMinimpl, m2283getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue m639createTextFieldValueFDrldGo = m639createTextFieldValueFDrldGo(getValue$foundation_release().getText(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(m639createTextFieldValueFDrldGo);
        this.oldValue = TextFieldValue.m2424copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, m639createTextFieldValueFDrldGo.getSelection(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    /* renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m647setDeletionPreviewHighlight5zctL8$foundation_release(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m489setDeletionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m491setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m2290getZerod9O1mEE());
        }
        if (TextRange.m2279getCollapsedimpl(range)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void setEditable(boolean z5) {
        this.editable.setValue(Boolean.valueOf(z5));
    }

    public final void setEnabled(boolean z5) {
        this.enabled.setValue(Boolean.valueOf(z5));
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChange = function1;
    }

    /* renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m648setSelectionPreviewHighlight5zctL8$foundation_release(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m491setSelectionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m489setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m2290getZerod9O1mEE());
        }
        if (TextRange.m2279getCollapsedimpl(range)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void setState$foundation_release(LegacyTextFieldState legacyTextFieldState) {
        this.state = legacyTextFieldState;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.value.setValue(textFieldValue);
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    public final void showSelectionToolbar$foundation_release() {
        ClipboardManager clipboardManager;
        if (getEnabled()) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            if (legacyTextFieldState == null || legacyTextFieldState.isInTouchMode()) {
                boolean z5 = this.visualTransformation instanceof PasswordVisualTransformation;
                Function0<Unit> function0 = (TextRange.m2279getCollapsedimpl(getValue$foundation_release().getSelection()) || z5) ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    }
                };
                Function0<Unit> function02 = (TextRange.m2279getCollapsedimpl(getValue$foundation_release().getSelection()) || !getEditable() || z5) ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TextFieldSelectionManager.this.cut$foundation_release();
                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    }
                };
                Function0<Unit> function03 = (getEditable() && (clipboardManager = this.clipboardManager) != null && clipboardManager.hasText()) ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TextFieldSelectionManager.this.paste$foundation_release();
                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    }
                } : null;
                Function0<Unit> function04 = TextRange.m2281getLengthimpl(getValue$foundation_release().getSelection()) != getValue$foundation_release().getText().length() ? new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TextFieldSelectionManager.this.selectAll$foundation_release();
                    }
                } : null;
                TextToolbar textToolbar = this.textToolbar;
                if (textToolbar != null) {
                    textToolbar.showMenu(getContentRect(), function0, function03, function02, function04);
                }
            }
        }
    }
}
