package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    /* loaded from: classes.dex */
    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) {
        Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    private Method getWriteMethod(Class cls) {
        Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class findParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = findParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }

    protected abstract void closeField();

    protected abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    protected abstract boolean readBoolean();

    public boolean readBoolean(boolean z5, int i5) {
        return !readField(i5) ? z5 : readBoolean();
    }

    protected abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i5) {
        return !readField(i5) ? bArr : readByteArray();
    }

    protected abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i5) {
        return !readField(i5) ? charSequence : readCharSequence();
    }

    protected abstract boolean readField(int i5);

    protected <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e8.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
        }
    }

    protected abstract int readInt();

    public int readInt(int i5, int i6) {
        return !readField(i6) ? i5 : readInt();
    }

    protected abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t5, int i5) {
        return !readField(i5) ? t5 : (T) readParcelable();
    }

    protected abstract String readString();

    public String readString(String str, int i5) {
        return !readField(i5) ? str : readString();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t5, int i5) {
        return !readField(i5) ? t5 : (T) readVersionedParcelable();
    }

    protected abstract void setOutputField(int i5);

    public void setSerializationFlags(boolean z5, boolean z6) {
    }

    protected abstract void writeBoolean(boolean z5);

    public void writeBoolean(boolean z5, int i5) {
        setOutputField(i5);
        writeBoolean(z5);
    }

    protected abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i5) {
        setOutputField(i5);
        writeByteArray(bArr);
    }

    protected abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i5) {
        setOutputField(i5);
        writeCharSequence(charSequence);
    }

    protected abstract void writeInt(int i5);

    public void writeInt(int i5, int i6) {
        setOutputField(i6);
        writeInt(i5);
    }

    protected abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i5) {
        setOutputField(i5);
        writeParcelable(parcelable);
    }

    protected abstract void writeString(String str);

    public void writeString(String str, int i5) {
        setOutputField(i5);
        writeString(str);
    }

    protected <T extends VersionedParcelable> void writeToParcel(T t5, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t5.getClass()).invoke(null, t5, versionedParcel);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (!(e8.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
            }
            throw ((RuntimeException) e8.getCause());
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i5) {
        setOutputField(i5);
        writeVersionedParcelable(versionedParcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) readFromParcel(readString, createSubParcel());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }
}
