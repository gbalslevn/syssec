package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {
    private final Activity mActivity;
    private final Context mContext;
    final FragmentManager mFragmentManager;
    private final Handler mHandler;
    private final int mWindowAnimations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity getActivity() {
        return this.mActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public abstract void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract E onGetHost();

    public abstract LayoutInflater onGetLayoutInflater();

    public void onStartActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i5, Bundle bundle) {
        if (i5 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        ContextCompat.startActivity(this.mContext, intent, bundle);
    }

    public abstract void onSupportInvalidateOptionsMenu();

    FragmentHostCallback(Activity activity, Context context, Handler handler, int i5) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = activity;
        this.mContext = (Context) Preconditions.checkNotNull(context, "context == null");
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "handler == null");
        this.mWindowAnimations = i5;
    }
}
