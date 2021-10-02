import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SmallButton extends StatelessWidget {
  SmallButton(this.text,
      {required this.width,
      required this.height,
      this.color,
      this.textStyle,
      this.onTap})
      : super();

  String text;
  final double width;
  final double height;
  final GestureTapCallback? onTap;
  final Color? color;
  final TextStyle? textStyle;

  Color getColor() {
    return color ?? Colors.white;
  }

  TextStyle getTextStyle() {
    return textStyle ?? TextStyle(fontSize: 16.0, color: Colors.black);
  }

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: onTap,
      child: Container(
        width: 40.0,
        height: 40.0,
        margin: EdgeInsets.all(8.0),
        decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(7.0), color: getColor()),
        child: Center(
          child: Text(
            text,
            style: getTextStyle(),
          ),
        ),
      ),
    );
  }
}
