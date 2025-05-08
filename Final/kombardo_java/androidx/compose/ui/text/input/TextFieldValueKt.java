package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getTextAfterSelection", "maxChars", BuildConfig.FLAVOR, "getTextBeforeSelection", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldValueKt {
    public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
        return textFieldValue.getText().m2204subSequence5zctL8(textFieldValue.getSelection());
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int i5) {
        return textFieldValue.getText().subSequence(TextRange.m2282getMaximpl(textFieldValue.getSelection()), Math.min(TextRange.m2282getMaximpl(textFieldValue.getSelection()) + i5, textFieldValue.getText().length()));
    }

    public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int i5) {
        return textFieldValue.getText().subSequence(Math.max(0, TextRange.m2283getMinimpl(textFieldValue.getSelection()) - i5), TextRange.m2283getMinimpl(textFieldValue.getSelection()));
    }
}
