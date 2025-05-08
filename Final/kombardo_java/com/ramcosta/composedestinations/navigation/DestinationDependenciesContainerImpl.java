package com.ramcosta.composedestinations.navigation;

import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.scope.DestinationScopeWithNoDependencies;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00020\r\"\b\b\u0001\u0010\t*\u00020\b2\u0006\u0010\n\u001a\u00028\u00012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000b¢\u0006\u0004\b\n\u0010\u000eJ/\u0010\u0012\u001a\u00028\u0001\"\b\b\u0001\u0010\t*\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\b0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/ramcosta/composedestinations/navigation/DestinationDependenciesContainerImpl;", "T", "Lcom/ramcosta/composedestinations/navigation/DestinationDependenciesContainer;", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", "Lcom/ramcosta/composedestinations/scope/DestinationScopeWithNoDependencies;", "destinationScope", "<init>", "(Lcom/ramcosta/composedestinations/scope/DestinationScopeWithNoDependencies;)V", BuildConfig.FLAVOR, "D", "dependency", "Lkotlin/reflect/KClass;", "asType", BuildConfig.FLAVOR, "(Ljava/lang/Object;Lkotlin/reflect/KClass;)V", "type", BuildConfig.FLAVOR, "isMarkedNavHostParam", "require", "(Lkotlin/reflect/KClass;Z)Ljava/lang/Object;", BuildConfig.FLAVOR, "Ljava/lang/Class;", "map", "Ljava/util/Map;", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getDestination", "()Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavBackStackEntry;", "getNavBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DestinationDependenciesContainerImpl<T> implements DestinationDependenciesContainer, DependenciesContainerBuilder<T>, DestinationScopeWithNoDependencies<T> {
    private final /* synthetic */ DestinationScopeWithNoDependencies<T> $$delegate_0;
    private final Map<Class<?>, Object> map;

    public DestinationDependenciesContainerImpl(DestinationScopeWithNoDependencies<T> destinationScope) {
        Intrinsics.checkNotNullParameter(destinationScope, "destinationScope");
        this.$$delegate_0 = destinationScope;
        this.map = new LinkedHashMap();
    }

    public final <D> void dependency(D dependency, KClass<? super D> asType) {
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        Intrinsics.checkNotNullParameter(asType, "asType");
        this.map.put(JvmClassMappingKt.getJavaClass(asType), dependency);
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScopeWithNoDependencies
    public TypedDestinationSpec<T> getDestination() {
        return this.$$delegate_0.getDestination();
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScopeWithNoDependencies
    public NavBackStackEntry getNavBackStackEntry() {
        return this.$$delegate_0.getNavBackStackEntry();
    }

    @Override // com.ramcosta.composedestinations.scope.DestinationScopeWithNoDependencies
    public NavController getNavController() {
        return this.$$delegate_0.getNavController();
    }

    public final <D> D require(KClass<? super D> type, boolean isMarkedNavHostParam) {
        String str;
        T t5;
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = this.map.get(JvmClassMappingKt.getJavaClass(type));
        if (obj == null) {
            obj = (D) null;
        }
        if (obj == null) {
            Iterator<T> it = this.map.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t5 = null;
                    break;
                }
                t5 = it.next();
                if (JvmClassMappingKt.getJavaClass(type).isAssignableFrom(t5.getClass())) {
                    break;
                }
            }
            T t6 = t5 != null ? t5 : null;
            if (t6 != null) {
                dependency(t6, type);
            }
            obj = (D) t6;
        }
        if (obj != null) {
            return (D) obj;
        }
        if (isMarkedNavHostParam) {
            str = JvmClassMappingKt.getJavaClass(type).getSimpleName() + " was requested and it is marked with @NavHostParam but it was not provided via dependency container";
        } else {
            str = JvmClassMappingKt.getJavaClass(type).getSimpleName() + " was requested, but it is not present";
        }
        throw new RuntimeException(str);
    }
}
