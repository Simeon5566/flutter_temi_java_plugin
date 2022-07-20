package io.flutter.plugins;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import com.robotemi.sdk.*;

public class FlutterTemiPlugin extends FlutterActivity {
    private static final String CHANNEL = "flutter_temi";
    private final Robot robot = Robot.getInstance();

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            // This method is invoked on the main thread.
                            System.out.println(CHANNEL.toString());
                            robot.goTo("Eingang");
                        }
                );
    }
}
