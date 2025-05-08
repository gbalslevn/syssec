package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002\u001a \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u001e\u0010\u0012\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007H\u0001\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0014"}, d2 = {"ValidatingEmptyOffsetMappingIdentity", "Landroidx/compose/ui/text/input/OffsetMapping;", "getValidatingEmptyOffsetMappingIdentity", "()Landroidx/compose/ui/text/input/OffsetMapping;", "validateOriginalToTransformed", BuildConfig.FLAVOR, "transformedOffset", BuildConfig.FLAVOR, "transformedLength", "offset", "validateTransformedToOriginal", "originalOffset", "originalLength", "filterWithValidation", "Landroidx/compose/ui/text/input/TransformedText;", "Landroidx/compose/ui/text/input/VisualTransformation;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "throwIfNotValidTransform", "limit", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ValidatingOffsetMappingKt {
    private static final OffsetMapping ValidatingEmptyOffsetMappingIdentity = new ValidatingOffsetMapping(OffsetMapping.INSTANCE.getIdentity(), 0, 0);

    public static final TransformedText filterWithValidation(VisualTransformation visualTransformation, AnnotatedString annotatedString) {
        TransformedText filter = visualTransformation.filter(annotatedString);
        throwIfNotValidTransform$default(filter, annotatedString.length(), 0, 2, null);
        return new TransformedText(filter.getText(), new ValidatingOffsetMapping(filter.getOffsetMapping(), annotatedString.length(), filter.getText().length()));
    }

    public static final OffsetMapping getValidatingEmptyOffsetMappingIdentity() {
        return ValidatingEmptyOffsetMappingIdentity;
    }

    public static final void throwIfNotValidTransform(TransformedText transformedText, int i5, int i6) {
        int length = transformedText.getText().length();
        int min = Math.min(i5, i6);
        for (int i7 = 0; i7 < min; i7++) {
            validateOriginalToTransformed(transformedText.getOffsetMapping().originalToTransformed(i7), length, i7);
        }
        validateOriginalToTransformed(transformedText.getOffsetMapping().originalToTransformed(i5), length, i5);
        int min2 = Math.min(length, i6);
        for (int i8 = 0; i8 < min2; i8++) {
            validateTransformedToOriginal(transformedText.getOffsetMapping().transformedToOriginal(i8), i5, i8);
        }
        validateTransformedToOriginal(transformedText.getOffsetMapping().transformedToOriginal(length), i5, length);
    }

    public static /* synthetic */ void throwIfNotValidTransform$default(TransformedText transformedText, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 100;
        }
        throwIfNotValidTransform(transformedText, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateOriginalToTransformed(int i5, int i6, int i7) {
        if (i5 < 0 || i5 > i6) {
            throw new IllegalStateException(("OffsetMapping.originalToTransformed returned invalid mapping: " + i7 + " -> " + i5 + " is not in range of transformed text [0, " + i6 + ']').toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateTransformedToOriginal(int i5, int i6, int i7) {
        if (i5 < 0 || i5 > i6) {
            throw new IllegalStateException(("OffsetMapping.transformedToOriginal returned invalid mapping: " + i7 + " -> " + i5 + " is not in range of original text [0, " + i6 + ']').toString());
        }
    }
}
