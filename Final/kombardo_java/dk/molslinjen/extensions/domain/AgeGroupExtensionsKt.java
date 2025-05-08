package dk.molslinjen.extensions.domain;

import android.content.Context;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.booking.AgeGroup;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"name", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/AgeGroup;", "context", "Landroid/content/Context;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AgeGroupExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgeGroup.values().length];
            try {
                iArr[AgeGroup.Infant.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgeGroup.Child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgeGroup.Adult.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String name(AgeGroup ageGroup, Context context) {
        Intrinsics.checkNotNullParameter(ageGroup, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int i5 = WhenMappings.$EnumSwitchMapping$0[ageGroup.ordinal()];
        if (i5 == 1) {
            String quantityString = context.getResources().getQuantityString(R.plurals.passengers_infant, 1);
            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
            return StringExtensionsKt.uppercaseFirstLetter(quantityString);
        }
        if (i5 == 2) {
            String quantityString2 = context.getResources().getQuantityString(R.plurals.passengers_child, 1);
            Intrinsics.checkNotNullExpressionValue(quantityString2, "getQuantityString(...)");
            return StringExtensionsKt.uppercaseFirstLetter(quantityString2);
        }
        if (i5 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        String quantityString3 = context.getResources().getQuantityString(R.plurals.passengers_adult, 1);
        Intrinsics.checkNotNullExpressionValue(quantityString3, "getQuantityString(...)");
        return StringExtensionsKt.uppercaseFirstLetter(quantityString3);
    }
}
