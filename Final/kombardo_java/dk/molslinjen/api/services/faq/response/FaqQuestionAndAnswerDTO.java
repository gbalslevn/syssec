package dk.molslinjen.api.services.faq.response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/faq/response/FaqQuestionAndAnswerDTO;", BuildConfig.FLAVOR, "question", BuildConfig.FLAVOR, "answer", "isPopular", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQuestion", "()Ljava/lang/String;", "getAnswer", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class FaqQuestionAndAnswerDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String answer;
    private final boolean isPopular;
    private final String question;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/faq/response/FaqQuestionAndAnswerDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/faq/response/FaqQuestionAndAnswerDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<FaqQuestionAndAnswerDTO> serializer() {
            return FaqQuestionAndAnswerDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ FaqQuestionAndAnswerDTO(int i5, String str, String str2, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, FaqQuestionAndAnswerDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.question = str;
        this.answer = str2;
        this.isPopular = z5;
    }

    public static /* synthetic */ FaqQuestionAndAnswerDTO copy$default(FaqQuestionAndAnswerDTO faqQuestionAndAnswerDTO, String str, String str2, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = faqQuestionAndAnswerDTO.question;
        }
        if ((i5 & 2) != 0) {
            str2 = faqQuestionAndAnswerDTO.answer;
        }
        if ((i5 & 4) != 0) {
            z5 = faqQuestionAndAnswerDTO.isPopular;
        }
        return faqQuestionAndAnswerDTO.copy(str, str2, z5);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(FaqQuestionAndAnswerDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.question);
        output.encodeStringElement(serialDesc, 1, self.answer);
        output.encodeBooleanElement(serialDesc, 2, self.isPopular);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsPopular() {
        return this.isPopular;
    }

    public final FaqQuestionAndAnswerDTO copy(String question, String answer, boolean isPopular) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new FaqQuestionAndAnswerDTO(question, answer, isPopular);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqQuestionAndAnswerDTO)) {
            return false;
        }
        FaqQuestionAndAnswerDTO faqQuestionAndAnswerDTO = (FaqQuestionAndAnswerDTO) other;
        return Intrinsics.areEqual(this.question, faqQuestionAndAnswerDTO.question) && Intrinsics.areEqual(this.answer, faqQuestionAndAnswerDTO.answer) && this.isPopular == faqQuestionAndAnswerDTO.isPopular;
    }

    public final String getAnswer() {
        return this.answer;
    }

    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        return (((this.question.hashCode() * 31) + this.answer.hashCode()) * 31) + Boolean.hashCode(this.isPopular);
    }

    public final boolean isPopular() {
        return this.isPopular;
    }

    public String toString() {
        return "FaqQuestionAndAnswerDTO(question=" + this.question + ", answer=" + this.answer + ", isPopular=" + this.isPopular + ")";
    }

    public FaqQuestionAndAnswerDTO(String question, String answer, boolean z5) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.question = question;
        this.answer = answer;
        this.isPopular = z5;
    }
}
