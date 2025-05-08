package androidx.navigation;

import androidx.navigation.NavOptions;
import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000eJ!\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R*\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00048\u0006@@X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R.\u0010,\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010\f8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001cR\u0016\u00103\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010\u001cR6\u00105\u001a\b\u0012\u0002\b\u0003\u0018\u0001042\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u0001048F@BX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R.\u0010;\u001a\u0004\u0018\u00010\u00012\b\u0010%\u001a\u0004\u0018\u00010\u00018F@BX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006A"}, d2 = {"Landroidx/navigation/NavOptionsBuilder;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Lkotlin/Function1;", "Landroidx/navigation/PopUpToBuilder;", BuildConfig.FLAVOR, "popUpToBuilder", "popUpTo", "(ILkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "route", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Landroidx/navigation/AnimBuilder;", "animBuilder", "anim", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/navigation/NavOptions;", "build$navigation_common_release", "()Landroidx/navigation/NavOptions;", "build", "Landroidx/navigation/NavOptions$Builder;", "builder", "Landroidx/navigation/NavOptions$Builder;", BuildConfig.FLAVOR, "launchSingleTop", "Z", "getLaunchSingleTop", "()Z", "setLaunchSingleTop", "(Z)V", "<set-?>", "restoreState", "getRestoreState", "setRestoreState", "value", "popUpToId", "I", "getPopUpToId", "()I", "setPopUpToId$navigation_common_release", "(I)V", "popUpToRoute", "Ljava/lang/String;", "getPopUpToRoute", "()Ljava/lang/String;", "setPopUpToRoute", "(Ljava/lang/String;)V", "inclusive", "saveState", "Lkotlin/reflect/KClass;", "popUpToRouteClass", "Lkotlin/reflect/KClass;", "getPopUpToRouteClass", "()Lkotlin/reflect/KClass;", "setPopUpToRouteClass", "(Lkotlin/reflect/KClass;)V", "popUpToRouteObject", "Ljava/lang/Object;", "getPopUpToRouteObject", "()Ljava/lang/Object;", "setPopUpToRouteObject", "(Ljava/lang/Object;)V", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavOptionsBuilder {
    private boolean inclusive;
    private boolean launchSingleTop;
    private String popUpToRoute;
    private KClass<?> popUpToRouteClass;
    private Object popUpToRouteObject;
    private boolean restoreState;
    private boolean saveState;
    private final NavOptions.Builder builder = new NavOptions.Builder();
    private int popUpToId = -1;

    private final void setPopUpToRoute(String str) {
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                throw new IllegalArgumentException("Cannot pop up to an empty route");
            }
            this.popUpToRoute = str;
            this.inclusive = false;
        }
    }

    public final void anim(Function1<? super AnimBuilder, Unit> animBuilder) {
        Intrinsics.checkNotNullParameter(animBuilder, "animBuilder");
        AnimBuilder animBuilder2 = new AnimBuilder();
        animBuilder.invoke(animBuilder2);
        this.builder.setEnterAnim(animBuilder2.getEnter()).setExitAnim(animBuilder2.getExit()).setPopEnterAnim(animBuilder2.getPopEnter()).setPopExitAnim(animBuilder2.getPopExit());
    }

    public final NavOptions build$navigation_common_release() {
        NavOptions.Builder builder = this.builder;
        builder.setLaunchSingleTop(this.launchSingleTop);
        builder.setRestoreState(this.restoreState);
        String str = this.popUpToRoute;
        if (str != null) {
            builder.setPopUpTo(str, this.inclusive, this.saveState);
        } else {
            KClass<?> kClass = this.popUpToRouteClass;
            if (kClass != null) {
                Intrinsics.checkNotNull(kClass);
                builder.setPopUpTo(kClass, this.inclusive, this.saveState);
            } else {
                Object obj = this.popUpToRouteObject;
                if (obj != null) {
                    Intrinsics.checkNotNull(obj);
                    builder.setPopUpTo((NavOptions.Builder) obj, this.inclusive, this.saveState);
                } else {
                    builder.setPopUpTo(this.popUpToId, this.inclusive, this.saveState);
                }
            }
        }
        return builder.build();
    }

    public final void popUpTo(int id, Function1<? super PopUpToBuilder, Unit> popUpToBuilder) {
        Intrinsics.checkNotNullParameter(popUpToBuilder, "popUpToBuilder");
        setPopUpToId$navigation_common_release(id);
        setPopUpToRoute(null);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
        this.saveState = popUpToBuilder2.getSaveState();
    }

    public final void setLaunchSingleTop(boolean z5) {
        this.launchSingleTop = z5;
    }

    public final void setPopUpToId$navigation_common_release(int i5) {
        this.popUpToId = i5;
        this.inclusive = false;
    }

    public final void setRestoreState(boolean z5) {
        this.restoreState = z5;
    }

    public final void popUpTo(String route, Function1<? super PopUpToBuilder, Unit> popUpToBuilder) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(popUpToBuilder, "popUpToBuilder");
        setPopUpToRoute(route);
        setPopUpToId$navigation_common_release(-1);
        PopUpToBuilder popUpToBuilder2 = new PopUpToBuilder();
        popUpToBuilder.invoke(popUpToBuilder2);
        this.inclusive = popUpToBuilder2.getInclusive();
        this.saveState = popUpToBuilder2.getSaveState();
    }
}
