import 'package:flutter/material.dart';

class ProgressIndicatorCircle extends StatelessWidget {
  const ProgressIndicatorCircle({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          CircularProgressIndicator(),
          Text('Loading...')
        ],
      ),
    );
  }
}