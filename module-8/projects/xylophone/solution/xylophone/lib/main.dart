import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';

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
            Expanded(
              child: Container(
                color: Colors.red,
                child: InkWell(
                  onTap: () => _playSound(1),
                ),
              ),
            ),
            Expanded(
              child: Container(
                color: Colors.blue,
                child: InkWell(
                  onTap: () => _playSound(2),
                ),
              ),
            ),
            Expanded(
              child: Container(
                color: Colors.yellow,
                child: InkWell(
                  onTap: () => _playSound(3),
                ),
              ),
            ),
            Expanded(
              child: Container(
                color: Colors.green,
                child: InkWell(
                  onTap: () => _playSound(4),
                ),
              ),
            ),
            Expanded(
              child: Container(
                color: Colors.orange,
                child: InkWell(
                  onTap: () => _playSound(5),
                ),
              ),
            ),
            Expanded(
              child: Container(
                color: Colors.teal,
                child: InkWell(
                  onTap: () => _playSound(6),
                ),
              ),
            ),
            Expanded(
              child: Container(
                color: Colors.grey,
                child: InkWell(
                  onTap: () => _playSound(7),
                ),
              ),
            )
          ],
        ),
      ),
    );
  }
}
