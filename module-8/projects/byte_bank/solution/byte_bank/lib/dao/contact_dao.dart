
import 'package:byte_bank/converters/converter_contact.dart';
import 'package:byte_bank/model/contact.dart';
import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';

class ContactDAO {
  
  static const String tableSql = 'CREATE TABLE contacts('
    'id INTEGER PRIMARY KEY, '
    'name TEXT, '
    'account INTEGER)';

  Future<Database> getDatabase() async {
    final String dbPath = await getDatabasesPath();
    final String path = join(dbPath, 'byte_bank.db');
    
    return openDatabase(path, onCreate: (db, version) {
      db.execute(tableSql);
    }, version: 1);
  }
  
  Future<int> save(Contact contact) async {
    final Database db = await getDatabase();

    return db.insert('contacts', ConverterContact.toMap(contact, false));
  }

  Future<List<Contact>> findAll() async {
    final Database db = await getDatabase();
    final List<Map<String, dynamic>> maps = await db.query('contacts');
    final List<Contact> contacts = [];

    for (Map<String, dynamic> map in maps) {
      contacts.add(ConverterContact.toContact(map));
    }

    return contacts;
  }
}