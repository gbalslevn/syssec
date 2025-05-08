package dk.molslinjen.ui.views.reusable.input.transformations;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import dk.molslinjen.domain.extensions.StringBuilderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/transformations/AddSpacesVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "subStringSegmentLength", BuildConfig.FLAVOR, "<init>", "(I)V", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddSpacesVisualTransformation implements VisualTransformation {
    private final int subStringSegmentLength;

    public AddSpacesVisualTransformation(int i5) {
        this.subStringSegmentLength = i5;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TransformedText(new AnnotatedString(StringBuilderKt.spacedString(new StringBuilder(), text.getText(), this.subStringSegmentLength), null, null, 6, null), new OffsetMapping() { // from class: dk.molslinjen.ui.views.reusable.input.transformations.AddSpacesVisualTransformation$filter$1
            private final int numberOfSpaces(int offset) {
                int i5;
                i5 = AddSpacesVisualTransformation.this.subStringSegmentLength;
                return (offset - 1) / i5;
            }

            @Override // androidx.compose.ui.text.input.OffsetMapping
            public int originalToTransformed(int offset) {
                return offset + numberOfSpaces(offset);
            }

            @Override // androidx.compose.ui.text.input.OffsetMapping
            public int transformedToOriginal(int offset) {
                return offset - numberOfSpaces(offset);
            }
        });
    }
}
