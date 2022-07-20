import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class FlutterTemi {
  static const MethodChannel _channel = MethodChannel('flutter_temi');

  static temiGoTo(String location) async {
    await _channel.invokeMethod('temi_goto', location);
  }
}