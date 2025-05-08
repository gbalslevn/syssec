package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.IconButtonTokens;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aU\u0010\f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/material3/IconButtonColors;", "colors", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "content", "IconButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IconButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IconButton(final Function0<Unit> function0, Modifier modifier, boolean z5, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        boolean z6;
        IconButtonColors iconButtonColors2;
        int i9;
        MutableInteractionSource mutableInteractionSource2;
        boolean z7;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final boolean z8;
        final IconButtonColors iconButtonColors3;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1142896114);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i11 = i6 & 2;
        if (i11 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                z6 = z5;
                i7 |= startRestartGroup.changed(z6) ? 256 : 128;
                if ((i5 & 3072) == 0) {
                    if ((i6 & 8) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        if (startRestartGroup.changed(iconButtonColors2)) {
                            i10 = 2048;
                            i7 |= i10;
                        }
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i10 = 1024;
                    i7 |= i10;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i7 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    if ((i6 & 32) == 0) {
                        i7 |= 196608;
                    } else if ((i5 & 196608) == 0) {
                        i7 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
                    }
                    if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            boolean z9 = i8 == 0 ? z6 : true;
                            if ((i6 & 8) != 0) {
                                i7 &= -7169;
                                iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(startRestartGroup, 6);
                            }
                            if (i9 == 0) {
                                mutableInteractionSource3 = null;
                                z7 = z9;
                            } else {
                                z7 = z9;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            modifier3 = modifier2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i6 & 8) != 0) {
                                i7 &= -7169;
                            }
                            mutableInteractionSource3 = mutableInteractionSource2;
                            modifier3 = modifier2;
                            z7 = z6;
                        }
                        IconButtonColors iconButtonColors4 = iconButtonColors2;
                        int i12 = i7;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1142896114, i12, -1, "androidx.compose.material3.IconButton (IconButton.kt:88)");
                        }
                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                        IconButtonTokens iconButtonTokens = IconButtonTokens.INSTANCE;
                        Modifier m120clickableO2vRcR0$default = ClickableKt.m120clickableO2vRcR0$default(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m331size3ABfNKs(minimumInteractiveComponentSize, iconButtonTokens.m1088getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(iconButtonTokens.getStateLayerShape(), startRestartGroup, 6)), iconButtonColors4.m851containerColorvNxB06k$material3_release(z7), null, 2, null), mutableInteractionSource3, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, Dp.m2599constructorimpl(iconButtonTokens.m1088getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z7, null, Role.m2163boximpl(Role.INSTANCE.m2170getButtono7Vup1c()), function0, 8, null);
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m120clickableO2vRcR0$default);
                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(iconButtonColors4.m852contentColorvNxB06k$material3_release(z7))), function2, startRestartGroup, ProvidedValue.$stable | ((i12 >> 12) & 112));
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z7;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        iconButtonColors3 = iconButtonColors4;
                        modifier4 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z8 = z6;
                        iconButtonColors3 = iconButtonColors2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconButtonKt$IconButton$2
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

                            public final void invoke(Composer composer2, int i13) {
                                IconButtonKt.IconButton(function0, modifier4, z8, iconButtonColors3, mutableInteractionSource4, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i6 & 32) == 0) {
                }
                if ((74899 & i7) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i8 == 0) {
                }
                if ((i6 & 8) != 0) {
                }
                if (i9 == 0) {
                }
                modifier3 = modifier2;
                IconButtonColors iconButtonColors42 = iconButtonColors2;
                int i122 = i7;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier minimumInteractiveComponentSize2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
                IconButtonTokens iconButtonTokens2 = IconButtonTokens.INSTANCE;
                Modifier m120clickableO2vRcR0$default2 = ClickableKt.m120clickableO2vRcR0$default(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m331size3ABfNKs(minimumInteractiveComponentSize2, iconButtonTokens2.m1088getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(iconButtonTokens2.getStateLayerShape(), startRestartGroup, 6)), iconButtonColors42.m851containerColorvNxB06k$material3_release(z7), null, 2, null), mutableInteractionSource3, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, Dp.m2599constructorimpl(iconButtonTokens2.m1088getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z7, null, Role.m2163boximpl(Role.INSTANCE.m2170getButtono7Vup1c()), function0, 8, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m120clickableO2vRcR0$default2);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(iconButtonColors42.m852contentColorvNxB06k$material3_release(z7))), function2, startRestartGroup, ProvidedValue.$stable | ((i122 >> 12) & 112));
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                z8 = z7;
                mutableInteractionSource2 = mutableInteractionSource3;
                iconButtonColors3 = iconButtonColors42;
                modifier4 = modifier3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z6 = z5;
            if ((i5 & 3072) == 0) {
            }
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i6 & 32) == 0) {
            }
            if ((74899 & i7) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i8 == 0) {
            }
            if ((i6 & 8) != 0) {
            }
            if (i9 == 0) {
            }
            modifier3 = modifier2;
            IconButtonColors iconButtonColors422 = iconButtonColors2;
            int i1222 = i7;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier minimumInteractiveComponentSize22 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
            IconButtonTokens iconButtonTokens22 = IconButtonTokens.INSTANCE;
            Modifier m120clickableO2vRcR0$default22 = ClickableKt.m120clickableO2vRcR0$default(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m331size3ABfNKs(minimumInteractiveComponentSize22, iconButtonTokens22.m1088getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(iconButtonTokens22.getStateLayerShape(), startRestartGroup, 6)), iconButtonColors422.m851containerColorvNxB06k$material3_release(z7), null, 2, null), mutableInteractionSource3, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, Dp.m2599constructorimpl(iconButtonTokens22.m1088getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z7, null, Role.m2163boximpl(Role.INSTANCE.m2170getButtono7Vup1c()), function0, 8, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m120clickableO2vRcR0$default22);
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion22.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(iconButtonColors422.m852contentColorvNxB06k$material3_release(z7))), function2, startRestartGroup, ProvidedValue.$stable | ((i1222 >> 12) & 112));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            z8 = z7;
            mutableInteractionSource2 = mutableInteractionSource3;
            iconButtonColors3 = iconButtonColors422;
            modifier4 = modifier3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        z6 = z5;
        if ((i5 & 3072) == 0) {
        }
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i6 & 32) == 0) {
        }
        if ((74899 & i7) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i8 == 0) {
        }
        if ((i6 & 8) != 0) {
        }
        if (i9 == 0) {
        }
        modifier3 = modifier2;
        IconButtonColors iconButtonColors4222 = iconButtonColors2;
        int i12222 = i7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier minimumInteractiveComponentSize222 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier3);
        IconButtonTokens iconButtonTokens222 = IconButtonTokens.INSTANCE;
        Modifier m120clickableO2vRcR0$default222 = ClickableKt.m120clickableO2vRcR0$default(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m331size3ABfNKs(minimumInteractiveComponentSize222, iconButtonTokens222.m1088getStateLayerSizeD9Ej5fM()), ShapesKt.getValue(iconButtonTokens222.getStateLayerShape(), startRestartGroup, 6)), iconButtonColors4222.m851containerColorvNxB06k$material3_release(z7), null, 2, null), mutableInteractionSource3, RippleKt.m885rippleOrFallbackImplementation9IZ8Weo(false, Dp.m2599constructorimpl(iconButtonTokens222.m1088getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z7, null, Role.m2163boximpl(Role.INSTANCE.m2170getButtono7Vup1c()), function0, 8, null);
        MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m120clickableO2vRcR0$default222);
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222, companion222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion222.getSetModifier());
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(iconButtonColors4222.m852contentColorvNxB06k$material3_release(z7))), function2, startRestartGroup, ProvidedValue.$stable | ((i12222 >> 12) & 112));
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z8 = z7;
        mutableInteractionSource2 = mutableInteractionSource3;
        iconButtonColors3 = iconButtonColors4222;
        modifier4 = modifier3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
