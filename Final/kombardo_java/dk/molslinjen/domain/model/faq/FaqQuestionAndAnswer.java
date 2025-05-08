package dk.molslinjen.domain.model.faq;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.faq.response.FaqQuestionAndAnswerDTO;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0013¨\u0006\""}, d2 = {"Ldk/molslinjen/domain/model/faq/FaqQuestionAndAnswer;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Ldk/molslinjen/domain/model/faq/FaqQuestionId;", "question", BuildConfig.FLAVOR, "answer", "isPopular", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "dto", "Ldk/molslinjen/api/services/faq/response/FaqQuestionAndAnswerDTO;", "(Ldk/molslinjen/api/services/faq/response/FaqQuestionAndAnswerDTO;)V", "getId-arQqKPc", "()Ljava/lang/String;", "Ljava/lang/String;", "getQuestion", "getAnswer", "()Z", "component1", "component1-arQqKPc", "component2", "component3", "component4", "copy", "copy-70qKi0c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ldk/molslinjen/domain/model/faq/FaqQuestionAndAnswer;", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FaqQuestionAndAnswer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FaqQuestionAndAnswer mock = new FaqQuestionAndAnswer(FaqQuestionId.m3230constructorimpl("1"), "This is a very good question?", "Answer, lorem ipsum bla bla. Answer, lorem ipsum bla bla. Answer, lorem ipsum bla bla. Answer, lorem ipsum bla bla.", false, null);
    private final String answer;
    private final String id;
    private final boolean isPopular;
    private final String question;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/faq/FaqQuestionAndAnswer$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/faq/FaqQuestionAndAnswer;", "getMock", "()Ldk/molslinjen/domain/model/faq/FaqQuestionAndAnswer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FaqQuestionAndAnswer getMock() {
            return FaqQuestionAndAnswer.mock;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FaqQuestionAndAnswer(String str, String str2, String str3, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z5);
    }

    /* renamed from: copy-70qKi0c$default, reason: not valid java name */
    public static /* synthetic */ FaqQuestionAndAnswer m3225copy70qKi0c$default(FaqQuestionAndAnswer faqQuestionAndAnswer, String str, String str2, String str3, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = faqQuestionAndAnswer.id;
        }
        if ((i5 & 2) != 0) {
            str2 = faqQuestionAndAnswer.question;
        }
        if ((i5 & 4) != 0) {
            str3 = faqQuestionAndAnswer.answer;
        }
        if ((i5 & 8) != 0) {
            z5 = faqQuestionAndAnswer.isPopular;
        }
        return faqQuestionAndAnswer.m3227copy70qKi0c(str, str2, str3, z5);
    }

    /* renamed from: component1-arQqKPc, reason: not valid java name and from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsPopular() {
        return this.isPopular;
    }

    /* renamed from: copy-70qKi0c, reason: not valid java name */
    public final FaqQuestionAndAnswer m3227copy70qKi0c(String id, String question, String answer, boolean isPopular) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new FaqQuestionAndAnswer(id, question, answer, isPopular, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqQuestionAndAnswer)) {
            return false;
        }
        FaqQuestionAndAnswer faqQuestionAndAnswer = (FaqQuestionAndAnswer) other;
        return FaqQuestionId.m3232equalsimpl0(this.id, faqQuestionAndAnswer.id) && Intrinsics.areEqual(this.question, faqQuestionAndAnswer.question) && Intrinsics.areEqual(this.answer, faqQuestionAndAnswer.answer) && this.isPopular == faqQuestionAndAnswer.isPopular;
    }

    public final String getAnswer() {
        return this.answer;
    }

    /* renamed from: getId-arQqKPc, reason: not valid java name */
    public final String m3228getIdarQqKPc() {
        return this.id;
    }

    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        return (((((FaqQuestionId.m3233hashCodeimpl(this.id) * 31) + this.question.hashCode()) * 31) + this.answer.hashCode()) * 31) + Boolean.hashCode(this.isPopular);
    }

    public final boolean isPopular() {
        return this.isPopular;
    }

    public String toString() {
        return "FaqQuestionAndAnswer(id=" + FaqQuestionId.m3234toStringimpl(this.id) + ", question=" + this.question + ", answer=" + this.answer + ", isPopular=" + this.isPopular + ")";
    }

    private FaqQuestionAndAnswer(String id, String question, String answer, boolean z5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.isPopular = z5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FaqQuestionAndAnswer(FaqQuestionAndAnswerDTO dto) {
        this(FaqQuestionId.m3230constructorimpl(r0), dto.getQuestion(), dto.getAnswer(), dto.isPopular(), null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
    }
}
