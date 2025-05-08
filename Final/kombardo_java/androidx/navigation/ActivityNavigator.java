package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.navigation.Navigator;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.conscrypt.BuildConfig;

@Navigator.Name("activity")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Landroidx/navigation/ActivityNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/ActivityNavigator$Destination;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "createDestination", "()Landroidx/navigation/ActivityNavigator$Destination;", BuildConfig.FLAVOR, "popBackStack", "()Z", "destination", "Landroid/os/Bundle;", "args", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Landroidx/navigation/NavDestination;", "navigate", "(Landroidx/navigation/ActivityNavigator$Destination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "hostActivity", "Landroid/app/Activity;", "Companion", "Destination", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class ActivityNavigator extends Navigator<Destination> {
    private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";
    private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";
    private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";
    private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";
    private static final String LOG_TAG = "ActivityNavigator";
    private final Context context;
    private final Activity hostActivity;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR(\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t8F@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u000bR(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001e8F@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R(\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t8F@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u000bR(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0014\u001a\u0004\u0018\u00010%8F@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Landroidx/navigation/ActivityNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/Navigator;", "activityNavigator", "<init>", "(Landroidx/navigation/Navigator;)V", BuildConfig.FLAVOR, "supportsActions", "()Z", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "Landroid/content/Intent;", "<set-?>", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "dataPattern", "Ljava/lang/String;", "getDataPattern", "targetPackage", "getTargetPackage", "Landroid/content/ComponentName;", "component", "Landroid/content/ComponentName;", "getComponent", "()Landroid/content/ComponentName;", "action", "getAction", "Landroid/net/Uri;", "data", "Landroid/net/Uri;", "getData", "()Landroid/net/Uri;", "navigation-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class Destination extends NavDestination {
        private String action;
        private ComponentName component;
        private Uri data;
        private String dataPattern;
        private Intent intent;
        private String targetPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> activityNavigator) {
            super(activityNavigator);
            Intrinsics.checkNotNullParameter(activityNavigator, "activityNavigator");
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !(other instanceof Destination)) {
                return false;
            }
            if (super.equals(other)) {
                Intent intent = this.intent;
                if ((intent != null ? intent.filterEquals(((Destination) other).intent) : ((Destination) other).intent == null) && Intrinsics.areEqual(this.dataPattern, ((Destination) other).dataPattern)) {
                    return true;
                }
            }
            return false;
        }

        public final String getAction() {
            Intent intent = this.intent;
            if (intent != null) {
                return intent.getAction();
            }
            return null;
        }

        public final ComponentName getComponent() {
            Intent intent = this.intent;
            if (intent != null) {
                return intent.getComponent();
            }
            return null;
        }

        public final String getDataPattern() {
            return this.dataPattern;
        }

        public final Intent getIntent() {
            return this.intent;
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int hashCode = super.hashCode() * 31;
            Intent intent = this.intent;
            int filterHashCode = (hashCode + (intent != null ? intent.filterHashCode() : 0)) * 31;
            String str = this.dataPattern;
            return filterHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // androidx.navigation.NavDestination
        public boolean supportsActions() {
            return false;
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            ComponentName component = getComponent();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                String action = getAction();
                if (action != null) {
                    sb.append(" action=");
                    sb.append(action);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        }
    }

    public ActivityNavigator(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Iterator it = SequencesKt.generateSequence(context, new Function1<Context, Context>() { // from class: androidx.navigation.ActivityNavigator$hostActivity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2 instanceof ContextWrapper) {
                    return ((ContextWrapper) it2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Context) obj) instanceof Activity) {
                    break;
                }
            }
        }
        this.hostActivity = (Activity) obj;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.navigation.Navigator
    public Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public NavDestination navigate(Destination destination, Bundle args, NavOptions navOptions, Navigator.Extras navigatorExtras) {
        Intent intent;
        int intExtra;
        String encode;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.getIntent() != null) {
            Intent intent2 = new Intent(destination.getIntent());
            if (args != null) {
                intent2.putExtras(args);
                String dataPattern = destination.getDataPattern();
                if (dataPattern != null && dataPattern.length() != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(dataPattern);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (args.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, BuildConfig.FLAVOR);
                            Map<String, NavArgument> arguments = destination.getArguments();
                            Intrinsics.checkNotNull(group);
                            NavArgument navArgument = arguments.get(group);
                            NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                            if (type == null || (encode = type.serializeAsValue(type.get(args, group))) == null) {
                                encode = Uri.encode(String.valueOf(args.get(group)));
                            }
                            stringBuffer.append(encode);
                        } else {
                            throw new IllegalArgumentException(("Could not find " + group + " in " + args + " to fill data pattern " + dataPattern).toString());
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            if (this.hostActivity == null) {
                intent2.addFlags(268435456);
            }
            if (navOptions != null && navOptions.getSingleTop()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.hostActivity;
            if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra(EXTRA_NAV_CURRENT, 0)) != 0) {
                intent2.putExtra(EXTRA_NAV_SOURCE, intExtra);
            }
            intent2.putExtra(EXTRA_NAV_CURRENT, destination.getId());
            Resources resources = this.context.getResources();
            if (navOptions != null) {
                int popEnterAnim = navOptions.getPopEnterAnim();
                int popExitAnim = navOptions.getPopExitAnim();
                if ((popEnterAnim > 0 && Intrinsics.areEqual(resources.getResourceTypeName(popEnterAnim), "animator")) || (popExitAnim > 0 && Intrinsics.areEqual(resources.getResourceTypeName(popExitAnim), "animator"))) {
                    Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(popEnterAnim) + " and popExit resource " + resources.getResourceName(popExitAnim) + " when launching " + destination);
                } else {
                    intent2.putExtra(EXTRA_POP_ENTER_ANIM, popEnterAnim);
                    intent2.putExtra(EXTRA_POP_EXIT_ANIM, popExitAnim);
                }
            }
            this.context.startActivity(intent2);
            if (navOptions != null && this.hostActivity != null) {
                int enterAnim = navOptions.getEnterAnim();
                int exitAnim = navOptions.getExitAnim();
                if ((enterAnim > 0 && Intrinsics.areEqual(resources.getResourceTypeName(enterAnim), "animator")) || (exitAnim > 0 && Intrinsics.areEqual(resources.getResourceTypeName(exitAnim), "animator"))) {
                    Log.w(LOG_TAG, "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(enterAnim) + " and exit resource " + resources.getResourceName(exitAnim) + "when launching " + destination);
                } else if (enterAnim >= 0 || exitAnim >= 0) {
                    this.hostActivity.overridePendingTransition(RangesKt.coerceAtLeast(enterAnim, 0), RangesKt.coerceAtLeast(exitAnim, 0));
                }
            }
            return null;
        }
        throw new IllegalStateException(("Destination " + destination.getId() + " does not have an Intent set.").toString());
    }
}
