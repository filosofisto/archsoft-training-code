class Post {

  final int id;
  final String title;
  final String body;

  Post({required this.id, required this.title, required this.body});

  factory Post.fromJson(Map<String, dynamic> json) {
    return Post(id: json['id'], title: json['title'], body: json['body']);
  }
}

class PostList {

  final List<Post> posts;

  PostList(this.posts);

  factory PostList.fromJson(List<dynamic> json) {
    return PostList(json.map((e) => Post.fromJson(e)).toList());
  }
}