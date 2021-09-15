import 'package:flutter/material.dart';

void main() {
  runApp(HomeUI());
}

class HomeUI extends StatelessWidget {
  const HomeUI({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.teal,
        body: SafeArea(
          child: Padding(
            padding: const EdgeInsets.all(12.0),
            child: Column(
              children: <Widget>[
                CircleAvatar(
                  radius: 50.0,
                  backgroundImage: AssetImage('images/edu.png'),
                ),
                Text(
                  'Eduardo Ribeiro da Silva',
                  style: TextStyle(
                      color: Colors.white,
                      fontSize: 30.0,
                      fontFamily: 'Comfortaa'),
                ),
                Text(
                  'Fullstack Developer',
                  style: TextStyle(fontSize: 25.0, color: Colors.teal.shade200),
                ),
                buildCard(text: '+48 567 876 908', iconData: Icons.phone),
                buildCard(text: 'filosofisto@gmail.com', iconData: Icons.email)
              ],
            ),
          ),
        ),
      ),
    );
  }

  Card buildCard({iconData: IconData, text: String}) {
    return Card(
      margin: EdgeInsets.symmetric(vertical: 10.0, horizontal: 30.0),
      color: Colors.white,
      child: Padding(
        padding: const EdgeInsets.all(12.0),
        child: Row(
          children: <Widget>[
            Icon(iconData, color: Colors.teal.shade500),
            SizedBox(
              width: 10.0,
            ),
            Text(
              text,
              style: TextStyle(fontSize: 20.0),
            )
          ],
        ),
      ),
    );
  }
}
