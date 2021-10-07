import 'package:flutter/material.dart';

class Input extends StatelessWidget {

  final TextEditingController controller;
  final String label;
  final TextInputType? keyboardType;

  const Input(this.controller, this.label, [this.keyboardType]);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: TextField(
        controller: controller,
        style: TextStyle(fontSize: 24.0),
        decoration: InputDecoration(labelText: label),
        keyboardType: keyboardType,
      ),
    );
  }
}
