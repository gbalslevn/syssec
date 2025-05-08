package dk.molslinjen.ui.views.reusable.input.dropdown;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DropdownPickerKt$DropdownContent$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ Function1<DropdownItem<T>, Unit> $onValueSelected;
    final /* synthetic */ List<DropdownItem<T>> $values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public DropdownPickerKt$DropdownContent$1(List<DropdownItem<T>> list, Function1<? super DropdownItem<T>, Unit> function1, Function0<Unit> function0) {
        this.$values = list;
        this.$onValueSelected = function1;
        this.$onDismissRequest = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function1 function1, Function0 function0, DropdownItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        function0.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope DropdownMenu, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(205122687, i5, -1, "dk.molslinjen.ui.views.reusable.input.dropdown.DropdownContent.<anonymous> (DropdownPicker.kt:101)");
        }
        List<DropdownItem<T>> list = this.$values;
        final Function1<DropdownItem<T>, Unit> function1 = this.$onValueSelected;
        final Function0<Unit> function0 = this.$onDismissRequest;
        int i6 = 0;
        for (Object obj : list) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DropdownItem dropdownItem = (DropdownItem) obj;
            composer.startReplaceGroup(-249912908);
            boolean changed = composer.changed(function1) | composer.changed(function0);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.dropdown.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit invoke$lambda$2$lambda$1$lambda$0;
                        invoke$lambda$2$lambda$1$lambda$0 = DropdownPickerKt$DropdownContent$1.invoke$lambda$2$lambda$1$lambda$0(Function1.this, function0, (DropdownItem) obj2);
                        return invoke$lambda$2$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function12 = (Function1) rememberedValue;
            composer.endReplaceGroup();
            DropdownPickerKt.DropdownRow(dropdownItem, function12, CollectionsKt.getLastIndex(list) != i6, composer, 0);
            i6 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
