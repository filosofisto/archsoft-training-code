
import 'package:flutter/material.dart';

class ExpandedButton extends StatelessWidget {
  const ExpandedButton({required this.color, required this.onTap}) : super();

  final Color color;
  final GestureTapCallback onTap;

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: Container(
        color: color,
        child: InkWell(
          onTap: () => this.onTap(),
        ),
      ),
    );
  }
}
