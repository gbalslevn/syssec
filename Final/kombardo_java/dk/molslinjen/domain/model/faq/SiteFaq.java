package dk.molslinjen.domain.model.faq;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/model/faq/SiteFaq;", BuildConfig.FLAVOR, "siteInfo", "Ldk/molslinjen/domain/model/site/SiteInfo;", "popularQuestions", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/faq/FaqPopularQuestion;", "subjects", "Ldk/molslinjen/domain/model/faq/FaqSubject;", "<init>", "(Ldk/molslinjen/domain/model/site/SiteInfo;Ljava/util/List;Ljava/util/List;)V", "getSiteInfo", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "getPopularQuestions", "()Ljava/util/List;", "getSubjects", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SiteFaq {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SiteFaq mock;
    private final List<FaqPopularQuestion> popularQuestions;
    private final SiteInfo siteInfo;
    private final List<FaqSubject> subjects;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/faq/SiteFaq$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/faq/SiteFaq;", "getMock", "()Ldk/molslinjen/domain/model/faq/SiteFaq;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SiteFaq getMock() {
            return SiteFaq.mock;
        }

        private Companion() {
        }
    }

    static {
        SiteInfo mock2 = SiteInfo.INSTANCE.getMock();
        int i5 = 10;
        int i6 = 15;
        IntRange intRange = new IntRange(10, 15);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new FaqPopularQuestion(FaqSubjectId.m3241constructorimpl(Constants.ID_ATTRIBUTE_KEY + nextInt), FaqQuestionId.m3230constructorimpl(Constants.ID_ATTRIBUTE_KEY + nextInt + " (Subject " + nextInt + ")"), "Question " + nextInt + "  (Subject " + nextInt + ")", null));
        }
        int i7 = 1;
        IntRange intRange2 = new IntRange(1, 20);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
        Iterator<Integer> it2 = intRange2.iterator();
        while (it2.hasNext()) {
            int nextInt2 = ((IntIterator) it2).nextInt();
            String m3241constructorimpl = FaqSubjectId.m3241constructorimpl(Constants.ID_ATTRIBUTE_KEY + nextInt2);
            String str = "Subject " + nextInt2;
            String str2 = "Description " + nextInt2;
            IntRange intRange3 = new IntRange(i7, i6);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange3, i5));
            Iterator<Integer> it3 = intRange3.iterator();
            while (it3.hasNext()) {
                int nextInt3 = ((IntIterator) it3).nextInt();
                arrayList3.add(new FaqQuestionAndAnswer(FaqQuestionId.m3230constructorimpl(Constants.ID_ATTRIBUTE_KEY + nextInt3 + " (Subject " + nextInt2 + ")"), "Question " + nextInt3 + " (Subject " + nextInt2 + ")", "Answer " + nextInt3 + " (Subject " + nextInt2 + ")", false, null));
                it2 = it2;
            }
            arrayList2.add(new FaqSubject(m3241constructorimpl, str, str2, arrayList3, null));
            it2 = it2;
            i5 = 10;
            i6 = 15;
            i7 = 1;
        }
        mock = new SiteFaq(mock2, arrayList, arrayList2);
    }

    public SiteFaq(SiteInfo siteInfo, List<FaqPopularQuestion> list, List<FaqSubject> list2) {
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        this.siteInfo = siteInfo;
        this.popularQuestions = list;
        this.subjects = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SiteFaq copy$default(SiteFaq siteFaq, SiteInfo siteInfo, List list, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            siteInfo = siteFaq.siteInfo;
        }
        if ((i5 & 2) != 0) {
            list = siteFaq.popularQuestions;
        }
        if ((i5 & 4) != 0) {
            list2 = siteFaq.subjects;
        }
        return siteFaq.copy(siteInfo, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final SiteInfo getSiteInfo() {
        return this.siteInfo;
    }

    public final List<FaqPopularQuestion> component2() {
        return this.popularQuestions;
    }

    public final List<FaqSubject> component3() {
        return this.subjects;
    }

    public final SiteFaq copy(SiteInfo siteInfo, List<FaqPopularQuestion> popularQuestions, List<FaqSubject> subjects) {
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        return new SiteFaq(siteInfo, popularQuestions, subjects);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteFaq)) {
            return false;
        }
        SiteFaq siteFaq = (SiteFaq) other;
        return Intrinsics.areEqual(this.siteInfo, siteFaq.siteInfo) && Intrinsics.areEqual(this.popularQuestions, siteFaq.popularQuestions) && Intrinsics.areEqual(this.subjects, siteFaq.subjects);
    }

    public final List<FaqPopularQuestion> getPopularQuestions() {
        return this.popularQuestions;
    }

    public final SiteInfo getSiteInfo() {
        return this.siteInfo;
    }

    public final List<FaqSubject> getSubjects() {
        return this.subjects;
    }

    public int hashCode() {
        int hashCode = this.siteInfo.hashCode() * 31;
        List<FaqPopularQuestion> list = this.popularQuestions;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<FaqSubject> list2 = this.subjects;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "SiteFaq(siteInfo=" + this.siteInfo + ", popularQuestions=" + this.popularQuestions + ", subjects=" + this.subjects + ")";
    }

    public /* synthetic */ SiteFaq(SiteInfo siteInfo, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(siteInfo, (i5 & 2) != 0 ? null : list, (i5 & 4) != 0 ? null : list2);
    }
}
