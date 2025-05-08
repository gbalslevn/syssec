package dk.molslinjen.ui.views.global.navigation;

import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001ac\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u00030\u0006j\u0002`\u00072\u0016\u0010\b\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u00030\u0006j\u0002`\u00070\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e\u001a:\u0010\u000f\u001a\u00020\u0010\"\u0010\b\u0000\u0010\u0011*\n\u0012\u0002\b\u00030\u0006j\u0002`\u0007\"\u0004\b\u0001\u0010\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00110\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b¨\u0006\u0012"}, d2 = {"setResult", BuildConfig.FLAVOR, "R", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", "result", "resultTargetType", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "resultOriginType", "Lkotlin/reflect/KClass;", "resultNavType", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "navController", "Landroidx/navigation/NavController;", "(Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Ljava/lang/Object;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Lkotlin/reflect/KClass;Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;Landroidx/navigation/NavController;)V", "resultKey", BuildConfig.FLAVOR, "D", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ResultBackNavigatorExtensionsKt {
    public static final <D extends TypedDestinationSpec<?>, R> String resultKey(KClass<D> resultOriginType, DestinationsNavType<R> resultNavType) {
        Intrinsics.checkNotNullParameter(resultOriginType, "resultOriginType");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        return "compose-destinations@" + resultOriginType.getQualifiedName() + "@" + Reflection.getOrCreateKotlinClass(resultNavType.getClass()).getQualifiedName() + "@result";
    }

    public static final <R> void setResult(ResultBackNavigator<R> resultBackNavigator, R r5, TypedDestinationSpec<?> resultTargetType, KClass<? extends TypedDestinationSpec<?>> resultOriginType, DestinationsNavType<? super R> resultNavType, NavController navController) {
        Object obj;
        SavedStateHandle savedStateHandle;
        Intrinsics.checkNotNullParameter(resultBackNavigator, "<this>");
        Intrinsics.checkNotNullParameter(resultTargetType, "resultTargetType");
        Intrinsics.checkNotNullParameter(resultOriginType, "resultOriginType");
        Intrinsics.checkNotNullParameter(resultNavType, "resultNavType");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Iterator<T> it = navController.getCurrentBackStack().getValue().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String route = ((NavBackStackEntry) next).getDestination().getRoute();
            if (route != null && StringsKt.startsWith$default(route, resultTargetType.getBaseRoute(), false, 2, (Object) null)) {
                obj = next;
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry == null || (savedStateHandle = navBackStackEntry.getSavedStateHandle()) == null) {
            return;
        }
        resultNavType.put(savedStateHandle, resultKey(resultOriginType, resultNavType), (String) r5);
    }
}
