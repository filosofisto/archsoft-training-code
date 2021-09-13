import 'package:flutter/material.dart';

class HomeUI extends StatelessWidget {
  const HomeUI({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Material(
      color: Colors.deepOrange,
      child: Center(
          child: Text(
        "Hello Material",
        textDirection: TextDirection.ltr,
        style: TextStyle(
            color: Colors.white,
            fontSize: 34.0,
            fontWeight: FontWeight.w700,
            fontStyle: FontStyle.italic),
      )),
    );
  }
}
