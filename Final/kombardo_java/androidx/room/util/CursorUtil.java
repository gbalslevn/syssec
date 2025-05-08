package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0015\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Landroid/database/Cursor;", "c", "copyAndClose", "(Landroid/database/Cursor;)Landroid/database/Cursor;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "getColumnIndex", "(Landroid/database/Cursor;Ljava/lang/String;)I", "getColumnIndexOrThrow", "cursor", "findColumnIndexBySuffix", "room-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CursorUtil {
    public static final Cursor copyAndClose(Cursor c5) {
        Intrinsics.checkNotNullParameter(c5, "c");
        Cursor cursor = c5;
        try {
            Cursor cursor2 = cursor;
            MatrixCursor matrixCursor = new MatrixCursor(cursor2.getColumnNames(), cursor2.getCount());
            while (cursor2.moveToNext()) {
                Object[] objArr = new Object[cursor2.getColumnCount()];
                int columnCount = c5.getColumnCount();
                for (int i5 = 0; i5 < columnCount; i5++) {
                    int type = cursor2.getType(i5);
                    if (type == 0) {
                        objArr[i5] = null;
                    } else if (type == 1) {
                        objArr[i5] = Long.valueOf(cursor2.getLong(i5));
                    } else if (type == 2) {
                        objArr[i5] = Double.valueOf(cursor2.getDouble(i5));
                    } else if (type == 3) {
                        objArr[i5] = cursor2.getString(i5);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i5] = cursor2.getBlob(i5);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            CloseableKt.closeFinally(cursor, null);
            return matrixCursor;
        } finally {
        }
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        return -1;
    }

    public static final int getColumnIndex(Cursor c5, String name) {
        Intrinsics.checkNotNullParameter(c5, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int columnIndex = c5.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c5.getColumnIndex('`' + name + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c5, name);
    }

    public static final int getColumnIndexOrThrow(Cursor c5, String name) {
        String str;
        Intrinsics.checkNotNullParameter(c5, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int columnIndex = getColumnIndex(c5, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c5.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "c.columnNames");
            str = ArraysKt.joinToString$default(columnNames, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        } catch (Exception e5) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e5);
            str = "unknown";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + str);
    }
}
