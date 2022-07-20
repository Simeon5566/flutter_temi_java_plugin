import 'dart:convert';
import 'dart:developer';
import 'package:flutter_temi_java_plugin/flutter_temi.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'dart:async';

class MainPage extends StatefulWidget {
  const MainPage({Key? key, required this.title}) : super(key: key);

  final String title;

  @override
  State<MainPage> createState() => _MainPage();
}

class _MainPage extends State<MainPage> {
  var navigatorKey = GlobalKey<NavigatorState>();

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        key: navigatorKey,
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Center(
            child: TextButton(
                onPressed: () {
                  FlutterTemi.temiGoTo("Entry");
                },
                child: const Text("TemiGoTo"))));
  }
}
