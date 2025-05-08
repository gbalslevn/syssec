package dk.molslinjen.ui.views.reusable.input.checkbox;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import dk.molslinjen.ui.views.reusable.NoRippleCompositionProviderKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControlKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aw\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0081\u0001\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "isChecked", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onCheckChange", "Lkotlin/Function0;", "onClickDisabled", "enabled", "Ldk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlSize;", "checkboxSize", "Ldk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlStyle;", "style", "showError", "LabeledSelectionControl", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLdk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlSize;Ldk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlStyle;ZLandroidx/compose/runtime/Composer;II)V", "labelModifier", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLdk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlSize;Ldk/molslinjen/ui/views/reusable/input/checkbox/SelectionControlStyle;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LabeledSelectionControlKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LabeledSelectionControl(Modifier modifier, final String label, final boolean z5, final Function1<? super Boolean, Unit> onCheckChange, Function0<Unit> function0, boolean z6, SelectionControlSize selectionControlSize, SelectionControlStyle selectionControlStyle, boolean z7, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Function0<Unit> function02;
        int i8;
        boolean z8;
        int i9;
        SelectionControlSize selectionControlSize2;
        int i10;
        int i11;
        Composer composer2;
        final boolean z9;
        final Function0<Unit> function03;
        final boolean z10;
        final SelectionControlSize selectionControlSize3;
        final SelectionControlStyle selectionControlStyle2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onCheckChange, "onCheckChange");
        Composer startRestartGroup = composer.startRestartGroup(-1201505459);
        int i12 = i6 & 1;
        if (i12 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(label) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(onCheckChange) ? 2048 : 1024;
        }
        int i13 = i6 & 16;
        if (i13 != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
            i8 = i6 & 32;
            if (i8 == 0) {
                i7 |= 196608;
            } else if ((196608 & i5) == 0) {
                z8 = z6;
                i7 |= startRestartGroup.changed(z8) ? 131072 : 65536;
                i9 = i6 & 64;
                if (i9 != 0) {
                    i7 |= 1572864;
                } else if ((1572864 & i5) == 0) {
                    selectionControlSize2 = selectionControlSize;
                    i7 |= startRestartGroup.changed(selectionControlSize2) ? 1048576 : 524288;
                    i10 = i6 & 128;
                    if (i10 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(selectionControlStyle) ? 8388608 : 4194304;
                    }
                    i11 = i6 & 256;
                    if (i11 == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i7 |= startRestartGroup.changed(z7) ? 67108864 : 33554432;
                    }
                    if ((i7 & 38347923) != 38347922 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        z9 = z7;
                        modifier3 = modifier2;
                        function03 = function02;
                        z10 = z8;
                        selectionControlSize3 = selectionControlSize2;
                        composer2 = startRestartGroup;
                        selectionControlStyle2 = selectionControlStyle;
                    } else {
                        Modifier modifier4 = i12 == 0 ? Modifier.INSTANCE : modifier2;
                        Function0<Unit> function04 = i13 == 0 ? null : function02;
                        boolean z11 = i8 == 0 ? true : z8;
                        SelectionControlSize selectionControlSize4 = i9 == 0 ? SelectionControlSize.Regular : selectionControlSize2;
                        SelectionControlStyle selectionControlStyle3 = i10 == 0 ? SelectionControlStyle.Checkbox : selectionControlStyle;
                        boolean z12 = i11 == 0 ? false : z7;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1201505459, i7, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControl (LabeledSelectionControl.kt:29)");
                        }
                        int i14 = i7 << 3;
                        composer2 = startRestartGroup;
                        LabeledSelectionControl(modifier4, null, new AnnotatedString(label, null, null, 6, null), z5, onCheckChange, function04, z11, selectionControlSize4, selectionControlStyle3, z12, startRestartGroup, (i7 & 14) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z9 = z12;
                        function03 = function04;
                        z10 = z11;
                        selectionControlSize3 = selectionControlSize4;
                        selectionControlStyle2 = selectionControlStyle3;
                        modifier3 = modifier4;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: d2.d
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LabeledSelectionControl$lambda$0;
                                LabeledSelectionControl$lambda$0 = LabeledSelectionControlKt.LabeledSelectionControl$lambda$0(Modifier.this, label, z5, onCheckChange, function03, z10, selectionControlSize3, selectionControlStyle2, z9, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return LabeledSelectionControl$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                selectionControlSize2 = selectionControlSize;
                i10 = i6 & 128;
                if (i10 == 0) {
                }
                i11 = i6 & 256;
                if (i11 == 0) {
                }
                if ((i7 & 38347923) != 38347922) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i142 = i7 << 3;
                composer2 = startRestartGroup;
                LabeledSelectionControl(modifier4, null, new AnnotatedString(label, null, null, 6, null), z5, onCheckChange, function04, z11, selectionControlSize4, selectionControlStyle3, z12, startRestartGroup, (i7 & 14) | (i142 & 7168) | (57344 & i142) | (458752 & i142) | (3670016 & i142) | (29360128 & i142) | (234881024 & i142) | (i142 & 1879048192), 2);
                if (ComposerKt.isTraceInProgress()) {
                }
                z9 = z12;
                function03 = function04;
                z10 = z11;
                selectionControlSize3 = selectionControlSize4;
                selectionControlStyle2 = selectionControlStyle3;
                modifier3 = modifier4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z8 = z6;
            i9 = i6 & 64;
            if (i9 != 0) {
            }
            selectionControlSize2 = selectionControlSize;
            i10 = i6 & 128;
            if (i10 == 0) {
            }
            i11 = i6 & 256;
            if (i11 == 0) {
            }
            if ((i7 & 38347923) != 38347922) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1422 = i7 << 3;
            composer2 = startRestartGroup;
            LabeledSelectionControl(modifier4, null, new AnnotatedString(label, null, null, 6, null), z5, onCheckChange, function04, z11, selectionControlSize4, selectionControlStyle3, z12, startRestartGroup, (i7 & 14) | (i1422 & 7168) | (57344 & i1422) | (458752 & i1422) | (3670016 & i1422) | (29360128 & i1422) | (234881024 & i1422) | (i1422 & 1879048192), 2);
            if (ComposerKt.isTraceInProgress()) {
            }
            z9 = z12;
            function03 = function04;
            z10 = z11;
            selectionControlSize3 = selectionControlSize4;
            selectionControlStyle2 = selectionControlStyle3;
            modifier3 = modifier4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function02 = function0;
        i8 = i6 & 32;
        if (i8 == 0) {
        }
        z8 = z6;
        i9 = i6 & 64;
        if (i9 != 0) {
        }
        selectionControlSize2 = selectionControlSize;
        i10 = i6 & 128;
        if (i10 == 0) {
        }
        i11 = i6 & 256;
        if (i11 == 0) {
        }
        if ((i7 & 38347923) != 38347922) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i14222 = i7 << 3;
        composer2 = startRestartGroup;
        LabeledSelectionControl(modifier4, null, new AnnotatedString(label, null, null, 6, null), z5, onCheckChange, function04, z11, selectionControlSize4, selectionControlStyle3, z12, startRestartGroup, (i7 & 14) | (i14222 & 7168) | (57344 & i14222) | (458752 & i14222) | (3670016 & i14222) | (29360128 & i14222) | (234881024 & i14222) | (i14222 & 1879048192), 2);
        if (ComposerKt.isTraceInProgress()) {
        }
        z9 = z12;
        function03 = function04;
        z10 = z11;
        selectionControlSize3 = selectionControlSize4;
        selectionControlStyle2 = selectionControlStyle3;
        modifier3 = modifier4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabeledSelectionControl$lambda$0(Modifier modifier, String str, boolean z5, Function1 function1, Function0 function0, boolean z6, SelectionControlSize selectionControlSize, SelectionControlStyle selectionControlStyle, boolean z7, int i5, int i6, Composer composer, int i7) {
        LabeledSelectionControl(modifier, str, z5, function1, function0, z6, selectionControlSize, selectionControlStyle, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabeledSelectionControl$lambda$1(Modifier modifier, Modifier modifier2, AnnotatedString annotatedString, boolean z5, Function1 function1, Function0 function0, boolean z6, SelectionControlSize selectionControlSize, SelectionControlStyle selectionControlStyle, boolean z7, int i5, int i6, Composer composer, int i7) {
        LabeledSelectionControl(modifier, modifier2, annotatedString, z5, function1, function0, z6, selectionControlSize, selectionControlStyle, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LabeledSelectionControl(Modifier modifier, Modifier modifier2, final AnnotatedString label, final boolean z5, final Function1<? super Boolean, Unit> onCheckChange, Function0<Unit> function0, boolean z6, SelectionControlSize selectionControlSize, SelectionControlStyle selectionControlStyle, boolean z7, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final Modifier modifier3;
        final Modifier modifier4;
        final Function0<Unit> function02;
        final boolean z8;
        final SelectionControlSize selectionControlSize2;
        final SelectionControlStyle selectionControlStyle2;
        final boolean z9;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onCheckChange, "onCheckChange");
        Composer startRestartGroup = composer.startRestartGroup(-941991446);
        int i13 = i6 & 1;
        if (i13 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i14 = i6 & 2;
        if (i14 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(label) ? 256 : 128;
            }
            if ((i6 & 8) == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
            }
            if ((i6 & 16) == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changedInstance(onCheckChange) ? 16384 : 8192;
            }
            i8 = i6 & 32;
            if (i8 == 0) {
                i7 |= 196608;
            } else if ((196608 & i5) == 0) {
                i7 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
                i9 = i6 & 64;
                if (i9 != 0) {
                    i7 |= 1572864;
                } else if ((1572864 & i5) == 0) {
                    i7 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
                    i10 = i6 & 128;
                    if (i10 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(selectionControlSize) ? 8388608 : 4194304;
                    }
                    i11 = i6 & 256;
                    if (i11 == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i7 |= startRestartGroup.changed(selectionControlStyle) ? 67108864 : 33554432;
                    }
                    i12 = i6 & 512;
                    if (i12 == 0) {
                        i7 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i7 |= startRestartGroup.changed(z7) ? 536870912 : 268435456;
                    }
                    if ((i7 & 306783379) != 306783378 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        modifier4 = modifier2;
                        function02 = function0;
                        z8 = z6;
                        selectionControlSize2 = selectionControlSize;
                        selectionControlStyle2 = selectionControlStyle;
                        z9 = z7;
                        composer2 = startRestartGroup;
                    } else {
                        Modifier modifier5 = i13 == 0 ? Modifier.INSTANCE : modifier;
                        Modifier modifier6 = i14 == 0 ? Modifier.INSTANCE : modifier2;
                        Function0<Unit> function03 = i8 == 0 ? null : function0;
                        boolean z10 = i9 == 0 ? true : z6;
                        SelectionControlSize selectionControlSize3 = i10 == 0 ? SelectionControlSize.Regular : selectionControlSize;
                        SelectionControlStyle selectionControlStyle3 = i11 == 0 ? SelectionControlStyle.Checkbox : selectionControlStyle;
                        boolean z11 = i12 == 0 ? false : z7;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-941991446, i7, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControl (LabeledSelectionControl.kt:55)");
                        }
                        composer2 = startRestartGroup;
                        NoRippleCompositionProviderKt.NoRippleCompositionProvider(ComposableLambdaKt.rememberComposableLambda(1907283659, true, new LabeledSelectionControlKt$LabeledSelectionControl$2(modifier5, z5, (z10 && function03 == null) ? false : true, z10, onCheckChange, function03, selectionControlSize3, selectionControlStyle3, z11, modifier6, label), composer2, 54), composer2, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        modifier4 = modifier6;
                        function02 = function03;
                        z8 = z10;
                        selectionControlSize2 = selectionControlSize3;
                        selectionControlStyle2 = selectionControlStyle3;
                        z9 = z11;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: d2.e
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LabeledSelectionControl$lambda$1;
                                LabeledSelectionControl$lambda$1 = LabeledSelectionControlKt.LabeledSelectionControl$lambda$1(Modifier.this, modifier4, label, z5, onCheckChange, function02, z8, selectionControlSize2, selectionControlStyle2, z9, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return LabeledSelectionControl$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
                i10 = i6 & 128;
                if (i10 == 0) {
                }
                i11 = i6 & 256;
                if (i11 == 0) {
                }
                i12 = i6 & 512;
                if (i12 == 0) {
                }
                if ((i7 & 306783379) != 306783378) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                NoRippleCompositionProviderKt.NoRippleCompositionProvider(ComposableLambdaKt.rememberComposableLambda(1907283659, true, new LabeledSelectionControlKt$LabeledSelectionControl$2(modifier5, z5, (z10 && function03 == null) ? false : true, z10, onCheckChange, function03, selectionControlSize3, selectionControlStyle3, z11, modifier6, label), composer2, 54), composer2, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier5;
                modifier4 = modifier6;
                function02 = function03;
                z8 = z10;
                selectionControlSize2 = selectionControlSize3;
                selectionControlStyle2 = selectionControlStyle3;
                z9 = z11;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i9 = i6 & 64;
            if (i9 != 0) {
            }
            i10 = i6 & 128;
            if (i10 == 0) {
            }
            i11 = i6 & 256;
            if (i11 == 0) {
            }
            i12 = i6 & 512;
            if (i12 == 0) {
            }
            if ((i7 & 306783379) != 306783378) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            NoRippleCompositionProviderKt.NoRippleCompositionProvider(ComposableLambdaKt.rememberComposableLambda(1907283659, true, new LabeledSelectionControlKt$LabeledSelectionControl$2(modifier5, z5, (z10 && function03 == null) ? false : true, z10, onCheckChange, function03, selectionControlSize3, selectionControlStyle3, z11, modifier6, label), composer2, 54), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier5;
            modifier4 = modifier6;
            function02 = function03;
            z8 = z10;
            selectionControlSize2 = selectionControlSize3;
            selectionControlStyle2 = selectionControlStyle3;
            z9 = z11;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i6 & 4) == 0) {
        }
        if ((i6 & 8) == 0) {
        }
        if ((i6 & 16) == 0) {
        }
        i8 = i6 & 32;
        if (i8 == 0) {
        }
        i9 = i6 & 64;
        if (i9 != 0) {
        }
        i10 = i6 & 128;
        if (i10 == 0) {
        }
        i11 = i6 & 256;
        if (i11 == 0) {
        }
        i12 = i6 & 512;
        if (i12 == 0) {
        }
        if ((i7 & 306783379) != 306783378) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        NoRippleCompositionProviderKt.NoRippleCompositionProvider(ComposableLambdaKt.rememberComposableLambda(1907283659, true, new LabeledSelectionControlKt$LabeledSelectionControl$2(modifier5, z5, (z10 && function03 == null) ? false : true, z10, onCheckChange, function03, selectionControlSize3, selectionControlStyle3, z11, modifier6, label), composer2, 54), composer2, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier5;
        modifier4 = modifier6;
        function02 = function03;
        z8 = z10;
        selectionControlSize2 = selectionControlSize3;
        selectionControlStyle2 = selectionControlStyle3;
        z9 = z11;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
