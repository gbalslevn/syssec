package dk.molslinjen.ui.views.screens.profile.faq.subject;

import dk.molslinjen.domain.model.faq.FaqQuestionId;
import dk.molslinjen.domain.model.faq.FaqSubjectId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/faq/subject/FaqSubjectScreenNavArgs;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/faq/FaqSubjectId;", "subjectId", "Ldk/molslinjen/domain/model/faq/FaqQuestionId;", "questionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSubjectId-pbmbVKA", "getQuestionId-_aMsN3U", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FaqSubjectScreenNavArgs {
    private final String questionId;
    private final String subjectId;

    public /* synthetic */ FaqSubjectScreenNavArgs(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    public boolean equals(Object other) {
        boolean m3232equalsimpl0;
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqSubjectScreenNavArgs)) {
            return false;
        }
        FaqSubjectScreenNavArgs faqSubjectScreenNavArgs = (FaqSubjectScreenNavArgs) other;
        if (!FaqSubjectId.m3243equalsimpl0(this.subjectId, faqSubjectScreenNavArgs.subjectId)) {
            return false;
        }
        String str = this.questionId;
        String str2 = faqSubjectScreenNavArgs.questionId;
        if (str == null) {
            if (str2 == null) {
                m3232equalsimpl0 = true;
            }
            m3232equalsimpl0 = false;
        } else {
            if (str2 != null) {
                m3232equalsimpl0 = FaqQuestionId.m3232equalsimpl0(str, str2);
            }
            m3232equalsimpl0 = false;
        }
        return m3232equalsimpl0;
    }

    /* renamed from: getQuestionId-_aMsN3U, reason: not valid java name and from getter */
    public final String getQuestionId() {
        return this.questionId;
    }

    /* renamed from: getSubjectId-pbmbVKA, reason: not valid java name and from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    public int hashCode() {
        int m3244hashCodeimpl = FaqSubjectId.m3244hashCodeimpl(this.subjectId) * 31;
        String str = this.questionId;
        return m3244hashCodeimpl + (str == null ? 0 : FaqQuestionId.m3233hashCodeimpl(str));
    }

    public String toString() {
        String m3245toStringimpl = FaqSubjectId.m3245toStringimpl(this.subjectId);
        String str = this.questionId;
        return "FaqSubjectScreenNavArgs(subjectId=" + m3245toStringimpl + ", questionId=" + (str == null ? "null" : FaqQuestionId.m3234toStringimpl(str)) + ")";
    }

    private FaqSubjectScreenNavArgs(String subjectId, String str) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        this.subjectId = subjectId;
        this.questionId = str;
    }
}
