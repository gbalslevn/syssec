package dk.molslinjen.ui.views.reusable;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.CircledBorderIconKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u001ao\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "icon", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "Landroidx/compose/ui/unit/Dp;", "containerSize", "iconSize", "Landroidx/compose/ui/graphics/Color;", "borderTint", "iconTint", "backgroundColor", BuildConfig.FLAVOR, "contentDescription", "CircledBorderIcon-kaRa2wg", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function0;FFJJJLjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "CircledBorderIcon", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CircledBorderIconKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00e8  */
    /* renamed from: CircledBorderIcon-kaRa2wg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3385CircledBorderIconkaRa2wg(Modifier modifier, final int i5, final Function0<Unit> onClick, float f5, float f6, long j5, long j6, long j7, String str, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        float f7;
        int i9;
        float f8;
        int i10;
        int i11;
        long j8;
        int i12;
        int i13;
        int i14;
        long m3266getGrey30d7_KjU;
        long m3281getWhite0d7_KjU;
        boolean z5;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final String str2;
        final float f9;
        final float f10;
        final Modifier modifier3;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-288853551);
        int i16 = i7 & 1;
        if (i16 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i8 = i6;
        }
        if ((2 & i7) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i17 = i7 & 8;
        if (i17 != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            f7 = f5;
            i8 |= startRestartGroup.changed(f7) ? 2048 : 1024;
            i9 = 16 & i7;
            if (i9 == 0) {
                i8 |= 24576;
            } else if ((i6 & 24576) == 0) {
                f8 = f6;
                i8 |= startRestartGroup.changed(f8) ? 16384 : 8192;
                i10 = i7 & 32;
                if (i10 != 0) {
                    i8 |= 196608;
                    i11 = i17;
                    j8 = j5;
                } else {
                    i11 = i17;
                    j8 = j5;
                    if ((i6 & 196608) == 0) {
                        i8 |= startRestartGroup.changed(j8) ? 131072 : 65536;
                    }
                }
                i12 = i7 & 64;
                if (i12 != 0) {
                    i8 |= 1572864;
                } else if ((i6 & 1572864) == 0) {
                    i8 |= startRestartGroup.changed(j6) ? 1048576 : 524288;
                }
                i13 = 128 & i7;
                if (i13 == 0) {
                    i15 = (i6 & 12582912) == 0 ? startRestartGroup.changed(j7) ? 8388608 : 4194304 : 12582912;
                    i14 = i7 & 256;
                    if (i14 == 0) {
                        i8 |= 100663296;
                    } else if ((100663296 & i6) == 0) {
                        i8 |= startRestartGroup.changed(str) ? 67108864 : 33554432;
                        if ((38347923 & i8) == 38347922 || !startRestartGroup.getSkipping()) {
                            Modifier modifier4 = i16 != 0 ? Modifier.INSTANCE : modifier2;
                            if (i11 != 0) {
                                f7 = Dp.m2599constructorimpl(32);
                            }
                            float m2599constructorimpl = i9 != 0 ? Dp.m2599constructorimpl(12) : f8;
                            if (i10 != 0) {
                                j8 = AppColor.INSTANCE.m3267getGrey40d7_KjU();
                            }
                            m3266getGrey30d7_KjU = i12 != 0 ? AppColor.INSTANCE.m3266getGrey30d7_KjU() : j6;
                            m3281getWhite0d7_KjU = i13 != 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j7;
                            String str3 = i14 != 0 ? null : str;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-288853551, i8, -1, "dk.molslinjen.ui.views.reusable.CircledBorderIcon (CircledBorderIcon.kt:34)");
                            }
                            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(ClipKt.clip(SizeKt.m331size3ABfNKs(modifier4, f7), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(1), j8, RoundedCornerShapeKt.getCircleShape()), m3281getWhite0d7_KjU, null, 2, null);
                            startRestartGroup.startReplaceGroup(-177512547);
                            z5 = (i8 & 896) == 256;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function0() { // from class: W1.e
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                                        CircledBorderIcon_kaRa2wg$lambda$1$lambda$0 = CircledBorderIconKt.CircledBorderIcon_kaRa2wg$lambda$1$lambda$0(Function0.this);
                                        return CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default, false, null, null, (Function0) rememberedValue, 7, null);
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            Modifier modifier5 = modifier4;
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
                            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            long j10 = j8;
                            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i8 >> 3) & 14), str3, SizeKt.m331size3ABfNKs(Modifier.INSTANCE, m2599constructorimpl), m3266getGrey30d7_KjU, startRestartGroup, ((i8 >> 21) & 112) | ((i8 >> 9) & 7168), 0);
                            startRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            f9 = m2599constructorimpl;
                            f10 = f7;
                            modifier3 = modifier5;
                            j9 = j10;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            m3281getWhite0d7_KjU = j7;
                            f10 = f7;
                            modifier3 = modifier2;
                            str2 = str;
                            j9 = j8;
                            f9 = f8;
                            m3266getGrey30d7_KjU = j6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final long j11 = m3266getGrey30d7_KjU;
                            final long j12 = m3281getWhite0d7_KjU;
                            endRestartGroup.updateScope(new Function2() { // from class: W1.f
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit CircledBorderIcon_kaRa2wg$lambda$3;
                                    CircledBorderIcon_kaRa2wg$lambda$3 = CircledBorderIconKt.CircledBorderIcon_kaRa2wg$lambda$3(Modifier.this, i5, onClick, f10, f9, j9, j11, j12, str2, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                    return CircledBorderIcon_kaRa2wg$lambda$3;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((38347923 & i8) == 38347922) {
                    }
                    if (i16 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(ClipKt.clip(SizeKt.m331size3ABfNKs(modifier4, f7), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(1), j8, RoundedCornerShapeKt.getCircleShape()), m3281getWhite0d7_KjU, null, 2, null);
                    startRestartGroup.startReplaceGroup(-177512547);
                    if ((i8 & 896) == 256) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue = new Function0() { // from class: W1.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                            CircledBorderIcon_kaRa2wg$lambda$1$lambda$0 = CircledBorderIconKt.CircledBorderIcon_kaRa2wg$lambda$1$lambda$0(Function0.this);
                            return CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceGroup();
                    Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default2, false, null, null, (Function0) rememberedValue, 7, null);
                    MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    Modifier modifier52 = modifier4;
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default2);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    long j102 = j8;
                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i8 >> 3) & 14), str3, SizeKt.m331size3ABfNKs(Modifier.INSTANCE, m2599constructorimpl), m3266getGrey30d7_KjU, startRestartGroup, ((i8 >> 21) & 112) | ((i8 >> 9) & 7168), 0);
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    str2 = str3;
                    f9 = m2599constructorimpl;
                    f10 = f7;
                    modifier3 = modifier52;
                    j9 = j102;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 |= i15;
                i14 = i7 & 256;
                if (i14 == 0) {
                }
                if ((38347923 & i8) == 38347922) {
                }
                if (i16 != 0) {
                }
                if (i11 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier m104backgroundbw27NRU$default22 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(ClipKt.clip(SizeKt.m331size3ABfNKs(modifier4, f7), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(1), j8, RoundedCornerShapeKt.getCircleShape()), m3281getWhite0d7_KjU, null, 2, null);
                startRestartGroup.startReplaceGroup(-177512547);
                if ((i8 & 896) == 256) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue = new Function0() { // from class: W1.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                        CircledBorderIcon_kaRa2wg$lambda$1$lambda$0 = CircledBorderIconKt.CircledBorderIcon_kaRa2wg$lambda$1$lambda$0(Function0.this);
                        return CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                Modifier m122clickableXHw0xAI$default22 = ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default22, false, null, null, (Function0) rememberedValue, 7, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                Modifier modifier522 = modifier4;
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default22);
                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                long j1022 = j8;
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion22.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i8 >> 3) & 14), str3, SizeKt.m331size3ABfNKs(Modifier.INSTANCE, m2599constructorimpl), m3266getGrey30d7_KjU, startRestartGroup, ((i8 >> 21) & 112) | ((i8 >> 9) & 7168), 0);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                str2 = str3;
                f9 = m2599constructorimpl;
                f10 = f7;
                modifier3 = modifier522;
                j9 = j1022;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f8 = f6;
            i10 = i7 & 32;
            if (i10 != 0) {
            }
            i12 = i7 & 64;
            if (i12 != 0) {
            }
            i13 = 128 & i7;
            if (i13 == 0) {
            }
            i8 |= i15;
            i14 = i7 & 256;
            if (i14 == 0) {
            }
            if ((38347923 & i8) == 38347922) {
            }
            if (i16 != 0) {
            }
            if (i11 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m104backgroundbw27NRU$default222 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(ClipKt.clip(SizeKt.m331size3ABfNKs(modifier4, f7), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(1), j8, RoundedCornerShapeKt.getCircleShape()), m3281getWhite0d7_KjU, null, 2, null);
            startRestartGroup.startReplaceGroup(-177512547);
            if ((i8 & 896) == 256) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue = new Function0() { // from class: W1.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                    CircledBorderIcon_kaRa2wg$lambda$1$lambda$0 = CircledBorderIconKt.CircledBorderIcon_kaRa2wg$lambda$1$lambda$0(Function0.this);
                    return CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default222 = ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default222, false, null, null, (Function0) rememberedValue, 7, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier modifier5222 = modifier4;
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default222);
            ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            long j10222 = j8;
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222, companion222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion222.getSetModifier());
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i8 >> 3) & 14), str3, SizeKt.m331size3ABfNKs(Modifier.INSTANCE, m2599constructorimpl), m3266getGrey30d7_KjU, startRestartGroup, ((i8 >> 21) & 112) | ((i8 >> 9) & 7168), 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            str2 = str3;
            f9 = m2599constructorimpl;
            f10 = f7;
            modifier3 = modifier5222;
            j9 = j10222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f7 = f5;
        i9 = 16 & i7;
        if (i9 == 0) {
        }
        f8 = f6;
        i10 = i7 & 32;
        if (i10 != 0) {
        }
        i12 = i7 & 64;
        if (i12 != 0) {
        }
        i13 = 128 & i7;
        if (i13 == 0) {
        }
        i8 |= i15;
        i14 = i7 & 256;
        if (i14 == 0) {
        }
        if ((38347923 & i8) == 38347922) {
        }
        if (i16 != 0) {
        }
        if (i11 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m104backgroundbw27NRU$default2222 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.m108borderxT4_qwU(ClipKt.clip(SizeKt.m331size3ABfNKs(modifier4, f7), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(1), j8, RoundedCornerShapeKt.getCircleShape()), m3281getWhite0d7_KjU, null, 2, null);
        startRestartGroup.startReplaceGroup(-177512547);
        if ((i8 & 896) == 256) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue = new Function0() { // from class: W1.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
                CircledBorderIcon_kaRa2wg$lambda$1$lambda$0 = CircledBorderIconKt.CircledBorderIcon_kaRa2wg$lambda$1$lambda$0(Function0.this);
                return CircledBorderIcon_kaRa2wg$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier m122clickableXHw0xAI$default2222 = ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default2222, false, null, null, (Function0) rememberedValue, 7, null);
        MeasurePolicy maybeCachedBoxMeasurePolicy2222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        Modifier modifier52222 = modifier4;
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default2222);
        ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2222 = companion2222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        long j102222 = j8;
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2222, companion2222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion2222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion2222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion2222.getSetModifier());
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i8 >> 3) & 14), str3, SizeKt.m331size3ABfNKs(Modifier.INSTANCE, m2599constructorimpl), m3266getGrey30d7_KjU, startRestartGroup, ((i8 >> 21) & 112) | ((i8 >> 9) & 7168), 0);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        str2 = str3;
        f9 = m2599constructorimpl;
        f10 = f7;
        modifier3 = modifier52222;
        j9 = j102222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircledBorderIcon_kaRa2wg$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircledBorderIcon_kaRa2wg$lambda$3(Modifier modifier, int i5, Function0 function0, float f5, float f6, long j5, long j6, long j7, String str, int i6, int i7, Composer composer, int i8) {
        m3385CircledBorderIconkaRa2wg(modifier, i5, function0, f5, f6, j5, j6, j7, str, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
