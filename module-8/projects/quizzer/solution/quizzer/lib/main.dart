import 'package:flutter/material.dart';
import 'package:quizzer/statement.dart';

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

  String _nextStatementOrResult() {
    if (_statementIndex < _statements.length) {
      return _statements[_statementIndex].text;
    }

    double percent = corrects / _statements.length * 100;

    if (percent > 50.0) {
      return 'Contratulation, you got ${percent.toInt()}%';
    }

    return 'Sorry, try again, you got only ${percent.toInt()}%';
  }

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

    _statementIndex++;

    // if (_statementIndex == _statements.length - 1) {
    //   _score.add(Text('${corrects / _statements.length * 100}%'));
    // } else {
    //   _statementIndex++;
    // }
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
                _nextStatementOrResult(),
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
        Row(
          children: _score,
        )
      ],
    );
  }
}
