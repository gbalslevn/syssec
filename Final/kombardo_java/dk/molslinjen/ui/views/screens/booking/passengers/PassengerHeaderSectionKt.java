package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.extensions.domain.PassengerInfoExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengerHeaderSectionKt;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0017\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u001a\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0003¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "showHelp", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "selectedPassengers", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", BuildConfig.FLAVOR, "showAgeGroup", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "showDirectionSpecificTitle", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", BuildConfig.FLAVOR, "remainingAdultCount", "remainingChildCount", "remainingInfantCount", "showNameRequiredInfo", "movePassengerInfo", "PassengerHeaderSection", "(Lkotlin/jvm/functions/Function0;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ljava/util/List;Ldk/molslinjen/domain/model/config/Transportation;ZLdk/molslinjen/domain/model/booking/BookingType;ZLdk/molslinjen/domain/model/booking/DepartureDirection;IIIZZLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/text/AnnotatedString;", "buildTitle", "(Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerHeaderSectionKt {
    public static final void PassengerHeaderSection(final Function0<Unit> showHelp, final PassengerInfo passengerInfo, final List<BookingPassenger> selectedPassengers, final Transportation transportation, final boolean z5, final BookingType bookingType, final boolean z6, final DepartureDirection departureDirection, final int i5, final int i6, final int i7, final boolean z7, final boolean z8, Composer composer, final int i8, final int i9) {
        int i10;
        int i11;
        boolean z9;
        Composer composer2;
        Modifier.Companion companion;
        String pluralStringResource;
        int i12;
        int i13;
        int i14;
        TextStyle m2295copyp1EtxEg;
        String pluralStringResource2;
        Intrinsics.checkNotNullParameter(showHelp, "showHelp");
        Intrinsics.checkNotNullParameter(selectedPassengers, "selectedPassengers");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(bookingType, "bookingType");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        Composer startRestartGroup = composer.startRestartGroup(107173114);
        if ((i8 & 6) == 0) {
            i10 = i8 | (startRestartGroup.changedInstance(showHelp) ? 4 : 2);
        } else {
            i10 = i8;
        }
        if ((i8 & 48) == 0) {
            i10 |= startRestartGroup.changedInstance(passengerInfo) ? 32 : 16;
        }
        if ((i8 & 384) == 0) {
            i10 |= startRestartGroup.changedInstance(selectedPassengers) ? 256 : 128;
        }
        if ((i8 & 3072) == 0) {
            i10 |= startRestartGroup.changedInstance(transportation) ? 2048 : 1024;
        }
        if ((i8 & 24576) == 0) {
            i10 |= startRestartGroup.changed(z5) ? 16384 : 8192;
        }
        if ((196608 & i8) == 0) {
            i10 |= startRestartGroup.changed(bookingType) ? 131072 : 65536;
        }
        if ((1572864 & i8) == 0) {
            i10 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
        }
        if ((12582912 & i8) == 0) {
            i10 |= startRestartGroup.changed(departureDirection) ? 8388608 : 4194304;
        }
        if ((100663296 & i8) == 0) {
            i10 |= startRestartGroup.changed(i5) ? 67108864 : 33554432;
        }
        if ((805306368 & i8) == 0) {
            i10 |= startRestartGroup.changed(i6) ? 536870912 : 268435456;
        }
        int i15 = i10;
        if ((i9 & 6) == 0) {
            i11 = i9 | (startRestartGroup.changed(i7) ? 4 : 2);
        } else {
            i11 = i9;
        }
        if ((i9 & 48) == 0) {
            i11 |= startRestartGroup.changed(z7) ? 32 : 16;
        }
        if ((i9 & 384) == 0) {
            z9 = z8;
            i11 |= startRestartGroup.changed(z9) ? 256 : 128;
        } else {
            z9 = z8;
        }
        int i16 = i11;
        if ((i15 & 306783379) == 306783378 && (i16 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(107173114, i15, i16, "dk.molslinjen.ui.views.screens.booking.passengers.PassengerHeaderSection (PassengerHeaderSection.kt:50)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion2, appColor.m3269getGrey60d7_KjU(), null, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f5 = 16;
            float f6 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            AnnotatedString buildTitle = buildTitle(bookingType, departureDirection, z6, startRestartGroup, ((i15 >> 15) & 14) | ((i15 >> 18) & 112) | ((i15 >> 12) & 896));
            TextStyle h2Bold = TypographyKt.getH2Bold();
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
            startRestartGroup.startReplaceGroup(568110724);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: U2.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengerHeaderSection$lambda$4$lambda$2$lambda$1$lambda$0;
                        PassengerHeaderSection$lambda$4$lambda$2$lambda$1$lambda$0 = PassengerHeaderSectionKt.PassengerHeaderSection$lambda$4$lambda$2$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                        return PassengerHeaderSection$lambda$4$lambda$2$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m941TextIbK3jfQ(buildTitle, SemanticsModifierKt.semantics$default(weight$default, false, (Function1) rememberedValue, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, h2Bold, startRestartGroup, 0, 12582912, 131068);
            startRestartGroup.startReplaceGroup(568112552);
            if (!z7 || z9) {
                composer2 = startRestartGroup;
                companion = companion2;
            } else {
                composer2 = startRestartGroup;
                companion = companion2;
                IconButtonKt.IconButton(showHelp, SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), Dp.m2599constructorimpl(f6)), false, null, null, ComposableSingletons$PassengerHeaderSectionKt.INSTANCE.m3465getLambda1$app_kombardoProd(), composer2, 196656 | (i15 & 14), 28);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            float f7 = 8;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f7)), composer2, 6);
            int maxPassengers = transportation.getMaxPassengers();
            if (z8) {
                composer2.startReplaceGroup(509245149);
                pluralStringResource = StringResources_androidKt.stringResource(R.string.passengers_maxPassengers_includeAllPassengers, new Object[]{Integer.valueOf(maxPassengers)}, composer2, 6);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(509359260);
                pluralStringResource = StringResources_androidKt.pluralStringResource(R.plurals.passengers_maxPassengers, maxPassengers, new Object[]{Integer.valueOf(maxPassengers)}, composer2, 6);
                composer2.endReplaceGroup();
            }
            composer2.startReplaceGroup(-1923226601);
            String formatted = passengerInfo == null ? null : PassengerInfoExtensionsKt.formatted(passengerInfo, (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
            composer2.endReplaceGroup();
            if (formatted == null) {
                formatted = BuildConfig.FLAVOR;
            }
            String str = z5 ? formatted : pluralStringResource;
            if (passengerInfo != null) {
                i12 = i5;
                i14 = passengerInfo.getTotalPassengerCount();
                i13 = 0;
            } else {
                i12 = i5;
                i13 = 0;
                i14 = 0;
            }
            int abs = Math.abs(RangesKt.coerceAtMost(i12, i13) + RangesKt.coerceAtMost(i6, i13) + RangesKt.coerceAtMost(i7, i13));
            if (!z5) {
                abs = selectedPassengers.size() - maxPassengers;
            }
            if (abs > 0) {
                composer2.startReplaceGroup(510065750);
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m104backgroundbw27NRU$default(PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), appColor.m3278getTagRed0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(4));
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer2, 0);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m312paddingVpY3zN4);
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                composer2.startReplaceGroup(568173074);
                if (!z5) {
                    if (z8) {
                        composer2.startReplaceGroup(433618996);
                        pluralStringResource2 = StringResources_androidKt.stringResource(R.string.passengers_maxPassengers_includeAllPassengers, new Object[]{Integer.valueOf(i14)}, composer2, 6);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(433775081);
                        pluralStringResource2 = StringResources_androidKt.pluralStringResource(R.plurals.passengers_maxPassengers, i14, new Object[]{Integer.valueOf(i14)}, composer2, 6);
                        composer2.endReplaceGroup();
                    }
                    str = pluralStringResource2;
                }
                composer2.endReplaceGroup();
                Composer composer3 = composer2;
                TextKt.m940Text4IGK_g(str, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 384, 1572864, 65530);
                TextKt.m940Text4IGK_g(StringResources_androidKt.pluralStringResource(R.plurals.editFlow_passengersOverMax, abs, composer2, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 0, 1572864, 65534);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(511174000);
                TextKt.m940Text4IGK_g(str, PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 432, 1572864, 65528);
                composer2.endReplaceGroup();
            }
            if (z8) {
                composer2.startReplaceGroup(511429006);
                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(ClickableKt.m122clickableXHw0xAI$default(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), false, null, null, showHelp, 7, null), 0.0f, Dp.m2599constructorimpl(f7), 1, null);
                String stringResource = StringResources_androidKt.stringResource(R.string.passengers_help_link, composer2, 6);
                m2295copyp1EtxEg = r44.m2295copyp1EtxEg((r48 & 1) != 0 ? r44.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r44.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r44.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r44.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r44.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r44.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r44.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r44.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r44.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r44.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r44.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r44.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r44.spanStyle.getTextDecoration() : TextDecoration.INSTANCE.getUnderline(), (r48 & 8192) != 0 ? r44.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r44.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r44.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r44.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r44.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r44.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r44.platformStyle : null, (r48 & 1048576) != 0 ? r44.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r44.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r44.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSub().paragraphStyle.getTextMotion() : null);
                TextKt.m940Text4IGK_g(stringResource, m313paddingVpY3zN4$default, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 384, 0, 65528);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(511832874);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f7)), composer2, 6);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.A
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerHeaderSection$lambda$5;
                    PassengerHeaderSection$lambda$5 = PassengerHeaderSectionKt.PassengerHeaderSection$lambda$5(Function0.this, passengerInfo, selectedPassengers, transportation, z5, bookingType, z6, departureDirection, i5, i6, i7, z7, z8, i8, i9, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerHeaderSection$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerHeaderSection$lambda$4$lambda$2$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.heading(semantics);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerHeaderSection$lambda$5(Function0 function0, PassengerInfo passengerInfo, List list, Transportation transportation, boolean z5, BookingType bookingType, boolean z6, DepartureDirection departureDirection, int i5, int i6, int i7, boolean z7, boolean z8, int i8, int i9, Composer composer, int i10) {
        PassengerHeaderSection(function0, passengerInfo, list, transportation, z5, bookingType, z6, departureDirection, i5, i6, i7, z7, z8, composer, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), RecomposeScopeImplKt.updateChangedFlags(i9));
        return Unit.INSTANCE;
    }

    private static final AnnotatedString buildTitle(BookingType bookingType, DepartureDirection departureDirection, boolean z5, Composer composer, int i5) {
        String stringResource;
        composer.startReplaceGroup(-895990204);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-895990204, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.buildTitle (PassengerHeaderSection.kt:148)");
        }
        if (bookingType == BookingType.Single || !z5) {
            composer.startReplaceGroup(-1838547374);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_travel, composer, 6);
            composer.endReplaceGroup();
        } else if (departureDirection == DepartureDirection.Return) {
            composer.startReplaceGroup(-1838544008);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_returnTravel, composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1838541830);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_outboundTravel, composer, 6);
            composer.endReplaceGroup();
        }
        String lowerCase = stringResource.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String stringResource2 = StringResources_androidKt.stringResource(R.string.passengers_whoIsTraveling, new Object[]{lowerCase}, composer, 6);
        if (bookingType != BookingType.TwoWay || !z5) {
            AnnotatedString annotatedString = new AnnotatedString(stringResource2, null, null, 6, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return annotatedString;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) stringResource2, lowerCase, 0, false, 6, (Object) null);
        AnnotatedString annotatedString2 = new AnnotatedString(stringResource2, CollectionsKt.mutableListOf(new AnnotatedString.Range(new SpanStyle(AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65534, null), indexOf$default, lowerCase.length() + indexOf$default)), null, 4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return annotatedString2;
    }
}
