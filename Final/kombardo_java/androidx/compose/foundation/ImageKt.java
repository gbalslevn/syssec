package androidx.compose.foundation;

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
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aU\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", "painter", BuildConfig.FLAVOR, "contentDescription", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", BuildConfig.FLAVOR, "Image", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ImageKt {
    /* JADX WARN: Removed duplicated region for block: B:104:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Image(final Painter painter, final String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f5, ColorFilter colorFilter, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        Alignment alignment2;
        int i9;
        ContentScale contentScale2;
        int i10;
        float f6;
        int i11;
        ColorFilter colorFilter2;
        Modifier modifier3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final Alignment alignment3;
        final ContentScale contentScale3;
        final Modifier modifier4;
        final ColorFilter colorFilter3;
        final float f7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1142754848);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(painter) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i12 = i6 & 4;
        if (i12 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                alignment2 = alignment;
                i7 |= startRestartGroup.changed(alignment2) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    contentScale2 = contentScale;
                    i7 |= startRestartGroup.changed(contentScale2) ? 16384 : 8192;
                    i10 = i6 & 32;
                    if (i10 == 0) {
                        i7 |= 196608;
                    } else if ((196608 & i5) == 0) {
                        f6 = f5;
                        i7 |= startRestartGroup.changed(f6) ? 131072 : 65536;
                        i11 = i6 & 64;
                        if (i11 != 0) {
                            i7 |= 1572864;
                            colorFilter2 = colorFilter;
                        } else {
                            colorFilter2 = colorFilter;
                            if ((i5 & 1572864) == 0) {
                                i7 |= startRestartGroup.changed(colorFilter2) ? 1048576 : 524288;
                            }
                        }
                        if ((i7 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            Alignment center = i8 != 0 ? Alignment.INSTANCE.getCenter() : alignment2;
                            ContentScale fit = i9 != 0 ? ContentScale.INSTANCE.getFit() : contentScale2;
                            float f8 = i10 != 0 ? 1.0f : f6;
                            if (i11 != 0) {
                                colorFilter2 = null;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1142754848, i7, -1, "androidx.compose.foundation.Image (Image.kt:243)");
                            }
                            if (str != null) {
                                startRestartGroup.startReplaceGroup(1040258775);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                boolean z5 = (i7 & 112) == 32;
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$semantics$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                                            SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m2173getImageo7Vup1c());
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                modifier3 = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(1040398089);
                                startRestartGroup.endReplaceGroup();
                                modifier3 = Modifier.INSTANCE;
                            }
                            Modifier paint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifier3)), painter, false, center, fit, f8, colorFilter2, 2, null);
                            ImageKt$Image$1 imageKt$Image$1 = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt$Image$1
                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                    return MeasureScope.layout$default(measureScope, Constraints.m2580getMinWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$1.1
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }
                                    }, 4, null);
                                }
                            };
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
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
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, imageKt$Image$1, companion2.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            startRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            alignment3 = center;
                            float f9 = f8;
                            contentScale3 = fit;
                            modifier4 = modifier2;
                            colorFilter3 = colorFilter2;
                            f7 = f9;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            alignment3 = alignment2;
                            contentScale3 = contentScale2;
                            colorFilter3 = colorFilter2;
                            f7 = f6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    ImageKt.Image(Painter.this, str, modifier4, alignment3, contentScale3, f7, colorFilter3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    f6 = f5;
                    i11 = i6 & 64;
                    if (i11 != 0) {
                    }
                    if ((i7 & 599187) == 599186) {
                    }
                    if (i12 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (str != null) {
                    }
                    Modifier paint$default2 = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifier3)), painter, false, center, fit, f8, colorFilter2, 2, null);
                    ImageKt$Image$1 imageKt$Image$12 = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt$Image$1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* renamed from: measure-3p2s80s */
                        public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                            return MeasureScope.layout$default(measureScope, Constraints.m2580getMinWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$1.1
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }
                            }, 4, null);
                        }
                    };
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default2);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, imageKt$Image$12, companion22.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    alignment3 = center;
                    float f92 = f8;
                    contentScale3 = fit;
                    modifier4 = modifier2;
                    colorFilter3 = colorFilter2;
                    f7 = f92;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                contentScale2 = contentScale;
                i10 = i6 & 32;
                if (i10 == 0) {
                }
                f6 = f5;
                i11 = i6 & 64;
                if (i11 != 0) {
                }
                if ((i7 & 599187) == 599186) {
                }
                if (i12 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (str != null) {
                }
                Modifier paint$default22 = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifier3)), painter, false, center, fit, f8, colorFilter2, 2, null);
                ImageKt$Image$1 imageKt$Image$122 = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt$Image$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        return MeasureScope.layout$default(measureScope, Constraints.m2580getMinWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$1.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }
                        }, 4, null);
                    }
                };
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default22);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, imageKt$Image$122, companion222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                alignment3 = center;
                float f922 = f8;
                contentScale3 = fit;
                modifier4 = modifier2;
                colorFilter3 = colorFilter2;
                f7 = f922;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            alignment2 = alignment;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            contentScale2 = contentScale;
            i10 = i6 & 32;
            if (i10 == 0) {
            }
            f6 = f5;
            i11 = i6 & 64;
            if (i11 != 0) {
            }
            if ((i7 & 599187) == 599186) {
            }
            if (i12 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (str != null) {
            }
            Modifier paint$default222 = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifier3)), painter, false, center, fit, f8, colorFilter2, 2, null);
            ImageKt$Image$1 imageKt$Image$1222 = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt$Image$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                    return MeasureScope.layout$default(measureScope, Constraints.m2580getMinWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope placementScope) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }
                    }, 4, null);
                }
            };
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default222);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor222 = companion2222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, imageKt$Image$1222, companion2222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion2222.getSetResolvedCompositionLocals());
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion2222.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion2222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            alignment3 = center;
            float f9222 = f8;
            contentScale3 = fit;
            modifier4 = modifier2;
            colorFilter3 = colorFilter2;
            f7 = f9222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        alignment2 = alignment;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        contentScale2 = contentScale;
        i10 = i6 & 32;
        if (i10 == 0) {
        }
        f6 = f5;
        i11 = i6 & 64;
        if (i11 != 0) {
        }
        if ((i7 & 599187) == 599186) {
        }
        if (i12 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (str != null) {
        }
        Modifier paint$default2222 = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier2.then(modifier3)), painter, false, center, fit, f8, colorFilter2, 2, null);
        ImageKt$Image$1 imageKt$Image$12222 = new MeasurePolicy() { // from class: androidx.compose.foundation.ImageKt$Image$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                return MeasureScope.layout$default(measureScope, Constraints.m2580getMinWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ImageKt$Image$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }
                }, 4, null);
            }
        };
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, paint$default2222);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2222 = companion22222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, imageKt$Image$12222, companion22222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion22222.getSetResolvedCompositionLocals());
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion22222.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion22222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        alignment3 = center;
        float f92222 = f8;
        contentScale3 = fit;
        modifier4 = modifier2;
        colorFilter3 = colorFilter2;
        f7 = f92222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
