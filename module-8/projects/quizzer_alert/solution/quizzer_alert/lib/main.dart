import 'package:flutter/material.dart';
import 'package:quizzer_alert/statement.dart';
import 'package:rflutter_alert/rflutter_alert.dart';

void main() {
  runApp(MaterialApp(home: QuizzPage()));
}

class QuizzPage extends StatefulWidget {
  const QuizzPage({Key? key}) : super(key: key);

  @override
  _QuizzPageState createState() => _QuizzPageState();
}

class _QuizzPageState extends State<QuizzPage> {
  List<Statement> _statements = [
    Statement('Pedro Alvarez Cabral discovered Brazil', true),
    Statement('Java is an amazing computer language', true),
    Statement('C++ generate binary code that is slow', false),
    Statement('Dart is not a Object Oriented language', false),
    Statement('Java has more than 20 years of age', true)
  ];

  int _statementIndex = 0;
  List<Widget> _score = [];
  int corrects = 0;

  void _processAnswer(bool value) {
    if (_statementIndex >= _statements.length) {
      return;
    }

    if (_statements[_statementIndex].correct == value) {
      corrects++;
      _score.add(Icon(
        Icons.check,
        color: Colors.green,
      ));
    } else {
      _score.add(Icon(
        Icons.close,
        color: Colors.red,
      ));
    }

    if (_statementIndex == _statements.length - 1) {
      double percent = corrects / _statements.length * 100;
      String message;

      if (percent > 50.0) {
        message = 'Congratulation, you got ${percent.toInt()}%';
      } else {
        message = 'Sorry, try again, you got only ${percent.toInt()}%';
      }

      Alert(context: context, title: 'Finished', desc: message, buttons: [
        DialogButton(
            child: Text(
              'Ok',
              style: TextStyle(fontSize: 20, color: Colors.white),
            ),
            onPressed: () => Navigator.pop(context))
      ]).show();
    } else {
      _statementIndex++;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      crossAxisAlignment: CrossAxisAlignment.stretch,
      children: <Widget>[
        Expanded(
            flex: 5,
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Center(
                  child: Text(
                _statements[_statementIndex].text,
                textAlign: TextAlign.center,
                style: TextStyle(fontSize: 25.0, color: Colors.white),
              )),
            )),
        Expanded(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(4),
              child: Stack(
                children: <Widget>[
                  Positioned.fill(
                    child: Container(
                      decoration: const BoxDecoration(
                        gradient: LinearGradient(
                          colors: <Color>[
                            Colors.green,
                            Colors.lightGreenAccent,
                          ],
                        ),
                      ),
                    ),
                  ),
                  TextButton(
                    style: TextButton.styleFrom(
                      padding: const EdgeInsets.all(16.0),
                      primary: Colors.white,
                      textStyle: const TextStyle(fontSize: 20),
                    ),
                    onPressed: () {
                      setState(() {
                        _processAnswer(true);
                      });
                    },
                    child:
                        Align(alignment: Alignment.center, child: Text('True')),
                  ),
                ],
              ),
            ),
          ),
        ),
        Expanded(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(4),
              child: Stack(
                children: <Widget>[
                  Positioned.fill(
                    child: Container(
                      decoration: const BoxDecoration(
                        gradient: LinearGradient(
                          colors: <Color>[
                            Colors.red,
                            Colors.pinkAccent,
                          ],
                        ),
                      ),
                    ),
                  ),
                  TextButton(
                    style: TextButton.styleFrom(
                      padding: const EdgeInsets.all(16.0),
                      primary: Colors.white,
                      textStyle: const TextStyle(fontSize: 20),
                    ),
                    onPressed: () {
                      setState(() {
                        _processAnswer(false);
                      });
                    },
                    child: Align(
                        alignment: Alignment.center, child: Text('False')),
                  ),
                ],
              ),
            ),
          ),
        ),
        Padding(
          padding: const EdgeInsets.all(16.0),
          child: Row(
            children: _score,
          ),
        )
      ],
    );
  }
}
