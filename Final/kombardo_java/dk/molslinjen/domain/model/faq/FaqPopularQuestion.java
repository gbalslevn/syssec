package dk.molslinjen.domain.model.faq;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/domain/model/faq/FaqPopularQuestion;", BuildConfig.FLAVOR, "subjectId", "Ldk/molslinjen/domain/model/faq/FaqSubjectId;", "questionId", "Ldk/molslinjen/domain/model/faq/FaqQuestionId;", "question", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSubjectId-pbmbVKA", "()Ljava/lang/String;", "Ljava/lang/String;", "getQuestionId-arQqKPc", "getQuestion", "component1", "component1-pbmbVKA", "component2", "component2-arQqKPc", "component3", "copy", "copy-D0-UKg4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ldk/molslinjen/domain/model/faq/FaqPopularQuestion;", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FaqPopularQuestion {
    private final String question;
    private final String questionId;
    private final String subjectId;

    public /* synthetic */ FaqPopularQuestion(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    /* renamed from: copy-D0-UKg4$default, reason: not valid java name */
    public static /* synthetic */ FaqPopularQuestion m3219copyD0UKg4$default(FaqPopularQuestion faqPopularQuestion, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = faqPopularQuestion.subjectId;
        }
        if ((i5 & 2) != 0) {
            str2 = faqPopularQuestion.questionId;
        }
        if ((i5 & 4) != 0) {
            str3 = faqPopularQuestion.question;
        }
        return faqPopularQuestion.m3222copyD0UKg4(str, str2, str3);
    }

    /* renamed from: component1-pbmbVKA, reason: not valid java name and from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* renamed from: component2-arQqKPc, reason: not valid java name and from getter */
    public final String getQuestionId() {
        return this.questionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: copy-D0-UKg4, reason: not valid java name */
    public final FaqPopularQuestion m3222copyD0UKg4(String subjectId, String questionId, String question) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(questionId, "questionId");
        Intrinsics.checkNotNullParameter(question, "question");
        return new FaqPopularQuestion(subjectId, questionId, question, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqPopularQuestion)) {
            return false;
        }
        FaqPopularQuestion faqPopularQuestion = (FaqPopularQuestion) other;
        return FaqSubjectId.m3243equalsimpl0(this.subjectId, faqPopularQuestion.subjectId) && FaqQuestionId.m3232equalsimpl0(this.questionId, faqPopularQuestion.questionId) && Intrinsics.areEqual(this.question, faqPopularQuestion.question);
    }

    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: getQuestionId-arQqKPc, reason: not valid java name */
    public final String m3223getQuestionIdarQqKPc() {
        return this.questionId;
    }

    /* renamed from: getSubjectId-pbmbVKA, reason: not valid java name */
    public final String m3224getSubjectIdpbmbVKA() {
        return this.subjectId;
    }

    public int hashCode() {
        return (((FaqSubjectId.m3244hashCodeimpl(this.subjectId) * 31) + FaqQuestionId.m3233hashCodeimpl(this.questionId)) * 31) + this.question.hashCode();
    }

    public String toString() {
        return "FaqPopularQuestion(subjectId=" + FaqSubjectId.m3245toStringimpl(this.subjectId) + ", questionId=" + FaqQuestionId.m3234toStringimpl(this.questionId) + ", question=" + this.question + ")";
    }

    private FaqPopularQuestion(String subjectId, String questionId, String question) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(questionId, "questionId");
        Intrinsics.checkNotNullParameter(question, "question");
        this.subjectId = subjectId;
        this.questionId = questionId;
        this.question = question;
    }
}
