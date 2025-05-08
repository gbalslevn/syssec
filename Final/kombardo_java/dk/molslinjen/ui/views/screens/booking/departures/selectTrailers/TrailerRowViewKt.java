package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.booking.product.presentation.ImageProductPresentation;
import dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.DoubleExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerRowViewKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\u001am\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001aI\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\fH\u0003¢\u0006\u0004\b\u0013\u0010\u0014\u001aE\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\tH\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0017\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "trailer", BuildConfig.FLAVOR, "outboundIsSelected", "returnIsSelected", "preventOutboundSelection", "lockOutbound", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Lkotlin/Function1;", BuildConfig.FLAVOR, "trailerSelected", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "onChangedForDirection", "TrailerRowView", "(Ldk/molslinjen/domain/model/booking/product/TrailerProduct;ZZZZLdk/molslinjen/domain/model/booking/BookingType;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "price", "ReturnDepartureSelection", "(Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "isSelected", "enabled", "onCheckChange", "DirectionSelectionRow", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "max", "formatMaxSpecification", "(D)Ljava/lang/String;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TrailerRowViewKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void DirectionSelectionRow(final String str, final PriceWithCurrency priceWithCurrency, final boolean z5, boolean z6, final Function1<? super Boolean, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        boolean z7;
        boolean z8;
        Object rememberedValue;
        Composer composer2;
        final boolean z9;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-478799134);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(priceWithCurrency) ? 32 : 16;
        }
        try {
            try {
                if ((i6 & 4) != 0) {
                    i7 |= 384;
                } else if ((i5 & 384) == 0) {
                    i7 |= startRestartGroup.changed(z5) ? 256 : 128;
                    i8 = i6 & 8;
                    if (i8 == 0) {
                        i7 |= 3072;
                    } else if ((i5 & 3072) == 0) {
                        z7 = z6;
                        i7 |= startRestartGroup.changed(z7) ? 2048 : 1024;
                        if ((i6 & 16) != 0) {
                            i7 |= 24576;
                        } else if ((i5 & 24576) == 0) {
                            i7 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
                        }
                        if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                            boolean z10 = i8 != 0 ? true : z7;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-478799134, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.DirectionSelectionRow (TrailerRowView.kt:200)");
                            }
                            startRestartGroup.startReplaceGroup(963457418);
                            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                            builder.append(str + "   ");
                            int pushStyle = builder.pushStyle(new SpanStyle(0L, TypographyKt.getParagraphSmallBold().m2299getFontSizeXSAIIZE(), TypographyKt.getParagraphSmallBold().getFontWeight(), null, null, TypographyKt.getParagraphSmallBold().getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65497, null));
                            builder.append(PriceWithCurrency.formattedValue$default(priceWithCurrency, false, 1, null) + " ");
                            Unit unit = Unit.INSTANCE;
                            builder.pop(pushStyle);
                            startRestartGroup.startReplaceGroup(963468851);
                            pushStyle = builder.pushStyle(new SpanStyle(0L, TypographyKt.getSubSmall().m2299getFontSizeXSAIIZE(), TypographyKt.getSubSmall().getFontWeight(), null, null, TypographyKt.getSubSmall().getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65497, null));
                            builder.append(PriceFormatExtensionsKt.getCurrencyFormatted(priceWithCurrency, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                            builder.pop(pushStyle);
                            startRestartGroup.endReplaceGroup();
                            AnnotatedString annotatedString = builder.toAnnotatedString();
                            startRestartGroup.endReplaceGroup();
                            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
                            SelectionControlStyle selectionControlStyle = SelectionControlStyle.Checkbox;
                            startRestartGroup.startReplaceGroup(963484427);
                            z8 = (57344 & i7) == 16384;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function1() { // from class: Q2.h
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit DirectionSelectionRow$lambda$24$lambda$23;
                                        DirectionSelectionRow$lambda$24$lambda$23 = TrailerRowViewKt.DirectionSelectionRow$lambda$24$lambda$23(Function1.this, ((Boolean) obj).booleanValue());
                                        return DirectionSelectionRow$lambda$24$lambda$23;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            composer2 = startRestartGroup;
                            LabeledSelectionControlKt.LabeledSelectionControl(null, m315paddingqDBjuR0$default, annotatedString, z5, (Function1) rememberedValue, null, z10, null, selectionControlStyle, false, composer2, ((i7 << 3) & 7168) | 100663344 | ((i7 << 9) & 3670016), 673);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z9 = z10;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z9 = z7;
                            composer2 = startRestartGroup;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: Q2.i
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit DirectionSelectionRow$lambda$25;
                                    DirectionSelectionRow$lambda$25 = TrailerRowViewKt.DirectionSelectionRow$lambda$25(str, priceWithCurrency, z5, z9, function1, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return DirectionSelectionRow$lambda$25;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z7 = z6;
                    if ((i6 & 16) != 0) {
                    }
                    if ((i7 & 9363) == 9362) {
                    }
                    if (i8 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(963457418);
                    AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, null);
                    builder2.append(str + "   ");
                    int pushStyle2 = builder2.pushStyle(new SpanStyle(0L, TypographyKt.getParagraphSmallBold().m2299getFontSizeXSAIIZE(), TypographyKt.getParagraphSmallBold().getFontWeight(), null, null, TypographyKt.getParagraphSmallBold().getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65497, null));
                    builder2.append(PriceWithCurrency.formattedValue$default(priceWithCurrency, false, 1, null) + " ");
                    Unit unit2 = Unit.INSTANCE;
                    builder2.pop(pushStyle2);
                    startRestartGroup.startReplaceGroup(963468851);
                    pushStyle2 = builder2.pushStyle(new SpanStyle(0L, TypographyKt.getSubSmall().m2299getFontSizeXSAIIZE(), TypographyKt.getSubSmall().getFontWeight(), null, null, TypographyKt.getSubSmall().getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65497, null));
                    builder2.append(PriceFormatExtensionsKt.getCurrencyFormatted(priceWithCurrency, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                    builder2.pop(pushStyle2);
                    startRestartGroup.endReplaceGroup();
                    AnnotatedString annotatedString2 = builder2.toAnnotatedString();
                    startRestartGroup.endReplaceGroup();
                    Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
                    SelectionControlStyle selectionControlStyle2 = SelectionControlStyle.Checkbox;
                    startRestartGroup.startReplaceGroup(963484427);
                    if ((57344 & i7) == 16384) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z8) {
                    }
                    rememberedValue = new Function1() { // from class: Q2.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DirectionSelectionRow$lambda$24$lambda$23;
                            DirectionSelectionRow$lambda$24$lambda$23 = TrailerRowViewKt.DirectionSelectionRow$lambda$24$lambda$23(Function1.this, ((Boolean) obj).booleanValue());
                            return DirectionSelectionRow$lambda$24$lambda$23;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                    LabeledSelectionControlKt.LabeledSelectionControl(null, m315paddingqDBjuR0$default2, annotatedString2, z5, (Function1) rememberedValue, null, z10, null, selectionControlStyle2, false, composer2, ((i7 << 3) & 7168) | 100663344 | ((i7 << 9) & 3670016), 673);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z9 = z10;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                builder2.append(PriceFormatExtensionsKt.getCurrencyFormatted(priceWithCurrency, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())));
                builder2.pop(pushStyle2);
                startRestartGroup.endReplaceGroup();
                AnnotatedString annotatedString22 = builder2.toAnnotatedString();
                startRestartGroup.endReplaceGroup();
                Modifier m315paddingqDBjuR0$default22 = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
                SelectionControlStyle selectionControlStyle22 = SelectionControlStyle.Checkbox;
                startRestartGroup.startReplaceGroup(963484427);
                if ((57344 & i7) == 16384) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z8) {
                }
                rememberedValue = new Function1() { // from class: Q2.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DirectionSelectionRow$lambda$24$lambda$23;
                        DirectionSelectionRow$lambda$24$lambda$23 = TrailerRowViewKt.DirectionSelectionRow$lambda$24$lambda$23(Function1.this, ((Boolean) obj).booleanValue());
                        return DirectionSelectionRow$lambda$24$lambda$23;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                LabeledSelectionControlKt.LabeledSelectionControl(null, m315paddingqDBjuR0$default22, annotatedString22, z5, (Function1) rememberedValue, null, z10, null, selectionControlStyle22, false, composer2, ((i7 << 3) & 7168) | 100663344 | ((i7 << 9) & 3670016), 673);
                if (ComposerKt.isTraceInProgress()) {
                }
                z9 = z10;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            } finally {
            }
            builder2.append(PriceWithCurrency.formattedValue$default(priceWithCurrency, false, 1, null) + " ");
            Unit unit22 = Unit.INSTANCE;
            builder2.pop(pushStyle2);
            startRestartGroup.startReplaceGroup(963468851);
            pushStyle2 = builder2.pushStyle(new SpanStyle(0L, TypographyKt.getSubSmall().m2299getFontSizeXSAIIZE(), TypographyKt.getSubSmall().getFontWeight(), null, null, TypographyKt.getSubSmall().getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65497, null));
        } finally {
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z7 = z6;
        if ((i6 & 16) != 0) {
        }
        if ((i7 & 9363) == 9362) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(963457418);
        AnnotatedString.Builder builder22 = new AnnotatedString.Builder(0, 1, null);
        builder22.append(str + "   ");
        int pushStyle22 = builder22.pushStyle(new SpanStyle(0L, TypographyKt.getParagraphSmallBold().m2299getFontSizeXSAIIZE(), TypographyKt.getParagraphSmallBold().getFontWeight(), null, null, TypographyKt.getParagraphSmallBold().getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65497, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DirectionSelectionRow$lambda$24$lambda$23(Function1 function1, boolean z5) {
        function1.invoke(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DirectionSelectionRow$lambda$25(String str, PriceWithCurrency priceWithCurrency, boolean z5, boolean z6, Function1 function1, int i5, int i6, Composer composer, int i7) {
        DirectionSelectionRow(str, priceWithCurrency, z5, z6, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void ReturnDepartureSelection(final PriceWithCurrency priceWithCurrency, final boolean z5, final boolean z6, final boolean z7, final Function2<? super DepartureDirection, ? super Boolean, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1851150661);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(priceWithCurrency) ? 4 : 2) | i5;
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
            i6 |= startRestartGroup.changed(z7) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1851150661, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.ReturnDepartureSelection (TrailerRowView.kt:161)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 24;
            Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(10), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_return_trailerBothDirections, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
            float f6 = 16;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            String stringResource = StringResources_androidKt.stringResource(R.string.departures_return_outbound, startRestartGroup, 6);
            boolean z8 = !z7;
            startRestartGroup.startReplaceGroup(1522307866);
            int i8 = i7 & 57344;
            boolean z9 = i8 == 16384;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: Q2.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ReturnDepartureSelection$lambda$18$lambda$15$lambda$14;
                        ReturnDepartureSelection$lambda$18$lambda$15$lambda$14 = TrailerRowViewKt.ReturnDepartureSelection$lambda$18$lambda$15$lambda$14(Function2.this, ((Boolean) obj).booleanValue());
                        return ReturnDepartureSelection$lambda$18$lambda$15$lambda$14;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i9 = i7 << 3;
            int i10 = i9 & 112;
            DirectionSelectionRow(stringResource, priceWithCurrency, z5, z8, (Function1) rememberedValue, startRestartGroup, i9 & 1008, 0);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.departures_return_return, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1522319128);
            boolean z10 = i8 == 16384;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: Q2.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ReturnDepartureSelection$lambda$18$lambda$17$lambda$16;
                        ReturnDepartureSelection$lambda$18$lambda$17$lambda$16 = TrailerRowViewKt.ReturnDepartureSelection$lambda$18$lambda$17$lambda$16(Function2.this, ((Boolean) obj).booleanValue());
                        return ReturnDepartureSelection$lambda$18$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            DirectionSelectionRow(stringResource2, priceWithCurrency, z6, false, (Function1) rememberedValue2, startRestartGroup, i10 | (i7 & 896), 8);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Q2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReturnDepartureSelection$lambda$19;
                    ReturnDepartureSelection$lambda$19 = TrailerRowViewKt.ReturnDepartureSelection$lambda$19(PriceWithCurrency.this, z5, z6, z7, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ReturnDepartureSelection$lambda$19;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnDepartureSelection$lambda$18$lambda$15$lambda$14(Function2 function2, boolean z5) {
        function2.invoke(DepartureDirection.Outbound, Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnDepartureSelection$lambda$18$lambda$17$lambda$16(Function2 function2, boolean z5) {
        function2.invoke(DepartureDirection.Return, Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReturnDepartureSelection$lambda$19(PriceWithCurrency priceWithCurrency, boolean z5, boolean z6, boolean z7, Function2 function2, int i5, Composer composer, int i6) {
        ReturnDepartureSelection(priceWithCurrency, z5, z6, z7, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TrailerRowView(final TrailerProduct trailer, final boolean z5, final boolean z6, final boolean z7, final boolean z8, final BookingType bookingType, final Function1<? super TrailerProduct, Unit> trailerSelected, final Function2<? super DepartureDirection, ? super Boolean, Unit> onChangedForDirection, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(trailer, "trailer");
        Intrinsics.checkNotNullParameter(bookingType, "bookingType");
        Intrinsics.checkNotNullParameter(trailerSelected, "trailerSelected");
        Intrinsics.checkNotNullParameter(onChangedForDirection, "onChangedForDirection");
        Composer startRestartGroup = composer.startRestartGroup(-1047512423);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(trailer) ? 4 : 2) | i5;
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
            i6 |= startRestartGroup.changed(z7) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z8) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(bookingType) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(trailerSelected) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onChangedForDirection) ? 8388608 : 4194304;
        }
        if ((4793491 & i6) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1047512423, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerRowView (TrailerRowView.kt:48)");
            }
            boolean z9 = z5 || z6;
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, 0.0f, Dp.m2599constructorimpl(16), 1, null);
            boolean z10 = !z8;
            startRestartGroup.startReplaceGroup(-727940123);
            int i7 = 3670016 & i6;
            boolean changedInstance = (i7 == 1048576) | startRestartGroup.changedInstance(trailer);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: Q2.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TrailerRowView$lambda$1$lambda$0;
                        TrailerRowView$lambda$1$lambda$0 = TrailerRowViewKt.TrailerRowView$lambda$1$lambda$0(Function1.this, trailer);
                        return TrailerRowView$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(m313paddingVpY3zN4$default, z10, null, null, (Function0) rememberedValue, 6, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            float f5 = 24;
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
            int i8 = i6;
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            boolean z11 = !z8;
            SelectionControlStyle selectionControlStyle = SelectionControlStyle.RadioButton;
            startRestartGroup.startReplaceGroup(561131299);
            boolean changedInstance2 = (i7 == 1048576) | startRestartGroup.changedInstance(trailer);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: Q2.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TrailerRowView$lambda$12$lambda$7$lambda$3$lambda$2;
                        TrailerRowView$lambda$12$lambda$7$lambda$3$lambda$2 = TrailerRowViewKt.TrailerRowView$lambda$12$lambda$7$lambda$3$lambda$2(Function1.this, trailer, ((Boolean) obj).booleanValue());
                        return TrailerRowView$lambda$12$lambda$7$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, z9, (Function1) rememberedValue2, null, z11, null, selectionControlStyle, false, startRestartGroup, 1572864, 169);
            startRestartGroup.startReplaceGroup(561135785);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            ImageHelper imageHelper = ImageHelper.INSTANCE;
            ProductPresentation presentation = trailer.getPresentation();
            ImageProductPresentation imageProductPresentation = presentation instanceof ImageProductPresentation ? (ImageProductPresentation) presentation : null;
            String m3193buildImageUrlC8IHX40 = imageHelper.m3193buildImageUrlC8IHX40(imageProductPresentation != null ? imageProductPresentation.getImageUrl() : null, null, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, 3456, 2);
            startRestartGroup.startReplaceGroup(561142344);
            if (m3193buildImageUrlC8IHX40 != null && !((Boolean) mutableState.getValue()).booleanValue()) {
                startRestartGroup.startReplaceGroup(561148446);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion4.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: Q2.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit TrailerRowView$lambda$12$lambda$7$lambda$6$lambda$5;
                            TrailerRowView$lambda$12$lambda$7$lambda$6$lambda$5 = TrailerRowViewKt.TrailerRowView$lambda$12$lambda$7$lambda$6$lambda$5(MutableState.this, (AsyncImagePainter.State.Error) obj);
                            return TrailerRowView$lambda$12$lambda$7$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, null, (Function1) rememberedValue4, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(14), 0.0f, 10, null), Dp.m2599constructorimpl(f5)), null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3266getGrey30d7_KjU(), 0, 2, null), startRestartGroup, 1597440, 40);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            Modifier fillMaxHeight$default2 = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, companion, 2.0f, false, 2, null), 0.0f, 1, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion2.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default2);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
            float f6 = 4;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, companion, 2.0f, false, 2, null), 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 11, null);
            String name = trailer.getName();
            TextStyle paragraph = TypographyKt.getParagraph();
            AppColor appColor = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(name, m315paddingqDBjuR0$default, appColor.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraph, startRestartGroup, 384, 1572864, 65528);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor5 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor5);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl5 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl5, rowMeasurePolicy4, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion3.getSetModifier());
            PriceTextKt.m3557PriceText1y9Plug((Price) trailer.getPrice(), rowScopeInstance.alignByBaseline(companion), PriceViewType.PriceOnly, false, TypographyKt.getParagraphSmallBold(), (TextAlign) null, 0, appColor.m3253getBrandBlack10d7_KjU(), startRestartGroup, 12607872, 104);
            PriceTextKt.m3557PriceText1y9Plug((Price) trailer.getPrice(), PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, rowScopeInstance.alignByBaseline(companion), 1.0f, false, 2, null), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSubSmall(), (TextAlign) null, 0, appColor.m3253getBrandBlack10d7_KjU(), startRestartGroup, 12607872, 104);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null);
            MeasurePolicy rowMeasurePolicy5 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor6 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor6);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl6 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl6, rowMeasurePolicy5, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl6, currentCompositionLocalMap6, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl6.getInserting() || !Intrinsics.areEqual(m1226constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m1226constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m1226constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m1227setimpl(m1226constructorimpl6, materializeModifier6, companion3.getSetModifier());
            TextKt.m940Text4IGK_g(formatMaxSpecification(trailer.getMaxHeight()), RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65528);
            TextKt.m940Text4IGK_g(formatMaxSpecification(trailer.getMaxLength()), RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65528);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (bookingType == BookingType.TwoWay && z9) {
                composer2 = startRestartGroup;
                ReturnDepartureSelection(trailer.getPrice(), z5, z6, z7, onChangedForDirection, startRestartGroup, (i8 & 8176) | ((i8 >> 9) & 57344));
            } else {
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Q2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TrailerRowView$lambda$13;
                    TrailerRowView$lambda$13 = TrailerRowViewKt.TrailerRowView$lambda$13(TrailerProduct.this, z5, z6, z7, z8, bookingType, trailerSelected, onChangedForDirection, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TrailerRowView$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailerRowView$lambda$1$lambda$0(Function1 function1, TrailerProduct trailerProduct) {
        function1.invoke(trailerProduct);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailerRowView$lambda$12$lambda$7$lambda$3$lambda$2(Function1 function1, TrailerProduct trailerProduct, boolean z5) {
        function1.invoke(trailerProduct);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailerRowView$lambda$12$lambda$7$lambda$6$lambda$5(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrailerRowView$lambda$13(TrailerProduct trailerProduct, boolean z5, boolean z6, boolean z7, boolean z8, BookingType bookingType, Function1 function1, Function2 function2, int i5, Composer composer, int i6) {
        TrailerRowView(trailerProduct, z5, z6, z7, z8, bookingType, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final String formatMaxSpecification(double d5) {
        if (d5 == 0.0d) {
            return "-";
        }
        return DoubleExtensionsKt.format(d5, 2) + "m";
    }
}
