package uniffi.molslinjen_shared;

import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import dk.molslinjen.domain.model.constants.Constants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.ForeignBytes;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bA\b`\u0018\u0000 ½\u00012\u00020\u0001:\u0002½\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010&\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u00105\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u00109\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010:\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010;\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010>\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010?\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010@\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010B\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010C\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J \u0010D\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H&J\u0018\u0010E\u001a\u00020\"2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010I\u001a\u00020\"2\u0006\u0010J\u001a\u00020K2\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010L\u001a\u00020\"2\u0006\u0010H\u001a\u00020\"2\u0006\u0010M\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010N\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010P\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010Q\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010R\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010S\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010T\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010U\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010V\u001a\u00020 2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010W\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010X\u001a\u00020 2\u0006\u0010Y\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010Z\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010[\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\\\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010]\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010^\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010_\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010`\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010a\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010b\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010c\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010d\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010e\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010g\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010h\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010i\u001a\u00020\u00032\u0006\u0010j\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010m\u001a\u00020\u00032\u0006\u0010n\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010o\u001a\u00020\u00032\u0006\u0010p\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010q\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010r\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010s\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J \u0010t\u001a\u00020\u00032\u0006\u0010u\u001a\u00020 2\u0006\u0010v\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010w\u001a\u00020\u00032\u0006\u0010x\u001a\u00020yH&J\u0010\u0010z\u001a\u00020\u00032\u0006\u0010x\u001a\u00020{H&J\u0010\u0010|\u001a\u00020\u00032\u0006\u0010x\u001a\u00020}H&J3\u0010~\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010\u007f\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020\"2\u0007\u0010\u0081\u0001\u001a\u00020\"2\u0007\u0010\u0082\u0001\u001a\u00020\"H&J+\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010\u007f\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020\"2\u0007\u0010\u0084\u0001\u001a\u00020\u0005H&J=\u0010\u0085\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010\u007f\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020\"2\u0007\u0010\u0088\u0001\u001a\u00020\"H&J+\u0010\u0089\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010\u007f\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020\"H&J\"\u0010\u008a\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010\u007f\u001a\u00020\"2\u0007\u0010\u0080\u0001\u001a\u00020\"H&J\"\u0010\u008b\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010\u008c\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\"\u0010\u008d\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010\u008e\u0001\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u008f\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u0090\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\"\u0010\u0091\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010\u008e\u0001\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u0092\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\"\u0010\u0093\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010\u0094\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u0095\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u0096\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u0097\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&JP\u0010\u0098\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0007\u0010\u0099\u0001\u001a\u00020\u00052\u0007\u0010\u009a\u0001\u001a\u00020\u00052\u0007\u0010\u009b\u0001\u001a\u00020\"2\u0007\u0010\u009c\u0001\u001a\u00020\"2\u0007\u0010\u009d\u0001\u001a\u00020\"2\u0007\u0010\u009e\u0001\u001a\u00020\"2\u0007\u0010\u009f\u0001\u001a\u00020\"H&J\u0019\u0010 \u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H&JF\u0010¡\u0001\u001a\u00020\u00032\u0006\u0010O\u001a\u00020 2\u0007\u0010¢\u0001\u001a\u00020\"2\u0007\u0010£\u0001\u001a\u00020\"2\u0007\u0010¤\u0001\u001a\u00020\"2\u0007\u0010¥\u0001\u001a\u00020\"2\u0007\u0010¦\u0001\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J5\u0010§\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0007\u0010¨\u0001\u001a\u00020\"2\u0007\u0010©\u0001\u001a\u00020\"2\u0007\u0010ª\u0001\u001a\u00020\"2\u0007\u0010«\u0001\u001a\u00020\"H&J#\u0010¬\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0007\u0010¨\u0001\u001a\u00020\"2\u0007\u0010\u00ad\u0001\u001a\u00020\"H&J\u001a\u0010®\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0007\u0010¯\u0001\u001a\u00020\"H&J#\u0010°\u0001\u001a\u00020\u00052\u0006\u0010O\u001a\u00020 2\u0007\u0010¯\u0001\u001a\u00020\"2\u0007\u0010\u00ad\u0001\u001a\u00020\"H&J+\u0010±\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010²\u0001\u001a\u00020\"2\u0007\u0010³\u0001\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J+\u0010´\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010²\u0001\u001a\u00020\"2\u0007\u0010³\u0001\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J+\u0010µ\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010²\u0001\u001a\u00020\"2\u0007\u0010³\u0001\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u0015H&J+\u0010¶\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010·\u0001\u001a\u00020\"2\u0007\u0010¸\u0001\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H&J4\u0010¹\u0001\u001a\u00020\"2\u0006\u0010O\u001a\u00020 2\u0007\u0010º\u0001\u001a\u00020\"2\u0007\u0010»\u0001\u001a\u00020\u00172\u0007\u0010¼\u0001\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006¾\u0001"}, d2 = {"Luniffi/molslinjen_shared/UniffiLib;", "Lcom/sun/jna/Library;", "ffi_molslinjen_shared_rust_future_cancel_f32", BuildConfig.FLAVOR, "handle", BuildConfig.FLAVOR, "ffi_molslinjen_shared_rust_future_cancel_f64", "ffi_molslinjen_shared_rust_future_cancel_i16", "ffi_molslinjen_shared_rust_future_cancel_i32", "ffi_molslinjen_shared_rust_future_cancel_i64", "ffi_molslinjen_shared_rust_future_cancel_i8", "ffi_molslinjen_shared_rust_future_cancel_pointer", "ffi_molslinjen_shared_rust_future_cancel_rust_buffer", "ffi_molslinjen_shared_rust_future_cancel_u16", "ffi_molslinjen_shared_rust_future_cancel_u32", "ffi_molslinjen_shared_rust_future_cancel_u64", "ffi_molslinjen_shared_rust_future_cancel_u8", "ffi_molslinjen_shared_rust_future_cancel_void", "ffi_molslinjen_shared_rust_future_complete_f32", BuildConfig.FLAVOR, "uniffi_out_err", "Luniffi/molslinjen_shared/UniffiRustCallStatus;", "ffi_molslinjen_shared_rust_future_complete_f64", BuildConfig.FLAVOR, "ffi_molslinjen_shared_rust_future_complete_i16", BuildConfig.FLAVOR, "ffi_molslinjen_shared_rust_future_complete_i32", BuildConfig.FLAVOR, "ffi_molslinjen_shared_rust_future_complete_i64", "ffi_molslinjen_shared_rust_future_complete_i8", BuildConfig.FLAVOR, "ffi_molslinjen_shared_rust_future_complete_pointer", "Lcom/sun/jna/Pointer;", "ffi_molslinjen_shared_rust_future_complete_rust_buffer", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "ffi_molslinjen_shared_rust_future_complete_u16", "ffi_molslinjen_shared_rust_future_complete_u32", "ffi_molslinjen_shared_rust_future_complete_u64", "ffi_molslinjen_shared_rust_future_complete_u8", "ffi_molslinjen_shared_rust_future_complete_void", "ffi_molslinjen_shared_rust_future_free_f32", "ffi_molslinjen_shared_rust_future_free_f64", "ffi_molslinjen_shared_rust_future_free_i16", "ffi_molslinjen_shared_rust_future_free_i32", "ffi_molslinjen_shared_rust_future_free_i64", "ffi_molslinjen_shared_rust_future_free_i8", "ffi_molslinjen_shared_rust_future_free_pointer", "ffi_molslinjen_shared_rust_future_free_rust_buffer", "ffi_molslinjen_shared_rust_future_free_u16", "ffi_molslinjen_shared_rust_future_free_u32", "ffi_molslinjen_shared_rust_future_free_u64", "ffi_molslinjen_shared_rust_future_free_u8", "ffi_molslinjen_shared_rust_future_free_void", "ffi_molslinjen_shared_rust_future_poll_f32", Callback.METHOD_NAME, "Luniffi/molslinjen_shared/UniffiRustFutureContinuationCallback;", "callbackData", "ffi_molslinjen_shared_rust_future_poll_f64", "ffi_molslinjen_shared_rust_future_poll_i16", "ffi_molslinjen_shared_rust_future_poll_i32", "ffi_molslinjen_shared_rust_future_poll_i64", "ffi_molslinjen_shared_rust_future_poll_i8", "ffi_molslinjen_shared_rust_future_poll_pointer", "ffi_molslinjen_shared_rust_future_poll_rust_buffer", "ffi_molslinjen_shared_rust_future_poll_u16", "ffi_molslinjen_shared_rust_future_poll_u32", "ffi_molslinjen_shared_rust_future_poll_u64", "ffi_molslinjen_shared_rust_future_poll_u8", "ffi_molslinjen_shared_rust_future_poll_void", "ffi_molslinjen_shared_rustbuffer_alloc", "size", "ffi_molslinjen_shared_rustbuffer_free", "buf", "ffi_molslinjen_shared_rustbuffer_from_bytes", "bytes", "Luniffi/molslinjen_shared/ForeignBytes$ByValue;", "ffi_molslinjen_shared_rustbuffer_reserve", "additional", "uniffi_molslinjen_shared_fn_clone_agillichandler", "ptr", "uniffi_molslinjen_shared_fn_clone_amountwrapper", "uniffi_molslinjen_shared_fn_clone_apiauthenticationbridge", "uniffi_molslinjen_shared_fn_clone_departurelowpricehandler", "uniffi_molslinjen_shared_fn_clone_requestparametersbridge", "uniffi_molslinjen_shared_fn_clone_rustloggertrait", "uniffi_molslinjen_shared_fn_clone_selectseatinghandler", "uniffi_molslinjen_shared_fn_clone_selectseatinghelper", "uniffi_molslinjen_shared_fn_constructor_agillichandler_new", "uniffi_molslinjen_shared_fn_constructor_amountwrapper_new", "defaultAmount", "uniffi_molslinjen_shared_fn_constructor_departurelowpricehandler_new", "uniffi_molslinjen_shared_fn_constructor_selectseatinghandler_new", "uniffi_molslinjen_shared_fn_constructor_selectseatinghelper_new", "uniffi_molslinjen_shared_fn_free_agillichandler", "uniffi_molslinjen_shared_fn_free_amountwrapper", "uniffi_molslinjen_shared_fn_free_apiauthenticationbridge", "uniffi_molslinjen_shared_fn_free_departurelowpricehandler", "uniffi_molslinjen_shared_fn_free_requestparametersbridge", "uniffi_molslinjen_shared_fn_free_rustloggertrait", "uniffi_molslinjen_shared_fn_free_selectseatinghandler", "uniffi_molslinjen_shared_fn_free_selectseatinghelper", "uniffi_molslinjen_shared_fn_func_constants_api_set_agillic_base_url", "newUrl", "uniffi_molslinjen_shared_fn_func_constants_api_set_molslinjen_base_url", "uniffi_molslinjen_shared_fn_func_ffi_configuration_manager", "uniffi_molslinjen_shared_fn_func_ffi_initialize_api_authentication_bridge", "apiAuthenticationBridge", "uniffi_molslinjen_shared_fn_func_ffi_initialize_configuration", "config", "uniffi_molslinjen_shared_fn_func_ffi_initialize_request_parameters_bridge", "requestParametersBridge", "uniffi_molslinjen_shared_fn_func_ffi_set_global_proxy_usage", "useProxy", "uniffi_molslinjen_shared_fn_func_mock_amount", "uniffi_molslinjen_shared_fn_func_mock_ferry_seat", "uniffi_molslinjen_shared_fn_func_mock_ferry_seating_section", "uniffi_molslinjen_shared_fn_func_set_rust_logger", "logger", "maxLevel", "uniffi_molslinjen_shared_fn_init_callback_vtable_apiauthenticationbridge", "vtable", "Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceApiAuthenticationBridge;", "uniffi_molslinjen_shared_fn_init_callback_vtable_requestparametersbridge", "Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRequestParametersBridge;", "uniffi_molslinjen_shared_fn_init_callback_vtable_rustloggertrait", "Luniffi/molslinjen_shared/UniffiVTableCallbackInterfaceRustLoggerTrait;", "uniffi_molslinjen_shared_fn_method_agillichandler_feedback", "email", "clientAppId", Constants.IntentExtra.ReportId, "feedbackStatus", "uniffi_molslinjen_shared_fn_method_agillichandler_give_consent", "validUntil", "uniffi_molslinjen_shared_fn_method_agillichandler_register", "appInstallationId", "pushNotificationToken", "consent", "uniffi_molslinjen_shared_fn_method_agillichandler_unregister", "uniffi_molslinjen_shared_fn_method_agillichandler_withdraw_consent", "uniffi_molslinjen_shared_fn_method_amountwrapper_add_charge", "count", "uniffi_molslinjen_shared_fn_method_amountwrapper_adding", "other", "uniffi_molslinjen_shared_fn_method_amountwrapper_charge_count", "uniffi_molslinjen_shared_fn_method_amountwrapper_currency", "uniffi_molslinjen_shared_fn_method_amountwrapper_ensure_above", "uniffi_molslinjen_shared_fn_method_amountwrapper_monetary_amount", "uniffi_molslinjen_shared_fn_method_amountwrapper_multiplied_by", "multiplier", "uniffi_molslinjen_shared_fn_method_amountwrapper_negation", "uniffi_molslinjen_shared_fn_method_amountwrapper_remove_charges", "uniffi_molslinjen_shared_fn_method_apiauthenticationbridge_current_agillic_authentication", "uniffi_molslinjen_shared_fn_method_departurelowpricehandler_get_lowest_prices", "pricesFromDate", "pricesToDate", "currencyType", "transportId", "departureRegionId", "departureRouteId", "siteId", "uniffi_molslinjen_shared_fn_method_requestparametersbridge_language", "uniffi_molslinjen_shared_fn_method_rustloggertrait_log", "level", "message", "path", "file", "line", "uniffi_molslinjen_shared_fn_method_selectseatinghandler_get_floor_plan", "departureId", "ferryName", "currency", "reservedSeats", "uniffi_molslinjen_shared_fn_method_selectseatinghandler_reserve_seats", "seatIds", "uniffi_molslinjen_shared_fn_method_selectseatinghandler_un_reserve_seats", "seatReservationId", "uniffi_molslinjen_shared_fn_method_selectseatinghandler_update_reserved_seats", "uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat", "floorPlan", "seatId", "uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat_group", "uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_section", "uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_details", "section", "targetSeatSize", "uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_overview", "sections", "targetWidth", "targetHeight", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface UniffiLib extends Library {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/UniffiLib$Companion;", BuildConfig.FLAVOR, "()V", "CLEANER", "Luniffi/molslinjen_shared/UniffiCleaner;", "getCLEANER$shared_release", "()Luniffi/molslinjen_shared/UniffiCleaner;", "CLEANER$delegate", "Lkotlin/Lazy;", "INSTANCE", "Luniffi/molslinjen_shared/UniffiLib;", "getINSTANCE$shared_release", "()Luniffi/molslinjen_shared/UniffiLib;", "INSTANCE$delegate", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: INSTANCE$delegate, reason: from kotlin metadata */
        private static final Lazy<UniffiLib> INSTANCE = LazyKt.lazy(new Function0<UniffiLib>() { // from class: uniffi.molslinjen_shared.UniffiLib$Companion$INSTANCE$2
            @Override // kotlin.jvm.functions.Function0
            public final UniffiLib invoke() {
                Library load = Native.load(Molslinjen_sharedKt.findLibraryName("molslinjen_shared"), (Class<Library>) IntegrityCheckingUniffiLib.class);
                Intrinsics.checkNotNullExpressionValue(load, "load(...)");
                IntegrityCheckingUniffiLib integrityCheckingUniffiLib = (IntegrityCheckingUniffiLib) load;
                Molslinjen_sharedKt.uniffiCheckContractApiVersion(integrityCheckingUniffiLib);
                Molslinjen_sharedKt.uniffiCheckApiChecksums(integrityCheckingUniffiLib);
                Library load2 = Native.load(Molslinjen_sharedKt.findLibraryName("molslinjen_shared"), (Class<Library>) UniffiLib.class);
                Intrinsics.checkNotNullExpressionValue(load2, "load(...)");
                UniffiLib uniffiLib = (UniffiLib) load2;
                uniffiCallbackInterfaceApiAuthenticationBridge.INSTANCE.register$shared_release(uniffiLib);
                uniffiCallbackInterfaceRequestParametersBridge.INSTANCE.register$shared_release(uniffiLib);
                uniffiCallbackInterfaceRustLoggerTrait.INSTANCE.register$shared_release(uniffiLib);
                return uniffiLib;
            }
        });

        /* renamed from: CLEANER$delegate, reason: from kotlin metadata */
        private static final Lazy<UniffiCleaner> CLEANER = LazyKt.lazy(new Function0<UniffiCleaner>() { // from class: uniffi.molslinjen_shared.UniffiLib$Companion$CLEANER$2
            @Override // kotlin.jvm.functions.Function0
            public final UniffiCleaner invoke() {
                UniffiCleaner create;
                create = Molslinjen_sharedKt.create(UniffiCleaner.INSTANCE);
                return create;
            }
        });

        private Companion() {
        }

        public final UniffiCleaner getCLEANER$shared_release() {
            return CLEANER.getValue();
        }

        public final UniffiLib getINSTANCE$shared_release() {
            return INSTANCE.getValue();
        }
    }

    void ffi_molslinjen_shared_rust_future_cancel_f32(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_f64(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_i16(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_i32(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_i64(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_i8(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_pointer(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_rust_buffer(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_u16(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_u32(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_u64(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_u8(long handle);

    void ffi_molslinjen_shared_rust_future_cancel_void(long handle);

    float ffi_molslinjen_shared_rust_future_complete_f32(long handle, UniffiRustCallStatus uniffi_out_err);

    double ffi_molslinjen_shared_rust_future_complete_f64(long handle, UniffiRustCallStatus uniffi_out_err);

    short ffi_molslinjen_shared_rust_future_complete_i16(long handle, UniffiRustCallStatus uniffi_out_err);

    int ffi_molslinjen_shared_rust_future_complete_i32(long handle, UniffiRustCallStatus uniffi_out_err);

    long ffi_molslinjen_shared_rust_future_complete_i64(long handle, UniffiRustCallStatus uniffi_out_err);

    byte ffi_molslinjen_shared_rust_future_complete_i8(long handle, UniffiRustCallStatus uniffi_out_err);

    Pointer ffi_molslinjen_shared_rust_future_complete_pointer(long handle, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue ffi_molslinjen_shared_rust_future_complete_rust_buffer(long handle, UniffiRustCallStatus uniffi_out_err);

    short ffi_molslinjen_shared_rust_future_complete_u16(long handle, UniffiRustCallStatus uniffi_out_err);

    int ffi_molslinjen_shared_rust_future_complete_u32(long handle, UniffiRustCallStatus uniffi_out_err);

    long ffi_molslinjen_shared_rust_future_complete_u64(long handle, UniffiRustCallStatus uniffi_out_err);

    byte ffi_molslinjen_shared_rust_future_complete_u8(long handle, UniffiRustCallStatus uniffi_out_err);

    void ffi_molslinjen_shared_rust_future_complete_void(long handle, UniffiRustCallStatus uniffi_out_err);

    void ffi_molslinjen_shared_rust_future_free_f32(long handle);

    void ffi_molslinjen_shared_rust_future_free_f64(long handle);

    void ffi_molslinjen_shared_rust_future_free_i16(long handle);

    void ffi_molslinjen_shared_rust_future_free_i32(long handle);

    void ffi_molslinjen_shared_rust_future_free_i64(long handle);

    void ffi_molslinjen_shared_rust_future_free_i8(long handle);

    void ffi_molslinjen_shared_rust_future_free_pointer(long handle);

    void ffi_molslinjen_shared_rust_future_free_rust_buffer(long handle);

    void ffi_molslinjen_shared_rust_future_free_u16(long handle);

    void ffi_molslinjen_shared_rust_future_free_u32(long handle);

    void ffi_molslinjen_shared_rust_future_free_u64(long handle);

    void ffi_molslinjen_shared_rust_future_free_u8(long handle);

    void ffi_molslinjen_shared_rust_future_free_void(long handle);

    void ffi_molslinjen_shared_rust_future_poll_f32(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_f64(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_i16(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_i32(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_i64(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_i8(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_pointer(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_rust_buffer(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_u16(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_u32(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_u64(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_u8(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    void ffi_molslinjen_shared_rust_future_poll_void(long handle, UniffiRustFutureContinuationCallback callback, long callbackData);

    RustBuffer.ByValue ffi_molslinjen_shared_rustbuffer_alloc(long size, UniffiRustCallStatus uniffi_out_err);

    void ffi_molslinjen_shared_rustbuffer_free(RustBuffer.ByValue buf, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue ffi_molslinjen_shared_rustbuffer_from_bytes(ForeignBytes.ByValue bytes, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue ffi_molslinjen_shared_rustbuffer_reserve(RustBuffer.ByValue buf, long additional, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_clone_agillichandler(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_clone_amountwrapper(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_clone_apiauthenticationbridge(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_clone_departurelowpricehandler(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_clone_requestparametersbridge(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_clone_rustloggertrait(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_clone_selectseatinghandler(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_clone_selectseatinghelper(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_constructor_agillichandler_new(UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_constructor_amountwrapper_new(RustBuffer.ByValue defaultAmount, UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_constructor_departurelowpricehandler_new(UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_constructor_selectseatinghandler_new(UniffiRustCallStatus uniffi_out_err);

    Pointer uniffi_molslinjen_shared_fn_constructor_selectseatinghelper_new(UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_free_agillichandler(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_free_amountwrapper(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_free_apiauthenticationbridge(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_free_departurelowpricehandler(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_free_requestparametersbridge(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_free_rustloggertrait(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_free_selectseatinghandler(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_free_selectseatinghelper(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_func_constants_api_set_agillic_base_url(RustBuffer.ByValue newUrl, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_func_constants_api_set_molslinjen_base_url(RustBuffer.ByValue newUrl, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_func_ffi_configuration_manager(UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_func_ffi_initialize_api_authentication_bridge(Pointer apiAuthenticationBridge, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_func_ffi_initialize_configuration(RustBuffer.ByValue config, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_func_ffi_initialize_request_parameters_bridge(Pointer requestParametersBridge, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_func_ffi_set_global_proxy_usage(byte useProxy, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_func_mock_amount(UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_func_mock_ferry_seat(UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_func_mock_ferry_seating_section(UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_func_set_rust_logger(Pointer logger, RustBuffer.ByValue maxLevel, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_init_callback_vtable_apiauthenticationbridge(UniffiVTableCallbackInterfaceApiAuthenticationBridge vtable);

    void uniffi_molslinjen_shared_fn_init_callback_vtable_requestparametersbridge(UniffiVTableCallbackInterfaceRequestParametersBridge vtable);

    void uniffi_molslinjen_shared_fn_init_callback_vtable_rustloggertrait(UniffiVTableCallbackInterfaceRustLoggerTrait vtable);

    long uniffi_molslinjen_shared_fn_method_agillichandler_feedback(Pointer ptr, RustBuffer.ByValue email, RustBuffer.ByValue clientAppId, RustBuffer.ByValue reportId, RustBuffer.ByValue feedbackStatus);

    long uniffi_molslinjen_shared_fn_method_agillichandler_give_consent(Pointer ptr, RustBuffer.ByValue email, RustBuffer.ByValue clientAppId, long validUntil);

    long uniffi_molslinjen_shared_fn_method_agillichandler_register(Pointer ptr, RustBuffer.ByValue email, RustBuffer.ByValue appInstallationId, RustBuffer.ByValue clientAppId, RustBuffer.ByValue pushNotificationToken, RustBuffer.ByValue consent);

    long uniffi_molslinjen_shared_fn_method_agillichandler_unregister(Pointer ptr, RustBuffer.ByValue email, RustBuffer.ByValue appInstallationId, RustBuffer.ByValue clientAppId);

    long uniffi_molslinjen_shared_fn_method_agillichandler_withdraw_consent(Pointer ptr, RustBuffer.ByValue email, RustBuffer.ByValue clientAppId);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_add_charge(Pointer ptr, long count, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_adding(Pointer ptr, RustBuffer.ByValue other, UniffiRustCallStatus uniffi_out_err);

    long uniffi_molslinjen_shared_fn_method_amountwrapper_charge_count(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_currency(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_ensure_above(Pointer ptr, RustBuffer.ByValue other, UniffiRustCallStatus uniffi_out_err);

    long uniffi_molslinjen_shared_fn_method_amountwrapper_monetary_amount(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_multiplied_by(Pointer ptr, long multiplier, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_negation(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_amountwrapper_remove_charges(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_apiauthenticationbridge_current_agillic_authentication(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    long uniffi_molslinjen_shared_fn_method_departurelowpricehandler_get_lowest_prices(Pointer ptr, long pricesFromDate, long pricesToDate, RustBuffer.ByValue currencyType, RustBuffer.ByValue transportId, RustBuffer.ByValue departureRegionId, RustBuffer.ByValue departureRouteId, RustBuffer.ByValue siteId);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_requestparametersbridge_language(Pointer ptr, UniffiRustCallStatus uniffi_out_err);

    void uniffi_molslinjen_shared_fn_method_rustloggertrait_log(Pointer ptr, RustBuffer.ByValue level, RustBuffer.ByValue message, RustBuffer.ByValue path, RustBuffer.ByValue file, RustBuffer.ByValue line, UniffiRustCallStatus uniffi_out_err);

    long uniffi_molslinjen_shared_fn_method_selectseatinghandler_get_floor_plan(Pointer ptr, RustBuffer.ByValue departureId, RustBuffer.ByValue ferryName, RustBuffer.ByValue currency, RustBuffer.ByValue reservedSeats);

    long uniffi_molslinjen_shared_fn_method_selectseatinghandler_reserve_seats(Pointer ptr, RustBuffer.ByValue departureId, RustBuffer.ByValue seatIds);

    long uniffi_molslinjen_shared_fn_method_selectseatinghandler_un_reserve_seats(Pointer ptr, RustBuffer.ByValue seatReservationId);

    long uniffi_molslinjen_shared_fn_method_selectseatinghandler_update_reserved_seats(Pointer ptr, RustBuffer.ByValue seatReservationId, RustBuffer.ByValue seatIds);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat(Pointer ptr, RustBuffer.ByValue floorPlan, RustBuffer.ByValue seatId, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_seat_group(Pointer ptr, RustBuffer.ByValue floorPlan, RustBuffer.ByValue seatId, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_find_section(Pointer ptr, RustBuffer.ByValue floorPlan, RustBuffer.ByValue seatId, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_details(Pointer ptr, RustBuffer.ByValue section, double targetSeatSize, UniffiRustCallStatus uniffi_out_err);

    RustBuffer.ByValue uniffi_molslinjen_shared_fn_method_selectseatinghelper_to_overview(Pointer ptr, RustBuffer.ByValue sections, double targetWidth, double targetHeight, UniffiRustCallStatus uniffi_out_err);
}
