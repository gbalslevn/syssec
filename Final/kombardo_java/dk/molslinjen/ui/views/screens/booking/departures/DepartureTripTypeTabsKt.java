package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureTripTypeTabsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u001aQ\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u0012\u001a\u00020\u0007*\u00020\r2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\"\u0018\u0010\u000f\u001a\u00020\u000e*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/booking/BookingType;", "selectedType", BuildConfig.FLAVOR, "enabled", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onDisabledClick", "Lkotlin/Function1;", "onTripTypeChanged", "DepartureTripTypeTabs", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/BookingType;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "isSelected", "onClick", "TripTypeTab", "(Landroidx/compose/foundation/layout/RowScope;IZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getTitle", "(Ldk/molslinjen/domain/model/booking/BookingType;)I", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureTripTypeTabsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BookingType.values().length];
            try {
                iArr[BookingType.Single.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BookingType.TwoWay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DepartureTripTypeTabs(Modifier modifier, final BookingType selectedType, boolean z5, Function0<Unit> function0, final Function1<? super BookingType, Unit> onTripTypeChanged, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        boolean z6;
        int i8;
        Function0<Unit> function02;
        int i9;
        Modifier modifier3;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final Function0<Unit> function03;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
        Intrinsics.checkNotNullParameter(onTripTypeChanged, "onTripTypeChanged");
        Composer startRestartGroup = composer.startRestartGroup(1062294502);
        int i10 = i6 & 1;
        if (i10 != 0) {
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
            i7 |= startRestartGroup.changed(selectedType) ? 32 : 16;
        }
        int i11 = i6 & 4;
        if (i11 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                function02 = function0;
                i7 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
                if ((i6 & 16) != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    i7 |= startRestartGroup.changedInstance(onTripTypeChanged) ? 16384 : 8192;
                }
                i9 = i7;
                if ((i9 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    modifier3 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                    boolean z7 = i11 != 0 ? true : z6;
                    Function0<Unit> function04 = i8 != 0 ? null : function02;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1062294502, i9, -1, "dk.molslinjen.ui.views.screens.booking.departures.DepartureTripTypeTabs (DepartureTripTypeTabs.kt:32)");
                    }
                    startRestartGroup.startReplaceGroup(-809023355);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = CollectionsKt.listOf((Object[]) new BookingType[]{BookingType.Single, BookingType.TwoWay});
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    List<BookingType> list = (List) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(AlphaKt.alpha(modifier3, z7 ? 1.0f : 0.4f), Color.m1485copywmQWz5c$default(AppColor.INSTANCE.m3254getBrandBlack20d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium());
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
                    boolean z8 = false;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU);
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
                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(1380970355);
                    for (final BookingType bookingType : list) {
                        int title = getTitle(bookingType);
                        boolean z9 = selectedType == bookingType ? true : z8;
                        startRestartGroup.startReplaceGroup(-983467217);
                        boolean changed = ((i9 & 57344) == 16384 ? true : z8) | startRestartGroup.changed(bookingType);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: J2.l
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit DepartureTripTypeTabs$lambda$4$lambda$3$lambda$2$lambda$1;
                                    DepartureTripTypeTabs$lambda$4$lambda$3$lambda$2$lambda$1 = DepartureTripTypeTabsKt.DepartureTripTypeTabs$lambda$4$lambda$3$lambda$2$lambda$1(Function1.this, bookingType);
                                    return DepartureTripTypeTabs$lambda$4$lambda$3$lambda$2$lambda$1;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        int i12 = i9 << 3;
                        TripTypeTab(rowScopeInstance, title, z9, z7, function04, (Function0) rememberedValue2, startRestartGroup, 6 | (i12 & 7168) | (i12 & 57344));
                        z8 = z8;
                        i9 = i9;
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z7;
                    function03 = function04;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function03 = function02;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final boolean z10 = z6;
                    endRestartGroup.updateScope(new Function2() { // from class: J2.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DepartureTripTypeTabs$lambda$5;
                            DepartureTripTypeTabs$lambda$5 = DepartureTripTypeTabsKt.DepartureTripTypeTabs$lambda$5(Modifier.this, selectedType, z10, function03, onTripTypeChanged, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return DepartureTripTypeTabs$lambda$5;
                        }
                    });
                    return;
                }
                return;
            }
            function02 = function0;
            if ((i6 & 16) != 0) {
            }
            i9 = i7;
            if ((i9 & 9363) == 9362) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-809023355);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            List<BookingType> list2 = (List) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier m103backgroundbw27NRU2 = BackgroundKt.m103backgroundbw27NRU(AlphaKt.alpha(modifier3, z7 ? 1.0f : 0.4f), Color.m1485copywmQWz5c$default(AppColor.INSTANCE.m3254getBrandBlack20d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium());
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            boolean z82 = false;
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1380970355);
            while (r0.hasNext()) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            z6 = z7;
            function03 = function04;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z6 = z5;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        function02 = function0;
        if ((i6 & 16) != 0) {
        }
        i9 = i7;
        if ((i9 & 9363) == 9362) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-809023355);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        List<BookingType> list22 = (List) rememberedValue;
        startRestartGroup.endReplaceGroup();
        Modifier m103backgroundbw27NRU22 = BackgroundKt.m103backgroundbw27NRU(AlphaKt.alpha(modifier3, z7 ? 1.0f : 0.4f), Color.m1485copywmQWz5c$default(AppColor.INSTANCE.m3254getBrandBlack20d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium());
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
        boolean z822 = false;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m103backgroundbw27NRU22);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy22, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
        RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(1380970355);
        while (r0.hasNext()) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z6 = z7;
        function03 = function04;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureTripTypeTabs$lambda$4$lambda$3$lambda$2$lambda$1(Function1 function1, BookingType bookingType) {
        function1.invoke(bookingType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureTripTypeTabs$lambda$5(Modifier modifier, BookingType bookingType, boolean z5, Function0 function0, Function1 function1, int i5, int i6, Composer composer, int i7) {
        DepartureTripTypeTabs(modifier, bookingType, z5, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final void TripTypeTab(final RowScope rowScope, final int i5, final boolean z5, final boolean z6, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1540357143);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        int i8 = i7;
        if ((74899 & i8) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1540357143, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.TripTypeTab (DepartureTripTypeTabs.kt:67)");
            }
            startRestartGroup.startReplaceGroup(1540264854);
            Modifier m103backgroundbw27NRU = z5 ? BackgroundKt.m103backgroundbw27NRU(Modifier.INSTANCE, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium()) : Modifier.INSTANCE;
            startRestartGroup.endReplaceGroup();
            Modifier m324defaultMinSizeVpY3zN4$default = SizeKt.m324defaultMinSizeVpY3zN4$default(m103backgroundbw27NRU, 0.0f, Dp.m2599constructorimpl(28), 1, null);
            startRestartGroup.startReplaceGroup(1540275254);
            boolean z7 = ((i8 & 7168) == 2048) | ((458752 & i8) == 131072) | ((57344 & i8) == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: J2.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TripTypeTab$lambda$7$lambda$6;
                        TripTypeTab$lambda$7$lambda$6 = DepartureTripTypeTabsKt.TripTypeTab$lambda$7$lambda$6(z6, function02, function0, ((Boolean) obj).booleanValue());
                        return TripTypeTab$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i5, startRestartGroup, (i8 >> 3) & 14), RowScope.weight$default(rowScope, SizeKt.wrapContentHeight$default(ToggleableKt.m455toggleableXHw0xAI$default(m324defaultMinSizeVpY3zN4$default, z5, false, null, (Function1) rememberedValue, 6, null), null, false, 3, null), 1.0f, false, 2, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 384, 1572864, 65016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J2.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TripTypeTab$lambda$8;
                    TripTypeTab$lambda$8 = DepartureTripTypeTabsKt.TripTypeTab$lambda$8(RowScope.this, i5, z5, z6, function0, function02, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return TripTypeTab$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TripTypeTab$lambda$7$lambda$6(boolean z5, Function0 function0, Function0 function02, boolean z6) {
        if (z5) {
            function0.invoke();
        } else if (function02 != null) {
            function02.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TripTypeTab$lambda$8(RowScope rowScope, int i5, boolean z5, boolean z6, Function0 function0, Function0 function02, int i6, Composer composer, int i7) {
        TripTypeTab(rowScope, i5, z5, z6, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    private static final int getTitle(BookingType bookingType) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[bookingType.ordinal()];
        if (i5 == 1) {
            return R.string.departures_tab_single;
        }
        if (i5 == 2) {
            return R.string.departures_tab_return;
        }
        throw new NoWhenBranchMatchedException();
    }
}
