import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  return runApp(
    MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.red,
        appBar: AppBar(
          title: Text('Dicee'),
          backgroundColor: Colors.red,
        ),
        body: DiceePage(),
      ),
    ),
  );
}

class DiceePage extends StatefulWidget {
  const DiceePage({Key? key}) : super(key: key);

  @override
  _DiceePageState createState() => _DiceePageState();
}

class _DiceePageState extends State<DiceePage> {
  int leftDicee = random();
  int rightDicee = random();

  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        Row(
          children: <Widget>[
            Expanded(
                child: TextButton(
                    onPressed: () => {
                          setState(() {
                            leftDicee = random();
                          })
                        },
                    child: Image.asset('images/dice$leftDicee.png'))),
            Expanded(
              child: TextButton(
                  onPressed: () => {
                        setState(() {
                          rightDicee = random();
                        })
                      },
                  child: Image.asset('images/dice$rightDicee.png')),
            )
          ],
        ),
        TextButton(
            onPressed: () => {
                  setState(() => {randomDicees()})
                },
            child: Text(
              'Random dicees',
              style: TextStyle(fontSize: 30.0),
            ))
      ],
    );
  }

  void randomDicees() {
    leftDicee = random();
    rightDicee = random();
  }

  static int random() {
    return Random().nextInt(6) + 1;
  }
}
