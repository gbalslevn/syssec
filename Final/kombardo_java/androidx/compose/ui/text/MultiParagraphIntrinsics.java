package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR \u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R\u0014\u0010)\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "Landroidx/compose/ui/text/AnnotatedString;", "annotatedString", "Landroidx/compose/ui/text/TextStyle;", "style", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "Landroidx/compose/ui/text/ParagraphStyle;", "defaultStyle", "resolveTextDirection", "(Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/ParagraphStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "Landroidx/compose/ui/text/AnnotatedString;", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "Ljava/util/List;", "getPlaceholders", "()Ljava/util/List;", BuildConfig.FLAVOR, "minIntrinsicWidth$delegate", "Lkotlin/Lazy;", "getMinIntrinsicWidth", "()F", "minIntrinsicWidth", "maxIntrinsicWidth$delegate", "getMaxIntrinsicWidth", "maxIntrinsicWidth", "Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "infoList", "getInfoList$ui_text_release", BuildConfig.FLAVOR, "getHasStaleResolvedFonts", "()Z", "hasStaleResolvedFonts", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {
    private final AnnotatedString annotatedString;
    private final List<ParagraphIntrinsicInfo> infoList;

    /* renamed from: maxIntrinsicWidth$delegate, reason: from kotlin metadata */
    private final Lazy maxIntrinsicWidth;

    /* renamed from: minIntrinsicWidth$delegate, reason: from kotlin metadata */
    private final Lazy minIntrinsicWidth;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    public MultiParagraphIntrinsics(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, Density density, FontFamily.Resolver resolver) {
        AnnotatedString substringWithoutParagraphStyles;
        List localPlaceholders;
        this.annotatedString = annotatedString;
        this.placeholders = list;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.minIntrinsicWidth = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$minIntrinsicWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                ParagraphIntrinsicInfo paragraphIntrinsicInfo;
                ParagraphIntrinsics intrinsics;
                List<ParagraphIntrinsicInfo> infoList$ui_text_release = MultiParagraphIntrinsics.this.getInfoList$ui_text_release();
                if (infoList$ui_text_release.isEmpty()) {
                    paragraphIntrinsicInfo = null;
                } else {
                    ParagraphIntrinsicInfo paragraphIntrinsicInfo2 = infoList$ui_text_release.get(0);
                    float minIntrinsicWidth = paragraphIntrinsicInfo2.getIntrinsics().getMinIntrinsicWidth();
                    int lastIndex = CollectionsKt.getLastIndex(infoList$ui_text_release);
                    int i5 = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            ParagraphIntrinsicInfo paragraphIntrinsicInfo3 = infoList$ui_text_release.get(i5);
                            float minIntrinsicWidth2 = paragraphIntrinsicInfo3.getIntrinsics().getMinIntrinsicWidth();
                            if (Float.compare(minIntrinsicWidth, minIntrinsicWidth2) < 0) {
                                paragraphIntrinsicInfo2 = paragraphIntrinsicInfo3;
                                minIntrinsicWidth = minIntrinsicWidth2;
                            }
                            if (i5 == lastIndex) {
                                break;
                            }
                            i5++;
                        }
                    }
                    paragraphIntrinsicInfo = paragraphIntrinsicInfo2;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo4 = paragraphIntrinsicInfo;
                return Float.valueOf((paragraphIntrinsicInfo4 == null || (intrinsics = paragraphIntrinsicInfo4.getIntrinsics()) == null) ? 0.0f : intrinsics.getMinIntrinsicWidth());
            }
        });
        this.maxIntrinsicWidth = LazyKt.lazy(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$maxIntrinsicWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                ParagraphIntrinsicInfo paragraphIntrinsicInfo;
                ParagraphIntrinsics intrinsics;
                List<ParagraphIntrinsicInfo> infoList$ui_text_release = MultiParagraphIntrinsics.this.getInfoList$ui_text_release();
                if (infoList$ui_text_release.isEmpty()) {
                    paragraphIntrinsicInfo = null;
                } else {
                    ParagraphIntrinsicInfo paragraphIntrinsicInfo2 = infoList$ui_text_release.get(0);
                    float maxIntrinsicWidth = paragraphIntrinsicInfo2.getIntrinsics().getMaxIntrinsicWidth();
                    int lastIndex = CollectionsKt.getLastIndex(infoList$ui_text_release);
                    int i5 = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            ParagraphIntrinsicInfo paragraphIntrinsicInfo3 = infoList$ui_text_release.get(i5);
                            float maxIntrinsicWidth2 = paragraphIntrinsicInfo3.getIntrinsics().getMaxIntrinsicWidth();
                            if (Float.compare(maxIntrinsicWidth, maxIntrinsicWidth2) < 0) {
                                paragraphIntrinsicInfo2 = paragraphIntrinsicInfo3;
                                maxIntrinsicWidth = maxIntrinsicWidth2;
                            }
                            if (i5 == lastIndex) {
                                break;
                            }
                            i5++;
                        }
                    }
                    paragraphIntrinsicInfo = paragraphIntrinsicInfo2;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo4 = paragraphIntrinsicInfo;
                return Float.valueOf((paragraphIntrinsicInfo4 == null || (intrinsics = paragraphIntrinsicInfo4.getIntrinsics()) == null) ? 0.0f : intrinsics.getMaxIntrinsicWidth());
            }
        });
        ParagraphStyle paragraphStyle = textStyle.toParagraphStyle();
        List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles = AnnotatedStringKt.normalizedParagraphStyles(annotatedString, paragraphStyle);
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        int size = normalizedParagraphStyles.size();
        for (int i5 = 0; i5 < size; i5++) {
            AnnotatedString.Range<ParagraphStyle> range = normalizedParagraphStyles.get(i5);
            substringWithoutParagraphStyles = AnnotatedStringKt.substringWithoutParagraphStyles(annotatedString, range.getStart(), range.getEnd());
            ParagraphStyle resolveTextDirection = resolveTextDirection(range.getItem(), paragraphStyle);
            String text = substringWithoutParagraphStyles.getText();
            TextStyle merge = textStyle.merge(resolveTextDirection);
            List<AnnotatedString.Range<SpanStyle>> spanStyles = substringWithoutParagraphStyles.getSpanStyles();
            localPlaceholders = MultiParagraphIntrinsicsKt.getLocalPlaceholders(getPlaceholders(), range.getStart(), range.getEnd());
            arrayList.add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(text, merge, spanStyles, localPlaceholders, density, resolver), range.getStart(), range.getEnd()));
        }
        this.infoList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphStyle resolveTextDirection(ParagraphStyle style, ParagraphStyle defaultStyle) {
        ParagraphStyle m2233copyykzQM6k;
        if (!TextDirection.m2538equalsimpl0(style.getTextDirection(), TextDirection.INSTANCE.m2547getUnspecifieds_7Xco())) {
            return style;
        }
        m2233copyykzQM6k = style.m2233copyykzQM6k((r22 & 1) != 0 ? style.textAlign : 0, (r22 & 2) != 0 ? style.textDirection : defaultStyle.getTextDirection(), (r22 & 4) != 0 ? style.lineHeight : 0L, (r22 & 8) != 0 ? style.textIndent : null, (r22 & 16) != 0 ? style.platformStyle : null, (r22 & 32) != 0 ? style.lineHeightStyle : null, (r22 & 64) != 0 ? style.lineBreak : 0, (r22 & 128) != 0 ? style.hyphens : 0, (r22 & 256) != 0 ? style.textMotion : null);
        return m2233copyykzQM6k;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        List<ParagraphIntrinsicInfo> list = this.infoList;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (list.get(i5).getIntrinsics().getHasStaleResolvedFonts()) {
                return true;
            }
        }
        return false;
    }

    public final List<ParagraphIntrinsicInfo> getInfoList$ui_text_release() {
        return this.infoList;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth.getValue()).floatValue();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth.getValue()).floatValue();
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }
}
