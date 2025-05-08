package androidx.compose.ui.text.input;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", BuildConfig.FLAVOR, "lengthBeforeCursor", "lengthAfterCursor", "<init>", "(II)V", "Landroidx/compose/ui/text/input/EditingBuffer;", "buffer", BuildConfig.FLAVOR, "applyTo", "(Landroidx/compose/ui/text/input/EditingBuffer;)V", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "I", "getLengthBeforeCursor", "getLengthAfterCursor", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i5, int i6) {
        this.lengthBeforeCursor = i5;
        this.lengthAfterCursor = i6;
        if (i5 < 0 || i6 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i5 + " and " + i6 + " respectively.").toString());
        }
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer buffer) {
        boolean isSurrogatePair;
        boolean isSurrogatePair2;
        int i5 = this.lengthBeforeCursor;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i7 < i5) {
                int i9 = i8 + 1;
                if (buffer.getSelectionStart() <= i9) {
                    i8 = buffer.getSelectionStart();
                    break;
                } else {
                    isSurrogatePair2 = EditCommandKt.isSurrogatePair(buffer.get$ui_text_release((buffer.getSelectionStart() - i9) - 1), buffer.get$ui_text_release(buffer.getSelectionStart() - i9));
                    i8 = isSurrogatePair2 ? i8 + 2 : i9;
                    i7++;
                }
            } else {
                break;
            }
        }
        int i10 = this.lengthAfterCursor;
        int i11 = 0;
        while (true) {
            if (i6 >= i10) {
                break;
            }
            int i12 = i11 + 1;
            if (buffer.getSelectionEnd() + i12 >= buffer.getLength$ui_text_release()) {
                i11 = buffer.getLength$ui_text_release() - buffer.getSelectionEnd();
                break;
            } else {
                isSurrogatePair = EditCommandKt.isSurrogatePair(buffer.get$ui_text_release((buffer.getSelectionEnd() + i12) - 1), buffer.get$ui_text_release(buffer.getSelectionEnd() + i12));
                i11 = isSurrogatePair ? i11 + 2 : i12;
                i6++;
            }
        }
        buffer.delete$ui_text_release(buffer.getSelectionEnd(), buffer.getSelectionEnd() + i11);
        buffer.delete$ui_text_release(buffer.getSelectionStart() - i8, buffer.getSelectionStart());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) other;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}
