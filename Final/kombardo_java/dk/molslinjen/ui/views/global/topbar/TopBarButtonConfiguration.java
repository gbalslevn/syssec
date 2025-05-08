package dk.molslinjen.ui.views.global.topbar;

import androidx.compose.runtime.Composer;
import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B)\b\u0004\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "showPopupState", "Lkotlin/Function0;", BuildConfig.FLAVOR, "popupContent", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/flow/StateFlow;", "getShowPopupState", "()Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/jvm/functions/Function2;", "getPopupContent", "()Lkotlin/jvm/functions/Function2;", "Basic", "Custom", "Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration$Basic;", "Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration$Custom;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TopBarButtonConfiguration {
    private final Function2<Composer, Integer, Unit> popupContent;
    private final StateFlow<Boolean> showPopupState;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration$Basic;", "Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;", BuildConfig.FLAVOR, "iconRes", "contentDescriptionRes", "Lkotlin/Function1;", "Landroidx/navigation/NavController;", BuildConfig.FLAVOR, "action", "<init>", "(ILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getIconRes", "Ljava/lang/Integer;", "getContentDescriptionRes", "()Ljava/lang/Integer;", "Lkotlin/jvm/functions/Function1;", "getAction", "()Lkotlin/jvm/functions/Function1;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Basic extends TopBarButtonConfiguration {
        private final Function1<NavController, Unit> action;
        private final Integer contentDescriptionRes;
        private final int iconRes;

        public /* synthetic */ Basic(int i5, Integer num, Function1 function1, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(i5, num, (i6 & 4) != 0 ? null : function1);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Basic)) {
                return false;
            }
            Basic basic = (Basic) other;
            return this.iconRes == basic.iconRes && Intrinsics.areEqual(this.contentDescriptionRes, basic.contentDescriptionRes) && Intrinsics.areEqual(this.action, basic.action);
        }

        public final Function1<NavController, Unit> getAction() {
            return this.action;
        }

        public final Integer getContentDescriptionRes() {
            return this.contentDescriptionRes;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.iconRes) * 31;
            Integer num = this.contentDescriptionRes;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Function1<NavController, Unit> function1 = this.action;
            return hashCode2 + (function1 != null ? function1.hashCode() : 0);
        }

        public String toString() {
            return "Basic(iconRes=" + this.iconRes + ", contentDescriptionRes=" + this.contentDescriptionRes + ", action=" + this.action + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Basic(int i5, Integer num, Function1<? super NavController, Unit> function1) {
            super(null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            this.iconRes = i5;
            this.contentDescriptionRes = num;
            this.action = function1;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration$Custom;", "Ldk/molslinjen/ui/views/global/topbar/TopBarButtonConfiguration;", "Lkotlin/Function1;", "Landroidx/navigation/NavController;", BuildConfig.FLAVOR, "content", "Lkotlinx/coroutines/flow/StateFlow;", BuildConfig.FLAVOR, "showPopupState", "Lkotlin/Function0;", "popupContent", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function2;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/jvm/functions/Function3;", "getContent", "()Lkotlin/jvm/functions/Function3;", "Lkotlinx/coroutines/flow/StateFlow;", "getShowPopupState", "()Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/jvm/functions/Function2;", "getPopupContent", "()Lkotlin/jvm/functions/Function2;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Custom extends TopBarButtonConfiguration {
        private final Function3<NavController, Composer, Integer, Unit> content;
        private final Function2<Composer, Integer, Unit> popupContent;
        private final StateFlow<Boolean> showPopupState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Custom(Function3<? super NavController, ? super Composer, ? super Integer, Unit> content, StateFlow<Boolean> stateFlow, Function2<? super Composer, ? super Integer, Unit> function2) {
            super(stateFlow, function2, null);
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
            this.showPopupState = stateFlow;
            this.popupContent = function2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Custom)) {
                return false;
            }
            Custom custom = (Custom) other;
            return Intrinsics.areEqual(this.content, custom.content) && Intrinsics.areEqual(this.showPopupState, custom.showPopupState) && Intrinsics.areEqual(this.popupContent, custom.popupContent);
        }

        public final Function3<NavController, Composer, Integer, Unit> getContent() {
            return this.content;
        }

        @Override // dk.molslinjen.ui.views.global.topbar.TopBarButtonConfiguration
        public Function2<Composer, Integer, Unit> getPopupContent() {
            return this.popupContent;
        }

        @Override // dk.molslinjen.ui.views.global.topbar.TopBarButtonConfiguration
        public StateFlow<Boolean> getShowPopupState() {
            return this.showPopupState;
        }

        public int hashCode() {
            int hashCode = this.content.hashCode() * 31;
            StateFlow<Boolean> stateFlow = this.showPopupState;
            int hashCode2 = (hashCode + (stateFlow == null ? 0 : stateFlow.hashCode())) * 31;
            Function2<Composer, Integer, Unit> function2 = this.popupContent;
            return hashCode2 + (function2 != null ? function2.hashCode() : 0);
        }

        public String toString() {
            return "Custom(content=" + this.content + ", showPopupState=" + this.showPopupState + ", popupContent=" + this.popupContent + ")";
        }
    }

    public /* synthetic */ TopBarButtonConfiguration(StateFlow stateFlow, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(stateFlow, function2);
    }

    public Function2<Composer, Integer, Unit> getPopupContent() {
        return this.popupContent;
    }

    public StateFlow<Boolean> getShowPopupState() {
        return this.showPopupState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TopBarButtonConfiguration(StateFlow<Boolean> stateFlow, Function2<? super Composer, ? super Integer, Unit> function2) {
        this.showPopupState = stateFlow;
        this.popupContent = function2;
    }
}
