package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryBackgroundViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a3\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "headerHeightPx", "bottomHeightPx", "Landroidx/compose/ui/graphics/Color;", "color", BuildConfig.FLAVOR, "TicketSummaryBackgroundView-ww6aTOc", "(Landroidx/compose/ui/Modifier;IIJLandroidx/compose/runtime/Composer;II)V", "TicketSummaryBackgroundView", "TicketBackgroundSingleCutOutView-FNF3uiM", "(Landroidx/compose/ui/Modifier;IJLandroidx/compose/runtime/Composer;II)V", "TicketBackgroundSingleCutOutView", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketSummaryBackgroundViewKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0050  */
    /* renamed from: TicketBackgroundSingleCutOutView-FNF3uiM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3562TicketBackgroundSingleCutOutViewFNF3uiM(Modifier modifier, final int i5, long j5, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        int i9;
        long j6;
        Modifier modifier3;
        boolean changed;
        Object rememberedValue;
        int i10;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(239994826);
        int i11 = i7 & 1;
        if (i11 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                j6 = j5;
                i8 |= startRestartGroup.changed(j6) ? 256 : 128;
                if ((i8 & 147) == 146 || !startRestartGroup.getSkipping()) {
                    modifier3 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i9 != 0) {
                        j6 = AppColor.INSTANCE.m3281getWhite0d7_KjU();
                    }
                    final long j8 = j6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(239994826, i8, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketBackgroundSingleCutOutView (TicketSummaryBackgroundView.kt:61)");
                    }
                    float f5 = 8;
                    final long CornerRadius = CornerRadiusKt.CornerRadius(ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f5), startRestartGroup, 6), ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f5), startRestartGroup, 6));
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
                    startRestartGroup.startReplaceGroup(1157118347);
                    changed = ((i8 & 112) == 32) | startRestartGroup.changed(CornerRadius) | ((i8 & 896) == 256);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        i10 = 0;
                        rememberedValue = new Function1() { // from class: C4.x
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9;
                                TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9 = TicketSummaryBackgroundViewKt.TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9(i5, j8, CornerRadius, (DrawScope) obj);
                                return TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    } else {
                        i10 = 0;
                    }
                    startRestartGroup.endReplaceGroup();
                    CanvasKt.Canvas(fillMaxWidth$default, (Function1) rememberedValue, startRestartGroup, i10);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j7 = j8;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    j7 = j6;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: C4.y
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TicketBackgroundSingleCutOutView_FNF3uiM$lambda$11;
                            TicketBackgroundSingleCutOutView_FNF3uiM$lambda$11 = TicketSummaryBackgroundViewKt.TicketBackgroundSingleCutOutView_FNF3uiM$lambda$11(Modifier.this, i5, j7, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                            return TicketBackgroundSingleCutOutView_FNF3uiM$lambda$11;
                        }
                    });
                    return;
                }
                return;
            }
            j6 = j5;
            if ((i8 & 147) == 146) {
            }
            if (i11 != 0) {
            }
            if (i9 != 0) {
            }
            final long j82 = j6;
            if (ComposerKt.isTraceInProgress()) {
            }
            float f52 = 8;
            final long CornerRadius2 = CornerRadiusKt.CornerRadius(ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f52), startRestartGroup, 6), ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f52), startRestartGroup, 6));
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(1157118347);
            changed = ((i8 & 112) == 32) | startRestartGroup.changed(CornerRadius2) | ((i8 & 896) == 256);
            rememberedValue = startRestartGroup.rememberedValue();
            if (changed) {
            }
            i10 = 0;
            rememberedValue = new Function1() { // from class: C4.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9;
                    TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9 = TicketSummaryBackgroundViewKt.TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9(i5, j82, CornerRadius2, (DrawScope) obj);
                    return TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            CanvasKt.Canvas(fillMaxWidth$default2, (Function1) rememberedValue, startRestartGroup, i10);
            if (ComposerKt.isTraceInProgress()) {
            }
            j7 = j82;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        j6 = j5;
        if ((i8 & 147) == 146) {
        }
        if (i11 != 0) {
        }
        if (i9 != 0) {
        }
        final long j822 = j6;
        if (ComposerKt.isTraceInProgress()) {
        }
        float f522 = 8;
        final long CornerRadius22 = CornerRadiusKt.CornerRadius(ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f522), startRestartGroup, 6), ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f522), startRestartGroup, 6));
        Modifier fillMaxWidth$default22 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
        startRestartGroup.startReplaceGroup(1157118347);
        changed = ((i8 & 112) == 32) | startRestartGroup.changed(CornerRadius22) | ((i8 & 896) == 256);
        rememberedValue = startRestartGroup.rememberedValue();
        if (changed) {
        }
        i10 = 0;
        rememberedValue = new Function1() { // from class: C4.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9;
                TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9 = TicketSummaryBackgroundViewKt.TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9(i5, j822, CornerRadius22, (DrawScope) obj);
                return TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        CanvasKt.Canvas(fillMaxWidth$default22, (Function1) rememberedValue, startRestartGroup, i10);
        if (ComposerKt.isTraceInProgress()) {
        }
        j7 = j822;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketBackgroundSingleCutOutView_FNF3uiM$lambda$10$lambda$9(int i5, long j5, long j6, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        long mo1703getSizeNHjbRc = Canvas.mo1703getSizeNHjbRc();
        float mo212toPx0680j_4 = Canvas.mo212toPx0680j_4(Dp.m2599constructorimpl(6));
        Path Path = AndroidPath_androidKt.Path();
        float f5 = i5;
        Path.addOval$default(Path, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(0.0f, f5), mo212toPx0680j_4), null, 2, null);
        Path.addOval$default(Path, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(Size.m1377getWidthimpl(mo1703getSizeNHjbRc), f5), mo212toPx0680j_4), null, 2, null);
        int m1479getDifferencertfAjoo = ClipOp.INSTANCE.m1479getDifferencertfAjoo();
        DrawContext drawContext = Canvas.getDrawContext();
        long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo1684clipPathmtrdDE(Path, m1479getDifferencertfAjoo);
            Path Path2 = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path2, RoundRectKt.m1367RoundRectZAM2FJo(RectKt.m1362Recttz77jQw(OffsetKt.Offset(0.0f, 0.0f), mo1703getSizeNHjbRc), j6, j6, j6, j6), null, 2, null);
            DrawScope.m1696drawPathLG529CI$default(Canvas, Path2, j5, 0.0f, null, null, 0, 60, null);
            drawContext.getCanvas().restore();
            drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketBackgroundSingleCutOutView_FNF3uiM$lambda$11(Modifier modifier, int i5, long j5, int i6, int i7, Composer composer, int i8) {
        m3562TicketBackgroundSingleCutOutViewFNF3uiM(modifier, i5, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0050  */
    /* renamed from: TicketSummaryBackgroundView-ww6aTOc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3563TicketSummaryBackgroundViewww6aTOc(Modifier modifier, final int i5, final int i6, long j5, Composer composer, final int i7, final int i8) {
        Modifier modifier2;
        int i9;
        int i10;
        long j6;
        Modifier modifier3;
        boolean changed;
        Object rememberedValue;
        int i11;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-718494385);
        int i12 = i8 & 1;
        if (i12 != 0) {
            i9 = i7 | 6;
            modifier2 = modifier;
        } else if ((i7 & 6) == 0) {
            modifier2 = modifier;
            i9 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i7;
        } else {
            modifier2 = modifier;
            i9 = i7;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i7 & 48) == 0) {
            i9 |= startRestartGroup.changed(i5) ? 32 : 16;
            if ((i8 & 4) == 0) {
                i9 |= 384;
            } else if ((i7 & 384) == 0) {
                i9 |= startRestartGroup.changed(i6) ? 256 : 128;
            }
            i10 = i8 & 8;
            if (i10 == 0) {
                i9 |= 3072;
            } else if ((i7 & 3072) == 0) {
                j6 = j5;
                i9 |= startRestartGroup.changed(j6) ? 2048 : 1024;
                if ((i9 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    modifier3 = i12 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i10 != 0) {
                        j6 = AppColor.INSTANCE.m3281getWhite0d7_KjU();
                    }
                    final long j7 = j6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-718494385, i9, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryBackgroundView (TicketSummaryBackgroundView.kt:25)");
                    }
                    float f5 = 8;
                    final long CornerRadius = CornerRadiusKt.CornerRadius(ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f5), startRestartGroup, 6), ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f5), startRestartGroup, 6));
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
                    startRestartGroup.startReplaceGroup(-458245824);
                    changed = ((i9 & 112) == 32) | ((i9 & 896) == 256) | startRestartGroup.changed(CornerRadius) | ((i9 & 7168) == 2048);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        i11 = 0;
                        rememberedValue = new Function1() { // from class: C4.v
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3;
                                TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3 = TicketSummaryBackgroundViewKt.TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3(i5, i6, j7, CornerRadius, (DrawScope) obj);
                                return TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    } else {
                        i11 = 0;
                    }
                    startRestartGroup.endReplaceGroup();
                    CanvasKt.Canvas(fillMaxWidth$default, (Function1) rememberedValue, startRestartGroup, i11);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j6 = j7;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final long j8 = j6;
                    endRestartGroup.updateScope(new Function2() { // from class: C4.w
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TicketSummaryBackgroundView_ww6aTOc$lambda$5;
                            TicketSummaryBackgroundView_ww6aTOc$lambda$5 = TicketSummaryBackgroundViewKt.TicketSummaryBackgroundView_ww6aTOc$lambda$5(Modifier.this, i5, i6, j8, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                            return TicketSummaryBackgroundView_ww6aTOc$lambda$5;
                        }
                    });
                    return;
                }
                return;
            }
            j6 = j5;
            if ((i9 & 1171) == 1170) {
            }
            if (i12 != 0) {
            }
            if (i10 != 0) {
            }
            final long j72 = j6;
            if (ComposerKt.isTraceInProgress()) {
            }
            float f52 = 8;
            final long CornerRadius2 = CornerRadiusKt.CornerRadius(ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f52), startRestartGroup, 6), ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f52), startRestartGroup, 6));
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-458245824);
            changed = ((i9 & 112) == 32) | ((i9 & 896) == 256) | startRestartGroup.changed(CornerRadius2) | ((i9 & 7168) == 2048);
            rememberedValue = startRestartGroup.rememberedValue();
            if (changed) {
            }
            i11 = 0;
            rememberedValue = new Function1() { // from class: C4.v
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3;
                    TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3 = TicketSummaryBackgroundViewKt.TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3(i5, i6, j72, CornerRadius2, (DrawScope) obj);
                    return TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            CanvasKt.Canvas(fillMaxWidth$default2, (Function1) rememberedValue, startRestartGroup, i11);
            if (ComposerKt.isTraceInProgress()) {
            }
            j6 = j72;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i8 & 4) == 0) {
        }
        i10 = i8 & 8;
        if (i10 == 0) {
        }
        j6 = j5;
        if ((i9 & 1171) == 1170) {
        }
        if (i12 != 0) {
        }
        if (i10 != 0) {
        }
        final long j722 = j6;
        if (ComposerKt.isTraceInProgress()) {
        }
        float f522 = 8;
        final long CornerRadius22 = CornerRadiusKt.CornerRadius(ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f522), startRestartGroup, 6), ComposeExtensionsKt.m3250dpToPx8Feqmps(Dp.m2599constructorimpl(f522), startRestartGroup, 6));
        Modifier fillMaxWidth$default22 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
        startRestartGroup.startReplaceGroup(-458245824);
        changed = ((i9 & 112) == 32) | ((i9 & 896) == 256) | startRestartGroup.changed(CornerRadius22) | ((i9 & 7168) == 2048);
        rememberedValue = startRestartGroup.rememberedValue();
        if (changed) {
        }
        i11 = 0;
        rememberedValue = new Function1() { // from class: C4.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3;
                TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3 = TicketSummaryBackgroundViewKt.TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3(i5, i6, j722, CornerRadius22, (DrawScope) obj);
                return TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        CanvasKt.Canvas(fillMaxWidth$default22, (Function1) rememberedValue, startRestartGroup, i11);
        if (ComposerKt.isTraceInProgress()) {
        }
        j6 = j722;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryBackgroundView_ww6aTOc$lambda$4$lambda$3(int i5, int i6, long j5, long j6, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        long mo1703getSizeNHjbRc = Canvas.mo1703getSizeNHjbRc();
        float mo212toPx0680j_4 = Canvas.mo212toPx0680j_4(Dp.m2599constructorimpl(6));
        Path Path = AndroidPath_androidKt.Path();
        float f5 = i5;
        float m1375getHeightimpl = Size.m1375getHeightimpl(mo1703getSizeNHjbRc) - i6;
        Path.addOval$default(Path, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(0.0f, f5), mo212toPx0680j_4), null, 2, null);
        Path.addOval$default(Path, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(Size.m1377getWidthimpl(mo1703getSizeNHjbRc), f5), mo212toPx0680j_4), null, 2, null);
        Path.addOval$default(Path, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(0.0f, m1375getHeightimpl), mo212toPx0680j_4), null, 2, null);
        Path.addOval$default(Path, RectKt.m1361Rect3MmeM6k(OffsetKt.Offset(Size.m1377getWidthimpl(mo1703getSizeNHjbRc), m1375getHeightimpl), mo212toPx0680j_4), null, 2, null);
        int m1479getDifferencertfAjoo = ClipOp.INSTANCE.m1479getDifferencertfAjoo();
        DrawContext drawContext = Canvas.getDrawContext();
        long mo1682getSizeNHjbRc = drawContext.mo1682getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo1684clipPathmtrdDE(Path, m1479getDifferencertfAjoo);
            Path Path2 = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path2, RoundRectKt.m1367RoundRectZAM2FJo(RectKt.m1362Recttz77jQw(OffsetKt.Offset(0.0f, 0.0f), mo1703getSizeNHjbRc), j6, j6, j6, j6), null, 2, null);
            DrawScope.m1696drawPathLG529CI$default(Canvas, Path2, j5, 0.0f, null, null, 0, 60, null);
            drawContext.getCanvas().restore();
            drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryBackgroundView_ww6aTOc$lambda$5(Modifier modifier, int i5, int i6, long j5, int i7, int i8, Composer composer, int i9) {
        m3563TicketSummaryBackgroundViewww6aTOc(modifier, i5, i6, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), i8);
        return Unit.INSTANCE;
    }
}
