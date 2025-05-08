package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b*\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0017R$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u001c8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", "failedCommand", BuildConfig.FLAVOR, "generateBatchErrorMessage", "(Ljava/util/List;Landroidx/compose/ui/text/input/EditCommand;)Ljava/lang/String;", "toStringForLog", "(Landroidx/compose/ui/text/input/EditCommand;)Ljava/lang/String;", "Landroidx/compose/ui/text/input/TextFieldValue;", "value", "Landroidx/compose/ui/text/input/TextInputSession;", "textInputSession", BuildConfig.FLAVOR, "reset", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextInputSession;)V", "apply", "(Ljava/util/List;)Landroidx/compose/ui/text/input/TextFieldValue;", "toTextFieldValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "<set-?>", "mBufferState", "Landroidx/compose/ui/text/input/TextFieldValue;", "getMBufferState$ui_text_release", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "getMBuffer$ui_text_release", "()Landroidx/compose/ui/text/input/EditingBuffer;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditProcessor {
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.INSTANCE.m2290getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getText(), this.mBufferState.getSelection(), null);

    private final String generateBatchErrorMessage(List<? extends EditCommand> editCommands, final EditCommand failedCommand) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m2372getCompositionMzsxiRA$ui_text_release() + ", selection=" + ((Object) TextRange.m2288toStringimpl(this.mBuffer.m2373getSelectiond9O1mEE$ui_text_release())) + "):");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        CollectionsKt.joinTo$default(editCommands, sb, "\n", null, null, 0, null, new Function1<EditCommand, CharSequence>() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(EditCommand editCommand) {
                String stringForLog;
                String str = EditCommand.this == editCommand ? " > " : "   ";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                stringForLog = this.toStringForLog(editCommand);
                sb2.append(stringForLog);
                return sb2.toString();
            }
        }, 60, null);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb.append(commitTextCommand.getText().length());
            sb.append(", newCursorPosition=");
            sb.append(commitTextCommand.getNewCursorPosition());
            sb.append(')');
            return sb.toString();
        }
        if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb2.append(setComposingTextCommand.getText().length());
            sb2.append(", newCursorPosition=");
            sb2.append(setComposingTextCommand.getNewCursorPosition());
            sb2.append(')');
            return sb2.toString();
        }
        if (!(editCommand instanceof SetComposingRegionCommand) && !(editCommand instanceof DeleteSurroundingTextCommand) && !(editCommand instanceof DeleteSurroundingTextInCodePointsCommand) && !(editCommand instanceof SetSelectionCommand) && !(editCommand instanceof FinishComposingTextCommand) && !(editCommand instanceof DeleteAllCommand)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknown EditCommand: ");
            String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "{anonymous EditCommand}";
            }
            sb3.append(simpleName);
            return sb3.toString();
        }
        return editCommand.toString();
    }

    public final TextFieldValue apply(List<? extends EditCommand> editCommands) {
        EditCommand editCommand;
        Exception e5;
        EditCommand editCommand2;
        try {
            int size = editCommands.size();
            int i5 = 0;
            editCommand = null;
            while (i5 < size) {
                try {
                    editCommand2 = editCommands.get(i5);
                } catch (Exception e6) {
                    e5 = e6;
                }
                try {
                    editCommand2.applyTo(this.mBuffer);
                    i5++;
                    editCommand = editCommand2;
                } catch (Exception e7) {
                    e5 = e7;
                    editCommand = editCommand2;
                    throw new RuntimeException(generateBatchErrorMessage(editCommands, editCommand), e5);
                }
            }
            AnnotatedString annotatedString$ui_text_release = this.mBuffer.toAnnotatedString$ui_text_release();
            long m2373getSelectiond9O1mEE$ui_text_release = this.mBuffer.m2373getSelectiond9O1mEE$ui_text_release();
            TextRange m2273boximpl = TextRange.m2273boximpl(m2373getSelectiond9O1mEE$ui_text_release);
            m2273boximpl.getPackedValue();
            TextRange textRange = TextRange.m2284getReversedimpl(this.mBufferState.getSelection()) ? null : m2273boximpl;
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString$ui_text_release, textRange != null ? textRange.getPackedValue() : TextRangeKt.TextRange(TextRange.m2282getMaximpl(m2373getSelectiond9O1mEE$ui_text_release), TextRange.m2283getMinimpl(m2373getSelectiond9O1mEE$ui_text_release)), this.mBuffer.m2372getCompositionMzsxiRA$ui_text_release(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e8) {
            editCommand = null;
            e5 = e8;
        }
    }

    public final void reset(TextFieldValue value, TextInputSession textInputSession) {
        boolean areEqual = Intrinsics.areEqual(value.getComposition(), this.mBuffer.m2372getCompositionMzsxiRA$ui_text_release());
        boolean z5 = true;
        boolean z6 = false;
        if (!Intrinsics.areEqual(this.mBufferState.getText(), value.getText())) {
            this.mBuffer = new EditingBuffer(value.getText(), value.getSelection(), null);
        } else if (TextRange.m2278equalsimpl0(this.mBufferState.getSelection(), value.getSelection())) {
            z5 = false;
        } else {
            this.mBuffer.setSelection$ui_text_release(TextRange.m2283getMinimpl(value.getSelection()), TextRange.m2282getMaximpl(value.getSelection()));
            z6 = true;
            z5 = false;
        }
        if (value.getComposition() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m2279getCollapsedimpl(value.getComposition().getPackedValue())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m2283getMinimpl(value.getComposition().getPackedValue()), TextRange.m2282getMaximpl(value.getComposition().getPackedValue()));
        }
        if (z5 || (!z6 && !areEqual)) {
            this.mBuffer.commitComposition$ui_text_release();
            value = TextFieldValue.m2424copy3r_uNRQ$default(value, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue = this.mBufferState;
        this.mBufferState = value;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue, value);
        }
    }

    /* renamed from: toTextFieldValue, reason: from getter */
    public final TextFieldValue getMBufferState() {
        return this.mBufferState;
    }
}
