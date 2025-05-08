package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 :2\u00020\u0001:\u00039:;B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\u0002\u0010\nBY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0096\u0002J\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\"\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J*\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\"\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J$\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0007J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000J\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\u001e\u0010.\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\b\u0010/\u001a\u00020\u0013H\u0016J\u0011\u00100\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002J\u0018\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u000203ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0018\u00101\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u0013H\u0016J\b\u00108\u001a\u00020\u0003H\u0016R$\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011R\"\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\"\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "spanStyles", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "spanStylesOrNull", "paragraphStylesOrNull", "annotations", BuildConfig.FLAVOR, "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnnotations$ui_text_release", "()Ljava/util/List;", "length", BuildConfig.FLAVOR, "getLength", "()I", "getParagraphStyles", "getParagraphStylesOrNull$ui_text_release", "getSpanStyles", "getSpanStylesOrNull$ui_text_release", "getText", "()Ljava/lang/String;", "equals", BuildConfig.FLAVOR, "other", "get", BuildConfig.FLAVOR, "index", "getLinkAnnotations", "Landroidx/compose/ui/text/LinkAnnotation;", "start", "end", "getStringAnnotations", "tag", "getTtsAnnotations", "Landroidx/compose/ui/text/TtsAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/UrlAnnotation;", "hasEqualAnnotations", "hasLinkAnnotations", "hasStringAnnotations", "hashCode", "plus", "subSequence", "range", "Landroidx/compose/ui/text/TextRange;", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "startIndex", "endIndex", "toString", "Builder", "Companion", "Range", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnnotatedString implements CharSequence {
    private static final Saver<AnnotatedString, ?> Saver = SaversKt.getAnnotatedStringSaver();
    private final List<Range<? extends Object>> annotations;
    private final List<Range<ParagraphStyle>> paragraphStylesOrNull;
    private final List<Range<SpanStyle>> spanStylesOrNull;
    private final String text;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u00013B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\f\u0010\u000fJ)\u0010\f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0012J\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\f\u0010\u0015J\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\tJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u0016J%\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001cJ-\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u0015\u0010#\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0003¢\u0006\u0004\b#\u0010\u0006J\r\u0010&\u001a\u00020\u0007¢\u0006\u0004\b&\u0010'R\u0018\u0010\b\u001a\u00060(j\u0002`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010*R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.R\"\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002000,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010.R\"\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002000,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010.¨\u00064"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", BuildConfig.FLAVOR, "capacity", "<init>", "(I)V", "Landroidx/compose/ui/text/AnnotatedString;", "text", "(Landroidx/compose/ui/text/AnnotatedString;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "append", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "(Ljava/lang/CharSequence;)Landroidx/compose/ui/text/AnnotatedString$Builder;", "start", "end", "(Ljava/lang/CharSequence;II)Landroidx/compose/ui/text/AnnotatedString$Builder;", BuildConfig.FLAVOR, "char", "(C)Landroidx/compose/ui/text/AnnotatedString$Builder;", "(Landroidx/compose/ui/text/AnnotatedString;II)V", "Landroidx/compose/ui/text/SpanStyle;", "style", "addStyle", "(Landroidx/compose/ui/text/SpanStyle;II)V", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/ParagraphStyle;II)V", "tag", "annotation", "addStringAnnotation", "(Ljava/lang/String;Ljava/lang/String;II)V", "pushStyle", "(Landroidx/compose/ui/text/SpanStyle;)I", "pop", "()V", "index", "toAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "spanStyles", "Ljava/util/List;", "paragraphStyles", BuildConfig.FLAVOR, "annotations", "styleStack", "MutableRange", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder implements Appendable {
        private final List<MutableRange<? extends Object>> annotations;
        private final List<MutableRange<ParagraphStyle>> paragraphStyles;
        private final List<MutableRange<SpanStyle>> spanStyles;
        private final List<MutableRange<? extends Object>> styleStack;
        private final StringBuilder text;

        public Builder(int i5) {
            this.text = new StringBuilder(i5);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public final void addStringAnnotation(String tag, String annotation, int start, int end) {
            this.annotations.add(new MutableRange<>(annotation, start, end, tag));
        }

        public final void addStyle(SpanStyle style, int start, int end) {
            this.spanStyles.add(new MutableRange<>(style, start, end, null, 8, null));
        }

        public final void pop() {
            if (!this.styleStack.isEmpty()) {
                this.styleStack.remove(r0.size() - 1).setEnd(this.text.length());
                return;
            }
            throw new IllegalStateException("Nothing to pop.");
        }

        public final int pushStyle(SpanStyle style) {
            MutableRange<SpanStyle> mutableRange = new MutableRange<>(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final AnnotatedString toAnnotatedString() {
            String sb = this.text.toString();
            List<MutableRange<SpanStyle>> list = this.spanStyles;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.add(list.get(i5).toRange(this.text.length()));
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            List<MutableRange<ParagraphStyle>> list2 = this.paragraphStyles;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                arrayList2.add(list2.get(i6).toRange(this.text.length()));
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            List<MutableRange<? extends Object>> list3 = this.annotations;
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size3 = list3.size();
            for (int i7 = 0; i7 < size3; i7++) {
                arrayList3.add(list3.get(i7).toRange(this.text.length()));
            }
            return new AnnotatedString(sb, arrayList, arrayList2, arrayList3.isEmpty() ? null : arrayList3);
        }

        public final void addStyle(ParagraphStyle style, int start, int end) {
            this.paragraphStyles.add(new MutableRange<>(style, start, end, null, 8, null));
        }

        public final void append(String text) {
            this.text.append(text);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "T", BuildConfig.FLAVOR, "item", BuildConfig.FLAVOR, "start", "end", BuildConfig.FLAVOR, "tag", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "defaultEnd", "Landroidx/compose/ui/text/AnnotatedString$Range;", "toRange", "(I)Landroidx/compose/ui/text/AnnotatedString$Range;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getItem", "()Ljava/lang/Object;", "I", "getStart", "getEnd", "setEnd", "(I)V", "Ljava/lang/String;", "getTag", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final /* data */ class MutableRange<T> {
            private int end;
            private final T item;
            private final int start;
            private final String tag;

            public MutableRange(T t5, int i5, int i6, String str) {
                this.item = t5;
                this.start = i5;
                this.end = i6;
                this.tag = str;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) other;
                return Intrinsics.areEqual(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual(this.tag, mutableRange.tag);
            }

            public int hashCode() {
                T t5 = this.item;
                return ((((((t5 == null ? 0 : t5.hashCode()) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + this.tag.hashCode();
            }

            public final void setEnd(int i5) {
                this.end = i5;
            }

            public final Range<T> toRange(int defaultEnd) {
                int i5 = this.end;
                if (i5 != Integer.MIN_VALUE) {
                    defaultEnd = i5;
                }
                if (defaultEnd != Integer.MIN_VALUE) {
                    return new Range<>(this.item, this.start, defaultEnd, this.tag);
                }
                throw new IllegalStateException("Item.end should be set first");
            }

            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }

            public /* synthetic */ MutableRange(Object obj, int i5, int i6, String str, int i7, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i5, (i7 & 4) != 0 ? Integer.MIN_VALUE : i6, (i7 & 8) != 0 ? BuildConfig.FLAVOR : str);
            }
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence text) {
            if (text instanceof AnnotatedString) {
                append((AnnotatedString) text);
            } else {
                this.text.append(text);
            }
            return this;
        }

        public final void pop(int index) {
            if (index < this.styleStack.size()) {
                while (this.styleStack.size() - 1 >= index) {
                    pop();
                }
            } else {
                throw new IllegalStateException((index + " should be less than " + this.styleStack.size()).toString());
            }
        }

        public /* synthetic */ Builder(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? 16 : i5);
        }

        public Builder(AnnotatedString annotatedString) {
            this(0, 1, null);
            append(annotatedString);
        }

        @Override // java.lang.Appendable
        public Builder append(CharSequence text, int start, int end) {
            if (text instanceof AnnotatedString) {
                append((AnnotatedString) text, start, end);
            } else {
                this.text.append(text, start, end);
            }
            return this;
        }

        @Override // java.lang.Appendable
        public Builder append(char r22) {
            this.text.append(r22);
            return this;
        }

        public final void append(AnnotatedString text) {
            int length = this.text.length();
            this.text.append(text.getText());
            List<Range<SpanStyle>> spanStylesOrNull$ui_text_release = text.getSpanStylesOrNull$ui_text_release();
            if (spanStylesOrNull$ui_text_release != null) {
                int size = spanStylesOrNull$ui_text_release.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Range<SpanStyle> range = spanStylesOrNull$ui_text_release.get(i5);
                    addStyle(range.getItem(), range.getStart() + length, range.getEnd() + length);
                }
            }
            List<Range<ParagraphStyle>> paragraphStylesOrNull$ui_text_release = text.getParagraphStylesOrNull$ui_text_release();
            if (paragraphStylesOrNull$ui_text_release != null) {
                int size2 = paragraphStylesOrNull$ui_text_release.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    Range<ParagraphStyle> range2 = paragraphStylesOrNull$ui_text_release.get(i6);
                    addStyle(range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
                }
            }
            List<Range<? extends Object>> annotations$ui_text_release = text.getAnnotations$ui_text_release();
            if (annotations$ui_text_release != null) {
                int size3 = annotations$ui_text_release.size();
                for (int i7 = 0; i7 < size3; i7++) {
                    Range<? extends Object> range3 = annotations$ui_text_release.get(i7);
                    this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
                }
            }
        }

        public final void append(AnnotatedString text, int start, int end) {
            int length = this.text.length();
            this.text.append((CharSequence) text.getText(), start, end);
            List access$getLocalSpanStyles = AnnotatedStringKt.access$getLocalSpanStyles(text, start, end);
            if (access$getLocalSpanStyles != null) {
                int size = access$getLocalSpanStyles.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Range range = (Range) access$getLocalSpanStyles.get(i5);
                    addStyle((SpanStyle) range.getItem(), range.getStart() + length, range.getEnd() + length);
                }
            }
            List access$getLocalParagraphStyles = AnnotatedStringKt.access$getLocalParagraphStyles(text, start, end);
            if (access$getLocalParagraphStyles != null) {
                int size2 = access$getLocalParagraphStyles.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    Range range2 = (Range) access$getLocalParagraphStyles.get(i6);
                    addStyle((ParagraphStyle) range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
                }
            }
            List access$getLocalAnnotations = AnnotatedStringKt.access$getLocalAnnotations(text, start, end);
            if (access$getLocalAnnotations != null) {
                int size3 = access$getLocalAnnotations.size();
                for (int i7 = 0; i7 < size3; i7++) {
                    Range range3 = (Range) access$getLocalAnnotations.get(i7);
                    this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(String str, List<Range<SpanStyle>> list, List<Range<ParagraphStyle>> list2, List<? extends Range<? extends Object>> list3) {
        List sortedWith;
        this.text = str;
        this.spanStylesOrNull = list;
        this.paragraphStylesOrNull = list2;
        this.annotations = list3;
        if (list2 == null || (sortedWith = CollectionsKt.sortedWith(list2, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues(Integer.valueOf(((AnnotatedString.Range) t5).getStart()), Integer.valueOf(((AnnotatedString.Range) t6).getStart()));
            }
        })) == null) {
            return;
        }
        int size = sortedWith.size();
        int i5 = -1;
        for (int i6 = 0; i6 < size; i6++) {
            Range range = (Range) sortedWith.get(i6);
            if (range.getStart() >= i5) {
                if (range.getEnd() <= this.text.length()) {
                    i5 = range.getEnd();
                } else {
                    throw new IllegalArgumentException(("ParagraphStyle range [" + range.getStart() + ", " + range.getEnd() + ") is out of boundary").toString());
                }
            } else {
                throw new IllegalArgumentException("ParagraphStyle should not overlap");
            }
        }
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i5) {
        return get(i5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) other;
        return Intrinsics.areEqual(this.text, annotatedString.text) && Intrinsics.areEqual(this.spanStylesOrNull, annotatedString.spanStylesOrNull) && Intrinsics.areEqual(this.paragraphStylesOrNull, annotatedString.paragraphStylesOrNull) && Intrinsics.areEqual(this.annotations, annotatedString.annotations);
    }

    public char get(int index) {
        return this.text.charAt(index);
    }

    public final List<Range<? extends Object>> getAnnotations$ui_text_release() {
        return this.annotations;
    }

    public int getLength() {
        return this.text.length();
    }

    public final List<Range<LinkAnnotation>> getLinkAnnotations(int start, int end) {
        List emptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            emptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Range<? extends Object> range = list.get(i5);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof LinkAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    emptyList.add(range);
                }
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(emptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return emptyList;
    }

    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        List<Range<ParagraphStyle>> list = this.paragraphStylesOrNull;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<Range<ParagraphStyle>> getParagraphStylesOrNull$ui_text_release() {
        return this.paragraphStylesOrNull;
    }

    public final List<Range<SpanStyle>> getSpanStyles() {
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List<Range<SpanStyle>> getSpanStylesOrNull$ui_text_release() {
        return this.spanStylesOrNull;
    }

    public final List<Range<String>> getStringAnnotations(String tag, int start, int end) {
        List emptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            emptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Range<? extends Object> range = list.get(i5);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof String) && Intrinsics.areEqual(tag, range2.getTag()) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    emptyList.add(range);
                }
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(emptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>");
        return emptyList;
    }

    public final String getText() {
        return this.text;
    }

    public final List<Range<TtsAnnotation>> getTtsAnnotations(int start, int end) {
        List emptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            emptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Range<? extends Object> range = list.get(i5);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof TtsAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    emptyList.add(range);
                }
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(emptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return emptyList;
    }

    @Deprecated
    public final List<Range<UrlAnnotation>> getUrlAnnotations(int start, int end) {
        List emptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            emptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Range<? extends Object> range = list.get(i5);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof UrlAnnotation) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    emptyList.add(range);
                }
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(emptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return emptyList;
    }

    public final boolean hasEqualAnnotations(AnnotatedString other) {
        return Intrinsics.areEqual(this.annotations, other.annotations);
    }

    public final boolean hasLinkAnnotations(int start, int end) {
        List<Range<? extends Object>> list = this.annotations;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Range<? extends Object> range = list.get(i5);
            if ((range.getItem() instanceof LinkAnnotation) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasStringAnnotations(String tag, int start, int end) {
        List<Range<? extends Object>> list = this.annotations;
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Range<? extends Object> range = list.get(i5);
            if ((range.getItem() instanceof String) && Intrinsics.areEqual(tag, range.getTag()) && AnnotatedStringKt.intersect(start, end, range.getStart(), range.getEnd())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        List<Range<SpanStyle>> list = this.spanStylesOrNull;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Range<ParagraphStyle>> list2 = this.paragraphStylesOrNull;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Range<? extends Object>> list3 = this.annotations;
        return hashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final AnnotatedString plus(AnnotatedString other) {
        Builder builder = new Builder(this);
        builder.append(other);
        return builder.toAnnotatedString();
    }

    /* renamed from: subSequence-5zc-tL8, reason: not valid java name */
    public final AnnotatedString m2204subSequence5zctL8(long range) {
        return subSequence(TextRange.m2283getMinimpl(range), TextRange.m2282getMaximpl(range));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public AnnotatedString subSequence(int startIndex, int endIndex) {
        if (startIndex <= endIndex) {
            if (startIndex == 0 && endIndex == this.text.length()) {
                return this;
            }
            String substring = this.text.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(substring, AnnotatedStringKt.access$filterRanges(this.spanStylesOrNull, startIndex, endIndex), AnnotatedStringKt.access$filterRanges(this.paragraphStylesOrNull, startIndex, endIndex), AnnotatedStringKt.access$filterRanges(this.annotations, startIndex, endIndex));
        }
        throw new IllegalArgumentException(("start (" + startIndex + ") should be less or equal to end (" + endIndex + ')').toString());
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ>\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Range;", "T", BuildConfig.FLAVOR, "item", BuildConfig.FLAVOR, "start", "end", BuildConfig.FLAVOR, "tag", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "(Ljava/lang/Object;II)V", "component1", "()Ljava/lang/Object;", "component2", "()I", "component3", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "toString", "()Ljava/lang/String;", "hashCode", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getItem", "I", "getStart", "getEnd", "Ljava/lang/String;", "getTag", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class Range<T> {
        private final int end;
        private final T item;
        private final int start;
        private final String tag;

        public Range(T t5, int i5, int i6, String str) {
            this.item = t5;
            this.start = i5;
            this.end = i6;
            this.tag = str;
            if (i5 > i6) {
                throw new IllegalArgumentException("Reversed range is not supported");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Range copy$default(Range range, Object obj, int i5, int i6, String str, int i7, Object obj2) {
            if ((i7 & 1) != 0) {
                obj = range.item;
            }
            if ((i7 & 2) != 0) {
                i5 = range.start;
            }
            if ((i7 & 4) != 0) {
                i6 = range.end;
            }
            if ((i7 & 8) != 0) {
                str = range.tag;
            }
            return range.copy(obj, i5, i6, str);
        }

        public final T component1() {
            return this.item;
        }

        /* renamed from: component2, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component3, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        public final Range<T> copy(T item, int start, int end, String tag) {
            return new Range<>(item, start, end, tag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Range)) {
                return false;
            }
            Range range = (Range) other;
            return Intrinsics.areEqual(this.item, range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual(this.tag, range.tag);
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            T t5 = this.item;
            return ((((((t5 == null ? 0 : t5.hashCode()) * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end)) * 31) + this.tag.hashCode();
        }

        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }

        public Range(T t5, int i5, int i6) {
            this(t5, i5, i6, BuildConfig.FLAVOR);
        }
    }

    public final List<Range<String>> getStringAnnotations(int start, int end) {
        List emptyList;
        List<Range<? extends Object>> list = this.annotations;
        if (list != null) {
            emptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Range<? extends Object> range = list.get(i5);
                Range<? extends Object> range2 = range;
                if ((range2.getItem() instanceof String) && AnnotatedStringKt.intersect(start, end, range2.getStart(), range2.getEnd())) {
                    emptyList.add(range);
                }
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(emptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>");
        return emptyList;
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? null : list, (i5 & 4) != 0 ? null : list2, (i5 & 8) != 0 ? null : list3);
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list, (i5 & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AnnotatedString(String str, List<Range<SpanStyle>> list, List<Range<ParagraphStyle>> list2) {
        this(str, r4.isEmpty() ? null : r4, r5.isEmpty() ? null : r5, null);
        List<Range<SpanStyle>> list3 = list;
        List<Range<ParagraphStyle>> list4 = list2;
    }
}
