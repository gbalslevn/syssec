package androidx.lifecycle;

/* loaded from: classes.dex */
public class MutableLiveData<T> extends LiveData<T> {
    public MutableLiveData(T t5) {
        super(t5);
    }

    @Override // androidx.lifecycle.LiveData
    public void postValue(T t5) {
        super.postValue(t5);
    }

    @Override // androidx.lifecycle.LiveData
    public void setValue(T t5) {
        super.setValue(t5);
    }

    public MutableLiveData() {
    }
}
