package dk.molslinjen.ui.views.reusable.dialog;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import dk.molslinjen.databinding.DatePickerSpinnerBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class DatePickerSpinnerDialogKt$DatePickerSpinner$1$1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DatePickerSpinnerBinding> {
    public static final DatePickerSpinnerDialogKt$DatePickerSpinner$1$1 INSTANCE = new DatePickerSpinnerDialogKt$DatePickerSpinner$1$1();

    DatePickerSpinnerDialogKt$DatePickerSpinner$1$1() {
        super(3, DatePickerSpinnerBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Ldk/molslinjen/databinding/DatePickerSpinnerBinding;", 0);
    }

    public final DatePickerSpinnerBinding invoke(LayoutInflater p02, ViewGroup viewGroup, boolean z5) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        return DatePickerSpinnerBinding.inflate(p02, viewGroup, z5);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ DatePickerSpinnerBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
        return invoke(layoutInflater, viewGroup, bool.booleanValue());
    }
}
