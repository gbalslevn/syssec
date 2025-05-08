package androidx.compose.ui.platform.coreshims;

import android.os.Bundle;
import android.view.ViewStructure;

/* loaded from: classes.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    /* loaded from: classes.dex */
    private static class Api23Impl {
        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }

        static void setClassName(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        static void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        static void setDimens(ViewStructure viewStructure, int i5, int i6, int i7, int i8, int i9, int i10) {
            viewStructure.setDimens(i5, i6, i7, i8, i9, i10);
        }

        static void setId(ViewStructure viewStructure, int i5, String str, String str2, String str3) {
            viewStructure.setId(i5, str, str2, str3);
        }

        static void setText(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }

        static void setTextStyle(ViewStructure viewStructure, float f5, int i5, int i6, int i7) {
            viewStructure.setTextStyle(f5, i5, i6, i7);
        }
    }

    private ViewStructureCompat(ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    public static ViewStructureCompat toViewStructureCompat(ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public Bundle getExtras() {
        return Api23Impl.getExtras((ViewStructure) this.mWrappedObj);
    }

    public void setClassName(String str) {
        Api23Impl.setClassName((ViewStructure) this.mWrappedObj, str);
    }

    public void setContentDescription(CharSequence charSequence) {
        Api23Impl.setContentDescription((ViewStructure) this.mWrappedObj, charSequence);
    }

    public void setDimens(int i5, int i6, int i7, int i8, int i9, int i10) {
        Api23Impl.setDimens((ViewStructure) this.mWrappedObj, i5, i6, i7, i8, i9, i10);
    }

    public void setId(int i5, String str, String str2, String str3) {
        Api23Impl.setId((ViewStructure) this.mWrappedObj, i5, str, str2, str3);
    }

    public void setText(CharSequence charSequence) {
        Api23Impl.setText((ViewStructure) this.mWrappedObj, charSequence);
    }

    public void setTextStyle(float f5, int i5, int i6, int i7) {
        Api23Impl.setTextStyle((ViewStructure) this.mWrappedObj, f5, i5, i6, i7);
    }

    public ViewStructure toViewStructure() {
        return (ViewStructure) this.mWrappedObj;
    }
}
