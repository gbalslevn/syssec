package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"¨\u0006'"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SensorDataManager;", "Landroid/hardware/SensorEventListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/hardware/SensorEvent;", "event", BuildConfig.FLAVOR, "onSensorChanged", "(Landroid/hardware/SensorEvent;)V", "Landroid/hardware/Sensor;", "sensor", BuildConfig.FLAVOR, "accuracy", "onAccuracyChanged", "(Landroid/hardware/Sensor;I)V", "cancel", "()V", "Landroid/hardware/SensorManager;", "sensorManager", "Landroid/hardware/SensorManager;", "Lkotlinx/coroutines/channels/Channel;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SensorDataManager$SensorData;", "data", "Lkotlinx/coroutines/channels/Channel;", "getData", "()Lkotlinx/coroutines/channels/Channel;", BuildConfig.FLAVOR, "gravity", "[F", "getGravity", "()[F", "setGravity", "([F)V", "geomagnetic", "getGeomagnetic", "setGeomagnetic", "SensorData", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SensorDataManager implements SensorEventListener {
    private final Channel<SensorData> data;
    private float[] geomagnetic;
    private float[] gravity;
    private final SensorManager sensorManager;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SensorDataManager$SensorData;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "roll", "pitch", "<init>", "(FF)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "F", "getRoll", "()F", "getPitch", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SensorData {
        private final float pitch;
        private final float roll;

        public SensorData(float f5, float f6) {
            this.roll = f5;
            this.pitch = f6;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SensorData)) {
                return false;
            }
            SensorData sensorData = (SensorData) other;
            return Float.compare(this.roll, sensorData.roll) == 0 && Float.compare(this.pitch, sensorData.pitch) == 0;
        }

        public final float getRoll() {
            return this.roll;
        }

        public int hashCode() {
            return (Float.hashCode(this.roll) * 31) + Float.hashCode(this.pitch);
        }

        public String toString() {
            return "SensorData(roll=" + this.roll + ", pitch=" + this.pitch + ")";
        }
    }

    public SensorDataManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        SensorManager sensorManager = (SensorManager) systemService;
        this.sensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(9);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(2);
        sensorManager.registerListener(this, defaultSensor, 2);
        sensorManager.registerListener(this, defaultSensor2, 2);
        this.data = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    public final void cancel() {
        this.sensorManager.unregisterListener(this);
    }

    public final Channel<SensorData> getData() {
        return this.data;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        float[] fArr;
        Sensor sensor;
        Sensor sensor2;
        if (event != null && (sensor2 = event.sensor) != null && sensor2.getType() == 9) {
            this.gravity = event.values;
        }
        if (event != null && (sensor = event.sensor) != null && sensor.getType() == 2) {
            this.geomagnetic = event.values;
        }
        float[] fArr2 = this.gravity;
        if (fArr2 == null || (fArr = this.geomagnetic) == null) {
            return;
        }
        float[] fArr3 = new float[9];
        if (SensorManager.getRotationMatrix(fArr3, new float[9], fArr2, fArr)) {
            float[] fArr4 = new float[3];
            SensorManager.getOrientation(fArr3, fArr4);
            this.data.mo3767trySendJP2dKIU(new SensorData(fArr4[2], fArr4[1]));
        }
    }
}
