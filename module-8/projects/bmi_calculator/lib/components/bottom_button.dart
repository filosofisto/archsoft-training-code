import 'package:bmi_calculator/util/constants.dart';
import 'package:flutter/material.dart';

class BottomButton extends StatelessWidget {

  final String label;
  final GestureTapCallback? onTap;

  const BottomButton({required this.label, this.onTap});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap,
      child: Container(
        color: kBottomContainerColor,
        margin: EdgeInsets.only(top: 10.0),
        // padding: EdgeInsets.only(bottom: 20.0),
        height: kBottomContainerHeight,
        width: double.infinity,
        child: Center(
            child: Text(
              label,
              style: kLargeButtonTextStyle,
            )),
      ),
    );
  }
}