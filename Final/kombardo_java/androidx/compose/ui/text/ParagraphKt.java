package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001ax\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a4\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0013\u0010\u001d\u001a\u00020\u0010*\u00020\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {BuildConfig.FLAVOR, "text", "Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "spanStyles", "Landroidx/compose/ui/text/Placeholder;", "placeholders", BuildConfig.FLAVOR, "maxLines", BuildConfig.FLAVOR, "ellipsis", "Landroidx/compose/ui/text/Paragraph;", "Paragraph-UdtVg6A", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Ljava/util/List;IZ)Landroidx/compose/ui/text/Paragraph;", "Paragraph", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "paragraphIntrinsics", "Paragraph-_EkL_-Y", "(Landroidx/compose/ui/text/ParagraphIntrinsics;JIZ)Landroidx/compose/ui/text/Paragraph;", BuildConfig.FLAVOR, "ceilToInt", "(F)I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ParagraphKt {
    /* renamed from: Paragraph-UdtVg6A, reason: not valid java name */
    public static final Paragraph m2229ParagraphUdtVg6A(String str, TextStyle textStyle, long j5, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i5, boolean z5) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m2437ActualParagraphO3s9Psw(str, textStyle, list, list2, i5, z5, j5, density, resolver);
    }

    /* renamed from: Paragraph-_EkL_-Y, reason: not valid java name */
    public static final Paragraph m2231Paragraph_EkL_Y(ParagraphIntrinsics paragraphIntrinsics, long j5, int i5, boolean z5) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.m2436ActualParagraphhBUhpc(paragraphIntrinsics, i5, z5, j5);
    }

    public static final int ceilToInt(float f5) {
        return (int) Math.ceil(f5);
    }
}
