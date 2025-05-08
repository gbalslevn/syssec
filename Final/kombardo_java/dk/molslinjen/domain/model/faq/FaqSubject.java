package dk.molslinjen.domain.model.faq;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.faq.response.FaqQuestionAndAnswerDTO;
import dk.molslinjen.api.services.faq.response.FaqSubjectDTO;
import dk.molslinjen.domain.model.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0010\u0010\u0016\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Ldk/molslinjen/domain/model/faq/FaqSubject;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Ldk/molslinjen/domain/model/faq/FaqSubjectId;", Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "description", "questionAndAnswers", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/faq/FaqQuestionAndAnswer;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "dto", "Ldk/molslinjen/api/services/faq/response/FaqSubjectDTO;", "(Ldk/molslinjen/api/services/faq/response/FaqSubjectDTO;)V", "getId-pbmbVKA", "()Ljava/lang/String;", "Ljava/lang/String;", "getTitle", "getDescription", "getQuestionAndAnswers", "()Ljava/util/List;", "component1", "component1-pbmbVKA", "component2", "component3", "component4", "copy", "copy-L-UcCNQ", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Ldk/molslinjen/domain/model/faq/FaqSubject;", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FaqSubject {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FaqSubject mock;
    private final String description;
    private final String id;
    private final List<FaqQuestionAndAnswer> questionAndAnswers;
    private final String title;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/faq/FaqSubject$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/faq/FaqSubject;", "getMock", "()Ldk/molslinjen/domain/model/faq/FaqSubject;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FaqSubject getMock() {
            return FaqSubject.mock;
        }

        private Companion() {
        }
    }

    static {
        String m3241constructorimpl = FaqSubjectId.m3241constructorimpl("1");
        IntRange intRange = new IntRange(1, 5);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(FaqQuestionAndAnswer.m3225copy70qKi0c$default(FaqQuestionAndAnswer.INSTANCE.getMock(), FaqQuestionId.m3230constructorimpl(String.valueOf(((IntIterator) it).nextInt())), null, null, false, 14, null));
        }
        mock = new FaqSubject(m3241constructorimpl, "Subject & Subject 1", "Description, lorem ipsum bla bla. Description, lorem ipsum bla bla. Description, lorem ipsum bla bla. Description, lorem ipsum bla bla. ", arrayList, null);
    }

    public /* synthetic */ FaqSubject(String str, String str2, String str3, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-L-UcCNQ$default, reason: not valid java name */
    public static /* synthetic */ FaqSubject m3236copyLUcCNQ$default(FaqSubject faqSubject, String str, String str2, String str3, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = faqSubject.id;
        }
        if ((i5 & 2) != 0) {
            str2 = faqSubject.title;
        }
        if ((i5 & 4) != 0) {
            str3 = faqSubject.description;
        }
        if ((i5 & 8) != 0) {
            list = faqSubject.questionAndAnswers;
        }
        return faqSubject.m3238copyLUcCNQ(str, str2, str3, list);
    }

    /* renamed from: component1-pbmbVKA, reason: not valid java name and from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<FaqQuestionAndAnswer> component4() {
        return this.questionAndAnswers;
    }

    /* renamed from: copy-L-UcCNQ, reason: not valid java name */
    public final FaqSubject m3238copyLUcCNQ(String id, String title, String description, List<FaqQuestionAndAnswer> questionAndAnswers) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(questionAndAnswers, "questionAndAnswers");
        return new FaqSubject(id, title, description, questionAndAnswers, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqSubject)) {
            return false;
        }
        FaqSubject faqSubject = (FaqSubject) other;
        return FaqSubjectId.m3243equalsimpl0(this.id, faqSubject.id) && Intrinsics.areEqual(this.title, faqSubject.title) && Intrinsics.areEqual(this.description, faqSubject.description) && Intrinsics.areEqual(this.questionAndAnswers, faqSubject.questionAndAnswers);
    }

    public final String getDescription() {
        return this.description;
    }

    /* renamed from: getId-pbmbVKA, reason: not valid java name */
    public final String m3239getIdpbmbVKA() {
        return this.id;
    }

    public final List<FaqQuestionAndAnswer> getQuestionAndAnswers() {
        return this.questionAndAnswers;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((FaqSubjectId.m3244hashCodeimpl(this.id) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.questionAndAnswers.hashCode();
    }

    public String toString() {
        return "FaqSubject(id=" + FaqSubjectId.m3245toStringimpl(this.id) + ", title=" + this.title + ", description=" + this.description + ", questionAndAnswers=" + this.questionAndAnswers + ")";
    }

    private FaqSubject(String id, String title, String description, List<FaqQuestionAndAnswer> questionAndAnswers) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(questionAndAnswers, "questionAndAnswers");
        this.id = id;
        this.title = title;
        this.description = description;
        this.questionAndAnswers = questionAndAnswers;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FaqSubject(FaqSubjectDTO dto) {
        this(r3, r4, r5, r6, null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String m3241constructorimpl = FaqSubjectId.m3241constructorimpl(uuid);
        String subject = dto.getSubject();
        String description = dto.getDescription();
        List<FaqQuestionAndAnswerDTO> questionAndAnswers = dto.getQuestionAndAnswers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(questionAndAnswers, 10));
        Iterator<T> it = questionAndAnswers.iterator();
        while (it.hasNext()) {
            arrayList.add(new FaqQuestionAndAnswer((FaqQuestionAndAnswerDTO) it.next()));
        }
    }
}
