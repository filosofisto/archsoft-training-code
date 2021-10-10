import 'package:bmi_calculator/components/bottom_button.dart';
import 'package:bmi_calculator/components/icon_content.dart';
import 'package:bmi_calculator/components/reusable_card.dart';
import 'package:bmi_calculator/components/round_icon_button.dart';
import 'package:bmi_calculator/screens/result_screen.dart';
import 'package:bmi_calculator/util/calculator.dart';
import 'package:bmi_calculator/util/constants.dart';
import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';

enum Gender { male, female }

class InputScreen extends StatefulWidget {
  const InputScreen({Key? key}) : super(key: key);

  @override
  _InputScreenState createState() => _InputScreenState();
}

class _InputScreenState extends State<InputScreen> {
  Gender? _selectedGender;
  int _height = 180;
  int _weight = 100;
  int _age = 20;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('BMI Calculator'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: <Widget>[
          Expanded(
              child: Row(
            children: <Widget>[
              Expanded(
                  child: ReusableCard(
                onPress: () {
                  setState(() {
                    _selectedGender = Gender.male;
                  });
                },
                color: _selectedGender == Gender.male
                    ? kActiveCardColor
                    : kInactiveCardColor,
                cardChild: IconContent(
                  iconData: FontAwesomeIcons.mars,
                  label: 'MALE',
                ),
              )),
              Expanded(
                  child: ReusableCard(
                onPress: () {
                  setState(() {
                    _selectedGender = Gender.female;
                  });
                },
                color: _selectedGender == Gender.female
                    ? kActiveCardColor
                    : kInactiveCardColor,
                cardChild: IconContent(
                  iconData: FontAwesomeIcons.venus,
                  label: 'FEMALE',
                ),
              ))
            ],
          )),
          Expanded(
              child: ReusableCard(
            color: kActiveCardColor,
            cardChild: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  'HEIGHT',
                  style: kLabelTextStyle,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.baseline,
                  textBaseline: TextBaseline.alphabetic,
                  children: <Widget>[
                    Text(
                      _height.toString(),
                      style: kNumberTextStyle,
                    ),
                    Text(
                      'cm',
                      style: kLabelTextStyle,
                    )
                  ],
                ),
                SliderTheme(
                  data: SliderTheme.of(context).copyWith(
                      activeTrackColor: kActiveSliderColor,
                      inactiveTrackColor: kInactiveSliderColor,
                      thumbColor: kThumbColor,
                      thumbShape:
                          RoundSliderThumbShape(enabledThumbRadius: 15.0),
                      overlayColor: Color(0x29EB1555),
                      overlayShape:
                          RoundSliderOverlayShape(overlayRadius: 30.0)),
                  child: Slider(
                    value: _height.toDouble(),
                    min: kMinHeight,
                    max: kMaxHeight,
                    onChanged: (double value) {
                      setState(() {
                        _height = value.toInt();
                      });
                    },
                  ),
                ),
              ],
            ),
          )),
          Expanded(
              child: Row(
            children: <Widget>[
              Expanded(
                  child: ReusableCard(
                color: kActiveCardColor,
                cardChild: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Text(
                      'WEIGHT',
                      style: kLabelTextStyle,
                    ),
                    Text(
                      _weight.toString(),
                      style: kNumberTextStyle,
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        RoundIconButton(
                          iconData: FontAwesomeIcons.minus,
                          onPressed: () {
                            setState(() {
                              _weight--;
                            });
                          },
                        ),
                        SizedBox(
                          width: 10.0,
                        ),
                        RoundIconButton(
                          iconData: FontAwesomeIcons.plus,
                          onPressed: () {
                            setState(() {
                              _weight++;
                            });
                          },
                        )
                      ],
                    )
                  ],
                ),
              )),
              Expanded(
                  child: ReusableCard(
                color: kActiveCardColor,
                cardChild: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Text(
                      'AGE',
                      style: kLabelTextStyle,
                    ),
                    Text(
                      _age.toString(),
                      style: kNumberTextStyle,
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: <Widget>[
                        RoundIconButton(
                          iconData: FontAwesomeIcons.minus,
                          onPressed: () {
                            setState(() {
                              _age--;
                            });
                          },
                        ),
                        SizedBox(
                          width: 10.0,
                        ),
                        RoundIconButton(
                          iconData: FontAwesomeIcons.plus,
                          onPressed: () {
                            setState(() {
                              _age++;
                            });
                          },
                        )
                      ],
                    )
                  ],
                ),
              ))
            ],
          )),
          BottomButton(
            label: 'CALCULATE',
            onTap: () {
              Calculator calculator =
                  Calculator(height: _height, weight: _weight);
              Navigator.push(context,
                  MaterialPageRoute(builder: (context) => ResultScreen(
                    bmi: calculator.getBMI(),
                    resultText: calculator.getResultText(),
                    resultInterpretation: calculator.getResultInterpretation(),
                  )));
            },
          )
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: Icon(Icons.add),
      ),
    );
  }
}
