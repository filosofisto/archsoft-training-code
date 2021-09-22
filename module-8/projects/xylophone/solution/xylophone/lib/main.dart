import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';
import 'package:xylophone/components/buttons.dart';

void main() {
  runApp(MaterialApp(
    home: XylophonePage(),
  ));
}

class XylophonePage extends StatelessWidget {
  const XylophonePage({Key? key}) : super(key: key);

  void _playSound(int value) {
    final player = AudioCache();
    player.play('note$value.wav');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.black,
      body: SafeArea(
        child: Column(
          children: <Widget>[
            ExpandedButton(color: Colors.red, onTap: () => _playSound(1)),
            ExpandedButton(color: Colors.blue, onTap: () => _playSound(2)),
            ExpandedButton(color: Colors.yellow, onTap: () => _playSound(3)),
            ExpandedButton(color: Colors.green, onTap: () => _playSound(4)),
            ExpandedButton(color: Colors.orange, onTap: () => _playSound(5)),
            ExpandedButton(color: Colors.teal, onTap: () => _playSound(6)),
            ExpandedButton(color: Colors.grey, onTap: () => _playSound(7)),
          ],
        ),
      ),
    );
  }
}
