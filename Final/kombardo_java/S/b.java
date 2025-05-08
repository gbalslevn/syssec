package S;

import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f2342a;

    public /* synthetic */ b(DelayMetCommandHandler delayMetCommandHandler) {
        this.f2342a = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2342a.startWork();
    }
}
