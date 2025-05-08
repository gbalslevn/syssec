package dk.molslinjen.ui.views.screens.booking.addons.seating.seat;

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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.domain.FerrySeatTypeExtensionsKt;
import dk.molslinjen.extensions.domain.FerrySeatingGroupTypeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.addons.seating.seat.FerrySeatViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatType;
import uniffi.molslinjen_shared.FerrySeatingGroupType;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aY\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a/\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType;", "groupType", BuildConfig.FLAVOR, "seatNumberInGroup", "Luniffi/molslinjen_shared/FerrySeatType;", "seatType", "Landroidx/compose/ui/unit/Dp;", "size", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/seat/SeatOrientation;", "orientation", BuildConfig.FLAVOR, "groupRotation", BuildConfig.FLAVOR, "isSelected", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "FerrySeatView-aA_HZ9I", "(Luniffi/molslinjen_shared/FerrySeatingGroupType;ILuniffi/molslinjen_shared/FerrySeatType;FLdk/molslinjen/ui/views/screens/booking/addons/seating/seat/SeatOrientation;FZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FerrySeatView", BuildConfig.FLAVOR, "buildContentDescription", "(ZLuniffi/molslinjen_shared/FerrySeatType;Luniffi/molslinjen_shared/FerrySeatingGroupType;ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerrySeatViewKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00d8  */
    /* renamed from: FerrySeatView-aA_HZ9I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3442FerrySeatViewaA_HZ9I(final FerrySeatingGroupType groupType, final int i5, final FerrySeatType seatType, float f5, SeatOrientation seatOrientation, final float f6, final boolean z5, final Function0<Unit> onClick, Composer composer, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        final float f7;
        int i11;
        SeatOrientation seatOrientation2;
        boolean changedInstance;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        Composer composer2;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final SeatOrientation seatOrientation3;
        final float f8;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(groupType, "groupType");
        Intrinsics.checkNotNullParameter(seatType, "seatType");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(607849898);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(groupType) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((2 & i7) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
            i9 = i8;
            if ((4 & i7) == 0) {
                i9 |= 384;
            } else if ((i6 & 384) == 0) {
                i9 |= startRestartGroup.changed(seatType) ? 256 : 128;
            }
            i10 = i7 & 8;
            if (i10 == 0) {
                i9 |= 3072;
            } else if ((i6 & 3072) == 0) {
                f7 = f5;
                i9 |= startRestartGroup.changed(f7) ? 2048 : 1024;
                i11 = 16 & i7;
                if (i11 != 0) {
                    i9 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    seatOrientation2 = seatOrientation;
                    i9 |= startRestartGroup.changed(seatOrientation2) ? 16384 : 8192;
                    if ((32 & i7) == 0) {
                        i9 |= 196608;
                    } else if ((i6 & 196608) == 0) {
                        i9 |= startRestartGroup.changed(f6) ? 131072 : 65536;
                    }
                    if ((i7 & 64) == 0) {
                        i9 |= 1572864;
                    } else if ((i6 & 1572864) == 0) {
                        i9 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                    }
                    if ((128 & i7) == 0) {
                        i9 |= 12582912;
                    } else if ((i6 & 12582912) == 0) {
                        i9 |= startRestartGroup.changedInstance(onClick) ? 8388608 : 4194304;
                    }
                    if ((4793491 & i9) == 4793490 || !startRestartGroup.getSkipping()) {
                        if (i10 != 0) {
                            f7 = FerrySectionSeatsViewModel.INSTANCE.m3451getSeatSizeD9Ej5fM();
                        }
                        SeatOrientation seatOrientation4 = i11 == 0 ? SeatOrientation.Down : seatOrientation2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(607849898, i9, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.seat.FerrySeatView (FerrySeatView.kt:45)");
                        }
                        int drawableRes = !z5 ? R.drawable.seat_selected : FerrySeatTypeExtensionsKt.getDrawableRes(seatType);
                        int i12 = i9 << 6;
                        final String buildContentDescription = buildContentDescription(z5, seatType, groupType, i5, startRestartGroup, ((i9 >> 18) & 14) | ((i9 >> 3) & 112) | (i12 & 896) | (i12 & 7168));
                        final Painter painterResource = PainterResources_androidKt.painterResource(drawableRes, startRestartGroup, 0);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Modifier rotate = RotateKt.rotate(SizeKt.m331size3ABfNKs(companion, f7), seatOrientation4.getRotation());
                        startRestartGroup.startReplaceGroup(-1039622908);
                        changedInstance = startRestartGroup.changedInstance(painterResource) | ((i9 & 7168) != 2048);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1() { // from class: G2.a
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit FerrySeatView_aA_HZ9I$lambda$2$lambda$1;
                                    FerrySeatView_aA_HZ9I$lambda$2$lambda$1 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$2$lambda$1(Painter.this, f7, (DrawScope) obj);
                                    return FerrySeatView_aA_HZ9I$lambda$2$lambda$1;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier clip = ClipKt.clip(DrawModifierKt.drawBehind(rotate, (Function1) rememberedValue), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)));
                        startRestartGroup.startReplaceGroup(-1039616967);
                        changed = startRestartGroup.changed(buildContentDescription);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function1() { // from class: G2.b
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit FerrySeatView_aA_HZ9I$lambda$4$lambda$3;
                                    FerrySeatView_aA_HZ9I$lambda$4$lambda$3 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$4$lambda$3(buildContentDescription, (SemanticsPropertyReceiver) obj);
                                    return FerrySeatView_aA_HZ9I$lambda$4$lambda$3;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        float f9 = f7;
                        composer2 = startRestartGroup;
                        Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(SemanticsModifierKt.semantics$default(clip, false, (Function1) rememberedValue2, 1, null), seatType == FerrySeatType.AVAILABLE, null, null, onClick, 6, null);
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getBottomCenter(), false);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m122clickableXHw0xAI$default);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.useNode();
                        } else {
                            composer2.createNode(constructor);
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer2.startReplaceGroup(-2085544261);
                        if (z5) {
                            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.seat_checkmark, composer2, 6), Accessibility.INSTANCE.getSkip(), RotateKt.rotate(companion, -(seatOrientation4.getRotation() + f6)), AppColor.INSTANCE.m3281getWhite0d7_KjU(), composer2, 3072, 0);
                        }
                        composer2.endReplaceGroup();
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        seatOrientation3 = seatOrientation4;
                        f8 = f9;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        f8 = f7;
                        composer2 = startRestartGroup;
                        seatOrientation3 = seatOrientation2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: G2.c
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit FerrySeatView_aA_HZ9I$lambda$6;
                                FerrySeatView_aA_HZ9I$lambda$6 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$6(FerrySeatingGroupType.this, i5, seatType, f8, seatOrientation3, f6, z5, onClick, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                return FerrySeatView_aA_HZ9I$lambda$6;
                            }
                        });
                        return;
                    }
                    return;
                }
                seatOrientation2 = seatOrientation;
                if ((32 & i7) == 0) {
                }
                if ((i7 & 64) == 0) {
                }
                if ((128 & i7) == 0) {
                }
                if ((4793491 & i9) == 4793490) {
                }
                if (i10 != 0) {
                }
                if (i11 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int drawableRes2 = !z5 ? R.drawable.seat_selected : FerrySeatTypeExtensionsKt.getDrawableRes(seatType);
                int i122 = i9 << 6;
                final String buildContentDescription2 = buildContentDescription(z5, seatType, groupType, i5, startRestartGroup, ((i9 >> 18) & 14) | ((i9 >> 3) & 112) | (i122 & 896) | (i122 & 7168));
                final Painter painterResource2 = PainterResources_androidKt.painterResource(drawableRes2, startRestartGroup, 0);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier rotate2 = RotateKt.rotate(SizeKt.m331size3ABfNKs(companion3, f7), seatOrientation4.getRotation());
                startRestartGroup.startReplaceGroup(-1039622908);
                changedInstance = startRestartGroup.changedInstance(painterResource2) | ((i9 & 7168) != 2048);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue = new Function1() { // from class: G2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit FerrySeatView_aA_HZ9I$lambda$2$lambda$1;
                        FerrySeatView_aA_HZ9I$lambda$2$lambda$1 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$2$lambda$1(Painter.this, f7, (DrawScope) obj);
                        return FerrySeatView_aA_HZ9I$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                Modifier clip2 = ClipKt.clip(DrawModifierKt.drawBehind(rotate2, (Function1) rememberedValue), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)));
                startRestartGroup.startReplaceGroup(-1039616967);
                changed = startRestartGroup.changed(buildContentDescription2);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new Function1() { // from class: G2.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit FerrySeatView_aA_HZ9I$lambda$4$lambda$3;
                        FerrySeatView_aA_HZ9I$lambda$4$lambda$3 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$4$lambda$3(buildContentDescription2, (SemanticsPropertyReceiver) obj);
                        return FerrySeatView_aA_HZ9I$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceGroup();
                float f92 = f7;
                composer2 = startRestartGroup;
                Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(SemanticsModifierKt.semantics$default(clip2, false, (Function1) rememberedValue2, 1, null), seatType == FerrySeatType.AVAILABLE, null, null, onClick, 6, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getBottomCenter(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m122clickableXHw0xAI$default2);
                ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                if (composer2.getApplier() == null) {
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy2, companion22.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceGroup(-2085544261);
                if (z5) {
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                seatOrientation3 = seatOrientation4;
                f8 = f92;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f7 = f5;
            i11 = 16 & i7;
            if (i11 != 0) {
            }
            seatOrientation2 = seatOrientation;
            if ((32 & i7) == 0) {
            }
            if ((i7 & 64) == 0) {
            }
            if ((128 & i7) == 0) {
            }
            if ((4793491 & i9) == 4793490) {
            }
            if (i10 != 0) {
            }
            if (i11 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int drawableRes22 = !z5 ? R.drawable.seat_selected : FerrySeatTypeExtensionsKt.getDrawableRes(seatType);
            int i1222 = i9 << 6;
            final String buildContentDescription22 = buildContentDescription(z5, seatType, groupType, i5, startRestartGroup, ((i9 >> 18) & 14) | ((i9 >> 3) & 112) | (i1222 & 896) | (i1222 & 7168));
            final Painter painterResource22 = PainterResources_androidKt.painterResource(drawableRes22, startRestartGroup, 0);
            Modifier.Companion companion32 = Modifier.INSTANCE;
            Modifier rotate22 = RotateKt.rotate(SizeKt.m331size3ABfNKs(companion32, f7), seatOrientation4.getRotation());
            startRestartGroup.startReplaceGroup(-1039622908);
            changedInstance = startRestartGroup.changedInstance(painterResource22) | ((i9 & 7168) != 2048);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue = new Function1() { // from class: G2.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit FerrySeatView_aA_HZ9I$lambda$2$lambda$1;
                    FerrySeatView_aA_HZ9I$lambda$2$lambda$1 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$2$lambda$1(Painter.this, f7, (DrawScope) obj);
                    return FerrySeatView_aA_HZ9I$lambda$2$lambda$1;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier clip22 = ClipKt.clip(DrawModifierKt.drawBehind(rotate22, (Function1) rememberedValue), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)));
            startRestartGroup.startReplaceGroup(-1039616967);
            changed = startRestartGroup.changed(buildContentDescription22);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new Function1() { // from class: G2.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit FerrySeatView_aA_HZ9I$lambda$4$lambda$3;
                    FerrySeatView_aA_HZ9I$lambda$4$lambda$3 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$4$lambda$3(buildContentDescription22, (SemanticsPropertyReceiver) obj);
                    return FerrySeatView_aA_HZ9I$lambda$4$lambda$3;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            float f922 = f7;
            composer2 = startRestartGroup;
            Modifier m122clickableXHw0xAI$default22 = ClickableKt.m122clickableXHw0xAI$default(SemanticsModifierKt.semantics$default(clip22, false, (Function1) rememberedValue2, 1, null), seatType == FerrySeatType.AVAILABLE, null, null, onClick, 6, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getBottomCenter(), false);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap22 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(composer2, m122clickableXHw0xAI$default22);
            ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
            if (composer2.getApplier() == null) {
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy22, companion222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            composer2.startReplaceGroup(-2085544261);
            if (z5) {
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            seatOrientation3 = seatOrientation4;
            f8 = f922;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i9 = i8;
        if ((4 & i7) == 0) {
        }
        i10 = i7 & 8;
        if (i10 == 0) {
        }
        f7 = f5;
        i11 = 16 & i7;
        if (i11 != 0) {
        }
        seatOrientation2 = seatOrientation;
        if ((32 & i7) == 0) {
        }
        if ((i7 & 64) == 0) {
        }
        if ((128 & i7) == 0) {
        }
        if ((4793491 & i9) == 4793490) {
        }
        if (i10 != 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int drawableRes222 = !z5 ? R.drawable.seat_selected : FerrySeatTypeExtensionsKt.getDrawableRes(seatType);
        int i12222 = i9 << 6;
        final String buildContentDescription222 = buildContentDescription(z5, seatType, groupType, i5, startRestartGroup, ((i9 >> 18) & 14) | ((i9 >> 3) & 112) | (i12222 & 896) | (i12222 & 7168));
        final Painter painterResource222 = PainterResources_androidKt.painterResource(drawableRes222, startRestartGroup, 0);
        Modifier.Companion companion322 = Modifier.INSTANCE;
        Modifier rotate222 = RotateKt.rotate(SizeKt.m331size3ABfNKs(companion322, f7), seatOrientation4.getRotation());
        startRestartGroup.startReplaceGroup(-1039622908);
        changedInstance = startRestartGroup.changedInstance(painterResource222) | ((i9 & 7168) != 2048);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function1() { // from class: G2.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit FerrySeatView_aA_HZ9I$lambda$2$lambda$1;
                FerrySeatView_aA_HZ9I$lambda$2$lambda$1 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$2$lambda$1(Painter.this, f7, (DrawScope) obj);
                return FerrySeatView_aA_HZ9I$lambda$2$lambda$1;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier clip222 = ClipKt.clip(DrawModifierKt.drawBehind(rotate222, (Function1) rememberedValue), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)));
        startRestartGroup.startReplaceGroup(-1039616967);
        changed = startRestartGroup.changed(buildContentDescription222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1() { // from class: G2.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit FerrySeatView_aA_HZ9I$lambda$4$lambda$3;
                FerrySeatView_aA_HZ9I$lambda$4$lambda$3 = FerrySeatViewKt.FerrySeatView_aA_HZ9I$lambda$4$lambda$3(buildContentDescription222, (SemanticsPropertyReceiver) obj);
                return FerrySeatView_aA_HZ9I$lambda$4$lambda$3;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        float f9222 = f7;
        composer2 = startRestartGroup;
        Modifier m122clickableXHw0xAI$default222 = ClickableKt.m122clickableXHw0xAI$default(SemanticsModifierKt.semantics$default(clip222, false, (Function1) rememberedValue2, 1, null), seatType == FerrySeatType.AVAILABLE, null, null, onClick, 6, null);
        MeasurePolicy maybeCachedBoxMeasurePolicy222 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getBottomCenter(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap222 = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(composer2, m122clickableXHw0xAI$default222);
        ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor222 = companion2222.getConstructor();
        if (composer2.getApplier() == null) {
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(composer2);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy222, companion2222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion2222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion2222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion2222.getSetModifier());
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        composer2.startReplaceGroup(-2085544261);
        if (z5) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        seatOrientation3 = seatOrientation4;
        f8 = f9222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySeatView_aA_HZ9I$lambda$2$lambda$1(Painter painter, float f5, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        Painter.m1748drawx_KDEd0$default(painter, drawBehind, drawBehind.mo213toSizeXkaWNTQ(DpKt.m2610DpSizeYgX7TsA(f5, f5)), 0.0f, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySeatView_aA_HZ9I$lambda$4$lambda$3(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySeatView_aA_HZ9I$lambda$6(FerrySeatingGroupType ferrySeatingGroupType, int i5, FerrySeatType ferrySeatType, float f5, SeatOrientation seatOrientation, float f6, boolean z5, Function0 function0, int i6, int i7, Composer composer, int i8) {
        m3442FerrySeatViewaA_HZ9I(ferrySeatingGroupType, i5, ferrySeatType, f5, seatOrientation, f6, z5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final String buildContentDescription(boolean z5, FerrySeatType ferrySeatType, FerrySeatingGroupType ferrySeatingGroupType, int i5, Composer composer, int i6) {
        String str;
        String stringResource;
        composer.startReplaceGroup(1832016287);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1832016287, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.seat.buildContentDescription (FerrySeatView.kt:96)");
        }
        if (z5) {
            composer.startReplaceGroup(962099730);
            str = StringResources_androidKt.stringResource(R.string.accessibilityLabel_seatSelected, composer, 6);
            composer.endReplaceGroup();
        } else if (ferrySeatType == FerrySeatType.AVAILABLE) {
            composer.startReplaceGroup(962103059);
            str = StringResources_androidKt.stringResource(R.string.accessibilityLabel_seatAvailable, composer, 6);
            composer.endReplaceGroup();
        } else if (ferrySeatType == FerrySeatType.NOT_AVAILABLE) {
            composer.startReplaceGroup(962106542);
            str = StringResources_androidKt.stringResource(R.string.accessibilityLabel_seatSold, composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-239401372);
            composer.endReplaceGroup();
            str = BuildConfig.FLAVOR;
        }
        if (ferrySeatingGroupType instanceof FerrySeatingGroupType.SingleSeat) {
            composer.startReplaceGroup(962112493);
            stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_singleSeat, new Object[]{str}, composer, 6);
            composer.endReplaceGroup();
        } else if (ferrySeatingGroupType instanceof FerrySeatingGroupType.DoubleSeat) {
            composer.startReplaceGroup(962117376);
            stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_doubleSeat, new Object[]{str, Integer.valueOf(i5), Integer.valueOf(FerrySeatingGroupTypeExtensionsKt.getNumberOfSeatsInGroup(ferrySeatingGroupType))}, composer, 6);
            composer.endReplaceGroup();
        } else if (ferrySeatingGroupType instanceof FerrySeatingGroupType.CornerTable) {
            composer.startReplaceGroup(962123971);
            stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_seatAtTable, new Object[]{str, Integer.valueOf(i5), Integer.valueOf(FerrySeatingGroupTypeExtensionsKt.getNumberOfSeatsInGroup(ferrySeatingGroupType))}, composer, 6);
            composer.endReplaceGroup();
        } else if (ferrySeatingGroupType instanceof FerrySeatingGroupType.CornerTableLarge) {
            composer.startReplaceGroup(962133795);
            stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_seatAtTable, new Object[]{str, Integer.valueOf(i5), Integer.valueOf(FerrySeatingGroupTypeExtensionsKt.getNumberOfSeatsInGroup(ferrySeatingGroupType))}, composer, 6);
            composer.endReplaceGroup();
        } else if (ferrySeatingGroupType instanceof FerrySeatingGroupType.LargeTable) {
            composer.startReplaceGroup(962143427);
            stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_seatAtTable, new Object[]{str, Integer.valueOf(i5), Integer.valueOf(FerrySeatingGroupTypeExtensionsKt.getNumberOfSeatsInGroup(ferrySeatingGroupType))}, composer, 6);
            composer.endReplaceGroup();
        } else if (ferrySeatingGroupType instanceof FerrySeatingGroupType.SmallTable) {
            composer.startReplaceGroup(962153059);
            stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_seatAtTable, new Object[]{str, Integer.valueOf(i5), Integer.valueOf(FerrySeatingGroupTypeExtensionsKt.getNumberOfSeatsInGroup(ferrySeatingGroupType))}, composer, 6);
            composer.endReplaceGroup();
        } else {
            if (!(ferrySeatingGroupType instanceof FerrySeatingGroupType.XLargeTable)) {
                composer.startReplaceGroup(962112048);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(962162723);
            stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_seatAtTable, new Object[]{str, Integer.valueOf(i5), Integer.valueOf(FerrySeatingGroupTypeExtensionsKt.getNumberOfSeatsInGroup(ferrySeatingGroupType))}, composer, 6);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return stringResource;
    }
}
