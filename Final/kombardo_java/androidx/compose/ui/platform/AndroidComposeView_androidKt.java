package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.text.input.PlatformTextInputService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001e\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a2\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0017\u001a\u00020\u0016*\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0019*\u00020\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\".\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\"\u0014\u0010%\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Landroidx/compose/ui/graphics/Matrix;", "other", BuildConfig.FLAVOR, "preTransform-JiSxe2E", "([F[F)V", "preTransform", BuildConfig.FLAVOR, "x", "y", "tmpMatrix", "preTranslate-cG2Xzmc", "([FFF[F)V", "preTranslate", "m1", BuildConfig.FLAVOR, "row", "m2", "column", "dot-p89u6pk", "([FI[FI)F", "dot", "Landroid/view/View;", BuildConfig.FLAVOR, "containsDescendant", "(Landroid/view/View;Landroid/view/View;)Z", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "getContentCaptureSessionCompat", "(Landroid/view/View;)Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "platformTextInputServiceInterceptor", "Lkotlin/jvm/functions/Function1;", "getPlatformTextInputServiceInterceptor", "()Lkotlin/jvm/functions/Function1;", "setPlatformTextInputServiceInterceptor", "(Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "ONE_FRAME_120_HERTZ_IN_MILLISECONDS", "J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidComposeView_androidKt {
    private static final long ONE_FRAME_120_HERTZ_IN_MILLISECONDS = 8;
    private static Function1<? super PlatformTextInputService, ? extends PlatformTextInputService> platformTextInputServiceInterceptor = new Function1<PlatformTextInputService, PlatformTextInputService>() { // from class: androidx.compose.ui.platform.AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1
        @Override // kotlin.jvm.functions.Function1
        public final PlatformTextInputService invoke(PlatformTextInputService platformTextInputService) {
            return platformTextInputService;
        }
    };

    public static final /* synthetic */ boolean access$containsDescendant(View view, View view2) {
        return containsDescendant(view, view2);
    }

    /* renamed from: access$preTranslate-cG2Xzmc */
    public static final /* synthetic */ void m2114access$preTranslatecG2Xzmc(float[] fArr, float f5, float f6, float[] fArr2) {
        m2117preTranslatecG2Xzmc(fArr, f5, f6, fArr2);
    }

    public static final boolean containsDescendant(View view, View view2) {
        if (Intrinsics.areEqual(view2, view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: dot-p89u6pk */
    private static final float m2115dotp89u6pk(float[] fArr, int i5, float[] fArr2, int i6) {
        int i7 = i5 * 4;
        return (fArr[i7] * fArr2[i6]) + (fArr[i7 + 1] * fArr2[4 + i6]) + (fArr[i7 + 2] * fArr2[8 + i6]) + (fArr[i7 + 3] * fArr2[12 + i6]);
    }

    public static final ContentCaptureSessionCompat getContentCaptureSessionCompat(View view) {
        ViewCompatShims.setImportantForContentCapture(view, 1);
        return ViewCompatShims.getContentCaptureSession(view);
    }

    public static final Function1<PlatformTextInputService, PlatformTextInputService> getPlatformTextInputServiceInterceptor() {
        return platformTextInputServiceInterceptor;
    }

    /* renamed from: preTransform-JiSxe2E */
    public static final void m2116preTransformJiSxe2E(float[] fArr, float[] fArr2) {
        float m2115dotp89u6pk = m2115dotp89u6pk(fArr2, 0, fArr, 0);
        float m2115dotp89u6pk2 = m2115dotp89u6pk(fArr2, 0, fArr, 1);
        float m2115dotp89u6pk3 = m2115dotp89u6pk(fArr2, 0, fArr, 2);
        float m2115dotp89u6pk4 = m2115dotp89u6pk(fArr2, 0, fArr, 3);
        float m2115dotp89u6pk5 = m2115dotp89u6pk(fArr2, 1, fArr, 0);
        float m2115dotp89u6pk6 = m2115dotp89u6pk(fArr2, 1, fArr, 1);
        float m2115dotp89u6pk7 = m2115dotp89u6pk(fArr2, 1, fArr, 2);
        float m2115dotp89u6pk8 = m2115dotp89u6pk(fArr2, 1, fArr, 3);
        float m2115dotp89u6pk9 = m2115dotp89u6pk(fArr2, 2, fArr, 0);
        float m2115dotp89u6pk10 = m2115dotp89u6pk(fArr2, 2, fArr, 1);
        float m2115dotp89u6pk11 = m2115dotp89u6pk(fArr2, 2, fArr, 2);
        float m2115dotp89u6pk12 = m2115dotp89u6pk(fArr2, 2, fArr, 3);
        float m2115dotp89u6pk13 = m2115dotp89u6pk(fArr2, 3, fArr, 0);
        float m2115dotp89u6pk14 = m2115dotp89u6pk(fArr2, 3, fArr, 1);
        float m2115dotp89u6pk15 = m2115dotp89u6pk(fArr2, 3, fArr, 2);
        float m2115dotp89u6pk16 = m2115dotp89u6pk(fArr2, 3, fArr, 3);
        fArr[0] = m2115dotp89u6pk;
        fArr[1] = m2115dotp89u6pk2;
        fArr[2] = m2115dotp89u6pk3;
        fArr[3] = m2115dotp89u6pk4;
        fArr[4] = m2115dotp89u6pk5;
        fArr[5] = m2115dotp89u6pk6;
        fArr[6] = m2115dotp89u6pk7;
        fArr[7] = m2115dotp89u6pk8;
        fArr[8] = m2115dotp89u6pk9;
        fArr[9] = m2115dotp89u6pk10;
        fArr[10] = m2115dotp89u6pk11;
        fArr[11] = m2115dotp89u6pk12;
        fArr[12] = m2115dotp89u6pk13;
        fArr[13] = m2115dotp89u6pk14;
        fArr[14] = m2115dotp89u6pk15;
        fArr[15] = m2115dotp89u6pk16;
    }

    /* renamed from: preTranslate-cG2Xzmc */
    public static final void m2117preTranslatecG2Xzmc(float[] fArr, float f5, float f6, float[] fArr2) {
        Matrix.m1552resetimpl(fArr2);
        Matrix.m1561translateimpl$default(fArr2, f5, f6, 0.0f, 4, null);
        m2116preTransformJiSxe2E(fArr, fArr2);
    }
}
