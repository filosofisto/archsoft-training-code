import 'package:bank/components/transfer_ui.dart';
import 'package:bank/model/transfer.dart';
import 'package:bank/screens/transfer_form.dart';
import 'package:flutter/material.dart';

class TransferListScreen extends StatefulWidget {
  TransferListScreen({Key? key}) : super(key: key);

  final List<Transfer> _list = [
    Transfer(value: 1500, account: '2345-8'),
    Transfer(value: 1750, account: '2345-8'),
    Transfer(value: 1389.56, account: '2345-8'),
  ];

  @override
  _TransferListScreenState createState() => _TransferListScreenState();
}

class _TransferListScreenState extends State<TransferListScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('List Transfers'),
      ),
      body: ListView.builder(
          itemCount: widget._list.length,
          itemBuilder: (context, index) => TransferUI(widget._list[index])),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          final Future future =
              Navigator.push(context, MaterialPageRoute(builder: (context) {
            return TransferFormScreen();
          }));

          future.then((transfer) => {
                setState(() => {widget._list.add(transfer)})
              });
        },
      ),
    );
  }
}
