package dk.molslinjen.ui.views.reusable.dialog;

import android.widget.DatePicker;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.viewinterop.AndroidViewBindingKt;
import dk.molslinjen.databinding.DatePickerSpinnerBinding;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.dialog.DatePickerSpinnerDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001aA\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\u0012\u0010\u0010\u001a\n \u0011*\u0004\u0018\u00010\u00050\u0005X\u008a\u008e\u0002"}, d2 = {"DatePickerSpinnerDialog", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "selectedDate", "Lorg/threeten/bp/LocalDate;", "maxDate", "minDate", "onDateSelected", "Lkotlin/Function1;", "onDismissRequest", "Lkotlin/Function0;", "(Ljava/lang/String;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DatePickerSpinner", "(Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd", "selectedValue", "kotlin.jvm.PlatformType"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DatePickerSpinnerDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerSpinner(final LocalDate localDate, final LocalDate localDate2, final LocalDate localDate3, final Function1<? super LocalDate, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(209015179);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(localDate) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(localDate2) ? 32 : 16;
        }
        int i9 = i6 & 4;
        if (i9 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(localDate3) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                localDate2 = null;
            }
            if (i9 != 0) {
                localDate3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(209015179, i7, -1, "dk.molslinjen.ui.views.reusable.dialog.DatePickerSpinner (DatePickerSpinnerDialog.kt:78)");
            }
            startRestartGroup.startReplaceGroup(408067997);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = DatePickerSpinnerDialogKt$DatePickerSpinner$1$1.INSTANCE;
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function3 function3 = (Function3) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(408069658);
            boolean changedInstance = ((i7 & 7168) == 2048) | startRestartGroup.changedInstance(localDate2) | startRestartGroup.changedInstance(localDate3) | startRestartGroup.changedInstance(localDate);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: b2.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DatePickerSpinner$lambda$11$lambda$10;
                        DatePickerSpinner$lambda$11$lambda$10 = DatePickerSpinnerDialogKt.DatePickerSpinner$lambda$11$lambda$10(LocalDate.this, localDate3, localDate, function1, (DatePickerSpinnerBinding) obj);
                        return DatePickerSpinner$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            AndroidViewBindingKt.AndroidViewBinding(function3, null, (Function1) rememberedValue2, startRestartGroup, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final LocalDate localDate4 = localDate2;
        final LocalDate localDate5 = localDate3;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: b2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DatePickerSpinner$lambda$12;
                    DatePickerSpinner$lambda$12 = DatePickerSpinnerDialogKt.DatePickerSpinner$lambda$12(LocalDate.this, localDate4, localDate5, function1, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return DatePickerSpinner$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerSpinner$lambda$11$lambda$10(LocalDate localDate, LocalDate localDate2, LocalDate localDate3, final Function1 function1, DatePickerSpinnerBinding AndroidViewBinding) {
        Intrinsics.checkNotNullParameter(AndroidViewBinding, "$this$AndroidViewBinding");
        if (localDate != null) {
            DatePicker datePicker = AndroidViewBinding.datePicker;
            LocalDateTime atStartOfDay = localDate.atStartOfDay();
            Intrinsics.checkNotNullExpressionValue(atStartOfDay, "atStartOfDay(...)");
            datePicker.setMaxDate(LocalDateTimeExtensionsKt.toMilliseconds(atStartOfDay));
        }
        if (localDate2 != null) {
            DatePicker datePicker2 = AndroidViewBinding.datePicker;
            LocalDateTime atStartOfDay2 = localDate2.atStartOfDay();
            Intrinsics.checkNotNullExpressionValue(atStartOfDay2, "atStartOfDay(...)");
            datePicker2.setMinDate(LocalDateTimeExtensionsKt.toMilliseconds(atStartOfDay2));
        }
        AndroidViewBinding.datePicker.init(localDate3.getYear(), localDate3.getMonthValue() - 1, localDate3.getDayOfMonth(), new DatePicker.OnDateChangedListener() { // from class: b2.f
            @Override // android.widget.DatePicker.OnDateChangedListener
            public final void onDateChanged(DatePicker datePicker3, int i5, int i6, int i7) {
                DatePickerSpinnerDialogKt.DatePickerSpinner$lambda$11$lambda$10$lambda$9(Function1.this, datePicker3, i5, i6, i7);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerSpinner$lambda$11$lambda$10$lambda$9(Function1 function1, DatePicker datePicker, int i5, int i6, int i7) {
        LocalDate of = LocalDate.of(i5, i6 + 1, i7);
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        function1.invoke(of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerSpinner$lambda$12(LocalDate localDate, LocalDate localDate2, LocalDate localDate3, Function1 function1, int i5, int i6, Composer composer, int i7) {
        DatePickerSpinner(localDate, localDate2, localDate3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DatePickerSpinnerDialog(final String title, final LocalDate localDate, LocalDate localDate2, LocalDate localDate3, final Function1<? super LocalDate, Unit> onDateSelected, final Function0<Unit> onDismissRequest, Composer composer, final int i5, final int i6) {
        int i7;
        LocalDate localDate4;
        int i8;
        LocalDate localDate5;
        int i9;
        Object rememberedValue;
        Composer.Companion companion;
        boolean z5;
        Object rememberedValue2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer startRestartGroup = composer.startRestartGroup(-105188858);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(title) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(localDate) ? 32 : 16;
        }
        int i10 = i6 & 4;
        if (i10 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            localDate4 = localDate2;
            i7 |= startRestartGroup.changedInstance(localDate4) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                localDate5 = localDate3;
                i7 |= startRestartGroup.changedInstance(localDate5) ? 2048 : 1024;
                if ((i6 & 16) != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    i7 |= startRestartGroup.changedInstance(onDateSelected) ? 16384 : 8192;
                }
                if ((i6 & 32) != 0) {
                    i7 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i7 |= startRestartGroup.changedInstance(onDismissRequest) ? 131072 : 65536;
                }
                i9 = i7;
                if ((74899 & i9) == 74898 || !startRestartGroup.getSkipping()) {
                    LocalDate localDate6 = i10 != 0 ? null : localDate4;
                    if (i8 != 0) {
                        localDate5 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-105188858, i9, -1, "dk.molslinjen.ui.views.reusable.dialog.DatePickerSpinnerDialog (DatePickerSpinnerDialog.kt:32)");
                    }
                    LocalDate now = (localDate == null && (localDate6 == null || localDate.isBefore(localDate6))) ? localDate : localDate6 == null ? LocalDate.now() : localDate6;
                    startRestartGroup.startReplaceGroup(-155029115);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(now, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    final MutableState mutableState = (MutableState) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    String stringResource = StringResources_androidKt.stringResource(R.string.button_confirm, startRestartGroup, 6);
                    startRestartGroup.startReplaceGroup(-155021851);
                    z5 = (57344 & i9) == 16384;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z5 || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: b2.b
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit DatePickerSpinnerDialog$lambda$4$lambda$3;
                                DatePickerSpinnerDialog$lambda$4$lambda$3 = DatePickerSpinnerDialogKt.DatePickerSpinnerDialog$lambda$4$lambda$3(Function1.this, mutableState);
                                return DatePickerSpinnerDialog$lambda$4$lambda$3;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    LocalDate localDate7 = localDate5;
                    LocalDate localDate8 = localDate6;
                    CustomDialogKt.CustomDialog(new SimpleButtonData(stringResource, false, false, (Function0) rememberedValue2, 6, null), null, new SimpleButtonData(StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6), false, false, onDismissRequest, 6, null), onDismissRequest, false, ComposableLambdaKt.rememberComposableLambda(1201054955, true, new DatePickerSpinnerDialogKt$DatePickerSpinnerDialog$2(title, localDate6, localDate7, mutableState), startRestartGroup, 54), startRestartGroup, ((i9 >> 6) & 7168) | 196608, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    localDate4 = localDate8;
                    localDate5 = localDate7;
                } else {
                    startRestartGroup.skipToGroupEnd();
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final LocalDate localDate9 = localDate4;
                    final LocalDate localDate10 = localDate5;
                    endRestartGroup.updateScope(new Function2() { // from class: b2.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DatePickerSpinnerDialog$lambda$5;
                            DatePickerSpinnerDialog$lambda$5 = DatePickerSpinnerDialogKt.DatePickerSpinnerDialog$lambda$5(title, localDate, localDate9, localDate10, onDateSelected, onDismissRequest, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return DatePickerSpinnerDialog$lambda$5;
                        }
                    });
                    return;
                }
                return;
            }
            localDate5 = localDate3;
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            i9 = i7;
            if ((74899 & i9) == 74898) {
            }
            if (i10 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (localDate == null) {
            }
            startRestartGroup.startReplaceGroup(-155029115);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            final MutableState mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            String stringResource2 = StringResources_androidKt.stringResource(R.string.button_confirm, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-155021851);
            if ((57344 & i9) == 16384) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue2 = new Function0() { // from class: b2.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit DatePickerSpinnerDialog$lambda$4$lambda$3;
                    DatePickerSpinnerDialog$lambda$4$lambda$3 = DatePickerSpinnerDialogKt.DatePickerSpinnerDialog$lambda$4$lambda$3(Function1.this, mutableState2);
                    return DatePickerSpinnerDialog$lambda$4$lambda$3;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            LocalDate localDate72 = localDate5;
            LocalDate localDate82 = localDate6;
            CustomDialogKt.CustomDialog(new SimpleButtonData(stringResource2, false, false, (Function0) rememberedValue2, 6, null), null, new SimpleButtonData(StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6), false, false, onDismissRequest, 6, null), onDismissRequest, false, ComposableLambdaKt.rememberComposableLambda(1201054955, true, new DatePickerSpinnerDialogKt$DatePickerSpinnerDialog$2(title, localDate6, localDate72, mutableState2), startRestartGroup, 54), startRestartGroup, ((i9 >> 6) & 7168) | 196608, 18);
            if (ComposerKt.isTraceInProgress()) {
            }
            localDate4 = localDate82;
            localDate5 = localDate72;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        localDate4 = localDate2;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        localDate5 = localDate3;
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        i9 = i7;
        if ((74899 & i9) == 74898) {
        }
        if (i10 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (localDate == null) {
        }
        startRestartGroup.startReplaceGroup(-155029115);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final MutableState mutableState22 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        String stringResource22 = StringResources_androidKt.stringResource(R.string.button_confirm, startRestartGroup, 6);
        startRestartGroup.startReplaceGroup(-155021851);
        if ((57344 & i9) == 16384) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue2 = new Function0() { // from class: b2.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit DatePickerSpinnerDialog$lambda$4$lambda$3;
                DatePickerSpinnerDialog$lambda$4$lambda$3 = DatePickerSpinnerDialogKt.DatePickerSpinnerDialog$lambda$4$lambda$3(Function1.this, mutableState22);
                return DatePickerSpinnerDialog$lambda$4$lambda$3;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        LocalDate localDate722 = localDate5;
        LocalDate localDate822 = localDate6;
        CustomDialogKt.CustomDialog(new SimpleButtonData(stringResource22, false, false, (Function0) rememberedValue2, 6, null), null, new SimpleButtonData(StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6), false, false, onDismissRequest, 6, null), onDismissRequest, false, ComposableLambdaKt.rememberComposableLambda(1201054955, true, new DatePickerSpinnerDialogKt$DatePickerSpinnerDialog$2(title, localDate6, localDate722, mutableState22), startRestartGroup, 54), startRestartGroup, ((i9 >> 6) & 7168) | 196608, 18);
        if (ComposerKt.isTraceInProgress()) {
        }
        localDate4 = localDate822;
        localDate5 = localDate722;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalDate DatePickerSpinnerDialog$lambda$1(MutableState<LocalDate> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerSpinnerDialog$lambda$4$lambda$3(Function1 function1, MutableState mutableState) {
        LocalDate DatePickerSpinnerDialog$lambda$1 = DatePickerSpinnerDialog$lambda$1(mutableState);
        Intrinsics.checkNotNullExpressionValue(DatePickerSpinnerDialog$lambda$1, "DatePickerSpinnerDialog$lambda$1(...)");
        function1.invoke(DatePickerSpinnerDialog$lambda$1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DatePickerSpinnerDialog$lambda$5(String str, LocalDate localDate, LocalDate localDate2, LocalDate localDate3, Function1 function1, Function0 function0, int i5, int i6, Composer composer, int i7) {
        DatePickerSpinnerDialog(str, localDate, localDate2, localDate3, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
