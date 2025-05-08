package dk.molslinjen.ui.views.reusable.input.nationality;

import androidx.lifecycle.ViewModel;
import dk.molslinjen.extensions.LocaleUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/nationality/NationalitySelectionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/reusable/input/nationality/NationalitySelectionViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "ViewState", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NationalitySelectionViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final MutableStateFlow<ViewState> viewState;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public NationalitySelectionViewModel() {
        ViewState value;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] iSOCountries = Locale.getISOCountries();
        Intrinsics.checkNotNullExpressionValue(iSOCountries, "getISOCountries(...)");
        for (String str : iSOCountries) {
            Locale locale = new Locale(BuildConfig.FLAVOR, str);
            if (LocaleUtils.INSTANCE.getFrequentlyUsedCountryCodes().contains(str)) {
                arrayList.add(locale);
            }
            arrayList2.add(locale);
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: dk.molslinjen.ui.views.reusable.input.nationality.NationalitySelectionViewModel$_init_$lambda$3$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues(((Locale) t5).getDisplayCountry(), ((Locale) t6).getDisplayCountry());
            }
        }), CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: dk.molslinjen.ui.views.reusable.input.nationality.NationalitySelectionViewModel$_init_$lambda$3$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues(((Locale) t5).getDisplayCountry(), ((Locale) t6).getDisplayCountry());
            }
        }))));
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/nationality/NationalitySelectionViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ljava/util/Locale;", "frequentlyUsed", "others", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "copy", "(Ljava/util/List;Ljava/util/List;)Ldk/molslinjen/ui/views/reusable/input/nationality/NationalitySelectionViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getFrequentlyUsed", "()Ljava/util/List;", "getOthers", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final List<Locale> frequentlyUsed;
        private final List<Locale> others;

        public ViewState(List<Locale> frequentlyUsed, List<Locale> others) {
            Intrinsics.checkNotNullParameter(frequentlyUsed, "frequentlyUsed");
            Intrinsics.checkNotNullParameter(others, "others");
            this.frequentlyUsed = frequentlyUsed;
            this.others = others;
        }

        public final ViewState copy(List<Locale> frequentlyUsed, List<Locale> others) {
            Intrinsics.checkNotNullParameter(frequentlyUsed, "frequentlyUsed");
            Intrinsics.checkNotNullParameter(others, "others");
            return new ViewState(frequentlyUsed, others);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.frequentlyUsed, viewState.frequentlyUsed) && Intrinsics.areEqual(this.others, viewState.others);
        }

        public final List<Locale> getFrequentlyUsed() {
            return this.frequentlyUsed;
        }

        public final List<Locale> getOthers() {
            return this.others;
        }

        public int hashCode() {
            return (this.frequentlyUsed.hashCode() * 31) + this.others.hashCode();
        }

        public String toString() {
            return "ViewState(frequentlyUsed=" + this.frequentlyUsed + ", others=" + this.others + ")";
        }

        public /* synthetic */ ViewState(List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list2);
        }
    }
}
