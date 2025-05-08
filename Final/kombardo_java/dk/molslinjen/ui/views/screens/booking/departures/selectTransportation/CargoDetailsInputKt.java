package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsInputKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0095\u0001\u0010\u0013\u001a\u00020\n*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScope;", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "transportationCargoInfo", BuildConfig.FLAVOR, "isWeightRequired", "isNotesRequired", BuildConfig.FLAVOR, "maxWeightAllowed", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onTotalWeightChange", "onNote1Change", "onNote2Change", "onNote3Change", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "CargoDetailsInput", "(Landroidx/compose/foundation/layout/ColumnScope;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;ZZDLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CargoDetailsInputKt {
    public static final void CargoDetailsInput(final ColumnScope columnScope, final TransportationCargoInfo transportationCargoInfo, final boolean z5, final boolean z6, final double d5, final Function1<? super String, Unit> onTotalWeightChange, final Function1<? super String, Unit> onNote1Change, final Function1<? super String, Unit> onNote2Change, final Function1<? super String, Unit> onNote3Change, final IFormValidator validator, final FocusRequester focusRequester, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        Composer composer2;
        int i10;
        int i11;
        String note3;
        String note2;
        String note1;
        Double totalWeight;
        String num;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(onTotalWeightChange, "onTotalWeightChange");
        Intrinsics.checkNotNullParameter(onNote1Change, "onNote1Change");
        Intrinsics.checkNotNullParameter(onNote2Change, "onNote2Change");
        Intrinsics.checkNotNullParameter(onNote3Change, "onNote3Change");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Composer startRestartGroup = composer.startRestartGroup(817099953);
        if ((i5 & 48) == 0) {
            i7 = (startRestartGroup.changedInstance(transportationCargoInfo) ? 32 : 16) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changed(d5) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changedInstance(onTotalWeightChange) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(onNote1Change) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(onNote2Change) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(onNote3Change) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i7 |= (1073741824 & i5) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changed(focusRequester) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i7 & 306783377) == 306783376 && (i8 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(817099953, i7, i8, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsInput (CargoDetailsInput.kt:37)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            startRestartGroup.startReplaceGroup(-1969669232);
            if (z5) {
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceGroup(-1969668390);
                boolean changedInstance = startRestartGroup.changedInstance(transportationCargoInfo) | ((i8 & 14) == 4);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new CargoDetailsInputKt$CargoDetailsInput$1$1(transportationCargoInfo, focusRequester, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(companion, focusRequester);
                CargoFormField cargoFormField = CargoFormField.Weight;
                String str = (transportationCargoInfo == null || (totalWeight = transportationCargoInfo.getTotalWeight()) == null || (num = Integer.valueOf((int) totalWeight.doubleValue()).toString()) == null) ? BuildConfig.FLAVOR : num;
                String stringResource = StringResources_androidKt.stringResource(R.string.cargoDetails_weight_description, new Object[]{Double.valueOf(d5)}, startRestartGroup, 6);
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2417getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null);
                List emptyList = CollectionsKt.emptyList();
                Integer valueOf = Integer.valueOf(R.string.cargoDetails_weight_title);
                startRestartGroup.startReplaceGroup(-1969659570);
                boolean z7 = (458752 & i7) == 131072;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: R2.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CargoDetailsInput$lambda$2$lambda$1;
                            CargoDetailsInput$lambda$2$lambda$1 = CargoDetailsInputKt.CargoDetailsInput$lambda$2$lambda$1(Function1.this, (String) obj);
                            return CargoDetailsInput$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function1 function1 = (Function1) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1969657684);
                boolean changedInstance2 = startRestartGroup.changedInstance(focusManager);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: R2.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CargoDetailsInput$lambda$4$lambda$3;
                            CargoDetailsInput$lambda$4$lambda$3 = CargoDetailsInputKt.CargoDetailsInput$lambda$4$lambda$3(FocusManager.this);
                            return CargoDetailsInput$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                i10 = 24;
                i9 = i7;
                composer2 = startRestartGroup;
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(focusRequester2, false, 0.0f, emptyList, valueOf, null, stringResource, function1, (Function0) rememberedValue3, str, false, null, false, false, 0, cargoFormField, validator, keyboardOptions, null, null, 0L, null, false, 0, composer2, 27648, ((i7 >> 9) & 3670016) | 12779520, 384, 12352550);
                i11 = 6;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer2, 6);
            } else {
                i9 = i7;
                composer2 = startRestartGroup;
                i10 = 24;
                i11 = 6;
            }
            composer2.endReplaceGroup();
            if (z6) {
                CargoFormField cargoFormField2 = CargoFormField.Note1;
                String str2 = (transportationCargoInfo == null || (note1 = transportationCargoInfo.getNote1()) == null) ? BuildConfig.FLAVOR : note1;
                String stringResource2 = StringResources_androidKt.stringResource(R.string.cargoDetails_note1_description, composer2, i11);
                List emptyList2 = CollectionsKt.emptyList();
                Integer valueOf2 = Integer.valueOf(R.string.cargoDetails_note1_title);
                composer2.startReplaceGroup(-1969635192);
                boolean z8 = (i9 & 3670016) == 1048576;
                Object rememberedValue4 = composer2.rememberedValue();
                if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: R2.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CargoDetailsInput$lambda$6$lambda$5;
                            CargoDetailsInput$lambda$6$lambda$5 = CargoDetailsInputKt.CargoDetailsInput$lambda$6$lambda$5(Function1.this, (String) obj);
                            return CargoDetailsInput$lambda$6$lambda$5;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                Function1 function12 = (Function1) rememberedValue4;
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(-1969633492);
                boolean changedInstance3 = composer2.changedInstance(focusManager);
                Object rememberedValue5 = composer2.rememberedValue();
                if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: R2.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CargoDetailsInput$lambda$8$lambda$7;
                            CargoDetailsInput$lambda$8$lambda$7 = CargoDetailsInputKt.CargoDetailsInput$lambda$8$lambda$7(FocusManager.this);
                            return CargoDetailsInput$lambda$8$lambda$7;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceGroup();
                int i12 = ((i9 >> 9) & 3670016) | 196608;
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList2, valueOf2, null, stringResource2, function12, (Function0) rememberedValue5, str2, false, null, false, false, 0, cargoFormField2, validator, null, null, null, 0L, null, true, 0, composer2, 27648, i12, 384, 12483623);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                float f5 = i10;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer2, 6);
                CargoFormField cargoFormField3 = CargoFormField.Note2;
                String str3 = (transportationCargoInfo == null || (note2 = transportationCargoInfo.getNote2()) == null) ? BuildConfig.FLAVOR : note2;
                String stringResource3 = StringResources_androidKt.stringResource(R.string.cargoDetails_note2_description, composer2, 6);
                List emptyList3 = CollectionsKt.emptyList();
                Integer valueOf3 = Integer.valueOf(R.string.cargoDetails_note2_title);
                composer2.startReplaceGroup(-1969616248);
                boolean z9 = (i9 & 29360128) == 8388608;
                Object rememberedValue6 = composer2.rememberedValue();
                if (z9 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: R2.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CargoDetailsInput$lambda$10$lambda$9;
                            CargoDetailsInput$lambda$10$lambda$9 = CargoDetailsInputKt.CargoDetailsInput$lambda$10$lambda$9(Function1.this, (String) obj);
                            return CargoDetailsInput$lambda$10$lambda$9;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue6);
                }
                Function1 function13 = (Function1) rememberedValue6;
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(-1969614548);
                boolean changedInstance4 = composer2.changedInstance(focusManager);
                Object rememberedValue7 = composer2.rememberedValue();
                if (changedInstance4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function0() { // from class: R2.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CargoDetailsInput$lambda$12$lambda$11;
                            CargoDetailsInput$lambda$12$lambda$11 = CargoDetailsInputKt.CargoDetailsInput$lambda$12$lambda$11(FocusManager.this);
                            return CargoDetailsInput$lambda$12$lambda$11;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                composer2.endReplaceGroup();
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList3, valueOf3, null, stringResource3, function13, (Function0) rememberedValue7, str3, false, null, false, false, 0, cargoFormField3, validator, null, null, null, 0L, null, true, 0, composer2, 27648, i12, 384, 12483623);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer2, 6);
                CargoFormField cargoFormField4 = CargoFormField.Note3;
                String str4 = (transportationCargoInfo == null || (note3 = transportationCargoInfo.getNote3()) == null) ? BuildConfig.FLAVOR : note3;
                String stringResource4 = StringResources_androidKt.stringResource(R.string.cargoDetails_note3_description, composer2, 6);
                List emptyList4 = CollectionsKt.emptyList();
                Integer valueOf4 = Integer.valueOf(R.string.cargoDetails_note3_title);
                composer2.startReplaceGroup(-1969597304);
                boolean z10 = (i9 & 234881024) == 67108864;
                Object rememberedValue8 = composer2.rememberedValue();
                if (z10 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue8 = new Function1() { // from class: R2.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CargoDetailsInput$lambda$14$lambda$13;
                            CargoDetailsInput$lambda$14$lambda$13 = CargoDetailsInputKt.CargoDetailsInput$lambda$14$lambda$13(Function1.this, (String) obj);
                            return CargoDetailsInput$lambda$14$lambda$13;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue8);
                }
                Function1 function14 = (Function1) rememberedValue8;
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(-1969595604);
                boolean changedInstance5 = composer2.changedInstance(focusManager);
                Object rememberedValue9 = composer2.rememberedValue();
                if (changedInstance5 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue9 = new Function0() { // from class: R2.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CargoDetailsInput$lambda$16$lambda$15;
                            CargoDetailsInput$lambda$16$lambda$15 = CargoDetailsInputKt.CargoDetailsInput$lambda$16$lambda$15(FocusManager.this);
                            return CargoDetailsInput$lambda$16$lambda$15;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue9);
                }
                composer2.endReplaceGroup();
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList4, valueOf4, null, stringResource4, function14, (Function0) rememberedValue9, str4, false, null, false, false, 0, cargoFormField4, validator, null, null, null, 0L, null, true, 0, composer2, 27648, i12, 384, 12483623);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R2.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CargoDetailsInput$lambda$17;
                    CargoDetailsInput$lambda$17 = CargoDetailsInputKt.CargoDetailsInput$lambda$17(ColumnScope.this, transportationCargoInfo, z5, z6, d5, onTotalWeightChange, onNote1Change, onNote2Change, onNote3Change, validator, focusRequester, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return CargoDetailsInput$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$10$lambda$9(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$12$lambda$11(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$14$lambda$13(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$16$lambda$15(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$17(ColumnScope columnScope, TransportationCargoInfo transportationCargoInfo, boolean z5, boolean z6, double d5, Function1 function1, Function1 function12, Function1 function13, Function1 function14, IFormValidator iFormValidator, FocusRequester focusRequester, int i5, int i6, Composer composer, int i7) {
        CargoDetailsInput(columnScope, transportationCargoInfo, z5, z6, d5, function1, function12, function13, function14, iFormValidator, focusRequester, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$2$lambda$1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$4$lambda$3(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$6$lambda$5(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CargoDetailsInput$lambda$8$lambda$7(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }
}
