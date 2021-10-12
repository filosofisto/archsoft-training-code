import 'package:byte_bank/screens/dashboard.dart';
import 'package:flutter/material.dart';

class ByteBankScreen extends StatelessWidget {
  const ByteBankScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primaryColor: Colors.green[900],
        accentColor: Colors.blueAccent[700],
        buttonTheme: ButtonThemeData(
          buttonColor: Colors.blueAccent[700],
          textTheme: ButtonTextTheme.primary
        )
      ),
      home: Dashboard(),
    );
  }
}


