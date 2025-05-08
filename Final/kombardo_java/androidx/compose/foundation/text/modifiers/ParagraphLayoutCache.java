package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphIntrinsicsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J \u0010#\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001dJ\u001d\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&JH\u0010)\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b/\u0010.J\u000f\u00100\u001a\u00020\u0002H\u0016¢\u0006\u0004\b0\u00101R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u00102R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u00103R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00104R\u001c\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\t\u00105R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00106R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00105R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00105R\u001c\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b8\u00109R.\u0010<\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:8\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bH\u00106\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR(\u0010N\u001a\u00020M8\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bN\u00109\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u001c\u0010Z\u001a\u00020\u00168\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bZ\u00109R\u0016\u0010[\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u00105R\u0016\u0010\\\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u00105R\u0014\u0010_\u001a\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006`"}, d2 = {"Landroidx/compose/foundation/text/modifiers/ParagraphLayoutCache;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "text", "Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", BuildConfig.FLAVOR, "softWrap", BuildConfig.FLAVOR, "maxLines", "minLines", "<init>", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/ParagraphIntrinsics;", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/text/Paragraph;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/Paragraph;", "layoutText", "newLayoutWillBeDifferent-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Z", "newLayoutWillBeDifferent", BuildConfig.FLAVOR, "markDirty", "()V", "layoutWithConstraints-K40F9xA", "layoutWithConstraints", "width", "intrinsicHeight", "(ILandroidx/compose/ui/unit/LayoutDirection;)I", "update-L6sJoHM", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;IZII)V", "update", "Landroidx/compose/ui/text/TextLayoutResult;", "slowCreateTextLayoutResultOrNull", "(Landroidx/compose/ui/text/TextStyle;)Landroidx/compose/ui/text/TextLayoutResult;", "minIntrinsicWidth", "(Landroidx/compose/ui/unit/LayoutDirection;)I", "maxIntrinsicWidth", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "I", "Z", "Landroidx/compose/foundation/text/modifiers/InlineDensity;", "lastDensity", "J", "Landroidx/compose/ui/unit/Density;", "value", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "getParagraph$foundation_release", "()Landroidx/compose/ui/text/Paragraph;", "setParagraph$foundation_release", "(Landroidx/compose/ui/text/Paragraph;)V", "didOverflow", "getDidOverflow$foundation_release", "()Z", "setDidOverflow$foundation_release", "(Z)V", "Landroidx/compose/ui/unit/IntSize;", "layoutSize", "getLayoutSize-YbymL2g$foundation_release", "()J", "setLayoutSize-ozmzZPI$foundation_release", "(J)V", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "mMinLinesConstrainer", "Landroidx/compose/foundation/text/modifiers/MinLinesConstrainer;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "prevConstraints", "cachedIntrinsicHeightInputWidth", "cachedIntrinsicHeight", "getObserveFontChanges$foundation_release", "()Lkotlin/Unit;", "observeFontChanges", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ParagraphLayoutCache {
    private int cachedIntrinsicHeight;
    private int cachedIntrinsicHeightInputWidth;
    private Density density;
    private boolean didOverflow;
    private FontFamily.Resolver fontFamilyResolver;
    private LayoutDirection intrinsicsLayoutDirection;
    private long lastDensity;
    private long layoutSize;
    private MinLinesConstrainer mMinLinesConstrainer;
    private int maxLines;
    private int minLines;
    private int overflow;
    private Paragraph paragraph;
    private ParagraphIntrinsics paragraphIntrinsics;
    private long prevConstraints;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    public /* synthetic */ ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i5, boolean z5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i5, z5, i6, i7);
    }

    /* renamed from: layoutText-K40F9xA, reason: not valid java name */
    private final Paragraph m612layoutTextK40F9xA(long constraints, LayoutDirection layoutDirection) {
        ParagraphIntrinsics layoutDirection2 = setLayoutDirection(layoutDirection);
        return ParagraphKt.m2231Paragraph_EkL_Y(layoutDirection2, LayoutUtilsKt.m603finalConstraintstfFHcEY(constraints, this.softWrap, this.overflow, layoutDirection2.getMaxIntrinsicWidth()), LayoutUtilsKt.m604finalMaxLinesxdlQI24(this.softWrap, this.overflow, this.maxLines), TextOverflow.m2560equalsimpl0(this.overflow, TextOverflow.INSTANCE.m2564getEllipsisgIe3tQ8()));
    }

    private final void markDirty() {
        this.paragraph = null;
        this.paragraphIntrinsics = null;
        this.intrinsicsLayoutDirection = null;
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
        this.prevConstraints = Constraints.INSTANCE.m2587fixedJhjzzOo(0, 0);
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.didOverflow = false;
    }

    /* renamed from: newLayoutWillBeDifferent-K40F9xA, reason: not valid java name */
    private final boolean m613newLayoutWillBeDifferentK40F9xA(long constraints, LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics;
        Paragraph paragraph = this.paragraph;
        if (paragraph == null || (paragraphIntrinsics = this.paragraphIntrinsics) == null || paragraphIntrinsics.getHasStaleResolvedFonts() || layoutDirection != this.intrinsicsLayoutDirection) {
            return true;
        }
        if (Constraints.m2572equalsimpl0(constraints, this.prevConstraints)) {
            return false;
        }
        return Constraints.m2578getMaxWidthimpl(constraints) != Constraints.m2578getMaxWidthimpl(this.prevConstraints) || ((float) Constraints.m2577getMaxHeightimpl(constraints)) < paragraph.getHeight() || paragraph.getDidExceedMaxLines();
    }

    private final ParagraphIntrinsics setLayoutDirection(LayoutDirection layoutDirection) {
        ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || paragraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            String str = this.text;
            TextStyle resolveDefaults = TextStyleKt.resolveDefaults(this.style, layoutDirection);
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            paragraphIntrinsics = ParagraphIntrinsicsKt.ParagraphIntrinsics$default(str, resolveDefaults, null, null, density, this.fontFamilyResolver, 12, null);
        }
        this.paragraphIntrinsics = paragraphIntrinsics;
        return paragraphIntrinsics;
    }

    /* renamed from: getDensity$foundation_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    /* renamed from: getDidOverflow$foundation_release, reason: from getter */
    public final boolean getDidOverflow() {
        return this.didOverflow;
    }

    /* renamed from: getLayoutSize-YbymL2g$foundation_release, reason: not valid java name and from getter */
    public final long getLayoutSize() {
        return this.layoutSize;
    }

    public final Unit getObserveFontChanges$foundation_release() {
        ParagraphIntrinsics paragraphIntrinsics = this.paragraphIntrinsics;
        if (paragraphIntrinsics != null) {
            paragraphIntrinsics.getHasStaleResolvedFonts();
        }
        return Unit.INSTANCE;
    }

    /* renamed from: getParagraph$foundation_release, reason: from getter */
    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    public final int intrinsicHeight(int width, LayoutDirection layoutDirection) {
        int i5 = this.cachedIntrinsicHeightInputWidth;
        int i6 = this.cachedIntrinsicHeight;
        if (width == i5 && i5 != -1) {
            return i6;
        }
        int ceilToIntPx = TextDelegateKt.ceilToIntPx(m612layoutTextK40F9xA(ConstraintsKt.Constraints(0, width, 0, Integer.MAX_VALUE), layoutDirection).getHeight());
        this.cachedIntrinsicHeightInputWidth = width;
        this.cachedIntrinsicHeight = ceilToIntPx;
        return ceilToIntPx;
    }

    /* renamed from: layoutWithConstraints-K40F9xA, reason: not valid java name */
    public final boolean m615layoutWithConstraintsK40F9xA(long constraints, LayoutDirection layoutDirection) {
        boolean z5 = true;
        if (this.minLines > 1) {
            MinLinesConstrainer.Companion companion = MinLinesConstrainer.INSTANCE;
            MinLinesConstrainer minLinesConstrainer = this.mMinLinesConstrainer;
            TextStyle textStyle = this.style;
            Density density = this.density;
            Intrinsics.checkNotNull(density);
            MinLinesConstrainer from = companion.from(minLinesConstrainer, layoutDirection, textStyle, density, this.fontFamilyResolver);
            this.mMinLinesConstrainer = from;
            constraints = from.m606coerceMinLinesOh53vG4$foundation_release(constraints, this.minLines);
        }
        boolean z6 = false;
        if (m613newLayoutWillBeDifferentK40F9xA(constraints, layoutDirection)) {
            Paragraph m612layoutTextK40F9xA = m612layoutTextK40F9xA(constraints, layoutDirection);
            this.prevConstraints = constraints;
            this.layoutSize = ConstraintsKt.m2590constrain4WqzIAM(constraints, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(m612layoutTextK40F9xA.getWidth()), TextDelegateKt.ceilToIntPx(m612layoutTextK40F9xA.getHeight())));
            if (!TextOverflow.m2560equalsimpl0(this.overflow, TextOverflow.INSTANCE.m2565getVisiblegIe3tQ8()) && (IntSize.m2661getWidthimpl(r9) < m612layoutTextK40F9xA.getWidth() || IntSize.m2660getHeightimpl(r9) < m612layoutTextK40F9xA.getHeight())) {
                z6 = true;
            }
            this.didOverflow = z6;
            this.paragraph = m612layoutTextK40F9xA;
            return true;
        }
        if (!Constraints.m2572equalsimpl0(constraints, this.prevConstraints)) {
            Paragraph paragraph = this.paragraph;
            Intrinsics.checkNotNull(paragraph);
            this.layoutSize = ConstraintsKt.m2590constrain4WqzIAM(constraints, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(Math.min(paragraph.getMaxIntrinsicWidth(), paragraph.getWidth())), TextDelegateKt.ceilToIntPx(paragraph.getHeight())));
            if (TextOverflow.m2560equalsimpl0(this.overflow, TextOverflow.INSTANCE.m2565getVisiblegIe3tQ8()) || (IntSize.m2661getWidthimpl(r3) >= paragraph.getWidth() && IntSize.m2660getHeightimpl(r3) >= paragraph.getHeight())) {
                z5 = false;
            }
            this.didOverflow = z5;
            this.prevConstraints = constraints;
        }
        return false;
    }

    public final int maxIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMaxIntrinsicWidth());
    }

    public final int minIntrinsicWidth(LayoutDirection layoutDirection) {
        return TextDelegateKt.ceilToIntPx(setLayoutDirection(layoutDirection).getMinIntrinsicWidth());
    }

    public final void setDensity$foundation_release(Density density) {
        Density density2 = this.density;
        long m597constructorimpl = density != null ? InlineDensity.m597constructorimpl(density) : InlineDensity.INSTANCE.m602getUnspecifiedL26CHvs();
        if (density2 == null) {
            this.density = density;
            this.lastDensity = m597constructorimpl;
        } else if (density == null || !InlineDensity.m598equalsimpl0(this.lastDensity, m597constructorimpl)) {
            this.density = density;
            this.lastDensity = m597constructorimpl;
            markDirty();
        }
    }

    public final TextLayoutResult slowCreateTextLayoutResultOrNull(TextStyle style) {
        Density density;
        LayoutDirection layoutDirection = this.intrinsicsLayoutDirection;
        if (layoutDirection == null || (density = this.density) == null) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.text, null, null, 6, null);
        if (this.paragraph == null || this.paragraphIntrinsics == null) {
            return null;
        }
        long m2570copyZbe2FdA$default = Constraints.m2570copyZbe2FdA$default(this.prevConstraints, 0, 0, 0, 0, 10, null);
        return new TextLayoutResult(new TextLayoutInput(annotatedString, style, CollectionsKt.emptyList(), this.maxLines, this.softWrap, this.overflow, density, layoutDirection, this.fontFamilyResolver, m2570copyZbe2FdA$default, (DefaultConstructorMarker) null), new MultiParagraph(new MultiParagraphIntrinsics(annotatedString, style, CollectionsKt.emptyList(), density, this.fontFamilyResolver), m2570copyZbe2FdA$default, this.maxLines, TextOverflow.m2560equalsimpl0(this.overflow, TextOverflow.INSTANCE.m2564getEllipsisgIe3tQ8()), null), this.layoutSize, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParagraphLayoutCache(paragraph=");
        sb.append(this.paragraph != null ? "<paragraph>" : "null");
        sb.append(", lastDensity=");
        sb.append((Object) InlineDensity.m601toStringimpl(this.lastDensity));
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: update-L6sJoHM, reason: not valid java name */
    public final void m616updateL6sJoHM(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int overflow, boolean softWrap, int maxLines, int minLines) {
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = overflow;
        this.softWrap = softWrap;
        this.maxLines = maxLines;
        this.minLines = minLines;
        markDirty();
    }

    private ParagraphLayoutCache(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i5, boolean z5, int i6, int i7) {
        this.text = str;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.overflow = i5;
        this.softWrap = z5;
        this.maxLines = i6;
        this.minLines = i7;
        this.lastDensity = InlineDensity.INSTANCE.m602getUnspecifiedL26CHvs();
        this.layoutSize = IntSizeKt.IntSize(0, 0);
        this.prevConstraints = Constraints.INSTANCE.m2587fixedJhjzzOo(0, 0);
        this.cachedIntrinsicHeightInputWidth = -1;
        this.cachedIntrinsicHeight = -1;
    }
}
