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
                            if(!call.method.equals("")) {
                                // System.out.println("Call: " + call.arguments.toString() + " , Method: " + call.method);
                                // robot.goTo("Entry");
                                if (call.method.equals("temi_goto")) {
                                    robot.goTo(call.arguments().toString());
                                }
                                if (call.method.equals("temi_stop_movement")) {
                                    robot.stopMovement();
                                }
                                if(call.method.equals("temi_speak")) {
                                    TtsRequest ttsRequest = TtsRequest.create(call.arguments().toString(), true);
                                    robot.speak(ttsRequest);
                                }
                            }
                        }
                );
    }
}
