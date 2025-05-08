package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import android.content.Context;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.FerrySectionSeatsScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatType;
import uniffi.molslinjen_shared.FerrySeatingSectionDetails;
import uniffi.molslinjen_shared.FerrySeatingSectionId;
import uniffi.molslinjen_shared.SelectSeatingHelperInterface;
import uniffi.molslinjen_shared.Size;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 F2\u00020\u0001:\u0002GFB3\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0014J\u000f\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u0014J\u0015\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u00102\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00100$¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0010¢\u0006\u0004\b(\u0010\u0014J\r\u0010)\u001a\u00020\u0010¢\u0006\u0004\b)\u0010\u0014J!\u0010+\u001a\u00020\u00102\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00100$¢\u0006\u0004\b+\u0010'J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020!¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u0010¢\u0006\u0004\b/\u0010\u0014J\r\u00100\u001a\u00020\u0010¢\u0006\u0004\b0\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00102R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0004\u0018\u0001078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020@0?8F¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;", "seatReservationManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Luniffi/molslinjen_shared/SelectSeatingHelperInterface;", "selectSeatingHelper", "Landroid/content/Context;", "context", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Luniffi/molslinjen_shared/SelectSeatingHelperInterface;Landroid/content/Context;Landroidx/lifecycle/SavedStateHandle;)V", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", BuildConfig.FLAVOR, "loadFerryData", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "setupFerryDataListener", "()V", "Luniffi/molslinjen_shared/Size;", "sectionSize", "Landroidx/compose/ui/geometry/Offset;", "getFocusPoint-x-9fifI", "(Luniffi/molslinjen_shared/Size;)Landroidx/compose/ui/geometry/Offset;", "getFocusPoint", "setupReservationListener", "setupSelectedSeatsListener", "Luniffi/molslinjen_shared/FerrySeat;", "seat", "toggleSeat", "(Luniffi/molslinjen_shared/FerrySeat;)V", BuildConfig.FLAVOR, "hasChanges", "()Z", "Lkotlin/Function1;", "onSuccessfulReservation", "onConfirm", "(Lkotlin/jvm/functions/Function1;)V", "showDeletePrompt", "hideDeletePrompt", "onSuccessfulDelete", "onDeleteReservation", "popToRoot", "showCloseWarning", "(Z)V", "hideCloseWarning", "cancelChanges", "Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Luniffi/molslinjen_shared/SelectSeatingHelperInterface;", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsScreenNavArgs;", "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "navSectionId", "Luniffi/molslinjen_shared/FerrySeatingSectionId;", BuildConfig.FLAVOR, "dpScaling", "F", "normalizedInitialFocusPoint", "Landroidx/compose/ui/geometry/Offset;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "viewState", "Companion", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FerrySectionSeatsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final float dpScaling;
    private final FerrySectionSeatsScreenNavArgs navArgs;
    private final FerrySeatingSectionId navSectionId;
    private final Offset normalizedInitialFocusPoint;
    private final ISelectSeatingManager seatReservationManager;
    private final SelectSeatingHelperInterface selectSeatingHelper;
    private final ISnackbarService snackbarService;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final float SeatSize = Dp.m2599constructorimpl(48);
    private static final float VerticalSpacing = Dp.m2599constructorimpl(6);
    private static final float HorizontalSpacing = Dp.m2599constructorimpl(8);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "SeatSize", "Landroidx/compose/ui/unit/Dp;", "getSeatSize-D9Ej5fM", "()F", "F", "VerticalSpacing", "getVerticalSpacing-D9Ej5fM", "HorizontalSpacing", "getHorizontalSpacing-D9Ej5fM", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHorizontalSpacing-D9Ej5fM, reason: not valid java name */
        public final float m3450getHorizontalSpacingD9Ej5fM() {
            return FerrySectionSeatsViewModel.HorizontalSpacing;
        }

        /* renamed from: getSeatSize-D9Ej5fM, reason: not valid java name */
        public final float m3451getSeatSizeD9Ej5fM() {
            return FerrySectionSeatsViewModel.SeatSize;
        }

        /* renamed from: getVerticalSpacing-D9Ej5fM, reason: not valid java name */
        public final float m3452getVerticalSpacingD9Ej5fM() {
            return FerrySectionSeatsViewModel.VerticalSpacing;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001:\u0001=B\u0085\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0090\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b\u0003\u0010%R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b2\u0010%R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b6\u0010%R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b\u0012\u0010%R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u00107\u001a\u0004\b8\u00109R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010:\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatType;", "seatTypes", "Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", "sectionDetails", BuildConfig.FLAVOR, "maxNumberOfPassengers", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "selectedSeats", "hasExistingReservation", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning;", "closeWarningState", "showDeletePrompt", "isDeleteLoading", "Landroidx/compose/ui/geometry/Offset;", "initialFocusPoint", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "<init>", "(ZLjava/util/Set;Luniffi/molslinjen_shared/FerrySeatingSectionDetails;Ljava/lang/Integer;Ljava/util/List;ZLdk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning;ZZLandroidx/compose/ui/geometry/Offset;Ldk/molslinjen/domain/model/booking/DepartureDirection;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "copy-Bn-6Y4c", "(ZLjava/util/Set;Luniffi/molslinjen_shared/FerrySeatingSectionDetails;Ljava/lang/Integer;Ljava/util/List;ZLdk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning;ZZLandroidx/compose/ui/geometry/Offset;Ldk/molslinjen/domain/model/booking/DepartureDirection;)Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState;", "copy", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/util/Set;", "getSeatTypes", "()Ljava/util/Set;", "Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", "getSectionDetails", "()Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", "Ljava/lang/Integer;", "getMaxNumberOfPassengers", "()Ljava/lang/Integer;", "Ljava/util/List;", "getSelectedSeats", "()Ljava/util/List;", "getHasExistingReservation", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning;", "getCloseWarningState", "()Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning;", "getShowDeletePrompt", "Landroidx/compose/ui/geometry/Offset;", "getInitialFocusPoint-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "CloseWarning", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final CloseWarning closeWarningState;
        private final DepartureDirection direction;
        private final boolean hasExistingReservation;
        private final Offset initialFocusPoint;
        private final boolean isDeleteLoading;
        private final boolean isLoading;
        private final Integer maxNumberOfPassengers;
        private final Set<FerrySeatType> seatTypes;
        private final FerrySeatingSectionDetails sectionDetails;
        private final List<FerrySeat> selectedSeats;
        private final boolean showDeletePrompt;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning;", BuildConfig.FLAVOR, "<init>", "()V", "Show", "Hide", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning$Hide;", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning$Show;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static abstract class CloseWarning {

            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning$Hide;", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning;", "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final /* data */ class Hide extends CloseWarning {
                public static final Hide INSTANCE = new Hide();

                private Hide() {
                    super(null);
                }

                public boolean equals(Object other) {
                    return this == other || (other instanceof Hide);
                }

                public int hashCode() {
                    return -1510769187;
                }

                public String toString() {
                    return "Hide";
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning$Show;", "Ldk/molslinjen/ui/views/screens/booking/addons/seating/select/FerrySectionSeatsViewModel$ViewState$CloseWarning;", "popToRoot", BuildConfig.FLAVOR, "<init>", "(Z)V", "getPopToRoot", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final class Show extends CloseWarning {
                private final boolean popToRoot;

                public Show(boolean z5) {
                    super(null);
                    this.popToRoot = z5;
                }

                public final boolean getPopToRoot() {
                    return this.popToRoot;
                }
            }

            public /* synthetic */ CloseWarning(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CloseWarning() {
            }
        }

        public /* synthetic */ ViewState(boolean z5, Set set, FerrySeatingSectionDetails ferrySeatingSectionDetails, Integer num, List list, boolean z6, CloseWarning closeWarning, boolean z7, boolean z8, Offset offset, DepartureDirection departureDirection, DefaultConstructorMarker defaultConstructorMarker) {
            this(z5, set, ferrySeatingSectionDetails, num, list, z6, closeWarning, z7, z8, offset, departureDirection);
        }

        /* renamed from: copy-Bn-6Y4c$default, reason: not valid java name */
        public static /* synthetic */ ViewState m3453copyBn6Y4c$default(ViewState viewState, boolean z5, Set set, FerrySeatingSectionDetails ferrySeatingSectionDetails, Integer num, List list, boolean z6, CloseWarning closeWarning, boolean z7, boolean z8, Offset offset, DepartureDirection departureDirection, int i5, Object obj) {
            return viewState.m3454copyBn6Y4c((i5 & 1) != 0 ? viewState.isLoading : z5, (i5 & 2) != 0 ? viewState.seatTypes : set, (i5 & 4) != 0 ? viewState.sectionDetails : ferrySeatingSectionDetails, (i5 & 8) != 0 ? viewState.maxNumberOfPassengers : num, (i5 & 16) != 0 ? viewState.selectedSeats : list, (i5 & 32) != 0 ? viewState.hasExistingReservation : z6, (i5 & 64) != 0 ? viewState.closeWarningState : closeWarning, (i5 & 128) != 0 ? viewState.showDeletePrompt : z7, (i5 & 256) != 0 ? viewState.isDeleteLoading : z8, (i5 & 512) != 0 ? viewState.initialFocusPoint : offset, (i5 & 1024) != 0 ? viewState.direction : departureDirection);
        }

        /* renamed from: copy-Bn-6Y4c, reason: not valid java name */
        public final ViewState m3454copyBn6Y4c(boolean isLoading, Set<? extends FerrySeatType> seatTypes, FerrySeatingSectionDetails sectionDetails, Integer maxNumberOfPassengers, List<FerrySeat> selectedSeats, boolean hasExistingReservation, CloseWarning closeWarningState, boolean showDeletePrompt, boolean isDeleteLoading, Offset initialFocusPoint, DepartureDirection direction) {
            Intrinsics.checkNotNullParameter(seatTypes, "seatTypes");
            Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
            Intrinsics.checkNotNullParameter(closeWarningState, "closeWarningState");
            Intrinsics.checkNotNullParameter(direction, "direction");
            return new ViewState(isLoading, seatTypes, sectionDetails, maxNumberOfPassengers, selectedSeats, hasExistingReservation, closeWarningState, showDeletePrompt, isDeleteLoading, initialFocusPoint, direction, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.seatTypes, viewState.seatTypes) && Intrinsics.areEqual(this.sectionDetails, viewState.sectionDetails) && Intrinsics.areEqual(this.maxNumberOfPassengers, viewState.maxNumberOfPassengers) && Intrinsics.areEqual(this.selectedSeats, viewState.selectedSeats) && this.hasExistingReservation == viewState.hasExistingReservation && Intrinsics.areEqual(this.closeWarningState, viewState.closeWarningState) && this.showDeletePrompt == viewState.showDeletePrompt && this.isDeleteLoading == viewState.isDeleteLoading && Intrinsics.areEqual(this.initialFocusPoint, viewState.initialFocusPoint) && this.direction == viewState.direction;
        }

        public final CloseWarning getCloseWarningState() {
            return this.closeWarningState;
        }

        public final boolean getHasExistingReservation() {
            return this.hasExistingReservation;
        }

        /* renamed from: getInitialFocusPoint-_m7T9-E, reason: not valid java name and from getter */
        public final Offset getInitialFocusPoint() {
            return this.initialFocusPoint;
        }

        public final Integer getMaxNumberOfPassengers() {
            return this.maxNumberOfPassengers;
        }

        public final Set<FerrySeatType> getSeatTypes() {
            return this.seatTypes;
        }

        public final FerrySeatingSectionDetails getSectionDetails() {
            return this.sectionDetails;
        }

        public final List<FerrySeat> getSelectedSeats() {
            return this.selectedSeats;
        }

        public final boolean getShowDeletePrompt() {
            return this.showDeletePrompt;
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.isLoading) * 31) + this.seatTypes.hashCode()) * 31;
            FerrySeatingSectionDetails ferrySeatingSectionDetails = this.sectionDetails;
            int hashCode2 = (hashCode + (ferrySeatingSectionDetails == null ? 0 : ferrySeatingSectionDetails.hashCode())) * 31;
            Integer num = this.maxNumberOfPassengers;
            int hashCode3 = (((((((((((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.selectedSeats.hashCode()) * 31) + Boolean.hashCode(this.hasExistingReservation)) * 31) + this.closeWarningState.hashCode()) * 31) + Boolean.hashCode(this.showDeletePrompt)) * 31) + Boolean.hashCode(this.isDeleteLoading)) * 31;
            Offset offset = this.initialFocusPoint;
            return ((hashCode3 + (offset != null ? Offset.m1339hashCodeimpl(offset.getPackedValue()) : 0)) * 31) + this.direction.hashCode();
        }

        /* renamed from: isDeleteLoading, reason: from getter */
        public final boolean getIsDeleteLoading() {
            return this.isDeleteLoading;
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", seatTypes=" + this.seatTypes + ", sectionDetails=" + this.sectionDetails + ", maxNumberOfPassengers=" + this.maxNumberOfPassengers + ", selectedSeats=" + this.selectedSeats + ", hasExistingReservation=" + this.hasExistingReservation + ", closeWarningState=" + this.closeWarningState + ", showDeletePrompt=" + this.showDeletePrompt + ", isDeleteLoading=" + this.isDeleteLoading + ", initialFocusPoint=" + this.initialFocusPoint + ", direction=" + this.direction + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ViewState(boolean z5, Set<? extends FerrySeatType> seatTypes, FerrySeatingSectionDetails ferrySeatingSectionDetails, Integer num, List<FerrySeat> selectedSeats, boolean z6, CloseWarning closeWarningState, boolean z7, boolean z8, Offset offset, DepartureDirection direction) {
            Intrinsics.checkNotNullParameter(seatTypes, "seatTypes");
            Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
            Intrinsics.checkNotNullParameter(closeWarningState, "closeWarningState");
            Intrinsics.checkNotNullParameter(direction, "direction");
            this.isLoading = z5;
            this.seatTypes = seatTypes;
            this.sectionDetails = ferrySeatingSectionDetails;
            this.maxNumberOfPassengers = num;
            this.selectedSeats = selectedSeats;
            this.hasExistingReservation = z6;
            this.closeWarningState = closeWarningState;
            this.showDeletePrompt = z7;
            this.isDeleteLoading = z8;
            this.initialFocusPoint = offset;
            this.direction = direction;
        }

        public /* synthetic */ ViewState(boolean z5, Set set, FerrySeatingSectionDetails ferrySeatingSectionDetails, Integer num, List list, boolean z6, CloseWarning closeWarning, boolean z7, boolean z8, Offset offset, DepartureDirection departureDirection, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? CollectionsKt.toSet(FerrySeatType.getEntries()) : set, (i5 & 4) != 0 ? null : ferrySeatingSectionDetails, (i5 & 8) != 0 ? null : num, (i5 & 16) != 0 ? CollectionsKt.emptyList() : list, (i5 & 32) != 0 ? false : z6, (i5 & 64) != 0 ? CloseWarning.Hide.INSTANCE : closeWarning, (i5 & 128) != 0 ? false : z7, (i5 & 256) != 0 ? false : z8, (i5 & 512) != 0 ? null : offset, departureDirection, null);
        }
    }

    public FerrySectionSeatsViewModel(ISelectSeatingManager seatReservationManager, ISnackbarService snackbarService, SelectSeatingHelperInterface selectSeatingHelper, Context context, SavedStateHandle savedStateHandle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(seatReservationManager, "seatReservationManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(selectSeatingHelper, "selectSeatingHelper");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.seatReservationManager = seatReservationManager;
        this.snackbarService = snackbarService;
        this.selectSeatingHelper = selectSeatingHelper;
        FerrySectionSeatsScreenNavArgs argsFrom = FerrySectionSeatsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        FerrySeatingSectionId sectionId = argsFrom.getSectionId();
        this.navSectionId = sectionId;
        this.dpScaling = context.getResources().getDisplayMetrics().density;
        this.normalizedInitialFocusPoint = argsFrom.getOffset();
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, null, false, null, false, false, null, argsFrom.getDirection(), 1023, null));
        this._viewState = MutableStateFlow;
        setupSelectedSeatsListener();
        setupFerryDataListener();
        setupReservationListener();
        if (sectionId == null) {
            DepartureDirection direction = argsFrom.getDirection();
            if (direction != null) {
                loadFerryData(direction);
                return;
            }
            return;
        }
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, ViewState.m3453copyBn6Y4c$default(value, false, null, null, null, null, false, null, false, false, null, null, 2046, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getFocusPoint-x-9fifI, reason: not valid java name */
    public final Offset m3449getFocusPointx9fifI(Size sectionSize) {
        Offset initialFocusPoint = getViewState().getValue().getInitialFocusPoint();
        if (initialFocusPoint != null || sectionSize == null) {
            return initialFocusPoint;
        }
        Offset offset = this.normalizedInitialFocusPoint;
        if (offset == null) {
            return null;
        }
        long packedValue = offset.getPackedValue();
        return Offset.m1328boximpl(OffsetKt.Offset(Offset.m1337getXimpl(packedValue) * ((float) sectionSize.getWidth()), Offset.m1338getYimpl(packedValue) * ((float) sectionSize.getHeight())));
    }

    private final void loadFerryData(DepartureDirection departureDirection) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FerrySectionSeatsViewModel$loadFerryData$1(this, departureDirection, null), 3, null);
    }

    private final void setupFerryDataListener() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new FerrySectionSeatsViewModel$setupFerryDataListener$1(this, null), 2, null);
    }

    private final void setupReservationListener() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new FerrySectionSeatsViewModel$setupReservationListener$1(this, null), 2, null);
    }

    private final void setupSelectedSeatsListener() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new FerrySectionSeatsViewModel$setupSelectedSeatsListener$1(this, null), 2, null);
    }

    public final void cancelChanges() {
        ViewState value;
        this.seatReservationManager.resetChanges();
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.m3453copyBn6Y4c$default(value, false, null, null, null, null, false, ViewState.CloseWarning.Hide.INSTANCE, false, false, null, null, 1983, null)));
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    public final boolean hasChanges() {
        ISelectSeatingManager.SeatReservationState value = this.seatReservationManager.getState().getValue();
        if (this._viewState.getValue().getHasExistingReservation()) {
            List<FerrySeat> reservedSeats = value.getReservedSeats();
            if (!(reservedSeats instanceof Collection) || !reservedSeats.isEmpty()) {
                Iterator<T> it = reservedSeats.iterator();
                while (it.hasNext()) {
                    if (!value.getSelectedSeats().contains(((FerrySeat) it.next()).getId())) {
                        return true;
                    }
                }
            }
        } else if (!value.getSelectedSeats().isEmpty()) {
            return true;
        }
        return false;
    }

    public final void hideCloseWarning() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.m3453copyBn6Y4c$default(value, false, null, null, null, null, false, ViewState.CloseWarning.Hide.INSTANCE, false, false, null, null, 1983, null)));
    }

    public final void hideDeletePrompt() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.m3453copyBn6Y4c$default(value, false, null, null, null, null, false, null, false, false, null, null, 1919, null)));
    }

    public final void onConfirm(Function1<? super Boolean, Unit> onSuccessfulReservation) {
        ViewState value;
        Intrinsics.checkNotNullParameter(onSuccessfulReservation, "onSuccessfulReservation");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.m3453copyBn6Y4c$default(value, true, null, null, null, null, false, null, false, false, null, null, 2046, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new FerrySectionSeatsViewModel$onConfirm$2(this, onSuccessfulReservation, null), 2, null);
    }

    public final void onDeleteReservation(Function1<? super Boolean, Unit> onSuccessfulDelete) {
        Intrinsics.checkNotNullParameter(onSuccessfulDelete, "onSuccessfulDelete");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new FerrySectionSeatsViewModel$onDeleteReservation$1(this, onSuccessfulDelete, null), 3, null);
    }

    public final void showCloseWarning(boolean popToRoot) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.m3453copyBn6Y4c$default(value, false, null, null, null, null, false, new ViewState.CloseWarning.Show(popToRoot), false, false, null, null, 1983, null)));
    }

    public final void showDeletePrompt() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.m3453copyBn6Y4c$default(value, false, null, null, null, null, false, null, true, false, null, null, 1919, null)));
    }

    public final void toggleSeat(FerrySeat seat) {
        Intrinsics.checkNotNullParameter(seat, "seat");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new FerrySectionSeatsViewModel$toggleSeat$1(this, seat, null), 2, null);
    }
}
