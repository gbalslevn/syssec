package com.ramcosta.composedestinations.spec;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import com.ramcosta.composedestinations.animations.NavHostAnimatedDestinationStyle;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCalls;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001*J3\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002\"\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003H'¢\u0006\u0004\b\u0007\u0010\bJK\u0010\u0016\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H'¢\u0006\u0004\b\u0016\u0010\u0017JC\u0010\u001d\u001a\u00020\u0014*\u00020\u00132\u0012\u0010\u001a\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H&¢\u0006\u0004\b\u001d\u0010\u001eJO\u0010$\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u001f*\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u0011\u001a\u00020\u00062\u0016\u0010#\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/ramcosta/composedestinations/spec/NavHostEngine;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "navigators", "Landroidx/navigation/NavHostController;", "rememberNavController", "([Landroidx/navigation/Navigator;Landroidx/compose/runtime/Composer;I)Landroidx/navigation/NavHostController;", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "route", "Lcom/ramcosta/composedestinations/spec/Direction;", "start", "Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;", "defaultTransitions", "navController", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", BuildConfig.FLAVOR, "builder", "NavHost", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/ramcosta/composedestinations/spec/Direction;Lcom/ramcosta/composedestinations/animations/NavHostAnimatedDestinationStyle;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;", "Lcom/ramcosta/composedestinations/spec/NavGraphSpec;", "navGraph", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "manualComposableCalls", "navigation", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/TypedNavGraphSpec;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;Lkotlin/jvm/functions/Function1;)V", "T", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "destination", "Lcom/ramcosta/composedestinations/navigation/DependenciesContainerBuilder;", "dependenciesContainerBuilder", "composable", "(Landroidx/navigation/NavGraphBuilder;Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;Landroidx/navigation/NavHostController;Lkotlin/jvm/functions/Function3;Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;)V", "Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", "getType", "()Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", "type", "Type", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NavHostEngine {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ramcosta/composedestinations/spec/NavHostEngine$Type;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "WEAR", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type DEFAULT = new Type("DEFAULT", 0);
        public static final Type WEAR = new Type("WEAR", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DEFAULT, WEAR};
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Type(String str, int i5) {
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    void NavHost(Modifier modifier, String str, Direction direction, NavHostAnimatedDestinationStyle navHostAnimatedDestinationStyle, NavHostController navHostController, Function1<? super NavGraphBuilder, Unit> function1, Composer composer, int i5);

    <T> void composable(NavGraphBuilder navGraphBuilder, TypedDestinationSpec<T> typedDestinationSpec, NavHostController navHostController, Function3<? super DependenciesContainerBuilder<?>, ? super Composer, ? super Integer, Unit> function3, ManualComposableCalls manualComposableCalls);

    Type getType();

    void navigation(NavGraphBuilder navGraphBuilder, TypedNavGraphSpec<?, ?> typedNavGraphSpec, ManualComposableCalls manualComposableCalls, Function1<? super NavGraphBuilder, Unit> function1);

    NavHostController rememberNavController(Navigator<? extends NavDestination>[] navigatorArr, Composer composer, int i5);
}
