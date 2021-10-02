import 'package:flutter/material.dart';
import 'package:tip_calculator/components/small_button.dart';
import 'package:tip_calculator/util/hexcolor.dart';

class Calculator extends StatefulWidget {
  const Calculator({Key? key}) : super(key: key);

  @override
  _CalculatorState createState() => _CalculatorState();
}

class _CalculatorState extends State<Calculator> {

  double _billAmount = 0;
  int _totalPeople = 1;
  double _totalPerPerson = 0;
  double _tipAmount = 0.0;
  int _tipPercent = 0;

  static HexColor _purple = HexColor("#6908D6");
  static TextStyle _smallTextStyle = TextStyle(color: Colors.grey.shade700);
  static TextStyle _mediumTextStyle =
      TextStyle(color: _purple, fontWeight: FontWeight.bold, fontSize: 24.0);

  void _calc() {
    _tipAmount = _billAmount * _tipPercent / 100;
    _totalPerPerson = (_billAmount + _tipAmount) / _totalPeople;
  }

  void _setBillAmount(String value) {
    try {
      _billAmount = double.parse(value);
    } catch (e) {
      _billAmount = 0.0;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        margin: EdgeInsets.only(top: MediaQuery.of(context).size.height * 0.1),
        alignment: Alignment.center,
        child: ListView(
          scrollDirection: Axis.vertical,
          padding: EdgeInsets.all(20.0),
          children: <Widget>[
            Container(
              height: 150,
              decoration: BoxDecoration(
                  color: _purple.withOpacity(0.1),
                  borderRadius: BorderRadius.circular(12.0)),
              child: Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Text(
                      'Total per person',
                      style: TextStyle(
                          fontSize: 24.0,
                          color: _purple,
                          fontWeight: FontWeight.normal),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(16.0),
                      child: Text(
                        '\$ ${_totalPerPerson.toStringAsPrecision(4)}',
                        style: TextStyle(
                            fontSize: 40.0,
                            color: _purple,
                            fontWeight: FontWeight.bold),
                      ),
                    )
                  ],
                ),
              ),
            ),
            Container(
              height: 280,
              margin: EdgeInsets.only(top: 24.0),
              padding: EdgeInsets.all(12.0),
              decoration: BoxDecoration(
                  border: Border.all(
                      color: Colors.blueGrey.shade100,
                      style: BorderStyle.solid),
                  borderRadius: BorderRadius.circular(12.0)),
              child: Column(
                children: <Widget>[
                  TextField(
                    keyboardType:
                        TextInputType.numberWithOptions(decimal: true),
                    style: TextStyle(color: _purple, fontSize: 16.0),
                    decoration: InputDecoration(
                        prefixIcon: Icon(Icons.monetization_on),
                        prefixText: "Bill Amount: "),
                    onChanged: (String value) {
                      // TODO: refactory
                      setState(() {
                        _setBillAmount(value);
                        _calc();
                      });
                    },
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: <Widget>[
                      Text(
                        'Split',
                        style: _smallTextStyle,
                      ),
                      Row(
                        children: <Widget>[
                          SmallButton(
                              '-',
                              width: 40.0,
                              height: 40.0,
                              color: _purple.withOpacity(0.1),
                              textStyle: _mediumTextStyle,
                              onTap: () {
                                setState(() {
                                  if (_totalPeople > 1) {
                                    _totalPeople--;
                                    _calc();
                                  }
                                });
                              }),
                          Text(
                            '$_totalPeople',
                            style: _mediumTextStyle,
                          ),
                          SmallButton(
                              '+',
                              width: 40.0,
                              height: 40.0,
                              color: _purple.withOpacity(0.1),
                              textStyle: _mediumTextStyle,
                              onTap: () {
                                setState(() {
                                  _totalPeople++;
                                  _calc();
                                });
                              }),
                         ],
                      )
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: <Widget>[
                      Text(
                        'Tip',
                        style: _smallTextStyle,
                      ),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Text(
                          '\$ $_tipAmount',
                          style: _mediumTextStyle,
                        ),
                      )
                    ],
                  ),
                  Column(
                    children: <Widget>[
                      Text(
                        '$_tipPercent %',
                        style: _mediumTextStyle,
                      ),
                      Slider(
                          min: 0,
                          max: 100,
                          activeColor: _purple,
                          inactiveColor: Colors.grey,
                          divisions: 10,
                          value: _tipPercent.toDouble(),
                          onChanged: (value) {
                            setState(() {
                              _tipPercent = value.round();
                              _calc();
                            });
                          })
                    ],
                  )
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
