package S;

import androidx.work.impl.background.systemalarm.DelayMetCommandHandler;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f2341a;

    public /* synthetic */ a(DelayMetCommandHandler delayMetCommandHandler) {
        this.f2341a = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DelayMetCommandHandler.a(this.f2341a);
    }
}
