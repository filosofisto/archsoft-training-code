
import 'dart:convert';

import 'package:http/http.dart';
import 'package:simple_http_podo/model/post.dart';

class Network {

  final String url;

  Network(this.url);

  Future<PostList> fetchData() async {
    Response response = await get(Uri.parse(url));

    if (response.statusCode == 200) {
      return PostList.fromJson(json.decode(response.body));
    } else {
      throw Exception('Fail to get posts');
    }
  }
}