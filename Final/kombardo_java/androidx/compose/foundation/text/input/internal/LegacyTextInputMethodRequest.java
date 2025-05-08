package androidx.compose.foundation.text.input.internal;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJU\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\u000e¢\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J5\u0010/\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$¢\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00104R(\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00060\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00105R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00105R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R$\u0010@\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010DR\"\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0F0E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR$\u0010P\u001a\u0004\u0018\u00010O8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006Y"}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyTextInputMethodRequest;", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "Landroid/view/View;", "view", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", BuildConfig.FLAVOR, "localToScreen", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "inputMethodManager", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "restartInputImmediately", "()V", "Landroidx/compose/ui/text/input/TextFieldValue;", "value", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;", "textInputNode", "Landroidx/compose/ui/text/input/ImeOptions;", "imeOptions", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/input/EditCommand;", "onEditCommand", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed", "startInput", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter$LegacyPlatformTextInputNode;Landroidx/compose/ui/text/input/ImeOptions;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Landroid/view/inputmethod/EditorInfo;", "outAttributes", "Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "createInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "oldValue", "newValue", "updateState", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;)V", "Landroidx/compose/ui/geometry/Rect;", "rect", "notifyFocusedRect", "(Landroidx/compose/ui/geometry/Rect;)V", "textFieldValue", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "innerTextFieldBounds", "decorationBoxBounds", "updateTextLayoutResult", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "<set-?>", "state", "Landroidx/compose/ui/text/input/TextFieldValue;", "getState", "()Landroidx/compose/ui/text/input/TextFieldValue;", "Landroidx/compose/ui/text/input/ImeOptions;", BuildConfig.FLAVOR, "Ljava/lang/ref/WeakReference;", "ics", "Ljava/util/List;", "Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection", "Landroid/graphics/Rect;", "focusedRect", "Landroid/graphics/Rect;", "getFocusedRect$foundation_release", "()Landroid/graphics/Rect;", "setFocusedRect$foundation_release", "(Landroid/graphics/Rect;)V", "Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "cursorAnchorInfoController", "Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LegacyTextInputMethodRequest implements PlatformTextInputMethodRequest {
    private final LegacyCursorAnchorInfoController cursorAnchorInfoController;
    private Rect focusedRect;
    private final InputMethodManager inputMethodManager;
    private LegacyTextFieldState legacyTextFieldState;
    private TextFieldSelectionManager textFieldSelectionManager;
    private final View view;
    private ViewConfiguration viewConfiguration;
    private Function1<? super List<? extends EditCommand>, Unit> onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$onEditCommand$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends EditCommand> list) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends EditCommand> list) {
            invoke2(list);
            return Unit.INSTANCE;
        }
    };
    private Function1<? super ImeAction, Unit> onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$onImeActionPerformed$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
            m593invokeKlQnJC8(imeAction.getValue());
            return Unit.INSTANCE;
        }

        /* renamed from: invoke-KlQnJC8, reason: not valid java name */
        public final void m593invokeKlQnJC8(int i5) {
        }
    };
    private TextFieldValue state = new TextFieldValue(BuildConfig.FLAVOR, TextRange.INSTANCE.m2290getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
    private ImeOptions imeOptions = ImeOptions.INSTANCE.getDefault();
    private List<WeakReference<RecordingInputConnection>> ics = new ArrayList();

    /* renamed from: baseInputConnection$delegate, reason: from kotlin metadata */
    private final Lazy baseInputConnection = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<BaseInputConnection>() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$baseInputConnection$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BaseInputConnection invoke() {
            return new BaseInputConnection(LegacyTextInputMethodRequest.this.getView(), false);
        }
    });

    public LegacyTextInputMethodRequest(View view, Function1<? super Matrix, Unit> function1, InputMethodManager inputMethodManager) {
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.cursorAnchorInfoController = new LegacyCursorAnchorInfoController(function1, inputMethodManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection.getValue();
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    public final View getView() {
        return this.view;
    }

    public final void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (!this.ics.isEmpty() || (rect2 = this.focusedRect) == null) {
            return;
        }
        this.view.requestRectangleOnScreen(new Rect(rect2));
    }

    public final void startInput(TextFieldValue value, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode textInputNode, ImeOptions imeOptions, Function1<? super List<? extends EditCommand>, Unit> onEditCommand, Function1<? super ImeAction, Unit> onImeActionPerformed) {
        this.state = value;
        this.imeOptions = imeOptions;
        this.onEditCommand = onEditCommand;
        this.onImeActionPerformed = onImeActionPerformed;
        this.legacyTextFieldState = textInputNode != null ? textInputNode.getLegacyTextFieldState() : null;
        this.textFieldSelectionManager = textInputNode != null ? textInputNode.getTextFieldSelectionManager() : null;
        this.viewConfiguration = textInputNode != null ? textInputNode.getViewConfiguration() : null;
    }

    public final void updateState(TextFieldValue oldValue, TextFieldValue newValue) {
        boolean z5 = (TextRange.m2278equalsimpl0(this.state.getSelection(), newValue.getSelection()) && Intrinsics.areEqual(this.state.getComposition(), newValue.getComposition())) ? false : true;
        this.state = newValue;
        int size = this.ics.size();
        for (int i5 = 0; i5 < size; i5++) {
            RecordingInputConnection recordingInputConnection = this.ics.get(i5).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setTextFieldValue$foundation_release(newValue);
            }
        }
        this.cursorAnchorInfoController.invalidate();
        if (Intrinsics.areEqual(oldValue, newValue)) {
            if (z5) {
                InputMethodManager inputMethodManager = this.inputMethodManager;
                int m2283getMinimpl = TextRange.m2283getMinimpl(newValue.getSelection());
                int m2282getMaximpl = TextRange.m2282getMaximpl(newValue.getSelection());
                TextRange composition = this.state.getComposition();
                int m2283getMinimpl2 = composition != null ? TextRange.m2283getMinimpl(composition.getPackedValue()) : -1;
                TextRange composition2 = this.state.getComposition();
                inputMethodManager.updateSelection(m2283getMinimpl, m2282getMaximpl, m2283getMinimpl2, composition2 != null ? TextRange.m2282getMaximpl(composition2.getPackedValue()) : -1);
                return;
            }
            return;
        }
        if (oldValue != null && (!Intrinsics.areEqual(oldValue.getText(), newValue.getText()) || (TextRange.m2278equalsimpl0(oldValue.getSelection(), newValue.getSelection()) && !Intrinsics.areEqual(oldValue.getComposition(), newValue.getComposition())))) {
            restartInputImmediately();
            return;
        }
        int size2 = this.ics.size();
        for (int i6 = 0; i6 < size2; i6++) {
            RecordingInputConnection recordingInputConnection2 = this.ics.get(i6).get();
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
            }
        }
    }

    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, androidx.compose.ui.geometry.Rect innerTextFieldBounds, androidx.compose.ui.geometry.Rect decorationBoxBounds) {
        this.cursorAnchorInfoController.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, innerTextFieldBounds, decorationBoxBounds);
    }

    @Override // androidx.compose.ui.platform.PlatformTextInputMethodRequest
    public RecordingInputConnection createInputConnection(EditorInfo outAttributes) {
        EditorInfo_androidKt.m566updatepLxbY9I$default(outAttributes, this.state.getText(), this.state.getSelection(), this.imeOptions, null, 8, null);
        LegacyPlatformTextInputServiceAdapter_androidKt.access$updateWithEmojiCompat(outAttributes);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new InputEventCallback2() { // from class: androidx.compose.foundation.text.input.internal.LegacyTextInputMethodRequest$createInputConnection$1
            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onConnectionClosed(RecordingInputConnection inputConnection) {
                List list;
                List list2;
                List list3;
                list = LegacyTextInputMethodRequest.this.ics;
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    list2 = LegacyTextInputMethodRequest.this.ics;
                    if (Intrinsics.areEqual(((WeakReference) list2.get(i5)).get(), inputConnection)) {
                        list3 = LegacyTextInputMethodRequest.this.ics;
                        list3.remove(i5);
                        return;
                    }
                }
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onEditCommands(List<? extends EditCommand> editCommands) {
                Function1 function1;
                function1 = LegacyTextInputMethodRequest.this.onEditCommand;
                function1.invoke(editCommands);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            /* renamed from: onImeAction-KlQnJC8 */
            public void mo592onImeActionKlQnJC8(int imeAction) {
                Function1 function1;
                function1 = LegacyTextInputMethodRequest.this.onImeActionPerformed;
                function1.invoke(ImeAction.m2375boximpl(imeAction));
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onKeyEvent(KeyEvent event) {
                BaseInputConnection baseInputConnection;
                baseInputConnection = LegacyTextInputMethodRequest.this.getBaseInputConnection();
                baseInputConnection.sendKeyEvent(event);
            }

            @Override // androidx.compose.foundation.text.input.internal.InputEventCallback2
            public void onRequestCursorAnchorInfo(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
                LegacyCursorAnchorInfoController legacyCursorAnchorInfoController;
                legacyCursorAnchorInfoController = LegacyTextInputMethodRequest.this.cursorAnchorInfoController;
                legacyCursorAnchorInfoController.requestUpdate(immediate, monitor, includeInsertionMarker, includeCharacterBounds, includeEditorBounds, includeLineBounds);
            }
        }, this.imeOptions.getAutoCorrect(), this.legacyTextFieldState, this.textFieldSelectionManager, this.viewConfiguration);
        this.ics.add(new WeakReference<>(recordingInputConnection));
        return recordingInputConnection;
    }
}
