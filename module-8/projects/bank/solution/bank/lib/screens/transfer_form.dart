import 'package:bank/components/input.dart';
import 'package:bank/model/transfer.dart';
import 'package:flutter/material.dart';

class TransferFormScreen extends StatefulWidget {
  const TransferFormScreen({Key? key}) : super(key: key);

  @override
  _TransferFormScreenState createState() => _TransferFormScreenState();
}

class _TransferFormScreenState extends State<TransferFormScreen> {
  final TextEditingController _accountController = TextEditingController();
  final TextEditingController _valueController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('New Transfer'),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Input(_accountController, 'Account'),
            Input(_valueController, 'Value', TextInputType.number),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: ElevatedButton(
                  onPressed: () {
                    final transfer = Transfer(
                      account: _accountController.text,
                      value: double.tryParse(_valueController.text) ?? 0
                    );

                    Navigator.pop(context, transfer);
                  },
                  child: Text(
                    'Save',
                    style: TextStyle(fontSize: 24.0),
                  )),
            )
          ],
        ),
      ),
    );
  }
}
