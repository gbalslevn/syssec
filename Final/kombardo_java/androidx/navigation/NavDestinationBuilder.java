package androidx.navigation;

import android.support.v4.media.session.a;
import androidx.navigation.NavDestination;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B-\b\u0000\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bB#\b\u0016\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\"\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R&\u0010%\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010&R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u0012008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002030.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010&¨\u00065"}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavDestination;", "D", BuildConfig.FLAVOR, "Landroidx/navigation/Navigator;", "navigator", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "route", "<init>", "(Landroidx/navigation/Navigator;ILjava/lang/String;)V", "(Landroidx/navigation/Navigator;Ljava/lang/String;)V", "name", "Landroidx/navigation/NavArgument;", "argument", BuildConfig.FLAVOR, "(Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "Landroidx/navigation/NavDeepLink;", "navDeepLink", "deepLink", "(Landroidx/navigation/NavDeepLink;)V", "instantiateDestination", "()Landroidx/navigation/NavDestination;", "build", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "I", "getId", "()I", "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", BuildConfig.FLAVOR, "Lkotlin/reflect/KType;", "Landroidx/navigation/NavType;", "typeMap", "Ljava/util/Map;", BuildConfig.FLAVOR, "label", "Ljava/lang/CharSequence;", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", BuildConfig.FLAVOR, "arguments", BuildConfig.FLAVOR, "deepLinks", "Ljava/util/List;", "Landroidx/navigation/NavAction;", "actions", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NavDestinationBuilder<D extends NavDestination> {
    private Map<Integer, NavAction> actions;
    private Map<String, NavArgument> arguments;
    private List<NavDeepLink> deepLinks;
    private final int id;
    private CharSequence label;
    private final Navigator<? extends D> navigator;
    private final String route;
    private Map<KType, ? extends NavType<?>> typeMap;

    public NavDestinationBuilder(Navigator<? extends D> navigator, int i5, String str) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        this.navigator = navigator;
        this.id = i5;
        this.route = str;
        this.arguments = new LinkedHashMap();
        this.deepLinks = new ArrayList();
        this.actions = new LinkedHashMap();
    }

    public final void argument(String name, NavArgument argument) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argument, "argument");
        this.arguments.put(name, argument);
    }

    public D build() {
        D instantiateDestination = instantiateDestination();
        instantiateDestination.setLabel(this.label);
        for (Map.Entry<String, NavArgument> entry : this.arguments.entrySet()) {
            instantiateDestination.addArgument(entry.getKey(), entry.getValue());
        }
        Iterator<T> it = this.deepLinks.iterator();
        while (it.hasNext()) {
            instantiateDestination.addDeepLink((NavDeepLink) it.next());
        }
        for (Map.Entry<Integer, NavAction> entry2 : this.actions.entrySet()) {
            int intValue = entry2.getKey().intValue();
            a.a(entry2.getValue());
            instantiateDestination.putAction(intValue, null);
        }
        String str = this.route;
        if (str != null) {
            instantiateDestination.setRoute(str);
        }
        int i5 = this.id;
        if (i5 != -1) {
            instantiateDestination.setId(i5);
        }
        return instantiateDestination;
    }

    public final void deepLink(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "navDeepLink");
        this.deepLinks.add(navDeepLink);
    }

    public final String getRoute() {
        return this.route;
    }

    protected D instantiateDestination() {
        return this.navigator.createDestination();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDestinationBuilder(Navigator<? extends D> navigator, String str) {
        this(navigator, -1, str);
        Intrinsics.checkNotNullParameter(navigator, "navigator");
    }
}
