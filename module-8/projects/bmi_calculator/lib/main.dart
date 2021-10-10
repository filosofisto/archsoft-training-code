import 'package:bmi_calculator/screens/input_screen.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(BMICalculator());
}

class BMICalculator extends StatelessWidget {
  const BMICalculator({Key? key}) : super(key: key);

  ThemeData _themeBasedOnConstructor() {
    return ThemeData(
        primaryColor: Color(0xFF0A0E21),
        scaffoldBackgroundColor: Color(0xFF0A0E21),
        accentColor: Colors.purple,
        textTheme: TextTheme(bodyText2: TextStyle(color: Colors.white)));
  }

  ThemeData _themeBasedOnCopyAnother() {
    return ThemeData.dark().copyWith(
      primaryColor: Color(0xFF0A0E21),
      scaffoldBackgroundColor: Color(0xFF0A0E21),
      accentColor: Colors.purple,
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: _themeBasedOnConstructor(),
      home: InputScreen(),
    );
  }
}
