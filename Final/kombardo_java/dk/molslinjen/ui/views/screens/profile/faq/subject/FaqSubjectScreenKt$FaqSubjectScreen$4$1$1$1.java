package dk.molslinjen.ui.views.screens.profile.faq.subject;

import dk.molslinjen.domain.model.faq.FaqQuestionId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class FaqSubjectScreenKt$FaqSubjectScreen$4$1$1$1 extends FunctionReferenceImpl implements Function1<FaqQuestionId, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FaqSubjectScreenKt$FaqSubjectScreen$4$1$1$1(Object obj) {
        super(1, obj, FaqSubjectViewModel.class, "onQuestionSelected", "onQuestionSelected-ItQmzgU(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FaqQuestionId faqQuestionId) {
        m3509invokeItQmzgU(faqQuestionId.m3235unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ItQmzgU, reason: not valid java name */
    public final void m3509invokeItQmzgU(String p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((FaqSubjectViewModel) this.receiver).m3512onQuestionSelectedItQmzgU(p02);
    }
}
