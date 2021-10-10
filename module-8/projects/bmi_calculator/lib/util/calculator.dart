import 'dart:math';

class Calculator {

  final int height;
  final int weight;
  double _bmi = 0;

  Calculator({required this.height, required this.weight});

  void calculate() {
    _bmi = weight / pow(height/100, 2);
  }

  double getBMI() {
    if (_bmi == 0) {
      calculate();
    }

    return _bmi;
  }

  String getResultText() {
    if (_bmi == 0) {
      calculate();
    }

    if (_bmi >= 25) {
      return 'Overweight';
    } else if (_bmi > 18.5) {
      return 'Normal';
    } else {
      return 'Underweight';
    }
  }

  String getResultInterpretation() {
    if (_bmi == 0) {
      calculate();
    }

    if (_bmi >= 25) {
      return 'You have a higher than normal body weight. Try to exercise more.';
    } else if (_bmi > 18.5) {
      return 'You have a normal body weight. Good job!';
    } else {
      return 'You have a lower than normal body weight. You can eat a bit more.';
    }
  }
}