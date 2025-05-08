package androidx.compose.material3;

import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ai\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aO\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0016\u001a\u00020\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u001a\u0010\u001a\u001a\u00020\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\"\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017\"\u0014\u0010\u001d\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017\"\u0014\u0010\u001e\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017\"\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\"\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020 0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {BuildConfig.FLAVOR, "checked", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onCheckedChange", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", "thumbContent", "enabled", "Landroidx/compose/material3/SwitchColors;", "colors", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Switch", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/interaction/InteractionSource;", "Landroidx/compose/ui/graphics/Shape;", "thumbShape", "SwitchImpl", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SwitchColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/unit/Dp;", "ThumbDiameter", "F", "getThumbDiameter", "()F", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "SwitchWidth", "SwitchHeight", "ThumbPadding", "Landroidx/compose/animation/core/SnapSpec;", BuildConfig.FLAVOR, "SnapSpec", "Landroidx/compose/animation/core/SnapSpec;", "Landroidx/compose/animation/core/TweenSpec;", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final SnapSpec<Float> SnapSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float UncheckedThumbDiameter;

    static {
        SwitchTokens switchTokens = SwitchTokens.INSTANCE;
        float m1155getSelectedHandleWidthD9Ej5fM = switchTokens.m1155getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = m1155getSelectedHandleWidthD9Ej5fM;
        UncheckedThumbDiameter = switchTokens.m1160getUnselectedHandleWidthD9Ej5fM();
        SwitchWidth = switchTokens.m1159getTrackWidthD9Ej5fM();
        float m1157getTrackHeightD9Ej5fM = switchTokens.m1157getTrackHeightD9Ej5fM();
        SwitchHeight = m1157getTrackHeightD9Ej5fM;
        ThumbPadding = Dp.m2599constructorimpl(Dp.m2599constructorimpl(m1157getTrackHeightD9Ej5fM - m1155getSelectedHandleWidthD9Ej5fM) / 2);
        SnapSpec = new SnapSpec<>(0, 1, null);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z5, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z6, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i5, final int i6) {
        int i7;
        final Modifier modifier2;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i9;
        boolean z7;
        SwitchColors switchColors2;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function23;
        boolean z8;
        SwitchColors switchColors3;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource4;
        int i12;
        Object obj;
        Modifier modifier4;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final boolean z9;
        final SwitchColors switchColors4;
        ScopeUpdateScope endRestartGroup;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1580463220);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i14 = i6 & 4;
        if (i14 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                function22 = function2;
                i7 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    z7 = z6;
                    i7 |= startRestartGroup.changed(z7) ? 16384 : 8192;
                    if ((196608 & i5) != 0) {
                        if ((i6 & 32) == 0) {
                            switchColors2 = switchColors;
                            if (startRestartGroup.changed(switchColors2)) {
                                i13 = 131072;
                                i7 |= i13;
                            }
                        } else {
                            switchColors2 = switchColors;
                        }
                        i13 = 65536;
                        i7 |= i13;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((1572864 & i5) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i7 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : 524288;
                        if ((i7 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier5 = i14 != 0 ? Modifier.INSTANCE : modifier;
                                if (i8 != 0) {
                                    function22 = null;
                                }
                                if (i9 != 0) {
                                    z7 = true;
                                }
                                if ((i6 & 32) != 0) {
                                    i7 &= -458753;
                                    switchColors2 = SwitchDefaults.INSTANCE.colors(startRestartGroup, 6);
                                }
                                if (i10 != 0) {
                                    modifier3 = modifier5;
                                    i11 = i7;
                                    function23 = function22;
                                    z8 = z7;
                                    switchColors3 = switchColors2;
                                    mutableInteractionSource3 = null;
                                } else {
                                    i11 = i7;
                                    function23 = function22;
                                    z8 = z7;
                                    switchColors3 = switchColors2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    modifier3 = modifier5;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 32) != 0) {
                                    i7 &= -458753;
                                }
                                i11 = i7;
                                function23 = function22;
                                z8 = z7;
                                switchColors3 = switchColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier3 = modifier;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1580463220, i11, -1, "androidx.compose.material3.Switch (Switch.kt:99)");
                            }
                            startRestartGroup.startReplaceGroup(783532531);
                            if (mutableInteractionSource3 == null) {
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            startRestartGroup.endReplaceGroup();
                            if (function1 != null) {
                                i12 = 6;
                                obj = null;
                                modifier4 = ToggleableKt.m453toggleableO2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE), z5, mutableInteractionSource4, null, z8, Role.m2163boximpl(Role.INSTANCE.m2175getSwitcho7Vup1c()), function1);
                            } else {
                                i12 = 6;
                                obj = null;
                                modifier4 = Modifier.INSTANCE;
                            }
                            int i15 = i11 << 3;
                            int i16 = i11 >> 6;
                            int i17 = (i15 & 112) | (i16 & 896) | (i16 & 7168) | (i15 & 57344);
                            Modifier modifier6 = modifier3;
                            composer2 = startRestartGroup;
                            SwitchImpl(SizeKt.m328requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(modifier4), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, SwitchHeight), z5, z8, switchColors3, function23, mutableInteractionSource4, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, i12), composer2, i17);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier6;
                            function24 = function23;
                            z9 = z8;
                            switchColors4 = switchColors3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function22;
                            z9 = z7;
                            switchColors4 = switchColors2;
                            composer2 = startRestartGroup;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i18) {
                                    SwitchKt.Switch(z5, function1, modifier2, function24, z9, switchColors4, mutableInteractionSource5, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i7 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(783532531);
                    if (mutableInteractionSource3 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    if (function1 != null) {
                    }
                    int i152 = i11 << 3;
                    int i162 = i11 >> 6;
                    int i172 = (i152 & 112) | (i162 & 896) | (i162 & 7168) | (i152 & 57344);
                    Modifier modifier62 = modifier3;
                    composer2 = startRestartGroup;
                    SwitchImpl(SizeKt.m328requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(modifier4), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, SwitchHeight), z5, z8, switchColors3, function23, mutableInteractionSource4, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, i12), composer2, i172);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier62;
                    function24 = function23;
                    z9 = z8;
                    switchColors4 = switchColors3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z7 = z6;
                if ((196608 & i5) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i7 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i10 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(783532531);
                if (mutableInteractionSource3 == null) {
                }
                startRestartGroup.endReplaceGroup();
                if (function1 != null) {
                }
                int i1522 = i11 << 3;
                int i1622 = i11 >> 6;
                int i1722 = (i1522 & 112) | (i1622 & 896) | (i1622 & 7168) | (i1522 & 57344);
                Modifier modifier622 = modifier3;
                composer2 = startRestartGroup;
                SwitchImpl(SizeKt.m328requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(modifier4), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, SwitchHeight), z5, z8, switchColors3, function23, mutableInteractionSource4, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, i12), composer2, i1722);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier622;
                function24 = function23;
                z9 = z8;
                switchColors4 = switchColors3;
                mutableInteractionSource2 = mutableInteractionSource3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function22 = function2;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z7 = z6;
            if ((196608 & i5) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i7 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i10 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(783532531);
            if (mutableInteractionSource3 == null) {
            }
            startRestartGroup.endReplaceGroup();
            if (function1 != null) {
            }
            int i15222 = i11 << 3;
            int i16222 = i11 >> 6;
            int i17222 = (i15222 & 112) | (i16222 & 896) | (i16222 & 7168) | (i15222 & 57344);
            Modifier modifier6222 = modifier3;
            composer2 = startRestartGroup;
            SwitchImpl(SizeKt.m328requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(modifier4), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, SwitchHeight), z5, z8, switchColors3, function23, mutableInteractionSource4, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, i12), composer2, i17222);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier6222;
            function24 = function23;
            z9 = z8;
            switchColors4 = switchColors3;
            mutableInteractionSource2 = mutableInteractionSource3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        function22 = function2;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z7 = z6;
        if ((196608 & i5) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i7 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i10 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(783532531);
        if (mutableInteractionSource3 == null) {
        }
        startRestartGroup.endReplaceGroup();
        if (function1 != null) {
        }
        int i152222 = i11 << 3;
        int i162222 = i11 >> 6;
        int i172222 = (i152222 & 112) | (i162222 & 896) | (i162222 & 7168) | (i152222 & 57344);
        Modifier modifier62222 = modifier3;
        composer2 = startRestartGroup;
        SwitchImpl(SizeKt.m328requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(modifier4), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, SwitchHeight), z5, z8, switchColors3, function23, mutableInteractionSource4, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, i12), composer2, i172222);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier62222;
        function24 = function23;
        z9 = z8;
        switchColors4 = switchColors3;
        mutableInteractionSource2 = mutableInteractionSource3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final Modifier modifier, final boolean z5, final boolean z6, final SwitchColors switchColors, final Function2<? super Composer, ? super Integer, Unit> function2, final InteractionSource interactionSource, final Shape shape, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1594099146);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(shape) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1594099146, i7, -1, "androidx.compose.material3.SwitchImpl (Switch.kt:144)");
            }
            long m911trackColorWaAFU9c$material3_release = switchColors.m911trackColorWaAFU9c$material3_release(z6, z5);
            long m910thumbColorWaAFU9c$material3_release = switchColors.m910thumbColorWaAFU9c$material3_release(z6, z5);
            SwitchTokens switchTokens = SwitchTokens.INSTANCE;
            Shape value = ShapesKt.getValue(switchTokens.getTrackShape(), startRestartGroup, 6);
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(BorderKt.m108borderxT4_qwU(modifier, switchTokens.m1158getTrackOutlineWidthD9Ej5fM(), switchColors.m908borderColorWaAFU9c$material3_release(z6, z5), value), m911trackColorWaAFU9c$material3_release, value);
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            Modifier then = BoxScopeInstance.INSTANCE.align(Modifier.INSTANCE, companion.getCenterStart()).then(new ThumbElement(interactionSource, z5));
            float m2599constructorimpl = Dp.m2599constructorimpl(switchTokens.m1156getStateLayerSizeD9Ej5fM() / 2);
            composer2 = startRestartGroup;
            Modifier m103backgroundbw27NRU2 = BackgroundKt.m103backgroundbw27NRU(IndicationKt.indication(then, interactionSource, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, m2599constructorimpl, 0L, startRestartGroup, 54, 4)), m910thumbColorWaAFU9c$material3_release, shape);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion.getCenter(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m103backgroundbw27NRU2);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            composer2.startReplaceGroup(1163457794);
            if (function2 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(switchColors.m909iconColorWaAFU9c$material3_release(z6, z5))), function2, composer2, ProvidedValue.$stable | ((i7 >> 9) & 112));
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    SwitchKt.SwitchImpl(Modifier.this, z5, z6, switchColors, function2, interactionSource, shape, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
