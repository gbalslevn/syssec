package dk.molslinjen.ui.views.reusable.input.dropdown;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.input.TextBoxKt;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownItem;
import dk.molslinjen.ui.views.reusable.input.dropdown.DropdownPickerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\u001a[\u0010\n\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u00032\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001aa\u0010\u0014\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u00032\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001aE\u0010\u0018\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0017\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c²\u0006\u000e\u0010\u000f\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001b\u001a\u00020\u001a8\n@\nX\u008a\u008e\u0002"}, d2 = {"T", "Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;", "selectedValue", BuildConfig.FLAVOR, "values", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onValueSelected", "Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownPickerSelectorStyle;", "selectorStyle", "DropdownPicker", "(Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;Ljava/util/List;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownPickerSelectorStyle;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/unit/Dp;", "minWidth", BuildConfig.FLAVOR, "showDropdown", "Lkotlin/Function0;", "onDismissRequest", "DropdownContent-AjpBEmI", "(FZLkotlin/jvm/functions/Function0;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DropdownContent", "value", "onClick", "showDivider", "DropdownRow", "(Ldk/molslinjen/ui/views/reusable/input/dropdown/DropdownItem;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "dropdownMinWidth", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DropdownPickerKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DropdownPickerSelectorStyle.values().length];
            try {
                iArr[DropdownPickerSelectorStyle.TextBox.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DropdownPickerSelectorStyle.SecondaryButton.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: DropdownContent-AjpBEmI, reason: not valid java name */
    private static final <T> void m3417DropdownContentAjpBEmI(final float f5, final boolean z5, final Function0<Unit> function0, final List<DropdownItem<T>> list, final Function1<? super DropdownItem<T>, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1332616316);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(f5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(list) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332616316, i6, -1, "dk.molslinjen.ui.views.reusable.input.dropdown.DropdownContent (DropdownPicker.kt:95)");
            }
            composer2 = startRestartGroup;
            AndroidMenu_androidKt.m769DropdownMenuIlH_yew(z5, function0, SizeKt.m338widthInVpY3zN4$default(Modifier.INSTANCE, f5, 0.0f, 2, null), 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(205122687, true, new DropdownPickerKt$DropdownContent$1(list, function1, function0), startRestartGroup, 54), composer2, (i6 >> 3) & 126, 48, 2040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DropdownContent_AjpBEmI$lambda$18;
                    DropdownContent_AjpBEmI$lambda$18 = DropdownPickerKt.DropdownContent_AjpBEmI$lambda$18(f5, z5, function0, list, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DropdownContent_AjpBEmI$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownContent_AjpBEmI$lambda$18(float f5, boolean z5, Function0 function0, List list, Function1 function1, int i5, Composer composer, int i6) {
        m3417DropdownContentAjpBEmI(f5, z5, function0, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> void DropdownPicker(final DropdownItem<T> selectedValue, final List<DropdownItem<T>> values, final Function1<? super DropdownItem<T>, Unit> onValueSelected, DropdownPickerSelectorStyle dropdownPickerSelectorStyle, Composer composer, final int i5, final int i6) {
        int i7;
        DropdownPickerSelectorStyle dropdownPickerSelectorStyle2;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int i8;
        int i9;
        Object rememberedValue3;
        Composer composer2;
        final DropdownPickerSelectorStyle dropdownPickerSelectorStyle3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(selectedValue, "selectedValue");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(onValueSelected, "onValueSelected");
        Composer startRestartGroup = composer.startRestartGroup(-1947255014);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(selectedValue) : startRestartGroup.changedInstance(selectedValue) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(values) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onValueSelected) ? 256 : 128;
        }
        int i10 = i6 & 8;
        if (i10 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            dropdownPickerSelectorStyle2 = dropdownPickerSelectorStyle;
            i7 |= startRestartGroup.changed(dropdownPickerSelectorStyle2) ? 2048 : 1024;
            if ((i7 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                DropdownPickerSelectorStyle dropdownPickerSelectorStyle4 = i10 == 0 ? DropdownPickerSelectorStyle.TextBox : dropdownPickerSelectorStyle2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1947255014, i7, -1, "dk.molslinjen.ui.views.reusable.input.dropdown.DropdownPicker (DropdownPicker.kt:41)");
                }
                startRestartGroup.startReplaceGroup(-1154299787);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(!DropdownPicker$lambda$1(mutableState) ? 0.0f : 180.0f, null, 0.0f, null, null, startRestartGroup, 0, 30);
                startRestartGroup.startReplaceGroup(-1154294511);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableState mutableState2 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                i8 = WhenMappings.$EnumSwitchMapping$0[dropdownPickerSelectorStyle4.ordinal()];
                if (i8 != 1) {
                    i9 = 0;
                    startRestartGroup.startReplaceGroup(-535347931);
                    startRestartGroup.startReplaceGroup(-535346566);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: e2.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit DropdownPicker$lambda$16$lambda$7$lambda$6;
                                DropdownPicker$lambda$16$lambda$7$lambda$6 = DropdownPickerKt.DropdownPicker$lambda$16$lambda$7$lambda$6(MutableState.this, (LayoutCoordinates) obj);
                                return DropdownPicker$lambda$16$lambda$7$lambda$6;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue4);
                    String displayValue = selectedValue.getDisplayValue();
                    startRestartGroup.startReplaceGroup(-535341751);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: e2.b
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit DropdownPicker$lambda$16$lambda$9$lambda$8;
                                DropdownPicker$lambda$16$lambda$9$lambda$8 = DropdownPickerKt.DropdownPicker$lambda$16$lambda$9$lambda$8(MutableState.this);
                                return DropdownPicker$lambda$16$lambda$9$lambda$8;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    Function0 function0 = (Function0) rememberedValue5;
                    startRestartGroup.endReplaceGroup();
                    TextBoxKt.m3414TextBoxNpQZenA(onGloballyPositioned, displayValue, null, null, false, function0, DropdownPicker$lambda$1(mutableState), false, 0L, DropdownPicker$lambda$1(mutableState) ? AppColor.INSTANCE.m3265getGrey20d7_KjU() : AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), null, ComposableLambdaKt.rememberComposableLambda(-2079377646, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.dropdown.DropdownPickerKt$DropdownPicker$1$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i11) {
                            if ((i11 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2079377646, i11, -1, "dk.molslinjen.ui.views.reusable.input.dropdown.DropdownPicker.<anonymous>.<anonymous> (DropdownPicker.kt:60)");
                            }
                            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_chevron_up, composer3, 6), Accessibility.INSTANCE.getSkip(), RotateKt.rotate(Modifier.INSTANCE, animateFloatAsState.getValue().floatValue()), AppColor.INSTANCE.m3265getGrey20d7_KjU(), composer3, 3072, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, 196614, 390, 2460);
                    startRestartGroup.endReplaceGroup();
                } else {
                    if (i8 != 2) {
                        startRestartGroup.startReplaceGroup(-535349834);
                        startRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    startRestartGroup.startReplaceGroup(-535320270);
                    startRestartGroup.startReplaceGroup(-535318150);
                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                    if (rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function1() { // from class: e2.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit DropdownPicker$lambda$16$lambda$11$lambda$10;
                                DropdownPicker$lambda$16$lambda$11$lambda$10 = DropdownPickerKt.DropdownPicker$lambda$16$lambda$11$lambda$10(MutableState.this, (LayoutCoordinates) obj);
                                return DropdownPicker$lambda$16$lambda$11$lambda$10;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue6);
                    String displayValue2 = selectedValue.getDisplayValue();
                    startRestartGroup.startReplaceGroup(-535313367);
                    Object rememberedValue7 = startRestartGroup.rememberedValue();
                    if (rememberedValue7 == companion.getEmpty()) {
                        rememberedValue7 = new Function0() { // from class: e2.d
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit DropdownPicker$lambda$16$lambda$13$lambda$12;
                                DropdownPicker$lambda$16$lambda$13$lambda$12 = DropdownPickerKt.DropdownPicker$lambda$16$lambda$13$lambda$12(MutableState.this);
                                return DropdownPicker$lambda$16$lambda$13$lambda$12;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    startRestartGroup.endReplaceGroup();
                    i9 = 0;
                    SecondaryButtonKt.m3406SecondaryButtonbZJ32A(onGloballyPositioned2, displayValue2, (Function0) rememberedValue7, null, false, null, false, null, Integer.valueOf(R.drawable.icon_chevron_down), 0L, false, startRestartGroup, 100663686, 0, 1784);
                    startRestartGroup.endReplaceGroup();
                }
                float pxToDp = ComposeExtensionsKt.pxToDp(DropdownPicker$lambda$4(mutableState2), startRestartGroup, i9);
                boolean DropdownPicker$lambda$1 = DropdownPicker$lambda$1(mutableState);
                startRestartGroup.startReplaceGroup(-535305270);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: e2.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit DropdownPicker$lambda$16$lambda$15$lambda$14;
                            DropdownPicker$lambda$16$lambda$15$lambda$14 = DropdownPickerKt.DropdownPicker$lambda$16$lambda$15$lambda$14(MutableState.this);
                            return DropdownPicker$lambda$16$lambda$15$lambda$14;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                int i11 = i7 << 6;
                composer2 = startRestartGroup;
                m3417DropdownContentAjpBEmI(pxToDp, DropdownPicker$lambda$1, (Function0) rememberedValue3, values, onValueSelected, startRestartGroup, (i11 & 7168) | 384 | (i11 & 57344));
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dropdownPickerSelectorStyle3 = dropdownPickerSelectorStyle4;
            } else {
                startRestartGroup.skipToGroupEnd();
                dropdownPickerSelectorStyle3 = dropdownPickerSelectorStyle2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: e2.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DropdownPicker$lambda$17;
                        DropdownPicker$lambda$17 = DropdownPickerKt.DropdownPicker$lambda$17(DropdownItem.this, values, onValueSelected, dropdownPickerSelectorStyle3, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return DropdownPicker$lambda$17;
                    }
                });
                return;
            }
            return;
        }
        dropdownPickerSelectorStyle2 = dropdownPickerSelectorStyle;
        if ((i7 & 1171) == 1170) {
        }
        if (i10 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-1154299787);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final MutableState mutableState3 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        final State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!DropdownPicker$lambda$1(mutableState3) ? 0.0f : 180.0f, null, 0.0f, null, null, startRestartGroup, 0, 30);
        startRestartGroup.startReplaceGroup(-1154294511);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        final MutableState mutableState22 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        Modifier.Companion companion22 = Modifier.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion22);
        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion32.getSetModifier());
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        i8 = WhenMappings.$EnumSwitchMapping$0[dropdownPickerSelectorStyle4.ordinal()];
        if (i8 != 1) {
        }
        float pxToDp2 = ComposeExtensionsKt.pxToDp(DropdownPicker$lambda$4(mutableState22), startRestartGroup, i9);
        boolean DropdownPicker$lambda$12 = DropdownPicker$lambda$1(mutableState3);
        startRestartGroup.startReplaceGroup(-535305270);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        int i112 = i7 << 6;
        composer2 = startRestartGroup;
        m3417DropdownContentAjpBEmI(pxToDp2, DropdownPicker$lambda$12, (Function0) rememberedValue3, values, onValueSelected, startRestartGroup, (i112 & 7168) | 384 | (i112 & 57344));
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        dropdownPickerSelectorStyle3 = dropdownPickerSelectorStyle4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final boolean DropdownPicker$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownPicker$lambda$16$lambda$11$lambda$10(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DropdownPicker$lambda$5(mutableState, IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownPicker$lambda$16$lambda$13$lambda$12(MutableState mutableState) {
        DropdownPicker$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownPicker$lambda$16$lambda$15$lambda$14(MutableState mutableState) {
        DropdownPicker$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownPicker$lambda$16$lambda$7$lambda$6(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DropdownPicker$lambda$5(mutableState, IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownPicker$lambda$16$lambda$9$lambda$8(MutableState mutableState) {
        DropdownPicker$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownPicker$lambda$17(DropdownItem dropdownItem, List list, Function1 function1, DropdownPickerSelectorStyle dropdownPickerSelectorStyle, int i5, int i6, Composer composer, int i7) {
        DropdownPicker(dropdownItem, list, function1, dropdownPickerSelectorStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void DropdownPicker$lambda$2(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    private static final int DropdownPicker$lambda$4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void DropdownPicker$lambda$5(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> void DropdownRow(final DropdownItem<T> dropdownItem, final Function1<? super DropdownItem<T>, Unit> function1, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(547628639);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(dropdownItem) : startRestartGroup.changedInstance(dropdownItem) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(547628639, i6, -1, "dk.molslinjen.ui.views.reusable.input.dropdown.DropdownRow (DropdownPicker.kt:115)");
            }
            boolean z6 = true;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-1282697017);
            boolean z7 = (i6 & 112) == 32;
            if ((i6 & 14) != 4 && ((i6 & 8) == 0 || !startRestartGroup.changedInstance(dropdownItem))) {
                z6 = false;
            }
            boolean z8 = z7 | z6;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: e2.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DropdownRow$lambda$20$lambda$19;
                        DropdownRow$lambda$20$lambda$19 = DropdownPickerKt.DropdownRow$lambda$20$lambda$19(Function1.this, dropdownItem);
                        return DropdownRow$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(dropdownItem.getDisplayValue(), PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(fillMaxWidth$default, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(30), Dp.m2599constructorimpl(16)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65532);
            if (z5) {
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e2.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DropdownRow$lambda$21;
                    DropdownRow$lambda$21 = DropdownPickerKt.DropdownRow$lambda$21(DropdownItem.this, function1, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DropdownRow$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownRow$lambda$20$lambda$19(Function1 function1, DropdownItem dropdownItem) {
        function1.invoke(dropdownItem);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownRow$lambda$21(DropdownItem dropdownItem, Function1 function1, boolean z5, int i5, Composer composer, int i6) {
        DropdownRow(dropdownItem, function1, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
