package dk.molslinjen.api.services.faq.response;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Ldk/molslinjen/api/services/faq/response/FaqSubjectDTO;", BuildConfig.FLAVOR, "subject", BuildConfig.FLAVOR, "description", "questionAndAnswers", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/faq/response/FaqQuestionAndAnswerDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSubject", "()Ljava/lang/String;", "getDescription", "getQuestionAndAnswers", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class FaqSubjectDTO {
    private final String description;
    private final List<FaqQuestionAndAnswerDTO> questionAndAnswers;
    private final String subject;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(FaqQuestionAndAnswerDTO$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/faq/response/FaqSubjectDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/faq/response/FaqSubjectDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<FaqSubjectDTO> serializer() {
            return FaqSubjectDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ FaqSubjectDTO(int i5, String str, String str2, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, FaqSubjectDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.subject = str;
        this.description = str2;
        this.questionAndAnswers = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FaqSubjectDTO copy$default(FaqSubjectDTO faqSubjectDTO, String str, String str2, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = faqSubjectDTO.subject;
        }
        if ((i5 & 2) != 0) {
            str2 = faqSubjectDTO.description;
        }
        if ((i5 & 4) != 0) {
            list = faqSubjectDTO.questionAndAnswers;
        }
        return faqSubjectDTO.copy(str, str2, list);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(FaqSubjectDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.subject);
        output.encodeStringElement(serialDesc, 1, self.description);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.questionAndAnswers);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<FaqQuestionAndAnswerDTO> component3() {
        return this.questionAndAnswers;
    }

    public final FaqSubjectDTO copy(String subject, String description, List<FaqQuestionAndAnswerDTO> questionAndAnswers) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(questionAndAnswers, "questionAndAnswers");
        return new FaqSubjectDTO(subject, description, questionAndAnswers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqSubjectDTO)) {
            return false;
        }
        FaqSubjectDTO faqSubjectDTO = (FaqSubjectDTO) other;
        return Intrinsics.areEqual(this.subject, faqSubjectDTO.subject) && Intrinsics.areEqual(this.description, faqSubjectDTO.description) && Intrinsics.areEqual(this.questionAndAnswers, faqSubjectDTO.questionAndAnswers);
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<FaqQuestionAndAnswerDTO> getQuestionAndAnswers() {
        return this.questionAndAnswers;
    }

    public final String getSubject() {
        return this.subject;
    }

    public int hashCode() {
        return (((this.subject.hashCode() * 31) + this.description.hashCode()) * 31) + this.questionAndAnswers.hashCode();
    }

    public String toString() {
        return "FaqSubjectDTO(subject=" + this.subject + ", description=" + this.description + ", questionAndAnswers=" + this.questionAndAnswers + ")";
    }

    public FaqSubjectDTO(String subject, String description, List<FaqQuestionAndAnswerDTO> questionAndAnswers) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(questionAndAnswers, "questionAndAnswers");
        this.subject = subject;
        this.description = description;
        this.questionAndAnswers = questionAndAnswers;
    }
}
