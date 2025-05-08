package com.ramcosta.composedestinations.spec;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.spec.TypedNavHostGraphSpec;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/ramcosta/composedestinations/spec/DirectionNavHostGraphSpec;", "Lcom/ramcosta/composedestinations/spec/TypedNavHostGraphSpec;", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/spec/Direction;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DirectionNavHostGraphSpec extends TypedNavHostGraphSpec<Unit>, Direction {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static void argsFrom(DirectionNavHostGraphSpec directionNavHostGraphSpec, Bundle bundle) {
        }

        public static List<NamedNavArgument> getArguments(DirectionNavHostGraphSpec directionNavHostGraphSpec) {
            return TypedNavHostGraphSpec.DefaultImpls.getArguments(directionNavHostGraphSpec);
        }

        public static String getBaseRoute(DirectionNavHostGraphSpec directionNavHostGraphSpec) {
            return directionNavHostGraphSpec.getRoute();
        }

        public static List<NavDeepLink> getDeepLinks(DirectionNavHostGraphSpec directionNavHostGraphSpec) {
            return TypedNavHostGraphSpec.DefaultImpls.getDeepLinks(directionNavHostGraphSpec);
        }

        public static Unit getDefaultStartArgs(DirectionNavHostGraphSpec directionNavHostGraphSpec) {
            return Unit.INSTANCE;
        }

        public static Direction invoke(DirectionNavHostGraphSpec directionNavHostGraphSpec) {
            return directionNavHostGraphSpec;
        }

        public static void requireGraphArgs(DirectionNavHostGraphSpec directionNavHostGraphSpec, Bundle bundle) {
            TypedNavHostGraphSpec.DefaultImpls.requireGraphArgs(directionNavHostGraphSpec, bundle);
        }

        public static void argsFrom(DirectionNavHostGraphSpec directionNavHostGraphSpec, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        }

        public static Direction invoke(DirectionNavHostGraphSpec directionNavHostGraphSpec, Unit navArgs) {
            Intrinsics.checkNotNullParameter(navArgs, "navArgs");
            return directionNavHostGraphSpec;
        }

        public static void requireGraphArgs(DirectionNavHostGraphSpec directionNavHostGraphSpec, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            TypedNavHostGraphSpec.DefaultImpls.requireGraphArgs(directionNavHostGraphSpec, savedStateHandle);
        }

        public static Unit argsFrom(DirectionNavHostGraphSpec directionNavHostGraphSpec, NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
            return (Unit) TypedNavHostGraphSpec.DefaultImpls.argsFrom(directionNavHostGraphSpec, navBackStackEntry);
        }

        public static void requireGraphArgs(DirectionNavHostGraphSpec directionNavHostGraphSpec, NavBackStackEntry navBackStackEntry) {
            Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
            TypedNavHostGraphSpec.DefaultImpls.requireGraphArgs(directionNavHostGraphSpec, navBackStackEntry);
        }
    }
}
