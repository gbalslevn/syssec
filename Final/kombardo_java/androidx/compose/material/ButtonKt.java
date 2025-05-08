package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0087\u0001\u0010\u0016\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0087\u0001\u0010\u0018\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0017¨\u0006\u001b²\u0006\f\u0010\u001a\u001a\u00020\u00198\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/material/ButtonElevation;", "elevation", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/foundation/BorderStroke;", "border", "Landroidx/compose/material/ButtonColors;", "colors", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "content", "Button", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TextButton", "Landroidx/compose/ui/graphics/Color;", "contentColor", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z5, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        boolean z6;
        int i9;
        MutableInteractionSource mutableInteractionSource2;
        ButtonElevation buttonElevation2;
        Shape shape2;
        int i10;
        BorderStroke borderStroke2;
        int i11;
        int i12;
        PaddingValues paddingValues2;
        int i13;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape3;
        Shape shape4;
        Composer composer2;
        int i14;
        ButtonColors buttonColors2;
        final PaddingValues contentPadding;
        int i15;
        Modifier modifier2;
        Shape shape5;
        MutableInteractionSource mutableInteractionSource4;
        final Shape shape6;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource5;
        final ButtonColors buttonColors3;
        final boolean z7;
        final ButtonElevation buttonElevation3;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-2116133464);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i18 = i6 & 2;
        if (i18 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                z6 = z5;
                i7 |= startRestartGroup.changed(z6) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i7 |= startRestartGroup.changed(mutableInteractionSource2) ? 2048 : 1024;
                    if ((i5 & 24576) != 0) {
                        if ((i6 & 16) == 0) {
                            buttonElevation2 = buttonElevation;
                            if (startRestartGroup.changed(buttonElevation2)) {
                                i17 = 16384;
                                i7 |= i17;
                            }
                        } else {
                            buttonElevation2 = buttonElevation;
                        }
                        i17 = 8192;
                        i7 |= i17;
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    if ((196608 & i5) != 0) {
                        shape2 = shape;
                        i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(shape2)) ? 131072 : 65536;
                    } else {
                        shape2 = shape;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((1572864 & i5) == 0) {
                        borderStroke2 = borderStroke;
                        i7 |= startRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        if ((i5 & 12582912) == 0) {
                            if ((i6 & 128) == 0 && startRestartGroup.changed(buttonColors)) {
                                i16 = 8388608;
                                i7 |= i16;
                            }
                            i16 = 4194304;
                            i7 |= i16;
                        }
                        i11 = i6 & 256;
                        if (i11 != 0) {
                            i7 |= 100663296;
                        } else if ((i5 & 100663296) == 0) {
                            i12 = i11;
                            paddingValues2 = paddingValues;
                            i7 |= startRestartGroup.changed(paddingValues2) ? 67108864 : 33554432;
                            if ((i6 & 512) == 0) {
                                i7 |= 805306368;
                            } else if ((i5 & 805306368) == 0) {
                                i7 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            }
                            i13 = i7;
                            if ((306783379 & i13) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier4 = i18 == 0 ? Modifier.INSTANCE : modifier;
                                    boolean z8 = i8 == 0 ? true : z6;
                                    mutableInteractionSource3 = i9 == 0 ? null : mutableInteractionSource2;
                                    if ((i6 & 16) != 0) {
                                        i13 &= -57345;
                                        buttonElevation2 = ButtonDefaults.INSTANCE.m656elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 196608, 31);
                                    }
                                    if ((i6 & 32) == 0) {
                                        shape3 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall();
                                        i13 &= -458753;
                                    } else {
                                        shape3 = shape2;
                                    }
                                    BorderStroke borderStroke3 = i10 == 0 ? null : borderStroke;
                                    if ((i6 & 128) == 0) {
                                        shape4 = shape3;
                                        composer2 = startRestartGroup;
                                        i14 = i12;
                                        buttonColors2 = ButtonDefaults.INSTANCE.m655buttonColorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                        i13 &= -29360129;
                                    } else {
                                        shape4 = shape3;
                                        composer2 = startRestartGroup;
                                        i14 = i12;
                                        buttonColors2 = buttonColors;
                                    }
                                    contentPadding = i14 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    i15 = i13;
                                    borderStroke2 = borderStroke3;
                                    modifier2 = modifier4;
                                    z6 = z8;
                                    shape5 = shape4;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i6 & 16) != 0) {
                                        i13 &= -57345;
                                    }
                                    if ((i6 & 32) != 0) {
                                        i13 &= -458753;
                                    }
                                    if ((i6 & 128) != 0) {
                                        i13 &= -29360129;
                                    }
                                    buttonColors2 = buttonColors;
                                    contentPadding = paddingValues;
                                    i15 = i13;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    shape5 = shape2;
                                    composer2 = startRestartGroup;
                                    modifier2 = modifier;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2116133464, i15, -1, "androidx.compose.material.Button (Button.kt:103)");
                                }
                                if (mutableInteractionSource3 != null) {
                                    composer2.startReplaceGroup(1050577827);
                                    Object rememberedValue = composer2.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composer2.updateRememberedValue(rememberedValue);
                                    }
                                    composer2.endReplaceGroup();
                                    mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    composer2.startReplaceGroup(-243205708);
                                    composer2.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                int i19 = i15 >> 6;
                                int i20 = (i19 & 14) | ((i15 >> 18) & 112);
                                final State<Color> contentColor = buttonColors2.contentColor(z6, composer2, i20);
                                Shape shape7 = shape5;
                                BorderStroke borderStroke4 = borderStroke2;
                                State<Dp> state = null;
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                                    }
                                }, 1, null);
                                long value = buttonColors2.backgroundColor(z6, composer2, i20).getValue().getValue();
                                long m1485copywmQWz5c$default = Color.m1485copywmQWz5c$default(Button$lambda$1(contentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                if (buttonElevation2 != null) {
                                    composer2.startReplaceGroup(1050984484);
                                    composer2.endReplaceGroup();
                                } else {
                                    composer2.startReplaceGroup(-243191939);
                                    State<Dp> elevation = buttonElevation2.elevation(z6, mutableInteractionSource4, composer2, i19 & 910);
                                    composer2.endReplaceGroup();
                                    state = elevation;
                                }
                                SurfaceKt.m737SurfaceLPr_se0(function0, semantics$default, z6, shape7, value, m1485copywmQWz5c$default, borderStroke4, state == null ? state.getValue().getValue() : Dp.m2599constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
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

                                    public final void invoke(Composer composer3, int i21) {
                                        long Button$lambda$1;
                                        if ((i21 & 3) == 2 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(7524271, i21, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:118)");
                                        }
                                        ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                        Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor);
                                        ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m1488getAlphaimpl(Button$lambda$1)));
                                        final PaddingValues paddingValues3 = contentPadding;
                                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i22) {
                                                if ((i22 & 3) == 2 && composer4.getSkipping()) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1699085201, i22, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:119)");
                                                }
                                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                final PaddingValues paddingValues4 = PaddingValues.this;
                                                final Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                        invoke(composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer5, int i23) {
                                                        if ((i23 & 3) == 2 && composer5.getSkipping()) {
                                                            composer5.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-630330208, i23, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
                                                        }
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                                        Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m658getMinWidthD9Ej5fM(), buttonDefaults.m657getMinHeightD9Ej5fM()), PaddingValues.this);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, padding);
                                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                        if (composer5.getApplier() == null) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                                        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                                        function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                        composer5.endNode();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer4, 54), composer4, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, (i15 & 14) | 805306368 | (i15 & 896) | (i19 & 7168) | (3670016 & i15), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                borderStroke2 = borderStroke4;
                                shape6 = shape7;
                                modifier3 = modifier2;
                                paddingValues2 = contentPadding;
                                mutableInteractionSource5 = mutableInteractionSource3;
                                ButtonElevation buttonElevation4 = buttonElevation2;
                                buttonColors3 = buttonColors2;
                                z7 = z6;
                                buttonElevation3 = buttonElevation4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier;
                                z7 = z6;
                                mutableInteractionSource5 = mutableInteractionSource2;
                                buttonElevation3 = buttonElevation2;
                                shape6 = shape2;
                                composer2 = startRestartGroup;
                                buttonColors3 = buttonColors;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                final BorderStroke borderStroke5 = borderStroke2;
                                final PaddingValues paddingValues3 = paddingValues2;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3
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

                                    public final void invoke(Composer composer3, int i21) {
                                        ButtonKt.Button(function0, modifier3, z7, mutableInteractionSource5, buttonElevation3, shape6, borderStroke5, buttonColors3, paddingValues3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i12 = i11;
                        paddingValues2 = paddingValues;
                        if ((i6 & 512) == 0) {
                        }
                        i13 = i7;
                        if ((306783379 & i13) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i6 & 16) != 0) {
                        }
                        if ((i6 & 32) == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if ((i6 & 128) == 0) {
                        }
                        if (i14 == 0) {
                        }
                        i15 = i13;
                        borderStroke2 = borderStroke3;
                        modifier2 = modifier4;
                        z6 = z8;
                        shape5 = shape4;
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (mutableInteractionSource3 != null) {
                        }
                        int i192 = i15 >> 6;
                        int i202 = (i192 & 14) | ((i15 >> 18) & 112);
                        final State<Color> contentColor2 = buttonColors2.contentColor(z6, composer2, i202);
                        Shape shape72 = shape5;
                        BorderStroke borderStroke42 = borderStroke2;
                        State<Dp> state2 = null;
                        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                            }
                        }, 1, null);
                        long value2 = buttonColors2.backgroundColor(z6, composer2, i202).getValue().getValue();
                        long m1485copywmQWz5c$default2 = Color.m1485copywmQWz5c$default(Button$lambda$1(contentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevation2 != null) {
                        }
                        SurfaceKt.m737SurfaceLPr_se0(function0, semantics$default2, z6, shape72, value2, m1485copywmQWz5c$default2, borderStroke42, state2 == null ? state2.getValue().getValue() : Dp.m2599constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
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

                            public final void invoke(Composer composer3, int i21) {
                                long Button$lambda$1;
                                if ((i21 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(7524271, i21, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:118)");
                                }
                                ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor2);
                                ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m1488getAlphaimpl(Button$lambda$1)));
                                final PaddingValues paddingValues32 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i22) {
                                        if ((i22 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1699085201, i22, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:119)");
                                        }
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues4 = PaddingValues.this;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i23) {
                                                if ((i23 & 3) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-630330208, i23, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
                                                }
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                                Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m658getMinWidthD9Ej5fM(), buttonDefaults.m657getMinHeightD9Ej5fM()), PaddingValues.this);
                                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, padding);
                                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                                if (composer5.getApplier() == null) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                                function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                composer5.endNode();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer4, 54), composer4, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, (i15 & 14) | 805306368 | (i15 & 896) | (i192 & 7168) | (3670016 & i15), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        borderStroke2 = borderStroke42;
                        shape6 = shape72;
                        modifier3 = modifier2;
                        paddingValues2 = contentPadding;
                        mutableInteractionSource5 = mutableInteractionSource3;
                        ButtonElevation buttonElevation42 = buttonElevation2;
                        buttonColors3 = buttonColors2;
                        z7 = z6;
                        buttonElevation3 = buttonElevation42;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    if ((i5 & 12582912) == 0) {
                    }
                    i11 = i6 & 256;
                    if (i11 != 0) {
                    }
                    i12 = i11;
                    paddingValues2 = paddingValues;
                    if ((i6 & 512) == 0) {
                    }
                    i13 = i7;
                    if ((306783379 & i13) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if ((i6 & 16) != 0) {
                    }
                    if ((i6 & 32) == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if ((i6 & 128) == 0) {
                    }
                    if (i14 == 0) {
                    }
                    i15 = i13;
                    borderStroke2 = borderStroke3;
                    modifier2 = modifier4;
                    z6 = z8;
                    shape5 = shape4;
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (mutableInteractionSource3 != null) {
                    }
                    int i1922 = i15 >> 6;
                    int i2022 = (i1922 & 14) | ((i15 >> 18) & 112);
                    final State<Color> contentColor22 = buttonColors2.contentColor(z6, composer2, i2022);
                    Shape shape722 = shape5;
                    BorderStroke borderStroke422 = borderStroke2;
                    State<Dp> state22 = null;
                    Modifier semantics$default22 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                        }
                    }, 1, null);
                    long value22 = buttonColors2.backgroundColor(z6, composer2, i2022).getValue().getValue();
                    long m1485copywmQWz5c$default22 = Color.m1485copywmQWz5c$default(Button$lambda$1(contentColor22), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevation2 != null) {
                    }
                    SurfaceKt.m737SurfaceLPr_se0(function0, semantics$default22, z6, shape722, value22, m1485copywmQWz5c$default22, borderStroke422, state22 == null ? state22.getValue().getValue() : Dp.m2599constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
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

                        public final void invoke(Composer composer3, int i21) {
                            long Button$lambda$1;
                            if ((i21 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(7524271, i21, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:118)");
                            }
                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                            Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor22);
                            ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m1488getAlphaimpl(Button$lambda$1)));
                            final PaddingValues paddingValues32 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i22) {
                                    if ((i22 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1699085201, i22, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:119)");
                                    }
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                    final PaddingValues paddingValues4 = PaddingValues.this;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i23) {
                                            if ((i23 & 3) == 2 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-630330208, i23, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                            Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m658getMinWidthD9Ej5fM(), buttonDefaults.m657getMinHeightD9Ej5fM()), PaddingValues.this);
                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, padding);
                                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                            if (composer5.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                            function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                            composer5.endNode();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer4, 54), composer4, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, (i15 & 14) | 805306368 | (i15 & 896) | (i1922 & 7168) | (3670016 & i15), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    borderStroke2 = borderStroke422;
                    shape6 = shape722;
                    modifier3 = modifier2;
                    paddingValues2 = contentPadding;
                    mutableInteractionSource5 = mutableInteractionSource3;
                    ButtonElevation buttonElevation422 = buttonElevation2;
                    buttonColors3 = buttonColors2;
                    z7 = z6;
                    buttonElevation3 = buttonElevation422;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i5 & 24576) != 0) {
                }
                if ((196608 & i5) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                borderStroke2 = borderStroke;
                if ((i5 & 12582912) == 0) {
                }
                i11 = i6 & 256;
                if (i11 != 0) {
                }
                i12 = i11;
                paddingValues2 = paddingValues;
                if ((i6 & 512) == 0) {
                }
                i13 = i7;
                if ((306783379 & i13) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i18 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if ((i6 & 16) != 0) {
                }
                if ((i6 & 32) == 0) {
                }
                if (i10 == 0) {
                }
                if ((i6 & 128) == 0) {
                }
                if (i14 == 0) {
                }
                i15 = i13;
                borderStroke2 = borderStroke3;
                modifier2 = modifier4;
                z6 = z8;
                shape5 = shape4;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (mutableInteractionSource3 != null) {
                }
                int i19222 = i15 >> 6;
                int i20222 = (i19222 & 14) | ((i15 >> 18) & 112);
                final State<Color> contentColor222 = buttonColors2.contentColor(z6, composer2, i20222);
                Shape shape7222 = shape5;
                BorderStroke borderStroke4222 = borderStroke2;
                State<Dp> state222 = null;
                Modifier semantics$default222 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                    }
                }, 1, null);
                long value222 = buttonColors2.backgroundColor(z6, composer2, i20222).getValue().getValue();
                long m1485copywmQWz5c$default222 = Color.m1485copywmQWz5c$default(Button$lambda$1(contentColor222), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevation2 != null) {
                }
                SurfaceKt.m737SurfaceLPr_se0(function0, semantics$default222, z6, shape7222, value222, m1485copywmQWz5c$default222, borderStroke4222, state222 == null ? state222.getValue().getValue() : Dp.m2599constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
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

                    public final void invoke(Composer composer3, int i21) {
                        long Button$lambda$1;
                        if ((i21 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(7524271, i21, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:118)");
                        }
                        ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor222);
                        ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m1488getAlphaimpl(Button$lambda$1)));
                        final PaddingValues paddingValues32 = contentPadding;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i22) {
                                if ((i22 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1699085201, i22, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:119)");
                                }
                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                final PaddingValues paddingValues4 = PaddingValues.this;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer5, int i23) {
                                        if ((i23 & 3) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-630330208, i23, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
                                        }
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                        Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m658getMinWidthD9Ej5fM(), buttonDefaults.m657getMinHeightD9Ej5fM()), PaddingValues.this);
                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, padding);
                                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                        if (composer5.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer5.startReusableNode();
                                        if (composer5.getInserting()) {
                                            composer5.createNode(constructor);
                                        } else {
                                            composer5.useNode();
                                        }
                                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                        function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                        composer5.endNode();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer4, 54), composer4, 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, (i15 & 14) | 805306368 | (i15 & 896) | (i19222 & 7168) | (3670016 & i15), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                borderStroke2 = borderStroke4222;
                shape6 = shape7222;
                modifier3 = modifier2;
                paddingValues2 = contentPadding;
                mutableInteractionSource5 = mutableInteractionSource3;
                ButtonElevation buttonElevation4222 = buttonElevation2;
                buttonColors3 = buttonColors2;
                z7 = z6;
                buttonElevation3 = buttonElevation4222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z6 = z5;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i5 & 24576) != 0) {
            }
            if ((196608 & i5) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            borderStroke2 = borderStroke;
            if ((i5 & 12582912) == 0) {
            }
            i11 = i6 & 256;
            if (i11 != 0) {
            }
            i12 = i11;
            paddingValues2 = paddingValues;
            if ((i6 & 512) == 0) {
            }
            i13 = i7;
            if ((306783379 & i13) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i18 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) == 0) {
            }
            if (i10 == 0) {
            }
            if ((i6 & 128) == 0) {
            }
            if (i14 == 0) {
            }
            i15 = i13;
            borderStroke2 = borderStroke3;
            modifier2 = modifier4;
            z6 = z8;
            shape5 = shape4;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (mutableInteractionSource3 != null) {
            }
            int i192222 = i15 >> 6;
            int i202222 = (i192222 & 14) | ((i15 >> 18) & 112);
            final State<Color> contentColor2222 = buttonColors2.contentColor(z6, composer2, i202222);
            Shape shape72222 = shape5;
            BorderStroke borderStroke42222 = borderStroke2;
            State<Dp> state2222 = null;
            Modifier semantics$default2222 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                }
            }, 1, null);
            long value2222 = buttonColors2.backgroundColor(z6, composer2, i202222).getValue().getValue();
            long m1485copywmQWz5c$default2222 = Color.m1485copywmQWz5c$default(Button$lambda$1(contentColor2222), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
            if (buttonElevation2 != null) {
            }
            SurfaceKt.m737SurfaceLPr_se0(function0, semantics$default2222, z6, shape72222, value2222, m1485copywmQWz5c$default2222, borderStroke42222, state2222 == null ? state2222.getValue().getValue() : Dp.m2599constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
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

                public final void invoke(Composer composer3, int i21) {
                    long Button$lambda$1;
                    if ((i21 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(7524271, i21, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:118)");
                    }
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor2222);
                    ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m1488getAlphaimpl(Button$lambda$1)));
                    final PaddingValues paddingValues32 = contentPadding;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i22) {
                            if ((i22 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1699085201, i22, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:119)");
                            }
                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                            final PaddingValues paddingValues4 = PaddingValues.this;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer5, int i23) {
                                    if ((i23 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-630330208, i23, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                    Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m658getMinWidthD9Ej5fM(), buttonDefaults.m657getMinHeightD9Ej5fM()), PaddingValues.this);
                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, padding);
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    if (composer5.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer5.startReusableNode();
                                    if (composer5.getInserting()) {
                                        composer5.createNode(constructor);
                                    } else {
                                        composer5.useNode();
                                    }
                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                    function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                    composer5.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer4, 54), composer4, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, (i15 & 14) | 805306368 | (i15 & 896) | (i192222 & 7168) | (3670016 & i15), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            borderStroke2 = borderStroke42222;
            shape6 = shape72222;
            modifier3 = modifier2;
            paddingValues2 = contentPadding;
            mutableInteractionSource5 = mutableInteractionSource3;
            ButtonElevation buttonElevation42222 = buttonElevation2;
            buttonColors3 = buttonColors2;
            z7 = z6;
            buttonElevation3 = buttonElevation42222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        z6 = z5;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i5 & 24576) != 0) {
        }
        if ((196608 & i5) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        borderStroke2 = borderStroke;
        if ((i5 & 12582912) == 0) {
        }
        i11 = i6 & 256;
        if (i11 != 0) {
        }
        i12 = i11;
        paddingValues2 = paddingValues;
        if ((i6 & 512) == 0) {
        }
        i13 = i7;
        if ((306783379 & i13) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i18 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) == 0) {
        }
        if (i10 == 0) {
        }
        if ((i6 & 128) == 0) {
        }
        if (i14 == 0) {
        }
        i15 = i13;
        borderStroke2 = borderStroke3;
        modifier2 = modifier4;
        z6 = z8;
        shape5 = shape4;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (mutableInteractionSource3 != null) {
        }
        int i1922222 = i15 >> 6;
        int i2022222 = (i1922222 & 14) | ((i15 >> 18) & 112);
        final State<Color> contentColor22222 = buttonColors2.contentColor(z6, composer2, i2022222);
        Shape shape722222 = shape5;
        BorderStroke borderStroke422222 = borderStroke2;
        State<Dp> state22222 = null;
        Modifier semantics$default22222 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
            }
        }, 1, null);
        long value22222 = buttonColors2.backgroundColor(z6, composer2, i2022222).getValue().getValue();
        long m1485copywmQWz5c$default22222 = Color.m1485copywmQWz5c$default(Button$lambda$1(contentColor22222), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
        if (buttonElevation2 != null) {
        }
        SurfaceKt.m737SurfaceLPr_se0(function0, semantics$default22222, z6, shape722222, value22222, m1485copywmQWz5c$default22222, borderStroke422222, state22222 == null ? state22222.getValue().getValue() : Dp.m2599constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(7524271, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
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

            public final void invoke(Composer composer3, int i21) {
                long Button$lambda$1;
                if ((i21 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(7524271, i21, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:118)");
                }
                ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor22222);
                ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m1488getAlphaimpl(Button$lambda$1)));
                final PaddingValues paddingValues32 = contentPadding;
                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.rememberComposableLambda(-1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i22) {
                        if ((i22 & 3) == 2 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1699085201, i22, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:119)");
                        }
                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                        final PaddingValues paddingValues4 = PaddingValues.this;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.rememberComposableLambda(-630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i23) {
                                if ((i23 & 3) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-630330208, i23, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m658getMinWidthD9Ej5fM(), buttonDefaults.m657getMinHeightD9Ej5fM()), PaddingValues.this);
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, padding);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                if (composer5.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer5.startReusableNode();
                                if (composer5.getInserting()) {
                                    composer5.createNode(constructor);
                                } else {
                                    composer5.useNode();
                                }
                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                composer5.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer4, 54), composer4, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer2, 54), composer2, (i15 & 14) | 805306368 | (i15 & 896) | (i1922222 & 7168) | (3670016 & i15), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        borderStroke2 = borderStroke422222;
        shape6 = shape722222;
        modifier3 = modifier2;
        paddingValues2 = contentPadding;
        mutableInteractionSource5 = mutableInteractionSource3;
        ButtonElevation buttonElevation422222 = buttonElevation2;
        buttonColors3 = buttonColors2;
        z7 = z6;
        buttonElevation3 = buttonElevation422222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Button$lambda$1(State<Color> state) {
        return state.getValue().getValue();
    }

    public static final void TextButton(Function0<Unit> function0, Modifier modifier, boolean z5, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i5, int i6) {
        Modifier modifier2 = (i6 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z6 = (i6 & 4) != 0 ? true : z5;
        MutableInteractionSource mutableInteractionSource2 = (i6 & 8) != 0 ? null : mutableInteractionSource;
        ButtonElevation buttonElevation2 = (i6 & 16) != 0 ? null : buttonElevation;
        Shape small = (i6 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke borderStroke2 = (i6 & 64) != 0 ? null : borderStroke;
        ButtonColors m659textButtonColorsRGew2ao = (i6 & 128) != 0 ? ButtonDefaults.INSTANCE.m659textButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues textButtonContentPadding = (i6 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(288797557, i5, -1, "androidx.compose.material.TextButton (Button.kt:233)");
        }
        Button(function0, modifier2, z6, mutableInteractionSource2, buttonElevation2, small, borderStroke2, m659textButtonColorsRGew2ao, textButtonContentPadding, function3, composer, i5 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
