package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0010\u000e\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0012\u001a\u001d\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0011\u0010\u0004\u001a\u00020\u0007*\u00020\u0007¢\u0006\u0004\b\u0004\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0007*\u00020\u0007¢\u0006\u0004\b\t\u0010\b\u001a#\u0010\r\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000f\u001a\u0011\u0010\u0011\u001a\u00020\u0010*\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0019\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0015\u001a\u00020\u0000*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0017\u001a#\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u001c\u001a#\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001b\u001a#\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001c\u001a#\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u001b\u001a#\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u001c\u001a#\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010\u001b\u001a#\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010\u001c\u001a)\u0010#\u001a\u00020\u0007*\u00020\u00072\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010&\u001a\u00020\u0000*\u00020\u00002\u0006\u0010%\u001a\u00020\u0007¢\u0006\u0004\b&\u0010'\u001a\u0019\u0010)\u001a\u00020\u0000*\u00020\u00002\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010'\u001a;\u0010.\u001a\u00020\u0010*\u00020\u00072\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0010H\u0000¢\u0006\u0004\b.\u0010/\u001a#\u00101\u001a\u00020\u0010*\u00020\u00072\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\b1\u00102\u001a#\u00103\u001a\u00020\u0010*\u00020\u00072\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\b3\u00102\u001a#\u00101\u001a\u00020\u0010*\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\b1\u00104\u001a#\u00103\u001a\u00020\u0010*\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\b3\u00104\u001a-\u00105\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\b5\u00106\u001a-\u00107\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\b7\u00106\u001a=\u0010;\u001a\u00020\n*\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u0010H\u0002¢\u0006\u0004\b9\u0010:\u001aG\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010>*\u00020\u00072\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00000<2\u0006\u0010 \u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0010H\u0002¢\u0006\u0004\b?\u0010@\u001a-\u0010;\u001a\u00020\n*\u00020\u00072\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\b;\u0010B\u001a-\u0010;\u001a\u00020\n*\u00020\u00072\u0006\u0010C\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\b;\u0010D\u001a-\u0010E\u001a\u00020\n*\u00020\u00072\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\bE\u0010B\u001a-\u0010E\u001a\u00020\n*\u00020\u00072\u0006\u0010C\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u0010¢\u0006\u0004\bE\u0010D\u001a&\u0010F\u001a\u00020\u0010*\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\bF\u00104\u001a&\u0010F\u001a\u00020\u0010*\u00020\u00072\u0006\u00100\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u0010H\u0086\u0002¢\u0006\u0004\bF\u00102\u001a?\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00130I*\u00020\u00072\u0006\u0010G\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010H\u001a\u00020\nH\u0002¢\u0006\u0004\bJ\u0010K\u001aG\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00130I*\u00020\u00072\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000M2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010H\u001a\u00020\nH\u0002¢\u0006\u0004\bJ\u0010N\u001a\u0017\u0010P\u001a\u00020O2\u0006\u0010H\u001a\u00020\nH\u0000¢\u0006\u0004\bP\u0010Q\u001a?\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000R*\u00020\u00072\u0012\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000M\"\u00020\u00002\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010H\u001a\u00020\n¢\u0006\u0004\bS\u0010T\u001a7\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000R*\u00020\u00072\n\u0010G\u001a\u00020\u0001\"\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010H\u001a\u00020\n¢\u0006\u0004\bS\u0010U\u001a1\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000R*\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\nH\u0002¢\u0006\u0004\bV\u0010W\u001a\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00000I*\u00020\u0007¢\u0006\u0004\bX\u0010Y\u001a\u0017\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00000R*\u00020\u0007¢\u0006\u0004\bZ\u0010[\u001a\u0015\u0010\\\u001a\u0004\u0018\u00010\u0010*\u00020\u0000H\u0007¢\u0006\u0004\b\\\u0010]\"\u0015\u0010`\u001a\u00020\u0013*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b^\u0010_\"\u0015\u0010c\u001a\u00020\n*\u00020\u00078F¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006d"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "chars", "trim", "(Ljava/lang/String;[C)Ljava/lang/String;", "trimStart", BuildConfig.FLAVOR, "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "trimEnd", BuildConfig.FLAVOR, "length", "padChar", "padStart", "(Ljava/lang/CharSequence;IC)Ljava/lang/CharSequence;", "(Ljava/lang/String;IC)Ljava/lang/String;", BuildConfig.FLAVOR, "isBlank", "(Ljava/lang/CharSequence;)Z", "Lkotlin/ranges/IntRange;", "range", "substring", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "delimiter", "missingDelimiterValue", "substringBefore", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "substringAfter", "substringBeforeLast", "substringAfterLast", "startIndex", "endIndex", "replacement", "replaceRange", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Ljava/lang/CharSequence;", "prefix", "removePrefix", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "suffix", "removeSuffix", "thisOffset", "other", "otherOffset", "ignoreCase", "regionMatchesImpl", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "char", "startsWith", "(Ljava/lang/CharSequence;CZ)Z", "endsWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "indexOfAny", "(Ljava/lang/CharSequence;[CIZ)I", "lastIndexOfAny", "last", "indexOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "indexOf", BuildConfig.FLAVOR, "strings", "Lkotlin/Pair;", "findAnyOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "findAnyOf", "(Ljava/lang/CharSequence;CIZ)I", "string", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "lastIndexOf", "contains", "delimiters", "limit", "Lkotlin/sequences/Sequence;", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/Sequence;", "rangesDelimitedBy", BuildConfig.FLAVOR, "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", BuildConfig.FLAVOR, "requireNonNegativeLimit", "(I)V", BuildConfig.FLAVOR, "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "split$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "lineSequence", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "lines", "(Ljava/lang/CharSequence;)Ljava/util/List;", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes3.dex */
public abstract class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static boolean contains(CharSequence charSequence, CharSequence other, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof String) {
            if (StringsKt.indexOf$default(charSequence, (String) other, 0, z5, 2, (Object) null) < 0) {
                return false;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, other, 0, charSequence.length(), z5, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return StringsKt.contains(charSequence, charSequence2, z5);
    }

    public static final boolean endsWith(CharSequence charSequence, char c5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(StringsKt.getLastIndex(charSequence)), c5, z5);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c5, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return endsWith(charSequence, c5, z5);
    }

    private static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i5, boolean z5, boolean z6) {
        Object obj;
        Object obj2;
        if (!z5 && collection.size() == 1) {
            String str = (String) CollectionsKt.single(collection);
            int indexOf$default = !z6 ? StringsKt.indexOf$default(charSequence, str, i5, false, 4, (Object) null) : StringsKt.lastIndexOf$default(charSequence, str, i5, false, 4, (Object) null);
            if (indexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(indexOf$default), str);
        }
        IntProgression intRange = !z6 ? new IntRange(RangesKt.coerceAtLeast(i5, 0), charSequence.length()) : RangesKt.downTo(RangesKt.coerceAtMost(i5, StringsKt.getLastIndex(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (StringsKt.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z5)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z5)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, char c5, int i5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? indexOfAny(charSequence, new char[]{c5}, i5, z5) : ((String) charSequence).indexOf(c5, i5);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z5, boolean z6) {
        IntProgression intRange = !z6 ? new IntRange(RangesKt.coerceAtLeast(i5, 0), RangesKt.coerceAtMost(i6, charSequence.length())) : RangesKt.downTo(RangesKt.coerceAtMost(i5, StringsKt.getLastIndex(charSequence)), RangesKt.coerceAtLeast(i6, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            while (!regionMatchesImpl(charSequence2, 0, charSequence, first, charSequence2.length(), z5)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = intRange.getFirst();
        int last2 = intRange.getLast();
        int step2 = intRange.getStep();
        if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
            return -1;
        }
        while (true) {
            String str = (String) charSequence2;
            if (StringsKt.regionMatches(str, 0, (String) charSequence, first2, str.length(), z5)) {
                return first2;
            }
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z5, boolean z6, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            z6 = false;
        }
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i5, i6, z5, z6);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c5, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return indexOf(charSequence, c5, i5, z5);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] chars, int i5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z5 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.single(chars), i5);
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i5, 0);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (coerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(coerceAtLeast);
            for (char c5 : chars) {
                if (CharsKt__CharKt.equals(c5, charAt, z5)) {
                    return coerceAtLeast;
                }
            }
            if (coerceAtLeast == lastIndex) {
                return -1;
            }
            coerceAtLeast++;
        }
    }

    public static boolean isBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            if (!CharsKt.isWhitespace(charSequence.charAt(i5))) {
                return false;
            }
        }
        return true;
    }

    public static final int lastIndexOf(CharSequence charSequence, char c5, int i5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? lastIndexOfAny(charSequence, new char[]{c5}, i5, z5) : ((String) charSequence).lastIndexOf(c5, i5);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c5, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = StringsKt.getLastIndex(charSequence);
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return lastIndexOf(charSequence, c5, i5, z5);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] chars, int i5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z5 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.single(chars), i5);
        }
        for (int coerceAtMost = RangesKt.coerceAtMost(i5, StringsKt.getLastIndex(charSequence)); -1 < coerceAtMost; coerceAtMost--) {
            char charAt = charSequence.charAt(coerceAtMost);
            for (char c5 : chars) {
                if (CharsKt__CharKt.equals(c5, charAt, z5)) {
                    return coerceAtMost;
                }
            }
        }
        return -1;
    }

    public static final Sequence<String> lineSequence(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new Sequence<String>() { // from class: kotlin.text.StringsKt__StringsKt$lineSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<String> iterator() {
                return new LinesIterator(charSequence);
            }
        };
    }

    public static final List<String> lines(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return SequencesKt.toList(lineSequence(charSequence));
    }

    public static final CharSequence padStart(CharSequence charSequence, int i5, char c5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i5 >= 0) {
            if (i5 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i5);
            int length = i5 - charSequence.length();
            int i6 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c5);
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i5 + " is less than zero.");
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, final char[] cArr, int i5, final boolean z5, int i6) {
        requireNonNegativeLimit(i6);
        return new DelimitedRangesSequence(charSequence, i5, i6, new Function2() { // from class: kotlin.text.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair rangesDelimitedBy$lambda$14$StringsKt__StringsKt;
                rangesDelimitedBy$lambda$14$StringsKt__StringsKt = StringsKt__StringsKt.rangesDelimitedBy$lambda$14$StringsKt__StringsKt(cArr, z5, (CharSequence) obj, ((Integer) obj2).intValue());
                return rangesDelimitedBy$lambda$14$StringsKt__StringsKt;
            }
        });
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i5, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i5, z5, i6);
    }

    public static final Pair rangesDelimitedBy$lambda$14$StringsKt__StringsKt(char[] cArr, boolean z5, CharSequence DelimitedRangesSequence, int i5) {
        Intrinsics.checkNotNullParameter(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int indexOfAny = indexOfAny(DelimitedRangesSequence, cArr, i5, z5);
        if (indexOfAny < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(indexOfAny), 1);
    }

    public static final Pair rangesDelimitedBy$lambda$16$StringsKt__StringsKt(List list, boolean z5, CharSequence DelimitedRangesSequence, int i5) {
        Intrinsics.checkNotNullParameter(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(DelimitedRangesSequence, list, i5, z5, false);
        if (findAnyOf$StringsKt__StringsKt != null) {
            return TuplesKt.to(findAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(findAnyOf$StringsKt__StringsKt.getSecond().length()));
        }
        return null;
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i5, CharSequence other, int i6, int i7, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i6 < 0 || i5 < 0 || i5 > charSequence.length() - i7 || i6 > other.length() - i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i5 + i8), other.charAt(i6 + i8), z5)) {
                return false;
            }
        }
        return true;
    }

    public static String removePrefix(String str, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!startsWith$default((CharSequence) str, prefix, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String removeSuffix(String str, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!StringsKt.endsWith$default((CharSequence) str, suffix, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static CharSequence replaceRange(CharSequence charSequence, int i5, int i6, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (i6 >= i5) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i5);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(replacement);
            sb.append(charSequence, i6, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i6 + ") is less than start index (" + i5 + ").");
    }

    public static final void requireNonNegativeLimit(int i5) {
        if (i5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i5).toString());
    }

    public static final List<String> split(CharSequence charSequence, String[] delimiters, boolean z5, int i5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return split$StringsKt__StringsKt(charSequence, str, z5, i5);
            }
        }
        Iterable asIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z5, i5, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asIterable, 10));
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z5, int i5) {
        requireNonNegativeLimit(i5);
        int i6 = 0;
        int indexOf = indexOf(charSequence, str, 0, z5);
        if (indexOf == -1 || i5 == 1) {
            return CollectionsKt.listOf(charSequence.toString());
        }
        boolean z6 = i5 > 0;
        ArrayList arrayList = new ArrayList(z6 ? RangesKt.coerceAtMost(i5, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i6, indexOf).toString());
            i6 = str.length() + indexOf;
            if (z6 && arrayList.size() == i5 - 1) {
                break;
            }
            indexOf = indexOf(charSequence, str, i6, z5);
        } while (indexOf != -1);
        arrayList.add(charSequence.subSequence(i6, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z5, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return split(charSequence, strArr, z5, i5);
    }

    public static final boolean startsWith(CharSequence charSequence, char c5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(0), c5, z5);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c5, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return startsWith(charSequence, c5, z5);
    }

    public static String substring(String str, IntRange range) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String substring = str.substring(range.getStart().intValue(), range.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String substringAfter(String str, char c5, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c5, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfter(str, c5, str2);
    }

    public static String substringAfterLast(String str, char c5, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c5, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfterLast(str, c5, str2);
    }

    public static final String substringBefore(String str, char c5, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c5, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c5, str2);
    }

    public static final String substringBeforeLast(String str, char c5, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c5, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c5, str2);
    }

    public static Boolean toBooleanStrictOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, "true")) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static String trim(String str, char... chars) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        int i5 = 0;
        boolean z5 = false;
        while (i5 <= length) {
            boolean contains = ArraysKt.contains(chars, str.charAt(!z5 ? i5 : length));
            if (z5) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i5++;
            } else {
                z5 = true;
            }
        }
        return str.subSequence(i5, length + 1).toString();
    }

    public static CharSequence trimEnd(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i5 = length - 1;
                if (!CharsKt.isWhitespace(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i5 < 0) {
                    break;
                }
                length = i5;
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static String trimStart(String str, char... chars) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                charSequence = BuildConfig.FLAVOR;
                break;
            }
            if (!ArraysKt.contains(chars, str.charAt(i5))) {
                charSequence = str.subSequence(i5, str.length());
                break;
            }
            i5++;
        }
        return charSequence.toString();
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c5, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return StringsKt.contains(charSequence, c5, z5);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence suffix, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!z5 && (charSequence instanceof String) && (suffix instanceof String)) {
            return StringsKt.endsWith$default((String) charSequence, (String) suffix, false, 2, (Object) null);
        }
        return regionMatchesImpl(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z5);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return endsWith(charSequence, charSequence2, z5);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return indexOf(charSequence, str, i5, z5);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = StringsKt.getLastIndex(charSequence);
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return lastIndexOf(charSequence, str, i5, z5);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i5, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i5, z5, i6);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z5, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return split(charSequence, cArr, z5, i5);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence prefix, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z5 && (charSequence instanceof String) && (prefix instanceof String)) {
            return StringsKt.startsWith$default((String) charSequence, (String) prefix, false, 2, (Object) null);
        }
        return regionMatchesImpl(charSequence, 0, prefix, 0, prefix.length(), z5);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return startsWith(charSequence, charSequence2, z5);
    }

    public static final String substring(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i5, final boolean z5, int i6) {
        requireNonNegativeLimit(i6);
        final List asList = ArraysKt.asList(strArr);
        return new DelimitedRangesSequence(charSequence, i5, i6, new Function2() { // from class: kotlin.text.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Pair rangesDelimitedBy$lambda$16$StringsKt__StringsKt;
                rangesDelimitedBy$lambda$16$StringsKt__StringsKt = StringsKt__StringsKt.rangesDelimitedBy$lambda$16$StringsKt__StringsKt(asList, z5, (CharSequence) obj, ((Integer) obj2).intValue());
                return rangesDelimitedBy$lambda$16$StringsKt__StringsKt;
            }
        });
    }

    public static final String substringAfter(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(indexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final String substringAfterLast(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(lastIndexOf$default + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final String substringBefore(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String substringBeforeLast(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static boolean contains(CharSequence charSequence, char c5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt.indexOf$default(charSequence, c5, 0, z5, 2, (Object) null) >= 0;
    }

    public static final int indexOf(CharSequence charSequence, String string, int i5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z5 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i5);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, string, i5, charSequence.length(), z5, false, 16, null);
    }

    public static final int lastIndexOf(CharSequence charSequence, String string, int i5, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!z5 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i5);
        }
        return indexOf$StringsKt__StringsKt(charSequence, string, i5, 0, z5, true);
    }

    public static CharSequence trim(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z5 = false;
        while (i5 <= length) {
            boolean isWhitespace = CharsKt.isWhitespace(charSequence.charAt(!z5 ? i5 : length));
            if (z5) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                i5++;
            } else {
                z5 = true;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static String padStart(String str, int i5, char c5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return padStart((CharSequence) str, i5, c5).toString();
    }

    public static final List<String> split(CharSequence charSequence, char[] delimiters, boolean z5, int i5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(delimiters[0]), z5, i5);
        }
        Iterable asIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, delimiters, 0, z5, i5, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asIterable, 10));
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }
}
