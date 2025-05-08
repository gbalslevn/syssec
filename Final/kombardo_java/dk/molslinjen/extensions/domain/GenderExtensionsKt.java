package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/Gender;", "getTitle", "(Ldk/molslinjen/domain/model/account/Gender;)I", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class GenderExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Gender.values().length];
            try {
                iArr[Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Gender.Other.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int getTitle(Gender gender) {
        Intrinsics.checkNotNullParameter(gender, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[gender.ordinal()];
        if (i5 == 1) {
            return R.string.checkbox_label_male;
        }
        if (i5 == 2) {
            return R.string.checkbox_label_female;
        }
        if (i5 == 3) {
            return R.string.checkbox_label_other;
        }
        throw new NoWhenBranchMatchedException();
    }
}
