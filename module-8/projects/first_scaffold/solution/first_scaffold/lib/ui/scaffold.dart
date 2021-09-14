import 'package:flutter/material.dart';

class ScaffoldUI extends StatelessWidget {
  const ScaffoldUI({Key? key}) : super(key: key);

  static final _colorAppBar = Colors.lightBlue;

  onAlarm() {
    print('Alarm clicked');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "Scaffold",
          style: TextStyle(color: _colorAppBar),
        ),
        backgroundColor: Colors.amberAccent,
        centerTitle: true,
        actions: [
          IconButton(
              color: _colorAppBar,
              onPressed: () => print("Email pressed"),
              icon: Icon(Icons.email)),
          IconButton(
              color: _colorAppBar, onPressed: onAlarm, icon: Icon(Icons.alarm))
        ],
      ),
      backgroundColor: Colors.redAccent.shade100,
      body: Container(
        child: Center(
            child: InkWell(
          child: Text(
            "Click here",
            style: TextStyle(fontSize: 50),
          ),
          onTap: () => print("Thank you for click"),
        )),
      ),
    );
  }
}
