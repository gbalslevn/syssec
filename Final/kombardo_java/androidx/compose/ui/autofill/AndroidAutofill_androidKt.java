package androidx.compose.ui.autofill;

import android.util.Log;
import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0001¨\u0006\t"}, d2 = {"performAutofill", BuildConfig.FLAVOR, "Landroidx/compose/ui/autofill/AndroidAutofill;", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "populateViewStructure", "root", "Landroid/view/ViewStructure;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidAutofill_androidKt {
    public static final void performAutofill(AndroidAutofill androidAutofill, SparseArray<AutofillValue> sparseArray) {
        int size = sparseArray.size();
        for (int i5 = 0; i5 < size; i5++) {
            int keyAt = sparseArray.keyAt(i5);
            AutofillValue autofillValue = sparseArray.get(keyAt);
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
            if (autofillApi26Helper.isText(autofillValue)) {
                androidAutofill.getAutofillTree().performAutofill(keyAt, autofillApi26Helper.textValue(autofillValue).toString());
            } else {
                if (autofillApi26Helper.isDate(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
                if (autofillApi26Helper.isList(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                }
                if (autofillApi26Helper.isToggle(autofillValue)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                }
            }
        }
    }

    public static final void populateViewStructure(AndroidAutofill androidAutofill, ViewStructure viewStructure) {
        int addChildCount = AutofillApi23Helper.INSTANCE.addChildCount(viewStructure, androidAutofill.getAutofillTree().getChildren().size());
        for (Map.Entry<Integer, AutofillNode> entry : androidAutofill.getAutofillTree().getChildren().entrySet()) {
            int intValue = entry.getKey().intValue();
            AutofillNode value = entry.getValue();
            AutofillApi23Helper autofillApi23Helper = AutofillApi23Helper.INSTANCE;
            ViewStructure newChild = autofillApi23Helper.newChild(viewStructure, addChildCount);
            if (newChild != null) {
                AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
                AutofillId autofillId = autofillApi26Helper.getAutofillId(viewStructure);
                Intrinsics.checkNotNull(autofillId);
                autofillApi26Helper.setAutofillId(newChild, autofillId, intValue);
                autofillApi23Helper.setId(newChild, intValue, androidAutofill.getView().getContext().getPackageName(), null, null);
                autofillApi26Helper.setAutofillType(newChild, ContentDataType.INSTANCE.m1257getTextA48pgw8());
                List<AutofillType> autofillTypes = value.getAutofillTypes();
                ArrayList arrayList = new ArrayList(autofillTypes.size());
                int size = autofillTypes.size();
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList.add(AndroidAutofillType_androidKt.getAndroidType(autofillTypes.get(i5)));
                }
                autofillApi26Helper.setAutofillHints(newChild, (String[]) arrayList.toArray(new String[0]));
                Rect boundingBox = value.getBoundingBox();
                if (boundingBox == null) {
                    Log.w("Autofill Warning", "Bounding box not set.\n                        Did you call perform autofillTree before the component was positioned? ");
                } else {
                    int round = Math.round(boundingBox.getLeft());
                    int round2 = Math.round(boundingBox.getTop());
                    int round3 = Math.round(boundingBox.getRight());
                    AutofillApi23Helper.INSTANCE.setDimens(newChild, round, round2, 0, 0, round3 - round, Math.round(boundingBox.getBottom()) - round2);
                }
            }
            addChildCount++;
        }
    }
}
