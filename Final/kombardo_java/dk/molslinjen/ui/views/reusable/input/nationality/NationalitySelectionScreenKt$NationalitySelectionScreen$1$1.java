package dk.molslinjen.ui.views.reusable.input.nationality;

import com.ramcosta.composedestinations.result.ResultBackNavigator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class NationalitySelectionScreenKt$NationalitySelectionScreen$1$1 extends FunctionReferenceImpl implements Function1<Locale, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NationalitySelectionScreenKt$NationalitySelectionScreen$1$1(Object obj) {
        super(1, obj, ResultBackNavigator.class, "navigateBack", "navigateBack(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Locale locale) {
        invoke2(locale);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Locale p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        ((ResultBackNavigator) this.receiver).navigateBack(p02);
    }
}
