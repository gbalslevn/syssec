package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.NonNullValueClassSaver;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007B#\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J.\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "J", "getText", "()Ljava/lang/String;", "copy", "copy-3r_uNRQ", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "(Ljava/lang/String;JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/ui/text/input/TextFieldValue;", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldValue {
    private static final Saver<TextFieldValue, Object> Saver = SaverKt.Saver(new Function2<SaverScope, TextFieldValue, Object>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextFieldValue textFieldValue) {
            return CollectionsKt.arrayListOf(SaversKt.save(textFieldValue.getText(), SaversKt.getAnnotatedStringSaver(), saverScope), SaversKt.save(TextRange.m2273boximpl(textFieldValue.getSelection()), SaversKt.getSaver(TextRange.INSTANCE), saverScope));
        }
    }, new Function1<Object, TextFieldValue>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextFieldValue invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver<AnnotatedString, Object> annotatedStringSaver = SaversKt.getAnnotatedStringSaver();
            Boolean bool = Boolean.FALSE;
            TextRange textRange = null;
            AnnotatedString restore = ((!Intrinsics.areEqual(obj2, bool) || (annotatedStringSaver instanceof NonNullValueClassSaver)) && obj2 != null) ? annotatedStringSaver.restore(obj2) : null;
            Intrinsics.checkNotNull(restore);
            Object obj3 = list.get(1);
            Saver<TextRange, Object> saver = SaversKt.getSaver(TextRange.INSTANCE);
            if ((!Intrinsics.areEqual(obj3, bool) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) {
                textRange = saver.restore(obj3);
            }
            Intrinsics.checkNotNull(textRange);
            return new TextFieldValue(restore, textRange.getPackedValue(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        }
    });

    /* renamed from: annotatedString, reason: from kotlin metadata and from toString */
    private final AnnotatedString text;
    private final TextRange composition;
    private final long selection;

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j5, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j5, textRange);
    }

    /* renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValue m2424copy3r_uNRQ$default(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j5, TextRange textRange, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            annotatedString = textFieldValue.text;
        }
        if ((i5 & 2) != 0) {
            j5 = textFieldValue.selection;
        }
        if ((i5 & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m2426copy3r_uNRQ(annotatedString, j5, textRange);
    }

    /* renamed from: copy-3r_uNRQ, reason: not valid java name */
    public final TextFieldValue m2426copy3r_uNRQ(AnnotatedString annotatedString, long selection, TextRange composition) {
        return new TextFieldValue(annotatedString, selection, composition, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) other;
        return TextRange.m2278equalsimpl0(this.selection, textFieldValue.selection) && Intrinsics.areEqual(this.composition, textFieldValue.composition) && Intrinsics.areEqual(this.text, textFieldValue.text);
    }

    /* renamed from: getAnnotatedString, reason: from getter */
    public final AnnotatedString getText() {
        return this.text;
    }

    /* renamed from: getComposition-MzsxiRA, reason: not valid java name and from getter */
    public final TextRange getComposition() {
        return this.composition;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    public final String getText() {
        return this.text.getText();
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + TextRange.m2286hashCodeimpl(this.selection)) * 31;
        TextRange textRange = this.composition;
        return hashCode + (textRange != null ? TextRange.m2286hashCodeimpl(textRange.getPackedValue()) : 0);
    }

    public String toString() {
        return "TextFieldValue(text='" + ((Object) this.text) + "', selection=" + ((Object) TextRange.m2288toStringimpl(this.selection)) + ", composition=" + this.composition + ')';
    }

    public /* synthetic */ TextFieldValue(String str, long j5, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j5, textRange);
    }

    /* renamed from: copy-3r_uNRQ, reason: not valid java name */
    public final TextFieldValue m2427copy3r_uNRQ(String text, long selection, TextRange composition) {
        DefaultConstructorMarker defaultConstructorMarker = null;
        return new TextFieldValue(new AnnotatedString(text, null, null, 6, defaultConstructorMarker), selection, composition, defaultConstructorMarker);
    }

    private TextFieldValue(AnnotatedString annotatedString, long j5, TextRange textRange) {
        this.text = annotatedString;
        this.selection = TextRangeKt.m2291coerceIn8ffj60Q(j5, 0, getText().length());
        this.composition = textRange != null ? TextRange.m2273boximpl(TextRangeKt.m2291coerceIn8ffj60Q(textRange.getPackedValue(), 0, getText().length())) : null;
    }

    /* renamed from: copy-3r_uNRQ$default, reason: not valid java name */
    public static /* synthetic */ TextFieldValue m2425copy3r_uNRQ$default(TextFieldValue textFieldValue, String str, long j5, TextRange textRange, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            j5 = textFieldValue.selection;
        }
        if ((i5 & 4) != 0) {
            textRange = textFieldValue.composition;
        }
        return textFieldValue.m2427copy3r_uNRQ(str, j5, textRange);
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j5, TextRange textRange, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, (i5 & 2) != 0 ? TextRange.INSTANCE.m2290getZerod9O1mEE() : j5, (i5 & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j5, TextRange textRange, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? TextRange.INSTANCE.m2290getZerod9O1mEE() : j5, (i5 & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TextFieldValue(String str, long j5, TextRange textRange) {
        this(new AnnotatedString(str, null, null, 6, r5), j5, textRange, r5);
        DefaultConstructorMarker defaultConstructorMarker = null;
    }
}
