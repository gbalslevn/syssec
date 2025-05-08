package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class CheckoutPassengerEditScreenKt$CheckoutPassengerEditScreen$1$1 extends FunctionReferenceImpl implements Function1<Locale, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckoutPassengerEditScreenKt$CheckoutPassengerEditScreen$1$1(Object obj) {
        super(1, obj, CheckoutPassengerEditViewModel.class, "updateNationality", "updateNationality(Ljava/util/Locale;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Locale locale) {
        invoke2(locale);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Locale locale) {
        ((CheckoutPassengerEditViewModel) this.receiver).updateNationality(locale);
    }
}
