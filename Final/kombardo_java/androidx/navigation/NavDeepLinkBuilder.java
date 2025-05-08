package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.TaskStackBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J%\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/navigation/NavController;", "navController", "(Landroidx/navigation/NavController;)V", BuildConfig.FLAVOR, "destId", "Landroidx/navigation/NavDestination;", "findDestination", "(I)Landroidx/navigation/NavDestination;", BuildConfig.FLAVOR, "verifyAllDestinations", "()V", "fillInIntent", "Landroid/os/Bundle;", "args", "setDestination", "(ILandroid/os/Bundle;)Landroidx/navigation/NavDeepLinkBuilder;", "addDestination", "setArguments", "(Landroid/os/Bundle;)Landroidx/navigation/NavDeepLinkBuilder;", "Landroidx/core/app/TaskStackBuilder;", "createTaskStackBuilder", "()Landroidx/core/app/TaskStackBuilder;", "Landroid/content/Context;", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Landroid/content/Intent;", "intent", "Landroid/content/Intent;", "Landroidx/navigation/NavGraph;", "graph", "Landroidx/navigation/NavGraph;", BuildConfig.FLAVOR, "Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "destinations", "Ljava/util/List;", "globalArgs", "Landroid/os/Bundle;", "DeepLinkDestination", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavDeepLinkBuilder {
    private final Activity activity;
    private final Context context;
    private final List<DeepLinkDestination> destinations;
    private Bundle globalArgs;
    private NavGraph graph;
    private final Intent intent;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", BuildConfig.FLAVOR, "destinationId", BuildConfig.FLAVOR, "arguments", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;)V", "getArguments", "()Landroid/os/Bundle;", "getDestinationId", "()I", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DeepLinkDestination {
        private final Bundle arguments;
        private final int destinationId;

        public DeepLinkDestination(int i5, Bundle bundle) {
            this.destinationId = i5;
            this.arguments = bundle;
        }

        public final Bundle getArguments() {
            return this.arguments;
        }

        public final int getDestinationId() {
            return this.destinationId;
        }
    }

    public NavDeepLinkBuilder(Context context) {
        Intent launchIntentForPackage;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Activity activity = (Activity) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(context, new Function1<Context, Context>() { // from class: androidx.navigation.NavDeepLinkBuilder$activity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ContextWrapper contextWrapper = it instanceof ContextWrapper ? (ContextWrapper) it : null;
                if (contextWrapper != null) {
                    return contextWrapper.getBaseContext();
                }
                return null;
            }
        }), new Function1<Context, Activity>() { // from class: androidx.navigation.NavDeepLinkBuilder$activity$2
            @Override // kotlin.jvm.functions.Function1
            public final Activity invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it instanceof Activity) {
                    return (Activity) it;
                }
                return null;
            }
        }));
        this.activity = activity;
        if (activity != null) {
            launchIntentForPackage = new Intent(context, activity.getClass());
        } else {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                launchIntentForPackage = new Intent();
            }
        }
        launchIntentForPackage.addFlags(268468224);
        this.intent = launchIntentForPackage;
        this.destinations = new ArrayList();
    }

    private final void fillInIntent() {
        ArrayList arrayList = new ArrayList();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        NavDestination navDestination = null;
        for (DeepLinkDestination deepLinkDestination : this.destinations) {
            int destinationId = deepLinkDestination.getDestinationId();
            Bundle arguments = deepLinkDestination.getArguments();
            NavDestination findDestination = findDestination(destinationId);
            if (findDestination == null) {
                throw new IllegalArgumentException("Navigation destination " + NavDestination.INSTANCE.getDisplayName(this.context, destinationId) + " cannot be found in the navigation graph " + this.graph);
            }
            for (int i5 : findDestination.buildDeepLinkIds(navDestination)) {
                arrayList.add(Integer.valueOf(i5));
                arrayList2.add(arguments);
            }
            navDestination = findDestination;
        }
        this.intent.putExtra("android-support-nav:controller:deepLinkIds", CollectionsKt.toIntArray(arrayList));
        this.intent.putParcelableArrayListExtra("android-support-nav:controller:deepLinkArgs", arrayList2);
    }

    private final NavDestination findDestination(int destId) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this.graph;
        Intrinsics.checkNotNull(navGraph);
        arrayDeque.add(navGraph);
        while (!arrayDeque.isEmpty()) {
            NavDestination navDestination = (NavDestination) arrayDeque.removeFirst();
            if (navDestination.getId() == destId) {
                return navDestination;
            }
            if (navDestination instanceof NavGraph) {
                Iterator<NavDestination> it = ((NavGraph) navDestination).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        return null;
    }

    public static /* synthetic */ NavDeepLinkBuilder setDestination$default(NavDeepLinkBuilder navDeepLinkBuilder, int i5, Bundle bundle, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            bundle = null;
        }
        return navDeepLinkBuilder.setDestination(i5, bundle);
    }

    private final void verifyAllDestinations() {
        Iterator<DeepLinkDestination> it = this.destinations.iterator();
        while (it.hasNext()) {
            int destinationId = it.next().getDestinationId();
            if (findDestination(destinationId) == null) {
                throw new IllegalArgumentException("Navigation destination " + NavDestination.INSTANCE.getDisplayName(this.context, destinationId) + " cannot be found in the navigation graph " + this.graph);
            }
        }
    }

    public final NavDeepLinkBuilder addDestination(int destId, Bundle args) {
        this.destinations.add(new DeepLinkDestination(destId, args));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    public final TaskStackBuilder createTaskStackBuilder() {
        if (this.graph == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link");
        }
        if (this.destinations.isEmpty()) {
            throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link");
        }
        fillInIntent();
        TaskStackBuilder addNextIntentWithParentStack = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(new Intent(this.intent));
        Intrinsics.checkNotNullExpressionValue(addNextIntentWithParentStack, "create(context).addNextI…rentStack(Intent(intent))");
        int intentCount = addNextIntentWithParentStack.getIntentCount();
        for (int i5 = 0; i5 < intentCount; i5++) {
            Intent editIntentAt = addNextIntentWithParentStack.editIntentAt(i5);
            if (editIntentAt != null) {
                editIntentAt.putExtra("android-support-nav:controller:deepLinkIntent", this.intent);
            }
        }
        return addNextIntentWithParentStack;
    }

    public final NavDeepLinkBuilder setArguments(Bundle args) {
        this.globalArgs = args;
        this.intent.putExtra("android-support-nav:controller:deepLinkExtras", args);
        return this;
    }

    public final NavDeepLinkBuilder setDestination(int destId, Bundle args) {
        this.destinations.clear();
        this.destinations.add(new DeepLinkDestination(destId, args));
        if (this.graph != null) {
            verifyAllDestinations();
        }
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDeepLinkBuilder(NavController navController) {
        this(navController.getContext());
        Intrinsics.checkNotNullParameter(navController, "navController");
        this.graph = navController.getGraph();
    }
}
