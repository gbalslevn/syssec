package androidx.compose.material3;

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
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0087\u0001\u0010\u0016\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0087\u0001\u0010\u0018\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/material3/ButtonColors;", "colors", "Landroidx/compose/material3/ButtonElevation;", "elevation", "Landroidx/compose/foundation/BorderStroke;", "border", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "content", "Button", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TextButton", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ButtonKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0186  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z5, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i9;
        int i10;
        int i11;
        int i12;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i13;
        ButtonColors buttonColors3;
        ?? r11;
        ButtonElevation buttonElevation3;
        MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues2;
        BorderStroke borderStroke2;
        Modifier modifier2;
        int i14;
        ButtonElevation buttonElevation4;
        boolean z6;
        MutableInteractionSource mutableInteractionSource4;
        MutableInteractionSource mutableInteractionSource5;
        State<Dp> shadowElevation$material3_release;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource6;
        final Modifier modifier3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        final Shape shape4;
        final ButtonColors buttonColors4;
        final ButtonElevation buttonElevation5;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        int i15;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(650121315);
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
                i7 |= startRestartGroup.changed(z5) ? 256 : 128;
                if ((i5 & 3072) == 0) {
                    if ((i6 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i17 = 2048;
                            i7 |= i17;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i17 = 1024;
                    i7 |= i17;
                } else {
                    shape2 = shape;
                }
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i16 = 16384;
                            i7 |= i16;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i16 = 8192;
                    i7 |= i16;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i5) == 0) {
                    if ((i6 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        if (startRestartGroup.changed(buttonElevation2)) {
                            i15 = 131072;
                            i7 |= i15;
                        }
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i15 = 65536;
                    i7 |= i15;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i9 = i6 & 64;
                if (i9 != 0) {
                    i7 |= 1572864;
                } else if ((1572864 & i5) == 0) {
                    i7 |= startRestartGroup.changed(borderStroke) ? 1048576 : 524288;
                    i10 = i6 & 128;
                    if (i10 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i11 = i6 & 256;
                    if (i11 == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i12 = i11;
                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource;
                        i7 |= startRestartGroup.changed(mutableInteractionSource7) ? 67108864 : 33554432;
                        mutableInteractionSource2 = mutableInteractionSource7;
                        if ((i6 & 512) != 0) {
                            i7 |= 805306368;
                        } else if ((i5 & 805306368) == 0) {
                            i7 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        }
                        if ((306783379 & i7) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i18 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z8 = i8 != 0 ? true : z5;
                                if ((i6 & 8) != 0) {
                                    i7 &= -7169;
                                    shape3 = ButtonDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i6 & 16) != 0) {
                                    i13 = i7 & (-57345);
                                    buttonColors3 = ButtonDefaults.INSTANCE.buttonColors(startRestartGroup, 6);
                                } else {
                                    i13 = i7;
                                    buttonColors3 = buttonColors2;
                                }
                                if ((i6 & 32) != 0) {
                                    r11 = null;
                                    buttonElevation3 = ButtonDefaults.INSTANCE.m780buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 196608, 31);
                                    i13 &= -458753;
                                } else {
                                    r11 = null;
                                    buttonElevation3 = buttonElevation;
                                }
                                BorderStroke borderStroke4 = i9 != 0 ? r11 : borderStroke;
                                PaddingValues contentPadding = i10 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i12 != 0) {
                                    paddingValues2 = contentPadding;
                                    borderStroke2 = borderStroke4;
                                    mutableInteractionSource3 = r11;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    paddingValues2 = contentPadding;
                                    borderStroke2 = borderStroke4;
                                }
                                modifier2 = modifier4;
                                shape2 = shape3;
                                buttonColors2 = buttonColors3;
                                i14 = i13;
                                buttonElevation4 = buttonElevation3;
                                z6 = z8;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 8) != 0) {
                                    i7 &= -7169;
                                }
                                if ((i6 & 16) != 0) {
                                    i7 &= -57345;
                                }
                                if ((i6 & 32) != 0) {
                                    i7 &= -458753;
                                }
                                modifier2 = modifier;
                                buttonElevation4 = buttonElevation;
                                borderStroke2 = borderStroke;
                                paddingValues2 = paddingValues;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i14 = i7;
                                z6 = z5;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(650121315, i14, -1, "androidx.compose.material3.Button (Button.kt:118)");
                            }
                            startRestartGroup.startReplaceGroup(-239156623);
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
                            long m776containerColorvNxB06k$material3_release = buttonColors2.m776containerColorvNxB06k$material3_release(z6);
                            final long m777contentColorvNxB06k$material3_release = buttonColors2.m777contentColorvNxB06k$material3_release(z6);
                            startRestartGroup.startReplaceGroup(-239150048);
                            if (buttonElevation4 == null) {
                                mutableInteractionSource5 = mutableInteractionSource3;
                                shadowElevation$material3_release = null;
                            } else {
                                mutableInteractionSource5 = mutableInteractionSource3;
                                shadowElevation$material3_release = buttonElevation4.shadowElevation$material3_release(z6, mutableInteractionSource4, startRestartGroup, ((i14 >> 9) & 896) | ((i14 >> 6) & 14));
                            }
                            startRestartGroup.endReplaceGroup();
                            ButtonElevation buttonElevation6 = buttonElevation4;
                            ButtonColors buttonColors5 = buttonColors2;
                            Modifier modifier5 = modifier2;
                            composer2 = startRestartGroup;
                            SurfaceKt.m902Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                                }
                            }, 1, null), z6, shape2, m776containerColorvNxB06k$material3_release, m777contentColorvNxB06k$material3_release, 0.0f, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().getValue() : Dp.m2599constructorimpl(0), borderStroke2, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

                                public final void invoke(Composer composer3, int i19) {
                                    if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(956488494, i19, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                                    }
                                    long j5 = m777contentColorvNxB06k$material3_release;
                                    TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                                    final PaddingValues paddingValues4 = paddingValues2;
                                    final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(j5, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                                        public final void invoke(Composer composer4, int i20) {
                                            if ((i20 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1327513942, i20, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                                            }
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                            Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m782getMinWidthD9Ej5fM(), buttonDefaults.m781getMinHeightD9Ej5fM()), PaddingValues.this);
                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
                                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer4);
                                            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                            function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                            composer4.endNode();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), composer3, 384);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), composer2, (i14 & 8078) | (234881024 & (i14 << 6)), 6, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource6 = mutableInteractionSource5;
                            modifier3 = modifier5;
                            borderStroke3 = borderStroke2;
                            paddingValues3 = paddingValues2;
                            shape4 = shape2;
                            buttonColors4 = buttonColors5;
                            buttonElevation5 = buttonElevation6;
                            z7 = z6;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z7 = z5;
                            shape4 = shape2;
                            buttonColors4 = buttonColors2;
                            buttonElevation5 = buttonElevation2;
                            composer2 = startRestartGroup;
                            borderStroke3 = borderStroke;
                            paddingValues3 = paddingValues;
                            mutableInteractionSource6 = mutableInteractionSource2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
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

                                public final void invoke(Composer composer3, int i19) {
                                    ButtonKt.Button(function0, modifier3, z7, shape4, buttonColors4, buttonElevation5, borderStroke3, paddingValues3, mutableInteractionSource6, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i12 = i11;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i6 & 512) != 0) {
                    }
                    if ((306783379 & i7) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if ((i6 & 8) != 0) {
                    }
                    if ((i6 & 16) != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    modifier2 = modifier4;
                    shape2 = shape3;
                    buttonColors2 = buttonColors3;
                    i14 = i13;
                    buttonElevation4 = buttonElevation3;
                    z6 = z8;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(-239156623);
                    if (mutableInteractionSource3 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    long m776containerColorvNxB06k$material3_release2 = buttonColors2.m776containerColorvNxB06k$material3_release(z6);
                    final long m777contentColorvNxB06k$material3_release2 = buttonColors2.m777contentColorvNxB06k$material3_release(z6);
                    startRestartGroup.startReplaceGroup(-239150048);
                    if (buttonElevation4 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    ButtonElevation buttonElevation62 = buttonElevation4;
                    ButtonColors buttonColors52 = buttonColors2;
                    Modifier modifier52 = modifier2;
                    composer2 = startRestartGroup;
                    SurfaceKt.m902Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                        }
                    }, 1, null), z6, shape2, m776containerColorvNxB06k$material3_release2, m777contentColorvNxB06k$material3_release2, 0.0f, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().getValue() : Dp.m2599constructorimpl(0), borderStroke2, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

                        public final void invoke(Composer composer3, int i19) {
                            if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(956488494, i19, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                            }
                            long j5 = m777contentColorvNxB06k$material3_release2;
                            TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                            final PaddingValues paddingValues4 = paddingValues2;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(j5, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                                public final void invoke(Composer composer4, int i20) {
                                    if ((i20 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1327513942, i20, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                    Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m782getMinWidthD9Ej5fM(), buttonDefaults.m781getMinHeightD9Ej5fM()), PaddingValues.this);
                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    if (composer4.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer4);
                                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                    composer4.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), composer2, (i14 & 8078) | (234881024 & (i14 << 6)), 6, 64);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource6 = mutableInteractionSource5;
                    modifier3 = modifier52;
                    borderStroke3 = borderStroke2;
                    paddingValues3 = paddingValues2;
                    shape4 = shape2;
                    buttonColors4 = buttonColors52;
                    buttonElevation5 = buttonElevation62;
                    z7 = z6;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i10 = i6 & 128;
                if (i10 == 0) {
                }
                i11 = i6 & 256;
                if (i11 == 0) {
                }
                i12 = i11;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i6 & 512) != 0) {
                }
                if ((306783379 & i7) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i18 != 0) {
                }
                if (i8 != 0) {
                }
                if ((i6 & 8) != 0) {
                }
                if ((i6 & 16) != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i12 != 0) {
                }
                modifier2 = modifier4;
                shape2 = shape3;
                buttonColors2 = buttonColors3;
                i14 = i13;
                buttonElevation4 = buttonElevation3;
                z6 = z8;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-239156623);
                if (mutableInteractionSource3 == null) {
                }
                startRestartGroup.endReplaceGroup();
                long m776containerColorvNxB06k$material3_release22 = buttonColors2.m776containerColorvNxB06k$material3_release(z6);
                final long m777contentColorvNxB06k$material3_release22 = buttonColors2.m777contentColorvNxB06k$material3_release(z6);
                startRestartGroup.startReplaceGroup(-239150048);
                if (buttonElevation4 == null) {
                }
                startRestartGroup.endReplaceGroup();
                ButtonElevation buttonElevation622 = buttonElevation4;
                ButtonColors buttonColors522 = buttonColors2;
                Modifier modifier522 = modifier2;
                composer2 = startRestartGroup;
                SurfaceKt.m902Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                    }
                }, 1, null), z6, shape2, m776containerColorvNxB06k$material3_release22, m777contentColorvNxB06k$material3_release22, 0.0f, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().getValue() : Dp.m2599constructorimpl(0), borderStroke2, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

                    public final void invoke(Composer composer3, int i19) {
                        if ((i19 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(956488494, i19, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                        }
                        long j5 = m777contentColorvNxB06k$material3_release22;
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                        final PaddingValues paddingValues4 = paddingValues2;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(j5, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                            public final void invoke(Composer composer4, int i20) {
                                if ((i20 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1327513942, i20, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                                }
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m782getMinWidthD9Ej5fM(), buttonDefaults.m781getMinHeightD9Ej5fM()), PaddingValues.this);
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                if (composer4.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer4);
                                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                                function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                composer4.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), composer2, (i14 & 8078) | (234881024 & (i14 << 6)), 6, 64);
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource6 = mutableInteractionSource5;
                modifier3 = modifier522;
                borderStroke3 = borderStroke2;
                paddingValues3 = paddingValues2;
                shape4 = shape2;
                buttonColors4 = buttonColors522;
                buttonElevation5 = buttonElevation622;
                z7 = z6;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i5 & 3072) == 0) {
            }
            if ((i5 & 24576) == 0) {
            }
            if ((196608 & i5) == 0) {
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
            i12 = i11;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i6 & 512) != 0) {
            }
            if ((306783379 & i7) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i18 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i6 & 8) != 0) {
            }
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i12 != 0) {
            }
            modifier2 = modifier4;
            shape2 = shape3;
            buttonColors2 = buttonColors3;
            i14 = i13;
            buttonElevation4 = buttonElevation3;
            z6 = z8;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-239156623);
            if (mutableInteractionSource3 == null) {
            }
            startRestartGroup.endReplaceGroup();
            long m776containerColorvNxB06k$material3_release222 = buttonColors2.m776containerColorvNxB06k$material3_release(z6);
            final long m777contentColorvNxB06k$material3_release222 = buttonColors2.m777contentColorvNxB06k$material3_release(z6);
            startRestartGroup.startReplaceGroup(-239150048);
            if (buttonElevation4 == null) {
            }
            startRestartGroup.endReplaceGroup();
            ButtonElevation buttonElevation6222 = buttonElevation4;
            ButtonColors buttonColors5222 = buttonColors2;
            Modifier modifier5222 = modifier2;
            composer2 = startRestartGroup;
            SurfaceKt.m902Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
                }
            }, 1, null), z6, shape2, m776containerColorvNxB06k$material3_release222, m777contentColorvNxB06k$material3_release222, 0.0f, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().getValue() : Dp.m2599constructorimpl(0), borderStroke2, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

                public final void invoke(Composer composer3, int i19) {
                    if ((i19 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(956488494, i19, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                    }
                    long j5 = m777contentColorvNxB06k$material3_release222;
                    TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                    final PaddingValues paddingValues4 = paddingValues2;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(j5, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                        public final void invoke(Composer composer4, int i20) {
                            if ((i20 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1327513942, i20, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                            Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m782getMinWidthD9Ej5fM(), buttonDefaults.m781getMinHeightD9Ej5fM()), PaddingValues.this);
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
                            if (composer4.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer4);
                            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                            function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                            composer4.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, (i14 & 8078) | (234881024 & (i14 << 6)), 6, 64);
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource6 = mutableInteractionSource5;
            modifier3 = modifier5222;
            borderStroke3 = borderStroke2;
            paddingValues3 = paddingValues2;
            shape4 = shape2;
            buttonColors4 = buttonColors5222;
            buttonElevation5 = buttonElevation6222;
            z7 = z6;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        if ((i5 & 3072) == 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        if ((196608 & i5) == 0) {
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
        i12 = i11;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i6 & 512) != 0) {
        }
        if ((306783379 & i7) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i18 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i6 & 8) != 0) {
        }
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i12 != 0) {
        }
        modifier2 = modifier4;
        shape2 = shape3;
        buttonColors2 = buttonColors3;
        i14 = i13;
        buttonElevation4 = buttonElevation3;
        z6 = z8;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-239156623);
        if (mutableInteractionSource3 == null) {
        }
        startRestartGroup.endReplaceGroup();
        long m776containerColorvNxB06k$material3_release2222 = buttonColors2.m776containerColorvNxB06k$material3_release(z6);
        final long m777contentColorvNxB06k$material3_release2222 = buttonColors2.m777contentColorvNxB06k$material3_release(z6);
        startRestartGroup.startReplaceGroup(-239150048);
        if (buttonElevation4 == null) {
        }
        startRestartGroup.endReplaceGroup();
        ButtonElevation buttonElevation62222 = buttonElevation4;
        ButtonColors buttonColors52222 = buttonColors2;
        Modifier modifier52222 = modifier2;
        composer2 = startRestartGroup;
        SurfaceKt.m902Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2170getButtono7Vup1c());
            }
        }, 1, null), z6, shape2, m776containerColorvNxB06k$material3_release2222, m777contentColorvNxB06k$material3_release2222, 0.0f, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().getValue() : Dp.m2599constructorimpl(0), borderStroke2, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
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

            public final void invoke(Composer composer3, int i19) {
                if ((i19 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(956488494, i19, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:135)");
                }
                long j5 = m777contentColorvNxB06k$material3_release2222;
                TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                final PaddingValues paddingValues4 = paddingValues2;
                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(j5, labelLarge, ComposableLambdaKt.rememberComposableLambda(1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2.1
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

                    public final void invoke(Composer composer4, int i20) {
                        if ((i20 & 3) == 2 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1327513942, i20, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:139)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                        Modifier padding = PaddingKt.padding(SizeKt.m323defaultMinSizeVpY3zN4(companion, buttonDefaults.m782getMinWidthD9Ej5fM(), buttonDefaults.m781getMinHeightD9Ej5fM()), PaddingValues.this);
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, padding);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        if (composer4.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor);
                        } else {
                            composer4.useNode();
                        }
                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer4);
                        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                        composer4.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer3, 54), composer3, 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), composer2, (i14 & 8078) | (234881024 & (i14 << 6)), 6, 64);
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource6 = mutableInteractionSource5;
        modifier3 = modifier52222;
        borderStroke3 = borderStroke2;
        paddingValues3 = paddingValues2;
        shape4 = shape2;
        buttonColors4 = buttonColors52222;
        buttonElevation5 = buttonElevation62222;
        z7 = z6;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextButton(final Function0<Unit> function0, Modifier modifier, boolean z5, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Shape shape2;
        ButtonColors buttonColors2;
        int i9;
        ButtonElevation buttonElevation2;
        int i10;
        BorderStroke borderStroke2;
        int i11;
        int i12;
        Modifier modifier2;
        boolean z6;
        Shape shape3;
        ButtonColors buttonColors3;
        MutableInteractionSource mutableInteractionSource2;
        int i13;
        BorderStroke borderStroke3;
        PaddingValues paddingValues2;
        ButtonElevation buttonElevation3;
        final MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues3;
        final boolean z7;
        final ButtonColors buttonColors4;
        final BorderStroke borderStroke4;
        final Modifier modifier3;
        final Shape shape4;
        final ButtonElevation buttonElevation4;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-2106428362);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i16 = i6 & 2;
        if (i16 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(z5) ? 256 : 128;
                if ((i5 & 3072) == 0) {
                    if ((i6 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i15 = 2048;
                            i7 |= i15;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i15 = 1024;
                    i7 |= i15;
                } else {
                    shape2 = shape;
                }
                if ((i5 & 24576) == 0) {
                    if ((i6 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i14 = 16384;
                            i7 |= i14;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i14 = 8192;
                    i7 |= i14;
                } else {
                    buttonColors2 = buttonColors;
                }
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    buttonElevation2 = buttonElevation;
                    i7 |= startRestartGroup.changed(buttonElevation2) ? 131072 : 65536;
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((1572864 & i5) == 0) {
                        borderStroke2 = borderStroke;
                        i7 |= startRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        i11 = i6 & 128;
                        if (i11 != 0) {
                            i7 |= 12582912;
                        } else if ((i5 & 12582912) == 0) {
                            i7 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                        }
                        i12 = i6 & 256;
                        if (i12 != 0) {
                            i7 |= 100663296;
                        } else if ((i5 & 100663296) == 0) {
                            i7 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i6 & 512) != 0) {
                            i7 |= 805306368;
                        } else if ((i5 & 805306368) == 0) {
                            i7 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            if ((i7 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    modifier2 = i16 == 0 ? Modifier.INSTANCE : modifier;
                                    z6 = i8 == 0 ? true : z5;
                                    if ((i6 & 8) == 0) {
                                        shape3 = ButtonDefaults.INSTANCE.getTextShape(startRestartGroup, 6);
                                        i7 &= -7169;
                                    } else {
                                        shape3 = shape2;
                                    }
                                    if ((i6 & 16) == 0) {
                                        buttonColors3 = ButtonDefaults.INSTANCE.textButtonColors(startRestartGroup, 6);
                                        i7 &= -57345;
                                    } else {
                                        buttonColors3 = buttonColors2;
                                    }
                                    if (i9 != 0) {
                                        buttonElevation2 = null;
                                    }
                                    if (i10 != 0) {
                                        borderStroke2 = null;
                                    }
                                    PaddingValues textButtonContentPadding = i11 == 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
                                    mutableInteractionSource2 = i12 == 0 ? mutableInteractionSource : null;
                                    i13 = i7;
                                    borderStroke3 = borderStroke2;
                                    paddingValues2 = textButtonContentPadding;
                                    buttonElevation3 = buttonElevation2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i6 & 8) != 0) {
                                        i7 &= -7169;
                                    }
                                    if ((i6 & 16) != 0) {
                                        i7 &= -57345;
                                    }
                                    modifier2 = modifier;
                                    z6 = z5;
                                    shape3 = shape2;
                                    buttonColors3 = buttonColors2;
                                    buttonElevation3 = buttonElevation2;
                                    borderStroke3 = borderStroke2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i13 = i7;
                                    paddingValues2 = paddingValues;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2106428362, i13, -1, "androidx.compose.material3.TextButton (Button.kt:430)");
                                }
                                Button(function0, modifier2, z6, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i13 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource3 = mutableInteractionSource2;
                                paddingValues3 = paddingValues2;
                                z7 = z6;
                                buttonColors4 = buttonColors3;
                                borderStroke4 = borderStroke3;
                                modifier3 = modifier2;
                                shape4 = shape3;
                                buttonElevation4 = buttonElevation3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier;
                                z7 = z5;
                                shape4 = shape2;
                                buttonColors4 = buttonColors2;
                                buttonElevation4 = buttonElevation2;
                                borderStroke4 = borderStroke2;
                                paddingValues3 = paddingValues;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$TextButton$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i17) {
                                        ButtonKt.TextButton(function0, modifier3, z7, shape4, buttonColors4, buttonElevation4, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i7 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if ((i6 & 8) == 0) {
                        }
                        if ((i6 & 16) == 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        i13 = i7;
                        borderStroke3 = borderStroke2;
                        paddingValues2 = textButtonContentPadding;
                        buttonElevation3 = buttonElevation2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Button(function0, modifier2, z6, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i13 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        paddingValues3 = paddingValues2;
                        z7 = z6;
                        buttonColors4 = buttonColors3;
                        borderStroke4 = borderStroke3;
                        modifier3 = modifier2;
                        shape4 = shape3;
                        buttonElevation4 = buttonElevation3;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    i11 = i6 & 128;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 256;
                    if (i12 != 0) {
                    }
                    if ((i6 & 512) != 0) {
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) != 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i6 & 8) == 0) {
                    }
                    if ((i6 & 16) == 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    i13 = i7;
                    borderStroke3 = borderStroke2;
                    paddingValues2 = textButtonContentPadding;
                    buttonElevation3 = buttonElevation2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Button(function0, modifier2, z6, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i13 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    paddingValues3 = paddingValues2;
                    z7 = z6;
                    buttonColors4 = buttonColors3;
                    borderStroke4 = borderStroke3;
                    modifier3 = modifier2;
                    shape4 = shape3;
                    buttonElevation4 = buttonElevation3;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                buttonElevation2 = buttonElevation;
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                borderStroke2 = borderStroke;
                i11 = i6 & 128;
                if (i11 != 0) {
                }
                i12 = i6 & 256;
                if (i12 != 0) {
                }
                if ((i6 & 512) != 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i16 == 0) {
                }
                if (i8 == 0) {
                }
                if ((i6 & 8) == 0) {
                }
                if ((i6 & 16) == 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                i13 = i7;
                borderStroke3 = borderStroke2;
                paddingValues2 = textButtonContentPadding;
                buttonElevation3 = buttonElevation2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Button(function0, modifier2, z6, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i13 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                paddingValues3 = paddingValues2;
                z7 = z6;
                buttonColors4 = buttonColors3;
                borderStroke4 = borderStroke3;
                modifier3 = modifier2;
                shape4 = shape3;
                buttonElevation4 = buttonElevation3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i5 & 3072) == 0) {
            }
            if ((i5 & 24576) == 0) {
            }
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            buttonElevation2 = buttonElevation;
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            borderStroke2 = borderStroke;
            i11 = i6 & 128;
            if (i11 != 0) {
            }
            i12 = i6 & 256;
            if (i12 != 0) {
            }
            if ((i6 & 512) != 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i16 == 0) {
            }
            if (i8 == 0) {
            }
            if ((i6 & 8) == 0) {
            }
            if ((i6 & 16) == 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            i13 = i7;
            borderStroke3 = borderStroke2;
            paddingValues2 = textButtonContentPadding;
            buttonElevation3 = buttonElevation2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Button(function0, modifier2, z6, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i13 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            paddingValues3 = paddingValues2;
            z7 = z6;
            buttonColors4 = buttonColors3;
            borderStroke4 = borderStroke3;
            modifier3 = modifier2;
            shape4 = shape3;
            buttonElevation4 = buttonElevation3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        if ((i5 & 3072) == 0) {
        }
        if ((i5 & 24576) == 0) {
        }
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        buttonElevation2 = buttonElevation;
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        borderStroke2 = borderStroke;
        i11 = i6 & 128;
        if (i11 != 0) {
        }
        i12 = i6 & 256;
        if (i12 != 0) {
        }
        if ((i6 & 512) != 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i16 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i6 & 8) == 0) {
        }
        if ((i6 & 16) == 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        i13 = i7;
        borderStroke3 = borderStroke2;
        paddingValues2 = textButtonContentPadding;
        buttonElevation3 = buttonElevation2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Button(function0, modifier2, z6, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i13 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource3 = mutableInteractionSource2;
        paddingValues3 = paddingValues2;
        z7 = z6;
        buttonColors4 = buttonColors3;
        borderStroke4 = borderStroke3;
        modifier3 = modifier2;
        shape4 = shape3;
        buttonElevation4 = buttonElevation3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
