package dk.molslinjen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dk.molslinjen.kombardo.R;

/* loaded from: classes2.dex */
public final class DatePickerSpinnerBinding implements ViewBinding {
    public final DatePicker datePicker;
    private final FrameLayout rootView;

    private DatePickerSpinnerBinding(FrameLayout frameLayout, DatePicker datePicker) {
        this.rootView = frameLayout;
        this.datePicker = datePicker;
    }

    public static DatePickerSpinnerBinding bind(View view) {
        DatePicker datePicker = (DatePicker) ViewBindings.findChildViewById(view, R.id.datePicker);
        if (datePicker != null) {
            return new DatePickerSpinnerBinding((FrameLayout) view, datePicker);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.datePicker)));
    }

    public static DatePickerSpinnerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View inflate = layoutInflater.inflate(R.layout.date_picker_spinner, viewGroup, false);
        if (z5) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
