import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: HomeUI(),
  ));
}

class HomeUI extends StatelessWidget {
  const HomeUI({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.blueAccent,
      appBar: AppBar(
        title: Text("Magic 8 Ball"),
        backgroundColor: Colors.blue[900],
      ),
      body: BallUI(),
    );
  }
}

class BallUI extends StatefulWidget {
  const BallUI({Key? key}) : super(key: key);

  @override
  _BallUIState createState() => _BallUIState();
}

class _BallUIState extends State<BallUI> {
  int ballNumber = 1;

  @override
  Widget build(BuildContext context) {
    return Center(
      child: TextButton(
          onPressed: () {
            setState(() {
              ballNumber = Random().nextInt(5) + 1;
            });
          }, child: Image.asset('images/ball$ballNumber.png')),
    );
  }
}
