package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R5\u0010\n\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR)\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR)\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR5\u0010\u0015\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00130\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR9\u0010\u0019\u001a$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00130\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR/\u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR2\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR/\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR;\u0010$\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0#0\u00050\u00048\u0006¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\rR/\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\rR/\u0010(\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\rR/\u0010*\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\rR)\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\rR/\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\rR)\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\rR2\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b2\u0010\u000b\u0012\u0004\b4\u0010\u0003\u001a\u0004\b3\u0010\rR)\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\rR)\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR)\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\rR)\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR)\u0010=\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\rR)\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\b?\u0010\u000b\u001a\u0004\b@\u0010\rR)\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR#\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C0\u00048\u0006¢\u0006\f\n\u0004\bE\u0010\u000b\u001a\u0004\bF\u0010\rR)\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bH\u0010\rR)\u0010I\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bI\u0010\u000b\u001a\u0004\bJ\u0010\rR)\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bK\u0010\u000b\u001a\u0004\bL\u0010\rR)\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00050\u00048\u0006¢\u0006\f\n\u0004\bM\u0010\u000b\u001a\u0004\bN\u0010\rR5\u0010O\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0007\u0012\u0004\u0012\u00020\t0\u00060\u00050\u00048\u0006¢\u0006\f\n\u0004\bO\u0010\u000b\u001a\u0004\bP\u0010\r¨\u0006Q"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsActions;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/TextLayoutResult;", BuildConfig.FLAVOR, "GetTextLayoutResult", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getGetTextLayoutResult", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "OnClick", "getOnClick", "OnLongClick", "getOnLongClick", "Lkotlin/Function2;", BuildConfig.FLAVOR, "ScrollBy", "getScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "ScrollByOffset", "getScrollByOffset", BuildConfig.FLAVOR, "ScrollToIndex", "getScrollToIndex", "Landroidx/compose/ui/text/AnnotatedString;", "OnAutofillText", "getOnAutofillText$ui_release", "SetProgress", "getSetProgress", "Lkotlin/Function3;", "SetSelection", "getSetSelection", "SetText", "getSetText", "SetTextSubstitution", "getSetTextSubstitution", "ShowTextSubstitution", "getShowTextSubstitution", "ClearTextSubstitution", "getClearTextSubstitution", "InsertTextAtCursor", "getInsertTextAtCursor", "OnImeAction", "getOnImeAction", "PerformImeAction", "getPerformImeAction", "getPerformImeAction$annotations", "CopyText", "getCopyText", "CutText", "getCutText", "PasteText", "getPasteText", "Expand", "getExpand", "Collapse", "getCollapse", "Dismiss", "getDismiss", "RequestFocus", "getRequestFocus", BuildConfig.FLAVOR, "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "CustomActions", "getCustomActions", "PageUp", "getPageUp", "PageLeft", "getPageLeft", "PageDown", "getPageDown", "PageRight", "getPageRight", "GetScrollViewportLength", "getGetScrollViewportLength", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsActions {
    public static final int $stable;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> ClearTextSubstitution;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Collapse;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CopyText;
    private static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CutText;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Dismiss;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Expand;
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<List<Float>, Boolean>>> GetScrollViewportLength;
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> GetTextLayoutResult;
    public static final SemanticsActions INSTANCE = new SemanticsActions();
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> InsertTextAtCursor;
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> OnAutofillText;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnClick;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnImeAction;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnLongClick;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageDown;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageLeft;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageRight;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageUp;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PasteText;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PerformImeAction;
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> RequestFocus;
    private static final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> ScrollBy;
    private static final SemanticsPropertyKey<Function2<Offset, Continuation<? super Offset>, Object>> ScrollByOffset;
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> ScrollToIndex;
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> SetProgress;
    private static final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> SetSelection;
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetText;
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetTextSubstitution;
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Boolean, Boolean>>> ShowTextSubstitution;

    static {
        SemanticsPropertiesKt$ActionPropertyKey$1 semanticsPropertiesKt$ActionPropertyKey$1 = new Function2<AccessibilityAction<Function<? extends Boolean>>, AccessibilityAction<Function<? extends Boolean>>, AccessibilityAction<Function<? extends Boolean>>>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1
            @Override // kotlin.jvm.functions.Function2
            public final AccessibilityAction<Function<? extends Boolean>> invoke(AccessibilityAction<Function<? extends Boolean>> accessibilityAction, AccessibilityAction<Function<? extends Boolean>> accessibilityAction2) {
                String label;
                Function<? extends Boolean> action;
                if (accessibilityAction == null || (label = accessibilityAction.getLabel()) == null) {
                    label = accessibilityAction2.getLabel();
                }
                if (accessibilityAction == null || (action = accessibilityAction.getAction()) == null) {
                    action = accessibilityAction2.getAction();
                }
                return new AccessibilityAction<>(label, action);
            }
        };
        GetTextLayoutResult = SemanticsPropertiesKt.AccessibilityKey("GetTextLayoutResult", semanticsPropertiesKt$ActionPropertyKey$1);
        OnClick = SemanticsPropertiesKt.AccessibilityKey("OnClick", semanticsPropertiesKt$ActionPropertyKey$1);
        OnLongClick = SemanticsPropertiesKt.AccessibilityKey("OnLongClick", semanticsPropertiesKt$ActionPropertyKey$1);
        ScrollBy = SemanticsPropertiesKt.AccessibilityKey("ScrollBy", semanticsPropertiesKt$ActionPropertyKey$1);
        ScrollByOffset = new SemanticsPropertyKey<>("ScrollByOffset", null, 2, null);
        ScrollToIndex = SemanticsPropertiesKt.AccessibilityKey("ScrollToIndex", semanticsPropertiesKt$ActionPropertyKey$1);
        OnAutofillText = SemanticsPropertiesKt.AccessibilityKey("OnAutofillText", semanticsPropertiesKt$ActionPropertyKey$1);
        SetProgress = SemanticsPropertiesKt.AccessibilityKey("SetProgress", semanticsPropertiesKt$ActionPropertyKey$1);
        SetSelection = SemanticsPropertiesKt.AccessibilityKey("SetSelection", semanticsPropertiesKt$ActionPropertyKey$1);
        SetText = SemanticsPropertiesKt.AccessibilityKey("SetText", semanticsPropertiesKt$ActionPropertyKey$1);
        SetTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("SetTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        ShowTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ShowTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        ClearTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ClearTextSubstitution", semanticsPropertiesKt$ActionPropertyKey$1);
        InsertTextAtCursor = SemanticsPropertiesKt.AccessibilityKey("InsertTextAtCursor", semanticsPropertiesKt$ActionPropertyKey$1);
        OnImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        PerformImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        CopyText = SemanticsPropertiesKt.AccessibilityKey("CopyText", semanticsPropertiesKt$ActionPropertyKey$1);
        CutText = SemanticsPropertiesKt.AccessibilityKey("CutText", semanticsPropertiesKt$ActionPropertyKey$1);
        PasteText = SemanticsPropertiesKt.AccessibilityKey("PasteText", semanticsPropertiesKt$ActionPropertyKey$1);
        Expand = SemanticsPropertiesKt.AccessibilityKey("Expand", semanticsPropertiesKt$ActionPropertyKey$1);
        Collapse = SemanticsPropertiesKt.AccessibilityKey("Collapse", semanticsPropertiesKt$ActionPropertyKey$1);
        Dismiss = SemanticsPropertiesKt.AccessibilityKey("Dismiss", semanticsPropertiesKt$ActionPropertyKey$1);
        RequestFocus = SemanticsPropertiesKt.AccessibilityKey("RequestFocus", semanticsPropertiesKt$ActionPropertyKey$1);
        CustomActions = SemanticsPropertiesKt.AccessibilityKey("CustomActions");
        PageUp = SemanticsPropertiesKt.AccessibilityKey("PageUp", semanticsPropertiesKt$ActionPropertyKey$1);
        PageLeft = SemanticsPropertiesKt.AccessibilityKey("PageLeft", semanticsPropertiesKt$ActionPropertyKey$1);
        PageDown = SemanticsPropertiesKt.AccessibilityKey("PageDown", semanticsPropertiesKt$ActionPropertyKey$1);
        PageRight = SemanticsPropertiesKt.AccessibilityKey("PageRight", semanticsPropertiesKt$ActionPropertyKey$1);
        GetScrollViewportLength = SemanticsPropertiesKt.AccessibilityKey("GetScrollViewportLength", semanticsPropertiesKt$ActionPropertyKey$1);
        $stable = 8;
    }

    private SemanticsActions() {
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getClearTextSubstitution() {
        return ClearTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCollapse() {
        return Collapse;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCopyText() {
        return CopyText;
    }

    public final SemanticsPropertyKey<List<CustomAccessibilityAction>> getCustomActions() {
        return CustomActions;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCutText() {
        return CutText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getDismiss() {
        return Dismiss;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getExpand() {
        return Expand;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<List<Float>, Boolean>>> getGetScrollViewportLength() {
        return GetScrollViewportLength;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getInsertTextAtCursor() {
        return InsertTextAtCursor;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnClick() {
        return OnClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnImeAction() {
        return OnImeAction;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnLongClick() {
        return OnLongClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageDown() {
        return PageDown;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageLeft() {
        return PageLeft;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageRight() {
        return PageRight;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageUp() {
        return PageUp;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPasteText() {
        return PasteText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getRequestFocus() {
        return RequestFocus;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> getScrollBy() {
        return ScrollBy;
    }

    public final SemanticsPropertyKey<Function2<Offset, Continuation<? super Offset>, Object>> getScrollByOffset() {
        return ScrollByOffset;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> getScrollToIndex() {
        return ScrollToIndex;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> getSetProgress() {
        return SetProgress;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> getSetSelection() {
        return SetSelection;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetText() {
        return SetText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetTextSubstitution() {
        return SetTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Boolean, Boolean>>> getShowTextSubstitution() {
        return ShowTextSubstitution;
    }
}
