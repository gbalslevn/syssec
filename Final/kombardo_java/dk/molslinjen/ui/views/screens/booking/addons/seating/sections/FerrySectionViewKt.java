package dk.molslinjen.ui.views.screens.booking.addons.seating.sections;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.addons.seating.sections.FerrySectionViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Point;
import uniffi.molslinjen_shared.Size;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aC\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/Point;", "sectionCoordinates", "Luniffi/molslinjen_shared/Size;", "sectionSize", "Landroidx/compose/ui/graphics/Color;", "fillColor", "borderColor", BuildConfig.FLAVOR, "FerrySectionView-jA1GFJw", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Luniffi/molslinjen_shared/Size;JJLandroidx/compose/runtime/Composer;II)V", "FerrySectionView", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerrySectionViewKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0089  */
    /* renamed from: FerrySectionView-jA1GFJw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3443FerrySectionViewjA1GFJw(Modifier modifier, final List<Point> sectionCoordinates, final Size sectionSize, long j5, long j6, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        long j7;
        int i8;
        long j8;
        Modifier modifier3;
        long m3269getGrey60d7_KjU;
        long m3267getGrey40d7_KjU;
        final Path Path;
        boolean changedInstance;
        Object rememberedValue;
        boolean changedInstance2;
        Object rememberedValue2;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(sectionCoordinates, "sectionCoordinates");
        Intrinsics.checkNotNullParameter(sectionSize, "sectionSize");
        Composer startRestartGroup = composer.startRestartGroup(592816304);
        int i9 = i6 & 1;
        if (i9 != 0) {
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
            i7 |= startRestartGroup.changedInstance(sectionCoordinates) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(sectionSize) ? 256 : 128;
        }
        int i10 = i6 & 8;
        if (i10 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            j7 = j5;
            i7 |= startRestartGroup.changed(j7) ? 2048 : 1024;
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                j8 = j6;
                i7 |= startRestartGroup.changed(j8) ? 16384 : 8192;
                if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                    m3269getGrey60d7_KjU = i10 != 0 ? AppColor.INSTANCE.m3269getGrey60d7_KjU() : j7;
                    m3267getGrey40d7_KjU = i8 != 0 ? AppColor.INSTANCE.m3267getGrey40d7_KjU() : j8;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(592816304, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.sections.FerrySectionView (FerrySectionView.kt:28)");
                    }
                    Path = AndroidPath_androidKt.Path();
                    int i11 = 0;
                    for (Object obj : sectionCoordinates) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        Point point = (Point) obj;
                        if (i11 == 0) {
                            Path.moveTo((float) point.getX(), (float) point.getY());
                        } else {
                            Path.lineTo((float) point.getX(), (float) point.getY());
                            if (i11 == CollectionsKt.getLastIndex(sectionCoordinates)) {
                                Path.close();
                            }
                        }
                        i11 = i12;
                    }
                    Modifier m333sizeVpY3zN4 = SizeKt.m333sizeVpY3zN4(Modifier.INSTANCE, ComposeExtensionsKt.pxToDp((int) sectionSize.getWidth(), startRestartGroup, 0), ComposeExtensionsKt.pxToDp((int) sectionSize.getHeight(), startRestartGroup, 0));
                    startRestartGroup.startReplaceGroup(1718927995);
                    changedInstance = startRestartGroup.changedInstance(Path);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function3() { // from class: H2.a
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                Unit FerrySectionView_jA1GFJw$lambda$3$lambda$2;
                                FerrySectionView_jA1GFJw$lambda$3$lambda$2 = FerrySectionViewKt.FerrySectionView_jA1GFJw$lambda$3$lambda$2(Path.this, (Path) obj2, (androidx.compose.ui.geometry.Size) obj3, (LayoutDirection) obj4);
                                return FerrySectionView_jA1GFJw$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier then = ClipKt.clip(m333sizeVpY3zN4, new GenericShape((Function3) rememberedValue)).then(modifier3);
                    startRestartGroup.startReplaceGroup(1718931737);
                    changedInstance2 = startRestartGroup.changedInstance(Path) | ((i7 & 7168) == 2048) | ((57344 & i7) == 16384);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final long j10 = m3269getGrey60d7_KjU;
                        final long j11 = m3267getGrey40d7_KjU;
                        rememberedValue2 = new Function1() { // from class: H2.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                Unit FerrySectionView_jA1GFJw$lambda$5$lambda$4;
                                FerrySectionView_jA1GFJw$lambda$5$lambda$4 = FerrySectionViewKt.FerrySectionView_jA1GFJw$lambda$5$lambda$4(Path.this, j10, j11, (DrawScope) obj2);
                                return FerrySectionView_jA1GFJw$lambda$5$lambda$4;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    CanvasKt.Canvas(then, (Function1) rememberedValue2, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j9 = m3267getGrey40d7_KjU;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    m3269getGrey60d7_KjU = j7;
                    j9 = j8;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final long j12 = m3269getGrey60d7_KjU;
                    endRestartGroup.updateScope(new Function2() { // from class: H2.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit FerrySectionView_jA1GFJw$lambda$6;
                            FerrySectionView_jA1GFJw$lambda$6 = FerrySectionViewKt.FerrySectionView_jA1GFJw$lambda$6(Modifier.this, sectionCoordinates, sectionSize, j12, j9, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                            return FerrySectionView_jA1GFJw$lambda$6;
                        }
                    });
                    return;
                }
                return;
            }
            j8 = j6;
            if ((i7 & 9363) == 9362) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Path = AndroidPath_androidKt.Path();
            int i112 = 0;
            while (r5.hasNext()) {
            }
            Modifier m333sizeVpY3zN42 = SizeKt.m333sizeVpY3zN4(Modifier.INSTANCE, ComposeExtensionsKt.pxToDp((int) sectionSize.getWidth(), startRestartGroup, 0), ComposeExtensionsKt.pxToDp((int) sectionSize.getHeight(), startRestartGroup, 0));
            startRestartGroup.startReplaceGroup(1718927995);
            changedInstance = startRestartGroup.changedInstance(Path);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue = new Function3() { // from class: H2.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit FerrySectionView_jA1GFJw$lambda$3$lambda$2;
                    FerrySectionView_jA1GFJw$lambda$3$lambda$2 = FerrySectionViewKt.FerrySectionView_jA1GFJw$lambda$3$lambda$2(Path.this, (Path) obj2, (androidx.compose.ui.geometry.Size) obj3, (LayoutDirection) obj4);
                    return FerrySectionView_jA1GFJw$lambda$3$lambda$2;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            Modifier then2 = ClipKt.clip(m333sizeVpY3zN42, new GenericShape((Function3) rememberedValue)).then(modifier3);
            startRestartGroup.startReplaceGroup(1718931737);
            changedInstance2 = startRestartGroup.changedInstance(Path) | ((i7 & 7168) == 2048) | ((57344 & i7) == 16384);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
            }
            final long j102 = m3269getGrey60d7_KjU;
            final long j112 = m3267getGrey40d7_KjU;
            rememberedValue2 = new Function1() { // from class: H2.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit FerrySectionView_jA1GFJw$lambda$5$lambda$4;
                    FerrySectionView_jA1GFJw$lambda$5$lambda$4 = FerrySectionViewKt.FerrySectionView_jA1GFJw$lambda$5$lambda$4(Path.this, j102, j112, (DrawScope) obj2);
                    return FerrySectionView_jA1GFJw$lambda$5$lambda$4;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            CanvasKt.Canvas(then2, (Function1) rememberedValue2, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j9 = m3267getGrey40d7_KjU;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        j7 = j5;
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        j8 = j6;
        if ((i7 & 9363) == 9362) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Path = AndroidPath_androidKt.Path();
        int i1122 = 0;
        while (r5.hasNext()) {
        }
        Modifier m333sizeVpY3zN422 = SizeKt.m333sizeVpY3zN4(Modifier.INSTANCE, ComposeExtensionsKt.pxToDp((int) sectionSize.getWidth(), startRestartGroup, 0), ComposeExtensionsKt.pxToDp((int) sectionSize.getHeight(), startRestartGroup, 0));
        startRestartGroup.startReplaceGroup(1718927995);
        changedInstance = startRestartGroup.changedInstance(Path);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function3() { // from class: H2.a
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                Unit FerrySectionView_jA1GFJw$lambda$3$lambda$2;
                FerrySectionView_jA1GFJw$lambda$3$lambda$2 = FerrySectionViewKt.FerrySectionView_jA1GFJw$lambda$3$lambda$2(Path.this, (Path) obj2, (androidx.compose.ui.geometry.Size) obj3, (LayoutDirection) obj4);
                return FerrySectionView_jA1GFJw$lambda$3$lambda$2;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier then22 = ClipKt.clip(m333sizeVpY3zN422, new GenericShape((Function3) rememberedValue)).then(modifier3);
        startRestartGroup.startReplaceGroup(1718931737);
        changedInstance2 = startRestartGroup.changedInstance(Path) | ((i7 & 7168) == 2048) | ((57344 & i7) == 16384);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        final long j1022 = m3269getGrey60d7_KjU;
        final long j1122 = m3267getGrey40d7_KjU;
        rememberedValue2 = new Function1() { // from class: H2.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit FerrySectionView_jA1GFJw$lambda$5$lambda$4;
                FerrySectionView_jA1GFJw$lambda$5$lambda$4 = FerrySectionViewKt.FerrySectionView_jA1GFJw$lambda$5$lambda$4(Path.this, j1022, j1122, (DrawScope) obj2);
                return FerrySectionView_jA1GFJw$lambda$5$lambda$4;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        CanvasKt.Canvas(then22, (Function1) rememberedValue2, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j9 = m3267getGrey40d7_KjU;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySectionView_jA1GFJw$lambda$3$lambda$2(Path path, Path GenericShape, androidx.compose.ui.geometry.Size size, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(GenericShape, "$this$GenericShape");
        Intrinsics.checkNotNullParameter(layoutDirection, "<unused var>");
        Path.m1574addPathUv8p0NA$default(GenericShape, path, 0L, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySectionView_jA1GFJw$lambda$5$lambda$4(Path path, long j5, long j6, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        DrawScope.m1695drawPathGBMwjPU$default(Canvas, path, new SolidColor(j5, null), 0.0f, Fill.INSTANCE, null, 0, 52, null);
        DrawScope.m1695drawPathGBMwjPU$default(Canvas, path, new SolidColor(j6, null), 0.0f, new Stroke(Canvas.mo212toPx0680j_4(Dp.m2599constructorimpl(3)), 0.0f, StrokeCap.INSTANCE.m1608getRoundKaPHkGw(), 0, null, 26, null), null, 0, 52, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySectionView_jA1GFJw$lambda$6(Modifier modifier, List list, Size size, long j5, long j6, int i5, int i6, Composer composer, int i7) {
        m3443FerrySectionViewjA1GFJw(modifier, list, size, j5, j6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
