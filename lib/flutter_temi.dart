import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class FlutterTemi {
  static const MethodChannel _channel = MethodChannel('flutter_temi');

  static temiGoTo(String location) async {
    await _channel.invokeMethod('temi_goto', location);
  }
  static temiStopMovement() async {
    await _channel.invokeMethod('temi_stop_movement');
  }
  static temiSpeak(String speakText) async {
    await _channel.invokeMethod('temi_speak', speakText);
  }
}