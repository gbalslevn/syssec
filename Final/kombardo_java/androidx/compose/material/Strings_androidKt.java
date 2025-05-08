package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.Strings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R$string;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"getString", BuildConfig.FLAVOR, "string", "Landroidx/compose/material/Strings;", "getString-4foXLRw", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Strings_androidKt {
    /* renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m735getString4foXLRw(int i5, Composer composer, int i6) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726638443, i6, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.INSTANCE;
        String string = Strings.m727equalsimpl0(i5, companion.m732getNavigationMenuUdPEhr4()) ? resources.getString(R$string.navigation_menu) : Strings.m727equalsimpl0(i5, companion.m728getCloseDrawerUdPEhr4()) ? resources.getString(R$string.close_drawer) : Strings.m727equalsimpl0(i5, companion.m729getCloseSheetUdPEhr4()) ? resources.getString(R$string.close_sheet) : Strings.m727equalsimpl0(i5, companion.m730getDefaultErrorMessageUdPEhr4()) ? resources.getString(R$string.default_error_message) : Strings.m727equalsimpl0(i5, companion.m731getExposedDropdownMenuUdPEhr4()) ? resources.getString(R$string.dropdown_menu) : Strings.m727equalsimpl0(i5, companion.m734getSliderRangeStartUdPEhr4()) ? resources.getString(R$string.range_start) : Strings.m727equalsimpl0(i5, companion.m733getSliderRangeEndUdPEhr4()) ? resources.getString(R$string.range_end) : BuildConfig.FLAVOR;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return string;
    }
}
