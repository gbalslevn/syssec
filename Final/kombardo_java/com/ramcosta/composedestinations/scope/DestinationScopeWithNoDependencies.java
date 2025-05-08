package com.ramcosta.composedestinations.scope;

import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/ramcosta/composedestinations/scope/DestinationScopeWithNoDependencies;", "T", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "getDestination", "()Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Landroidx/navigation/NavBackStackEntry;", "getNavBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "navController", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DestinationScopeWithNoDependencies<T> {
    TypedDestinationSpec<T> getDestination();

    NavBackStackEntry getNavBackStackEntry();

    NavController getNavController();
}
