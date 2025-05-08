package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", "Landroid/view/inputmethod/ExtractedText;", "toExtractedText", "(Landroidx/compose/ui/text/input/TextFieldValue;)Landroid/view/inputmethod/ExtractedText;", BuildConfig.FLAVOR, "DEBUG_CLASS", "Ljava/lang/String;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RecordingInputConnection_androidKt {
    private static final String DEBUG_CLASS = "RecordingInputConnection";

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExtractedText toExtractedText(TextFieldValue textFieldValue) {
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = textFieldValue.getText();
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = textFieldValue.getText().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.m2283getMinimpl(textFieldValue.getSelection());
        extractedText.selectionEnd = TextRange.m2282getMaximpl(textFieldValue.getSelection());
        extractedText.flags = !StringsKt.contains$default((CharSequence) textFieldValue.getText(), '\n', false, 2, (Object) null) ? 1 : 0;
        return extractedText;
    }
}
