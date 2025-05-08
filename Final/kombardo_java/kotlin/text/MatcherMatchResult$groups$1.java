package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatcherMatchResult$groups$1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", BuildConfig.FLAVOR, "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", BuildConfig.FLAVOR, "isEmpty", "()Z", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", BuildConfig.FLAVOR, "index", "get", "(I)Lkotlin/text/MatchGroup;", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchGroupCollection {
    final /* synthetic */ MatcherMatchResult this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.this$0 = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof MatchGroup) {
            return contains((MatchGroup) obj);
        }
        return false;
    }

    public MatchGroup get(int index) {
        java.util.regex.MatchResult matchResult;
        IntRange range;
        java.util.regex.MatchResult matchResult2;
        matchResult = this.this$0.getMatchResult();
        range = RegexKt.range(matchResult, index);
        if (range.getStart().intValue() < 0) {
            return null;
        }
        matchResult2 = this.this$0.getMatchResult();
        String group = matchResult2.group(index);
        Intrinsics.checkNotNullExpressionValue(group, "group(...)");
        return new MatchGroup(group, range);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        java.util.regex.MatchResult matchResult;
        matchResult = this.this$0.getMatchResult();
        return matchResult.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), new Function1() { // from class: G4.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MatchGroup matchGroup;
                matchGroup = MatcherMatchResult$groups$1.this.get(((Integer) obj).intValue());
                return matchGroup;
            }
        }).iterator();
    }

    public /* bridge */ boolean contains(MatchGroup matchGroup) {
        return super.contains((MatcherMatchResult$groups$1) matchGroup);
    }
}
