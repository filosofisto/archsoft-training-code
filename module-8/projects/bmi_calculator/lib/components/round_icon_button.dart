import 'package:flutter/material.dart';

class RoundIconButton extends StatelessWidget {

  final IconData iconData;
  final VoidCallback? onPressed;

  const RoundIconButton({required this.iconData, required this.onPressed});


  @override
  Widget build(BuildContext context) {
    return RawMaterialButton(
      child: Icon(iconData, color: Colors.white,),
      onPressed: onPressed,
      shape: CircleBorder(),
      fillColor: Color(0xFF4C4F5E),
      constraints: BoxConstraints.tightFor(
        width: 56.0,
        height: 56.0
      ),
      elevation: 0.0,
    );
  }
}
