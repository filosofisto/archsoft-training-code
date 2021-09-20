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

  @override
  Widget build(BuildContext context) {
    return Container();
  }
}
