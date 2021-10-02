import 'package:flutter/material.dart';
import 'package:simple_http/network.dart';

void main() {
  runApp(JsonParsingSimple());
}

class JsonParsingSimple extends StatefulWidget {
  const JsonParsingSimple({Key? key}) : super(key: key);

  @override
  _JsonParsingSimpleState createState() => _JsonParsingSimpleState();
}

class _JsonParsingSimpleState extends State<JsonParsingSimple> {
  late Future data;

  @override
  void initState() {
    super.initState();

    String url = 'https://jsonplaceholder.typicode.com/posts';
    Network network = Network(url);
    data = network.fetchData();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Json Parsing'),
        ),
        body: Center(
          child: Container(
              child: FutureBuilder(
            future: data,
            builder: (context, AsyncSnapshot snapshot) {
              if (snapshot.hasData) {
                return createListView(snapshot.data, context);
              }

              return indicatorProgress();
            },
          )),
        ),
      ),
    );
  }

  Widget indicatorProgress() {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        CircularProgressIndicator(),
        Text('Loading...')
      ],
    );
  }

  Widget createListView(List list, BuildContext context) {
    return Container(
      child: ListView.builder(
          itemCount: list.length,
          itemBuilder: (context, int index) {
            return Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                ListTile(
                  title: Text("${list[index]['title']}"),
                  subtitle: Text("${list[index]['body']}"),
                  leading: CircleAvatar(
                    backgroundColor: Colors.black,
                    radius: 25,
                    child: Text("${list[index]['id']}"),
                  ),
                )
              ],
            );
          }),
    );
  }
}
