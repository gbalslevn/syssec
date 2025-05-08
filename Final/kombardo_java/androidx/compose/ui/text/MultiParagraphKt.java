package androidx.compose.ui.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0005\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\t\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a<\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0014\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0014\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {BuildConfig.FLAVOR, "Landroidx/compose/ui/text/ParagraphInfo;", "paragraphInfoList", BuildConfig.FLAVOR, "index", "findParagraphByIndex", "(Ljava/util/List;I)I", BuildConfig.FLAVOR, "y", "findParagraphByY", "(Ljava/util/List;F)I", "Landroidx/compose/ui/text/TextRange;", "range", "Lkotlin/Function1;", BuildConfig.FLAVOR, "action", "findParagraphsByRange-Sb-Bc2M", "(Ljava/util/List;JLkotlin/jvm/functions/Function1;)V", "findParagraphsByRange", "lineIndex", "findParagraphByLineIndex", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MultiParagraphKt {
    public static final int findParagraphByIndex(List<ParagraphInfo> list, int i5) {
        int endIndex = ((ParagraphInfo) CollectionsKt.last((List) list)).getEndIndex();
        if (i5 > ((ParagraphInfo) CollectionsKt.last((List) list)).getEndIndex()) {
            throw new IllegalArgumentException(("Index " + i5 + " should be less or equal than last line's end " + endIndex).toString());
        }
        int size = list.size() - 1;
        int i6 = 0;
        while (i6 <= size) {
            int i7 = (i6 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i7);
            char c5 = paragraphInfo.getStartIndex() > i5 ? (char) 1 : paragraphInfo.getEndIndex() <= i5 ? (char) 65535 : (char) 0;
            if (c5 < 0) {
                i6 = i7 + 1;
            } else {
                if (c5 <= 0) {
                    return i7;
                }
                size = i7 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static final int findParagraphByLineIndex(List<ParagraphInfo> list, int i5) {
        int size = list.size() - 1;
        int i6 = 0;
        while (i6 <= size) {
            int i7 = (i6 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i7);
            char c5 = paragraphInfo.getStartLineIndex() > i5 ? (char) 1 : paragraphInfo.getEndLineIndex() <= i5 ? (char) 65535 : (char) 0;
            if (c5 < 0) {
                i6 = i7 + 1;
            } else {
                if (c5 <= 0) {
                    return i7;
                }
                size = i7 - 1;
            }
        }
        return -(i6 + 1);
    }

    public static final int findParagraphByY(List<ParagraphInfo> list, float f5) {
        if (f5 <= 0.0f) {
            return 0;
        }
        if (f5 >= ((ParagraphInfo) CollectionsKt.last((List) list)).getBottom()) {
            return CollectionsKt.getLastIndex(list);
        }
        int size = list.size() - 1;
        int i5 = 0;
        while (i5 <= size) {
            int i6 = (i5 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i6);
            char c5 = paragraphInfo.getTop() > f5 ? (char) 1 : paragraphInfo.getBottom() <= f5 ? (char) 65535 : (char) 0;
            if (c5 < 0) {
                i5 = i6 + 1;
            } else {
                if (c5 <= 0) {
                    return i6;
                }
                size = i6 - 1;
            }
        }
        return -(i5 + 1);
    }

    /* renamed from: findParagraphsByRange-Sb-Bc2M, reason: not valid java name */
    public static final void m2223findParagraphsByRangeSbBc2M(List<ParagraphInfo> list, long j5, Function1<? super ParagraphInfo, Unit> function1) {
        int size = list.size();
        for (int findParagraphByIndex = findParagraphByIndex(list, TextRange.m2283getMinimpl(j5)); findParagraphByIndex < size; findParagraphByIndex++) {
            ParagraphInfo paragraphInfo = list.get(findParagraphByIndex);
            if (paragraphInfo.getStartIndex() >= TextRange.m2282getMaximpl(j5)) {
                return;
            }
            if (paragraphInfo.getStartIndex() != paragraphInfo.getEndIndex()) {
                function1.invoke(paragraphInfo);
            }
        }
    }
}
