package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a8\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a8\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000e\u001a\u001b\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0016\u0010\u0015\u001a\u00020\u0012*\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "imageVector", BuildConfig.FLAVOR, "contentDescription", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "tint", BuildConfig.FLAVOR, "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "Icon", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/geometry/Size;", BuildConfig.FLAVOR, "isInfinite-uvyYCjk", "(J)Z", "isInfinite", "DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m331size3ABfNKs(Modifier.INSTANCE, IconButtonTokens.INSTANCE.m1087getIconSizeD9Ej5fM());

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0048  */
    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m858Iconww6aTOc(final ImageVector imageVector, final String str, Modifier modifier, long j5, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        long j6;
        Modifier modifier3;
        long value;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-126890956);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(imageVector) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                modifier2 = modifier;
                i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                if ((i5 & 3072) == 0) {
                    if ((i6 & 8) == 0) {
                        j6 = j5;
                        if (startRestartGroup.changed(j6)) {
                            i9 = 2048;
                            i7 |= i9;
                        }
                    } else {
                        j6 = j5;
                    }
                    i9 = 1024;
                    i7 |= i9;
                } else {
                    j6 = j5;
                }
                if ((i7 & 1171) != 1170 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                        }
                        modifier3 = modifier2;
                    } else {
                        modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i6 & 8) != 0) {
                            i7 &= -7169;
                            value = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-126890956, i7, -1, "androidx.compose.material3.Icon (Icon.kt:70)");
                            }
                            m857Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, startRestartGroup, i7 & 14), str, modifier3, value, startRestartGroup, VectorPainter.$stable | (i7 & 112) | (i7 & 896) | (i7 & 7168), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier4 = modifier3;
                            j6 = value;
                        }
                    }
                    value = j6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    m857Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, startRestartGroup, i7 & 14), str, modifier3, value, startRestartGroup, VectorPainter.$stable | (i7 & 112) | (i7 & 896) | (i7 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    j6 = value;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final long j7 = j6;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$1
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

                        public final void invoke(Composer composer2, int i10) {
                            IconKt.m858Iconww6aTOc(ImageVector.this, str, modifier4, j7, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                        }
                    });
                    return;
                }
                return;
            }
            modifier2 = modifier;
            if ((i5 & 3072) == 0) {
            }
            if ((i7 & 1171) != 1170) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0) {
            }
            if (i8 != 0) {
            }
            if ((i6 & 8) != 0) {
            }
            value = j6;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            m857Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, startRestartGroup, i7 & 14), str, modifier3, value, startRestartGroup, VectorPainter.$stable | (i7 & 112) | (i7 & 896) | (i7 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            j6 = value;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        modifier2 = modifier;
        if ((i5 & 3072) == 0) {
        }
        if ((i7 & 1171) != 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) == 0) {
        }
        if (i8 != 0) {
        }
        if ((i6 & 8) != 0) {
        }
        value = j6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m857Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, startRestartGroup, i7 & 14), str, modifier3, value, startRestartGroup, VectorPainter.$stable | (i7 & 112) | (i7 & 896) | (i7 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        j6 = value;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        return modifier.then((Size.m1374equalsimpl0(painter.mo1744getIntrinsicSizeNHjbRc(), Size.INSTANCE.m1383getUnspecifiedNHjbRc()) || m859isInfiniteuvyYCjk(painter.mo1744getIntrinsicSizeNHjbRc())) ? DefaultIconSizeModifier : Modifier.INSTANCE);
    }

    /* renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m859isInfiniteuvyYCjk(long j5) {
        return Float.isInfinite(Size.m1377getWidthimpl(j5)) && Float.isInfinite(Size.m1375getHeightimpl(j5));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0071  */
    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m857Iconww6aTOc(final Painter painter, final String str, Modifier modifier, long j5, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        long j6;
        Modifier modifier3;
        boolean z5;
        Object rememberedValue;
        Modifier modifier4;
        final Modifier modifier5;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-2142239481);
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
        int i8 = i6 & 4;
        if (i8 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i5 & 3072) != 0) {
                j6 = j5;
                i7 |= ((i6 & 8) == 0 && startRestartGroup.changed(j6)) ? 2048 : 1024;
            } else {
                j6 = j5;
            }
            if ((i7 & 1171) != 1170 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                modifier5 = modifier2;
                j7 = j6;
            } else {
                startRestartGroup.startDefaults();
                if ((i5 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i6 & 8) != 0) {
                        i7 &= -7169;
                    }
                    modifier3 = modifier2;
                } else {
                    Modifier modifier6 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i6 & 8) == 0) {
                        i7 &= -7169;
                        modifier3 = modifier6;
                        j6 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                    } else {
                        modifier3 = modifier6;
                    }
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2142239481, i7, -1, "androidx.compose.material3.Icon (Icon.kt:143)");
                }
                z5 = (((i7 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j6)) || (i7 & 3072) == 2048;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = !Color.m1487equalsimpl0(j6, Color.INSTANCE.m1501getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, j6, 0, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ColorFilter colorFilter = (ColorFilter) rememberedValue;
                startRestartGroup.startReplaceGroup(-2144891392);
                if (str == null) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    boolean z6 = (i7 & 112) == 32;
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$semantics$1$1
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
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    modifier4 = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue2, 1, null);
                } else {
                    modifier4 = Modifier.INSTANCE;
                }
                Modifier modifier7 = modifier4;
                startRestartGroup.endReplaceGroup();
                long j8 = j6;
                BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier3), painter), painter, false, null, ContentScale.INSTANCE.getFit(), 0.0f, colorFilter, 22, null).then(modifier7), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier3;
                j7 = j8;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$3
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

                    public final void invoke(Composer composer2, int i9) {
                        IconKt.m857Iconww6aTOc(Painter.this, str, modifier5, j7, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i5 & 3072) != 0) {
        }
        if ((i7 & 1171) != 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) == 0) {
        }
        if (i8 == 0) {
        }
        if ((i6 & 8) == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (((i7 & 7168) ^ 3072) <= 2048) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        if (!Color.m1487equalsimpl0(j6, Color.INSTANCE.m1501getUnspecified0d7_KjU())) {
        }
        startRestartGroup.updateRememberedValue(rememberedValue);
        ColorFilter colorFilter2 = (ColorFilter) rememberedValue;
        startRestartGroup.startReplaceGroup(-2144891392);
        if (str == null) {
        }
        Modifier modifier72 = modifier4;
        startRestartGroup.endReplaceGroup();
        long j82 = j6;
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier3), painter), painter, false, null, ContentScale.INSTANCE.getFit(), 0.0f, colorFilter2, 22, null).then(modifier72), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier5 = modifier3;
        j7 = j82;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
