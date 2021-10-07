import 'package:bank/model/transfer.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

class TransferUI extends StatelessWidget {

  final Transfer transfer;
  final numberFormat = NumberFormat.simpleCurrency(locale: 'pt_BR');

  TransferUI(this.transfer);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: Icon(Icons.monetization_on_outlined),
        title: Text(
          numberFormat.format(transfer.value),
          style: TextStyle(fontSize: 24.0),
        ),
        subtitle: Text(
          transfer.account,
          style: TextStyle(fontSize: 16.0),
        ),
      ),
    );
  }
}
