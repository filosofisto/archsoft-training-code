import 'package:byte_bank/model/contact.dart';

class ConverterContact {

  static Contact toContact(Map<String, dynamic> map) {
    return Contact(map['id'], map['name'], map['account']);
  }

  static Map<String, dynamic> toMap(Contact contact, bool useId) {
    final Map<String, dynamic> map = Map();

    if (useId) {
      map['id'] = contact.id;
    }

    map['name'] = contact.name;
    map['account'] = contact.account;

    return map;
  }
}
