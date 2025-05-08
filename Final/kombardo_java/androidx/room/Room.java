package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0004*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J?\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0004*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/Room;", BuildConfig.FLAVOR, "<init>", "()V", "T", "C", "Ljava/lang/Class;", "klass", BuildConfig.FLAVOR, "suffix", "getGeneratedImplementation", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroid/content/Context;", "context", "Landroidx/room/RoomDatabase$Builder;", "inMemoryDatabaseBuilder", "(Landroid/content/Context;Ljava/lang/Class;)Landroidx/room/RoomDatabase$Builder;", "name", "databaseBuilder", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)Landroidx/room/RoomDatabase$Builder;", "CURSOR_CONV_SUFFIX", "Ljava/lang/String;", "room-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final Room INSTANCE = new Room();

    private Room() {
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> klass, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (name == null || StringsKt.isBlank(name)) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        return new RoomDatabase.Builder<>(context, klass, name);
    }

    public static final <T, C> T getGeneratedImplementation(Class<C> klass, String suffix) {
        String str;
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        Package r02 = klass.getPackage();
        Intrinsics.checkNotNull(r02);
        String fullPackage = r02.getName();
        String canonicalName = klass.getCanonicalName();
        Intrinsics.checkNotNull(canonicalName);
        Intrinsics.checkNotNullExpressionValue(fullPackage, "fullPackage");
        if (fullPackage.length() != 0) {
            canonicalName = canonicalName.substring(fullPackage.length() + 1);
            Intrinsics.checkNotNullExpressionValue(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str2 = StringsKt.replace$default(canonicalName, '.', '_', false, 4, (Object) null) + suffix;
        try {
            if (fullPackage.length() == 0) {
                str = str2;
            } else {
                str = fullPackage + '.' + str2;
            }
            Class<?> cls = Class.forName(str, true, klass.getClassLoader());
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + str2 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + klass.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + klass.getCanonicalName());
        }
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> klass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return new RoomDatabase.Builder<>(context, klass, null);
    }
}
